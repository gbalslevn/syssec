package androidx.arch.core.internal;

import androidx.arch.core.internal.SafeIterableMap;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {
    private final HashMap<K, SafeIterableMap.Entry<K, V>> mHashMap = new HashMap<>();

    public Map.Entry<K, V> ceil(K k5) {
        if (contains(k5)) {
            return this.mHashMap.get(k5).mPrevious;
        }
        return null;
    }

    public boolean contains(K k5) {
        return this.mHashMap.containsKey(k5);
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    protected SafeIterableMap.Entry<K, V> get(K k5) {
        return this.mHashMap.get(k5);
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public V putIfAbsent(K k5, V v5) {
        SafeIterableMap.Entry<K, V> entry = get(k5);
        if (entry != null) {
            return entry.mValue;
        }
        this.mHashMap.put(k5, put(k5, v5));
        return null;
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public V remove(K k5) {
        V v5 = (V) super.remove(k5);
        this.mHashMap.remove(k5);
        return v5;
    }
}
