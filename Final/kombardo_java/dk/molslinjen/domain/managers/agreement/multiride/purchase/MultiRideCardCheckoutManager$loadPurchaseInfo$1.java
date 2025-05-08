package dk.molslinjen.domain.managers.agreement.multiride.purchase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.agreement.multiride.purchase.MultiRideCardCheckoutManager", f = "MultiRideCardCheckoutManager.kt", l = {191, 191}, m = "loadPurchaseInfo")
/* loaded from: classes2.dex */
public final class MultiRideCardCheckoutManager$loadPurchaseInfo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MultiRideCardCheckoutManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiRideCardCheckoutManager$loadPurchaseInfo$1(MultiRideCardCheckoutManager multiRideCardCheckoutManager, Continuation<? super MultiRideCardCheckoutManager$loadPurchaseInfo$1> continuation) {
        super(continuation);
        this.this$0 = multiRideCardCheckoutManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object loadPurchaseInfo;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        loadPurchaseInfo = this.this$0.loadPurchaseInfo(null, null, this);
        return loadPurchaseInfo;
    }
}
