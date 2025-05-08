package dk.molslinjen.ui.views.screens.booking.departures;

import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.checkout.IEditManager;
import dk.molslinjen.domain.managers.route.RouteSelectedState;
import dk.molslinjen.domain.managers.route.RouteSharedSelectedState;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.booking.product.TrailerProduct;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
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
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel$departureSelected$1", f = "DeparturesViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class DeparturesViewModel$departureSelected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Departure $departure;
    final /* synthetic */ DepartureDirection $departureDirection;
    int label;
    final /* synthetic */ DeparturesViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeparturesViewModel$departureSelected$1(DeparturesViewModel departuresViewModel, Departure departure, DepartureDirection departureDirection, Continuation<? super DeparturesViewModel$departureSelected$1> continuation) {
        super(2, continuation);
        this.this$0 = departuresViewModel;
        this.$departure = departure;
        this.$departureDirection = departureDirection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeparturesViewModel$departureSelected$1(this.this$0, this.$departure, this.$departureDirection, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Transportation selectedTransportation;
        IAnalyticsTracker iAnalyticsTracker;
        PassengerInfo passengerInfo;
        IEditManager iEditManager;
        Site site;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        RouteSharedSelectedState value = this.this$0.routeManager.getSharedSelectedState().getValue();
        if (value == null || (selectedTransportation = value.getSelectedTransportation()) == null) {
            return Unit.INSTANCE;
        }
        iAnalyticsTracker = this.this$0.analyticsTracker;
        Departure departure = this.$departure;
        RouteSelectedState value2 = this.this$0.routeManager.getActiveSelectedState().getValue();
        if (value2 == null || (passengerInfo = value2.getPassengerInfo()) == null) {
            return Unit.INSTANCE;
        }
        RouteSelectedState value3 = this.this$0.routeManager.getActiveSelectedState().getValue();
        TrailerProduct selectedTrailer = value3 != null ? value3.getSelectedTrailer() : null;
        iEditManager = this.this$0.editManager;
        boolean isEditing = iEditManager.getEditState().getValue().getIsEditing();
        DepartureDirection departureDirection = this.$departureDirection;
        RouteSharedSelectedState value4 = this.this$0.routeManager.getSharedSelectedState().getValue();
        if (value4 == null || (site = value4.getSite()) == null) {
            return Unit.INSTANCE;
        }
        iAnalyticsTracker.trackViewedDeparture(departure, selectedTransportation, passengerInfo, selectedTrailer, isEditing, departureDirection, site);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeparturesViewModel$departureSelected$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
