package org.conscrypt;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.X509Certificate;
import java.util.Properties;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLContextSpi;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.conscrypt.io.IoUtils;

/* loaded from: classes3.dex */
public final class Conscrypt {
    private static final Version VERSION;

    /* loaded from: classes3.dex */
    public static class ProviderBuilder {
        private String defaultTlsProtocol;
        private String name;
        private boolean provideTrustManager;

        public Provider build() {
            return new OpenSSLProvider(this.name, this.provideTrustManager, this.defaultTlsProtocol);
        }

        public ProviderBuilder defaultTlsProtocol(String str) {
            this.defaultTlsProtocol = str;
            return this;
        }

        @Deprecated
        public ProviderBuilder provideTrustManager() {
            return provideTrustManager(true);
        }

        public ProviderBuilder setName(String str) {
            this.name = str;
            return this;
        }

        private ProviderBuilder() {
            this.name = Platform.getDefaultProviderName();
            this.provideTrustManager = Platform.provideTrustManagerByDefault();
            this.defaultTlsProtocol = "TLSv1.3";
        }

        public ProviderBuilder provideTrustManager(boolean z5) {
            this.provideTrustManager = z5;
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class Version {
        private final int major;
        private final int minor;
        private final int patch;

        public int major() {
            return this.major;
        }

        public int minor() {
            return this.minor;
        }

        public int patch() {
            return this.patch;
        }

        private Version(int i5, int i6, int i7) {
            this.major = i5;
            this.minor = i6;
            this.patch = i7;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i5;
        int i6;
        InputStream inputStream;
        int i7;
        int i8 = -1;
        InputStream inputStream2 = null;
        Object[] objArr = 0;
        try {
            inputStream = Conscrypt.class.getResourceAsStream("conscrypt.properties");
            if (inputStream != null) {
                try {
                    try {
                        Properties properties = new Properties();
                        properties.load(inputStream);
                        i5 = Integer.parseInt(properties.getProperty("org.conscrypt.version.major", "-1"));
                        try {
                            i6 = Integer.parseInt(properties.getProperty("org.conscrypt.version.minor", "-1"));
                        } catch (IOException unused) {
                            i6 = -1;
                        }
                        try {
                            i7 = Integer.parseInt(properties.getProperty("org.conscrypt.version.patch", "-1"));
                            i8 = i5;
                        } catch (IOException unused2) {
                            IoUtils.closeQuietly(inputStream);
                            i7 = -1;
                            i8 = i5;
                            if (i8 >= 0) {
                            }
                            VERSION = null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream2 = inputStream;
                        IoUtils.closeQuietly(inputStream2);
                        throw th;
                    }
                } catch (IOException unused3) {
                    i5 = -1;
                    i6 = -1;
                }
            } else {
                i7 = -1;
                i6 = -1;
            }
            IoUtils.closeQuietly(inputStream);
        } catch (IOException unused4) {
            i5 = -1;
            i6 = -1;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
        if (i8 >= 0 || i6 < 0 || i7 < 0) {
            VERSION = null;
        } else {
            VERSION = new Version(i8, i6, i7);
        }
    }

    private Conscrypt() {
    }

    public static void checkAvailability() {
        NativeCrypto.checkAvailability();
    }

    public static byte[] exportKeyingMaterial(SSLSocket sSLSocket, String str, byte[] bArr, int i5) {
        return toConscrypt(sSLSocket).exportKeyingMaterial(str, bArr, i5);
    }

    public static String getApplicationProtocol(SSLSocket sSLSocket) {
        return toConscrypt(sSLSocket).getApplicationProtocol();
    }

    public static String[] getApplicationProtocols(SSLSocket sSLSocket) {
        return toConscrypt(sSLSocket).getApplicationProtocols();
    }

    public static byte[] getChannelId(SSLSocket sSLSocket) {
        return toConscrypt(sSLSocket).getChannelId();
    }

    public static synchronized ConscryptHostnameVerifier getDefaultHostnameVerifier(TrustManager trustManager) {
        ConscryptHostnameVerifier defaultHostnameVerifier;
        synchronized (Conscrypt.class) {
            defaultHostnameVerifier = TrustManagerImpl.getDefaultHostnameVerifier();
        }
        return defaultHostnameVerifier;
    }

    public static X509TrustManager getDefaultX509TrustManager() {
        checkAvailability();
        return SSLParametersImpl.getDefaultX509TrustManager();
    }

    public static String getHostname(SSLSocket sSLSocket) {
        return toConscrypt(sSLSocket).getHostname();
    }

    public static String getHostnameOrIP(SSLSocket sSLSocket) {
        return toConscrypt(sSLSocket).getHostnameOrIP();
    }

    public static ConscryptHostnameVerifier getHostnameVerifier(TrustManager trustManager) {
        return toConscrypt(trustManager).getHostnameVerifier();
    }

    public static byte[] getTlsUnique(SSLSocket sSLSocket) {
        return toConscrypt(sSLSocket).getTlsUnique();
    }

    public static boolean isAvailable() {
        try {
            checkAvailability();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isConscrypt(Provider provider) {
        return provider instanceof OpenSSLProvider;
    }

    public static int maxEncryptedPacketLength() {
        return 16709;
    }

    public static int maxSealOverhead(SSLEngine sSLEngine) {
        return toConscrypt(sSLEngine).maxSealOverhead();
    }

    public static SSLContextSpi newPreferredSSLContextSpi() {
        checkAvailability();
        return OpenSSLContextImpl.getPreferred();
    }

    public static Provider newProvider() {
        checkAvailability();
        return new OpenSSLProvider();
    }

    public static ProviderBuilder newProviderBuilder() {
        return new ProviderBuilder();
    }

    public static void setApplicationProtocolSelector(SSLSocket sSLSocket, ApplicationProtocolSelector applicationProtocolSelector) {
        toConscrypt(sSLSocket).setApplicationProtocolSelector(applicationProtocolSelector);
    }

    public static void setApplicationProtocols(SSLSocket sSLSocket, String[] strArr) {
        toConscrypt(sSLSocket).setApplicationProtocols(strArr);
    }

    public static void setBufferAllocator(SSLEngine sSLEngine, BufferAllocator bufferAllocator) {
        toConscrypt(sSLEngine).setBufferAllocator(bufferAllocator);
    }

    public static void setChannelIdEnabled(SSLSocket sSLSocket, boolean z5) {
        toConscrypt(sSLSocket).setChannelIdEnabled(z5);
    }

    public static void setChannelIdPrivateKey(SSLSocket sSLSocket, PrivateKey privateKey) {
        toConscrypt(sSLSocket).setChannelIdPrivateKey(privateKey);
    }

    public static void setClientSessionCache(SSLContext sSLContext, SSLClientSessionCache sSLClientSessionCache) {
        SSLSessionContext clientSessionContext = sSLContext.getClientSessionContext();
        if (clientSessionContext instanceof ClientSessionContext) {
            ((ClientSessionContext) clientSessionContext).setPersistentCache(sSLClientSessionCache);
            return;
        }
        throw new IllegalArgumentException("Not a conscrypt client context: " + clientSessionContext.getClass().getName());
    }

    public static void setDefaultBufferAllocator(BufferAllocator bufferAllocator) {
        ConscryptEngine.setDefaultBufferAllocator(bufferAllocator);
    }

    public static synchronized void setDefaultHostnameVerifier(ConscryptHostnameVerifier conscryptHostnameVerifier) {
        synchronized (Conscrypt.class) {
            TrustManagerImpl.setDefaultHostnameVerifier(conscryptHostnameVerifier);
        }
    }

    public static void setHandshakeListener(SSLEngine sSLEngine, HandshakeListener handshakeListener) {
        toConscrypt(sSLEngine).setHandshakeListener(handshakeListener);
    }

    public static void setHostname(SSLSocket sSLSocket, String str) {
        toConscrypt(sSLSocket).setHostname(str);
    }

    public static void setHostnameVerifier(TrustManager trustManager, ConscryptHostnameVerifier conscryptHostnameVerifier) {
        toConscrypt(trustManager).setHostnameVerifier(conscryptHostnameVerifier);
    }

    public static void setServerSessionCache(SSLContext sSLContext, SSLServerSessionCache sSLServerSessionCache) {
        SSLSessionContext serverSessionContext = sSLContext.getServerSessionContext();
        if (serverSessionContext instanceof ServerSessionContext) {
            ((ServerSessionContext) serverSessionContext).setPersistentCache(sSLServerSessionCache);
            return;
        }
        throw new IllegalArgumentException("Not a conscrypt client context: " + serverSessionContext.getClass().getName());
    }

    public static void setUseEngineSocket(SSLSocketFactory sSLSocketFactory, boolean z5) {
        toConscrypt(sSLSocketFactory).setUseEngineSocket(z5);
    }

    public static void setUseEngineSocketByDefault(boolean z5) {
        OpenSSLSocketFactoryImpl.setUseEngineSocketByDefault(z5);
        OpenSSLServerSocketFactoryImpl.setUseEngineSocketByDefault(z5);
    }

    public static void setUseSessionTickets(SSLSocket sSLSocket, boolean z5) {
        toConscrypt(sSLSocket).setUseSessionTickets(z5);
    }

    private static OpenSSLSocketFactoryImpl toConscrypt(SSLSocketFactory sSLSocketFactory) {
        if (isConscrypt(sSLSocketFactory)) {
            return (OpenSSLSocketFactoryImpl) sSLSocketFactory;
        }
        throw new IllegalArgumentException("Not a conscrypt socket factory: " + sSLSocketFactory.getClass().getName());
    }

    public static SSLEngineResult unwrap(SSLEngine sSLEngine, ByteBuffer[] byteBufferArr, ByteBuffer[] byteBufferArr2) {
        return toConscrypt(sSLEngine).unwrap(byteBufferArr, byteBufferArr2);
    }

    public static Version version() {
        return VERSION;
    }

    public static ConscryptHostnameVerifier wrapHostnameVerifier(final HostnameVerifier hostnameVerifier) {
        return new ConscryptHostnameVerifier() { // from class: org.conscrypt.Conscrypt.1
            @Override // org.conscrypt.ConscryptHostnameVerifier
            public boolean verify(X509Certificate[] x509CertificateArr, String str, SSLSession sSLSession) {
                return hostnameVerifier.verify(str, sSLSession);
            }
        };
    }

    public static byte[] exportKeyingMaterial(SSLEngine sSLEngine, String str, byte[] bArr, int i5) {
        return toConscrypt(sSLEngine).exportKeyingMaterial(str, bArr, i5);
    }

    public static String getApplicationProtocol(SSLEngine sSLEngine) {
        return toConscrypt(sSLEngine).getApplicationProtocol();
    }

    public static String[] getApplicationProtocols(SSLEngine sSLEngine) {
        return toConscrypt(sSLEngine).getApplicationProtocols();
    }

    public static byte[] getChannelId(SSLEngine sSLEngine) {
        return toConscrypt(sSLEngine).getChannelId();
    }

    public static String getHostname(SSLEngine sSLEngine) {
        return toConscrypt(sSLEngine).getHostname();
    }

    public static byte[] getTlsUnique(SSLEngine sSLEngine) {
        return toConscrypt(sSLEngine).getTlsUnique();
    }

    public static boolean isConscrypt(SSLContext sSLContext) {
        return sSLContext.getProvider() instanceof OpenSSLProvider;
    }

    public static void setApplicationProtocolSelector(SSLEngine sSLEngine, ApplicationProtocolSelector applicationProtocolSelector) {
        toConscrypt(sSLEngine).setApplicationProtocolSelector(applicationProtocolSelector);
    }

    public static void setApplicationProtocols(SSLEngine sSLEngine, String[] strArr) {
        toConscrypt(sSLEngine).setApplicationProtocols(strArr);
    }

    public static void setBufferAllocator(SSLSocket sSLSocket, BufferAllocator bufferAllocator) {
        AbstractConscryptSocket conscrypt = toConscrypt(sSLSocket);
        if (conscrypt instanceof ConscryptEngineSocket) {
            ((ConscryptEngineSocket) conscrypt).setBufferAllocator(bufferAllocator);
        }
    }

    public static void setChannelIdEnabled(SSLEngine sSLEngine, boolean z5) {
        toConscrypt(sSLEngine).setChannelIdEnabled(z5);
    }

    public static void setChannelIdPrivateKey(SSLEngine sSLEngine, PrivateKey privateKey) {
        toConscrypt(sSLEngine).setChannelIdPrivateKey(privateKey);
    }

    public static void setHostname(SSLEngine sSLEngine, String str) {
        toConscrypt(sSLEngine).setHostname(str);
    }

    public static void setUseEngineSocket(SSLServerSocketFactory sSLServerSocketFactory, boolean z5) {
        toConscrypt(sSLServerSocketFactory).setUseEngineSocket(z5);
    }

    public static void setUseSessionTickets(SSLEngine sSLEngine, boolean z5) {
        toConscrypt(sSLEngine).setUseSessionTickets(z5);
    }

    public static SSLEngineResult unwrap(SSLEngine sSLEngine, ByteBuffer[] byteBufferArr, int i5, int i6, ByteBuffer[] byteBufferArr2, int i7, int i8) {
        return toConscrypt(sSLEngine).unwrap(byteBufferArr, i5, i6, byteBufferArr2, i7, i8);
    }

    public static boolean isConscrypt(SSLSocketFactory sSLSocketFactory) {
        return sSLSocketFactory instanceof OpenSSLSocketFactoryImpl;
    }

    @Deprecated
    public static Provider newProvider(String str) {
        checkAvailability();
        return newProviderBuilder().setName(str).build();
    }

    public static boolean isConscrypt(SSLServerSocketFactory sSLServerSocketFactory) {
        return sSLServerSocketFactory instanceof OpenSSLServerSocketFactoryImpl;
    }

    public static boolean isConscrypt(SSLSocket sSLSocket) {
        return sSLSocket instanceof AbstractConscryptSocket;
    }

    private static OpenSSLServerSocketFactoryImpl toConscrypt(SSLServerSocketFactory sSLServerSocketFactory) {
        if (isConscrypt(sSLServerSocketFactory)) {
            return (OpenSSLServerSocketFactoryImpl) sSLServerSocketFactory;
        }
        throw new IllegalArgumentException("Not a conscrypt server socket factory: " + sSLServerSocketFactory.getClass().getName());
    }

    public static boolean isConscrypt(SSLEngine sSLEngine) {
        return sSLEngine instanceof AbstractConscryptEngine;
    }

    public static boolean isConscrypt(TrustManager trustManager) {
        return trustManager instanceof TrustManagerImpl;
    }

    private static AbstractConscryptSocket toConscrypt(SSLSocket sSLSocket) {
        if (isConscrypt(sSLSocket)) {
            return (AbstractConscryptSocket) sSLSocket;
        }
        throw new IllegalArgumentException("Not a conscrypt socket: " + sSLSocket.getClass().getName());
    }

    private static AbstractConscryptEngine toConscrypt(SSLEngine sSLEngine) {
        if (isConscrypt(sSLEngine)) {
            return (AbstractConscryptEngine) sSLEngine;
        }
        throw new IllegalArgumentException("Not a conscrypt engine: " + sSLEngine.getClass().getName());
    }

    private static TrustManagerImpl toConscrypt(TrustManager trustManager) {
        if (isConscrypt(trustManager)) {
            return (TrustManagerImpl) trustManager;
        }
        throw new IllegalArgumentException("Not a Conscrypt trust manager: " + trustManager.getClass().getName());
    }
}
