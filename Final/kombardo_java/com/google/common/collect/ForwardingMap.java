package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class ForwardingMap<K, V> extends ForwardingObject implements Map<K, V> {
    @Override // java.util.Map
    public void clear() {
        delegate().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return delegate().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return delegate().containsValue(obj);
    }

    @Override // com.google.common.collect.ForwardingObject
    protected abstract Map<K, V> delegate();

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return delegate().entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // java.util.Map
    public V get(Object obj) {
        return delegate().get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return delegate().keySet();
    }

    @Override // java.util.Map
    public V put(K k5, V v5) {
        return delegate().put(k5, v5);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        delegate().putAll(map);
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        return delegate().remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return delegate().size();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return delegate().values();
    }
}
