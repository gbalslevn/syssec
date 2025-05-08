package com.google.common.collect;

import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public abstract class ForwardingConcurrentMap<K, V> extends ForwardingMap<K, V> implements ConcurrentMap<K, V> {
    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    protected abstract ConcurrentMap<K, V> delegate();

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k5, V v5) {
        return delegate().putIfAbsent(k5, v5);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        return delegate().remove(obj, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k5, V v5) {
        return delegate().replace(k5, v5);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k5, V v5, V v6) {
        return delegate().replace(k5, v5, v6);
    }
}
