package kotlinx.coroutines.internal;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00028\u0000H&¢\u0006\u0004\b\n\u0010\bJ!\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00028\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000f\u0010\bR\u0013\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00108\u0002X\u0082\u0004¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/internal/AtomicOp;", "T", "Lkotlinx/coroutines/internal/OpDescriptor;", "<init>", "()V", BuildConfig.FLAVOR, "decision", "decide", "(Ljava/lang/Object;)Ljava/lang/Object;", "affected", "prepare", "failure", BuildConfig.FLAVOR, "complete", "(Ljava/lang/Object;Ljava/lang/Object;)V", "perform", "Lkotlinx/atomicfu/AtomicRef;", "_consensus", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class AtomicOp<T> extends OpDescriptor {
    private static final AtomicReferenceFieldUpdater _consensus$FU = AtomicReferenceFieldUpdater.newUpdater(AtomicOp.class, Object.class, "_consensus");
    private volatile Object _consensus = AtomicKt.NO_DECISION;

    private final Object decide(Object decision) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _consensus$FU;
        Object obj = atomicReferenceFieldUpdater.get(this);
        Object obj2 = AtomicKt.NO_DECISION;
        return obj != obj2 ? obj : a.a(atomicReferenceFieldUpdater, this, obj2, decision) ? decision : atomicReferenceFieldUpdater.get(this);
    }

    public abstract void complete(T affected, Object failure);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.OpDescriptor
    public final Object perform(Object affected) {
        Object obj = _consensus$FU.get(this);
        if (obj == AtomicKt.NO_DECISION) {
            obj = decide(prepare(affected));
        }
        complete(affected, obj);
        return obj;
    }

    public abstract Object prepare(T affected);
}
