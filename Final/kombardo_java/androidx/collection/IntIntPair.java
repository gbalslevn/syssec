package androidx.collection;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087@\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0000\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0015\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u0012\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0003\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000f\u0088\u0001\b\u0092\u0001\u00020\u0007¨\u0006\u001b"}, d2 = {"Landroidx/collection/IntIntPair;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "first", "second", "constructor-impl", "(II)J", BuildConfig.FLAVOR, "packedValue", "(J)J", BuildConfig.FLAVOR, "toString-impl", "(J)Ljava/lang/String;", "toString", "hashCode-impl", "(J)I", "hashCode", "other", BuildConfig.FLAVOR, "equals-impl", "(JLjava/lang/Object;)Z", "equals", "J", "getPackedValue$annotations", "()V", "getFirst-impl", "getSecond-impl", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IntIntPair {
    public final long packedValue;

    private /* synthetic */ IntIntPair(long j5) {
        this.packedValue = j5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntIntPair m6boximpl(long j5) {
        return new IntIntPair(j5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m8constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m9equalsimpl(long j5, Object obj) {
        return (obj instanceof IntIntPair) && j5 == ((IntIntPair) obj).getPackedValue();
    }

    /* renamed from: getFirst-impl, reason: not valid java name */
    public static final int m10getFirstimpl(long j5) {
        return (int) (j5 >> 32);
    }

    /* renamed from: getSecond-impl, reason: not valid java name */
    public static final int m11getSecondimpl(long j5) {
        return (int) (j5 & 4294967295L);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m12hashCodeimpl(long j5) {
        return Long.hashCode(j5);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m13toStringimpl(long j5) {
        return '(' + m10getFirstimpl(j5) + ", " + m11getSecondimpl(j5) + ')';
    }

    public boolean equals(Object obj) {
        return m9equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m12hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m13toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m7constructorimpl(int i5, int i6) {
        return m8constructorimpl((i6 & 4294967295L) | (i5 << 32));
    }
}
