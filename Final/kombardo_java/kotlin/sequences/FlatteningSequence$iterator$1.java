package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.conscrypt.BuildConfig;

/* JADX INFO: Add missing generic type declarations: [E] */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\u0004R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00018\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR*\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"kotlin/sequences/FlatteningSequence$iterator$1", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "ensureItemIterator", "()Z", "next", "()Ljava/lang/Object;", "hasNext", "iterator", "Ljava/util/Iterator;", "getIterator", "()Ljava/util/Iterator;", "itemIterator", "getItemIterator", "setItemIterator", "(Ljava/util/Iterator;)V", BuildConfig.FLAVOR, "state", "I", "getState", "()I", "setState", "(I)V", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FlatteningSequence$iterator$1<E> implements Iterator<E>, KMappedMarker {
    private Iterator<? extends E> itemIterator;
    private final Iterator<T> iterator;
    private int state;
    final /* synthetic */ FlatteningSequence<T, R, E> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlatteningSequence$iterator$1(FlatteningSequence<T, R, E> flatteningSequence) {
        Sequence sequence;
        this.this$0 = flatteningSequence;
        sequence = ((FlatteningSequence) flatteningSequence).sequence;
        this.iterator = sequence.iterator();
    }

    private final boolean ensureItemIterator() {
        Function1 function1;
        Function1 function12;
        Iterator<? extends E> it = this.itemIterator;
        if (it != null && it.hasNext()) {
            this.state = 1;
            return true;
        }
        while (this.iterator.hasNext()) {
            Object next = this.iterator.next();
            function1 = ((FlatteningSequence) this.this$0).iterator;
            function12 = ((FlatteningSequence) this.this$0).transformer;
            Iterator<? extends E> it2 = (Iterator) function1.invoke(function12.invoke(next));
            if (it2.hasNext()) {
                this.itemIterator = it2;
                this.state = 1;
                return true;
            }
        }
        this.state = 2;
        this.itemIterator = null;
        return false;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i5 = this.state;
        if (i5 == 1) {
            return true;
        }
        if (i5 == 2) {
            return false;
        }
        return ensureItemIterator();
    }

    @Override // java.util.Iterator
    public E next() {
        int i5 = this.state;
        if (i5 == 2) {
            throw new NoSuchElementException();
        }
        if (i5 == 0 && !ensureItemIterator()) {
            throw new NoSuchElementException();
        }
        this.state = 0;
        Iterator<? extends E> it = this.itemIterator;
        Intrinsics.checkNotNull(it);
        return it.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
