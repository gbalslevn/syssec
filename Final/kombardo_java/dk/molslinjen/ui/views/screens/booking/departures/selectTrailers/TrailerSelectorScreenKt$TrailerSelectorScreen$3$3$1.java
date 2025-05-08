package dk.molslinjen.ui.views.screens.booking.departures.selectTrailers;

import dk.molslinjen.domain.model.booking.DepartureDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class TrailerSelectorScreenKt$TrailerSelectorScreen$3$3$1 extends FunctionReferenceImpl implements Function2<DepartureDirection, Boolean, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TrailerSelectorScreenKt$TrailerSelectorScreen$3$3$1(Object obj) {
        super(2, obj, TrailerSelectorViewModel.class, "onChangedForDirection", "onChangedForDirection(Ldk/molslinjen/domain/model/booking/DepartureDirection;Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(DepartureDirection departureDirection, Boolean bool) {
        invoke(departureDirection, bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(DepartureDirection p02, boolean z5) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((TrailerSelectorViewModel) this.receiver).onChangedForDirection(p02, z5);
    }
}
