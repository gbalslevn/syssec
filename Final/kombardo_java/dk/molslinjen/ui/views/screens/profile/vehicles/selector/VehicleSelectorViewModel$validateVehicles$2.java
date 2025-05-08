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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "isValid", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.vehicles.selector.VehicleSelectorViewModel$validateVehicles$2", f = "VehicleSelectorViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class VehicleSelectorViewModel$validateVehicles$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    final /* synthetic */ UserVehicle $vehicle;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ VehicleSelectorViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VehicleSelectorViewModel$validateVehicles$2(VehicleSelectorViewModel vehicleSelectorViewModel, UserVehicle userVehicle, Continuation<? super VehicleSelectorViewModel$validateVehicles$2> continuation) {
        super(2, continuation);
        this.this$0 = vehicleSelectorViewModel;
        this.$vehicle = userVehicle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        VehicleSelectorViewModel$validateVehicles$2 vehicleSelectorViewModel$validateVehicles$2 = new VehicleSelectorViewModel$validateVehicles$2(this.this$0, this.$vehicle, continuation);
        vehicleSelectorViewModel$validateVehicles$2.Z$0 = ((Boolean) obj).booleanValue();
        return vehicleSelectorViewModel$validateVehicles$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
        return invoke(bool.booleanValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object value;
        VehicleSelectorViewModel.ViewState viewState;
        List<UserVehicle> list;
        List<UserVehicle> list2;
        ArrayList arrayList;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        boolean z5 = this.Z$0;
        MutableStateFlow mutableStateFlow = this.this$0._viewState;
        UserVehicle userVehicle = this.$vehicle;
        do {
            value = mutableStateFlow.getValue();
            viewState = (VehicleSelectorViewModel.ViewState) value;
            List<UserVehicle> availableVehicles = viewState.getAvailableVehicles();
            if (z5) {
                availableVehicles = CollectionsKt.plus((Collection<? extends UserVehicle>) availableVehicles, userVehicle);
            }
            list = availableVehicles;
            List<UserVehicle> unavailableVehicles = viewState.getUnavailableVehicles();
            if (!z5) {
                unavailableVehicles = CollectionsKt.plus((Collection<? extends UserVehicle>) unavailableVehicles, userVehicle);
            }
            list2 = unavailableVehicles;
            List<UserVehicle> unvalidatedVehicles = viewState.getUnvalidatedVehicles();
            arrayList = new ArrayList();
            for (Object obj2 : unvalidatedVehicles) {
                if (!Intrinsics.areEqual((UserVehicle) obj2, userVehicle)) {
                    arrayList.add(obj2);
                }
            }
        } while (!mutableStateFlow.compareAndSet(value, VehicleSelectorViewModel.ViewState.copy$default(viewState, arrayList, list, list2, false, false, null, null, 120, null)));
        return Unit.INSTANCE;
    }

    public final Object invoke(boolean z5, Continuation<? super Unit> continuation) {
        return ((VehicleSelectorViewModel$validateVehicles$2) create(Boolean.valueOf(z5), continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
