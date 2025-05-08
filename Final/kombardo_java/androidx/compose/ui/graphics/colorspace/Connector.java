package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorModel;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB;\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fB!\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\u000eJ\u001a\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0010ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u001d\u0010\b\u001a\u00020\u00078\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\n\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Connector;", BuildConfig.FLAVOR, "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "source", "destination", "transformSource", "transformDestination", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "renderIntent", BuildConfig.FLAVOR, "transform", "<init>", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;I[FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "intent", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "Landroidx/compose/ui/graphics/Color;", "color", "transformToColor-l2rxGTc$ui_graphics_release", "(J)J", "transformToColor", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getSource", "()Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getDestination", "I", "getRenderIntent-uksYyKA", "()I", "[F", "Companion", "RgbConnector", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class Connector {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ColorSpace destination;
    private final int renderIntent;
    private final ColorSpace source;
    private final float[] transform;
    private final ColorSpace transformDestination;
    private final ColorSpace transformSource;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u000e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Connector$Companion;", BuildConfig.FLAVOR, "()V", "computeTransform", BuildConfig.FLAVOR, "source", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "destination", "intent", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "computeTransform-YBCOT_4", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;I)[F", "identity", "Landroidx/compose/ui/graphics/colorspace/Connector;", "identity$ui_graphics_release", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: computeTransform-YBCOT_4, reason: not valid java name */
        public final float[] m1652computeTransformYBCOT_4(ColorSpace source, ColorSpace destination, int intent) {
            if (!RenderIntent.m1655equalsimpl0(intent, RenderIntent.INSTANCE.m1656getAbsoluteuksYyKA())) {
                return null;
            }
            long model = source.getModel();
            ColorModel.Companion companion = ColorModel.INSTANCE;
            boolean m1638equalsimpl0 = ColorModel.m1638equalsimpl0(model, companion.m1643getRgbxdoWZVw());
            boolean m1638equalsimpl02 = ColorModel.m1638equalsimpl0(destination.getModel(), companion.m1643getRgbxdoWZVw());
            if (m1638equalsimpl0 && m1638equalsimpl02) {
                return null;
            }
            if (!m1638equalsimpl0 && !m1638equalsimpl02) {
                return null;
            }
            if (!m1638equalsimpl0) {
                source = destination;
            }
            Intrinsics.checkNotNull(source, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
            Rgb rgb = (Rgb) source;
            float[] xyz$ui_graphics_release = m1638equalsimpl0 ? rgb.getWhitePoint().toXyz$ui_graphics_release() : Illuminant.INSTANCE.getD50Xyz$ui_graphics_release();
            float[] xyz$ui_graphics_release2 = m1638equalsimpl02 ? rgb.getWhitePoint().toXyz$ui_graphics_release() : Illuminant.INSTANCE.getD50Xyz$ui_graphics_release();
            return new float[]{xyz$ui_graphics_release[0] / xyz$ui_graphics_release2[0], xyz$ui_graphics_release[1] / xyz$ui_graphics_release2[1], xyz$ui_graphics_release[2] / xyz$ui_graphics_release2[2]};
        }

        public final Connector identity$ui_graphics_release(final ColorSpace source) {
            final int m1658getRelativeuksYyKA = RenderIntent.INSTANCE.m1658getRelativeuksYyKA();
            return new Connector(source, m1658getRelativeuksYyKA) { // from class: androidx.compose.ui.graphics.colorspace.Connector$Companion$identity$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(source, source, m1658getRelativeuksYyKA, null);
                }

                @Override // androidx.compose.ui.graphics.colorspace.Connector
                /* renamed from: transformToColor-l2rxGTc$ui_graphics_release */
                public long mo1650transformToColorl2rxGTc$ui_graphics_release(long color) {
                    return color;
                }
            };
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0010ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Connector$RgbConnector;", "Landroidx/compose/ui/graphics/colorspace/Connector;", "Landroidx/compose/ui/graphics/colorspace/Rgb;", "mSource", "mDestination", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "intent", "<init>", "(Landroidx/compose/ui/graphics/colorspace/Rgb;Landroidx/compose/ui/graphics/colorspace/Rgb;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "source", "destination", BuildConfig.FLAVOR, "computeTransform-YBCOT_4", "(Landroidx/compose/ui/graphics/colorspace/Rgb;Landroidx/compose/ui/graphics/colorspace/Rgb;I)[F", "computeTransform", "Landroidx/compose/ui/graphics/Color;", "color", "transformToColor-l2rxGTc$ui_graphics_release", "(J)J", "transformToColor", "Landroidx/compose/ui/graphics/colorspace/Rgb;", "mTransform", "[F", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class RgbConnector extends Connector {
        private final Rgb mDestination;
        private final Rgb mSource;
        private final float[] mTransform;

        public /* synthetic */ RgbConnector(Rgb rgb, Rgb rgb2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(rgb, rgb2, i5);
        }

        /* renamed from: computeTransform-YBCOT_4, reason: not valid java name */
        private final float[] m1653computeTransformYBCOT_4(Rgb source, Rgb destination, int intent) {
            if (ColorSpaceKt.compare(source.getWhitePoint(), destination.getWhitePoint())) {
                return ColorSpaceKt.mul3x3(destination.getInverseTransform(), source.getTransform());
            }
            float[] transform = source.getTransform();
            float[] inverseTransform = destination.getInverseTransform();
            float[] xyz$ui_graphics_release = source.getWhitePoint().toXyz$ui_graphics_release();
            float[] xyz$ui_graphics_release2 = destination.getWhitePoint().toXyz$ui_graphics_release();
            WhitePoint whitePoint = source.getWhitePoint();
            Illuminant illuminant = Illuminant.INSTANCE;
            if (!ColorSpaceKt.compare(whitePoint, illuminant.getD50())) {
                float[] transform2 = Adaptation.INSTANCE.getBradford().getTransform();
                float[] d50Xyz$ui_graphics_release = illuminant.getD50Xyz$ui_graphics_release();
                float[] copyOf = Arrays.copyOf(d50Xyz$ui_graphics_release, d50Xyz$ui_graphics_release.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                transform = ColorSpaceKt.mul3x3(ColorSpaceKt.chromaticAdaptation(transform2, xyz$ui_graphics_release, copyOf), source.getTransform());
            }
            if (!ColorSpaceKt.compare(destination.getWhitePoint(), illuminant.getD50())) {
                float[] transform3 = Adaptation.INSTANCE.getBradford().getTransform();
                float[] d50Xyz$ui_graphics_release2 = illuminant.getD50Xyz$ui_graphics_release();
                float[] copyOf2 = Arrays.copyOf(d50Xyz$ui_graphics_release2, d50Xyz$ui_graphics_release2.length);
                Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, size)");
                inverseTransform = ColorSpaceKt.inverse3x3(ColorSpaceKt.mul3x3(ColorSpaceKt.chromaticAdaptation(transform3, xyz$ui_graphics_release2, copyOf2), destination.getTransform()));
            }
            if (RenderIntent.m1655equalsimpl0(intent, RenderIntent.INSTANCE.m1656getAbsoluteuksYyKA())) {
                transform = ColorSpaceKt.mul3x3Diag(new float[]{xyz$ui_graphics_release[0] / xyz$ui_graphics_release2[0], xyz$ui_graphics_release[1] / xyz$ui_graphics_release2[1], xyz$ui_graphics_release[2] / xyz$ui_graphics_release2[2]}, transform);
            }
            return ColorSpaceKt.mul3x3(inverseTransform, transform);
        }

        @Override // androidx.compose.ui.graphics.colorspace.Connector
        /* renamed from: transformToColor-l2rxGTc$ui_graphics_release */
        public long mo1650transformToColorl2rxGTc$ui_graphics_release(long color) {
            float m1492getRedimpl = Color.m1492getRedimpl(color);
            float m1491getGreenimpl = Color.m1491getGreenimpl(color);
            float m1489getBlueimpl = Color.m1489getBlueimpl(color);
            float m1488getAlphaimpl = Color.m1488getAlphaimpl(color);
            float invoke = (float) this.mSource.getEotfFunc().invoke(m1492getRedimpl);
            float invoke2 = (float) this.mSource.getEotfFunc().invoke(m1491getGreenimpl);
            float invoke3 = (float) this.mSource.getEotfFunc().invoke(m1489getBlueimpl);
            float[] fArr = this.mTransform;
            return ColorKt.Color((float) this.mDestination.getOetfFunc().invoke((fArr[0] * invoke) + (fArr[3] * invoke2) + (fArr[6] * invoke3)), (float) this.mDestination.getOetfFunc().invoke((fArr[1] * invoke) + (fArr[4] * invoke2) + (fArr[7] * invoke3)), (float) this.mDestination.getOetfFunc().invoke((fArr[2] * invoke) + (fArr[5] * invoke2) + (fArr[8] * invoke3)), m1488getAlphaimpl, this.mDestination);
        }

        private RgbConnector(Rgb rgb, Rgb rgb2, int i5) {
            super(rgb, rgb2, rgb, rgb2, i5, null, null);
            this.mSource = rgb;
            this.mDestination = rgb2;
            this.mTransform = m1653computeTransformYBCOT_4(rgb, rgb2, i5);
        }
    }

    public /* synthetic */ Connector(ColorSpace colorSpace, ColorSpace colorSpace2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(colorSpace, colorSpace2, i5);
    }

    /* renamed from: transformToColor-l2rxGTc$ui_graphics_release, reason: not valid java name */
    public long mo1650transformToColorl2rxGTc$ui_graphics_release(long color) {
        float m1492getRedimpl = Color.m1492getRedimpl(color);
        float m1491getGreenimpl = Color.m1491getGreenimpl(color);
        float m1489getBlueimpl = Color.m1489getBlueimpl(color);
        float m1488getAlphaimpl = Color.m1488getAlphaimpl(color);
        long xy$ui_graphics_release = this.transformSource.toXy$ui_graphics_release(m1492getRedimpl, m1491getGreenimpl, m1489getBlueimpl);
        float intBitsToFloat = Float.intBitsToFloat((int) (xy$ui_graphics_release >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (xy$ui_graphics_release & 4294967295L));
        float z$ui_graphics_release = this.transformSource.toZ$ui_graphics_release(m1492getRedimpl, m1491getGreenimpl, m1489getBlueimpl);
        float[] fArr = this.transform;
        if (fArr != null) {
            intBitsToFloat *= fArr[0];
            intBitsToFloat2 *= fArr[1];
            z$ui_graphics_release *= fArr[2];
        }
        float f5 = intBitsToFloat;
        return this.transformDestination.mo1646xyzaToColorJlNiLsg$ui_graphics_release(f5, intBitsToFloat2, z$ui_graphics_release, m1488getAlphaimpl, this.destination);
    }

    public /* synthetic */ Connector(ColorSpace colorSpace, ColorSpace colorSpace2, ColorSpace colorSpace3, ColorSpace colorSpace4, int i5, float[] fArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(colorSpace, colorSpace2, colorSpace3, colorSpace4, i5, fArr);
    }

    private Connector(ColorSpace colorSpace, ColorSpace colorSpace2, ColorSpace colorSpace3, ColorSpace colorSpace4, int i5, float[] fArr) {
        this.source = colorSpace;
        this.destination = colorSpace2;
        this.transformSource = colorSpace3;
        this.transformDestination = colorSpace4;
        this.renderIntent = i5;
        this.transform = fArr;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Connector(ColorSpace colorSpace, ColorSpace colorSpace2, int i5) {
        this(colorSpace, colorSpace2, ColorModel.m1638equalsimpl0(r0, r2.m1643getRgbxdoWZVw()) ? ColorSpaceKt.adapt$default(colorSpace, Illuminant.INSTANCE.getD50(), null, 2, null) : colorSpace, ColorModel.m1638equalsimpl0(colorSpace2.getModel(), r2.m1643getRgbxdoWZVw()) ? ColorSpaceKt.adapt$default(colorSpace2, Illuminant.INSTANCE.getD50(), null, 2, null) : colorSpace2, i5, INSTANCE.m1652computeTransformYBCOT_4(colorSpace, colorSpace2, i5), null);
        long model = colorSpace.getModel();
        ColorModel.Companion companion = ColorModel.INSTANCE;
    }
}
