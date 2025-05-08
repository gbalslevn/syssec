package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.util.MathHelpersKt;
import com.sdk.growthbook.utils.Constants;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\u000bJ'\u0010\u0013\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0010¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0016\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0010¢\u0006\u0004\b\u0014\u0010\u0015J=\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0001H\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Oklab;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "<init>", "(Ljava/lang/String;I)V", "component", BuildConfig.FLAVOR, "getMinValue", "(I)F", "getMaxValue", "v0", "v1", "v2", BuildConfig.FLAVOR, "toXy$ui_graphics_release", "(FFF)J", "toXy", "toZ$ui_graphics_release", "(FFF)F", "toZ", "x", "y", "z", "a", "colorSpace", "Landroidx/compose/ui/graphics/Color;", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "xyzaToColor", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Oklab extends ColorSpace {
    private static final float[] InverseM1;
    private static final float[] InverseM2;

    /* renamed from: M1, reason: collision with root package name */
    private static final float[] f3569M1;

    /* renamed from: M2, reason: collision with root package name */
    private static final float[] f3570M2;

    static {
        float[] transform = Adaptation.INSTANCE.getBradford().getTransform();
        Illuminant illuminant = Illuminant.INSTANCE;
        float[] mul3x3 = ColorSpaceKt.mul3x3(new float[]{0.818933f, 0.032984544f, 0.0482003f, 0.36186674f, 0.9293119f, 0.26436627f, -0.12885971f, 0.03614564f, 0.6338517f}, ColorSpaceKt.chromaticAdaptation(transform, illuminant.getD50().toXyz$ui_graphics_release(), illuminant.getD65().toXyz$ui_graphics_release()));
        f3569M1 = mul3x3;
        float[] fArr = {0.21045426f, 1.9779985f, 0.025904037f, 0.7936178f, -2.4285922f, 0.78277177f, -0.004072047f, 0.4505937f, -0.80867577f};
        f3570M2 = fArr;
        InverseM1 = ColorSpaceKt.inverse3x3(mul3x3);
        InverseM2 = ColorSpaceKt.inverse3x3(fArr);
    }

    public Oklab(String str, int i5) {
        super(str, ColorModel.INSTANCE.m1642getLabxdoWZVw(), i5, null);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int component) {
        return component == 0 ? 1.0f : 0.5f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMinValue(int component) {
        return component == 0 ? 0.0f : -0.5f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float v02, float v12, float v22) {
        if (v02 < 0.0f) {
            v02 = 0.0f;
        }
        if (v02 > 1.0f) {
            v02 = 1.0f;
        }
        if (v12 < -0.5f) {
            v12 = -0.5f;
        }
        if (v12 > 0.5f) {
            v12 = 0.5f;
        }
        if (v22 < -0.5f) {
            v22 = -0.5f;
        }
        float f5 = v22 <= 0.5f ? v22 : 0.5f;
        float[] fArr = InverseM2;
        float f6 = (fArr[0] * v02) + (fArr[3] * v12) + (fArr[6] * f5);
        float f7 = (fArr[1] * v02) + (fArr[4] * v12) + (fArr[7] * f5);
        float f8 = (fArr[2] * v02) + (fArr[5] * v12) + (fArr[8] * f5);
        float f9 = f6 * f6 * f6;
        float f10 = f7 * f7 * f7;
        float f11 = f8 * f8 * f8;
        float[] fArr2 = InverseM1;
        return (Float.floatToRawIntBits(((fArr2[0] * f9) + (fArr2[3] * f10)) + (fArr2[6] * f11)) << 32) | (Float.floatToRawIntBits((fArr2[1] * f9) + (fArr2[4] * f10) + (fArr2[7] * f11)) & 4294967295L);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float v02, float v12, float v22) {
        if (v02 < 0.0f) {
            v02 = 0.0f;
        }
        if (v02 > 1.0f) {
            v02 = 1.0f;
        }
        if (v12 < -0.5f) {
            v12 = -0.5f;
        }
        if (v12 > 0.5f) {
            v12 = 0.5f;
        }
        if (v22 < -0.5f) {
            v22 = -0.5f;
        }
        float f5 = v22 <= 0.5f ? v22 : 0.5f;
        float[] fArr = InverseM2;
        float f6 = (fArr[0] * v02) + (fArr[3] * v12) + (fArr[6] * f5);
        float f7 = (fArr[1] * v02) + (fArr[4] * v12) + (fArr[7] * f5);
        float f8 = (fArr[2] * v02) + (fArr[5] * v12) + (fArr[8] * f5);
        float f9 = f6 * f6 * f6;
        float f10 = f7 * f7 * f7;
        float[] fArr2 = InverseM1;
        return (fArr2[2] * f9) + (fArr2[5] * f10) + (fArr2[8] * f8 * f8 * f8);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public long mo1646xyzaToColorJlNiLsg$ui_graphics_release(float x5, float y5, float z5, float a5, ColorSpace colorSpace) {
        float[] fArr = f3569M1;
        float f5 = (fArr[0] * x5) + (fArr[3] * y5) + (fArr[6] * z5);
        float f6 = (fArr[1] * x5) + (fArr[4] * y5) + (fArr[7] * z5);
        float f7 = (fArr[2] * x5) + (fArr[5] * y5) + (fArr[8] * z5);
        float fastCbrt = MathHelpersKt.fastCbrt(f5);
        float fastCbrt2 = MathHelpersKt.fastCbrt(f6);
        float fastCbrt3 = MathHelpersKt.fastCbrt(f7);
        float[] fArr2 = f3570M2;
        return ColorKt.Color((fArr2[0] * fastCbrt) + (fArr2[3] * fastCbrt2) + (fArr2[6] * fastCbrt3), (fArr2[1] * fastCbrt) + (fArr2[4] * fastCbrt2) + (fArr2[7] * fastCbrt3), (fArr2[2] * fastCbrt) + (fArr2[5] * fastCbrt2) + (fArr2[8] * fastCbrt3), a5, colorSpace);
    }
}
