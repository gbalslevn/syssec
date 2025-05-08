package dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture;

import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardRouteState;
import dk.molslinjen.domain.model.booking.RouteDirection;
import dk.molslinjen.domain.model.config.Route;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.ui.views.shared.routeSelector.helpers.IRouteLocationHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2<T> implements FlowCollector {
    final /* synthetic */ SaleOnBoardDepartureSelectorViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SaleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2(SaleOnBoardDepartureSelectorViewModel saleOnBoardDepartureSelectorViewModel) {
        this.this$0 = saleOnBoardDepartureSelectorViewModel;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(SaleOnBoardRouteState saleOnBoardRouteState, Continuation<? super Unit> continuation) {
        SaleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2$emit$1 saleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2$emit$1;
        int i5;
        IRouteLocationHelper iRouteLocationHelper;
        SaleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2<T> saleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2;
        RouteDirection routeDirection;
        if (continuation instanceof SaleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2$emit$1) {
            saleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2$emit$1 = (SaleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2$emit$1) continuation;
            int i6 = saleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2$emit$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                saleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2$emit$1.label = i6 - Integer.MIN_VALUE;
                Object obj = saleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = saleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2$emit$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    iRouteLocationHelper = this.this$0.routeLocationHelper;
                    Route selectedRoute = saleOnBoardRouteState.getSelectedRoute();
                    Site site = saleOnBoardRouteState.getSite();
                    saleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2$emit$1.L$0 = this;
                    saleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2$emit$1.L$1 = saleOnBoardRouteState;
                    saleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2$emit$1.label = 1;
                    obj = iRouteLocationHelper.getNearestRouteDirection(selectedRoute, site, 2, saleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2$emit$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    saleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2 = this;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    saleOnBoardRouteState = (SaleOnBoardRouteState) saleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2$emit$1.L$1;
                    saleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2 = (SaleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2) saleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2$emit$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                routeDirection = (RouteDirection) obj;
                if (routeDirection != null && saleOnBoardRouteState.getSelectedRouteDirection() != routeDirection) {
                    saleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2.this$0.flipDirection();
                }
                return Unit.INSTANCE;
            }
        }
        saleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2$emit$1 = new SaleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2$emit$1(this, continuation);
        Object obj2 = saleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = saleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2$emit$1.label;
        if (i5 != 0) {
        }
        routeDirection = (RouteDirection) obj2;
        if (routeDirection != null) {
            saleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2.this$0.flipDirection();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return emit((SaleOnBoardRouteState) obj, (Continuation<? super Unit>) continuation);
    }
}
