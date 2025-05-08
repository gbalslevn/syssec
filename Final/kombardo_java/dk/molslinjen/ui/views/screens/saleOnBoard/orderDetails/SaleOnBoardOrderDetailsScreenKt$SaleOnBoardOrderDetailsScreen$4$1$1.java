package dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails;

import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class SaleOnBoardOrderDetailsScreenKt$SaleOnBoardOrderDetailsScreen$4$1$1 extends FunctionReferenceImpl implements Function1<SaleOnBoardOrder, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SaleOnBoardOrderDetailsScreenKt$SaleOnBoardOrderDetailsScreen$4$1$1(Object obj) {
        super(1, obj, SaleOnBoardOrderDetailsViewModel.class, "cancelOrder", "cancelOrder(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SaleOnBoardOrder saleOnBoardOrder) {
        invoke2(saleOnBoardOrder);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SaleOnBoardOrder p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((SaleOnBoardOrderDetailsViewModel) this.receiver).cancelOrder(p02);
    }
}
