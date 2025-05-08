package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes2.dex */
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {
    static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Map.Entry[0];
    private transient ImmutableSet<Map.Entry<K, V>> entrySet;
    private transient ImmutableSet<K> keySet;
    private transient ImmutableSetMultimap<K, V> multimapView;
    private transient ImmutableCollection<V> values;

    /* loaded from: classes2.dex */
    public static class Builder<K, V> {
        Object[] alternatingKeysAndValues;
        DuplicateKey duplicateKey;
        boolean entriesUsed;
        int size;
        Comparator<? super V> valueComparator;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public static final class DuplicateKey {
            private final Object key;
            private final Object value1;
            private final Object value2;

            /* JADX INFO: Access modifiers changed from: package-private */
            public DuplicateKey(Object obj, Object obj2, Object obj3) {
                this.key = obj;
                this.value1 = obj2;
                this.value2 = obj3;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public IllegalArgumentException exception() {
                String valueOf = String.valueOf(this.key);
                String valueOf2 = String.valueOf(this.value1);
                String valueOf3 = String.valueOf(this.key);
                String valueOf4 = String.valueOf(this.value2);
                StringBuilder sb = new StringBuilder(valueOf.length() + 39 + valueOf2.length() + valueOf3.length() + valueOf4.length());
                sb.append("Multiple entries with same key: ");
                sb.append(valueOf);
                sb.append("=");
                sb.append(valueOf2);
                sb.append(" and ");
                sb.append(valueOf3);
                sb.append("=");
                sb.append(valueOf4);
                return new IllegalArgumentException(sb.toString());
            }
        }

        public Builder() {
            this(4);
        }

        private ImmutableMap<K, V> build(boolean z5) {
            Object[] objArr;
            DuplicateKey duplicateKey;
            DuplicateKey duplicateKey2;
            if (z5 && (duplicateKey2 = this.duplicateKey) != null) {
                throw duplicateKey2.exception();
            }
            int i5 = this.size;
            if (this.valueComparator == null) {
                objArr = this.alternatingKeysAndValues;
            } else {
                if (this.entriesUsed) {
                    this.alternatingKeysAndValues = Arrays.copyOf(this.alternatingKeysAndValues, i5 * 2);
                }
                objArr = this.alternatingKeysAndValues;
                if (!z5) {
                    objArr = lastEntryForEachKey(objArr, this.size);
                    if (objArr.length < this.alternatingKeysAndValues.length) {
                        i5 = objArr.length >>> 1;
                    }
                }
                sortEntries(objArr, i5, this.valueComparator);
            }
            this.entriesUsed = true;
            RegularImmutableMap create = RegularImmutableMap.create(i5, objArr, this);
            if (!z5 || (duplicateKey = this.duplicateKey) == null) {
                return create;
            }
            throw duplicateKey.exception();
        }

        private void ensureCapacity(int i5) {
            int i6 = i5 * 2;
            Object[] objArr = this.alternatingKeysAndValues;
            if (i6 > objArr.length) {
                this.alternatingKeysAndValues = Arrays.copyOf(objArr, ImmutableCollection.Builder.expandedCapacity(objArr.length, i6));
                this.entriesUsed = false;
            }
        }

        private Object[] lastEntryForEachKey(Object[] objArr, int i5) {
            HashSet hashSet = new HashSet();
            BitSet bitSet = new BitSet();
            for (int i6 = i5 - 1; i6 >= 0; i6--) {
                Object obj = objArr[i6 * 2];
                Objects.requireNonNull(obj);
                if (!hashSet.add(obj)) {
                    bitSet.set(i6);
                }
            }
            if (bitSet.isEmpty()) {
                return objArr;
            }
            Object[] objArr2 = new Object[(i5 - bitSet.cardinality()) * 2];
            int i7 = 0;
            int i8 = 0;
            while (i7 < i5 * 2) {
                if (bitSet.get(i7 >>> 1)) {
                    i7 += 2;
                } else {
                    int i9 = i8 + 1;
                    int i10 = i7 + 1;
                    Object obj2 = objArr[i7];
                    Objects.requireNonNull(obj2);
                    objArr2[i8] = obj2;
                    i8 += 2;
                    i7 += 2;
                    Object obj3 = objArr[i10];
                    Objects.requireNonNull(obj3);
                    objArr2[i9] = obj3;
                }
            }
            return objArr2;
        }

        static <V> void sortEntries(Object[] objArr, int i5, Comparator<? super V> comparator) {
            Map.Entry[] entryArr = new Map.Entry[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = i6 * 2;
                Object obj = objArr[i7];
                Objects.requireNonNull(obj);
                Object obj2 = objArr[i7 + 1];
                Objects.requireNonNull(obj2);
                entryArr[i6] = new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
            Arrays.sort(entryArr, 0, i5, Ordering.from(comparator).onResultOf(Maps.valueFunction()));
            for (int i8 = 0; i8 < i5; i8++) {
                int i9 = i8 * 2;
                objArr[i9] = entryArr[i8].getKey();
                objArr[i9 + 1] = entryArr[i8].getValue();
            }
        }

        public ImmutableMap<K, V> buildOrThrow() {
            return build(true);
        }

        public Builder<K, V> put(K k5, V v5) {
            ensureCapacity(this.size + 1);
            CollectPreconditions.checkEntryNotNull(k5, v5);
            Object[] objArr = this.alternatingKeysAndValues;
            int i5 = this.size;
            objArr[i5 * 2] = k5;
            objArr[(i5 * 2) + 1] = v5;
            this.size = i5 + 1;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(int i5) {
            this.alternatingKeysAndValues = new Object[i5 * 2];
            this.size = 0;
            this.entriesUsed = false;
        }

        public ImmutableMap<K, V> build() {
            return buildOrThrow();
        }
    }

    /* loaded from: classes2.dex */
    static class SerializedForm<K, V> implements Serializable {
        private static final boolean USE_LEGACY_SERIALIZATION = true;
        private static final long serialVersionUID = 0;
        private final Object keys;
        private final Object values;

        SerializedForm(ImmutableMap<K, V> immutableMap) {
            Object[] objArr = new Object[immutableMap.size()];
            Object[] objArr2 = new Object[immutableMap.size()];
            UnmodifiableIterator<Map.Entry<K, V>> it = immutableMap.entrySet().iterator();
            int i5 = 0;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                objArr[i5] = next.getKey();
                objArr2[i5] = next.getValue();
                i5++;
            }
            this.keys = objArr;
            this.values = objArr2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        final Object legacyReadResolve() {
            Object[] objArr = (Object[]) this.keys;
            Object[] objArr2 = (Object[]) this.values;
            Builder<K, V> makeBuilder = makeBuilder(objArr.length);
            for (int i5 = 0; i5 < objArr.length; i5++) {
                makeBuilder.put(objArr[i5], objArr2[i5]);
            }
            return makeBuilder.buildOrThrow();
        }

        Builder<K, V> makeBuilder(int i5) {
            return new Builder<>(i5);
        }

        final Object readResolve() {
            Object obj = this.keys;
            if (!(obj instanceof ImmutableSet)) {
                return legacyReadResolve();
            }
            ImmutableSet immutableSet = (ImmutableSet) obj;
            ImmutableCollection immutableCollection = (ImmutableCollection) this.values;
            Builder builder = (Builder<K, V>) makeBuilder(immutableSet.size());
            UnmodifiableIterator it = immutableSet.iterator();
            UnmodifiableIterator it2 = immutableCollection.iterator();
            while (it.hasNext()) {
                builder.put(it.next(), it2.next());
            }
            return builder.buildOrThrow();
        }
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static <K, V> Builder<K, V> builderWithExpectedSize(int i5) {
        CollectPreconditions.checkNonnegative(i5, "expectedSize");
        return new Builder<>(i5);
    }

    public static <K, V> ImmutableMap<K, V> of() {
        return (ImmutableMap<K, V>) RegularImmutableMap.EMPTY;
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    abstract ImmutableSet<Map.Entry<K, V>> createEntrySet();

    abstract ImmutableSet<K> createKeySet();

    abstract ImmutableCollection<V> createValues();

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return Maps.equalsImpl(this, obj);
    }

    @Override // java.util.Map
    public abstract V get(Object obj);

    @Override // java.util.Map
    public final V getOrDefault(Object obj, V v5) {
        V v6 = get(obj);
        return v6 != null ? v6 : v5;
    }

    @Override // java.util.Map
    public int hashCode() {
        return Sets.hashCodeImpl(entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K k5, V v5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return Maps.toStringImpl(this);
    }

    Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <K, V> ImmutableMap<K, V> of(K k5, V v5) {
        CollectPreconditions.checkEntryNotNull(k5, v5);
        return RegularImmutableMap.create(1, new Object[]{k5, v5});
    }

    @Override // java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<Map.Entry<K, V>> createEntrySet = createEntrySet();
        this.entrySet = createEntrySet;
        return createEntrySet;
    }

    @Override // java.util.Map
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> immutableSet = this.keySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<K> createKeySet = createKeySet();
        this.keySet = createKeySet;
        return createKeySet;
    }

    @Override // java.util.Map
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.values;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        ImmutableCollection<V> createValues = createValues();
        this.values = createValues;
        return createValues;
    }
}
