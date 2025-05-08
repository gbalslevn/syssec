package dk.molslinjen.ui.views.shared.routeSelector;

import androidx.appcompat.R$styleable;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.model.booking.RouteDirection;
import dk.molslinjen.domain.model.config.Route;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.ui.views.shared.routeSelector.helpers.IRouteLocationHelper;
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
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorMolslinjenViewModel$routeSelected$2", f = "RouteSelectorMolslinjenViewModel.kt", l = {R$styleable.AppCompatTheme_windowActionBar, 118}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class RouteSelectorMolslinjenViewModel$routeSelected$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $defaultTransportationId;
    final /* synthetic */ Function0<Unit> $proceed;
    final /* synthetic */ Route $route;
    final /* synthetic */ Site $site;
    int label;
    final /* synthetic */ RouteSelectorMolslinjenViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteSelectorMolslinjenViewModel$routeSelected$2(RouteSelectorMolslinjenViewModel routeSelectorMolslinjenViewModel, Route route, Site site, String str, Function0<Unit> function0, Continuation<? super RouteSelectorMolslinjenViewModel$routeSelected$2> continuation) {
        super(2, continuation);
        this.this$0 = routeSelectorMolslinjenViewModel;
        this.$route = route;
        this.$site = site;
        this.$defaultTransportationId = str;
        this.$proceed = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RouteSelectorMolslinjenViewModel$routeSelected$2(this.this$0, this.$route, this.$site, this.$defaultTransportationId, this.$proceed, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IRouteLocationHelper iRouteLocationHelper;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iRouteLocationHelper = this.this$0.routeLocationHelper;
            Route route = this.$route;
            Site site = this.$site;
            this.label = 1;
            obj = iRouteLocationHelper.getNearestRouteDirection(route, site, 1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$proceed.invoke();
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        RouteDirection routeDirection = (RouteDirection) obj;
        if (routeDirection == null) {
            routeDirection = RouteDirection.Outbound;
        }
        RouteDirection routeDirection2 = routeDirection;
        IRouteManager iRouteManager = this.this$0.routeManager;
        Site site2 = this.$site;
        Route route2 = this.$route;
        String str = this.$defaultTransportationId;
        this.label = 2;
        if (iRouteManager.selectRoute(site2, route2, routeDirection2, str, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.$proceed.invoke();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RouteSelectorMolslinjenViewModel$routeSelected$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
