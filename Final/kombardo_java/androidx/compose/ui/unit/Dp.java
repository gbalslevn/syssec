package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087@\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H\u0097\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0011\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0016\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u0088\u0001\u0003\u0092\u0001\u00020\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/unit/Dp;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "constructor-impl", "(F)F", "other", BuildConfig.FLAVOR, "compareTo-0680j_4", "(FF)I", "compareTo", BuildConfig.FLAVOR, "toString-impl", "(F)Ljava/lang/String;", "toString", "hashCode-impl", "(F)I", "hashCode", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "equals-impl", "(FLjava/lang/Object;)Z", "equals", "F", "getValue", "()F", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Dp implements Comparable<Dp> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float Hairline = m2599constructorimpl(0.0f);
    private static final float Infinity = m2599constructorimpl(Float.POSITIVE_INFINITY);
    private static final float Unspecified = m2599constructorimpl(Float.NaN);
    private final float value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR&\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\n\u0010\u0006\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\u000b\u0010\bR&\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u000e\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/unit/Dp$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/unit/Dp;", "Hairline", "F", "getHairline-D9Ej5fM", "()F", "getHairline-D9Ej5fM$annotations", "Infinity", "getInfinity-D9Ej5fM", "getInfinity-D9Ej5fM$annotations", "Unspecified", "getUnspecified-D9Ej5fM", "getUnspecified-D9Ej5fM$annotations", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getHairline-D9Ej5fM, reason: not valid java name */
        public final float m2606getHairlineD9Ej5fM() {
            return Dp.Hairline;
        }

        /* renamed from: getInfinity-D9Ej5fM, reason: not valid java name */
        public final float m2607getInfinityD9Ej5fM() {
            return Dp.Infinity;
        }

        /* renamed from: getUnspecified-D9Ej5fM, reason: not valid java name */
        public final float m2608getUnspecifiedD9Ej5fM() {
            return Dp.Unspecified;
        }

        private Companion() {
        }
    }

    private /* synthetic */ Dp(float f5) {
        this.value = f5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Dp m2597boximpl(float f5) {
        return new Dp(f5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static float m2599constructorimpl(float f5) {
        return f5;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2600equalsimpl(float f5, Object obj) {
        return (obj instanceof Dp) && Float.compare(f5, ((Dp) obj).getValue()) == 0;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2601equalsimpl0(float f5, float f6) {
        return Float.compare(f5, f6) == 0;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2602hashCodeimpl(float f5) {
        return Float.hashCode(f5);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2603toStringimpl(float f5) {
        if (Float.isNaN(f5)) {
            return "Dp.Unspecified";
        }
        return f5 + ".dp";
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Dp dp) {
        return m2604compareTo0680j_4(dp.getValue());
    }

    /* renamed from: compareTo-0680j_4, reason: not valid java name */
    public int m2604compareTo0680j_4(float f5) {
        return m2598compareTo0680j_4(this.value, f5);
    }

    public boolean equals(Object obj) {
        return m2600equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2602hashCodeimpl(this.value);
    }

    public String toString() {
        return m2603toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ float getValue() {
        return this.value;
    }

    /* renamed from: compareTo-0680j_4, reason: not valid java name */
    public static int m2598compareTo0680j_4(float f5, float f6) {
        return Float.compare(f5, f6);
    }
}
