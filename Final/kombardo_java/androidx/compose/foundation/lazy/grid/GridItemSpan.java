package androidx.compose.foundation.lazy.grid;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0010\u0010\tJ\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/lazy/grid/GridItemSpan;", BuildConfig.FLAVOR, "packedValue", BuildConfig.FLAVOR, "constructor-impl", "(J)J", "currentLineSpan", BuildConfig.FLAVOR, "getCurrentLineSpan-impl", "(J)I", "equals", BuildConfig.FLAVOR, "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", BuildConfig.FLAVOR, "toString-impl", "(J)Ljava/lang/String;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GridItemSpan {
    private final long packedValue;

    private /* synthetic */ GridItemSpan(long j5) {
        this.packedValue = j5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ GridItemSpan m380boximpl(long j5) {
        return new GridItemSpan(j5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m381constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m382equalsimpl(long j5, Object obj) {
        return (obj instanceof GridItemSpan) && j5 == ((GridItemSpan) obj).getPackedValue();
    }

    /* renamed from: getCurrentLineSpan-impl, reason: not valid java name */
    public static final int m383getCurrentLineSpanimpl(long j5) {
        return (int) j5;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m384hashCodeimpl(long j5) {
        return Long.hashCode(j5);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m385toStringimpl(long j5) {
        return "GridItemSpan(packedValue=" + j5 + ')';
    }

    public boolean equals(Object obj) {
        return m382equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m384hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m385toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }
}
