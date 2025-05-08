package dk.molslinjen.ui.views.screens.saleOnBoard.basket;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class SaleOnBoardBasketScreenKt$SaleOnBoardBasketScreen$6$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SaleOnBoardBasketScreenKt$SaleOnBoardBasketScreen$6$1(Object obj) {
        super(1, obj, SaleOnBoardBasketViewModel.class, "onNameChange", "onNameChange(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((SaleOnBoardBasketViewModel) this.receiver).onNameChange(p02);
    }
}
