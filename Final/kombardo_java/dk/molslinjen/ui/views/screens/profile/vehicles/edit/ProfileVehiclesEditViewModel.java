package dk.molslinjen.ui.views.screens.profile.vehicles.edit;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.ProfileVehicleEditScreenDestination;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.vehicles.IUserVehiclesManager;
import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.ui.views.screens.profile.vehicles.shared.InputState;
import dk.molslinjen.ui.views.screens.profile.vehicles.shared.ProfileVehicleInputHandler;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001/B!\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ,\u0010\u0010\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000eH\u0082@¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0013\u001a\u00020\u00122\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\f¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\f¢\u0006\u0004\b\u0017\u0010\u0016J\u001b\u0010\u0018\u001a\u00020\u00122\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0004\b\u0018\u0010\u0014J\u0018\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0096\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0019H\u0096\u0001¢\u0006\u0004\b\u001e\u0010\u001cR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001fR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020%0(8F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020,0(8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b-\u0010*¨\u00060"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/vehicles/edit/ProfileVehiclesEditViewModel;", "Landroidx/lifecycle/ViewModel;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/managers/user/vehicles/IUserVehiclesManager;", "vehiclesManager", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "snackbarService", "Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle", "<init>", "(Ldk/molslinjen/domain/managers/user/vehicles/IUserVehiclesManager;Ldk/molslinjen/core/snackbar/ISnackbarService;Landroidx/lifecycle/SavedStateHandle;)V", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "result", "Lkotlin/Function0;", "onSuccess", "handleResult", "(Ldk/molslinjen/domain/managers/ManagerResult;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/Job;", "updateVehicle", "(Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/Job;", "triggerDeleteFlow", "()V", "cancelDeleteFlow", "deleteVehicle", BuildConfig.FLAVOR, "licensePlate", "updateLicensePlate", "(Ljava/lang/String;)V", "name", "updateName", "Ldk/molslinjen/domain/managers/user/vehicles/IUserVehiclesManager;", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "Ldk/molslinjen/ui/views/screens/profile/vehicles/edit/ProfileVehicleEditScreenNavArgs;", "navArgs", "Ldk/molslinjen/ui/views/screens/profile/vehicles/edit/ProfileVehicleEditScreenNavArgs;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/profile/vehicles/edit/ProfileVehiclesEditViewModel$ViewState;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "viewState", "Ldk/molslinjen/ui/views/screens/profile/vehicles/shared/IProfileVehicleInputHandler$InputState;", "getVehicleInput", "vehicleInput", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProfileVehiclesEditViewModel extends ViewModel {
    private final /* synthetic */ ProfileVehicleInputHandler $$delegate_0;
    private MutableStateFlow<ViewState> _viewState;
    private final ProfileVehicleEditScreenNavArgs navArgs;
    private final ISnackbarService snackbarService;
    private final IUserVehiclesManager vehiclesManager;

    public ProfileVehiclesEditViewModel(IUserVehiclesManager vehiclesManager, ISnackbarService snackbarService, SavedStateHandle savedStateHandle) {
        Object obj;
        ViewState value;
        Intrinsics.checkNotNullParameter(vehiclesManager, "vehiclesManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.$$delegate_0 = new ProfileVehicleInputHandler();
        this.vehiclesManager = vehiclesManager;
        this.snackbarService = snackbarService;
        this.navArgs = ProfileVehicleEditScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        this._viewState = StateFlowKt.MutableStateFlow(new ViewState(false, false, null, 7, null));
        Iterator<T> it = vehiclesManager.getVehiclesState().getValue().getVehicles().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((UserVehicle) obj).getId(), this.navArgs.getVehicleId())) {
                    break;
                }
            }
        }
        UserVehicle userVehicle = (UserVehicle) obj;
        if (userVehicle != null) {
            MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, false, userVehicle, 3, null)));
            updateLicensePlate(userVehicle.getLicensePlate());
            updateName(userVehicle.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x007d, code lost:
    
        if (r2.compareAndSet(r14, dk.molslinjen.ui.views.screens.profile.vehicles.edit.ProfileVehiclesEditViewModel.ViewState.copy$default(r6, false, false, null, 4, null)) == false) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x006f -> B:10:0x0070). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleResult(ManagerResult<Unit> managerResult, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        ProfileVehiclesEditViewModel$handleResult$1 profileVehiclesEditViewModel$handleResult$1;
        int i5;
        ProfileVehiclesEditViewModel profileVehiclesEditViewModel;
        MutableStateFlow mutableStateFlow;
        Object value;
        ViewState viewState;
        if (continuation instanceof ProfileVehiclesEditViewModel$handleResult$1) {
            profileVehiclesEditViewModel$handleResult$1 = (ProfileVehiclesEditViewModel$handleResult$1) continuation;
            int i6 = profileVehiclesEditViewModel$handleResult$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                profileVehiclesEditViewModel$handleResult$1.label = i6 - Integer.MIN_VALUE;
                Object obj = profileVehiclesEditViewModel$handleResult$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = profileVehiclesEditViewModel$handleResult$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!(managerResult instanceof ManagerResult.Error)) {
                        if (!(managerResult instanceof ManagerResult.Success)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        function0.invoke();
                        return Unit.INSTANCE;
                    }
                    profileVehiclesEditViewModel = this;
                    mutableStateFlow = this._viewState;
                    value = mutableStateFlow.getValue();
                    ViewState viewState2 = (ViewState) value;
                    ISnackbarService iSnackbarService = profileVehiclesEditViewModel.snackbarService;
                    profileVehiclesEditViewModel$handleResult$1.L$0 = profileVehiclesEditViewModel;
                    profileVehiclesEditViewModel$handleResult$1.L$1 = managerResult;
                    profileVehiclesEditViewModel$handleResult$1.L$2 = mutableStateFlow;
                    profileVehiclesEditViewModel$handleResult$1.L$3 = value;
                    profileVehiclesEditViewModel$handleResult$1.L$4 = viewState2;
                    profileVehiclesEditViewModel$handleResult$1.label = 1;
                    if (ManagerResultExtensionsKt.handleError((ManagerResult.Error) managerResult, iSnackbarService, profileVehiclesEditViewModel$handleResult$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    viewState = viewState2;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ViewState viewState3 = (ViewState) profileVehiclesEditViewModel$handleResult$1.L$4;
                    value = profileVehiclesEditViewModel$handleResult$1.L$3;
                    mutableStateFlow = (MutableStateFlow) profileVehiclesEditViewModel$handleResult$1.L$2;
                    ManagerResult<Unit> managerResult2 = (ManagerResult) profileVehiclesEditViewModel$handleResult$1.L$1;
                    profileVehiclesEditViewModel = (ProfileVehiclesEditViewModel) profileVehiclesEditViewModel$handleResult$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    viewState = viewState3;
                    managerResult = managerResult2;
                }
            }
        }
        profileVehiclesEditViewModel$handleResult$1 = new ProfileVehiclesEditViewModel$handleResult$1(this, continuation);
        Object obj2 = profileVehiclesEditViewModel$handleResult$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = profileVehiclesEditViewModel$handleResult$1.label;
        if (i5 != 0) {
        }
    }

    public final void cancelDeleteFlow() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, false, null, 5, null)));
    }

    public final Job deleteVehicle(Function0<Unit> onSuccess) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ProfileVehiclesEditViewModel$deleteVehicle$1(this, onSuccess, null), 3, null);
        return launch$default;
    }

    public StateFlow<InputState> getVehicleInput() {
        return this.$$delegate_0.getVehicleInput();
    }

    public final StateFlow<ViewState> getViewState() {
        return this._viewState;
    }

    public final void triggerDeleteFlow() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, true, null, 5, null)));
    }

    public void updateLicensePlate(String licensePlate) {
        Intrinsics.checkNotNullParameter(licensePlate, "licensePlate");
        this.$$delegate_0.updateLicensePlate(licensePlate);
    }

    public void updateName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.$$delegate_0.updateName(name);
    }

    public final Job updateVehicle(Function0<Unit> onSuccess) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ProfileVehiclesEditViewModel$updateVehicle$1(this, onSuccess, null), 3, null);
        return launch$default;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0003\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\u0015R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/vehicles/edit/ProfileVehiclesEditViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isLoading", "showDeleteDialog", "Ldk/molslinjen/domain/model/account/UserVehicle;", "originalVehicle", "<init>", "(ZZLdk/molslinjen/domain/model/account/UserVehicle;)V", "copy", "(ZZLdk/molslinjen/domain/model/account/UserVehicle;)Ldk/molslinjen/ui/views/screens/profile/vehicles/edit/ProfileVehiclesEditViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "getShowDeleteDialog", "Ldk/molslinjen/domain/model/account/UserVehicle;", "getOriginalVehicle", "()Ldk/molslinjen/domain/model/account/UserVehicle;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final boolean isLoading;
        private final UserVehicle originalVehicle;
        private final boolean showDeleteDialog;

        public ViewState(boolean z5, boolean z6, UserVehicle userVehicle) {
            this.isLoading = z5;
            this.showDeleteDialog = z6;
            this.originalVehicle = userVehicle;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z5, boolean z6, UserVehicle userVehicle, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z5 = viewState.isLoading;
            }
            if ((i5 & 2) != 0) {
                z6 = viewState.showDeleteDialog;
            }
            if ((i5 & 4) != 0) {
                userVehicle = viewState.originalVehicle;
            }
            return viewState.copy(z5, z6, userVehicle);
        }

        public final ViewState copy(boolean isLoading, boolean showDeleteDialog, UserVehicle originalVehicle) {
            return new ViewState(isLoading, showDeleteDialog, originalVehicle);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isLoading == viewState.isLoading && this.showDeleteDialog == viewState.showDeleteDialog && Intrinsics.areEqual(this.originalVehicle, viewState.originalVehicle);
        }

        public final UserVehicle getOriginalVehicle() {
            return this.originalVehicle;
        }

        public final boolean getShowDeleteDialog() {
            return this.showDeleteDialog;
        }

        public int hashCode() {
            int hashCode = ((Boolean.hashCode(this.isLoading) * 31) + Boolean.hashCode(this.showDeleteDialog)) * 31;
            UserVehicle userVehicle = this.originalVehicle;
            return hashCode + (userVehicle == null ? 0 : userVehicle.hashCode());
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public String toString() {
            return "ViewState(isLoading=" + this.isLoading + ", showDeleteDialog=" + this.showDeleteDialog + ", originalVehicle=" + this.originalVehicle + ")";
        }

        public /* synthetic */ ViewState(boolean z5, boolean z6, UserVehicle userVehicle, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? false : z5, (i5 & 2) != 0 ? false : z6, (i5 & 4) != 0 ? null : userVehicle);
        }
    }
}
