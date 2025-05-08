package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import com.sdk.growthbook.utils.Constants;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\u000bJ'\u0010\u0013\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0010¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0016\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0010¢\u0006\u0004\b\u0014\u0010\u0015J=\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0001H\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Lab;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "<init>", "(Ljava/lang/String;I)V", "component", BuildConfig.FLAVOR, "getMinValue", "(I)F", "getMaxValue", "v0", "v1", "v2", BuildConfig.FLAVOR, "toXy$ui_graphics_release", "(FFF)J", "toXy", "toZ$ui_graphics_release", "(FFF)F", "toZ", "x", "y", "z", "a", "colorSpace", "Landroidx/compose/ui/graphics/Color;", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "xyzaToColor", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Lab extends ColorSpace {

    /* renamed from: A, reason: collision with root package name */
    private static final float f3565A = 0.008856452f;

    /* renamed from: B, reason: collision with root package name */
    private static final float f3566B = 7.787037f;

    /* renamed from: C, reason: collision with root package name */
    private static final float f3567C = 0.13793103f;

    /* renamed from: D, reason: collision with root package name */
    private static final float f3568D = 0.20689656f;

    public Lab(String str, int i5) {
        super(str, ColorModel.INSTANCE.m1642getLabxdoWZVw(), i5, null);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int component) {
        return component == 0 ? 100.0f : 128.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMinValue(int component) {
        return component == 0 ? 0.0f : -128.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float v02, float v12, float v22) {
        if (v02 < 0.0f) {
            v02 = 0.0f;
        }
        if (v02 > 100.0f) {
            v02 = 100.0f;
        }
        if (v12 < -128.0f) {
            v12 = -128.0f;
        }
        if (v12 > 128.0f) {
            v12 = 128.0f;
        }
        float f5 = (v02 + 16.0f) / 116.0f;
        float f6 = (v12 * 0.002f) + f5;
        float f7 = f6 > f3568D ? f6 * f6 * f6 : (f6 - f3567C) * 0.12841855f;
        float f8 = f5 > f3568D ? f5 * f5 * f5 : (f5 - f3567C) * 0.12841855f;
        float f9 = f7 * Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[0];
        return (Float.floatToRawIntBits(f8 * r5.getD50Xyz$ui_graphics_release()[1]) & 4294967295L) | (Float.floatToRawIntBits(f9) << 32);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float v02, float v12, float v22) {
        if (v02 < 0.0f) {
            v02 = 0.0f;
        }
        if (v02 > 100.0f) {
            v02 = 100.0f;
        }
        if (v22 < -128.0f) {
            v22 = -128.0f;
        }
        if (v22 > 128.0f) {
            v22 = 128.0f;
        }
        float f5 = ((v02 + 16.0f) / 116.0f) - (v22 * 0.005f);
        return (f5 > f3568D ? f5 * f5 * f5 : 0.12841855f * (f5 - f3567C)) * Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[2];
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public long mo1646xyzaToColorJlNiLsg$ui_graphics_release(float x5, float y5, float z5, float a5, ColorSpace colorSpace) {
        Illuminant illuminant = Illuminant.INSTANCE;
        float f5 = x5 / illuminant.getD50Xyz$ui_graphics_release()[0];
        float f6 = y5 / illuminant.getD50Xyz$ui_graphics_release()[1];
        float f7 = z5 / illuminant.getD50Xyz$ui_graphics_release()[2];
        float cbrt = f5 > f3565A ? (float) Math.cbrt(f5) : (f5 * f3566B) + f3567C;
        float cbrt2 = f6 > f3565A ? (float) Math.cbrt(f6) : (f6 * f3566B) + f3567C;
        float f8 = (116.0f * cbrt2) - 16.0f;
        float f9 = (cbrt - cbrt2) * 500.0f;
        float cbrt3 = (cbrt2 - (f7 > f3565A ? (float) Math.cbrt(f7) : (f7 * f3566B) + f3567C)) * 200.0f;
        if (f8 < 0.0f) {
            f8 = 0.0f;
        }
        if (f8 > 100.0f) {
            f8 = 100.0f;
        }
        if (f9 < -128.0f) {
            f9 = -128.0f;
        }
        if (f9 > 128.0f) {
            f9 = 128.0f;
        }
        if (cbrt3 < -128.0f) {
            cbrt3 = -128.0f;
        }
        return ColorKt.Color(f8, f9, cbrt3 <= 128.0f ? cbrt3 : 128.0f, a5, colorSpace);
    }
}
