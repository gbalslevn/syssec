package kotlin.collections.unsigned;

import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a \u0010\r\u001a\u00020\n*\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0087\u0004¢\u0006\u0004\b\u000b\u0010\f\u001a \u0010\r\u001a\u00020\n*\u0004\u0018\u00010\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0000H\u0087\u0004¢\u0006\u0004\b\u000e\u0010\u000f\u001a \u0010\r\u001a\u00020\n*\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\u0010H\u0087\u0004¢\u0006\u0004\b\u0011\u0010\u0012\u001a \u0010\r\u001a\u00020\n*\u0004\u0018\u00010\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u0013H\u0087\u0004¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lkotlin/ULongArray;", "Lkotlin/ranges/IntRange;", "indices", BuildConfig.FLAVOR, "Lkotlin/ULong;", "slice-ZRhS8yI", "([JLkotlin/ranges/IntRange;)Ljava/util/List;", "slice", "Lkotlin/UIntArray;", "other", BuildConfig.FLAVOR, "contentEquals-KJPZfPQ", "([I[I)Z", "contentEquals", "contentEquals-lec5QzE", "([J[J)Z", "Lkotlin/UByteArray;", "contentEquals-kV0jMPg", "([B[B)Z", "Lkotlin/UShortArray;", "contentEquals-FGO6Aew", "([S[S)Z", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/collections/unsigned/UArraysKt")
/* loaded from: classes2.dex */
public abstract class UArraysKt___UArraysKt extends UArraysKt___UArraysJvmKt {
    /* renamed from: contentEquals-FGO6Aew, reason: not valid java name */
    public static boolean m3676contentEqualsFGO6Aew(short[] sArr, short[] sArr2) {
        if (sArr == null) {
            sArr = null;
        }
        if (sArr2 == null) {
            sArr2 = null;
        }
        return Arrays.equals(sArr, sArr2);
    }

    /* renamed from: contentEquals-KJPZfPQ, reason: not valid java name */
    public static boolean m3677contentEqualsKJPZfPQ(int[] iArr, int[] iArr2) {
        if (iArr == null) {
            iArr = null;
        }
        if (iArr2 == null) {
            iArr2 = null;
        }
        return Arrays.equals(iArr, iArr2);
    }

    /* renamed from: contentEquals-kV0jMPg, reason: not valid java name */
    public static boolean m3678contentEqualskV0jMPg(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            bArr = null;
        }
        if (bArr2 == null) {
            bArr2 = null;
        }
        return Arrays.equals(bArr, bArr2);
    }

    /* renamed from: contentEquals-lec5QzE, reason: not valid java name */
    public static boolean m3679contentEqualslec5QzE(long[] jArr, long[] jArr2) {
        if (jArr == null) {
            jArr = null;
        }
        if (jArr2 == null) {
            jArr2 = null;
        }
        return Arrays.equals(jArr, jArr2);
    }

    /* renamed from: slice-ZRhS8yI, reason: not valid java name */
    public static List<ULong> m3680sliceZRhS8yI(long[] slice, IntRange indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt.emptyList() : UArraysKt___UArraysJvmKt.m3671asListQwZRm1k(ULongArray.m3630constructorimpl(ArraysKt.copyOfRange(slice, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1)));
    }
}
