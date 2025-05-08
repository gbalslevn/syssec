package dk.molslinjen.ui.views.screens.profile.vehicles.register;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.user.vehicles.IUserVehiclesManager;
import dk.molslinjen.domain.model.account.LicensePlateValidation;
import dk.molslinjen.ui.views.screens.profile.vehicles.shared.InputState;
import dk.molslinjen.ui.views.screens.profile.vehicles.shared.ProfileVehicleInputHandler;
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

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001%B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u0011\u0010\u000eJ\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0018R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0019R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u001e8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b#\u0010 ¨\u0006&"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/vehicles/register/ProfileVehiclesRegisterViewModel;", "Landroidx/lifecycle/ViewModel;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/managers/user/vehicles/IUserVehiclesManager;", "vehiclesManager", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "snackbarService", "<init>", "(Ldk/molslinjen/domain/managers/user/vehicles/IUserVehiclesManager;Ldk/molslinjen/core/snackbar/ISnackbarService;)V", "Lkotlin/Function0;", BuildConfig.FLAVOR, "finishFlow", "Lkotlinx/coroutines/Job;", "validateLicencePlate", "(Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/Job;", "cancelRegisterValidation", "()V", "registerVehicle", BuildConfig.FLAVOR, "licensePlate", "updateLicensePlate", "(Ljava/lang/String;)V", "name", "updateName", "Ldk/molslinjen/domain/managers/user/vehicles/IUserVehiclesManager;", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/profile/vehicles/register/ProfileVehiclesRegisterViewModel$ViewState;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "viewState", "Ldk/molslinjen/ui/views/screens/profile/vehicles/shared/IProfileVehicleInputHandler$InputState;", "getVehicleInput", "vehicleInput", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProfileVehiclesRegisterViewModel extends ViewModel {
    private final /* synthetic */ ProfileVehicleInputHandler $$delegate_0;
    private final MutableStateFlow<ViewState> _viewState;
    private final ISnackbarService snackbarService;
    private final IUserVehiclesManager vehiclesManager;

    /* JADX WARN: Multi-variable type inference failed */
    public ProfileVehiclesRegisterViewModel(IUserVehiclesManager vehiclesManager, ISnackbarService snackbarService) {
        Intrinsics.checkNotNullParameter(vehiclesManager, "vehiclesManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        this.$$delegate_0 = new ProfileVehicleInputHandler();
        this.vehiclesManager = vehiclesManager;
        this.snackbarService = snackbarService;
        this._viewState = StateFlowKt.MutableStateFlow(new ViewState(null, false, 3, 0 == true ? 1 : 0));
    }

    public final void cancelRegisterValidation() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, value.copy(null, false)));
    }

    public StateFlow<InputState> getVehicleInput() {
        return this.$$delegate_0.getVehicleInput();
    }

    public final StateFlow<ViewState> getViewState() {
        return this._viewState;
    }

    public final Job registerVehicle(Function0<Unit> finishFlow) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(finishFlow, "finishFlow");
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ProfileVehiclesRegisterViewModel$registerVehicle$1(this, finishFlow, null), 3, null);
        return launch$default;
    }

    public void updateLicensePlate(String licensePlate) {
        Intrinsics.checkNotNullParameter(licensePlate, "licensePlate");
        this.$$delegate_0.updateLicensePlate(licensePlate);
    }

    public void updateName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.$$delegate_0.updateName(name);
    }

    public final Job validateLicencePlate(Function0<Unit> finishFlow) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(finishFlow, "finishFlow");
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ProfileVehiclesRegisterViewModel$validateLicencePlate$1(this, finishFlow, null), 3, null);
        return launch$default;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0005\u0010\u0017¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/vehicles/register/ProfileVehiclesRegisterViewModel$ViewState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/account/LicensePlateValidation$Valid;", "licensePlaceValidation", BuildConfig.FLAVOR, "isLoading", "<init>", "(Ldk/molslinjen/domain/model/account/LicensePlateValidation$Valid;Z)V", "copy", "(Ldk/molslinjen/domain/model/account/LicensePlateValidation$Valid;Z)Ldk/molslinjen/ui/views/screens/profile/vehicles/register/ProfileVehiclesRegisterViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/account/LicensePlateValidation$Valid;", "getLicensePlaceValidation", "()Ldk/molslinjen/domain/model/account/LicensePlateValidation$Valid;", "Z", "()Z", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final boolean isLoading;
        private final LicensePlateValidation.Valid licensePlaceValidation;

        public ViewState(LicensePlateValidation.Valid valid, boolean z5) {
            this.licensePlaceValidation = valid;
            this.isLoading = z5;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, LicensePlateValidation.Valid valid, boolean z5, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                valid = viewState.licensePlaceValidation;
            }
            if ((i5 & 2) != 0) {
                z5 = viewState.isLoading;
            }
            return viewState.copy(valid, z5);
        }

        public final ViewState copy(LicensePlateValidation.Valid licensePlaceValidation, boolean isLoading) {
            return new ViewState(licensePlaceValidation, isLoading);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics.areEqual(this.licensePlaceValidation, viewState.licensePlaceValidation) && this.isLoading == viewState.isLoading;
        }

        public final LicensePlateValidation.Valid getLicensePlaceValidation() {
            return this.licensePlaceValidation;
        }

        public int hashCode() {
            LicensePlateValidation.Valid valid = this.licensePlaceValidation;
            return ((valid == null ? 0 : valid.hashCode()) * 31) + Boolean.hashCode(this.isLoading);
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public String toString() {
            return "ViewState(licensePlaceValidation=" + this.licensePlaceValidation + ", isLoading=" + this.isLoading + ")";
        }

        public /* synthetic */ ViewState(LicensePlateValidation.Valid valid, boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? null : valid, (i5 & 2) != 0 ? false : z5);
        }
    }
}
