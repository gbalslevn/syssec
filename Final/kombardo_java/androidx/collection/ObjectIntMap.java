package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0011J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\u0019\u0010\fR\u001c\u0010\u001b\u001a\u00020\u001a8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u0012\u0004\b\u001d\u0010\u0004R$\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001e8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b\u001f\u0010 \u0012\u0004\b!\u0010\u0004R\u001c\u0010#\u001a\u00020\"8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b#\u0010$\u0012\u0004\b%\u0010\u0004R\u001c\u0010&\u001a\u00020\n8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b&\u0010'\u0012\u0004\b(\u0010\u0004R\u001c\u0010)\u001a\u00020\n8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b)\u0010'\u0012\u0004\b*\u0010\u0004R\u0011\u0010,\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b+\u0010\u0013R\u0011\u0010.\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b-\u0010\u0013\u0082\u0001\u0001/¨\u00060"}, d2 = {"Landroidx/collection/ObjectIntMap;", "K", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "isEmpty", "()Z", "isNotEmpty", "key", BuildConfig.FLAVOR, "get", "(Ljava/lang/Object;)I", "defaultValue", "getOrDefault", "(Ljava/lang/Object;I)I", "contains", "(Ljava/lang/Object;)Z", "hashCode", "()I", "other", "equals", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "findKeyIndex", BuildConfig.FLAVOR, "metadata", "[J", "getMetadata$annotations", BuildConfig.FLAVOR, "keys", "[Ljava/lang/Object;", "getKeys$annotations", BuildConfig.FLAVOR, "values", "[I", "getValues$annotations", "_capacity", "I", "get_capacity$collection$annotations", "_size", "get_size$collection$annotations", "getCapacity", "capacity", "getSize", "size", "Landroidx/collection/MutableObjectIntMap;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ObjectIntMap<K> {
    public int _capacity;
    public int _size;
    public Object[] keys;
    public long[] metadata;
    public int[] values;

    public /* synthetic */ ObjectIntMap(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final boolean contains(K key) {
        return findKeyIndex(key) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ObjectIntMap)) {
            return false;
        }
        ObjectIntMap objectIntMap = (ObjectIntMap) other;
        if (objectIntMap.get_size() != get_size()) {
            return false;
        }
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j5) < 128) {
                            int i8 = (i5 << 3) + i7;
                            if (iArr[i8] != objectIntMap.get(objArr[i8])) {
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
        }
        return true;
    }

    public final int findKeyIndex(K key) {
        int i5 = 0;
        int hashCode = (key != null ? key.hashCode() : 0) * (-862048943);
        int i6 = hashCode ^ (hashCode << 16);
        int i7 = i6 & 127;
        int i8 = this._capacity;
        int i9 = i6 >>> 7;
        while (true) {
            int i10 = i9 & i8;
            long[] jArr = this.metadata;
            int i11 = i10 >> 3;
            int i12 = (i10 & 7) << 3;
            long j5 = ((jArr[i11 + 1] << (64 - i12)) & ((-i12) >> 63)) | (jArr[i11] >>> i12);
            long j6 = (i7 * 72340172838076673L) ^ j5;
            for (long j7 = (~j6) & (j6 - 72340172838076673L) & (-9187201950435737472L); j7 != 0; j7 &= j7 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j7) >> 3) + i10) & i8;
                if (Intrinsics.areEqual(this.keys[numberOfTrailingZeros], key)) {
                    return numberOfTrailingZeros;
                }
            }
            if ((j5 & ((~j5) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i5 += 8;
            i9 = i10 + i5;
        }
    }

    public final int get(K key) {
        int findKeyIndex = findKeyIndex(key);
        if (findKeyIndex >= 0) {
            return this.values[findKeyIndex];
        }
        throw new NoSuchElementException("There is no key " + key + " in the map");
    }

    /* renamed from: getCapacity, reason: from getter */
    public final int get_capacity() {
        return this._capacity;
    }

    public final int getOrDefault(K key, int defaultValue) {
        int findKeyIndex = findKeyIndex(key);
        return findKeyIndex >= 0 ? this.values[findKeyIndex] : defaultValue;
    }

    /* renamed from: getSize, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    public int hashCode() {
        Object[] objArr = this.keys;
        int[] iArr = this.values;
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
                            Object obj = objArr[i10];
                            i7 += Integer.hashCode(iArr[i10]) ^ (obj != null ? obj.hashCode() : 0);
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
        Object[] objArr = this.keys;
        int[] iArr = this.values;
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
                            Object obj = objArr[i9];
                            int i10 = iArr[i9];
                            if (obj == this) {
                                obj = "(this)";
                            }
                            sb.append(obj);
                            sb.append("=");
                            sb.append(i10);
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

    private ObjectIntMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = ContainerHelpersKt.EMPTY_OBJECTS;
        this.values = IntSetKt.getEmptyIntArray();
    }
}
