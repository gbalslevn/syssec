package dk.molslinjen.ui.views.screens.booking.receipt;

import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.user.AuthenticationType;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData;", "activationInfo", "Ldk/molslinjen/domain/managers/user/IUserManager$ActivationInfo;", "authenticationType", "Ldk/molslinjen/domain/managers/user/AuthenticationType;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.receipt.ReceiptViewModel$accountCardData$1", f = "ReceiptViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class ReceiptViewModel$accountCardData$1 extends SuspendLambda implements Function3<IUserManager.ActivationInfo, AuthenticationType, Continuation<? super AccountCardData>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ ReceiptViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReceiptViewModel$accountCardData$1(ReceiptViewModel receiptViewModel, Continuation<? super ReceiptViewModel$accountCardData$1> continuation) {
        super(3, continuation);
        this.this$0 = receiptViewModel;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(IUserManager.ActivationInfo activationInfo, AuthenticationType authenticationType, Continuation<? super AccountCardData> continuation) {
        ReceiptViewModel$accountCardData$1 receiptViewModel$accountCardData$1 = new ReceiptViewModel$accountCardData$1(this.this$0, continuation);
        receiptViewModel$accountCardData$1.L$0 = activationInfo;
        receiptViewModel$accountCardData$1.L$1 = authenticationType;
        return receiptViewModel$accountCardData$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Site site;
        boolean nudgeForProfileCreate;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        IUserManager.ActivationInfo activationInfo = (IUserManager.ActivationInfo) this.L$0;
        AuthenticationType authenticationType = (AuthenticationType) this.L$1;
        CheckoutManager.CheckoutState value = this.this$0.getCheckoutState().getValue();
        boolean z5 = false;
        if (value != null && (site = value.getSite()) != null) {
            nudgeForProfileCreate = this.this$0.nudgeForProfileCreate(site);
            if (nudgeForProfileCreate) {
                z5 = true;
            }
        }
        if (activationInfo != null) {
            return new AccountCardData.ActivationPending(activationInfo);
        }
        if (authenticationType.isAuthenticated() || !z5) {
            return null;
        }
        return new AccountCardData.Signup(R.string.receipt_createProfile_details);
    }
}
