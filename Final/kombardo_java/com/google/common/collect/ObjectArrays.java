package com.google.common.collect;

/* loaded from: classes2.dex */
public abstract class ObjectArrays {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object checkElementNotNull(Object obj, int i5) {
        if (obj != null) {
            return obj;
        }
        StringBuilder sb = new StringBuilder(20);
        sb.append("at index ");
        sb.append(i5);
        throw new NullPointerException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] checkElementsNotNull(Object... objArr) {
        checkElementsNotNull(objArr, objArr.length);
        return objArr;
    }

    public static <T> T[] newArray(T[] tArr, int i5) {
        return (T[]) Platform.newArray(tArr, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] checkElementsNotNull(Object[] objArr, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            checkElementNotNull(objArr[i6], i6);
        }
        return objArr;
    }
}
