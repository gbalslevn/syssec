package dk.molslinjen.ui.views.screens.booking.departures;

import dk.molslinjen.domain.managers.route.RouteSelectedState;
import dk.molslinjen.domain.managers.route.RouteSharedSelectedState;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Ldk/molslinjen/domain/managers/route/RouteSharedSelectedState;", "Ldk/molslinjen/domain/managers/route/RouteSelectedState;", "flow1", "flow2"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel$switchToStartFromNearestHarbor$2", f = "DeparturesViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class DeparturesViewModel$switchToStartFromNearestHarbor$2 extends SuspendLambda implements Function3<RouteSharedSelectedState, RouteSelectedState, Continuation<? super Pair<? extends RouteSharedSelectedState, ? extends RouteSelectedState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeparturesViewModel$switchToStartFromNearestHarbor$2(Continuation<? super DeparturesViewModel$switchToStartFromNearestHarbor$2> continuation) {
        super(3, continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(RouteSharedSelectedState routeSharedSelectedState, RouteSelectedState routeSelectedState, Continuation<? super Pair<RouteSharedSelectedState, RouteSelectedState>> continuation) {
        DeparturesViewModel$switchToStartFromNearestHarbor$2 departuresViewModel$switchToStartFromNearestHarbor$2 = new DeparturesViewModel$switchToStartFromNearestHarbor$2(continuation);
        departuresViewModel$switchToStartFromNearestHarbor$2.L$0 = routeSharedSelectedState;
        departuresViewModel$switchToStartFromNearestHarbor$2.L$1 = routeSelectedState;
        return departuresViewModel$switchToStartFromNearestHarbor$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        RouteSharedSelectedState routeSharedSelectedState = (RouteSharedSelectedState) this.L$0;
        RouteSelectedState routeSelectedState = (RouteSelectedState) this.L$1;
        if (routeSharedSelectedState == null || routeSelectedState == null) {
            return null;
        }
        return TuplesKt.to(routeSharedSelectedState, routeSelectedState);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(RouteSharedSelectedState routeSharedSelectedState, RouteSelectedState routeSelectedState, Continuation<? super Pair<? extends RouteSharedSelectedState, ? extends RouteSelectedState>> continuation) {
        return invoke2(routeSharedSelectedState, routeSelectedState, (Continuation<? super Pair<RouteSharedSelectedState, RouteSelectedState>>) continuation);
    }
}
