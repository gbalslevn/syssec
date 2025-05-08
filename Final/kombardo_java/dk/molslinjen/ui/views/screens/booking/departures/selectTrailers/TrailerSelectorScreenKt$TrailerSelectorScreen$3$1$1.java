package dk.molslinjen.ui.views.screens.booking.departures.selectTrailers;

import dk.molslinjen.domain.model.booking.product.TrailerProduct;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class TrailerSelectorScreenKt$TrailerSelectorScreen$3$1$1 extends FunctionReferenceImpl implements Function1<TrailerProduct, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TrailerSelectorScreenKt$TrailerSelectorScreen$3$1$1(Object obj) {
        super(1, obj, TrailerSelectorViewModel.class, "trailerSelected", "trailerSelected(Ldk/molslinjen/domain/model/booking/product/TrailerProduct;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TrailerProduct trailerProduct) {
        invoke2(trailerProduct);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(TrailerProduct p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((TrailerSelectorViewModel) this.receiver).trailerSelected(p02);
    }
}
