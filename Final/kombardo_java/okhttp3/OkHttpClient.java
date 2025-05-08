package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 q2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002rqB\u0011\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00128G¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0017\u0010\u0017\u001a\u00020\u00168G¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8G¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001eR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8G¢\u0006\f\n\u0004\b\u001f\u0010\u001d\u001a\u0004\b\u001f\u0010\u001eR\u0017\u0010!\u001a\u00020 8G¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#R\u0017\u0010%\u001a\u00020$8G¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b%\u0010'R\u0017\u0010)\u001a\u00020(8G¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b)\u0010+R\u0017\u0010,\u001a\u00020$8G¢\u0006\f\n\u0004\b,\u0010&\u001a\u0004\b,\u0010'R\u0017\u0010-\u001a\u00020$8G¢\u0006\f\n\u0004\b-\u0010&\u001a\u0004\b-\u0010'R\u0017\u0010/\u001a\u00020.8G¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b/\u00101R\u0019\u00103\u001a\u0004\u0018\u0001028G¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b3\u00105R\u0017\u00107\u001a\u0002068G¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b7\u00109R\u0019\u0010;\u001a\u0004\u0018\u00010:8G¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b;\u0010=R\u0017\u0010?\u001a\u00020>8G¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\b?\u0010AR\u0017\u0010B\u001a\u00020(8G¢\u0006\f\n\u0004\bB\u0010*\u001a\u0004\bB\u0010+R\u0017\u0010D\u001a\u00020C8G¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bD\u0010FR\u0016\u0010H\u001a\u0004\u0018\u00010G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0019\u0010K\u001a\u0004\u0018\u00010J8G¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bK\u0010MR\u001d\u0010O\u001a\b\u0012\u0004\u0012\u00020N0\u001a8G¢\u0006\f\n\u0004\bO\u0010\u001d\u001a\u0004\bO\u0010\u001eR\u001d\u0010Q\u001a\b\u0012\u0004\u0012\u00020P0\u001a8G¢\u0006\f\n\u0004\bQ\u0010\u001d\u001a\u0004\bQ\u0010\u001eR\u0017\u0010S\u001a\u00020R8G¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bS\u0010UR\u0017\u0010W\u001a\u00020V8G¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bW\u0010YR\u0019\u0010[\u001a\u0004\u0018\u00010Z8G¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b[\u0010]R\u0017\u0010_\u001a\u00020^8G¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\b_\u0010aR\u0017\u0010b\u001a\u00020^8G¢\u0006\f\n\u0004\bb\u0010`\u001a\u0004\bb\u0010aR\u0017\u0010c\u001a\u00020^8G¢\u0006\f\n\u0004\bc\u0010`\u001a\u0004\bc\u0010aR\u0017\u0010d\u001a\u00020^8G¢\u0006\f\n\u0004\bd\u0010`\u001a\u0004\bd\u0010aR\u0017\u0010e\u001a\u00020^8G¢\u0006\f\n\u0004\be\u0010`\u001a\u0004\be\u0010aR\u0017\u0010g\u001a\u00020f8G¢\u0006\f\n\u0004\bg\u0010h\u001a\u0004\bg\u0010iR\u0017\u0010k\u001a\u00020j8\u0006¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bm\u0010nR\u0011\u0010o\u001a\u00020G8G¢\u0006\u0006\u001a\u0004\bo\u0010p¨\u0006s"}, d2 = {"Lokhttp3/OkHttpClient;", BuildConfig.FLAVOR, "Lokhttp3/Call$Factory;", BuildConfig.FLAVOR, "Lokhttp3/OkHttpClient$Builder;", "builder", "<init>", "(Lokhttp3/OkHttpClient$Builder;)V", "()V", BuildConfig.FLAVOR, "verifyClientState", "Lokhttp3/Request;", "request", "Lokhttp3/Call;", "newCall", "(Lokhttp3/Request;)Lokhttp3/Call;", "newBuilder", "()Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/Dispatcher;", "dispatcher", "Lokhttp3/Dispatcher;", "()Lokhttp3/Dispatcher;", "Lokhttp3/ConnectionPool;", "connectionPool", "Lokhttp3/ConnectionPool;", "()Lokhttp3/ConnectionPool;", BuildConfig.FLAVOR, "Lokhttp3/Interceptor;", "interceptors", "Ljava/util/List;", "()Ljava/util/List;", "networkInterceptors", "Lokhttp3/EventListener$Factory;", "eventListenerFactory", "Lokhttp3/EventListener$Factory;", "()Lokhttp3/EventListener$Factory;", BuildConfig.FLAVOR, "retryOnConnectionFailure", "Z", "()Z", "Lokhttp3/Authenticator;", "authenticator", "Lokhttp3/Authenticator;", "()Lokhttp3/Authenticator;", "followRedirects", "followSslRedirects", "Lokhttp3/CookieJar;", "cookieJar", "Lokhttp3/CookieJar;", "()Lokhttp3/CookieJar;", "Lokhttp3/Cache;", "cache", "Lokhttp3/Cache;", "()Lokhttp3/Cache;", "Lokhttp3/Dns;", "dns", "Lokhttp3/Dns;", "()Lokhttp3/Dns;", "Ljava/net/Proxy;", "proxy", "Ljava/net/Proxy;", "()Ljava/net/Proxy;", "Ljava/net/ProxySelector;", "proxySelector", "Ljava/net/ProxySelector;", "()Ljava/net/ProxySelector;", "proxyAuthenticator", "Ljavax/net/SocketFactory;", "socketFactory", "Ljavax/net/SocketFactory;", "()Ljavax/net/SocketFactory;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactoryOrNull", "Ljavax/net/ssl/SSLSocketFactory;", "Ljavax/net/ssl/X509TrustManager;", "x509TrustManager", "Ljavax/net/ssl/X509TrustManager;", "()Ljavax/net/ssl/X509TrustManager;", "Lokhttp3/ConnectionSpec;", "connectionSpecs", "Lokhttp3/Protocol;", "protocols", "Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "Ljavax/net/ssl/HostnameVerifier;", "()Ljavax/net/ssl/HostnameVerifier;", "Lokhttp3/CertificatePinner;", "certificatePinner", "Lokhttp3/CertificatePinner;", "()Lokhttp3/CertificatePinner;", "Lokhttp3/internal/tls/CertificateChainCleaner;", "certificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "()Lokhttp3/internal/tls/CertificateChainCleaner;", BuildConfig.FLAVOR, "callTimeoutMillis", "I", "()I", "connectTimeoutMillis", "readTimeoutMillis", "writeTimeoutMillis", "pingIntervalMillis", BuildConfig.FLAVOR, "minWebSocketMessageToCompress", "J", "()J", "Lokhttp3/internal/connection/RouteDatabase;", "routeDatabase", "Lokhttp3/internal/connection/RouteDatabase;", "getRouteDatabase", "()Lokhttp3/internal/connection/RouteDatabase;", "sslSocketFactory", "()Ljavax/net/ssl/SSLSocketFactory;", "Companion", "Builder", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class OkHttpClient implements Cloneable, Call.Factory {
    private final Authenticator authenticator;
    private final Cache cache;
    private final int callTimeoutMillis;
    private final CertificateChainCleaner certificateChainCleaner;
    private final CertificatePinner certificatePinner;
    private final int connectTimeoutMillis;
    private final ConnectionPool connectionPool;
    private final List<ConnectionSpec> connectionSpecs;
    private final CookieJar cookieJar;
    private final Dispatcher dispatcher;
    private final Dns dns;
    private final EventListener.Factory eventListenerFactory;
    private final boolean followRedirects;
    private final boolean followSslRedirects;
    private final HostnameVerifier hostnameVerifier;
    private final List<Interceptor> interceptors;
    private final long minWebSocketMessageToCompress;
    private final List<Interceptor> networkInterceptors;
    private final int pingIntervalMillis;
    private final List<Protocol> protocols;
    private final Proxy proxy;
    private final Authenticator proxyAuthenticator;
    private final ProxySelector proxySelector;
    private final int readTimeoutMillis;
    private final boolean retryOnConnectionFailure;
    private final RouteDatabase routeDatabase;
    private final SocketFactory socketFactory;
    private final SSLSocketFactory sslSocketFactoryOrNull;
    private final int writeTimeoutMillis;
    private final X509TrustManager x509TrustManager;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<Protocol> DEFAULT_PROTOCOLS = Util.immutableListOf(Protocol.HTTP_2, Protocol.HTTP_1_1);
    private static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS = Util.immutableListOf(ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT);

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Lokhttp3/OkHttpClient$Companion;", BuildConfig.FLAVOR, "()V", "DEFAULT_CONNECTION_SPECS", BuildConfig.FLAVOR, "Lokhttp3/ConnectionSpec;", "getDEFAULT_CONNECTION_SPECS$okhttp", "()Ljava/util/List;", "DEFAULT_PROTOCOLS", "Lokhttp3/Protocol;", "getDEFAULT_PROTOCOLS$okhttp", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<ConnectionSpec> getDEFAULT_CONNECTION_SPECS$okhttp() {
            return OkHttpClient.DEFAULT_CONNECTION_SPECS;
        }

        public final List<Protocol> getDEFAULT_PROTOCOLS$okhttp() {
            return OkHttpClient.DEFAULT_PROTOCOLS;
        }

        private Companion() {
        }
    }

    public OkHttpClient(Builder builder) {
        ProxySelector proxySelector;
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.dispatcher = builder.getDispatcher();
        this.connectionPool = builder.getConnectionPool();
        this.interceptors = Util.toImmutableList(builder.getInterceptors$okhttp());
        this.networkInterceptors = Util.toImmutableList(builder.getNetworkInterceptors$okhttp());
        this.eventListenerFactory = builder.getEventListenerFactory();
        this.retryOnConnectionFailure = builder.getRetryOnConnectionFailure();
        this.authenticator = builder.getAuthenticator();
        this.followRedirects = builder.getFollowRedirects();
        this.followSslRedirects = builder.getFollowSslRedirects();
        this.cookieJar = builder.getCookieJar();
        builder.getCache$okhttp();
        this.dns = builder.getDns();
        this.proxy = builder.getProxy();
        if (builder.getProxy() != null) {
            proxySelector = NullProxySelector.INSTANCE;
        } else {
            proxySelector = builder.getProxySelector();
            proxySelector = proxySelector == null ? ProxySelector.getDefault() : proxySelector;
            if (proxySelector == null) {
                proxySelector = NullProxySelector.INSTANCE;
            }
        }
        this.proxySelector = proxySelector;
        this.proxyAuthenticator = builder.getProxyAuthenticator();
        this.socketFactory = builder.getSocketFactory();
        List<ConnectionSpec> connectionSpecs$okhttp = builder.getConnectionSpecs$okhttp();
        this.connectionSpecs = connectionSpecs$okhttp;
        this.protocols = builder.getProtocols$okhttp();
        this.hostnameVerifier = builder.getHostnameVerifier();
        this.callTimeoutMillis = builder.getCallTimeout();
        this.connectTimeoutMillis = builder.getConnectTimeout();
        this.readTimeoutMillis = builder.getReadTimeout();
        this.writeTimeoutMillis = builder.getWriteTimeout();
        this.pingIntervalMillis = builder.getPingInterval();
        this.minWebSocketMessageToCompress = builder.getMinWebSocketMessageToCompress();
        RouteDatabase routeDatabase = builder.getRouteDatabase();
        this.routeDatabase = routeDatabase == null ? new RouteDatabase() : routeDatabase;
        List<ConnectionSpec> list = connectionSpecs$okhttp;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((ConnectionSpec) it.next()).getIsTls()) {
                    if (builder.getSslSocketFactoryOrNull() != null) {
                        this.sslSocketFactoryOrNull = builder.getSslSocketFactoryOrNull();
                        CertificateChainCleaner certificateChainCleaner = builder.getCertificateChainCleaner();
                        Intrinsics.checkNotNull(certificateChainCleaner);
                        this.certificateChainCleaner = certificateChainCleaner;
                        X509TrustManager x509TrustManagerOrNull = builder.getX509TrustManagerOrNull();
                        Intrinsics.checkNotNull(x509TrustManagerOrNull);
                        this.x509TrustManager = x509TrustManagerOrNull;
                        CertificatePinner certificatePinner = builder.getCertificatePinner();
                        Intrinsics.checkNotNull(certificateChainCleaner);
                        this.certificatePinner = certificatePinner.withCertificateChainCleaner$okhttp(certificateChainCleaner);
                    } else {
                        Platform.Companion companion = Platform.INSTANCE;
                        X509TrustManager platformTrustManager = companion.get().platformTrustManager();
                        this.x509TrustManager = platformTrustManager;
                        Platform platform = companion.get();
                        Intrinsics.checkNotNull(platformTrustManager);
                        this.sslSocketFactoryOrNull = platform.newSslSocketFactory(platformTrustManager);
                        CertificateChainCleaner.Companion companion2 = CertificateChainCleaner.INSTANCE;
                        Intrinsics.checkNotNull(platformTrustManager);
                        CertificateChainCleaner certificateChainCleaner2 = companion2.get(platformTrustManager);
                        this.certificateChainCleaner = certificateChainCleaner2;
                        CertificatePinner certificatePinner2 = builder.getCertificatePinner();
                        Intrinsics.checkNotNull(certificateChainCleaner2);
                        this.certificatePinner = certificatePinner2.withCertificateChainCleaner$okhttp(certificateChainCleaner2);
                    }
                    verifyClientState();
                }
            }
        }
        this.sslSocketFactoryOrNull = null;
        this.certificateChainCleaner = null;
        this.x509TrustManager = null;
        this.certificatePinner = CertificatePinner.DEFAULT;
        verifyClientState();
    }

    private final void verifyClientState() {
        if (this.interceptors.contains(null)) {
            throw new IllegalStateException(Intrinsics.stringPlus("Null interceptor: ", interceptors()).toString());
        }
        if (this.networkInterceptors.contains(null)) {
            throw new IllegalStateException(Intrinsics.stringPlus("Null network interceptor: ", networkInterceptors()).toString());
        }
        List<ConnectionSpec> list = this.connectionSpecs;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((ConnectionSpec) it.next()).getIsTls()) {
                    if (this.sslSocketFactoryOrNull == null) {
                        throw new IllegalStateException("sslSocketFactory == null");
                    }
                    if (this.certificateChainCleaner == null) {
                        throw new IllegalStateException("certificateChainCleaner == null");
                    }
                    if (this.x509TrustManager == null) {
                        throw new IllegalStateException("x509TrustManager == null");
                    }
                    return;
                }
            }
        }
        if (this.sslSocketFactoryOrNull != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (this.certificateChainCleaner != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (this.x509TrustManager != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (!Intrinsics.areEqual(this.certificatePinner, CertificatePinner.DEFAULT)) {
            throw new IllegalStateException("Check failed.");
        }
    }

    /* renamed from: authenticator, reason: from getter */
    public final Authenticator getAuthenticator() {
        return this.authenticator;
    }

    public final Cache cache() {
        return null;
    }

    /* renamed from: callTimeoutMillis, reason: from getter */
    public final int getCallTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    /* renamed from: certificateChainCleaner, reason: from getter */
    public final CertificateChainCleaner getCertificateChainCleaner() {
        return this.certificateChainCleaner;
    }

    /* renamed from: certificatePinner, reason: from getter */
    public final CertificatePinner getCertificatePinner() {
        return this.certificatePinner;
    }

    public Object clone() {
        return super.clone();
    }

    /* renamed from: connectTimeoutMillis, reason: from getter */
    public final int getConnectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    /* renamed from: connectionPool, reason: from getter */
    public final ConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    public final List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    /* renamed from: cookieJar, reason: from getter */
    public final CookieJar getCookieJar() {
        return this.cookieJar;
    }

    /* renamed from: dispatcher, reason: from getter */
    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    /* renamed from: dns, reason: from getter */
    public final Dns getDns() {
        return this.dns;
    }

    /* renamed from: eventListenerFactory, reason: from getter */
    public final EventListener.Factory getEventListenerFactory() {
        return this.eventListenerFactory;
    }

    /* renamed from: followRedirects, reason: from getter */
    public final boolean getFollowRedirects() {
        return this.followRedirects;
    }

    /* renamed from: followSslRedirects, reason: from getter */
    public final boolean getFollowSslRedirects() {
        return this.followSslRedirects;
    }

    public final RouteDatabase getRouteDatabase() {
        return this.routeDatabase;
    }

    /* renamed from: hostnameVerifier, reason: from getter */
    public final HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final List<Interceptor> interceptors() {
        return this.interceptors;
    }

    /* renamed from: minWebSocketMessageToCompress, reason: from getter */
    public final long getMinWebSocketMessageToCompress() {
        return this.minWebSocketMessageToCompress;
    }

    public final List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    @Override // okhttp3.Call.Factory
    public Call newCall(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return new RealCall(this, request, false);
    }

    /* renamed from: pingIntervalMillis, reason: from getter */
    public final int getPingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    public final List<Protocol> protocols() {
        return this.protocols;
    }

    /* renamed from: proxy, reason: from getter */
    public final Proxy getProxy() {
        return this.proxy;
    }

    /* renamed from: proxyAuthenticator, reason: from getter */
    public final Authenticator getProxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    /* renamed from: proxySelector, reason: from getter */
    public final ProxySelector getProxySelector() {
        return this.proxySelector;
    }

    /* renamed from: readTimeoutMillis, reason: from getter */
    public final int getReadTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    /* renamed from: retryOnConnectionFailure, reason: from getter */
    public final boolean getRetryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    /* renamed from: socketFactory, reason: from getter */
    public final SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    public final SSLSocketFactory sslSocketFactory() {
        SSLSocketFactory sSLSocketFactory = this.sslSocketFactoryOrNull;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    /* renamed from: writeTimeoutMillis, reason: from getter */
    public final int getWriteTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    /* renamed from: x509TrustManager, reason: from getter */
    public final X509TrustManager getX509TrustManager() {
        return this.x509TrustManager;
    }

    @Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0014\u001a\u00020\u00002\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001bJ\u001d\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001d\u0010\u001bJ\r\u0010\u001e\u001a\u00020\u0004¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R \u0010/\u001a\b\u0012\u0004\u0012\u00020\u00070.8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R \u00103\u001a\b\u0012\u0004\u0012\u00020\u00070.8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b3\u00100\u001a\u0004\b4\u00102R\"\u00106\u001a\u0002058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010\u0010\u001a\u00020\u000f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010B\u001a\u00020A8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010H\u001a\u00020\u000f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bH\u0010<\u001a\u0004\bI\u0010>\"\u0004\bJ\u0010@R\"\u0010K\u001a\u00020\u000f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bK\u0010<\u001a\u0004\bL\u0010>\"\u0004\bM\u0010@R\"\u0010O\u001a\u00020N8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR$\u0010V\u001a\u0004\u0018\u00010U8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\"\u0010]\u001a\u00020\\8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR$\u0010d\u001a\u0004\u0018\u00010c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR$\u0010k\u001a\u0004\u0018\u00010j8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\"\u0010q\u001a\u00020A8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bq\u0010C\u001a\u0004\br\u0010E\"\u0004\bs\u0010GR\"\u0010u\u001a\u00020t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR&\u0010|\u001a\u0004\u0018\u00010{8\u0000@\u0000X\u0080\u000e¢\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R,\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0082\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R.\u0010\u008a\u0001\u001a\t\u0012\u0005\u0012\u00030\u0089\u00010\u00128\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0005\b\u008a\u0001\u00100\u001a\u0005\b\u008b\u0001\u00102\"\u0006\b\u008c\u0001\u0010\u008d\u0001R+\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0004\b\u0014\u00100\u001a\u0005\b\u008e\u0001\u00102\"\u0006\b\u008f\u0001\u0010\u008d\u0001R*\u0010\u0091\u0001\u001a\u00030\u0090\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R*\u0010\u0098\u0001\u001a\u00030\u0097\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0098\u0001\u0010\u0099\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R,\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009e\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u009f\u0001\u0010 \u0001\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001R*\u0010¦\u0001\u001a\u00030¥\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b¦\u0001\u0010§\u0001\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R(\u0010\u001a\u001a\u00030¥\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b\u001a\u0010§\u0001\u001a\u0006\b¬\u0001\u0010©\u0001\"\u0006\b\u00ad\u0001\u0010«\u0001R(\u0010\u001c\u001a\u00030¥\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b\u001c\u0010§\u0001\u001a\u0006\b®\u0001\u0010©\u0001\"\u0006\b¯\u0001\u0010«\u0001R(\u0010\u001d\u001a\u00030¥\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b\u001d\u0010§\u0001\u001a\u0006\b°\u0001\u0010©\u0001\"\u0006\b±\u0001\u0010«\u0001R*\u0010²\u0001\u001a\u00030¥\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b²\u0001\u0010§\u0001\u001a\u0006\b³\u0001\u0010©\u0001\"\u0006\b´\u0001\u0010«\u0001R)\u0010µ\u0001\u001a\u00020\u00168\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bµ\u0001\u0010¶\u0001\u001a\u0006\b·\u0001\u0010¸\u0001\"\u0006\b¹\u0001\u0010º\u0001R,\u0010¼\u0001\u001a\u0005\u0018\u00010»\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b¼\u0001\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001¨\u0006Â\u0001"}, d2 = {"Lokhttp3/OkHttpClient$Builder;", BuildConfig.FLAVOR, "<init>", "()V", "Lokhttp3/OkHttpClient;", "okHttpClient", "(Lokhttp3/OkHttpClient;)V", "Lokhttp3/Interceptor;", "interceptor", "addInterceptor", "(Lokhttp3/Interceptor;)Lokhttp3/OkHttpClient$Builder;", "addNetworkInterceptor", "Lokhttp3/EventListener;", "eventListener", "(Lokhttp3/EventListener;)Lokhttp3/OkHttpClient$Builder;", BuildConfig.FLAVOR, "retryOnConnectionFailure", "(Z)Lokhttp3/OkHttpClient$Builder;", BuildConfig.FLAVOR, "Lokhttp3/Protocol;", "protocols", "(Ljava/util/List;)Lokhttp3/OkHttpClient$Builder;", BuildConfig.FLAVOR, "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "connectTimeout", "(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;", "readTimeout", "writeTimeout", "build", "()Lokhttp3/OkHttpClient;", "Lokhttp3/Dispatcher;", "dispatcher", "Lokhttp3/Dispatcher;", "getDispatcher$okhttp", "()Lokhttp3/Dispatcher;", "setDispatcher$okhttp", "(Lokhttp3/Dispatcher;)V", "Lokhttp3/ConnectionPool;", "connectionPool", "Lokhttp3/ConnectionPool;", "getConnectionPool$okhttp", "()Lokhttp3/ConnectionPool;", "setConnectionPool$okhttp", "(Lokhttp3/ConnectionPool;)V", BuildConfig.FLAVOR, "interceptors", "Ljava/util/List;", "getInterceptors$okhttp", "()Ljava/util/List;", "networkInterceptors", "getNetworkInterceptors$okhttp", "Lokhttp3/EventListener$Factory;", "eventListenerFactory", "Lokhttp3/EventListener$Factory;", "getEventListenerFactory$okhttp", "()Lokhttp3/EventListener$Factory;", "setEventListenerFactory$okhttp", "(Lokhttp3/EventListener$Factory;)V", "Z", "getRetryOnConnectionFailure$okhttp", "()Z", "setRetryOnConnectionFailure$okhttp", "(Z)V", "Lokhttp3/Authenticator;", "authenticator", "Lokhttp3/Authenticator;", "getAuthenticator$okhttp", "()Lokhttp3/Authenticator;", "setAuthenticator$okhttp", "(Lokhttp3/Authenticator;)V", "followRedirects", "getFollowRedirects$okhttp", "setFollowRedirects$okhttp", "followSslRedirects", "getFollowSslRedirects$okhttp", "setFollowSslRedirects$okhttp", "Lokhttp3/CookieJar;", "cookieJar", "Lokhttp3/CookieJar;", "getCookieJar$okhttp", "()Lokhttp3/CookieJar;", "setCookieJar$okhttp", "(Lokhttp3/CookieJar;)V", "Lokhttp3/Cache;", "cache", "Lokhttp3/Cache;", "getCache$okhttp", "()Lokhttp3/Cache;", "setCache$okhttp", "(Lokhttp3/Cache;)V", "Lokhttp3/Dns;", "dns", "Lokhttp3/Dns;", "getDns$okhttp", "()Lokhttp3/Dns;", "setDns$okhttp", "(Lokhttp3/Dns;)V", "Ljava/net/Proxy;", "proxy", "Ljava/net/Proxy;", "getProxy$okhttp", "()Ljava/net/Proxy;", "setProxy$okhttp", "(Ljava/net/Proxy;)V", "Ljava/net/ProxySelector;", "proxySelector", "Ljava/net/ProxySelector;", "getProxySelector$okhttp", "()Ljava/net/ProxySelector;", "setProxySelector$okhttp", "(Ljava/net/ProxySelector;)V", "proxyAuthenticator", "getProxyAuthenticator$okhttp", "setProxyAuthenticator$okhttp", "Ljavax/net/SocketFactory;", "socketFactory", "Ljavax/net/SocketFactory;", "getSocketFactory$okhttp", "()Ljavax/net/SocketFactory;", "setSocketFactory$okhttp", "(Ljavax/net/SocketFactory;)V", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactoryOrNull", "Ljavax/net/ssl/SSLSocketFactory;", "getSslSocketFactoryOrNull$okhttp", "()Ljavax/net/ssl/SSLSocketFactory;", "setSslSocketFactoryOrNull$okhttp", "(Ljavax/net/ssl/SSLSocketFactory;)V", "Ljavax/net/ssl/X509TrustManager;", "x509TrustManagerOrNull", "Ljavax/net/ssl/X509TrustManager;", "getX509TrustManagerOrNull$okhttp", "()Ljavax/net/ssl/X509TrustManager;", "setX509TrustManagerOrNull$okhttp", "(Ljavax/net/ssl/X509TrustManager;)V", "Lokhttp3/ConnectionSpec;", "connectionSpecs", "getConnectionSpecs$okhttp", "setConnectionSpecs$okhttp", "(Ljava/util/List;)V", "getProtocols$okhttp", "setProtocols$okhttp", "Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "Ljavax/net/ssl/HostnameVerifier;", "getHostnameVerifier$okhttp", "()Ljavax/net/ssl/HostnameVerifier;", "setHostnameVerifier$okhttp", "(Ljavax/net/ssl/HostnameVerifier;)V", "Lokhttp3/CertificatePinner;", "certificatePinner", "Lokhttp3/CertificatePinner;", "getCertificatePinner$okhttp", "()Lokhttp3/CertificatePinner;", "setCertificatePinner$okhttp", "(Lokhttp3/CertificatePinner;)V", "Lokhttp3/internal/tls/CertificateChainCleaner;", "certificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "getCertificateChainCleaner$okhttp", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "setCertificateChainCleaner$okhttp", "(Lokhttp3/internal/tls/CertificateChainCleaner;)V", BuildConfig.FLAVOR, "callTimeout", "I", "getCallTimeout$okhttp", "()I", "setCallTimeout$okhttp", "(I)V", "getConnectTimeout$okhttp", "setConnectTimeout$okhttp", "getReadTimeout$okhttp", "setReadTimeout$okhttp", "getWriteTimeout$okhttp", "setWriteTimeout$okhttp", "pingInterval", "getPingInterval$okhttp", "setPingInterval$okhttp", "minWebSocketMessageToCompress", "J", "getMinWebSocketMessageToCompress$okhttp", "()J", "setMinWebSocketMessageToCompress$okhttp", "(J)V", "Lokhttp3/internal/connection/RouteDatabase;", "routeDatabase", "Lokhttp3/internal/connection/RouteDatabase;", "getRouteDatabase$okhttp", "()Lokhttp3/internal/connection/RouteDatabase;", "setRouteDatabase$okhttp", "(Lokhttp3/internal/connection/RouteDatabase;)V", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Builder {
        private Authenticator authenticator;
        private Cache cache;
        private int callTimeout;
        private CertificateChainCleaner certificateChainCleaner;
        private CertificatePinner certificatePinner;
        private int connectTimeout;
        private ConnectionPool connectionPool;
        private List<ConnectionSpec> connectionSpecs;
        private CookieJar cookieJar;
        private Dispatcher dispatcher;
        private Dns dns;
        private EventListener.Factory eventListenerFactory;
        private boolean followRedirects;
        private boolean followSslRedirects;
        private HostnameVerifier hostnameVerifier;
        private final List<Interceptor> interceptors;
        private long minWebSocketMessageToCompress;
        private final List<Interceptor> networkInterceptors;
        private int pingInterval;
        private List<? extends Protocol> protocols;
        private Proxy proxy;
        private Authenticator proxyAuthenticator;
        private ProxySelector proxySelector;
        private int readTimeout;
        private boolean retryOnConnectionFailure;
        private RouteDatabase routeDatabase;
        private SocketFactory socketFactory;
        private SSLSocketFactory sslSocketFactoryOrNull;
        private int writeTimeout;
        private X509TrustManager x509TrustManagerOrNull;

        public Builder() {
            this.dispatcher = new Dispatcher();
            this.connectionPool = new ConnectionPool();
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.eventListenerFactory = Util.asFactory(EventListener.NONE);
            this.retryOnConnectionFailure = true;
            Authenticator authenticator = Authenticator.NONE;
            this.authenticator = authenticator;
            this.followRedirects = true;
            this.followSslRedirects = true;
            this.cookieJar = CookieJar.NO_COOKIES;
            this.dns = Dns.SYSTEM;
            this.proxyAuthenticator = authenticator;
            SocketFactory socketFactory = SocketFactory.getDefault();
            Intrinsics.checkNotNullExpressionValue(socketFactory, "getDefault()");
            this.socketFactory = socketFactory;
            Companion companion = OkHttpClient.INSTANCE;
            this.connectionSpecs = companion.getDEFAULT_CONNECTION_SPECS$okhttp();
            this.protocols = companion.getDEFAULT_PROTOCOLS$okhttp();
            this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
            this.certificatePinner = CertificatePinner.DEFAULT;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
            this.minWebSocketMessageToCompress = 1024L;
        }

        public final Builder addInterceptor(Interceptor interceptor) {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            getInterceptors$okhttp().add(interceptor);
            return this;
        }

        public final Builder addNetworkInterceptor(Interceptor interceptor) {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            getNetworkInterceptors$okhttp().add(interceptor);
            return this;
        }

        public final OkHttpClient build() {
            return new OkHttpClient(this);
        }

        public final Builder connectTimeout(long timeout, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            setConnectTimeout$okhttp(Util.checkDuration("timeout", timeout, unit));
            return this;
        }

        public final Builder eventListener(EventListener eventListener) {
            Intrinsics.checkNotNullParameter(eventListener, "eventListener");
            setEventListenerFactory$okhttp(Util.asFactory(eventListener));
            return this;
        }

        /* renamed from: getAuthenticator$okhttp, reason: from getter */
        public final Authenticator getAuthenticator() {
            return this.authenticator;
        }

        public final Cache getCache$okhttp() {
            return null;
        }

        /* renamed from: getCallTimeout$okhttp, reason: from getter */
        public final int getCallTimeout() {
            return this.callTimeout;
        }

        /* renamed from: getCertificateChainCleaner$okhttp, reason: from getter */
        public final CertificateChainCleaner getCertificateChainCleaner() {
            return this.certificateChainCleaner;
        }

        /* renamed from: getCertificatePinner$okhttp, reason: from getter */
        public final CertificatePinner getCertificatePinner() {
            return this.certificatePinner;
        }

        /* renamed from: getConnectTimeout$okhttp, reason: from getter */
        public final int getConnectTimeout() {
            return this.connectTimeout;
        }

        /* renamed from: getConnectionPool$okhttp, reason: from getter */
        public final ConnectionPool getConnectionPool() {
            return this.connectionPool;
        }

        public final List<ConnectionSpec> getConnectionSpecs$okhttp() {
            return this.connectionSpecs;
        }

        /* renamed from: getCookieJar$okhttp, reason: from getter */
        public final CookieJar getCookieJar() {
            return this.cookieJar;
        }

        /* renamed from: getDispatcher$okhttp, reason: from getter */
        public final Dispatcher getDispatcher() {
            return this.dispatcher;
        }

        /* renamed from: getDns$okhttp, reason: from getter */
        public final Dns getDns() {
            return this.dns;
        }

        /* renamed from: getEventListenerFactory$okhttp, reason: from getter */
        public final EventListener.Factory getEventListenerFactory() {
            return this.eventListenerFactory;
        }

        /* renamed from: getFollowRedirects$okhttp, reason: from getter */
        public final boolean getFollowRedirects() {
            return this.followRedirects;
        }

        /* renamed from: getFollowSslRedirects$okhttp, reason: from getter */
        public final boolean getFollowSslRedirects() {
            return this.followSslRedirects;
        }

        /* renamed from: getHostnameVerifier$okhttp, reason: from getter */
        public final HostnameVerifier getHostnameVerifier() {
            return this.hostnameVerifier;
        }

        public final List<Interceptor> getInterceptors$okhttp() {
            return this.interceptors;
        }

        /* renamed from: getMinWebSocketMessageToCompress$okhttp, reason: from getter */
        public final long getMinWebSocketMessageToCompress() {
            return this.minWebSocketMessageToCompress;
        }

        public final List<Interceptor> getNetworkInterceptors$okhttp() {
            return this.networkInterceptors;
        }

        /* renamed from: getPingInterval$okhttp, reason: from getter */
        public final int getPingInterval() {
            return this.pingInterval;
        }

        public final List<Protocol> getProtocols$okhttp() {
            return this.protocols;
        }

        /* renamed from: getProxy$okhttp, reason: from getter */
        public final Proxy getProxy() {
            return this.proxy;
        }

        /* renamed from: getProxyAuthenticator$okhttp, reason: from getter */
        public final Authenticator getProxyAuthenticator() {
            return this.proxyAuthenticator;
        }

        /* renamed from: getProxySelector$okhttp, reason: from getter */
        public final ProxySelector getProxySelector() {
            return this.proxySelector;
        }

        /* renamed from: getReadTimeout$okhttp, reason: from getter */
        public final int getReadTimeout() {
            return this.readTimeout;
        }

        /* renamed from: getRetryOnConnectionFailure$okhttp, reason: from getter */
        public final boolean getRetryOnConnectionFailure() {
            return this.retryOnConnectionFailure;
        }

        /* renamed from: getRouteDatabase$okhttp, reason: from getter */
        public final RouteDatabase getRouteDatabase() {
            return this.routeDatabase;
        }

        /* renamed from: getSocketFactory$okhttp, reason: from getter */
        public final SocketFactory getSocketFactory() {
            return this.socketFactory;
        }

        /* renamed from: getSslSocketFactoryOrNull$okhttp, reason: from getter */
        public final SSLSocketFactory getSslSocketFactoryOrNull() {
            return this.sslSocketFactoryOrNull;
        }

        /* renamed from: getWriteTimeout$okhttp, reason: from getter */
        public final int getWriteTimeout() {
            return this.writeTimeout;
        }

        /* renamed from: getX509TrustManagerOrNull$okhttp, reason: from getter */
        public final X509TrustManager getX509TrustManagerOrNull() {
            return this.x509TrustManagerOrNull;
        }

        public final Builder protocols(List<? extends Protocol> protocols) {
            Intrinsics.checkNotNullParameter(protocols, "protocols");
            List mutableList = CollectionsKt.toMutableList((Collection) protocols);
            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            if (!mutableList.contains(protocol) && !mutableList.contains(Protocol.HTTP_1_1)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("protocols must contain h2_prior_knowledge or http/1.1: ", mutableList).toString());
            }
            if (mutableList.contains(protocol) && mutableList.size() > 1) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("protocols containing h2_prior_knowledge cannot use other protocols: ", mutableList).toString());
            }
            if (mutableList.contains(Protocol.HTTP_1_0)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("protocols must not contain http/1.0: ", mutableList).toString());
            }
            if (mutableList.contains(null)) {
                throw new IllegalArgumentException("protocols must not contain null");
            }
            mutableList.remove(Protocol.SPDY_3);
            if (!Intrinsics.areEqual(mutableList, getProtocols$okhttp())) {
                setRouteDatabase$okhttp(null);
            }
            List<? extends Protocol> unmodifiableList = Collections.unmodifiableList(mutableList);
            Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(protocolsCopy)");
            setProtocols$okhttp(unmodifiableList);
            return this;
        }

        public final Builder readTimeout(long timeout, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            setReadTimeout$okhttp(Util.checkDuration("timeout", timeout, unit));
            return this;
        }

        public final Builder retryOnConnectionFailure(boolean retryOnConnectionFailure) {
            setRetryOnConnectionFailure$okhttp(retryOnConnectionFailure);
            return this;
        }

        public final void setConnectTimeout$okhttp(int i5) {
            this.connectTimeout = i5;
        }

        public final void setEventListenerFactory$okhttp(EventListener.Factory factory) {
            Intrinsics.checkNotNullParameter(factory, "<set-?>");
            this.eventListenerFactory = factory;
        }

        public final void setProtocols$okhttp(List<? extends Protocol> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.protocols = list;
        }

        public final void setReadTimeout$okhttp(int i5) {
            this.readTimeout = i5;
        }

        public final void setRetryOnConnectionFailure$okhttp(boolean z5) {
            this.retryOnConnectionFailure = z5;
        }

        public final void setRouteDatabase$okhttp(RouteDatabase routeDatabase) {
            this.routeDatabase = routeDatabase;
        }

        public final void setWriteTimeout$okhttp(int i5) {
            this.writeTimeout = i5;
        }

        public final Builder writeTimeout(long timeout, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            setWriteTimeout$okhttp(Util.checkDuration("timeout", timeout, unit));
            return this;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(OkHttpClient okHttpClient) {
            this();
            Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
            this.dispatcher = okHttpClient.getDispatcher();
            this.connectionPool = okHttpClient.getConnectionPool();
            CollectionsKt.addAll(this.interceptors, okHttpClient.interceptors());
            CollectionsKt.addAll(this.networkInterceptors, okHttpClient.networkInterceptors());
            this.eventListenerFactory = okHttpClient.getEventListenerFactory();
            this.retryOnConnectionFailure = okHttpClient.getRetryOnConnectionFailure();
            this.authenticator = okHttpClient.getAuthenticator();
            this.followRedirects = okHttpClient.getFollowRedirects();
            this.followSslRedirects = okHttpClient.getFollowSslRedirects();
            this.cookieJar = okHttpClient.getCookieJar();
            okHttpClient.cache();
            this.dns = okHttpClient.getDns();
            this.proxy = okHttpClient.getProxy();
            this.proxySelector = okHttpClient.getProxySelector();
            this.proxyAuthenticator = okHttpClient.getProxyAuthenticator();
            this.socketFactory = okHttpClient.getSocketFactory();
            this.sslSocketFactoryOrNull = okHttpClient.sslSocketFactoryOrNull;
            this.x509TrustManagerOrNull = okHttpClient.getX509TrustManager();
            this.connectionSpecs = okHttpClient.connectionSpecs();
            this.protocols = okHttpClient.protocols();
            this.hostnameVerifier = okHttpClient.getHostnameVerifier();
            this.certificatePinner = okHttpClient.getCertificatePinner();
            this.certificateChainCleaner = okHttpClient.getCertificateChainCleaner();
            this.callTimeout = okHttpClient.getCallTimeoutMillis();
            this.connectTimeout = okHttpClient.getConnectTimeoutMillis();
            this.readTimeout = okHttpClient.getReadTimeoutMillis();
            this.writeTimeout = okHttpClient.getWriteTimeoutMillis();
            this.pingInterval = okHttpClient.getPingIntervalMillis();
            this.minWebSocketMessageToCompress = okHttpClient.getMinWebSocketMessageToCompress();
            this.routeDatabase = okHttpClient.getRouteDatabase();
        }
    }

    public OkHttpClient() {
        this(new Builder());
    }
}
