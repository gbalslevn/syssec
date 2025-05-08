package dk.molslinjen.ui.views.screens.agreements.multiride.details;

import dk.molslinjen.domain.model.agreement.multiRide.MultiRideAssociatedVehicle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public /* synthetic */ class MultiRideDetailsScreenKt$MultiRideDetailsScreen$6$1 extends FunctionReferenceImpl implements Function1<MultiRideAssociatedVehicle, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiRideDetailsScreenKt$MultiRideDetailsScreen$6$1(Object obj) {
        super(1, obj, MultiRideDetailsViewModel.class, "triggerRemoveVehicleFlow", "triggerRemoveVehicleFlow(Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideAssociatedVehicle;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MultiRideAssociatedVehicle multiRideAssociatedVehicle) {
        invoke2(multiRideAssociatedVehicle);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MultiRideAssociatedVehicle p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((MultiRideDetailsViewModel) this.receiver).triggerRemoveVehicleFlow(p02);
    }
}
