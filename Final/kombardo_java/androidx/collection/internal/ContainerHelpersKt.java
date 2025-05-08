package androidx.collection.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0000\u001a \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0000\u001a\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0000\u001a\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0000\u001a\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058\u0000X\u0081\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0016"}, d2 = {"EMPTY_INTS", BuildConfig.FLAVOR, "EMPTY_LONGS", BuildConfig.FLAVOR, "EMPTY_OBJECTS", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "[Ljava/lang/Object;", "binarySearch", BuildConfig.FLAVOR, "array", "size", "value", BuildConfig.FLAVOR, "equal", BuildConfig.FLAVOR, "a", "b", "idealByteArraySize", "need", "idealIntArraySize", "idealLongArraySize", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ContainerHelpersKt {
    public static final int[] EMPTY_INTS = new int[0];
    public static final long[] EMPTY_LONGS = new long[0];
    public static final Object[] EMPTY_OBJECTS = new Object[0];

    public static final int binarySearch(int[] array, int i5, int i6) {
        Intrinsics.checkNotNullParameter(array, "array");
        int i7 = i5 - 1;
        int i8 = 0;
        while (i8 <= i7) {
            int i9 = (i8 + i7) >>> 1;
            int i10 = array[i9];
            if (i10 < i6) {
                i8 = i9 + 1;
            } else {
                if (i10 <= i6) {
                    return i9;
                }
                i7 = i9 - 1;
            }
        }
        return ~i8;
    }

    public static final boolean equal(Object obj, Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    public static final int idealByteArraySize(int i5) {
        for (int i6 = 4; i6 < 32; i6++) {
            int i7 = (1 << i6) - 12;
            if (i5 <= i7) {
                return i7;
            }
        }
        return i5;
    }

    public static final int idealIntArraySize(int i5) {
        return idealByteArraySize(i5 * 4) / 4;
    }

    public static final int idealLongArraySize(int i5) {
        return idealByteArraySize(i5 * 8) / 8;
    }

    public static final int binarySearch(long[] array, int i5, long j5) {
        Intrinsics.checkNotNullParameter(array, "array");
        int i6 = i5 - 1;
        int i7 = 0;
        while (i7 <= i6) {
            int i8 = (i7 + i6) >>> 1;
            long j6 = array[i8];
            if (j6 < j5) {
                i7 = i8 + 1;
            } else {
                if (j6 <= j5) {
                    return i8;
                }
                i6 = i8 - 1;
            }
        }
        return ~i7;
    }
}
