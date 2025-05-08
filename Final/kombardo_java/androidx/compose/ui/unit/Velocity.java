package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087@\u0018\u0000 )2\u00020\u0001:\u0001)B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u000eJ\u001e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0006H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0019\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001d\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010!\u001a\u00020\u001e2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\"R\u001a\u0010\u0007\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u001a\u0010\b\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010&\u001a\u0004\b'\u0010$\u0088\u0001\u0003\u0092\u0001\u00020\u0002\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006*"}, d2 = {"Landroidx/compose/ui/unit/Velocity;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "packedValue", "constructor-impl", "(J)J", BuildConfig.FLAVOR, "x", "y", "copy-OhffZ5M", "(JFF)J", "copy", "other", "minus-AH228Gc", "(JJ)J", "minus", "plus-AH228Gc", "plus", "operand", "times-adjELrA", "(JF)J", "times", BuildConfig.FLAVOR, "toString-impl", "(J)Ljava/lang/String;", "toString", BuildConfig.FLAVOR, "hashCode-impl", "(J)I", "hashCode", BuildConfig.FLAVOR, "equals-impl", "(JLjava/lang/Object;)Z", "equals", "J", "getX-impl", "(J)F", "getX$annotations", "()V", "getY-impl", "getY$annotations", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Velocity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = m2696constructorimpl(0);
    private final long packedValue;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Landroidx/compose/ui/unit/Velocity$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/unit/Velocity;", "Zero", "J", "getZero-9UxMQ8M", "()J", "getZero-9UxMQ8M$annotations", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getZero-9UxMQ8M, reason: not valid java name */
        public final long m2709getZero9UxMQ8M() {
            return Velocity.Zero;
        }

        private Companion() {
        }
    }

    private /* synthetic */ Velocity(long j5) {
        this.packedValue = j5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Velocity m2695boximpl(long j5) {
        return new Velocity(j5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m2696constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: copy-OhffZ5M, reason: not valid java name */
    public static final long m2697copyOhffZ5M(long j5, float f5, float f6) {
        return m2696constructorimpl((Float.floatToRawIntBits(f5) << 32) | (Float.floatToRawIntBits(f6) & 4294967295L));
    }

    /* renamed from: copy-OhffZ5M$default, reason: not valid java name */
    public static /* synthetic */ long m2698copyOhffZ5M$default(long j5, float f5, float f6, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = Float.intBitsToFloat((int) (j5 >> 32));
        }
        if ((i5 & 2) != 0) {
            f6 = Float.intBitsToFloat((int) (4294967295L & j5));
        }
        return m2697copyOhffZ5M(j5, f5, f6);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2699equalsimpl(long j5, Object obj) {
        return (obj instanceof Velocity) && j5 == ((Velocity) obj).getPackedValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2700equalsimpl0(long j5, long j6) {
        return j5 == j6;
    }

    /* renamed from: getX-impl, reason: not valid java name */
    public static final float m2701getXimpl(long j5) {
        return Float.intBitsToFloat((int) (j5 >> 32));
    }

    /* renamed from: getY-impl, reason: not valid java name */
    public static final float m2702getYimpl(long j5) {
        return Float.intBitsToFloat((int) (j5 & 4294967295L));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2703hashCodeimpl(long j5) {
        return Long.hashCode(j5);
    }

    /* renamed from: minus-AH228Gc, reason: not valid java name */
    public static final long m2704minusAH228Gc(long j5, long j6) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32)) - Float.intBitsToFloat((int) (j6 >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L)) - Float.intBitsToFloat((int) (j6 & 4294967295L));
        return m2696constructorimpl((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L));
    }

    /* renamed from: plus-AH228Gc, reason: not valid java name */
    public static final long m2705plusAH228Gc(long j5, long j6) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32)) + Float.intBitsToFloat((int) (j6 >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L)) + Float.intBitsToFloat((int) (j6 & 4294967295L));
        return m2696constructorimpl((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L));
    }

    /* renamed from: times-adjELrA, reason: not valid java name */
    public static final long m2706timesadjELrA(long j5, float f5) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32)) * f5;
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L)) * f5;
        return m2696constructorimpl((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L));
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2707toStringimpl(long j5) {
        return '(' + m2701getXimpl(j5) + ", " + m2702getYimpl(j5) + ") px/sec";
    }

    public boolean equals(Object obj) {
        return m2699equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2703hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m2707toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }
}
