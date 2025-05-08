package io.michaelrocks.libphonenumber.android.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class RegexCache {
    private LRUCache<String, Pattern> cache;

    /* loaded from: classes2.dex */
    private static class LRUCache<K, V> {
        private LinkedHashMap<K, V> map;
        private int size;

        public LRUCache(int i5) {
            this.size = i5;
            this.map = new LinkedHashMap<K, V>(((i5 * 4) / 3) + 1, 0.75f, true) { // from class: io.michaelrocks.libphonenumber.android.internal.RegexCache.LRUCache.1
                @Override // java.util.LinkedHashMap
                protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
                    return size() > LRUCache.this.size;
                }
            };
        }
    }

    public RegexCache(int i5) {
        this.cache = new LRUCache<>(i5);
    }
}
