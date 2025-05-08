package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087@\u0018\u0000 \u001b2\u00020\u0001:\u0004\u001b\u001c\u001d\u001eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0005J\u001a\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00128Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005R\u0017\u0010\u0017\u001a\u00020\u00158Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0005R\u0017\u0010\u001a\u001a\u00020\u00188Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0005\u0088\u0001\u0003\u0092\u0001\u00020\u0002\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "mask", "constructor-impl", "(I)I", BuildConfig.FLAVOR, "toString-impl", "(I)Ljava/lang/String;", "toString", "hashCode-impl", "hashCode", "other", BuildConfig.FLAVOR, "equals-impl", "(ILjava/lang/Object;)Z", "equals", "I", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "getStrategy-fcGXIks", "strategy", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "getStrictness-usljTpc", "strictness", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "getWordBreak-jp8hJ3c", "wordBreak", "Companion", "Strategy", "Strictness", "WordBreak", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LineBreak {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Heading;
    private static final int Paragraph;
    private static final int Simple;
    private static final int Unspecified;
    private final int mask;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR&\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\n\u0010\u0006\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\u000b\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\r"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/text/style/LineBreak;", "Simple", "I", "getSimple-rAG3T2k", "()I", "getSimple-rAG3T2k$annotations", "Unspecified", "getUnspecified-rAG3T2k", "getUnspecified-rAG3T2k$annotations", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getSimple-rAG3T2k, reason: not valid java name */
        public final int m2485getSimplerAG3T2k() {
            return LineBreak.Simple;
        }

        /* renamed from: getUnspecified-rAG3T2k, reason: not valid java name */
        public final int m2486getUnspecifiedrAG3T2k() {
            return LineBreak.Unspecified;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087@\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\b\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strategy;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "constructor-impl", "(I)I", BuildConfig.FLAVOR, "toString-impl", "(I)Ljava/lang/String;", "toString", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Strategy {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int Simple = m2487constructorimpl(1);
        private static final int HighQuality = m2487constructorimpl(2);
        private static final int Balanced = m2487constructorimpl(3);
        private static final int Unspecified = m2487constructorimpl(0);

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u001d\u0010\u000b\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\r"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strategy$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "Simple", "I", "getSimple-fcGXIks", "()I", "HighQuality", "getHighQuality-fcGXIks", "Balanced", "getBalanced-fcGXIks", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: getBalanced-fcGXIks, reason: not valid java name */
            public final int m2490getBalancedfcGXIks() {
                return Strategy.Balanced;
            }

            /* renamed from: getHighQuality-fcGXIks, reason: not valid java name */
            public final int m2491getHighQualityfcGXIks() {
                return Strategy.HighQuality;
            }

            /* renamed from: getSimple-fcGXIks, reason: not valid java name */
            public final int m2492getSimplefcGXIks() {
                return Strategy.Simple;
            }

            private Companion() {
            }
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        public static int m2487constructorimpl(int i5) {
            return i5;
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m2488equalsimpl0(int i5, int i6) {
            return i5 == i6;
        }

        /* renamed from: toString-impl, reason: not valid java name */
        public static String m2489toStringimpl(int i5) {
            return m2488equalsimpl0(i5, Simple) ? "Strategy.Simple" : m2488equalsimpl0(i5, HighQuality) ? "Strategy.HighQuality" : m2488equalsimpl0(i5, Balanced) ? "Strategy.Balanced" : m2488equalsimpl0(i5, Unspecified) ? "Strategy.Unspecified" : "Invalid";
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087@\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\b\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strictness;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "constructor-impl", "(I)I", BuildConfig.FLAVOR, "toString-impl", "(I)Ljava/lang/String;", "toString", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Strictness {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int Default = m2493constructorimpl(1);
        private static final int Loose = m2493constructorimpl(2);
        private static final int Normal = m2493constructorimpl(3);
        private static final int Strict = m2493constructorimpl(4);
        private static final int Unspecified = m2493constructorimpl(0);

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u001d\u0010\u000b\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u001d\u0010\r\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strictness$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "Default", "I", "getDefault-usljTpc", "()I", "Loose", "getLoose-usljTpc", "Normal", "getNormal-usljTpc", "Strict", "getStrict-usljTpc", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: getDefault-usljTpc, reason: not valid java name */
            public final int m2496getDefaultusljTpc() {
                return Strictness.Default;
            }

            /* renamed from: getLoose-usljTpc, reason: not valid java name */
            public final int m2497getLooseusljTpc() {
                return Strictness.Loose;
            }

            /* renamed from: getNormal-usljTpc, reason: not valid java name */
            public final int m2498getNormalusljTpc() {
                return Strictness.Normal;
            }

            /* renamed from: getStrict-usljTpc, reason: not valid java name */
            public final int m2499getStrictusljTpc() {
                return Strictness.Strict;
            }

            private Companion() {
            }
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        public static int m2493constructorimpl(int i5) {
            return i5;
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m2494equalsimpl0(int i5, int i6) {
            return i5 == i6;
        }

        /* renamed from: toString-impl, reason: not valid java name */
        public static String m2495toStringimpl(int i5) {
            return m2494equalsimpl0(i5, Default) ? "Strictness.None" : m2494equalsimpl0(i5, Loose) ? "Strictness.Loose" : m2494equalsimpl0(i5, Normal) ? "Strictness.Normal" : m2494equalsimpl0(i5, Strict) ? "Strictness.Strict" : m2494equalsimpl0(i5, Unspecified) ? "Strictness.Unspecified" : "Invalid";
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087@\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\b\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$WordBreak;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "constructor-impl", "(I)I", BuildConfig.FLAVOR, "toString-impl", "(I)Ljava/lang/String;", "toString", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class WordBreak {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int Default = m2500constructorimpl(1);
        private static final int Phrase = m2500constructorimpl(2);
        private static final int Unspecified = m2500constructorimpl(0);

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$WordBreak$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "Default", "I", "getDefault-jp8hJ3c", "()I", "Phrase", "getPhrase-jp8hJ3c", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: getDefault-jp8hJ3c, reason: not valid java name */
            public final int m2503getDefaultjp8hJ3c() {
                return WordBreak.Default;
            }

            /* renamed from: getPhrase-jp8hJ3c, reason: not valid java name */
            public final int m2504getPhrasejp8hJ3c() {
                return WordBreak.Phrase;
            }

            private Companion() {
            }
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        public static int m2500constructorimpl(int i5) {
            return i5;
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m2501equalsimpl0(int i5, int i6) {
            return i5 == i6;
        }

        /* renamed from: toString-impl, reason: not valid java name */
        public static String m2502toStringimpl(int i5) {
            return m2501equalsimpl0(i5, Default) ? "WordBreak.None" : m2501equalsimpl0(i5, Phrase) ? "WordBreak.Phrase" : m2501equalsimpl0(i5, Unspecified) ? "WordBreak.Unspecified" : "Invalid";
        }
    }

    static {
        int packBytes;
        int packBytes2;
        int packBytes3;
        Strategy.Companion companion = Strategy.INSTANCE;
        int m2492getSimplefcGXIks = companion.m2492getSimplefcGXIks();
        Strictness.Companion companion2 = Strictness.INSTANCE;
        int m2498getNormalusljTpc = companion2.m2498getNormalusljTpc();
        WordBreak.Companion companion3 = WordBreak.INSTANCE;
        packBytes = LineBreak_androidKt.packBytes(m2492getSimplefcGXIks, m2498getNormalusljTpc, companion3.m2503getDefaultjp8hJ3c());
        Simple = m2476constructorimpl(packBytes);
        packBytes2 = LineBreak_androidKt.packBytes(companion.m2490getBalancedfcGXIks(), companion2.m2497getLooseusljTpc(), companion3.m2504getPhrasejp8hJ3c());
        Heading = m2476constructorimpl(packBytes2);
        packBytes3 = LineBreak_androidKt.packBytes(companion.m2491getHighQualityfcGXIks(), companion2.m2499getStrictusljTpc(), companion3.m2503getDefaultjp8hJ3c());
        Paragraph = m2476constructorimpl(packBytes3);
        Unspecified = m2476constructorimpl(0);
    }

    private /* synthetic */ LineBreak(int i5) {
        this.mask = i5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ LineBreak m2475boximpl(int i5) {
        return new LineBreak(i5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int m2476constructorimpl(int i5) {
        return i5;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2477equalsimpl(int i5, Object obj) {
        return (obj instanceof LineBreak) && i5 == ((LineBreak) obj).getMask();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2478equalsimpl0(int i5, int i6) {
        return i5 == i6;
    }

    /* renamed from: getStrategy-fcGXIks, reason: not valid java name */
    public static final int m2479getStrategyfcGXIks(int i5) {
        int unpackByte1;
        unpackByte1 = LineBreak_androidKt.unpackByte1(i5);
        return Strategy.m2487constructorimpl(unpackByte1);
    }

    /* renamed from: getStrictness-usljTpc, reason: not valid java name */
    public static final int m2480getStrictnessusljTpc(int i5) {
        int unpackByte2;
        unpackByte2 = LineBreak_androidKt.unpackByte2(i5);
        return Strictness.m2493constructorimpl(unpackByte2);
    }

    /* renamed from: getWordBreak-jp8hJ3c, reason: not valid java name */
    public static final int m2481getWordBreakjp8hJ3c(int i5) {
        int unpackByte3;
        unpackByte3 = LineBreak_androidKt.unpackByte3(i5);
        return WordBreak.m2500constructorimpl(unpackByte3);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2482hashCodeimpl(int i5) {
        return Integer.hashCode(i5);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2483toStringimpl(int i5) {
        return "LineBreak(strategy=" + ((Object) Strategy.m2489toStringimpl(m2479getStrategyfcGXIks(i5))) + ", strictness=" + ((Object) Strictness.m2495toStringimpl(m2480getStrictnessusljTpc(i5))) + ", wordBreak=" + ((Object) WordBreak.m2502toStringimpl(m2481getWordBreakjp8hJ3c(i5))) + ')';
    }

    public boolean equals(Object obj) {
        return m2477equalsimpl(this.mask, obj);
    }

    public int hashCode() {
        return m2482hashCodeimpl(this.mask);
    }

    public String toString() {
        return m2483toStringimpl(this.mask);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getMask() {
        return this.mask;
    }
}
