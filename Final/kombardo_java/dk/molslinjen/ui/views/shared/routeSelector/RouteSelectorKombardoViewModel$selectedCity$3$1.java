package dk.molslinjen.ui.views.shared.routeSelector;

import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.model.booking.RouteDirection;
import dk.molslinjen.domain.model.config.Route;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorKombardoViewModel$selectedCity$3$1", f = "RouteSelectorKombardoViewModel.kt", l = {212, 218}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class RouteSelectorKombardoViewModel$selectedCity$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onRouteSelected;
    final /* synthetic */ Route $route;
    final /* synthetic */ RouteDirection $routeDirection;
    final /* synthetic */ Transportation $transportation;
    int label;
    final /* synthetic */ RouteSelectorKombardoViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteSelectorKombardoViewModel$selectedCity$3$1(RouteSelectorKombardoViewModel routeSelectorKombardoViewModel, Route route, RouteDirection routeDirection, Transportation transportation, Function0<Unit> function0, Continuation<? super RouteSelectorKombardoViewModel$selectedCity$3$1> continuation) {
        super(2, continuation);
        this.this$0 = routeSelectorKombardoViewModel;
        this.$route = route;
        this.$routeDirection = routeDirection;
        this.$transportation = transportation;
        this.$onRouteSelected = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RouteSelectorKombardoViewModel$selectedCity$3$1(this.this$0, this.$route, this.$routeDirection, this.$transportation, this.$onRouteSelected, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IRouteManager iRouteManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iRouteManager = this.this$0.routeManager;
            Site site = Site.Kombardo;
            Route route = this.$route;
            RouteDirection routeDirection = this.$routeDirection;
            String id = this.$transportation.getId();
            this.label = 1;
            if (iRouteManager.selectRoute(site, route, routeDirection, id, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$onRouteSelected.invoke();
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        this.label = 2;
        if (DelayKt.delay(500L, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.$onRouteSelected.invoke();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RouteSelectorKombardoViewModel$selectedCity$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
