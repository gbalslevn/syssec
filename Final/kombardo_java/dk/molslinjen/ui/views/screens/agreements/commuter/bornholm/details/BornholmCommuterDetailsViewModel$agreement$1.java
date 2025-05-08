package dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.details;

import dk.molslinjen.domain.extensions.CommuterDataStateExtensionsKt;
import dk.molslinjen.domain.managers.agreement.commuter.bornholm.IBornholmCommuterManager;
import dk.molslinjen.domain.model.agreement.commuter.bornholm.BornholmCommuterAgreement;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterAgreement;", "managerState", "Ldk/molslinjen/domain/managers/agreement/commuter/bornholm/IBornholmCommuterManager$State;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.details.BornholmCommuterDetailsViewModel$agreement$1", f = "BornholmCommuterDetailsViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class BornholmCommuterDetailsViewModel$agreement$1 extends SuspendLambda implements Function2<IBornholmCommuterManager.State, Continuation<? super BornholmCommuterAgreement>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BornholmCommuterDetailsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BornholmCommuterDetailsViewModel$agreement$1(BornholmCommuterDetailsViewModel bornholmCommuterDetailsViewModel, Continuation<? super BornholmCommuterDetailsViewModel$agreement$1> continuation) {
        super(2, continuation);
        this.this$0 = bornholmCommuterDetailsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BornholmCommuterDetailsViewModel$agreement$1 bornholmCommuterDetailsViewModel$agreement$1 = new BornholmCommuterDetailsViewModel$agreement$1(this.this$0, continuation);
        bornholmCommuterDetailsViewModel$agreement$1.L$0 = obj;
        return bornholmCommuterDetailsViewModel$agreement$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(IBornholmCommuterManager.State state, Continuation<? super BornholmCommuterAgreement> continuation) {
        return ((BornholmCommuterDetailsViewModel$agreement$1) create(state, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BornholmCommuterDetailsScreenNavArgs bornholmCommuterDetailsScreenNavArgs;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List agreements = CommuterDataStateExtensionsKt.getAgreements(((IBornholmCommuterManager.State) this.L$0).getAgreementsState());
        BornholmCommuterDetailsViewModel bornholmCommuterDetailsViewModel = this.this$0;
        for (Object obj2 : agreements) {
            String commuterAgreementId = ((BornholmCommuterAgreement) obj2).getCommuterAgreementId();
            bornholmCommuterDetailsScreenNavArgs = bornholmCommuterDetailsViewModel.navArgs;
            if (Intrinsics.areEqual(commuterAgreementId, bornholmCommuterDetailsScreenNavArgs.getCommuterAgreementId())) {
                return obj2;
            }
        }
        return null;
    }
}
