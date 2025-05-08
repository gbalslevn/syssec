package org.conscrypt;

import com.adjust.sdk.Constants;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.X509KeyManager;
import javax.security.auth.x500.X500Principal;
import org.conscrypt.NativeCrypto;
import org.conscrypt.SSLParametersImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class NativeSsl {
    private final SSLParametersImpl.AliasChooser aliasChooser;
    private final NativeCrypto.SSLHandshakeCallbacks handshakeCallbacks;
    private X509Certificate[] localCertificates;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final SSLParametersImpl parameters;
    private final SSLParametersImpl.PSKCallbacks pskCallbacks;
    private volatile long ssl;

    /* loaded from: classes3.dex */
    final class BioWrapper {
        private volatile long bio;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void close() {
            NativeSsl.this.lock.writeLock().lock();
            try {
                long j5 = this.bio;
                this.bio = 0L;
                if (j5 != 0) {
                    NativeCrypto.BIO_free_all(j5);
                }
            } finally {
                NativeSsl.this.lock.writeLock().unlock();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getPendingWrittenBytes() {
            NativeSsl.this.lock.readLock().lock();
            try {
                return this.bio == 0 ? 0 : NativeCrypto.SSL_pending_written_bytes_in_BIO(this.bio);
            } finally {
                NativeSsl.this.lock.readLock().unlock();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int readDirectByteBuffer(long j5, int i5) {
            NativeSsl.this.lock.readLock().lock();
            try {
                if (NativeSsl.this.isClosed()) {
                    throw new SSLException("Connection closed");
                }
                return NativeCrypto.ENGINE_SSL_read_BIO_direct(NativeSsl.this.ssl, NativeSsl.this, this.bio, j5, i5, NativeSsl.this.handshakeCallbacks);
            } finally {
                NativeSsl.this.lock.readLock().unlock();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int writeDirectByteBuffer(long j5, int i5) {
            NativeSsl.this.lock.readLock().lock();
            try {
                if (NativeSsl.this.isClosed()) {
                    throw new SSLException("Connection closed");
                }
                return NativeCrypto.ENGINE_SSL_write_BIO_direct(NativeSsl.this.ssl, NativeSsl.this, this.bio, j5, i5, NativeSsl.this.handshakeCallbacks);
            } finally {
                NativeSsl.this.lock.readLock().unlock();
            }
        }

        private BioWrapper() {
            this.bio = NativeCrypto.SSL_BIO_new(NativeSsl.this.ssl, NativeSsl.this);
        }
    }

    private NativeSsl(long j5, SSLParametersImpl sSLParametersImpl, NativeCrypto.SSLHandshakeCallbacks sSLHandshakeCallbacks, SSLParametersImpl.AliasChooser aliasChooser, SSLParametersImpl.PSKCallbacks pSKCallbacks) {
        this.ssl = j5;
        this.parameters = sSLParametersImpl;
        this.handshakeCallbacks = sSLHandshakeCallbacks;
        this.aliasChooser = aliasChooser;
        this.pskCallbacks = pSKCallbacks;
    }

    private void enablePSKKeyManagerIfRequested() {
        PSKKeyManager pSKKeyManager = this.parameters.getPSKKeyManager();
        if (pSKKeyManager != null) {
            for (String str : this.parameters.enabledCipherSuites) {
                if (str != null && str.contains("PSK")) {
                    if (isClient()) {
                        NativeCrypto.set_SSL_psk_client_callback_enabled(this.ssl, this, true);
                        return;
                    }
                    NativeCrypto.set_SSL_psk_server_callback_enabled(this.ssl, this, true);
                    NativeCrypto.SSL_use_psk_identity_hint(this.ssl, this, this.pskCallbacks.chooseServerPSKIdentityHint(pSKKeyManager));
                    return;
                }
            }
        }
    }

    private Set<String> getCipherKeyTypes() {
        HashSet hashSet = new HashSet();
        for (long j5 : NativeCrypto.SSL_get_ciphers(this.ssl, this)) {
            String serverX509KeyType = SSLUtils.getServerX509KeyType(j5);
            if (serverX509KeyType != null) {
                hashSet.add(serverX509KeyType);
            }
        }
        return hashSet;
    }

    private boolean isClient() {
        return this.parameters.getUseClientMode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NativeSsl newInstance(SSLParametersImpl sSLParametersImpl, NativeCrypto.SSLHandshakeCallbacks sSLHandshakeCallbacks, SSLParametersImpl.AliasChooser aliasChooser, SSLParametersImpl.PSKCallbacks pSKCallbacks) {
        AbstractSessionContext sessionContext = sSLParametersImpl.getSessionContext();
        return new NativeSsl(NativeCrypto.SSL_new(sessionContext.sslCtxNativePointer, sessionContext), sSLParametersImpl, sSLHandshakeCallbacks, aliasChooser, pSKCallbacks);
    }

    private void setCertificate(String str) {
        X509KeyManager x509KeyManager;
        PrivateKey privateKey;
        if (str == null || (x509KeyManager = this.parameters.getX509KeyManager()) == null || (privateKey = x509KeyManager.getPrivateKey(str)) == null) {
            return;
        }
        X509Certificate[] certificateChain = x509KeyManager.getCertificateChain(str);
        this.localCertificates = certificateChain;
        if (certificateChain == null) {
            return;
        }
        int length = certificateChain.length;
        PublicKey publicKey = length > 0 ? certificateChain[0].getPublicKey() : null;
        byte[][] bArr = new byte[length];
        for (int i5 = 0; i5 < length; i5++) {
            bArr[i5] = this.localCertificates[i5].getEncoded();
        }
        try {
            NativeCrypto.setLocalCertsAndPrivateKey(this.ssl, this, bArr, OpenSSLKey.fromPrivateKeyForTLSStackOnly(privateKey, publicKey).getNativeRef());
        } catch (InvalidKeyException e5) {
            throw new SSLException(e5);
        }
    }

    private void setCertificateValidation() {
        if (isClient()) {
            return;
        }
        if (this.parameters.getNeedClientAuth()) {
            NativeCrypto.SSL_set_verify(this.ssl, this, 3);
        } else {
            if (!this.parameters.getWantClientAuth()) {
                NativeCrypto.SSL_set_verify(this.ssl, this, 0);
                return;
            }
            NativeCrypto.SSL_set_verify(this.ssl, this, 1);
        }
        X509Certificate[] acceptedIssuers = this.parameters.getX509TrustManager().getAcceptedIssuers();
        if (acceptedIssuers == null || acceptedIssuers.length == 0) {
            return;
        }
        try {
            NativeCrypto.SSL_set_client_CA_list(this.ssl, this, SSLUtils.encodeSubjectX509Principals(acceptedIssuers));
        } catch (CertificateEncodingException e5) {
            throw new SSLException("Problem encoding principals", e5);
        }
    }

    private void setTlsChannelId(OpenSSLKey openSSLKey) {
        SSLParametersImpl sSLParametersImpl = this.parameters;
        if (sSLParametersImpl.channelIdEnabled) {
            if (!sSLParametersImpl.getUseClientMode()) {
                NativeCrypto.SSL_enable_tls_channel_id(this.ssl, this);
            } else {
                if (openSSLKey == null) {
                    throw new SSLHandshakeException("Invalid TLS channel ID key specified");
                }
                NativeCrypto.SSL_set1_tls_channel_id(this.ssl, this, openSSLKey.getNativeRef());
            }
        }
    }

    private void verifyWithSniMatchers(String str) {
        if (AddressUtils.isValidSniHostname(str) && !Platform.serverNamePermitted(this.parameters, str)) {
            throw new SSLHandshakeException("SNI match failed: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void chooseClientCertificate(byte[] bArr, int[] iArr, byte[][] bArr2) {
        X500Principal[] x500PrincipalArr;
        Set<String> supportedClientKeyTypes = SSLUtils.getSupportedClientKeyTypes(bArr, iArr);
        String[] strArr = (String[]) supportedClientKeyTypes.toArray(new String[supportedClientKeyTypes.size()]);
        if (bArr2 == null) {
            x500PrincipalArr = null;
        } else {
            x500PrincipalArr = new X500Principal[bArr2.length];
            for (int i5 = 0; i5 < bArr2.length; i5++) {
                x500PrincipalArr[i5] = new X500Principal(bArr2[i5]);
            }
        }
        X509KeyManager x509KeyManager = this.parameters.getX509KeyManager();
        setCertificate(x509KeyManager != null ? this.aliasChooser.chooseClientAlias(x509KeyManager, x500PrincipalArr, strArr) : null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int clientPSKKeyRequested(String str, byte[] bArr, byte[] bArr2) {
        byte[] bytes;
        String str2;
        byte[] bArr3;
        PSKKeyManager pSKKeyManager = this.parameters.getPSKKeyManager();
        if (pSKKeyManager == null) {
            return 0;
        }
        String chooseClientPSKIdentity = this.pskCallbacks.chooseClientPSKIdentity(pSKKeyManager, str);
        if (chooseClientPSKIdentity == null) {
            bArr3 = EmptyArray.BYTE;
            str2 = BuildConfig.FLAVOR;
        } else {
            if (chooseClientPSKIdentity.isEmpty()) {
                bytes = EmptyArray.BYTE;
            } else {
                try {
                    bytes = chooseClientPSKIdentity.getBytes(Constants.ENCODING);
                } catch (UnsupportedEncodingException e5) {
                    throw new RuntimeException("UTF-8 encoding not supported", e5);
                }
            }
            byte[] bArr4 = bytes;
            str2 = chooseClientPSKIdentity;
            bArr3 = bArr4;
        }
        if (bArr3.length + 1 > bArr.length) {
            return 0;
        }
        if (bArr3.length > 0) {
            System.arraycopy(bArr3, 0, bArr, 0, bArr3.length);
        }
        bArr[bArr3.length] = 0;
        byte[] encoded = this.pskCallbacks.getPSKKey(pSKKeyManager, str, str2).getEncoded();
        if (encoded == null || encoded.length > bArr2.length) {
            return 0;
        }
        System.arraycopy(encoded, 0, bArr2, 0, encoded.length);
        return encoded.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void close() {
        this.lock.writeLock().lock();
        try {
            if (!isClosed()) {
                long j5 = this.ssl;
                this.ssl = 0L;
                NativeCrypto.SSL_free(j5, this);
            }
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void configureServerCertificate() {
        X509KeyManager x509KeyManager;
        verifyWithSniMatchers(getRequestedServerName());
        if (isClient() || (x509KeyManager = this.parameters.getX509KeyManager()) == null) {
            return;
        }
        Iterator<String> it = getCipherKeyTypes().iterator();
        while (it.hasNext()) {
            try {
                setCertificate(this.aliasChooser.chooseServerAlias(x509KeyManager, it.next()));
            } catch (CertificateEncodingException e5) {
                throw new IOException(e5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doHandshake(FileDescriptor fileDescriptor, int i5) {
        this.lock.readLock().lock();
        try {
            if (!isClosed() && fileDescriptor != null && fileDescriptor.valid()) {
                NativeCrypto.SSL_do_handshake(this.ssl, this, fileDescriptor, this.handshakeCallbacks, i5);
                return;
            }
            throw new SocketException("Socket is closed");
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] exportKeyingMaterial(String str, byte[] bArr, int i5) {
        if (str == null) {
            throw new NullPointerException("Label is null");
        }
        return NativeCrypto.SSL_export_keying_material(this.ssl, this, str.getBytes(Charset.forName("US-ASCII")), bArr, i5);
    }

    protected final void finalize() {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void forceRead() {
        this.lock.readLock().lock();
        try {
            NativeCrypto.ENGINE_SSL_force_read(this.ssl, this, this.handshakeCallbacks);
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getApplicationProtocol() {
        return NativeCrypto.getApplicationProtocol(this.ssl, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getCipherSuite() {
        return NativeCrypto.cipherSuiteToJava(NativeCrypto.SSL_get_current_cipher(this.ssl, this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getError(int i5) {
        return NativeCrypto.SSL_get_error(this.ssl, this, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public X509Certificate[] getLocalCertificates() {
        return this.localCertificates;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMaxSealOverhead() {
        return NativeCrypto.SSL_max_seal_overhead(this.ssl, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getPeerCertificateOcspData() {
        return NativeCrypto.SSL_get_ocsp_response(this.ssl, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public X509Certificate[] getPeerCertificates() {
        byte[][] SSL_get0_peer_certificates = NativeCrypto.SSL_get0_peer_certificates(this.ssl, this);
        if (SSL_get0_peer_certificates == null) {
            return null;
        }
        return SSLUtils.decodeX509CertificateChain(SSL_get0_peer_certificates);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getPeerTlsSctData() {
        return NativeCrypto.SSL_get_signed_cert_timestamp_list(this.ssl, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPendingReadableBytes() {
        this.lock.readLock().lock();
        try {
            if (!isClosed()) {
                return NativeCrypto.SSL_pending_readable_bytes(this.ssl, this);
            }
            this.lock.readLock().unlock();
            return 0;
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getRequestedServerName() {
        return NativeCrypto.SSL_get_servername(this.ssl, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getSessionId() {
        return NativeCrypto.SSL_session_id(this.ssl, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getTime() {
        return NativeCrypto.SSL_get_time(this.ssl, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getTimeout() {
        return NativeCrypto.SSL_get_timeout(this.ssl, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getTlsChannelId() {
        return NativeCrypto.SSL_get_tls_channel_id(this.ssl, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getTlsUnique() {
        return NativeCrypto.SSL_get_tls_unique(this.ssl, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getVersion() {
        return NativeCrypto.SSL_get_version(this.ssl, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initialize(String str, OpenSSLKey openSSLKey) {
        if (!this.parameters.getEnableSessionCreation()) {
            NativeCrypto.SSL_set_session_creation_enabled(this.ssl, this, false);
        }
        NativeCrypto.SSL_accept_renegotiations(this.ssl, this);
        if (isClient()) {
            NativeCrypto.SSL_set_connect_state(this.ssl, this);
            NativeCrypto.SSL_enable_ocsp_stapling(this.ssl, this);
            if (this.parameters.isCTVerificationEnabled(str)) {
                NativeCrypto.SSL_enable_signed_cert_timestamps(this.ssl, this);
            }
        } else {
            NativeCrypto.SSL_set_accept_state(this.ssl, this);
            if (this.parameters.getOCSPResponse() != null) {
                NativeCrypto.SSL_enable_ocsp_stapling(this.ssl, this);
            }
        }
        if (this.parameters.getEnabledProtocols().length == 0 && this.parameters.isEnabledProtocolsFiltered) {
            throw new SSLHandshakeException("No enabled protocols; SSLv3 is no longer supported and was filtered from the list");
        }
        NativeCrypto.setEnabledProtocols(this.ssl, this, this.parameters.enabledProtocols);
        long j5 = this.ssl;
        SSLParametersImpl sSLParametersImpl = this.parameters;
        NativeCrypto.setEnabledCipherSuites(j5, this, sSLParametersImpl.enabledCipherSuites, sSLParametersImpl.enabledProtocols);
        if (this.parameters.applicationProtocols.length > 0) {
            NativeCrypto.setApplicationProtocols(this.ssl, this, isClient(), this.parameters.applicationProtocols);
        }
        if (!isClient() && this.parameters.applicationProtocolSelector != null) {
            NativeCrypto.setHasApplicationProtocolSelector(this.ssl, this, true);
        }
        if (!isClient()) {
            NativeCrypto.SSL_set_options(this.ssl, this, 4194304L);
            if (this.parameters.sctExtension != null) {
                NativeCrypto.SSL_set_signed_cert_timestamp_list(this.ssl, this, this.parameters.sctExtension);
            }
            if (this.parameters.ocspResponse != null) {
                NativeCrypto.SSL_set_ocsp_response(this.ssl, this, this.parameters.ocspResponse);
            }
        }
        enablePSKKeyManagerIfRequested();
        if (this.parameters.useSessionTickets) {
            NativeCrypto.SSL_clear_options(this.ssl, this, 16384L);
        } else {
            NativeCrypto.SSL_set_options(this.ssl, this, NativeCrypto.SSL_get_options(this.ssl, this) | 16384);
        }
        if (this.parameters.getUseSni() && AddressUtils.isValidSniHostname(str)) {
            NativeCrypto.SSL_set_tlsext_host_name(this.ssl, this, str);
        }
        NativeCrypto.SSL_set_mode(this.ssl, this, 256L);
        setCertificateValidation();
        setTlsChannelId(openSSLKey);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void interrupt() {
        NativeCrypto.SSL_interrupt(this.ssl, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isClosed() {
        return this.ssl == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BioWrapper newBio() {
        try {
            return new BioWrapper();
        } catch (SSLException e5) {
            throw new RuntimeException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void offerToResumeSession(long j5) {
        NativeCrypto.SSL_set_session(this.ssl, this, j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int read(FileDescriptor fileDescriptor, byte[] bArr, int i5, int i6, int i7) {
        this.lock.readLock().lock();
        try {
            if (isClosed() || fileDescriptor == null || !fileDescriptor.valid()) {
                throw new SocketException("Socket is closed");
            }
            return NativeCrypto.SSL_read(this.ssl, this, fileDescriptor, this.handshakeCallbacks, bArr, i5, i6, i7);
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int readDirectByteBuffer(long j5, int i5) {
        this.lock.readLock().lock();
        try {
            return NativeCrypto.ENGINE_SSL_read_direct(this.ssl, this, j5, i5, this.handshakeCallbacks);
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int serverPSKKeyRequested(String str, String str2, byte[] bArr) {
        byte[] encoded;
        PSKKeyManager pSKKeyManager = this.parameters.getPSKKeyManager();
        if (pSKKeyManager == null || (encoded = this.pskCallbacks.getPSKKey(pSKKeyManager, str, str2).getEncoded()) == null || encoded.length > bArr.length) {
            return 0;
        }
        System.arraycopy(encoded, 0, bArr, 0, encoded.length);
        return encoded.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTimeout(long j5) {
        NativeCrypto.SSL_set_timeout(this.ssl, this, j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void shutdown(FileDescriptor fileDescriptor) {
        NativeCrypto.SSL_shutdown(this.ssl, this, fileDescriptor, this.handshakeCallbacks);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean wasShutdownReceived() {
        this.lock.readLock().lock();
        try {
            return (NativeCrypto.SSL_get_shutdown(this.ssl, this) & 2) != 0;
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean wasShutdownSent() {
        this.lock.readLock().lock();
        try {
            return (NativeCrypto.SSL_get_shutdown(this.ssl, this) & 1) != 0;
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void write(FileDescriptor fileDescriptor, byte[] bArr, int i5, int i6, int i7) {
        this.lock.readLock().lock();
        try {
            if (isClosed() || fileDescriptor == null || !fileDescriptor.valid()) {
                throw new SocketException("Socket is closed");
            }
            NativeCrypto.SSL_write(this.ssl, this, fileDescriptor, this.handshakeCallbacks, bArr, i5, i6, i7);
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int writeDirectByteBuffer(long j5, int i5) {
        this.lock.readLock().lock();
        try {
            return NativeCrypto.ENGINE_SSL_write_direct(this.ssl, this, j5, i5, this.handshakeCallbacks);
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void shutdown() {
        this.lock.readLock().lock();
        try {
            NativeCrypto.ENGINE_SSL_shutdown(this.ssl, this, this.handshakeCallbacks);
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int doHandshake() {
        this.lock.readLock().lock();
        try {
            return NativeCrypto.ENGINE_SSL_do_handshake(this.ssl, this, this.handshakeCallbacks);
        } finally {
            this.lock.readLock().unlock();
        }
    }
}
