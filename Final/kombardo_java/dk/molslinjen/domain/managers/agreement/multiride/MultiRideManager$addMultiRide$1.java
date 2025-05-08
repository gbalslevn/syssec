package dk.molslinjen.domain.managers.agreement.multiride;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager", f = "MultiRideManager.kt", l = {75, 76, 80, 82, 83, 87}, m = "addMultiRide")
/* loaded from: classes2.dex */
public final class MultiRideManager$addMultiRide$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MultiRideManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiRideManager$addMultiRide$1(MultiRideManager multiRideManager, Continuation<? super MultiRideManager$addMultiRide$1> continuation) {
        super(continuation);
        this.this$0 = multiRideManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.addMultiRide(null, null, this);
    }
}
