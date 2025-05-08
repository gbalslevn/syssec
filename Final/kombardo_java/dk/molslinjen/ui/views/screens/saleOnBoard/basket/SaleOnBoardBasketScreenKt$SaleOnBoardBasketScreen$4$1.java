package dk.molslinjen.ui.views.screens.saleOnBoard.basket;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class SaleOnBoardBasketScreenKt$SaleOnBoardBasketScreen$4$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SaleOnBoardBasketScreenKt$SaleOnBoardBasketScreen$4$1(Object obj) {
        super(1, obj, SaleOnBoardBasketViewModel.class, "onPickupTimeCategorySelection", "onPickupTimeCategorySelection(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z5) {
        ((SaleOnBoardBasketViewModel) this.receiver).onPickupTimeCategorySelection(z5);
    }
}
