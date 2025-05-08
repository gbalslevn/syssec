package dk.molslinjen.ui.views.screens.booking.addons.seating.select;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import uniffi.molslinjen_shared.FerrySeat;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class FerrySectionSeatsScreenKt$FerrySectionSeatsScreen$7$1$1$1 extends FunctionReferenceImpl implements Function1<FerrySeat, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FerrySectionSeatsScreenKt$FerrySectionSeatsScreen$7$1$1$1(Object obj) {
        super(1, obj, FerrySectionSeatsViewModel.class, "toggleSeat", "toggleSeat(Luniffi/molslinjen_shared/FerrySeat;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FerrySeat ferrySeat) {
        invoke2(ferrySeat);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FerrySeat p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((FerrySectionSeatsViewModel) this.receiver).toggleSeat(p02);
    }
}
