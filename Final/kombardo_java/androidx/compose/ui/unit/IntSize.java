package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087@\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0012\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u0012\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\n8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0016\u0010\fR\u001a\u0010\u001b\u001a\u00020\n8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0019\u0010\f\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/unit/IntSize;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "packedValue", "constructor-impl", "(J)J", BuildConfig.FLAVOR, "toString-impl", "(J)Ljava/lang/String;", "toString", BuildConfig.FLAVOR, "hashCode-impl", "(J)I", "hashCode", "other", BuildConfig.FLAVOR, "equals-impl", "(JLjava/lang/Object;)Z", "equals", "J", "getPackedValue$annotations", "()V", "getWidth-impl", "getWidth$annotations", "width", "getHeight-impl", "getHeight$annotations", "height", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IntSize {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = m2657constructorimpl(0);
    private final long packedValue;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, d2 = {"Landroidx/compose/ui/unit/IntSize$Companion;", BuildConfig.FLAVOR, "()V", "Zero", "Landroidx/compose/ui/unit/IntSize;", "getZero-YbymL2g", "()J", "J", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getZero-YbymL2g, reason: not valid java name */
        public final long m2665getZeroYbymL2g() {
            return IntSize.Zero;
        }

        private Companion() {
        }
    }

    private /* synthetic */ IntSize(long j5) {
        this.packedValue = j5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntSize m2656boximpl(long j5) {
        return new IntSize(j5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m2657constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2658equalsimpl(long j5, Object obj) {
        return (obj instanceof IntSize) && j5 == ((IntSize) obj).getPackedValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2659equalsimpl0(long j5, long j6) {
        return j5 == j6;
    }

    /* renamed from: getHeight-impl, reason: not valid java name */
    public static final int m2660getHeightimpl(long j5) {
        return (int) (j5 & 4294967295L);
    }

    /* renamed from: getWidth-impl, reason: not valid java name */
    public static final int m2661getWidthimpl(long j5) {
        return (int) (j5 >> 32);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2662hashCodeimpl(long j5) {
        return Long.hashCode(j5);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2663toStringimpl(long j5) {
        return m2661getWidthimpl(j5) + " x " + m2660getHeightimpl(j5);
    }

    public boolean equals(Object obj) {
        return m2658equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2662hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m2663toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }
}
