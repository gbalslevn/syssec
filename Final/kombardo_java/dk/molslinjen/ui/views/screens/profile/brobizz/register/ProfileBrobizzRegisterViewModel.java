package dk.molslinjen.ui.views.screens.profile.brobizz.register;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.user.brobizz.IUserBrobizzManager;
import dk.molslinjen.ui.views.screens.profile.brobizz.shared.InputState;
import dk.molslinjen.ui.views.screens.profile.brobizz.shared.ProfileBrobizzInputHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001!B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0018\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/brobizz/register/ProfileBrobizzRegisterViewModel;", "Landroidx/lifecycle/ViewModel;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/managers/user/brobizz/IUserBrobizzManager;", "brobizzManager", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "snackbarService", "<init>", "(Ldk/molslinjen/domain/managers/user/brobizz/IUserBrobizzManager;Ldk/molslinjen/core/snackbar/ISnackbarService;)V", "Lkotlin/Function0;", BuildConfig.FLAVOR, "finishFlow", "Lkotlinx/coroutines/Job;", "registerBrobizz", "(Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/Job;", BuildConfig.FLAVOR, "brobizzNumber", "updateBrobizzNumber", "(Ljava/lang/String;)V", "Ldk/molslinjen/domain/managers/user/brobizz/IUserBrobizzManager;", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/profile/brobizz/register/ProfileBrobizzRegisterViewModel$ViewState;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "viewState", "getViewState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/ui/views/screens/profile/brobizz/shared/IProfileBrobizzInputHandler$InputState;", "getInputState", "()Lkotlinx/coroutines/flow/StateFlow;", "inputState", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProfileBrobizzRegisterViewModel extends ViewModel {
    private final /* synthetic */ ProfileBrobizzInputHandler $$delegate_0;
    private final MutableStateFlow<ViewState> _viewState;
    private final IUserBrobizzManager brobizzManager;
    private final ISnackbarService snackbarService;
    private final MutableStateFlow<ViewState> viewState;

    public ProfileBrobizzRegisterViewModel(IUserBrobizzManager brobizzManager, ISnackbarService snackbarService) {
        Intrinsics.checkNotNullParameter(brobizzManager, "brobizzManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        this.$$delegate_0 = new ProfileBrobizzInputHandler();
        this.brobizzManager = brobizzManager;
        this.snackbarService = snackbarService;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(false, 1, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
    }

    public StateFlow<InputState> getInputState() {
        return this.$$delegate_0.getInputState();
    }

    public final MutableStateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final Job registerBrobizz(Function0<Unit> finishFlow) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(finishFlow, "finishFlow");
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ProfileBrobizzRegisterViewModel$registerBrobizz$1(this, finishFlow, null), 3, null);
        return launch$default;
    }

    public void updateBrobizzNumber(String brobizzNumber) {
        Intrinsics.checkNotNullParameter(brobizzNumber, "brobizzNumber");
        this.$$delegate_0.updateBrobizzNumber(brobizzNumber);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0003\u0010\u0012¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/brobizz/register/ProfileBrobizzRegisterViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isLoading", "<init>", "(Z)V", "copy", "(Z)Ldk/molslinjen/ui/views/screens/profile/brobizz/register/ProfileBrobizzRegisterViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final boolean isLoading;

        public ViewState(boolean z5) {
            this.isLoading = z5;
        }

        public final ViewState copy(boolean isLoading) {
            return new ViewState(isLoading);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ViewState) && this.isLoading == ((ViewState) other).isLoading;
        }

        public int hashCode() {
            return Boolean.hashCode(this.isLoading);
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public String toString() {
            return "ViewState(isLoading=" + this.isLoading + ")";
        }

        public /* synthetic */ ViewState(boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? false : z5);
        }
    }
}
