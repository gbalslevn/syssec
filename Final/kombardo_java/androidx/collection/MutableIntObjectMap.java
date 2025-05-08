package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\fJ\u000f\u0010\u0013\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\fJ\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0015\u0010\u0006J \u0010\u0017\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u0004\u0018\u00018\u00002\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001e\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001d\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u001e\u0010\u001cJ\r\u0010\u001f\u001a\u00020\u0007¢\u0006\u0004\b\u001f\u0010\fR\u0016\u0010 \u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006\""}, d2 = {"Landroidx/collection/MutableIntObjectMap;", "V", "Landroidx/collection/IntObjectMap;", BuildConfig.FLAVOR, "initialCapacity", "<init>", "(I)V", BuildConfig.FLAVOR, "initializeStorage", "capacity", "initializeMetadata", "initializeGrowth", "()V", "key", "findAbsoluteInsertIndex", "(I)I", "hash1", "findFirstAvailableSlot", "adjustStorage", "dropDeletes", "newCapacity", "resizeStorage", "value", "set", "(ILjava/lang/Object;)V", "put", "(ILjava/lang/Object;)Ljava/lang/Object;", "remove", "(I)Ljava/lang/Object;", "index", "removeValueAt", "clear", "growthLimit", "I", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableIntObjectMap<V> extends IntObjectMap<V> {
    private int growthLimit;

    public /* synthetic */ MutableIntObjectMap(int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
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
        int[] iArr;
        int i5;
        int i6;
        long[] jArr = this.metadata;
        int i7 = this._capacity;
        int[] iArr2 = this.keys;
        Object[] objArr = this.values;
        ScatterMapKt.convertMetadataForCleanup(jArr, i7);
        char c5 = 0;
        int i8 = 0;
        int i9 = -1;
        while (i8 != i7) {
            int i10 = i8 >> 3;
            int i11 = (i8 & 7) << 3;
            long j5 = (jArr[i10] >> i11) & 255;
            if (j5 == 128) {
                i9 = i8;
                i8++;
            } else {
                if (j5 == 254) {
                    int hashCode = Integer.hashCode(iArr2[i8]) * (-862048943);
                    int i12 = (hashCode ^ (hashCode << 16)) >>> 7;
                    int findFirstAvailableSlot = findFirstAvailableSlot(i12);
                    int i13 = i12 & i7;
                    if (((findFirstAvailableSlot - i13) & i7) / 8 == ((i8 - i13) & i7) / 8) {
                        jArr[i10] = ((r10 & 127) << i11) | ((~(255 << i11)) & jArr[i10]);
                        jArr[ArraysKt.getLastIndex(jArr)] = (jArr[c5] & 72057594037927935L) | Long.MIN_VALUE;
                    } else {
                        int i14 = findFirstAvailableSlot >> 3;
                        long j6 = jArr[i14];
                        int i15 = (findFirstAvailableSlot & 7) << 3;
                        if (((j6 >> i15) & 255) == 128) {
                            int i16 = i8;
                            iArr = iArr2;
                            jArr[i14] = (j6 & (~(255 << i15))) | ((r10 & 127) << i15);
                            jArr[i10] = (jArr[i10] & (~(255 << i11))) | (128 << i11);
                            iArr[findFirstAvailableSlot] = iArr[i16];
                            iArr[i16] = 0;
                            objArr[findFirstAvailableSlot] = objArr[i16];
                            objArr[i16] = null;
                            i6 = i16;
                            i9 = i6;
                            i5 = i7;
                        } else {
                            int i17 = i7;
                            iArr = iArr2;
                            int i18 = i8;
                            jArr[i14] = ((r10 & 127) << i15) | (j6 & (~(255 << i15)));
                            if (i9 == -1) {
                                i5 = i17;
                                i9 = ScatterMapKt.findEmptySlot(jArr, i18 + 1, i5);
                            } else {
                                i5 = i17;
                            }
                            iArr[i9] = iArr[findFirstAvailableSlot];
                            iArr[findFirstAvailableSlot] = iArr[i18];
                            iArr[i18] = iArr[i9];
                            objArr[i9] = objArr[findFirstAvailableSlot];
                            objArr[findFirstAvailableSlot] = objArr[i18];
                            objArr[i18] = objArr[i9];
                            i6 = i18 - 1;
                        }
                        c5 = 0;
                        jArr[ArraysKt.getLastIndex(jArr)] = (jArr[0] & 72057594037927935L) | Long.MIN_VALUE;
                        i8 = i6 + 1;
                        i7 = i5;
                        iArr2 = iArr;
                    }
                }
                i8++;
            }
        }
        initializeGrowth();
    }

    private final int findAbsoluteInsertIndex(int key) {
        int hashCode = Integer.hashCode(key) * (-862048943);
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
        this.keys = new int[max];
        this.values = new Object[max];
    }

    private final void resizeStorage(int newCapacity) {
        long[] jArr;
        MutableIntObjectMap<V> mutableIntObjectMap = this;
        long[] jArr2 = mutableIntObjectMap.metadata;
        int[] iArr = mutableIntObjectMap.keys;
        Object[] objArr = mutableIntObjectMap.values;
        int i5 = mutableIntObjectMap._capacity;
        initializeStorage(newCapacity);
        long[] jArr3 = mutableIntObjectMap.metadata;
        int[] iArr2 = mutableIntObjectMap.keys;
        Object[] objArr2 = mutableIntObjectMap.values;
        int i6 = mutableIntObjectMap._capacity;
        int i7 = 0;
        while (i7 < i5) {
            if (((jArr2[i7 >> 3] >> ((i7 & 7) << 3)) & 255) < 128) {
                int i8 = iArr[i7];
                int hashCode = Integer.hashCode(i8) * (-862048943);
                int i9 = hashCode ^ (hashCode << 16);
                int findFirstAvailableSlot = mutableIntObjectMap.findFirstAvailableSlot(i9 >>> 7);
                long j5 = i9 & 127;
                int i10 = findFirstAvailableSlot >> 3;
                int i11 = (findFirstAvailableSlot & 7) << 3;
                jArr = jArr2;
                long j6 = (jArr3[i10] & (~(255 << i11))) | (j5 << i11);
                jArr3[i10] = j6;
                jArr3[(((findFirstAvailableSlot - 7) & i6) + (i6 & 7)) >> 3] = j6;
                iArr2[findFirstAvailableSlot] = i8;
                objArr2[findFirstAvailableSlot] = objArr[i7];
            } else {
                jArr = jArr2;
            }
            i7++;
            mutableIntObjectMap = this;
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

    public final V put(int key, V value) {
        int findAbsoluteInsertIndex = findAbsoluteInsertIndex(key);
        Object[] objArr = this.values;
        V v5 = (V) objArr[findAbsoluteInsertIndex];
        this.keys[findAbsoluteInsertIndex] = key;
        objArr[findAbsoluteInsertIndex] = value;
        return v5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0061, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0063, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final V remove(int key) {
        int i5;
        int hashCode = Integer.hashCode(key) * (-862048943);
        int i6 = hashCode ^ (hashCode << 16);
        int i7 = i6 & 127;
        int i8 = this._capacity;
        int i9 = (i6 >>> 7) & i8;
        int i10 = 0;
        loop0: while (true) {
            long[] jArr = this.metadata;
            int i11 = i9 >> 3;
            int i12 = (i9 & 7) << 3;
            long j5 = ((jArr[i11 + 1] << (64 - i12)) & ((-i12) >> 63)) | (jArr[i11] >>> i12);
            long j6 = (i7 * 72340172838076673L) ^ j5;
            long j7 = (~j6) & (j6 - 72340172838076673L) & (-9187201950435737472L);
            while (true) {
                if (j7 == 0) {
                    break;
                }
                i5 = ((Long.numberOfTrailingZeros(j7) >> 3) + i9) & i8;
                if (this.keys[i5] == key) {
                    break loop0;
                }
                j7 &= j7 - 1;
            }
            i10 += 8;
            i9 = (i9 + i10) & i8;
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
        Object[] objArr = this.values;
        V v5 = (V) objArr[index];
        objArr[index] = null;
        return v5;
    }

    public final void set(int key, V value) {
        int findAbsoluteInsertIndex = findAbsoluteInsertIndex(key);
        this.keys[findAbsoluteInsertIndex] = key;
        this.values[findAbsoluteInsertIndex] = value;
    }

    public MutableIntObjectMap(int i5) {
        super(null);
        if (!(i5 >= 0)) {
            RuntimeHelpersKt.throwIllegalArgumentException("Capacity must be a positive value.");
        }
        initializeStorage(ScatterMapKt.unloadedCapacity(i5));
    }
}
