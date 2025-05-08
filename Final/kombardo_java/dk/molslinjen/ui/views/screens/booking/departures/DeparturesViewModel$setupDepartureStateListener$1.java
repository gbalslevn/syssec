package dk.molslinjen.ui.views.screens.booking.departures;

import dk.molslinjen.domain.managers.departure.DepartureState;
import dk.molslinjen.domain.managers.departure.IDepartureManager;
import dk.molslinjen.domain.managers.route.RouteSelectedState;
import dk.molslinjen.domain.model.booking.DayDepartures;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.TimeTableStatus;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel$setupDepartureStateListener$1", f = "DeparturesViewModel.kt", l = {211}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class DeparturesViewModel$setupDepartureStateListener$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DepartureDirection $departureDirection;
    int label;
    final /* synthetic */ DeparturesViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "departureState", "Ldk/molslinjen/domain/managers/departure/DepartureState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel$setupDepartureStateListener$1$1", f = "DeparturesViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel$setupDepartureStateListener$1$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<DepartureState, Continuation<? super Unit>, Object> {
        final /* synthetic */ DepartureDirection $departureDirection;
        final /* synthetic */ MutableStateFlow<DepartureTabState> $departureTabState;
        final /* synthetic */ StateFlow<RouteSelectedState> $routeSelectedState;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DeparturesViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(StateFlow<RouteSelectedState> stateFlow, MutableStateFlow<DepartureTabState> mutableStateFlow, DepartureDirection departureDirection, DeparturesViewModel departuresViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$routeSelectedState = stateFlow;
            this.$departureTabState = mutableStateFlow;
            this.$departureDirection = departureDirection;
            this.this$0 = departuresViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$routeSelectedState, this.$departureTabState, this.$departureDirection, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(DepartureState departureState, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(departureState, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [dk.molslinjen.domain.model.booking.TimeTableStatus, T] */
        /* JADX WARN: Type inference failed for: r6v5, types: [dk.molslinjen.domain.model.booking.TimeTableStatus, T] */
        /* JADX WARN: Type inference failed for: r8v2, types: [T, org.threeten.bp.LocalDate] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            DepartureTabState value;
            Object value2;
            DepartureState copy;
            DepartureTabState value3;
            LocalDate selectedStartDate;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            DepartureState departureState = (DepartureState) this.L$0;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            RouteSelectedState value4 = this.$routeSelectedState.getValue();
            ref$ObjectRef.element = (value4 == null || (selectedStartDate = value4.getSelectedStartDate()) == null) ? 0 : selectedStartDate.minusDays(1L);
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = TimeTableStatus.Available;
            List<DayDepartures> departures = departureState.getDepartures();
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : departures) {
                DayDepartures dayDepartures = (DayDepartures) obj2;
                boolean z5 = Intrinsics.areEqual(dayDepartures.getDate().minusDays(1L), ref$ObjectRef.element) && ((TimeTableStatus) ref$ObjectRef2.element).isAvailable();
                ref$ObjectRef.element = dayDepartures.getDate();
                ref$ObjectRef2.element = dayDepartures.getTimeTableStatus();
                if (!z5) {
                    break;
                }
                arrayList.add(obj2);
            }
            if (!((TimeTableStatus) ref$ObjectRef2.element).isAvailable()) {
                MutableStateFlow<DepartureTabState> mutableStateFlow = this.$departureTabState;
                do {
                    value3 = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value3, DepartureTabState.copy$default(value3, false, null, false, 6, null)));
            } else if (departureState.getDepartures().isEmpty()) {
                MutableStateFlow<DepartureTabState> mutableStateFlow2 = this.$departureTabState;
                do {
                    value = mutableStateFlow2.getValue();
                } while (!mutableStateFlow2.compareAndSet(value, DepartureTabState.copy$default(value, true, null, false, 6, null)));
            }
            MutableStateFlow mutableStateFlow3 = this.$departureDirection == DepartureDirection.Outbound ? this.this$0._outboundDepartureState : this.this$0._returnDepartureState;
            do {
                value2 = mutableStateFlow3.getValue();
                copy = departureState.copy((r18 & 1) != 0 ? departureState.loadingDeparturesError : false, (r18 & 2) != 0 ? departureState.departures : arrayList, (r18 & 4) != 0 ? departureState.siteDepartureNotice : null, (r18 & 8) != 0 ? departureState.shownHeaderDate : null, (r18 & 16) != 0 ? departureState.selectionInProgressDeparture : null, (r18 & 32) != 0 ? departureState.selectedDeparture : null, (r18 & 64) != 0 ? departureState.selectedDepartureTicket : null, (r18 & 128) != 0 ? departureState.startedLoadingTime : null);
            } while (!mutableStateFlow3.compareAndSet(value2, copy));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeparturesViewModel$setupDepartureStateListener$1(DepartureDirection departureDirection, DeparturesViewModel departuresViewModel, Continuation<? super DeparturesViewModel$setupDepartureStateListener$1> continuation) {
        super(2, continuation);
        this.$departureDirection = departureDirection;
        this.this$0 = departuresViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeparturesViewModel$setupDepartureStateListener$1(this.$departureDirection, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IDepartureManager iDepartureManager;
        StateFlow<DepartureState> returnState;
        IDepartureManager iDepartureManager2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            DepartureDirection departureDirection = this.$departureDirection;
            DepartureDirection departureDirection2 = DepartureDirection.Outbound;
            if (departureDirection == departureDirection2) {
                iDepartureManager2 = this.this$0.departureManager;
                returnState = iDepartureManager2.getOutboundState();
            } else {
                iDepartureManager = this.this$0.departureManager;
                returnState = iDepartureManager.getReturnState();
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$departureDirection == departureDirection2 ? this.this$0.getOutboundSelectedState() : this.this$0.getReturnSelectedState(), this.$departureDirection == departureDirection2 ? this.this$0._outboundDepartureTabState : this.this$0._returnDepartureTabState, this.$departureDirection, this.this$0, null);
            this.label = 1;
            if (FlowKt.collectLatest(returnState, anonymousClass1, this) == coroutine_suspended) {
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
        return ((DeparturesViewModel$setupDepartureStateListener$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
