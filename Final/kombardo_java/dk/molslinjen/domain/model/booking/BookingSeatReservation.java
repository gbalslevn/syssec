package dk.molslinjen.domain.model.booking;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.booking.response.booking.BookingResponseDTO;
import dk.molslinjen.domain.extensions.domain.FerrySeatExtenstionsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FerrySeat;
import uniffi.molslinjen_shared.SeatReservationId;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Ldk/molslinjen/domain/model/booking/BookingSeatReservation;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "Luniffi/molslinjen_shared/SeatReservationId;", "seats", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/FerrySeat;", "<init>", "(Luniffi/molslinjen_shared/SeatReservationId;Ljava/util/List;)V", "dto", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BookingSeatReservationDTO;", "(Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BookingSeatReservationDTO;)V", "getId", "()Luniffi/molslinjen_shared/SeatReservationId;", "getSeats", "()Ljava/util/List;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class BookingSeatReservation {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final BookingSeatReservation mock;
    private final SeatReservationId id;
    private final List<FerrySeat> seats;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/BookingSeatReservation$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/BookingSeatReservation;", "getMock", "()Ldk/molslinjen/domain/model/booking/BookingSeatReservation;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BookingSeatReservation getMock() {
            return BookingSeatReservation.mock;
        }

        private Companion() {
        }
    }

    static {
        SeatReservationId seatReservationId = new SeatReservationId(123);
        FerrySeat.Companion companion = FerrySeat.INSTANCE;
        mock = new BookingSeatReservation(seatReservationId, CollectionsKt.listOf((Object[]) new FerrySeat[]{FerrySeatExtenstionsKt.mock(companion, 1), FerrySeatExtenstionsKt.mock(companion, 2), FerrySeatExtenstionsKt.mock(companion, 3), FerrySeatExtenstionsKt.mock(companion, 4), FerrySeatExtenstionsKt.mock(companion, 5), FerrySeatExtenstionsKt.mock(companion, 6), FerrySeatExtenstionsKt.mock(companion, 7)}));
    }

    public BookingSeatReservation(SeatReservationId id, List<FerrySeat> seats) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(seats, "seats");
        this.id = id;
        this.seats = seats;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BookingSeatReservation copy$default(BookingSeatReservation bookingSeatReservation, SeatReservationId seatReservationId, List list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            seatReservationId = bookingSeatReservation.id;
        }
        if ((i5 & 2) != 0) {
            list = bookingSeatReservation.seats;
        }
        return bookingSeatReservation.copy(seatReservationId, list);
    }

    /* renamed from: component1, reason: from getter */
    public final SeatReservationId getId() {
        return this.id;
    }

    public final List<FerrySeat> component2() {
        return this.seats;
    }

    public final BookingSeatReservation copy(SeatReservationId id, List<FerrySeat> seats) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(seats, "seats");
        return new BookingSeatReservation(id, seats);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BookingSeatReservation)) {
            return false;
        }
        BookingSeatReservation bookingSeatReservation = (BookingSeatReservation) other;
        return Intrinsics.areEqual(this.id, bookingSeatReservation.id) && Intrinsics.areEqual(this.seats, bookingSeatReservation.seats);
    }

    public final SeatReservationId getId() {
        return this.id;
    }

    public final List<FerrySeat> getSeats() {
        return this.seats;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.seats.hashCode();
    }

    public String toString() {
        return "BookingSeatReservation(id=" + this.id + ", seats=" + this.seats + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BookingSeatReservation(BookingResponseDTO.BookingSeatReservationDTO dto) {
        this(r0, r1);
        Intrinsics.checkNotNullParameter(dto, "dto");
        SeatReservationId seatReservationId = new SeatReservationId(dto.getSeatReservationId());
        List<BookingResponseDTO.BookingSeatDTO> seats = dto.getSeats();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(seats, 10));
        Iterator<T> it = seats.iterator();
        while (it.hasNext()) {
            arrayList.add(FerrySeatExtenstionsKt.invoke(FerrySeat.INSTANCE, (BookingResponseDTO.BookingSeatDTO) it.next()));
        }
    }
}
