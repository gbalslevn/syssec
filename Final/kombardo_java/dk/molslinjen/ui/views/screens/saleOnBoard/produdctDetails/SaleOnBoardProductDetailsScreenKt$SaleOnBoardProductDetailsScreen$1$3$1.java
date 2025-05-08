package dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails;

import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardVariant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class SaleOnBoardProductDetailsScreenKt$SaleOnBoardProductDetailsScreen$1$3$1 extends FunctionReferenceImpl implements Function1<SaleOnBoardVariant, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SaleOnBoardProductDetailsScreenKt$SaleOnBoardProductDetailsScreen$1$3$1(Object obj) {
        super(1, obj, SaleOnBoardProductDetailsViewModel.class, "selectVariant", "selectVariant(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardVariant;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SaleOnBoardVariant saleOnBoardVariant) {
        invoke2(saleOnBoardVariant);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SaleOnBoardVariant p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((SaleOnBoardProductDetailsViewModel) this.receiver).selectVariant(p02);
    }
}
