package androidx.collection;

import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0017B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0006J\u0015\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\u0010\u0010\nJ\u0017\u0010\u0012\u001a\u00028\u00002\b\b\u0001\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Landroidx/collection/MutableObjectList;", "E", "Landroidx/collection/ObjectList;", BuildConfig.FLAVOR, "initialCapacity", "<init>", "(I)V", "element", BuildConfig.FLAVOR, "add", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "clear", "()V", "capacity", "ensureCapacity", "remove", "index", "removeAt", "(I)Ljava/lang/Object;", "Landroidx/collection/MutableObjectList$ObjectListMutableList;", "list", "Landroidx/collection/MutableObjectList$ObjectListMutableList;", "ObjectListMutableList", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableObjectList<E> extends ObjectList<E> {
    private ObjectListMutableList<E> list;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/collection/MutableObjectList$ObjectListMutableList;", "T", BuildConfig.FLAVOR, "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    private static final class ObjectListMutableList<T> implements List<T>, KMutableList {
    }

    public /* synthetic */ MutableObjectList(int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 16 : i5);
    }

    public final boolean add(E element) {
        ensureCapacity(this._size + 1);
        Object[] objArr = this.content;
        int i5 = this._size;
        objArr[i5] = element;
        this._size = i5 + 1;
        return true;
    }

    public final void clear() {
        ArraysKt.fill(this.content, (Object) null, 0, this._size);
        this._size = 0;
    }

    public final void ensureCapacity(int capacity) {
        Object[] objArr = this.content;
        if (objArr.length < capacity) {
            Object[] copyOf = Arrays.copyOf(objArr, Math.max(capacity, (objArr.length * 3) / 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    public final boolean remove(E element) {
        int indexOf = indexOf(element);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public final E removeAt(int index) {
        int i5;
        if (index < 0 || index >= (i5 = this._size)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Index ");
            sb.append(index);
            sb.append(" must be in 0..");
            sb.append(this._size - 1);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        Object[] objArr = this.content;
        E e5 = (E) objArr[index];
        if (index != i5 - 1) {
            ArraysKt.copyInto(objArr, objArr, index, index + 1, i5);
        }
        int i6 = this._size - 1;
        this._size = i6;
        objArr[i6] = null;
        return e5;
    }

    public MutableObjectList(int i5) {
        super(i5, null);
    }
}
