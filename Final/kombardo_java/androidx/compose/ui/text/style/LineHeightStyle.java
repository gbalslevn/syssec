package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0003\u0014\u0015\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle;", BuildConfig.FLAVOR, "alignment", "Landroidx/compose/ui/text/style/LineHeightStyle$Alignment;", "trim", "Landroidx/compose/ui/text/style/LineHeightStyle$Trim;", "(FILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlignment-PIaL0Z0", "()F", "F", "getTrim-EVpEnUU", "()I", "I", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Alignment", "Companion", "Trim", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LineHeightStyle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final LineHeightStyle Default;
    private final float alignment;
    private final int trim;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\f\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Alignment;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "topRatio", "constructor-impl", "(F)F", BuildConfig.FLAVOR, "toString-impl", "(F)Ljava/lang/String;", "toString", BuildConfig.FLAVOR, "hashCode-impl", "(F)I", "hashCode", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Alignment {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final float Top = m2507constructorimpl(0.0f);
        private static final float Center = m2507constructorimpl(0.5f);
        private static final float Proportional = m2507constructorimpl(-1.0f);
        private static final float Bottom = m2507constructorimpl(1.0f);

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Alignment$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/text/style/LineHeightStyle$Alignment;", "Center", "F", "getCenter-PIaL0Z0", "()F", "Proportional", "getProportional-PIaL0Z0", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: getCenter-PIaL0Z0, reason: not valid java name */
            public final float m2511getCenterPIaL0Z0() {
                return Alignment.Center;
            }

            /* renamed from: getProportional-PIaL0Z0, reason: not valid java name */
            public final float m2512getProportionalPIaL0Z0() {
                return Alignment.Proportional;
            }

            private Companion() {
            }
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        public static float m2507constructorimpl(float f5) {
            if ((0.0f > f5 || f5 > 1.0f) && f5 != -1.0f) {
                throw new IllegalStateException("topRatio should be in [0..1] range or -1");
            }
            return f5;
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m2508equalsimpl0(float f5, float f6) {
            return Float.compare(f5, f6) == 0;
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m2509hashCodeimpl(float f5) {
            return Float.hashCode(f5);
        }

        /* renamed from: toString-impl, reason: not valid java name */
        public static String m2510toStringimpl(float f5) {
            if (f5 == Top) {
                return "LineHeightStyle.Alignment.Top";
            }
            if (f5 == Center) {
                return "LineHeightStyle.Alignment.Center";
            }
            if (f5 == Proportional) {
                return "LineHeightStyle.Alignment.Proportional";
            }
            if (f5 == Bottom) {
                return "LineHeightStyle.Alignment.Bottom";
            }
            return "LineHeightStyle.Alignment(topPercentage = " + f5 + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Companion;", BuildConfig.FLAVOR, "()V", "Default", "Landroidx/compose/ui/text/style/LineHeightStyle;", "getDefault", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LineHeightStyle getDefault() {
            return LineHeightStyle.Default;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087@\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000f\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000e\u0010\fJ\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Trim;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "constructor-impl", "(I)I", BuildConfig.FLAVOR, "toString-impl", "(I)Ljava/lang/String;", "toString", BuildConfig.FLAVOR, "isTrimFirstLineTop-impl$ui_text_release", "(I)Z", "isTrimFirstLineTop", "isTrimLastLineBottom-impl$ui_text_release", "isTrimLastLineBottom", "hashCode-impl", "hashCode", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Trim {
        private static final int FlagTrimBottom = 16;
        private static final int FlagTrimTop = 1;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int FirstLineTop = m2513constructorimpl(1);
        private static final int LastLineBottom = m2513constructorimpl(16);
        private static final int Both = m2513constructorimpl(17);
        private static final int None = m2513constructorimpl(0);

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Trim$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/text/style/LineHeightStyle$Trim;", "Both", "I", "getBoth-EVpEnUU", "()I", "None", "getNone-EVpEnUU", BuildConfig.FLAVOR, "FlagTrimBottom", "FlagTrimTop", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: getBoth-EVpEnUU, reason: not valid java name */
            public final int m2519getBothEVpEnUU() {
                return Trim.Both;
            }

            /* renamed from: getNone-EVpEnUU, reason: not valid java name */
            public final int m2520getNoneEVpEnUU() {
                return Trim.None;
            }

            private Companion() {
            }
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        private static int m2513constructorimpl(int i5) {
            return i5;
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m2514equalsimpl0(int i5, int i6) {
            return i5 == i6;
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m2515hashCodeimpl(int i5) {
            return Integer.hashCode(i5);
        }

        /* renamed from: isTrimFirstLineTop-impl$ui_text_release, reason: not valid java name */
        public static final boolean m2516isTrimFirstLineTopimpl$ui_text_release(int i5) {
            return (i5 & 1) > 0;
        }

        /* renamed from: isTrimLastLineBottom-impl$ui_text_release, reason: not valid java name */
        public static final boolean m2517isTrimLastLineBottomimpl$ui_text_release(int i5) {
            return (i5 & 16) > 0;
        }

        /* renamed from: toString-impl, reason: not valid java name */
        public static String m2518toStringimpl(int i5) {
            return i5 == FirstLineTop ? "LineHeightStyle.Trim.FirstLineTop" : i5 == LastLineBottom ? "LineHeightStyle.Trim.LastLineBottom" : i5 == Both ? "LineHeightStyle.Trim.Both" : i5 == None ? "LineHeightStyle.Trim.None" : "Invalid";
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        INSTANCE = new Companion(defaultConstructorMarker);
        Default = new LineHeightStyle(Alignment.INSTANCE.m2512getProportionalPIaL0Z0(), Trim.INSTANCE.m2519getBothEVpEnUU(), defaultConstructorMarker);
    }

    public /* synthetic */ LineHeightStyle(float f5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(f5, i5);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LineHeightStyle)) {
            return false;
        }
        LineHeightStyle lineHeightStyle = (LineHeightStyle) other;
        return Alignment.m2508equalsimpl0(this.alignment, lineHeightStyle.alignment) && Trim.m2514equalsimpl0(this.trim, lineHeightStyle.trim);
    }

    /* renamed from: getAlignment-PIaL0Z0, reason: not valid java name and from getter */
    public final float getAlignment() {
        return this.alignment;
    }

    /* renamed from: getTrim-EVpEnUU, reason: not valid java name and from getter */
    public final int getTrim() {
        return this.trim;
    }

    public int hashCode() {
        return (Alignment.m2509hashCodeimpl(this.alignment) * 31) + Trim.m2515hashCodeimpl(this.trim);
    }

    public String toString() {
        return "LineHeightStyle(alignment=" + ((Object) Alignment.m2510toStringimpl(this.alignment)) + ", trim=" + ((Object) Trim.m2518toStringimpl(this.trim)) + ')';
    }

    private LineHeightStyle(float f5, int i5) {
        this.alignment = f5;
        this.trim = i5;
    }
}
