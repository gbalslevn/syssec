package dk.molslinjen.ui.views.screens.profile.edit;

import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.screens.profile.edit.ProfileEditViewModel;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/ui/views/screens/profile/edit/ProfileEditViewModel$ViewState;", "viewState", "pendingActivation", "Ldk/molslinjen/domain/managers/user/IUserManager$ActivationInfo;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.edit.ProfileEditViewModel$viewState$1", f = "ProfileEditViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class ProfileEditViewModel$viewState$1 extends SuspendLambda implements Function3<ProfileEditViewModel.ViewState, IUserManager.ActivationInfo, Continuation<? super ProfileEditViewModel.ViewState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProfileEditViewModel$viewState$1(Continuation<? super ProfileEditViewModel$viewState$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(ProfileEditViewModel.ViewState viewState, IUserManager.ActivationInfo activationInfo, Continuation<? super ProfileEditViewModel.ViewState> continuation) {
        ProfileEditViewModel$viewState$1 profileEditViewModel$viewState$1 = new ProfileEditViewModel$viewState$1(continuation);
        profileEditViewModel$viewState$1.L$0 = viewState;
        profileEditViewModel$viewState$1.L$1 = activationInfo;
        return profileEditViewModel$viewState$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AccountCardData signup;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ProfileEditViewModel.ViewState viewState = (ProfileEditViewModel.ViewState) this.L$0;
        IUserManager.ActivationInfo activationInfo = (IUserManager.ActivationInfo) this.L$1;
        if (activationInfo != null) {
            signup = new AccountCardData.ActivationPending(activationInfo);
        } else {
            signup = (viewState.getEditMode() == ProfileEditViewModel.EditMode.EditLocal || viewState.getEditMode() == ProfileEditViewModel.EditMode.CreateLocal) ? new AccountCardData.Signup(R.string.profile_edit_signup_description) : null;
        }
        return ProfileEditViewModel.ViewState.copy$default(viewState, false, null, signup, null, false, false, 59, null);
    }
}
