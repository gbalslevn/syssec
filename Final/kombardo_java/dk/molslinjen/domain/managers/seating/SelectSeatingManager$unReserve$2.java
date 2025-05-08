package dk.molslinjen.domain.managers.seating;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.seating.SelectSeatingManager", f = "SelectSeatingManager.kt", l = {215}, m = "unReserve")
/* loaded from: classes2.dex */
public final class SelectSeatingManager$unReserve$2 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SelectSeatingManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectSeatingManager$unReserve$2(SelectSeatingManager selectSeatingManager, Continuation<? super SelectSeatingManager$unReserve$2> continuation) {
        super(continuation);
        this.this$0 = selectSeatingManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object unReserve;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        unReserve = this.this$0.unReserve(null, this);
        return unReserve;
    }
}
