package coil.request;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import coil.content.Requests;
import coil.content.Utils;
import coil.decode.Decoder;
import coil.fetch.Fetcher;
import coil.memory.MemoryCache;
import coil.request.Parameters;
import coil.size.DisplaySizeResolver;
import coil.size.Precision;
import coil.size.Scale;
import coil.size.SizeResolver;
import coil.size.ViewSizeResolver;
import coil.target.Target;
import coil.transition.Transition;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import okhttp3.Headers;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bd\u0018\u00002\u00020\u0001:\u0004¨\u0001©\u0001B÷\u0002\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u001c\u0010\u0016\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0018\u00010\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010#\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010%\u001a\u00020!\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010(\u001a\u00020&\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010,\u001a\u00020*\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010.\u001a\u00020*\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u00104\u001a\u000203\u0012\u0006\u00106\u001a\u000205\u0012\b\u00107\u001a\u0004\u0018\u00010\t\u0012\b\u00109\u001a\u0004\u0018\u000108\u0012\b\u0010;\u001a\u0004\u0018\u00010:\u0012\b\u0010<\u001a\u0004\u0018\u000108\u0012\b\u0010=\u001a\u0004\u0018\u00010:\u0012\b\u0010>\u001a\u0004\u0018\u000108\u0012\b\u0010?\u001a\u0004\u0018\u00010:\u0012\u0006\u0010A\u001a\u00020@\u0012\u0006\u0010C\u001a\u00020B¢\u0006\u0004\bD\u0010EJ\u0019\u0010G\u001a\u00020F2\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\bG\u0010HJ\u001a\u0010J\u001a\u00020!2\b\u0010I\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u000208H\u0016¢\u0006\u0004\bL\u0010MR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010N\u001a\u0004\bO\u0010PR\u0017\u0010\u0004\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0004\u0010Q\u001a\u0004\bR\u0010SR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010T\u001a\u0004\bU\u0010VR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010W\u001a\u0004\bX\u0010YR\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010Z\u001a\u0004\b[\u0010\\R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010]\u001a\u0004\b^\u0010_R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010`\u001a\u0004\ba\u0010bR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010c\u001a\u0004\bd\u0010eR\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010f\u001a\u0004\bg\u0010hR-\u0010\u0016\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0016\u0010i\u001a\u0004\bj\u0010kR\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010l\u001a\u0004\bm\u0010nR\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010o\u001a\u0004\bp\u0010qR\u0017\u0010\u001c\u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010r\u001a\u0004\bs\u0010tR\u0017\u0010\u001e\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010u\u001a\u0004\bv\u0010wR\u0017\u0010 \u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\b \u0010x\u001a\u0004\by\u0010zR\u0017\u0010\"\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b\"\u0010{\u001a\u0004\b|\u0010}R\u0017\u0010#\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b#\u0010{\u001a\u0004\b~\u0010}R\u0017\u0010$\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b$\u0010{\u001a\u0004\b\u007f\u0010}R\u0018\u0010%\u001a\u00020!8\u0006¢\u0006\r\n\u0004\b%\u0010{\u001a\u0005\b\u0080\u0001\u0010}R\u001a\u0010'\u001a\u00020&8\u0006¢\u0006\u000f\n\u0005\b'\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001a\u0010(\u001a\u00020&8\u0006¢\u0006\u000f\n\u0005\b(\u0010\u0081\u0001\u001a\u0006\b\u0084\u0001\u0010\u0083\u0001R\u001a\u0010)\u001a\u00020&8\u0006¢\u0006\u000f\n\u0005\b)\u0010\u0081\u0001\u001a\u0006\b\u0085\u0001\u0010\u0083\u0001R\u001a\u0010+\u001a\u00020*8\u0006¢\u0006\u000f\n\u0005\b+\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001a\u0010,\u001a\u00020*8\u0006¢\u0006\u000f\n\u0005\b,\u0010\u0086\u0001\u001a\u0006\b\u0089\u0001\u0010\u0088\u0001R\u001a\u0010-\u001a\u00020*8\u0006¢\u0006\u000f\n\u0005\b-\u0010\u0086\u0001\u001a\u0006\b\u008a\u0001\u0010\u0088\u0001R\u001a\u0010.\u001a\u00020*8\u0006¢\u0006\u000f\n\u0005\b.\u0010\u0086\u0001\u001a\u0006\b\u008b\u0001\u0010\u0088\u0001R\u001a\u00100\u001a\u00020/8\u0006¢\u0006\u000f\n\u0005\b0\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001a\u00102\u001a\u0002018\u0006¢\u0006\u000f\n\u0005\b2\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001a\u00104\u001a\u0002038\u0006¢\u0006\u000f\n\u0005\b4\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001a\u00106\u001a\u0002058\u0006¢\u0006\u000f\n\u0005\b6\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001a\u00107\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\r\n\u0004\b7\u0010Z\u001a\u0005\b\u0098\u0001\u0010\\R\u0017\u00109\u001a\u0004\u0018\u0001088\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b9\u0010\u0099\u0001R\u0017\u0010;\u001a\u0004\u0018\u00010:8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b;\u0010\u009a\u0001R\u0017\u0010<\u001a\u0004\u0018\u0001088\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b<\u0010\u0099\u0001R\u0017\u0010=\u001a\u0004\u0018\u00010:8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b=\u0010\u009a\u0001R\u0017\u0010>\u001a\u0004\u0018\u0001088\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b>\u0010\u0099\u0001R\u0017\u0010?\u001a\u0004\u0018\u00010:8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b?\u0010\u009a\u0001R\u001a\u0010A\u001a\u00020@8\u0006¢\u0006\u000f\n\u0005\bA\u0010\u009b\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001a\u0010C\u001a\u00020B8\u0006¢\u0006\u000f\n\u0005\bC\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001R\u0016\u0010£\u0001\u001a\u0004\u0018\u00010:8F¢\u0006\b\u001a\u0006\b¡\u0001\u0010¢\u0001R\u0016\u0010¥\u0001\u001a\u0004\u0018\u00010:8F¢\u0006\b\u001a\u0006\b¤\u0001\u0010¢\u0001R\u0016\u0010§\u0001\u001a\u0004\u0018\u00010:8F¢\u0006\b\u001a\u0006\b¦\u0001\u0010¢\u0001¨\u0006ª\u0001"}, d2 = {"Lcoil/request/ImageRequest;", BuildConfig.FLAVOR, "Landroid/content/Context;", "context", "data", "Lcoil/target/Target;", "target", "Lcoil/request/ImageRequest$Listener;", "listener", "Lcoil/memory/MemoryCache$Key;", "memoryCacheKey", BuildConfig.FLAVOR, "diskCacheKey", "Landroid/graphics/Bitmap$Config;", "bitmapConfig", "Landroid/graphics/ColorSpace;", "colorSpace", "Lcoil/size/Precision;", "precision", "Lkotlin/Pair;", "Lcoil/fetch/Fetcher$Factory;", "Ljava/lang/Class;", "fetcherFactory", "Lcoil/decode/Decoder$Factory;", "decoderFactory", BuildConfig.FLAVOR, "transformations", "Lcoil/transition/Transition$Factory;", "transitionFactory", "Lokhttp3/Headers;", "headers", "Lcoil/request/Tags;", "tags", BuildConfig.FLAVOR, "allowConversionToBitmap", "allowHardware", "allowRgb565", "premultipliedAlpha", "Lcoil/request/CachePolicy;", "memoryCachePolicy", "diskCachePolicy", "networkCachePolicy", "Lkotlinx/coroutines/CoroutineDispatcher;", "interceptorDispatcher", "fetcherDispatcher", "decoderDispatcher", "transformationDispatcher", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Lcoil/size/SizeResolver;", "sizeResolver", "Lcoil/size/Scale;", "scale", "Lcoil/request/Parameters;", "parameters", "placeholderMemoryCacheKey", BuildConfig.FLAVOR, "placeholderResId", "Landroid/graphics/drawable/Drawable;", "placeholderDrawable", "errorResId", "errorDrawable", "fallbackResId", "fallbackDrawable", "Lcoil/request/DefinedRequestOptions;", "defined", "Lcoil/request/DefaultRequestOptions;", "defaults", "<init>", "(Landroid/content/Context;Ljava/lang/Object;Lcoil/target/Target;Lcoil/request/ImageRequest$Listener;Lcoil/memory/MemoryCache$Key;Ljava/lang/String;Landroid/graphics/Bitmap$Config;Landroid/graphics/ColorSpace;Lcoil/size/Precision;Lkotlin/Pair;Lcoil/decode/Decoder$Factory;Ljava/util/List;Lcoil/transition/Transition$Factory;Lokhttp3/Headers;Lcoil/request/Tags;ZZZZLcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/lifecycle/Lifecycle;Lcoil/size/SizeResolver;Lcoil/size/Scale;Lcoil/request/Parameters;Lcoil/memory/MemoryCache$Key;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Lcoil/request/DefinedRequestOptions;Lcoil/request/DefaultRequestOptions;)V", "Lcoil/request/ImageRequest$Builder;", "newBuilder", "(Landroid/content/Context;)Lcoil/request/ImageRequest$Builder;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Ljava/lang/Object;", "getData", "()Ljava/lang/Object;", "Lcoil/target/Target;", "getTarget", "()Lcoil/target/Target;", "Lcoil/request/ImageRequest$Listener;", "getListener", "()Lcoil/request/ImageRequest$Listener;", "Lcoil/memory/MemoryCache$Key;", "getMemoryCacheKey", "()Lcoil/memory/MemoryCache$Key;", "Ljava/lang/String;", "getDiskCacheKey", "()Ljava/lang/String;", "Landroid/graphics/Bitmap$Config;", "getBitmapConfig", "()Landroid/graphics/Bitmap$Config;", "Landroid/graphics/ColorSpace;", "getColorSpace", "()Landroid/graphics/ColorSpace;", "Lcoil/size/Precision;", "getPrecision", "()Lcoil/size/Precision;", "Lkotlin/Pair;", "getFetcherFactory", "()Lkotlin/Pair;", "Lcoil/decode/Decoder$Factory;", "getDecoderFactory", "()Lcoil/decode/Decoder$Factory;", "Ljava/util/List;", "getTransformations", "()Ljava/util/List;", "Lcoil/transition/Transition$Factory;", "getTransitionFactory", "()Lcoil/transition/Transition$Factory;", "Lokhttp3/Headers;", "getHeaders", "()Lokhttp3/Headers;", "Lcoil/request/Tags;", "getTags", "()Lcoil/request/Tags;", "Z", "getAllowConversionToBitmap", "()Z", "getAllowHardware", "getAllowRgb565", "getPremultipliedAlpha", "Lcoil/request/CachePolicy;", "getMemoryCachePolicy", "()Lcoil/request/CachePolicy;", "getDiskCachePolicy", "getNetworkCachePolicy", "Lkotlinx/coroutines/CoroutineDispatcher;", "getInterceptorDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getFetcherDispatcher", "getDecoderDispatcher", "getTransformationDispatcher", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "Lcoil/size/SizeResolver;", "getSizeResolver", "()Lcoil/size/SizeResolver;", "Lcoil/size/Scale;", "getScale", "()Lcoil/size/Scale;", "Lcoil/request/Parameters;", "getParameters", "()Lcoil/request/Parameters;", "getPlaceholderMemoryCacheKey", "Ljava/lang/Integer;", "Landroid/graphics/drawable/Drawable;", "Lcoil/request/DefinedRequestOptions;", "getDefined", "()Lcoil/request/DefinedRequestOptions;", "Lcoil/request/DefaultRequestOptions;", "getDefaults", "()Lcoil/request/DefaultRequestOptions;", "getPlaceholder", "()Landroid/graphics/drawable/Drawable;", "placeholder", "getError", "error", "getFallback", "fallback", "Builder", "Listener", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ImageRequest {
    private final boolean allowConversionToBitmap;
    private final boolean allowHardware;
    private final boolean allowRgb565;
    private final Bitmap.Config bitmapConfig;
    private final ColorSpace colorSpace;
    private final Context context;
    private final Object data;
    private final CoroutineDispatcher decoderDispatcher;
    private final Decoder.Factory decoderFactory;
    private final DefaultRequestOptions defaults;
    private final DefinedRequestOptions defined;
    private final String diskCacheKey;
    private final CachePolicy diskCachePolicy;
    private final Drawable errorDrawable;
    private final Integer errorResId;
    private final Drawable fallbackDrawable;
    private final Integer fallbackResId;
    private final CoroutineDispatcher fetcherDispatcher;
    private final Pair<Fetcher.Factory<?>, Class<?>> fetcherFactory;
    private final Headers headers;
    private final CoroutineDispatcher interceptorDispatcher;
    private final Lifecycle lifecycle;
    private final Listener listener;
    private final MemoryCache.Key memoryCacheKey;
    private final CachePolicy memoryCachePolicy;
    private final CachePolicy networkCachePolicy;
    private final Parameters parameters;
    private final Drawable placeholderDrawable;
    private final MemoryCache.Key placeholderMemoryCacheKey;
    private final Integer placeholderResId;
    private final Precision precision;
    private final boolean premultipliedAlpha;
    private final Scale scale;
    private final SizeResolver sizeResolver;
    private final Tags tags;
    private final Target target;
    private final CoroutineDispatcher transformationDispatcher;
    private final List<Object> transformations;
    private final Transition.Factory transitionFactory;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0017J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u000bH\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcoil/request/ImageRequest$Listener;", BuildConfig.FLAVOR, "onCancel", BuildConfig.FLAVOR, "request", "Lcoil/request/ImageRequest;", "onError", "result", "Lcoil/request/ErrorResult;", "onStart", "onSuccess", "Lcoil/request/SuccessResult;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface Listener {
        void onCancel(ImageRequest request);

        void onError(ImageRequest request, ErrorResult result);

        void onStart(ImageRequest request);

        void onSuccess(ImageRequest request, SuccessResult result);
    }

    public /* synthetic */ ImageRequest(Context context, Object obj, Target target, Listener listener, MemoryCache.Key key, String str, Bitmap.Config config, ColorSpace colorSpace, Precision precision, Pair pair, Decoder.Factory factory, List list, Transition.Factory factory2, Headers headers, Tags tags, boolean z5, boolean z6, boolean z7, boolean z8, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, CoroutineDispatcher coroutineDispatcher4, Lifecycle lifecycle, SizeResolver sizeResolver, Scale scale, Parameters parameters, MemoryCache.Key key2, Integer num, Drawable drawable, Integer num2, Drawable drawable2, Integer num3, Drawable drawable3, DefinedRequestOptions definedRequestOptions, DefaultRequestOptions defaultRequestOptions, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, obj, target, listener, key, str, config, colorSpace, precision, pair, factory, list, factory2, headers, tags, z5, z6, z7, z8, cachePolicy, cachePolicy2, cachePolicy3, coroutineDispatcher, coroutineDispatcher2, coroutineDispatcher3, coroutineDispatcher4, lifecycle, sizeResolver, scale, parameters, key2, num, drawable, num2, drawable2, num3, drawable3, definedRequestOptions, defaultRequestOptions);
    }

    public static /* synthetic */ Builder newBuilder$default(ImageRequest imageRequest, Context context, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            context = imageRequest.context;
        }
        return imageRequest.newBuilder(context);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) other;
            if (Intrinsics.areEqual(this.context, imageRequest.context) && Intrinsics.areEqual(this.data, imageRequest.data) && Intrinsics.areEqual(this.target, imageRequest.target) && Intrinsics.areEqual(this.listener, imageRequest.listener) && Intrinsics.areEqual(this.memoryCacheKey, imageRequest.memoryCacheKey) && Intrinsics.areEqual(this.diskCacheKey, imageRequest.diskCacheKey) && this.bitmapConfig == imageRequest.bitmapConfig && Intrinsics.areEqual(this.colorSpace, imageRequest.colorSpace) && this.precision == imageRequest.precision && Intrinsics.areEqual(this.fetcherFactory, imageRequest.fetcherFactory) && Intrinsics.areEqual(this.decoderFactory, imageRequest.decoderFactory) && Intrinsics.areEqual(this.transformations, imageRequest.transformations) && Intrinsics.areEqual(this.transitionFactory, imageRequest.transitionFactory) && Intrinsics.areEqual(this.headers, imageRequest.headers) && Intrinsics.areEqual(this.tags, imageRequest.tags) && this.allowConversionToBitmap == imageRequest.allowConversionToBitmap && this.allowHardware == imageRequest.allowHardware && this.allowRgb565 == imageRequest.allowRgb565 && this.premultipliedAlpha == imageRequest.premultipliedAlpha && this.memoryCachePolicy == imageRequest.memoryCachePolicy && this.diskCachePolicy == imageRequest.diskCachePolicy && this.networkCachePolicy == imageRequest.networkCachePolicy && Intrinsics.areEqual(this.interceptorDispatcher, imageRequest.interceptorDispatcher) && Intrinsics.areEqual(this.fetcherDispatcher, imageRequest.fetcherDispatcher) && Intrinsics.areEqual(this.decoderDispatcher, imageRequest.decoderDispatcher) && Intrinsics.areEqual(this.transformationDispatcher, imageRequest.transformationDispatcher) && Intrinsics.areEqual(this.placeholderMemoryCacheKey, imageRequest.placeholderMemoryCacheKey) && Intrinsics.areEqual(this.placeholderResId, imageRequest.placeholderResId) && Intrinsics.areEqual(this.placeholderDrawable, imageRequest.placeholderDrawable) && Intrinsics.areEqual(this.errorResId, imageRequest.errorResId) && Intrinsics.areEqual(this.errorDrawable, imageRequest.errorDrawable) && Intrinsics.areEqual(this.fallbackResId, imageRequest.fallbackResId) && Intrinsics.areEqual(this.fallbackDrawable, imageRequest.fallbackDrawable) && Intrinsics.areEqual(this.lifecycle, imageRequest.lifecycle) && Intrinsics.areEqual(this.sizeResolver, imageRequest.sizeResolver) && this.scale == imageRequest.scale && Intrinsics.areEqual(this.parameters, imageRequest.parameters) && Intrinsics.areEqual(this.defined, imageRequest.defined) && Intrinsics.areEqual(this.defaults, imageRequest.defaults)) {
                return true;
            }
        }
        return false;
    }

    public final boolean getAllowConversionToBitmap() {
        return this.allowConversionToBitmap;
    }

    public final boolean getAllowHardware() {
        return this.allowHardware;
    }

    public final boolean getAllowRgb565() {
        return this.allowRgb565;
    }

    public final Bitmap.Config getBitmapConfig() {
        return this.bitmapConfig;
    }

    public final ColorSpace getColorSpace() {
        return this.colorSpace;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Object getData() {
        return this.data;
    }

    public final CoroutineDispatcher getDecoderDispatcher() {
        return this.decoderDispatcher;
    }

    public final Decoder.Factory getDecoderFactory() {
        return this.decoderFactory;
    }

    public final DefaultRequestOptions getDefaults() {
        return this.defaults;
    }

    public final DefinedRequestOptions getDefined() {
        return this.defined;
    }

    public final String getDiskCacheKey() {
        return this.diskCacheKey;
    }

    public final CachePolicy getDiskCachePolicy() {
        return this.diskCachePolicy;
    }

    public final Drawable getError() {
        return Requests.getDrawableCompat(this, this.errorDrawable, this.errorResId, this.defaults.getError());
    }

    public final Drawable getFallback() {
        return Requests.getDrawableCompat(this, this.fallbackDrawable, this.fallbackResId, this.defaults.getFallback());
    }

    public final CoroutineDispatcher getFetcherDispatcher() {
        return this.fetcherDispatcher;
    }

    public final Pair<Fetcher.Factory<?>, Class<?>> getFetcherFactory() {
        return this.fetcherFactory;
    }

    public final Headers getHeaders() {
        return this.headers;
    }

    public final CoroutineDispatcher getInterceptorDispatcher() {
        return this.interceptorDispatcher;
    }

    public final Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    public final Listener getListener() {
        return this.listener;
    }

    public final MemoryCache.Key getMemoryCacheKey() {
        return this.memoryCacheKey;
    }

    public final CachePolicy getMemoryCachePolicy() {
        return this.memoryCachePolicy;
    }

    public final CachePolicy getNetworkCachePolicy() {
        return this.networkCachePolicy;
    }

    public final Parameters getParameters() {
        return this.parameters;
    }

    public final Drawable getPlaceholder() {
        return Requests.getDrawableCompat(this, this.placeholderDrawable, this.placeholderResId, this.defaults.getPlaceholder());
    }

    public final MemoryCache.Key getPlaceholderMemoryCacheKey() {
        return this.placeholderMemoryCacheKey;
    }

    public final Precision getPrecision() {
        return this.precision;
    }

    public final boolean getPremultipliedAlpha() {
        return this.premultipliedAlpha;
    }

    public final Scale getScale() {
        return this.scale;
    }

    public final SizeResolver getSizeResolver() {
        return this.sizeResolver;
    }

    public final Tags getTags() {
        return this.tags;
    }

    public final Target getTarget() {
        return this.target;
    }

    public final CoroutineDispatcher getTransformationDispatcher() {
        return this.transformationDispatcher;
    }

    public final List<Object> getTransformations() {
        return this.transformations;
    }

    public final Transition.Factory getTransitionFactory() {
        return this.transitionFactory;
    }

    public int hashCode() {
        int hashCode = ((this.context.hashCode() * 31) + this.data.hashCode()) * 31;
        Target target = this.target;
        int hashCode2 = (hashCode + (target != null ? target.hashCode() : 0)) * 31;
        Listener listener = this.listener;
        int hashCode3 = (hashCode2 + (listener != null ? listener.hashCode() : 0)) * 31;
        MemoryCache.Key key = this.memoryCacheKey;
        int hashCode4 = (hashCode3 + (key != null ? key.hashCode() : 0)) * 31;
        String str = this.diskCacheKey;
        int hashCode5 = (((hashCode4 + (str != null ? str.hashCode() : 0)) * 31) + this.bitmapConfig.hashCode()) * 31;
        ColorSpace colorSpace = this.colorSpace;
        int hashCode6 = (((hashCode5 + (colorSpace != null ? colorSpace.hashCode() : 0)) * 31) + this.precision.hashCode()) * 31;
        Pair<Fetcher.Factory<?>, Class<?>> pair = this.fetcherFactory;
        int hashCode7 = (hashCode6 + (pair != null ? pair.hashCode() : 0)) * 31;
        Decoder.Factory factory = this.decoderFactory;
        int hashCode8 = (((((((((((((((((((((((((((((((((((((((hashCode7 + (factory != null ? factory.hashCode() : 0)) * 31) + this.transformations.hashCode()) * 31) + this.transitionFactory.hashCode()) * 31) + this.headers.hashCode()) * 31) + this.tags.hashCode()) * 31) + Boolean.hashCode(this.allowConversionToBitmap)) * 31) + Boolean.hashCode(this.allowHardware)) * 31) + Boolean.hashCode(this.allowRgb565)) * 31) + Boolean.hashCode(this.premultipliedAlpha)) * 31) + this.memoryCachePolicy.hashCode()) * 31) + this.diskCachePolicy.hashCode()) * 31) + this.networkCachePolicy.hashCode()) * 31) + this.interceptorDispatcher.hashCode()) * 31) + this.fetcherDispatcher.hashCode()) * 31) + this.decoderDispatcher.hashCode()) * 31) + this.transformationDispatcher.hashCode()) * 31) + this.lifecycle.hashCode()) * 31) + this.sizeResolver.hashCode()) * 31) + this.scale.hashCode()) * 31) + this.parameters.hashCode()) * 31;
        MemoryCache.Key key2 = this.placeholderMemoryCacheKey;
        int hashCode9 = (hashCode8 + (key2 != null ? key2.hashCode() : 0)) * 31;
        Integer num = this.placeholderResId;
        int hashCode10 = (hashCode9 + (num != null ? num.hashCode() : 0)) * 31;
        Drawable drawable = this.placeholderDrawable;
        int hashCode11 = (hashCode10 + (drawable != null ? drawable.hashCode() : 0)) * 31;
        Integer num2 = this.errorResId;
        int hashCode12 = (hashCode11 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Drawable drawable2 = this.errorDrawable;
        int hashCode13 = (hashCode12 + (drawable2 != null ? drawable2.hashCode() : 0)) * 31;
        Integer num3 = this.fallbackResId;
        int hashCode14 = (hashCode13 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Drawable drawable3 = this.fallbackDrawable;
        return ((((hashCode14 + (drawable3 != null ? drawable3.hashCode() : 0)) * 31) + this.defined.hashCode()) * 31) + this.defaults.hashCode();
    }

    public final Builder newBuilder() {
        return newBuilder$default(this, null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImageRequest(Context context, Object obj, Target target, Listener listener, MemoryCache.Key key, String str, Bitmap.Config config, ColorSpace colorSpace, Precision precision, Pair<? extends Fetcher.Factory<?>, ? extends Class<?>> pair, Decoder.Factory factory, List<Object> list, Transition.Factory factory2, Headers headers, Tags tags, boolean z5, boolean z6, boolean z7, boolean z8, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, CoroutineDispatcher coroutineDispatcher4, Lifecycle lifecycle, SizeResolver sizeResolver, Scale scale, Parameters parameters, MemoryCache.Key key2, Integer num, Drawable drawable, Integer num2, Drawable drawable2, Integer num3, Drawable drawable3, DefinedRequestOptions definedRequestOptions, DefaultRequestOptions defaultRequestOptions) {
        this.context = context;
        this.data = obj;
        this.target = target;
        this.listener = listener;
        this.memoryCacheKey = key;
        this.diskCacheKey = str;
        this.bitmapConfig = config;
        this.colorSpace = colorSpace;
        this.precision = precision;
        this.fetcherFactory = pair;
        this.decoderFactory = factory;
        this.transformations = list;
        this.transitionFactory = factory2;
        this.headers = headers;
        this.tags = tags;
        this.allowConversionToBitmap = z5;
        this.allowHardware = z6;
        this.allowRgb565 = z7;
        this.premultipliedAlpha = z8;
        this.memoryCachePolicy = cachePolicy;
        this.diskCachePolicy = cachePolicy2;
        this.networkCachePolicy = cachePolicy3;
        this.interceptorDispatcher = coroutineDispatcher;
        this.fetcherDispatcher = coroutineDispatcher2;
        this.decoderDispatcher = coroutineDispatcher3;
        this.transformationDispatcher = coroutineDispatcher4;
        this.lifecycle = lifecycle;
        this.sizeResolver = sizeResolver;
        this.scale = scale;
        this.parameters = parameters;
        this.placeholderMemoryCacheKey = key2;
        this.placeholderResId = num;
        this.placeholderDrawable = drawable;
        this.errorResId = num2;
        this.errorDrawable = drawable2;
        this.fallbackResId = num3;
        this.fallbackDrawable = drawable3;
        this.defined = definedRequestOptions;
        this.defaults = defaultRequestOptions;
    }

    public final Builder newBuilder(Context context) {
        return new Builder(this, context);
    }

    @Metadata(d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0013¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b!\u0010\"J\u0015\u0010$\u001a\u00020\u00002\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u0006¢\u0006\u0004\b&\u0010'R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010(R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010)R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010*R\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00103\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010;R,\u0010?\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030=\u0012\b\u0012\u0006\u0012\u0002\b\u00030>\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010H\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010K\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR(\u0010N\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030>\u0012\u0004\u0012\u00020\u0001\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010Q\u001a\u00020P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010U\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010TR\u0016\u0010V\u001a\u00020P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010RR\u0018\u0010X\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010YR\u0018\u0010[\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010YR\u0018\u0010]\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010_\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010^R\u0018\u0010`\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010^R\u0018\u0010a\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010^R\u0018\u0010c\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010e\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u00101R\u0018\u0010g\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010j\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010l\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bl\u0010hR\u0018\u0010m\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010kR\u0018\u0010n\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bn\u0010hR\u0018\u0010o\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010kR\u0018\u0010p\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0018\u0010r\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010tR\u0018\u0010u\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010qR\u0018\u0010v\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010sR\u0018\u0010w\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010t¨\u0006x"}, d2 = {"Lcoil/request/ImageRequest$Builder;", BuildConfig.FLAVOR, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lcoil/request/ImageRequest;", "request", "(Lcoil/request/ImageRequest;Landroid/content/Context;)V", BuildConfig.FLAVOR, "resetResolvedValues", "()V", "resetResolvedScale", "Landroidx/lifecycle/Lifecycle;", "resolveLifecycle", "()Landroidx/lifecycle/Lifecycle;", "Lcoil/size/SizeResolver;", "resolveSizeResolver", "()Lcoil/size/SizeResolver;", "Lcoil/size/Scale;", "resolveScale", "()Lcoil/size/Scale;", "data", "(Ljava/lang/Object;)Lcoil/request/ImageRequest$Builder;", "resolver", "size", "(Lcoil/size/SizeResolver;)Lcoil/request/ImageRequest$Builder;", "scale", "(Lcoil/size/Scale;)Lcoil/request/ImageRequest$Builder;", "Lcoil/size/Precision;", "precision", "(Lcoil/size/Precision;)Lcoil/request/ImageRequest$Builder;", "Lcoil/target/Target;", "target", "(Lcoil/target/Target;)Lcoil/request/ImageRequest$Builder;", "Lcoil/request/DefaultRequestOptions;", "defaults", "(Lcoil/request/DefaultRequestOptions;)Lcoil/request/ImageRequest$Builder;", "build", "()Lcoil/request/ImageRequest;", "Landroid/content/Context;", "Lcoil/request/DefaultRequestOptions;", "Ljava/lang/Object;", "Lcoil/target/Target;", "Lcoil/request/ImageRequest$Listener;", "listener", "Lcoil/request/ImageRequest$Listener;", "Lcoil/memory/MemoryCache$Key;", "memoryCacheKey", "Lcoil/memory/MemoryCache$Key;", BuildConfig.FLAVOR, "diskCacheKey", "Ljava/lang/String;", "Landroid/graphics/Bitmap$Config;", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "Landroid/graphics/ColorSpace;", "colorSpace", "Landroid/graphics/ColorSpace;", "Lcoil/size/Precision;", "Lkotlin/Pair;", "Lcoil/fetch/Fetcher$Factory;", "Ljava/lang/Class;", "fetcherFactory", "Lkotlin/Pair;", "Lcoil/decode/Decoder$Factory;", "decoderFactory", "Lcoil/decode/Decoder$Factory;", BuildConfig.FLAVOR, "transformations", "Ljava/util/List;", "Lcoil/transition/Transition$Factory;", "transitionFactory", "Lcoil/transition/Transition$Factory;", "Lokhttp3/Headers$Builder;", "headers", "Lokhttp3/Headers$Builder;", BuildConfig.FLAVOR, "tags", "Ljava/util/Map;", BuildConfig.FLAVOR, "allowConversionToBitmap", "Z", "allowHardware", "Ljava/lang/Boolean;", "allowRgb565", "premultipliedAlpha", "Lcoil/request/CachePolicy;", "memoryCachePolicy", "Lcoil/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "Lkotlinx/coroutines/CoroutineDispatcher;", "interceptorDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "fetcherDispatcher", "decoderDispatcher", "transformationDispatcher", "Lcoil/request/Parameters$Builder;", "parameters", "Lcoil/request/Parameters$Builder;", "placeholderMemoryCacheKey", BuildConfig.FLAVOR, "placeholderResId", "Ljava/lang/Integer;", "Landroid/graphics/drawable/Drawable;", "placeholderDrawable", "Landroid/graphics/drawable/Drawable;", "errorResId", "errorDrawable", "fallbackResId", "fallbackDrawable", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "sizeResolver", "Lcoil/size/SizeResolver;", "Lcoil/size/Scale;", "resolvedLifecycle", "resolvedSizeResolver", "resolvedScale", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Builder {
        private boolean allowConversionToBitmap;
        private Boolean allowHardware;
        private Boolean allowRgb565;
        private Bitmap.Config bitmapConfig;
        private ColorSpace colorSpace;
        private final Context context;
        private Object data;
        private CoroutineDispatcher decoderDispatcher;
        private Decoder.Factory decoderFactory;
        private DefaultRequestOptions defaults;
        private String diskCacheKey;
        private CachePolicy diskCachePolicy;
        private Drawable errorDrawable;
        private Integer errorResId;
        private Drawable fallbackDrawable;
        private Integer fallbackResId;
        private CoroutineDispatcher fetcherDispatcher;
        private Pair<? extends Fetcher.Factory<?>, ? extends Class<?>> fetcherFactory;
        private Headers.Builder headers;
        private CoroutineDispatcher interceptorDispatcher;
        private Lifecycle lifecycle;
        private Listener listener;
        private MemoryCache.Key memoryCacheKey;
        private CachePolicy memoryCachePolicy;
        private CachePolicy networkCachePolicy;
        private Parameters.Builder parameters;
        private Drawable placeholderDrawable;
        private MemoryCache.Key placeholderMemoryCacheKey;
        private Integer placeholderResId;
        private Precision precision;
        private boolean premultipliedAlpha;
        private Lifecycle resolvedLifecycle;
        private Scale resolvedScale;
        private SizeResolver resolvedSizeResolver;
        private Scale scale;
        private SizeResolver sizeResolver;
        private Map<Class<?>, Object> tags;
        private Target target;
        private CoroutineDispatcher transformationDispatcher;
        private List<Object> transformations;
        private Transition.Factory transitionFactory;

        public Builder(Context context) {
            this.context = context;
            this.defaults = Requests.getDEFAULT_REQUEST_OPTIONS();
            this.data = null;
            this.target = null;
            this.listener = null;
            this.memoryCacheKey = null;
            this.diskCacheKey = null;
            this.bitmapConfig = null;
            this.colorSpace = null;
            this.precision = null;
            this.fetcherFactory = null;
            this.decoderFactory = null;
            this.transformations = CollectionsKt.emptyList();
            this.transitionFactory = null;
            this.headers = null;
            this.tags = null;
            this.allowConversionToBitmap = true;
            this.allowHardware = null;
            this.allowRgb565 = null;
            this.premultipliedAlpha = true;
            this.memoryCachePolicy = null;
            this.diskCachePolicy = null;
            this.networkCachePolicy = null;
            this.interceptorDispatcher = null;
            this.fetcherDispatcher = null;
            this.decoderDispatcher = null;
            this.transformationDispatcher = null;
            this.parameters = null;
            this.placeholderMemoryCacheKey = null;
            this.placeholderResId = null;
            this.placeholderDrawable = null;
            this.errorResId = null;
            this.errorDrawable = null;
            this.fallbackResId = null;
            this.fallbackDrawable = null;
            this.lifecycle = null;
            this.sizeResolver = null;
            this.scale = null;
            this.resolvedLifecycle = null;
            this.resolvedSizeResolver = null;
            this.resolvedScale = null;
        }

        private final void resetResolvedScale() {
            this.resolvedScale = null;
        }

        private final void resetResolvedValues() {
            this.resolvedLifecycle = null;
            this.resolvedSizeResolver = null;
            this.resolvedScale = null;
        }

        private final Lifecycle resolveLifecycle() {
            Lifecycle lifecycle = coil.content.Context.getLifecycle(this.context);
            return lifecycle == null ? GlobalLifecycle.INSTANCE : lifecycle;
        }

        private final Scale resolveScale() {
            KeyEvent.Callback view;
            SizeResolver sizeResolver = this.sizeResolver;
            KeyEvent.Callback callback = null;
            ViewSizeResolver viewSizeResolver = sizeResolver instanceof ViewSizeResolver ? (ViewSizeResolver) sizeResolver : null;
            if (viewSizeResolver != null && (view = viewSizeResolver.getView()) != null) {
                callback = view;
            }
            return callback instanceof ImageView ? Utils.getScale((ImageView) callback) : Scale.FIT;
        }

        private final SizeResolver resolveSizeResolver() {
            return new DisplaySizeResolver(this.context);
        }

        public final ImageRequest build() {
            Context context = this.context;
            Object obj = this.data;
            if (obj == null) {
                obj = NullRequestData.INSTANCE;
            }
            Object obj2 = obj;
            Target target = this.target;
            Listener listener = this.listener;
            MemoryCache.Key key = this.memoryCacheKey;
            String str = this.diskCacheKey;
            Bitmap.Config config = this.bitmapConfig;
            if (config == null) {
                config = this.defaults.getBitmapConfig();
            }
            Bitmap.Config config2 = config;
            ColorSpace colorSpace = this.colorSpace;
            Precision precision = this.precision;
            if (precision == null) {
                precision = this.defaults.getPrecision();
            }
            Precision precision2 = precision;
            Pair<? extends Fetcher.Factory<?>, ? extends Class<?>> pair = this.fetcherFactory;
            Decoder.Factory factory = this.decoderFactory;
            List<Object> list = this.transformations;
            Transition.Factory factory2 = this.transitionFactory;
            if (factory2 == null) {
                factory2 = this.defaults.getTransitionFactory();
            }
            Transition.Factory factory3 = factory2;
            Headers.Builder builder = this.headers;
            Headers orEmpty = Utils.orEmpty(builder != null ? builder.build() : null);
            Map<Class<?>, ? extends Object> map = this.tags;
            Tags orEmpty2 = Utils.orEmpty(map != null ? Tags.INSTANCE.from(map) : null);
            boolean z5 = this.allowConversionToBitmap;
            Boolean bool = this.allowHardware;
            boolean booleanValue = bool != null ? bool.booleanValue() : this.defaults.getAllowHardware();
            Boolean bool2 = this.allowRgb565;
            boolean booleanValue2 = bool2 != null ? bool2.booleanValue() : this.defaults.getAllowRgb565();
            boolean z6 = this.premultipliedAlpha;
            CachePolicy cachePolicy = this.memoryCachePolicy;
            if (cachePolicy == null) {
                cachePolicy = this.defaults.getMemoryCachePolicy();
            }
            CachePolicy cachePolicy2 = cachePolicy;
            CachePolicy cachePolicy3 = this.diskCachePolicy;
            if (cachePolicy3 == null) {
                cachePolicy3 = this.defaults.getDiskCachePolicy();
            }
            CachePolicy cachePolicy4 = cachePolicy3;
            CachePolicy cachePolicy5 = this.networkCachePolicy;
            if (cachePolicy5 == null) {
                cachePolicy5 = this.defaults.getNetworkCachePolicy();
            }
            CachePolicy cachePolicy6 = cachePolicy5;
            CoroutineDispatcher coroutineDispatcher = this.interceptorDispatcher;
            if (coroutineDispatcher == null) {
                coroutineDispatcher = this.defaults.getInterceptorDispatcher();
            }
            CoroutineDispatcher coroutineDispatcher2 = coroutineDispatcher;
            CoroutineDispatcher coroutineDispatcher3 = this.fetcherDispatcher;
            if (coroutineDispatcher3 == null) {
                coroutineDispatcher3 = this.defaults.getFetcherDispatcher();
            }
            CoroutineDispatcher coroutineDispatcher4 = coroutineDispatcher3;
            CoroutineDispatcher coroutineDispatcher5 = this.decoderDispatcher;
            if (coroutineDispatcher5 == null) {
                coroutineDispatcher5 = this.defaults.getDecoderDispatcher();
            }
            CoroutineDispatcher coroutineDispatcher6 = coroutineDispatcher5;
            CoroutineDispatcher coroutineDispatcher7 = this.transformationDispatcher;
            if (coroutineDispatcher7 == null) {
                coroutineDispatcher7 = this.defaults.getTransformationDispatcher();
            }
            CoroutineDispatcher coroutineDispatcher8 = coroutineDispatcher7;
            Lifecycle lifecycle = this.lifecycle;
            if (lifecycle == null && (lifecycle = this.resolvedLifecycle) == null) {
                lifecycle = resolveLifecycle();
            }
            Lifecycle lifecycle2 = lifecycle;
            SizeResolver sizeResolver = this.sizeResolver;
            if (sizeResolver == null && (sizeResolver = this.resolvedSizeResolver) == null) {
                sizeResolver = resolveSizeResolver();
            }
            SizeResolver sizeResolver2 = sizeResolver;
            Scale scale = this.scale;
            if (scale == null && (scale = this.resolvedScale) == null) {
                scale = resolveScale();
            }
            Scale scale2 = scale;
            Parameters.Builder builder2 = this.parameters;
            return new ImageRequest(context, obj2, target, listener, key, str, config2, colorSpace, precision2, pair, factory, list, factory3, orEmpty, orEmpty2, z5, booleanValue, booleanValue2, z6, cachePolicy2, cachePolicy4, cachePolicy6, coroutineDispatcher2, coroutineDispatcher4, coroutineDispatcher6, coroutineDispatcher8, lifecycle2, sizeResolver2, scale2, Utils.orEmpty(builder2 != null ? builder2.build() : null), this.placeholderMemoryCacheKey, this.placeholderResId, this.placeholderDrawable, this.errorResId, this.errorDrawable, this.fallbackResId, this.fallbackDrawable, new DefinedRequestOptions(this.lifecycle, this.sizeResolver, this.scale, this.interceptorDispatcher, this.fetcherDispatcher, this.decoderDispatcher, this.transformationDispatcher, this.transitionFactory, this.precision, this.bitmapConfig, this.allowHardware, this.allowRgb565, this.memoryCachePolicy, this.diskCachePolicy, this.networkCachePolicy), this.defaults, null);
        }

        public final Builder data(Object data) {
            this.data = data;
            return this;
        }

        public final Builder defaults(DefaultRequestOptions defaults) {
            this.defaults = defaults;
            resetResolvedScale();
            return this;
        }

        public final Builder precision(Precision precision) {
            this.precision = precision;
            return this;
        }

        public final Builder scale(Scale scale) {
            this.scale = scale;
            return this;
        }

        public final Builder size(SizeResolver resolver) {
            this.sizeResolver = resolver;
            resetResolvedValues();
            return this;
        }

        public final Builder target(Target target) {
            this.target = target;
            resetResolvedValues();
            return this;
        }

        public Builder(ImageRequest imageRequest, Context context) {
            this.context = context;
            this.defaults = imageRequest.getDefaults();
            this.data = imageRequest.getData();
            this.target = imageRequest.getTarget();
            this.listener = imageRequest.getListener();
            this.memoryCacheKey = imageRequest.getMemoryCacheKey();
            this.diskCacheKey = imageRequest.getDiskCacheKey();
            this.bitmapConfig = imageRequest.getDefined().getBitmapConfig();
            this.colorSpace = imageRequest.getColorSpace();
            this.precision = imageRequest.getDefined().getPrecision();
            this.fetcherFactory = imageRequest.getFetcherFactory();
            this.decoderFactory = imageRequest.getDecoderFactory();
            this.transformations = imageRequest.getTransformations();
            this.transitionFactory = imageRequest.getDefined().getTransitionFactory();
            this.headers = imageRequest.getHeaders().newBuilder();
            this.tags = MapsKt.toMutableMap(imageRequest.getTags().asMap());
            this.allowConversionToBitmap = imageRequest.getAllowConversionToBitmap();
            this.allowHardware = imageRequest.getDefined().getAllowHardware();
            this.allowRgb565 = imageRequest.getDefined().getAllowRgb565();
            this.premultipliedAlpha = imageRequest.getPremultipliedAlpha();
            this.memoryCachePolicy = imageRequest.getDefined().getMemoryCachePolicy();
            this.diskCachePolicy = imageRequest.getDefined().getDiskCachePolicy();
            this.networkCachePolicy = imageRequest.getDefined().getNetworkCachePolicy();
            this.interceptorDispatcher = imageRequest.getDefined().getInterceptorDispatcher();
            this.fetcherDispatcher = imageRequest.getDefined().getFetcherDispatcher();
            this.decoderDispatcher = imageRequest.getDefined().getDecoderDispatcher();
            this.transformationDispatcher = imageRequest.getDefined().getTransformationDispatcher();
            this.parameters = imageRequest.getParameters().newBuilder();
            this.placeholderMemoryCacheKey = imageRequest.getPlaceholderMemoryCacheKey();
            this.placeholderResId = imageRequest.placeholderResId;
            this.placeholderDrawable = imageRequest.placeholderDrawable;
            this.errorResId = imageRequest.errorResId;
            this.errorDrawable = imageRequest.errorDrawable;
            this.fallbackResId = imageRequest.fallbackResId;
            this.fallbackDrawable = imageRequest.fallbackDrawable;
            this.lifecycle = imageRequest.getDefined().getLifecycle();
            this.sizeResolver = imageRequest.getDefined().getSizeResolver();
            this.scale = imageRequest.getDefined().getScale();
            if (imageRequest.getContext() == context) {
                this.resolvedLifecycle = imageRequest.getLifecycle();
                this.resolvedSizeResolver = imageRequest.getSizeResolver();
                this.resolvedScale = imageRequest.getScale();
            } else {
                this.resolvedLifecycle = null;
                this.resolvedSizeResolver = null;
                this.resolvedScale = null;
            }
        }
    }
}
