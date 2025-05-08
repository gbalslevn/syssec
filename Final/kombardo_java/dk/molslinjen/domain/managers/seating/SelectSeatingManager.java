package dk.molslinjen.domain.managers.seating;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.domain.extensions.domain.CurrencyTypeExtensionsKt;
import dk.molslinjen.domain.extensions.domain.FerrySeatingGroupTypeExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.checkout.ICheckoutManager;
import dk.molslinjen.domain.managers.seating.ISelectSeatingManager;
import dk.molslinjen.domain.managers.seating.SelectSeatingManagerError;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.Ferry;
import dk.molslinjen.domain.model.booking.product.CheckoutSeatReservation;
import dk.molslinjen.domain.model.booking.product.UnavailableSeatReservation;
import dk.molslinjen.domain.model.shared.CurrencyType;
import dk.molslinjen.domain.providers.IStringsProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.Currency;
import uniffi.molslinjen_shared.DepartureId;
import uniffi.molslinjen_shared.FerryFloorPlan;
import uniffi.molslinjen_shared.FerrySeat;
import uniffi.molslinjen_shared.FerrySeatId;
import uniffi.molslinjen_shared.FerrySeatingGroup;
import uniffi.molslinjen_shared.FerrySeatingSection;
import uniffi.molslinjen_shared.SeatReservationId;
import uniffi.molslinjen_shared.SelectSeatingHandlerException;
import uniffi.molslinjen_shared.SelectSeatingHandlerInterface;
import uniffi.molslinjen_shared.SelectSeatingHelperInterface;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u00019B)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\r\u001a\u00020\fH\u0082@¢\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b\u0016\u0010\u0015J$\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0096@¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\u0018H\u0096@¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010!\u001a\u0004\u0018\u00010 H\u0096@¢\u0006\u0004\b!\u0010\"J\u0019\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u001d\u001a\u00020\u0018H\u0016¢\u0006\u0004\b$\u0010%J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0096@¢\u0006\u0004\b&\u0010\"J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0096@¢\u0006\u0004\b'\u0010\"J\u000f\u0010(\u001a\u00020\u000fH\u0016¢\u0006\u0004\b(\u0010)R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010*R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010+R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010,R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010-R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020/0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\"\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020.8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b3\u00101\u001a\u0004\b4\u00105R \u00107\u001a\b\u0012\u0004\u0012\u0002060.8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b7\u00101\u001a\u0004\b8\u00105¨\u0006:"}, d2 = {"Ldk/molslinjen/domain/managers/seating/SelectSeatingManager;", "Ldk/molslinjen/domain/managers/seating/ISelectSeatingManager;", "Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;", "checkoutManager", "Luniffi/molslinjen_shared/SelectSeatingHandlerInterface;", "selectSeatingHandler", "Luniffi/molslinjen_shared/SelectSeatingHelperInterface;", "selectSeatingHelper", "Ldk/molslinjen/domain/providers/IStringsProvider;", "stringsProvider", "<init>", "(Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;Luniffi/molslinjen_shared/SelectSeatingHandlerInterface;Luniffi/molslinjen_shared/SelectSeatingHelperInterface;Ldk/molslinjen/domain/providers/IStringsProvider;)V", "Luniffi/molslinjen_shared/SeatReservationId;", "seatReservationId", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "unReserve", "(Luniffi/molslinjen_shared/SeatReservationId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "direction", "synchronizeSeatSelection", "(Ldk/molslinjen/domain/model/booking/DepartureDirection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchFloorPlan", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/FerrySeatId;", "selectedSeats", "Luniffi/molslinjen_shared/FerrySeat;", "getSeats", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", Constants.ID_ATTRIBUTE_KEY, "findSeat", "(Luniffi/molslinjen_shared/FerrySeatId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Luniffi/molslinjen_shared/FerrySeatingSection;", "activeSection", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ldk/molslinjen/domain/managers/seating/SelectSeatingManagerError$SeatLimitReached;", "toggleSeat", "(Luniffi/molslinjen_shared/FerrySeatId;)Ldk/molslinjen/domain/managers/seating/SelectSeatingManagerError$SeatLimitReached;", "reserve", "unreserve", "resetChanges", "()V", "Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;", "Luniffi/molslinjen_shared/SelectSeatingHandlerInterface;", "Luniffi/molslinjen_shared/SelectSeatingHelperInterface;", "Ldk/molslinjen/domain/providers/IStringsProvider;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/managers/seating/SelectSeatingManager$SeatReservationManagerInternalState;", "internalState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Luniffi/molslinjen_shared/FerryFloorPlan;", "selectedFloorPlan", "getSelectedFloorPlan", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/managers/seating/ISelectSeatingManager$SeatReservationState;", "state", "getState", "SeatReservationManagerInternalState", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SelectSeatingManager implements ISelectSeatingManager {
    private final ICheckoutManager checkoutManager;
    private final MutableStateFlow<SeatReservationManagerInternalState> internalState;
    private final SelectSeatingHandlerInterface selectSeatingHandler;
    private final SelectSeatingHelperInterface selectSeatingHelper;
    private final MutableStateFlow<FerryFloorPlan> selectedFloorPlan;
    private final MutableStateFlow<ISelectSeatingManager.SeatReservationState> state;
    private final IStringsProvider stringsProvider;

    /* JADX WARN: Multi-variable type inference failed */
    public SelectSeatingManager(ICheckoutManager checkoutManager, SelectSeatingHandlerInterface selectSeatingHandler, SelectSeatingHelperInterface selectSeatingHelper, IStringsProvider stringsProvider) {
        Intrinsics.checkNotNullParameter(checkoutManager, "checkoutManager");
        Intrinsics.checkNotNullParameter(selectSeatingHandler, "selectSeatingHandler");
        Intrinsics.checkNotNullParameter(selectSeatingHelper, "selectSeatingHelper");
        Intrinsics.checkNotNullParameter(stringsProvider, "stringsProvider");
        this.checkoutManager = checkoutManager;
        this.selectSeatingHandler = selectSeatingHandler;
        this.selectSeatingHelper = selectSeatingHelper;
        this.stringsProvider = stringsProvider;
        this.internalState = StateFlowKt.MutableStateFlow(new SeatReservationManagerInternalState(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
        this.selectedFloorPlan = StateFlowKt.MutableStateFlow(null);
        this.state = StateFlowKt.MutableStateFlow(new ISelectSeatingManager.SeatReservationState(0, null, null, null, 15, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object unReserve(SeatReservationId seatReservationId, Continuation<? super ManagerResult<Unit>> continuation) {
        SelectSeatingManager$unReserve$2 selectSeatingManager$unReserve$2;
        int i5;
        SelectSeatingManager selectSeatingManager;
        DepartureDirection departureDirection;
        MutableStateFlow<ISelectSeatingManager.SeatReservationState> state;
        ISelectSeatingManager.SeatReservationState value;
        try {
            if (continuation instanceof SelectSeatingManager$unReserve$2) {
                selectSeatingManager$unReserve$2 = (SelectSeatingManager$unReserve$2) continuation;
                int i6 = selectSeatingManager$unReserve$2.label;
                if ((i6 & Integer.MIN_VALUE) != 0) {
                    selectSeatingManager$unReserve$2.label = i6 - Integer.MIN_VALUE;
                    Object obj = selectSeatingManager$unReserve$2.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = selectSeatingManager$unReserve$2.label;
                    if (i5 != 0) {
                        ResultKt.throwOnFailure(obj);
                        DepartureDirection direction = this.internalState.getValue().getDirection();
                        if (direction == null) {
                            return ManagerResult.Error.INSTANCE.noMessage();
                        }
                        SelectSeatingHandlerInterface selectSeatingHandlerInterface = this.selectSeatingHandler;
                        selectSeatingManager$unReserve$2.L$0 = this;
                        selectSeatingManager$unReserve$2.L$1 = direction;
                        selectSeatingManager$unReserve$2.label = 1;
                        if (selectSeatingHandlerInterface.unReserveSeats(seatReservationId, selectSeatingManager$unReserve$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        selectSeatingManager = this;
                        departureDirection = direction;
                    } else {
                        if (i5 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        departureDirection = (DepartureDirection) selectSeatingManager$unReserve$2.L$1;
                        selectSeatingManager = (SelectSeatingManager) selectSeatingManager$unReserve$2.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    state = selectSeatingManager.getState();
                    do {
                        value = state.getValue();
                    } while (!state.compareAndSet(value, ISelectSeatingManager.SeatReservationState.copy$default(value, 0, CollectionsKt.emptyList(), null, CollectionsKt.emptyList(), 1, null)));
                    selectSeatingManager.checkoutManager.setSeatReservation(null, departureDirection);
                    return new ManagerResult.Success(Unit.INSTANCE);
                }
            }
            if (i5 != 0) {
            }
            state = selectSeatingManager.getState();
            do {
                value = state.getValue();
            } while (!state.compareAndSet(value, ISelectSeatingManager.SeatReservationState.copy$default(value, 0, CollectionsKt.emptyList(), null, CollectionsKt.emptyList(), 1, null)));
            selectSeatingManager.checkoutManager.setSeatReservation(null, departureDirection);
            return new ManagerResult.Success(Unit.INSTANCE);
        } catch (SelectSeatingHandlerException e5) {
            Logger.INSTANCE.logError(e5);
            if ((e5 instanceof SelectSeatingHandlerException.NoFloorsException) || (e5 instanceof SelectSeatingHandlerException.ServiceException)) {
                return ManagerResult.Error.INSTANCE.noMessage();
            }
            throw new NoWhenBranchMatchedException();
        }
        selectSeatingManager$unReserve$2 = new SelectSeatingManager$unReserve$2(this, continuation);
        Object obj2 = selectSeatingManager$unReserve$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = selectSeatingManager$unReserve$2.label;
    }

    @Override // dk.molslinjen.domain.managers.seating.ISelectSeatingManager
    public Object activeSection(Continuation<? super FerrySeatingSection> continuation) {
        FerrySeat ferrySeat;
        FerrySeatId id;
        FerryFloorPlan value = getSelectedFloorPlan().getValue();
        if (value == null || (ferrySeat = (FerrySeat) CollectionsKt.firstOrNull((List) getState().getValue().getReservedSeats())) == null || (id = ferrySeat.getId()) == null) {
            return null;
        }
        return this.selectSeatingHelper.findSection(value, id);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    @Override // dk.molslinjen.domain.managers.seating.ISelectSeatingManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object fetchFloorPlan(DepartureDirection departureDirection, Continuation<? super ManagerResult<Unit>> continuation) {
        SelectSeatingManager$fetchFloorPlan$1 selectSeatingManager$fetchFloorPlan$1;
        int i5;
        String name;
        CurrencyType currency;
        Currency currency2;
        String str;
        Currency currency3;
        DepartureId departureId;
        SelectSeatingHandlerException e5;
        SelectSeatingManager selectSeatingManager;
        FerryFloorPlan ferryFloorPlan;
        MutableStateFlow<FerryFloorPlan> selectedFloorPlan;
        if (continuation instanceof SelectSeatingManager$fetchFloorPlan$1) {
            selectSeatingManager$fetchFloorPlan$1 = (SelectSeatingManager$fetchFloorPlan$1) continuation;
            int i6 = selectSeatingManager$fetchFloorPlan$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                selectSeatingManager$fetchFloorPlan$1.label = i6 - Integer.MIN_VALUE;
                SelectSeatingManager$fetchFloorPlan$1 selectSeatingManager$fetchFloorPlan$12 = selectSeatingManager$fetchFloorPlan$1;
                Object obj = selectSeatingManager$fetchFloorPlan$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = selectSeatingManager$fetchFloorPlan$12.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    CheckoutManager.CheckoutDirectionState value = this.checkoutManager.directionState(departureDirection).getValue();
                    if (value == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    Ferry ferry = value.getDeparture().getFerry();
                    if (ferry == null || (name = ferry.getName()) == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    DepartureId departureId2 = this.internalState.getValue().getDepartureId();
                    if (departureId2 == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    CheckoutManager.CheckoutState value2 = this.checkoutManager.getCheckoutState().getValue();
                    if (value2 == null || (currency = value2.getCurrency()) == null || (currency2 = CurrencyTypeExtensionsKt.toCurrency(currency)) == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    try {
                        SelectSeatingHandlerInterface selectSeatingHandlerInterface = this.selectSeatingHandler;
                        List<FerrySeat> reservedSeats = getState().getValue().getReservedSeats();
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(reservedSeats, 10));
                        Iterator<T> it = reservedSeats.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((FerrySeat) it.next()).getId());
                        }
                        selectSeatingManager$fetchFloorPlan$12.L$0 = this;
                        selectSeatingManager$fetchFloorPlan$12.L$1 = name;
                        selectSeatingManager$fetchFloorPlan$12.L$2 = departureId2;
                        selectSeatingManager$fetchFloorPlan$12.L$3 = currency2;
                        selectSeatingManager$fetchFloorPlan$12.label = 1;
                        Object floorPlan = selectSeatingHandlerInterface.getFloorPlan(departureId2, name, currency2, arrayList, selectSeatingManager$fetchFloorPlan$12);
                        if (floorPlan == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        selectSeatingManager = this;
                        departureId = departureId2;
                        obj = floorPlan;
                        str = name;
                        currency3 = currency2;
                    } catch (SelectSeatingHandlerException e6) {
                        str = name;
                        currency3 = currency2;
                        departureId = departureId2;
                        e5 = e6;
                        Logger logger = Logger.INSTANCE;
                        Logger.log$default(logger, "Failed to get floor plan for departure " + departureId + ", " + str + ", " + currency3, null, 0, 6, null);
                        logger.logError(e5);
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    currency3 = (Currency) selectSeatingManager$fetchFloorPlan$12.L$3;
                    departureId = (DepartureId) selectSeatingManager$fetchFloorPlan$12.L$2;
                    str = (String) selectSeatingManager$fetchFloorPlan$12.L$1;
                    selectSeatingManager = (SelectSeatingManager) selectSeatingManager$fetchFloorPlan$12.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (SelectSeatingHandlerException e7) {
                        e5 = e7;
                        Logger logger2 = Logger.INSTANCE;
                        Logger.log$default(logger2, "Failed to get floor plan for departure " + departureId + ", " + str + ", " + currency3, null, 0, 6, null);
                        logger2.logError(e5);
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                }
                ferryFloorPlan = (FerryFloorPlan) obj;
                selectSeatingManager.resetChanges();
                selectedFloorPlan = selectSeatingManager.getSelectedFloorPlan();
                do {
                } while (!selectedFloorPlan.compareAndSet(selectedFloorPlan.getValue(), ferryFloorPlan));
                return new ManagerResult.Success(Unit.INSTANCE);
            }
        }
        selectSeatingManager$fetchFloorPlan$1 = new SelectSeatingManager$fetchFloorPlan$1(this, continuation);
        SelectSeatingManager$fetchFloorPlan$1 selectSeatingManager$fetchFloorPlan$122 = selectSeatingManager$fetchFloorPlan$1;
        Object obj2 = selectSeatingManager$fetchFloorPlan$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = selectSeatingManager$fetchFloorPlan$122.label;
        if (i5 != 0) {
        }
        ferryFloorPlan = (FerryFloorPlan) obj2;
        selectSeatingManager.resetChanges();
        selectedFloorPlan = selectSeatingManager.getSelectedFloorPlan();
        do {
        } while (!selectedFloorPlan.compareAndSet(selectedFloorPlan.getValue(), ferryFloorPlan));
        return new ManagerResult.Success(Unit.INSTANCE);
    }

    public Object findSeat(FerrySeatId ferrySeatId, Continuation<? super FerrySeat> continuation) {
        FerryFloorPlan value = getSelectedFloorPlan().getValue();
        if (value != null) {
            return this.selectSeatingHelper.findSeat(value, ferrySeatId);
        }
        return null;
    }

    @Override // dk.molslinjen.domain.managers.seating.ISelectSeatingManager
    public Object getSeats(List<FerrySeatId> list, Continuation<? super List<FerrySeat>> continuation) {
        FerryFloorPlan value = getSelectedFloorPlan().getValue();
        if (value == null) {
            return CollectionsKt.emptyList();
        }
        List<FerrySeatingSection> sections = value.getSections();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(sections, 10));
        Iterator<T> it = sections.iterator();
        while (it.hasNext()) {
            List<FerrySeatingGroup> seatGroups = ((FerrySeatingSection) it.next()).getSeatGroups();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(seatGroups, 10));
            Iterator<T> it2 = seatGroups.iterator();
            while (it2.hasNext()) {
                arrayList2.add(FerrySeatingGroupTypeExtensionsKt.getSeats(((FerrySeatingGroup) it2.next()).getGroupType()));
            }
            arrayList.add(CollectionsKt.flatten(arrayList2));
        }
        List flatten = CollectionsKt.flatten(arrayList);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : flatten) {
            if (list.contains(((FerrySeat) obj).getId())) {
                arrayList3.add(obj);
            }
        }
        return arrayList3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01ec A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /* JADX WARN: Type inference failed for: r11v21, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v28, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x01ed -> B:14:0x01f4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x018f -> B:34:0x0192). Please report as a decompilation issue!!! */
    @Override // dk.molslinjen.domain.managers.seating.ISelectSeatingManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object reserve(Continuation<? super ManagerResult<Unit>> continuation) {
        SelectSeatingManager$reserve$1 selectSeatingManager$reserve$1;
        int i5;
        DepartureDirection direction;
        SelectSeatingManager selectSeatingManager;
        DepartureDirection departureDirection;
        List<FerrySeatId> list;
        DepartureDirection departureDirection2;
        List<FerrySeatId> list2;
        SeatReservationId seatReservationId;
        SelectSeatingManager selectSeatingManager2;
        SelectSeatingManager selectSeatingManager3;
        List<FerrySeatId> list3;
        Collection collection;
        DepartureDirection departureDirection3;
        SeatReservationId seatReservationId2;
        Iterator it;
        MutableStateFlow<ISelectSeatingManager.SeatReservationState> state;
        ArrayList arrayList;
        ISelectSeatingManager.SeatReservationState seatReservationState;
        ISelectSeatingManager.SeatReservationState seatReservationState2;
        Iterator it2;
        SeatReservationId seatReservationId3;
        List<FerrySeatId> list4;
        int i6;
        SeatReservationId seatReservationId4;
        FerrySeat ferrySeat;
        Object findSeat;
        try {
            if (continuation instanceof SelectSeatingManager$reserve$1) {
                selectSeatingManager$reserve$1 = (SelectSeatingManager$reserve$1) continuation;
                int i7 = selectSeatingManager$reserve$1.label;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    selectSeatingManager$reserve$1.label = i7 - Integer.MIN_VALUE;
                    Object obj = selectSeatingManager$reserve$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = selectSeatingManager$reserve$1.label;
                    if (i5 != 0) {
                        ResultKt.throwOnFailure(obj);
                        DepartureId departureId = this.internalState.getValue().getDepartureId();
                        if (departureId != null && (direction = this.internalState.getValue().getDirection()) != null) {
                            List<FerrySeatId> selectedSeats = getState().getValue().getSelectedSeats();
                            if (getState().getValue().getSelectedSeats().size() < getState().getValue().getSeatsToBeSelected()) {
                                return new ManagerResult.Error.ErrorString(null, this.stringsProvider.getSelectSeatNotEnoughSeatsSelected(), 1, null);
                            }
                            SeatReservationId seatReservationId5 = getState().getValue().getSeatReservationId();
                            if (seatReservationId5 != null) {
                                SelectSeatingHandlerInterface selectSeatingHandlerInterface = this.selectSeatingHandler;
                                selectSeatingManager$reserve$1.L$0 = this;
                                selectSeatingManager$reserve$1.L$1 = direction;
                                selectSeatingManager$reserve$1.L$2 = selectedSeats;
                                selectSeatingManager$reserve$1.L$3 = seatReservationId5;
                                selectSeatingManager$reserve$1.label = 1;
                                if (selectSeatingHandlerInterface.updateReservedSeats(seatReservationId5, selectedSeats, selectSeatingManager$reserve$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                departureDirection2 = direction;
                                list2 = selectedSeats;
                                seatReservationId = seatReservationId5;
                                selectSeatingManager2 = this;
                                ArrayList arrayList2 = new ArrayList();
                                Iterator it3 = list2.iterator();
                                selectSeatingManager3 = selectSeatingManager2;
                                list3 = list2;
                                collection = arrayList2;
                                departureDirection3 = departureDirection2;
                                seatReservationId2 = seatReservationId;
                                it = it3;
                            } else {
                                SelectSeatingHandlerInterface selectSeatingHandlerInterface2 = this.selectSeatingHandler;
                                selectSeatingManager$reserve$1.L$0 = this;
                                selectSeatingManager$reserve$1.L$1 = direction;
                                selectSeatingManager$reserve$1.L$2 = selectedSeats;
                                selectSeatingManager$reserve$1.label = 2;
                                obj = selectSeatingHandlerInterface2.reserveSeats(departureId, selectedSeats, selectSeatingManager$reserve$1);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                selectSeatingManager = this;
                                departureDirection = direction;
                                list = selectedSeats;
                                selectSeatingManager2 = selectSeatingManager;
                                departureDirection2 = departureDirection;
                                list2 = list;
                                seatReservationId = (SeatReservationId) obj;
                                ArrayList arrayList22 = new ArrayList();
                                Iterator it32 = list2.iterator();
                                selectSeatingManager3 = selectSeatingManager2;
                                list3 = list2;
                                collection = arrayList22;
                                departureDirection3 = departureDirection2;
                                seatReservationId2 = seatReservationId;
                                it = it32;
                            }
                        }
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    if (i5 == 1) {
                        seatReservationId = (SeatReservationId) selectSeatingManager$reserve$1.L$3;
                        list2 = (List) selectSeatingManager$reserve$1.L$2;
                        departureDirection2 = (DepartureDirection) selectSeatingManager$reserve$1.L$1;
                        selectSeatingManager2 = (SelectSeatingManager) selectSeatingManager$reserve$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        ArrayList arrayList222 = new ArrayList();
                        Iterator it322 = list2.iterator();
                        selectSeatingManager3 = selectSeatingManager2;
                        list3 = list2;
                        collection = arrayList222;
                        departureDirection3 = departureDirection2;
                        seatReservationId2 = seatReservationId;
                        it = it322;
                    } else if (i5 == 2) {
                        list = (List) selectSeatingManager$reserve$1.L$2;
                        departureDirection = (DepartureDirection) selectSeatingManager$reserve$1.L$1;
                        selectSeatingManager = (SelectSeatingManager) selectSeatingManager$reserve$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        selectSeatingManager2 = selectSeatingManager;
                        departureDirection2 = departureDirection;
                        list2 = list;
                        seatReservationId = (SeatReservationId) obj;
                        ArrayList arrayList2222 = new ArrayList();
                        Iterator it3222 = list2.iterator();
                        selectSeatingManager3 = selectSeatingManager2;
                        list3 = list2;
                        collection = arrayList2222;
                        departureDirection3 = departureDirection2;
                        seatReservationId2 = seatReservationId;
                        it = it3222;
                    } else if (i5 == 3) {
                        it = (Iterator) selectSeatingManager$reserve$1.L$5;
                        collection = (Collection) selectSeatingManager$reserve$1.L$4;
                        seatReservationId2 = (SeatReservationId) selectSeatingManager$reserve$1.L$3;
                        list3 = (List) selectSeatingManager$reserve$1.L$2;
                        departureDirection3 = (DepartureDirection) selectSeatingManager$reserve$1.L$1;
                        selectSeatingManager3 = (SelectSeatingManager) selectSeatingManager$reserve$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        ferrySeat = (FerrySeat) obj;
                        if (ferrySeat != null) {
                            collection.add(ferrySeat);
                        }
                    } else {
                        if (i5 != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i8 = selectSeatingManager$reserve$1.I$0;
                        it2 = (Iterator) selectSeatingManager$reserve$1.L$8;
                        ?? r8 = (Collection) selectSeatingManager$reserve$1.L$7;
                        ISelectSeatingManager.SeatReservationState seatReservationState3 = (ISelectSeatingManager.SeatReservationState) selectSeatingManager$reserve$1.L$6;
                        seatReservationId4 = (SeatReservationId) selectSeatingManager$reserve$1.L$5;
                        ?? r11 = selectSeatingManager$reserve$1.L$4;
                        MutableStateFlow<ISelectSeatingManager.SeatReservationState> mutableStateFlow = (MutableStateFlow) selectSeatingManager$reserve$1.L$3;
                        SeatReservationId seatReservationId6 = (SeatReservationId) selectSeatingManager$reserve$1.L$2;
                        List<FerrySeatId> list5 = (List) selectSeatingManager$reserve$1.L$1;
                        SelectSeatingManager selectSeatingManager4 = (SelectSeatingManager) selectSeatingManager$reserve$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        i6 = i8;
                        seatReservationState2 = seatReservationState3;
                        List<FerrySeatId> list6 = list5;
                        seatReservationId3 = seatReservationId6;
                        seatReservationState = r11;
                        arrayList = r8;
                        FerrySeat ferrySeat2 = (FerrySeat) obj;
                        if (ferrySeat2 != null) {
                            arrayList.add(ferrySeat2);
                        }
                        state = mutableStateFlow;
                        selectSeatingManager3 = selectSeatingManager4;
                        list4 = list6;
                        while (!it2.hasNext()) {
                            ISelectSeatingManager.SeatReservationState seatReservationState4 = seatReservationState2;
                            SelectSeatingManager selectSeatingManager5 = selectSeatingManager3;
                            if (state.compareAndSet(seatReservationState, ISelectSeatingManager.SeatReservationState.copy$default(seatReservationState4, i6, null, seatReservationId4, arrayList, 3, null))) {
                                return new ManagerResult.Success(Unit.INSTANCE);
                            }
                            selectSeatingManager3 = selectSeatingManager5;
                            SeatReservationId seatReservationId7 = seatReservationId3;
                            List<FerrySeatId> list7 = list4;
                            ISelectSeatingManager.SeatReservationState value = state.getValue();
                            arrayList = new ArrayList();
                            seatReservationState = value;
                            seatReservationState2 = value;
                            it2 = list7.iterator();
                            seatReservationId3 = seatReservationId7;
                            list4 = list7;
                            i6 = 0;
                            seatReservationId4 = seatReservationId3;
                        }
                        FerrySeatId ferrySeatId = (FerrySeatId) it2.next();
                        selectSeatingManager$reserve$1.L$0 = selectSeatingManager3;
                        selectSeatingManager$reserve$1.L$1 = list4;
                        selectSeatingManager$reserve$1.L$2 = seatReservationId3;
                        selectSeatingManager$reserve$1.L$3 = state;
                        selectSeatingManager$reserve$1.L$4 = seatReservationState;
                        selectSeatingManager$reserve$1.L$5 = seatReservationId4;
                        selectSeatingManager$reserve$1.L$6 = seatReservationState2;
                        selectSeatingManager$reserve$1.L$7 = arrayList;
                        selectSeatingManager$reserve$1.L$8 = it2;
                        selectSeatingManager$reserve$1.I$0 = i6;
                        selectSeatingManager$reserve$1.label = 4;
                        findSeat = selectSeatingManager3.findSeat(ferrySeatId, selectSeatingManager$reserve$1);
                        if (findSeat == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        SelectSeatingManager selectSeatingManager6 = selectSeatingManager3;
                        mutableStateFlow = state;
                        obj = findSeat;
                        list6 = list4;
                        selectSeatingManager4 = selectSeatingManager6;
                        FerrySeat ferrySeat22 = (FerrySeat) obj;
                        if (ferrySeat22 != null) {
                        }
                        state = mutableStateFlow;
                        selectSeatingManager3 = selectSeatingManager4;
                        list4 = list6;
                        while (!it2.hasNext()) {
                        }
                        FerrySeatId ferrySeatId2 = (FerrySeatId) it2.next();
                        selectSeatingManager$reserve$1.L$0 = selectSeatingManager3;
                        selectSeatingManager$reserve$1.L$1 = list4;
                        selectSeatingManager$reserve$1.L$2 = seatReservationId3;
                        selectSeatingManager$reserve$1.L$3 = state;
                        selectSeatingManager$reserve$1.L$4 = seatReservationState;
                        selectSeatingManager$reserve$1.L$5 = seatReservationId4;
                        selectSeatingManager$reserve$1.L$6 = seatReservationState2;
                        selectSeatingManager$reserve$1.L$7 = arrayList;
                        selectSeatingManager$reserve$1.L$8 = it2;
                        selectSeatingManager$reserve$1.I$0 = i6;
                        selectSeatingManager$reserve$1.label = 4;
                        findSeat = selectSeatingManager3.findSeat(ferrySeatId2, selectSeatingManager$reserve$1);
                        if (findSeat == coroutine_suspended) {
                        }
                    }
                    if (it.hasNext()) {
                        FerrySeatId ferrySeatId3 = (FerrySeatId) it.next();
                        selectSeatingManager$reserve$1.L$0 = selectSeatingManager3;
                        selectSeatingManager$reserve$1.L$1 = departureDirection3;
                        selectSeatingManager$reserve$1.L$2 = list3;
                        selectSeatingManager$reserve$1.L$3 = seatReservationId2;
                        selectSeatingManager$reserve$1.L$4 = collection;
                        selectSeatingManager$reserve$1.L$5 = it;
                        selectSeatingManager$reserve$1.label = 3;
                        obj = selectSeatingManager3.findSeat(ferrySeatId3, selectSeatingManager$reserve$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ferrySeat = (FerrySeat) obj;
                        if (ferrySeat != null) {
                        }
                        if (it.hasNext()) {
                            selectSeatingManager3.checkoutManager.setSeatReservation(new CheckoutSeatReservation(seatReservationId2, (List) collection, false), departureDirection3);
                            state = selectSeatingManager3.getState();
                            ISelectSeatingManager.SeatReservationState value2 = state.getValue();
                            arrayList = new ArrayList();
                            seatReservationState = value2;
                            seatReservationState2 = value2;
                            it2 = list3.iterator();
                            seatReservationId3 = seatReservationId2;
                            list4 = list3;
                            i6 = 0;
                            seatReservationId4 = seatReservationId3;
                            while (!it2.hasNext()) {
                            }
                            FerrySeatId ferrySeatId22 = (FerrySeatId) it2.next();
                            selectSeatingManager$reserve$1.L$0 = selectSeatingManager3;
                            selectSeatingManager$reserve$1.L$1 = list4;
                            selectSeatingManager$reserve$1.L$2 = seatReservationId3;
                            selectSeatingManager$reserve$1.L$3 = state;
                            selectSeatingManager$reserve$1.L$4 = seatReservationState;
                            selectSeatingManager$reserve$1.L$5 = seatReservationId4;
                            selectSeatingManager$reserve$1.L$6 = seatReservationState2;
                            selectSeatingManager$reserve$1.L$7 = arrayList;
                            selectSeatingManager$reserve$1.L$8 = it2;
                            selectSeatingManager$reserve$1.I$0 = i6;
                            selectSeatingManager$reserve$1.label = 4;
                            findSeat = selectSeatingManager3.findSeat(ferrySeatId22, selectSeatingManager$reserve$1);
                            if (findSeat == coroutine_suspended) {
                            }
                        }
                    }
                }
            }
            if (i5 != 0) {
            }
            if (it.hasNext()) {
            }
        } catch (SelectSeatingHandlerException e5) {
            if (!(e5 instanceof SelectSeatingHandlerException.NoFloorsException) && !(e5 instanceof SelectSeatingHandlerException.ServiceException)) {
                throw new NoWhenBranchMatchedException();
            }
            ManagerResult.Error.Companion companion = ManagerResult.Error.INSTANCE;
            companion.noMessage();
            return companion.noMessage();
        }
        selectSeatingManager$reserve$1 = new SelectSeatingManager$reserve$1(this, continuation);
        Object obj2 = selectSeatingManager$reserve$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = selectSeatingManager$reserve$1.label;
    }

    @Override // dk.molslinjen.domain.managers.seating.ISelectSeatingManager
    public void resetChanges() {
        ISelectSeatingManager.SeatReservationState value;
        ISelectSeatingManager.SeatReservationState seatReservationState;
        ArrayList arrayList;
        MutableStateFlow<ISelectSeatingManager.SeatReservationState> state = getState();
        do {
            value = state.getValue();
            seatReservationState = value;
            List<FerrySeat> reservedSeats = seatReservationState.getReservedSeats();
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(reservedSeats, 10));
            Iterator<T> it = reservedSeats.iterator();
            while (it.hasNext()) {
                arrayList.add(((FerrySeat) it.next()).getId());
            }
        } while (!state.compareAndSet(value, ISelectSeatingManager.SeatReservationState.copy$default(seatReservationState, 0, arrayList, null, null, 13, null)));
    }

    @Override // dk.molslinjen.domain.managers.seating.ISelectSeatingManager
    public Object synchronizeSeatSelection(DepartureDirection departureDirection, Continuation<? super ManagerResult<Unit>> continuation) {
        ISelectSeatingManager.SeatReservationState value;
        FerryFloorPlan value2;
        FerryFloorPlan ferryFloorPlan;
        SeatReservationManagerInternalState value3;
        List<FerrySeat> emptyList;
        ISelectSeatingManager.SeatReservationState value4;
        ISelectSeatingManager.SeatReservationState seatReservationState;
        SeatReservationId id;
        ArrayList arrayList;
        CheckoutManager.CheckoutDirectionState value5 = this.checkoutManager.directionState(departureDirection).getValue();
        if (value5 == null) {
            return ManagerResult.Error.INSTANCE.noMessage();
        }
        DepartureId departureId = new DepartureId(value5.getDeparture().getId());
        MutableStateFlow<ISelectSeatingManager.SeatReservationState> state = getState();
        do {
            value = state.getValue();
        } while (!state.compareAndSet(value, ISelectSeatingManager.SeatReservationState.copy$default(value, value5.getPassengers().size(), null, null, null, 14, null)));
        MutableStateFlow<FerryFloorPlan> selectedFloorPlan = getSelectedFloorPlan();
        do {
            value2 = selectedFloorPlan.getValue();
            ferryFloorPlan = value2;
            if (!Intrinsics.areEqual(this.internalState.getValue().getDepartureId(), departureId)) {
                ferryFloorPlan = null;
            }
        } while (!selectedFloorPlan.compareAndSet(value2, ferryFloorPlan));
        MutableStateFlow<SeatReservationManagerInternalState> mutableStateFlow = this.internalState;
        do {
            value3 = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value3, value3.copy(departureId, departureDirection)));
        CheckoutSeatReservation seatReservation = value5.getSeatReservation();
        UnavailableSeatReservation unavailableSeatReservation = value5.getUnavailableSeatReservation();
        if (unavailableSeatReservation instanceof UnavailableSeatReservation.Invalid) {
            return unReserve(((UnavailableSeatReservation.Invalid) unavailableSeatReservation).getReservation().getId(), continuation);
        }
        if (seatReservation == null || (emptyList = seatReservation.getSeats()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        List<FerrySeat> list = emptyList;
        MutableStateFlow<ISelectSeatingManager.SeatReservationState> state2 = getState();
        do {
            value4 = state2.getValue();
            seatReservationState = value4;
            CheckoutSeatReservation seatReservation2 = value5.getSeatReservation();
            id = seatReservation2 != null ? seatReservation2.getId() : null;
            List<FerrySeat> list2 = list;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((FerrySeat) it.next()).getId());
            }
        } while (!state2.compareAndSet(value4, ISelectSeatingManager.SeatReservationState.copy$default(seatReservationState, 0, arrayList, id, list, 1, null)));
        return new ManagerResult.Success(Unit.INSTANCE);
    }

    @Override // dk.molslinjen.domain.managers.seating.ISelectSeatingManager
    public SelectSeatingManagerError.SeatLimitReached toggleSeat(FerrySeatId id) {
        ISelectSeatingManager.SeatReservationState value;
        ISelectSeatingManager.SeatReservationState seatReservationState;
        ISelectSeatingManager.SeatReservationState value2;
        ISelectSeatingManager.SeatReservationState seatReservationState2;
        Intrinsics.checkNotNullParameter(id, "id");
        if (getState().getValue().getSelectedSeats().contains(id)) {
            MutableStateFlow<ISelectSeatingManager.SeatReservationState> state = getState();
            do {
                value2 = state.getValue();
                seatReservationState2 = value2;
            } while (!state.compareAndSet(value2, ISelectSeatingManager.SeatReservationState.copy$default(seatReservationState2, 0, CollectionsKt.minus(seatReservationState2.getSelectedSeats(), id), null, null, 13, null)));
            return null;
        }
        if (getState().getValue().getSelectedSeats().size() >= getState().getValue().getSeatsToBeSelected()) {
            return SelectSeatingManagerError.SeatLimitReached.INSTANCE;
        }
        MutableStateFlow<ISelectSeatingManager.SeatReservationState> state2 = getState();
        do {
            value = state2.getValue();
            seatReservationState = value;
        } while (!state2.compareAndSet(value, ISelectSeatingManager.SeatReservationState.copy$default(seatReservationState, 0, CollectionsKt.plus((Collection<? extends FerrySeatId>) seatReservationState.getSelectedSeats(), id), null, null, 13, null)));
        return null;
    }

    @Override // dk.molslinjen.domain.managers.seating.ISelectSeatingManager
    public Object unreserve(Continuation<? super ManagerResult<Unit>> continuation) {
        SeatReservationId seatReservationId = getState().getValue().getSeatReservationId();
        return seatReservationId == null ? ManagerResult.Error.INSTANCE.noMessage() : unReserve(seatReservationId, continuation);
    }

    @Override // dk.molslinjen.domain.managers.seating.ISelectSeatingManager
    public MutableStateFlow<FerryFloorPlan> getSelectedFloorPlan() {
        return this.selectedFloorPlan;
    }

    @Override // dk.molslinjen.domain.managers.seating.ISelectSeatingManager
    public MutableStateFlow<ISelectSeatingManager.SeatReservationState> getState() {
        return this.state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Ldk/molslinjen/domain/managers/seating/SelectSeatingManager$SeatReservationManagerInternalState;", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/DepartureId;", "departureId", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "direction", "<init>", "(Luniffi/molslinjen_shared/DepartureId;Ldk/molslinjen/domain/model/booking/DepartureDirection;)V", "copy", "(Luniffi/molslinjen_shared/DepartureId;Ldk/molslinjen/domain/model/booking/DepartureDirection;)Ldk/molslinjen/domain/managers/seating/SelectSeatingManager$SeatReservationManagerInternalState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Luniffi/molslinjen_shared/DepartureId;", "getDepartureId", "()Luniffi/molslinjen_shared/DepartureId;", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "getDirection", "()Ldk/molslinjen/domain/model/booking/DepartureDirection;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class SeatReservationManagerInternalState {
        private final DepartureId departureId;
        private final DepartureDirection direction;

        public SeatReservationManagerInternalState(DepartureId departureId, DepartureDirection departureDirection) {
            this.departureId = departureId;
            this.direction = departureDirection;
        }

        public final SeatReservationManagerInternalState copy(DepartureId departureId, DepartureDirection direction) {
            return new SeatReservationManagerInternalState(departureId, direction);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SeatReservationManagerInternalState)) {
                return false;
            }
            SeatReservationManagerInternalState seatReservationManagerInternalState = (SeatReservationManagerInternalState) other;
            return Intrinsics.areEqual(this.departureId, seatReservationManagerInternalState.departureId) && this.direction == seatReservationManagerInternalState.direction;
        }

        public final DepartureId getDepartureId() {
            return this.departureId;
        }

        public final DepartureDirection getDirection() {
            return this.direction;
        }

        public int hashCode() {
            DepartureId departureId = this.departureId;
            int hashCode = (departureId == null ? 0 : departureId.hashCode()) * 31;
            DepartureDirection departureDirection = this.direction;
            return hashCode + (departureDirection != null ? departureDirection.hashCode() : 0);
        }

        public String toString() {
            return "SeatReservationManagerInternalState(departureId=" + this.departureId + ", direction=" + this.direction + ")";
        }

        public /* synthetic */ SeatReservationManagerInternalState(DepartureId departureId, DepartureDirection departureDirection, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? null : departureId, (i5 & 2) != 0 ? null : departureDirection);
        }
    }
}
