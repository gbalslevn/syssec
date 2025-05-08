package dk.molslinjen.ui.views.screens.booking.summary;

import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.user.creditcards.IUserCreditCardsManager;
import dk.molslinjen.domain.model.account.CreditCard;
import dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryViewModel;
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
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryViewModel$loadPaymentMethods$3", f = "BookingSummaryViewModel.kt", l = {161}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class BookingSummaryViewModel$loadPaymentMethods$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BookingSummaryViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookingSummaryViewModel$loadPaymentMethods$3(BookingSummaryViewModel bookingSummaryViewModel, Continuation<? super BookingSummaryViewModel$loadPaymentMethods$3> continuation) {
        super(2, continuation);
        this.this$0 = bookingSummaryViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(BookingSummaryViewModel bookingSummaryViewModel, List list) {
        MutableStateFlow mutableStateFlow;
        Object value;
        mutableStateFlow = bookingSummaryViewModel._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, BookingSummaryViewModel.ViewState.copy$default((BookingSummaryViewModel.ViewState) value, null, null, list, false, false, 27, null)));
        if (!list.isEmpty()) {
            CheckoutManager.CheckoutState value2 = bookingSummaryViewModel.checkoutManager.getCheckoutState().getValue();
            if (value2 == null) {
                return Unit.INSTANCE;
            }
            bookingSummaryViewModel.checkoutManager.selectPaymentMethod(value2.getSelectedPaymentType(), (CreditCard) CollectionsKt.firstOrNull(list));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BookingSummaryViewModel$loadPaymentMethods$3(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IUserCreditCardsManager iUserCreditCardsManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iUserCreditCardsManager = this.this$0.creditCardsManager;
            final BookingSummaryViewModel bookingSummaryViewModel = this.this$0;
            Function1<? super List<CreditCard>, Unit> function1 = new Function1() { // from class: dk.molslinjen.ui.views.screens.booking.summary.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = BookingSummaryViewModel$loadPaymentMethods$3.invokeSuspend$lambda$1(BookingSummaryViewModel.this, (List) obj2);
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
        return ((BookingSummaryViewModel$loadPaymentMethods$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
