package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    private static final byte ABSENT = -1;
    private static final int BYTE_MASK = 255;
    private static final int BYTE_MAX_SIZE = 128;
    static final ImmutableMap<Object, Object> EMPTY = new RegularImmutableMap(null, new Object[0], 0);
    private static final int SHORT_MASK = 65535;
    private static final int SHORT_MAX_SIZE = 32768;
    private static final long serialVersionUID = 0;
    final transient Object[] alternatingKeysAndValues;
    private final transient Object hashTable;
    private final transient int size;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
        private final transient Object[] alternatingKeysAndValues;
        private final transient int keyOffset;
        private final transient ImmutableMap<K, V> map;
        private final transient int size;

        EntrySet(ImmutableMap<K, V> immutableMap, Object[] objArr, int i5, int i6) {
            this.map = immutableMap;
            this.alternatingKeysAndValues = objArr;
            this.keyOffset = i5;
            this.size = i6;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.map.get(key));
        }

        @Override // com.google.common.collect.ImmutableCollection
        int copyIntoArray(Object[] objArr, int i5) {
            return asList().copyIntoArray(objArr, i5);
        }

        @Override // com.google.common.collect.ImmutableSet
        ImmutableList<Map.Entry<K, V>> createAsList() {
            return new ImmutableList<Map.Entry<K, V>>() { // from class: com.google.common.collect.RegularImmutableMap.EntrySet.1
                @Override // com.google.common.collect.ImmutableCollection
                public boolean isPartialView() {
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return EntrySet.this.size;
                }

                @Override // java.util.List
                public Map.Entry<K, V> get(int i5) {
                    Preconditions.checkElementIndex(i5, EntrySet.this.size);
                    int i6 = i5 * 2;
                    Object obj = EntrySet.this.alternatingKeysAndValues[EntrySet.this.keyOffset + i6];
                    Objects.requireNonNull(obj);
                    Object obj2 = EntrySet.this.alternatingKeysAndValues[i6 + (EntrySet.this.keyOffset ^ 1)];
                    Objects.requireNonNull(obj2);
                    return new AbstractMap.SimpleImmutableEntry(obj, obj2);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }
    }

    /* loaded from: classes2.dex */
    static final class KeySet<K> extends ImmutableSet<K> {
        private final transient ImmutableList<K> list;
        private final transient ImmutableMap<K, ?> map;

        KeySet(ImmutableMap<K, ?> immutableMap, ImmutableList<K> immutableList) {
            this.map = immutableMap;
            this.list = immutableList;
        }

        @Override // com.google.common.collect.ImmutableSet
        public ImmutableList<K> asList() {
            return this.list;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.map.get(obj) != null;
        }

        @Override // com.google.common.collect.ImmutableCollection
        int copyIntoArray(Object[] objArr, int i5) {
            return asList().copyIntoArray(objArr, i5);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public UnmodifiableIterator<K> iterator() {
            return asList().iterator();
        }
    }

    /* loaded from: classes2.dex */
    static final class KeysOrValuesAsList extends ImmutableList<Object> {
        private final transient Object[] alternatingKeysAndValues;
        private final transient int offset;
        private final transient int size;

        KeysOrValuesAsList(Object[] objArr, int i5, int i6) {
            this.alternatingKeysAndValues = objArr;
            this.offset = i5;
            this.size = i6;
        }

        @Override // java.util.List
        public Object get(int i5) {
            Preconditions.checkElementIndex(i5, this.size);
            Object obj = this.alternatingKeysAndValues[(i5 * 2) + this.offset];
            Objects.requireNonNull(obj);
            return obj;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.size;
        }
    }

    private RegularImmutableMap(Object obj, Object[] objArr, int i5) {
        this.hashTable = obj;
        this.alternatingKeysAndValues = objArr;
        this.size = i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> RegularImmutableMap<K, V> create(int i5, Object[] objArr) {
        return create(i5, objArr, null);
    }

    private static Object createHashTable(Object[] objArr, int i5, int i6, int i7) {
        ImmutableMap.Builder.DuplicateKey duplicateKey = null;
        if (i5 == 1) {
            Object obj = objArr[i7];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[i7 ^ 1];
            Objects.requireNonNull(obj2);
            CollectPreconditions.checkEntryNotNull(obj, obj2);
            return null;
        }
        int i8 = i6 - 1;
        int i9 = -1;
        if (i6 <= 128) {
            byte[] bArr = new byte[i6];
            Arrays.fill(bArr, ABSENT);
            int i10 = 0;
            for (int i11 = 0; i11 < i5; i11++) {
                int i12 = (i11 * 2) + i7;
                int i13 = (i10 * 2) + i7;
                Object obj3 = objArr[i12];
                Objects.requireNonNull(obj3);
                Object obj4 = objArr[i12 ^ 1];
                Objects.requireNonNull(obj4);
                CollectPreconditions.checkEntryNotNull(obj3, obj4);
                int smear = Hashing.smear(obj3.hashCode());
                while (true) {
                    int i14 = smear & i8;
                    int i15 = bArr[i14] & ABSENT;
                    if (i15 == 255) {
                        bArr[i14] = (byte) i13;
                        if (i10 < i11) {
                            objArr[i13] = obj3;
                            objArr[i13 ^ 1] = obj4;
                        }
                        i10++;
                    } else {
                        if (obj3.equals(objArr[i15])) {
                            int i16 = i15 ^ 1;
                            Object obj5 = objArr[i16];
                            Objects.requireNonNull(obj5);
                            duplicateKey = new ImmutableMap.Builder.DuplicateKey(obj3, obj4, obj5);
                            objArr[i16] = obj4;
                            break;
                        }
                        smear = i14 + 1;
                    }
                }
            }
            return i10 == i5 ? bArr : new Object[]{bArr, Integer.valueOf(i10), duplicateKey};
        }
        if (i6 <= SHORT_MAX_SIZE) {
            short[] sArr = new short[i6];
            Arrays.fill(sArr, (short) -1);
            int i17 = 0;
            for (int i18 = 0; i18 < i5; i18++) {
                int i19 = (i18 * 2) + i7;
                int i20 = (i17 * 2) + i7;
                Object obj6 = objArr[i19];
                Objects.requireNonNull(obj6);
                Object obj7 = objArr[i19 ^ 1];
                Objects.requireNonNull(obj7);
                CollectPreconditions.checkEntryNotNull(obj6, obj7);
                int smear2 = Hashing.smear(obj6.hashCode());
                while (true) {
                    int i21 = smear2 & i8;
                    int i22 = sArr[i21] & SHORT_MASK;
                    if (i22 == SHORT_MASK) {
                        sArr[i21] = (short) i20;
                        if (i17 < i18) {
                            objArr[i20] = obj6;
                            objArr[i20 ^ 1] = obj7;
                        }
                        i17++;
                    } else {
                        if (obj6.equals(objArr[i22])) {
                            int i23 = i22 ^ 1;
                            Object obj8 = objArr[i23];
                            Objects.requireNonNull(obj8);
                            duplicateKey = new ImmutableMap.Builder.DuplicateKey(obj6, obj7, obj8);
                            objArr[i23] = obj7;
                            break;
                        }
                        smear2 = i21 + 1;
                    }
                }
            }
            return i17 == i5 ? sArr : new Object[]{sArr, Integer.valueOf(i17), duplicateKey};
        }
        int[] iArr = new int[i6];
        Arrays.fill(iArr, -1);
        int i24 = 0;
        int i25 = 0;
        while (i24 < i5) {
            int i26 = (i24 * 2) + i7;
            int i27 = (i25 * 2) + i7;
            Object obj9 = objArr[i26];
            Objects.requireNonNull(obj9);
            Object obj10 = objArr[i26 ^ 1];
            Objects.requireNonNull(obj10);
            CollectPreconditions.checkEntryNotNull(obj9, obj10);
            int smear3 = Hashing.smear(obj9.hashCode());
            while (true) {
                int i28 = smear3 & i8;
                int i29 = iArr[i28];
                if (i29 == i9) {
                    iArr[i28] = i27;
                    if (i25 < i24) {
                        objArr[i27] = obj9;
                        objArr[i27 ^ 1] = obj10;
                    }
                    i25++;
                } else {
                    if (obj9.equals(objArr[i29])) {
                        int i30 = i29 ^ 1;
                        Object obj11 = objArr[i30];
                        Objects.requireNonNull(obj11);
                        duplicateKey = new ImmutableMap.Builder.DuplicateKey(obj9, obj10, obj11);
                        objArr[i30] = obj10;
                        break;
                    }
                    smear3 = i28 + 1;
                    i9 = -1;
                }
            }
            i24++;
            i9 = -1;
        }
        return i25 == i5 ? iArr : new Object[]{iArr, Integer.valueOf(i25), duplicateKey};
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new EntrySet(this, this.alternatingKeysAndValues, 0, this.size);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        return new KeySet(this, new KeysOrValuesAsList(this.alternatingKeysAndValues, 0, this.size));
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableCollection<V> createValues() {
        return new KeysOrValuesAsList(this.alternatingKeysAndValues, 1, this.size);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        V v5 = (V) get(this.hashTable, this.alternatingKeysAndValues, this.size, 0, obj);
        if (v5 == null) {
            return null;
        }
        return v5;
    }

    @Override // java.util.Map
    public int size() {
        return this.size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> RegularImmutableMap<K, V> create(int i5, Object[] objArr, ImmutableMap.Builder<K, V> builder) {
        if (i5 == 0) {
            return (RegularImmutableMap) EMPTY;
        }
        if (i5 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[1];
            Objects.requireNonNull(obj2);
            CollectPreconditions.checkEntryNotNull(obj, obj2);
            return new RegularImmutableMap<>(null, objArr, 1);
        }
        Preconditions.checkPositionIndex(i5, objArr.length >> 1);
        Object createHashTable = createHashTable(objArr, i5, ImmutableSet.chooseTableSize(i5), 0);
        if (createHashTable instanceof Object[]) {
            Object[] objArr2 = (Object[]) createHashTable;
            ImmutableMap.Builder.DuplicateKey duplicateKey = (ImmutableMap.Builder.DuplicateKey) objArr2[2];
            if (builder != null) {
                builder.duplicateKey = duplicateKey;
                Object obj3 = objArr2[0];
                int intValue = ((Integer) objArr2[1]).intValue();
                objArr = Arrays.copyOf(objArr, intValue * 2);
                createHashTable = obj3;
                i5 = intValue;
            } else {
                throw duplicateKey.exception();
            }
        }
        return new RegularImmutableMap<>(createHashTable, objArr, i5);
    }

    static Object get(Object obj, Object[] objArr, int i5, int i6, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i5 == 1) {
            Object obj3 = objArr[i6];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i6 ^ 1];
            Objects.requireNonNull(obj4);
            return obj4;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length - 1;
            int smear = Hashing.smear(obj2.hashCode());
            while (true) {
                int i7 = smear & length;
                int i8 = bArr[i7] & ABSENT;
                if (i8 == 255) {
                    return null;
                }
                if (obj2.equals(objArr[i8])) {
                    return objArr[i8 ^ 1];
                }
                smear = i7 + 1;
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length2 = sArr.length - 1;
            int smear2 = Hashing.smear(obj2.hashCode());
            while (true) {
                int i9 = smear2 & length2;
                int i10 = sArr[i9] & SHORT_MASK;
                if (i10 == SHORT_MASK) {
                    return null;
                }
                if (obj2.equals(objArr[i10])) {
                    return objArr[i10 ^ 1];
                }
                smear2 = i9 + 1;
            }
        } else {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length - 1;
            int smear3 = Hashing.smear(obj2.hashCode());
            while (true) {
                int i11 = smear3 & length3;
                int i12 = iArr[i11];
                if (i12 == -1) {
                    return null;
                }
                if (obj2.equals(objArr[i12])) {
                    return objArr[i12 ^ 1];
                }
                smear3 = i11 + 1;
            }
        }
    }
}
