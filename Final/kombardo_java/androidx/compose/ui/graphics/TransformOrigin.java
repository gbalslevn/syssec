package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0087@\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0012\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u0012\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0019\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/graphics/TransformOrigin;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "packedValue", "constructor-impl", "(J)J", BuildConfig.FLAVOR, "toString-impl", "(J)Ljava/lang/String;", "toString", BuildConfig.FLAVOR, "hashCode-impl", "(J)I", "hashCode", "other", BuildConfig.FLAVOR, "equals-impl", "(JLjava/lang/Object;)Z", "equals", "J", "getPackedValue$annotations", "()V", BuildConfig.FLAVOR, "getPivotFractionX-impl", "(J)F", "pivotFractionX", "getPivotFractionY-impl", "pivotFractionY", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TransformOrigin {
    private final long packedValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Center = TransformOriginKt.TransformOrigin(0.5f, 0.5f);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, d2 = {"Landroidx/compose/ui/graphics/TransformOrigin$Companion;", BuildConfig.FLAVOR, "()V", "Center", "Landroidx/compose/ui/graphics/TransformOrigin;", "getCenter-SzJe1aQ", "()J", "J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getCenter-SzJe1aQ, reason: not valid java name */
        public final long m1635getCenterSzJe1aQ() {
            return TransformOrigin.Center;
        }

        private Companion() {
        }
    }

    private /* synthetic */ TransformOrigin(long j5) {
        this.packedValue = j5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TransformOrigin m1626boximpl(long j5) {
        return new TransformOrigin(j5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m1627constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1628equalsimpl(long j5, Object obj) {
        return (obj instanceof TransformOrigin) && j5 == ((TransformOrigin) obj).getPackedValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1629equalsimpl0(long j5, long j6) {
        return j5 == j6;
    }

    /* renamed from: getPivotFractionX-impl, reason: not valid java name */
    public static final float m1630getPivotFractionXimpl(long j5) {
        return Float.intBitsToFloat((int) (j5 >> 32));
    }

    /* renamed from: getPivotFractionY-impl, reason: not valid java name */
    public static final float m1631getPivotFractionYimpl(long j5) {
        return Float.intBitsToFloat((int) (j5 & 4294967295L));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1632hashCodeimpl(long j5) {
        return Long.hashCode(j5);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1633toStringimpl(long j5) {
        return "TransformOrigin(packedValue=" + j5 + ')';
    }

    public boolean equals(Object obj) {
        return m1628equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m1632hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m1633toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }
}
