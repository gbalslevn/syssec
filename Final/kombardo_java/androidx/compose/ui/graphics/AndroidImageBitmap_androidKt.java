package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a:\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\n\u0010\r\u001a\u00020\u000e*\u00020\u0001\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\u000e\u001a\u0016\u0010\u0010\u001a\u00020\u0011*\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0011\u0010\u0014\u001a\u00020\u0006*\u00020\u0011H\u0000¢\u0006\u0002\u0010\u0015\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, d2 = {"ActualImageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "width", BuildConfig.FLAVOR, "height", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "hasAlpha", BuildConfig.FLAVOR, "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "ActualImageBitmap-x__-hDU", "(IIIZLandroidx/compose/ui/graphics/colorspace/ColorSpace;)Landroidx/compose/ui/graphics/ImageBitmap;", "asAndroidBitmap", "Landroid/graphics/Bitmap;", "asImageBitmap", "toBitmapConfig", "Landroid/graphics/Bitmap$Config;", "toBitmapConfig-1JJdX4A", "(I)Landroid/graphics/Bitmap$Config;", "toImageConfig", "(Landroid/graphics/Bitmap$Config;)I", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AndroidImageBitmap_androidKt {
    /* renamed from: ActualImageBitmap-x__-hDU, reason: not valid java name */
    public static final ImageBitmap m1399ActualImageBitmapx__hDU(int i5, int i6, int i7, boolean z5, ColorSpace colorSpace) {
        Bitmap createBitmap;
        m1400toBitmapConfig1JJdX4A(i7);
        createBitmap = Bitmap.createBitmap((DisplayMetrics) null, i5, i6, m1400toBitmapConfig1JJdX4A(i7), z5, AndroidColorSpace_androidKt.toAndroidColorSpace(colorSpace));
        return new AndroidImageBitmap(createBitmap);
    }

    public static final Bitmap asAndroidBitmap(ImageBitmap imageBitmap) {
        if (imageBitmap instanceof AndroidImageBitmap) {
            return ((AndroidImageBitmap) imageBitmap).getBitmap();
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Bitmap");
    }

    public static final ImageBitmap asImageBitmap(Bitmap bitmap) {
        return new AndroidImageBitmap(bitmap);
    }

    /* renamed from: toBitmapConfig-1JJdX4A, reason: not valid java name */
    public static final Bitmap.Config m1400toBitmapConfig1JJdX4A(int i5) {
        ImageBitmapConfig.Companion companion = ImageBitmapConfig.INSTANCE;
        return ImageBitmapConfig.m1534equalsimpl0(i5, companion.m1539getArgb8888_sVssgQ()) ? Bitmap.Config.ARGB_8888 : ImageBitmapConfig.m1534equalsimpl0(i5, companion.m1538getAlpha8_sVssgQ()) ? Bitmap.Config.ALPHA_8 : ImageBitmapConfig.m1534equalsimpl0(i5, companion.m1542getRgb565_sVssgQ()) ? Bitmap.Config.RGB_565 : ImageBitmapConfig.m1534equalsimpl0(i5, companion.m1540getF16_sVssgQ()) ? Bitmap.Config.RGBA_F16 : ImageBitmapConfig.m1534equalsimpl0(i5, companion.m1541getGpu_sVssgQ()) ? Bitmap.Config.HARDWARE : Bitmap.Config.ARGB_8888;
    }

    public static final int toImageConfig(Bitmap.Config config) {
        return config == Bitmap.Config.ALPHA_8 ? ImageBitmapConfig.INSTANCE.m1538getAlpha8_sVssgQ() : config == Bitmap.Config.RGB_565 ? ImageBitmapConfig.INSTANCE.m1542getRgb565_sVssgQ() : config == Bitmap.Config.ARGB_4444 ? ImageBitmapConfig.INSTANCE.m1539getArgb8888_sVssgQ() : config == Bitmap.Config.RGBA_F16 ? ImageBitmapConfig.INSTANCE.m1540getF16_sVssgQ() : config == Bitmap.Config.HARDWARE ? ImageBitmapConfig.INSTANCE.m1541getGpu_sVssgQ() : ImageBitmapConfig.INSTANCE.m1539getArgb8888_sVssgQ();
    }
}
