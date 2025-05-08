package dk.molslinjen.ui.views.screens.profile.vehicles.shared;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\bR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/vehicles/shared/ProfileVehicleInputHandler;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "licensePlate", BuildConfig.FLAVOR, "updateLicensePlate", "(Ljava/lang/String;)V", "name", "updateName", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/profile/vehicles/shared/IProfileVehicleInputHandler$InputState;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "getVehicleInput", "()Lkotlinx/coroutines/flow/StateFlow;", "vehicleInput", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProfileVehicleInputHandler {
    private final MutableStateFlow<InputState> _viewState = StateFlowKt.MutableStateFlow(new InputState(null, null, 3, null));

    public StateFlow<InputState> getVehicleInput() {
        return this._viewState;
    }

    public void updateLicensePlate(String licensePlate) {
        InputState value;
        Intrinsics.checkNotNullParameter(licensePlate, "licensePlate");
        MutableStateFlow<InputState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, InputState.copy$default(value, licensePlate, null, 2, null)));
    }

    public void updateName(String name) {
        InputState value;
        Intrinsics.checkNotNullParameter(name, "name");
        MutableStateFlow<InputState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, InputState.copy$default(value, null, name, 1, null)));
    }
}
