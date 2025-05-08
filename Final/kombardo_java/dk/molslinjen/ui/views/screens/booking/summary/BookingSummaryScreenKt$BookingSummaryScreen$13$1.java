package dk.molslinjen.ui.views.screens.booking.summary;

import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.product.Product;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class BookingSummaryScreenKt$BookingSummaryScreen$13$1 extends FunctionReferenceImpl implements Function3<DepartureDirection, Product, Integer, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BookingSummaryScreenKt$BookingSummaryScreen$13$1(Object obj) {
        super(3, obj, BookingSummaryViewModel.class, "onProductQuantityChanged", "onProductQuantityChanged(Ldk/molslinjen/domain/model/booking/DepartureDirection;Ldk/molslinjen/domain/model/booking/product/Product;I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(DepartureDirection departureDirection, Product product, Integer num) {
        invoke(departureDirection, product, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(DepartureDirection p02, Product p12, int i5) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        Intrinsics.checkNotNullParameter(p12, "p1");
        ((BookingSummaryViewModel) this.receiver).onProductQuantityChanged(p02, p12, i5);
    }
}
