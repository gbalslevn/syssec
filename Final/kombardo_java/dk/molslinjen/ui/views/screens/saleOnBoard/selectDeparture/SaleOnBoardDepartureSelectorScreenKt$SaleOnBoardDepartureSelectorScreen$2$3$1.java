package dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.LocalDate;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class SaleOnBoardDepartureSelectorScreenKt$SaleOnBoardDepartureSelectorScreen$2$3$1 extends FunctionReferenceImpl implements Function1<LocalDate, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SaleOnBoardDepartureSelectorScreenKt$SaleOnBoardDepartureSelectorScreen$2$3$1(Object obj) {
        super(1, obj, SaleOnBoardDepartureSelectorViewModel.class, "updateShownHeaderDate", "updateShownHeaderDate(Lorg/threeten/bp/LocalDate;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(LocalDate localDate) {
        invoke2(localDate);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(LocalDate p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((SaleOnBoardDepartureSelectorViewModel) this.receiver).updateShownHeaderDate(p02);
    }
}
