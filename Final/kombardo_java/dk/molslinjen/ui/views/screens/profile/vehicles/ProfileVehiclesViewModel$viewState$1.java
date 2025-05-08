package dk.molslinjen.ui.views.screens.profile.vehicles;

import dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData;
import dk.molslinjen.ui.views.screens.profile.vehicles.ProfileVehiclesViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/ui/views/screens/profile/vehicles/ProfileVehiclesViewModel$ViewState;", "viewState", "accountCardData", "Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.vehicles.ProfileVehiclesViewModel$viewState$1", f = "ProfileVehiclesViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class ProfileVehiclesViewModel$viewState$1 extends SuspendLambda implements Function3<ProfileVehiclesViewModel.ViewState, AccountCardData, Continuation<? super ProfileVehiclesViewModel.ViewState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProfileVehiclesViewModel$viewState$1(Continuation<? super ProfileVehiclesViewModel$viewState$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(ProfileVehiclesViewModel.ViewState viewState, AccountCardData accountCardData, Continuation<? super ProfileVehiclesViewModel.ViewState> continuation) {
        ProfileVehiclesViewModel$viewState$1 profileVehiclesViewModel$viewState$1 = new ProfileVehiclesViewModel$viewState$1(continuation);
        profileVehiclesViewModel$viewState$1.L$0 = viewState;
        profileVehiclesViewModel$viewState$1.L$1 = accountCardData;
        return profileVehiclesViewModel$viewState$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ProfileVehiclesViewModel.ViewState viewState = (ProfileVehiclesViewModel.ViewState) this.L$0;
        AccountCardData accountCardData = (AccountCardData) this.L$1;
        if (viewState.getUserVehiclesState().getVehicles().isEmpty()) {
            accountCardData = null;
        }
        return ProfileVehiclesViewModel.ViewState.copy$default(viewState, null, accountCardData, false, null, false, 29, null);
    }
}
