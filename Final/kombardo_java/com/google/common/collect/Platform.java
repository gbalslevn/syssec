package com.google.common.collect;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes2.dex */
abstract class Platform {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] copy(Object[] objArr, int i5, int i6, T[] tArr) {
        return (T[]) Arrays.copyOfRange(objArr, i5, i6, tArr.getClass());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] newArray(T[] tArr, int i5) {
        return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Map<K, V> preservesInsertionOrderOnPutsMap() {
        return CompactHashMap.create();
    }
}
