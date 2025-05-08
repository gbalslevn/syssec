package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087@\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0005\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\r"}, d2 = {"Landroidx/compose/ui/graphics/BlendMode;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "constructor-impl", "(I)I", BuildConfig.FLAVOR, "toString-impl", "(I)Ljava/lang/String;", "toString", "hashCode-impl", "hashCode", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class BlendMode {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Clear = m1428constructorimpl(0);
    private static final int Src = m1428constructorimpl(1);
    private static final int Dst = m1428constructorimpl(2);
    private static final int SrcOver = m1428constructorimpl(3);
    private static final int DstOver = m1428constructorimpl(4);
    private static final int SrcIn = m1428constructorimpl(5);
    private static final int DstIn = m1428constructorimpl(6);
    private static final int SrcOut = m1428constructorimpl(7);
    private static final int DstOut = m1428constructorimpl(8);
    private static final int SrcAtop = m1428constructorimpl(9);
    private static final int DstAtop = m1428constructorimpl(10);
    private static final int Xor = m1428constructorimpl(11);
    private static final int Plus = m1428constructorimpl(12);
    private static final int Modulate = m1428constructorimpl(13);
    private static final int Screen = m1428constructorimpl(14);
    private static final int Overlay = m1428constructorimpl(15);
    private static final int Darken = m1428constructorimpl(16);
    private static final int Lighten = m1428constructorimpl(17);
    private static final int ColorDodge = m1428constructorimpl(18);
    private static final int ColorBurn = m1428constructorimpl(19);
    private static final int Hardlight = m1428constructorimpl(20);
    private static final int Softlight = m1428constructorimpl(21);
    private static final int Difference = m1428constructorimpl(22);
    private static final int Exclusion = m1428constructorimpl(23);
    private static final int Multiply = m1428constructorimpl(24);
    private static final int Hue = m1428constructorimpl(25);
    private static final int Saturation = m1428constructorimpl(26);
    private static final int Color = m1428constructorimpl(27);
    private static final int Luminosity = m1428constructorimpl(28);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b<\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006R\u0019\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0013\u0010\u0006R\u0019\u0010\u0014\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0015\u0010\u0006R\u0019\u0010\u0016\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0017\u0010\u0006R\u0019\u0010\u0018\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0019\u0010\u0006R\u0019\u0010\u001a\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001b\u0010\u0006R\u0019\u0010\u001c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001d\u0010\u0006R\u0019\u0010\u001e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001f\u0010\u0006R\u0019\u0010 \u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b!\u0010\u0006R\u0019\u0010\"\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b#\u0010\u0006R\u0019\u0010$\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b%\u0010\u0006R\u0019\u0010&\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b'\u0010\u0006R\u0019\u0010(\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b)\u0010\u0006R\u0019\u0010*\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b+\u0010\u0006R\u0019\u0010,\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b-\u0010\u0006R\u0019\u0010.\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b/\u0010\u0006R\u0019\u00100\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b1\u0010\u0006R\u0019\u00102\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b3\u0010\u0006R\u0019\u00104\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b5\u0010\u0006R\u0019\u00106\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b7\u0010\u0006R\u0019\u00108\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b9\u0010\u0006R\u0019\u0010:\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b;\u0010\u0006R\u0019\u0010<\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b=\u0010\u0006R\u0019\u0010>\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b?\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006@"}, d2 = {"Landroidx/compose/ui/graphics/BlendMode$Companion;", BuildConfig.FLAVOR, "()V", "Clear", "Landroidx/compose/ui/graphics/BlendMode;", "getClear-0nO6VwU", "()I", "I", "Color", "getColor-0nO6VwU", "ColorBurn", "getColorBurn-0nO6VwU", "ColorDodge", "getColorDodge-0nO6VwU", "Darken", "getDarken-0nO6VwU", "Difference", "getDifference-0nO6VwU", "Dst", "getDst-0nO6VwU", "DstAtop", "getDstAtop-0nO6VwU", "DstIn", "getDstIn-0nO6VwU", "DstOut", "getDstOut-0nO6VwU", "DstOver", "getDstOver-0nO6VwU", "Exclusion", "getExclusion-0nO6VwU", "Hardlight", "getHardlight-0nO6VwU", "Hue", "getHue-0nO6VwU", "Lighten", "getLighten-0nO6VwU", "Luminosity", "getLuminosity-0nO6VwU", "Modulate", "getModulate-0nO6VwU", "Multiply", "getMultiply-0nO6VwU", "Overlay", "getOverlay-0nO6VwU", "Plus", "getPlus-0nO6VwU", "Saturation", "getSaturation-0nO6VwU", "Screen", "getScreen-0nO6VwU", "Softlight", "getSoftlight-0nO6VwU", "Src", "getSrc-0nO6VwU", "SrcAtop", "getSrcAtop-0nO6VwU", "SrcIn", "getSrcIn-0nO6VwU", "SrcOut", "getSrcOut-0nO6VwU", "SrcOver", "getSrcOver-0nO6VwU", "Xor", "getXor-0nO6VwU", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getClear-0nO6VwU, reason: not valid java name */
        public final int m1432getClear0nO6VwU() {
            return BlendMode.Clear;
        }

        /* renamed from: getColor-0nO6VwU, reason: not valid java name */
        public final int m1433getColor0nO6VwU() {
            return BlendMode.Color;
        }

        /* renamed from: getColorBurn-0nO6VwU, reason: not valid java name */
        public final int m1434getColorBurn0nO6VwU() {
            return BlendMode.ColorBurn;
        }

        /* renamed from: getColorDodge-0nO6VwU, reason: not valid java name */
        public final int m1435getColorDodge0nO6VwU() {
            return BlendMode.ColorDodge;
        }

        /* renamed from: getDarken-0nO6VwU, reason: not valid java name */
        public final int m1436getDarken0nO6VwU() {
            return BlendMode.Darken;
        }

        /* renamed from: getDifference-0nO6VwU, reason: not valid java name */
        public final int m1437getDifference0nO6VwU() {
            return BlendMode.Difference;
        }

        /* renamed from: getDst-0nO6VwU, reason: not valid java name */
        public final int m1438getDst0nO6VwU() {
            return BlendMode.Dst;
        }

        /* renamed from: getDstAtop-0nO6VwU, reason: not valid java name */
        public final int m1439getDstAtop0nO6VwU() {
            return BlendMode.DstAtop;
        }

        /* renamed from: getDstIn-0nO6VwU, reason: not valid java name */
        public final int m1440getDstIn0nO6VwU() {
            return BlendMode.DstIn;
        }

        /* renamed from: getDstOut-0nO6VwU, reason: not valid java name */
        public final int m1441getDstOut0nO6VwU() {
            return BlendMode.DstOut;
        }

        /* renamed from: getDstOver-0nO6VwU, reason: not valid java name */
        public final int m1442getDstOver0nO6VwU() {
            return BlendMode.DstOver;
        }

        /* renamed from: getExclusion-0nO6VwU, reason: not valid java name */
        public final int m1443getExclusion0nO6VwU() {
            return BlendMode.Exclusion;
        }

        /* renamed from: getHardlight-0nO6VwU, reason: not valid java name */
        public final int m1444getHardlight0nO6VwU() {
            return BlendMode.Hardlight;
        }

        /* renamed from: getHue-0nO6VwU, reason: not valid java name */
        public final int m1445getHue0nO6VwU() {
            return BlendMode.Hue;
        }

        /* renamed from: getLighten-0nO6VwU, reason: not valid java name */
        public final int m1446getLighten0nO6VwU() {
            return BlendMode.Lighten;
        }

        /* renamed from: getLuminosity-0nO6VwU, reason: not valid java name */
        public final int m1447getLuminosity0nO6VwU() {
            return BlendMode.Luminosity;
        }

        /* renamed from: getModulate-0nO6VwU, reason: not valid java name */
        public final int m1448getModulate0nO6VwU() {
            return BlendMode.Modulate;
        }

        /* renamed from: getMultiply-0nO6VwU, reason: not valid java name */
        public final int m1449getMultiply0nO6VwU() {
            return BlendMode.Multiply;
        }

        /* renamed from: getOverlay-0nO6VwU, reason: not valid java name */
        public final int m1450getOverlay0nO6VwU() {
            return BlendMode.Overlay;
        }

        /* renamed from: getPlus-0nO6VwU, reason: not valid java name */
        public final int m1451getPlus0nO6VwU() {
            return BlendMode.Plus;
        }

        /* renamed from: getSaturation-0nO6VwU, reason: not valid java name */
        public final int m1452getSaturation0nO6VwU() {
            return BlendMode.Saturation;
        }

        /* renamed from: getScreen-0nO6VwU, reason: not valid java name */
        public final int m1453getScreen0nO6VwU() {
            return BlendMode.Screen;
        }

        /* renamed from: getSoftlight-0nO6VwU, reason: not valid java name */
        public final int m1454getSoftlight0nO6VwU() {
            return BlendMode.Softlight;
        }

        /* renamed from: getSrc-0nO6VwU, reason: not valid java name */
        public final int m1455getSrc0nO6VwU() {
            return BlendMode.Src;
        }

        /* renamed from: getSrcAtop-0nO6VwU, reason: not valid java name */
        public final int m1456getSrcAtop0nO6VwU() {
            return BlendMode.SrcAtop;
        }

        /* renamed from: getSrcIn-0nO6VwU, reason: not valid java name */
        public final int m1457getSrcIn0nO6VwU() {
            return BlendMode.SrcIn;
        }

        /* renamed from: getSrcOut-0nO6VwU, reason: not valid java name */
        public final int m1458getSrcOut0nO6VwU() {
            return BlendMode.SrcOut;
        }

        /* renamed from: getSrcOver-0nO6VwU, reason: not valid java name */
        public final int m1459getSrcOver0nO6VwU() {
            return BlendMode.SrcOver;
        }

        /* renamed from: getXor-0nO6VwU, reason: not valid java name */
        public final int m1460getXor0nO6VwU() {
            return BlendMode.Xor;
        }

        private Companion() {
        }
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1428constructorimpl(int i5) {
        return i5;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1429equalsimpl0(int i5, int i6) {
        return i5 == i6;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1430hashCodeimpl(int i5) {
        return Integer.hashCode(i5);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1431toStringimpl(int i5) {
        return m1429equalsimpl0(i5, Clear) ? "Clear" : m1429equalsimpl0(i5, Src) ? "Src" : m1429equalsimpl0(i5, Dst) ? "Dst" : m1429equalsimpl0(i5, SrcOver) ? "SrcOver" : m1429equalsimpl0(i5, DstOver) ? "DstOver" : m1429equalsimpl0(i5, SrcIn) ? "SrcIn" : m1429equalsimpl0(i5, DstIn) ? "DstIn" : m1429equalsimpl0(i5, SrcOut) ? "SrcOut" : m1429equalsimpl0(i5, DstOut) ? "DstOut" : m1429equalsimpl0(i5, SrcAtop) ? "SrcAtop" : m1429equalsimpl0(i5, DstAtop) ? "DstAtop" : m1429equalsimpl0(i5, Xor) ? "Xor" : m1429equalsimpl0(i5, Plus) ? "Plus" : m1429equalsimpl0(i5, Modulate) ? "Modulate" : m1429equalsimpl0(i5, Screen) ? "Screen" : m1429equalsimpl0(i5, Overlay) ? "Overlay" : m1429equalsimpl0(i5, Darken) ? "Darken" : m1429equalsimpl0(i5, Lighten) ? "Lighten" : m1429equalsimpl0(i5, ColorDodge) ? "ColorDodge" : m1429equalsimpl0(i5, ColorBurn) ? "ColorBurn" : m1429equalsimpl0(i5, Hardlight) ? "HardLight" : m1429equalsimpl0(i5, Softlight) ? "Softlight" : m1429equalsimpl0(i5, Difference) ? "Difference" : m1429equalsimpl0(i5, Exclusion) ? "Exclusion" : m1429equalsimpl0(i5, Multiply) ? "Multiply" : m1429equalsimpl0(i5, Hue) ? "Hue" : m1429equalsimpl0(i5, Saturation) ? "Saturation" : m1429equalsimpl0(i5, Color) ? "Color" : m1429equalsimpl0(i5, Luminosity) ? "Luminosity" : "Unknown";
    }
}
