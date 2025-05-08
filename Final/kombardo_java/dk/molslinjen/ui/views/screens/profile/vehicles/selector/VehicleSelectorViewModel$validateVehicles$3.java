package dk.molslinjen.ui.views.screens.profile.vehicles.selector;

import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.ui.views.screens.profile.vehicles.selector.VehicleSelectorViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.vehicles.selector.VehicleSelectorViewModel$validateVehicles$3", f = "VehicleSelectorViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class VehicleSelectorViewModel$validateVehicles$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ UserVehicle $vehicle;
    int label;
    final /* synthetic */ VehicleSelectorViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VehicleSelectorViewModel$validateVehicles$3(VehicleSelectorViewModel vehicleSelectorViewModel, UserVehicle userVehicle, Continuation<? super VehicleSelectorViewModel$validateVehicles$3> continuation) {
        super(1, continuation);
        this.this$0 = vehicleSelectorViewModel;
        this.$vehicle = userVehicle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new VehicleSelectorViewModel$validateVehicles$3(this.this$0, this.$vehicle, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object value;
        VehicleSelectorViewModel.ViewState viewState;
        List plus;
        ArrayList arrayList;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        MutableStateFlow mutableStateFlow = this.this$0._viewState;
        UserVehicle userVehicle = this.$vehicle;
        do {
            value = mutableStateFlow.getValue();
            viewState = (VehicleSelectorViewModel.ViewState) value;
            plus = CollectionsKt.plus((Collection<? extends UserVehicle>) viewState.getUnavailableVehicles(), userVehicle);
            List<UserVehicle> unvalidatedVehicles = viewState.getUnvalidatedVehicles();
            arrayList = new ArrayList();
            for (Object obj2 : unvalidatedVehicles) {
                if (!Intrinsics.areEqual((UserVehicle) obj2, userVehicle)) {
                    arrayList.add(obj2);
                }
            }
        } while (!mutableStateFlow.compareAndSet(value, VehicleSelectorViewModel.ViewState.copy$default(viewState, arrayList, null, plus, false, false, null, null, 122, null)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((VehicleSelectorViewModel$validateVehicles$3) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
