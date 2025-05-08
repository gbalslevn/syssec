package dk.molslinjen.ui.views.screens.booking.departures.selectTransportationProducts;

import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.product.Product;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class TransportProductSelectorScreenKt$TransportProductSelectorScreen$3$1$1 extends FunctionReferenceImpl implements Function3<Integer, Product, DepartureDirection, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TransportProductSelectorScreenKt$TransportProductSelectorScreen$3$1$1(Object obj) {
        super(3, obj, TransportProductSelectorViewModel.class, "changeQuantity", "changeQuantity(ILdk/molslinjen/domain/model/booking/product/Product;Ldk/molslinjen/domain/model/booking/DepartureDirection;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Product product, DepartureDirection departureDirection) {
        invoke(num.intValue(), product, departureDirection);
        return Unit.INSTANCE;
    }

    public final void invoke(int i5, Product p12, DepartureDirection p22) {
        Intrinsics.checkNotNullParameter(p12, "p1");
        Intrinsics.checkNotNullParameter(p22, "p2");
        ((TransportProductSelectorViewModel) this.receiver).changeQuantity(i5, p12, p22);
    }
}
