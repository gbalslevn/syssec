package androidx.compose.ui.geometry;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\b\u0087@\u0018\u0000 42\u00020\u0001:\u00014B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000f\u001a\u00020\fH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0013\u0010\u0011J\u0016\u0010\u0016\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0005J\u001b\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0019J\u001e\u0010 \u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0006H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001e\u0010\"\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0006H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u001fJ\u000f\u0010&\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u0010\u0010*\u001a\u00020'HÖ\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010-\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b+\u0010,R\u0014\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010.R\u001a\u0010\u0007\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b0\u00101\u001a\u0004\b/\u0010\u0011R\u001a\u0010\b\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b3\u00101\u001a\u0004\b2\u0010\u0011\u0088\u0001\u0003\u0092\u0001\u00020\u0002\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"Landroidx/compose/ui/geometry/Offset;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "packedValue", "constructor-impl", "(J)J", BuildConfig.FLAVOR, "x", "y", "copy-dBAh8RU", "(JFF)J", "copy", BuildConfig.FLAVOR, "isValid-impl", "(J)Z", "isValid", "getDistance-impl", "(J)F", "getDistance", "getDistanceSquared-impl", "getDistanceSquared", "unaryMinus-F1C5BW0", "unaryMinus", "other", "minus-MK-Hz9U", "(JJ)J", "minus", "plus-MK-Hz9U", "plus", "operand", "times-tuRUvjQ", "(JF)J", "times", "div-tuRUvjQ", "div", BuildConfig.FLAVOR, "toString-impl", "(J)Ljava/lang/String;", "toString", BuildConfig.FLAVOR, "hashCode-impl", "(J)I", "hashCode", "equals-impl", "(JLjava/lang/Object;)Z", "equals", "J", "getX-impl", "getX$annotations", "()V", "getY-impl", "getY$annotations", "Companion", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Offset {
    private final long packedValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = m1329constructorimpl(0);
    private static final long Infinite = m1329constructorimpl(9187343241974906880L);
    private static final long Unspecified = m1329constructorimpl(9205357640488583168L);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR&\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\n\u0010\u0006\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\u000b\u0010\bR&\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u000e\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/geometry/Offset$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/geometry/Offset;", "Zero", "J", "getZero-F1C5BW0", "()J", "getZero-F1C5BW0$annotations", "Infinite", "getInfinite-F1C5BW0", "getInfinite-F1C5BW0$annotations", "Unspecified", "getUnspecified-F1C5BW0", "getUnspecified-F1C5BW0$annotations", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getInfinite-F1C5BW0, reason: not valid java name */
        public final long m1347getInfiniteF1C5BW0() {
            return Offset.Infinite;
        }

        /* renamed from: getUnspecified-F1C5BW0, reason: not valid java name */
        public final long m1348getUnspecifiedF1C5BW0() {
            return Offset.Unspecified;
        }

        /* renamed from: getZero-F1C5BW0, reason: not valid java name */
        public final long m1349getZeroF1C5BW0() {
            return Offset.Zero;
        }

        private Companion() {
        }
    }

    private /* synthetic */ Offset(long j5) {
        this.packedValue = j5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Offset m1328boximpl(long j5) {
        return new Offset(j5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m1329constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: copy-dBAh8RU, reason: not valid java name */
    public static final long m1330copydBAh8RU(long j5, float f5, float f6) {
        return m1329constructorimpl((Float.floatToRawIntBits(f5) << 32) | (Float.floatToRawIntBits(f6) & 4294967295L));
    }

    /* renamed from: copy-dBAh8RU$default, reason: not valid java name */
    public static /* synthetic */ long m1331copydBAh8RU$default(long j5, float f5, float f6, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = Float.intBitsToFloat((int) (j5 >> 32));
        }
        if ((i5 & 2) != 0) {
            f6 = Float.intBitsToFloat((int) (4294967295L & j5));
        }
        return m1330copydBAh8RU(j5, f5, f6);
    }

    /* renamed from: div-tuRUvjQ, reason: not valid java name */
    public static final long m1332divtuRUvjQ(long j5, float f5) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32)) / f5;
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L)) / f5;
        return m1329constructorimpl((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L));
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1333equalsimpl(long j5, Object obj) {
        return (obj instanceof Offset) && j5 == ((Offset) obj).getPackedValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1334equalsimpl0(long j5, long j6) {
        return j5 == j6;
    }

    /* renamed from: getDistance-impl, reason: not valid java name */
    public static final float m1335getDistanceimpl(long j5) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L));
        return (float) Math.sqrt((intBitsToFloat * intBitsToFloat) + (intBitsToFloat2 * intBitsToFloat2));
    }

    /* renamed from: getDistanceSquared-impl, reason: not valid java name */
    public static final float m1336getDistanceSquaredimpl(long j5) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L));
        return (intBitsToFloat * intBitsToFloat) + (intBitsToFloat2 * intBitsToFloat2);
    }

    /* renamed from: getX-impl, reason: not valid java name */
    public static final float m1337getXimpl(long j5) {
        return Float.intBitsToFloat((int) (j5 >> 32));
    }

    /* renamed from: getY-impl, reason: not valid java name */
    public static final float m1338getYimpl(long j5) {
        return Float.intBitsToFloat((int) (j5 & 4294967295L));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1339hashCodeimpl(long j5) {
        return Long.hashCode(j5);
    }

    /* renamed from: isValid-impl, reason: not valid java name */
    public static final boolean m1340isValidimpl(long j5) {
        long j6 = j5 & 9223372034707292159L;
        return (((~j6) & (j6 - 9187343246269874177L)) & (-9223372034707292160L)) == -9223372034707292160L;
    }

    /* renamed from: minus-MK-Hz9U, reason: not valid java name */
    public static final long m1341minusMKHz9U(long j5, long j6) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32)) - Float.intBitsToFloat((int) (j6 >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L)) - Float.intBitsToFloat((int) (j6 & 4294967295L));
        return m1329constructorimpl((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L));
    }

    /* renamed from: plus-MK-Hz9U, reason: not valid java name */
    public static final long m1342plusMKHz9U(long j5, long j6) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32)) + Float.intBitsToFloat((int) (j6 >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L)) + Float.intBitsToFloat((int) (j6 & 4294967295L));
        return m1329constructorimpl((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L));
    }

    /* renamed from: times-tuRUvjQ, reason: not valid java name */
    public static final long m1343timestuRUvjQ(long j5, float f5) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32)) * f5;
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L)) * f5;
        return m1329constructorimpl((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L));
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1344toStringimpl(long j5) {
        if (!OffsetKt.m1351isSpecifiedk4lQ0M(j5)) {
            return "Offset.Unspecified";
        }
        return "Offset(" + GeometryUtilsKt.toStringAsFixed(m1337getXimpl(j5), 1) + ", " + GeometryUtilsKt.toStringAsFixed(m1338getYimpl(j5), 1) + ')';
    }

    /* renamed from: unaryMinus-F1C5BW0, reason: not valid java name */
    public static final long m1345unaryMinusF1C5BW0(long j5) {
        return m1329constructorimpl(j5 ^ (-9223372034707292160L));
    }

    public boolean equals(Object obj) {
        return m1333equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m1339hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m1344toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }
}
