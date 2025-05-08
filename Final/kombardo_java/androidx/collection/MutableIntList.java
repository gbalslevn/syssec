package androidx.collection;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\b\u001a\u00020\u000b2\b\b\u0001\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00072\b\b\u0001\u0010\n\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0086\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0005J\u0015\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\tJ\u0017\u0010\u0016\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\u0018\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u000b¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Landroidx/collection/MutableIntList;", "Landroidx/collection/IntList;", BuildConfig.FLAVOR, "initialCapacity", "<init>", "(I)V", "element", BuildConfig.FLAVOR, "add", "(I)Z", "index", BuildConfig.FLAVOR, "(II)V", BuildConfig.FLAVOR, "elements", "addAll", "(I[I)Z", "plusAssign", "([I)V", "capacity", "ensureCapacity", "remove", "removeAt", "(I)I", "set", "(II)I", "sort", "()V", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableIntList extends IntList {
    public /* synthetic */ MutableIntList(int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 16 : i5);
    }

    public final boolean add(int element) {
        ensureCapacity(this._size + 1);
        int[] iArr = this.content;
        int i5 = this._size;
        iArr[i5] = element;
        this._size = i5 + 1;
        return true;
    }

    public final boolean addAll(int index, int[] elements) {
        int i5;
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (index < 0 || index > (i5 = this._size)) {
            throw new IndexOutOfBoundsException("Index " + index + " must be in 0.." + this._size);
        }
        if (elements.length == 0) {
            return false;
        }
        ensureCapacity(i5 + elements.length);
        int[] iArr = this.content;
        int i6 = this._size;
        if (index != i6) {
            ArraysKt.copyInto(iArr, iArr, elements.length + index, index, i6);
        }
        ArraysKt.copyInto$default(elements, iArr, index, 0, 0, 12, (Object) null);
        this._size += elements.length;
        return true;
    }

    public final void ensureCapacity(int capacity) {
        int[] iArr = this.content;
        if (iArr.length < capacity) {
            int[] copyOf = Arrays.copyOf(iArr, Math.max(capacity, (iArr.length * 3) / 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    public final void plusAssign(int[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        addAll(this._size, elements);
    }

    public final boolean remove(int element) {
        int indexOf = indexOf(element);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public final int removeAt(int index) {
        int i5;
        if (index < 0 || index >= (i5 = this._size)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Index ");
            sb.append(index);
            sb.append(" must be in 0..");
            sb.append(this._size - 1);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        int[] iArr = this.content;
        int i6 = iArr[index];
        if (index != i5 - 1) {
            ArraysKt.copyInto(iArr, iArr, index, index + 1, i5);
        }
        this._size--;
        return i6;
    }

    public final int set(int index, int element) {
        if (index >= 0 && index < this._size) {
            int[] iArr = this.content;
            int i5 = iArr[index];
            iArr[index] = element;
            return i5;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("set index ");
        sb.append(index);
        sb.append(" must be between 0 .. ");
        sb.append(this._size - 1);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final void sort() {
        int i5 = this._size;
        if (i5 == 0) {
            return;
        }
        ArraysKt.sort(this.content, 0, i5);
    }

    public MutableIntList(int i5) {
        super(i5, null);
    }

    public final void add(int index, int element) {
        int i5;
        if (index >= 0 && index <= (i5 = this._size)) {
            ensureCapacity(i5 + 1);
            int[] iArr = this.content;
            int i6 = this._size;
            if (index != i6) {
                ArraysKt.copyInto(iArr, iArr, index + 1, index, i6);
            }
            iArr[index] = element;
            this._size++;
            return;
        }
        throw new IndexOutOfBoundsException("Index " + index + " must be in 0.." + this._size);
    }
}
