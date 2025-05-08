package coil.network;

import coil.content.Time;
import coil.content.Utils;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000b\fB\u001b\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcoil/network/CacheStrategy;", BuildConfig.FLAVOR, "networkRequest", "Lokhttp3/Request;", "cacheResponse", "Lcoil/network/CacheResponse;", "(Lokhttp3/Request;Lcoil/network/CacheResponse;)V", "getCacheResponse", "()Lcoil/network/CacheResponse;", "getNetworkRequest", "()Lokhttp3/Request;", "Companion", "Factory", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CacheStrategy {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CacheResponse cacheResponse;
    private final Request networkRequest;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0012"}, d2 = {"Lcoil/network/CacheStrategy$Companion;", BuildConfig.FLAVOR, "()V", "combineHeaders", "Lokhttp3/Headers;", "cachedHeaders", "networkHeaders", "isCacheable", BuildConfig.FLAVOR, "request", "Lokhttp3/Request;", "response", "Lcoil/network/CacheResponse;", "Lokhttp3/Response;", "isContentSpecificHeader", "name", BuildConfig.FLAVOR, "isEndToEnd", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean isContentSpecificHeader(String name) {
            return StringsKt.equals("Content-Length", name, true) || StringsKt.equals("Content-Encoding", name, true) || StringsKt.equals("Content-Type", name, true);
        }

        private final boolean isEndToEnd(String name) {
            return (StringsKt.equals("Connection", name, true) || StringsKt.equals("Keep-Alive", name, true) || StringsKt.equals("Proxy-Authenticate", name, true) || StringsKt.equals("Proxy-Authorization", name, true) || StringsKt.equals("TE", name, true) || StringsKt.equals("Trailers", name, true) || StringsKt.equals("Transfer-Encoding", name, true) || StringsKt.equals("Upgrade", name, true)) ? false : true;
        }

        public final Headers combineHeaders(Headers cachedHeaders, Headers networkHeaders) {
            Headers.Builder builder = new Headers.Builder();
            int size = cachedHeaders.size();
            for (int i5 = 0; i5 < size; i5++) {
                String name = cachedHeaders.name(i5);
                String value = cachedHeaders.value(i5);
                if ((!StringsKt.equals("Warning", name, true) || !StringsKt.startsWith$default(value, "1", false, 2, (Object) null)) && (isContentSpecificHeader(name) || !isEndToEnd(name) || networkHeaders.get(name) == null)) {
                    builder.add(name, value);
                }
            }
            int size2 = networkHeaders.size();
            for (int i6 = 0; i6 < size2; i6++) {
                String name2 = networkHeaders.name(i6);
                if (!isContentSpecificHeader(name2) && isEndToEnd(name2)) {
                    builder.add(name2, networkHeaders.value(i6));
                }
            }
            return builder.build();
        }

        public final boolean isCacheable(Request request, Response response) {
            return (request.cacheControl().getNoStore() || response.cacheControl().getNoStore() || Intrinsics.areEqual(response.getHeaders().get("Vary"), "*")) ? false : true;
        }

        private Companion() {
        }

        public final boolean isCacheable(Request request, CacheResponse response) {
            return (request.cacheControl().getNoStore() || response.getCacheControl().getNoStore() || Intrinsics.areEqual(response.getResponseHeaders().get("Vary"), "*")) ? false : true;
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcoil/network/CacheStrategy$Factory;", BuildConfig.FLAVOR, "request", "Lokhttp3/Request;", "cacheResponse", "Lcoil/network/CacheResponse;", "(Lokhttp3/Request;Lcoil/network/CacheResponse;)V", "ageSeconds", BuildConfig.FLAVOR, "etag", BuildConfig.FLAVOR, "expires", "Ljava/util/Date;", "lastModified", "lastModifiedString", "receivedResponseMillis", BuildConfig.FLAVOR, "sentRequestMillis", "servedDate", "servedDateString", "cacheResponseAge", "compute", "Lcoil/network/CacheStrategy;", "computeFreshnessLifetime", "hasConditions", BuildConfig.FLAVOR, "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Factory {
        private int ageSeconds;
        private final CacheResponse cacheResponse;
        private String etag;
        private Date expires;
        private Date lastModified;
        private String lastModifiedString;
        private long receivedResponseMillis;
        private final Request request;
        private long sentRequestMillis;
        private Date servedDate;
        private String servedDateString;

        public Factory(Request request, CacheResponse cacheResponse) {
            this.request = request;
            this.cacheResponse = cacheResponse;
            this.ageSeconds = -1;
            if (cacheResponse != null) {
                this.sentRequestMillis = cacheResponse.getSentRequestAtMillis();
                this.receivedResponseMillis = cacheResponse.getReceivedResponseAtMillis();
                Headers responseHeaders = cacheResponse.getResponseHeaders();
                int size = responseHeaders.size();
                for (int i5 = 0; i5 < size; i5++) {
                    String name = responseHeaders.name(i5);
                    if (StringsKt.equals(name, "Date", true)) {
                        this.servedDate = responseHeaders.getDate("Date");
                        this.servedDateString = responseHeaders.value(i5);
                    } else if (StringsKt.equals(name, "Expires", true)) {
                        this.expires = responseHeaders.getDate("Expires");
                    } else if (StringsKt.equals(name, "Last-Modified", true)) {
                        this.lastModified = responseHeaders.getDate("Last-Modified");
                        this.lastModifiedString = responseHeaders.value(i5);
                    } else if (StringsKt.equals(name, "ETag", true)) {
                        this.etag = responseHeaders.value(i5);
                    } else if (StringsKt.equals(name, "Age", true)) {
                        this.ageSeconds = Utils.toNonNegativeInt(responseHeaders.value(i5), -1);
                    }
                }
            }
        }

        private final long cacheResponseAge() {
            Date date = this.servedDate;
            long max = date != null ? Math.max(0L, this.receivedResponseMillis - date.getTime()) : 0L;
            int i5 = this.ageSeconds;
            if (i5 != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(i5));
            }
            return max + (this.receivedResponseMillis - this.sentRequestMillis) + (Time.INSTANCE.currentMillis() - this.receivedResponseMillis);
        }

        private final long computeFreshnessLifetime() {
            CacheResponse cacheResponse = this.cacheResponse;
            Intrinsics.checkNotNull(cacheResponse);
            if (cacheResponse.getCacheControl().getMaxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.getMaxAgeSeconds());
            }
            Date date = this.expires;
            if (date != null) {
                Date date2 = this.servedDate;
                long time = date.getTime() - (date2 != null ? date2.getTime() : this.receivedResponseMillis);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.lastModified == null || this.request.getUrl().query() != null) {
                return 0L;
            }
            Date date3 = this.servedDate;
            long time2 = date3 != null ? date3.getTime() : this.sentRequestMillis;
            Date date4 = this.lastModified;
            Intrinsics.checkNotNull(date4);
            long time3 = time2 - date4.getTime();
            if (time3 > 0) {
                return time3 / 10;
            }
            return 0L;
        }

        private final boolean hasConditions(Request request) {
            return (request.header("If-Modified-Since") == null && request.header("If-None-Match") == null) ? false : true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final CacheStrategy compute() {
            String str;
            CacheResponse cacheResponse = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            Object[] objArr4 = 0;
            Object[] objArr5 = 0;
            Object[] objArr6 = 0;
            Object[] objArr7 = 0;
            Object[] objArr8 = 0;
            Object[] objArr9 = 0;
            Object[] objArr10 = 0;
            Object[] objArr11 = 0;
            Object[] objArr12 = 0;
            if (this.cacheResponse == null) {
                return new CacheStrategy(this.request, cacheResponse, objArr12 == true ? 1 : 0);
            }
            if (this.request.isHttps() && !this.cacheResponse.getIsTls()) {
                return new CacheStrategy(this.request, objArr11 == true ? 1 : 0, objArr10 == true ? 1 : 0);
            }
            CacheControl cacheControl = this.cacheResponse.getCacheControl();
            if (!CacheStrategy.INSTANCE.isCacheable(this.request, this.cacheResponse)) {
                return new CacheStrategy(this.request, objArr9 == true ? 1 : 0, objArr8 == true ? 1 : 0);
            }
            CacheControl cacheControl2 = this.request.cacheControl();
            if (cacheControl2.getNoCache() || hasConditions(this.request)) {
                return new CacheStrategy(this.request, objArr2 == true ? 1 : 0, objArr == true ? 1 : 0);
            }
            long cacheResponseAge = cacheResponseAge();
            long computeFreshnessLifetime = computeFreshnessLifetime();
            if (cacheControl2.getMaxAgeSeconds() != -1) {
                computeFreshnessLifetime = Math.min(computeFreshnessLifetime, TimeUnit.SECONDS.toMillis(cacheControl2.getMaxAgeSeconds()));
            }
            long j5 = 0;
            long millis = cacheControl2.getMinFreshSeconds() != -1 ? TimeUnit.SECONDS.toMillis(cacheControl2.getMinFreshSeconds()) : 0L;
            if (!cacheControl.getMustRevalidate() && cacheControl2.getMaxStaleSeconds() != -1) {
                j5 = TimeUnit.SECONDS.toMillis(cacheControl2.getMaxStaleSeconds());
            }
            if (!cacheControl.getNoCache() && cacheResponseAge + millis < computeFreshnessLifetime + j5) {
                return new CacheStrategy(objArr7 == true ? 1 : 0, this.cacheResponse, objArr6 == true ? 1 : 0);
            }
            String str2 = this.etag;
            if (str2 != null) {
                Intrinsics.checkNotNull(str2);
                str = "If-None-Match";
            } else {
                str = "If-Modified-Since";
                if (this.lastModified != null) {
                    str2 = this.lastModifiedString;
                    Intrinsics.checkNotNull(str2);
                } else {
                    if (this.servedDate == null) {
                        return new CacheStrategy(this.request, objArr4 == true ? 1 : 0, objArr3 == true ? 1 : 0);
                    }
                    str2 = this.servedDateString;
                    Intrinsics.checkNotNull(str2);
                }
            }
            return new CacheStrategy(this.request.newBuilder().addHeader(str, str2).build(), this.cacheResponse, objArr5 == true ? 1 : 0);
        }
    }

    public /* synthetic */ CacheStrategy(Request request, CacheResponse cacheResponse, DefaultConstructorMarker defaultConstructorMarker) {
        this(request, cacheResponse);
    }

    public final CacheResponse getCacheResponse() {
        return this.cacheResponse;
    }

    public final Request getNetworkRequest() {
        return this.networkRequest;
    }

    private CacheStrategy(Request request, CacheResponse cacheResponse) {
        this.networkRequest = request;
        this.cacheResponse = cacheResponse;
    }
}
