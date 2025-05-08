package dk.molslinjen.ui.views.screens.booking.departures.selectTransportation;

import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.managers.route.RouteSelectedState;
import dk.molslinjen.domain.managers.route.RouteState;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.TransportProducts;
import dk.molslinjen.domain.model.booking.TransportationCargoInfo;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.CargoDetailsViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.CargoDetailsViewModel$load$1", f = "CargoDetailsViewModel.kt", l = {35, 39}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class CargoDetailsViewModel$load$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $proceed;
    int label;
    final /* synthetic */ CargoDetailsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "routeState", "Ldk/molslinjen/domain/managers/route/RouteState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.CargoDetailsViewModel$load$1$1", f = "CargoDetailsViewModel.kt", l = {51}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.CargoDetailsViewModel$load$1$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<RouteState, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Boolean, Unit> $proceed;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CargoDetailsViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(CargoDetailsViewModel cargoDetailsViewModel, Function1<? super Boolean, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = cargoDetailsViewModel;
            this.$proceed = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$proceed, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(RouteState routeState, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(routeState, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ManagerResult<TransportProducts> transportProducts;
            TransportProducts transportProducts2;
            IRouteManager iRouteManager;
            IRouteManager iRouteManager2;
            IRouteManager iRouteManager3;
            MutableStateFlow mutableStateFlow;
            Object value;
            IRouteManager iRouteManager4;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                RouteState routeState = (RouteState) this.L$0;
                if (routeState == null || (transportProducts = routeState.getTransportProducts()) == null || (transportProducts2 = (TransportProducts) ManagerResultExtensionsKt.toData(transportProducts)) == null) {
                    return Unit.INSTANCE;
                }
                iRouteManager = this.this$0.routeManager;
                RouteSelectedState value2 = iRouteManager.getOutboundSelectedState().getValue();
                TransportationCargoInfo transportationCargoInfo = value2 != null ? value2.getTransportationCargoInfo() : null;
                iRouteManager2 = this.this$0.routeManager;
                RouteSelectedState value3 = iRouteManager2.getReturnSelectedState().getValue();
                TransportationCargoInfo transportationCargoInfo2 = value3 != null ? value3.getTransportationCargoInfo() : null;
                iRouteManager3 = this.this$0.routeManager;
                boolean z5 = iRouteManager3.getReturnSelectedState().getValue() != null;
                boolean isWeightRequired = transportProducts2.getGoods().isWeightRequired();
                boolean isNotesAvailable = transportProducts2.isNotesAvailable();
                if (isWeightRequired || isNotesAvailable) {
                    mutableStateFlow = this.this$0._viewState;
                    do {
                        value = mutableStateFlow.getValue();
                    } while (!mutableStateFlow.compareAndSet(value, CargoDetailsViewModel.ViewState.copy$default((CargoDetailsViewModel.ViewState) value, null, isWeightRequired, transportProducts2.getGoods().getMaxWeight(), isNotesAvailable, transportationCargoInfo == null ? new TransportationCargoInfo((Double) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null) : transportationCargoInfo, transportationCargoInfo2 == null ? new TransportationCargoInfo((Double) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null) : transportationCargoInfo2, (z5 && transportationCargoInfo != null && transportationCargoInfo2 == null) ? DepartureDirection.Return : DepartureDirection.Outbound, z5, false, 1, null)));
                    return Unit.INSTANCE;
                }
                iRouteManager4 = this.this$0.routeManager;
                String transportationId = this.this$0.getViewState().getValue().getTransportationId();
                this.label = 1;
                if (IRouteManager.DefaultImpls.setTransportation$default(iRouteManager4, transportationId, null, null, this, 6, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.$proceed.invoke(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CargoDetailsViewModel$load$1(CargoDetailsViewModel cargoDetailsViewModel, Function1<? super Boolean, Unit> function1, Continuation<? super CargoDetailsViewModel$load$1> continuation) {
        super(2, continuation);
        this.this$0 = cargoDetailsViewModel;
        this.$proceed = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CargoDetailsViewModel$load$1(this.this$0, this.$proceed, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IRouteManager iRouteManager;
        IRouteManager iRouteManager2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iRouteManager = this.this$0.routeManager;
            String transportationId = this.this$0.getViewState().getValue().getTransportationId();
            this.label = 1;
            if (iRouteManager.loadTransportProducts(transportationId, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        iRouteManager2 = this.this$0.routeManager;
        StateFlow<RouteState> routeState = iRouteManager2.getRouteState();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$proceed, null);
        this.label = 2;
        if (FlowKt.collectLatest(routeState, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CargoDetailsViewModel$load$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
