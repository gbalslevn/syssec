package dk.molslinjen.domain.managers.agreement.multiride.purchase;

import dk.molslinjen.api.services.multiRide.response.MultiRideSummaryResponseDTO;
import dk.molslinjen.domain.managers.agreement.multiride.IMultiRideManager;
import dk.molslinjen.domain.managers.agreement.multiride.purchase.IMultiRideCardCheckoutManager;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCardSummaryInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Ldk/molslinjen/api/services/multiRide/response/MultiRideSummaryResponseDTO;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.agreement.multiride.purchase.MultiRideCardCheckoutManager$loadReceiptInfo$2", f = "MultiRideCardCheckoutManager.kt", l = {147}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class MultiRideCardCheckoutManager$loadReceiptInfo$2 extends SuspendLambda implements Function2<MultiRideSummaryResponseDTO, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MultiRideCardCheckoutManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiRideCardCheckoutManager$loadReceiptInfo$2(MultiRideCardCheckoutManager multiRideCardCheckoutManager, Continuation<? super MultiRideCardCheckoutManager$loadReceiptInfo$2> continuation) {
        super(2, continuation);
        this.this$0 = multiRideCardCheckoutManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MultiRideCardCheckoutManager$loadReceiptInfo$2 multiRideCardCheckoutManager$loadReceiptInfo$2 = new MultiRideCardCheckoutManager$loadReceiptInfo$2(this.this$0, continuation);
        multiRideCardCheckoutManager$loadReceiptInfo$2.L$0 = obj;
        return multiRideCardCheckoutManager$loadReceiptInfo$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(MultiRideSummaryResponseDTO multiRideSummaryResponseDTO, Continuation<? super Unit> continuation) {
        return ((MultiRideCardCheckoutManager$loadReceiptInfo$2) create(multiRideSummaryResponseDTO, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IMultiRideCardCheckoutManager.CheckoutState value;
        MultiRideCardSummaryInfo createSummaryInfo;
        IMultiRideCardCheckoutManager.CheckoutState copy;
        IMultiRideManager iMultiRideManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            MultiRideSummaryResponseDTO multiRideSummaryResponseDTO = (MultiRideSummaryResponseDTO) this.L$0;
            MutableStateFlow<IMultiRideCardCheckoutManager.CheckoutState> checkoutState = this.this$0.getCheckoutState();
            MultiRideCardCheckoutManager multiRideCardCheckoutManager = this.this$0;
            do {
                value = checkoutState.getValue();
                createSummaryInfo = multiRideCardCheckoutManager.createSummaryInfo(multiRideSummaryResponseDTO.getMultiRideTicket());
                copy = r7.copy((r26 & 1) != 0 ? r7.flowOrigin : null, (r26 & 2) != 0 ? r7.siteInfo : null, (r26 & 4) != 0 ? r7.multiRideCardToRefill : null, (r26 & 8) != 0 ? r7.purchaseInfos : null, (r26 & 16) != 0 ? r7.selectedPurchaseInfo : null, (r26 & 32) != 0 ? r7.numberOfCharges : 0, (r26 & 64) != 0 ? r7.selectedPriceStep : null, (r26 & 128) != 0 ? r7.totalPrice : null, (r26 & 256) != 0 ? r7.personalInfo : null, (r26 & 512) != 0 ? r7.selectedPaymentType : null, (r26 & 1024) != 0 ? r7.selectedCreditCard : null, (r26 & 2048) != 0 ? value.summaryCardInfo : createSummaryInfo);
            } while (!checkoutState.compareAndSet(value, copy));
            String cardNumber = multiRideSummaryResponseDTO.getMultiRideTicket().getCardNumber();
            if (cardNumber != null) {
                MultiRideCardCheckoutManager multiRideCardCheckoutManager2 = this.this$0;
                iMultiRideManager = multiRideCardCheckoutManager2.multiRideManager;
                String email = multiRideCardCheckoutManager2.getCheckoutState().getValue().getPersonalInfo().getEmail();
                this.label = 1;
                if (iMultiRideManager.addMultiRide(cardNumber, email, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
