package dk.molslinjen.ui.views.screens.booking.departures.selectTransportation;

import dk.molslinjen.domain.model.config.TransportationCategory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class TransportationSelectorScreenKt$TransportationSelectorScreen$4$2$1 extends FunctionReferenceImpl implements Function1<TransportationCategory, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TransportationSelectorScreenKt$TransportationSelectorScreen$4$2$1(Object obj) {
        super(1, obj, TransportationSelectorViewModel.class, "transportationCategorySelected", "transportationCategorySelected(Ldk/molslinjen/domain/model/config/TransportationCategory;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TransportationCategory transportationCategory) {
        invoke2(transportationCategory);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(TransportationCategory p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((TransportationSelectorViewModel) this.receiver).transportationCategorySelected(p02);
    }
}
