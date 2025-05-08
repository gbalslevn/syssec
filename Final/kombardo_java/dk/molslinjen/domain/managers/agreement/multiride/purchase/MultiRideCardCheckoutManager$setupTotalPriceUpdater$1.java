package dk.molslinjen.domain.managers.agreement.multiride.purchase;

import dk.molslinjen.domain.managers.agreement.multiride.purchase.IMultiRideCardCheckoutManager;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRidePriceStep;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.agreement.multiride.purchase.MultiRideCardCheckoutManager$setupTotalPriceUpdater$1", f = "MultiRideCardCheckoutManager.kt", l = {178}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class MultiRideCardCheckoutManager$setupTotalPriceUpdater$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MultiRideCardCheckoutManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "currentState", "Ldk/molslinjen/domain/managers/agreement/multiride/purchase/IMultiRideCardCheckoutManager$CheckoutState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.agreement.multiride.purchase.MultiRideCardCheckoutManager$setupTotalPriceUpdater$1$1", f = "MultiRideCardCheckoutManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.agreement.multiride.purchase.MultiRideCardCheckoutManager$setupTotalPriceUpdater$1$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<IMultiRideCardCheckoutManager.CheckoutState, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MultiRideCardCheckoutManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MultiRideCardCheckoutManager multiRideCardCheckoutManager, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = multiRideCardCheckoutManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(IMultiRideCardCheckoutManager.CheckoutState checkoutState, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(checkoutState, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IMultiRideCardCheckoutManager.CheckoutState copy;
            PriceWithCurrency price;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            IMultiRideCardCheckoutManager.CheckoutState checkoutState = (IMultiRideCardCheckoutManager.CheckoutState) this.L$0;
            MultiRidePriceStep selectedPriceStep = checkoutState.getSelectedPriceStep();
            PriceWithCurrency times = (selectedPriceStep == null || (price = selectedPriceStep.getPrice()) == null) ? null : price.times(checkoutState.getNumberOfCharges());
            MutableStateFlow<IMultiRideCardCheckoutManager.CheckoutState> checkoutState2 = this.this$0.getCheckoutState();
            while (true) {
                IMultiRideCardCheckoutManager.CheckoutState value = checkoutState2.getValue();
                MutableStateFlow<IMultiRideCardCheckoutManager.CheckoutState> mutableStateFlow = checkoutState2;
                copy = r2.copy((r26 & 1) != 0 ? r2.flowOrigin : null, (r26 & 2) != 0 ? r2.siteInfo : null, (r26 & 4) != 0 ? r2.multiRideCardToRefill : null, (r26 & 8) != 0 ? r2.purchaseInfos : null, (r26 & 16) != 0 ? r2.selectedPurchaseInfo : null, (r26 & 32) != 0 ? r2.numberOfCharges : 0, (r26 & 64) != 0 ? r2.selectedPriceStep : null, (r26 & 128) != 0 ? r2.totalPrice : times, (r26 & 256) != 0 ? r2.personalInfo : null, (r26 & 512) != 0 ? r2.selectedPaymentType : null, (r26 & 1024) != 0 ? r2.selectedCreditCard : null, (r26 & 2048) != 0 ? value.summaryCardInfo : null);
                if (mutableStateFlow.compareAndSet(value, copy)) {
                    return Unit.INSTANCE;
                }
                checkoutState2 = mutableStateFlow;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiRideCardCheckoutManager$setupTotalPriceUpdater$1(MultiRideCardCheckoutManager multiRideCardCheckoutManager, Continuation<? super MultiRideCardCheckoutManager$setupTotalPriceUpdater$1> continuation) {
        super(2, continuation);
        this.this$0 = multiRideCardCheckoutManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MultiRideCardCheckoutManager$setupTotalPriceUpdater$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableStateFlow<IMultiRideCardCheckoutManager.CheckoutState> checkoutState = this.this$0.getCheckoutState();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (FlowKt.collectLatest(checkoutState, anonymousClass1, this) == coroutine_suspended) {
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
        return ((MultiRideCardCheckoutManager$setupTotalPriceUpdater$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
