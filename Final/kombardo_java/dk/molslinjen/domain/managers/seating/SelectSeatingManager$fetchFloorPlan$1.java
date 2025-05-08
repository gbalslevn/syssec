package dk.molslinjen.domain.managers.seating;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.seating.SelectSeatingManager", f = "SelectSeatingManager.kt", l = {90}, m = "fetchFloorPlan")
/* loaded from: classes2.dex */
public final class SelectSeatingManager$fetchFloorPlan$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SelectSeatingManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectSeatingManager$fetchFloorPlan$1(SelectSeatingManager selectSeatingManager, Continuation<? super SelectSeatingManager$fetchFloorPlan$1> continuation) {
        super(continuation);
        this.this$0 = selectSeatingManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchFloorPlan(null, this);
    }
}
