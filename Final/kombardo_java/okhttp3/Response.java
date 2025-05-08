package okhttp3;

import dk.molslinjen.domain.model.constants.Constants;
import java.io.Closeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http.HttpHeaders;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001EB}\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001c\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001a\u001a\u00020\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u0013\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0006H\u0016¢\u0006\u0004\b(\u0010)R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010*\u001a\u0004\b\u0003\u0010+R\u0017\u0010\u0005\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u0005\u0010,\u001a\u0004\b\u0005\u0010-R\u0017\u0010\u0007\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\u0007\u0010.\u001a\u0004\b\u0007\u0010)R\u0017\u0010\t\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\t\u0010/\u001a\u0004\b\t\u00100R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0007¢\u0006\f\n\u0004\b\u000b\u00101\u001a\u0004\b\u000b\u00102R\u0017\u0010\r\u001a\u00020\f8\u0007¢\u0006\f\n\u0004\b\r\u00103\u001a\u0004\b\r\u00104R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0007¢\u0006\f\n\u0004\b\u000f\u00105\u001a\u0004\b\u000f\u00106R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\f\n\u0004\b\u0010\u00107\u001a\u0004\b\u0010\u00108R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\f\n\u0004\b\u0011\u00107\u001a\u0004\b\u0011\u00108R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\f\n\u0004\b\u0012\u00107\u001a\u0004\b\u0012\u00108R\u0017\u0010\u0014\u001a\u00020\u00138\u0007¢\u0006\f\n\u0004\b\u0014\u00109\u001a\u0004\b\u0014\u0010:R\u0017\u0010\u0015\u001a\u00020\u00138\u0007¢\u0006\f\n\u0004\b\u0015\u00109\u001a\u0004\b\u0015\u0010:R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0017\u0010;\u001a\u0004\b\u0017\u0010<R\u0018\u0010>\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0011\u0010A\u001a\u00020@8F¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0011\u0010C\u001a\u00020=8G¢\u0006\u0006\u001a\u0004\bC\u0010D¨\u0006F"}, d2 = {"Lokhttp3/Response;", "Ljava/io/Closeable;", "Lokhttp3/Request;", "request", "Lokhttp3/Protocol;", "protocol", BuildConfig.FLAVOR, "message", BuildConfig.FLAVOR, "code", "Lokhttp3/Handshake;", "handshake", "Lokhttp3/Headers;", "headers", "Lokhttp3/ResponseBody;", Constants.IntentExtra.PushBody, "networkResponse", "cacheResponse", "priorResponse", BuildConfig.FLAVOR, "sentRequestAtMillis", "receivedResponseAtMillis", "Lokhttp3/internal/connection/Exchange;", "exchange", "<init>", "(Lokhttp3/Request;Lokhttp3/Protocol;Ljava/lang/String;ILokhttp3/Handshake;Lokhttp3/Headers;Lokhttp3/ResponseBody;Lokhttp3/Response;Lokhttp3/Response;Lokhttp3/Response;JJLokhttp3/internal/connection/Exchange;)V", "name", "defaultValue", "header", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lokhttp3/Response$Builder;", "newBuilder", "()Lokhttp3/Response$Builder;", BuildConfig.FLAVOR, "Lokhttp3/Challenge;", "challenges", "()Ljava/util/List;", BuildConfig.FLAVOR, "close", "()V", "toString", "()Ljava/lang/String;", "Lokhttp3/Request;", "()Lokhttp3/Request;", "Lokhttp3/Protocol;", "()Lokhttp3/Protocol;", "Ljava/lang/String;", "I", "()I", "Lokhttp3/Handshake;", "()Lokhttp3/Handshake;", "Lokhttp3/Headers;", "()Lokhttp3/Headers;", "Lokhttp3/ResponseBody;", "()Lokhttp3/ResponseBody;", "Lokhttp3/Response;", "()Lokhttp3/Response;", "J", "()J", "Lokhttp3/internal/connection/Exchange;", "()Lokhttp3/internal/connection/Exchange;", "Lokhttp3/CacheControl;", "lazyCacheControl", "Lokhttp3/CacheControl;", BuildConfig.FLAVOR, "isSuccessful", "()Z", "cacheControl", "()Lokhttp3/CacheControl;", "Builder", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Response implements Closeable {
    private final ResponseBody body;
    private final Response cacheResponse;
    private final int code;
    private final Exchange exchange;
    private final Handshake handshake;
    private final Headers headers;
    private CacheControl lazyCacheControl;
    private final String message;
    private final Response networkResponse;
    private final Response priorResponse;
    private final Protocol protocol;
    private final long receivedResponseAtMillis;
    private final Request request;
    private final long sentRequestAtMillis;

    public Response(Request request, Protocol protocol, String message, int i5, Handshake handshake, Headers headers, ResponseBody responseBody, Response response, Response response2, Response response3, long j5, long j6, Exchange exchange) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.request = request;
        this.protocol = protocol;
        this.message = message;
        this.code = i5;
        this.handshake = handshake;
        this.headers = headers;
        this.body = responseBody;
        this.networkResponse = response;
        this.cacheResponse = response2;
        this.priorResponse = response3;
        this.sentRequestAtMillis = j5;
        this.receivedResponseAtMillis = j6;
        this.exchange = exchange;
    }

    public static /* synthetic */ String header$default(Response response, String str, String str2, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str2 = null;
        }
        return response.header(str, str2);
    }

    /* renamed from: body, reason: from getter */
    public final ResponseBody getBody() {
        return this.body;
    }

    public final CacheControl cacheControl() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.INSTANCE.parse(this.headers);
        this.lazyCacheControl = parse;
        return parse;
    }

    /* renamed from: cacheResponse, reason: from getter */
    public final Response getCacheResponse() {
        return this.cacheResponse;
    }

    public final List<Challenge> challenges() {
        String str;
        Headers headers = this.headers;
        int i5 = this.code;
        if (i5 == 401) {
            str = "WWW-Authenticate";
        } else {
            if (i5 != 407) {
                return CollectionsKt.emptyList();
            }
            str = "Proxy-Authenticate";
        }
        return HttpHeaders.parseChallenges(headers, str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ResponseBody responseBody = this.body;
        if (responseBody == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        responseBody.close();
    }

    /* renamed from: code, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: exchange, reason: from getter */
    public final Exchange getExchange() {
        return this.exchange;
    }

    /* renamed from: handshake, reason: from getter */
    public final Handshake getHandshake() {
        return this.handshake;
    }

    public final String header(String name, String defaultValue) {
        Intrinsics.checkNotNullParameter(name, "name");
        String str = this.headers.get(name);
        return str == null ? defaultValue : str;
    }

    /* renamed from: headers, reason: from getter */
    public final Headers getHeaders() {
        return this.headers;
    }

    public final boolean isSuccessful() {
        int i5 = this.code;
        return 200 <= i5 && i5 < 300;
    }

    /* renamed from: message, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: networkResponse, reason: from getter */
    public final Response getNetworkResponse() {
        return this.networkResponse;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    /* renamed from: priorResponse, reason: from getter */
    public final Response getPriorResponse() {
        return this.priorResponse;
    }

    /* renamed from: protocol, reason: from getter */
    public final Protocol getProtocol() {
        return this.protocol;
    }

    /* renamed from: receivedResponseAtMillis, reason: from getter */
    public final long getReceivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    /* renamed from: request, reason: from getter */
    public final Request getRequest() {
        return this.request;
    }

    /* renamed from: sentRequestAtMillis, reason: from getter */
    public final long getSentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.getUrl() + '}';
    }

    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J!\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001c\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001e\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u0019\u0010#\u001a\u00020\u00002\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\u00020\u00002\b\u0010%\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b%\u0010&J\u0019\u0010'\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b'\u0010&J\u0019\u0010(\u001a\u00020\u00002\b\u0010(\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b(\u0010&J\u0017\u0010*\u001a\u00020\u00002\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\u00002\u0006\u0010,\u001a\u00020)H\u0016¢\u0006\u0004\b,\u0010+J\u0017\u00101\u001a\u00020\t2\u0006\u0010.\u001a\u00020-H\u0000¢\u0006\u0004\b/\u00100J\u000f\u00102\u001a\u00020\u0004H\u0016¢\u0006\u0004\b2\u00103R$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000e\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0011\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010\u0014\u001a\u00020\u00138\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010 \u001a\u00020M8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b \u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR$\u0010#\u001a\u0004\u0018\u00010\"8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b#\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR$\u0010%\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b%\u0010X\u001a\u0004\bY\u00103\"\u0004\bZ\u0010\u0006R$\u0010'\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b'\u0010X\u001a\u0004\b[\u00103\"\u0004\b\\\u0010\u0006R$\u0010(\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b(\u0010X\u001a\u0004\b]\u00103\"\u0004\b^\u0010\u0006R\"\u0010*\u001a\u00020)8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b*\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010,\u001a\u00020)8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b,\u0010_\u001a\u0004\bd\u0010a\"\u0004\be\u0010cR$\u0010f\u001a\u0004\u0018\u00010-8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u00100¨\u0006k"}, d2 = {"Lokhttp3/Response$Builder;", BuildConfig.FLAVOR, "<init>", "()V", "Lokhttp3/Response;", "response", "(Lokhttp3/Response;)V", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "checkSupportResponse", "(Ljava/lang/String;Lokhttp3/Response;)V", "checkPriorResponse", "Lokhttp3/Request;", "request", "(Lokhttp3/Request;)Lokhttp3/Response$Builder;", "Lokhttp3/Protocol;", "protocol", "(Lokhttp3/Protocol;)Lokhttp3/Response$Builder;", BuildConfig.FLAVOR, "code", "(I)Lokhttp3/Response$Builder;", "message", "(Ljava/lang/String;)Lokhttp3/Response$Builder;", "Lokhttp3/Handshake;", "handshake", "(Lokhttp3/Handshake;)Lokhttp3/Response$Builder;", "value", "header", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Response$Builder;", "addHeader", "Lokhttp3/Headers;", "headers", "(Lokhttp3/Headers;)Lokhttp3/Response$Builder;", "Lokhttp3/ResponseBody;", Constants.IntentExtra.PushBody, "(Lokhttp3/ResponseBody;)Lokhttp3/Response$Builder;", "networkResponse", "(Lokhttp3/Response;)Lokhttp3/Response$Builder;", "cacheResponse", "priorResponse", BuildConfig.FLAVOR, "sentRequestAtMillis", "(J)Lokhttp3/Response$Builder;", "receivedResponseAtMillis", "Lokhttp3/internal/connection/Exchange;", "deferredTrailers", "initExchange$okhttp", "(Lokhttp3/internal/connection/Exchange;)V", "initExchange", "build", "()Lokhttp3/Response;", "Lokhttp3/Request;", "getRequest$okhttp", "()Lokhttp3/Request;", "setRequest$okhttp", "(Lokhttp3/Request;)V", "Lokhttp3/Protocol;", "getProtocol$okhttp", "()Lokhttp3/Protocol;", "setProtocol$okhttp", "(Lokhttp3/Protocol;)V", "I", "getCode$okhttp", "()I", "setCode$okhttp", "(I)V", "Ljava/lang/String;", "getMessage$okhttp", "()Ljava/lang/String;", "setMessage$okhttp", "(Ljava/lang/String;)V", "Lokhttp3/Handshake;", "getHandshake$okhttp", "()Lokhttp3/Handshake;", "setHandshake$okhttp", "(Lokhttp3/Handshake;)V", "Lokhttp3/Headers$Builder;", "Lokhttp3/Headers$Builder;", "getHeaders$okhttp", "()Lokhttp3/Headers$Builder;", "setHeaders$okhttp", "(Lokhttp3/Headers$Builder;)V", "Lokhttp3/ResponseBody;", "getBody$okhttp", "()Lokhttp3/ResponseBody;", "setBody$okhttp", "(Lokhttp3/ResponseBody;)V", "Lokhttp3/Response;", "getNetworkResponse$okhttp", "setNetworkResponse$okhttp", "getCacheResponse$okhttp", "setCacheResponse$okhttp", "getPriorResponse$okhttp", "setPriorResponse$okhttp", "J", "getSentRequestAtMillis$okhttp", "()J", "setSentRequestAtMillis$okhttp", "(J)V", "getReceivedResponseAtMillis$okhttp", "setReceivedResponseAtMillis$okhttp", "exchange", "Lokhttp3/internal/connection/Exchange;", "getExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "setExchange$okhttp", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static class Builder {
        private ResponseBody body;
        private Response cacheResponse;
        private int code;
        private Exchange exchange;
        private Handshake handshake;
        private Headers.Builder headers;
        private String message;
        private Response networkResponse;
        private Response priorResponse;
        private Protocol protocol;
        private long receivedResponseAtMillis;
        private Request request;
        private long sentRequestAtMillis;

        public Builder() {
            this.code = -1;
            this.headers = new Headers.Builder();
        }

        private final void checkPriorResponse(Response response) {
            if (response != null && response.getBody() != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        private final void checkSupportResponse(String name, Response response) {
            if (response == null) {
                return;
            }
            if (response.getBody() != null) {
                throw new IllegalArgumentException(Intrinsics.stringPlus(name, ".body != null").toString());
            }
            if (response.getNetworkResponse() != null) {
                throw new IllegalArgumentException(Intrinsics.stringPlus(name, ".networkResponse != null").toString());
            }
            if (response.getCacheResponse() != null) {
                throw new IllegalArgumentException(Intrinsics.stringPlus(name, ".cacheResponse != null").toString());
            }
            if (response.getPriorResponse() != null) {
                throw new IllegalArgumentException(Intrinsics.stringPlus(name, ".priorResponse != null").toString());
            }
        }

        public Builder addHeader(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            getHeaders().add(name, value);
            return this;
        }

        public Builder body(ResponseBody body) {
            setBody$okhttp(body);
            return this;
        }

        public Response build() {
            int i5 = this.code;
            if (i5 < 0) {
                throw new IllegalStateException(Intrinsics.stringPlus("code < 0: ", Integer.valueOf(getCode())).toString());
            }
            Request request = this.request;
            if (request == null) {
                throw new IllegalStateException("request == null");
            }
            Protocol protocol = this.protocol;
            if (protocol == null) {
                throw new IllegalStateException("protocol == null");
            }
            String str = this.message;
            if (str != null) {
                return new Response(request, protocol, str, i5, this.handshake, this.headers.build(), this.body, this.networkResponse, this.cacheResponse, this.priorResponse, this.sentRequestAtMillis, this.receivedResponseAtMillis, this.exchange);
            }
            throw new IllegalStateException("message == null");
        }

        public Builder cacheResponse(Response cacheResponse) {
            checkSupportResponse("cacheResponse", cacheResponse);
            setCacheResponse$okhttp(cacheResponse);
            return this;
        }

        public Builder code(int code) {
            setCode$okhttp(code);
            return this;
        }

        /* renamed from: getCode$okhttp, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        /* renamed from: getHeaders$okhttp, reason: from getter */
        public final Headers.Builder getHeaders() {
            return this.headers;
        }

        public Builder handshake(Handshake handshake) {
            setHandshake$okhttp(handshake);
            return this;
        }

        public Builder header(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            getHeaders().set(name, value);
            return this;
        }

        public Builder headers(Headers headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            setHeaders$okhttp(headers.newBuilder());
            return this;
        }

        public final void initExchange$okhttp(Exchange deferredTrailers) {
            Intrinsics.checkNotNullParameter(deferredTrailers, "deferredTrailers");
            this.exchange = deferredTrailers;
        }

        public Builder message(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            setMessage$okhttp(message);
            return this;
        }

        public Builder networkResponse(Response networkResponse) {
            checkSupportResponse("networkResponse", networkResponse);
            setNetworkResponse$okhttp(networkResponse);
            return this;
        }

        public Builder priorResponse(Response priorResponse) {
            checkPriorResponse(priorResponse);
            setPriorResponse$okhttp(priorResponse);
            return this;
        }

        public Builder protocol(Protocol protocol) {
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            setProtocol$okhttp(protocol);
            return this;
        }

        public Builder receivedResponseAtMillis(long receivedResponseAtMillis) {
            setReceivedResponseAtMillis$okhttp(receivedResponseAtMillis);
            return this;
        }

        public Builder request(Request request) {
            Intrinsics.checkNotNullParameter(request, "request");
            setRequest$okhttp(request);
            return this;
        }

        public Builder sentRequestAtMillis(long sentRequestAtMillis) {
            setSentRequestAtMillis$okhttp(sentRequestAtMillis);
            return this;
        }

        public final void setBody$okhttp(ResponseBody responseBody) {
            this.body = responseBody;
        }

        public final void setCacheResponse$okhttp(Response response) {
            this.cacheResponse = response;
        }

        public final void setCode$okhttp(int i5) {
            this.code = i5;
        }

        public final void setHandshake$okhttp(Handshake handshake) {
            this.handshake = handshake;
        }

        public final void setHeaders$okhttp(Headers.Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "<set-?>");
            this.headers = builder;
        }

        public final void setMessage$okhttp(String str) {
            this.message = str;
        }

        public final void setNetworkResponse$okhttp(Response response) {
            this.networkResponse = response;
        }

        public final void setPriorResponse$okhttp(Response response) {
            this.priorResponse = response;
        }

        public final void setProtocol$okhttp(Protocol protocol) {
            this.protocol = protocol;
        }

        public final void setReceivedResponseAtMillis$okhttp(long j5) {
            this.receivedResponseAtMillis = j5;
        }

        public final void setRequest$okhttp(Request request) {
            this.request = request;
        }

        public final void setSentRequestAtMillis$okhttp(long j5) {
            this.sentRequestAtMillis = j5;
        }

        public Builder(Response response) {
            Intrinsics.checkNotNullParameter(response, "response");
            this.code = -1;
            this.request = response.getRequest();
            this.protocol = response.getProtocol();
            this.code = response.getCode();
            this.message = response.getMessage();
            this.handshake = response.getHandshake();
            this.headers = response.getHeaders().newBuilder();
            this.body = response.getBody();
            this.networkResponse = response.getNetworkResponse();
            this.cacheResponse = response.getCacheResponse();
            this.priorResponse = response.getPriorResponse();
            this.sentRequestAtMillis = response.getSentRequestAtMillis();
            this.receivedResponseAtMillis = response.getReceivedResponseAtMillis();
            this.exchange = response.getExchange();
        }
    }
}
