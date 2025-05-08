package dk.molslinjen.ui.views.screens.profile.authentication.activation;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.ramcosta.composedestinations.generated.destinations.AccountActivationScreenDestination;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.managers.user.LoginResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0015B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0086@¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/authentication/activation/AccountActivationViewModel;", "Landroidx/lifecycle/ViewModel;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Ldk/molslinjen/domain/managers/user/IUserManager;Landroidx/lifecycle/SavedStateHandle;)V", "navArgs", "Ldk/molslinjen/ui/views/screens/profile/authentication/activation/AccountActivationScreenNavArgs;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/profile/authentication/activation/AccountActivationViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "activateAccountAction", "Ldk/molslinjen/domain/managers/ManagerResult;", "Ldk/molslinjen/domain/managers/user/LoginResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AccountActivationViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final AccountActivationScreenNavArgs navArgs;
    private final IUserManager userManager;
    private final StateFlow<ViewState> viewState;

    /* JADX WARN: Multi-variable type inference failed */
    public AccountActivationViewModel(IUserManager userManager, SavedStateHandle savedStateHandle) {
        ViewState value;
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.userManager = userManager;
        AccountActivationScreenNavArgs argsFrom = AccountActivationScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        this.navArgs = argsFrom;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, argsFrom.getOriginalUrl(), 1, 0 == true ? 1 : 0));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        do {
            value = MutableStateFlow.getValue();
        } while (!MutableStateFlow.compareAndSet(value, ViewState.copy$default(value, this.userManager.getAuthenticationType().getValue().isAuthenticated() ? ViewState.AuthenticationState.Authenticated : ViewState.AuthenticationState.NotAuthenticated, null, 2, null)));
    }

    public final Object activateAccountAction(Continuation<? super ManagerResult<? extends LoginResult>> continuation) {
        return this.userManager.activateAccount(this.navArgs.getToken(), continuation);
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0018B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u000b¨\u0006\u0019"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/authentication/activation/AccountActivationViewModel$ViewState;", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/screens/profile/authentication/activation/AccountActivationViewModel$ViewState$AuthenticationState;", "authenticationState", BuildConfig.FLAVOR, "originalUrl", "<init>", "(Ldk/molslinjen/ui/views/screens/profile/authentication/activation/AccountActivationViewModel$ViewState$AuthenticationState;Ljava/lang/String;)V", "copy", "(Ldk/molslinjen/ui/views/screens/profile/authentication/activation/AccountActivationViewModel$ViewState$AuthenticationState;Ljava/lang/String;)Ldk/molslinjen/ui/views/screens/profile/authentication/activation/AccountActivationViewModel$ViewState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/ui/views/screens/profile/authentication/activation/AccountActivationViewModel$ViewState$AuthenticationState;", "getAuthenticationState", "()Ldk/molslinjen/ui/views/screens/profile/authentication/activation/AccountActivationViewModel$ViewState$AuthenticationState;", "Ljava/lang/String;", "getOriginalUrl", "AuthenticationState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final AuthenticationState authenticationState;
        private final String originalUrl;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/authentication/activation/AccountActivationViewModel$ViewState$AuthenticationState;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "NotAuthenticated", "Authenticated", "Loading", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class AuthenticationState {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ AuthenticationState[] $VALUES;
            public static final AuthenticationState NotAuthenticated = new AuthenticationState("NotAuthenticated", 0);
            public static final AuthenticationState Authenticated = new AuthenticationState("Authenticated", 1);
            public static final AuthenticationState Loading = new AuthenticationState("Loading", 2);

            private static final /* synthetic */ AuthenticationState[] $values() {
                return new AuthenticationState[]{NotAuthenticated, Authenticated, Loading};
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

        public ViewState(AuthenticationState authenticationState, String originalUrl) {
            Intrinsics.checkNotNullParameter(authenticationState, "authenticationState");
            Intrinsics.checkNotNullParameter(originalUrl, "originalUrl");
            this.authenticationState = authenticationState;
            this.originalUrl = originalUrl;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, AuthenticationState authenticationState, String str, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                authenticationState = viewState.authenticationState;
            }
            if ((i5 & 2) != 0) {
                str = viewState.originalUrl;
            }
            return viewState.copy(authenticationState, str);
        }

        public final ViewState copy(AuthenticationState authenticationState, String originalUrl) {
            Intrinsics.checkNotNullParameter(authenticationState, "authenticationState");
            Intrinsics.checkNotNullParameter(originalUrl, "originalUrl");
            return new ViewState(authenticationState, originalUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.authenticationState == viewState.authenticationState && Intrinsics.areEqual(this.originalUrl, viewState.originalUrl);
        }

        public final AuthenticationState getAuthenticationState() {
            return this.authenticationState;
        }

        public final String getOriginalUrl() {
            return this.originalUrl;
        }

        public int hashCode() {
            return (this.authenticationState.hashCode() * 31) + this.originalUrl.hashCode();
        }

        public String toString() {
            return "ViewState(authenticationState=" + this.authenticationState + ", originalUrl=" + this.originalUrl + ")";
        }

        public /* synthetic */ ViewState(AuthenticationState authenticationState, String str, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? AuthenticationState.Loading : authenticationState, str);
        }
    }
}
