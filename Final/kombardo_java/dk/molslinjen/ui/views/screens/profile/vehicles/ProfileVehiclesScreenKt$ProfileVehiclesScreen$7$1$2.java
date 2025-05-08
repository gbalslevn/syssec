package dk.molslinjen.ui.views.screens.profile.vehicles;

import dk.molslinjen.domain.model.account.UserVehicle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public /* synthetic */ class ProfileVehiclesScreenKt$ProfileVehiclesScreen$7$1$2 extends FunctionReferenceImpl implements Function1<UserVehicle, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ProfileVehiclesScreenKt$ProfileVehiclesScreen$7$1$2(Object obj) {
        super(1, obj, ProfileVehiclesViewModel.class, "triggerDeleteFlow", "triggerDeleteFlow(Ldk/molslinjen/domain/model/account/UserVehicle;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(UserVehicle userVehicle) {
        invoke2(userVehicle);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(UserVehicle p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((ProfileVehiclesViewModel) this.receiver).triggerDeleteFlow(p02);
    }
}
