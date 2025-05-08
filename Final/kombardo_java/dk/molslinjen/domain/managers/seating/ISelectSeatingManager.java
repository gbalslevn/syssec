package dk.molslinjen.domain.managers.seating;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.seating.SelectSeatingManagerError;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FerryFloorPlan;
import uniffi.molslinjen_shared.FerrySeat;
import uniffi.molslinjen_shared.FerrySeatId;
import uniffi.molslinjen_shared.FerrySeatingSection;
import uniffi.molslinjen_shared.SeatReservationId;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\"J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\b\u0010\u0007J$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH¦@¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fH¦@¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\nH&¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H¦@¢\u0006\u0004\b\u0016\u0010\u0011J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H¦@¢\u0006\u0004\b\u0017\u0010\u0011J\u000f\u0010\u0018\u001a\u00020\u0005H&¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001a8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001a8&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001d¨\u0006#"}, d2 = {"Ldk/molslinjen/domain/managers/seating/ISelectSeatingManager;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "direction", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "synchronizeSeatSelection", "(Ldk/molslinjen/domain/model/booking/DepartureDirection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchFloorPlan", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/FerrySeatId;", "selectedSeats", "Luniffi/molslinjen_shared/FerrySeat;", "getSeats", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Luniffi/molslinjen_shared/FerrySeatingSection;", "activeSection", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", Constants.ID_ATTRIBUTE_KEY, "Ldk/molslinjen/domain/managers/seating/SelectSeatingManagerError$SeatLimitReached;", "toggleSeat", "(Luniffi/molslinjen_shared/FerrySeatId;)Ldk/molslinjen/domain/managers/seating/SelectSeatingManagerError$SeatLimitReached;", "reserve", "unreserve", "resetChanges", "()V", "Lkotlinx/coroutines/flow/StateFlow;", "Luniffi/molslinjen_shared/FerryFloorPlan;", "getSelectedFloorPlan", "()Lkotlinx/coroutines/flow/StateFlow;", "selectedFloorPlan", "Ldk/molslinjen/domain/managers/seating/ISelectSeatingManager$SeatReservationState;", "getState", "state", "SeatReservationState", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ISelectSeatingManager {
    Object activeSection(Continuation<? super FerrySeatingSection> continuation);

    Object fetchFloorPlan(DepartureDirection departureDirection, Continuation<? super ManagerResult<Unit>> continuation);

    Object getSeats(List<FerrySeatId> list, Continuation<? super List<FerrySeat>> continuation);

    StateFlow<FerryFloorPlan> getSelectedFloorPlan();

    StateFlow<SeatReservationState> getState();

    Object reserve(Continuation<? super ManagerResult<Unit>> continuation);

    void resetChanges();

    Object synchronizeSeatSelection(DepartureDirection departureDirection, Continuation<? super ManagerResult<Unit>> continuation);

    SelectSeatingManagerError.SeatLimitReached toggleSeat(FerrySeatId id);

    Object unreserve(Continuation<? super ManagerResult<Unit>> continuation);

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\u000b\u0010\fJF\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u0013R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b \u0010\u001c¨\u0006!"}, d2 = {"Ldk/molslinjen/domain/managers/seating/ISelectSeatingManager$SeatReservationState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "seatsToBeSelected", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/FerrySeatId;", "selectedSeats", "Luniffi/molslinjen_shared/SeatReservationId;", "seatReservationId", "Luniffi/molslinjen_shared/FerrySeat;", "reservedSeats", "<init>", "(ILjava/util/List;Luniffi/molslinjen_shared/SeatReservationId;Ljava/util/List;)V", "copy", "(ILjava/util/List;Luniffi/molslinjen_shared/SeatReservationId;Ljava/util/List;)Ldk/molslinjen/domain/managers/seating/ISelectSeatingManager$SeatReservationState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "I", "getSeatsToBeSelected", "Ljava/util/List;", "getSelectedSeats", "()Ljava/util/List;", "Luniffi/molslinjen_shared/SeatReservationId;", "getSeatReservationId", "()Luniffi/molslinjen_shared/SeatReservationId;", "getReservedSeats", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class SeatReservationState {
        private final List<FerrySeat> reservedSeats;
        private final SeatReservationId seatReservationId;
        private final int seatsToBeSelected;
        private final List<FerrySeatId> selectedSeats;

        public SeatReservationState(int i5, List<FerrySeatId> selectedSeats, SeatReservationId seatReservationId, List<FerrySeat> reservedSeats) {
            Intrinsics.checkNotNullParameter(selectedSeats, "selectedSeats");
            Intrinsics.checkNotNullParameter(reservedSeats, "reservedSeats");
            this.seatsToBeSelected = i5;
            this.selectedSeats = selectedSeats;
            this.seatReservationId = seatReservationId;
            this.reservedSeats = reservedSeats;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SeatReservationState copy$default(SeatReservationState seatReservationState, int i5, List list, SeatReservationId seatReservationId, List list2, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i5 = seatReservationState.seatsToBeSelected;
            }
            if ((i6 & 2) != 0) {
                list = seatReservationState.selectedSeats;
            }
            if ((i6 & 4) != 0) {
                seatReservationId = seatReservationState.seatReservationId;
            }
            if ((i6 & 8) != 0) {
                list2 = seatReservationState.reservedSeats;
            }
            return seatReservationState.copy(i5, list, seatReservationId, list2);
        }

        public final SeatReservationState copy(int seatsToBeSelected, List<FerrySeatId> selectedSeats, SeatReservationId seatReservationId, List<FerrySeat> reservedSeats) {
            Intrinsics.checkNotNullParameter(selectedSeats, "selectedSeats");
            Intrinsics.checkNotNullParameter(reservedSeats, "reservedSeats");
            return new SeatReservationState(seatsToBeSelected, selectedSeats, seatReservationId, reservedSeats);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SeatReservationState)) {
                return false;
            }
            SeatReservationState seatReservationState = (SeatReservationState) other;
            return this.seatsToBeSelected == seatReservationState.seatsToBeSelected && Intrinsics.areEqual(this.selectedSeats, seatReservationState.selectedSeats) && Intrinsics.areEqual(this.seatReservationId, seatReservationState.seatReservationId) && Intrinsics.areEqual(this.reservedSeats, seatReservationState.reservedSeats);
        }

        public final List<FerrySeat> getReservedSeats() {
            return this.reservedSeats;
        }

        public final SeatReservationId getSeatReservationId() {
            return this.seatReservationId;
        }

        public final int getSeatsToBeSelected() {
            return this.seatsToBeSelected;
        }

        public final List<FerrySeatId> getSelectedSeats() {
            return this.selectedSeats;
        }

        public int hashCode() {
            int hashCode = ((Integer.hashCode(this.seatsToBeSelected) * 31) + this.selectedSeats.hashCode()) * 31;
            SeatReservationId seatReservationId = this.seatReservationId;
            return ((hashCode + (seatReservationId == null ? 0 : seatReservationId.hashCode())) * 31) + this.reservedSeats.hashCode();
        }

        public String toString() {
            return "SeatReservationState(seatsToBeSelected=" + this.seatsToBeSelected + ", selectedSeats=" + this.selectedSeats + ", seatReservationId=" + this.seatReservationId + ", reservedSeats=" + this.reservedSeats + ")";
        }

        public /* synthetic */ SeatReservationState(int i5, List list, SeatReservationId seatReservationId, List list2, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this((i6 & 1) != 0 ? 0 : i5, (i6 & 2) != 0 ? CollectionsKt.emptyList() : list, (i6 & 4) != 0 ? null : seatReservationId, (i6 & 8) != 0 ? CollectionsKt.emptyList() : list2);
        }
    }
}
