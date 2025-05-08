package dk.molslinjen.ui.views.screens.profile.edit.changePassword;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.user.IUserManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0017B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0011J\u0014\u0010\u0014\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/edit/changePassword/ChangePasswordViewModel;", "Landroidx/lifecycle/ViewModel;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "<init>", "(Ldk/molslinjen/domain/managers/user/IUserManager;Ldk/molslinjen/core/snackbar/ISnackbarService;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/profile/edit/changePassword/ChangePasswordViewModel$ViewState;", "viewState", "getViewState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "updateCurrentPassword", BuildConfig.FLAVOR, "currentPassword", BuildConfig.FLAVOR, "updateNewPassword", "newPassword", "submit", "dismiss", "Lkotlin/Function0;", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ChangePasswordViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final ISnackbarService snackbarService;
    private final IUserManager userManager;
    private final MutableStateFlow<ViewState> viewState;

    public ChangePasswordViewModel(IUserManager userManager, ISnackbarService snackbarService) {
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        this.userManager = userManager;
        this.snackbarService = snackbarService;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(false, null, null, 7, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
    }

    public final MutableStateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void submit(Function0<Unit> dismiss) {
        Intrinsics.checkNotNullParameter(dismiss, "dismiss");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ChangePasswordViewModel$submit$1(this, dismiss, null), 3, null);
    }

    public final void updateCurrentPassword(String currentPassword) {
        ViewState value;
        Intrinsics.checkNotNullParameter(currentPassword, "currentPassword");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, currentPassword, null, 5, null)));
    }

    public final void updateNewPassword(String newPassword) {
        ViewState value;
        Intrinsics.checkNotNullParameter(newPassword, "newPassword");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, null, newPassword, 3, null)));
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0003\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0017\u0010\f¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/edit/changePassword/ChangePasswordViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isLoading", BuildConfig.FLAVOR, "currentPassword", "newPassword", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V", "copy", "(ZLjava/lang/String;Ljava/lang/String;)Ldk/molslinjen/ui/views/screens/profile/edit/changePassword/ChangePasswordViewModel$ViewState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "Ljava/lang/String;", "getCurrentPassword", "getNewPassword", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final String currentPassword;
        private final boolean isLoading;
        private final String newPassword;

        public ViewState(boolean z5, String currentPassword, String newPassword) {
            Intrinsics.checkNotNullParameter(currentPassword, "currentPassword");
            Intrinsics.checkNotNullParameter(newPassword, "newPassword");
            this.isLoading = z5;
            this.currentPassword = currentPassword;
            this.newPassword = newPassword;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z5, String str, String str2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z5 = viewState.isLoading;
            }
            if ((i5 & 2) != 0) {
                str = viewState.currentPassword;
            }
            if ((i5 & 4) != 0) {
                str2 = viewState.newPassword;
            }
            return viewState.copy(z5, str, str2);
        }

        public final ViewState copy(boolean isLoading, String currentPassword, String newPassword) {
            Intrinsics.checkNotNullParameter(currentPassword, "currentPassword");
            Intrinsics.checkNotNullParameter(newPassword, "newPassword");
            return new ViewState(isLoading, currentPassword, newPassword);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isLoading == viewState.isLoading && Intrinsics.areEqual(this.currentPassword, viewState.currentPassword) && Intrinsics.areEqual(this.newPassword, viewState.newPassword);
        }

        public final String getCurrentPassword() {
            return this.currentPassword;
        }

        public final String getNewPassword() {
            return this.newPassword;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.isLoading) * 31) + this.currentPassword.hashCode()) * 31) + this.newPassword.hashCode();
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public String toString() {
            return "ViewState(isLoading=" + this.isLoading + ", currentPassword=" + this.currentPassword + ", newPassword=" + this.newPassword + ")";
        }

        public /* synthetic */ ViewState(boolean z5, String str, String str2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? false : z5, (i5 & 2) != 0 ? BuildConfig.FLAVOR : str, (i5 & 4) != 0 ? BuildConfig.FLAVOR : str2);
        }
    }
}
