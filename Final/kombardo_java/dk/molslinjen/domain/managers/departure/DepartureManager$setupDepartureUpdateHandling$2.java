package dk.molslinjen.domain.managers.departure;

import dk.molslinjen.core.log.Logger;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.managers.route.RouteSelectedState;
import dk.molslinjen.domain.managers.route.RouteSharedSelectedState;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.departure.DepartureManager$setupDepartureUpdateHandling$2", f = "DepartureManager.kt", l = {98}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class DepartureManager$setupDepartureUpdateHandling$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DepartureManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Triple;", "Ldk/molslinjen/domain/managers/route/RouteSelectedState;", "Ldk/molslinjen/domain/managers/route/RouteSharedSelectedState;", "Ldk/molslinjen/domain/model/booking/Departure;", "state", "sharedState", "outboundState"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.departure.DepartureManager$setupDepartureUpdateHandling$2$1", f = "DepartureManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.departure.DepartureManager$setupDepartureUpdateHandling$2$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function4<RouteSelectedState, RouteSharedSelectedState, Departure, Continuation<? super Triple<? extends RouteSelectedState, ? extends RouteSharedSelectedState, ? extends Departure>>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(4, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(RouteSelectedState routeSelectedState, RouteSharedSelectedState routeSharedSelectedState, Departure departure, Continuation<? super Triple<RouteSelectedState, RouteSharedSelectedState, Departure>> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = routeSelectedState;
            anonymousClass1.L$1 = routeSharedSelectedState;
            anonymousClass1.L$2 = departure;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return new Triple((RouteSelectedState) this.L$0, (RouteSharedSelectedState) this.L$1, (Departure) this.L$2);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(RouteSelectedState routeSelectedState, RouteSharedSelectedState routeSharedSelectedState, Departure departure, Continuation<? super Triple<? extends RouteSelectedState, ? extends RouteSharedSelectedState, ? extends Departure>> continuation) {
            return invoke2(routeSelectedState, routeSharedSelectedState, departure, (Continuation<? super Triple<RouteSelectedState, RouteSharedSelectedState, Departure>>) continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u001e\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Lkotlin/Triple;", "Ldk/molslinjen/domain/managers/route/RouteSelectedState;", "Ldk/molslinjen/domain/managers/route/RouteSharedSelectedState;", "Ldk/molslinjen/domain/model/booking/Departure;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.departure.DepartureManager$setupDepartureUpdateHandling$2$2", f = "DepartureManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.departure.DepartureManager$setupDepartureUpdateHandling$2$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Triple<? extends RouteSelectedState, ? extends RouteSharedSelectedState, ? extends Departure>, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineScope $$this$launch;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DepartureManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DepartureManager departureManager, CoroutineScope coroutineScope, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = departureManager;
            this.$$this$launch = coroutineScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, this.$$this$launch, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Triple<? extends RouteSelectedState, ? extends RouteSharedSelectedState, ? extends Departure> triple, Continuation<? super Unit> continuation) {
            return invoke2((Triple<RouteSelectedState, RouteSharedSelectedState, Departure>) triple, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            RouteSharedSelectedState routeSharedSelectedState;
            Departure departure;
            IRouteManager iRouteManager;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Triple triple = (Triple) this.L$0;
            Logger.log$default(Logger.INSTANCE, "Return startLoadingDepartures: " + triple, "DepartureManager", 0, 4, null);
            RouteSelectedState routeSelectedState = (RouteSelectedState) triple.getFirst();
            if (routeSelectedState != null && (routeSharedSelectedState = (RouteSharedSelectedState) triple.getSecond()) != null && (departure = (Departure) triple.getThird()) != null) {
                DepartureManager departureManager = this.this$0;
                CoroutineScope coroutineScope = this.$$this$launch;
                MutableStateFlow<DepartureState> returnState = departureManager.getReturnState();
                iRouteManager = this.this$0.routeManager;
                departureManager.startLoadingDepartures(coroutineScope, routeSelectedState, routeSharedSelectedState, returnState, departure, iRouteManager.getOutboundSelectedState().getValue(), DepartureDirection.Return, null);
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Triple<RouteSelectedState, RouteSharedSelectedState, Departure> triple, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(triple, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DepartureManager$setupDepartureUpdateHandling$2(DepartureManager departureManager, Continuation<? super DepartureManager$setupDepartureUpdateHandling$2> continuation) {
        super(2, continuation);
        this.this$0 = departureManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DepartureManager$setupDepartureUpdateHandling$2 departureManager$setupDepartureUpdateHandling$2 = new DepartureManager$setupDepartureUpdateHandling$2(this.this$0, continuation);
        departureManager$setupDepartureUpdateHandling$2.L$0 = obj;
        return departureManager$setupDepartureUpdateHandling$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IRouteManager iRouteManager;
        IRouteManager iRouteManager2;
        Flow flow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            iRouteManager = this.this$0.routeManager;
            StateFlow<RouteSelectedState> returnSelectedState = iRouteManager.getReturnSelectedState();
            iRouteManager2 = this.this$0.routeManager;
            StateFlow<RouteSharedSelectedState> sharedSelectedState = iRouteManager2.getSharedSelectedState();
            flow = this.this$0.selectedOutboundDepartureState;
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(FlowKt.debounce(FlowKt.combine(returnSelectedState, sharedSelectedState, flow, new AnonymousClass1(null)), 500L));
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, coroutineScope, null);
            this.label = 1;
            if (FlowKt.collectLatest(distinctUntilChanged, anonymousClass2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DepartureManager$setupDepartureUpdateHandling$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
