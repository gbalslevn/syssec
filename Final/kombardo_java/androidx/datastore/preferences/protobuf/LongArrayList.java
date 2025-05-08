package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class LongArrayList extends AbstractProtobufList<Long> implements Internal.LongList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final LongArrayList EMPTY_LIST = new LongArrayList(new long[0], 0, false);
    private long[] array;
    private int size;

    private LongArrayList(long[] jArr, int i5, boolean z5) {
        super(z5);
        this.array = jArr;
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
    public boolean addAll(Collection<? extends Long> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof LongArrayList)) {
            return super.addAll(collection);
        }
        LongArrayList longArrayList = (LongArrayList) collection;
        int i5 = longArrayList.size;
        if (i5 == 0) {
            return false;
        }
        int i6 = this.size;
        if (Integer.MAX_VALUE - i6 < i5) {
            throw new OutOfMemoryError();
        }
        int i7 = i6 + i5;
        long[] jArr = this.array;
        if (i7 > jArr.length) {
            this.array = Arrays.copyOf(jArr, i7);
        }
        System.arraycopy(longArrayList.array, 0, this.array, this.size, longArrayList.size);
        this.size = i7;
        ((AbstractList) this).modCount++;
        return true;
    }

    public void addLong(long j5) {
        ensureIsMutable();
        int i5 = this.size;
        long[] jArr = this.array;
        if (i5 == jArr.length) {
            long[] jArr2 = new long[((i5 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i5);
            this.array = jArr2;
        }
        long[] jArr3 = this.array;
        int i6 = this.size;
        this.size = i6 + 1;
        jArr3[i6] = j5;
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
        if (!(obj instanceof LongArrayList)) {
            return super.equals(obj);
        }
        LongArrayList longArrayList = (LongArrayList) obj;
        if (this.size != longArrayList.size) {
            return false;
        }
        long[] jArr = longArrayList.array;
        for (int i5 = 0; i5 < this.size; i5++) {
            if (this.array[i5] != jArr[i5]) {
                return false;
            }
        }
        return true;
    }

    public long getLong(int i5) {
        ensureIndexInRange(i5);
        return this.array[i5];
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.size; i6++) {
            i5 = (i5 * 31) + Internal.hashLong(this.array[i6]);
        }
        return i5;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            if (this.array[i5] == longValue) {
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
        long[] jArr = this.array;
        System.arraycopy(jArr, i6, jArr, i5, this.size - i6);
        this.size -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    public long setLong(int i5, long j5) {
        ensureIsMutable();
        ensureIndexInRange(i5);
        long[] jArr = this.array;
        long j6 = jArr[i5];
        jArr[i5] = j5;
        return j6;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractList, java.util.List
    public Long get(int i5) {
        return Long.valueOf(getLong(i5));
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList
    /* renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Long> mutableCopyWithCapacity2(int i5) {
        if (i5 >= this.size) {
            return new LongArrayList(Arrays.copyOf(this.array, i5), this.size, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Long remove(int i5) {
        ensureIsMutable();
        ensureIndexInRange(i5);
        long[] jArr = this.array;
        long j5 = jArr[i5];
        if (i5 < this.size - 1) {
            System.arraycopy(jArr, i5 + 1, jArr, i5, (r3 - i5) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j5);
    }

    @Override // java.util.AbstractList, java.util.List
    public Long set(int i5, Long l5) {
        return Long.valueOf(setLong(i5, l5.longValue()));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Long l5) {
        addLong(l5.longValue());
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i5, Long l5) {
        addLong(i5, l5.longValue());
    }

    private void addLong(int i5, long j5) {
        int i6;
        ensureIsMutable();
        if (i5 >= 0 && i5 <= (i6 = this.size)) {
            long[] jArr = this.array;
            if (i6 < jArr.length) {
                System.arraycopy(jArr, i5, jArr, i5 + 1, i6 - i5);
            } else {
                long[] jArr2 = new long[((i6 * 3) / 2) + 1];
                System.arraycopy(jArr, 0, jArr2, 0, i5);
                System.arraycopy(this.array, i5, jArr2, i5 + 1, this.size - i5);
                this.array = jArr2;
            }
            this.array[i5] = j5;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i5));
    }
}
