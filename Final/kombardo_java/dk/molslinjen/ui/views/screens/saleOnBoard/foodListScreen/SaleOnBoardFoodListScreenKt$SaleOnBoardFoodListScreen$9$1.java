package dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen;

import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProduct;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class SaleOnBoardFoodListScreenKt$SaleOnBoardFoodListScreen$9$1 extends FunctionReferenceImpl implements Function2<SaleOnBoardProduct, Integer, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SaleOnBoardFoodListScreenKt$SaleOnBoardFoodListScreen$9$1(Object obj) {
        super(2, obj, SaleOnBoardFoodListViewModel.class, "seenProduct", "seenProduct(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(SaleOnBoardProduct saleOnBoardProduct, Integer num) {
        invoke(saleOnBoardProduct, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(SaleOnBoardProduct p02, int i5) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((SaleOnBoardFoodListViewModel) this.receiver).seenProduct(p02, i5);
    }
}
