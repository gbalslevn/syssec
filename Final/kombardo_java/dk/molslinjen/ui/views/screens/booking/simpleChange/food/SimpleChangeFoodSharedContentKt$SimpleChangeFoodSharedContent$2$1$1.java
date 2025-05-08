package dk.molslinjen.ui.views.screens.booking.simpleChange.food;

import dk.molslinjen.domain.model.booking.product.Product;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class SimpleChangeFoodSharedContentKt$SimpleChangeFoodSharedContent$2$1$1 extends FunctionReferenceImpl implements Function2<Product, Integer, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SimpleChangeFoodSharedContentKt$SimpleChangeFoodSharedContent$2$1$1(Object obj) {
        super(2, obj, SimpleChangeFoodViewModel.class, "onQuantityChanged", "onQuantityChanged(Ldk/molslinjen/domain/model/booking/product/Product;I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Product product, Integer num) {
        invoke(product, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Product p02, int i5) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((SimpleChangeFoodViewModel) this.receiver).onQuantityChanged(p02, i5);
    }
}
