package dk.molslinjen.ui.views.screens.booking.departures;

import dk.molslinjen.domain.managers.route.RouteSelectedState;
import dk.molslinjen.domain.model.config.RouteDirectionGroup;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Ldk/molslinjen/domain/managers/route/RouteSelectedState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel$outboundRouteId$1", f = "DeparturesViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class DeparturesViewModel$outboundRouteId$1 extends SuspendLambda implements Function2<RouteSelectedState, Continuation<? super String>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeparturesViewModel$outboundRouteId$1(Continuation<? super DeparturesViewModel$outboundRouteId$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DeparturesViewModel$outboundRouteId$1 departuresViewModel$outboundRouteId$1 = new DeparturesViewModel$outboundRouteId$1(continuation);
        departuresViewModel$outboundRouteId$1.L$0 = obj;
        return departuresViewModel$outboundRouteId$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(RouteSelectedState routeSelectedState, Continuation<? super String> continuation) {
        return ((DeparturesViewModel$outboundRouteId$1) create(routeSelectedState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        RouteDirectionGroup selectedRouteDirectionGroup;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        RouteSelectedState routeSelectedState = (RouteSelectedState) this.L$0;
        if (routeSelectedState == null || (selectedRouteDirectionGroup = routeSelectedState.getSelectedRouteDirectionGroup()) == null) {
            return null;
        }
        return selectedRouteDirectionGroup.getMainRouteId();
    }
}
