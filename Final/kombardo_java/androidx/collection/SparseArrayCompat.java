package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001a\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\n\u001a\u0004\u0018\u00018\u00002\u0006\u0010\t\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0006J!\u0010\u0010\u001a\u0004\u0018\u00018\u00002\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u000bJ\u0017\u0010\u0019\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0019\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001f\u0010\u0013J\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u001a8\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u001e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0(8\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010\u0014\u001a\u00020\u00038\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010,¨\u0006-"}, d2 = {"Landroidx/collection/SparseArrayCompat;", "E", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "initialCapacity", "<init>", "(I)V", "clone", "()Landroidx/collection/SparseArrayCompat;", "key", "get", "(I)Ljava/lang/Object;", "index", BuildConfig.FLAVOR, "removeAt", "value", "replace", "(ILjava/lang/Object;)Ljava/lang/Object;", "put", "(ILjava/lang/Object;)V", "size", "()I", "keyAt", "(I)I", "valueAt", "indexOfKey", BuildConfig.FLAVOR, "containsKey", "(I)Z", "clear", "()V", "append", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "garbage", "Z", BuildConfig.FLAVOR, "keys", "[I", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "values", "[Ljava/lang/Object;", "I", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class SparseArrayCompat<E> implements Cloneable {
    public /* synthetic */ boolean garbage;
    public /* synthetic */ int[] keys;
    public /* synthetic */ int size;
    public /* synthetic */ Object[] values;

    public SparseArrayCompat() {
        this(0, 1, null);
    }

    public void append(int key, E value) {
        int i5 = this.size;
        if (i5 != 0 && key <= this.keys[i5 - 1]) {
            put(key, value);
            return;
        }
        if (this.garbage && i5 >= this.keys.length) {
            SparseArrayCompatKt.gc(this);
        }
        int i6 = this.size;
        if (i6 >= this.keys.length) {
            int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i6 + 1);
            int[] copyOf = Arrays.copyOf(this.keys, idealIntArraySize);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.keys = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.values, idealIntArraySize);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
            this.values = copyOf2;
        }
        this.keys[i6] = key;
        this.values[i6] = value;
        this.size = i6 + 1;
    }

    public void clear() {
        int i5 = this.size;
        Object[] objArr = this.values;
        for (int i6 = 0; i6 < i5; i6++) {
            objArr[i6] = null;
        }
        this.size = 0;
        this.garbage = false;
    }

    public boolean containsKey(int key) {
        return indexOfKey(key) >= 0;
    }

    public E get(int key) {
        return (E) SparseArrayCompatKt.commonGet(this, key);
    }

    public int indexOfKey(int key) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return ContainerHelpersKt.binarySearch(this.keys, this.size, key);
    }

    public int keyAt(int index) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return this.keys[index];
    }

    public void put(int key, E value) {
        Object obj;
        int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, key);
        if (binarySearch >= 0) {
            this.values[binarySearch] = value;
            return;
        }
        int i5 = ~binarySearch;
        if (i5 < this.size) {
            Object obj2 = this.values[i5];
            obj = SparseArrayCompatKt.DELETED;
            if (obj2 == obj) {
                this.keys[i5] = key;
                this.values[i5] = value;
                return;
            }
        }
        if (this.garbage && this.size >= this.keys.length) {
            SparseArrayCompatKt.gc(this);
            i5 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, key);
        }
        int i6 = this.size;
        if (i6 >= this.keys.length) {
            int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i6 + 1);
            int[] copyOf = Arrays.copyOf(this.keys, idealIntArraySize);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.keys = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.values, idealIntArraySize);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
            this.values = copyOf2;
        }
        int i7 = this.size;
        if (i7 - i5 != 0) {
            int[] iArr = this.keys;
            int i8 = i5 + 1;
            ArraysKt.copyInto(iArr, iArr, i8, i5, i7);
            Object[] objArr = this.values;
            ArraysKt.copyInto(objArr, objArr, i8, i5, this.size);
        }
        this.keys[i5] = key;
        this.values[i5] = value;
        this.size++;
    }

    public void removeAt(int index) {
        Object obj;
        Object obj2;
        Object obj3 = this.values[index];
        obj = SparseArrayCompatKt.DELETED;
        if (obj3 != obj) {
            Object[] objArr = this.values;
            obj2 = SparseArrayCompatKt.DELETED;
            objArr[index] = obj2;
            this.garbage = true;
        }
    }

    public E replace(int key, E value) {
        int indexOfKey = indexOfKey(key);
        if (indexOfKey < 0) {
            return null;
        }
        Object[] objArr = this.values;
        E e5 = (E) objArr[indexOfKey];
        objArr[indexOfKey] = value;
        return e5;
    }

    public int size() {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return this.size;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.size * 28);
        sb.append('{');
        int i5 = this.size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(keyAt(i6));
            sb.append('=');
            E valueAt = valueAt(i6);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "buffer.toString()");
        return sb2;
    }

    public E valueAt(int index) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return (E) this.values[index];
    }

    public SparseArrayCompat(int i5) {
        if (i5 == 0) {
            this.keys = ContainerHelpersKt.EMPTY_INTS;
            this.values = ContainerHelpersKt.EMPTY_OBJECTS;
        } else {
            int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i5);
            this.keys = new int[idealIntArraySize];
            this.values = new Object[idealIntArraySize];
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SparseArrayCompat<E> m16clone() {
        Object clone = super.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) clone;
        sparseArrayCompat.keys = (int[]) this.keys.clone();
        sparseArrayCompat.values = (Object[]) this.values.clone();
        return sparseArrayCompat;
    }

    public /* synthetic */ SparseArrayCompat(int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 10 : i5);
    }
}
