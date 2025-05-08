package okhttp3.internal.cache;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.connection.RealCall;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/cache/CacheInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Cache;", "cache", "<init>", "(Lokhttp3/Cache;)V", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Lokhttp3/Cache;", "getCache$okhttp", "()Lokhttp3/Cache;", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CacheInterceptor implements Interceptor {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Cache cache;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/cache/CacheInterceptor$Companion;", BuildConfig.FLAVOR, "()V", "combine", "Lokhttp3/Headers;", "cachedHeaders", "networkHeaders", "isContentSpecificHeader", BuildConfig.FLAVOR, "fieldName", BuildConfig.FLAVOR, "isEndToEnd", "stripBody", "Lokhttp3/Response;", "response", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Headers combine(Headers cachedHeaders, Headers networkHeaders) {
            Headers.Builder builder = new Headers.Builder();
            int size = cachedHeaders.size();
            int i5 = 0;
            int i6 = 0;
            while (i6 < size) {
                int i7 = i6 + 1;
                String name = cachedHeaders.name(i6);
                String value = cachedHeaders.value(i6);
                if ((!StringsKt.equals("Warning", name, true) || !StringsKt.startsWith$default(value, "1", false, 2, (Object) null)) && (isContentSpecificHeader(name) || !isEndToEnd(name) || networkHeaders.get(name) == null)) {
                    builder.addLenient$okhttp(name, value);
                }
                i6 = i7;
            }
            int size2 = networkHeaders.size();
            while (i5 < size2) {
                int i8 = i5 + 1;
                String name2 = networkHeaders.name(i5);
                if (!isContentSpecificHeader(name2) && isEndToEnd(name2)) {
                    builder.addLenient$okhttp(name2, networkHeaders.value(i5));
                }
                i5 = i8;
            }
            return builder.build();
        }

        private final boolean isContentSpecificHeader(String fieldName) {
            return StringsKt.equals("Content-Length", fieldName, true) || StringsKt.equals("Content-Encoding", fieldName, true) || StringsKt.equals("Content-Type", fieldName, true);
        }

        private final boolean isEndToEnd(String fieldName) {
            return (StringsKt.equals("Connection", fieldName, true) || StringsKt.equals("Keep-Alive", fieldName, true) || StringsKt.equals("Proxy-Authenticate", fieldName, true) || StringsKt.equals("Proxy-Authorization", fieldName, true) || StringsKt.equals("TE", fieldName, true) || StringsKt.equals("Trailers", fieldName, true) || StringsKt.equals("Transfer-Encoding", fieldName, true) || StringsKt.equals("Upgrade", fieldName, true)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Response stripBody(Response response) {
            return (response == null ? null : response.getBody()) != null ? response.newBuilder().body(null).build() : response;
        }

        private Companion() {
        }
    }

    public CacheInterceptor(Cache cache) {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Call call = chain.call();
        CacheStrategy compute = new CacheStrategy.Factory(System.currentTimeMillis(), chain.request(), null).compute();
        Request networkRequest = compute.getNetworkRequest();
        Response cacheResponse = compute.getCacheResponse();
        RealCall realCall = call instanceof RealCall ? (RealCall) call : null;
        EventListener eventListener = realCall == null ? null : realCall.getEventListener();
        if (eventListener == null) {
            eventListener = EventListener.NONE;
        }
        if (networkRequest == null && cacheResponse == null) {
            Response build = new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(System.currentTimeMillis()).build();
            eventListener.satisfactionFailure(call, build);
            return build;
        }
        if (networkRequest == null) {
            Intrinsics.checkNotNull(cacheResponse);
            Response build2 = cacheResponse.newBuilder().cacheResponse(INSTANCE.stripBody(cacheResponse)).build();
            eventListener.cacheHit(call, build2);
            return build2;
        }
        if (cacheResponse != null) {
            eventListener.cacheConditionalHit(call, cacheResponse);
        }
        Response proceed = chain.proceed(networkRequest);
        if (cacheResponse != null) {
            if (proceed != null && proceed.getCode() == 304) {
                Response.Builder newBuilder = cacheResponse.newBuilder();
                Companion companion = INSTANCE;
                newBuilder.headers(companion.combine(cacheResponse.getHeaders(), proceed.getHeaders())).sentRequestAtMillis(proceed.getSentRequestAtMillis()).receivedResponseAtMillis(proceed.getReceivedResponseAtMillis()).cacheResponse(companion.stripBody(cacheResponse)).networkResponse(companion.stripBody(proceed)).build();
                ResponseBody body = proceed.getBody();
                Intrinsics.checkNotNull(body);
                body.close();
                Intrinsics.checkNotNull(null);
                throw null;
            }
            ResponseBody body2 = cacheResponse.getBody();
            if (body2 != null) {
                Util.closeQuietly(body2);
            }
        }
        Intrinsics.checkNotNull(proceed);
        Response.Builder newBuilder2 = proceed.newBuilder();
        Companion companion2 = INSTANCE;
        return newBuilder2.cacheResponse(companion2.stripBody(cacheResponse)).networkResponse(companion2.stripBody(proceed)).build();
    }
}
