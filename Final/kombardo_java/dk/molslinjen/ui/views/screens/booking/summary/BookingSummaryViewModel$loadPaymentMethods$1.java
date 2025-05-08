package dk.molslinjen.ui.views.screens.booking.summary;

import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.checkout.IPaymentManager;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.shared.CurrencyType;
import dk.molslinjen.domain.model.site.SiteInfo;
import dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryViewModel;
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
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryViewModel$loadPaymentMethods$1", f = "BookingSummaryViewModel.kt", l = {147}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class BookingSummaryViewModel$loadPaymentMethods$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BookingSummaryViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookingSummaryViewModel$loadPaymentMethods$1(BookingSummaryViewModel bookingSummaryViewModel, Continuation<? super BookingSummaryViewModel$loadPaymentMethods$1> continuation) {
        super(2, continuation);
        this.this$0 = bookingSummaryViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BookingSummaryViewModel$loadPaymentMethods$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IPaymentManager iPaymentManager;
        Site site;
        CurrencyType currency;
        String routeId;
        MutableStateFlow mutableStateFlow;
        Object value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iPaymentManager = this.this$0.paymentManager;
            SiteInfo siteInfo = this.this$0.getViewState().getValue().getSiteInfo();
            if (siteInfo == null || (site = siteInfo.getSite()) == null) {
                return Unit.INSTANCE;
            }
            CheckoutManager.CheckoutState value2 = this.this$0.getCheckoutState().getValue();
            if (value2 == null || (currency = value2.getCurrency()) == null) {
                return Unit.INSTANCE;
            }
            CheckoutManager.CheckoutState value3 = this.this$0.getCheckoutState().getValue();
            if (value3 == null || (routeId = value3.getRouteId()) == null) {
                return Unit.INSTANCE;
            }
            this.label = 1;
            obj = iPaymentManager.getPaymentMethodsForBooking(site, currency, routeId, this);
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
        } while (!mutableStateFlow.compareAndSet(value, BookingSummaryViewModel.ViewState.copy$default((BookingSummaryViewModel.ViewState) value, null, list, null, false, false, 29, null)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BookingSummaryViewModel$loadPaymentMethods$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
