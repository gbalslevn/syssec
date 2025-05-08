package dk.molslinjen.extensions;

import dk.molslinjen.domain.managers.user.AuthenticationType;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¨\u0006\t"}, d2 = {"toProfileAssetsCardData", "Lkotlinx/coroutines/flow/Flow;", "Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData;", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/user/IUserManager$ActivationInfo;", "signupDescription", BuildConfig.FLAVOR, "authenticationTypeStateFlow", "Ldk/molslinjen/domain/managers/user/AuthenticationType;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ActivationInfoExtensionsKt {
    public static final Flow<AccountCardData> toProfileAssetsCardData(StateFlow<IUserManager.ActivationInfo> stateFlow, int i5, StateFlow<? extends AuthenticationType> authenticationTypeStateFlow) {
        Intrinsics.checkNotNullParameter(stateFlow, "<this>");
        Intrinsics.checkNotNullParameter(authenticationTypeStateFlow, "authenticationTypeStateFlow");
        return FlowKt.flowCombine(stateFlow, authenticationTypeStateFlow, new ActivationInfoExtensionsKt$toProfileAssetsCardData$1(i5, null));
    }
}
