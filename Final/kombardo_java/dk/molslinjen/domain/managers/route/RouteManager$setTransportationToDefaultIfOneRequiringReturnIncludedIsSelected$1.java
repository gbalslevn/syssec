package dk.molslinjen.domain.managers.route;

import androidx.appcompat.R$styleable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.route.RouteManager", f = "RouteManager.kt", l = {115, R$styleable.AppCompatTheme_windowActionBar}, m = "setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected")
/* loaded from: classes2.dex */
public final class RouteManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RouteManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1(RouteManager routeManager, Continuation<? super RouteManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1> continuation) {
        super(continuation);
        this.this$0 = routeManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object transportationToDefaultIfOneRequiringReturnIncludedIsSelected;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        transportationToDefaultIfOneRequiringReturnIncludedIsSelected = this.this$0.setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected(this);
        return transportationToDefaultIfOneRequiringReturnIncludedIsSelected;
    }
}
