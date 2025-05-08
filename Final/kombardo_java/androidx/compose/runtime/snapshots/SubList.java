package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.PreconditionsKt;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0010)\n\u0002\b\b\n\u0002\u0010+\n\u0002\b\u0016\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0096\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001f\u0010\u0019J\u0017\u0010 \u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b \u0010\u0010J\u001f\u0010 \u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b \u0010!J%\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016¢\u0006\u0004\b\"\u0010#J\u001d\u0010\"\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016¢\u0006\u0004\b\"\u0010\u0014J\u000f\u0010$\u001a\u00020\nH\u0016¢\u0006\u0004\b$\u0010\fJ\u0015\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016¢\u0006\u0004\b&\u0010'J\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%2\u0006\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b&\u0010(J\u0017\u0010)\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b)\u0010\u0010J\u001d\u0010*\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016¢\u0006\u0004\b*\u0010\u0014J\u0017\u0010+\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b+\u0010\u0017J\u001d\u0010,\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016¢\u0006\u0004\b,\u0010\u0014J \u0010-\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b-\u0010.J%\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b/\u00100R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u00101\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00105R$\u00108\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u00058\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b8\u00105\u001a\u0004\b9\u0010:¨\u0006;"}, d2 = {"Landroidx/compose/runtime/snapshots/SubList;", "T", BuildConfig.FLAVOR, "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "parentList", BuildConfig.FLAVOR, "fromIndex", "toIndex", "<init>", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;II)V", BuildConfig.FLAVOR, "validateModification", "()V", "element", BuildConfig.FLAVOR, "contains", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "elements", "containsAll", "(Ljava/util/Collection;)Z", "index", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "()Z", BuildConfig.FLAVOR, "iterator", "()Ljava/util/Iterator;", "lastIndexOf", "add", "(ILjava/lang/Object;)V", "addAll", "(ILjava/util/Collection;)Z", "clear", BuildConfig.FLAVOR, "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "(II)Ljava/util/List;", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "getParentList", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "offset", "I", "structure", "<set-?>", "size", "getSize", "()I", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SubList<T> implements List<T>, KMutableList {
    private final int offset;
    private final SnapshotStateList<T> parentList;
    private int size;
    private int structure;

    public SubList(SnapshotStateList<T> snapshotStateList, int i5, int i6) {
        this.parentList = snapshotStateList;
        this.offset = i5;
        this.structure = snapshotStateList.getStructure$runtime_release();
        this.size = i6 - i5;
    }

    private final void validateModification() {
        if (this.parentList.getStructure$runtime_release() != this.structure) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T element) {
        validateModification();
        this.parentList.add(this.offset + size(), element);
        this.size = size() + 1;
        this.structure = this.parentList.getStructure$runtime_release();
        return true;
    }

    @Override // java.util.List
    public boolean addAll(int index, Collection<? extends T> elements) {
        validateModification();
        boolean addAll = this.parentList.addAll(index + this.offset, elements);
        if (addAll) {
            this.size = size() + elements.size();
            this.structure = this.parentList.getStructure$runtime_release();
        }
        return addAll;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        if (size() > 0) {
            validateModification();
            SnapshotStateList<T> snapshotStateList = this.parentList;
            int i5 = this.offset;
            snapshotStateList.removeRange(i5, size() + i5);
            this.size = 0;
            this.structure = this.parentList.getStructure$runtime_release();
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object element) {
        return indexOf(element) >= 0;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Collection<? extends Object> collection = elements;
        if ((collection instanceof Collection) && collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List
    public T get(int index) {
        validateModification();
        SnapshotStateListKt.validateRange(index, size());
        return this.parentList.get(this.offset + index);
    }

    public int getSize() {
        return this.size;
    }

    @Override // java.util.List
    public int indexOf(Object element) {
        validateModification();
        int i5 = this.offset;
        Iterator<Integer> it = RangesKt.until(i5, size() + i5).iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            if (Intrinsics.areEqual(element, this.parentList.get(nextInt))) {
                return nextInt - this.offset;
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object element) {
        validateModification();
        int size = this.offset + size();
        do {
            size--;
            if (size < this.offset) {
                return -1;
            }
        } while (!Intrinsics.areEqual(element, this.parentList.get(size)));
        return size - this.offset;
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final /* bridge */ T remove(int i5) {
        return removeAt(i5);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        Iterator<? extends Object> it = elements.iterator();
        while (true) {
            boolean z5 = false;
            while (it.hasNext()) {
                if (remove(it.next()) || z5) {
                    z5 = true;
                }
            }
            return z5;
        }
    }

    public T removeAt(int index) {
        validateModification();
        T remove = this.parentList.remove(this.offset + index);
        this.size = size() - 1;
        this.structure = this.parentList.getStructure$runtime_release();
        return remove;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        validateModification();
        SnapshotStateList<T> snapshotStateList = this.parentList;
        int i5 = this.offset;
        int retainAllInRange$runtime_release = snapshotStateList.retainAllInRange$runtime_release(elements, i5, size() + i5);
        if (retainAllInRange$runtime_release > 0) {
            this.structure = this.parentList.getStructure$runtime_release();
            this.size = size() - retainAllInRange$runtime_release;
        }
        return retainAllInRange$runtime_release > 0;
    }

    @Override // java.util.List
    public T set(int index, T element) {
        SnapshotStateListKt.validateRange(index, size());
        validateModification();
        T t5 = this.parentList.set(index + this.offset, element);
        this.structure = this.parentList.getStructure$runtime_release();
        return t5;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    public List<T> subList(int fromIndex, int toIndex) {
        if (!(fromIndex >= 0 && fromIndex <= toIndex && toIndex <= size())) {
            PreconditionsKt.throwIllegalArgumentException("fromIndex or toIndex are out of bounds");
        }
        validateModification();
        SnapshotStateList<T> snapshotStateList = this.parentList;
        int i5 = this.offset;
        return new SubList(snapshotStateList, fromIndex + i5, toIndex + i5);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int index) {
        validateModification();
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = index - 1;
        return new SubList$listIterator$1(ref$IntRef, this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object element) {
        int indexOf = indexOf(element);
        if (indexOf < 0) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    @Override // java.util.List
    public void add(int index, T element) {
        validateModification();
        this.parentList.add(this.offset + index, element);
        this.size = size() + 1;
        this.structure = this.parentList.getStructure$runtime_release();
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> elements) {
        return addAll(size(), elements);
    }
}
