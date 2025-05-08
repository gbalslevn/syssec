package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087@\u0018\u0000 *2\u00020\u0001:\u0001*B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\u0006H\u0087\n¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u0006H\u0087\n¢\u0006\u0004\b\n\u0010\bJ'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0013J\u0016\u0010\u0018\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u001c\u001a\u00020\u0019H\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001e\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001d\u0010\bJ\u001a\u0010\"\u001a\u00020\u001f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0003\u0010#\u0012\u0004\b$\u0010%R\u001a\u0010\f\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010%\u001a\u0004\b&\u0010\bR\u001a\u0010\r\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010%\u001a\u0004\b(\u0010\b\u0088\u0001\u0003\u0092\u0001\u00020\u0002\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006+"}, d2 = {"Landroidx/compose/ui/unit/IntOffset;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "packedValue", "constructor-impl", "(J)J", BuildConfig.FLAVOR, "component1-impl", "(J)I", "component1", "component2-impl", "component2", "x", "y", "copy-iSbpLlY", "(JII)J", "copy", "other", "minus-qkQi6aY", "(JJ)J", "minus", "plus-qkQi6aY", "plus", "unaryMinus-nOcc-ac", "unaryMinus", BuildConfig.FLAVOR, "toString-impl", "(J)Ljava/lang/String;", "toString", "hashCode-impl", "hashCode", BuildConfig.FLAVOR, "equals-impl", "(JLjava/lang/Object;)Z", "equals", "J", "getPackedValue$annotations", "()V", "getX-impl", "getX$annotations", "getY-impl", "getY$annotations", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IntOffset {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = m2635constructorimpl(0);
    private final long packedValue;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, d2 = {"Landroidx/compose/ui/unit/IntOffset$Companion;", BuildConfig.FLAVOR, "()V", "Zero", "Landroidx/compose/ui/unit/IntOffset;", "getZero-nOcc-ac", "()J", "J", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getZero-nOcc-ac, reason: not valid java name */
        public final long m2648getZeronOccac() {
            return IntOffset.Zero;
        }

        private Companion() {
        }
    }

    private /* synthetic */ IntOffset(long j5) {
        this.packedValue = j5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntOffset m2632boximpl(long j5) {
        return new IntOffset(j5);
    }

    /* renamed from: component1-impl, reason: not valid java name */
    public static final int m2633component1impl(long j5) {
        return m2640getXimpl(j5);
    }

    /* renamed from: component2-impl, reason: not valid java name */
    public static final int m2634component2impl(long j5) {
        return m2641getYimpl(j5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m2635constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: copy-iSbpLlY, reason: not valid java name */
    public static final long m2636copyiSbpLlY(long j5, int i5, int i6) {
        return m2635constructorimpl((i5 << 32) | (i6 & 4294967295L));
    }

    /* renamed from: copy-iSbpLlY$default, reason: not valid java name */
    public static /* synthetic */ long m2637copyiSbpLlY$default(long j5, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i5 = (int) (j5 >> 32);
        }
        if ((i7 & 2) != 0) {
            i6 = (int) (4294967295L & j5);
        }
        return m2636copyiSbpLlY(j5, i5, i6);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2638equalsimpl(long j5, Object obj) {
        return (obj instanceof IntOffset) && j5 == ((IntOffset) obj).getPackedValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2639equalsimpl0(long j5, long j6) {
        return j5 == j6;
    }

    /* renamed from: getX-impl, reason: not valid java name */
    public static final int m2640getXimpl(long j5) {
        return (int) (j5 >> 32);
    }

    /* renamed from: getY-impl, reason: not valid java name */
    public static final int m2641getYimpl(long j5) {
        return (int) (j5 & 4294967295L);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2642hashCodeimpl(long j5) {
        return Long.hashCode(j5);
    }

    /* renamed from: minus-qkQi6aY, reason: not valid java name */
    public static final long m2643minusqkQi6aY(long j5, long j6) {
        return m2635constructorimpl(((((int) (j5 >> 32)) - ((int) (j6 >> 32))) << 32) | ((((int) (j5 & 4294967295L)) - ((int) (j6 & 4294967295L))) & 4294967295L));
    }

    /* renamed from: plus-qkQi6aY, reason: not valid java name */
    public static final long m2644plusqkQi6aY(long j5, long j6) {
        return m2635constructorimpl(((((int) (j5 >> 32)) + ((int) (j6 >> 32))) << 32) | ((((int) (j5 & 4294967295L)) + ((int) (j6 & 4294967295L))) & 4294967295L));
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2645toStringimpl(long j5) {
        return '(' + m2640getXimpl(j5) + ", " + m2641getYimpl(j5) + ')';
    }

    /* renamed from: unaryMinus-nOcc-ac, reason: not valid java name */
    public static final long m2646unaryMinusnOccac(long j5) {
        return m2635constructorimpl(((-((int) (j5 & 4294967295L))) & 4294967295L) | ((-((int) (j5 >> 32))) << 32));
    }

    public boolean equals(Object obj) {
        return m2638equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2642hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m2645toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }
}
