package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0087@\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0012\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u0012\u0004\b\u0014\u0010\u0015R \u0010\u001a\u001a\u00020\u00168FX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u0017\u0010\u0018R \u0010\u001d\u001a\u00020\u00168FX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001b\u0010\u0018\u0088\u0001\u0003\u0092\u0001\u00020\u0002\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/unit/DpOffset;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "packedValue", "constructor-impl", "(J)J", BuildConfig.FLAVOR, "toString-impl", "(J)Ljava/lang/String;", "toString", BuildConfig.FLAVOR, "hashCode-impl", "(J)I", "hashCode", "other", BuildConfig.FLAVOR, "equals-impl", "(JLjava/lang/Object;)Z", "equals", "J", "getPackedValue$annotations", "()V", "Landroidx/compose/ui/unit/Dp;", "getX-D9Ej5fM", "(J)F", "getX-D9Ej5fM$annotations", "x", "getY-D9Ej5fM", "getY-D9Ej5fM$annotations", "y", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DpOffset {
    private final long packedValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = m2613constructorimpl(0);
    private static final long Unspecified = m2613constructorimpl(9205357640488583168L);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/unit/DpOffset$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private /* synthetic */ DpOffset(long j5) {
        this.packedValue = j5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DpOffset m2612boximpl(long j5) {
        return new DpOffset(j5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m2613constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2614equalsimpl(long j5, Object obj) {
        return (obj instanceof DpOffset) && j5 == ((DpOffset) obj).getPackedValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2615equalsimpl0(long j5, long j6) {
        return j5 == j6;
    }

    /* renamed from: getX-D9Ej5fM, reason: not valid java name */
    public static final float m2616getXD9Ej5fM(long j5) {
        return Dp.m2599constructorimpl(Float.intBitsToFloat((int) (j5 >> 32)));
    }

    /* renamed from: getY-D9Ej5fM, reason: not valid java name */
    public static final float m2617getYD9Ej5fM(long j5) {
        return Dp.m2599constructorimpl(Float.intBitsToFloat((int) (j5 & 4294967295L)));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2618hashCodeimpl(long j5) {
        return Long.hashCode(j5);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2619toStringimpl(long j5) {
        if (j5 == 9205357640488583168L) {
            return "DpOffset.Unspecified";
        }
        return '(' + ((Object) Dp.m2603toStringimpl(m2616getXD9Ej5fM(j5))) + ", " + ((Object) Dp.m2603toStringimpl(m2617getYD9Ej5fM(j5))) + ')';
    }

    public boolean equals(Object obj) {
        return m2614equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2618hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m2619toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }
}
