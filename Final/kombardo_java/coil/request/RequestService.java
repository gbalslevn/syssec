package coil.request;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.lifecycle.Lifecycle;
import coil.ImageLoader;
import coil.content.Bitmaps;
import coil.content.HardwareBitmapService;
import coil.content.HardwareBitmaps;
import coil.content.Logger;
import coil.content.Requests;
import coil.content.SystemCallbacks;
import coil.content.Utils;
import coil.size.Dimension;
import coil.size.Scale;
import coil.size.Size;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcoil/request/RequestService;", BuildConfig.FLAVOR, "imageLoader", "Lcoil/ImageLoader;", "systemCallbacks", "Lcoil/util/SystemCallbacks;", "logger", "Lcoil/util/Logger;", "(Lcoil/ImageLoader;Lcoil/util/SystemCallbacks;Lcoil/util/Logger;)V", "hardwareBitmapService", "Lcoil/util/HardwareBitmapService;", "allowHardwareWorkerThread", BuildConfig.FLAVOR, "options", "Lcoil/request/Options;", "errorResult", "Lcoil/request/ErrorResult;", "request", "Lcoil/request/ImageRequest;", "throwable", BuildConfig.FLAVOR, "isConfigValidForHardware", "requestedConfig", "Landroid/graphics/Bitmap$Config;", "isConfigValidForHardwareAllocation", "size", "Lcoil/size/Size;", "isConfigValidForTransformations", "requestDelegate", "Lcoil/request/RequestDelegate;", "initialRequest", "job", "Lkotlinx/coroutines/Job;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RequestService {
    private final HardwareBitmapService hardwareBitmapService;
    private final ImageLoader imageLoader;
    private final SystemCallbacks systemCallbacks;

    public RequestService(ImageLoader imageLoader, SystemCallbacks systemCallbacks, Logger logger) {
        this.imageLoader = imageLoader;
        this.systemCallbacks = systemCallbacks;
        this.hardwareBitmapService = HardwareBitmaps.HardwareBitmapService(logger);
    }

    private final boolean isConfigValidForHardwareAllocation(ImageRequest request, Size size) {
        if (Bitmaps.isHardware(request.getBitmapConfig())) {
            return isConfigValidForHardware(request, request.getBitmapConfig()) && this.hardwareBitmapService.allowHardwareMainThread(size);
        }
        return true;
    }

    private final boolean isConfigValidForTransformations(ImageRequest request) {
        return request.getTransformations().isEmpty() || ArraysKt.contains(Utils.getVALID_TRANSFORMATION_CONFIGS(), request.getBitmapConfig());
    }

    public final boolean allowHardwareWorkerThread(Options options) {
        return !Bitmaps.isHardware(options.getConfig()) || this.hardwareBitmapService.getAllowHardware();
    }

    public final ErrorResult errorResult(ImageRequest request, Throwable throwable) {
        Drawable error;
        if (throwable instanceof NullRequestDataException) {
            error = request.getFallback();
            if (error == null) {
                error = request.getError();
            }
        } else {
            error = request.getError();
        }
        return new ErrorResult(error, request, throwable);
    }

    public final boolean isConfigValidForHardware(ImageRequest request, Bitmap.Config requestedConfig) {
        if (!Bitmaps.isHardware(requestedConfig)) {
            return true;
        }
        if (!request.getAllowHardware()) {
            return false;
        }
        request.getTarget();
        return true;
    }

    public final Options options(ImageRequest request, Size size) {
        Bitmap.Config bitmapConfig = (isConfigValidForTransformations(request) && isConfigValidForHardwareAllocation(request, size)) ? request.getBitmapConfig() : Bitmap.Config.ARGB_8888;
        CachePolicy networkCachePolicy = this.systemCallbacks.get_isOnline() ? request.getNetworkCachePolicy() : CachePolicy.DISABLED;
        Dimension width = size.getWidth();
        Dimension.Undefined undefined = Dimension.Undefined.INSTANCE;
        return new Options(request.getContext(), bitmapConfig, request.getColorSpace(), size, (Intrinsics.areEqual(width, undefined) || Intrinsics.areEqual(size.getHeight(), undefined)) ? Scale.FIT : request.getScale(), Requests.getAllowInexactSize(request), request.getAllowRgb565() && request.getTransformations().isEmpty() && bitmapConfig != Bitmap.Config.ALPHA_8, request.getPremultipliedAlpha(), request.getDiskCacheKey(), request.getHeaders(), request.getTags(), request.getParameters(), request.getMemoryCachePolicy(), request.getDiskCachePolicy(), networkCachePolicy);
    }

    public final RequestDelegate requestDelegate(ImageRequest initialRequest, Job job) {
        Lifecycle lifecycle = initialRequest.getLifecycle();
        initialRequest.getTarget();
        return new BaseRequestDelegate(lifecycle, job);
    }
}
