package coil.memory;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.a;
import coil.EventListener;
import coil.ImageLoader;
import coil.content.Bitmaps;
import coil.content.Logger;
import coil.content.Requests;
import coil.content.Utils;
import coil.decode.DataSource;
import coil.decode.DecodeUtils;
import coil.intercept.EngineInterceptor;
import coil.intercept.Interceptor;
import coil.memory.MemoryCache;
import coil.request.ImageRequest;
import coil.request.Options;
import coil.request.RequestService;
import coil.request.SuccessResult;
import coil.size.Dimension;
import coil.size.Scale;
import coil.size.Size;
import coil.size.Sizes;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001+B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ(\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J5\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\b\u001cJ0\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J(\u0010\u001e\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J&\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u000bJ \u0010(\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010¨\u0006,"}, d2 = {"Lcoil/memory/MemoryCacheService;", BuildConfig.FLAVOR, "imageLoader", "Lcoil/ImageLoader;", "requestService", "Lcoil/request/RequestService;", "logger", "Lcoil/util/Logger;", "(Lcoil/ImageLoader;Lcoil/request/RequestService;Lcoil/util/Logger;)V", "diskCacheKey", BuildConfig.FLAVOR, "Lcoil/memory/MemoryCache$Value;", "getDiskCacheKey", "(Lcoil/memory/MemoryCache$Value;)Ljava/lang/String;", "isSampled", BuildConfig.FLAVOR, "(Lcoil/memory/MemoryCache$Value;)Z", "getCacheValue", "request", "Lcoil/request/ImageRequest;", "cacheKey", "Lcoil/memory/MemoryCache$Key;", "size", "Lcoil/size/Size;", "scale", "Lcoil/size/Scale;", "isCacheValueValid", "cacheValue", "isCacheValueValid$coil_base_release", "isSizeValid", "newCacheKey", "mappedData", "options", "Lcoil/request/Options;", "eventListener", "Lcoil/EventListener;", "newResult", "Lcoil/request/SuccessResult;", "chain", "Lcoil/intercept/Interceptor$Chain;", "setCacheValue", "result", "Lcoil/intercept/EngineInterceptor$ExecuteResult;", "Companion", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MemoryCacheService {
    private static final String TAG = "MemoryCacheService";
    private final ImageLoader imageLoader;
    private final Logger logger;
    private final RequestService requestService;

    public MemoryCacheService(ImageLoader imageLoader, RequestService requestService, Logger logger) {
        this.imageLoader = imageLoader;
        this.requestService = requestService;
        this.logger = logger;
    }

    private final String getDiskCacheKey(MemoryCache.Value value) {
        Object obj = value.getExtras().get("coil#disk_cache_key");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    private final boolean isSampled(MemoryCache.Value value) {
        Object obj = value.getExtras().get("coil#is_sampled");
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private final boolean isSizeValid(ImageRequest request, MemoryCache.Key cacheKey, MemoryCache.Value cacheValue, Size size, Scale scale) {
        String str;
        boolean isSampled = isSampled(cacheValue);
        if (Sizes.isOriginal(size)) {
            if (!isSampled) {
                return true;
            }
            Logger logger = this.logger;
            if (logger != null && logger.getLevel() <= 3) {
                logger.log(TAG, 3, request.getData() + ": Requested original size, but cached image is sampled.", null);
            }
            return false;
        }
        String str2 = cacheKey.getExtras().get("coil#transformation_size");
        if (str2 != null) {
            return Intrinsics.areEqual(str2, size.toString());
        }
        int width = cacheValue.getBitmap().getWidth();
        int height = cacheValue.getBitmap().getHeight();
        Dimension width2 = size.getWidth();
        int i5 = width2 instanceof Dimension.Pixels ? ((Dimension.Pixels) width2).px : Integer.MAX_VALUE;
        Dimension height2 = size.getHeight();
        int i6 = height2 instanceof Dimension.Pixels ? ((Dimension.Pixels) height2).px : Integer.MAX_VALUE;
        double computeSizeMultiplier = DecodeUtils.computeSizeMultiplier(width, height, i5, i6, scale);
        boolean allowInexactSize = Requests.getAllowInexactSize(request);
        if (allowInexactSize) {
            double coerceAtMost = RangesKt.coerceAtMost(computeSizeMultiplier, 1.0d);
            str = TAG;
            if (Math.abs(i5 - (width * coerceAtMost)) <= 1.0d || Math.abs(i6 - (coerceAtMost * height)) <= 1.0d) {
                return true;
            }
        } else {
            str = TAG;
            if ((Utils.isMinOrMax(i5) || Math.abs(i5 - width) <= 1) && (Utils.isMinOrMax(i6) || Math.abs(i6 - height) <= 1)) {
                return true;
            }
        }
        if (computeSizeMultiplier != 1.0d && !allowInexactSize) {
            Logger logger2 = this.logger;
            if (logger2 == null || logger2.getLevel() > 3) {
                return false;
            }
            logger2.log(str, 3, request.getData() + ": Cached image's request size (" + width + ", " + height + ") does not exactly match the requested size (" + size.getWidth() + ", " + size.getHeight() + ", " + scale + ").", null);
            return false;
        }
        String str3 = str;
        if (computeSizeMultiplier <= 1.0d || !isSampled) {
            return true;
        }
        Logger logger3 = this.logger;
        if (logger3 == null || logger3.getLevel() > 3) {
            return false;
        }
        logger3.log(str3, 3, request.getData() + ": Cached image's request size (" + width + ", " + height + ") is smaller than the requested size (" + size.getWidth() + ", " + size.getHeight() + ", " + scale + ").", null);
        return false;
    }

    public final MemoryCache.Value getCacheValue(ImageRequest request, MemoryCache.Key cacheKey, Size size, Scale scale) {
        if (!request.getMemoryCachePolicy().getReadEnabled()) {
            return null;
        }
        MemoryCache memoryCache = this.imageLoader.getMemoryCache();
        MemoryCache.Value value = memoryCache != null ? memoryCache.get(cacheKey) : null;
        if (value == null || !isCacheValueValid$coil_base_release(request, cacheKey, value, size, scale)) {
            return null;
        }
        return value;
    }

    public final boolean isCacheValueValid$coil_base_release(ImageRequest request, MemoryCache.Key cacheKey, MemoryCache.Value cacheValue, Size size, Scale scale) {
        if (this.requestService.isConfigValidForHardware(request, Bitmaps.getSafeConfig(cacheValue.getBitmap()))) {
            return isSizeValid(request, cacheKey, cacheValue, size, scale);
        }
        Logger logger = this.logger;
        if (logger == null || logger.getLevel() > 3) {
            return false;
        }
        logger.log(TAG, 3, request.getData() + ": Cached bitmap is hardware-backed, which is incompatible with the request.", null);
        return false;
    }

    public final MemoryCache.Key newCacheKey(ImageRequest request, Object mappedData, Options options, EventListener eventListener) {
        MemoryCache.Key memoryCacheKey = request.getMemoryCacheKey();
        if (memoryCacheKey != null) {
            return memoryCacheKey;
        }
        eventListener.keyStart(request, mappedData);
        String key = this.imageLoader.getComponents().key(mappedData, options);
        eventListener.keyEnd(request, key);
        if (key == null) {
            return null;
        }
        List<Object> transformations = request.getTransformations();
        Map<String, String> memoryCacheKeys = request.getParameters().memoryCacheKeys();
        if (transformations.isEmpty() && memoryCacheKeys.isEmpty()) {
            return new MemoryCache.Key(key, null, 2, null);
        }
        Map mutableMap = MapsKt.toMutableMap(memoryCacheKeys);
        if (!transformations.isEmpty()) {
            List<Object> transformations2 = request.getTransformations();
            if (transformations2.size() > 0) {
                a.a(transformations2.get(0));
                StringBuilder sb = new StringBuilder();
                sb.append("coil#transformation_");
                sb.append(0);
                throw null;
            }
            mutableMap.put("coil#transformation_size", options.getSize().toString());
        }
        return new MemoryCache.Key(key, mutableMap);
    }

    public final SuccessResult newResult(Interceptor.Chain chain, ImageRequest request, MemoryCache.Key cacheKey, MemoryCache.Value cacheValue) {
        return new SuccessResult(new BitmapDrawable(request.getContext().getResources(), cacheValue.getBitmap()), request, DataSource.MEMORY_CACHE, cacheKey, getDiskCacheKey(cacheValue), isSampled(cacheValue), Utils.isPlaceholderCached(chain));
    }

    public final boolean setCacheValue(MemoryCache.Key cacheKey, ImageRequest request, EngineInterceptor.ExecuteResult result) {
        MemoryCache memoryCache;
        Bitmap bitmap;
        if (request.getMemoryCachePolicy().getWriteEnabled() && (memoryCache = this.imageLoader.getMemoryCache()) != null && cacheKey != null) {
            Drawable drawable = result.getDrawable();
            BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
            if (bitmapDrawable != null && (bitmap = bitmapDrawable.getBitmap()) != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("coil#is_sampled", Boolean.valueOf(result.getIsSampled()));
                String diskCacheKey = result.getDiskCacheKey();
                if (diskCacheKey != null) {
                    linkedHashMap.put("coil#disk_cache_key", diskCacheKey);
                }
                memoryCache.set(cacheKey, new MemoryCache.Value(bitmap, linkedHashMap));
                return true;
            }
        }
        return false;
    }
}
