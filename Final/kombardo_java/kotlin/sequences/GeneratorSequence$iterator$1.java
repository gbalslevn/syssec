package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.conscrypt.BuildConfig;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010(\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"kotlin/sequences/GeneratorSequence$iterator$1", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "calcNext", "()V", "next", "()Ljava/lang/Object;", BuildConfig.FLAVOR, "hasNext", "()Z", "nextItem", "Ljava/lang/Object;", "getNextItem", "setNextItem", "(Ljava/lang/Object;)V", BuildConfig.FLAVOR, "nextState", "I", "getNextState", "()I", "setNextState", "(I)V", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GeneratorSequence$iterator$1<T> implements Iterator<T>, KMappedMarker {
    private T nextItem;
    private int nextState = -2;
    final /* synthetic */ GeneratorSequence<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeneratorSequence$iterator$1(GeneratorSequence<T> generatorSequence) {
        this.this$0 = generatorSequence;
    }

    private final void calcNext() {
        Function1 function1;
        T t5;
        Function0 function0;
        if (this.nextState == -2) {
            function0 = ((GeneratorSequence) this.this$0).getInitialValue;
            t5 = (T) function0.invoke();
        } else {
            function1 = ((GeneratorSequence) this.this$0).getNextValue;
            T t6 = this.nextItem;
            Intrinsics.checkNotNull(t6);
            t5 = (T) function1.invoke(t6);
        }
        this.nextItem = t5;
        this.nextState = t5 == null ? 0 : 1;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nextState < 0) {
            calcNext();
        }
        return this.nextState == 1;
    }

    @Override // java.util.Iterator
    public T next() {
        if (this.nextState < 0) {
            calcNext();
        }
        if (this.nextState == 0) {
            throw new NoSuchElementException();
        }
        T t5 = this.nextItem;
        Intrinsics.checkNotNull(t5, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
        this.nextState = -1;
        return t5;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
