package dk.molslinjen.ui.views.screens.profile.vehicles.edit;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class ProfileVehicleEditScreenKt$ProfileVehicleEditScreen$6$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ProfileVehicleEditScreenKt$ProfileVehicleEditScreen$6$1$1(Object obj) {
        super(0, obj, ProfileVehiclesEditViewModel.class, "triggerDeleteFlow", "triggerDeleteFlow()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((ProfileVehiclesEditViewModel) this.receiver).triggerDeleteFlow();
    }
}
