package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import com.sdk.growthbook.utils.Constants;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\u000bJ'\u0010\u0013\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0010¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0016\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0010¢\u0006\u0004\b\u0014\u0010\u0015J=\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0001H\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Xyz;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "<init>", "(Ljava/lang/String;I)V", "component", BuildConfig.FLAVOR, "getMinValue", "(I)F", "getMaxValue", "v0", "v1", "v2", BuildConfig.FLAVOR, "toXy$ui_graphics_release", "(FFF)J", "toXy", "toZ$ui_graphics_release", "(FFF)F", "toZ", "x", "y", "z", "a", "colorSpace", "Landroidx/compose/ui/graphics/Color;", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "xyzaToColor", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Xyz extends ColorSpace {
    public Xyz(String str, int i5) {
        super(str, ColorModel.INSTANCE.m1644getXyzxdoWZVw(), i5, null);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int component) {
        return 2.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMinValue(int component) {
        return -2.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float v02, float v12, float v22) {
        if (v02 < -2.0f) {
            v02 = -2.0f;
        }
        if (v02 > 2.0f) {
            v02 = 2.0f;
        }
        if (v12 < -2.0f) {
            v12 = -2.0f;
        }
        return (Float.floatToRawIntBits(v02) << 32) | (Float.floatToRawIntBits(v12 <= 2.0f ? v12 : 2.0f) & 4294967295L);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float v02, float v12, float v22) {
        if (v22 < -2.0f) {
            v22 = -2.0f;
        }
        if (v22 > 2.0f) {
            return 2.0f;
        }
        return v22;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public long mo1646xyzaToColorJlNiLsg$ui_graphics_release(float x5, float y5, float z5, float a5, ColorSpace colorSpace) {
        if (x5 < -2.0f) {
            x5 = -2.0f;
        }
        if (x5 > 2.0f) {
            x5 = 2.0f;
        }
        if (y5 < -2.0f) {
            y5 = -2.0f;
        }
        if (y5 > 2.0f) {
            y5 = 2.0f;
        }
        if (z5 < -2.0f) {
            z5 = -2.0f;
        }
        return ColorKt.Color(x5, y5, z5 <= 2.0f ? z5 : 2.0f, a5, colorSpace);
    }
}
