package dk.molslinjen.ui.views.screens.booking.departures;

import dk.molslinjen.domain.model.booking.DepartureDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class DeparturesScreenSharedKt$DeparturesScreenShared$15$1 extends FunctionReferenceImpl implements Function1<DepartureDirection, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DeparturesScreenSharedKt$DeparturesScreenShared$15$1(Object obj) {
        super(1, obj, DeparturesViewModel.class, "reloadDeparturesAfterError", "reloadDeparturesAfterError(Ldk/molslinjen/domain/model/booking/DepartureDirection;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DepartureDirection departureDirection) {
        invoke2(departureDirection);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DepartureDirection p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((DeparturesViewModel) this.receiver).reloadDeparturesAfterError(p02);
    }
}
