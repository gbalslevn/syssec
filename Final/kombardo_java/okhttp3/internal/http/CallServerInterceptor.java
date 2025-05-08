package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http2.ConnectionShutdownException;
import okio.BufferedSink;
import okio.Okio;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lokhttp3/internal/http/CallServerInterceptor;", "Lokhttp3/Interceptor;", "forWebSocket", BuildConfig.FLAVOR, "(Z)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "shouldIgnoreAndWaitForRealResponse", "code", BuildConfig.FLAVOR, "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean z5) {
        this.forWebSocket = z5;
    }

    private final boolean shouldIgnoreAndWaitForRealResponse(int code) {
        if (code == 100) {
            return true;
        }
        return 102 <= code && code < 200;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e5 A[Catch: IOException -> 0x00b8, TryCatch #2 {IOException -> 0x00b8, blocks: (B:65:0x00aa, B:67:0x00b3, B:22:0x00bb, B:24:0x00e5, B:26:0x00ee, B:27:0x00f1, B:28:0x0115, B:32:0x0120, B:33:0x013f, B:35:0x014d, B:43:0x0163, B:48:0x0176, B:51:0x0199, B:52:0x01a3, B:60:0x0191, B:61:0x016c, B:62:0x0158, B:63:0x012f), top: B:64:0x00aa }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0176 A[Catch: IOException -> 0x00b8, TryCatch #2 {IOException -> 0x00b8, blocks: (B:65:0x00aa, B:67:0x00b3, B:22:0x00bb, B:24:0x00e5, B:26:0x00ee, B:27:0x00f1, B:28:0x0115, B:32:0x0120, B:33:0x013f, B:35:0x014d, B:43:0x0163, B:48:0x0176, B:51:0x0199, B:52:0x01a3, B:60:0x0191, B:61:0x016c, B:62:0x0158, B:63:0x012f), top: B:64:0x00aa }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x016c A[Catch: IOException -> 0x00b8, TryCatch #2 {IOException -> 0x00b8, blocks: (B:65:0x00aa, B:67:0x00b3, B:22:0x00bb, B:24:0x00e5, B:26:0x00ee, B:27:0x00f1, B:28:0x0115, B:32:0x0120, B:33:0x013f, B:35:0x014d, B:43:0x0163, B:48:0x0176, B:51:0x0199, B:52:0x01a3, B:60:0x0191, B:61:0x016c, B:62:0x0158, B:63:0x012f), top: B:64:0x00aa }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response intercept(Interceptor.Chain chain) {
        boolean z5;
        Response.Builder builder;
        Response.Builder builder2;
        int code;
        Response build;
        ResponseBody body;
        Response.Builder builder3;
        Intrinsics.checkNotNullParameter(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Exchange exchange = realInterceptorChain.getExchange();
        Intrinsics.checkNotNull(exchange);
        Request request = realInterceptorChain.getRequest();
        RequestBody body2 = request.getBody();
        long currentTimeMillis = System.currentTimeMillis();
        Long l5 = null;
        try {
            exchange.writeRequestHeaders(request);
            ?? permitsRequestBody = HttpMethod.permitsRequestBody(request.getMethod());
            try {
                if (permitsRequestBody == 0 || body2 == null) {
                    exchange.noRequestBody();
                    z5 = true;
                    permitsRequestBody = 0;
                } else {
                    if (StringsKt.equals("100-continue", request.header("Expect"), true)) {
                        exchange.flushRequest();
                        Response.Builder readResponseHeaders = exchange.readResponseHeaders(true);
                        try {
                            exchange.responseHeadersStart();
                            z5 = false;
                            builder3 = readResponseHeaders;
                        } catch (IOException e5) {
                            e = e5;
                            z5 = true;
                            builder = readResponseHeaders;
                            if (e instanceof ConnectionShutdownException) {
                                throw e;
                            }
                            builder2 = builder;
                            if (!exchange.getHasFailure()) {
                                throw e;
                            }
                            if (builder2 == null) {
                            }
                            Response build2 = builder2.request(request).handshake(exchange.getConnection().getHandshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
                            code = build2.getCode();
                            if (shouldIgnoreAndWaitForRealResponse(code)) {
                            }
                            exchange.responseHeadersEnd(build2);
                            if (this.forWebSocket) {
                            }
                            if (!StringsKt.equals("close", build.getRequest().header("Connection"), true)) {
                            }
                            exchange.noNewExchangesOnConnection();
                            if (code != 204) {
                            }
                            body = build.getBody();
                            if ((body != null ? -1L : body.getContentLength()) > 0) {
                            }
                            return build;
                        }
                    } else {
                        z5 = true;
                        builder3 = null;
                    }
                    if (builder3 != null) {
                        exchange.noRequestBody();
                        permitsRequestBody = builder3;
                        if (!exchange.getConnection().isMultiplexed$okhttp()) {
                            exchange.noNewExchangesOnConnection();
                            permitsRequestBody = builder3;
                        }
                    } else if (body2.isDuplex()) {
                        exchange.flushRequest();
                        body2.writeTo(Okio.buffer(exchange.createRequestBody(request, true)));
                        permitsRequestBody = builder3;
                    } else {
                        BufferedSink buffer = Okio.buffer(exchange.createRequestBody(request, false));
                        body2.writeTo(buffer);
                        buffer.close();
                        permitsRequestBody = builder3;
                    }
                }
                if (body2 == null || !body2.isDuplex()) {
                    exchange.finishRequest();
                }
                e = null;
                builder2 = permitsRequestBody;
            } catch (IOException e6) {
                e = e6;
                builder = permitsRequestBody;
            }
        } catch (IOException e7) {
            e = e7;
            z5 = true;
            builder = null;
        }
        if (builder2 == null) {
            try {
                builder2 = exchange.readResponseHeaders(false);
                Intrinsics.checkNotNull(builder2);
                if (z5) {
                    exchange.responseHeadersStart();
                    z5 = false;
                }
            } catch (IOException e8) {
                if (e == null) {
                    throw e8;
                }
                ExceptionsKt.addSuppressed(e, e8);
                throw e;
            }
        }
        Response build22 = builder2.request(request).handshake(exchange.getConnection().getHandshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
        code = build22.getCode();
        if (shouldIgnoreAndWaitForRealResponse(code)) {
            Response.Builder readResponseHeaders2 = exchange.readResponseHeaders(false);
            Intrinsics.checkNotNull(readResponseHeaders2);
            if (z5) {
                exchange.responseHeadersStart();
            }
            build22 = readResponseHeaders2.request(request).handshake(exchange.getConnection().getHandshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
            code = build22.getCode();
        }
        exchange.responseHeadersEnd(build22);
        build = (this.forWebSocket || code != 101) ? build22.newBuilder().body(exchange.openResponseBody(build22)).build() : build22.newBuilder().body(Util.EMPTY_RESPONSE).build();
        if (!StringsKt.equals("close", build.getRequest().header("Connection"), true) || StringsKt.equals("close", Response.header$default(build, "Connection", null, 2, null), true)) {
            exchange.noNewExchangesOnConnection();
        }
        if (code != 204 || code == 205) {
            body = build.getBody();
            if ((body != null ? -1L : body.getContentLength()) > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("HTTP ");
                sb.append(code);
                sb.append(" had non-zero Content-Length: ");
                ResponseBody body3 = build.getBody();
                if (body3 != null) {
                    l5 = Long.valueOf(body3.getContentLength());
                }
                sb.append(l5);
                throw new ProtocolException(sb.toString());
            }
        }
        return build;
    }
}
