package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a>\u0010\f\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {BuildConfig.FLAVOR, "width", "height", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "config", BuildConfig.FLAVOR, "hasAlpha", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "colorSpace", "Landroidx/compose/ui/graphics/ImageBitmap;", "ImageBitmap-x__-hDU", "(IIIZLandroidx/compose/ui/graphics/colorspace/ColorSpace;)Landroidx/compose/ui/graphics/ImageBitmap;", "ImageBitmap", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ImageBitmapKt {
    /* renamed from: ImageBitmap-x__-hDU, reason: not valid java name */
    public static final ImageBitmap m1543ImageBitmapx__hDU(int i5, int i6, int i7, boolean z5, ColorSpace colorSpace) {
        return AndroidImageBitmap_androidKt.m1399ActualImageBitmapx__hDU(i5, i6, i7, z5, colorSpace);
    }

    /* renamed from: ImageBitmap-x__-hDU$default, reason: not valid java name */
    public static /* synthetic */ ImageBitmap m1544ImageBitmapx__hDU$default(int i5, int i6, int i7, boolean z5, ColorSpace colorSpace, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            i7 = ImageBitmapConfig.INSTANCE.m1539getArgb8888_sVssgQ();
        }
        if ((i8 & 8) != 0) {
            z5 = true;
        }
        if ((i8 & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return m1543ImageBitmapx__hDU(i5, i6, i7, z5, colorSpace);
    }
}
