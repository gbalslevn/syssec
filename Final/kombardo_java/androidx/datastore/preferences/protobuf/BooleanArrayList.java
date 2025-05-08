package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class BooleanArrayList extends AbstractProtobufList<Boolean> implements Internal.BooleanList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final BooleanArrayList EMPTY_LIST = new BooleanArrayList(new boolean[0], 0, false);
    private boolean[] array;
    private int size;

    private BooleanArrayList(boolean[] zArr, int i5, boolean z5) {
        super(z5);
        this.array = zArr;
        this.size = i5;
    }

    private void ensureIndexInRange(int i5) {
        if (i5 < 0 || i5 >= this.size) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i5));
        }
    }

    private String makeOutOfBoundsExceptionMessage(int i5) {
        return "Index:" + i5 + ", Size:" + this.size;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Boolean> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof BooleanArrayList)) {
            return super.addAll(collection);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) collection;
        int i5 = booleanArrayList.size;
        if (i5 == 0) {
            return false;
        }
        int i6 = this.size;
        if (Integer.MAX_VALUE - i6 < i5) {
            throw new OutOfMemoryError();
        }
        int i7 = i6 + i5;
        boolean[] zArr = this.array;
        if (i7 > zArr.length) {
            this.array = Arrays.copyOf(zArr, i7);
        }
        System.arraycopy(booleanArrayList.array, 0, this.array, this.size, booleanArrayList.size);
        this.size = i7;
        ((AbstractList) this).modCount++;
        return true;
    }

    public void addBoolean(boolean z5) {
        ensureIsMutable();
        int i5 = this.size;
        boolean[] zArr = this.array;
        if (i5 == zArr.length) {
            boolean[] zArr2 = new boolean[((i5 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i5);
            this.array = zArr2;
        }
        boolean[] zArr3 = this.array;
        int i6 = this.size;
        this.size = i6 + 1;
        zArr3[i6] = z5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BooleanArrayList)) {
            return super.equals(obj);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) obj;
        if (this.size != booleanArrayList.size) {
            return false;
        }
        boolean[] zArr = booleanArrayList.array;
        for (int i5 = 0; i5 < this.size; i5++) {
            if (this.array[i5] != zArr[i5]) {
                return false;
            }
        }
        return true;
    }

    public boolean getBoolean(int i5) {
        ensureIndexInRange(i5);
        return this.array[i5];
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.size; i6++) {
            i5 = (i5 * 31) + Internal.hashBoolean(this.array[i6]);
        }
        return i5;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            if (this.array[i5] == booleanValue) {
                return i5;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i5, int i6) {
        ensureIsMutable();
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.array;
        System.arraycopy(zArr, i6, zArr, i5, this.size - i6);
        this.size -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    public boolean setBoolean(int i5, boolean z5) {
        ensureIsMutable();
        ensureIndexInRange(i5);
        boolean[] zArr = this.array;
        boolean z6 = zArr[i5];
        zArr[i5] = z5;
        return z6;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractList, java.util.List
    public Boolean get(int i5) {
        return Boolean.valueOf(getBoolean(i5));
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList
    /* renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Boolean> mutableCopyWithCapacity2(int i5) {
        if (i5 >= this.size) {
            return new BooleanArrayList(Arrays.copyOf(this.array, i5), this.size, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Boolean remove(int i5) {
        ensureIsMutable();
        ensureIndexInRange(i5);
        boolean[] zArr = this.array;
        boolean z5 = zArr[i5];
        if (i5 < this.size - 1) {
            System.arraycopy(zArr, i5 + 1, zArr, i5, (r2 - i5) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z5);
    }

    @Override // java.util.AbstractList, java.util.List
    public Boolean set(int i5, Boolean bool) {
        return Boolean.valueOf(setBoolean(i5, bool.booleanValue()));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Boolean bool) {
        addBoolean(bool.booleanValue());
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i5, Boolean bool) {
        addBoolean(i5, bool.booleanValue());
    }

    private void addBoolean(int i5, boolean z5) {
        int i6;
        ensureIsMutable();
        if (i5 >= 0 && i5 <= (i6 = this.size)) {
            boolean[] zArr = this.array;
            if (i6 < zArr.length) {
                System.arraycopy(zArr, i5, zArr, i5 + 1, i6 - i5);
            } else {
                boolean[] zArr2 = new boolean[((i6 * 3) / 2) + 1];
                System.arraycopy(zArr, 0, zArr2, 0, i5);
                System.arraycopy(this.array, i5, zArr2, i5 + 1, this.size - i5);
                this.array = zArr2;
            }
            this.array[i5] = z5;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i5));
    }
}
