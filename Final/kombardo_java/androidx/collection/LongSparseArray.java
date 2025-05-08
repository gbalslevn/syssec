package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001a\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\n\u001a\u00020\tH\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\rH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\u00158\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u001e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0+8\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010\u0013\u001a\u00020\u00038\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010/¨\u00060"}, d2 = {"Landroidx/collection/LongSparseArray;", "E", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "initialCapacity", "<init>", "(I)V", "clone", "()Landroidx/collection/LongSparseArray;", BuildConfig.FLAVOR, "key", "get", "(J)Ljava/lang/Object;", BuildConfig.FLAVOR, "remove", "(J)V", "value", "put", "(JLjava/lang/Object;)V", "size", "()I", BuildConfig.FLAVOR, "isEmpty", "()Z", "index", "keyAt", "(I)J", "valueAt", "(I)Ljava/lang/Object;", "indexOfKey", "(J)I", "containsKey", "(J)Z", "clear", "()V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "garbage", "Z", BuildConfig.FLAVOR, "keys", "[J", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "values", "[Ljava/lang/Object;", "I", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class LongSparseArray<E> implements Cloneable {
    public /* synthetic */ boolean garbage;
    public /* synthetic */ long[] keys;
    public /* synthetic */ int size;
    public /* synthetic */ Object[] values;

    public LongSparseArray() {
        this(0, 1, null);
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

    public boolean containsKey(long key) {
        return indexOfKey(key) >= 0;
    }

    public E get(long key) {
        Object obj;
        int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, key);
        if (binarySearch >= 0) {
            Object obj2 = this.values[binarySearch];
            obj = LongSparseArrayKt.DELETED;
            if (obj2 != obj) {
                return (E) this.values[binarySearch];
            }
        }
        return null;
    }

    public int indexOfKey(long key) {
        Object obj;
        if (this.garbage) {
            int i5 = this.size;
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i6 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                Object obj2 = objArr[i7];
                obj = LongSparseArrayKt.DELETED;
                if (obj2 != obj) {
                    if (i7 != i6) {
                        jArr[i6] = jArr[i7];
                        objArr[i6] = obj2;
                        objArr[i7] = null;
                    }
                    i6++;
                }
            }
            this.garbage = false;
            this.size = i6;
        }
        return ContainerHelpersKt.binarySearch(this.keys, this.size, key);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public long keyAt(int index) {
        Object obj;
        if (!(index >= 0 && index < this.size)) {
            RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + index);
        }
        if (this.garbage) {
            int i5 = this.size;
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i6 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                Object obj2 = objArr[i7];
                obj = LongSparseArrayKt.DELETED;
                if (obj2 != obj) {
                    if (i7 != i6) {
                        jArr[i6] = jArr[i7];
                        objArr[i6] = obj2;
                        objArr[i7] = null;
                    }
                    i6++;
                }
            }
            this.garbage = false;
            this.size = i6;
        }
        return this.keys[index];
    }

    public void put(long key, E value) {
        Object obj;
        Object obj2;
        int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, key);
        if (binarySearch >= 0) {
            this.values[binarySearch] = value;
            return;
        }
        int i5 = ~binarySearch;
        if (i5 < this.size) {
            Object obj3 = this.values[i5];
            obj2 = LongSparseArrayKt.DELETED;
            if (obj3 == obj2) {
                this.keys[i5] = key;
                this.values[i5] = value;
                return;
            }
        }
        if (this.garbage) {
            int i6 = this.size;
            long[] jArr = this.keys;
            if (i6 >= jArr.length) {
                Object[] objArr = this.values;
                int i7 = 0;
                for (int i8 = 0; i8 < i6; i8++) {
                    Object obj4 = objArr[i8];
                    obj = LongSparseArrayKt.DELETED;
                    if (obj4 != obj) {
                        if (i8 != i7) {
                            jArr[i7] = jArr[i8];
                            objArr[i7] = obj4;
                            objArr[i8] = null;
                        }
                        i7++;
                    }
                }
                this.garbage = false;
                this.size = i7;
                i5 = ~ContainerHelpersKt.binarySearch(this.keys, i7, key);
            }
        }
        int i9 = this.size;
        if (i9 >= this.keys.length) {
            int idealLongArraySize = ContainerHelpersKt.idealLongArraySize(i9 + 1);
            long[] copyOf = Arrays.copyOf(this.keys, idealLongArraySize);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.keys = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.values, idealLongArraySize);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
            this.values = copyOf2;
        }
        int i10 = this.size;
        if (i10 - i5 != 0) {
            long[] jArr2 = this.keys;
            int i11 = i5 + 1;
            ArraysKt.copyInto(jArr2, jArr2, i11, i5, i10);
            Object[] objArr2 = this.values;
            ArraysKt.copyInto(objArr2, objArr2, i11, i5, this.size);
        }
        this.keys[i5] = key;
        this.values[i5] = value;
        this.size++;
    }

    public void remove(long key) {
        Object obj;
        Object obj2;
        int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, key);
        if (binarySearch >= 0) {
            Object obj3 = this.values[binarySearch];
            obj = LongSparseArrayKt.DELETED;
            if (obj3 != obj) {
                Object[] objArr = this.values;
                obj2 = LongSparseArrayKt.DELETED;
                objArr[binarySearch] = obj2;
                this.garbage = true;
            }
        }
    }

    public int size() {
        Object obj;
        if (this.garbage) {
            int i5 = this.size;
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i6 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                Object obj2 = objArr[i7];
                obj = LongSparseArrayKt.DELETED;
                if (obj2 != obj) {
                    if (i7 != i6) {
                        jArr[i6] = jArr[i7];
                        objArr[i6] = obj2;
                        objArr[i7] = null;
                    }
                    i6++;
                }
            }
            this.garbage = false;
            this.size = i6;
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

    public E valueAt(int index) {
        Object obj;
        if (!(index >= 0 && index < this.size)) {
            RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + index);
        }
        if (this.garbage) {
            int i5 = this.size;
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i6 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                Object obj2 = objArr[i7];
                obj = LongSparseArrayKt.DELETED;
                if (obj2 != obj) {
                    if (i7 != i6) {
                        jArr[i6] = jArr[i7];
                        objArr[i6] = obj2;
                        objArr[i7] = null;
                    }
                    i6++;
                }
            }
            this.garbage = false;
            this.size = i6;
        }
        return (E) this.values[index];
    }

    public LongSparseArray(int i5) {
        if (i5 == 0) {
            this.keys = ContainerHelpersKt.EMPTY_LONGS;
            this.values = ContainerHelpersKt.EMPTY_OBJECTS;
        } else {
            int idealLongArraySize = ContainerHelpersKt.idealLongArraySize(i5);
            this.keys = new long[idealLongArraySize];
            this.values = new Object[idealLongArraySize];
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public LongSparseArray<E> m15clone() {
        Object clone = super.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        LongSparseArray<E> longSparseArray = (LongSparseArray) clone;
        longSparseArray.keys = (long[]) this.keys.clone();
        longSparseArray.values = (Object[]) this.values.clone();
        return longSparseArray;
    }

    public /* synthetic */ LongSparseArray(int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 10 : i5);
    }
}
