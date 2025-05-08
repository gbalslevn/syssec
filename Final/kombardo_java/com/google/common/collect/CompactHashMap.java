package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    private static final int MAX_HASH_BUCKET_LENGTH = 9;
    private static final Object NOT_FOUND = new Object();
    transient int[] entries;
    private transient Set<Map.Entry<K, V>> entrySetView;
    private transient Set<K> keySetView;
    transient Object[] keys;
    private transient int metadata;
    private transient int size;
    private transient Object table;
    transient Object[] values;
    private transient Collection<V> valuesView;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class EntrySetView extends AbstractSet<Map.Entry<K, V>> {
        EntrySetView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return delegateOrNull.entrySet().contains(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int indexOf = CompactHashMap.this.indexOf(entry.getKey());
            return indexOf != -1 && Objects.equal(CompactHashMap.this.value(indexOf), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return CompactHashMap.this.entrySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return delegateOrNull.entrySet().remove(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (CompactHashMap.this.needsAllocArrays()) {
                return false;
            }
            int hashTableMask = CompactHashMap.this.hashTableMask();
            int remove = CompactHashing.remove(entry.getKey(), entry.getValue(), hashTableMask, CompactHashMap.this.requireTable(), CompactHashMap.this.requireEntries(), CompactHashMap.this.requireKeys(), CompactHashMap.this.requireValues());
            if (remove == -1) {
                return false;
            }
            CompactHashMap.this.moveLastEntry(remove, hashTableMask);
            CompactHashMap.access$1210(CompactHashMap.this);
            CompactHashMap.this.incrementModCount();
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    /* loaded from: classes2.dex */
    private abstract class Itr<T> implements Iterator<T> {
        int currentIndex;
        int expectedMetadata;
        int indexToRemove;

        private Itr() {
            this.expectedMetadata = CompactHashMap.this.metadata;
            this.currentIndex = CompactHashMap.this.firstEntryIndex();
            this.indexToRemove = -1;
        }

        private void checkForConcurrentModification() {
            if (CompactHashMap.this.metadata != this.expectedMetadata) {
                throw new ConcurrentModificationException();
            }
        }

        abstract T getOutput(int i5);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.currentIndex >= 0;
        }

        void incrementExpectedModCount() {
            this.expectedMetadata += 32;
        }

        @Override // java.util.Iterator
        public T next() {
            checkForConcurrentModification();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i5 = this.currentIndex;
            this.indexToRemove = i5;
            T output = getOutput(i5);
            this.currentIndex = CompactHashMap.this.getSuccessor(this.currentIndex);
            return output;
        }

        @Override // java.util.Iterator
        public void remove() {
            checkForConcurrentModification();
            CollectPreconditions.checkRemove(this.indexToRemove >= 0);
            incrementExpectedModCount();
            CompactHashMap compactHashMap = CompactHashMap.this;
            compactHashMap.remove(compactHashMap.key(this.indexToRemove));
            this.currentIndex = CompactHashMap.this.adjustAfterRemove(this.currentIndex, this.indexToRemove);
            this.indexToRemove = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class KeySetView extends AbstractSet<K> {
        KeySetView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return CompactHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return CompactHashMap.this.keySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            return delegateOrNull != null ? delegateOrNull.keySet().remove(obj) : CompactHashMap.this.removeHelper(obj) != CompactHashMap.NOT_FOUND;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class MapEntry extends AbstractMapEntry<K, V> {
        private final K key;
        private int lastKnownIndex;

        MapEntry(int i5) {
            this.key = (K) CompactHashMap.this.key(i5);
            this.lastKnownIndex = i5;
        }

        private void updateLastKnownIndex() {
            int i5 = this.lastKnownIndex;
            if (i5 == -1 || i5 >= CompactHashMap.this.size() || !Objects.equal(this.key, CompactHashMap.this.key(this.lastKnownIndex))) {
                this.lastKnownIndex = CompactHashMap.this.indexOf(this.key);
            }
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V getValue() {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return (V) NullnessCasts.uncheckedCastNullableTToT(delegateOrNull.get(this.key));
            }
            updateLastKnownIndex();
            int i5 = this.lastKnownIndex;
            return i5 == -1 ? (V) NullnessCasts.unsafeNull() : (V) CompactHashMap.this.value(i5);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v5) {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return (V) NullnessCasts.uncheckedCastNullableTToT(delegateOrNull.put(this.key, v5));
            }
            updateLastKnownIndex();
            int i5 = this.lastKnownIndex;
            if (i5 == -1) {
                CompactHashMap.this.put(this.key, v5);
                return (V) NullnessCasts.unsafeNull();
            }
            V v6 = (V) CompactHashMap.this.value(i5);
            CompactHashMap.this.setValue(this.lastKnownIndex, v5);
            return v6;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class ValuesView extends AbstractCollection<V> {
        ValuesView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return CompactHashMap.this.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    CompactHashMap() {
        init(3);
    }

    static /* synthetic */ int access$1210(CompactHashMap compactHashMap) {
        int i5 = compactHashMap.size;
        compactHashMap.size = i5 - 1;
        return i5;
    }

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap<>();
    }

    private int entry(int i5) {
        return requireEntries()[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int hashTableMask() {
        return (1 << (this.metadata & 31)) - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int indexOf(Object obj) {
        if (needsAllocArrays()) {
            return -1;
        }
        int smearedHash = Hashing.smearedHash(obj);
        int hashTableMask = hashTableMask();
        int tableGet = CompactHashing.tableGet(requireTable(), smearedHash & hashTableMask);
        if (tableGet == 0) {
            return -1;
        }
        int hashPrefix = CompactHashing.getHashPrefix(smearedHash, hashTableMask);
        do {
            int i5 = tableGet - 1;
            int entry = entry(i5);
            if (CompactHashing.getHashPrefix(entry, hashTableMask) == hashPrefix && Objects.equal(obj, key(i5))) {
                return i5;
            }
            tableGet = CompactHashing.getNext(entry, hashTableMask);
        } while (tableGet != 0);
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public K key(int i5) {
        return (K) requireKeys()[i5];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt < 0) {
            StringBuilder sb = new StringBuilder(25);
            sb.append("Invalid size: ");
            sb.append(readInt);
            throw new InvalidObjectException(sb.toString());
        }
        init(readInt);
        for (int i5 = 0; i5 < readInt; i5++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object removeHelper(Object obj) {
        if (needsAllocArrays()) {
            return NOT_FOUND;
        }
        int hashTableMask = hashTableMask();
        int remove = CompactHashing.remove(obj, null, hashTableMask, requireTable(), requireEntries(), requireKeys(), null);
        if (remove == -1) {
            return NOT_FOUND;
        }
        V value = value(remove);
        moveLastEntry(remove, hashTableMask);
        this.size--;
        incrementModCount();
        return value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] requireEntries() {
        int[] iArr = this.entries;
        java.util.Objects.requireNonNull(iArr);
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] requireKeys() {
        Object[] objArr = this.keys;
        java.util.Objects.requireNonNull(objArr);
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object requireTable() {
        Object obj = this.table;
        java.util.Objects.requireNonNull(obj);
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] requireValues() {
        Object[] objArr = this.values;
        java.util.Objects.requireNonNull(objArr);
        return objArr;
    }

    private void resizeMeMaybe(int i5) {
        int min;
        int length = requireEntries().length;
        if (i5 <= length || (min = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        resizeEntries(min);
    }

    private int resizeTable(int i5, int i6, int i7, int i8) {
        Object createTable = CompactHashing.createTable(i6);
        int i9 = i6 - 1;
        if (i8 != 0) {
            CompactHashing.tableSet(createTable, i7 & i9, i8 + 1);
        }
        Object requireTable = requireTable();
        int[] requireEntries = requireEntries();
        for (int i10 = 0; i10 <= i5; i10++) {
            int tableGet = CompactHashing.tableGet(requireTable, i10);
            while (tableGet != 0) {
                int i11 = tableGet - 1;
                int i12 = requireEntries[i11];
                int hashPrefix = CompactHashing.getHashPrefix(i12, i5) | i10;
                int i13 = hashPrefix & i9;
                int tableGet2 = CompactHashing.tableGet(createTable, i13);
                CompactHashing.tableSet(createTable, i13, tableGet);
                requireEntries[i11] = CompactHashing.maskCombine(hashPrefix, tableGet2, i9);
                tableGet = CompactHashing.getNext(i12, i5);
            }
        }
        this.table = createTable;
        setHashTableMask(i9);
        return i9;
    }

    private void setEntry(int i5, int i6) {
        requireEntries()[i5] = i6;
    }

    private void setHashTableMask(int i5) {
        this.metadata = CompactHashing.maskCombine(this.metadata, 32 - Integer.numberOfLeadingZeros(i5), 31);
    }

    private void setKey(int i5, K k5) {
        requireKeys()[i5] = k5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(int i5, V v5) {
        requireValues()[i5] = v5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V value(int i5) {
        return (V) requireValues()[i5];
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<Map.Entry<K, V>> entrySetIterator = entrySetIterator();
        while (entrySetIterator.hasNext()) {
            Map.Entry<K, V> next = entrySetIterator.next();
            objectOutputStream.writeObject(next.getKey());
            objectOutputStream.writeObject(next.getValue());
        }
    }

    void accessEntry(int i5) {
    }

    int adjustAfterRemove(int i5, int i6) {
        return i5 - 1;
    }

    int allocArrays() {
        Preconditions.checkState(needsAllocArrays(), "Arrays already allocated");
        int i5 = this.metadata;
        int tableSize = CompactHashing.tableSize(i5);
        this.table = CompactHashing.createTable(tableSize);
        setHashTableMask(tableSize - 1);
        this.entries = new int[i5];
        this.keys = new Object[i5];
        this.values = new Object[i5];
        return i5;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        incrementModCount();
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            this.metadata = Ints.constrainToRange(size(), 3, 1073741823);
            delegateOrNull.clear();
            this.table = null;
            this.size = 0;
            return;
        }
        Arrays.fill(requireKeys(), 0, this.size, (Object) null);
        Arrays.fill(requireValues(), 0, this.size, (Object) null);
        CompactHashing.tableClear(requireTable());
        Arrays.fill(requireEntries(), 0, this.size, 0);
        this.size = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Map<K, V> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.containsKey(obj) : indexOf(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.containsValue(obj);
        }
        for (int i5 = 0; i5 < this.size; i5++) {
            if (Objects.equal(obj, value(i5))) {
                return true;
            }
        }
        return false;
    }

    Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> createHashFloodingResistantDelegate = createHashFloodingResistantDelegate(hashTableMask() + 1);
        int firstEntryIndex = firstEntryIndex();
        while (firstEntryIndex >= 0) {
            createHashFloodingResistantDelegate.put(key(firstEntryIndex), value(firstEntryIndex));
            firstEntryIndex = getSuccessor(firstEntryIndex);
        }
        this.table = createHashFloodingResistantDelegate;
        this.entries = null;
        this.keys = null;
        this.values = null;
        incrementModCount();
        return createHashFloodingResistantDelegate;
    }

    Set<Map.Entry<K, V>> createEntrySet() {
        return new EntrySetView();
    }

    Map<K, V> createHashFloodingResistantDelegate(int i5) {
        return new LinkedHashMap(i5, 1.0f);
    }

    Set<K> createKeySet() {
        return new KeySetView();
    }

    Collection<V> createValues() {
        return new ValuesView();
    }

    Map<K, V> delegateOrNull() {
        Object obj = this.table;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySetView;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> createEntrySet = createEntrySet();
        this.entrySetView = createEntrySet;
        return createEntrySet;
    }

    Iterator<Map.Entry<K, V>> entrySetIterator() {
        Map<K, V> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.entrySet().iterator() : new CompactHashMap<K, V>.Itr<Map.Entry<K, V>>() { // from class: com.google.common.collect.CompactHashMap.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.CompactHashMap.Itr
            public Map.Entry<K, V> getOutput(int i5) {
                return new MapEntry(i5);
            }
        };
    }

    int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.get(obj);
        }
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return null;
        }
        accessEntry(indexOf);
        return value(indexOf);
    }

    int getSuccessor(int i5) {
        int i6 = i5 + 1;
        if (i6 < this.size) {
            return i6;
        }
        return -1;
    }

    void incrementModCount() {
        this.metadata += 32;
    }

    void init(int i5) {
        Preconditions.checkArgument(i5 >= 0, "Expected size must be >= 0");
        this.metadata = Ints.constrainToRange(i5, 1, 1073741823);
    }

    void insertEntry(int i5, K k5, V v5, int i6, int i7) {
        setEntry(i5, CompactHashing.maskCombine(i6, 0, i7));
        setKey(i5, k5);
        setValue(i5, v5);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySetView;
        if (set != null) {
            return set;
        }
        Set<K> createKeySet = createKeySet();
        this.keySetView = createKeySet;
        return createKeySet;
    }

    Iterator<K> keySetIterator() {
        Map<K, V> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.keySet().iterator() : new CompactHashMap<K, V>.Itr<K>() { // from class: com.google.common.collect.CompactHashMap.1
            @Override // com.google.common.collect.CompactHashMap.Itr
            K getOutput(int i5) {
                return (K) CompactHashMap.this.key(i5);
            }
        };
    }

    void moveLastEntry(int i5, int i6) {
        Object requireTable = requireTable();
        int[] requireEntries = requireEntries();
        Object[] requireKeys = requireKeys();
        Object[] requireValues = requireValues();
        int size = size();
        int i7 = size - 1;
        if (i5 >= i7) {
            requireKeys[i5] = null;
            requireValues[i5] = null;
            requireEntries[i5] = 0;
            return;
        }
        Object obj = requireKeys[i7];
        requireKeys[i5] = obj;
        requireValues[i5] = requireValues[i7];
        requireKeys[i7] = null;
        requireValues[i7] = null;
        requireEntries[i5] = requireEntries[i7];
        requireEntries[i7] = 0;
        int smearedHash = Hashing.smearedHash(obj) & i6;
        int tableGet = CompactHashing.tableGet(requireTable, smearedHash);
        if (tableGet == size) {
            CompactHashing.tableSet(requireTable, smearedHash, i5 + 1);
            return;
        }
        while (true) {
            int i8 = tableGet - 1;
            int i9 = requireEntries[i8];
            int next = CompactHashing.getNext(i9, i6);
            if (next == size) {
                requireEntries[i8] = CompactHashing.maskCombine(i9, i5 + 1, i6);
                return;
            }
            tableGet = next;
        }
    }

    boolean needsAllocArrays() {
        return this.table == null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k5, V v5) {
        int resizeTable;
        int i5;
        if (needsAllocArrays()) {
            allocArrays();
        }
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.put(k5, v5);
        }
        int[] requireEntries = requireEntries();
        Object[] requireKeys = requireKeys();
        Object[] requireValues = requireValues();
        int i6 = this.size;
        int i7 = i6 + 1;
        int smearedHash = Hashing.smearedHash(k5);
        int hashTableMask = hashTableMask();
        int i8 = smearedHash & hashTableMask;
        int tableGet = CompactHashing.tableGet(requireTable(), i8);
        if (tableGet != 0) {
            int hashPrefix = CompactHashing.getHashPrefix(smearedHash, hashTableMask);
            int i9 = 0;
            while (true) {
                int i10 = tableGet - 1;
                int i11 = requireEntries[i10];
                if (CompactHashing.getHashPrefix(i11, hashTableMask) == hashPrefix && Objects.equal(k5, requireKeys[i10])) {
                    V v6 = (V) requireValues[i10];
                    requireValues[i10] = v5;
                    accessEntry(i10);
                    return v6;
                }
                int next = CompactHashing.getNext(i11, hashTableMask);
                i9++;
                if (next != 0) {
                    tableGet = next;
                } else {
                    if (i9 >= 9) {
                        return convertToHashFloodingResistantImplementation().put(k5, v5);
                    }
                    if (i7 > hashTableMask) {
                        resizeTable = resizeTable(hashTableMask, CompactHashing.newCapacity(hashTableMask), smearedHash, i6);
                    } else {
                        requireEntries[i10] = CompactHashing.maskCombine(i11, i7, hashTableMask);
                    }
                }
            }
        } else if (i7 > hashTableMask) {
            resizeTable = resizeTable(hashTableMask, CompactHashing.newCapacity(hashTableMask), smearedHash, i6);
            i5 = resizeTable;
        } else {
            CompactHashing.tableSet(requireTable(), i8, i7);
            i5 = hashTableMask;
        }
        resizeMeMaybe(i7);
        insertEntry(i6, k5, v5, smearedHash, i5);
        this.size = i7;
        incrementModCount();
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.remove(obj);
        }
        V v5 = (V) removeHelper(obj);
        if (v5 == NOT_FOUND) {
            return null;
        }
        return v5;
    }

    void resizeEntries(int i5) {
        this.entries = Arrays.copyOf(requireEntries(), i5);
        this.keys = Arrays.copyOf(requireKeys(), i5);
        this.values = Arrays.copyOf(requireValues(), i5);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map<K, V> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.size() : this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.valuesView;
        if (collection != null) {
            return collection;
        }
        Collection<V> createValues = createValues();
        this.valuesView = createValues;
        return createValues;
    }

    Iterator<V> valuesIterator() {
        Map<K, V> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.values().iterator() : new CompactHashMap<K, V>.Itr<V>() { // from class: com.google.common.collect.CompactHashMap.3
            @Override // com.google.common.collect.CompactHashMap.Itr
            V getOutput(int i5) {
                return (V) CompactHashMap.this.value(i5);
            }
        };
    }
}
