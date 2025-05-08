package dk.molslinjen.extensions;

import dk.molslinjen.core.Feature;
import dk.molslinjen.domain.managers.user.AuthenticationType;
import dk.molslinjen.domain.managers.user.IUserManager;
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
@DebugMetadata(c = "dk.molslinjen.extensions.ActivationInfoExtensionsKt$toProfileAssetsCardData$1", f = "ActivationInfoExtensions.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class ActivationInfoExtensionsKt$toProfileAssetsCardData$1 extends SuspendLambda implements Function3<IUserManager.ActivationInfo, AuthenticationType, Continuation<? super AccountCardData>, Object> {
    final /* synthetic */ int $signupDescription;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivationInfoExtensionsKt$toProfileAssetsCardData$1(int i5, Continuation<? super ActivationInfoExtensionsKt$toProfileAssetsCardData$1> continuation) {
        super(3, continuation);
        this.$signupDescription = i5;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(IUserManager.ActivationInfo activationInfo, AuthenticationType authenticationType, Continuation<? super AccountCardData> continuation) {
        ActivationInfoExtensionsKt$toProfileAssetsCardData$1 activationInfoExtensionsKt$toProfileAssetsCardData$1 = new ActivationInfoExtensionsKt$toProfileAssetsCardData$1(this.$signupDescription, continuation);
        activationInfoExtensionsKt$toProfileAssetsCardData$1.L$0 = activationInfo;
        activationInfoExtensionsKt$toProfileAssetsCardData$1.L$1 = authenticationType;
        return activationInfoExtensionsKt$toProfileAssetsCardData$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        IUserManager.ActivationInfo activationInfo = (IUserManager.ActivationInfo) this.L$0;
        AuthenticationType authenticationType = (AuthenticationType) this.L$1;
        if (!Feature.Account.isEnabled()) {
            return null;
        }
        if (activationInfo != null) {
            return new AccountCardData.ActivationPending(activationInfo);
        }
        if (authenticationType.isAuthenticated()) {
            return null;
        }
        return new AccountCardData.Signup(this.$signupDescription);
    }
}
