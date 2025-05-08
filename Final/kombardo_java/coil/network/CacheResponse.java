package coil.network;

import coil.content.Utils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Response;
import okio.BufferedSink;
import okio.BufferedSource;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#R\u001b\u0010\b\u001a\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019¨\u0006$"}, d2 = {"Lcoil/network/CacheResponse;", BuildConfig.FLAVOR, "source", "Lokio/BufferedSource;", "(Lokio/BufferedSource;)V", "response", "Lokhttp3/Response;", "(Lokhttp3/Response;)V", "cacheControl", "Lokhttp3/CacheControl;", "getCacheControl", "()Lokhttp3/CacheControl;", "cacheControl$delegate", "Lkotlin/Lazy;", "contentType", "Lokhttp3/MediaType;", "getContentType", "()Lokhttp3/MediaType;", "contentType$delegate", "isTls", BuildConfig.FLAVOR, "()Z", "receivedResponseAtMillis", BuildConfig.FLAVOR, "getReceivedResponseAtMillis", "()J", "responseHeaders", "Lokhttp3/Headers;", "getResponseHeaders", "()Lokhttp3/Headers;", "sentRequestAtMillis", "getSentRequestAtMillis", "writeTo", BuildConfig.FLAVOR, "sink", "Lokio/BufferedSink;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CacheResponse {

    /* renamed from: cacheControl$delegate, reason: from kotlin metadata */
    private final Lazy cacheControl;

    /* renamed from: contentType$delegate, reason: from kotlin metadata */
    private final Lazy contentType;
    private final boolean isTls;
    private final long receivedResponseAtMillis;
    private final Headers responseHeaders;
    private final long sentRequestAtMillis;

    public CacheResponse(BufferedSource bufferedSource) {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.cacheControl = LazyKt.lazy(lazyThreadSafetyMode, new Function0<CacheControl>() { // from class: coil.network.CacheResponse$cacheControl$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CacheControl invoke() {
                return CacheControl.INSTANCE.parse(CacheResponse.this.getResponseHeaders());
            }
        });
        this.contentType = LazyKt.lazy(lazyThreadSafetyMode, new Function0<MediaType>() { // from class: coil.network.CacheResponse$contentType$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final MediaType invoke() {
                String str = CacheResponse.this.getResponseHeaders().get("Content-Type");
                if (str != null) {
                    return MediaType.INSTANCE.parse(str);
                }
                return null;
            }
        });
        this.sentRequestAtMillis = Long.parseLong(bufferedSource.readUtf8LineStrict());
        this.receivedResponseAtMillis = Long.parseLong(bufferedSource.readUtf8LineStrict());
        this.isTls = Integer.parseInt(bufferedSource.readUtf8LineStrict()) > 0;
        int parseInt = Integer.parseInt(bufferedSource.readUtf8LineStrict());
        Headers.Builder builder = new Headers.Builder();
        for (int i5 = 0; i5 < parseInt; i5++) {
            Utils.addUnsafeNonAscii(builder, bufferedSource.readUtf8LineStrict());
        }
        this.responseHeaders = builder.build();
    }

    public final CacheControl getCacheControl() {
        return (CacheControl) this.cacheControl.getValue();
    }

    public final MediaType getContentType() {
        return (MediaType) this.contentType.getValue();
    }

    public final long getReceivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    public final Headers getResponseHeaders() {
        return this.responseHeaders;
    }

    public final long getSentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    /* renamed from: isTls, reason: from getter */
    public final boolean getIsTls() {
        return this.isTls;
    }

    public final void writeTo(BufferedSink sink) {
        sink.writeDecimalLong(this.sentRequestAtMillis).writeByte(10);
        sink.writeDecimalLong(this.receivedResponseAtMillis).writeByte(10);
        sink.writeDecimalLong(this.isTls ? 1L : 0L).writeByte(10);
        sink.writeDecimalLong(this.responseHeaders.size()).writeByte(10);
        int size = this.responseHeaders.size();
        for (int i5 = 0; i5 < size; i5++) {
            sink.writeUtf8(this.responseHeaders.name(i5)).writeUtf8(": ").writeUtf8(this.responseHeaders.value(i5)).writeByte(10);
        }
    }

    public CacheResponse(Response response) {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.cacheControl = LazyKt.lazy(lazyThreadSafetyMode, new Function0<CacheControl>() { // from class: coil.network.CacheResponse$cacheControl$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CacheControl invoke() {
                return CacheControl.INSTANCE.parse(CacheResponse.this.getResponseHeaders());
            }
        });
        this.contentType = LazyKt.lazy(lazyThreadSafetyMode, new Function0<MediaType>() { // from class: coil.network.CacheResponse$contentType$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final MediaType invoke() {
                String str = CacheResponse.this.getResponseHeaders().get("Content-Type");
                if (str != null) {
                    return MediaType.INSTANCE.parse(str);
                }
                return null;
            }
        });
        this.sentRequestAtMillis = response.getSentRequestAtMillis();
        this.receivedResponseAtMillis = response.getReceivedResponseAtMillis();
        this.isTls = response.getHandshake() != null;
        this.responseHeaders = response.getHeaders();
    }
}
