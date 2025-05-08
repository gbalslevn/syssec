package dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen;

import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardCategory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class SaleOnBoardFoodListScreenKt$SaleOnBoardFoodListScreen$5$1 extends FunctionReferenceImpl implements Function1<SaleOnBoardCategory, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SaleOnBoardFoodListScreenKt$SaleOnBoardFoodListScreen$5$1(Object obj) {
        super(1, obj, SaleOnBoardFoodListViewModel.class, "selectCategory", "selectCategory(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCategory;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SaleOnBoardCategory saleOnBoardCategory) {
        invoke2(saleOnBoardCategory);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SaleOnBoardCategory p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((SaleOnBoardFoodListViewModel) this.receiver).selectCategory(p02);
    }
}
