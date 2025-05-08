package dk.molslinjen.ui.views.screens.tickets.barcodeDetails;

import dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardManager;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.SaleOnBoardBarcodeDetailsViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.tickets.barcodeDetails.SaleOnBoardBarcodeDetailsViewModel$loadData$1", f = "SaleOnBoardBarcodeDetailsViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class SaleOnBoardBarcodeDetailsViewModel$loadData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SaleOnBoardBarcodeDetailsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaleOnBoardBarcodeDetailsViewModel$loadData$1(SaleOnBoardBarcodeDetailsViewModel saleOnBoardBarcodeDetailsViewModel, Continuation<? super SaleOnBoardBarcodeDetailsViewModel$loadData$1> continuation) {
        super(2, continuation);
        this.this$0 = saleOnBoardBarcodeDetailsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SaleOnBoardBarcodeDetailsViewModel$loadData$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ISaleOnBoardManager iSaleOnBoardManager;
        Object obj2;
        MutableStateFlow mutableStateFlow;
        Object value;
        SaleOnBoardBarcodeDetailsScreenNavArgs saleOnBoardBarcodeDetailsScreenNavArgs;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        iSaleOnBoardManager = this.this$0.saleOnBoardManager;
        List<SaleOnBoardOrder> orders = iSaleOnBoardManager.getSaleOnBoardState().getValue().getOrders();
        SaleOnBoardBarcodeDetailsViewModel saleOnBoardBarcodeDetailsViewModel = this.this$0;
        Iterator<T> it = orders.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            String orderNumber = ((SaleOnBoardOrder) obj2).getOrderNumber();
            saleOnBoardBarcodeDetailsScreenNavArgs = saleOnBoardBarcodeDetailsViewModel.navArgs;
            if (Intrinsics.areEqual(orderNumber, saleOnBoardBarcodeDetailsScreenNavArgs.getOrderNumber())) {
                break;
            }
        }
        SaleOnBoardOrder saleOnBoardOrder = (SaleOnBoardOrder) obj2;
        if (saleOnBoardOrder != null) {
            mutableStateFlow = this.this$0._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, ((SaleOnBoardBarcodeDetailsViewModel.ViewState) value).copy(saleOnBoardOrder)));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SaleOnBoardBarcodeDetailsViewModel$loadData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
