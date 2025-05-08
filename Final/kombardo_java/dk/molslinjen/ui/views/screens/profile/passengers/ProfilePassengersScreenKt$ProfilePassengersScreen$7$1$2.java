package dk.molslinjen.ui.views.screens.profile.passengers;

import dk.molslinjen.domain.model.account.UserPassenger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public /* synthetic */ class ProfilePassengersScreenKt$ProfilePassengersScreen$7$1$2 extends FunctionReferenceImpl implements Function1<UserPassenger, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ProfilePassengersScreenKt$ProfilePassengersScreen$7$1$2(Object obj) {
        super(1, obj, ProfilePassengersViewModel.class, "triggerDeleteFlow", "triggerDeleteFlow(Ldk/molslinjen/domain/model/account/UserPassenger;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(UserPassenger userPassenger) {
        invoke2(userPassenger);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(UserPassenger p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((ProfilePassengersViewModel) this.receiver).triggerDeleteFlow(p02);
    }
}
