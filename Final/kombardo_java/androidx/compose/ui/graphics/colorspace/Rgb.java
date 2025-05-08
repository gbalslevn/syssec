package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.graphics.colorspace.TransferParameters;
import com.sdk.growthbook.utils.Constants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 Y2\u00020\u0001:\u0001YB]\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014B1\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0016BA\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0019B!\b\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0000\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ'\u0010&\u001a\u00020#2\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\fH\u0010¢\u0006\u0004\b$\u0010%J'\u0010)\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\fH\u0010¢\u0006\u0004\b'\u0010(J=\u00101\u001a\u00020.2\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0001H\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100J\u001a\u00105\u001a\u0002042\b\u00103\u001a\u0004\u0018\u000102H\u0096\u0002¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0011H\u0016¢\u0006\u0004\b7\u00108R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00109\u001a\u0004\b:\u0010;R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010<R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010<R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010=\u001a\u0004\b>\u0010?R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010@\u001a\u0004\bA\u0010BR\u001a\u0010\b\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010@\u001a\u0004\bC\u0010BR\u001a\u0010D\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\bD\u0010@\u001a\u0004\bE\u0010BR\u001a\u0010F\u001a\u00020\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR#\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170J8\u0006¢\u0006\f\n\u0004\b\n\u0010K\u001a\u0004\bL\u0010MR\u001a\u0010N\u001a\u00020\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bN\u0010G\u001a\u0004\bO\u0010IR\u001a\u0010P\u001a\u00020\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bP\u0010G\u001a\u0004\bQ\u0010IR#\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170J8\u0006¢\u0006\f\n\u0004\b\u000b\u0010K\u001a\u0004\bR\u0010MR\u001a\u0010S\u001a\u00020\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bS\u0010G\u001a\u0004\bT\u0010IR\u001a\u0010U\u001a\u0002048\u0016X\u0096\u0004¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bU\u0010WR\u001a\u0010X\u001a\u0002048\u0016X\u0096\u0004¢\u0006\f\n\u0004\bX\u0010V\u001a\u0004\bX\u0010W\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006Z"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Rgb;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "primaries", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "whitePoint", "transform", "Landroidx/compose/ui/graphics/colorspace/DoubleFunction;", "oetf", "eotf", BuildConfig.FLAVOR, "min", "max", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "transferParameters", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "<init>", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;[FLandroidx/compose/ui/graphics/colorspace/DoubleFunction;Landroidx/compose/ui/graphics/colorspace/DoubleFunction;FFLandroidx/compose/ui/graphics/colorspace/TransferParameters;I)V", "function", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Landroidx/compose/ui/graphics/colorspace/TransferParameters;I)V", BuildConfig.FLAVOR, "gamma", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;DFFI)V", "colorSpace", "(Landroidx/compose/ui/graphics/colorspace/Rgb;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;)V", "component", "getMinValue", "(I)F", "getMaxValue", "v0", "v1", "v2", BuildConfig.FLAVOR, "toXy$ui_graphics_release", "(FFF)J", "toXy", "toZ$ui_graphics_release", "(FFF)F", "toZ", "x", "y", "z", "a", "Landroidx/compose/ui/graphics/Color;", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "xyzaToColor", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "getWhitePoint", "()Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "F", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "getTransferParameters", "()Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "[F", "getPrimaries$ui_graphics_release", "()[F", "getTransform$ui_graphics_release", "inverseTransform", "getInverseTransform$ui_graphics_release", "oetfOrig", "Landroidx/compose/ui/graphics/colorspace/DoubleFunction;", "getOetfOrig$ui_graphics_release", "()Landroidx/compose/ui/graphics/colorspace/DoubleFunction;", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "getOetf", "()Lkotlin/jvm/functions/Function1;", "oetfFunc", "getOetfFunc$ui_graphics_release", "eotfOrig", "getEotfOrig$ui_graphics_release", "getEotf", "eotfFunc", "getEotfFunc$ui_graphics_release", "isWideGamut", "Z", "()Z", "isSrgb", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Rgb extends ColorSpace {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final DoubleFunction DoubleIdentity = new DoubleFunction() { // from class: n.e
        @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
        public final double invoke(double d5) {
            double DoubleIdentity$lambda$12;
            DoubleIdentity$lambda$12 = Rgb.DoubleIdentity$lambda$12(d5);
            return DoubleIdentity$lambda$12;
        }
    };
    private final Function1<Double, Double> eotf;
    private final DoubleFunction eotfFunc;
    private final DoubleFunction eotfOrig;
    private final float[] inverseTransform;
    private final boolean isSrgb;
    private final boolean isWideGamut;
    private final float max;
    private final float min;
    private final Function1<Double, Double> oetf;
    private final DoubleFunction oetfFunc;
    private final DoubleFunction oetfOrig;
    private final float[] primaries;
    private final TransferParameters transferParameters;
    private final float[] transform;
    private final WhitePoint whitePoint;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u001a\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JG\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010!\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bH\u0002¢\u0006\u0004\b!\u0010\"J\u001f\u0010%\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b'\u0010(J\u001f\u0010)\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006-"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Rgb$Companion;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "primaries", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "whitePoint", "Landroidx/compose/ui/graphics/colorspace/DoubleFunction;", "OETF", "EOTF", BuildConfig.FLAVOR, "min", "max", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "isSrgb", "([FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Landroidx/compose/ui/graphics/colorspace/DoubleFunction;Landroidx/compose/ui/graphics/colorspace/DoubleFunction;FFI)Z", BuildConfig.FLAVOR, "point", "a", "b", "compare", "(DLandroidx/compose/ui/graphics/colorspace/DoubleFunction;Landroidx/compose/ui/graphics/colorspace/DoubleFunction;)Z", "isWideGamut", "([FFF)Z", "area", "([F)F", "ax", "ay", "bx", "by", "cross", "(FFFF)F", "p1", "p2", "contains", "([F[F)Z", "xyPrimaries", "([F)[F", "computeXYZMatrix", "([FLandroidx/compose/ui/graphics/colorspace/WhitePoint;)[F", "DoubleIdentity", "Landroidx/compose/ui/graphics/colorspace/DoubleFunction;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final float area(float[] primaries) {
            float f5 = primaries[0];
            float f6 = primaries[1];
            float f7 = primaries[2];
            float f8 = primaries[3];
            float f9 = primaries[4];
            float f10 = primaries[5];
            float f11 = ((((((f5 * f8) + (f6 * f9)) + (f7 * f10)) - (f8 * f9)) - (f6 * f7)) - (f5 * f10)) * 0.5f;
            return f11 < 0.0f ? -f11 : f11;
        }

        private final boolean compare(double point, DoubleFunction a5, DoubleFunction b5) {
            return Math.abs(a5.invoke(point) - b5.invoke(point)) <= 0.001d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float[] computeXYZMatrix(float[] primaries, WhitePoint whitePoint) {
            float f5 = primaries[0];
            float f6 = primaries[1];
            float f7 = primaries[2];
            float f8 = primaries[3];
            float f9 = primaries[4];
            float f10 = primaries[5];
            float x5 = whitePoint.getX();
            float y5 = whitePoint.getY();
            float f11 = 1;
            float f12 = (f11 - f5) / f6;
            float f13 = (f11 - f7) / f8;
            float f14 = (f11 - f9) / f10;
            float f15 = (f11 - x5) / y5;
            float f16 = f5 / f6;
            float f17 = (f7 / f8) - f16;
            float f18 = (x5 / y5) - f16;
            float f19 = f13 - f12;
            float f20 = (f9 / f10) - f16;
            float f21 = (((f15 - f12) * f17) - (f18 * f19)) / (((f14 - f12) * f17) - (f19 * f20));
            float f22 = (f18 - (f20 * f21)) / f17;
            float f23 = (1.0f - f22) - f21;
            float f24 = f23 / f6;
            float f25 = f22 / f8;
            float f26 = f21 / f10;
            return new float[]{f24 * f5, f23, f24 * ((1.0f - f5) - f6), f25 * f7, f22, f25 * ((1.0f - f7) - f8), f26 * f9, f21, f26 * ((1.0f - f9) - f10)};
        }

        private final boolean contains(float[] p12, float[] p22) {
            float f5 = p12[0];
            float f6 = p22[0];
            float f7 = p12[1];
            float f8 = p22[1];
            float f9 = p12[2] - p22[2];
            float f10 = p12[3] - p22[3];
            float f11 = p12[4];
            float f12 = p22[4];
            float f13 = p12[5];
            float f14 = p22[5];
            float[] fArr = {f5 - f6, f7 - f8, f9, f10, f11 - f12, f13 - f14};
            return cross(fArr[0], fArr[1], f6 - f12, f8 - f14) >= 0.0f && cross(p22[0] - p22[2], p22[1] - p22[3], fArr[0], fArr[1]) >= 0.0f && cross(fArr[2], fArr[3], p22[2] - p22[0], p22[3] - p22[1]) >= 0.0f && cross(p22[2] - p22[4], p22[3] - p22[5], fArr[2], fArr[3]) >= 0.0f && cross(fArr[4], fArr[5], p22[4] - p22[2], p22[5] - p22[3]) >= 0.0f && cross(p22[4] - p22[0], p22[5] - p22[1], fArr[4], fArr[5]) >= 0.0f;
        }

        private final float cross(float ax, float ay, float bx, float by) {
            return (ax * by) - (ay * bx);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isSrgb(float[] primaries, WhitePoint whitePoint, DoubleFunction OETF, DoubleFunction EOTF, float min, float max, int id) {
            if (id == 0) {
                return true;
            }
            ColorSpaces colorSpaces = ColorSpaces.INSTANCE;
            if (!ColorSpaceKt.compare(primaries, colorSpaces.getSrgbPrimaries$ui_graphics_release()) || !ColorSpaceKt.compare(whitePoint, Illuminant.INSTANCE.getD65()) || min != 0.0f || max != 1.0f) {
                return false;
            }
            Rgb srgb = colorSpaces.getSrgb();
            for (double d5 = 0.0d; d5 <= 1.0d; d5 += 0.00392156862745098d) {
                if (!compare(d5, OETF, srgb.getOetfOrig()) || !compare(d5, EOTF, srgb.getEotfOrig())) {
                    return false;
                }
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isWideGamut(float[] primaries, float min, float max) {
            float area = area(primaries);
            ColorSpaces colorSpaces = ColorSpaces.INSTANCE;
            return (area / area(colorSpaces.getNtsc1953Primaries$ui_graphics_release()) > 0.9f && contains(primaries, colorSpaces.getSrgbPrimaries$ui_graphics_release())) || (min < 0.0f && max > 1.0f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float[] xyPrimaries(float[] primaries) {
            float[] fArr = new float[6];
            if (primaries.length == 9) {
                float f5 = primaries[0];
                float f6 = primaries[1];
                float f7 = f5 + f6 + primaries[2];
                fArr[0] = f5 / f7;
                fArr[1] = f6 / f7;
                float f8 = primaries[3];
                float f9 = primaries[4];
                float f10 = f8 + f9 + primaries[5];
                fArr[2] = f8 / f10;
                fArr[3] = f9 / f10;
                float f11 = primaries[6];
                float f12 = primaries[7];
                float f13 = f11 + f12 + primaries[8];
                fArr[4] = f11 / f13;
                fArr[5] = f12 / f13;
            } else {
                ArraysKt.copyInto$default(primaries, fArr, 0, 0, 6, 6, (Object) null);
            }
            return fArr;
        }

        private Companion() {
        }
    }

    public Rgb(String str, float[] fArr, WhitePoint whitePoint, float[] fArr2, DoubleFunction doubleFunction, DoubleFunction doubleFunction2, float f5, float f6, TransferParameters transferParameters, int i5) {
        super(str, ColorModel.INSTANCE.m1643getRgbxdoWZVw(), i5, null);
        this.whitePoint = whitePoint;
        this.min = f5;
        this.max = f6;
        this.transferParameters = transferParameters;
        this.oetfOrig = doubleFunction;
        this.oetf = new Function1<Double, Double>() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$oetf$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d5) {
                return invoke(d5.doubleValue());
            }

            public final Double invoke(double d5) {
                float f7;
                float f8;
                double invoke = Rgb.this.getOetfOrig().invoke(d5);
                f7 = Rgb.this.min;
                double d6 = f7;
                f8 = Rgb.this.max;
                return Double.valueOf(RangesKt.coerceIn(invoke, d6, f8));
            }
        };
        this.oetfFunc = new DoubleFunction() { // from class: n.c
            @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
            public final double invoke(double d5) {
                double oetfFunc$lambda$0;
                oetfFunc$lambda$0 = Rgb.oetfFunc$lambda$0(Rgb.this, d5);
                return oetfFunc$lambda$0;
            }
        };
        this.eotfOrig = doubleFunction2;
        this.eotf = new Function1<Double, Double>() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$eotf$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d5) {
                return invoke(d5.doubleValue());
            }

            public final Double invoke(double d5) {
                float f7;
                float f8;
                DoubleFunction eotfOrig = Rgb.this.getEotfOrig();
                f7 = Rgb.this.min;
                double d6 = f7;
                f8 = Rgb.this.max;
                return Double.valueOf(eotfOrig.invoke(RangesKt.coerceIn(d5, d6, f8)));
            }
        };
        this.eotfFunc = new DoubleFunction() { // from class: n.d
            @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
            public final double invoke(double d5) {
                double eotfFunc$lambda$1;
                eotfFunc$lambda$1 = Rgb.eotfFunc$lambda$1(Rgb.this, d5);
                return eotfFunc$lambda$1;
            }
        };
        if (fArr.length != 6 && fArr.length != 9) {
            throw new IllegalArgumentException("The color space's primaries must be defined as an array of 6 floats in xyY or 9 floats in XYZ");
        }
        if (f5 < f6) {
            Companion companion = INSTANCE;
            float[] xyPrimaries = companion.xyPrimaries(fArr);
            this.primaries = xyPrimaries;
            if (fArr2 == null) {
                this.transform = companion.computeXYZMatrix(xyPrimaries, whitePoint);
            } else if (fArr2.length == 9) {
                this.transform = fArr2;
            } else {
                throw new IllegalArgumentException("Transform must have 9 entries! Has " + fArr2.length);
            }
            this.inverseTransform = ColorSpaceKt.inverse3x3(this.transform);
            this.isWideGamut = companion.isWideGamut(xyPrimaries, f5, f6);
            this.isSrgb = companion.isSrgb(xyPrimaries, whitePoint, doubleFunction, doubleFunction2, f5, f6, i5);
            return;
        }
        throw new IllegalArgumentException("Invalid range: min=" + f5 + ", max=" + f6 + "; min must be strictly < max");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double DoubleIdentity$lambda$12(double d5) {
        return d5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double _init_$lambda$10(double d5, double d6) {
        if (d6 < 0.0d) {
            d6 = 0.0d;
        }
        return Math.pow(d6, 1.0d / d5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double _init_$lambda$11(double d5, double d6) {
        if (d6 < 0.0d) {
            d6 = 0.0d;
        }
        return Math.pow(d6, d5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double _init_$lambda$6(TransferParameters transferParameters, double d5) {
        return ColorSpaceKt.rcpResponse(d5, transferParameters.getA(), transferParameters.getB(), transferParameters.getC(), transferParameters.getD(), transferParameters.getGamma());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double _init_$lambda$7(TransferParameters transferParameters, double d5) {
        return ColorSpaceKt.rcpResponse(d5, transferParameters.getA(), transferParameters.getB(), transferParameters.getC(), transferParameters.getD(), transferParameters.getE(), transferParameters.getF(), transferParameters.getGamma());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double _init_$lambda$8(TransferParameters transferParameters, double d5) {
        return ColorSpaceKt.response(d5, transferParameters.getA(), transferParameters.getB(), transferParameters.getC(), transferParameters.getD(), transferParameters.getGamma());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double _init_$lambda$9(TransferParameters transferParameters, double d5) {
        return ColorSpaceKt.response(d5, transferParameters.getA(), transferParameters.getB(), transferParameters.getC(), transferParameters.getD(), transferParameters.getE(), transferParameters.getF(), transferParameters.getGamma());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double eotfFunc$lambda$1(Rgb rgb, double d5) {
        return rgb.eotfOrig.invoke(RangesKt.coerceIn(d5, rgb.min, rgb.max));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double oetfFunc$lambda$0(Rgb rgb, double d5) {
        return RangesKt.coerceIn(rgb.oetfOrig.invoke(d5), rgb.min, rgb.max);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || Rgb.class != other.getClass() || !super.equals(other)) {
            return false;
        }
        Rgb rgb = (Rgb) other;
        if (Float.compare(rgb.min, this.min) != 0 || Float.compare(rgb.max, this.max) != 0 || !Intrinsics.areEqual(this.whitePoint, rgb.whitePoint) || !Arrays.equals(this.primaries, rgb.primaries)) {
            return false;
        }
        TransferParameters transferParameters = this.transferParameters;
        if (transferParameters != null) {
            return Intrinsics.areEqual(transferParameters, rgb.transferParameters);
        }
        if (rgb.transferParameters == null) {
            return true;
        }
        if (Intrinsics.areEqual(this.oetfOrig, rgb.oetfOrig)) {
            return Intrinsics.areEqual(this.eotfOrig, rgb.eotfOrig);
        }
        return false;
    }

    public final Function1<Double, Double> getEotf() {
        return this.eotf;
    }

    /* renamed from: getEotfFunc$ui_graphics_release, reason: from getter */
    public final DoubleFunction getEotfFunc() {
        return this.eotfFunc;
    }

    /* renamed from: getEotfOrig$ui_graphics_release, reason: from getter */
    public final DoubleFunction getEotfOrig() {
        return this.eotfOrig;
    }

    /* renamed from: getInverseTransform$ui_graphics_release, reason: from getter */
    public final float[] getInverseTransform() {
        return this.inverseTransform;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int component) {
        return this.max;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMinValue(int component) {
        return this.min;
    }

    public final Function1<Double, Double> getOetf() {
        return this.oetf;
    }

    /* renamed from: getOetfFunc$ui_graphics_release, reason: from getter */
    public final DoubleFunction getOetfFunc() {
        return this.oetfFunc;
    }

    /* renamed from: getOetfOrig$ui_graphics_release, reason: from getter */
    public final DoubleFunction getOetfOrig() {
        return this.oetfOrig;
    }

    /* renamed from: getPrimaries$ui_graphics_release, reason: from getter */
    public final float[] getPrimaries() {
        return this.primaries;
    }

    public final TransferParameters getTransferParameters() {
        return this.transferParameters;
    }

    /* renamed from: getTransform$ui_graphics_release, reason: from getter */
    public final float[] getTransform() {
        return this.transform;
    }

    public final WhitePoint getWhitePoint() {
        return this.whitePoint;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public int hashCode() {
        int hashCode = ((((super.hashCode() * 31) + this.whitePoint.hashCode()) * 31) + Arrays.hashCode(this.primaries)) * 31;
        float f5 = this.min;
        int floatToIntBits = (hashCode + (f5 == 0.0f ? 0 : Float.floatToIntBits(f5))) * 31;
        float f6 = this.max;
        int floatToIntBits2 = (floatToIntBits + (f6 == 0.0f ? 0 : Float.floatToIntBits(f6))) * 31;
        TransferParameters transferParameters = this.transferParameters;
        int hashCode2 = floatToIntBits2 + (transferParameters != null ? transferParameters.hashCode() : 0);
        return this.transferParameters == null ? (((hashCode2 * 31) + this.oetfOrig.hashCode()) * 31) + this.eotfOrig.hashCode() : hashCode2;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* renamed from: isSrgb, reason: from getter */
    public boolean getIsSrgb() {
        return this.isSrgb;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float v02, float v12, float v22) {
        float invoke = (float) this.eotfFunc.invoke(v02);
        float invoke2 = (float) this.eotfFunc.invoke(v12);
        float invoke3 = (float) this.eotfFunc.invoke(v22);
        float[] fArr = this.transform;
        float f5 = (fArr[0] * invoke) + (fArr[3] * invoke2) + (fArr[6] * invoke3);
        float f6 = (fArr[1] * invoke) + (fArr[4] * invoke2) + (fArr[7] * invoke3);
        return (Float.floatToRawIntBits(f5) << 32) | (Float.floatToRawIntBits(f6) & 4294967295L);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float v02, float v12, float v22) {
        float invoke = (float) this.eotfFunc.invoke(v02);
        float invoke2 = (float) this.eotfFunc.invoke(v12);
        float invoke3 = (float) this.eotfFunc.invoke(v22);
        float[] fArr = this.transform;
        return (fArr[2] * invoke) + (fArr[5] * invoke2) + (fArr[8] * invoke3);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public long mo1646xyzaToColorJlNiLsg$ui_graphics_release(float x5, float y5, float z5, float a5, ColorSpace colorSpace) {
        float[] fArr = this.inverseTransform;
        return ColorKt.Color((float) this.oetfFunc.invoke((fArr[0] * x5) + (fArr[3] * y5) + (fArr[6] * z5)), (float) this.oetfFunc.invoke((fArr[1] * x5) + (fArr[4] * y5) + (fArr[7] * z5)), (float) this.oetfFunc.invoke((fArr[2] * x5) + (fArr[5] * y5) + (fArr[8] * z5)), a5, colorSpace);
    }

    public Rgb(String str, float[] fArr, WhitePoint whitePoint, final TransferParameters transferParameters, int i5) {
        this(str, fArr, whitePoint, null, (transferParameters.getE() == 0.0d && transferParameters.getF() == 0.0d) ? new DoubleFunction() { // from class: n.h
            @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
            public final double invoke(double d5) {
                double _init_$lambda$6;
                _init_$lambda$6 = Rgb._init_$lambda$6(TransferParameters.this, d5);
                return _init_$lambda$6;
            }
        } : new DoubleFunction() { // from class: n.i
            @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
            public final double invoke(double d5) {
                double _init_$lambda$7;
                _init_$lambda$7 = Rgb._init_$lambda$7(TransferParameters.this, d5);
                return _init_$lambda$7;
            }
        }, (transferParameters.getE() == 0.0d && transferParameters.getF() == 0.0d) ? new DoubleFunction() { // from class: n.j
            @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
            public final double invoke(double d5) {
                double _init_$lambda$8;
                _init_$lambda$8 = Rgb._init_$lambda$8(TransferParameters.this, d5);
                return _init_$lambda$8;
            }
        } : new DoubleFunction() { // from class: n.k
            @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
            public final double invoke(double d5) {
                double _init_$lambda$9;
                _init_$lambda$9 = Rgb._init_$lambda$9(TransferParameters.this, d5);
                return _init_$lambda$9;
            }
        }, 0.0f, 1.0f, transferParameters, i5);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Rgb(String str, float[] fArr, WhitePoint whitePoint, final double d5, float f5, float f6, int i5) {
        this(str, fArr, whitePoint, null, r17, r0, f5, f6, new TransferParameters(d5, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 96, null), i5);
        DoubleFunction doubleFunction;
        DoubleFunction doubleFunction2;
        if (d5 == 1.0d) {
            doubleFunction = DoubleIdentity;
        } else {
            doubleFunction = new DoubleFunction() { // from class: n.f
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double invoke(double d6) {
                    double _init_$lambda$10;
                    _init_$lambda$10 = Rgb._init_$lambda$10(d5, d6);
                    return _init_$lambda$10;
                }
            };
        }
        DoubleFunction doubleFunction3 = doubleFunction;
        if (d5 == 1.0d) {
            doubleFunction2 = DoubleIdentity;
        } else {
            doubleFunction2 = new DoubleFunction() { // from class: n.g
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double invoke(double d6) {
                    double _init_$lambda$11;
                    _init_$lambda$11 = Rgb._init_$lambda$11(d5, d6);
                    return _init_$lambda$11;
                }
            };
        }
    }

    public Rgb(Rgb rgb, float[] fArr, WhitePoint whitePoint) {
        this(rgb.getName(), rgb.primaries, whitePoint, fArr, rgb.oetfOrig, rgb.eotfOrig, rgb.min, rgb.max, rgb.transferParameters, -1);
    }
}
