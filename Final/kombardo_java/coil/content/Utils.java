package coil.content;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.net.Uri;
import android.os.Looper;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import coil.EventListener;
import coil.decode.DataSource;
import coil.disk.DiskCache;
import coil.intercept.Interceptor;
import coil.intercept.RealInterceptorChain;
import coil.request.Parameters;
import coil.request.Tags;
import coil.size.Dimension;
import coil.size.Scale;
import java.io.Closeable;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001f\u0010\u0007\u001a\u0004\u0018\u00010\u0005*\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0015\u0010\n\u001a\u00020\t*\u0004\u0018\u00010\tH\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0015\u0010\n\u001a\u00020\f*\u0004\u0018\u00010\fH\u0000¢\u0006\u0004\b\n\u0010\r\u001a\u0015\u0010\n\u001a\u00020\u000e*\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0004\b\n\u0010\u000f\u001a\u000f\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001b\u0010\u0015\u001a\u00020\u0013*\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0013\u0010\u0018\u001a\u00020\u0001*\u00020\u0017H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0013\u0010\u001a\u001a\u00020\u0010*\u00020\u0013H\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001b\u0010\u001f\u001a\u00020\u0013*\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001dH\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u0017\u0010#\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020!H\u0000¢\u0006\u0004\b#\u0010$\u001a\u001b\u0010'\u001a\u00020%*\u00020%2\u0006\u0010&\u001a\u00020\u0005H\u0000¢\u0006\u0004\b'\u0010(\u001a\u0013\u0010+\u001a\u00020**\u00020)H\u0000¢\u0006\u0004\b+\u0010,\u001a\u0017\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020-H\u0000¢\u0006\u0004\b0\u00101\u001a\u001f\u00103\u001a\u00020\u00132\u0006\u0010.\u001a\u00020-2\u0006\u00102\u001a\u00020/H\u0000¢\u0006\u0004\b3\u00104\" \u00107\u001a\b\u0012\u0004\u0012\u000206058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u001a\u0010;\u001a\u0002068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u001c\u0010@\u001a\u0004\u0018\u00010?8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u001a\u0010D\u001a\u00020\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0014\u0010H\u001a\u00020/8\u0002X\u0082T¢\u0006\u0006\n\u0004\bH\u0010I\"\u0014\u0010J\u001a\u00020/8\u0002X\u0082T¢\u0006\u0006\n\u0004\bJ\u0010I\"\u0014\u0010K\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\bK\u0010L\"\u0018\u0010P\u001a\u00020\u0005*\u00020M8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bN\u0010O\"\u0018\u0010T\u001a\u00020\u0013*\u00020Q8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bR\u0010S\"\u0018\u0010V\u001a\u00020\u0013*\u00020Q8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bU\u0010S\"\u0018\u0010W\u001a\u00020\u0010*\u00020Q8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bW\u0010X\"\u0018\u0010\u001e\u001a\u00020\u001d*\u00020Y8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010[\"\u001a\u0010^\u001a\u0004\u0018\u00010\u0005*\u00020!8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010]\"\u0018\u0010b\u001a\u00020\u0013*\u00020_8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b`\u0010a\"\u0018\u0010f\u001a\u00020c*\u00020-8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bd\u0010e\"\u0018\u0010h\u001a\u00020\u0010*\u00020g8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bh\u0010i\"\u0018\u0010m\u001a\u00020j*\u00020g8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bk\u0010l¨\u0006n"}, d2 = {"Ljava/io/Closeable;", BuildConfig.FLAVOR, "closeQuietly", "(Ljava/io/Closeable;)V", "Landroid/webkit/MimeTypeMap;", BuildConfig.FLAVOR, "url", "getMimeTypeFromUrl", "(Landroid/webkit/MimeTypeMap;Ljava/lang/String;)Ljava/lang/String;", "Lokhttp3/Headers;", "orEmpty", "(Lokhttp3/Headers;)Lokhttp3/Headers;", "Lcoil/request/Tags;", "(Lcoil/request/Tags;)Lcoil/request/Tags;", "Lcoil/request/Parameters;", "(Lcoil/request/Parameters;)Lcoil/request/Parameters;", BuildConfig.FLAVOR, "isMainThread", "()Z", BuildConfig.FLAVOR, "defaultValue", "toNonNegativeInt", "(Ljava/lang/String;I)I", "Lcoil/disk/DiskCache$Editor;", "abortQuietly", "(Lcoil/disk/DiskCache$Editor;)V", "isMinOrMax", "(I)Z", "Lcoil/size/Dimension;", "Lcoil/size/Scale;", "scale", "toPx", "(Lcoil/size/Dimension;Lcoil/size/Scale;)I", "Landroid/net/Uri;", "uri", "isAssetUri", "(Landroid/net/Uri;)Z", "Lokhttp3/Headers$Builder;", "line", "addUnsafeNonAscii", "(Lokhttp3/Headers$Builder;Ljava/lang/String;)Lokhttp3/Headers$Builder;", "Lokhttp3/Response;", "Lokhttp3/ResponseBody;", "requireBody", "(Lokhttp3/Response;)Lokhttp3/ResponseBody;", "Landroid/content/Context;", "context", BuildConfig.FLAVOR, "defaultMemoryCacheSizePercent", "(Landroid/content/Context;)D", "percent", "calculateMemoryCacheSize", "(Landroid/content/Context;D)I", BuildConfig.FLAVOR, "Landroid/graphics/Bitmap$Config;", "VALID_TRANSFORMATION_CONFIGS", "[Landroid/graphics/Bitmap$Config;", "getVALID_TRANSFORMATION_CONFIGS", "()[Landroid/graphics/Bitmap$Config;", "DEFAULT_BITMAP_CONFIG", "Landroid/graphics/Bitmap$Config;", "getDEFAULT_BITMAP_CONFIG", "()Landroid/graphics/Bitmap$Config;", "Landroid/graphics/ColorSpace;", "NULL_COLOR_SPACE", "Landroid/graphics/ColorSpace;", "getNULL_COLOR_SPACE", "()Landroid/graphics/ColorSpace;", "EMPTY_HEADERS", "Lokhttp3/Headers;", "getEMPTY_HEADERS", "()Lokhttp3/Headers;", "STANDARD_MEMORY_MULTIPLIER", "D", "LOW_MEMORY_MULTIPLIER", "DEFAULT_MEMORY_CLASS_MEGABYTES", "I", "Lcoil/decode/DataSource;", "getEmoji", "(Lcoil/decode/DataSource;)Ljava/lang/String;", "emoji", "Landroid/graphics/drawable/Drawable;", "getWidth", "(Landroid/graphics/drawable/Drawable;)I", "width", "getHeight", "height", "isVector", "(Landroid/graphics/drawable/Drawable;)Z", "Landroid/widget/ImageView;", "getScale", "(Landroid/widget/ImageView;)Lcoil/size/Scale;", "getFirstPathSegment", "(Landroid/net/Uri;)Ljava/lang/String;", "firstPathSegment", "Landroid/content/res/Configuration;", "getNightMode", "(Landroid/content/res/Configuration;)I", "nightMode", "Ljava/io/File;", "getSafeCacheDir", "(Landroid/content/Context;)Ljava/io/File;", "safeCacheDir", "Lcoil/intercept/Interceptor$Chain;", "isPlaceholderCached", "(Lcoil/intercept/Interceptor$Chain;)Z", "Lcoil/EventListener;", "getEventListener", "(Lcoil/intercept/Interceptor$Chain;)Lcoil/EventListener;", "eventListener", "coil-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* renamed from: coil.util.-Utils, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class Utils {
    private static final int DEFAULT_MEMORY_CLASS_MEGABYTES = 256;
    private static final double LOW_MEMORY_MULTIPLIER = 0.15d;
    private static final ColorSpace NULL_COLOR_SPACE = null;
    private static final double STANDARD_MEMORY_MULTIPLIER = 0.2d;
    private static final Bitmap.Config[] VALID_TRANSFORMATION_CONFIGS = {Bitmap.Config.ARGB_8888, Bitmap.Config.RGBA_F16};
    private static final Bitmap.Config DEFAULT_BITMAP_CONFIG = Bitmap.Config.HARDWARE;
    private static final Headers EMPTY_HEADERS = new Headers.Builder().build();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: coil.util.-Utils$WhenMappings */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[DataSource.values().length];
            try {
                iArr[DataSource.MEMORY_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DataSource.MEMORY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DataSource.DISK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DataSource.NETWORK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            try {
                iArr2[ImageView.ScaleType.FIT_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[Scale.values().length];
            try {
                iArr3[Scale.FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[Scale.FIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public static final void abortQuietly(DiskCache.Editor editor) {
        try {
            editor.abort();
        } catch (Exception unused) {
        }
    }

    public static final Headers.Builder addUnsafeNonAscii(Headers.Builder builder, String str) {
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, ':', 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            throw new IllegalArgumentException(("Unexpected header: " + str).toString());
        }
        String substring = str.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        String obj = StringsKt.trim(substring).toString();
        String substring2 = str.substring(indexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        builder.addUnsafeNonAscii(obj, substring2);
        return builder;
    }

    public static final int calculateMemoryCacheSize(Context context, double d5) {
        int i5;
        try {
            Object systemService = ContextCompat.getSystemService(context, ActivityManager.class);
            Intrinsics.checkNotNull(systemService);
            ActivityManager activityManager = (ActivityManager) systemService;
            i5 = (context.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass();
        } catch (Exception unused) {
            i5 = 256;
        }
        double d6 = 1024;
        return (int) (d5 * i5 * d6 * d6);
    }

    public static final void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (RuntimeException e5) {
            throw e5;
        } catch (Exception unused) {
        }
    }

    public static final double defaultMemoryCacheSizePercent(Context context) {
        try {
            Object systemService = ContextCompat.getSystemService(context, ActivityManager.class);
            Intrinsics.checkNotNull(systemService);
            return ((ActivityManager) systemService).isLowRamDevice() ? LOW_MEMORY_MULTIPLIER : STANDARD_MEMORY_MULTIPLIER;
        } catch (Exception unused) {
            return STANDARD_MEMORY_MULTIPLIER;
        }
    }

    public static final Bitmap.Config getDEFAULT_BITMAP_CONFIG() {
        return DEFAULT_BITMAP_CONFIG;
    }

    public static final String getEmoji(DataSource dataSource) {
        int i5 = WhenMappings.$EnumSwitchMapping$0[dataSource.ordinal()];
        if (i5 == 1 || i5 == 2) {
            return "🧠";
        }
        if (i5 == 3) {
            return "💾";
        }
        if (i5 == 4) {
            return "☁️ ";
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final EventListener getEventListener(Interceptor.Chain chain) {
        return chain instanceof RealInterceptorChain ? ((RealInterceptorChain) chain).getEventListener() : EventListener.NONE;
    }

    public static final String getFirstPathSegment(Uri uri) {
        return (String) CollectionsKt.firstOrNull((List) uri.getPathSegments());
    }

    public static final int getHeight(Drawable drawable) {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        return (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) ? drawable.getIntrinsicHeight() : bitmap.getHeight();
    }

    public static final String getMimeTypeFromUrl(MimeTypeMap mimeTypeMap, String str) {
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        return mimeTypeMap.getMimeTypeFromExtension(StringsKt.substringAfterLast(StringsKt.substringAfterLast$default(StringsKt.substringBeforeLast$default(StringsKt.substringBeforeLast$default(str, '#', null, 2, null), '?', null, 2, null), '/', (String) null, 2, (Object) null), '.', BuildConfig.FLAVOR));
    }

    public static final int getNightMode(Configuration configuration) {
        return configuration.uiMode & 48;
    }

    public static final File getSafeCacheDir(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            throw new IllegalStateException("cacheDir == null");
        }
        cacheDir.mkdirs();
        return cacheDir;
    }

    public static final Scale getScale(ImageView imageView) {
        ImageView.ScaleType scaleType = imageView.getScaleType();
        int i5 = scaleType == null ? -1 : WhenMappings.$EnumSwitchMapping$1[scaleType.ordinal()];
        return (i5 == 1 || i5 == 2 || i5 == 3 || i5 == 4) ? Scale.FIT : Scale.FILL;
    }

    public static final Bitmap.Config[] getVALID_TRANSFORMATION_CONFIGS() {
        return VALID_TRANSFORMATION_CONFIGS;
    }

    public static final int getWidth(Drawable drawable) {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        return (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) ? drawable.getIntrinsicWidth() : bitmap.getWidth();
    }

    public static final boolean isAssetUri(Uri uri) {
        return Intrinsics.areEqual(uri.getScheme(), "file") && Intrinsics.areEqual(getFirstPathSegment(uri), "android_asset");
    }

    public static final boolean isMainThread() {
        return Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
    }

    public static final boolean isMinOrMax(int i5) {
        return i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE;
    }

    public static final boolean isPlaceholderCached(Interceptor.Chain chain) {
        return (chain instanceof RealInterceptorChain) && ((RealInterceptorChain) chain).getIsPlaceholderCached();
    }

    public static final boolean isVector(Drawable drawable) {
        return (drawable instanceof VectorDrawable) || (drawable instanceof VectorDrawableCompat);
    }

    public static final Headers orEmpty(Headers headers) {
        return headers == null ? EMPTY_HEADERS : headers;
    }

    public static final ResponseBody requireBody(Response response) {
        ResponseBody body = response.getBody();
        if (body != null) {
            return body;
        }
        throw new IllegalStateException("response body == null");
    }

    public static final int toNonNegativeInt(String str, int i5) {
        Long longOrNull = StringsKt.toLongOrNull(str);
        if (longOrNull == null) {
            return i5;
        }
        long longValue = longOrNull.longValue();
        if (longValue > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (longValue < 0) {
            return 0;
        }
        return (int) longValue;
    }

    public static final int toPx(Dimension dimension, Scale scale) {
        if (dimension instanceof Dimension.Pixels) {
            return ((Dimension.Pixels) dimension).px;
        }
        int i5 = WhenMappings.$EnumSwitchMapping$2[scale.ordinal()];
        if (i5 == 1) {
            return Integer.MIN_VALUE;
        }
        if (i5 == 2) {
            return Integer.MAX_VALUE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Tags orEmpty(Tags tags) {
        return tags == null ? Tags.EMPTY : tags;
    }

    public static final Parameters orEmpty(Parameters parameters) {
        return parameters == null ? Parameters.EMPTY : parameters;
    }
}
