package dk.molslinjen.ui.views.screens.booking.departures;

import dk.molslinjen.domain.managers.route.RouteSelectedState;
import dk.molslinjen.domain.managers.route.RouteSharedSelectedState;
import dk.molslinjen.domain.model.booking.RouteDirection;
import dk.molslinjen.domain.model.config.Route;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.ui.views.shared.routeSelector.helpers.IRouteLocationHelper;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DeparturesViewModel$switchToStartFromNearestHarbor$3<T> implements FlowCollector {
    final /* synthetic */ DeparturesViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeparturesViewModel$switchToStartFromNearestHarbor$3(DeparturesViewModel departuresViewModel) {
        this.this$0 = departuresViewModel;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return emit((Pair<RouteSharedSelectedState, RouteSelectedState>) obj, (Continuation<? super Unit>) continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Pair<RouteSharedSelectedState, RouteSelectedState> pair, Continuation<? super Unit> continuation) {
        DeparturesViewModel$switchToStartFromNearestHarbor$3$emit$1 departuresViewModel$switchToStartFromNearestHarbor$3$emit$1;
        int i5;
        RouteSelectedState component2;
        IRouteLocationHelper iRouteLocationHelper;
        DeparturesViewModel$switchToStartFromNearestHarbor$3<T> departuresViewModel$switchToStartFromNearestHarbor$3;
        RouteDirection routeDirection;
        if (continuation instanceof DeparturesViewModel$switchToStartFromNearestHarbor$3$emit$1) {
            departuresViewModel$switchToStartFromNearestHarbor$3$emit$1 = (DeparturesViewModel$switchToStartFromNearestHarbor$3$emit$1) continuation;
            int i6 = departuresViewModel$switchToStartFromNearestHarbor$3$emit$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                departuresViewModel$switchToStartFromNearestHarbor$3$emit$1.label = i6 - Integer.MIN_VALUE;
                Object obj = departuresViewModel$switchToStartFromNearestHarbor$3$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = departuresViewModel$switchToStartFromNearestHarbor$3$emit$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    RouteSharedSelectedState component1 = pair.component1();
                    component2 = pair.component2();
                    iRouteLocationHelper = this.this$0.routeLocationHelper;
                    Route selectedRoute = component1.getSelectedRoute();
                    Site site = component1.getSite();
                    departuresViewModel$switchToStartFromNearestHarbor$3$emit$1.L$0 = this;
                    departuresViewModel$switchToStartFromNearestHarbor$3$emit$1.L$1 = component2;
                    departuresViewModel$switchToStartFromNearestHarbor$3$emit$1.label = 1;
                    obj = iRouteLocationHelper.getNearestRouteDirection(selectedRoute, site, 2, departuresViewModel$switchToStartFromNearestHarbor$3$emit$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    departuresViewModel$switchToStartFromNearestHarbor$3 = this;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    component2 = (RouteSelectedState) departuresViewModel$switchToStartFromNearestHarbor$3$emit$1.L$1;
                    departuresViewModel$switchToStartFromNearestHarbor$3 = (DeparturesViewModel$switchToStartFromNearestHarbor$3) departuresViewModel$switchToStartFromNearestHarbor$3$emit$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                routeDirection = (RouteDirection) obj;
                if (routeDirection != null && component2.getSelectedRouteDirection() != routeDirection) {
                    departuresViewModel$switchToStartFromNearestHarbor$3.this$0.flipDirection();
                }
                return Unit.INSTANCE;
            }
        }
        departuresViewModel$switchToStartFromNearestHarbor$3$emit$1 = new DeparturesViewModel$switchToStartFromNearestHarbor$3$emit$1(this, continuation);
        Object obj2 = departuresViewModel$switchToStartFromNearestHarbor$3$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = departuresViewModel$switchToStartFromNearestHarbor$3$emit$1.label;
        if (i5 != 0) {
        }
        routeDirection = (RouteDirection) obj2;
        if (routeDirection != null) {
            departuresViewModel$switchToStartFromNearestHarbor$3.this$0.flipDirection();
        }
        return Unit.INSTANCE;
    }
}
