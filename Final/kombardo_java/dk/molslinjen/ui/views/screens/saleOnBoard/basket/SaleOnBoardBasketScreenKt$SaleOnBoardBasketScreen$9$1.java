package dk.molslinjen.ui.views.screens.saleOnBoard.basket;

import dk.molslinjen.domain.model.saleOnBoard.NotificationType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class SaleOnBoardBasketScreenKt$SaleOnBoardBasketScreen$9$1 extends FunctionReferenceImpl implements Function1<NotificationType, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SaleOnBoardBasketScreenKt$SaleOnBoardBasketScreen$9$1(Object obj) {
        super(1, obj, SaleOnBoardBasketViewModel.class, "onNotificationTypeChange", "onNotificationTypeChange(Ldk/molslinjen/domain/model/saleOnBoard/NotificationType;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(NotificationType notificationType) {
        invoke2(notificationType);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(NotificationType p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((SaleOnBoardBasketViewModel) this.receiver).onNotificationTypeChange(p02);
    }
}
