package dagger.internal;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class LazyClassKeyMap<V> implements Map<Class<?>, V> {
    private final Map<String, V> delegate;

    private LazyClassKeyMap(Map<String, V> map) {
        this.delegate = map;
    }

    public static <V> Map<Class<?>, V> of(Map<String, V> map) {
        return new LazyClassKeyMap(map);
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Dagger map bindings are immutable");
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        if (obj instanceof Class) {
            return this.delegate.containsKey(((Class) obj).getName());
        }
        throw new IllegalArgumentException("Key must be a class");
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.delegate.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<Class<?>, V>> entrySet() {
        throw new UnsupportedOperationException("Maps created with @LazyClassKey do not support usage of entrySet(). Consider @ClassKey instead.");
    }

    @Override // java.util.Map
    public V get(Object obj) {
        if (obj instanceof Class) {
            return this.delegate.get(((Class) obj).getName());
        }
        throw new IllegalArgumentException("Key must be a class");
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // java.util.Map
    public Set<Class<?>> keySet() {
        throw new UnsupportedOperationException("Maps created with @LazyClassKey do not support usage of keySet(). Consider @ClassKey instead.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(Class<?> cls, Object obj) {
        return put2(cls, (Class<?>) obj);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Class<?>, ? extends V> map) {
        throw new UnsupportedOperationException("Dagger map bindings are immutable");
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException("Dagger map bindings are immutable");
    }

    @Override // java.util.Map
    public int size() {
        return this.delegate.size();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return this.delegate.values();
    }

    /* renamed from: put, reason: avoid collision after fix types in other method */
    public V put2(Class<?> cls, V v5) {
        throw new UnsupportedOperationException("Dagger map bindings are immutable");
    }
}
