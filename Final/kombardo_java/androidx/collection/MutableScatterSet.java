package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u0012\n\u0002\u0010#\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u00010B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\u00020\u00132\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001a\u001a\u00020\u00132\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u001a\u0010\u001cJ\u001e\u0010\u0016\u001a\u00020\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0086\u0002¢\u0006\u0004\b\u0016\u0010\u001dJ\u001e\u0010\u0016\u001a\u00020\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002¢\u0006\u0004\b\u0016\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\u00132\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0004\b\u001f\u0010\u0015J\u0018\u0010 \u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b \u0010\u0017J\u0017\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\"\u0010\u0006J\r\u0010#\u001a\u00020\u0007¢\u0006\u0004\b#\u0010\fJ\u000f\u0010%\u001a\u00020\u0007H\u0000¢\u0006\u0004\b$\u0010\fJ\u000f\u0010'\u001a\u00020\u0007H\u0000¢\u0006\u0004\b&\u0010\fJ\u0017\u0010*\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0003H\u0000¢\u0006\u0004\b)\u0010\u0006J\u0013\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000+¢\u0006\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/¨\u00061"}, d2 = {"Landroidx/collection/MutableScatterSet;", "E", "Landroidx/collection/ScatterSet;", BuildConfig.FLAVOR, "initialCapacity", "<init>", "(I)V", BuildConfig.FLAVOR, "initializeStorage", "capacity", "initializeMetadata", "initializeGrowth", "()V", "element", "findAbsoluteInsertIndex", "(Ljava/lang/Object;)I", "hash1", "findFirstAvailableSlot", "(I)I", BuildConfig.FLAVOR, "add", "(Ljava/lang/Object;)Z", "plusAssign", "(Ljava/lang/Object;)V", BuildConfig.FLAVOR, "elements", "addAll", "(Ljava/lang/Iterable;)Z", "(Landroidx/collection/ScatterSet;)Z", "(Ljava/lang/Iterable;)V", "(Landroidx/collection/ScatterSet;)V", "remove", "minusAssign", "index", "removeElementAt", "clear", "adjustStorage$collection", "adjustStorage", "dropDeletes$collection", "dropDeletes", "newCapacity", "resizeStorage$collection", "resizeStorage", BuildConfig.FLAVOR, "asMutableSet", "()Ljava/util/Set;", "growthLimit", "I", "MutableSetWrapper", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableScatterSet<E> extends ScatterSet<E> {
    private int growthLimit;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010)\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0096\u0002J\u0015\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\bJ\u0016\u0010\u0011\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016J\u0016\u0010\u0012\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¨\u0006\u0013"}, d2 = {"Landroidx/collection/MutableScatterSet$MutableSetWrapper;", "Landroidx/collection/ScatterSet$SetWrapper;", "Landroidx/collection/ScatterSet;", BuildConfig.FLAVOR, "(Landroidx/collection/MutableScatterSet;)V", "add", BuildConfig.FLAVOR, "element", "(Ljava/lang/Object;)Z", "addAll", "elements", BuildConfig.FLAVOR, "clear", BuildConfig.FLAVOR, "iterator", BuildConfig.FLAVOR, "remove", "removeAll", "retainAll", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    private final class MutableSetWrapper extends ScatterSet<E>.SetWrapper implements Set<E>, KMutableSet {
        public MutableSetWrapper() {
            super();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(E element) {
            return MutableScatterSet.this.add(element);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends E> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            return MutableScatterSet.this.addAll(elements);
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            MutableScatterSet.this.clear();
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return new MutableScatterSet$MutableSetWrapper$iterator$1(MutableScatterSet.this);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object element) {
            return MutableScatterSet.this.remove(element);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<? extends Object> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            int i5 = MutableScatterSet.this.get_size();
            Iterator<? extends Object> it = elements.iterator();
            while (it.hasNext()) {
                MutableScatterSet.this.minusAssign(it.next());
            }
            return i5 != MutableScatterSet.this.get_size();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<? extends Object> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            MutableScatterSet<E> mutableScatterSet = MutableScatterSet.this;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            boolean z5 = false;
            if (length >= 0) {
                int i5 = 0;
                boolean z6 = false;
                while (true) {
                    long j5 = jArr[i5];
                    if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i6 = 8 - ((~(i5 - length)) >>> 31);
                        for (int i7 = 0; i7 < i6; i7++) {
                            if ((255 & j5) < 128) {
                                int i8 = (i5 << 3) + i7;
                                if (!elements.contains(mutableScatterSet.elements[i8])) {
                                    mutableScatterSet.removeElementAt(i8);
                                    z6 = true;
                                }
                            }
                            j5 >>= 8;
                        }
                        if (i6 != 8) {
                            return z6;
                        }
                    }
                    if (i5 == length) {
                        z5 = z6;
                        break;
                    }
                    i5++;
                }
            }
            return z5;
        }
    }

    public MutableScatterSet(int i5) {
        super(null);
        if (!(i5 >= 0)) {
            RuntimeHelpersKt.throwIllegalArgumentException("Capacity must be a positive value.");
        }
        initializeStorage(ScatterMapKt.unloadedCapacity(i5));
    }

    private final int findAbsoluteInsertIndex(E element) {
        int hashCode = (element != null ? element.hashCode() : 0) * (-862048943);
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
                if (Intrinsics.areEqual(this.elements[numberOfTrailingZeros], element)) {
                    return numberOfTrailingZeros;
                }
            }
            if ((((~j5) << 6) & j5 & (-9187201950435737472L)) != 0) {
                int findFirstAvailableSlot = findFirstAvailableSlot(i6);
                if (this.growthLimit == 0 && ((this.metadata[findFirstAvailableSlot >> 3] >> ((findFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage$collection();
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
            i10 += 8;
            i9 = (i9 + i10) & i8;
            i7 = i13;
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
        this.elements = new Object[max];
    }

    public final boolean add(E element) {
        int i5 = get_size();
        this.elements[findAbsoluteInsertIndex(element)] = element;
        return get_size() != i5;
    }

    public final boolean addAll(Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i5 = get_size();
        plusAssign((Iterable) elements);
        return i5 != get_size();
    }

    public final void adjustStorage$collection() {
        if (this._capacity <= 8 || Long.compareUnsigned(ULong.m3622constructorimpl(ULong.m3622constructorimpl(this._size) * 32), ULong.m3622constructorimpl(ULong.m3622constructorimpl(this._capacity) * 25)) > 0) {
            resizeStorage$collection(ScatterMapKt.nextCapacity(this._capacity));
        } else {
            dropDeletes$collection();
        }
    }

    public final Set<E> asMutableSet() {
        return new MutableSetWrapper();
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
        ArraysKt.fill(this.elements, (Object) null, 0, this._capacity);
        initializeGrowth();
    }

    public final void dropDeletes$collection() {
        int i5;
        long[] jArr = this.metadata;
        int i6 = this._capacity;
        Object[] objArr = this.elements;
        ScatterMapKt.convertMetadataForCleanup(jArr, i6);
        int i7 = 0;
        int i8 = 0;
        int i9 = -1;
        while (i8 != i6) {
            int i10 = i8 >> 3;
            int i11 = (i8 & 7) << 3;
            long j5 = (jArr[i10] >> i11) & 255;
            if (j5 == 128) {
                i9 = i8;
                i8++;
            } else {
                if (j5 == 254) {
                    Object obj = objArr[i8];
                    int hashCode = (obj != null ? obj.hashCode() : i7) * (-862048943);
                    int i12 = (hashCode ^ (hashCode << 16)) >>> 7;
                    int findFirstAvailableSlot = findFirstAvailableSlot(i12);
                    int i13 = i12 & i6;
                    if (((findFirstAvailableSlot - i13) & i6) / 8 == ((i8 - i13) & i6) / 8) {
                        jArr[i10] = ((r9 & 127) << i11) | ((~(255 << i11)) & jArr[i10]);
                        jArr[ArraysKt.getLastIndex(jArr)] = (jArr[i7] & 72057594037927935L) | Long.MIN_VALUE;
                    } else {
                        int i14 = findFirstAvailableSlot >> 3;
                        long j6 = jArr[i14];
                        int i15 = (findFirstAvailableSlot & 7) << 3;
                        if (((j6 >> i15) & 255) == 128) {
                            int i16 = i8;
                            jArr[i14] = ((r9 & 127) << i15) | (j6 & (~(255 << i15)));
                            jArr[i10] = (jArr[i10] & (~(255 << i11))) | (128 << i11);
                            objArr[findFirstAvailableSlot] = objArr[i16];
                            objArr[i16] = null;
                            i5 = i16;
                            i9 = i5;
                        } else {
                            int i17 = i8;
                            jArr[i14] = ((r9 & 127) << i15) | (j6 & (~(255 << i15)));
                            if (i9 == -1) {
                                i9 = ScatterMapKt.findEmptySlot(jArr, i17 + 1, i6);
                            }
                            objArr[i9] = objArr[findFirstAvailableSlot];
                            objArr[findFirstAvailableSlot] = objArr[i17];
                            objArr[i17] = objArr[i9];
                            i5 = i17 - 1;
                        }
                        jArr[ArraysKt.getLastIndex(jArr)] = (jArr[0] & 72057594037927935L) | Long.MIN_VALUE;
                        i8 = i5 + 1;
                        i7 = 0;
                    }
                }
                i8++;
            }
        }
        initializeGrowth();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0069, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006b, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void minusAssign(E element) {
        int i5;
        int i6 = 0;
        int hashCode = (element != null ? element.hashCode() : 0) * (-862048943);
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
                if (Intrinsics.areEqual(this.elements[i5], element)) {
                    break loop0;
                } else {
                    j7 &= j7 - 1;
                }
            }
            i6 += 8;
            i10 = i11 + i6;
        }
        if (i5 >= 0) {
            removeElementAt(i5);
        }
    }

    public final void plusAssign(E element) {
        this.elements[findAbsoluteInsertIndex(element)] = element;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006e, code lost:
    
        if (((r7 & ((~r7) << 6)) & (-9187201950435737472L)) == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0070, code lost:
    
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean remove(E element) {
        int i5;
        int hashCode = (element != null ? element.hashCode() : 0) * (-862048943);
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
                if (Intrinsics.areEqual(this.elements[i5], element)) {
                    break loop0;
                }
                j7 &= j7 - 1;
            }
            i10 += 8;
            i9 = (i9 + i10) & i8;
        }
        boolean z5 = i5 >= 0;
        if (z5) {
            removeElementAt(i5);
        }
        return z5;
    }

    public final void removeElementAt(int index) {
        this._size--;
        long[] jArr = this.metadata;
        int i5 = this._capacity;
        int i6 = index >> 3;
        int i7 = (index & 7) << 3;
        long j5 = (jArr[i6] & (~(255 << i7))) | (254 << i7);
        jArr[i6] = j5;
        jArr[(((index - 7) & i5) + (i5 & 7)) >> 3] = j5;
        this.elements[index] = null;
    }

    public final void resizeStorage$collection(int newCapacity) {
        long[] jArr = this.metadata;
        Object[] objArr = this.elements;
        int i5 = this._capacity;
        initializeStorage(newCapacity);
        long[] jArr2 = this.metadata;
        Object[] objArr2 = this.elements;
        int i6 = this._capacity;
        for (int i7 = 0; i7 < i5; i7++) {
            if (((jArr[i7 >> 3] >> ((i7 & 7) << 3)) & 255) < 128) {
                Object obj = objArr[i7];
                int hashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
                int i8 = hashCode ^ (hashCode << 16);
                int findFirstAvailableSlot = findFirstAvailableSlot(i8 >>> 7);
                long j5 = i8 & 127;
                int i9 = findFirstAvailableSlot >> 3;
                int i10 = (findFirstAvailableSlot & 7) << 3;
                long j6 = (jArr2[i9] & (~(255 << i10))) | (j5 << i10);
                jArr2[i9] = j6;
                jArr2[(((findFirstAvailableSlot - 7) & i6) + (i6 & 7)) >> 3] = j6;
                objArr2[findFirstAvailableSlot] = obj;
            }
        }
    }

    public final void plusAssign(Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            plusAssign((MutableScatterSet<E>) it.next());
        }
    }

    public final boolean addAll(ScatterSet<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i5 = get_size();
        plusAssign((ScatterSet) elements);
        return i5 != get_size();
    }

    public /* synthetic */ MutableScatterSet(int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 6 : i5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(ScatterSet<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = elements.elements;
        long[] jArr = elements.metadata;
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
                        plusAssign((MutableScatterSet<E>) objArr[(i5 << 3) + i7]);
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
}
