package kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u001f\u0010\n\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\tH\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\tH\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lkotlin/ULong;", "v1", "v2", "ulongDivide-eb3DHEI", "(JJ)J", "ulongDivide", BuildConfig.FLAVOR, "uintCompare", "(II)I", BuildConfig.FLAVOR, "ulongCompare", "(JJ)I", "value", BuildConfig.FLAVOR, "ulongToDouble", "(J)D", "base", BuildConfig.FLAVOR, "ulongToString", "(JI)Ljava/lang/String;", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class UnsignedKt {
    public static final int uintCompare(int i5, int i6) {
        return Intrinsics.compare(i5 ^ Integer.MIN_VALUE, i6 ^ Integer.MIN_VALUE);
    }

    public static final int ulongCompare(long j5, long j6) {
        return Intrinsics.compare(j5 ^ Long.MIN_VALUE, j6 ^ Long.MIN_VALUE);
    }

    /* renamed from: ulongDivide-eb3DHEI, reason: not valid java name */
    public static final long m3667ulongDivideeb3DHEI(long j5, long j6) {
        if (j6 < 0) {
            return Long.compareUnsigned(j5, j6) < 0 ? ULong.m3622constructorimpl(0L) : ULong.m3622constructorimpl(1L);
        }
        if (j5 >= 0) {
            return ULong.m3622constructorimpl(j5 / j6);
        }
        long j7 = ((j5 >>> 1) / j6) << 1;
        return ULong.m3622constructorimpl(j7 + (Long.compareUnsigned(ULong.m3622constructorimpl(j5 - (j7 * j6)), ULong.m3622constructorimpl(j6)) < 0 ? 0 : 1));
    }

    public static final double ulongToDouble(long j5) {
        return ((j5 >>> 11) * 2048) + (j5 & 2047);
    }

    public static final String ulongToString(long j5, int i5) {
        if (j5 >= 0) {
            String l5 = Long.toString(j5, CharsKt.checkRadix(i5));
            Intrinsics.checkNotNullExpressionValue(l5, "toString(...)");
            return l5;
        }
        long j6 = i5;
        long j7 = ((j5 >>> 1) / j6) << 1;
        long j8 = j5 - (j7 * j6);
        if (j8 >= j6) {
            j8 -= j6;
            j7++;
        }
        StringBuilder sb = new StringBuilder();
        String l6 = Long.toString(j7, CharsKt.checkRadix(i5));
        Intrinsics.checkNotNullExpressionValue(l6, "toString(...)");
        sb.append(l6);
        String l7 = Long.toString(j8, CharsKt.checkRadix(i5));
        Intrinsics.checkNotNullExpressionValue(l7, "toString(...)");
        sb.append(l7);
        return sb.toString();
    }
}
