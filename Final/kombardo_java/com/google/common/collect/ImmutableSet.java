package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* loaded from: classes2.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    private static final int CUTOFF = 751619276;
    private static final double DESIRED_LOAD_FACTOR = 0.7d;
    private transient ImmutableList<E> asList;

    /* loaded from: classes2.dex */
    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int chooseTableSize(int i5) {
        int max = Math.max(i5, 2);
        if (max >= CUTOFF) {
            Preconditions.checkArgument(max < 1073741824, "collection too large");
            return 1073741824;
        }
        int highestOneBit = Integer.highestOneBit(max - 1) << 1;
        while (highestOneBit * DESIRED_LOAD_FACTOR < max) {
            highestOneBit <<= 1;
        }
        return highestOneBit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ImmutableSet<E> construct(int i5, Object... objArr) {
        if (i5 == 0) {
            return of();
        }
        if (i5 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return of(obj);
        }
        int chooseTableSize = chooseTableSize(i5);
        Object[] objArr2 = new Object[chooseTableSize];
        int i6 = chooseTableSize - 1;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < i5; i9++) {
            Object checkElementNotNull = ObjectArrays.checkElementNotNull(objArr[i9], i9);
            int hashCode = checkElementNotNull.hashCode();
            int smear = Hashing.smear(hashCode);
            while (true) {
                int i10 = smear & i6;
                Object obj2 = objArr2[i10];
                if (obj2 == null) {
                    objArr[i8] = checkElementNotNull;
                    objArr2[i10] = checkElementNotNull;
                    i7 += hashCode;
                    i8++;
                    break;
                }
                if (obj2.equals(checkElementNotNull)) {
                    break;
                }
                smear++;
            }
        }
        Arrays.fill(objArr, i8, i5, (Object) null);
        if (i8 == 1) {
            Object obj3 = objArr[0];
            Objects.requireNonNull(obj3);
            return new SingletonImmutableSet(obj3);
        }
        if (chooseTableSize(i8) < chooseTableSize / 2) {
            return construct(i8, objArr);
        }
        if (shouldTrim(i8, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i8);
        }
        return new RegularImmutableSet(objArr, i7, objArr2, i6, i8);
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.isPartialView()) {
                return immutableSet;
            }
        }
        Object[] array = collection.toArray();
        return construct(array.length, array);
    }

    public static <E> ImmutableSet<E> of() {
        return RegularImmutableSet.EMPTY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean shouldTrim(int i5, int i6) {
        return i5 < (i6 >> 1) + (i6 >> 2);
    }

    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> createAsList = createAsList();
        this.asList = createAsList;
        return createAsList;
    }

    ImmutableList<E> createAsList() {
        return ImmutableList.asImmutableList(toArray());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && isHashCodeFast() && ((ImmutableSet) obj).isHashCodeFast() && hashCode() != obj.hashCode()) {
            return false;
        }
        return Sets.equalsImpl(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }

    boolean isHashCodeFast() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract UnmodifiableIterator<E> iterator();

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> ImmutableSet<E> of(E e5) {
        return new SingletonImmutableSet(e5);
    }

    public static <E> ImmutableSet<E> of(E e5, E e6, E e7) {
        return construct(3, e5, e6, e7);
    }

    @SafeVarargs
    public static <E> ImmutableSet<E> of(E e5, E e6, E e7, E e8, E e9, E e10, E... eArr) {
        Preconditions.checkArgument(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e5;
        objArr[1] = e6;
        objArr[2] = e7;
        objArr[3] = e8;
        objArr[4] = e9;
        objArr[5] = e10;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return construct(length, objArr);
    }

    /* loaded from: classes2.dex */
    public static class Builder<E> extends ImmutableCollection.ArrayBasedBuilder<E> {
        private int hashCode;
        Object[] hashTable;

        public Builder() {
            super(4);
        }

        private void addDeduping(E e5) {
            Objects.requireNonNull(this.hashTable);
            int length = this.hashTable.length - 1;
            int hashCode = e5.hashCode();
            int smear = Hashing.smear(hashCode);
            while (true) {
                int i5 = smear & length;
                Object[] objArr = this.hashTable;
                Object obj = objArr[i5];
                if (obj == null) {
                    objArr[i5] = e5;
                    this.hashCode += hashCode;
                    super.add((Builder<E>) e5);
                    return;
                } else if (obj.equals(e5)) {
                    return;
                } else {
                    smear = i5 + 1;
                }
            }
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder
        public Builder<E> add(E e5) {
            Preconditions.checkNotNull(e5);
            if (this.hashTable != null && ImmutableSet.chooseTableSize(this.size) <= this.hashTable.length) {
                addDeduping(e5);
                return this;
            }
            this.hashTable = null;
            super.add((Builder<E>) e5);
            return this;
        }

        public ImmutableSet<E> build() {
            ImmutableSet<E> construct;
            int i5 = this.size;
            if (i5 == 0) {
                return ImmutableSet.of();
            }
            if (i5 == 1) {
                Object obj = this.contents[0];
                Objects.requireNonNull(obj);
                return ImmutableSet.of(obj);
            }
            if (this.hashTable == null || ImmutableSet.chooseTableSize(i5) != this.hashTable.length) {
                construct = ImmutableSet.construct(this.size, this.contents);
                this.size = construct.size();
            } else {
                Object[] copyOf = ImmutableSet.shouldTrim(this.size, this.contents.length) ? Arrays.copyOf(this.contents, this.size) : this.contents;
                construct = new RegularImmutableSet<>(copyOf, this.hashCode, this.hashTable, r5.length - 1, this.size);
            }
            this.forceCopy = true;
            this.hashTable = null;
            return construct;
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder
        public Builder<E> add(E... eArr) {
            if (this.hashTable != null) {
                for (E e5 : eArr) {
                    add((Builder<E>) e5);
                }
            } else {
                super.add((Object[]) eArr);
            }
            return this;
        }
    }

    public static <E> ImmutableSet<E> copyOf(E[] eArr) {
        int length = eArr.length;
        if (length == 0) {
            return of();
        }
        if (length != 1) {
            return construct(eArr.length, (Object[]) eArr.clone());
        }
        return of((Object) eArr[0]);
    }
}
