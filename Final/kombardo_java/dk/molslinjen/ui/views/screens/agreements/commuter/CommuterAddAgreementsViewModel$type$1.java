package dk.molslinjen.ui.views.screens.agreements.commuter;

import dk.molslinjen.domain.extensions.CommuterDataStateExtensionsKt;
import dk.molslinjen.domain.managers.agreement.commuter.CommuterDataState;
import dk.molslinjen.domain.managers.agreement.commuter.bornholm.IBornholmCommuterManager;
import dk.molslinjen.domain.managers.user.AuthenticationType;
import dk.molslinjen.domain.model.agreement.commuter.oeresund.OeresundCommuterAgreement;
import dk.molslinjen.ui.views.screens.agreements.commuter.CommuterAddAgreementsViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/ui/views/screens/agreements/commuter/CommuterAddAgreementsViewModel$State;", "bornholmState", "Ldk/molslinjen/domain/managers/agreement/commuter/bornholm/IBornholmCommuterManager$State;", "oeresundState", "Ldk/molslinjen/domain/managers/agreement/commuter/CommuterDataState;", "Ldk/molslinjen/domain/model/agreement/commuter/oeresund/OeresundCommuterAgreement;", "authenticationType", "Ldk/molslinjen/domain/managers/user/AuthenticationType;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.agreements.commuter.CommuterAddAgreementsViewModel$type$1", f = "CommuterAddAgreementsViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class CommuterAddAgreementsViewModel$type$1 extends SuspendLambda implements Function4<IBornholmCommuterManager.State, CommuterDataState<? extends OeresundCommuterAgreement>, AuthenticationType, Continuation<? super CommuterAddAgreementsViewModel.State>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CommuterAddAgreementsViewModel$type$1(Continuation<? super CommuterAddAgreementsViewModel$type$1> continuation) {
        super(4, continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(IBornholmCommuterManager.State state, CommuterDataState<OeresundCommuterAgreement> commuterDataState, AuthenticationType authenticationType, Continuation<? super CommuterAddAgreementsViewModel.State> continuation) {
        CommuterAddAgreementsViewModel$type$1 commuterAddAgreementsViewModel$type$1 = new CommuterAddAgreementsViewModel$type$1(continuation);
        commuterAddAgreementsViewModel$type$1.L$0 = state;
        commuterAddAgreementsViewModel$type$1.L$1 = commuterDataState;
        commuterAddAgreementsViewModel$type$1.L$2 = authenticationType;
        return commuterAddAgreementsViewModel$type$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        IBornholmCommuterManager.State state = (IBornholmCommuterManager.State) this.L$0;
        CommuterDataState commuterDataState = (CommuterDataState) this.L$1;
        boolean z5 = ((AuthenticationType) this.L$2) instanceof AuthenticationType.None;
        return (CommuterDataStateExtensionsKt.getAgreements(state.getAgreementsState()).isEmpty() && CommuterDataStateExtensionsKt.getAgreements(commuterDataState).isEmpty()) ? new CommuterAddAgreementsViewModel.State.Large(z5) : new CommuterAddAgreementsViewModel.State.Small(z5);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(IBornholmCommuterManager.State state, CommuterDataState<? extends OeresundCommuterAgreement> commuterDataState, AuthenticationType authenticationType, Continuation<? super CommuterAddAgreementsViewModel.State> continuation) {
        return invoke2(state, (CommuterDataState<OeresundCommuterAgreement>) commuterDataState, authenticationType, continuation);
    }
}
