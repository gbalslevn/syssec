package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.colorspace.ColorSpaceKt;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u001a\u0010\f\u001a\u00020\u000b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015R\u0017\u0010\u001e\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015R\u0017\u0010 \u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b \u0010\u0013\u001a\u0004\b!\u0010\u0015R\u0017\u0010\"\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010\u0015R\u0017\u0010$\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b$\u0010\u0013\u001a\u0004\b%\u0010\u0015R\u0017\u0010&\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b&\u0010\u0013\u001a\u0004\b'\u0010\u0015R\u0017\u0010(\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b(\u0010\u0013\u001a\u0004\b)\u0010\u0015R\u0017\u0010*\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b*\u0010\u0013\u001a\u0004\b+\u0010\u0015R\u0017\u0010,\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b,\u0010\u0013\u001a\u0004\b-\u0010\u0015R\u0017\u0010.\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b.\u0010\u0013\u001a\u0004\b/\u0010\u0015R\u0017\u00101\u001a\u0002008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0017\u00105\u001a\u0002008\u0006¢\u0006\f\n\u0004\b5\u00102\u001a\u0004\b6\u00104R\u001a\u00107\u001a\u00020\u00118\u0000X\u0080\u0004¢\u0006\f\n\u0004\b7\u0010\u0013\u001a\u0004\b8\u0010\u0015R\u0017\u00109\u001a\u0002008\u0006¢\u0006\f\n\u0004\b9\u00102\u001a\u0004\b:\u00104R \u0010<\u001a\b\u0012\u0004\u0012\u0002000;8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?¨\u0006@"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/ColorSpaces;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "SrgbPrimaries", "[F", "getSrgbPrimaries$ui_graphics_release", "()[F", "Ntsc1953Primaries", "getNtsc1953Primaries$ui_graphics_release", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "SrgbTransferParameters", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "getSrgbTransferParameters$ui_graphics_release", "()Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "NoneTransferParameters", "Landroidx/compose/ui/graphics/colorspace/Rgb;", "Srgb", "Landroidx/compose/ui/graphics/colorspace/Rgb;", "getSrgb", "()Landroidx/compose/ui/graphics/colorspace/Rgb;", "LinearSrgb", "getLinearSrgb", "ExtendedSrgb", "getExtendedSrgb", "LinearExtendedSrgb", "getLinearExtendedSrgb", "Bt709", "getBt709", "Bt2020", "getBt2020", "DciP3", "getDciP3", "DisplayP3", "getDisplayP3", "Ntsc1953", "getNtsc1953", "SmpteC", "getSmpteC", "AdobeRgb", "getAdobeRgb", "ProPhotoRgb", "getProPhotoRgb", "Aces", "getAces", "Acescg", "getAcescg", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "CieXyz", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getCieXyz", "()Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "CieLab", "getCieLab", "Unspecified", "getUnspecified$ui_graphics_release", "Oklab", "getOklab", BuildConfig.FLAVOR, "ColorSpacesArray", "[Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getColorSpacesArray$ui_graphics_release", "()[Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ColorSpaces {
    private static final Rgb Aces;
    private static final Rgb Acescg;
    private static final Rgb AdobeRgb;
    private static final Rgb Bt2020;
    private static final Rgb Bt709;
    private static final ColorSpace CieLab;
    private static final ColorSpace CieXyz;
    private static final ColorSpace[] ColorSpacesArray;
    private static final Rgb DciP3;
    private static final Rgb DisplayP3;
    private static final Rgb ExtendedSrgb;
    public static final ColorSpaces INSTANCE = new ColorSpaces();
    private static final Rgb LinearExtendedSrgb;
    private static final Rgb LinearSrgb;
    private static final TransferParameters NoneTransferParameters;
    private static final Rgb Ntsc1953;
    private static final float[] Ntsc1953Primaries;
    private static final ColorSpace Oklab;
    private static final Rgb ProPhotoRgb;
    private static final Rgb SmpteC;
    private static final Rgb Srgb;
    private static final float[] SrgbPrimaries;
    private static final TransferParameters SrgbTransferParameters;
    private static final Rgb Unspecified;

    static {
        float[] fArr = {0.64f, 0.33f, 0.3f, 0.6f, 0.15f, 0.06f};
        SrgbPrimaries = fArr;
        float[] fArr2 = {0.67f, 0.33f, 0.21f, 0.71f, 0.14f, 0.08f};
        Ntsc1953Primaries = fArr2;
        TransferParameters transferParameters = new TransferParameters(2.4d, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d, 0.0d, 0.0d, 96, null);
        SrgbTransferParameters = transferParameters;
        TransferParameters transferParameters2 = new TransferParameters(2.2d, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d, 0.0d, 0.0d, 96, null);
        NoneTransferParameters = transferParameters2;
        Illuminant illuminant = Illuminant.INSTANCE;
        Rgb rgb = new Rgb("sRGB IEC61966-2.1", fArr, illuminant.getD65(), transferParameters, 0);
        Srgb = rgb;
        Rgb rgb2 = new Rgb("sRGB IEC61966-2.1 (Linear)", fArr, illuminant.getD65(), 1.0d, 0.0f, 1.0f, 1);
        LinearSrgb = rgb2;
        Rgb rgb3 = new Rgb("scRGB-nl IEC 61966-2-2:2003", fArr, illuminant.getD65(), null, new DoubleFunction() { // from class: n.a
            @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
            public final double invoke(double d5) {
                double absRcpResponse;
                absRcpResponse = ColorSpaceKt.absRcpResponse(d5, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d, 2.4d);
                return absRcpResponse;
            }
        }, new DoubleFunction() { // from class: n.b
            @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
            public final double invoke(double d5) {
                double absResponse;
                absResponse = ColorSpaceKt.absResponse(d5, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d, 2.4d);
                return absResponse;
            }
        }, -0.799f, 2.399f, transferParameters, 2);
        ExtendedSrgb = rgb3;
        Rgb rgb4 = new Rgb("scRGB IEC 61966-2-2:2003", fArr, illuminant.getD65(), 1.0d, -0.5f, 7.499f, 3);
        LinearExtendedSrgb = rgb4;
        Rgb rgb5 = new Rgb("Rec. ITU-R BT.709-5", new float[]{0.64f, 0.33f, 0.3f, 0.6f, 0.15f, 0.06f}, illuminant.getD65(), new TransferParameters(2.2222222222222223d, 0.9099181073703367d, 0.09008189262966333d, 0.2222222222222222d, 0.081d, 0.0d, 0.0d, 96, null), 4);
        Bt709 = rgb5;
        Rgb rgb6 = new Rgb("Rec. ITU-R BT.2020-1", new float[]{0.708f, 0.292f, 0.17f, 0.797f, 0.131f, 0.046f}, illuminant.getD65(), new TransferParameters(2.2222222222222223d, 0.9096697898662786d, 0.09033021013372146d, 0.2222222222222222d, 0.08145d, 0.0d, 0.0d, 96, null), 5);
        Bt2020 = rgb6;
        Rgb rgb7 = new Rgb("SMPTE RP 431-2-2007 DCI (P3)", new float[]{0.68f, 0.32f, 0.265f, 0.69f, 0.15f, 0.06f}, new WhitePoint(0.314f, 0.351f), 2.6d, 0.0f, 1.0f, 6);
        DciP3 = rgb7;
        Rgb rgb8 = new Rgb("Display P3", new float[]{0.68f, 0.32f, 0.265f, 0.69f, 0.15f, 0.06f}, illuminant.getD65(), transferParameters, 7);
        DisplayP3 = rgb8;
        Rgb rgb9 = new Rgb("NTSC (1953)", fArr2, illuminant.getC(), new TransferParameters(2.2222222222222223d, 0.9099181073703367d, 0.09008189262966333d, 0.2222222222222222d, 0.081d, 0.0d, 0.0d, 96, null), 8);
        Ntsc1953 = rgb9;
        Rgb rgb10 = new Rgb("SMPTE-C RGB", new float[]{0.63f, 0.34f, 0.31f, 0.595f, 0.155f, 0.07f}, illuminant.getD65(), new TransferParameters(2.2222222222222223d, 0.9099181073703367d, 0.09008189262966333d, 0.2222222222222222d, 0.081d, 0.0d, 0.0d, 96, null), 9);
        SmpteC = rgb10;
        Rgb rgb11 = new Rgb("Adobe RGB (1998)", new float[]{0.64f, 0.33f, 0.21f, 0.71f, 0.15f, 0.06f}, illuminant.getD65(), 2.2d, 0.0f, 1.0f, 10);
        AdobeRgb = rgb11;
        Rgb rgb12 = new Rgb("ROMM RGB ISO 22028-2:2013", new float[]{0.7347f, 0.2653f, 0.1596f, 0.8404f, 0.0366f, 1.0E-4f}, illuminant.getD50(), new TransferParameters(1.8d, 1.0d, 0.0d, 0.0625d, 0.031248d, 0.0d, 0.0d, 96, null), 11);
        ProPhotoRgb = rgb12;
        Rgb rgb13 = new Rgb("SMPTE ST 2065-1:2012 ACES", new float[]{0.7347f, 0.2653f, 0.0f, 1.0f, 1.0E-4f, -0.077f}, illuminant.getD60(), 1.0d, -65504.0f, 65504.0f, 12);
        Aces = rgb13;
        Rgb rgb14 = new Rgb("Academy S-2014-004 ACEScg", new float[]{0.713f, 0.293f, 0.165f, 0.83f, 0.128f, 0.044f}, illuminant.getD60(), 1.0d, -65504.0f, 65504.0f, 13);
        Acescg = rgb14;
        Xyz xyz = new Xyz("Generic XYZ", 14);
        CieXyz = xyz;
        Lab lab = new Lab("Generic L*a*b*", 15);
        CieLab = lab;
        Rgb rgb15 = new Rgb("None", fArr, illuminant.getD65(), transferParameters2, 16);
        Unspecified = rgb15;
        Oklab oklab = new Oklab("Oklab", 17);
        Oklab = oklab;
        ColorSpacesArray = new ColorSpace[]{rgb, rgb2, rgb3, rgb4, rgb5, rgb6, rgb7, rgb8, rgb9, rgb10, rgb11, rgb12, rgb13, rgb14, xyz, lab, rgb15, oklab};
    }

    private ColorSpaces() {
    }

    public final Rgb getAces() {
        return Aces;
    }

    public final Rgb getAcescg() {
        return Acescg;
    }

    public final Rgb getAdobeRgb() {
        return AdobeRgb;
    }

    public final Rgb getBt2020() {
        return Bt2020;
    }

    public final Rgb getBt709() {
        return Bt709;
    }

    public final ColorSpace getCieLab() {
        return CieLab;
    }

    public final ColorSpace getCieXyz() {
        return CieXyz;
    }

    public final ColorSpace[] getColorSpacesArray$ui_graphics_release() {
        return ColorSpacesArray;
    }

    public final Rgb getDciP3() {
        return DciP3;
    }

    public final Rgb getDisplayP3() {
        return DisplayP3;
    }

    public final Rgb getExtendedSrgb() {
        return ExtendedSrgb;
    }

    public final Rgb getLinearExtendedSrgb() {
        return LinearExtendedSrgb;
    }

    public final Rgb getLinearSrgb() {
        return LinearSrgb;
    }

    public final Rgb getNtsc1953() {
        return Ntsc1953;
    }

    public final float[] getNtsc1953Primaries$ui_graphics_release() {
        return Ntsc1953Primaries;
    }

    public final ColorSpace getOklab() {
        return Oklab;
    }

    public final Rgb getProPhotoRgb() {
        return ProPhotoRgb;
    }

    public final Rgb getSmpteC() {
        return SmpteC;
    }

    public final Rgb getSrgb() {
        return Srgb;
    }

    public final float[] getSrgbPrimaries$ui_graphics_release() {
        return SrgbPrimaries;
    }

    public final Rgb getUnspecified$ui_graphics_release() {
        return Unspecified;
    }
}
