package dk.molslinjen.domain.managers.departure;

import com.sdk.growthbook.utils.Constants;
import com.sun.jna.Function;
import dk.molslinjen.api.services.booking.IBookingService;
import dk.molslinjen.domain.managers.checkout.IEditManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.managers.route.RouteSelectedState;
import dk.molslinjen.domain.managers.route.RouteSharedSelectedState;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.BookingDeparture;
import dk.molslinjen.domain.model.booking.DayDepartures;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.DepartureLoadingState;
import dk.molslinjen.domain.model.booking.DepartureTicket;
import dk.molslinjen.domain.model.settings.ISettings;
import dk.molslinjen.domain.model.settings.SettingsProperty;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.temporal.ChronoUnit;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020$H\u0002JP\u0010%\u001a\u00020$*\u00020\u00102\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\u0010+\u001a\u0004\u0018\u00010\u001f2\b\u0010,\u001a\u0004\u0018\u00010'2\u0006\u0010!\u001a\u00020\"2\b\u0010-\u001a\u0004\u0018\u00010.H\u0002J\u0014\u0010/\u001a\u00020\u0012*\u00020\u00102\u0006\u0010!\u001a\u00020\"H\u0002Jj\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020'2\u0006\u00104\u001a\u00020)2\u0006\u00105\u001a\u00020\u00152\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\u0010+\u001a\u0004\u0018\u00010\u001f2\b\u0010,\u001a\u0004\u0018\u00010'2\u0006\u0010!\u001a\u00020\"2\b\u0010-\u001a\u0004\u0018\u00010.H\u0082@¢\u0006\u0002\u00106J\u0018\u00107\u001a\u00020$2\u0006\u00108\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"H\u0016J\u0016\u00109\u001a\u00020$2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u0010\u0010:\u001a\u00020$2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010;\u001a\u00020$2\u0006\u00105\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0016J \u0010>\u001a\u00020$2\u0006\u0010=\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020@2\u0006\u0010!\u001a\u00020\"H\u0016J(\u0010A\u001a\u0012\u0012\u0004\u0012\u00020\u001f\u0012\u0006\u0012\u0004\u0018\u00010@\u0018\u00010B2\u0006\u0010C\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010D\u001a\u00020$H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0016\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Ldk/molslinjen/domain/managers/departure/DepartureManager;", "Ldk/molslinjen/domain/managers/departure/IDepartureManager;", "routeManager", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "editManager", "Ldk/molslinjen/domain/managers/checkout/IEditManager;", "bookingService", "Ldk/molslinjen/api/services/booking/IBookingService;", "settings", "Ldk/molslinjen/domain/model/settings/ISettings;", "<init>", "(Ldk/molslinjen/domain/managers/route/IRouteManager;Ldk/molslinjen/domain/managers/checkout/IEditManager;Ldk/molslinjen/api/services/booking/IBookingService;Ldk/molslinjen/domain/model/settings/ISettings;)V", "outboundDepartureRequestHandler", "Ldk/molslinjen/domain/managers/departure/IDepartureRequestHandler;", "returnDepartureRequestHandler", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "currentOutboundDeparturesRequestId", BuildConfig.FLAVOR, "currentReturnDeparturesRequestId", "isLoadingDeparturesUntil", "Lorg/threeten/bp/LocalDate;", "outboundState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/managers/departure/DepartureState;", "getOutboundState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "returnState", "getReturnState", "selectedOutboundDepartureState", "Lkotlinx/coroutines/flow/Flow;", "Ldk/molslinjen/domain/model/booking/Departure;", "getState", "departureDirection", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "setupDepartureUpdateHandling", BuildConfig.FLAVOR, "startLoadingDepartures", "routeSelectedState", "Ldk/molslinjen/domain/managers/route/RouteSelectedState;", "routeSharedSelectedState", "Ldk/molslinjen/domain/managers/route/RouteSharedSelectedState;", "resultState", "outboundTripDepartureForReturn", "outboundTripRouteStateForReturn", "existingBooking", "Ldk/molslinjen/domain/model/booking/Booking;", "getAndUpdateSessionKey", "getDepartures", "departuresRequestId", "sessionKey", "requestState", "requestSharedState", "date", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/managers/route/RouteSelectedState;Ldk/molslinjen/domain/managers/route/RouteSharedSelectedState;Lorg/threeten/bp/LocalDate;Lkotlinx/coroutines/flow/MutableStateFlow;Ldk/molslinjen/domain/model/booking/Departure;Ldk/molslinjen/domain/managers/route/RouteSelectedState;Ldk/molslinjen/domain/model/booking/DepartureDirection;Ldk/molslinjen/domain/model/booking/Booking;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureLoadingDeparturesUntil", "toDate", "showDepartureLoadingError", "reloadDepartures", "updateShownHeaderDate", "departureSelectionStarted", "departure", "departureTicketSelected", "ticket", "Ldk/molslinjen/domain/model/booking/DepartureTicket;", "getDeparture", "Lkotlin/Pair;", Constants.ID_ATTRIBUTE_KEY, "clear", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DepartureManager implements IDepartureManager {
    private final CoroutineScope coroutineScope;
    private String currentOutboundDeparturesRequestId;
    private String currentReturnDeparturesRequestId;
    private final IEditManager editManager;
    private LocalDate isLoadingDeparturesUntil;
    private final IDepartureRequestHandler outboundDepartureRequestHandler;
    private final MutableStateFlow<DepartureState> outboundState;
    private final IDepartureRequestHandler returnDepartureRequestHandler;
    private final MutableStateFlow<DepartureState> returnState;
    private final IRouteManager routeManager;
    private final Flow<Departure> selectedOutboundDepartureState;
    private final ISettings settings;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DepartureDirection.values().length];
            try {
                iArr[DepartureDirection.Outbound.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DepartureDirection.Return.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DepartureManager(IRouteManager routeManager, IEditManager editManager, IBookingService bookingService, ISettings settings) {
        Intrinsics.checkNotNullParameter(routeManager, "routeManager");
        Intrinsics.checkNotNullParameter(editManager, "editManager");
        Intrinsics.checkNotNullParameter(bookingService, "bookingService");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.routeManager = routeManager;
        this.editManager = editManager;
        this.settings = settings;
        this.outboundDepartureRequestHandler = new DepartureRequestHandler(bookingService);
        this.returnDepartureRequestHandler = new DepartureRequestHandler(bookingService);
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        this.currentOutboundDeparturesRequestId = uuid;
        String uuid2 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid2, "toString(...)");
        this.currentReturnDeparturesRequestId = uuid2;
        LocalDate now = LocalDate.now();
        Intrinsics.checkNotNullExpressionValue(now, "now(...)");
        this.isLoadingDeparturesUntil = now;
        this.outboundState = StateFlowKt.MutableStateFlow(new DepartureState(false, null, null, null, null, null, null, null, Function.USE_VARARGS, null));
        this.returnState = StateFlowKt.MutableStateFlow(new DepartureState(false, null, null, null, null, null, null, null, Function.USE_VARARGS, null));
        final MutableStateFlow<DepartureState> outboundState = getOutboundState();
        this.selectedOutboundDepartureState = new Flow<Departure>() { // from class: dk.molslinjen.domain.managers.departure.DepartureManager$special$$inlined$map$1

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "value", BuildConfig.FLAVOR, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
            /* renamed from: dk.molslinjen.domain.managers.departure.DepartureManager$special$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                @DebugMetadata(c = "dk.molslinjen.domain.managers.departure.DepartureManager$special$$inlined$map$1$2", f = "DepartureManager.kt", l = {223}, m = "emit")
                /* renamed from: dk.molslinjen.domain.managers.departure.DepartureManager$special$$inlined$map$1$2$1, reason: invalid class name */
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
                                Departure selectedDeparture = ((DepartureState) obj).getSelectedDeparture();
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(selectedDeparture, anonymousClass1) == coroutine_suspended) {
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
            public Object collect(FlowCollector<? super Departure> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
        setupDepartureUpdateHandling();
    }

    private final String getAndUpdateSessionKey(CoroutineScope coroutineScope, DepartureDirection departureDirection) {
        String str = (String) this.settings.get(coroutineScope, SettingsProperty.DeparturesSessionKey.INSTANCE).getValue();
        if (departureDirection == DepartureDirection.Outbound || str == null) {
            str = UUID.randomUUID().toString();
        }
        Intrinsics.checkNotNull(str);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DepartureManager$getAndUpdateSessionKey$1(this, str, null), 3, null);
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getDepartures(String str, String str2, RouteSelectedState routeSelectedState, RouteSharedSelectedState routeSharedSelectedState, LocalDate localDate, MutableStateFlow<DepartureState> mutableStateFlow, Departure departure, RouteSelectedState routeSelectedState2, DepartureDirection departureDirection, Booking booking, Continuation<? super Unit> continuation) {
        DepartureManager$getDepartures$1 departureManager$getDepartures$1;
        int i5;
        IDepartureRequestHandler iDepartureRequestHandler;
        MutableStateFlow<DepartureState> mutableStateFlow2;
        Booking booking2;
        DepartureManager departureManager;
        LocalDate localDate2;
        DayDepartures dayDepartures;
        DepartureState value;
        Object obj;
        DepartureState copy;
        Object obj2;
        DepartureTicket departureTicket;
        DepartureState value2;
        Object obj3;
        DepartureState copy2;
        List<DepartureTicket> tickets;
        Object obj4;
        if (continuation instanceof DepartureManager$getDepartures$1) {
            departureManager$getDepartures$1 = (DepartureManager$getDepartures$1) continuation;
            int i6 = departureManager$getDepartures$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                departureManager$getDepartures$1.label = i6 - Integer.MIN_VALUE;
                DepartureManager$getDepartures$1 departureManager$getDepartures$12 = departureManager$getDepartures$1;
                Object obj5 = departureManager$getDepartures$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = departureManager$getDepartures$12.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj5);
                    int i7 = WhenMappings.$EnumSwitchMapping$0[departureDirection.ordinal()];
                    if (i7 == 1) {
                        iDepartureRequestHandler = this.outboundDepartureRequestHandler;
                    } else {
                        if (i7 != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        iDepartureRequestHandler = this.returnDepartureRequestHandler;
                    }
                    IDepartureRequestHandler iDepartureRequestHandler2 = iDepartureRequestHandler;
                    departureManager$getDepartures$12.L$0 = this;
                    departureManager$getDepartures$12.L$1 = localDate;
                    mutableStateFlow2 = mutableStateFlow;
                    departureManager$getDepartures$12.L$2 = mutableStateFlow2;
                    booking2 = booking;
                    departureManager$getDepartures$12.L$3 = booking2;
                    departureManager$getDepartures$12.label = 1;
                    Object departures = iDepartureRequestHandler2.getDepartures(str, str2, localDate, routeSelectedState, routeSharedSelectedState, departure, routeSelectedState2, booking, departureManager$getDepartures$12);
                    if (departures == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    departureManager = this;
                    localDate2 = localDate;
                    obj5 = departures;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Booking booking3 = (Booking) departureManager$getDepartures$12.L$3;
                    MutableStateFlow<DepartureState> mutableStateFlow3 = (MutableStateFlow) departureManager$getDepartures$12.L$2;
                    localDate2 = (LocalDate) departureManager$getDepartures$12.L$1;
                    departureManager = (DepartureManager) departureManager$getDepartures$12.L$0;
                    ResultKt.throwOnFailure(obj5);
                    booking2 = booking3;
                    mutableStateFlow2 = mutableStateFlow3;
                }
                dayDepartures = (DayDepartures) obj5;
                if (dayDepartures != null) {
                    return Unit.INSTANCE;
                }
                if (dayDepartures.getLoadingState() == DepartureLoadingState.Error) {
                    departureManager.showDepartureLoadingError(mutableStateFlow2);
                }
                List<DayDepartures> departures2 = mutableStateFlow2.getValue().getDepartures();
                if (!(departures2 instanceof Collection) || !departures2.isEmpty()) {
                    for (DayDepartures dayDepartures2 : departures2) {
                        if (!dayDepartures2.getTimeTableStatus().isAvailable() && dayDepartures2.getDate().isBefore(localDate2)) {
                            return Unit.INSTANCE;
                        }
                    }
                }
                if (booking2 == null || mutableStateFlow2.getValue().getSelectedDeparture() != null || booking2 == null || !Intrinsics.areEqual(dayDepartures.getDate(), booking2.getTicket().getDeparture().getDate())) {
                    do {
                        value = mutableStateFlow2.getValue();
                        DepartureState departureState = value;
                        List sortedWith = CollectionsKt.sortedWith(CollectionsKt.plus((Collection<? extends DayDepartures>) departureState.getDepartures(), dayDepartures), new Comparator() { // from class: dk.molslinjen.domain.managers.departure.DepartureManager$getDepartures$lambda$10$$inlined$sortedBy$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t5, T t6) {
                                return ComparisonsKt.compareValues(((DayDepartures) t5).getDate(), ((DayDepartures) t6).getDate());
                            }
                        });
                        Iterator it = sortedWith.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it.next();
                            if (((DayDepartures) obj).getSiteDeparturesNotice() != null) {
                                break;
                            }
                        }
                        DayDepartures dayDepartures3 = (DayDepartures) obj;
                        copy = departureState.copy((r18 & 1) != 0 ? departureState.loadingDeparturesError : false, (r18 & 2) != 0 ? departureState.departures : sortedWith, (r18 & 4) != 0 ? departureState.siteDepartureNotice : dayDepartures3 != null ? dayDepartures3.getSiteDeparturesNotice() : null, (r18 & 8) != 0 ? departureState.shownHeaderDate : null, (r18 & 16) != 0 ? departureState.selectionInProgressDeparture : null, (r18 & 32) != 0 ? departureState.selectedDeparture : null, (r18 & 64) != 0 ? departureState.selectedDepartureTicket : null, (r18 & 128) != 0 ? departureState.startedLoadingTime : null);
                    } while (!mutableStateFlow2.compareAndSet(value, copy));
                } else {
                    BookingDeparture departure2 = booking2.getTicket().getDeparture();
                    Iterator<T> it2 = dayDepartures.getDepartures().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it2.next();
                        if (Intrinsics.areEqual(((Departure) obj2).getId(), departure2.getDepartureId())) {
                            break;
                        }
                    }
                    Departure departure3 = (Departure) obj2;
                    if (departure3 == null || (tickets = departure3.getTickets()) == null) {
                        departureTicket = null;
                    } else {
                        Iterator<T> it3 = tickets.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                obj4 = null;
                                break;
                            }
                            obj4 = it3.next();
                            if (Intrinsics.areEqual(((DepartureTicket) obj4).getCategory().getId(), booking2.getTicket().getTicketTypeId())) {
                                break;
                            }
                        }
                        departureTicket = (DepartureTicket) obj4;
                    }
                    do {
                        value2 = mutableStateFlow2.getValue();
                        DepartureState departureState2 = value2;
                        List sortedWith2 = CollectionsKt.sortedWith(CollectionsKt.plus((Collection<? extends DayDepartures>) departureState2.getDepartures(), dayDepartures), new Comparator() { // from class: dk.molslinjen.domain.managers.departure.DepartureManager$getDepartures$lambda$7$$inlined$sortedBy$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t5, T t6) {
                                return ComparisonsKt.compareValues(((DayDepartures) t5).getDate(), ((DayDepartures) t6).getDate());
                            }
                        });
                        Departure departure4 = departureTicket == null ? null : departure3;
                        Iterator it4 = sortedWith2.iterator();
                        while (true) {
                            if (!it4.hasNext()) {
                                obj3 = null;
                                break;
                            }
                            obj3 = it4.next();
                            if (((DayDepartures) obj3).getSiteDeparturesNotice() != null) {
                                break;
                            }
                        }
                        DayDepartures dayDepartures4 = (DayDepartures) obj3;
                        copy2 = departureState2.copy((r18 & 1) != 0 ? departureState2.loadingDeparturesError : false, (r18 & 2) != 0 ? departureState2.departures : sortedWith2, (r18 & 4) != 0 ? departureState2.siteDepartureNotice : dayDepartures4 != null ? dayDepartures4.getSiteDeparturesNotice() : null, (r18 & 8) != 0 ? departureState2.shownHeaderDate : null, (r18 & 16) != 0 ? departureState2.selectionInProgressDeparture : null, (r18 & 32) != 0 ? departureState2.selectedDeparture : departure4, (r18 & 64) != 0 ? departureState2.selectedDepartureTicket : departureTicket, (r18 & 128) != 0 ? departureState2.startedLoadingTime : null);
                    } while (!mutableStateFlow2.compareAndSet(value2, copy2));
                }
                return Unit.INSTANCE;
            }
        }
        departureManager$getDepartures$1 = new DepartureManager$getDepartures$1(this, continuation);
        DepartureManager$getDepartures$1 departureManager$getDepartures$122 = departureManager$getDepartures$1;
        Object obj52 = departureManager$getDepartures$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = departureManager$getDepartures$122.label;
        if (i5 != 0) {
        }
        dayDepartures = (DayDepartures) obj52;
        if (dayDepartures != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MutableStateFlow<DepartureState> getState(DepartureDirection departureDirection) {
        int i5 = WhenMappings.$EnumSwitchMapping$0[departureDirection.ordinal()];
        if (i5 == 1) {
            return getOutboundState();
        }
        if (i5 == 2) {
            return getReturnState();
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void setupDepartureUpdateHandling() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new DepartureManager$setupDepartureUpdateHandling$1(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new DepartureManager$setupDepartureUpdateHandling$2(this, null), 3, null);
    }

    private final void showDepartureLoadingError(MutableStateFlow<DepartureState> resultState) {
        DepartureState value;
        DepartureState copy;
        do {
            value = resultState.getValue();
            copy = r1.copy((r18 & 1) != 0 ? r1.loadingDeparturesError : true, (r18 & 2) != 0 ? r1.departures : null, (r18 & 4) != 0 ? r1.siteDepartureNotice : null, (r18 & 8) != 0 ? r1.shownHeaderDate : null, (r18 & 16) != 0 ? r1.selectionInProgressDeparture : null, (r18 & 32) != 0 ? r1.selectedDeparture : null, (r18 & 64) != 0 ? r1.selectedDepartureTicket : null, (r18 & 128) != 0 ? value.startedLoadingTime : null);
        } while (!resultState.compareAndSet(value, copy));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startLoadingDepartures(CoroutineScope coroutineScope, RouteSelectedState routeSelectedState, RouteSharedSelectedState routeSharedSelectedState, MutableStateFlow<DepartureState> mutableStateFlow, Departure departure, RouteSelectedState routeSelectedState2, DepartureDirection departureDirection, Booking booking) {
        LocalDate localDate;
        DepartureState copy;
        String andUpdateSessionKey = getAndUpdateSessionKey(coroutineScope, departureDirection);
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        int i5 = WhenMappings.$EnumSwitchMapping$0[departureDirection.ordinal()];
        if (i5 == 1) {
            this.currentOutboundDeparturesRequestId = uuid;
        } else {
            if (i5 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            this.currentReturnDeparturesRequestId = uuid;
        }
        LocalDate selectedStartDate = routeSelectedState.getSelectedStartDate();
        this.isLoadingDeparturesUntil = selectedStartDate.plusDays(2L);
        while (true) {
            DepartureState value = mutableStateFlow.getValue();
            localDate = selectedStartDate;
            copy = r1.copy((r18 & 1) != 0 ? r1.loadingDeparturesError : false, (r18 & 2) != 0 ? r1.departures : CollectionsKt.emptyList(), (r18 & 4) != 0 ? r1.siteDepartureNotice : null, (r18 & 8) != 0 ? r1.shownHeaderDate : selectedStartDate, (r18 & 16) != 0 ? r1.selectionInProgressDeparture : null, (r18 & 32) != 0 ? r1.selectedDeparture : null, (r18 & 64) != 0 ? r1.selectedDepartureTicket : null, (r18 & 128) != 0 ? value.startedLoadingTime : LocalDateTime.now());
            if (mutableStateFlow.compareAndSet(value, copy)) {
                break;
            } else {
                selectedStartDate = localDate;
            }
        }
        int i6 = 0;
        while (i6 < 3) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DepartureManager$startLoadingDepartures$2(this, uuid, andUpdateSessionKey, routeSelectedState, routeSharedSelectedState, localDate, i6, mutableStateFlow, departure, routeSelectedState2, departureDirection, booking, null), 3, null);
            i6++;
            uuid = uuid;
        }
    }

    @Override // dk.molslinjen.domain.managers.departure.IDepartureManager
    public void clear() {
        DepartureState value;
        DepartureState copy;
        DepartureState value2;
        DepartureState copy2;
        MutableStateFlow<DepartureState> outboundState = getOutboundState();
        do {
            value = outboundState.getValue();
            copy = r2.copy((r18 & 1) != 0 ? r2.loadingDeparturesError : false, (r18 & 2) != 0 ? r2.departures : null, (r18 & 4) != 0 ? r2.siteDepartureNotice : null, (r18 & 8) != 0 ? r2.shownHeaderDate : null, (r18 & 16) != 0 ? r2.selectionInProgressDeparture : null, (r18 & 32) != 0 ? r2.selectedDeparture : null, (r18 & 64) != 0 ? r2.selectedDepartureTicket : null, (r18 & 128) != 0 ? value.startedLoadingTime : null);
        } while (!outboundState.compareAndSet(value, copy));
        MutableStateFlow<DepartureState> returnState = getReturnState();
        do {
            value2 = returnState.getValue();
            copy2 = r2.copy((r18 & 1) != 0 ? r2.loadingDeparturesError : false, (r18 & 2) != 0 ? r2.departures : null, (r18 & 4) != 0 ? r2.siteDepartureNotice : null, (r18 & 8) != 0 ? r2.shownHeaderDate : null, (r18 & 16) != 0 ? r2.selectionInProgressDeparture : null, (r18 & 32) != 0 ? r2.selectedDeparture : null, (r18 & 64) != 0 ? r2.selectedDepartureTicket : null, (r18 & 128) != 0 ? value2.startedLoadingTime : null);
        } while (!returnState.compareAndSet(value2, copy2));
    }

    @Override // dk.molslinjen.domain.managers.departure.IDepartureManager
    public void departureSelectionStarted(Departure departure, DepartureDirection departureDirection) {
        DepartureState value;
        DepartureState copy;
        Intrinsics.checkNotNullParameter(departure, "departure");
        Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
        DepartureTicket selectedDepartureTicket = getState(departureDirection).getValue().getSelectedDepartureTicket();
        Iterator<T> it = departure.getTickets().iterator();
        while (it.hasNext() && !Intrinsics.areEqual((DepartureTicket) it.next(), selectedDepartureTicket)) {
        }
        MutableStateFlow<DepartureState> state = getState(departureDirection);
        do {
            value = state.getValue();
            copy = r1.copy((r18 & 1) != 0 ? r1.loadingDeparturesError : false, (r18 & 2) != 0 ? r1.departures : null, (r18 & 4) != 0 ? r1.siteDepartureNotice : null, (r18 & 8) != 0 ? r1.shownHeaderDate : null, (r18 & 16) != 0 ? r1.selectionInProgressDeparture : departure, (r18 & 32) != 0 ? r1.selectedDeparture : null, (r18 & 64) != 0 ? r1.selectedDepartureTicket : null, (r18 & 128) != 0 ? value.startedLoadingTime : null);
        } while (!state.compareAndSet(value, copy));
    }

    @Override // dk.molslinjen.domain.managers.departure.IDepartureManager
    public void departureTicketSelected(Departure departure, DepartureTicket ticket, DepartureDirection departureDirection) {
        DepartureState value;
        DepartureState copy;
        Intrinsics.checkNotNullParameter(departure, "departure");
        Intrinsics.checkNotNullParameter(ticket, "ticket");
        Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
        MutableStateFlow<DepartureState> state = getState(departureDirection);
        do {
            value = state.getValue();
            copy = r1.copy((r18 & 1) != 0 ? r1.loadingDeparturesError : false, (r18 & 2) != 0 ? r1.departures : null, (r18 & 4) != 0 ? r1.siteDepartureNotice : null, (r18 & 8) != 0 ? r1.shownHeaderDate : null, (r18 & 16) != 0 ? r1.selectionInProgressDeparture : null, (r18 & 32) != 0 ? r1.selectedDeparture : departure, (r18 & 64) != 0 ? r1.selectedDepartureTicket : ticket, (r18 & 128) != 0 ? value.startedLoadingTime : null);
        } while (!state.compareAndSet(value, copy));
    }

    @Override // dk.molslinjen.domain.managers.departure.IDepartureManager
    public void ensureLoadingDeparturesUntil(LocalDate toDate, DepartureDirection departureDirection) {
        RouteSharedSelectedState value;
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
        LocalDate localDate = this.isLoadingDeparturesUntil;
        String str = (String) this.settings.latestValueFor(SettingsProperty.DeparturesSessionKey.INSTANCE);
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        String str2 = str;
        if (!toDate.isAfter(localDate)) {
            return;
        }
        this.isLoadingDeparturesUntil = toDate;
        long between = ChronoUnit.DAYS.between(localDate, toDate);
        RouteSelectedState value2 = this.routeManager.getActiveSelectedState().getValue();
        if (value2 == null || (value = this.routeManager.getSharedSelectedState().getValue()) == null) {
            return;
        }
        DepartureDirection departureDirection2 = DepartureDirection.Return;
        Departure selectedDeparture = departureDirection == departureDirection2 ? getOutboundState().getValue().getSelectedDeparture() : null;
        RouteSelectedState value3 = departureDirection == departureDirection2 ? this.routeManager.getOutboundSelectedState().getValue() : null;
        String str3 = departureDirection == DepartureDirection.Outbound ? this.currentOutboundDeparturesRequestId : this.currentReturnDeparturesRequestId;
        if (1 > between) {
            return;
        }
        long j5 = 1;
        while (true) {
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new DepartureManager$ensureLoadingDeparturesUntil$1(localDate, j5, this, departureDirection, str3, str2, value2, value, selectedDeparture, value3, null), 3, null);
            if (j5 == between) {
                return;
            } else {
                j5++;
            }
        }
    }

    @Override // dk.molslinjen.domain.managers.departure.IDepartureManager
    public Pair<Departure, DepartureTicket> getDeparture(String id, DepartureDirection departureDirection) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
        DepartureState value = getState(departureDirection).getValue();
        Departure selectionInProgressDeparture = value.getSelectionInProgressDeparture();
        if (selectionInProgressDeparture == null || !Intrinsics.areEqual(selectionInProgressDeparture.getId(), id)) {
            return null;
        }
        return new Pair<>(selectionInProgressDeparture, Intrinsics.areEqual(value.getSelectedDeparture(), selectionInProgressDeparture) ? value.getSelectedDepartureTicket() : null);
    }

    @Override // dk.molslinjen.domain.managers.departure.IDepartureManager
    public void reloadDepartures(DepartureDirection departureDirection) {
        Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
        RouteSelectedState value = this.routeManager.getActiveSelectedState().getValue();
        if (value != null) {
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new DepartureManager$reloadDepartures$1$1(this, departureDirection, value, null), 3, null);
        }
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new DepartureManager$reloadDepartures$2(this, null), 3, null);
    }

    @Override // dk.molslinjen.domain.managers.departure.IDepartureManager
    public void updateShownHeaderDate(LocalDate date, DepartureDirection departureDirection) {
        DepartureState value;
        DepartureState copy;
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
        MutableStateFlow<DepartureState> state = getState(departureDirection);
        do {
            value = state.getValue();
            copy = r1.copy((r18 & 1) != 0 ? r1.loadingDeparturesError : false, (r18 & 2) != 0 ? r1.departures : null, (r18 & 4) != 0 ? r1.siteDepartureNotice : null, (r18 & 8) != 0 ? r1.shownHeaderDate : date, (r18 & 16) != 0 ? r1.selectionInProgressDeparture : null, (r18 & 32) != 0 ? r1.selectedDeparture : null, (r18 & 64) != 0 ? r1.selectedDepartureTicket : null, (r18 & 128) != 0 ? value.startedLoadingTime : null);
        } while (!state.compareAndSet(value, copy));
    }

    @Override // dk.molslinjen.domain.managers.departure.IDepartureManager
    public MutableStateFlow<DepartureState> getOutboundState() {
        return this.outboundState;
    }

    @Override // dk.molslinjen.domain.managers.departure.IDepartureManager
    public MutableStateFlow<DepartureState> getReturnState() {
        return this.returnState;
    }
}
