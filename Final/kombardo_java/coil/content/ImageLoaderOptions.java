package coil.content;

import coil.decode.ExifOrientationPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\u000f\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcoil/util/ImageLoaderOptions;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "addLastModifiedToFileCacheKey", "networkObserverEnabled", "respectCacheHeaders", BuildConfig.FLAVOR, "bitmapFactoryMaxParallelism", "Lcoil/decode/ExifOrientationPolicy;", "bitmapFactoryExifOrientationPolicy", "<init>", "(ZZZILcoil/decode/ExifOrientationPolicy;)V", "Z", "getAddLastModifiedToFileCacheKey", "()Z", "getNetworkObserverEnabled", "getRespectCacheHeaders", "I", "getBitmapFactoryMaxParallelism", "()I", "Lcoil/decode/ExifOrientationPolicy;", "getBitmapFactoryExifOrientationPolicy", "()Lcoil/decode/ExifOrientationPolicy;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ImageLoaderOptions {
    private final boolean addLastModifiedToFileCacheKey;
    private final ExifOrientationPolicy bitmapFactoryExifOrientationPolicy;
    private final int bitmapFactoryMaxParallelism;
    private final boolean networkObserverEnabled;
    private final boolean respectCacheHeaders;

    public ImageLoaderOptions(boolean z5, boolean z6, boolean z7, int i5, ExifOrientationPolicy exifOrientationPolicy) {
        this.addLastModifiedToFileCacheKey = z5;
        this.networkObserverEnabled = z6;
        this.respectCacheHeaders = z7;
        this.bitmapFactoryMaxParallelism = i5;
        this.bitmapFactoryExifOrientationPolicy = exifOrientationPolicy;
    }

    public final boolean getAddLastModifiedToFileCacheKey() {
        return this.addLastModifiedToFileCacheKey;
    }

    public final ExifOrientationPolicy getBitmapFactoryExifOrientationPolicy() {
        return this.bitmapFactoryExifOrientationPolicy;
    }

    public final int getBitmapFactoryMaxParallelism() {
        return this.bitmapFactoryMaxParallelism;
    }

    public final boolean getNetworkObserverEnabled() {
        return this.networkObserverEnabled;
    }

    public final boolean getRespectCacheHeaders() {
        return this.respectCacheHeaders;
    }

    public /* synthetic */ ImageLoaderOptions(boolean z5, boolean z6, boolean z7, int i5, ExifOrientationPolicy exifOrientationPolicy, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? true : z5, (i6 & 2) != 0 ? true : z6, (i6 & 4) == 0 ? z7 : true, (i6 & 8) != 0 ? 4 : i5, (i6 & 16) != 0 ? ExifOrientationPolicy.RESPECT_PERFORMANCE : exifOrientationPolicy);
    }
}
