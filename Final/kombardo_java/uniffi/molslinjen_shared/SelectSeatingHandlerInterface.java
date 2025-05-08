package uniffi.molslinjen_shared;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018J7\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\rJ'\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J'\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Luniffi/molslinjen_shared/SelectSeatingHandlerInterface;", BuildConfig.FLAVOR, "getFloorPlan", "Luniffi/molslinjen_shared/FerryFloorPlan;", "departureId", "Luniffi/molslinjen_shared/DepartureId;", "ferryName", BuildConfig.FLAVOR, "currency", "Luniffi/molslinjen_shared/Currency;", "reservedSeats", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/FerrySeatId;", "(Luniffi/molslinjen_shared/DepartureId;Ljava/lang/String;Luniffi/molslinjen_shared/Currency;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reserveSeats", "Luniffi/molslinjen_shared/SeatReservationId;", "seatIds", "(Luniffi/molslinjen_shared/DepartureId;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unReserveSeats", BuildConfig.FLAVOR, "seatReservationId", "(Luniffi/molslinjen_shared/SeatReservationId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateReservedSeats", "(Luniffi/molslinjen_shared/SeatReservationId;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface SelectSeatingHandlerInterface {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Luniffi/molslinjen_shared/SelectSeatingHandlerInterface$Companion;", BuildConfig.FLAVOR, "()V", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    Object getFloorPlan(DepartureId departureId, String str, Currency currency, List<FerrySeatId> list, Continuation<? super FerryFloorPlan> continuation);

    Object reserveSeats(DepartureId departureId, List<FerrySeatId> list, Continuation<? super SeatReservationId> continuation);

    Object unReserveSeats(SeatReservationId seatReservationId, Continuation<? super Unit> continuation);

    Object updateReservedSeats(SeatReservationId seatReservationId, List<FerrySeatId> list, Continuation<? super Unit> continuation);
}
