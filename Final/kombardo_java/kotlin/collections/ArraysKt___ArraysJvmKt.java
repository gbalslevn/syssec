package kotlin.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0018\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002*\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0007\u001a-\u0010\r\u001a\u00020\u0006*\u00020\b2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000e\u001aS\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a9\u0010\u0013\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00152\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0013\u0010\u0016\u001a9\u0010\u0013\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0013\u0010\u0017\u001a9\u0010\u0013\u001a\u00020\u0018*\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00182\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0013\u0010\u0019\u001a9\u0010\u0013\u001a\u00020\b*\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0013\u0010\u001a\u001a9\u0010\u0013\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u001b2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0013\u0010\u001c\u001a5\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001a#\u0010\u001f\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u001d\u0010 \u001a#\u0010\u001f\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u001d\u0010!\u001a#\u0010\u001f\u001a\u00020\u0018*\u00020\u00182\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u001d\u0010\"\u001a9\u0010$\u001a\u00020#\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\n\u001a\u00028\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b$\u0010%\u001a-\u0010$\u001a\u00020#*\u00020\u00052\u0006\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b$\u0010&\u001a-\u0010$\u001a\u00020#*\u00020\u00182\u0006\u0010\n\u001a\u00020'2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b$\u0010(\u001a.\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\n\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b)\u0010*\u001a\u001c\u0010)\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\n\u001a\u00020\u0006H\u0086\u0002¢\u0006\u0004\b)\u0010+\u001a6\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0086\u0002¢\u0006\u0004\b)\u0010-\u001a\u001c\u0010)\u001a\u00020\u0005*\u00020\u00052\u0006\u0010,\u001a\u00020\u0005H\u0086\u0002¢\u0006\u0004\b)\u0010.\u001a\u001c\u0010)\u001a\u00020\u0018*\u00020\u00182\u0006\u0010,\u001a\u00020\u0018H\u0086\u0002¢\u0006\u0004\b)\u0010/\u001a\u001c\u0010)\u001a\u00020\b*\u00020\b2\u0006\u0010,\u001a\u00020\bH\u0086\u0002¢\u0006\u0004\b)\u00100\u001a\u001c\u0010)\u001a\u000201*\u0002012\u0006\u0010,\u001a\u000201H\u0086\u0002¢\u0006\u0004\b)\u00102\u001a\u001f\u00103\u001a\u00020#\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b3\u00104\u001a%\u00103\u001a\u00020#*\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b3\u00105\u001a;\u00109\u001a\u00020#\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u001a\u00108\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u000006j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`7¢\u0006\u0004\b9\u0010:\u001aO\u00109\u001a\u00020#\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u001a\u00108\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u000006j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`72\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b9\u0010;\u001a\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0005¢\u0006\u0004\b<\u0010=\u001a\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020'0\u0001*\u00020\u0018¢\u0006\u0004\b<\u0010>\u001a\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020\t0\u0001*\u00020\b¢\u0006\u0004\b<\u0010?\u001a\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020@0\u0001*\u000201¢\u0006\u0004\b<\u0010A¨\u0006B"}, d2 = {"T", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "asList", "([Ljava/lang/Object;)Ljava/util/List;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "([I)Ljava/util/List;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "element", "fromIndex", "toIndex", "binarySearch", "([FFII)I", "destination", "destinationOffset", "startIndex", "endIndex", "copyInto", "([Ljava/lang/Object;[Ljava/lang/Object;III)[Ljava/lang/Object;", BuildConfig.FLAVOR, "([B[BIII)[B", "([I[IIII)[I", BuildConfig.FLAVOR, "([J[JIII)[J", "([F[FIII)[F", BuildConfig.FLAVOR, "([C[CIII)[C", "copyOfRange", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "copyOfRangeImpl", "([BII)[B", "([III)[I", "([JII)[J", BuildConfig.FLAVOR, "fill", "([Ljava/lang/Object;Ljava/lang/Object;II)V", "([IIII)V", BuildConfig.FLAVOR, "([JJII)V", "plus", "([Ljava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;", "([II)[I", "elements", "([Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;", "([I[I)[I", "([J[J)[J", "([F[F)[F", BuildConfig.FLAVOR, "([Z[Z)[Z", "sort", "([Ljava/lang/Object;)V", "([III)V", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "sortWith", "([Ljava/lang/Object;Ljava/util/Comparator;)V", "([Ljava/lang/Object;Ljava/util/Comparator;II)V", "toTypedArray", "([I)[Ljava/lang/Integer;", "([J)[Ljava/lang/Long;", "([F)[Ljava/lang/Float;", BuildConfig.FLAVOR, "([Z)[Ljava/lang/Boolean;", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/collections/ArraysKt")
/* loaded from: classes2.dex */
public abstract class ArraysKt___ArraysJvmKt extends ArraysKt__ArraysKt {
    public static <T> List<T> asList(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        List<T> asList = ArraysUtilJVM.asList(tArr);
        Intrinsics.checkNotNullExpressionValue(asList, "asList(...)");
        return asList;
    }

    public static final int binarySearch(float[] fArr, float f5, int i5, int i6) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return Arrays.binarySearch(fArr, i5, i6, f5);
    }

    public static /* synthetic */ int binarySearch$default(float[] fArr, float f5, int i5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i5 = 0;
        }
        if ((i7 & 4) != 0) {
            i6 = fArr.length;
        }
        return binarySearch(fArr, f5, i5, i6);
    }

    public static <T> T[] copyInto(T[] tArr, T[] destination, int i5, int i6, int i7) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(tArr, i6, destination, i5, i7 - i6);
        return destination;
    }

    public static /* synthetic */ Object[] copyInto$default(Object[] objArr, Object[] objArr2, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i5 = 0;
        }
        if ((i8 & 4) != 0) {
            i6 = 0;
        }
        if ((i8 & 8) != 0) {
            i7 = objArr.length;
        }
        return ArraysKt.copyInto(objArr, objArr2, i5, i6, i7);
    }

    public static <T> T[] copyOfRange(T[] tArr, int i5, int i6) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i6, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i5, i6);
        Intrinsics.checkNotNullExpressionValue(tArr2, "copyOfRange(...)");
        return tArr2;
    }

    public static <T> void fill(T[] tArr, T t5, int i5, int i6) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Arrays.fill(tArr, i5, i6, t5);
    }

    public static /* synthetic */ void fill$default(Object[] objArr, Object obj, int i5, int i6, int i7, Object obj2) {
        if ((i7 & 2) != 0) {
            i5 = 0;
        }
        if ((i7 & 4) != 0) {
            i6 = objArr.length;
        }
        ArraysKt.fill(objArr, obj, i5, i6);
    }

    public static <T> T[] plus(T[] tArr, T t5) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = tArr.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, length + 1);
        tArr2[length] = t5;
        Intrinsics.checkNotNull(tArr2);
        return tArr2;
    }

    public static <T> void sort(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    public static final <T> void sortWith(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    public static Integer[] toTypedArray(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Integer[] numArr = new Integer[iArr.length];
        int length = iArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            numArr[i5] = Integer.valueOf(iArr[i5]);
        }
        return numArr;
    }

    public static List<Integer> asList(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return new ArraysKt___ArraysJvmKt$asList$3(iArr);
    }

    public static byte[] copyInto(byte[] bArr, byte[] destination, int i5, int i6, int i7) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(bArr, i6, destination, i5, i7 - i6);
        return destination;
    }

    public static final void fill(int[] iArr, int i5, int i6, int i7) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Arrays.fill(iArr, i6, i7, i5);
    }

    public static void sort(int[] iArr, int i5, int i6) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Arrays.sort(iArr, i5, i6);
    }

    public static <T> void sortWith(T[] tArr, Comparator<? super T> comparator, int i5, int i6) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Arrays.sort(tArr, i5, i6, comparator);
    }

    public static int[] copyInto(int[] iArr, int[] destination, int i5, int i6, int i7) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(iArr, i6, destination, i5, i7 - i6);
        return destination;
    }

    public static /* synthetic */ byte[] copyInto$default(byte[] bArr, byte[] bArr2, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i5 = 0;
        }
        if ((i8 & 4) != 0) {
            i6 = 0;
        }
        if ((i8 & 8) != 0) {
            i7 = bArr.length;
        }
        return ArraysKt.copyInto(bArr, bArr2, i5, i6, i7);
    }

    public static byte[] copyOfRange(byte[] bArr, int i5, int i6) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i6, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i5, i6);
        Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    public static final void fill(long[] jArr, long j5, int i5, int i6) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Arrays.fill(jArr, i5, i6, j5);
    }

    public static /* synthetic */ void fill$default(int[] iArr, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = iArr.length;
        }
        fill(iArr, i5, i6, i7);
    }

    public static long[] copyInto(long[] jArr, long[] destination, int i5, int i6, int i7) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(jArr, i6, destination, i5, i7 - i6);
        return destination;
    }

    public static Long[] toTypedArray(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Long[] lArr = new Long[jArr.length];
        int length = jArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            lArr[i5] = Long.valueOf(jArr[i5]);
        }
        return lArr;
    }

    public static float[] copyInto(float[] fArr, float[] destination, int i5, int i6, int i7) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(fArr, i6, destination, i5, i7 - i6);
        return destination;
    }

    public static /* synthetic */ int[] copyInto$default(int[] iArr, int[] iArr2, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i5 = 0;
        }
        if ((i8 & 4) != 0) {
            i6 = 0;
        }
        if ((i8 & 8) != 0) {
            i7 = iArr.length;
        }
        return ArraysKt.copyInto(iArr, iArr2, i5, i6, i7);
    }

    public static int[] copyOfRange(int[] iArr, int i5, int i6) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i6, iArr.length);
        int[] copyOfRange = Arrays.copyOfRange(iArr, i5, i6);
        Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    public static /* synthetic */ void fill$default(long[] jArr, long j5, int i5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i5 = 0;
        }
        if ((i7 & 4) != 0) {
            i6 = jArr.length;
        }
        fill(jArr, j5, i5, i6);
    }

    public static int[] plus(int[] iArr, int i5) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, length + 1);
        copyOf[length] = i5;
        Intrinsics.checkNotNull(copyOf);
        return copyOf;
    }

    public static char[] copyInto(char[] cArr, char[] destination, int i5, int i6, int i7) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(cArr, i6, destination, i5, i7 - i6);
        return destination;
    }

    public static /* synthetic */ float[] copyInto$default(float[] fArr, float[] fArr2, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i5 = 0;
        }
        if ((i8 & 4) != 0) {
            i6 = 0;
        }
        if ((i8 & 8) != 0) {
            i7 = fArr.length;
        }
        return ArraysKt.copyInto(fArr, fArr2, i5, i6, i7);
    }

    public static long[] copyOfRange(long[] jArr, int i5, int i6) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i6, jArr.length);
        long[] copyOfRange = Arrays.copyOfRange(jArr, i5, i6);
        Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    public static Float[] toTypedArray(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Float[] fArr2 = new Float[fArr.length];
        int length = fArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            fArr2[i5] = Float.valueOf(fArr[i5]);
        }
        return fArr2;
    }

    public static <T> T[] plus(T[] tArr, T[] elements) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = tArr.length;
        int length2 = elements.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, length + length2);
        System.arraycopy(elements, 0, tArr2, length, length2);
        Intrinsics.checkNotNull(tArr2);
        return tArr2;
    }

    public static Boolean[] toTypedArray(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Boolean[] boolArr = new Boolean[zArr.length];
        int length = zArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            boolArr[i5] = Boolean.valueOf(zArr[i5]);
        }
        return boolArr;
    }

    public static int[] plus(int[] iArr, int[] elements) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = iArr.length;
        int length2 = elements.length;
        int[] copyOf = Arrays.copyOf(iArr, length + length2);
        System.arraycopy(elements, 0, copyOf, length, length2);
        Intrinsics.checkNotNull(copyOf);
        return copyOf;
    }

    public static long[] plus(long[] jArr, long[] elements) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = jArr.length;
        int length2 = elements.length;
        long[] copyOf = Arrays.copyOf(jArr, length + length2);
        System.arraycopy(elements, 0, copyOf, length, length2);
        Intrinsics.checkNotNull(copyOf);
        return copyOf;
    }

    public static float[] plus(float[] fArr, float[] elements) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = fArr.length;
        int length2 = elements.length;
        float[] copyOf = Arrays.copyOf(fArr, length + length2);
        System.arraycopy(elements, 0, copyOf, length, length2);
        Intrinsics.checkNotNull(copyOf);
        return copyOf;
    }

    public static boolean[] plus(boolean[] zArr, boolean[] elements) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = zArr.length;
        int length2 = elements.length;
        boolean[] copyOf = Arrays.copyOf(zArr, length + length2);
        System.arraycopy(elements, 0, copyOf, length, length2);
        Intrinsics.checkNotNull(copyOf);
        return copyOf;
    }
}
