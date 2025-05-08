package dk.molslinjen.domain.managers.user.vehicles;

import dk.molslinjen.api.services.account.vehicle.response.VehicleDTO;
import dk.molslinjen.domain.model.account.UserVehicle;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "resultVehicle", "Ldk/molslinjen/api/services/account/vehicle/response/VehicleDTO;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.user.vehicles.UserVehiclesManager$updateVehicle$2", f = "UserVehiclesManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class UserVehiclesManager$updateVehicle$2 extends SuspendLambda implements Function2<VehicleDTO, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ UserVehiclesManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserVehiclesManager$updateVehicle$2(UserVehiclesManager userVehiclesManager, Continuation<? super UserVehiclesManager$updateVehicle$2> continuation) {
        super(2, continuation);
        this.this$0 = userVehiclesManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        UserVehiclesManager$updateVehicle$2 userVehiclesManager$updateVehicle$2 = new UserVehiclesManager$updateVehicle$2(this.this$0, continuation);
        userVehiclesManager$updateVehicle$2.L$0 = obj;
        return userVehiclesManager$updateVehicle$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(VehicleDTO vehicleDTO, Continuation<? super Unit> continuation) {
        return ((UserVehiclesManager$updateVehicle$2) create(vehicleDTO, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        UserVehiclesState value;
        UserVehiclesState userVehiclesState;
        ArrayList arrayList;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        VehicleDTO vehicleDTO = (VehicleDTO) this.L$0;
        MutableStateFlow<UserVehiclesState> vehiclesState = this.this$0.getVehiclesState();
        do {
            value = vehiclesState.getValue();
            userVehiclesState = value;
            List<UserVehicle> vehicles = userVehiclesState.getVehicles();
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(vehicles, 10));
            for (UserVehicle userVehicle : vehicles) {
                if (Intrinsics.areEqual(userVehicle.getId(), vehicleDTO.getVehicleId())) {
                    userVehicle = new UserVehicle(vehicleDTO);
                }
                arrayList.add(userVehicle);
            }
        } while (!vehiclesState.compareAndSet(value, userVehiclesState.copy(arrayList)));
        return Unit.INSTANCE;
    }
}
