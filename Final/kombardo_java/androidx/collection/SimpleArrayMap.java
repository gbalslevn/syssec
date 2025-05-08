package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0007J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00028\u0001H\u0001¢\u0006\u0004\b\u0019\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u001b\u0010\u0015J\u001a\u0010\u001c\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u001f\u001a\u00028\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001e\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00028\u00012\u0006\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b$\u0010#J\u001f\u0010%\u001a\u00028\u00012\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00028\u0001H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0013H\u0016¢\u0006\u0004\b'\u0010(J!\u0010)\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u0001H\u0016¢\u0006\u0004\b)\u0010 J!\u0010*\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u0001H\u0016¢\u0006\u0004\b*\u0010 J\u0019\u0010+\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b+\u0010\u001dJ\u001f\u0010+\u001a\u00020\u00132\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u0001H\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00028\u00012\u0006\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b-\u0010#J!\u0010.\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u0001H\u0016¢\u0006\u0004\b.\u0010 J'\u0010.\u001a\u00020\u00132\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010/\u001a\u00028\u00012\u0006\u00100\u001a\u00028\u0001H\u0016¢\u0006\u0004\b.\u00101J\u000f\u00102\u001a\u00020\u0004H\u0016¢\u0006\u0004\b2\u0010\rJ\u001a\u00104\u001a\u00020\u00132\b\u00103\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b4\u0010\u0015J\u000f\u00105\u001a\u00020\u0004H\u0016¢\u0006\u0004\b5\u0010\rJ\u000f\u00107\u001a\u000206H\u0016¢\u0006\u0004\b7\u00108R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u001e\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u00102\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010?¨\u0006@"}, d2 = {"Landroidx/collection/SimpleArrayMap;", "K", "V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "capacity", "<init>", "(I)V", "key", "hash", "indexOf", "(Ljava/lang/Object;I)I", "indexOfNull", "()I", BuildConfig.FLAVOR, "clear", "()V", "minimumCapacity", "ensureCapacity", BuildConfig.FLAVOR, "containsKey", "(Ljava/lang/Object;)Z", "indexOfKey", "(Ljava/lang/Object;)I", "value", "__restricted$indexOfValue", "indexOfValue", "containsValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "defaultValue", "getOrDefault", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "index", "keyAt", "(I)Ljava/lang/Object;", "valueAt", "setValueAt", "(ILjava/lang/Object;)Ljava/lang/Object;", "isEmpty", "()Z", "put", "putIfAbsent", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeAt", "replace", "oldValue", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "size", "other", "equals", "hashCode", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashes", "[I", BuildConfig.FLAVOR, "array", "[Ljava/lang/Object;", "I", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class SimpleArrayMap<K, V> {
    private Object[] array;
    private int[] hashes;
    private int size;

    public SimpleArrayMap() {
        this(0, 1, null);
    }

    private final int indexOf(K key, int hash) {
        int i5 = this.size;
        if (i5 == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpersKt.binarySearch(this.hashes, i5, hash);
        if (binarySearch < 0 || Intrinsics.areEqual(key, this.array[binarySearch << 1])) {
            return binarySearch;
        }
        int i6 = binarySearch + 1;
        while (i6 < i5 && this.hashes[i6] == hash) {
            if (Intrinsics.areEqual(key, this.array[i6 << 1])) {
                return i6;
            }
            i6++;
        }
        for (int i7 = binarySearch - 1; i7 >= 0 && this.hashes[i7] == hash; i7--) {
            if (Intrinsics.areEqual(key, this.array[i7 << 1])) {
                return i7;
            }
        }
        return ~i6;
    }

    private final int indexOfNull() {
        int i5 = this.size;
        if (i5 == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpersKt.binarySearch(this.hashes, i5, 0);
        if (binarySearch < 0 || this.array[binarySearch << 1] == null) {
            return binarySearch;
        }
        int i6 = binarySearch + 1;
        while (i6 < i5 && this.hashes[i6] == 0) {
            if (this.array[i6 << 1] == null) {
                return i6;
            }
            i6++;
        }
        for (int i7 = binarySearch - 1; i7 >= 0 && this.hashes[i7] == 0; i7--) {
            if (this.array[i7 << 1] == null) {
                return i7;
            }
        }
        return ~i6;
    }

    public final int __restricted$indexOfValue(V value) {
        int i5 = this.size * 2;
        Object[] objArr = this.array;
        if (value == null) {
            for (int i6 = 1; i6 < i5; i6 += 2) {
                if (objArr[i6] == null) {
                    return i6 >> 1;
                }
            }
            return -1;
        }
        for (int i7 = 1; i7 < i5; i7 += 2) {
            if (Intrinsics.areEqual(value, objArr[i7])) {
                return i7 >> 1;
            }
        }
        return -1;
    }

    public void clear() {
        if (this.size > 0) {
            this.hashes = ContainerHelpersKt.EMPTY_INTS;
            this.array = ContainerHelpersKt.EMPTY_OBJECTS;
            this.size = 0;
        }
        if (this.size > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(K key) {
        return indexOfKey(key) >= 0;
    }

    public boolean containsValue(V value) {
        return __restricted$indexOfValue(value) >= 0;
    }

    public void ensureCapacity(int minimumCapacity) {
        int i5 = this.size;
        int[] iArr = this.hashes;
        if (iArr.length < minimumCapacity) {
            int[] copyOf = Arrays.copyOf(iArr, minimumCapacity);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.hashes = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.array, minimumCapacity * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
            this.array = copyOf2;
        }
        if (this.size != i5) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        try {
            if (other instanceof SimpleArrayMap) {
                if (getSize() != ((SimpleArrayMap) other).getSize()) {
                    return false;
                }
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) other;
                int i5 = this.size;
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
            if (!(other instanceof Map) || getSize() != ((Map) other).size()) {
                return false;
            }
            int i7 = this.size;
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

    public V get(K key) {
        int indexOfKey = indexOfKey(key);
        if (indexOfKey >= 0) {
            return (V) this.array[(indexOfKey << 1) + 1];
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V getOrDefault(Object key, V defaultValue) {
        int indexOfKey = indexOfKey(key);
        return indexOfKey >= 0 ? (V) this.array[(indexOfKey << 1) + 1] : defaultValue;
    }

    public int hashCode() {
        int[] iArr = this.hashes;
        Object[] objArr = this.array;
        int i5 = this.size;
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

    public int indexOfKey(K key) {
        return key == null ? indexOfNull() : indexOf(key, key.hashCode());
    }

    public boolean isEmpty() {
        return this.size <= 0;
    }

    public K keyAt(int index) {
        boolean z5 = false;
        if (index >= 0 && index < this.size) {
            z5 = true;
        }
        if (!z5) {
            RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + index);
        }
        return (K) this.array[index << 1];
    }

    public V put(K key, V value) {
        int i5 = this.size;
        int hashCode = key != null ? key.hashCode() : 0;
        int indexOf = key != null ? indexOf(key, hashCode) : indexOfNull();
        if (indexOf >= 0) {
            int i6 = (indexOf << 1) + 1;
            Object[] objArr = this.array;
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
            Object[] copyOf2 = Arrays.copyOf(this.array, i8 << 1);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
            this.array = copyOf2;
            if (i5 != this.size) {
                throw new ConcurrentModificationException();
            }
        }
        if (i7 < i5) {
            int[] iArr2 = this.hashes;
            int i9 = i7 + 1;
            ArraysKt.copyInto(iArr2, iArr2, i9, i7, i5);
            Object[] objArr2 = this.array;
            ArraysKt.copyInto(objArr2, objArr2, i9 << 1, i7 << 1, this.size << 1);
        }
        int i10 = this.size;
        if (i5 == i10) {
            int[] iArr3 = this.hashes;
            if (i7 < iArr3.length) {
                iArr3[i7] = hashCode;
                Object[] objArr3 = this.array;
                int i11 = i7 << 1;
                objArr3[i11] = key;
                objArr3[i11 + 1] = value;
                this.size = i10 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K key, V value) {
        V v5 = get(key);
        return v5 == null ? put(key, value) : v5;
    }

    public V remove(K key) {
        int indexOfKey = indexOfKey(key);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public V removeAt(int index) {
        if (!(index >= 0 && index < this.size)) {
            RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + index);
        }
        Object[] objArr = this.array;
        int i5 = index << 1;
        V v5 = (V) objArr[i5 + 1];
        int i6 = this.size;
        if (i6 <= 1) {
            clear();
        } else {
            int i7 = i6 - 1;
            int[] iArr = this.hashes;
            if (iArr.length <= 8 || i6 >= iArr.length / 3) {
                if (index < i7) {
                    int i8 = index + 1;
                    ArraysKt.copyInto(iArr, iArr, index, i8, i6);
                    Object[] objArr2 = this.array;
                    ArraysKt.copyInto(objArr2, objArr2, i5, i8 << 1, i6 << 1);
                }
                Object[] objArr3 = this.array;
                int i9 = i7 << 1;
                objArr3[i9] = null;
                objArr3[i9 + 1] = null;
            } else {
                int i10 = i6 > 8 ? i6 + (i6 >> 1) : 8;
                int[] copyOf = Arrays.copyOf(iArr, i10);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                this.hashes = copyOf;
                Object[] copyOf2 = Arrays.copyOf(this.array, i10 << 1);
                Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
                this.array = copyOf2;
                if (i6 != this.size) {
                    throw new ConcurrentModificationException();
                }
                if (index > 0) {
                    ArraysKt.copyInto(iArr, this.hashes, 0, 0, index);
                    ArraysKt.copyInto(objArr, this.array, 0, 0, i5);
                }
                if (index < i7) {
                    int i11 = index + 1;
                    ArraysKt.copyInto(iArr, this.hashes, index, i11, i6);
                    ArraysKt.copyInto(objArr, this.array, i5, i11 << 1, i6 << 1);
                }
            }
            if (i6 != this.size) {
                throw new ConcurrentModificationException();
            }
            this.size = i7;
        }
        return v5;
    }

    public V replace(K key, V value) {
        int indexOfKey = indexOfKey(key);
        if (indexOfKey >= 0) {
            return setValueAt(indexOfKey, value);
        }
        return null;
    }

    public V setValueAt(int index, V value) {
        boolean z5 = false;
        if (index >= 0 && index < this.size) {
            z5 = true;
        }
        if (!z5) {
            RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + index);
        }
        int i5 = (index << 1) + 1;
        Object[] objArr = this.array;
        V v5 = (V) objArr[i5];
        objArr[i5] = value;
        return v5;
    }

    /* renamed from: size, reason: from getter */
    public int getSize() {
        return this.size;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.size * 28);
        sb.append('{');
        int i5 = this.size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            K keyAt = keyAt(i6);
            if (keyAt != sb) {
                sb.append(keyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V valueAt = valueAt(i6);
            if (valueAt != sb) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public V valueAt(int index) {
        boolean z5 = false;
        if (index >= 0 && index < this.size) {
            z5 = true;
        }
        if (!z5) {
            RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + index);
        }
        return (V) this.array[(index << 1) + 1];
    }

    public SimpleArrayMap(int i5) {
        int[] iArr;
        Object[] objArr;
        if (i5 == 0) {
            iArr = ContainerHelpersKt.EMPTY_INTS;
        } else {
            iArr = new int[i5];
        }
        this.hashes = iArr;
        if (i5 == 0) {
            objArr = ContainerHelpersKt.EMPTY_OBJECTS;
        } else {
            objArr = new Object[i5 << 1];
        }
        this.array = objArr;
    }

    public boolean remove(K key, V value) {
        int indexOfKey = indexOfKey(key);
        if (indexOfKey < 0 || !Intrinsics.areEqual(value, valueAt(indexOfKey))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }

    public boolean replace(K key, V oldValue, V newValue) {
        int indexOfKey = indexOfKey(key);
        if (indexOfKey < 0 || !Intrinsics.areEqual(oldValue, valueAt(indexOfKey))) {
            return false;
        }
        setValueAt(indexOfKey, newValue);
        return true;
    }

    public /* synthetic */ SimpleArrayMap(int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 0 : i5);
    }
}
