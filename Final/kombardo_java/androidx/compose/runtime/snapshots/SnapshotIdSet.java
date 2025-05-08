package androidx.compose.runtime.snapshots;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B+\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0000¢\u0006\u0004\b\u0015\u0010\u0014J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001fR\u0014\u0010\u0005\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010 R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010!¨\u0006#"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "upperSet", "lowerSet", "lowerBound", BuildConfig.FLAVOR, "belowBound", "<init>", "(JJI[I)V", "bit", BuildConfig.FLAVOR, "get", "(I)Z", "set", "(I)Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "clear", "bits", "andNot", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "or", BuildConfig.FLAVOR, "iterator", "()Ljava/util/Iterator;", "default", "lowest", "(I)I", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "J", "I", "[I", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapshotIdSet implements Iterable<Integer>, KMappedMarker {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SnapshotIdSet EMPTY = new SnapshotIdSet(0, 0, 0, null);
    private final int[] belowBound;
    private final int lowerBound;
    private final long lowerSet;
    private final long upperSet;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet$Companion;", BuildConfig.FLAVOR, "()V", "EMPTY", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "getEMPTY", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SnapshotIdSet getEMPTY() {
            return SnapshotIdSet.EMPTY;
        }

        private Companion() {
        }
    }

    private SnapshotIdSet(long j5, long j6, int i5, int[] iArr) {
        this.upperSet = j5;
        this.lowerSet = j6;
        this.lowerBound = i5;
        this.belowBound = iArr;
    }

    public final SnapshotIdSet andNot(SnapshotIdSet bits) {
        SnapshotIdSet snapshotIdSet;
        SnapshotIdSet snapshotIdSet2 = EMPTY;
        if (bits == snapshotIdSet2) {
            return this;
        }
        if (this == snapshotIdSet2) {
            return snapshotIdSet2;
        }
        int i5 = bits.lowerBound;
        int i6 = this.lowerBound;
        if (i5 == i6) {
            int[] iArr = bits.belowBound;
            int[] iArr2 = this.belowBound;
            if (iArr == iArr2) {
                return new SnapshotIdSet(this.upperSet & (~bits.upperSet), this.lowerSet & (~bits.lowerSet), i6, iArr2);
            }
        }
        int[] iArr3 = bits.belowBound;
        if (iArr3 != null) {
            snapshotIdSet = this;
            for (int i7 : iArr3) {
                snapshotIdSet = snapshotIdSet.clear(i7);
            }
        } else {
            snapshotIdSet = this;
        }
        if (bits.lowerSet != 0) {
            for (int i8 = 0; i8 < 64; i8++) {
                if ((bits.lowerSet & (1 << i8)) != 0) {
                    snapshotIdSet = snapshotIdSet.clear(bits.lowerBound + i8);
                }
            }
        }
        if (bits.upperSet != 0) {
            for (int i9 = 0; i9 < 64; i9++) {
                if ((bits.upperSet & (1 << i9)) != 0) {
                    snapshotIdSet = snapshotIdSet.clear(i9 + 64 + bits.lowerBound);
                }
            }
        }
        return snapshotIdSet;
    }

    public final SnapshotIdSet clear(int bit) {
        int[] iArr;
        int binarySearch;
        int i5 = this.lowerBound;
        int i6 = bit - i5;
        if (i6 >= 0 && i6 < 64) {
            long j5 = 1 << i6;
            long j6 = this.lowerSet;
            if ((j6 & j5) != 0) {
                return new SnapshotIdSet(this.upperSet, j6 & (~j5), i5, this.belowBound);
            }
        } else if (i6 >= 64 && i6 < 128) {
            long j7 = 1 << (i6 - 64);
            long j8 = this.upperSet;
            if ((j8 & j7) != 0) {
                return new SnapshotIdSet(j8 & (~j7), this.lowerSet, i5, this.belowBound);
            }
        } else if (i6 < 0 && (iArr = this.belowBound) != null && (binarySearch = SnapshotIdSetKt.binarySearch(iArr, bit)) >= 0) {
            int length = iArr.length;
            int i7 = length - 1;
            if (i7 == 0) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, null);
            }
            int[] iArr2 = new int[i7];
            if (binarySearch > 0) {
                ArraysKt.copyInto(iArr, iArr2, 0, 0, binarySearch);
            }
            if (binarySearch < i7) {
                ArraysKt.copyInto(iArr, iArr2, binarySearch, binarySearch + 1, length);
            }
            return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, iArr2);
        }
        return this;
    }

    public final boolean get(int bit) {
        int[] iArr;
        int i5 = bit - this.lowerBound;
        if (i5 >= 0 && i5 < 64) {
            return ((1 << i5) & this.lowerSet) != 0;
        }
        if (i5 >= 64 && i5 < 128) {
            return ((1 << (i5 - 64)) & this.upperSet) != 0;
        }
        if (i5 <= 0 && (iArr = this.belowBound) != null) {
            return SnapshotIdSetKt.binarySearch(iArr, bit) >= 0;
        }
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<Integer> iterator() {
        return SequencesKt.sequence(new SnapshotIdSet$iterator$1(this, null)).iterator();
    }

    public final int lowest(int r6) {
        int[] iArr = this.belowBound;
        if (iArr != null) {
            return iArr[0];
        }
        long j5 = this.lowerSet;
        if (j5 != 0) {
            return this.lowerBound + Long.numberOfTrailingZeros(j5);
        }
        long j6 = this.upperSet;
        return j6 != 0 ? this.lowerBound + 64 + Long.numberOfTrailingZeros(j6) : r6;
    }

    public final SnapshotIdSet or(SnapshotIdSet bits) {
        SnapshotIdSet snapshotIdSet;
        SnapshotIdSet snapshotIdSet2 = EMPTY;
        if (bits == snapshotIdSet2) {
            return this;
        }
        if (this == snapshotIdSet2) {
            return bits;
        }
        int i5 = bits.lowerBound;
        int i6 = this.lowerBound;
        if (i5 == i6) {
            int[] iArr = bits.belowBound;
            int[] iArr2 = this.belowBound;
            if (iArr == iArr2) {
                return new SnapshotIdSet(this.upperSet | bits.upperSet, this.lowerSet | bits.lowerSet, i6, iArr2);
            }
        }
        int i7 = 0;
        if (this.belowBound == null) {
            int[] iArr3 = this.belowBound;
            if (iArr3 != null) {
                for (int i8 : iArr3) {
                    bits = bits.set(i8);
                }
            }
            if (this.lowerSet != 0) {
                for (int i9 = 0; i9 < 64; i9++) {
                    if ((this.lowerSet & (1 << i9)) != 0) {
                        bits = bits.set(this.lowerBound + i9);
                    }
                }
            }
            if (this.upperSet != 0) {
                while (i7 < 64) {
                    if ((this.upperSet & (1 << i7)) != 0) {
                        bits = bits.set(i7 + 64 + this.lowerBound);
                    }
                    i7++;
                }
            }
            return bits;
        }
        int[] iArr4 = bits.belowBound;
        if (iArr4 != null) {
            snapshotIdSet = this;
            for (int i10 : iArr4) {
                snapshotIdSet = snapshotIdSet.set(i10);
            }
        } else {
            snapshotIdSet = this;
        }
        if (bits.lowerSet != 0) {
            for (int i11 = 0; i11 < 64; i11++) {
                if ((bits.lowerSet & (1 << i11)) != 0) {
                    snapshotIdSet = snapshotIdSet.set(bits.lowerBound + i11);
                }
            }
        }
        if (bits.upperSet != 0) {
            while (i7 < 64) {
                if ((bits.upperSet & (1 << i7)) != 0) {
                    snapshotIdSet = snapshotIdSet.set(i7 + 64 + bits.lowerBound);
                }
                i7++;
            }
        }
        return snapshotIdSet;
    }

    public final SnapshotIdSet set(int bit) {
        int i5;
        int[] iArr;
        int i6 = this.lowerBound;
        int i7 = bit - i6;
        long j5 = 0;
        if (i7 >= 0 && i7 < 64) {
            long j6 = 1 << i7;
            long j7 = this.lowerSet;
            if ((j7 & j6) == 0) {
                return new SnapshotIdSet(this.upperSet, j7 | j6, i6, this.belowBound);
            }
        } else if (i7 >= 64 && i7 < 128) {
            long j8 = 1 << (i7 - 64);
            long j9 = this.upperSet;
            if ((j9 & j8) == 0) {
                return new SnapshotIdSet(j9 | j8, this.lowerSet, i6, this.belowBound);
            }
        } else if (i7 < 128) {
            int[] iArr2 = this.belowBound;
            if (iArr2 == null) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, i6, new int[]{bit});
            }
            int binarySearch = SnapshotIdSetKt.binarySearch(iArr2, bit);
            if (binarySearch < 0) {
                int i8 = -(binarySearch + 1);
                int length = iArr2.length;
                int[] iArr3 = new int[length + 1];
                ArraysKt.copyInto(iArr2, iArr3, 0, 0, i8);
                ArraysKt.copyInto(iArr2, iArr3, i8 + 1, i8, length);
                iArr3[i8] = bit;
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, iArr3);
            }
        } else if (!get(bit)) {
            long j10 = this.upperSet;
            long j11 = this.lowerSet;
            int i9 = this.lowerBound;
            int i10 = ((bit + 1) / 64) * 64;
            ArrayList arrayList = null;
            long j12 = j11;
            long j13 = j10;
            while (true) {
                if (i9 >= i10) {
                    i5 = i9;
                    break;
                }
                if (j12 != j5) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        int[] iArr4 = this.belowBound;
                        if (iArr4 != null) {
                            for (int i11 : iArr4) {
                                arrayList.add(Integer.valueOf(i11));
                            }
                        }
                    }
                    for (int i12 = 0; i12 < 64; i12++) {
                        if (((1 << i12) & j12) != 0) {
                            arrayList.add(Integer.valueOf(i12 + i9));
                        }
                    }
                    j5 = 0;
                }
                if (j13 == j5) {
                    i5 = i10;
                    j12 = j5;
                    break;
                }
                i9 += 64;
                j12 = j13;
                j13 = j5;
            }
            if (arrayList == null || (iArr = CollectionsKt.toIntArray(arrayList)) == null) {
                iArr = this.belowBound;
            }
            return new SnapshotIdSet(j13, j12, i5, iArr).set(bit);
        }
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" [");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(this, 10));
        Iterator<Integer> it = iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(it.next().intValue()));
        }
        sb.append(ListUtilsKt.fastJoinToString$default(arrayList, null, null, null, 0, null, null, 63, null));
        sb.append(']');
        return sb.toString();
    }
}
