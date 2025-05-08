package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
class LazyField$LazyIterator<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> iterator;

    public LazyField$LazyIterator(Iterator<Map.Entry<K, Object>> it) {
        this.iterator = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.iterator.remove();
    }

    @Override // java.util.Iterator
    public Map.Entry<K, Object> next() {
        Map.Entry<K, Object> next = this.iterator.next();
        next.getValue();
        return next;
    }
}
