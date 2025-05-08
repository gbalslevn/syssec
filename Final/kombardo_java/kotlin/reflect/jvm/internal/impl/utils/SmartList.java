package kotlin.reflect.jvm.internal.impl.utils;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class SmartList<E> extends AbstractList<E> implements RandomAccess {
    private Object myElem;
    private int mySize;

    /* loaded from: classes3.dex */
    private static class EmptyIterator<T> implements Iterator<T> {
        private static final EmptyIterator INSTANCE = new EmptyIterator();

        private EmptyIterator() {
        }

        public static <T> EmptyIterator<T> getInstance() {
            return INSTANCE;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException();
        }
    }

    /* loaded from: classes3.dex */
    private class SingletonIterator extends SingletonIteratorBase<E> {
        private final int myInitialModCount;

        public SingletonIterator() {
            super();
            this.myInitialModCount = ((AbstractList) SmartList.this).modCount;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.SmartList.SingletonIteratorBase
        protected void checkCoModification() {
            if (((AbstractList) SmartList.this).modCount == this.myInitialModCount) {
                return;
            }
            throw new ConcurrentModificationException("ModCount: " + ((AbstractList) SmartList.this).modCount + "; expected: " + this.myInitialModCount);
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.SmartList.SingletonIteratorBase
        protected E getElement() {
            return (E) SmartList.this.myElem;
        }

        @Override // java.util.Iterator
        public void remove() {
            checkCoModification();
            SmartList.this.clear();
        }
    }

    /* loaded from: classes3.dex */
    private static abstract class SingletonIteratorBase<T> implements Iterator<T> {
        private boolean myVisited;

        private SingletonIteratorBase() {
        }

        protected abstract void checkCoModification();

        protected abstract T getElement();

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return !this.myVisited;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (this.myVisited) {
                throw new NoSuchElementException();
            }
            this.myVisited = true;
            checkCoModification();
            return getElement();
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int i5) {
        String str = (i5 == 2 || i5 == 3 || i5 == 5 || i5 == 6 || i5 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i5 == 2 || i5 == 3 || i5 == 5 || i5 == 6 || i5 == 7) ? 2 : 3];
        switch (i5) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
                break;
            case 4:
                objArr[0] = "a";
                break;
            default:
                objArr[0] = "elements";
                break;
        }
        if (i5 == 2 || i5 == 3) {
            objArr[1] = "iterator";
        } else if (i5 == 5 || i5 == 6 || i5 == 7) {
            objArr[1] = "toArray";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
        }
        switch (i5) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                break;
            case 4:
                objArr[2] = "toArray";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i5 != 2 && i5 != 3 && i5 != 5 && i5 != 6 && i5 != 7) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e5) {
        int i5 = this.mySize;
        if (i5 == 0) {
            this.myElem = e5;
        } else if (i5 == 1) {
            this.myElem = new Object[]{this.myElem, e5};
        } else {
            Object[] objArr = (Object[]) this.myElem;
            int length = objArr.length;
            if (i5 >= length) {
                int i6 = ((length * 3) / 2) + 1;
                int i7 = i5 + 1;
                if (i6 < i7) {
                    i6 = i7;
                }
                Object[] objArr2 = new Object[i6];
                this.myElem = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
                objArr = objArr2;
            }
            objArr[this.mySize] = e5;
        }
        this.mySize++;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.myElem = null;
        this.mySize = 0;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i5) {
        int i6;
        if (i5 >= 0 && i5 < (i6 = this.mySize)) {
            return i6 == 1 ? (E) this.myElem : (E) ((Object[]) this.myElem)[i5];
        }
        throw new IndexOutOfBoundsException("Index: " + i5 + ", Size: " + this.mySize);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        int i5 = this.mySize;
        if (i5 == 0) {
            EmptyIterator emptyIterator = EmptyIterator.getInstance();
            if (emptyIterator == null) {
                $$$reportNull$$$0(2);
            }
            return emptyIterator;
        }
        if (i5 == 1) {
            return new SingletonIterator();
        }
        Iterator<E> it = super.iterator();
        if (it == null) {
            $$$reportNull$$$0(3);
        }
        return it;
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i5) {
        int i6;
        E e5;
        if (i5 < 0 || i5 >= (i6 = this.mySize)) {
            throw new IndexOutOfBoundsException("Index: " + i5 + ", Size: " + this.mySize);
        }
        if (i6 == 1) {
            e5 = (E) this.myElem;
            this.myElem = null;
        } else {
            Object[] objArr = (Object[]) this.myElem;
            Object obj = objArr[i5];
            if (i6 == 2) {
                this.myElem = objArr[1 - i5];
            } else {
                int i7 = (i6 - i5) - 1;
                if (i7 > 0) {
                    System.arraycopy(objArr, i5 + 1, objArr, i5, i7);
                }
                objArr[this.mySize - 1] = null;
            }
            e5 = (E) obj;
        }
        this.mySize--;
        ((AbstractList) this).modCount++;
        return e5;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i5, E e5) {
        int i6;
        if (i5 < 0 || i5 >= (i6 = this.mySize)) {
            throw new IndexOutOfBoundsException("Index: " + i5 + ", Size: " + this.mySize);
        }
        if (i6 == 1) {
            E e6 = (E) this.myElem;
            this.myElem = e5;
            return e6;
        }
        Object[] objArr = (Object[]) this.myElem;
        E e7 = (E) objArr[i5];
        objArr[i5] = e5;
        return e7;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.mySize;
    }

    @Override // java.util.List
    public void sort(Comparator<? super E> comparator) {
        int i5 = this.mySize;
        if (i5 >= 2) {
            Arrays.sort((Object[]) this.myElem, 0, i5, comparator);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        if (tArr == 0) {
            $$$reportNull$$$0(4);
        }
        int length = tArr.length;
        int i5 = this.mySize;
        if (i5 == 1) {
            if (length == 0) {
                T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
                tArr2[0] = this.myElem;
                return tArr2;
            }
            tArr[0] = this.myElem;
        } else {
            if (length < i5) {
                T[] tArr3 = (T[]) Arrays.copyOf((Object[]) this.myElem, i5, tArr.getClass());
                if (tArr3 == null) {
                    $$$reportNull$$$0(6);
                }
                return tArr3;
            }
            if (i5 != 0) {
                System.arraycopy(this.myElem, 0, tArr, 0, i5);
            }
        }
        int i6 = this.mySize;
        if (length > i6) {
            tArr[i6] = 0;
        }
        return tArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i5, E e5) {
        int i6;
        if (i5 >= 0 && i5 <= (i6 = this.mySize)) {
            if (i6 == 0) {
                this.myElem = e5;
            } else if (i6 == 1 && i5 == 0) {
                this.myElem = new Object[]{e5, this.myElem};
            } else {
                Object[] objArr = new Object[i6 + 1];
                if (i6 == 1) {
                    objArr[0] = this.myElem;
                } else {
                    Object[] objArr2 = (Object[]) this.myElem;
                    System.arraycopy(objArr2, 0, objArr, 0, i5);
                    System.arraycopy(objArr2, i5, objArr, i5 + 1, this.mySize - i5);
                }
                objArr[i5] = e5;
                this.myElem = objArr;
            }
            this.mySize++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("Index: " + i5 + ", Size: " + this.mySize);
    }
}
