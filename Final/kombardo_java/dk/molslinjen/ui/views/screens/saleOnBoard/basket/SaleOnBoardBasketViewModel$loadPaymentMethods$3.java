package dk.molslinjen.ui.views.screens.saleOnBoard.basket;

import dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardCheckoutManager;
import dk.molslinjen.domain.managers.user.creditcards.IUserCreditCardsManager;
import dk.molslinjen.domain.model.account.CreditCard;
import dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardBasketViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardBasketViewModel$loadPaymentMethods$3", f = "SaleOnBoardBasketViewModel.kt", l = {141}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class SaleOnBoardBasketViewModel$loadPaymentMethods$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SaleOnBoardBasketViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaleOnBoardBasketViewModel$loadPaymentMethods$3(SaleOnBoardBasketViewModel saleOnBoardBasketViewModel, Continuation<? super SaleOnBoardBasketViewModel$loadPaymentMethods$3> continuation) {
        super(2, continuation);
        this.this$0 = saleOnBoardBasketViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(SaleOnBoardBasketViewModel saleOnBoardBasketViewModel, List list) {
        MutableStateFlow mutableStateFlow;
        Object value;
        ISaleOnBoardCheckoutManager iSaleOnBoardCheckoutManager;
        mutableStateFlow = saleOnBoardBasketViewModel._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, SaleOnBoardBasketViewModel.ViewState.copy$default((SaleOnBoardBasketViewModel.ViewState) value, false, false, null, null, list, false, null, null, null, 495, null)));
        if (!list.isEmpty()) {
            iSaleOnBoardCheckoutManager = saleOnBoardBasketViewModel.saleOnBoardCheckoutManager;
            iSaleOnBoardCheckoutManager.selectPaymentMethod(saleOnBoardBasketViewModel.getSaleOnBoardCheckoutState().getValue().getSelectedPaymentType(), (CreditCard) CollectionsKt.firstOrNull(list));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SaleOnBoardBasketViewModel$loadPaymentMethods$3(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IUserCreditCardsManager iUserCreditCardsManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iUserCreditCardsManager = this.this$0.creditCardsManager;
            final SaleOnBoardBasketViewModel saleOnBoardBasketViewModel = this.this$0;
            Function1<? super List<CreditCard>, Unit> function1 = new Function1() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.basket.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = SaleOnBoardBasketViewModel$loadPaymentMethods$3.invokeSuspend$lambda$1(SaleOnBoardBasketViewModel.this, (List) obj2);
                    return invokeSuspend$lambda$1;
                }
            };
            this.label = 1;
            if (iUserCreditCardsManager.collectLatestValidCards(function1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SaleOnBoardBasketViewModel$loadPaymentMethods$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
