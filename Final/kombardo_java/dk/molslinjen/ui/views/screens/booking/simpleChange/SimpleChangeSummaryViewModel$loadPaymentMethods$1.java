package dk.molslinjen.ui.views.screens.booking.simpleChange;

import dk.molslinjen.domain.managers.checkout.IPaymentManager;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.shared.CurrencyType;
import dk.molslinjen.ui.views.screens.booking.simpleChange.SimpleChangeSummaryViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.simpleChange.SimpleChangeSummaryViewModel$loadPaymentMethods$1", f = "SimpleChangeSummaryViewModel.kt", l = {51}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class SimpleChangeSummaryViewModel$loadPaymentMethods$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Booking $booking;
    int label;
    final /* synthetic */ SimpleChangeSummaryViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleChangeSummaryViewModel$loadPaymentMethods$1(SimpleChangeSummaryViewModel simpleChangeSummaryViewModel, Booking booking, Continuation<? super SimpleChangeSummaryViewModel$loadPaymentMethods$1> continuation) {
        super(2, continuation);
        this.this$0 = simpleChangeSummaryViewModel;
        this.$booking = booking;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SimpleChangeSummaryViewModel$loadPaymentMethods$1(this.this$0, this.$booking, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IPaymentManager iPaymentManager;
        MutableStateFlow mutableStateFlow;
        Object value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iPaymentManager = this.this$0.paymentManager;
            Site site = this.$booking.getSite();
            CurrencyType currencyType = this.$booking.getOrderTotal().getPrice().getCurrencyType();
            this.label = 1;
            obj = iPaymentManager.getPaymentMethodsForOthers(site, currencyType, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        List list = (List) obj;
        mutableStateFlow = this.this$0._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, SimpleChangeSummaryViewModel.ViewState.copy$default((SimpleChangeSummaryViewModel.ViewState) value, false, null, list, null, 11, null)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SimpleChangeSummaryViewModel$loadPaymentMethods$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
