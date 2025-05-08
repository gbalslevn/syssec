package dk.molslinjen.domain.managers.user.vehicles;

import dk.molslinjen.api.services.account.vehicle.response.VehicleDTO;
import dk.molslinjen.api.services.account.vehicle.response.VehiclesResponseDTO;
import dk.molslinjen.domain.model.account.UserVehicle;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "data", "Ldk/molslinjen/api/services/account/vehicle/response/VehiclesResponseDTO;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.user.vehicles.UserVehiclesManager$loadVehicles$2", f = "UserVehiclesManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class UserVehiclesManager$loadVehicles$2 extends SuspendLambda implements Function2<VehiclesResponseDTO, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ UserVehiclesManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserVehiclesManager$loadVehicles$2(UserVehiclesManager userVehiclesManager, Continuation<? super UserVehiclesManager$loadVehicles$2> continuation) {
        super(2, continuation);
        this.this$0 = userVehiclesManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        UserVehiclesManager$loadVehicles$2 userVehiclesManager$loadVehicles$2 = new UserVehiclesManager$loadVehicles$2(this.this$0, continuation);
        userVehiclesManager$loadVehicles$2.L$0 = obj;
        return userVehiclesManager$loadVehicles$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(VehiclesResponseDTO vehiclesResponseDTO, Continuation<? super Unit> continuation) {
        return ((UserVehiclesManager$loadVehicles$2) create(vehiclesResponseDTO, continuation)).invokeSuspend(Unit.INSTANCE);
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
        VehiclesResponseDTO vehiclesResponseDTO = (VehiclesResponseDTO) this.L$0;
        MutableStateFlow<UserVehiclesState> vehiclesState = this.this$0.getVehiclesState();
        do {
            value = vehiclesState.getValue();
            userVehiclesState = value;
            List<VehicleDTO> vehicles = vehiclesResponseDTO.getVehicles();
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(vehicles, 10));
            Iterator<T> it = vehicles.iterator();
            while (it.hasNext()) {
                arrayList.add(new UserVehicle((VehicleDTO) it.next()));
            }
        } while (!vehiclesState.compareAndSet(value, userVehiclesState.copy(arrayList)));
        return Unit.INSTANCE;
    }
}
