package org.conscrypt;

import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContextSpi;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* loaded from: classes3.dex */
public abstract class OpenSSLContextImpl extends SSLContextSpi {
    private static DefaultSSLContextImpl defaultSslContextImpl;
    private final ClientSessionContext clientSessionContext;
    private final String[] protocols;
    private final ServerSessionContext serverSessionContext;
    SSLParametersImpl sslParameters;

    /* loaded from: classes3.dex */
    public static final class TLSv1 extends OpenSSLContextImpl {
        public TLSv1() {
            super(NativeCrypto.TLSV1_PROTOCOLS);
        }
    }

    /* loaded from: classes3.dex */
    public static final class TLSv11 extends OpenSSLContextImpl {
        public TLSv11() {
            super(NativeCrypto.TLSV11_PROTOCOLS);
        }
    }

    /* loaded from: classes3.dex */
    public static final class TLSv12 extends OpenSSLContextImpl {
        public TLSv12() {
            super(NativeCrypto.TLSV12_PROTOCOLS);
        }
    }

    /* loaded from: classes3.dex */
    public static final class TLSv13 extends OpenSSLContextImpl {
        public TLSv13() {
            super(NativeCrypto.TLSV13_PROTOCOLS);
        }
    }

    OpenSSLContextImpl(String[] strArr) {
        this.protocols = strArr;
        this.clientSessionContext = new ClientSessionContext();
        this.serverSessionContext = new ServerSessionContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OpenSSLContextImpl getPreferred() {
        return new TLSv13();
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLEngine engineCreateSSLEngine(String str, int i5) {
        SSLParametersImpl sSLParametersImpl = this.sslParameters;
        if (sSLParametersImpl != null) {
            SSLParametersImpl sSLParametersImpl2 = (SSLParametersImpl) sSLParametersImpl.clone();
            sSLParametersImpl2.setUseClientMode(false);
            return Platform.wrapEngine(new ConscryptEngine(str, i5, sSLParametersImpl2));
        }
        throw new IllegalStateException("SSLContext is not initialized.");
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLSessionContext engineGetClientSessionContext() {
        return this.clientSessionContext;
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLSessionContext engineGetServerSessionContext() {
        return this.serverSessionContext;
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLServerSocketFactory engineGetServerSocketFactory() {
        if (this.sslParameters != null) {
            return new OpenSSLServerSocketFactoryImpl(this.sslParameters);
        }
        throw new IllegalStateException("SSLContext is not initialized.");
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLSocketFactory engineGetSocketFactory() {
        if (this.sslParameters != null) {
            return Platform.wrapSocketFactoryIfNeeded(new OpenSSLSocketFactoryImpl(this.sslParameters));
        }
        throw new IllegalStateException("SSLContext is not initialized.");
    }

    @Override // javax.net.ssl.SSLContextSpi
    public void engineInit(KeyManager[] keyManagerArr, TrustManager[] trustManagerArr, SecureRandom secureRandom) {
        this.sslParameters = new SSLParametersImpl(keyManagerArr, trustManagerArr, secureRandom, this.clientSessionContext, this.serverSessionContext, this.protocols);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLContextImpl(String[] strArr, boolean z5) {
        synchronized (DefaultSSLContextImpl.class) {
            try {
                this.protocols = null;
                DefaultSSLContextImpl defaultSSLContextImpl = defaultSslContextImpl;
                if (defaultSSLContextImpl == null) {
                    this.clientSessionContext = new ClientSessionContext();
                    this.serverSessionContext = new ServerSessionContext();
                    defaultSslContextImpl = (DefaultSSLContextImpl) this;
                } else {
                    this.clientSessionContext = (ClientSessionContext) defaultSSLContextImpl.engineGetClientSessionContext();
                    this.serverSessionContext = (ServerSessionContext) defaultSslContextImpl.engineGetServerSessionContext();
                }
                this.sslParameters = new SSLParametersImpl(defaultSslContextImpl.getKeyManagers(), defaultSslContextImpl.getTrustManagers(), (SecureRandom) null, this.clientSessionContext, this.serverSessionContext, strArr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLEngine engineCreateSSLEngine() {
        SSLParametersImpl sSLParametersImpl = this.sslParameters;
        if (sSLParametersImpl != null) {
            SSLParametersImpl sSLParametersImpl2 = (SSLParametersImpl) sSLParametersImpl.clone();
            sSLParametersImpl2.setUseClientMode(false);
            return Platform.wrapEngine(new ConscryptEngine(sSLParametersImpl2));
        }
        throw new IllegalStateException("SSLContext is not initialized.");
    }
}
