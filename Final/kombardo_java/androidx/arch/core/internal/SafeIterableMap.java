package androidx.arch.core.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SafeIterableMap<K, V> implements Iterable<Map.Entry<K, V>> {
    private Entry<K, V> mEnd;
    private final WeakHashMap<SupportRemove<K, V>, Boolean> mIterators = new WeakHashMap<>();
    private int mSize = 0;
    Entry<K, V> mStart;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AscendingIterator<K, V> extends ListIterator<K, V> {
        AscendingIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            super(entry, entry2);
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        Entry<K, V> backward(Entry<K, V> entry) {
            return entry.mPrevious;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        Entry<K, V> forward(Entry<K, V> entry) {
            return entry.mNext;
        }
    }

    /* loaded from: classes.dex */
    private static class DescendingIterator<K, V> extends ListIterator<K, V> {
        DescendingIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            super(entry, entry2);
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        Entry<K, V> backward(Entry<K, V> entry) {
            return entry.mNext;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        Entry<K, V> forward(Entry<K, V> entry) {
            return entry.mPrevious;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Entry<K, V> implements Map.Entry<K, V> {
        final K mKey;
        Entry<K, V> mNext;
        Entry<K, V> mPrevious;
        final V mValue;

        Entry(K k5, V v5) {
            this.mKey = k5;
            this.mValue = v5;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.mKey.equals(entry.mKey) && this.mValue.equals(entry.mValue);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.mKey;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.mValue;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.mKey.hashCode() ^ this.mValue.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v5) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.mKey + "=" + this.mValue;
        }
    }

    /* loaded from: classes.dex */
    public class IteratorWithAdditions extends SupportRemove<K, V> implements Iterator<Map.Entry<K, V>> {
        private boolean mBeforeStart = true;
        private Entry<K, V> mCurrent;

        IteratorWithAdditions() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.mBeforeStart) {
                return SafeIterableMap.this.mStart != null;
            }
            Entry<K, V> entry = this.mCurrent;
            return (entry == null || entry.mNext == null) ? false : true;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        void supportRemove(Entry<K, V> entry) {
            Entry<K, V> entry2 = this.mCurrent;
            if (entry == entry2) {
                Entry<K, V> entry3 = entry2.mPrevious;
                this.mCurrent = entry3;
                this.mBeforeStart = entry3 == null;
            }
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (this.mBeforeStart) {
                this.mBeforeStart = false;
                this.mCurrent = SafeIterableMap.this.mStart;
            } else {
                Entry<K, V> entry = this.mCurrent;
                this.mCurrent = entry != null ? entry.mNext : null;
            }
            return this.mCurrent;
        }
    }

    /* loaded from: classes.dex */
    private static abstract class ListIterator<K, V> extends SupportRemove<K, V> implements Iterator<Map.Entry<K, V>> {
        Entry<K, V> mExpectedEnd;
        Entry<K, V> mNext;

        ListIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            this.mExpectedEnd = entry2;
            this.mNext = entry;
        }

        private Entry<K, V> nextNode() {
            Entry<K, V> entry = this.mNext;
            Entry<K, V> entry2 = this.mExpectedEnd;
            if (entry == entry2 || entry2 == null) {
                return null;
            }
            return forward(entry);
        }

        abstract Entry<K, V> backward(Entry<K, V> entry);

        abstract Entry<K, V> forward(Entry<K, V> entry);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.mNext != null;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        public void supportRemove(Entry<K, V> entry) {
            if (this.mExpectedEnd == entry && entry == this.mNext) {
                this.mNext = null;
                this.mExpectedEnd = null;
            }
            Entry<K, V> entry2 = this.mExpectedEnd;
            if (entry2 == entry) {
                this.mExpectedEnd = backward(entry2);
            }
            if (this.mNext == entry) {
                this.mNext = nextNode();
            }
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            Entry<K, V> entry = this.mNext;
            this.mNext = nextNode();
            return entry;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class SupportRemove<K, V> {
        abstract void supportRemove(Entry<K, V> entry);
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        DescendingIterator descendingIterator = new DescendingIterator(this.mEnd, this.mStart);
        this.mIterators.put(descendingIterator, Boolean.FALSE);
        return descendingIterator;
    }

    public Map.Entry<K, V> eldest() {
        return this.mStart;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SafeIterableMap)) {
            return false;
        }
        SafeIterableMap safeIterableMap = (SafeIterableMap) obj;
        if (size() != safeIterableMap.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = safeIterableMap.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    protected Entry<K, V> get(K k5) {
        Entry<K, V> entry = this.mStart;
        while (entry != null && !entry.mKey.equals(k5)) {
            entry = entry.mNext;
        }
        return entry;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i5 = 0;
        while (it.hasNext()) {
            i5 += it.next().hashCode();
        }
        return i5;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        AscendingIterator ascendingIterator = new AscendingIterator(this.mStart, this.mEnd);
        this.mIterators.put(ascendingIterator, Boolean.FALSE);
        return ascendingIterator;
    }

    public SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions() {
        SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions = new IteratorWithAdditions();
        this.mIterators.put(iteratorWithAdditions, Boolean.FALSE);
        return iteratorWithAdditions;
    }

    public Map.Entry<K, V> newest() {
        return this.mEnd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Entry<K, V> put(K k5, V v5) {
        Entry<K, V> entry = new Entry<>(k5, v5);
        this.mSize++;
        Entry<K, V> entry2 = this.mEnd;
        if (entry2 == null) {
            this.mStart = entry;
            this.mEnd = entry;
            return entry;
        }
        entry2.mNext = entry;
        entry.mPrevious = entry2;
        this.mEnd = entry;
        return entry;
    }

    public V putIfAbsent(K k5, V v5) {
        Entry<K, V> entry = get(k5);
        if (entry != null) {
            return entry.mValue;
        }
        put(k5, v5);
        return null;
    }

    public V remove(K k5) {
        Entry<K, V> entry = get(k5);
        if (entry == null) {
            return null;
        }
        this.mSize--;
        if (!this.mIterators.isEmpty()) {
            Iterator<SupportRemove<K, V>> it = this.mIterators.keySet().iterator();
            while (it.hasNext()) {
                it.next().supportRemove(entry);
            }
        }
        Entry<K, V> entry2 = entry.mPrevious;
        if (entry2 != null) {
            entry2.mNext = entry.mNext;
        } else {
            this.mStart = entry.mNext;
        }
        Entry<K, V> entry3 = entry.mNext;
        if (entry3 != null) {
            entry3.mPrevious = entry2;
        } else {
            this.mEnd = entry2;
        }
        entry.mNext = null;
        entry.mPrevious = null;
        return entry.mValue;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
