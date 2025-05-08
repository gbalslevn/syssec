package androidx.compose.ui.graphics;

import android.graphics.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.graphics.colorspace.TransferParameters;
import androidx.compose.ui.graphics.colorspace.WhitePoint;
import java.util.function.DoubleUnaryOperator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0007J\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/graphics/ColorSpaceVerificationHelper;", BuildConfig.FLAVOR, "()V", "androidColorSpace", "Landroid/graphics/ColorSpace;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "composeColorSpace", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ColorSpaceVerificationHelper {
    public static final ColorSpaceVerificationHelper INSTANCE = new ColorSpaceVerificationHelper();

    private ColorSpaceVerificationHelper() {
    }

    public static final ColorSpace androidColorSpace(androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace) {
        ColorSpace.Rgb rgb;
        ColorSpaces colorSpaces = ColorSpaces.INSTANCE;
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getSrgb())) {
            return ColorSpace.get(ColorSpace.Named.SRGB);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getAces())) {
            return ColorSpace.get(ColorSpace.Named.ACES);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getAcescg())) {
            return ColorSpace.get(ColorSpace.Named.ACESCG);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getAdobeRgb())) {
            return ColorSpace.get(ColorSpace.Named.ADOBE_RGB);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getBt2020())) {
            return ColorSpace.get(ColorSpace.Named.BT2020);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getBt709())) {
            return ColorSpace.get(ColorSpace.Named.BT709);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getCieLab())) {
            return ColorSpace.get(ColorSpace.Named.CIE_LAB);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getCieXyz())) {
            return ColorSpace.get(ColorSpace.Named.CIE_XYZ);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getDciP3())) {
            return ColorSpace.get(ColorSpace.Named.DCI_P3);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getDisplayP3())) {
            return ColorSpace.get(ColorSpace.Named.DISPLAY_P3);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getExtendedSrgb())) {
            return ColorSpace.get(ColorSpace.Named.EXTENDED_SRGB);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getLinearExtendedSrgb())) {
            return ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getLinearSrgb())) {
            return ColorSpace.get(ColorSpace.Named.LINEAR_SRGB);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getNtsc1953())) {
            return ColorSpace.get(ColorSpace.Named.NTSC_1953);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getProPhotoRgb())) {
            return ColorSpace.get(ColorSpace.Named.PRO_PHOTO_RGB);
        }
        if (Intrinsics.areEqual(colorSpace, colorSpaces.getSmpteC())) {
            return ColorSpace.get(ColorSpace.Named.SMPTE_C);
        }
        if (!(colorSpace instanceof Rgb)) {
            return ColorSpace.get(ColorSpace.Named.SRGB);
        }
        Rgb rgb2 = (Rgb) colorSpace;
        float[] xyz$ui_graphics_release = rgb2.getWhitePoint().toXyz$ui_graphics_release();
        TransferParameters transferParameters = rgb2.getTransferParameters();
        ColorSpace.Rgb.TransferParameters transferParameters2 = transferParameters != null ? new ColorSpace.Rgb.TransferParameters(transferParameters.getA(), transferParameters.getB(), transferParameters.getC(), transferParameters.getD(), transferParameters.getE(), transferParameters.getF(), transferParameters.getGamma()) : null;
        if (transferParameters2 != null) {
            rgb = new ColorSpace.Rgb(colorSpace.getName(), rgb2.getPrimaries(), xyz$ui_graphics_release, transferParameters2);
        } else {
            String name = colorSpace.getName();
            float[] primaries = rgb2.getPrimaries();
            final Function1<Double, Double> oetf = rgb2.getOetf();
            DoubleUnaryOperator doubleUnaryOperator = new DoubleUnaryOperator() { // from class: androidx.compose.ui.graphics.a
                @Override // java.util.function.DoubleUnaryOperator
                public final double applyAsDouble(double d5) {
                    double androidColorSpace$lambda$0;
                    androidColorSpace$lambda$0 = ColorSpaceVerificationHelper.androidColorSpace$lambda$0(Function1.this, d5);
                    return androidColorSpace$lambda$0;
                }
            };
            final Function1<Double, Double> eotf = rgb2.getEotf();
            rgb = new ColorSpace.Rgb(name, primaries, xyz$ui_graphics_release, doubleUnaryOperator, new DoubleUnaryOperator() { // from class: androidx.compose.ui.graphics.b
                @Override // java.util.function.DoubleUnaryOperator
                public final double applyAsDouble(double d5) {
                    double androidColorSpace$lambda$1;
                    androidColorSpace$lambda$1 = ColorSpaceVerificationHelper.androidColorSpace$lambda$1(Function1.this, d5);
                    return androidColorSpace$lambda$1;
                }
            }, colorSpace.getMinValue(0), colorSpace.getMaxValue(0));
        }
        return rgb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double androidColorSpace$lambda$0(Function1 function1, double d5) {
        return ((Number) function1.invoke(Double.valueOf(d5))).doubleValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double androidColorSpace$lambda$1(Function1 function1, double d5) {
        return ((Number) function1.invoke(Double.valueOf(d5))).doubleValue();
    }

    public static final androidx.compose.ui.graphics.colorspace.ColorSpace composeColorSpace(final ColorSpace colorSpace) {
        WhitePoint whitePoint;
        TransferParameters transferParameters;
        int id = colorSpace.getId();
        if (id == ColorSpace.Named.SRGB.ordinal()) {
            return ColorSpaces.INSTANCE.getSrgb();
        }
        if (id == ColorSpace.Named.ACES.ordinal()) {
            return ColorSpaces.INSTANCE.getAces();
        }
        if (id == ColorSpace.Named.ACESCG.ordinal()) {
            return ColorSpaces.INSTANCE.getAcescg();
        }
        if (id == ColorSpace.Named.ADOBE_RGB.ordinal()) {
            return ColorSpaces.INSTANCE.getAdobeRgb();
        }
        if (id == ColorSpace.Named.BT2020.ordinal()) {
            return ColorSpaces.INSTANCE.getBt2020();
        }
        if (id == ColorSpace.Named.BT709.ordinal()) {
            return ColorSpaces.INSTANCE.getBt709();
        }
        if (id == ColorSpace.Named.CIE_LAB.ordinal()) {
            return ColorSpaces.INSTANCE.getCieLab();
        }
        if (id == ColorSpace.Named.CIE_XYZ.ordinal()) {
            return ColorSpaces.INSTANCE.getCieXyz();
        }
        if (id == ColorSpace.Named.DCI_P3.ordinal()) {
            return ColorSpaces.INSTANCE.getDciP3();
        }
        if (id == ColorSpace.Named.DISPLAY_P3.ordinal()) {
            return ColorSpaces.INSTANCE.getDisplayP3();
        }
        if (id == ColorSpace.Named.EXTENDED_SRGB.ordinal()) {
            return ColorSpaces.INSTANCE.getExtendedSrgb();
        }
        if (id == ColorSpace.Named.LINEAR_EXTENDED_SRGB.ordinal()) {
            return ColorSpaces.INSTANCE.getLinearExtendedSrgb();
        }
        if (id == ColorSpace.Named.LINEAR_SRGB.ordinal()) {
            return ColorSpaces.INSTANCE.getLinearSrgb();
        }
        if (id == ColorSpace.Named.NTSC_1953.ordinal()) {
            return ColorSpaces.INSTANCE.getNtsc1953();
        }
        if (id == ColorSpace.Named.PRO_PHOTO_RGB.ordinal()) {
            return ColorSpaces.INSTANCE.getProPhotoRgb();
        }
        if (id == ColorSpace.Named.SMPTE_C.ordinal()) {
            return ColorSpaces.INSTANCE.getSmpteC();
        }
        if (!(colorSpace instanceof ColorSpace.Rgb)) {
            return ColorSpaces.INSTANCE.getSrgb();
        }
        ColorSpace.Rgb rgb = (ColorSpace.Rgb) colorSpace;
        ColorSpace.Rgb.TransferParameters transferParameters2 = rgb.getTransferParameters();
        WhitePoint whitePoint2 = rgb.getWhitePoint().length == 3 ? new WhitePoint(rgb.getWhitePoint()[0], rgb.getWhitePoint()[1], rgb.getWhitePoint()[2]) : new WhitePoint(rgb.getWhitePoint()[0], rgb.getWhitePoint()[1]);
        if (transferParameters2 != null) {
            whitePoint = whitePoint2;
            transferParameters = new TransferParameters(transferParameters2.g, transferParameters2.a, transferParameters2.b, transferParameters2.c, transferParameters2.d, transferParameters2.e, transferParameters2.f);
        } else {
            whitePoint = whitePoint2;
            transferParameters = null;
        }
        return new Rgb(rgb.getName(), rgb.getPrimaries(), whitePoint, rgb.getTransform(), new DoubleFunction() { // from class: androidx.compose.ui.graphics.c
            @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
            public final double invoke(double d5) {
                double composeColorSpace$lambda$2;
                composeColorSpace$lambda$2 = ColorSpaceVerificationHelper.composeColorSpace$lambda$2(colorSpace, d5);
                return composeColorSpace$lambda$2;
            }
        }, new DoubleFunction() { // from class: androidx.compose.ui.graphics.d
            @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
            public final double invoke(double d5) {
                double composeColorSpace$lambda$3;
                composeColorSpace$lambda$3 = ColorSpaceVerificationHelper.composeColorSpace$lambda$3(colorSpace, d5);
                return composeColorSpace$lambda$3;
            }
        }, colorSpace.getMinValue(0), colorSpace.getMaxValue(0), transferParameters, rgb.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double composeColorSpace$lambda$2(ColorSpace colorSpace, double d5) {
        return ((ColorSpace.Rgb) colorSpace).getOetf().applyAsDouble(d5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double composeColorSpace$lambda$3(ColorSpace colorSpace, double d5) {
        return ((ColorSpace.Rgb) colorSpace).getEotf().applyAsDouble(d5);
    }
}
