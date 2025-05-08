package dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.domain.managers.departure.DepartureState;
import dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardCheckoutManager;
import dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardDepartureManager;
import dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardRouteManager;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardRouteState;
import dk.molslinjen.domain.managers.splitTest.ISplitTestManager;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.ui.views.screens.booking.departures.DepartureTabState;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u001f\u001a\u00020 H\u0082@¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020 H\u0002J\u0006\u0010#\u001a\u00020 J\u000e\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020&J\u001c\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020 0+J\u000e\u0010,\u001a\u00020 2\u0006\u0010%\u001a\u00020&J\u000e\u0010-\u001a\u00020 2\u0006\u0010%\u001a\u00020&J\u0006\u0010.\u001a\u00020 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006/"}, d2 = {"Ldk/molslinjen/ui/views/screens/saleOnBoard/selectDeparture/SaleOnBoardDepartureSelectorViewModel;", "Landroidx/lifecycle/ViewModel;", "saleOnBoardCheckoutManager", "Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardCheckoutManager;", "saleOnBoardRouteManager", "Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardRouteManager;", "saleOnBoardDepartureManager", "Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardDepartureManager;", "routeLocationHelper", "Ldk/molslinjen/ui/views/shared/routeSelector/helpers/IRouteLocationHelper;", "splitTestManager", "Ldk/molslinjen/domain/managers/splitTest/ISplitTestManager;", "<init>", "(Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardCheckoutManager;Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardRouteManager;Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardDepartureManager;Ldk/molslinjen/ui/views/shared/routeSelector/helpers/IRouteLocationHelper;Ldk/molslinjen/domain/managers/splitTest/ISplitTestManager;)V", "routeState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardRouteState;", "getRouteState", "()Lkotlinx/coroutines/flow/StateFlow;", "departureState", "Ldk/molslinjen/domain/managers/departure/DepartureState;", "getDepartureState", "_departureTabState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/booking/departures/DepartureTabState;", "departureTabState", "getDepartureTabState", "splitTestShowRouteSwitchWithText", BuildConfig.FLAVOR, "getSplitTestShowRouteSwitchWithText", "()Z", "switchToStartFromNearestHarbor", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleDepartureErrors", "reloadDeparturesAfterError", "dateSelected", "date", "Lorg/threeten/bp/LocalDate;", "departureSelected", "departure", "Ldk/molslinjen/domain/model/booking/Departure;", "proceed", "Lkotlin/Function0;", "updateShownHeaderDate", "departureDayHeaderShown", "flipDirection", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaleOnBoardDepartureSelectorViewModel extends ViewModel {
    private final MutableStateFlow<DepartureTabState> _departureTabState;
    private final StateFlow<DepartureState> departureState;
    private final StateFlow<DepartureTabState> departureTabState;
    private final IRouteLocationHelper routeLocationHelper;
    private final StateFlow<SaleOnBoardRouteState> routeState;
    private final ISaleOnBoardCheckoutManager saleOnBoardCheckoutManager;
    private final ISaleOnBoardDepartureManager saleOnBoardDepartureManager;
    private final ISaleOnBoardRouteManager saleOnBoardRouteManager;
    private final boolean splitTestShowRouteSwitchWithText;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.SaleOnBoardDepartureSelectorViewModel$1", f = "SaleOnBoardDepartureSelectorViewModel.kt", l = {39}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.SaleOnBoardDepartureSelectorViewModel$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                ISaleOnBoardRouteManager iSaleOnBoardRouteManager = SaleOnBoardDepartureSelectorViewModel.this.saleOnBoardRouteManager;
                this.label = 1;
                if (iSaleOnBoardRouteManager.setup(this) == coroutine_suspended) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.SaleOnBoardDepartureSelectorViewModel$2", f = "SaleOnBoardDepartureSelectorViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.SaleOnBoardDepartureSelectorViewModel$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            SaleOnBoardDepartureSelectorViewModel.this.handleDepartureErrors();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.SaleOnBoardDepartureSelectorViewModel$3", f = "SaleOnBoardDepartureSelectorViewModel.kt", l = {47}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.SaleOnBoardDepartureSelectorViewModel$3, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                SaleOnBoardDepartureSelectorViewModel saleOnBoardDepartureSelectorViewModel = SaleOnBoardDepartureSelectorViewModel.this;
                this.label = 1;
                if (saleOnBoardDepartureSelectorViewModel.switchToStartFromNearestHarbor(this) == coroutine_suspended) {
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
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public SaleOnBoardDepartureSelectorViewModel(ISaleOnBoardCheckoutManager saleOnBoardCheckoutManager, ISaleOnBoardRouteManager saleOnBoardRouteManager, ISaleOnBoardDepartureManager saleOnBoardDepartureManager, IRouteLocationHelper routeLocationHelper, ISplitTestManager splitTestManager) {
        Intrinsics.checkNotNullParameter(saleOnBoardCheckoutManager, "saleOnBoardCheckoutManager");
        Intrinsics.checkNotNullParameter(saleOnBoardRouteManager, "saleOnBoardRouteManager");
        Intrinsics.checkNotNullParameter(saleOnBoardDepartureManager, "saleOnBoardDepartureManager");
        Intrinsics.checkNotNullParameter(routeLocationHelper, "routeLocationHelper");
        Intrinsics.checkNotNullParameter(splitTestManager, "splitTestManager");
        this.saleOnBoardCheckoutManager = saleOnBoardCheckoutManager;
        this.saleOnBoardRouteManager = saleOnBoardRouteManager;
        this.saleOnBoardDepartureManager = saleOnBoardDepartureManager;
        this.routeLocationHelper = routeLocationHelper;
        this.routeState = saleOnBoardRouteManager.getRouteState();
        this.departureState = saleOnBoardDepartureManager.getDepartureState();
        MutableStateFlow<DepartureTabState> MutableStateFlow = StateFlowKt.MutableStateFlow(new DepartureTabState(false, null, false, 7, null));
        this._departureTabState = MutableStateFlow;
        this.departureTabState = MutableStateFlow;
        this.splitTestShowRouteSwitchWithText = splitTestManager.getShowRouteSwitchWithText();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass3(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleDepartureErrors() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SaleOnBoardDepartureSelectorViewModel$handleDepartureErrors$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object switchToStartFromNearestHarbor(Continuation<? super Unit> continuation) {
        Object collect = FlowKt.filterNotNull(this.routeState).collect(new SaleOnBoardDepartureSelectorViewModel$switchToStartFromNearestHarbor$2(this), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public final void dateSelected(LocalDate date) {
        Intrinsics.checkNotNullParameter(date, "date");
        this.saleOnBoardRouteManager.dateSelected(date);
    }

    public final void departureDayHeaderShown(LocalDate date) {
        Intrinsics.checkNotNullParameter(date, "date");
        ISaleOnBoardDepartureManager iSaleOnBoardDepartureManager = this.saleOnBoardDepartureManager;
        LocalDate plusDays = date.plusDays(2L);
        Intrinsics.checkNotNullExpressionValue(plusDays, "plusDays(...)");
        iSaleOnBoardDepartureManager.ensureLoadingDeparturesUntil(plusDays);
    }

    public final void departureSelected(Departure departure, Function0<Unit> proceed) {
        Intrinsics.checkNotNullParameter(departure, "departure");
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        this.saleOnBoardCheckoutManager.setupWithDeparture(departure);
        proceed.invoke();
    }

    public final void flipDirection() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SaleOnBoardDepartureSelectorViewModel$flipDirection$1(this, null), 3, null);
    }

    public final StateFlow<DepartureState> getDepartureState() {
        return this.departureState;
    }

    public final StateFlow<DepartureTabState> getDepartureTabState() {
        return this.departureTabState;
    }

    public final StateFlow<SaleOnBoardRouteState> getRouteState() {
        return this.routeState;
    }

    public final boolean getSplitTestShowRouteSwitchWithText() {
        return this.splitTestShowRouteSwitchWithText;
    }

    public final void reloadDeparturesAfterError() {
        DepartureTabState value;
        MutableStateFlow<DepartureTabState> mutableStateFlow = this._departureTabState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, DepartureTabState.copy$default(value, true, null, false, 2, null)));
        this.saleOnBoardDepartureManager.reloadDepartures();
    }

    public final void updateShownHeaderDate(LocalDate date) {
        Intrinsics.checkNotNullParameter(date, "date");
        this.saleOnBoardDepartureManager.updateShownHeaderDate(date);
    }
}
