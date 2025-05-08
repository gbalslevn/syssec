package kotlin.collections;

import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.conscrypt.BuildConfig;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010+\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u0010R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"kotlin/collections/ReversedList$listIterator$1", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "hasNext", "()Z", "hasPrevious", "next", "()Ljava/lang/Object;", BuildConfig.FLAVOR, "nextIndex", "()I", "previous", "previousIndex", "element", BuildConfig.FLAVOR, "add", "(Ljava/lang/Object;)V", "remove", "()V", "set", "delegateIterator", "Ljava/util/ListIterator;", "getDelegateIterator", "()Ljava/util/ListIterator;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ReversedList$listIterator$1<T> implements ListIterator<T>, KMappedMarker {
    private final ListIterator<T> delegateIterator;
    final /* synthetic */ ReversedList<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReversedList$listIterator$1(ReversedList<T> reversedList, int i5) {
        List list;
        int reversePositionIndex$CollectionsKt__ReversedViewsKt;
        this.this$0 = reversedList;
        list = ((ReversedList) reversedList).delegate;
        reversePositionIndex$CollectionsKt__ReversedViewsKt = CollectionsKt__ReversedViewsKt.reversePositionIndex$CollectionsKt__ReversedViewsKt(reversedList, i5);
        this.delegateIterator = list.listIterator(reversePositionIndex$CollectionsKt__ReversedViewsKt);
    }

    @Override // java.util.ListIterator
    public void add(T element) {
        this.delegateIterator.add(element);
        this.delegateIterator.previous();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.delegateIterator.hasPrevious();
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.delegateIterator.hasNext();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public T next() {
        return this.delegateIterator.previous();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        int reverseIteratorIndex$CollectionsKt__ReversedViewsKt;
        reverseIteratorIndex$CollectionsKt__ReversedViewsKt = CollectionsKt__ReversedViewsKt.reverseIteratorIndex$CollectionsKt__ReversedViewsKt(this.this$0, this.delegateIterator.previousIndex());
        return reverseIteratorIndex$CollectionsKt__ReversedViewsKt;
    }

    @Override // java.util.ListIterator
    public T previous() {
        return this.delegateIterator.next();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        int reverseIteratorIndex$CollectionsKt__ReversedViewsKt;
        reverseIteratorIndex$CollectionsKt__ReversedViewsKt = CollectionsKt__ReversedViewsKt.reverseIteratorIndex$CollectionsKt__ReversedViewsKt(this.this$0, this.delegateIterator.nextIndex());
        return reverseIteratorIndex$CollectionsKt__ReversedViewsKt;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        this.delegateIterator.remove();
    }

    @Override // java.util.ListIterator
    public void set(T element) {
        this.delegateIterator.set(element);
    }
}
