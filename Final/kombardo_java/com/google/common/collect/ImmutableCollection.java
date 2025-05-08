package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;

/* loaded from: classes2.dex */
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] EMPTY_ARRAY = new Object[0];

    /* loaded from: classes2.dex */
    public static abstract class Builder<E> {
        Builder() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int expandedCapacity(int i5, int i6) {
            if (i6 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int i7 = i5 + (i5 >> 1) + 1;
            if (i7 < i6) {
                i7 = Integer.highestOneBit(i6 - 1) << 1;
            }
            if (i7 < 0) {
                return Integer.MAX_VALUE;
            }
            return i7;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean contains(Object obj);

    abstract int copyIntoArray(Object[] objArr, int i5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object[] internalArray() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int internalArrayEnd() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int internalArrayStart() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean isPartialView();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract UnmodifiableIterator<E> iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(EMPTY_ARRAY);
    }

    Object writeReplace() {
        return new ImmutableList.SerializedForm(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        Preconditions.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] internalArray = internalArray();
            if (internalArray != null) {
                return (T[]) Platform.copy(internalArray, internalArrayStart(), internalArrayEnd(), tArr);
            }
            tArr = (T[]) ObjectArrays.newArray(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        copyIntoArray(tArr, 0);
        return tArr;
    }

    /* loaded from: classes2.dex */
    static abstract class ArrayBasedBuilder<E> extends Builder<E> {
        Object[] contents;
        boolean forceCopy;
        int size;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ArrayBasedBuilder(int i5) {
            CollectPreconditions.checkNonnegative(i5, "initialCapacity");
            this.contents = new Object[i5];
            this.size = 0;
        }

        private void getReadyToExpandTo(int i5) {
            Object[] objArr = this.contents;
            if (objArr.length < i5) {
                this.contents = Arrays.copyOf(objArr, Builder.expandedCapacity(objArr.length, i5));
                this.forceCopy = false;
            } else if (this.forceCopy) {
                this.contents = (Object[]) objArr.clone();
                this.forceCopy = false;
            }
        }

        public ArrayBasedBuilder<E> add(E e5) {
            Preconditions.checkNotNull(e5);
            getReadyToExpandTo(this.size + 1);
            Object[] objArr = this.contents;
            int i5 = this.size;
            this.size = i5 + 1;
            objArr[i5] = e5;
            return this;
        }

        final void addAll(Object[] objArr, int i5) {
            ObjectArrays.checkElementsNotNull(objArr, i5);
            getReadyToExpandTo(this.size + i5);
            System.arraycopy(objArr, 0, this.contents, this.size, i5);
            this.size += i5;
        }

        public Builder<E> add(E... eArr) {
            addAll(eArr, eArr.length);
            return this;
        }
    }
}
