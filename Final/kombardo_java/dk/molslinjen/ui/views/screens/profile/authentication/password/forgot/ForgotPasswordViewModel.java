package dk.molslinjen.ui.views.screens.profile.authentication.password.forgot;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.ui.views.reusable.model.UIUploadState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0002\u0013\u0014B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/authentication/password/forgot/ForgotPasswordViewModel;", "Landroidx/lifecycle/ViewModel;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "<init>", "(Ldk/molslinjen/domain/managers/user/IUserManager;Ldk/molslinjen/core/snackbar/ISnackbarService;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/profile/authentication/password/forgot/ForgotPasswordViewModel$ViewState;", "viewState", "getViewState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "updateEmail", BuildConfig.FLAVOR, "email", BuildConfig.FLAVOR, "requestResetPassword", "ViewState", "Companion", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ForgotPasswordViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final ISnackbarService snackbarService;
    private final IUserManager userManager;
    private final MutableStateFlow<ViewState> viewState;
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public ForgotPasswordViewModel(IUserManager userManager, ISnackbarService snackbarService) {
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        this.userManager = userManager;
        this.snackbarService = snackbarService;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
    }

    public final MutableStateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void requestResetPassword() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ForgotPasswordViewModel$requestResetPassword$1(this, null), 3, null);
    }

    public final void updateEmail(String email) {
        ViewState value;
        Intrinsics.checkNotNullParameter(email, "email");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, email, null, 2, null)));
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/authentication/password/forgot/ForgotPasswordViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "email", "Ldk/molslinjen/ui/views/reusable/model/UIUploadState;", "uploadState", "<init>", "(Ljava/lang/String;Ldk/molslinjen/ui/views/reusable/model/UIUploadState;)V", "copy", "(Ljava/lang/String;Ldk/molslinjen/ui/views/reusable/model/UIUploadState;)Ldk/molslinjen/ui/views/screens/profile/authentication/password/forgot/ForgotPasswordViewModel$ViewState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getEmail", "Ldk/molslinjen/ui/views/reusable/model/UIUploadState;", "getUploadState", "()Ldk/molslinjen/ui/views/reusable/model/UIUploadState;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final String email;
        private final UIUploadState uploadState;

        public ViewState(String email, UIUploadState uploadState) {
            Intrinsics.checkNotNullParameter(email, "email");
            Intrinsics.checkNotNullParameter(uploadState, "uploadState");
            this.email = email;
            this.uploadState = uploadState;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, String str, UIUploadState uIUploadState, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = viewState.email;
            }
            if ((i5 & 2) != 0) {
                uIUploadState = viewState.uploadState;
            }
            return viewState.copy(str, uIUploadState);
        }

        public final ViewState copy(String email, UIUploadState uploadState) {
            Intrinsics.checkNotNullParameter(email, "email");
            Intrinsics.checkNotNullParameter(uploadState, "uploadState");
            return new ViewState(email, uploadState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics.areEqual(this.email, viewState.email) && this.uploadState == viewState.uploadState;
        }

        public final String getEmail() {
            return this.email;
        }

        public final UIUploadState getUploadState() {
            return this.uploadState;
        }

        public int hashCode() {
            return (this.email.hashCode() * 31) + this.uploadState.hashCode();
        }

        public String toString() {
            return "ViewState(email=" + this.email + ", uploadState=" + this.uploadState + ")";
        }

        public /* synthetic */ ViewState(String str, UIUploadState uIUploadState, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? BuildConfig.FLAVOR : str, (i5 & 2) != 0 ? UIUploadState.Idle : uIUploadState);
        }
    }
}
