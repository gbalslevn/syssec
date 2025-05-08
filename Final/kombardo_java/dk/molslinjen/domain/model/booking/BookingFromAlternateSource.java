package dk.molslinjen.domain.model.booking;

import dk.molslinjen.domain.model.agreement.commuter.bornholm.BornholmCommuterBooking;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideBookingTicket;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Ldk/molslinjen/domain/model/booking/BookingFromAlternateSource;", BuildConfig.FLAVOR, "reservationNumber", BuildConfig.FLAVOR, "phone", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "commuterBooking", "Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterBooking;", "(Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterBooking;)V", "getReservationNumber", "()Ljava/lang/String;", "getPhone", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class BookingFromAlternateSource {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String phone;
    private final String reservationNumber;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/BookingFromAlternateSource$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "from", "Ldk/molslinjen/domain/model/booking/BookingFromAlternateSource;", "multiRideBookingTicket", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideBookingTicket;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BookingFromAlternateSource from(MultiRideBookingTicket multiRideBookingTicket) {
            Intrinsics.checkNotNullParameter(multiRideBookingTicket, "multiRideBookingTicket");
            if (multiRideBookingTicket.getPhone() == null) {
                return null;
            }
            return new BookingFromAlternateSource(multiRideBookingTicket.getReservationNumber(), multiRideBookingTicket.getPhone());
        }

        private Companion() {
        }
    }

    public BookingFromAlternateSource(String reservationNumber, String phone) {
        Intrinsics.checkNotNullParameter(reservationNumber, "reservationNumber");
        Intrinsics.checkNotNullParameter(phone, "phone");
        this.reservationNumber = reservationNumber;
        this.phone = phone;
    }

    public static /* synthetic */ BookingFromAlternateSource copy$default(BookingFromAlternateSource bookingFromAlternateSource, String str, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = bookingFromAlternateSource.reservationNumber;
        }
        if ((i5 & 2) != 0) {
            str2 = bookingFromAlternateSource.phone;
        }
        return bookingFromAlternateSource.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getReservationNumber() {
        return this.reservationNumber;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    public final BookingFromAlternateSource copy(String reservationNumber, String phone) {
        Intrinsics.checkNotNullParameter(reservationNumber, "reservationNumber");
        Intrinsics.checkNotNullParameter(phone, "phone");
        return new BookingFromAlternateSource(reservationNumber, phone);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BookingFromAlternateSource)) {
            return false;
        }
        BookingFromAlternateSource bookingFromAlternateSource = (BookingFromAlternateSource) other;
        return Intrinsics.areEqual(this.reservationNumber, bookingFromAlternateSource.reservationNumber) && Intrinsics.areEqual(this.phone, bookingFromAlternateSource.phone);
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getReservationNumber() {
        return this.reservationNumber;
    }

    public int hashCode() {
        return (this.reservationNumber.hashCode() * 31) + this.phone.hashCode();
    }

    public String toString() {
        return "BookingFromAlternateSource(reservationNumber=" + this.reservationNumber + ", phone=" + this.phone + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BookingFromAlternateSource(BornholmCommuterBooking commuterBooking) {
        this(commuterBooking.getReservationNumber(), commuterBooking.getPhone());
        Intrinsics.checkNotNullParameter(commuterBooking, "commuterBooking");
    }
}
