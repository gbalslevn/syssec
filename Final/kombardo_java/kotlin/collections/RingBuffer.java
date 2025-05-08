package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\f\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B\u001f\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\n\u0010\rJ\u0018\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\bH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0001\u0010\u00012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0014¢\u0006\u0004\b\u0018\u0010\u001aJ\u001b\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00028\u0000¢\u0006\u0004\b \u0010!J\u0015\u0010#\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\b¢\u0006\u0004\b#\u0010\rR\u001c\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010$R\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010%R\u0016\u0010&\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010%R$\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b(\u0010%\u001a\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lkotlin/collections/RingBuffer;", "T", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "buffer", BuildConfig.FLAVOR, "filledSize", "<init>", "([Ljava/lang/Object;I)V", "capacity", "(I)V", "index", "get", "(I)Ljava/lang/Object;", BuildConfig.FLAVOR, "isFull", "()Z", BuildConfig.FLAVOR, "iterator", "()Ljava/util/Iterator;", "array", "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "()[Ljava/lang/Object;", "maxCapacity", "expanded", "(I)Lkotlin/collections/RingBuffer;", "element", BuildConfig.FLAVOR, "add", "(Ljava/lang/Object;)V", "n", "removeFirst", "[Ljava/lang/Object;", "I", "startIndex", "value", "size", "getSize", "()I", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class RingBuffer<T> extends AbstractList<T> implements RandomAccess {
    private final Object[] buffer;
    private final int capacity;
    private int size;
    private int startIndex;

    public RingBuffer(Object[] buffer, int i5) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.buffer = buffer;
        if (i5 >= 0) {
            if (i5 <= buffer.length) {
                this.capacity = buffer.length;
                this.size = i5;
                return;
            }
            throw new IllegalArgumentException(("ring buffer filled size: " + i5 + " cannot be larger than the buffer size: " + buffer.length).toString());
        }
        throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i5).toString());
    }

    @Override // java.util.Collection, java.util.List
    public final void add(T element) {
        if (isFull()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.buffer[(this.startIndex + size()) % this.capacity] = element;
        this.size = size() + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final RingBuffer<T> expanded(int maxCapacity) {
        Object[] array;
        int i5 = this.capacity;
        int coerceAtMost = RangesKt.coerceAtMost(i5 + (i5 >> 1) + 1, maxCapacity);
        if (this.startIndex == 0) {
            array = Arrays.copyOf(this.buffer, coerceAtMost);
            Intrinsics.checkNotNullExpressionValue(array, "copyOf(...)");
        } else {
            array = toArray(new Object[coerceAtMost]);
        }
        return new RingBuffer<>(array, size());
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public T get(int index) {
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, size());
        return (T) this.buffer[(this.startIndex + index) % this.capacity];
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return this.size;
    }

    public final boolean isFull() {
        return size() == this.capacity;
    }

    @Override // kotlin.collections.AbstractList, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<T> iterator() {
        return new AbstractIterator<T>(this) { // from class: kotlin.collections.RingBuffer$iterator$1
            private int count;
            private int index;
            final /* synthetic */ RingBuffer<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int i5;
                this.this$0 = this;
                this.count = this.size();
                i5 = ((RingBuffer) this).startIndex;
                this.index = i5;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.collections.AbstractIterator
            protected void computeNext() {
                Object[] objArr;
                if (this.count == 0) {
                    done();
                    return;
                }
                objArr = ((RingBuffer) this.this$0).buffer;
                setNext(objArr[this.index]);
                this.index = (this.index + 1) % ((RingBuffer) this.this$0).capacity;
                this.count--;
            }
        };
    }

    public final void removeFirst(int n5) {
        if (n5 < 0) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + n5).toString());
        }
        if (n5 > size()) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + n5 + ", size = " + size()).toString());
        }
        if (n5 > 0) {
            int i5 = this.startIndex;
            int i6 = (i5 + n5) % this.capacity;
            if (i5 > i6) {
                ArraysKt.fill(this.buffer, (Object) null, i5, this.capacity);
                ArraysKt.fill(this.buffer, (Object) null, 0, i6);
            } else {
                ArraysKt.fill(this.buffer, (Object) null, i5, i6);
            }
            this.startIndex = i6;
            this.size = size() - n5;
        }
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        int length = array.length;
        Object[] objArr = array;
        if (length < size()) {
            Object[] objArr2 = (T[]) Arrays.copyOf(array, size());
            Intrinsics.checkNotNullExpressionValue(objArr2, "copyOf(...)");
            objArr = objArr2;
        }
        int size = size();
        int i5 = 0;
        int i6 = 0;
        for (int i7 = this.startIndex; i6 < size && i7 < this.capacity; i7++) {
            objArr[i6] = this.buffer[i7];
            i6++;
        }
        while (i6 < size) {
            objArr[i6] = this.buffer[i5];
            i6++;
            i5++;
        }
        return (T[]) CollectionsKt.terminateCollectionToArray(size, objArr);
    }

    public RingBuffer(int i5) {
        this(new Object[i5], 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
