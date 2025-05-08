package dk.molslinjen.ui.views.screens.booking.departures;

import dk.molslinjen.domain.model.booking.DepartureDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public /* synthetic */ class DeparturesScreenSharedKt$DeparturesScreenShared$7$1 extends AdaptedFunctionReference implements Function1<DepartureDirection, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DeparturesScreenSharedKt$DeparturesScreenShared$7$1(Object obj) {
        super(1, obj, DeparturesViewModel.class, "updateDepartureDirection", "updateDepartureDirection(Ldk/molslinjen/domain/model/booking/DepartureDirection;Lorg/threeten/bp/LocalDate;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DepartureDirection departureDirection) {
        invoke2(departureDirection);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DepartureDirection p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        DeparturesViewModel.updateDepartureDirection$default((DeparturesViewModel) this.receiver, p02, null, 2, null);
    }
}
