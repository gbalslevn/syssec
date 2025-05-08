package dk.molslinjen.ui.views.shared.routeSelector.helpers;

import android.location.Location;
import dk.molslinjen.core.location.ILocationManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/location/Location;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.shared.routeSelector.helpers.RouteLocationHelper$getNearestRouteDirection$currentLocation$1", f = "RouteLocationHelper.kt", l = {27}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class RouteLocationHelper$getNearestRouteDirection$currentLocation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Location>, Object> {
    int label;
    final /* synthetic */ RouteLocationHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteLocationHelper$getNearestRouteDirection$currentLocation$1(RouteLocationHelper routeLocationHelper, Continuation<? super RouteLocationHelper$getNearestRouteDirection$currentLocation$1> continuation) {
        super(2, continuation);
        this.this$0 = routeLocationHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RouteLocationHelper$getNearestRouteDirection$currentLocation$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ILocationManager iLocationManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iLocationManager = this.this$0.locationManager;
            this.label = 1;
            obj = iLocationManager.getLocation(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Location> continuation) {
        return ((RouteLocationHelper$getNearestRouteDirection$currentLocation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
