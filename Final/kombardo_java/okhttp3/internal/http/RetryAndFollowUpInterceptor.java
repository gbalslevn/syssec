package okhttp3.internal.http;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J(\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lokhttp3/internal/http/RetryAndFollowUpInterceptor;", "Lokhttp3/Interceptor;", "client", "Lokhttp3/OkHttpClient;", "(Lokhttp3/OkHttpClient;)V", "buildRedirectRequest", "Lokhttp3/Request;", "userResponse", "Lokhttp3/Response;", "method", BuildConfig.FLAVOR, "followUpRequest", "exchange", "Lokhttp3/internal/connection/Exchange;", "intercept", "chain", "Lokhttp3/Interceptor$Chain;", "isRecoverable", BuildConfig.FLAVOR, "e", "Ljava/io/IOException;", "requestSendStarted", "recover", "call", "Lokhttp3/internal/connection/RealCall;", "userRequest", "requestIsOneShot", "retryAfter", BuildConfig.FLAVOR, "defaultDelay", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {
    private static final int MAX_FOLLOW_UPS = 20;
    private final OkHttpClient client;

    public RetryAndFollowUpInterceptor(OkHttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
    }

    private final Request buildRedirectRequest(Response userResponse, String method) {
        String header$default;
        HttpUrl resolve;
        if (!this.client.getFollowRedirects() || (header$default = Response.header$default(userResponse, "Location", null, 2, null)) == null || (resolve = userResponse.getRequest().getUrl().resolve(header$default)) == null) {
            return null;
        }
        if (!Intrinsics.areEqual(resolve.getScheme(), userResponse.getRequest().getUrl().getScheme()) && !this.client.getFollowSslRedirects()) {
            return null;
        }
        Request.Builder newBuilder = userResponse.getRequest().newBuilder();
        if (HttpMethod.permitsRequestBody(method)) {
            int code = userResponse.getCode();
            HttpMethod httpMethod = HttpMethod.INSTANCE;
            boolean z5 = httpMethod.redirectsWithBody(method) || code == 308 || code == 307;
            if (!httpMethod.redirectsToGet(method) || code == 308 || code == 307) {
                newBuilder.method(method, z5 ? userResponse.getRequest().getBody() : null);
            } else {
                newBuilder.method("GET", null);
            }
            if (!z5) {
                newBuilder.removeHeader("Transfer-Encoding");
                newBuilder.removeHeader("Content-Length");
                newBuilder.removeHeader("Content-Type");
            }
        }
        if (!Util.canReuseConnectionFor(userResponse.getRequest().getUrl(), resolve)) {
            newBuilder.removeHeader("Authorization");
        }
        return newBuilder.url(resolve).build();
    }

    private final Request followUpRequest(Response userResponse, Exchange exchange) {
        RealConnection connection;
        Route route = (exchange == null || (connection = exchange.getConnection()) == null) ? null : connection.getRoute();
        int code = userResponse.getCode();
        String method = userResponse.getRequest().getMethod();
        if (code != 307 && code != 308) {
            if (code == 401) {
                return this.client.getAuthenticator().authenticate(route, userResponse);
            }
            if (code == 421) {
                RequestBody body = userResponse.getRequest().getBody();
                if ((body != null && body.isOneShot()) || exchange == null || !exchange.isCoalescedConnection$okhttp()) {
                    return null;
                }
                exchange.getConnection().noCoalescedConnections$okhttp();
                return userResponse.getRequest();
            }
            if (code == 503) {
                Response priorResponse = userResponse.getPriorResponse();
                if ((priorResponse == null || priorResponse.getCode() != 503) && retryAfter(userResponse, Integer.MAX_VALUE) == 0) {
                    return userResponse.getRequest();
                }
                return null;
            }
            if (code == 407) {
                Intrinsics.checkNotNull(route);
                if (route.getProxy().type() == Proxy.Type.HTTP) {
                    return this.client.getProxyAuthenticator().authenticate(route, userResponse);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (code == 408) {
                if (!this.client.getRetryOnConnectionFailure()) {
                    return null;
                }
                RequestBody body2 = userResponse.getRequest().getBody();
                if (body2 != null && body2.isOneShot()) {
                    return null;
                }
                Response priorResponse2 = userResponse.getPriorResponse();
                if ((priorResponse2 == null || priorResponse2.getCode() != 408) && retryAfter(userResponse, 0) <= 0) {
                    return userResponse.getRequest();
                }
                return null;
            }
            switch (code) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        return buildRedirectRequest(userResponse, method);
    }

    private final boolean isRecoverable(IOException e5, boolean requestSendStarted) {
        if (e5 instanceof ProtocolException) {
            return false;
        }
        return e5 instanceof InterruptedIOException ? (e5 instanceof SocketTimeoutException) && !requestSendStarted : (((e5 instanceof SSLHandshakeException) && (e5.getCause() instanceof CertificateException)) || (e5 instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private final boolean recover(IOException e5, RealCall call, Request userRequest, boolean requestSendStarted) {
        if (this.client.getRetryOnConnectionFailure()) {
            return !(requestSendStarted && requestIsOneShot(e5, userRequest)) && isRecoverable(e5, requestSendStarted) && call.retryAfterFailure();
        }
        return false;
    }

    private final boolean requestIsOneShot(IOException e5, Request userRequest) {
        RequestBody body = userRequest.getBody();
        return (body != null && body.isOneShot()) || (e5 instanceof FileNotFoundException);
    }

    private final int retryAfter(Response userResponse, int defaultDelay) {
        String header$default = Response.header$default(userResponse, "Retry-After", null, 2, null);
        if (header$default == null) {
            return defaultDelay;
        }
        if (!new Regex("\\d+").matches(header$default)) {
            return Integer.MAX_VALUE;
        }
        Integer valueOf = Integer.valueOf(header$default);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(header)");
        return valueOf.intValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        if (r7 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
    
        r0 = r0.newBuilder().priorResponse(r7.newBuilder().body(null).build()).build();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
    
        r7 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
    
        r0 = r1.getInterceptorScopedExchange();
        r6 = followUpRequest(r7, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004d, code lost:
    
        if (r6 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005e, code lost:
    
        r0 = r6.getBody();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0062, code lost:
    
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0068, code lost:
    
        if (r0.isOneShot() == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006a, code lost:
    
        r1.exitNetworkInterceptorExchange$okhttp(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006d, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006e, code lost:
    
        r0 = r7.getBody();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0072, code lost:
    
        if (r0 != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0078, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007c, code lost:
    
        if (r8 > 20) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0092, code lost:
    
        throw new java.net.ProtocolException(kotlin.jvm.internal.Intrinsics.stringPlus("Too many follow-up requests: ", java.lang.Integer.valueOf(r8)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0075, code lost:
    
        okhttp3.internal.Util.closeQuietly(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x004f, code lost:
    
        if (r0 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0055, code lost:
    
        if (r0.getIsDuplex() == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0057, code lost:
    
        r1.timeoutEarlyExit();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x005a, code lost:
    
        r1.exitNetworkInterceptorExchange$okhttp(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x005d, code lost:
    
        return r7;
     */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response intercept(Interceptor.Chain chain) {
        Request followUpRequest;
        Intrinsics.checkNotNullParameter(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request = realInterceptorChain.getRequest();
        RealCall call = realInterceptorChain.getCall();
        List emptyList = CollectionsKt.emptyList();
        int i5 = 0;
        Response response = null;
        while (true) {
            boolean z5 = true;
            while (true) {
                call.enterNetworkInterceptorExchange(request, z5);
                try {
                    if (call.getCanceled()) {
                        throw new IOException("Canceled");
                    }
                    try {
                        Response proceed = realInterceptorChain.proceed(request);
                        break;
                    } catch (IOException e5) {
                        if (!recover(e5, call, request, !(e5 instanceof ConnectionShutdownException))) {
                            throw Util.withSuppressed(e5, emptyList);
                        }
                        emptyList = CollectionsKt.plus((Collection<? extends IOException>) emptyList, e5);
                    } catch (RouteException e6) {
                        if (!recover(e6.getLastConnectException(), call, request, false)) {
                            throw Util.withSuppressed(e6.getFirstConnectException(), emptyList);
                        }
                        emptyList = CollectionsKt.plus((Collection<? extends IOException>) emptyList, e6.getFirstConnectException());
                    }
                    call.exitNetworkInterceptorExchange$okhttp(true);
                    z5 = false;
                } catch (Throwable th) {
                    call.exitNetworkInterceptorExchange$okhttp(true);
                    throw th;
                }
            }
            call.exitNetworkInterceptorExchange$okhttp(true);
            request = followUpRequest;
        }
    }
}
