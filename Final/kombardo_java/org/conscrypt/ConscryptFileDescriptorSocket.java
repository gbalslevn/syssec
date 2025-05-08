package org.conscrypt;

import com.sun.jna.Function;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECKey;
import java.security.spec.ECParameterSpec;
import javax.crypto.SecretKey;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;
import org.conscrypt.ExternalSession;
import org.conscrypt.NativeCrypto;
import org.conscrypt.NativeRef;
import org.conscrypt.SSLParametersImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ConscryptFileDescriptorSocket extends OpenSSLSocketImpl implements NativeCrypto.SSLHandshakeCallbacks, SSLParametersImpl.PSKCallbacks, SSLParametersImpl.AliasChooser {
    private static final boolean DBG_STATE = false;
    private final ActiveSession activeSession;
    private OpenSSLKey channelIdPrivateKey;
    private SessionSnapshot closedSession;
    private final SSLSession externalSession;
    private final Object guard;
    private int handshakeTimeoutMilliseconds;
    private SSLInputStream is;
    private SSLOutputStream os;
    private final NativeSsl ssl;
    private final SSLParametersImpl sslParameters;
    private int state;
    private int writeTimeoutMilliseconds;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConscryptFileDescriptorSocket(SSLParametersImpl sSLParametersImpl) {
        this.state = 0;
        this.guard = Platform.closeGuardGet();
        this.externalSession = Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() { // from class: org.conscrypt.ConscryptFileDescriptorSocket.1
            @Override // org.conscrypt.ExternalSession.Provider
            public ConscryptSession provideSession() {
                return ConscryptFileDescriptorSocket.this.provideSession();
            }
        }));
        this.writeTimeoutMilliseconds = 0;
        this.handshakeTimeoutMilliseconds = -1;
        this.sslParameters = sSLParametersImpl;
        NativeSsl newSsl = newSsl(sSLParametersImpl, this);
        this.ssl = newSsl;
        this.activeSession = new ActiveSession(newSsl, sSLParametersImpl.getSessionContext());
    }

    private void assertReadableOrWriteableState() {
        int i5 = this.state;
        if (i5 == 5 || i5 == 4) {
            return;
        }
        throw new AssertionError("Invalid state: " + this.state);
    }

    private ClientSessionContext clientSessionContext() {
        return this.sslParameters.getClientSessionContext();
    }

    private void closeUnderlyingSocket() {
        super.close();
    }

    private void free() {
        if (this.ssl.isClosed()) {
            return;
        }
        this.ssl.close();
        Platform.closeGuardClose(this.guard);
    }

    private static NativeSsl newSsl(SSLParametersImpl sSLParametersImpl, ConscryptFileDescriptorSocket conscryptFileDescriptorSocket) {
        return NativeSsl.newInstance(sSLParametersImpl, conscryptFileDescriptorSocket, conscryptFileDescriptorSocket, conscryptFileDescriptorSocket);
    }

    private ConscryptSession provideAfterHandshakeSession() {
        return this.state < 2 ? SSLNullSession.getNullSession() : provideSession();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ConscryptSession provideHandshakeSession() {
        ConscryptSession nullSession;
        synchronized (this.ssl) {
            try {
                int i5 = this.state;
                nullSession = (i5 < 2 || i5 >= 5) ? SSLNullSession.getNullSession() : this.activeSession;
            } catch (Throwable th) {
                throw th;
            }
        }
        return nullSession;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ConscryptSession provideSession() {
        synchronized (this.ssl) {
            int i5 = this.state;
            if (i5 == 8) {
                ConscryptSession conscryptSession = this.closedSession;
                if (conscryptSession == null) {
                    conscryptSession = SSLNullSession.getNullSession();
                }
                return conscryptSession;
            }
            boolean z5 = true;
            boolean z6 = i5 >= 5;
            if (!z6) {
                if (isConnected()) {
                    waitForHandshake();
                    z6 = z5;
                    return z6 ? SSLNullSession.getNullSession() : this.activeSession;
                }
            }
            z5 = z6;
            z6 = z5;
            if (z6) {
            }
        }
    }

    private AbstractSessionContext sessionContext() {
        return this.sslParameters.getSessionContext();
    }

    private void shutdownAndFreeSslNative() {
        try {
            Platform.blockGuardOnNetwork();
            this.ssl.shutdown(Platform.getFileDescriptor(this.socket));
        } catch (IOException unused) {
        } catch (Throwable th) {
            free();
            closeUnderlyingSocket();
            throw th;
        }
        free();
        closeUnderlyingSocket();
    }

    private void transitionTo(int i5) {
        int i6;
        if (i5 == 8 && !this.ssl.isClosed() && (i6 = this.state) >= 2 && i6 < 8) {
            this.closedSession = new SessionSnapshot(this.activeSession);
        }
        this.state = i5;
    }

    private void waitForHandshake() {
        startHandshake();
        synchronized (this.ssl) {
            while (true) {
                int i5 = this.state;
                if (i5 == 5 || i5 == 4 || i5 == 8) {
                    break;
                }
                try {
                    this.ssl.wait();
                } catch (InterruptedException e5) {
                    Thread.currentThread().interrupt();
                    throw new IOException("Interrupted waiting for handshake", e5);
                }
            }
            throw new SocketException("Socket is closed");
        }
    }

    @Override // org.conscrypt.SSLParametersImpl.AliasChooser
    public final String chooseClientAlias(X509KeyManager x509KeyManager, X500Principal[] x500PrincipalArr, String[] strArr) {
        return x509KeyManager.chooseClientAlias(strArr, x500PrincipalArr, this);
    }

    @Override // org.conscrypt.SSLParametersImpl.PSKCallbacks
    public final String chooseClientPSKIdentity(PSKKeyManager pSKKeyManager, String str) {
        return pSKKeyManager.chooseClientKeyIdentity(str, this);
    }

    @Override // org.conscrypt.SSLParametersImpl.AliasChooser
    public final String chooseServerAlias(X509KeyManager x509KeyManager, String str) {
        return x509KeyManager.chooseServerAlias(str, null, this);
    }

    @Override // org.conscrypt.SSLParametersImpl.PSKCallbacks
    public final String chooseServerPSKIdentityHint(PSKKeyManager pSKKeyManager) {
        return pSKKeyManager.chooseServerKeyIdentityHint(this);
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public final void clientCertificateRequested(byte[] bArr, int[] iArr, byte[][] bArr2) {
        this.ssl.chooseClientCertificate(bArr, iArr, bArr2);
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public final int clientPSKKeyRequested(String str, byte[] bArr, byte[] bArr2) {
        return this.ssl.clientPSKKeyRequested(str, bArr, bArr2);
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket, java.net.Socket, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        NativeSsl nativeSsl = this.ssl;
        if (nativeSsl == null) {
            return;
        }
        synchronized (nativeSsl) {
            try {
                int i5 = this.state;
                if (i5 == 8) {
                    return;
                }
                transitionTo(8);
                if (i5 == 0) {
                    free();
                    closeUnderlyingSocket();
                    this.ssl.notifyAll();
                    return;
                }
                if (i5 != 5 && i5 != 4) {
                    this.ssl.interrupt();
                    this.ssl.notifyAll();
                    return;
                }
                this.ssl.notifyAll();
                SSLInputStream sSLInputStream = this.is;
                SSLOutputStream sSLOutputStream = this.os;
                if (sSLInputStream != null || sSLOutputStream != null) {
                    this.ssl.interrupt();
                }
                if (sSLInputStream != null) {
                    sSLInputStream.awaitPendingOps();
                }
                if (sSLOutputStream != null) {
                    sSLOutputStream.awaitPendingOps();
                }
                shutdownAndFreeSslNative();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptSocket
    public byte[] exportKeyingMaterial(String str, byte[] bArr, int i5) {
        synchronized (this.ssl) {
            int i6 = this.state;
            if (i6 >= 3 && i6 != 8) {
                return this.ssl.exportKeyingMaterial(str, bArr, i5);
            }
            return null;
        }
    }

    protected final void finalize() {
        try {
            Object obj = this.guard;
            if (obj != null) {
                Platform.closeGuardWarnIfOpen(obj);
            }
            NativeSsl nativeSsl = this.ssl;
            if (nativeSsl != null) {
                synchronized (nativeSsl) {
                    transitionTo(8);
                }
            }
        } finally {
            super.finalize();
        }
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    final SSLSession getActiveSession() {
        return this.activeSession;
    }

    @Override // org.conscrypt.AbstractConscryptSocket, javax.net.ssl.SSLSocket
    public final String getApplicationProtocol() {
        return provideAfterHandshakeSession().getApplicationProtocol();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptSocket
    public final String[] getApplicationProtocols() {
        return this.sslParameters.getApplicationProtocols();
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final byte[] getChannelId() {
        if (getUseClientMode()) {
            throw new IllegalStateException("Client mode");
        }
        synchronized (this.ssl) {
            if (this.state != 5) {
                throw new IllegalStateException("Channel ID is only available after handshake completes");
            }
        }
        return this.ssl.getTlsChannelId();
    }

    @Override // javax.net.ssl.SSLSocket
    public final boolean getEnableSessionCreation() {
        return this.sslParameters.getEnableSessionCreation();
    }

    @Override // javax.net.ssl.SSLSocket
    public final String[] getEnabledCipherSuites() {
        return this.sslParameters.getEnabledCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocket
    public final String[] getEnabledProtocols() {
        return this.sslParameters.getEnabledProtocols();
    }

    @Override // org.conscrypt.AbstractConscryptSocket, javax.net.ssl.SSLSocket
    public final String getHandshakeApplicationProtocol() {
        String applicationProtocol;
        synchronized (this.ssl) {
            try {
                int i5 = this.state;
                applicationProtocol = (i5 < 2 || i5 >= 5) ? null : getApplicationProtocol();
            } catch (Throwable th) {
                throw th;
            }
        }
        return applicationProtocol;
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket, javax.net.ssl.SSLSocket
    public final SSLSession getHandshakeSession() {
        synchronized (this.ssl) {
            try {
                int i5 = this.state;
                if (i5 < 2 || i5 >= 5) {
                    return null;
                }
                return Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() { // from class: org.conscrypt.ConscryptFileDescriptorSocket.2
                    @Override // org.conscrypt.ExternalSession.Provider
                    public ConscryptSession provideSession() {
                        return ConscryptFileDescriptorSocket.this.provideHandshakeSession();
                    }
                }));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket, java.net.Socket
    public final InputStream getInputStream() {
        SSLInputStream sSLInputStream;
        checkOpen();
        synchronized (this.ssl) {
            try {
                if (this.state == 8) {
                    throw new SocketException("Socket is closed.");
                }
                if (this.is == null) {
                    this.is = new SSLInputStream();
                }
                sSLInputStream = this.is;
            } catch (Throwable th) {
                throw th;
            }
        }
        waitForHandshake();
        return sSLInputStream;
    }

    @Override // javax.net.ssl.SSLSocket
    public final boolean getNeedClientAuth() {
        return this.sslParameters.getNeedClientAuth();
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket, java.net.Socket
    public final OutputStream getOutputStream() {
        SSLOutputStream sSLOutputStream;
        checkOpen();
        synchronized (this.ssl) {
            try {
                if (this.state == 8) {
                    throw new SocketException("Socket is closed.");
                }
                if (this.os == null) {
                    this.os = new SSLOutputStream();
                }
                sSLOutputStream = this.os;
            } catch (Throwable th) {
                throw th;
            }
        }
        waitForHandshake();
        return sSLOutputStream;
    }

    @Override // org.conscrypt.SSLParametersImpl.PSKCallbacks
    public final SecretKey getPSKKey(PSKKeyManager pSKKeyManager, String str, String str2) {
        return pSKKeyManager.getKey(str, str2, this);
    }

    @Override // javax.net.ssl.SSLSocket
    public final SSLParameters getSSLParameters() {
        SSLParameters sSLParameters = super.getSSLParameters();
        Platform.getSSLParameters(sSLParameters, this.sslParameters, this);
        return sSLParameters;
    }

    @Override // javax.net.ssl.SSLSocket
    public final SSLSession getSession() {
        return this.externalSession;
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final int getSoWriteTimeout() {
        return this.writeTimeoutMilliseconds;
    }

    @Override // javax.net.ssl.SSLSocket
    public final String[] getSupportedCipherSuites() {
        return NativeCrypto.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocket
    public final String[] getSupportedProtocols() {
        return NativeCrypto.getSupportedProtocols();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptSocket
    public byte[] getTlsUnique() {
        return this.ssl.getTlsUnique();
    }

    @Override // javax.net.ssl.SSLSocket
    public final boolean getUseClientMode() {
        return this.sslParameters.getUseClientMode();
    }

    @Override // javax.net.ssl.SSLSocket
    public final boolean getWantClientAuth() {
        return this.sslParameters.getWantClientAuth();
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public final void onNewSessionEstablished(long j5) {
        try {
            NativeCrypto.SSL_SESSION_up_ref(j5);
            sessionContext().cacheSession(NativeSslSession.newInstance(new NativeRef.SSL_SESSION(j5), this.activeSession));
        } catch (Exception unused) {
        }
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public final void onSSLStateChange(int i5, int i6) {
        if (i5 != 32) {
            return;
        }
        synchronized (this.ssl) {
            try {
                if (this.state == 8) {
                    return;
                }
                transitionTo(5);
                notifyHandshakeCompletedListeners();
                synchronized (this.ssl) {
                    this.ssl.notifyAll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
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
    public final void serverCertificateRequested() {
        synchronized (this.ssl) {
            this.ssl.configureServerCertificate();
        }
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public final int serverPSKKeyRequested(String str, String str2, byte[] bArr) {
        return this.ssl.serverPSKKeyRequested(str, str2, bArr);
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public final long serverSessionRequested(byte[] bArr) {
        return 0L;
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    public final void setApplicationProtocolSelector(ApplicationProtocolSelector applicationProtocolSelector) {
        setApplicationProtocolSelector(applicationProtocolSelector == null ? null : new ApplicationProtocolSelectorAdapter(this, applicationProtocolSelector));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractConscryptSocket
    public final void setApplicationProtocols(String[] strArr) {
        this.sslParameters.setApplicationProtocols(strArr);
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final void setChannelIdEnabled(boolean z5) {
        if (getUseClientMode()) {
            throw new IllegalStateException("Client mode");
        }
        synchronized (this.ssl) {
            if (this.state != 0) {
                throw new IllegalStateException("Could not enable/disable Channel ID after the initial handshake has begun.");
            }
        }
        this.sslParameters.channelIdEnabled = z5;
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final void setChannelIdPrivateKey(PrivateKey privateKey) {
        if (!getUseClientMode()) {
            throw new IllegalStateException("Server mode");
        }
        synchronized (this.ssl) {
            if (this.state != 0) {
                throw new IllegalStateException("Could not change Channel ID private key after the initial handshake has begun.");
            }
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
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setEnableSessionCreation(boolean z5) {
        this.sslParameters.setEnableSessionCreation(z5);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setEnabledCipherSuites(String[] strArr) {
        this.sslParameters.setEnabledCipherSuites(strArr);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setEnabledProtocols(String[] strArr) {
        this.sslParameters.setEnabledProtocols(strArr);
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final void setHandshakeTimeout(int i5) {
        this.handshakeTimeoutMilliseconds = i5;
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final void setHostname(String str) {
        this.sslParameters.setUseSni(str != null);
        super.setHostname(str);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setNeedClientAuth(boolean z5) {
        this.sslParameters.setNeedClientAuth(z5);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setSSLParameters(SSLParameters sSLParameters) {
        super.setSSLParameters(sSLParameters);
        Platform.setSSLParameters(sSLParameters, this.sslParameters, this);
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final void setSoWriteTimeout(int i5) {
        this.writeTimeoutMilliseconds = i5;
        Platform.setSocketWriteTimeout(this, i5);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setUseClientMode(boolean z5) {
        synchronized (this.ssl) {
            if (this.state != 0) {
                throw new IllegalArgumentException("Could not change the mode after the initial handshake has begun.");
            }
        }
        this.sslParameters.setUseClientMode(z5);
    }

    @Override // org.conscrypt.OpenSSLSocketImpl, org.conscrypt.AbstractConscryptSocket
    public final void setUseSessionTickets(boolean z5) {
        this.sslParameters.setUseSessionTickets(z5);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setWantClientAuth(boolean z5) {
        this.sslParameters.setWantClientAuth(z5);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void startHandshake() {
        NativeSslSession cachedSession;
        checkOpen();
        synchronized (this.ssl) {
            if (this.state == 0) {
                transitionTo(2);
                boolean z5 = true;
                try {
                    try {
                        Platform.closeGuardOpen(this.guard, "close");
                        this.ssl.initialize(getHostname(), this.channelIdPrivateKey);
                        if (getUseClientMode() && (cachedSession = clientSessionContext().getCachedSession(getHostnameOrIP(), getPort(), this.sslParameters)) != null) {
                            cachedSession.offerToResume(this.ssl);
                        }
                        int soTimeout = getSoTimeout();
                        int soWriteTimeout = getSoWriteTimeout();
                        int i5 = this.handshakeTimeoutMilliseconds;
                        if (i5 >= 0) {
                            setSoTimeout(i5);
                            setSoWriteTimeout(this.handshakeTimeoutMilliseconds);
                        }
                        synchronized (this.ssl) {
                            if (this.state == 8) {
                                synchronized (this.ssl) {
                                    transitionTo(8);
                                    this.ssl.notifyAll();
                                }
                                try {
                                    shutdownAndFreeSslNative();
                                    return;
                                } catch (IOException unused) {
                                    return;
                                }
                            }
                            try {
                                this.ssl.doHandshake(Platform.getFileDescriptor(this.socket), getSoTimeout());
                                this.activeSession.onPeerCertificateAvailable(getHostnameOrIP(), getPort());
                                synchronized (this.ssl) {
                                    if (this.state == 8) {
                                        synchronized (this.ssl) {
                                            transitionTo(8);
                                            this.ssl.notifyAll();
                                        }
                                        try {
                                            shutdownAndFreeSslNative();
                                            return;
                                        } catch (IOException unused2) {
                                            return;
                                        }
                                    }
                                    if (this.handshakeTimeoutMilliseconds >= 0) {
                                        setSoTimeout(soTimeout);
                                        setSoWriteTimeout(soWriteTimeout);
                                    }
                                    synchronized (this.ssl) {
                                        try {
                                            int i6 = this.state;
                                            if (i6 != 8) {
                                                z5 = false;
                                            }
                                            if (i6 == 2) {
                                                transitionTo(4);
                                            } else {
                                                transitionTo(5);
                                            }
                                            if (!z5) {
                                                this.ssl.notifyAll();
                                            }
                                        } finally {
                                        }
                                    }
                                    if (z5) {
                                        synchronized (this.ssl) {
                                            transitionTo(8);
                                            this.ssl.notifyAll();
                                        }
                                        try {
                                            shutdownAndFreeSslNative();
                                        } catch (IOException unused3) {
                                        }
                                    }
                                }
                            } catch (CertificateException e5) {
                                SSLHandshakeException sSLHandshakeException = new SSLHandshakeException(e5.getMessage());
                                sSLHandshakeException.initCause(e5);
                                throw sSLHandshakeException;
                            } catch (SSLException e6) {
                                synchronized (this.ssl) {
                                    if (this.state != 8) {
                                        if (e6.getMessage().contains("unexpected CCS")) {
                                            Platform.logEvent(String.format("ssl_unexpected_ccs: host=%s", getHostnameOrIP()));
                                        }
                                        throw e6;
                                    }
                                    synchronized (this.ssl) {
                                        transitionTo(8);
                                        this.ssl.notifyAll();
                                        try {
                                            shutdownAndFreeSslNative();
                                        } catch (IOException unused4) {
                                        }
                                    }
                                }
                            }
                        }
                    } catch (SSLProtocolException e7) {
                        throw ((SSLHandshakeException) new SSLHandshakeException("Handshake failed").initCause(e7));
                    }
                } catch (Throwable th) {
                    if (1 != 0) {
                        synchronized (this.ssl) {
                            transitionTo(8);
                            this.ssl.notifyAll();
                            try {
                                shutdownAndFreeSslNative();
                            } catch (IOException unused5) {
                            }
                        }
                    }
                    throw th;
                }
            }
        }
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public final void verifyCertificateChain(byte[][] bArr, String str) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    X509Certificate[] decodeX509CertificateChain = SSLUtils.decodeX509CertificateChain(bArr);
                    X509TrustManager x509TrustManager = this.sslParameters.getX509TrustManager();
                    if (x509TrustManager == null) {
                        throw new CertificateException("No X.509 TrustManager");
                    }
                    this.activeSession.onPeerCertificatesReceived(getHostnameOrIP(), getPort(), decodeX509CertificateChain);
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

    /* loaded from: classes3.dex */
    private class SSLOutputStream extends OutputStream {
        private final Object writeLock = new Object();

        SSLOutputStream() {
        }

        void awaitPendingOps() {
            synchronized (this.writeLock) {
            }
        }

        @Override // java.io.OutputStream
        public void write(int i5) {
            write(new byte[]{(byte) (i5 & Function.USE_VARARGS)});
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i5, int i6) {
            Platform.blockGuardOnNetwork();
            ConscryptFileDescriptorSocket.this.checkOpen();
            ArrayUtils.checkOffsetAndCount(bArr.length, i5, i6);
            if (i6 == 0) {
                return;
            }
            synchronized (this.writeLock) {
                synchronized (ConscryptFileDescriptorSocket.this.ssl) {
                    if (ConscryptFileDescriptorSocket.this.state == 8) {
                        throw new SocketException("socket is closed");
                    }
                }
                ConscryptFileDescriptorSocket.this.ssl.write(Platform.getFileDescriptor(ConscryptFileDescriptorSocket.this.socket), bArr, i5, i6, ConscryptFileDescriptorSocket.this.writeTimeoutMilliseconds);
                synchronized (ConscryptFileDescriptorSocket.this.ssl) {
                    if (ConscryptFileDescriptorSocket.this.state == 8) {
                        throw new SocketException("socket is closed");
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private class SSLInputStream extends InputStream {
        private final Object readLock = new Object();

        SSLInputStream() {
        }

        @Override // java.io.InputStream
        public int available() {
            return ConscryptFileDescriptorSocket.this.ssl.getPendingReadableBytes();
        }

        void awaitPendingOps() {
            synchronized (this.readLock) {
            }
        }

        @Override // java.io.InputStream
        public int read() {
            byte[] bArr = new byte[1];
            if (read(bArr, 0, 1) != -1) {
                return bArr[0] & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i5, int i6) {
            int read;
            Platform.blockGuardOnNetwork();
            ConscryptFileDescriptorSocket.this.checkOpen();
            ArrayUtils.checkOffsetAndCount(bArr.length, i5, i6);
            if (i6 == 0) {
                return 0;
            }
            synchronized (this.readLock) {
                try {
                    synchronized (ConscryptFileDescriptorSocket.this.ssl) {
                        if (ConscryptFileDescriptorSocket.this.state == 8) {
                            throw new SocketException("socket is closed");
                        }
                    }
                    read = ConscryptFileDescriptorSocket.this.ssl.read(Platform.getFileDescriptor(ConscryptFileDescriptorSocket.this.socket), bArr, i5, i6, ConscryptFileDescriptorSocket.this.getSoTimeout());
                    if (read == -1) {
                        synchronized (ConscryptFileDescriptorSocket.this.ssl) {
                            try {
                                if (ConscryptFileDescriptorSocket.this.state == 8) {
                                    throw new SocketException("socket is closed");
                                }
                            } finally {
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return read;
        }
    }

    @Override // org.conscrypt.AbstractConscryptSocket
    final void setApplicationProtocolSelector(ApplicationProtocolSelectorAdapter applicationProtocolSelectorAdapter) {
        this.sslParameters.setApplicationProtocolSelector(applicationProtocolSelectorAdapter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConscryptFileDescriptorSocket(String str, int i5, SSLParametersImpl sSLParametersImpl) {
        super(str, i5);
        this.state = 0;
        this.guard = Platform.closeGuardGet();
        this.externalSession = Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() { // from class: org.conscrypt.ConscryptFileDescriptorSocket.1
            @Override // org.conscrypt.ExternalSession.Provider
            public ConscryptSession provideSession() {
                return ConscryptFileDescriptorSocket.this.provideSession();
            }
        }));
        this.writeTimeoutMilliseconds = 0;
        this.handshakeTimeoutMilliseconds = -1;
        this.sslParameters = sSLParametersImpl;
        NativeSsl newSsl = newSsl(sSLParametersImpl, this);
        this.ssl = newSsl;
        this.activeSession = new ActiveSession(newSsl, sSLParametersImpl.getSessionContext());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConscryptFileDescriptorSocket(InetAddress inetAddress, int i5, SSLParametersImpl sSLParametersImpl) {
        super(inetAddress, i5);
        this.state = 0;
        this.guard = Platform.closeGuardGet();
        this.externalSession = Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() { // from class: org.conscrypt.ConscryptFileDescriptorSocket.1
            @Override // org.conscrypt.ExternalSession.Provider
            public ConscryptSession provideSession() {
                return ConscryptFileDescriptorSocket.this.provideSession();
            }
        }));
        this.writeTimeoutMilliseconds = 0;
        this.handshakeTimeoutMilliseconds = -1;
        this.sslParameters = sSLParametersImpl;
        NativeSsl newSsl = newSsl(sSLParametersImpl, this);
        this.ssl = newSsl;
        this.activeSession = new ActiveSession(newSsl, sSLParametersImpl.getSessionContext());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConscryptFileDescriptorSocket(String str, int i5, InetAddress inetAddress, int i6, SSLParametersImpl sSLParametersImpl) {
        super(str, i5, inetAddress, i6);
        this.state = 0;
        this.guard = Platform.closeGuardGet();
        this.externalSession = Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() { // from class: org.conscrypt.ConscryptFileDescriptorSocket.1
            @Override // org.conscrypt.ExternalSession.Provider
            public ConscryptSession provideSession() {
                return ConscryptFileDescriptorSocket.this.provideSession();
            }
        }));
        this.writeTimeoutMilliseconds = 0;
        this.handshakeTimeoutMilliseconds = -1;
        this.sslParameters = sSLParametersImpl;
        NativeSsl newSsl = newSsl(sSLParametersImpl, this);
        this.ssl = newSsl;
        this.activeSession = new ActiveSession(newSsl, sSLParametersImpl.getSessionContext());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConscryptFileDescriptorSocket(InetAddress inetAddress, int i5, InetAddress inetAddress2, int i6, SSLParametersImpl sSLParametersImpl) {
        super(inetAddress, i5, inetAddress2, i6);
        this.state = 0;
        this.guard = Platform.closeGuardGet();
        this.externalSession = Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() { // from class: org.conscrypt.ConscryptFileDescriptorSocket.1
            @Override // org.conscrypt.ExternalSession.Provider
            public ConscryptSession provideSession() {
                return ConscryptFileDescriptorSocket.this.provideSession();
            }
        }));
        this.writeTimeoutMilliseconds = 0;
        this.handshakeTimeoutMilliseconds = -1;
        this.sslParameters = sSLParametersImpl;
        NativeSsl newSsl = newSsl(sSLParametersImpl, this);
        this.ssl = newSsl;
        this.activeSession = new ActiveSession(newSsl, sSLParametersImpl.getSessionContext());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConscryptFileDescriptorSocket(Socket socket, String str, int i5, boolean z5, SSLParametersImpl sSLParametersImpl) {
        super(socket, str, i5, z5);
        this.state = 0;
        this.guard = Platform.closeGuardGet();
        this.externalSession = Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() { // from class: org.conscrypt.ConscryptFileDescriptorSocket.1
            @Override // org.conscrypt.ExternalSession.Provider
            public ConscryptSession provideSession() {
                return ConscryptFileDescriptorSocket.this.provideSession();
            }
        }));
        this.writeTimeoutMilliseconds = 0;
        this.handshakeTimeoutMilliseconds = -1;
        this.sslParameters = sSLParametersImpl;
        NativeSsl newSsl = newSsl(sSLParametersImpl, this);
        this.ssl = newSsl;
        this.activeSession = new ActiveSession(newSsl, sSLParametersImpl.getSessionContext());
    }
}
