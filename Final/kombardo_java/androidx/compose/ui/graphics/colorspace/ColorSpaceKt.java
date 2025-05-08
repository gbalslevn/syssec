package androidx.compose.ui.graphics.colorspace;

import androidx.collection.MutableIntObjectMap;
import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.compose.ui.graphics.colorspace.Connector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0010\u001a*\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a(\u0010\n\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0007\u001a%\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a?\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a?\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u001a\u0010\u0019\u001aO\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0018\u0010\u001d\u001aO\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u001a\u0010\u001d\u001a?\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u001e\u0010\u0019\u001a?\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u001f\u0010\u0019\u001a\u001f\u0010!\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001f\u0010!\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020#2\u0006\u0010\u0014\u001a\u00020#H\u0000¢\u0006\u0004\b!\u0010$\u001a\u0017\u0010&\u001a\u00020#2\u0006\u0010%\u001a\u00020#H\u0000¢\u0006\u0004\b&\u0010'\u001a\u001f\u0010*\u001a\u00020#2\u0006\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020#H\u0000¢\u0006\u0004\b*\u0010+\u001a\u001f\u0010,\u001a\u00020#2\u0006\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020#H\u0000¢\u0006\u0004\b,\u0010+\u001a\u001f\u0010-\u001a\u00020#2\u0006\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020#H\u0000¢\u0006\u0004\b-\u0010+\u001a'\u00101\u001a\u00020#2\u0006\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020#2\u0006\u00100\u001a\u00020#H\u0000¢\u0006\u0004\b1\u00102\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00063"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "source", "destination", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "intent", "Landroidx/compose/ui/graphics/colorspace/Connector;", "createConnector-YBCOT_4", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;I)Landroidx/compose/ui/graphics/colorspace/Connector;", "createConnector", "connect-YBCOT_4", "connect", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "whitePoint", "Landroidx/compose/ui/graphics/colorspace/Adaptation;", "adaptation", "adapt", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/WhitePoint;Landroidx/compose/ui/graphics/colorspace/Adaptation;)Landroidx/compose/ui/graphics/colorspace/ColorSpace;", BuildConfig.FLAVOR, "x", "a", "b", "c", "d", "g", "rcpResponse", "(DDDDDD)D", "response", "e", "f", "(DDDDDDDD)D", "absRcpResponse", "absResponse", BuildConfig.FLAVOR, "compare", "(Landroidx/compose/ui/graphics/colorspace/WhitePoint;Landroidx/compose/ui/graphics/colorspace/WhitePoint;)Z", BuildConfig.FLAVOR, "([F[F)Z", "m", "inverse3x3", "([F)[F", "lhs", "rhs", "mul3x3", "([F[F)[F", "mul3x3Float3", "mul3x3Diag", "matrix", "srcWhitePoint", "dstWhitePoint", "chromaticAdaptation", "([F[F[F)[F", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ColorSpaceKt {
    public static final double absRcpResponse(double d5, double d6, double d7, double d8, double d9, double d10) {
        return Math.copySign(rcpResponse(d5 < 0.0d ? -d5 : d5, d6, d7, d8, d9, d10), d5);
    }

    public static final double absResponse(double d5, double d6, double d7, double d8, double d9, double d10) {
        return Math.copySign(response(d5 < 0.0d ? -d5 : d5, d6, d7, d8, d9, d10), d5);
    }

    public static final ColorSpace adapt(ColorSpace colorSpace, WhitePoint whitePoint, Adaptation adaptation) {
        if (!ColorModel.m1638equalsimpl0(colorSpace.getModel(), ColorModel.INSTANCE.m1643getRgbxdoWZVw())) {
            return colorSpace;
        }
        Intrinsics.checkNotNull(colorSpace, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        Rgb rgb = (Rgb) colorSpace;
        if (compare(rgb.getWhitePoint(), whitePoint)) {
            return colorSpace;
        }
        return new Rgb(rgb, mul3x3(chromaticAdaptation(adaptation.getTransform(), rgb.getWhitePoint().toXyz$ui_graphics_release(), whitePoint.toXyz$ui_graphics_release()), rgb.getTransform()), whitePoint);
    }

    public static /* synthetic */ ColorSpace adapt$default(ColorSpace colorSpace, WhitePoint whitePoint, Adaptation adaptation, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            adaptation = Adaptation.INSTANCE.getBradford();
        }
        return adapt(colorSpace, whitePoint, adaptation);
    }

    public static final float[] chromaticAdaptation(float[] fArr, float[] fArr2, float[] fArr3) {
        float[] mul3x3Float3 = mul3x3Float3(fArr, fArr2);
        float[] mul3x3Float32 = mul3x3Float3(fArr, fArr3);
        return mul3x3(inverse3x3(fArr), mul3x3Diag(new float[]{mul3x3Float32[0] / mul3x3Float3[0], mul3x3Float32[1] / mul3x3Float3[1], mul3x3Float32[2] / mul3x3Float3[2]}, fArr));
    }

    public static final boolean compare(WhitePoint whitePoint, WhitePoint whitePoint2) {
        if (whitePoint == whitePoint2) {
            return true;
        }
        return Math.abs(whitePoint.getX() - whitePoint2.getX()) < 0.001f && Math.abs(whitePoint.getY() - whitePoint2.getY()) < 0.001f;
    }

    /* renamed from: connect-YBCOT_4 */
    public static final Connector m1647connectYBCOT_4(ColorSpace colorSpace, ColorSpace colorSpace2, int i5) {
        int id = colorSpace.getId();
        int id2 = colorSpace2.getId();
        if ((id | id2) < 0) {
            return m1649createConnectorYBCOT_4(colorSpace, colorSpace2, i5);
        }
        MutableIntObjectMap<Connector> connectors = ConnectorKt.getConnectors();
        int i6 = id | (id2 << 6) | (i5 << 12);
        Connector connector = connectors.get(i6);
        if (connector == null) {
            connector = m1649createConnectorYBCOT_4(colorSpace, colorSpace2, i5);
            connectors.set(i6, connector);
        }
        return connector;
    }

    /* renamed from: connect-YBCOT_4$default */
    public static /* synthetic */ Connector m1648connectYBCOT_4$default(ColorSpace colorSpace, ColorSpace colorSpace2, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            colorSpace2 = ColorSpaces.INSTANCE.getSrgb();
        }
        if ((i6 & 2) != 0) {
            i5 = RenderIntent.INSTANCE.m1657getPerceptualuksYyKA();
        }
        return m1647connectYBCOT_4(colorSpace, colorSpace2, i5);
    }

    /* renamed from: createConnector-YBCOT_4 */
    private static final Connector m1649createConnectorYBCOT_4(ColorSpace colorSpace, ColorSpace colorSpace2, int i5) {
        Connector connector;
        if (colorSpace == colorSpace2) {
            return Connector.INSTANCE.identity$ui_graphics_release(colorSpace);
        }
        long model = colorSpace.getModel();
        ColorModel.Companion companion = ColorModel.INSTANCE;
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (ColorModel.m1638equalsimpl0(model, companion.m1643getRgbxdoWZVw()) && ColorModel.m1638equalsimpl0(colorSpace2.getModel(), companion.m1643getRgbxdoWZVw())) {
            Intrinsics.checkNotNull(colorSpace, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
            Intrinsics.checkNotNull(colorSpace2, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
            connector = new Connector.RgbConnector((Rgb) colorSpace, (Rgb) colorSpace2, i5, defaultConstructorMarker);
        } else {
            connector = new Connector(colorSpace, colorSpace2, i5, defaultConstructorMarker);
        }
        return connector;
    }

    public static final float[] inverse3x3(float[] fArr) {
        float f5 = fArr[0];
        float f6 = fArr[3];
        float f7 = fArr[6];
        float f8 = fArr[1];
        float f9 = fArr[4];
        float f10 = fArr[7];
        float f11 = fArr[2];
        float f12 = fArr[5];
        float f13 = fArr[8];
        float f14 = (f9 * f13) - (f10 * f12);
        float f15 = (f10 * f11) - (f8 * f13);
        float f16 = (f8 * f12) - (f9 * f11);
        float f17 = (f5 * f14) + (f6 * f15) + (f7 * f16);
        float[] fArr2 = new float[fArr.length];
        fArr2[0] = f14 / f17;
        fArr2[1] = f15 / f17;
        fArr2[2] = f16 / f17;
        fArr2[3] = ((f7 * f12) - (f6 * f13)) / f17;
        fArr2[4] = ((f13 * f5) - (f7 * f11)) / f17;
        fArr2[5] = ((f11 * f6) - (f12 * f5)) / f17;
        fArr2[6] = ((f6 * f10) - (f7 * f9)) / f17;
        fArr2[7] = ((f7 * f8) - (f10 * f5)) / f17;
        fArr2[8] = ((f5 * f9) - (f6 * f8)) / f17;
        return fArr2;
    }

    public static final float[] mul3x3(float[] fArr, float[] fArr2) {
        float f5 = fArr[0];
        float f6 = fArr2[0];
        float f7 = fArr[3];
        float f8 = fArr2[1];
        float f9 = fArr[6];
        float f10 = fArr2[2];
        float f11 = (f5 * f6) + (f7 * f8) + (f9 * f10);
        float f12 = fArr[1];
        float f13 = fArr[4];
        float f14 = fArr[7];
        float f15 = (f12 * f6) + (f13 * f8) + (f14 * f10);
        float f16 = fArr[2];
        float f17 = fArr[5];
        float f18 = fArr[8];
        float f19 = (f6 * f16) + (f8 * f17) + (f10 * f18);
        float f20 = fArr2[3];
        float f21 = fArr2[4];
        float f22 = fArr2[5];
        float f23 = (f5 * f20) + (f7 * f21) + (f9 * f22);
        float f24 = (f12 * f20) + (f13 * f21) + (f14 * f22);
        float f25 = (f20 * f16) + (f21 * f17) + (f22 * f18);
        float f26 = fArr2[6];
        float f27 = fArr2[7];
        float f28 = (f5 * f26) + (f7 * f27);
        float f29 = fArr2[8];
        return new float[]{f11, f15, f19, f23, f24, f25, f28 + (f9 * f29), (f12 * f26) + (f13 * f27) + (f14 * f29), (f16 * f26) + (f17 * f27) + (f18 * f29)};
    }

    public static final float[] mul3x3Diag(float[] fArr, float[] fArr2) {
        float f5 = fArr[0];
        float f6 = fArr2[0] * f5;
        float f7 = fArr[1];
        float f8 = fArr2[1] * f7;
        float f9 = fArr[2];
        return new float[]{f6, f8, fArr2[2] * f9, fArr2[3] * f5, fArr2[4] * f7, fArr2[5] * f9, f5 * fArr2[6], f7 * fArr2[7], f9 * fArr2[8]};
    }

    public static final float[] mul3x3Float3(float[] fArr, float[] fArr2) {
        float f5 = fArr2[0];
        float f6 = fArr2[1];
        float f7 = fArr2[2];
        fArr2[0] = (fArr[0] * f5) + (fArr[3] * f6) + (fArr[6] * f7);
        fArr2[1] = (fArr[1] * f5) + (fArr[4] * f6) + (fArr[7] * f7);
        fArr2[2] = (fArr[2] * f5) + (fArr[5] * f6) + (fArr[8] * f7);
        return fArr2;
    }

    public static final double rcpResponse(double d5, double d6, double d7, double d8, double d9, double d10) {
        return d5 >= d9 * d8 ? (Math.pow(d5, 1.0d / d10) - d7) / d6 : d5 / d8;
    }

    public static final double response(double d5, double d6, double d7, double d8, double d9, double d10) {
        return d5 >= d9 ? Math.pow((d6 * d5) + d7, d10) : d5 * d8;
    }

    public static final boolean compare(float[] fArr, float[] fArr2) {
        if (fArr == fArr2) {
            return true;
        }
        int length = fArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (Float.compare(fArr[i5], fArr2[i5]) != 0 && Math.abs(fArr[i5] - fArr2[i5]) > 0.001f) {
                return false;
            }
        }
        return true;
    }

    public static final double rcpResponse(double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12) {
        return d5 >= d9 * d8 ? (Math.pow(d5 - d10, 1.0d / d12) - d7) / d6 : (d5 - d11) / d8;
    }

    public static final double response(double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12) {
        return d5 >= d9 ? Math.pow((d6 * d5) + d7, d12) + d10 : (d8 * d5) + d11;
    }
}
