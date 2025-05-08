package androidx.collection;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
abstract class ArraySetJvmUtil {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] resizeForToArray(T[] tArr, int i5) {
        if (tArr.length < i5) {
            return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i5));
        }
        if (tArr.length > i5) {
            tArr[i5] = null;
        }
        return tArr;
    }
}
