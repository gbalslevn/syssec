package dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails;

import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProductAddOn;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProductAddOnOption;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class SaleOnBoardProductDetailsScreenKt$SaleOnBoardProductDetailsScreen$1$1$1 extends FunctionReferenceImpl implements Function2<SaleOnBoardProductAddOn, SaleOnBoardProductAddOnOption, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SaleOnBoardProductDetailsScreenKt$SaleOnBoardProductDetailsScreen$1$1$1(Object obj) {
        super(2, obj, SaleOnBoardProductDetailsViewModel.class, "selectOption", "selectOption(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProductAddOn;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProductAddOnOption;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(SaleOnBoardProductAddOn saleOnBoardProductAddOn, SaleOnBoardProductAddOnOption saleOnBoardProductAddOnOption) {
        invoke2(saleOnBoardProductAddOn, saleOnBoardProductAddOnOption);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SaleOnBoardProductAddOn p02, SaleOnBoardProductAddOnOption saleOnBoardProductAddOnOption) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((SaleOnBoardProductDetailsViewModel) this.receiver).selectOption(p02, saleOnBoardProductAddOnOption);
    }
}
