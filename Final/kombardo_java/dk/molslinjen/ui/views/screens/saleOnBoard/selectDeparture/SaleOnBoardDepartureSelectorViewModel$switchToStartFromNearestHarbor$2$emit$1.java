package dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture;

import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardRouteState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.SaleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2", f = "SaleOnBoardDepartureSelectorViewModel.kt", l = {55}, m = "emit")
/* loaded from: classes2.dex */
public final class SaleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SaleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SaleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2$emit$1(SaleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2<? super T> saleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2, Continuation<? super SaleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2$emit$1> continuation) {
        super(continuation);
        this.this$0 = saleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((SaleOnBoardRouteState) null, (Continuation<? super Unit>) this);
    }
}
