package dk.molslinjen.ui.views.screens.profile.authentication.password.reset;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.ramcosta.composedestinations.generated.destinations.ResetPasswordScreenDestination;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.managers.user.LoginResult;
import dk.molslinjen.extensions.ManagerResultExtensionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0002 !B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0013J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0086@¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\""}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/authentication/password/reset/ResetPasswordViewModel;", "Landroidx/lifecycle/ViewModel;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Ldk/molslinjen/domain/managers/user/IUserManager;Ldk/molslinjen/core/snackbar/ISnackbarService;Landroidx/lifecycle/SavedStateHandle;)V", "navArgs", "Ldk/molslinjen/ui/views/screens/profile/authentication/password/reset/ResetPasswordScreenNavArgs;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/profile/authentication/password/reset/ResetPasswordViewModel$ViewState;", "viewState", "getViewState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "updatePassword", BuildConfig.FLAVOR, "password", BuildConfig.FLAVOR, "triggerResetPassword", "resetPasswordAction", "Ldk/molslinjen/domain/managers/ManagerResult;", "Ldk/molslinjen/domain/managers/user/LoginResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetPasswordFailure", "Ldk/molslinjen/domain/managers/ManagerResult$Error;", "error", "(Ldk/molslinjen/domain/managers/ManagerResult$Error;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCancelMerge", "ResetPasswordState", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ResetPasswordViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final ResetPasswordScreenNavArgs navArgs;
    private final ISnackbarService snackbarService;
    private final IUserManager userManager;
    private final MutableStateFlow<ViewState> viewState;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/authentication/password/reset/ResetPasswordViewModel$ResetPasswordState;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Idle", "Action", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class ResetPasswordState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ResetPasswordState[] $VALUES;
        public static final ResetPasswordState Idle = new ResetPasswordState("Idle", 0);
        public static final ResetPasswordState Action = new ResetPasswordState("Action", 1);

        private static final /* synthetic */ ResetPasswordState[] $values() {
            return new ResetPasswordState[]{Idle, Action};
        }

        static {
            ResetPasswordState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private ResetPasswordState(String str, int i5) {
        }

        public static ResetPasswordState valueOf(String str) {
            return (ResetPasswordState) Enum.valueOf(ResetPasswordState.class, str);
        }

        public static ResetPasswordState[] values() {
            return (ResetPasswordState[]) $VALUES.clone();
        }
    }

    public ResetPasswordViewModel(IUserManager userManager, ISnackbarService snackbarService, SavedStateHandle savedStateHandle) {
        ViewState value;
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.userManager = userManager;
        this.snackbarService = snackbarService;
        ResetPasswordScreenNavArgs argsFrom = ResetPasswordScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        this.navArgs = argsFrom;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, null, null, argsFrom.getOriginalUrl(), 7, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        do {
            value = MutableStateFlow.getValue();
        } while (!MutableStateFlow.compareAndSet(value, ViewState.copy$default(value, this.userManager.getAuthenticationType().getValue().isAuthenticated() ? ViewState.AuthenticationState.Authenticated : ViewState.AuthenticationState.NotAuthenticated, null, null, null, 14, null)));
    }

    public final MutableStateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void onCancelMerge() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, ResetPasswordState.Idle, null, 11, null)));
    }

    public final Object resetPasswordAction(Continuation<? super ManagerResult<? extends LoginResult>> continuation) {
        return this.userManager.resetPassword(this._viewState.getValue().getPassword(), this.navArgs.getResetToken(), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resetPasswordFailure(ManagerResult.Error error, Continuation<? super ManagerResult.Error> continuation) {
        ResetPasswordViewModel$resetPasswordFailure$1 resetPasswordViewModel$resetPasswordFailure$1;
        int i5;
        ViewState value;
        if (continuation instanceof ResetPasswordViewModel$resetPasswordFailure$1) {
            resetPasswordViewModel$resetPasswordFailure$1 = (ResetPasswordViewModel$resetPasswordFailure$1) continuation;
            int i6 = resetPasswordViewModel$resetPasswordFailure$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                resetPasswordViewModel$resetPasswordFailure$1.label = i6 - Integer.MIN_VALUE;
                Object obj = resetPasswordViewModel$resetPasswordFailure$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = resetPasswordViewModel$resetPasswordFailure$1.label;
                if (i5 == 0) {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, ResetPasswordState.Idle, null, 11, null)));
                ISnackbarService iSnackbarService = this.snackbarService;
                resetPasswordViewModel$resetPasswordFailure$1.label = 1;
                if (ManagerResultExtensionsKt.handleError(error, iSnackbarService, resetPasswordViewModel$resetPasswordFailure$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return null;
            }
        }
        resetPasswordViewModel$resetPasswordFailure$1 = new ResetPasswordViewModel$resetPasswordFailure$1(this, continuation);
        Object obj2 = resetPasswordViewModel$resetPasswordFailure$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = resetPasswordViewModel$resetPasswordFailure$1.label;
        if (i5 == 0) {
        }
    }

    public final void triggerResetPassword() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, ResetPasswordState.Action, null, 11, null)));
    }

    public final void updatePassword(String password) {
        ViewState value;
        Intrinsics.checkNotNullParameter(password, "password");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, password, null, null, 13, null)));
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u001fB-\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ8\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001e\u0010\u000e¨\u0006 "}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/authentication/password/reset/ResetPasswordViewModel$ViewState;", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/screens/profile/authentication/password/reset/ResetPasswordViewModel$ViewState$AuthenticationState;", "authenticationState", BuildConfig.FLAVOR, "password", "Ldk/molslinjen/ui/views/screens/profile/authentication/password/reset/ResetPasswordViewModel$ResetPasswordState;", "state", "originalUrl", "<init>", "(Ldk/molslinjen/ui/views/screens/profile/authentication/password/reset/ResetPasswordViewModel$ViewState$AuthenticationState;Ljava/lang/String;Ldk/molslinjen/ui/views/screens/profile/authentication/password/reset/ResetPasswordViewModel$ResetPasswordState;Ljava/lang/String;)V", "copy", "(Ldk/molslinjen/ui/views/screens/profile/authentication/password/reset/ResetPasswordViewModel$ViewState$AuthenticationState;Ljava/lang/String;Ldk/molslinjen/ui/views/screens/profile/authentication/password/reset/ResetPasswordViewModel$ResetPasswordState;Ljava/lang/String;)Ldk/molslinjen/ui/views/screens/profile/authentication/password/reset/ResetPasswordViewModel$ViewState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/ui/views/screens/profile/authentication/password/reset/ResetPasswordViewModel$ViewState$AuthenticationState;", "getAuthenticationState", "()Ldk/molslinjen/ui/views/screens/profile/authentication/password/reset/ResetPasswordViewModel$ViewState$AuthenticationState;", "Ljava/lang/String;", "getPassword", "Ldk/molslinjen/ui/views/screens/profile/authentication/password/reset/ResetPasswordViewModel$ResetPasswordState;", "getState", "()Ldk/molslinjen/ui/views/screens/profile/authentication/password/reset/ResetPasswordViewModel$ResetPasswordState;", "getOriginalUrl", "AuthenticationState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final AuthenticationState authenticationState;
        private final String originalUrl;
        private final String password;
        private final ResetPasswordState state;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/authentication/password/reset/ResetPasswordViewModel$ViewState$AuthenticationState;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Loading", "Authenticated", "NotAuthenticated", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class AuthenticationState {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ AuthenticationState[] $VALUES;
            public static final AuthenticationState Loading = new AuthenticationState("Loading", 0);
            public static final AuthenticationState Authenticated = new AuthenticationState("Authenticated", 1);
            public static final AuthenticationState NotAuthenticated = new AuthenticationState("NotAuthenticated", 2);

            private static final /* synthetic */ AuthenticationState[] $values() {
                return new AuthenticationState[]{Loading, Authenticated, NotAuthenticated};
            }

            static {
                AuthenticationState[] $values = $values();
                $VALUES = $values;
                $ENTRIES = EnumEntriesKt.enumEntries($values);
            }

            private AuthenticationState(String str, int i5) {
            }

            public static AuthenticationState valueOf(String str) {
                return (AuthenticationState) Enum.valueOf(AuthenticationState.class, str);
            }

            public static AuthenticationState[] values() {
                return (AuthenticationState[]) $VALUES.clone();
            }
        }

        public ViewState(AuthenticationState authenticationState, String password, ResetPasswordState state, String originalUrl) {
            Intrinsics.checkNotNullParameter(authenticationState, "authenticationState");
            Intrinsics.checkNotNullParameter(password, "password");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(originalUrl, "originalUrl");
            this.authenticationState = authenticationState;
            this.password = password;
            this.state = state;
            this.originalUrl = originalUrl;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, AuthenticationState authenticationState, String str, ResetPasswordState resetPasswordState, String str2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                authenticationState = viewState.authenticationState;
            }
            if ((i5 & 2) != 0) {
                str = viewState.password;
            }
            if ((i5 & 4) != 0) {
                resetPasswordState = viewState.state;
            }
            if ((i5 & 8) != 0) {
                str2 = viewState.originalUrl;
            }
            return viewState.copy(authenticationState, str, resetPasswordState, str2);
        }

        public final ViewState copy(AuthenticationState authenticationState, String password, ResetPasswordState state, String originalUrl) {
            Intrinsics.checkNotNullParameter(authenticationState, "authenticationState");
            Intrinsics.checkNotNullParameter(password, "password");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(originalUrl, "originalUrl");
            return new ViewState(authenticationState, password, state, originalUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.authenticationState == viewState.authenticationState && Intrinsics.areEqual(this.password, viewState.password) && this.state == viewState.state && Intrinsics.areEqual(this.originalUrl, viewState.originalUrl);
        }

        public final AuthenticationState getAuthenticationState() {
            return this.authenticationState;
        }

        public final String getOriginalUrl() {
            return this.originalUrl;
        }

        public final String getPassword() {
            return this.password;
        }

        public final ResetPasswordState getState() {
            return this.state;
        }

        public int hashCode() {
            return (((((this.authenticationState.hashCode() * 31) + this.password.hashCode()) * 31) + this.state.hashCode()) * 31) + this.originalUrl.hashCode();
        }

        public String toString() {
            return "ViewState(authenticationState=" + this.authenticationState + ", password=" + this.password + ", state=" + this.state + ", originalUrl=" + this.originalUrl + ")";
        }

        public /* synthetic */ ViewState(AuthenticationState authenticationState, String str, ResetPasswordState resetPasswordState, String str2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? AuthenticationState.Loading : authenticationState, (i5 & 2) != 0 ? BuildConfig.FLAVOR : str, (i5 & 4) != 0 ? ResetPasswordState.Idle : resetPasswordState, str2);
        }
    }
}
