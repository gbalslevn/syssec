package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\fJ\u000f\u0010\u0015\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0015\u0010\fJ\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0006J \u0010\u0019\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\fR\u0016\u0010\u001c\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Landroidx/collection/MutableLongObjectMap;", "V", "Landroidx/collection/LongObjectMap;", BuildConfig.FLAVOR, "initialCapacity", "<init>", "(I)V", BuildConfig.FLAVOR, "initializeStorage", "capacity", "initializeMetadata", "initializeGrowth", "()V", BuildConfig.FLAVOR, "key", "findAbsoluteInsertIndex", "(J)I", "hash1", "findFirstAvailableSlot", "(I)I", "adjustStorage", "dropDeletes", "newCapacity", "resizeStorage", "value", "set", "(JLjava/lang/Object;)V", "clear", "growthLimit", "I", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableLongObjectMap<V> extends LongObjectMap<V> {
    private int growthLimit;

    public MutableLongObjectMap(int i5) {
        super(null);
        if (!(i5 >= 0)) {
            RuntimeHelpersKt.throwIllegalArgumentException("Capacity must be a positive value.");
        }
        initializeStorage(ScatterMapKt.unloadedCapacity(i5));
    }

    private final void adjustStorage() {
        if (this._capacity <= 8 || Long.compareUnsigned(ULong.m3622constructorimpl(ULong.m3622constructorimpl(this._size) * 32), ULong.m3622constructorimpl(ULong.m3622constructorimpl(this._capacity) * 25)) > 0) {
            resizeStorage(ScatterMapKt.nextCapacity(this._capacity));
        } else {
            dropDeletes();
        }
    }

    private final void dropDeletes() {
        long[] jArr;
        int i5;
        int i6;
        long[] jArr2 = this.metadata;
        int i7 = this._capacity;
        long[] jArr3 = this.keys;
        Object[] objArr = this.values;
        ScatterMapKt.convertMetadataForCleanup(jArr2, i7);
        char c5 = 0;
        int i8 = 0;
        int i9 = -1;
        while (i8 != i7) {
            int i10 = i8 >> 3;
            int i11 = (i8 & 7) << 3;
            long j5 = (jArr2[i10] >> i11) & 255;
            if (j5 == 128) {
                i9 = i8;
                i8++;
            } else {
                if (j5 == 254) {
                    int hashCode = Long.hashCode(jArr3[i8]) * (-862048943);
                    int i12 = (hashCode ^ (hashCode << 16)) >>> 7;
                    int findFirstAvailableSlot = findFirstAvailableSlot(i12);
                    int i13 = i12 & i7;
                    if (((findFirstAvailableSlot - i13) & i7) / 8 == ((i8 - i13) & i7) / 8) {
                        jArr2[i10] = ((r10 & 127) << i11) | ((~(255 << i11)) & jArr2[i10]);
                        jArr2[ArraysKt.getLastIndex(jArr2)] = (jArr2[c5] & 72057594037927935L) | Long.MIN_VALUE;
                    } else {
                        int i14 = findFirstAvailableSlot >> 3;
                        long j6 = jArr2[i14];
                        int i15 = (findFirstAvailableSlot & 7) << 3;
                        if (((j6 >> i15) & 255) == 128) {
                            int i16 = i8;
                            jArr = jArr3;
                            jArr2[i14] = (j6 & (~(255 << i15))) | ((r10 & 127) << i15);
                            jArr2[i10] = (jArr2[i10] & (~(255 << i11))) | (128 << i11);
                            jArr[findFirstAvailableSlot] = jArr[i16];
                            jArr[i16] = 0;
                            objArr[findFirstAvailableSlot] = objArr[i16];
                            objArr[i16] = null;
                            i6 = i16;
                            i9 = i6;
                            i5 = i7;
                        } else {
                            int i17 = i7;
                            jArr = jArr3;
                            int i18 = i8;
                            jArr2[i14] = ((r10 & 127) << i15) | (j6 & (~(255 << i15)));
                            if (i9 == -1) {
                                i5 = i17;
                                i9 = ScatterMapKt.findEmptySlot(jArr2, i18 + 1, i5);
                            } else {
                                i5 = i17;
                            }
                            jArr[i9] = jArr[findFirstAvailableSlot];
                            jArr[findFirstAvailableSlot] = jArr[i18];
                            jArr[i18] = jArr[i9];
                            objArr[i9] = objArr[findFirstAvailableSlot];
                            objArr[findFirstAvailableSlot] = objArr[i18];
                            objArr[i18] = objArr[i9];
                            i6 = i18 - 1;
                        }
                        c5 = 0;
                        jArr2[ArraysKt.getLastIndex(jArr2)] = (jArr2[0] & 72057594037927935L) | Long.MIN_VALUE;
                        i8 = i6 + 1;
                        i7 = i5;
                        jArr3 = jArr;
                    }
                }
                i8++;
            }
        }
        initializeGrowth();
    }

    private final int findAbsoluteInsertIndex(long key) {
        int hashCode = Long.hashCode(key) * (-862048943);
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
            int i13 = i10;
            long j7 = j5 ^ (j6 * 72340172838076673L);
            for (long j8 = (~j7) & (j7 - 72340172838076673L) & (-9187201950435737472L); j8 != 0; j8 &= j8 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j8) >> 3) + i9) & i8;
                if (this.keys[numberOfTrailingZeros] == key) {
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
                return findFirstAvailableSlot;
            }
            i10 = i13 + 8;
            i9 = (i9 + i10) & i8;
        }
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
        this.keys = new long[max];
        this.values = new Object[max];
    }

    private final void resizeStorage(int newCapacity) {
        long[] jArr;
        MutableLongObjectMap<V> mutableLongObjectMap = this;
        long[] jArr2 = mutableLongObjectMap.metadata;
        long[] jArr3 = mutableLongObjectMap.keys;
        Object[] objArr = mutableLongObjectMap.values;
        int i5 = mutableLongObjectMap._capacity;
        initializeStorage(newCapacity);
        long[] jArr4 = mutableLongObjectMap.metadata;
        long[] jArr5 = mutableLongObjectMap.keys;
        Object[] objArr2 = mutableLongObjectMap.values;
        int i6 = mutableLongObjectMap._capacity;
        int i7 = 0;
        while (i7 < i5) {
            if (((jArr2[i7 >> 3] >> ((i7 & 7) << 3)) & 255) < 128) {
                long j5 = jArr3[i7];
                int hashCode = Long.hashCode(j5) * (-862048943);
                int i8 = hashCode ^ (hashCode << 16);
                int findFirstAvailableSlot = mutableLongObjectMap.findFirstAvailableSlot(i8 >>> 7);
                long j6 = i8 & 127;
                int i9 = findFirstAvailableSlot >> 3;
                int i10 = (findFirstAvailableSlot & 7) << 3;
                jArr = jArr2;
                long j7 = (jArr4[i9] & (~(255 << i10))) | (j6 << i10);
                jArr4[i9] = j7;
                jArr4[(((findFirstAvailableSlot - 7) & i6) + (i6 & 7)) >> 3] = j7;
                jArr5[findFirstAvailableSlot] = j5;
                objArr2[findFirstAvailableSlot] = objArr[i7];
            } else {
                jArr = jArr2;
            }
            i7++;
            mutableLongObjectMap = this;
            jArr2 = jArr;
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
        initializeGrowth();
    }

    public final void set(long key, V value) {
        int findAbsoluteInsertIndex = findAbsoluteInsertIndex(key);
        this.keys[findAbsoluteInsertIndex] = key;
        this.values[findAbsoluteInsertIndex] = value;
    }
}
