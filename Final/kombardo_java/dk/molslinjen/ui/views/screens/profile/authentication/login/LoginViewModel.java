package dk.molslinjen.ui.views.screens.profile.authentication.login;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.managers.user.LoginResult;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.EmailInputValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.NonEmptyStringValidator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0002#$B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0011J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0086@¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u0011J\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010!\u001a\u00020\u00112\b\u0010\"\u001a\u0004\u0018\u00010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006%"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/authentication/login/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "<init>", "(Ldk/molslinjen/domain/managers/user/IUserManager;Ldk/molslinjen/core/snackbar/ISnackbarService;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/profile/authentication/login/LoginViewModel$ViewState;", "viewState", "getViewState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "updateEmail", BuildConfig.FLAVOR, "newValue", BuildConfig.FLAVOR, "updatePassword", "triggerLogin", "loginAction", "Ldk/molslinjen/domain/managers/ManagerResult;", "Ldk/molslinjen/domain/managers/user/LoginResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginFailure", "Ldk/molslinjen/domain/managers/ManagerResult$Error;", "error", "(Ldk/molslinjen/domain/managers/ManagerResult$Error;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCancelMerge", "getFormValidator", "Ldk/molslinjen/ui/views/reusable/input/validation/FormValidator;", "setTrackingScreenRoute", "trackingScreen", "ViewState", "LoginState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LoginViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final IAnalyticsTracker analyticsTracker;
    private final ISnackbarService snackbarService;
    private final IUserManager userManager;
    private final MutableStateFlow<ViewState> viewState;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/authentication/login/LoginViewModel$LoginState;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Idle", "Action", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class LoginState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ LoginState[] $VALUES;
        public static final LoginState Idle = new LoginState("Idle", 0);
        public static final LoginState Action = new LoginState("Action", 1);

        private static final /* synthetic */ LoginState[] $values() {
            return new LoginState[]{Idle, Action};
        }

        static {
            LoginState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private LoginState(String str, int i5) {
        }

        public static LoginState valueOf(String str) {
            return (LoginState) Enum.valueOf(LoginState.class, str);
        }

        public static LoginState[] values() {
            return (LoginState[]) $VALUES.clone();
        }
    }

    public LoginViewModel(IUserManager userManager, ISnackbarService snackbarService, IAnalyticsTracker analyticsTracker) {
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        this.userManager = userManager;
        this.snackbarService = snackbarService;
        this.analyticsTracker = analyticsTracker;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, null, null, null, 15, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
    }

    public final FormValidator getFormValidator() {
        return new FormValidator(MapsKt.mapOf(TuplesKt.to(LoginFormField.Email, EmailInputValidator.INSTANCE), TuplesKt.to(LoginFormField.Password, NonEmptyStringValidator.INSTANCE)), ViewModelKt.getViewModelScope(this));
    }

    public final MutableStateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0078 A[PHI: r7
      0x0078: PHI (r7v10 java.lang.Object) = (r7v9 java.lang.Object), (r7v1 java.lang.Object) binds: [B:17:0x0075, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0077 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loginAction(Continuation<? super ManagerResult<? extends LoginResult>> continuation) {
        LoginViewModel$loginAction$1 loginViewModel$loginAction$1;
        int i5;
        LoginViewModel loginViewModel;
        if (continuation instanceof LoginViewModel$loginAction$1) {
            loginViewModel$loginAction$1 = (LoginViewModel$loginAction$1) continuation;
            int i6 = loginViewModel$loginAction$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                loginViewModel$loginAction$1.label = i6 - Integer.MIN_VALUE;
                Object obj = loginViewModel$loginAction$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = loginViewModel$loginAction$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    String email = this._viewState.getValue().getEmail();
                    String password = this._viewState.getValue().getPassword();
                    IUserManager iUserManager = this.userManager;
                    loginViewModel$loginAction$1.L$0 = this;
                    loginViewModel$loginAction$1.label = 1;
                    obj = iUserManager.login(email, password, loginViewModel$loginAction$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    loginViewModel = this;
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    loginViewModel = (LoginViewModel) loginViewModel$loginAction$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                LoginViewModel$loginAction$2 loginViewModel$loginAction$2 = new LoginViewModel$loginAction$2(loginViewModel, null);
                loginViewModel$loginAction$1.L$0 = null;
                loginViewModel$loginAction$1.label = 2;
                obj = ManagerResultExtensionsKt.onSuccess((ManagerResult) obj, loginViewModel$loginAction$2, loginViewModel$loginAction$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        loginViewModel$loginAction$1 = new LoginViewModel$loginAction$1(this, continuation);
        Object obj2 = loginViewModel$loginAction$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = loginViewModel$loginAction$1.label;
        if (i5 != 0) {
        }
        LoginViewModel$loginAction$2 loginViewModel$loginAction$22 = new LoginViewModel$loginAction$2(loginViewModel, null);
        loginViewModel$loginAction$1.L$0 = null;
        loginViewModel$loginAction$1.label = 2;
        obj2 = ManagerResultExtensionsKt.onSuccess((ManagerResult) obj2, loginViewModel$loginAction$22, loginViewModel$loginAction$1);
        if (obj2 != coroutine_suspended2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loginFailure(ManagerResult.Error error, Continuation<? super ManagerResult.Error> continuation) {
        LoginViewModel$loginFailure$1 loginViewModel$loginFailure$1;
        int i5;
        ViewState value;
        if (continuation instanceof LoginViewModel$loginFailure$1) {
            loginViewModel$loginFailure$1 = (LoginViewModel$loginFailure$1) continuation;
            int i6 = loginViewModel$loginFailure$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                loginViewModel$loginFailure$1.label = i6 - Integer.MIN_VALUE;
                Object obj = loginViewModel$loginFailure$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = loginViewModel$loginFailure$1.label;
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
                } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, LoginState.Idle, null, null, null, 14, null)));
                ISnackbarService iSnackbarService = this.snackbarService;
                loginViewModel$loginFailure$1.label = 1;
                if (dk.molslinjen.extensions.ManagerResultExtensionsKt.handleError(error, iSnackbarService, loginViewModel$loginFailure$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return null;
            }
        }
        loginViewModel$loginFailure$1 = new LoginViewModel$loginFailure$1(this, continuation);
        Object obj2 = loginViewModel$loginFailure$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = loginViewModel$loginFailure$1.label;
        if (i5 == 0) {
        }
    }

    public final void onCancelMerge() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, LoginState.Idle, null, null, null, 14, null)));
    }

    public final void setTrackingScreenRoute(String trackingScreen) {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, null, trackingScreen, 7, null)));
    }

    public final void triggerLogin() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, LoginState.Action, null, null, null, 14, null)));
    }

    public final void updateEmail(String newValue) {
        ViewState value;
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, newValue, null, null, 13, null)));
    }

    public final void updatePassword(String newValue) {
        ViewState value;
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, newValue, null, 11, null)));
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ:\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u001a\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u001b\u0010\r¨\u0006\u001c"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/authentication/login/LoginViewModel$ViewState;", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/screens/profile/authentication/login/LoginViewModel$LoginState;", "uploadState", BuildConfig.FLAVOR, "email", "password", "trackingScreen", "<init>", "(Ldk/molslinjen/ui/views/screens/profile/authentication/login/LoginViewModel$LoginState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "copy", "(Ldk/molslinjen/ui/views/screens/profile/authentication/login/LoginViewModel$LoginState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ldk/molslinjen/ui/views/screens/profile/authentication/login/LoginViewModel$ViewState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/ui/views/screens/profile/authentication/login/LoginViewModel$LoginState;", "getUploadState", "()Ldk/molslinjen/ui/views/screens/profile/authentication/login/LoginViewModel$LoginState;", "Ljava/lang/String;", "getEmail", "getPassword", "getTrackingScreen", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final String email;
        private final String password;
        private final String trackingScreen;
        private final LoginState uploadState;

        public ViewState(LoginState uploadState, String email, String password, String str) {
            Intrinsics.checkNotNullParameter(uploadState, "uploadState");
            Intrinsics.checkNotNullParameter(email, "email");
            Intrinsics.checkNotNullParameter(password, "password");
            this.uploadState = uploadState;
            this.email = email;
            this.password = password;
            this.trackingScreen = str;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, LoginState loginState, String str, String str2, String str3, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                loginState = viewState.uploadState;
            }
            if ((i5 & 2) != 0) {
                str = viewState.email;
            }
            if ((i5 & 4) != 0) {
                str2 = viewState.password;
            }
            if ((i5 & 8) != 0) {
                str3 = viewState.trackingScreen;
            }
            return viewState.copy(loginState, str, str2, str3);
        }

        public final ViewState copy(LoginState uploadState, String email, String password, String trackingScreen) {
            Intrinsics.checkNotNullParameter(uploadState, "uploadState");
            Intrinsics.checkNotNullParameter(email, "email");
            Intrinsics.checkNotNullParameter(password, "password");
            return new ViewState(uploadState, email, password, trackingScreen);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.uploadState == viewState.uploadState && Intrinsics.areEqual(this.email, viewState.email) && Intrinsics.areEqual(this.password, viewState.password) && Intrinsics.areEqual(this.trackingScreen, viewState.trackingScreen);
        }

        public final String getEmail() {
            return this.email;
        }

        public final String getPassword() {
            return this.password;
        }

        public final String getTrackingScreen() {
            return this.trackingScreen;
        }

        public final LoginState getUploadState() {
            return this.uploadState;
        }

        public int hashCode() {
            int hashCode = ((((this.uploadState.hashCode() * 31) + this.email.hashCode()) * 31) + this.password.hashCode()) * 31;
            String str = this.trackingScreen;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "ViewState(uploadState=" + this.uploadState + ", email=" + this.email + ", password=" + this.password + ", trackingScreen=" + this.trackingScreen + ")";
        }

        public /* synthetic */ ViewState(LoginState loginState, String str, String str2, String str3, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? LoginState.Idle : loginState, (i5 & 2) != 0 ? BuildConfig.FLAVOR : str, (i5 & 4) != 0 ? BuildConfig.FLAVOR : str2, (i5 & 8) != 0 ? null : str3);
        }
    }
}
