package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\fJ\u000f\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\fJ\u0017\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0016\u0010\u0006J \u0010\u0019\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0017H\u0086\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001c\u001a\u00020\u00072\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\fR\u0016\u0010\u001f\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Landroidx/collection/MutableObjectFloatMap;", "K", "Landroidx/collection/ObjectFloatMap;", BuildConfig.FLAVOR, "initialCapacity", "<init>", "(I)V", BuildConfig.FLAVOR, "initializeStorage", "capacity", "initializeMetadata", "initializeGrowth", "()V", "key", "findIndex", "(Ljava/lang/Object;)I", "hash1", "findFirstAvailableSlot", "(I)I", "adjustStorage", "dropDeletes", "newCapacity", "resizeStorage", BuildConfig.FLAVOR, "value", "set", "(Ljava/lang/Object;F)V", "from", "putAll", "(Landroidx/collection/ObjectFloatMap;)V", "clear", "growthLimit", "I", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableObjectFloatMap<K> extends ObjectFloatMap<K> {
    private int growthLimit;

    public /* synthetic */ MutableObjectFloatMap(int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
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
        float[] fArr = this.values;
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
                        jArr[ArraysKt.getLastIndex(jArr)] = (jArr[i8] & 72057594037927935L) | Long.MIN_VALUE;
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
                            fArr[findFirstAvailableSlot] = fArr[i17];
                            fArr[i17] = 0.0f;
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
                            fArr[i10] = fArr[findFirstAvailableSlot];
                            fArr[findFirstAvailableSlot] = fArr[i19];
                            fArr[i19] = fArr[i10];
                            i6 = i19 - 1;
                        }
                        i8 = 0;
                        jArr[ArraysKt.getLastIndex(jArr)] = (jArr[0] & 72057594037927935L) | Long.MIN_VALUE;
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

    private final int findIndex(K key) {
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
        this.values = new float[max];
    }

    private final void resizeStorage(int newCapacity) {
        int i5;
        long[] jArr = this.metadata;
        Object[] objArr = this.keys;
        float[] fArr = this.values;
        int i6 = this._capacity;
        initializeStorage(newCapacity);
        long[] jArr2 = this.metadata;
        Object[] objArr2 = this.keys;
        float[] fArr2 = this.values;
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
                objArr2[findFirstAvailableSlot] = obj;
                fArr2[findFirstAvailableSlot] = fArr[i5];
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
        ArraysKt.fill(this.keys, (Object) null, 0, this._capacity);
        initializeGrowth();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(ObjectFloatMap<K> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        Object[] objArr = from.keys;
        float[] fArr = from.values;
        long[] jArr = from.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i5 = 0;
        while (true) {
            long j5 = jArr[i5];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j5) < 128) {
                        int i8 = (i5 << 3) + i7;
                        set(objArr[i8], fArr[i8]);
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i5 == length) {
                return;
            } else {
                i5++;
            }
        }
    }

    public final void set(K key, float value) {
        int findIndex = findIndex(key);
        if (findIndex < 0) {
            findIndex = ~findIndex;
        }
        this.keys[findIndex] = key;
        this.values[findIndex] = value;
    }

    public MutableObjectFloatMap(int i5) {
        super(null);
        if (!(i5 >= 0)) {
            RuntimeHelpersKt.throwIllegalArgumentException("Capacity must be a positive value.");
        }
        initializeStorage(ScatterMapKt.unloadedCapacity(i5));
    }
}
