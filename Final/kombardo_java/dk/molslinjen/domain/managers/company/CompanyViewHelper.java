package dk.molslinjen.domain.managers.company;

import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.account.user.AccountUser;
import dk.molslinjen.domain.model.account.user.User;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/domain/managers/company/CompanyViewHelper;", "Ldk/molslinjen/domain/managers/company/ICompanyViewHelper;", "Ldk/molslinjen/domain/managers/user/IUserManager;", "userManager", "<init>", "(Ldk/molslinjen/domain/managers/user/IUserManager;)V", BuildConfig.FLAVOR, "showCompanyPopup", "()V", "hideCompanyPopup", "Ldk/molslinjen/domain/managers/user/IUserManager;", "getUserManager", "()Ldk/molslinjen/domain/managers/user/IUserManager;", "Lkotlinx/coroutines/flow/MutableStateFlow;", BuildConfig.FLAVOR, "showCompanyPopupState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getShowCompanyPopupState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CompanyViewHelper implements ICompanyViewHelper {
    private final MutableStateFlow<Boolean> showCompanyPopupState;
    private final IUserManager userManager;

    public CompanyViewHelper(IUserManager userManager) {
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        this.userManager = userManager;
        this.showCompanyPopupState = StateFlowKt.MutableStateFlow(Boolean.FALSE);
    }

    @Override // dk.molslinjen.domain.managers.company.ICompanyViewHelper
    public void hideCompanyPopup() {
        Boolean value;
        MutableStateFlow<Boolean> showCompanyPopupState = getShowCompanyPopupState();
        do {
            value = showCompanyPopupState.getValue();
            value.booleanValue();
        } while (!showCompanyPopupState.compareAndSet(value, Boolean.FALSE));
    }

    @Override // dk.molslinjen.domain.managers.company.ICompanyViewHelper
    public void showCompanyPopup() {
        Boolean value;
        User user = this.userManager.getCurrentUserState().getValue().getUser();
        if (!(user instanceof AccountUser) || ((AccountUser) user).getCompanies().isEmpty()) {
            return;
        }
        MutableStateFlow<Boolean> showCompanyPopupState = getShowCompanyPopupState();
        do {
            value = showCompanyPopupState.getValue();
            value.booleanValue();
        } while (!showCompanyPopupState.compareAndSet(value, Boolean.TRUE));
    }

    @Override // dk.molslinjen.domain.managers.company.ICompanyViewHelper
    public MutableStateFlow<Boolean> getShowCompanyPopupState() {
        return this.showCompanyPopupState;
    }
}
