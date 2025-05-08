package kotlin.reflect.jvm.internal.impl.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public abstract class CollectionsKt {
    public static final <T> void addIfNotNull(Collection<T> collection, T t5) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        if (t5 != null) {
            collection.add(t5);
        }
    }

    private static final int capacity(int i5) {
        if (i5 < 3) {
            return 3;
        }
        return i5 + (i5 / 3) + 1;
    }

    public static final <T> List<T> compact(ArrayList<T> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        int size = arrayList.size();
        if (size == 0) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        if (size == 1) {
            return kotlin.collections.CollectionsKt.listOf(kotlin.collections.CollectionsKt.first((List) arrayList));
        }
        arrayList.trimToSize();
        return arrayList;
    }

    public static final <K> Map<K, Integer> mapToIndex(Iterable<? extends K> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends K> it = iterable.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            linkedHashMap.put(it.next(), Integer.valueOf(i5));
            i5++;
        }
        return linkedHashMap;
    }

    public static final <K, V> HashMap<K, V> newHashMapWithExpectedSize(int i5) {
        return new HashMap<>(capacity(i5));
    }

    public static final <E> HashSet<E> newHashSetWithExpectedSize(int i5) {
        return new HashSet<>(capacity(i5));
    }

    public static final <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int i5) {
        return new LinkedHashSet<>(capacity(i5));
    }
}
