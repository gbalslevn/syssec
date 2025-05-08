package dk.molslinjen.ui.views.screens.profile.vehicles.register;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class ProfileVehiclesRegisterScreenKt$ProfileVehiclesRegisterScreen$2$1 extends AdaptedFunctionReference implements Function1<Function0<? extends Unit>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ProfileVehiclesRegisterScreenKt$ProfileVehiclesRegisterScreen$2$1(Object obj) {
        super(1, obj, ProfileVehiclesRegisterViewModel.class, "registerVehicle", "registerVehicle(Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/Job;", 8);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0) {
        invoke2((Function0<Unit>) function0);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Function0<Unit> p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((ProfileVehiclesRegisterViewModel) this.receiver).registerVehicle(p02);
    }
}
