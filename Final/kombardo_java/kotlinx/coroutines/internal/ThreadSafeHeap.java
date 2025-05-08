package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0004j\u0002`\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0082\u0010¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0082\u0010¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0016\u0010\u0015J\u0015\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00028\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001b\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0004\b\u001b\u0010\u0015J\u0017\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\bH\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\u001f\u0010 R \u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R$\u0010'\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b8F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\fR\u0011\u0010(\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u000b\u0010+\u001a\u00020*8\u0002X\u0082\u0004¨\u0006,"}, d2 = {"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", BuildConfig.FLAVOR, "T", BuildConfig.FLAVOR, "Lkotlinx/coroutines/internal/SynchronizedObject;", "<init>", "()V", BuildConfig.FLAVOR, "i", BuildConfig.FLAVOR, "siftUpFrom", "(I)V", "siftDownFrom", BuildConfig.FLAVOR, "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "j", "swap", "(II)V", "peek", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstOrNull", "node", BuildConfig.FLAVOR, "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "firstImpl", "index", "removeAtImpl", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "addImpl", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "a", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "value", "getSize", "()I", "setSize", "size", "isEmpty", "()Z", "Lkotlinx/atomicfu/AtomicInt;", "_size", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {
    private static final AtomicIntegerFieldUpdater _size$FU = AtomicIntegerFieldUpdater.newUpdater(ThreadSafeHeap.class, "_size");
    private volatile int _size;
    private T[] a;

    private final T[] realloc() {
        T[] tArr = this.a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new ThreadSafeHeapNode[4];
            this.a = tArr2;
            return tArr2;
        }
        if (getSize() < tArr.length) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, getSize() * 2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        T[] tArr3 = (T[]) ((ThreadSafeHeapNode[]) copyOf);
        this.a = tArr3;
        return tArr3;
    }

    private final void setSize(int i5) {
        _size$FU.set(this, i5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0028, code lost:
    
        if (((java.lang.Comparable) r3).compareTo(r4) < 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void siftDownFrom(int i5) {
        while (true) {
            int i6 = i5 * 2;
            int i7 = i6 + 1;
            if (i7 >= getSize()) {
                return;
            }
            T[] tArr = this.a;
            Intrinsics.checkNotNull(tArr);
            int i8 = i6 + 2;
            if (i8 < getSize()) {
                T t5 = tArr[i8];
                Intrinsics.checkNotNull(t5);
                T t6 = tArr[i7];
                Intrinsics.checkNotNull(t6);
            }
            i8 = i7;
            T t7 = tArr[i5];
            Intrinsics.checkNotNull(t7);
            T t8 = tArr[i8];
            Intrinsics.checkNotNull(t8);
            if (((Comparable) t7).compareTo(t8) <= 0) {
                return;
            }
            swap(i5, i8);
            i5 = i8;
        }
    }

    private final void siftUpFrom(int i5) {
        while (i5 > 0) {
            T[] tArr = this.a;
            Intrinsics.checkNotNull(tArr);
            int i6 = (i5 - 1) / 2;
            T t5 = tArr[i6];
            Intrinsics.checkNotNull(t5);
            T t6 = tArr[i5];
            Intrinsics.checkNotNull(t6);
            if (((Comparable) t5).compareTo(t6) <= 0) {
                return;
            }
            swap(i5, i6);
            i5 = i6;
        }
    }

    private final void swap(int i5, int j5) {
        T[] tArr = this.a;
        Intrinsics.checkNotNull(tArr);
        T t5 = tArr[j5];
        Intrinsics.checkNotNull(t5);
        T t6 = tArr[i5];
        Intrinsics.checkNotNull(t6);
        tArr[i5] = t5;
        tArr[j5] = t6;
        t5.setIndex(i5);
        t6.setIndex(j5);
    }

    public final void addImpl(T node) {
        node.setHeap(this);
        T[] realloc = realloc();
        int size = getSize();
        setSize(size + 1);
        realloc[size] = node;
        node.setIndex(size);
        siftUpFrom(size);
    }

    public final T firstImpl() {
        T[] tArr = this.a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int getSize() {
        return _size$FU.get(this);
    }

    public final boolean isEmpty() {
        return getSize() == 0;
    }

    public final T peek() {
        T firstImpl;
        synchronized (this) {
            firstImpl = firstImpl();
        }
        return firstImpl;
    }

    public final boolean remove(T node) {
        boolean z5;
        synchronized (this) {
            if (node.getHeap() == null) {
                z5 = false;
            } else {
                removeAtImpl(node.getIndex());
                z5 = true;
            }
        }
        return z5;
    }

    public final T removeAtImpl(int index) {
        T[] tArr = this.a;
        Intrinsics.checkNotNull(tArr);
        setSize(getSize() - 1);
        if (index < getSize()) {
            swap(index, getSize());
            int i5 = (index - 1) / 2;
            if (index > 0) {
                T t5 = tArr[index];
                Intrinsics.checkNotNull(t5);
                T t6 = tArr[i5];
                Intrinsics.checkNotNull(t6);
                if (((Comparable) t5).compareTo(t6) < 0) {
                    swap(index, i5);
                    siftUpFrom(i5);
                }
            }
            siftDownFrom(index);
        }
        T t7 = tArr[getSize()];
        Intrinsics.checkNotNull(t7);
        t7.setHeap(null);
        t7.setIndex(-1);
        tArr[getSize()] = null;
        return t7;
    }

    public final T removeFirstOrNull() {
        T removeAtImpl;
        synchronized (this) {
            removeAtImpl = getSize() > 0 ? removeAtImpl(0) : null;
        }
        return removeAtImpl;
    }
}
