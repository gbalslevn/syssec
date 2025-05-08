package dk.molslinjen.domain.managers.saleOnBoard;

import com.sun.jna.Function;
import dk.molslinjen.api.services.booking.IBookingService;
import dk.molslinjen.domain.managers.departure.DepartureRequestHandler;
import dk.molslinjen.domain.managers.departure.DepartureState;
import dk.molslinjen.domain.managers.departure.IDepartureRequestHandler;
import dk.molslinjen.domain.model.booking.DayDepartures;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureLoadingState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.ChronoUnit;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0014\u0010\u0017\u001a\u00020\u0016*\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J&\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u000fH\u0016J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0016J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006$"}, d2 = {"Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardDepartureManager;", "Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardDepartureManager;", "bookingService", "Ldk/molslinjen/api/services/booking/IBookingService;", "saleOnBoardRouteManager", "Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardRouteManager;", "<init>", "(Ldk/molslinjen/api/services/booking/IBookingService;Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardRouteManager;)V", "departureRequestHandler", "Ldk/molslinjen/domain/managers/departure/IDepartureRequestHandler;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "currentDeparturesRequestId", BuildConfig.FLAVOR, "isLoadingDeparturesUntil", "Lorg/threeten/bp/LocalDate;", "departureState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/managers/departure/DepartureState;", "getDepartureState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "setupDepartureUpdateHandling", BuildConfig.FLAVOR, "startLoadingDepartures", "routeState", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardRouteState;", "getDepartures", "departuresRequestId", "requestState", "date", "(Ljava/lang/String;Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardRouteState;Lorg/threeten/bp/LocalDate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureLoadingDeparturesUntil", "toDate", "showDepartureLoadingError", "reloadDepartures", "updateShownHeaderDate", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaleOnBoardDepartureManager implements ISaleOnBoardDepartureManager {
    private final CoroutineScope coroutineScope;
    private String currentDeparturesRequestId;
    private final IDepartureRequestHandler departureRequestHandler;
    private final MutableStateFlow<DepartureState> departureState;
    private LocalDate isLoadingDeparturesUntil;
    private final ISaleOnBoardRouteManager saleOnBoardRouteManager;

    public SaleOnBoardDepartureManager(IBookingService bookingService, ISaleOnBoardRouteManager saleOnBoardRouteManager) {
        Intrinsics.checkNotNullParameter(bookingService, "bookingService");
        Intrinsics.checkNotNullParameter(saleOnBoardRouteManager, "saleOnBoardRouteManager");
        this.saleOnBoardRouteManager = saleOnBoardRouteManager;
        this.departureRequestHandler = new DepartureRequestHandler(bookingService);
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        this.currentDeparturesRequestId = uuid;
        LocalDate now = LocalDate.now();
        Intrinsics.checkNotNullExpressionValue(now, "now(...)");
        this.isLoadingDeparturesUntil = now;
        this.departureState = StateFlowKt.MutableStateFlow(new DepartureState(false, null, null, null, null, null, null, null, Function.USE_VARARGS, null));
        setupDepartureUpdateHandling();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getDepartures(String str, SaleOnBoardRouteState saleOnBoardRouteState, LocalDate localDate, Continuation<? super Unit> continuation) {
        SaleOnBoardDepartureManager$getDepartures$1 saleOnBoardDepartureManager$getDepartures$1;
        int i5;
        LocalDate localDate2;
        Object departures;
        SaleOnBoardDepartureManager saleOnBoardDepartureManager;
        DayDepartures dayDepartures;
        DepartureState value;
        DepartureState copy;
        Departure copy2;
        if (continuation instanceof SaleOnBoardDepartureManager$getDepartures$1) {
            saleOnBoardDepartureManager$getDepartures$1 = (SaleOnBoardDepartureManager$getDepartures$1) continuation;
            int i6 = saleOnBoardDepartureManager$getDepartures$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                saleOnBoardDepartureManager$getDepartures$1.label = i6 - Integer.MIN_VALUE;
                SaleOnBoardDepartureManager$getDepartures$1 saleOnBoardDepartureManager$getDepartures$12 = saleOnBoardDepartureManager$getDepartures$1;
                Object obj = saleOnBoardDepartureManager$getDepartures$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = saleOnBoardDepartureManager$getDepartures$12.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IDepartureRequestHandler iDepartureRequestHandler = this.departureRequestHandler;
                    saleOnBoardDepartureManager$getDepartures$12.L$0 = this;
                    localDate2 = localDate;
                    saleOnBoardDepartureManager$getDepartures$12.L$1 = localDate2;
                    saleOnBoardDepartureManager$getDepartures$12.label = 1;
                    departures = iDepartureRequestHandler.getDepartures(str, null, localDate, saleOnBoardRouteState, saleOnBoardDepartureManager$getDepartures$12);
                    if (departures == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    saleOnBoardDepartureManager = this;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LocalDate localDate3 = (LocalDate) saleOnBoardDepartureManager$getDepartures$12.L$1;
                    SaleOnBoardDepartureManager saleOnBoardDepartureManager2 = (SaleOnBoardDepartureManager) saleOnBoardDepartureManager$getDepartures$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    departures = obj;
                    localDate2 = localDate3;
                    saleOnBoardDepartureManager = saleOnBoardDepartureManager2;
                }
                dayDepartures = (DayDepartures) departures;
                if (dayDepartures != null) {
                    return Unit.INSTANCE;
                }
                if (dayDepartures.getLoadingState() == DepartureLoadingState.Error) {
                    saleOnBoardDepartureManager.showDepartureLoadingError();
                }
                List<DayDepartures> departures2 = saleOnBoardDepartureManager.getDepartureState().getValue().getDepartures();
                if (!(departures2 instanceof Collection) || !departures2.isEmpty()) {
                    for (DayDepartures dayDepartures2 : departures2) {
                        if (!dayDepartures2.getTimeTableStatus().isAvailable() && dayDepartures2.getDate().isBefore(localDate2)) {
                            return Unit.INSTANCE;
                        }
                    }
                }
                MutableStateFlow<DepartureState> departureState = saleOnBoardDepartureManager.getDepartureState();
                do {
                    value = departureState.getValue();
                    DepartureState departureState2 = value;
                    List mutableList = CollectionsKt.toMutableList((Collection) departureState2.getDepartures());
                    List<Departure> departures3 = dayDepartures.getDepartures();
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(departures3, 10));
                    Iterator<T> it = departures3.iterator();
                    while (it.hasNext()) {
                        copy2 = r14.copy((r40 & 1) != 0 ? r14.arrivalHarborName : null, (r40 & 2) != 0 ? r14.arrivalTime : null, (r40 & 4) != 0 ? r14.cancelled : false, (r40 & 8) != 0 ? r14.customRouteTypeText : null, (r40 & 16) != 0 ? r14.date : null, (r40 & 32) != 0 ? r14.departureHarborName : null, (r40 & 64) != 0 ? r14.departureTime : null, (r40 & 128) != 0 ? r14.ferry : null, (r40 & 256) != 0 ? r14.id : null, (r40 & 512) != 0 ? r14.timeTableId : null, (r40 & 1024) != 0 ? r14.information : null, (r40 & 2048) != 0 ? r14.fromPrice : null, (r40 & 4096) != 0 ? r14.cheapestTicketType : null, (r40 & 8192) != 0 ? r14.mainRouteId : null, (r40 & 16384) != 0 ? r14.routeId : null, (r40 & 32768) != 0 ? r14.routeType : null, (r40 & 65536) != 0 ? r14.soldOut : false, (r40 & 131072) != 0 ? r14.transportSwitchDescription : null, (r40 & 262144) != 0 ? r14.tickets : null, (r40 & 524288) != 0 ? r14.travelTime : null, (r40 & 1048576) != 0 ? r14.limitedAvailability : false, (r40 & 2097152) != 0 ? ((Departure) it.next()).availableProductTypes : null);
                        arrayList.add(copy2);
                    }
                    mutableList.add(DayDepartures.copy$default(dayDepartures, null, arrayList, null, null, null, 29, null));
                    Unit unit = Unit.INSTANCE;
                    copy = departureState2.copy((r18 & 1) != 0 ? departureState2.loadingDeparturesError : false, (r18 & 2) != 0 ? departureState2.departures : CollectionsKt.sortedWith(mutableList, new Comparator() { // from class: dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardDepartureManager$getDepartures$lambda$5$$inlined$sortedBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t5, T t6) {
                            return ComparisonsKt.compareValues(((DayDepartures) t5).getDate(), ((DayDepartures) t6).getDate());
                        }
                    }), (r18 & 4) != 0 ? departureState2.siteDepartureNotice : null, (r18 & 8) != 0 ? departureState2.shownHeaderDate : null, (r18 & 16) != 0 ? departureState2.selectionInProgressDeparture : null, (r18 & 32) != 0 ? departureState2.selectedDeparture : null, (r18 & 64) != 0 ? departureState2.selectedDepartureTicket : null, (r18 & 128) != 0 ? departureState2.startedLoadingTime : null);
                } while (!departureState.compareAndSet(value, copy));
                return Unit.INSTANCE;
            }
        }
        saleOnBoardDepartureManager$getDepartures$1 = new SaleOnBoardDepartureManager$getDepartures$1(this, continuation);
        SaleOnBoardDepartureManager$getDepartures$1 saleOnBoardDepartureManager$getDepartures$122 = saleOnBoardDepartureManager$getDepartures$1;
        Object obj2 = saleOnBoardDepartureManager$getDepartures$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = saleOnBoardDepartureManager$getDepartures$122.label;
        if (i5 != 0) {
        }
        dayDepartures = (DayDepartures) departures;
        if (dayDepartures != null) {
        }
    }

    private final void setupDepartureUpdateHandling() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new SaleOnBoardDepartureManager$setupDepartureUpdateHandling$1(this, null), 3, null);
    }

    private final void showDepartureLoadingError() {
        DepartureState value;
        DepartureState copy;
        MutableStateFlow<DepartureState> departureState = getDepartureState();
        do {
            value = departureState.getValue();
            copy = r2.copy((r18 & 1) != 0 ? r2.loadingDeparturesError : true, (r18 & 2) != 0 ? r2.departures : null, (r18 & 4) != 0 ? r2.siteDepartureNotice : null, (r18 & 8) != 0 ? r2.shownHeaderDate : null, (r18 & 16) != 0 ? r2.selectionInProgressDeparture : null, (r18 & 32) != 0 ? r2.selectedDeparture : null, (r18 & 64) != 0 ? r2.selectedDepartureTicket : null, (r18 & 128) != 0 ? value.startedLoadingTime : null);
        } while (!departureState.compareAndSet(value, copy));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startLoadingDepartures(CoroutineScope coroutineScope, SaleOnBoardRouteState saleOnBoardRouteState) {
        DepartureState value;
        DepartureState copy;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        this.currentDeparturesRequestId = uuid;
        LocalDate selectedStartDate = saleOnBoardRouteState.getSelectedStartDate();
        this.isLoadingDeparturesUntil = selectedStartDate.plusDays(2L);
        MutableStateFlow<DepartureState> departureState = getDepartureState();
        do {
            value = departureState.getValue();
            copy = r9.copy((r18 & 1) != 0 ? r9.loadingDeparturesError : false, (r18 & 2) != 0 ? r9.departures : CollectionsKt.emptyList(), (r18 & 4) != 0 ? r9.siteDepartureNotice : null, (r18 & 8) != 0 ? r9.shownHeaderDate : selectedStartDate, (r18 & 16) != 0 ? r9.selectionInProgressDeparture : null, (r18 & 32) != 0 ? r9.selectedDeparture : null, (r18 & 64) != 0 ? r9.selectedDepartureTicket : null, (r18 & 128) != 0 ? value.startedLoadingTime : null);
        } while (!departureState.compareAndSet(value, copy));
        int i5 = 0;
        while (i5 < 3) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SaleOnBoardDepartureManager$startLoadingDepartures$2(this, uuid, saleOnBoardRouteState, selectedStartDate, i5, null), 3, null);
            i5++;
            selectedStartDate = selectedStartDate;
        }
    }

    @Override // dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardDepartureManager
    public void ensureLoadingDeparturesUntil(LocalDate toDate) {
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        LocalDate localDate = this.isLoadingDeparturesUntil;
        if (!toDate.isAfter(localDate)) {
            return;
        }
        this.isLoadingDeparturesUntil = toDate;
        long between = ChronoUnit.DAYS.between(localDate, toDate);
        SaleOnBoardRouteState value = this.saleOnBoardRouteManager.getRouteState().getValue();
        if (value == null || 1 > between) {
            return;
        }
        long j5 = 1;
        while (true) {
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new SaleOnBoardDepartureManager$ensureLoadingDeparturesUntil$1(this, value, localDate, j5, null), 3, null);
            if (j5 == between) {
                return;
            } else {
                j5++;
            }
        }
    }

    @Override // dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardDepartureManager
    public void reloadDepartures() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new SaleOnBoardDepartureManager$reloadDepartures$1(this, null), 3, null);
    }

    @Override // dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardDepartureManager
    public void updateShownHeaderDate(LocalDate date) {
        DepartureState value;
        DepartureState copy;
        Intrinsics.checkNotNullParameter(date, "date");
        MutableStateFlow<DepartureState> departureState = getDepartureState();
        do {
            value = departureState.getValue();
            copy = r2.copy((r18 & 1) != 0 ? r2.loadingDeparturesError : false, (r18 & 2) != 0 ? r2.departures : null, (r18 & 4) != 0 ? r2.siteDepartureNotice : null, (r18 & 8) != 0 ? r2.shownHeaderDate : date, (r18 & 16) != 0 ? r2.selectionInProgressDeparture : null, (r18 & 32) != 0 ? r2.selectedDeparture : null, (r18 & 64) != 0 ? r2.selectedDepartureTicket : null, (r18 & 128) != 0 ? value.startedLoadingTime : null);
        } while (!departureState.compareAndSet(value, copy));
    }

    @Override // dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardDepartureManager
    public MutableStateFlow<DepartureState> getDepartureState() {
        return this.departureState;
    }
}
