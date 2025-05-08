package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {
    private static final UnmodifiableListIterator<Object> EMPTY_ITR = new Itr(RegularImmutableList.EMPTY, 0);

    /* loaded from: classes2.dex */
    public static final class Builder<E> extends ImmutableCollection.ArrayBasedBuilder<E> {
        public Builder() {
            this(4);
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder
        public Builder<E> add(E... eArr) {
            super.add((Object[]) eArr);
            return this;
        }

        public ImmutableList<E> build() {
            this.forceCopy = true;
            return ImmutableList.asImmutableList(this.contents, this.size);
        }

        Builder(int i5) {
            super(i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class Itr<E> extends AbstractIndexedListIterator<E> {
        private final ImmutableList<E> list;

        Itr(ImmutableList<E> immutableList, int i5) {
            super(immutableList.size(), i5);
            this.list = immutableList;
        }

        @Override // com.google.common.collect.AbstractIndexedListIterator
        protected E get(int i5) {
            return this.list.get(i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ReverseImmutableList<E> extends ImmutableList<E> {
        private final transient ImmutableList<E> forwardList;

        ReverseImmutableList(ImmutableList<E> immutableList) {
            this.forwardList = immutableList;
        }

        private int reverseIndex(int i5) {
            return (size() - 1) - i5;
        }

        private int reversePosition(int i5) {
            return size() - i5;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.forwardList.contains(obj);
        }

        @Override // java.util.List
        public E get(int i5) {
            Preconditions.checkElementIndex(i5, size());
            return this.forwardList.get(reverseIndex(i5));
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(Object obj) {
            int lastIndexOf = this.forwardList.lastIndexOf(obj);
            if (lastIndexOf >= 0) {
                return reverseIndex(lastIndexOf);
            }
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return this.forwardList.isPartialView();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(Object obj) {
            int indexOf = this.forwardList.indexOf(obj);
            if (indexOf >= 0) {
                return reverseIndex(indexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.google.common.collect.ImmutableList
        public ImmutableList<E> reverse() {
            return this.forwardList;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.forwardList.size();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i5) {
            return super.listIterator(i5);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i5, int i6) {
            Preconditions.checkPositionIndexes(i5, i6, size());
            return this.forwardList.subList(reversePosition(i6), reversePosition(i5)).reverse();
        }
    }

    /* loaded from: classes2.dex */
    static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        Object readResolve() {
            return ImmutableList.copyOf(this.elements);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class SubList extends ImmutableList<E> {
        final transient int length;
        final transient int offset;

        SubList(int i5, int i6) {
            this.offset = i5;
            this.length = i6;
        }

        @Override // java.util.List
        public E get(int i5) {
            Preconditions.checkElementIndex(i5, this.length);
            return ImmutableList.this.get(i5 + this.offset);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public Object[] internalArray() {
            return ImmutableList.this.internalArray();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public int internalArrayEnd() {
            return ImmutableList.this.internalArrayStart() + this.offset + this.length;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public int internalArrayStart() {
            return ImmutableList.this.internalArrayStart() + this.offset;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.length;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i5) {
            return super.listIterator(i5);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i5, int i6) {
            Preconditions.checkPositionIndexes(i5, i6, this.length);
            ImmutableList immutableList = ImmutableList.this;
            int i7 = this.offset;
            return immutableList.subList(i5 + i7, i6 + i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableList<E> asImmutableList(Object[] objArr) {
        return asImmutableList(objArr, objArr.length);
    }

    private static <E> ImmutableList<E> construct(Object... objArr) {
        return asImmutableList(ObjectArrays.checkElementsNotNull(objArr));
    }

    public static <E> ImmutableList<E> copyOf(E[] eArr) {
        return eArr.length == 0 ? of() : construct((Object[]) eArr.clone());
    }

    public static <E> ImmutableList<E> of() {
        return (ImmutableList<E>) RegularImmutableList.EMPTY;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E> ImmutableList<E> sortedCopyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        Preconditions.checkNotNull(comparator);
        Object[] array = Iterables.toArray(iterable);
        ObjectArrays.checkElementsNotNull(array);
        Arrays.sort(array, comparator);
        return asImmutableList(array);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i5, E e5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i5, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i5) {
        int size = size();
        for (int i6 = 0; i6 < size; i6++) {
            objArr[i5 + i6] = get(i6);
        }
        return i5 + size;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return Lists.equalsImpl(this, obj);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i5 = 1;
        for (int i6 = 0; i6 < size; i6++) {
            i5 = ~(~((i5 * 31) + get(i6).hashCode()));
        }
        return i5;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return Lists.indexOfImpl(this, obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return Lists.lastIndexOfImpl(this, obj);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i5) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> reverse() {
        return size() <= 1 ? this : new ReverseImmutableList(this);
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i5, E e5) {
        throw new UnsupportedOperationException();
    }

    ImmutableList<E> subListUnchecked(int i5, int i6) {
        return new SubList(i5, i6 - i5);
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableList<E> asImmutableList(Object[] objArr, int i5) {
        if (i5 == 0) {
            return of();
        }
        return new RegularImmutableList(objArr, i5);
    }

    public static <E> ImmutableList<E> of(E e5, E e6) {
        return construct(e5, e6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public UnmodifiableIterator<E> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public ImmutableList<E> subList(int i5, int i6) {
        Preconditions.checkPositionIndexes(i5, i6, size());
        int i7 = i6 - i5;
        if (i7 == size()) {
            return this;
        }
        if (i7 == 0) {
            return of();
        }
        return subListUnchecked(i5, i6);
    }

    public static <E> ImmutableList<E> of(E e5, E e6, E e7) {
        return construct(e5, e6, e7);
    }

    @Override // java.util.List
    public UnmodifiableListIterator<E> listIterator() {
        return listIterator(0);
    }

    public static <E> ImmutableList<E> of(E e5, E e6, E e7, E e8, E e9, E e10, E e11) {
        return construct(e5, e6, e7, e8, e9, e10, e11);
    }

    @Override // java.util.List
    public UnmodifiableListIterator<E> listIterator(int i5) {
        Preconditions.checkPositionIndex(i5, size());
        if (isEmpty()) {
            return (UnmodifiableListIterator<E>) EMPTY_ITR;
        }
        return new Itr(this, i5);
    }
}
