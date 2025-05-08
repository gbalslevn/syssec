package androidx.compose.ui.text.caches;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0013\b\u0017\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0013\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\u00028\u00012\u0006\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0017J\r\u0010\u0019\u001a\u00020\u000e¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001c\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u001f\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u001f\u0010\u0010J\u000f\u0010 \u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010\rJ\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u001e\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\"\u0010*\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u0007¨\u0006."}, d2 = {"Landroidx/compose/ui/text/caches/SimpleArrayMap;", "K", "V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "capacity", "<init>", "(I)V", "key", "hash", "indexOf", "(Ljava/lang/Object;I)I", "indexOfNull", "()I", BuildConfig.FLAVOR, "containsKey", "(Ljava/lang/Object;)Z", "indexOfKey", "(Ljava/lang/Object;)I", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "index", "keyAt", "(I)Ljava/lang/Object;", "valueAt", "isEmpty", "()Z", "value", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "other", "equals", "hashCode", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashes", "[I", BuildConfig.FLAVOR, "keyValues", "[Ljava/lang/Object;", "_size", "I", "get_size", "set_size", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SimpleArrayMap<K, V> {
    private int _size;
    private int[] hashes;
    private Object[] keyValues;

    public SimpleArrayMap(int i5) {
        if (i5 == 0) {
            this.hashes = ContainerHelpersKt.EMPTY_INTS;
            this.keyValues = ContainerHelpersKt.EMPTY_OBJECTS;
        } else {
            this.hashes = new int[i5];
            this.keyValues = new Object[i5 << 1];
        }
        this._size = 0;
    }

    public final boolean containsKey(K key) {
        return indexOfKey(key) >= 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        try {
            if (other instanceof SimpleArrayMap) {
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) other;
                int i5 = this._size;
                if (i5 != simpleArrayMap._size) {
                    return false;
                }
                for (int i6 = 0; i6 < i5; i6++) {
                    K keyAt = keyAt(i6);
                    V valueAt = valueAt(i6);
                    Object obj = simpleArrayMap.get(keyAt);
                    if (valueAt == null) {
                        if (obj != null || !simpleArrayMap.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!Intrinsics.areEqual(valueAt, obj)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(other instanceof Map) || this._size != ((Map) other).size()) {
                return false;
            }
            int i7 = this._size;
            for (int i8 = 0; i8 < i7; i8++) {
                K keyAt2 = keyAt(i8);
                V valueAt2 = valueAt(i8);
                Object obj2 = ((Map) other).get(keyAt2);
                if (valueAt2 == null) {
                    if (obj2 != null || !((Map) other).containsKey(keyAt2)) {
                        return false;
                    }
                } else if (!Intrinsics.areEqual(valueAt2, obj2)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public final V get(K key) {
        int indexOfKey = indexOfKey(key);
        if (indexOfKey >= 0) {
            return (V) this.keyValues[(indexOfKey << 1) + 1];
        }
        return null;
    }

    public int hashCode() {
        int[] iArr = this.hashes;
        Object[] objArr = this.keyValues;
        int i5 = this._size;
        int i6 = 1;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i5) {
            Object obj = objArr[i6];
            i8 += (obj != null ? obj.hashCode() : 0) ^ iArr[i7];
            i7++;
            i6 += 2;
        }
        return i8;
    }

    protected final int indexOf(Object key, int hash) {
        int i5 = this._size;
        if (i5 == 0) {
            return -1;
        }
        int binarySearchInternal = ContainerHelpersKt.binarySearchInternal(this.hashes, i5, hash);
        if (binarySearchInternal < 0 || Intrinsics.areEqual(key, this.keyValues[binarySearchInternal << 1])) {
            return binarySearchInternal;
        }
        int i6 = binarySearchInternal + 1;
        while (i6 < i5 && this.hashes[i6] == hash) {
            if (Intrinsics.areEqual(key, this.keyValues[i6 << 1])) {
                return i6;
            }
            i6++;
        }
        for (int i7 = binarySearchInternal - 1; i7 >= 0 && this.hashes[i7] == hash; i7--) {
            if (Intrinsics.areEqual(key, this.keyValues[i7 << 1])) {
                return i7;
            }
        }
        return ~i6;
    }

    public final int indexOfKey(Object key) {
        return key == null ? indexOfNull() : indexOf(key, key.hashCode());
    }

    protected final int indexOfNull() {
        int i5 = this._size;
        if (i5 == 0) {
            return -1;
        }
        int binarySearchInternal = ContainerHelpersKt.binarySearchInternal(this.hashes, i5, 0);
        if (binarySearchInternal < 0 || this.keyValues[binarySearchInternal << 1] == null) {
            return binarySearchInternal;
        }
        int i6 = binarySearchInternal + 1;
        while (i6 < i5 && this.hashes[i6] == 0) {
            if (this.keyValues[i6 << 1] == null) {
                return i6;
            }
            i6++;
        }
        for (int i7 = binarySearchInternal - 1; i7 >= 0 && this.hashes[i7] == 0; i7--) {
            if (this.keyValues[i7 << 1] == null) {
                return i7;
            }
        }
        return ~i6;
    }

    public final boolean isEmpty() {
        return this._size <= 0;
    }

    public final K keyAt(int index) {
        return (K) this.keyValues[index << 1];
    }

    public final V put(K key, V value) {
        int hashCode;
        int indexOf;
        int i5 = this._size;
        if (key == null) {
            indexOf = indexOfNull();
            hashCode = 0;
        } else {
            hashCode = key.hashCode();
            indexOf = indexOf(key, hashCode);
        }
        if (indexOf >= 0) {
            int i6 = (indexOf << 1) + 1;
            Object[] objArr = this.keyValues;
            V v5 = (V) objArr[i6];
            objArr[i6] = value;
            return v5;
        }
        int i7 = ~indexOf;
        int[] iArr = this.hashes;
        if (i5 >= iArr.length) {
            int i8 = 8;
            if (i5 >= 8) {
                i8 = (i5 >> 1) + i5;
            } else if (i5 < 4) {
                i8 = 4;
            }
            int[] copyOf = Arrays.copyOf(iArr, i8);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.hashes = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.keyValues, i8 << 1);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
            this.keyValues = copyOf2;
            if (i5 != this._size) {
                throw new ConcurrentModificationException();
            }
        }
        if (i7 < i5) {
            int[] iArr2 = this.hashes;
            int i9 = i7 + 1;
            ArraysKt.copyInto(iArr2, iArr2, i9, i7, i5);
            Object[] objArr2 = this.keyValues;
            ArraysKt.copyInto(objArr2, objArr2, i9 << 1, i7 << 1, this._size << 1);
        }
        int i10 = this._size;
        if (i5 == i10) {
            int[] iArr3 = this.hashes;
            if (i7 < iArr3.length) {
                iArr3[i7] = hashCode;
                Object[] objArr3 = this.keyValues;
                int i11 = i7 << 1;
                objArr3[i11] = key;
                objArr3[i11 + 1] = value;
                this._size = i10 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this._size * 28);
        sb.append('{');
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            K keyAt = keyAt(i6);
            if (keyAt != this) {
                sb.append(keyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V valueAt = valueAt(i6);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public final V valueAt(int index) {
        return (V) this.keyValues[(index << 1) + 1];
    }

    public /* synthetic */ SimpleArrayMap(int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 0 : i5);
    }
}
