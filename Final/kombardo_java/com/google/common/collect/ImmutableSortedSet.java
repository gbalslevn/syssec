package com.google.common.collect;

import A2.d;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;

/* loaded from: classes2.dex */
public abstract class ImmutableSortedSet<E> extends ImmutableSortedSetFauxverideShim<E> implements NavigableSet<E>, SortedIterable<E> {
    final transient Comparator<? super E> comparator;
    transient ImmutableSortedSet<E> descendingSet;

    /* loaded from: classes2.dex */
    public static final class Builder<E> extends ImmutableSet.Builder<E> {
        private final Comparator<? super E> comparator;

        public Builder(Comparator<? super E> comparator) {
            this.comparator = (Comparator) Preconditions.checkNotNull(comparator);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.ArrayBasedBuilder
        public /* bridge */ /* synthetic */ ImmutableSet.Builder add(Object obj) {
            return add((Builder<E>) obj);
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.ArrayBasedBuilder
        public Builder<E> add(E e5) {
            super.add((Builder<E>) e5);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder
        public ImmutableSortedSet<E> build() {
            ImmutableSortedSet<E> construct = ImmutableSortedSet.construct(this.comparator, this.size, this.contents);
            this.size = construct.size();
            this.forceCopy = true;
            return construct;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.ArrayBasedBuilder
        public Builder<E> add(E... eArr) {
            super.add((Object[]) eArr);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    private static class SerializedForm<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super E> comparator;
        final Object[] elements;

        public SerializedForm(Comparator<? super E> comparator, Object[] objArr) {
            this.comparator = comparator;
            this.elements = objArr;
        }

        /* JADX WARN: Multi-variable type inference failed */
        Object readResolve() {
            return new Builder(this.comparator).add(this.elements).build();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableSortedSet(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <E> ImmutableSortedSet<E> construct(Comparator<? super E> comparator, int i5, E... eArr) {
        if (i5 == 0) {
            return emptySet(comparator);
        }
        ObjectArrays.checkElementsNotNull(eArr, i5);
        Arrays.sort(eArr, 0, i5, comparator);
        int i6 = 1;
        for (int i7 = 1; i7 < i5; i7++) {
            d dVar = (Object) eArr[i7];
            if (comparator.compare(dVar, (Object) eArr[i6 - 1]) != 0) {
                eArr[i6] = dVar;
                i6++;
            }
        }
        Arrays.fill(eArr, i6, i5, (Object) null);
        if (i6 < eArr.length / 2) {
            eArr = (E[]) Arrays.copyOf(eArr, i6);
        }
        return new RegularImmutableSortedSet(ImmutableList.asImmutableList(eArr, i6), comparator);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        Preconditions.checkNotNull(comparator);
        if (SortedIterables.hasSameComparator(comparator, iterable) && (iterable instanceof ImmutableSortedSet)) {
            ImmutableSortedSet<E> immutableSortedSet = (ImmutableSortedSet) iterable;
            if (!immutableSortedSet.isPartialView()) {
                return immutableSortedSet;
            }
        }
        Object[] array = Iterables.toArray(iterable);
        return construct(comparator, array.length, array);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> RegularImmutableSortedSet<E> emptySet(Comparator<? super E> comparator) {
        return Ordering.natural().equals(comparator) ? (RegularImmutableSortedSet<E>) RegularImmutableSortedSet.NATURAL_EMPTY_SET : new RegularImmutableSortedSet<>(ImmutableList.of(), comparator);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // java.util.SortedSet, com.google.common.collect.SortedIterable
    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    abstract ImmutableSortedSet<E> createDescendingSet();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet headSet(Object obj, boolean z5) {
        return headSet((ImmutableSortedSet<E>) obj, z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract ImmutableSortedSet<E> headSetImpl(E e5, boolean z5);

    @Override // java.util.NavigableSet
    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet subSet(Object obj, boolean z5, Object obj2, boolean z6) {
        return subSet((boolean) obj, z5, (boolean) obj2, z6);
    }

    abstract ImmutableSortedSet<E> subSetImpl(E e5, boolean z5, E e6, boolean z6);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet tailSet(Object obj, boolean z5) {
        return tailSet((ImmutableSortedSet<E>) obj, z5);
    }

    abstract ImmutableSortedSet<E> tailSetImpl(E e5, boolean z5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public int unsafeCompare(Object obj, Object obj2) {
        return unsafeCompare(this.comparator, obj, obj2);
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(this.comparator, toArray());
    }

    static int unsafeCompare(Comparator<?> comparator, Object obj, Object obj2) {
        return comparator.compare(obj, obj2);
    }

    @Override // java.util.NavigableSet
    public ImmutableSortedSet<E> descendingSet() {
        ImmutableSortedSet<E> immutableSortedSet = this.descendingSet;
        if (immutableSortedSet != null) {
            return immutableSortedSet;
        }
        ImmutableSortedSet<E> createDescendingSet = createDescendingSet();
        this.descendingSet = createDescendingSet;
        createDescendingSet.descendingSet = this;
        return createDescendingSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
        return headSet((ImmutableSortedSet<E>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet tailSet(Object obj) {
        return tailSet((ImmutableSortedSet<E>) obj);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public ImmutableSortedSet<E> headSet(E e5) {
        return headSet((ImmutableSortedSet<E>) e5, false);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public ImmutableSortedSet<E> subSet(E e5, E e6) {
        return subSet((boolean) e5, true, (boolean) e6, false);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public ImmutableSortedSet<E> tailSet(E e5) {
        return tailSet((ImmutableSortedSet<E>) e5, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public ImmutableSortedSet<E> headSet(E e5, boolean z5) {
        return headSetImpl(Preconditions.checkNotNull(e5), z5);
    }

    @Override // java.util.NavigableSet
    public ImmutableSortedSet<E> subSet(E e5, boolean z5, E e6, boolean z6) {
        Preconditions.checkNotNull(e5);
        Preconditions.checkNotNull(e6);
        Preconditions.checkArgument(this.comparator.compare(e5, e6) <= 0);
        return subSetImpl(e5, z5, e6, z6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public ImmutableSortedSet<E> tailSet(E e5, boolean z5) {
        return tailSetImpl(Preconditions.checkNotNull(e5), z5);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Collection<? extends E> collection) {
        return copyOf((Comparator) comparator, (Iterable) collection);
    }
}
