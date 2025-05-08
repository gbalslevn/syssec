package com.google.common.collect;

import java.util.Collection;
import java.util.Map;

/* loaded from: classes2.dex */
public interface Multimap<K, V> {
    Map<K, Collection<V>> asMap();
}
