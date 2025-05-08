package dk.molslinjen.ui.views.screens.booking.departures.calendar;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.CalendarScreenDestination;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarViewModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;
import org.threeten.bp.YearMonth;
import uniffi.molslinjen_shared.DepartureCalendarPrices;
import uniffi.molslinjen_shared.DepartureLowPriceHandlerInterface;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001!B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J\u001e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001a2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u000e\u0010 \u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00140\u00108F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0012R \u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarViewModel;", "Landroidx/lifecycle/ViewModel;", "priceHandler", "Luniffi/molslinjen_shared/DepartureLowPriceHandlerInterface;", "routeManager", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Luniffi/molslinjen_shared/DepartureLowPriceHandlerInterface;Ldk/molslinjen/domain/managers/route/IRouteManager;Landroidx/lifecycle/SavedStateHandle;)V", "navArgs", "Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarScreenNavArgs;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "_pricesData", "Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarViewModel$ViewState$PricesState;", "Luniffi/molslinjen_shared/DepartureCalendarPrices;", "pricesData", "getPricesData", "pricesMap", BuildConfig.FLAVOR, "Lorg/threeten/bp/YearMonth;", "fetchPrices", BuildConfig.FLAVOR, "month", "updateLocalState", "pricesState", "onMonthChange", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CalendarViewModel extends ViewModel {
    private final MutableStateFlow<ViewState.PricesState<DepartureCalendarPrices>> _pricesData;
    private final MutableStateFlow<ViewState> _viewState;
    private final CalendarScreenNavArgs navArgs;
    private final DepartureLowPriceHandlerInterface priceHandler;
    private final Map<YearMonth, ViewState.PricesState<DepartureCalendarPrices>> pricesMap;
    private final IRouteManager routeManager;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarViewModel$1", f = "CalendarViewModel.kt", l = {60}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarViewModel$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "monthToShow", "Lorg/threeten/bp/YearMonth;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarViewModel$1$2", f = "CalendarViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarViewModel$1$2, reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<YearMonth, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ CalendarViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(CalendarViewModel calendarViewModel, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = calendarViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.fetchPrices((YearMonth) this.L$0);
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(YearMonth yearMonth, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(yearMonth, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

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
                if (CalendarViewModel.this.getViewState().getValue().getCalendarType() == CalendarSheetType.LowPrice) {
                    final StateFlow<ViewState> viewState = CalendarViewModel.this.getViewState();
                    Flow debounce = FlowKt.debounce(new Flow<YearMonth>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarViewModel$1$invokeSuspend$$inlined$map$1

                        @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "value", BuildConfig.FLAVOR, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
                        /* renamed from: dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarViewModel$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                        /* loaded from: classes2.dex */
                        public static final class AnonymousClass2<T> implements FlowCollector {
                            final /* synthetic */ FlowCollector $this_unsafeFlow;

                            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                            @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarViewModel$1$invokeSuspend$$inlined$map$1$2", f = "CalendarViewModel.kt", l = {223}, m = "emit")
                            /* renamed from: dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarViewModel$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                            /* loaded from: classes2.dex */
                            public static final class AnonymousClass1 extends ContinuationImpl {
                                int label;
                                /* synthetic */ Object result;

                                public AnonymousClass1(Continuation continuation) {
                                    super(continuation);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    this.result = obj;
                                    this.label |= Integer.MIN_VALUE;
                                    return AnonymousClass2.this.emit(null, this);
                                }
                            }

                            public AnonymousClass2(FlowCollector flowCollector) {
                                this.$this_unsafeFlow = flowCollector;
                            }

                            /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                            /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                            @Override // kotlinx.coroutines.flow.FlowCollector
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Object emit(Object obj, Continuation continuation) {
                                AnonymousClass1 anonymousClass1;
                                int i5;
                                if (continuation instanceof AnonymousClass1) {
                                    anonymousClass1 = (AnonymousClass1) continuation;
                                    int i6 = anonymousClass1.label;
                                    if ((i6 & Integer.MIN_VALUE) != 0) {
                                        anonymousClass1.label = i6 - Integer.MIN_VALUE;
                                        Object obj2 = anonymousClass1.result;
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        i5 = anonymousClass1.label;
                                        if (i5 != 0) {
                                            ResultKt.throwOnFailure(obj2);
                                            FlowCollector flowCollector = this.$this_unsafeFlow;
                                            YearMonth monthToShow = ((CalendarViewModel.ViewState) obj).getMonthToShow();
                                            anonymousClass1.label = 1;
                                            if (flowCollector.emit(monthToShow, anonymousClass1) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        } else {
                                            if (i5 != 1) {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            ResultKt.throwOnFailure(obj2);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }
                                anonymousClass1 = new AnonymousClass1(continuation);
                                Object obj22 = anonymousClass1.result;
                                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                i5 = anonymousClass1.label;
                                if (i5 != 0) {
                                }
                                return Unit.INSTANCE;
                            }
                        }

                        @Override // kotlinx.coroutines.flow.Flow
                        public Object collect(FlowCollector<? super YearMonth> flowCollector, Continuation continuation) {
                            Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                            return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                        }
                    }, 300L);
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(CalendarViewModel.this, null);
                    this.label = 1;
                    if (FlowKt.collectLatest(debounce, anonymousClass2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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

    public CalendarViewModel(DepartureLowPriceHandlerInterface priceHandler, IRouteManager routeManager, SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(priceHandler, "priceHandler");
        Intrinsics.checkNotNullParameter(routeManager, "routeManager");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.priceHandler = priceHandler;
        this.routeManager = routeManager;
        CalendarScreenNavArgs argsFrom = CalendarScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        this.navArgs = argsFrom;
        this._viewState = StateFlowKt.MutableStateFlow(new ViewState(argsFrom.getSelectedDate(), argsFrom.getMinDate(), argsFrom.getMaxDate(), argsFrom.getCalendarType(), null, null, 48, null));
        this._pricesData = StateFlowKt.MutableStateFlow(ViewState.PricesState.Loading.INSTANCE);
        this.pricesMap = SnapshotStateKt.mutableStateMapOf();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getDefault(), null, new AnonymousClass1(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchPrices(YearMonth month) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getDefault(), null, new CalendarViewModel$fetchPrices$1(this, month, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLocalState(YearMonth month, ViewState.PricesState<DepartureCalendarPrices> pricesState) {
        this.pricesMap.put(month, pricesState);
        if (Intrinsics.areEqual(getViewState().getValue().getMonthToShow(), month)) {
            MutableStateFlow<ViewState.PricesState<DepartureCalendarPrices>> mutableStateFlow = this._pricesData;
            do {
            } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), pricesState));
        }
    }

    public final StateFlow<ViewState.PricesState<DepartureCalendarPrices>> getPricesData() {
        return this._pricesData;
    }

    public final StateFlow<ViewState> getViewState() {
        return this._viewState;
    }

    public final void onMonthChange(YearMonth month) {
        ViewState value;
        Intrinsics.checkNotNullParameter(month, "month");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, null, null, month, null, 47, null)));
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001:\u0001)BE\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJV\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001e\u0010\u001dR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010#\u001a\u0004\b$\u0010%R\u001f\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\f\u0010&\u001a\u0004\b'\u0010(¨\u0006*"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarViewModel$ViewState;", BuildConfig.FLAVOR, "Lorg/threeten/bp/LocalDate;", "selectedDate", "minDate", "maxDate", "Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarSheetType;", "calendarType", "Lorg/threeten/bp/YearMonth;", "monthToShow", "Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarViewModel$ViewState$PricesState;", "Luniffi/molslinjen_shared/DepartureCalendarPrices;", "currentPrices", "<init>", "(Lorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalDate;Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarSheetType;Lorg/threeten/bp/YearMonth;Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarViewModel$ViewState$PricesState;)V", "copy", "(Lorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalDate;Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarSheetType;Lorg/threeten/bp/YearMonth;Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarViewModel$ViewState$PricesState;)Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Lorg/threeten/bp/LocalDate;", "getSelectedDate", "()Lorg/threeten/bp/LocalDate;", "getMinDate", "getMaxDate", "Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarSheetType;", "getCalendarType", "()Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarSheetType;", "Lorg/threeten/bp/YearMonth;", "getMonthToShow", "()Lorg/threeten/bp/YearMonth;", "Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarViewModel$ViewState$PricesState;", "getCurrentPrices", "()Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarViewModel$ViewState$PricesState;", "PricesState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final CalendarSheetType calendarType;
        private final PricesState<DepartureCalendarPrices> currentPrices;
        private final LocalDate maxDate;
        private final LocalDate minDate;
        private final YearMonth monthToShow;
        private final LocalDate selectedDate;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0003\b\t\n¨\u0006\u000b"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarViewModel$ViewState$PricesState;", "T", BuildConfig.FLAVOR, "<init>", "()V", "Success", "Error", "Loading", "Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarViewModel$ViewState$PricesState$Error;", "Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarViewModel$ViewState$PricesState$Loading;", "Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarViewModel$ViewState$PricesState$Success;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static abstract class PricesState<T> {

            @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\t\u001a\u00020\nHÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarViewModel$ViewState$PricesState$Error;", "Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarViewModel$ViewState$PricesState;", BuildConfig.FLAVOR, "<init>", "()V", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
            /* loaded from: classes2.dex */
            public static final /* data */ class Error extends PricesState {
                public static final Error INSTANCE = new Error();

                private Error() {
                    super(null);
                }

                public boolean equals(Object other) {
                    return this == other || (other instanceof Error);
                }

                public int hashCode() {
                    return 1834996060;
                }

                public String toString() {
                    return "Error";
                }
            }

            @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\t\u001a\u00020\nHÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarViewModel$ViewState$PricesState$Loading;", "Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarViewModel$ViewState$PricesState;", BuildConfig.FLAVOR, "<init>", "()V", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
            /* loaded from: classes2.dex */
            public static final /* data */ class Loading extends PricesState {
                public static final Loading INSTANCE = new Loading();

                private Loading() {
                    super(null);
                }

                public boolean equals(Object other) {
                    return this == other || (other instanceof Loading);
                }

                public int hashCode() {
                    return 15293328;
                }

                public String toString() {
                    return "Loading";
                }
            }

            @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00028\u00018\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarViewModel$ViewState$PricesState$Success;", "T", "Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarViewModel$ViewState$PricesState;", "value", "<init>", "(Ljava/lang/Object;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
            /* loaded from: classes2.dex */
            public static final /* data */ class Success<T> extends PricesState<T> {
                private final T value;

                public Success(T t5) {
                    super(null);
                    this.value = t5;
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    return (other instanceof Success) && Intrinsics.areEqual(this.value, ((Success) other).value);
                }

                public final T getValue() {
                    return this.value;
                }

                public int hashCode() {
                    T t5 = this.value;
                    if (t5 == null) {
                        return 0;
                    }
                    return t5.hashCode();
                }

                public String toString() {
                    return "Success(value=" + this.value + ")";
                }
            }

            public /* synthetic */ PricesState(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private PricesState() {
            }
        }

        public ViewState(LocalDate selectedDate, LocalDate minDate, LocalDate localDate, CalendarSheetType calendarType, YearMonth monthToShow, PricesState<DepartureCalendarPrices> pricesState) {
            Intrinsics.checkNotNullParameter(selectedDate, "selectedDate");
            Intrinsics.checkNotNullParameter(minDate, "minDate");
            Intrinsics.checkNotNullParameter(calendarType, "calendarType");
            Intrinsics.checkNotNullParameter(monthToShow, "monthToShow");
            this.selectedDate = selectedDate;
            this.minDate = minDate;
            this.maxDate = localDate;
            this.calendarType = calendarType;
            this.monthToShow = monthToShow;
            this.currentPrices = pricesState;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, LocalDate localDate, LocalDate localDate2, LocalDate localDate3, CalendarSheetType calendarSheetType, YearMonth yearMonth, PricesState pricesState, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                localDate = viewState.selectedDate;
            }
            if ((i5 & 2) != 0) {
                localDate2 = viewState.minDate;
            }
            LocalDate localDate4 = localDate2;
            if ((i5 & 4) != 0) {
                localDate3 = viewState.maxDate;
            }
            LocalDate localDate5 = localDate3;
            if ((i5 & 8) != 0) {
                calendarSheetType = viewState.calendarType;
            }
            CalendarSheetType calendarSheetType2 = calendarSheetType;
            if ((i5 & 16) != 0) {
                yearMonth = viewState.monthToShow;
            }
            YearMonth yearMonth2 = yearMonth;
            if ((i5 & 32) != 0) {
                pricesState = viewState.currentPrices;
            }
            return viewState.copy(localDate, localDate4, localDate5, calendarSheetType2, yearMonth2, pricesState);
        }

        public final ViewState copy(LocalDate selectedDate, LocalDate minDate, LocalDate maxDate, CalendarSheetType calendarType, YearMonth monthToShow, PricesState<DepartureCalendarPrices> currentPrices) {
            Intrinsics.checkNotNullParameter(selectedDate, "selectedDate");
            Intrinsics.checkNotNullParameter(minDate, "minDate");
            Intrinsics.checkNotNullParameter(calendarType, "calendarType");
            Intrinsics.checkNotNullParameter(monthToShow, "monthToShow");
            return new ViewState(selectedDate, minDate, maxDate, calendarType, monthToShow, currentPrices);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics.areEqual(this.selectedDate, viewState.selectedDate) && Intrinsics.areEqual(this.minDate, viewState.minDate) && Intrinsics.areEqual(this.maxDate, viewState.maxDate) && this.calendarType == viewState.calendarType && Intrinsics.areEqual(this.monthToShow, viewState.monthToShow) && Intrinsics.areEqual(this.currentPrices, viewState.currentPrices);
        }

        public final CalendarSheetType getCalendarType() {
            return this.calendarType;
        }

        public final LocalDate getMaxDate() {
            return this.maxDate;
        }

        public final LocalDate getMinDate() {
            return this.minDate;
        }

        public final YearMonth getMonthToShow() {
            return this.monthToShow;
        }

        public final LocalDate getSelectedDate() {
            return this.selectedDate;
        }

        public int hashCode() {
            int hashCode = ((this.selectedDate.hashCode() * 31) + this.minDate.hashCode()) * 31;
            LocalDate localDate = this.maxDate;
            int hashCode2 = (((((hashCode + (localDate == null ? 0 : localDate.hashCode())) * 31) + this.calendarType.hashCode()) * 31) + this.monthToShow.hashCode()) * 31;
            PricesState<DepartureCalendarPrices> pricesState = this.currentPrices;
            return hashCode2 + (pricesState != null ? pricesState.hashCode() : 0);
        }

        public String toString() {
            return "ViewState(selectedDate=" + this.selectedDate + ", minDate=" + this.minDate + ", maxDate=" + this.maxDate + ", calendarType=" + this.calendarType + ", monthToShow=" + this.monthToShow + ", currentPrices=" + this.currentPrices + ")";
        }

        public /* synthetic */ ViewState(LocalDate localDate, LocalDate localDate2, LocalDate localDate3, CalendarSheetType calendarSheetType, YearMonth yearMonth, PricesState pricesState, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(localDate, localDate2, localDate3, calendarSheetType, (i5 & 16) != 0 ? YearMonth.of(localDate.getYear(), localDate.getMonthValue()) : yearMonth, (i5 & 32) != 0 ? null : pricesState);
        }
    }
}
