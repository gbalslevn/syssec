package com.google.protobuf;

import android.support.v4.media.session.a;
import com.google.protobuf.FieldSet;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class SmallSortedMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private List<SmallSortedMap<K, V>.Entry> entryList;
    private boolean isImmutable;
    private volatile SmallSortedMap<K, V>.DescendingEntrySet lazyDescendingEntrySet;
    private volatile SmallSortedMap<K, V>.EntrySet lazyEntrySet;
    private final int maxArraySize;
    private Map<K, V> overflowEntries;
    private Map<K, V> overflowEntriesDescending;

    /* loaded from: classes2.dex */
    private class DescendingEntryIterator implements Iterator<Map.Entry<K, V>> {
        private Iterator<Map.Entry<K, V>> lazyOverflowIterator;
        private int pos;

        private DescendingEntryIterator() {
            this.pos = SmallSortedMap.this.entryList.size();
        }

        private Iterator<Map.Entry<K, V>> getOverflowIterator() {
            if (this.lazyOverflowIterator == null) {
                this.lazyOverflowIterator = SmallSortedMap.this.overflowEntriesDescending.entrySet().iterator();
            }
            return this.lazyOverflowIterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i5 = this.pos;
            return (i5 > 0 && i5 <= SmallSortedMap.this.entryList.size()) || getOverflowIterator().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (getOverflowIterator().hasNext()) {
                return getOverflowIterator().next();
            }
            List list = SmallSortedMap.this.entryList;
            int i5 = this.pos - 1;
            this.pos = i5;
            return (Map.Entry) list.get(i5);
        }
    }

    /* loaded from: classes2.dex */
    private class DescendingEntrySet extends SmallSortedMap<K, V>.EntrySet {
        private DescendingEntrySet() {
            super();
        }

        @Override // com.google.protobuf.SmallSortedMap.EntrySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new DescendingEntryIterator();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class EmptySet {
        private static final Iterator<Object> ITERATOR = new Iterator<Object>() { // from class: com.google.protobuf.SmallSortedMap.EmptySet.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        private static final Iterable<Object> ITERABLE = new Iterable<Object>() { // from class: com.google.protobuf.SmallSortedMap.EmptySet.2
            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return EmptySet.ITERATOR;
            }
        };

        static <T> Iterable<T> iterable() {
            return (Iterable<T>) ITERABLE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class Entry implements Map.Entry<K, V>, Comparable<SmallSortedMap<K, V>.Entry> {
        private final K key;
        private V value;

        Entry(SmallSortedMap smallSortedMap, Map.Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return equals(this.key, entry.getKey()) && equals(this.value, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k5 = this.key;
            int hashCode = k5 == null ? 0 : k5.hashCode();
            V v5 = this.value;
            return hashCode ^ (v5 != null ? v5.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v5) {
            SmallSortedMap.this.checkMutable();
            V v6 = this.value;
            this.value = v5;
            return v6;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }

        Entry(K k5, V v5) {
            this.key = k5;
            this.value = v5;
        }

        @Override // java.lang.Comparable
        public int compareTo(SmallSortedMap<K, V>.Entry entry) {
            return getKey().compareTo(entry.getKey());
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        private boolean equals(Object obj, Object obj2) {
            if (obj == null) {
                return obj2 == null;
            }
            return obj.equals(obj2);
        }
    }

    /* loaded from: classes2.dex */
    private class EntryIterator implements Iterator<Map.Entry<K, V>> {
        private Iterator<Map.Entry<K, V>> lazyOverflowIterator;
        private boolean nextCalledBeforeRemove;
        private int pos;

        private EntryIterator() {
            this.pos = -1;
        }

        private Iterator<Map.Entry<K, V>> getOverflowIterator() {
            if (this.lazyOverflowIterator == null) {
                this.lazyOverflowIterator = SmallSortedMap.this.overflowEntries.entrySet().iterator();
            }
            return this.lazyOverflowIterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.pos + 1 >= SmallSortedMap.this.entryList.size()) {
                return !SmallSortedMap.this.overflowEntries.isEmpty() && getOverflowIterator().hasNext();
            }
            return true;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.nextCalledBeforeRemove) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.nextCalledBeforeRemove = false;
            SmallSortedMap.this.checkMutable();
            if (this.pos >= SmallSortedMap.this.entryList.size()) {
                getOverflowIterator().remove();
                return;
            }
            SmallSortedMap smallSortedMap = SmallSortedMap.this;
            int i5 = this.pos;
            this.pos = i5 - 1;
            smallSortedMap.removeArrayEntryAt(i5);
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            this.nextCalledBeforeRemove = true;
            int i5 = this.pos + 1;
            this.pos = i5;
            if (i5 < SmallSortedMap.this.entryList.size()) {
                return (Map.Entry) SmallSortedMap.this.entryList.get(this.pos);
            }
            return getOverflowIterator().next();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            SmallSortedMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = SmallSortedMap.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            SmallSortedMap.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return SmallSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            SmallSortedMap.this.put((SmallSortedMap) entry.getKey(), (K) entry.getValue());
            return true;
        }
    }

    private int binarySearchInArray(K k5) {
        int i5;
        int size = this.entryList.size();
        int i6 = size - 1;
        if (i6 >= 0) {
            int compareTo = k5.compareTo(this.entryList.get(i6).getKey());
            if (compareTo > 0) {
                i5 = size + 1;
                return -i5;
            }
            if (compareTo == 0) {
                return i6;
            }
        }
        int i7 = 0;
        while (i7 <= i6) {
            int i8 = (i7 + i6) / 2;
            int compareTo2 = k5.compareTo(this.entryList.get(i8).getKey());
            if (compareTo2 < 0) {
                i6 = i8 - 1;
            } else {
                if (compareTo2 <= 0) {
                    return i8;
                }
                i7 = i8 + 1;
            }
        }
        i5 = i7 + 1;
        return -i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkMutable() {
        if (this.isImmutable) {
            throw new UnsupportedOperationException();
        }
    }

    private void ensureEntryArrayMutable() {
        checkMutable();
        if (!this.entryList.isEmpty() || (this.entryList instanceof ArrayList)) {
            return;
        }
        this.entryList = new ArrayList(this.maxArraySize);
    }

    private SortedMap<K, V> getOverflowEntriesMutable() {
        checkMutable();
        if (this.overflowEntries.isEmpty() && !(this.overflowEntries instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.overflowEntries = treeMap;
            this.overflowEntriesDescending = treeMap.descendingMap();
        }
        return (SortedMap) this.overflowEntries;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <FieldDescriptorType extends FieldSet.FieldDescriptorLite<FieldDescriptorType>> SmallSortedMap<FieldDescriptorType, Object> newFieldMap(int i5) {
        return (SmallSortedMap<FieldDescriptorType, Object>) new SmallSortedMap<FieldDescriptorType, Object>(i5) { // from class: com.google.protobuf.SmallSortedMap.1
            @Override // com.google.protobuf.SmallSortedMap
            public void makeImmutable() {
                if (!isImmutable()) {
                    if (getNumArrayEntries() > 0) {
                        a.a(getArrayEntryAt(0).getKey());
                        throw null;
                    }
                    Iterator<Map.Entry<FieldDescriptorType, Object>> it = getOverflowEntries().iterator();
                    if (it.hasNext()) {
                        a.a(it.next().getKey());
                        throw null;
                    }
                }
                super.makeImmutable();
            }

            @Override // java.util.AbstractMap, java.util.Map
            public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
                return super.put((AnonymousClass1<FieldDescriptorType>) obj, (Comparable) obj2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V removeArrayEntryAt(int i5) {
        checkMutable();
        V value = this.entryList.remove(i5).getValue();
        if (!this.overflowEntries.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = getOverflowEntriesMutable().entrySet().iterator();
            this.entryList.add(new Entry(this, it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        checkMutable();
        if (!this.entryList.isEmpty()) {
            this.entryList.clear();
        }
        if (this.overflowEntries.isEmpty()) {
            return;
        }
        this.overflowEntries.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return binarySearchInArray(comparable) >= 0 || this.overflowEntries.containsKey(comparable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<Map.Entry<K, V>> descendingEntrySet() {
        if (this.lazyDescendingEntrySet == null) {
            this.lazyDescendingEntrySet = new DescendingEntrySet();
        }
        return this.lazyDescendingEntrySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.lazyEntrySet == null) {
            this.lazyEntrySet = new EntrySet();
        }
        return this.lazyEntrySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SmallSortedMap)) {
            return super.equals(obj);
        }
        SmallSortedMap smallSortedMap = (SmallSortedMap) obj;
        int size = size();
        if (size != smallSortedMap.size()) {
            return false;
        }
        int numArrayEntries = getNumArrayEntries();
        if (numArrayEntries != smallSortedMap.getNumArrayEntries()) {
            return entrySet().equals(smallSortedMap.entrySet());
        }
        for (int i5 = 0; i5 < numArrayEntries; i5++) {
            if (!getArrayEntryAt(i5).equals(smallSortedMap.getArrayEntryAt(i5))) {
                return false;
            }
        }
        if (numArrayEntries != size) {
            return this.overflowEntries.equals(smallSortedMap.overflowEntries);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int binarySearchInArray = binarySearchInArray(comparable);
        return binarySearchInArray >= 0 ? this.entryList.get(binarySearchInArray).getValue() : this.overflowEntries.get(comparable);
    }

    public Map.Entry<K, V> getArrayEntryAt(int i5) {
        return this.entryList.get(i5);
    }

    public int getNumArrayEntries() {
        return this.entryList.size();
    }

    public int getNumOverflowEntries() {
        return this.overflowEntries.size();
    }

    public Iterable<Map.Entry<K, V>> getOverflowEntries() {
        return this.overflowEntries.isEmpty() ? EmptySet.iterable() : this.overflowEntries.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int numArrayEntries = getNumArrayEntries();
        int i5 = 0;
        for (int i6 = 0; i6 < numArrayEntries; i6++) {
            i5 += this.entryList.get(i6).hashCode();
        }
        return getNumOverflowEntries() > 0 ? i5 + this.overflowEntries.hashCode() : i5;
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public void makeImmutable() {
        if (this.isImmutable) {
            return;
        }
        this.overflowEntries = this.overflowEntries.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.overflowEntries);
        this.overflowEntriesDescending = this.overflowEntriesDescending.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.overflowEntriesDescending);
        this.isImmutable = true;
    }

    public V put(K k5, V v5) {
        checkMutable();
        int binarySearchInArray = binarySearchInArray(k5);
        if (binarySearchInArray >= 0) {
            return this.entryList.get(binarySearchInArray).setValue(v5);
        }
        ensureEntryArrayMutable();
        int i5 = -(binarySearchInArray + 1);
        if (i5 >= this.maxArraySize) {
            return getOverflowEntriesMutable().put(k5, v5);
        }
        int size = this.entryList.size();
        int i6 = this.maxArraySize;
        if (size == i6) {
            SmallSortedMap<K, V>.Entry remove = this.entryList.remove(i6 - 1);
            getOverflowEntriesMutable().put(remove.getKey(), remove.getValue());
        }
        this.entryList.add(i5, new Entry(k5, v5));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        checkMutable();
        Comparable comparable = (Comparable) obj;
        int binarySearchInArray = binarySearchInArray(comparable);
        if (binarySearchInArray >= 0) {
            return (V) removeArrayEntryAt(binarySearchInArray);
        }
        if (this.overflowEntries.isEmpty()) {
            return null;
        }
        return this.overflowEntries.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.entryList.size() + this.overflowEntries.size();
    }

    private SmallSortedMap(int i5) {
        this.maxArraySize = i5;
        this.entryList = Collections.emptyList();
        this.overflowEntries = Collections.emptyMap();
        this.overflowEntriesDescending = Collections.emptyMap();
    }
}
