package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\u001a\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\n\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u00020\u00188\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u0012\u0004\b\u001b\u0010\u0004R\u001c\u0010\u001d\u001a\u00020\u001c8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u0012\u0004\b\u001f\u0010\u0004R$\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020 8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b!\u0010\"\u0012\u0004\b#\u0010\u0004R\u001c\u0010$\u001a\u00020\t8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b$\u0010%\u0012\u0004\b&\u0010\u0004R\u001c\u0010'\u001a\u00020\t8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b'\u0010%\u0012\u0004\b(\u0010\u0004R\u0011\u0010*\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b)\u0010\u0011R\u0011\u0010,\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b+\u0010\u0011\u0082\u0001\u0001-¨\u0006."}, d2 = {"Landroidx/collection/IntObjectMap;", "V", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "isEmpty", "()Z", "isNotEmpty", BuildConfig.FLAVOR, "key", "get", "(I)Ljava/lang/Object;", "contains", "(I)Z", "containsKey", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "metadata", "[J", "getMetadata$annotations", BuildConfig.FLAVOR, "keys", "[I", "getKeys$annotations", BuildConfig.FLAVOR, "values", "[Ljava/lang/Object;", "getValues$annotations", "_capacity", "I", "get_capacity$collection$annotations", "_size", "get_size$collection$annotations", "getCapacity", "capacity", "getSize", "size", "Landroidx/collection/MutableIntObjectMap;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class IntObjectMap<V> {
    public int _capacity;
    public int _size;
    public int[] keys;
    public long[] metadata;
    public Object[] values;

    public /* synthetic */ IntObjectMap(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0067, code lost:
    
        if (((r6 & ((~r6) << 6)) & (-9187201950435737472L)) == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0069, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean contains(int key) {
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
        return i5 >= 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0067, code lost:
    
        if (((r6 & ((~r6) << 6)) & (-9187201950435737472L)) == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0069, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean containsKey(int key) {
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
        return i5 >= 0;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof IntObjectMap)) {
            return false;
        }
        IntObjectMap intObjectMap = (IntObjectMap) other;
        if (intObjectMap.get_size() != get_size()) {
            return false;
        }
        int[] iArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            loop0: while (true) {
                long j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j5) < 128) {
                            int i8 = (i5 << 3) + i7;
                            int i9 = iArr[i8];
                            Object obj = objArr[i8];
                            if (obj == null) {
                                if (intObjectMap.get(i9) != null || !intObjectMap.containsKey(i9)) {
                                    break loop0;
                                }
                            } else if (!Intrinsics.areEqual(obj, intObjectMap.get(i9))) {
                                return false;
                            }
                        }
                        j5 >>= 8;
                    }
                    if (i6 != 8) {
                        break;
                    }
                }
                if (i5 == length) {
                    break;
                }
                i5++;
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0061, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0063, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final V get(int key) {
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
            return (V) this.values[i5];
        }
        return null;
    }

    /* renamed from: getCapacity, reason: from getter */
    public final int get_capacity() {
        return this._capacity;
    }

    /* renamed from: getSize, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    public int hashCode() {
        int[] iArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        int i5 = 0;
        if (length >= 0) {
            int i6 = 0;
            int i7 = 0;
            while (true) {
                long j5 = jArr[i6];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i8 = 8 - ((~(i6 - length)) >>> 31);
                    for (int i9 = 0; i9 < i8; i9++) {
                        if ((255 & j5) < 128) {
                            int i10 = (i6 << 3) + i9;
                            int i11 = iArr[i10];
                            Object obj = objArr[i10];
                            i7 += (obj != null ? obj.hashCode() : 0) ^ Integer.hashCode(i11);
                        }
                        j5 >>= 8;
                    }
                    if (i8 != 8) {
                        return i7;
                    }
                }
                if (i6 == length) {
                    i5 = i7;
                    break;
                }
                i6++;
            }
        }
        return i5;
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        int[] iArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            int i6 = 0;
            while (true) {
                long j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i7 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i8 = 0; i8 < i7; i8++) {
                        if ((255 & j5) < 128) {
                            int i9 = (i5 << 3) + i8;
                            int i10 = iArr[i9];
                            Object obj = objArr[i9];
                            sb.append(i10);
                            sb.append("=");
                            if (obj == this) {
                                obj = "(this)";
                            }
                            sb.append(obj);
                            i6++;
                            if (i6 < this._size) {
                                sb.append(',');
                                sb.append(' ');
                            }
                        }
                        j5 >>= 8;
                    }
                    if (i7 != 8) {
                        break;
                    }
                }
                if (i5 == length) {
                    break;
                }
                i5++;
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "s.append('}').toString()");
        return sb2;
    }

    private IntObjectMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = IntSetKt.getEmptyIntArray();
        this.values = ContainerHelpersKt.EMPTY_OBJECTS;
    }
}
