package dk.molslinjen.domain.managers.agreement.multiride.purchase;

import dk.molslinjen.api.services.multiRide.response.MultiRideSummaryResponseDTO;
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
@DebugMetadata(c = "dk.molslinjen.domain.managers.agreement.multiride.purchase.MultiRideCardCheckoutManager$loadSummaryInfo$2", f = "MultiRideCardCheckoutManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class MultiRideCardCheckoutManager$loadSummaryInfo$2 extends SuspendLambda implements Function2<MultiRideSummaryResponseDTO, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MultiRideCardCheckoutManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiRideCardCheckoutManager$loadSummaryInfo$2(MultiRideCardCheckoutManager multiRideCardCheckoutManager, Continuation<? super MultiRideCardCheckoutManager$loadSummaryInfo$2> continuation) {
        super(2, continuation);
        this.this$0 = multiRideCardCheckoutManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MultiRideCardCheckoutManager$loadSummaryInfo$2 multiRideCardCheckoutManager$loadSummaryInfo$2 = new MultiRideCardCheckoutManager$loadSummaryInfo$2(this.this$0, continuation);
        multiRideCardCheckoutManager$loadSummaryInfo$2.L$0 = obj;
        return multiRideCardCheckoutManager$loadSummaryInfo$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(MultiRideSummaryResponseDTO multiRideSummaryResponseDTO, Continuation<? super Unit> continuation) {
        return ((MultiRideCardCheckoutManager$loadSummaryInfo$2) create(multiRideSummaryResponseDTO, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IMultiRideCardCheckoutManager.CheckoutState value;
        MultiRideCardSummaryInfo createSummaryInfo;
        IMultiRideCardCheckoutManager.CheckoutState copy;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        MultiRideSummaryResponseDTO multiRideSummaryResponseDTO = (MultiRideSummaryResponseDTO) this.L$0;
        MutableStateFlow<IMultiRideCardCheckoutManager.CheckoutState> checkoutState = this.this$0.getCheckoutState();
        MultiRideCardCheckoutManager multiRideCardCheckoutManager = this.this$0;
        do {
            value = checkoutState.getValue();
            createSummaryInfo = multiRideCardCheckoutManager.createSummaryInfo(multiRideSummaryResponseDTO.getMultiRideTicket());
            copy = r5.copy((r26 & 1) != 0 ? r5.flowOrigin : null, (r26 & 2) != 0 ? r5.siteInfo : null, (r26 & 4) != 0 ? r5.multiRideCardToRefill : null, (r26 & 8) != 0 ? r5.purchaseInfos : null, (r26 & 16) != 0 ? r5.selectedPurchaseInfo : null, (r26 & 32) != 0 ? r5.numberOfCharges : 0, (r26 & 64) != 0 ? r5.selectedPriceStep : null, (r26 & 128) != 0 ? r5.totalPrice : null, (r26 & 256) != 0 ? r5.personalInfo : null, (r26 & 512) != 0 ? r5.selectedPaymentType : null, (r26 & 1024) != 0 ? r5.selectedCreditCard : null, (r26 & 2048) != 0 ? value.summaryCardInfo : createSummaryInfo);
        } while (!checkoutState.compareAndSet(value, copy));
        return Unit.INSTANCE;
    }
}
