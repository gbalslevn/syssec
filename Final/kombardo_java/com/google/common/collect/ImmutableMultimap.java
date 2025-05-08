package com.google.common.collect;

import com.google.common.collect.Serialization;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class ImmutableMultimap<K, V> extends BaseImmutableMultimap<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final transient ImmutableMap<K, ? extends ImmutableCollection<V>> map;
    final transient int size;

    /* loaded from: classes2.dex */
    public static class Builder<K, V> {
        final Map<K, Collection<V>> builderMap = Platform.preservesInsertionOrderOnPutsMap();
        Comparator<? super K> keyComparator;
        Comparator<? super V> valueComparator;
    }

    /* loaded from: classes2.dex */
    static class FieldSettersHolder {
        static final Serialization.FieldSetter<ImmutableMultimap> MAP_FIELD_SETTER = Serialization.getFieldSetter(ImmutableMultimap.class, "map");
        static final Serialization.FieldSetter<ImmutableMultimap> SIZE_FIELD_SETTER = Serialization.getFieldSetter(ImmutableMultimap.class, "size");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> immutableMap, int i5) {
        this.map = immutableMap;
        this.size = i5;
    }

    @Override // com.google.common.collect.AbstractMultimap
    public boolean containsValue(Object obj) {
        return obj != null && super.containsValue(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public ImmutableMap<K, Collection<V>> asMap() {
        return this.map;
    }
}
