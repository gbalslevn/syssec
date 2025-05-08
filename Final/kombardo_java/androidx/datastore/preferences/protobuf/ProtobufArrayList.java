package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {
    private static final ProtobufArrayList<Object> EMPTY_LIST = new ProtobufArrayList<>(new Object[0], 0, false);
    private E[] array;
    private int size;

    private ProtobufArrayList(E[] eArr, int i5, boolean z5) {
        super(z5);
        this.array = eArr;
        this.size = i5;
    }

    private static <E> E[] createArray(int i5) {
        return (E[]) new Object[i5];
    }

    public static <E> ProtobufArrayList<E> emptyList() {
        return (ProtobufArrayList<E>) EMPTY_LIST;
    }

    private void ensureIndexInRange(int i5) {
        if (i5 < 0 || i5 >= this.size) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i5));
        }
    }

    private String makeOutOfBoundsExceptionMessage(int i5) {
        return "Index:" + i5 + ", Size:" + this.size;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e5) {
        ensureIsMutable();
        int i5 = this.size;
        E[] eArr = this.array;
        if (i5 == eArr.length) {
            this.array = (E[]) Arrays.copyOf(eArr, ((i5 * 3) / 2) + 1);
        }
        E[] eArr2 = this.array;
        int i6 = this.size;
        this.size = i6 + 1;
        eArr2[i6] = e5;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i5) {
        ensureIndexInRange(i5);
        return this.array[i5];
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E remove(int i5) {
        ensureIsMutable();
        ensureIndexInRange(i5);
        E[] eArr = this.array;
        E e5 = eArr[i5];
        if (i5 < this.size - 1) {
            System.arraycopy(eArr, i5 + 1, eArr, i5, (r2 - i5) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return e5;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i5, E e5) {
        ensureIsMutable();
        ensureIndexInRange(i5);
        E[] eArr = this.array;
        E e6 = eArr[i5];
        eArr[i5] = e5;
        ((AbstractList) this).modCount++;
        return e6;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList
    public ProtobufArrayList<E> mutableCopyWithCapacity(int i5) {
        if (i5 >= this.size) {
            return new ProtobufArrayList<>(Arrays.copyOf(this.array, i5), this.size, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i5, E e5) {
        int i6;
        ensureIsMutable();
        if (i5 >= 0 && i5 <= (i6 = this.size)) {
            E[] eArr = this.array;
            if (i6 < eArr.length) {
                System.arraycopy(eArr, i5, eArr, i5 + 1, i6 - i5);
            } else {
                E[] eArr2 = (E[]) createArray(((i6 * 3) / 2) + 1);
                System.arraycopy(this.array, 0, eArr2, 0, i5);
                System.arraycopy(this.array, i5, eArr2, i5 + 1, this.size - i5);
                this.array = eArr2;
            }
            this.array[i5] = e5;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i5));
    }
}
