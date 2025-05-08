package androidx.core.content.res;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
abstract class GrowingArrayUtils {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object[], java.lang.Object] */
    public static <T> T[] append(T[] tArr, int i5, T t5) {
        if (i5 + 1 > tArr.length) {
            ?? r02 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), growSize(i5));
            System.arraycopy(tArr, 0, r02, 0, i5);
            tArr = r02;
        }
        tArr[i5] = t5;
        return tArr;
    }

    public static int growSize(int i5) {
        if (i5 <= 4) {
            return 8;
        }
        return i5 * 2;
    }

    public static int[] append(int[] iArr, int i5, int i6) {
        if (i5 + 1 > iArr.length) {
            int[] iArr2 = new int[growSize(i5)];
            System.arraycopy(iArr, 0, iArr2, 0, i5);
            iArr = iArr2;
        }
        iArr[i5] = i6;
        return iArr;
    }
}
