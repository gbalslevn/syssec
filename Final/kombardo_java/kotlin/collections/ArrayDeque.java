package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u001e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\f\b\u0007\u0018\u0000 T*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001TB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u000fJ%\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u001f\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001f\u0010\u001bJ\u000f\u0010 \u001a\u00020\tH\u0002¢\u0006\u0004\b \u0010\u0007J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00028\u0000¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b&\u0010%J\r\u0010'\u001a\u00028\u0000¢\u0006\u0004\b'\u0010%J\u000f\u0010(\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b(\u0010%J\u0015\u0010*\u001a\u00020\t2\u0006\u0010)\u001a\u00028\u0000¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\u00020\t2\u0006\u0010)\u001a\u00028\u0000¢\u0006\u0004\b,\u0010+J\r\u0010-\u001a\u00028\u0000¢\u0006\u0004\b-\u0010%J\u000f\u0010.\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b.\u0010%J\r\u0010/\u001a\u00028\u0000¢\u0006\u0004\b/\u0010%J\u000f\u00100\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b0\u0010%J\u0017\u00101\u001a\u00020!2\u0006\u0010)\u001a\u00028\u0000H\u0016¢\u0006\u0004\b1\u00102J\u001f\u00101\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010)\u001a\u00028\u0000H\u0016¢\u0006\u0004\b1\u00103J\u001d\u00104\u001a\u00020!2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016¢\u0006\u0004\b4\u00105J%\u00104\u001a\u00020!2\u0006\u0010\r\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016¢\u0006\u0004\b4\u00106J\u0018\u00107\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b7\u00108J \u00109\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010)\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b9\u0010:J\u0018\u0010;\u001a\u00020!2\u0006\u0010)\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b;\u00102J\u0017\u0010<\u001a\u00020\u00032\u0006\u0010)\u001a\u00028\u0000H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010>\u001a\u00020\u00032\u0006\u0010)\u001a\u00028\u0000H\u0016¢\u0006\u0004\b>\u0010=J\u0017\u0010?\u001a\u00020!2\u0006\u0010)\u001a\u00028\u0000H\u0016¢\u0006\u0004\b?\u00102J\u0017\u0010@\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b@\u00108J\u001d\u0010A\u001a\u00020!2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016¢\u0006\u0004\bA\u00105J\u001d\u0010B\u001a\u00020!2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016¢\u0006\u0004\bB\u00105J\u000f\u0010C\u001a\u00020\tH\u0016¢\u0006\u0004\bC\u0010\u0007J)\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00010E\"\u0004\b\u0001\u0010D2\f\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00010EH\u0016¢\u0006\u0004\bG\u0010HJ\u0017\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010I0EH\u0016¢\u0006\u0004\bG\u0010JJ\u001f\u0010K\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0014¢\u0006\u0004\bK\u0010\u001bR\u0016\u0010L\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u001e\u0010N\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010I0E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR$\u0010Q\u001a\u00020\u00032\u0006\u0010P\u001a\u00020\u00038\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\bQ\u0010M\u001a\u0004\bR\u0010S¨\u0006U"}, d2 = {"Lkotlin/collections/ArrayDeque;", "E", "Lkotlin/collections/AbstractMutableList;", BuildConfig.FLAVOR, "initialCapacity", "<init>", "(I)V", "()V", "minCapacity", BuildConfig.FLAVOR, "ensureCapacity", "newCapacity", "copyElements", "index", "positiveMod", "(I)I", "negativeMod", "incremented", "decremented", "internalIndex", BuildConfig.FLAVOR, "elements", "copyCollectionElements", "(ILjava/util/Collection;)V", "fromIndex", "toIndex", "removeRangeShiftPreceding", "(II)V", "removeRangeShiftSucceeding", "internalFromIndex", "internalToIndex", "nullifyNonEmpty", "registerModification", BuildConfig.FLAVOR, "isEmpty", "()Z", "first", "()Ljava/lang/Object;", "firstOrNull", "last", "lastOrNull", "element", "addFirst", "(Ljava/lang/Object;)V", "addLast", "removeFirst", "removeFirstOrNull", "removeLast", "removeLastOrNull", "add", "(Ljava/lang/Object;)Z", "(ILjava/lang/Object;)V", "addAll", "(Ljava/util/Collection;)Z", "(ILjava/util/Collection;)Z", "get", "(I)Ljava/lang/Object;", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "contains", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "remove", "removeAt", "removeAll", "retainAll", "clear", "T", BuildConfig.FLAVOR, "array", "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", BuildConfig.FLAVOR, "()[Ljava/lang/Object;", "removeRange", "head", "I", "elementData", "[Ljava/lang/Object;", "value", "size", "getSize", "()I", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ArrayDeque<E> extends AbstractMutableList<E> {
    private static final int defaultMinCapacity = 10;
    private Object[] elementData;
    private int head;
    private int size;
    private static final Object[] emptyElementData = new Object[0];

    public ArrayDeque(int i5) {
        Object[] objArr;
        if (i5 == 0) {
            objArr = emptyElementData;
        } else if (i5 > 0) {
            objArr = new Object[i5];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + i5);
        }
        this.elementData = objArr;
    }

    private final void copyCollectionElements(int internalIndex, Collection<? extends E> elements) {
        Iterator<? extends E> it = elements.iterator();
        int length = this.elementData.length;
        while (internalIndex < length && it.hasNext()) {
            this.elementData[internalIndex] = it.next();
            internalIndex++;
        }
        int i5 = this.head;
        for (int i6 = 0; i6 < i5 && it.hasNext(); i6++) {
            this.elementData[i6] = it.next();
        }
        this.size = size() + elements.size();
    }

    private final void copyElements(int newCapacity) {
        Object[] objArr = new Object[newCapacity];
        Object[] objArr2 = this.elementData;
        ArraysKt.copyInto(objArr2, objArr, 0, this.head, objArr2.length);
        Object[] objArr3 = this.elementData;
        int length = objArr3.length;
        int i5 = this.head;
        ArraysKt.copyInto(objArr3, objArr, length - i5, 0, i5);
        this.head = 0;
        this.elementData = objArr;
    }

    private final int decremented(int index) {
        return index == 0 ? ArraysKt.getLastIndex(this.elementData) : index - 1;
    }

    private final void ensureCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.elementData;
        if (minCapacity <= objArr.length) {
            return;
        }
        if (objArr == emptyElementData) {
            this.elementData = new Object[RangesKt.coerceAtLeast(minCapacity, 10)];
        } else {
            copyElements(AbstractList.INSTANCE.newCapacity$kotlin_stdlib(objArr.length, minCapacity));
        }
    }

    private final int incremented(int index) {
        if (index == ArraysKt.getLastIndex(this.elementData)) {
            return 0;
        }
        return index + 1;
    }

    private final int negativeMod(int index) {
        return index < 0 ? index + this.elementData.length : index;
    }

    private final void nullifyNonEmpty(int internalFromIndex, int internalToIndex) {
        if (internalFromIndex < internalToIndex) {
            ArraysKt.fill(this.elementData, (Object) null, internalFromIndex, internalToIndex);
            return;
        }
        Object[] objArr = this.elementData;
        ArraysKt.fill(objArr, (Object) null, internalFromIndex, objArr.length);
        ArraysKt.fill(this.elementData, (Object) null, 0, internalToIndex);
    }

    private final int positiveMod(int index) {
        Object[] objArr = this.elementData;
        return index >= objArr.length ? index - objArr.length : index;
    }

    private final void registerModification() {
        ((java.util.AbstractList) this).modCount++;
    }

    private final void removeRangeShiftPreceding(int fromIndex, int toIndex) {
        int positiveMod = positiveMod(this.head + (fromIndex - 1));
        int positiveMod2 = positiveMod(this.head + (toIndex - 1));
        while (fromIndex > 0) {
            int i5 = positiveMod + 1;
            int min = Math.min(fromIndex, Math.min(i5, positiveMod2 + 1));
            Object[] objArr = this.elementData;
            int i6 = positiveMod2 - min;
            int i7 = positiveMod - min;
            ArraysKt.copyInto(objArr, objArr, i6 + 1, i7 + 1, i5);
            positiveMod = negativeMod(i7);
            positiveMod2 = negativeMod(i6);
            fromIndex -= min;
        }
    }

    private final void removeRangeShiftSucceeding(int fromIndex, int toIndex) {
        int positiveMod = positiveMod(this.head + toIndex);
        int positiveMod2 = positiveMod(this.head + fromIndex);
        int size = size();
        while (true) {
            size -= toIndex;
            if (size <= 0) {
                return;
            }
            Object[] objArr = this.elementData;
            toIndex = Math.min(size, Math.min(objArr.length - positiveMod, objArr.length - positiveMod2));
            Object[] objArr2 = this.elementData;
            int i5 = positiveMod + toIndex;
            ArraysKt.copyInto(objArr2, objArr2, positiveMod2, positiveMod, i5);
            positiveMod = positiveMod(i5);
            positiveMod2 = positiveMod(positiveMod2 + toIndex);
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E element) {
        addLast(element);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        registerModification();
        ensureCapacity(size() + elements.size());
        copyCollectionElements(positiveMod(this.head + size()), elements);
        return true;
    }

    public final void addFirst(E element) {
        registerModification();
        ensureCapacity(size() + 1);
        int decremented = decremented(this.head);
        this.head = decremented;
        this.elementData[decremented] = element;
        this.size = size() + 1;
    }

    public final void addLast(E element) {
        registerModification();
        ensureCapacity(size() + 1);
        this.elementData[positiveMod(this.head + size())] = element;
        this.size = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (!isEmpty()) {
            registerModification();
            nullifyNonEmpty(this.head, positiveMod(this.head + size()));
        }
        this.head = 0;
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    public final E first() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.elementData[this.head];
    }

    public final E firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.elementData[this.head];
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int index) {
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, size());
        return (E) this.elementData[positiveMod(this.head + index)];
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.size;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object element) {
        int i5;
        int positiveMod = positiveMod(this.head + size());
        int i6 = this.head;
        if (i6 < positiveMod) {
            while (i6 < positiveMod) {
                if (Intrinsics.areEqual(element, this.elementData[i6])) {
                    i5 = this.head;
                } else {
                    i6++;
                }
            }
            return -1;
        }
        if (i6 < positiveMod) {
            return -1;
        }
        int length = this.elementData.length;
        while (true) {
            if (i6 >= length) {
                for (int i7 = 0; i7 < positiveMod; i7++) {
                    if (Intrinsics.areEqual(element, this.elementData[i7])) {
                        i6 = i7 + this.elementData.length;
                        i5 = this.head;
                    }
                }
                return -1;
            }
            if (Intrinsics.areEqual(element, this.elementData[i6])) {
                i5 = this.head;
                break;
            }
            i6++;
        }
        return i6 - i5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    public final E last() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.elementData[positiveMod(this.head + CollectionsKt.getLastIndex(this))];
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object element) {
        int lastIndex;
        int i5;
        int positiveMod = positiveMod(this.head + size());
        int i6 = this.head;
        if (i6 < positiveMod) {
            lastIndex = positiveMod - 1;
            if (i6 <= lastIndex) {
                while (!Intrinsics.areEqual(element, this.elementData[lastIndex])) {
                    if (lastIndex != i6) {
                        lastIndex--;
                    }
                }
                i5 = this.head;
                return lastIndex - i5;
            }
            return -1;
        }
        if (i6 > positiveMod) {
            int i7 = positiveMod - 1;
            while (true) {
                if (-1 >= i7) {
                    lastIndex = ArraysKt.getLastIndex(this.elementData);
                    int i8 = this.head;
                    if (i8 <= lastIndex) {
                        while (!Intrinsics.areEqual(element, this.elementData[lastIndex])) {
                            if (lastIndex != i8) {
                                lastIndex--;
                            }
                        }
                        i5 = this.head;
                    }
                } else {
                    if (Intrinsics.areEqual(element, this.elementData[i7])) {
                        lastIndex = i7 + this.elementData.length;
                        i5 = this.head;
                        break;
                    }
                    i7--;
                }
            }
        }
        return -1;
    }

    public final E lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.elementData[positiveMod(this.head + CollectionsKt.getLastIndex(this))];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object element) {
        int indexOf = indexOf(element);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> elements) {
        int positiveMod;
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z5 = false;
        z5 = false;
        z5 = false;
        if (!isEmpty() && this.elementData.length != 0) {
            int positiveMod2 = positiveMod(this.head + size());
            int i5 = this.head;
            if (i5 < positiveMod2) {
                positiveMod = i5;
                while (i5 < positiveMod2) {
                    Object obj = this.elementData[i5];
                    if (elements.contains(obj)) {
                        z5 = true;
                    } else {
                        this.elementData[positiveMod] = obj;
                        positiveMod++;
                    }
                    i5++;
                }
                ArraysKt.fill(this.elementData, (Object) null, positiveMod, positiveMod2);
            } else {
                int length = this.elementData.length;
                boolean z6 = false;
                int i6 = i5;
                while (i5 < length) {
                    Object[] objArr = this.elementData;
                    Object obj2 = objArr[i5];
                    objArr[i5] = null;
                    if (elements.contains(obj2)) {
                        z6 = true;
                    } else {
                        this.elementData[i6] = obj2;
                        i6++;
                    }
                    i5++;
                }
                positiveMod = positiveMod(i6);
                for (int i7 = 0; i7 < positiveMod2; i7++) {
                    Object[] objArr2 = this.elementData;
                    Object obj3 = objArr2[i7];
                    objArr2[i7] = null;
                    if (elements.contains(obj3)) {
                        z6 = true;
                    } else {
                        this.elementData[positiveMod] = obj3;
                        positiveMod = incremented(positiveMod);
                    }
                }
                z5 = z6;
            }
            if (z5) {
                registerModification();
                this.size = negativeMod(positiveMod - this.head);
            }
        }
        return z5;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int index) {
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, size());
        if (index == CollectionsKt.getLastIndex(this)) {
            return removeLast();
        }
        if (index == 0) {
            return removeFirst();
        }
        registerModification();
        int positiveMod = positiveMod(this.head + index);
        E e5 = (E) this.elementData[positiveMod];
        if (index < (size() >> 1)) {
            int i5 = this.head;
            if (positiveMod >= i5) {
                Object[] objArr = this.elementData;
                ArraysKt.copyInto(objArr, objArr, i5 + 1, i5, positiveMod);
            } else {
                Object[] objArr2 = this.elementData;
                ArraysKt.copyInto(objArr2, objArr2, 1, 0, positiveMod);
                Object[] objArr3 = this.elementData;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i6 = this.head;
                ArraysKt.copyInto(objArr3, objArr3, i6 + 1, i6, objArr3.length - 1);
            }
            Object[] objArr4 = this.elementData;
            int i7 = this.head;
            objArr4[i7] = null;
            this.head = incremented(i7);
        } else {
            int positiveMod2 = positiveMod(this.head + CollectionsKt.getLastIndex(this));
            if (positiveMod <= positiveMod2) {
                Object[] objArr5 = this.elementData;
                ArraysKt.copyInto(objArr5, objArr5, positiveMod, positiveMod + 1, positiveMod2 + 1);
            } else {
                Object[] objArr6 = this.elementData;
                ArraysKt.copyInto(objArr6, objArr6, positiveMod, positiveMod + 1, objArr6.length);
                Object[] objArr7 = this.elementData;
                objArr7[objArr7.length - 1] = objArr7[0];
                ArraysKt.copyInto(objArr7, objArr7, 0, 1, positiveMod2 + 1);
            }
            this.elementData[positiveMod2] = null;
        }
        this.size = size() - 1;
        return e5;
    }

    public final E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        registerModification();
        Object[] objArr = this.elementData;
        int i5 = this.head;
        E e5 = (E) objArr[i5];
        objArr[i5] = null;
        this.head = incremented(i5);
        this.size = size() - 1;
        return e5;
    }

    public final E removeFirstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    public final E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        registerModification();
        int positiveMod = positiveMod(this.head + CollectionsKt.getLastIndex(this));
        Object[] objArr = this.elementData;
        E e5 = (E) objArr[positiveMod];
        objArr[positiveMod] = null;
        this.size = size() - 1;
        return e5;
    }

    public final E removeLastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    @Override // java.util.AbstractList
    protected void removeRange(int fromIndex, int toIndex) {
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, size());
        int i5 = toIndex - fromIndex;
        if (i5 == 0) {
            return;
        }
        if (i5 == size()) {
            clear();
            return;
        }
        if (i5 == 1) {
            remove(fromIndex);
            return;
        }
        registerModification();
        if (fromIndex < size() - toIndex) {
            removeRangeShiftPreceding(fromIndex, toIndex);
            int positiveMod = positiveMod(this.head + i5);
            nullifyNonEmpty(this.head, positiveMod);
            this.head = positiveMod;
        } else {
            removeRangeShiftSucceeding(fromIndex, toIndex);
            int positiveMod2 = positiveMod(this.head + size());
            nullifyNonEmpty(negativeMod(positiveMod2 - i5), positiveMod2);
        }
        this.size = size() - i5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> elements) {
        int positiveMod;
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z5 = false;
        z5 = false;
        z5 = false;
        if (!isEmpty() && this.elementData.length != 0) {
            int positiveMod2 = positiveMod(this.head + size());
            int i5 = this.head;
            if (i5 < positiveMod2) {
                positiveMod = i5;
                while (i5 < positiveMod2) {
                    Object obj = this.elementData[i5];
                    if (elements.contains(obj)) {
                        this.elementData[positiveMod] = obj;
                        positiveMod++;
                    } else {
                        z5 = true;
                    }
                    i5++;
                }
                ArraysKt.fill(this.elementData, (Object) null, positiveMod, positiveMod2);
            } else {
                int length = this.elementData.length;
                boolean z6 = false;
                int i6 = i5;
                while (i5 < length) {
                    Object[] objArr = this.elementData;
                    Object obj2 = objArr[i5];
                    objArr[i5] = null;
                    if (elements.contains(obj2)) {
                        this.elementData[i6] = obj2;
                        i6++;
                    } else {
                        z6 = true;
                    }
                    i5++;
                }
                positiveMod = positiveMod(i6);
                for (int i7 = 0; i7 < positiveMod2; i7++) {
                    Object[] objArr2 = this.elementData;
                    Object obj3 = objArr2[i7];
                    objArr2[i7] = null;
                    if (elements.contains(obj3)) {
                        this.elementData[positiveMod] = obj3;
                        positiveMod = incremented(positiveMod);
                    } else {
                        z6 = true;
                    }
                }
                z5 = z6;
            }
            if (z5) {
                registerModification();
                this.size = negativeMod(positiveMod - this.head);
            }
        }
        return z5;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int index, E element) {
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, size());
        int positiveMod = positiveMod(this.head + index);
        Object[] objArr = this.elementData;
        E e5 = (E) objArr[positiveMod];
        objArr[positiveMod] = element;
        return e5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        if (array.length < size()) {
            array = (T[]) ArraysKt__ArraysJVMKt.arrayOfNulls(array, size());
        }
        int positiveMod = positiveMod(this.head + size());
        int i5 = this.head;
        if (i5 < positiveMod) {
            ArraysKt.copyInto$default(this.elementData, array, 0, i5, positiveMod, 2, (Object) null);
        } else if (!isEmpty()) {
            Object[] objArr = this.elementData;
            ArraysKt.copyInto(objArr, array, 0, this.head, objArr.length);
            Object[] objArr2 = this.elementData;
            ArraysKt.copyInto(objArr2, array, objArr2.length - this.head, 0, positiveMod);
        }
        return (T[]) CollectionsKt.terminateCollectionToArray(size(), array);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int index, E element) {
        AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, size());
        if (index == size()) {
            addLast(element);
            return;
        }
        if (index == 0) {
            addFirst(element);
            return;
        }
        registerModification();
        ensureCapacity(size() + 1);
        int positiveMod = positiveMod(this.head + index);
        if (index < ((size() + 1) >> 1)) {
            int decremented = decremented(positiveMod);
            int decremented2 = decremented(this.head);
            int i5 = this.head;
            if (decremented >= i5) {
                Object[] objArr = this.elementData;
                objArr[decremented2] = objArr[i5];
                ArraysKt.copyInto(objArr, objArr, i5, i5 + 1, decremented + 1);
            } else {
                Object[] objArr2 = this.elementData;
                ArraysKt.copyInto(objArr2, objArr2, i5 - 1, i5, objArr2.length);
                Object[] objArr3 = this.elementData;
                objArr3[objArr3.length - 1] = objArr3[0];
                ArraysKt.copyInto(objArr3, objArr3, 0, 1, decremented + 1);
            }
            this.elementData[decremented] = element;
            this.head = decremented2;
        } else {
            int positiveMod2 = positiveMod(this.head + size());
            if (positiveMod < positiveMod2) {
                Object[] objArr4 = this.elementData;
                ArraysKt.copyInto(objArr4, objArr4, positiveMod + 1, positiveMod, positiveMod2);
            } else {
                Object[] objArr5 = this.elementData;
                ArraysKt.copyInto(objArr5, objArr5, 1, 0, positiveMod2);
                Object[] objArr6 = this.elementData;
                objArr6[0] = objArr6[objArr6.length - 1];
                ArraysKt.copyInto(objArr6, objArr6, positiveMod + 1, positiveMod, objArr6.length - 1);
            }
            this.elementData[positiveMod] = element;
        }
        this.size = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int index, Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (index == size()) {
            return addAll(elements);
        }
        registerModification();
        ensureCapacity(size() + elements.size());
        int positiveMod = positiveMod(this.head + size());
        int positiveMod2 = positiveMod(this.head + index);
        int size = elements.size();
        if (index < ((size() + 1) >> 1)) {
            int i5 = this.head;
            int i6 = i5 - size;
            if (positiveMod2 < i5) {
                Object[] objArr = this.elementData;
                ArraysKt.copyInto(objArr, objArr, i6, i5, objArr.length);
                if (size >= positiveMod2) {
                    Object[] objArr2 = this.elementData;
                    ArraysKt.copyInto(objArr2, objArr2, objArr2.length - size, 0, positiveMod2);
                } else {
                    Object[] objArr3 = this.elementData;
                    ArraysKt.copyInto(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.elementData;
                    ArraysKt.copyInto(objArr4, objArr4, 0, size, positiveMod2);
                }
            } else if (i6 >= 0) {
                Object[] objArr5 = this.elementData;
                ArraysKt.copyInto(objArr5, objArr5, i6, i5, positiveMod2);
            } else {
                Object[] objArr6 = this.elementData;
                i6 += objArr6.length;
                int i7 = positiveMod2 - i5;
                int length = objArr6.length - i6;
                if (length >= i7) {
                    ArraysKt.copyInto(objArr6, objArr6, i6, i5, positiveMod2);
                } else {
                    ArraysKt.copyInto(objArr6, objArr6, i6, i5, i5 + length);
                    Object[] objArr7 = this.elementData;
                    ArraysKt.copyInto(objArr7, objArr7, 0, this.head + length, positiveMod2);
                }
            }
            this.head = i6;
            copyCollectionElements(negativeMod(positiveMod2 - size), elements);
        } else {
            int i8 = positiveMod2 + size;
            if (positiveMod2 < positiveMod) {
                int i9 = size + positiveMod;
                Object[] objArr8 = this.elementData;
                if (i9 <= objArr8.length) {
                    ArraysKt.copyInto(objArr8, objArr8, i8, positiveMod2, positiveMod);
                } else if (i8 >= objArr8.length) {
                    ArraysKt.copyInto(objArr8, objArr8, i8 - objArr8.length, positiveMod2, positiveMod);
                } else {
                    int length2 = positiveMod - (i9 - objArr8.length);
                    ArraysKt.copyInto(objArr8, objArr8, 0, length2, positiveMod);
                    Object[] objArr9 = this.elementData;
                    ArraysKt.copyInto(objArr9, objArr9, i8, positiveMod2, length2);
                }
            } else {
                Object[] objArr10 = this.elementData;
                ArraysKt.copyInto(objArr10, objArr10, size, 0, positiveMod);
                Object[] objArr11 = this.elementData;
                if (i8 >= objArr11.length) {
                    ArraysKt.copyInto(objArr11, objArr11, i8 - objArr11.length, positiveMod2, objArr11.length);
                } else {
                    ArraysKt.copyInto(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.elementData;
                    ArraysKt.copyInto(objArr12, objArr12, i8, positiveMod2, objArr12.length - size);
                }
            }
            copyCollectionElements(positiveMod2, elements);
        }
        return true;
    }

    public ArrayDeque() {
        this.elementData = emptyElementData;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
