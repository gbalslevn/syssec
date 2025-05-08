package dk.molslinjen.ui.views.screens.booking.departures;

import dk.molslinjen.domain.analytics.AnalyticsEvent;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.route.RouteSelectedState;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.config.RouteDirectionGroup;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel$locationPermissionGranted$1", f = "DeparturesViewModel.kt", l = {363}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class DeparturesViewModel$locationPermissionGranted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DeparturesViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeparturesViewModel$locationPermissionGranted$1(DeparturesViewModel departuresViewModel, Continuation<? super DeparturesViewModel$locationPermissionGranted$1> continuation) {
        super(2, continuation);
        this.this$0 = departuresViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeparturesViewModel$locationPermissionGranted$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        RouteDirectionGroup selectedRouteDirectionGroup;
        String mainRouteId;
        IAnalyticsTracker iAnalyticsTracker;
        IUserManager iUserManager;
        IAnalyticsTracker iAnalyticsTracker2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            RouteSelectedState value = this.this$0.getOutboundSelectedState().getValue();
            if (value != null && (selectedRouteDirectionGroup = value.getSelectedRouteDirectionGroup()) != null && (mainRouteId = selectedRouteDirectionGroup.getMainRouteId()) != null) {
                DeparturesViewModel departuresViewModel = this.this$0;
                this.label = 1;
                if (departuresViewModel.loadTravelTime(mainRouteId, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        iAnalyticsTracker = this.this$0.analyticsTracker;
        iUserManager = this.this$0.userManager;
        iAnalyticsTracker.updateStateTracking(iUserManager, null);
        iAnalyticsTracker2 = this.this$0.analyticsTracker;
        iAnalyticsTracker2.trackEvent(new AnalyticsEvent.ChangeLocationPermissionEvent(true, false, false, true, 6, null));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeparturesViewModel$locationPermissionGranted$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
