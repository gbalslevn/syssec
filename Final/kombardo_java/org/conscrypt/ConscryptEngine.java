package org.conscrypt;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECKey;
import java.security.spec.ECParameterSpec;
import java.util.Arrays;
import javax.crypto.SecretKey;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;
import org.conscrypt.ExternalSession;
import org.conscrypt.NativeCrypto;
import org.conscrypt.NativeRef;
import org.conscrypt.NativeSsl;
import org.conscrypt.SSLParametersImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ConscryptEngine extends AbstractConscryptEngine implements NativeCrypto.SSLHandshakeCallbacks, SSLParametersImpl.AliasChooser, SSLParametersImpl.PSKCallbacks {
    private static final SSLEngineResult CLOSED_NOT_HANDSHAKING;
    private static final SSLEngineResult NEED_UNWRAP_CLOSED;
    private static final SSLEngineResult NEED_UNWRAP_OK;
    private static final SSLEngineResult NEED_WRAP_CLOSED;
    private static final SSLEngineResult NEED_WRAP_OK;
    private static BufferAllocator defaultBufferAllocator;
    private ActiveSession activeSession;
    private BufferAllocator bufferAllocator;
    private OpenSSLKey channelIdPrivateKey;
    private SessionSnapshot closedSession;
    private final SSLSession externalSession;
    private boolean handshakeFinished;
    private HandshakeListener handshakeListener;
    private ByteBuffer lazyDirectBuffer;
    private int maxSealOverhead;
    private final NativeSsl.BioWrapper networkBio;
    private String peerHostname;
    private final PeerInfoProvider peerInfoProvider;
    private final ByteBuffer[] singleDstBuffer;
    private final ByteBuffer[] singleSrcBuffer;
    private final NativeSsl ssl;
    private final SSLParametersImpl sslParameters;
    private int state;

    static {
        SSLEngineResult.Status status = SSLEngineResult.Status.OK;
        SSLEngineResult.HandshakeStatus handshakeStatus = SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
        NEED_UNWRAP_OK = new SSLEngineResult(status, handshakeStatus, 0, 0);
        SSLEngineResult.Status status2 = SSLEngineResult.Status.CLOSED;
        NEED_UNWRAP_CLOSED = new SSLEngineResult(status2, handshakeStatus, 0, 0);
        SSLEngineResult.HandshakeStatus handshakeStatus2 = SSLEngineResult.HandshakeStatus.NEED_WRAP;
        NEED_WRAP_OK = new SSLEngineResult(status, handshakeStatus2, 0, 0);
        NEED_WRAP_CLOSED = new SSLEngineResult(status2, handshakeStatus2, 0, 0);
        CLOSED_NOT_HANDSHAKING = new SSLEngineResult(status2, SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0);
        defaultBufferAllocator = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConscryptEngine(SSLParametersImpl sSLParametersImpl) {
        this.bufferAllocator = defaultBufferAllocator;
        this.state = 0;
        this.externalSession = Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() { // from class: org.conscrypt.ConscryptEngine.1
            @Override // org.conscrypt.ExternalSession.Provider
            public ConscryptSession provideSession() {
                return ConscryptEngine.this.provideSession();
            }
        }));
        this.singleSrcBuffer = new ByteBuffer[1];
        this.singleDstBuffer = new ByteBuffer[1];
        this.sslParameters = sSLParametersImpl;
        this.peerInfoProvider = PeerInfoProvider.nullProvider();
        NativeSsl newSsl = newSsl(sSLParametersImpl, this, this);
        this.ssl = newSsl;
        this.networkBio = newSsl.newBio();
    }

    private void beginHandshakeInternal() {
        NativeSslSession cachedSession;
        int i5 = this.state;
        if (i5 == 0) {
            throw new IllegalStateException("Client/server mode must be set before handshake");
        }
        if (i5 != 1) {
            if (i5 == 6 || i5 == 7 || i5 == 8) {
                throw new SSLHandshakeException("Engine has already been closed");
            }
            return;
        }
        transitionTo(2);
        try {
            try {
                this.ssl.initialize(getHostname(), this.channelIdPrivateKey);
                if (getUseClientMode() && (cachedSession = clientSessionContext().getCachedSession(getHostname(), getPeerPort(), this.sslParameters)) != null) {
                    cachedSession.offerToResume(this.ssl);
                }
                this.maxSealOverhead = this.ssl.getMaxSealOverhead();
                handshake();
            } catch (IOException e5) {
                if (e5.getMessage().contains("unexpected CCS")) {
                    Platform.logEvent(String.format("ssl_unexpected_ccs: host=%s", getPeerHost()));
                }
                closeAll();
                throw SSLUtils.toSSLHandshakeException(e5);
            }
        } catch (Throwable th) {
            closeAndFreeResources();
            throw th;
        }
    }

    private static int calcDstsLength(ByteBuffer[] byteBufferArr, int i5, int i6) {
        int i7 = 0;
        for (int i8 = 0; i8 < byteBufferArr.length; i8++) {
            ByteBuffer byteBuffer = byteBufferArr[i8];
            Preconditions.checkArgument(byteBuffer != null, "dsts[%d] is null", Integer.valueOf(i8));
            if (byteBuffer.isReadOnly()) {
                throw new ReadOnlyBufferException();
            }
            if (i8 >= i5 && i8 < i5 + i6) {
                i7 += byteBuffer.remaining();
            }
        }
        return i7;
    }

    private static long calcSrcsLength(ByteBuffer[] byteBufferArr, int i5, int i6) {
        long j5 = 0;
        while (i5 < i6) {
            if (byteBufferArr[i5] == null) {
                throw new IllegalArgumentException("srcs[" + i5 + "] is null");
            }
            j5 += r2.remaining();
            i5++;
        }
        return j5;
    }

    private ClientSessionContext clientSessionContext() {
        return this.sslParameters.getClientSessionContext();
    }

    private void closeAll() {
        closeOutbound();
        closeInbound();
    }

    private void closeAndFreeResources() {
        transitionTo(8);
        NativeSsl nativeSsl = this.ssl;
        if (nativeSsl != null) {
            nativeSsl.close();
        }
        NativeSsl.BioWrapper bioWrapper = this.networkBio;
        if (bioWrapper != null) {
            bioWrapper.close();
        }
    }

    private SSLException convertException(Throwable th) {
        return ((th instanceof SSLHandshakeException) || !this.handshakeFinished) ? SSLUtils.toSSLHandshakeException(th) : SSLUtils.toSSLException(th);
    }

    private long directByteBufferAddress(ByteBuffer byteBuffer, int i5) {
        return NativeCrypto.getDirectBufferAddress(byteBuffer) + i5;
    }

    private void finishHandshake() {
        this.handshakeFinished = true;
        HandshakeListener handshakeListener = this.handshakeListener;
        if (handshakeListener != null) {
            handshakeListener.onHandshakeFinished();
        }
    }

    private void freeIfDone() {
        if (isInboundDone() && isOutboundDone()) {
            closeAndFreeResources();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BufferAllocator getDefaultBufferAllocator() {
        return defaultBufferAllocator;
    }

    private SSLEngineResult.Status getEngineStatus() {
        int i5 = this.state;
        return (i5 == 6 || i5 == 7 || i5 == 8) ? SSLEngineResult.Status.CLOSED : SSLEngineResult.Status.OK;
    }

    private SSLEngineResult.HandshakeStatus getHandshakeStatusInternal() {
        if (this.handshakeFinished) {
            return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
        }
        switch (this.state) {
            case 0:
            case 1:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
            case 2:
                return pendingStatus(pendingOutboundEncryptedBytes());
            case 3:
                return SSLEngineResult.HandshakeStatus.NEED_WRAP;
            default:
                throw new IllegalStateException("Unexpected engine state: " + this.state);
        }
    }

    private ByteBuffer getOrCreateLazyDirectBuffer() {
        if (this.lazyDirectBuffer == null) {
            this.lazyDirectBuffer = ByteBuffer.allocateDirect(Math.max(16384, 16709));
        }
        this.lazyDirectBuffer.clear();
        return this.lazyDirectBuffer;
    }

    private SSLEngineResult.HandshakeStatus handshake() {
        try {
            try {
                int doHandshake = this.ssl.doHandshake();
                if (doHandshake == 2) {
                    return pendingStatus(pendingOutboundEncryptedBytes());
                }
                if (doHandshake == 3) {
                    return SSLEngineResult.HandshakeStatus.NEED_WRAP;
                }
                this.activeSession.onPeerCertificateAvailable(getPeerHost(), getPeerPort());
                finishHandshake();
                return SSLEngineResult.HandshakeStatus.FINISHED;
            } catch (IOException e5) {
                closeAll();
                throw e5;
            }
        } catch (Exception e6) {
            throw SSLUtils.toSSLHandshakeException(e6);
        }
    }

    private boolean isHandshakeStarted() {
        int i5 = this.state;
        return (i5 == 0 || i5 == 1) ? false : true;
    }

    private SSLEngineResult.HandshakeStatus mayFinishHandshake(SSLEngineResult.HandshakeStatus handshakeStatus) {
        return (this.handshakeFinished || handshakeStatus != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) ? handshakeStatus : handshake();
    }

    private SSLEngineResult newResult(int i5, int i6, SSLEngineResult.HandshakeStatus handshakeStatus) {
        SSLEngineResult.Status engineStatus = getEngineStatus();
        if (handshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED) {
            handshakeStatus = getHandshakeStatusInternal();
        }
        return new SSLEngineResult(engineStatus, mayFinishHandshake(handshakeStatus), i5, i6);
    }

    private static NativeSsl newSsl(SSLParametersImpl sSLParametersImpl, ConscryptEngine conscryptEngine, SSLParametersImpl.AliasChooser aliasChooser) {
        try {
            return NativeSsl.newInstance(sSLParametersImpl, conscryptEngine, aliasChooser, conscryptEngine);
        } catch (SSLException e5) {
            throw new RuntimeException(e5);
        }
    }

    private SSLException newSslExceptionWithMessage(String str) {
        return !this.handshakeFinished ? new SSLException(str) : new SSLHandshakeException(str);
    }

    private int pendingInboundCleartextBytes() {
        return this.ssl.getPendingReadableBytes();
    }

    private static SSLEngineResult.HandshakeStatus pendingStatus(int i5) {
        return i5 > 0 ? SSLEngineResult.HandshakeStatus.NEED_WRAP : SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
    }

    private ConscryptSession provideAfterHandshakeSession() {
        return this.state < 2 ? SSLNullSession.getNullSession() : provideSession();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ConscryptSession provideHandshakeSession() {
        ConscryptSession nullSession;
        synchronized (this.ssl) {
            try {
                nullSession = this.state == 2 ? this.activeSession : SSLNullSession.getNullSession();
            } catch (Throwable th) {
                throw th;
            }
        }
        return nullSession;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ConscryptSession provideSession() {
        synchronized (this.ssl) {
            try {
                int i5 = this.state;
                if (i5 == 8) {
                    ConscryptSession conscryptSession = this.closedSession;
                    if (conscryptSession == null) {
                        conscryptSession = SSLNullSession.getNullSession();
                    }
                    return conscryptSession;
                }
                if (i5 < 3) {
                    return SSLNullSession.getNullSession();
                }
                return this.activeSession;
            } finally {
            }
        }
    }

    private int readEncryptedData(ByteBuffer byteBuffer, int i5) {
        try {
            int position = byteBuffer.position();
            if (byteBuffer.remaining() < i5) {
                return 0;
            }
            int min = Math.min(i5, byteBuffer.limit() - position);
            if (!byteBuffer.isDirect()) {
                return readEncryptedDataHeap(byteBuffer, min);
            }
            int readEncryptedDataDirect = readEncryptedDataDirect(byteBuffer, position, min);
            if (readEncryptedDataDirect <= 0) {
                return readEncryptedDataDirect;
            }
            byteBuffer.position(position + readEncryptedDataDirect);
            return readEncryptedDataDirect;
        } catch (Exception e5) {
            throw convertException(e5);
        }
    }

    private int readEncryptedDataDirect(ByteBuffer byteBuffer, int i5, int i6) {
        return this.networkBio.readDirectByteBuffer(directByteBufferAddress(byteBuffer, i5), i6);
    }

    private int readEncryptedDataHeap(ByteBuffer byteBuffer, int i5) {
        ByteBuffer orCreateLazyDirectBuffer;
        AllocatedBuffer allocatedBuffer = null;
        try {
            BufferAllocator bufferAllocator = this.bufferAllocator;
            if (bufferAllocator != null) {
                allocatedBuffer = bufferAllocator.allocateDirectBuffer(i5);
                orCreateLazyDirectBuffer = allocatedBuffer.nioBuffer();
            } else {
                orCreateLazyDirectBuffer = getOrCreateLazyDirectBuffer();
            }
            int readEncryptedDataDirect = readEncryptedDataDirect(orCreateLazyDirectBuffer, 0, Math.min(i5, orCreateLazyDirectBuffer.remaining()));
            if (readEncryptedDataDirect > 0) {
                orCreateLazyDirectBuffer.position(readEncryptedDataDirect);
                orCreateLazyDirectBuffer.flip();
                byteBuffer.put(orCreateLazyDirectBuffer);
            }
            if (allocatedBuffer != null) {
                allocatedBuffer.release();
            }
            return readEncryptedDataDirect;
        } catch (Throwable th) {
            if (allocatedBuffer != null) {
                allocatedBuffer.release();
            }
            throw th;
        }
    }

    private SSLEngineResult readPendingBytesFromBIO(ByteBuffer byteBuffer, int i5, int i6, SSLEngineResult.HandshakeStatus handshakeStatus) {
        try {
            int pendingOutboundEncryptedBytes = pendingOutboundEncryptedBytes();
            if (pendingOutboundEncryptedBytes <= 0) {
                return null;
            }
            if (byteBuffer.remaining() < pendingOutboundEncryptedBytes) {
                SSLEngineResult.Status status = SSLEngineResult.Status.BUFFER_OVERFLOW;
                if (handshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED) {
                    handshakeStatus = getHandshakeStatus(pendingOutboundEncryptedBytes);
                }
                return new SSLEngineResult(status, mayFinishHandshake(handshakeStatus), i5, i6);
            }
            int readEncryptedData = readEncryptedData(byteBuffer, pendingOutboundEncryptedBytes);
            if (readEncryptedData <= 0) {
                NativeCrypto.SSL_clear_error();
            } else {
                i6 += readEncryptedData;
                pendingOutboundEncryptedBytes -= readEncryptedData;
            }
            SSLEngineResult.Status engineStatus = getEngineStatus();
            if (handshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED) {
                handshakeStatus = getHandshakeStatus(pendingOutboundEncryptedBytes);
            }
            return new SSLEngineResult(engineStatus, mayFinishHandshake(handshakeStatus), i5, i6);
        } catch (Exception e5) {
            throw convertException(e5);
        }
    }

    private int readPlaintextData(ByteBuffer byteBuffer) {
        try {
            int position = byteBuffer.position();
            int min = Math.min(16709, byteBuffer.limit() - position);
            if (!byteBuffer.isDirect()) {
                return readPlaintextDataHeap(byteBuffer, min);
            }
            int readPlaintextDataDirect = readPlaintextDataDirect(byteBuffer, position, min);
            if (readPlaintextDataDirect > 0) {
                byteBuffer.position(position + readPlaintextDataDirect);
            }
            return readPlaintextDataDirect;
        } catch (CertificateException e5) {
            throw convertException(e5);
        }
    }

    private int readPlaintextDataDirect(ByteBuffer byteBuffer, int i5, int i6) {
        return this.ssl.readDirectByteBuffer(directByteBufferAddress(byteBuffer, i5), i6);
    }

    private int readPlaintextDataHeap(ByteBuffer byteBuffer, int i5) {
        ByteBuffer orCreateLazyDirectBuffer;
        AllocatedBuffer allocatedBuffer = null;
        try {
            BufferAllocator bufferAllocator = this.bufferAllocator;
            if (bufferAllocator != null) {
                allocatedBuffer = bufferAllocator.allocateDirectBuffer(i5);
                orCreateLazyDirectBuffer = allocatedBuffer.nioBuffer();
            } else {
                orCreateLazyDirectBuffer = getOrCreateLazyDirectBuffer();
            }
            int readPlaintextDataDirect = readPlaintextDataDirect(orCreateLazyDirectBuffer, 0, Math.min(i5, orCreateLazyDirectBuffer.remaining()));
            if (readPlaintextDataDirect > 0) {
                orCreateLazyDirectBuffer.position(readPlaintextDataDirect);
                orCreateLazyDirectBuffer.flip();
                byteBuffer.put(orCreateLazyDirectBuffer);
            }
            if (allocatedBuffer != null) {
                allocatedBuffer.release();
            }
            return readPlaintextDataDirect;
        } catch (Throwable th) {
            if (allocatedBuffer != null) {
                allocatedBuffer.release();
            }
            throw th;
        }
    }

    private void resetSingleDstBuffer() {
        this.singleDstBuffer[0] = null;
    }

    private void resetSingleSrcBuffer() {
        this.singleSrcBuffer[0] = null;
    }

    private void sendSSLShutdown() {
        try {
            this.ssl.shutdown();
        } catch (IOException unused) {
        }
    }

    private AbstractSessionContext sessionContext() {
        return this.sslParameters.getSessionContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setDefaultBufferAllocator(BufferAllocator bufferAllocator) {
        defaultBufferAllocator = bufferAllocator;
    }

    private ByteBuffer[] singleDstBuffer(ByteBuffer byteBuffer) {
        ByteBuffer[] byteBufferArr = this.singleDstBuffer;
        byteBufferArr[0] = byteBuffer;
        return byteBufferArr;
    }

    private ByteBuffer[] singleSrcBuffer(ByteBuffer byteBuffer) {
        ByteBuffer[] byteBufferArr = this.singleSrcBuffer;
        byteBufferArr[0] = byteBuffer;
        return byteBufferArr;
    }

    private void transitionTo(int i5) {
        int i6;
        if (i5 == 2) {
            this.handshakeFinished = false;
            this.activeSession = new ActiveSession(this.ssl, this.sslParameters.getSessionContext());
        } else if (i5 == 8 && !this.ssl.isClosed() && (i6 = this.state) >= 2 && i6 < 8) {
            this.closedSession = new SessionSnapshot(this.activeSession);
        }
        this.state = i5;
    }

    private int writeEncryptedData(ByteBuffer byteBuffer, int i5) {
        try {
            int position = byteBuffer.position();
            int writeEncryptedDataDirect = byteBuffer.isDirect() ? writeEncryptedDataDirect(byteBuffer, position, i5) : writeEncryptedDataHeap(byteBuffer, position, i5);
            if (writeEncryptedDataDirect > 0) {
                byteBuffer.position(position + writeEncryptedDataDirect);
            }
            return writeEncryptedDataDirect;
        } catch (IOException e5) {
            closeAll();
            throw new SSLException(e5);
        }
    }

    private int writeEncryptedDataDirect(ByteBuffer byteBuffer, int i5, int i6) {
        return this.networkBio.writeDirectByteBuffer(directByteBufferAddress(byteBuffer, i5), i6);
    }

    private int writeEncryptedDataHeap(ByteBuffer byteBuffer, int i5, int i6) {
        ByteBuffer orCreateLazyDirectBuffer;
        AllocatedBuffer allocatedBuffer = null;
        try {
            BufferAllocator bufferAllocator = this.bufferAllocator;
            if (bufferAllocator != null) {
                allocatedBuffer = bufferAllocator.allocateDirectBuffer(i6);
                orCreateLazyDirectBuffer = allocatedBuffer.nioBuffer();
            } else {
                orCreateLazyDirectBuffer = getOrCreateLazyDirectBuffer();
            }
            int limit = byteBuffer.limit();
            int min = Math.min(Math.min(limit - i5, i6), orCreateLazyDirectBuffer.remaining());
            byteBuffer.limit(i5 + min);
            orCreateLazyDirectBuffer.put(byteBuffer);
            byteBuffer.limit(limit);
            byteBuffer.position(i5);
            int writeEncryptedDataDirect = writeEncryptedDataDirect(orCreateLazyDirectBuffer, 0, min);
            byteBuffer.position(i5);
            if (allocatedBuffer != null) {
                allocatedBuffer.release();
            }
            return writeEncryptedDataDirect;
        } catch (Throwable th) {
            if (allocatedBuffer != null) {
                allocatedBuffer.release();
            }
            throw th;
        }
    }

    private int writePlaintextData(ByteBuffer byteBuffer, int i5) {
        try {
            int position = byteBuffer.position();
            int writePlaintextDataDirect = byteBuffer.isDirect() ? writePlaintextDataDirect(byteBuffer, position, i5) : writePlaintextDataHeap(byteBuffer, position, i5);
            if (writePlaintextDataDirect > 0) {
                byteBuffer.position(position + writePlaintextDataDirect);
            }
            return writePlaintextDataDirect;
        } catch (Exception e5) {
            throw convertException(e5);
        }
    }

    private int writePlaintextDataDirect(ByteBuffer byteBuffer, int i5, int i6) {
        return this.ssl.writeDirectByteBuffer(directByteBufferAddress(byteBuffer, i5), i6);
    }

    private int writePlaintextDataHeap(ByteBuffer byteBuffer, int i5, int i6) {
        ByteBuffer orCreateLazyDirectBuffer;
        AllocatedBuffer allocatedBuffer = null;
        try {
            BufferAllocator bufferAllocator = this.bufferAllocator;
            if (bufferAllocator != null) {
                allocatedBuffer = bufferAllocator.allocateDirectBuffer(i6);
                orCreateLazyDirectBuffer = allocatedBuffer.nioBuffer();
            } else {
                orCreateLazyDirectBuffer = getOrCreateLazyDirectBuffer();
            }
            int limit = byteBuffer.limit();
            int min = Math.min(i6, orCreateLazyDirectBuffer.remaining());
            byteBuffer.limit(i5 + min);
            orCreateLazyDirectBuffer.put(byteBuffer);
            orCreateLazyDirectBuffer.flip();
            byteBuffer.limit(limit);
            byteBuffer.position(i5);
            int writePlaintextDataDirect = writePlaintextDataDirect(orCreateLazyDirectBuffer, 0, min);
            if (allocatedBuffer != null) {
                allocatedBuffer.release();
            }
            return writePlaintextDataDirect;
        } catch (Throwable th) {
            if (allocatedBuffer != null) {
                allocatedBuffer.release();
            }
            throw th;
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public void beginHandshake() {
        synchronized (this.ssl) {
            beginHandshakeInternal();
        }
    }

    @Override // org.conscrypt.SSLParametersImpl.AliasChooser
    public String chooseClientAlias(X509KeyManager x509KeyManager, X500Principal[] x500PrincipalArr, String[] strArr) {
        return x509KeyManager instanceof X509ExtendedKeyManager ? ((X509ExtendedKeyManager) x509KeyManager).chooseEngineClientAlias(strArr, x500PrincipalArr, this) : x509KeyManager.chooseClientAlias(strArr, x500PrincipalArr, null);
    }

    @Override // org.conscrypt.SSLParametersImpl.PSKCallbacks
    public String chooseClientPSKIdentity(PSKKeyManager pSKKeyManager, String str) {
        return pSKKeyManager.chooseClientKeyIdentity(str, this);
    }

    @Override // org.conscrypt.SSLParametersImpl.AliasChooser
    public String chooseServerAlias(X509KeyManager x509KeyManager, String str) {
        return x509KeyManager instanceof X509ExtendedKeyManager ? ((X509ExtendedKeyManager) x509KeyManager).chooseEngineServerAlias(str, null, this) : x509KeyManager.chooseServerAlias(str, null, null);
    }

    @Override // org.conscrypt.SSLParametersImpl.PSKCallbacks
    public String chooseServerPSKIdentityHint(PSKKeyManager pSKKeyManager) {
        return pSKKeyManager.chooseServerKeyIdentityHint(this);
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void clientCertificateRequested(byte[] bArr, int[] iArr, byte[][] bArr2) {
        this.ssl.chooseClientCertificate(bArr, iArr, bArr2);
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public int clientPSKKeyRequested(String str, byte[] bArr, byte[] bArr2) {
        return this.ssl.clientPSKKeyRequested(str, bArr, bArr2);
    }

    @Override // javax.net.ssl.SSLEngine
    public void closeInbound() {
        synchronized (this.ssl) {
            try {
                int i5 = this.state;
                if (i5 != 8 && i5 != 6) {
                    if (isHandshakeStarted()) {
                        if (this.state == 7) {
                            transitionTo(8);
                        } else {
                            transitionTo(6);
                        }
                        freeIfDone();
                    } else {
                        closeAndFreeResources();
                    }
                }
            } finally {
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public void closeOutbound() {
        synchronized (this.ssl) {
            try {
                int i5 = this.state;
                if (i5 != 8 && i5 != 7) {
                    if (isHandshakeStarted()) {
                        if (this.state == 6) {
                            transitionTo(8);
                        } else {
                            transitionTo(7);
                        }
                        sendSSLShutdown();
                        freeIfDone();
                    } else {
                        closeAndFreeResources();
                    }
                }
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public byte[] exportKeyingMaterial(String str, byte[] bArr, int i5) {
        synchronized (this.ssl) {
            int i6 = this.state;
            if (i6 >= 3 && i6 != 8) {
                return this.ssl.exportKeyingMaterial(str, bArr, i5);
            }
            return null;
        }
    }

    protected void finalize() {
        try {
            closeAndFreeResources();
        } finally {
            super.finalize();
        }
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public String getApplicationProtocol() {
        return provideAfterHandshakeSession().getApplicationProtocol();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public String[] getApplicationProtocols() {
        return this.sslParameters.getApplicationProtocols();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public byte[] getChannelId() {
        byte[] tlsChannelId;
        synchronized (this.ssl) {
            try {
                if (getUseClientMode()) {
                    throw new IllegalStateException("Not allowed in client mode");
                }
                if (isHandshakeStarted()) {
                    throw new IllegalStateException("Channel ID is only available after handshake completes");
                }
                tlsChannelId = this.ssl.getTlsChannelId();
            } catch (Throwable th) {
                throw th;
            }
        }
        return tlsChannelId;
    }

    @Override // javax.net.ssl.SSLEngine
    public Runnable getDelegatedTask() {
        return null;
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getEnableSessionCreation() {
        return this.sslParameters.getEnableSessionCreation();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getEnabledCipherSuites() {
        return this.sslParameters.getEnabledCipherSuites();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getEnabledProtocols() {
        return this.sslParameters.getEnabledProtocols();
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public String getHandshakeApplicationProtocol() {
        String applicationProtocol;
        synchronized (this.ssl) {
            try {
                applicationProtocol = this.state >= 2 ? getApplicationProtocol() : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return applicationProtocol;
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        SSLEngineResult.HandshakeStatus handshakeStatusInternal;
        synchronized (this.ssl) {
            handshakeStatusInternal = getHandshakeStatusInternal();
        }
        return handshakeStatusInternal;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public String getHostname() {
        String str = this.peerHostname;
        return str != null ? str : this.peerInfoProvider.getHostname();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getNeedClientAuth() {
        return this.sslParameters.getNeedClientAuth();
    }

    @Override // org.conscrypt.SSLParametersImpl.PSKCallbacks
    public SecretKey getPSKKey(PSKKeyManager pSKKeyManager, String str, String str2) {
        return pSKKeyManager.getKey(str, str2, this);
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public String getPeerHost() {
        String str = this.peerHostname;
        return str != null ? str : this.peerInfoProvider.getHostnameOrIP();
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public int getPeerPort() {
        return this.peerInfoProvider.getPort();
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLParameters getSSLParameters() {
        SSLParameters sSLParameters = super.getSSLParameters();
        Platform.getSSLParameters(sSLParameters, this.sslParameters, this);
        return sSLParameters;
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLSession getSession() {
        return this.externalSession;
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getSupportedCipherSuites() {
        return NativeCrypto.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getSupportedProtocols() {
        return NativeCrypto.getSupportedProtocols();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public byte[] getTlsUnique() {
        return this.ssl.getTlsUnique();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getUseClientMode() {
        return this.sslParameters.getUseClientMode();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getWantClientAuth() {
        return this.sslParameters.getWantClientAuth();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public SSLSession handshakeSession() {
        synchronized (this.ssl) {
            try {
                if (this.state != 2) {
                    return null;
                }
                return Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() { // from class: org.conscrypt.ConscryptEngine.2
                    @Override // org.conscrypt.ExternalSession.Provider
                    public ConscryptSession provideSession() {
                        return ConscryptEngine.this.provideHandshakeSession();
                    }
                }));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean isInboundDone() {
        boolean z5;
        synchronized (this.ssl) {
            try {
                int i5 = this.state;
                if (i5 != 8) {
                    if (i5 != 6) {
                        if (this.ssl.wasShutdownReceived()) {
                        }
                    }
                }
                z5 = pendingInboundCleartextBytes() == 0;
            } finally {
            }
        }
        return z5;
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean isOutboundDone() {
        boolean z5;
        synchronized (this.ssl) {
            try {
                int i5 = this.state;
                if (i5 != 8) {
                    if (i5 != 7) {
                        if (this.ssl.wasShutdownSent()) {
                        }
                    }
                }
                z5 = pendingOutboundEncryptedBytes() == 0;
            } finally {
            }
        }
        return z5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public int maxSealOverhead() {
        return this.maxSealOverhead;
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void onNewSessionEstablished(long j5) {
        try {
            NativeCrypto.SSL_SESSION_up_ref(j5);
            sessionContext().cacheSession(NativeSslSession.newInstance(new NativeRef.SSL_SESSION(j5), this.activeSession));
        } catch (Exception unused) {
        }
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void onSSLStateChange(int i5, int i6) {
        synchronized (this.ssl) {
            try {
                if (i5 == 16) {
                    transitionTo(2);
                } else if (i5 == 32) {
                    int i7 = this.state;
                    if (i7 != 2 && i7 != 4) {
                        throw new IllegalStateException("Completed handshake while in mode " + this.state);
                    }
                    transitionTo(3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int pendingOutboundEncryptedBytes() {
        return this.networkBio.getPendingWrittenBytes();
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public int selectApplicationProtocol(byte[] bArr) {
        ApplicationProtocolSelectorAdapter applicationProtocolSelector = this.sslParameters.getApplicationProtocolSelector();
        if (applicationProtocolSelector == null) {
            return 3;
        }
        return applicationProtocolSelector.selectApplicationProtocol(bArr);
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void serverCertificateRequested() {
        synchronized (this.ssl) {
            this.ssl.configureServerCertificate();
        }
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public int serverPSKKeyRequested(String str, String str2, byte[] bArr) {
        return this.ssl.serverPSKKeyRequested(str, str2, bArr);
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public long serverSessionRequested(byte[] bArr) {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setApplicationProtocolSelector(ApplicationProtocolSelector applicationProtocolSelector) {
        setApplicationProtocolSelector(applicationProtocolSelector == null ? null : new ApplicationProtocolSelectorAdapter(this, applicationProtocolSelector));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setApplicationProtocols(String[] strArr) {
        this.sslParameters.setApplicationProtocols(strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setBufferAllocator(BufferAllocator bufferAllocator) {
        synchronized (this.ssl) {
            try {
                if (isHandshakeStarted()) {
                    throw new IllegalStateException("Could not set buffer allocator after the initial handshake has begun.");
                }
                this.bufferAllocator = bufferAllocator;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setChannelIdEnabled(boolean z5) {
        synchronized (this.ssl) {
            try {
                if (getUseClientMode()) {
                    throw new IllegalStateException("Not allowed in client mode");
                }
                if (isHandshakeStarted()) {
                    throw new IllegalStateException("Could not enable/disable Channel ID after the initial handshake has begun.");
                }
                this.sslParameters.channelIdEnabled = z5;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setChannelIdPrivateKey(PrivateKey privateKey) {
        if (!getUseClientMode()) {
            throw new IllegalStateException("Not allowed in server mode");
        }
        synchronized (this.ssl) {
            try {
                if (isHandshakeStarted()) {
                    throw new IllegalStateException("Could not change Channel ID private key after the initial handshake has begun.");
                }
                if (privateKey == null) {
                    this.sslParameters.channelIdEnabled = false;
                    this.channelIdPrivateKey = null;
                    return;
                }
                this.sslParameters.channelIdEnabled = true;
                try {
                    ECParameterSpec params = privateKey instanceof ECKey ? ((ECKey) privateKey).getParams() : null;
                    if (params == null) {
                        params = OpenSSLECGroupContext.getCurveByName("prime256v1").getECParameterSpec();
                    }
                    this.channelIdPrivateKey = OpenSSLKey.fromECPrivateKeyForTLSStackOnly(privateKey, params);
                } catch (InvalidKeyException unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnableSessionCreation(boolean z5) {
        this.sslParameters.setEnableSessionCreation(z5);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnabledCipherSuites(String[] strArr) {
        this.sslParameters.setEnabledCipherSuites(strArr);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnabledProtocols(String[] strArr) {
        this.sslParameters.setEnabledProtocols(strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setHandshakeListener(HandshakeListener handshakeListener) {
        synchronized (this.ssl) {
            try {
                if (isHandshakeStarted()) {
                    throw new IllegalStateException("Handshake listener must be set before starting the handshake.");
                }
                this.handshakeListener = handshakeListener;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setHostname(String str) {
        this.sslParameters.setUseSni(str != null);
        this.peerHostname = str;
    }

    @Override // javax.net.ssl.SSLEngine
    public void setNeedClientAuth(boolean z5) {
        this.sslParameters.setNeedClientAuth(z5);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setSSLParameters(SSLParameters sSLParameters) {
        super.setSSLParameters(sSLParameters);
        Platform.setSSLParameters(sSLParameters, this.sslParameters, this);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setUseClientMode(boolean z5) {
        synchronized (this.ssl) {
            try {
                if (isHandshakeStarted()) {
                    throw new IllegalArgumentException("Can not change mode after handshake: state == " + this.state);
                }
                transitionTo(1);
                this.sslParameters.setUseClientMode(z5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public void setUseSessionTickets(boolean z5) {
        this.sslParameters.setUseSessionTickets(z5);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setWantClientAuth(boolean z5) {
        this.sslParameters.setWantClientAuth(z5);
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        SSLEngineResult unwrap;
        synchronized (this.ssl) {
            try {
                try {
                    unwrap = unwrap(singleSrcBuffer(byteBuffer), singleDstBuffer(byteBuffer2));
                } finally {
                    resetSingleSrcBuffer();
                    resetSingleDstBuffer();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return unwrap;
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void verifyCertificateChain(byte[][] bArr, String str) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    X509Certificate[] decodeX509CertificateChain = SSLUtils.decodeX509CertificateChain(bArr);
                    X509TrustManager x509TrustManager = this.sslParameters.getX509TrustManager();
                    if (x509TrustManager == null) {
                        throw new CertificateException("No X.509 TrustManager");
                    }
                    this.activeSession.onPeerCertificatesReceived(getPeerHost(), getPeerPort(), decodeX509CertificateChain);
                    if (getUseClientMode()) {
                        Platform.checkServerTrusted(x509TrustManager, decodeX509CertificateChain, str, this);
                        return;
                    } else {
                        Platform.checkClientTrusted(x509TrustManager, decodeX509CertificateChain, decodeX509CertificateChain[0].getPublicKey().getAlgorithm(), this);
                        return;
                    }
                }
            } catch (CertificateException e5) {
                throw e5;
            } catch (Exception e6) {
                throw new CertificateException(e6);
            }
        }
        throw new CertificateException("Peer sent no certificate");
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        SSLEngineResult wrap;
        synchronized (this.ssl) {
            try {
                try {
                    wrap = wrap(singleSrcBuffer(byteBuffer), byteBuffer2);
                } finally {
                    resetSingleSrcBuffer();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return wrap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setApplicationProtocolSelector(ApplicationProtocolSelectorAdapter applicationProtocolSelectorAdapter) {
        this.sslParameters.setApplicationProtocolSelector(applicationProtocolSelectorAdapter);
    }

    private SSLEngineResult.HandshakeStatus getHandshakeStatus(int i5) {
        return !this.handshakeFinished ? pendingStatus(i5) : SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer[] byteBufferArr, int i5, int i6, ByteBuffer byteBuffer) {
        int i7;
        int i8;
        SSLEngineResult readPendingBytesFromBIO;
        boolean z5 = true;
        Preconditions.checkArgument(byteBufferArr != null, "srcs is null");
        Preconditions.checkArgument(byteBuffer != null, "dst is null");
        int i9 = i5 + i6;
        Preconditions.checkPositionIndexes(i5, i9, byteBufferArr.length);
        if (!byteBuffer.isReadOnly()) {
            if (i5 != 0 || i6 != byteBufferArr.length) {
                byteBufferArr = (ByteBuffer[]) Arrays.copyOfRange(byteBufferArr, i5, i9);
            }
            BufferUtils.checkNotNull(byteBufferArr);
            synchronized (this.ssl) {
                try {
                    int i10 = this.state;
                    if (i10 != 0) {
                        if (i10 == 1) {
                            beginHandshakeInternal();
                        } else if (i10 == 7 || i10 == 8) {
                            SSLEngineResult readPendingBytesFromBIO2 = readPendingBytesFromBIO(byteBuffer, 0, 0, SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING);
                            if (readPendingBytesFromBIO2 != null) {
                                freeIfDone();
                                return readPendingBytesFromBIO2;
                            }
                            return new SSLEngineResult(SSLEngineResult.Status.CLOSED, getHandshakeStatusInternal(), 0, 0);
                        }
                        SSLEngineResult.HandshakeStatus handshakeStatus = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                        if (!this.handshakeFinished) {
                            handshakeStatus = handshake();
                            if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
                                return NEED_UNWRAP_OK;
                            }
                            if (this.state == 8) {
                                return NEED_UNWRAP_CLOSED;
                            }
                        }
                        int min = (int) Math.min(BufferUtils.remaining(byteBufferArr), 16384L);
                        if (byteBuffer.remaining() < SSLUtils.calculateOutNetBufSize(min)) {
                            return new SSLEngineResult(SSLEngineResult.Status.BUFFER_OVERFLOW, getHandshakeStatusInternal(), 0, 0);
                        }
                        if (min > 0) {
                            ByteBuffer bufferLargerThan = BufferUtils.getBufferLargerThan(byteBufferArr, 16384);
                            if (bufferLargerThan == null) {
                                bufferLargerThan = BufferUtils.copyNoConsume(byteBufferArr, getOrCreateLazyDirectBuffer(), 16384);
                            } else {
                                z5 = false;
                            }
                            i8 = writePlaintextData(bufferLargerThan, Math.min(16384, bufferLargerThan.remaining()));
                            if (i8 > 0) {
                                if (z5) {
                                    BufferUtils.consume(byteBufferArr, i8);
                                }
                                SSLEngineResult readPendingBytesFromBIO3 = readPendingBytesFromBIO(byteBuffer, i8, 0, handshakeStatus);
                                if (readPendingBytesFromBIO3 == null) {
                                    i7 = 0;
                                } else {
                                    if (readPendingBytesFromBIO3.getStatus() != SSLEngineResult.Status.OK) {
                                        return readPendingBytesFromBIO3;
                                    }
                                    i7 = readPendingBytesFromBIO3.bytesProduced();
                                }
                            } else {
                                int error = this.ssl.getError(i8);
                                if (error == 2) {
                                    SSLEngineResult readPendingBytesFromBIO4 = readPendingBytesFromBIO(byteBuffer, 0, 0, handshakeStatus);
                                    if (readPendingBytesFromBIO4 == null) {
                                        readPendingBytesFromBIO4 = new SSLEngineResult(getEngineStatus(), SSLEngineResult.HandshakeStatus.NEED_UNWRAP, 0, 0);
                                    }
                                    return readPendingBytesFromBIO4;
                                }
                                if (error == 3) {
                                    SSLEngineResult readPendingBytesFromBIO5 = readPendingBytesFromBIO(byteBuffer, 0, 0, handshakeStatus);
                                    if (readPendingBytesFromBIO5 == null) {
                                        readPendingBytesFromBIO5 = NEED_WRAP_CLOSED;
                                    }
                                    return readPendingBytesFromBIO5;
                                }
                                if (error == 6) {
                                    closeAll();
                                    SSLEngineResult readPendingBytesFromBIO6 = readPendingBytesFromBIO(byteBuffer, 0, 0, handshakeStatus);
                                    if (readPendingBytesFromBIO6 == null) {
                                        readPendingBytesFromBIO6 = CLOSED_NOT_HANDSHAKING;
                                    }
                                    return readPendingBytesFromBIO6;
                                }
                                closeAll();
                                throw newSslExceptionWithMessage("SSL_write: error " + error);
                            }
                        } else {
                            i7 = 0;
                            i8 = 0;
                        }
                        return (i8 != 0 || (readPendingBytesFromBIO = readPendingBytesFromBIO(byteBuffer, 0, i7, handshakeStatus)) == null) ? newResult(i8, i7, handshakeStatus) : readPendingBytesFromBIO;
                    }
                    throw new IllegalStateException("Client/server mode must be set before calling wrap");
                } finally {
                }
            }
        }
        throw new ReadOnlyBufferException();
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) {
        SSLEngineResult unwrap;
        synchronized (this.ssl) {
            try {
                try {
                    unwrap = unwrap(singleSrcBuffer(byteBuffer), byteBufferArr);
                } finally {
                    resetSingleSrcBuffer();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return unwrap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConscryptEngine(String str, int i5, SSLParametersImpl sSLParametersImpl) {
        this.bufferAllocator = defaultBufferAllocator;
        this.state = 0;
        this.externalSession = Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() { // from class: org.conscrypt.ConscryptEngine.1
            @Override // org.conscrypt.ExternalSession.Provider
            public ConscryptSession provideSession() {
                return ConscryptEngine.this.provideSession();
            }
        }));
        this.singleSrcBuffer = new ByteBuffer[1];
        this.singleDstBuffer = new ByteBuffer[1];
        this.sslParameters = sSLParametersImpl;
        this.peerInfoProvider = PeerInfoProvider.forHostAndPort(str, i5);
        NativeSsl newSsl = newSsl(sSLParametersImpl, this, this);
        this.ssl = newSsl;
        this.networkBio = newSsl.newBio();
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr, int i5, int i6) {
        SSLEngineResult unwrap;
        synchronized (this.ssl) {
            try {
                try {
                    unwrap = unwrap(singleSrcBuffer(byteBuffer), 0, 1, byteBufferArr, i5, i6);
                } finally {
                    resetSingleSrcBuffer();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return unwrap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public SSLEngineResult unwrap(ByteBuffer[] byteBufferArr, ByteBuffer[] byteBufferArr2) {
        Preconditions.checkArgument(byteBufferArr != null, "srcs is null");
        Preconditions.checkArgument(byteBufferArr2 != null, "dsts is null");
        return unwrap(byteBufferArr, 0, byteBufferArr.length, byteBufferArr2, 0, byteBufferArr2.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptEngine
    public SSLEngineResult unwrap(ByteBuffer[] byteBufferArr, int i5, int i6, ByteBuffer[] byteBufferArr2, int i7, int i8) {
        int i9;
        int i10;
        int i11;
        boolean z5 = true;
        Preconditions.checkArgument(byteBufferArr != null, "srcs is null");
        Preconditions.checkArgument(byteBufferArr2 != null, "dsts is null");
        int i12 = i6 + i5;
        Preconditions.checkPositionIndexes(i5, i12, byteBufferArr.length);
        int i13 = i7 + i8;
        Preconditions.checkPositionIndexes(i7, i13, byteBufferArr2.length);
        int calcDstsLength = calcDstsLength(byteBufferArr2, i7, i8);
        long calcSrcsLength = calcSrcsLength(byteBufferArr, i5, i12);
        synchronized (this.ssl) {
            try {
                int i14 = this.state;
                if (i14 != 0) {
                    if (i14 == 1) {
                        beginHandshakeInternal();
                    } else if (i14 == 6 || i14 == 8) {
                        freeIfDone();
                        return new SSLEngineResult(SSLEngineResult.Status.CLOSED, getHandshakeStatusInternal(), 0, 0);
                    }
                    SSLEngineResult.HandshakeStatus handshakeStatus = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                    if (!this.handshakeFinished) {
                        handshakeStatus = handshake();
                        if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_WRAP) {
                            return NEED_WRAP_OK;
                        }
                        if (this.state == 8) {
                            return NEED_WRAP_CLOSED;
                        }
                    }
                    if (pendingInboundCleartextBytes() > 0) {
                        z5 = false;
                    }
                    if (calcSrcsLength <= 0 || !z5) {
                        if (z5) {
                            return new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW, getHandshakeStatus(), 0, 0);
                        }
                        i9 = 0;
                    } else {
                        if (calcSrcsLength < 5) {
                            return new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW, getHandshakeStatus(), 0, 0);
                        }
                        i9 = SSLUtils.getEncryptedPacketLength(byteBufferArr, i5);
                        if (i9 < 0) {
                            throw new SSLException("Unable to parse TLS packet header");
                        }
                        if (calcSrcsLength < i9) {
                            return new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW, getHandshakeStatus(), 0, 0);
                        }
                    }
                    if (i9 <= 0 || i5 >= i12) {
                        i10 = 0;
                    } else {
                        i10 = 0;
                        while (true) {
                            ByteBuffer byteBuffer = byteBufferArr[i5];
                            int remaining = byteBuffer.remaining();
                            if (remaining != 0) {
                                int writeEncryptedData = writeEncryptedData(byteBuffer, Math.min(i9, remaining));
                                if (writeEncryptedData <= 0) {
                                    NativeCrypto.SSL_clear_error();
                                    break;
                                }
                                i10 += writeEncryptedData;
                                i9 -= writeEncryptedData;
                                if (i9 != 0 && writeEncryptedData == remaining) {
                                }
                            }
                            i5++;
                            if (i5 >= i12) {
                                break;
                            }
                        }
                    }
                    if (calcDstsLength > 0) {
                        i11 = 0;
                        while (i7 < i13) {
                            try {
                                ByteBuffer byteBuffer2 = byteBufferArr2[i7];
                                if (byteBuffer2.hasRemaining()) {
                                    int readPlaintextData = readPlaintextData(byteBuffer2);
                                    if (readPlaintextData <= 0) {
                                        if (readPlaintextData != -6) {
                                            if (readPlaintextData != -3 && readPlaintextData != -2) {
                                                closeAll();
                                                throw newSslExceptionWithMessage("SSL_read");
                                            }
                                            return newResult(i10, i11, handshakeStatus);
                                        }
                                        closeAll();
                                        return new SSLEngineResult(SSLEngineResult.Status.CLOSED, pendingOutboundEncryptedBytes() > 0 ? SSLEngineResult.HandshakeStatus.NEED_WRAP : SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, i10, i11);
                                    }
                                    i11 += readPlaintextData;
                                    if (byteBuffer2.hasRemaining()) {
                                        break;
                                    }
                                }
                                i7++;
                            } catch (InterruptedIOException unused) {
                                r1 = i11;
                                return newResult(i10, r1, handshakeStatus);
                            }
                        }
                    } else {
                        try {
                            this.ssl.forceRead();
                            i11 = 0;
                        } catch (InterruptedIOException unused2) {
                            return newResult(i10, r1, handshakeStatus);
                        }
                    }
                    if ((this.handshakeFinished ? pendingInboundCleartextBytes() : 0) > 0) {
                        SSLEngineResult.Status status = SSLEngineResult.Status.BUFFER_OVERFLOW;
                        if (handshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED) {
                            handshakeStatus = getHandshakeStatusInternal();
                        }
                        return new SSLEngineResult(status, mayFinishHandshake(handshakeStatus), i10, i11);
                    }
                    return newResult(i10, i11, handshakeStatus);
                }
                throw new IllegalStateException("Client/server mode must be set before calling unwrap");
            } catch (IOException e5) {
                closeAll();
                throw convertException(e5);
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConscryptEngine(SSLParametersImpl sSLParametersImpl, PeerInfoProvider peerInfoProvider, SSLParametersImpl.AliasChooser aliasChooser) {
        this.bufferAllocator = defaultBufferAllocator;
        this.state = 0;
        this.externalSession = Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() { // from class: org.conscrypt.ConscryptEngine.1
            @Override // org.conscrypt.ExternalSession.Provider
            public ConscryptSession provideSession() {
                return ConscryptEngine.this.provideSession();
            }
        }));
        this.singleSrcBuffer = new ByteBuffer[1];
        this.singleDstBuffer = new ByteBuffer[1];
        this.sslParameters = sSLParametersImpl;
        this.peerInfoProvider = (PeerInfoProvider) Preconditions.checkNotNull(peerInfoProvider, "peerInfoProvider");
        NativeSsl newSsl = newSsl(sSLParametersImpl, this, aliasChooser);
        this.ssl = newSsl;
        this.networkBio = newSsl.newBio();
    }
}
