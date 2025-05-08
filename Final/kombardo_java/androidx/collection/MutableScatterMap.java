package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\rJ\u000f\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\rJ\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0007J \u0010\u0017\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0001H\u0086\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u001b\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\rJ\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Landroidx/collection/MutableScatterMap;", "K", "V", "Landroidx/collection/ScatterMap;", BuildConfig.FLAVOR, "initialCapacity", "<init>", "(I)V", BuildConfig.FLAVOR, "initializeStorage", "capacity", "initializeMetadata", "initializeGrowth", "()V", "hash1", "findFirstAvailableSlot", "(I)I", "adjustStorage", "dropDeletes", "newCapacity", "resizeStorage", "key", "value", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "remove", "(Ljava/lang/Object;)Ljava/lang/Object;", "index", "removeValueAt", "(I)Ljava/lang/Object;", "clear", "findInsertIndex", "(Ljava/lang/Object;)I", "growthLimit", "I", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableScatterMap<K, V> extends ScatterMap<K, V> {
    private int growthLimit;

    public /* synthetic */ MutableScatterMap(int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 6 : i5);
    }

    private final void adjustStorage() {
        if (this._capacity <= 8 || Long.compareUnsigned(ULong.m3622constructorimpl(ULong.m3622constructorimpl(this._size) * 32), ULong.m3622constructorimpl(ULong.m3622constructorimpl(this._capacity) * 25)) > 0) {
            resizeStorage(ScatterMapKt.nextCapacity(this._capacity));
        } else {
            dropDeletes();
        }
    }

    private final void dropDeletes() {
        Object[] objArr;
        int i5;
        int i6;
        long[] jArr = this.metadata;
        int i7 = this._capacity;
        Object[] objArr2 = this.keys;
        Object[] objArr3 = this.values;
        ScatterMapKt.convertMetadataForCleanup(jArr, i7);
        int i8 = 0;
        int i9 = 0;
        int i10 = -1;
        while (i9 != i7) {
            int i11 = i9 >> 3;
            int i12 = (i9 & 7) << 3;
            long j5 = (jArr[i11] >> i12) & 255;
            if (j5 == 128) {
                i10 = i9;
                i9++;
            } else {
                if (j5 == 254) {
                    Object obj = objArr2[i9];
                    int hashCode = (obj != null ? obj.hashCode() : i8) * (-862048943);
                    int i13 = (hashCode ^ (hashCode << 16)) >>> 7;
                    int findFirstAvailableSlot = findFirstAvailableSlot(i13);
                    int i14 = i13 & i7;
                    if (((findFirstAvailableSlot - i14) & i7) / 8 == ((i9 - i14) & i7) / 8) {
                        jArr[i11] = ((r10 & 127) << i12) | ((~(255 << i12)) & jArr[i11]);
                        jArr[ArraysKt.getLastIndex(jArr)] = jArr[i8];
                    } else {
                        int i15 = findFirstAvailableSlot >> 3;
                        long j6 = jArr[i15];
                        int i16 = (findFirstAvailableSlot & 7) << 3;
                        if (((j6 >> i16) & 255) == 128) {
                            int i17 = i9;
                            objArr = objArr2;
                            jArr[i15] = (j6 & (~(255 << i16))) | ((r10 & 127) << i16);
                            jArr[i11] = (jArr[i11] & (~(255 << i12))) | (128 << i12);
                            objArr[findFirstAvailableSlot] = objArr[i17];
                            objArr[i17] = null;
                            objArr3[findFirstAvailableSlot] = objArr3[i17];
                            objArr3[i17] = null;
                            i6 = i17;
                            i10 = i6;
                            i5 = i7;
                        } else {
                            int i18 = i7;
                            objArr = objArr2;
                            int i19 = i9;
                            jArr[i15] = ((r10 & 127) << i16) | (j6 & (~(255 << i16)));
                            if (i10 == -1) {
                                i5 = i18;
                                i10 = ScatterMapKt.findEmptySlot(jArr, i19 + 1, i5);
                            } else {
                                i5 = i18;
                            }
                            objArr[i10] = objArr[findFirstAvailableSlot];
                            objArr[findFirstAvailableSlot] = objArr[i19];
                            objArr[i19] = objArr[i10];
                            objArr3[i10] = objArr3[findFirstAvailableSlot];
                            objArr3[findFirstAvailableSlot] = objArr3[i19];
                            objArr3[i19] = objArr3[i10];
                            i6 = i19 - 1;
                        }
                        i8 = 0;
                        jArr[ArraysKt.getLastIndex(jArr)] = jArr[0];
                        i9 = i6 + 1;
                        i7 = i5;
                        objArr2 = objArr;
                    }
                }
                i9++;
            }
        }
        initializeGrowth();
    }

    private final int findFirstAvailableSlot(int hash1) {
        int i5 = this._capacity;
        int i6 = hash1 & i5;
        int i7 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i8 = i6 >> 3;
            int i9 = (i6 & 7) << 3;
            long j5 = ((jArr[i8 + 1] << (64 - i9)) & ((-i9) >> 63)) | (jArr[i8] >>> i9);
            long j6 = j5 & ((~j5) << 7) & (-9187201950435737472L);
            if (j6 != 0) {
                return (i6 + (Long.numberOfTrailingZeros(j6) >> 3)) & i5;
            }
            i7 += 8;
            i6 = (i6 + i7) & i5;
        }
    }

    private final void initializeGrowth() {
        this.growthLimit = ScatterMapKt.loadedCapacity(get_capacity()) - this._size;
    }

    private final void initializeMetadata(int capacity) {
        long[] jArr;
        if (capacity == 0) {
            jArr = ScatterMapKt.EmptyGroup;
        } else {
            jArr = new long[((capacity + 15) & (-8)) >> 3];
            ArraysKt.fill$default(jArr, -9187201950435737472L, 0, 0, 6, (Object) null);
        }
        this.metadata = jArr;
        int i5 = capacity >> 3;
        long j5 = 255 << ((capacity & 7) << 3);
        jArr[i5] = (jArr[i5] & (~j5)) | j5;
        initializeGrowth();
    }

    private final void initializeStorage(int initialCapacity) {
        int max = initialCapacity > 0 ? Math.max(7, ScatterMapKt.normalizeCapacity(initialCapacity)) : 0;
        this._capacity = max;
        initializeMetadata(max);
        this.keys = new Object[max];
        this.values = new Object[max];
    }

    private final void resizeStorage(int newCapacity) {
        int i5;
        long[] jArr = this.metadata;
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        int i6 = this._capacity;
        initializeStorage(newCapacity);
        long[] jArr2 = this.metadata;
        Object[] objArr3 = this.keys;
        Object[] objArr4 = this.values;
        int i7 = this._capacity;
        int i8 = 0;
        while (i8 < i6) {
            if (((jArr[i8 >> 3] >> ((i8 & 7) << 3)) & 255) < 128) {
                Object obj = objArr[i8];
                int hashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
                int i9 = hashCode ^ (hashCode << 16);
                int findFirstAvailableSlot = findFirstAvailableSlot(i9 >>> 7);
                i5 = i8;
                long j5 = i9 & 127;
                int i10 = findFirstAvailableSlot >> 3;
                int i11 = (findFirstAvailableSlot & 7) << 3;
                long j6 = (j5 << i11) | (jArr2[i10] & (~(255 << i11)));
                jArr2[i10] = j6;
                jArr2[(((findFirstAvailableSlot - 7) & i7) + (i7 & 7)) >> 3] = j6;
                objArr3[findFirstAvailableSlot] = obj;
                objArr4[findFirstAvailableSlot] = objArr2[i5];
            } else {
                i5 = i8;
            }
            i8 = i5 + 1;
        }
    }

    public final void clear() {
        this._size = 0;
        long[] jArr = this.metadata;
        if (jArr != ScatterMapKt.EmptyGroup) {
            ArraysKt.fill$default(jArr, -9187201950435737472L, 0, 0, 6, (Object) null);
            long[] jArr2 = this.metadata;
            int i5 = this._capacity;
            int i6 = i5 >> 3;
            long j5 = 255 << ((i5 & 7) << 3);
            jArr2[i6] = (jArr2[i6] & (~j5)) | j5;
        }
        ArraysKt.fill(this.values, (Object) null, 0, this._capacity);
        ArraysKt.fill(this.keys, (Object) null, 0, this._capacity);
        initializeGrowth();
    }

    public final int findInsertIndex(K key) {
        int hashCode = (key != null ? key.hashCode() : 0) * (-862048943);
        int i5 = hashCode ^ (hashCode << 16);
        int i6 = i5 >>> 7;
        int i7 = i5 & 127;
        int i8 = this._capacity;
        int i9 = i6 & i8;
        int i10 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i11 = i9 >> 3;
            int i12 = (i9 & 7) << 3;
            long j5 = ((jArr[i11 + 1] << (64 - i12)) & ((-i12) >> 63)) | (jArr[i11] >>> i12);
            long j6 = i7;
            int i13 = i7;
            long j7 = j5 ^ (j6 * 72340172838076673L);
            for (long j8 = (~j7) & (j7 - 72340172838076673L) & (-9187201950435737472L); j8 != 0; j8 &= j8 - 1) {
                int numberOfTrailingZeros = (i9 + (Long.numberOfTrailingZeros(j8) >> 3)) & i8;
                if (Intrinsics.areEqual(this.keys[numberOfTrailingZeros], key)) {
                    return numberOfTrailingZeros;
                }
            }
            if ((((~j5) << 6) & j5 & (-9187201950435737472L)) != 0) {
                int findFirstAvailableSlot = findFirstAvailableSlot(i6);
                if (this.growthLimit == 0 && ((this.metadata[findFirstAvailableSlot >> 3] >> ((findFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage();
                    findFirstAvailableSlot = findFirstAvailableSlot(i6);
                }
                this._size++;
                int i14 = this.growthLimit;
                long[] jArr2 = this.metadata;
                int i15 = findFirstAvailableSlot >> 3;
                long j9 = jArr2[i15];
                int i16 = (findFirstAvailableSlot & 7) << 3;
                this.growthLimit = i14 - (((j9 >> i16) & 255) == 128 ? 1 : 0);
                int i17 = this._capacity;
                long j10 = ((~(255 << i16)) & j9) | (j6 << i16);
                jArr2[i15] = j10;
                jArr2[(((findFirstAvailableSlot - 7) & i17) + (i17 & 7)) >> 3] = j10;
                return ~findFirstAvailableSlot;
            }
            i10 += 8;
            i9 = (i9 + i10) & i8;
            i7 = i13;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0069, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006b, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final V remove(K key) {
        int i5;
        int i6 = 0;
        int hashCode = (key != null ? key.hashCode() : 0) * (-862048943);
        int i7 = hashCode ^ (hashCode << 16);
        int i8 = i7 & 127;
        int i9 = this._capacity;
        int i10 = i7 >>> 7;
        loop0: while (true) {
            int i11 = i10 & i9;
            long[] jArr = this.metadata;
            int i12 = i11 >> 3;
            int i13 = (i11 & 7) << 3;
            long j5 = ((jArr[i12 + 1] << (64 - i13)) & ((-i13) >> 63)) | (jArr[i12] >>> i13);
            long j6 = (i8 * 72340172838076673L) ^ j5;
            long j7 = (~j6) & (j6 - 72340172838076673L) & (-9187201950435737472L);
            while (true) {
                if (j7 == 0) {
                    break;
                }
                i5 = ((Long.numberOfTrailingZeros(j7) >> 3) + i11) & i9;
                if (Intrinsics.areEqual(this.keys[i5], key)) {
                    break loop0;
                }
                j7 &= j7 - 1;
            }
            i6 += 8;
            i10 = i11 + i6;
        }
        if (i5 >= 0) {
            return removeValueAt(i5);
        }
        return null;
    }

    public final V removeValueAt(int index) {
        this._size--;
        long[] jArr = this.metadata;
        int i5 = this._capacity;
        int i6 = index >> 3;
        int i7 = (index & 7) << 3;
        long j5 = (jArr[i6] & (~(255 << i7))) | (254 << i7);
        jArr[i6] = j5;
        jArr[(((index - 7) & i5) + (i5 & 7)) >> 3] = j5;
        this.keys[index] = null;
        Object[] objArr = this.values;
        V v5 = (V) objArr[index];
        objArr[index] = null;
        return v5;
    }

    public final void set(K key, V value) {
        int findInsertIndex = findInsertIndex(key);
        if (findInsertIndex < 0) {
            findInsertIndex = ~findInsertIndex;
        }
        this.keys[findInsertIndex] = key;
        this.values[findInsertIndex] = value;
    }

    public MutableScatterMap(int i5) {
        super(null);
        if (!(i5 >= 0)) {
            RuntimeHelpersKt.throwIllegalArgumentException("Capacity must be a positive value.");
        }
        initializeStorage(ScatterMapKt.unloadedCapacity(i5));
    }
}
