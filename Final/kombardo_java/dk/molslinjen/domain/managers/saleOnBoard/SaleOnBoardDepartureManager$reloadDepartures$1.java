package dk.molslinjen.domain.managers.saleOnBoard;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardDepartureManager$reloadDepartures$1", f = "SaleOnBoardDepartureManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class SaleOnBoardDepartureManager$reloadDepartures$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SaleOnBoardDepartureManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaleOnBoardDepartureManager$reloadDepartures$1(SaleOnBoardDepartureManager saleOnBoardDepartureManager, Continuation<? super SaleOnBoardDepartureManager$reloadDepartures$1> continuation) {
        super(2, continuation);
        this.this$0 = saleOnBoardDepartureManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SaleOnBoardDepartureManager$reloadDepartures$1 saleOnBoardDepartureManager$reloadDepartures$1 = new SaleOnBoardDepartureManager$reloadDepartures$1(this.this$0, continuation);
        saleOnBoardDepartureManager$reloadDepartures$1.L$0 = obj;
        return saleOnBoardDepartureManager$reloadDepartures$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ISaleOnBoardRouteManager iSaleOnBoardRouteManager;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        iSaleOnBoardRouteManager = this.this$0.saleOnBoardRouteManager;
        SaleOnBoardRouteState value = iSaleOnBoardRouteManager.getRouteState().getValue();
        if (value == null) {
            return Unit.INSTANCE;
        }
        this.this$0.startLoadingDepartures(coroutineScope, value);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SaleOnBoardDepartureManager$reloadDepartures$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
