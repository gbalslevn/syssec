package androidx.collection;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Add missing generic type declarations: [E] */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0010)\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"androidx/collection/MutableScatterSet$MutableSetWrapper$iterator$1", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "hasNext", "()Z", "next", "()Ljava/lang/Object;", BuildConfig.FLAVOR, "remove", "()V", BuildConfig.FLAVOR, "current", "I", "getCurrent", "()I", "setCurrent", "(I)V", BuildConfig.FLAVOR, "iterator", "Ljava/util/Iterator;", "getIterator", "()Ljava/util/Iterator;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableScatterSet$MutableSetWrapper$iterator$1<E> implements Iterator<E>, KMappedMarker {
    private int current = -1;
    private final Iterator<E> iterator;
    final /* synthetic */ MutableScatterSet<E> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MutableScatterSet$MutableSetWrapper$iterator$1(MutableScatterSet<E> mutableScatterSet) {
        this.this$0 = mutableScatterSet;
        this.iterator = SequencesKt.iterator(new MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1(mutableScatterSet, this, null));
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public E next() {
        return this.iterator.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        int i5 = this.current;
        if (i5 != -1) {
            this.this$0.removeElementAt(i5);
            this.current = -1;
        }
    }

    public final void setCurrent(int i5) {
        this.current = i5;
    }
}
