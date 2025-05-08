package dk.molslinjen.ui.views.screens.profile.passengers;

import dk.molslinjen.ui.views.screens.profile.passengers.ProfilePassengersViewModel;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/ui/views/screens/profile/passengers/ProfilePassengersViewModel$ViewState;", "viewState", "accountCardData", "Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.passengers.ProfilePassengersViewModel$viewState$1", f = "ProfilePassengersViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class ProfilePassengersViewModel$viewState$1 extends SuspendLambda implements Function3<ProfilePassengersViewModel.ViewState, AccountCardData, Continuation<? super ProfilePassengersViewModel.ViewState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProfilePassengersViewModel$viewState$1(Continuation<? super ProfilePassengersViewModel$viewState$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(ProfilePassengersViewModel.ViewState viewState, AccountCardData accountCardData, Continuation<? super ProfilePassengersViewModel.ViewState> continuation) {
        ProfilePassengersViewModel$viewState$1 profilePassengersViewModel$viewState$1 = new ProfilePassengersViewModel$viewState$1(continuation);
        profilePassengersViewModel$viewState$1.L$0 = viewState;
        profilePassengersViewModel$viewState$1.L$1 = accountCardData;
        return profilePassengersViewModel$viewState$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ProfilePassengersViewModel.ViewState viewState = (ProfilePassengersViewModel.ViewState) this.L$0;
        AccountCardData accountCardData = (AccountCardData) this.L$1;
        if (viewState.getPassengers().isEmpty()) {
            accountCardData = null;
        }
        return ProfilePassengersViewModel.ViewState.copy$default(viewState, accountCardData, null, false, null, false, 30, null);
    }
}
