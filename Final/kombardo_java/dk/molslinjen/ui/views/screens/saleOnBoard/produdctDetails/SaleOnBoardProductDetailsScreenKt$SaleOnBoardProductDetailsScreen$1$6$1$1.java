package dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails;

import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public /* synthetic */ class SaleOnBoardProductDetailsScreenKt$SaleOnBoardProductDetailsScreen$1$6$1$1 extends AdaptedFunctionReference implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SaleOnBoardProductDetailsScreenKt$SaleOnBoardProductDetailsScreen$1$6$1$1(Object obj) {
        super(0, obj, DestinationsNavigator.class, "popBackStack", "popBackStack()Z", 8);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((DestinationsNavigator) this.receiver).popBackStack();
    }
}
