package dk.molslinjen.ui.views.screens.saleOnBoard.basket;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class SaleOnBoardBasketScreenKt$SaleOnBoardBasketScreen$12$1 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SaleOnBoardBasketScreenKt$SaleOnBoardBasketScreen$12$1(Object obj) {
        super(0, obj, SaleOnBoardBasketViewModel.class, "undoRemoveLastLineItem", "undoRemoveLastLineItem()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((SaleOnBoardBasketViewModel) this.receiver).undoRemoveLastLineItem();
    }
}
