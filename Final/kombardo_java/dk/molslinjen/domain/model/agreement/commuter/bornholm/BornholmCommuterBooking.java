package dk.molslinjen.domain.model.agreement.commuter.bornholm;

import dk.molslinjen.api.services.commuter.bornholm.response.BornholmCommuterBookingResponseDTO;
import dk.molslinjen.domain.model.agreement.IAgreementDeparture;
import dk.molslinjen.domain.model.agreement.commuter.CommuterTicket;
import dk.molslinjen.domain.model.booking.Ferry;
import dk.molslinjen.domain.model.booking.RouteType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 >2\u00020\u0001:\u0001>B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0007HÆ\u0003J\t\u00106\u001a\u00020\u0007HÆ\u0003J1\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u00108\u001a\u00020\u00032\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020<HÖ\u0001J\t\u0010=\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u0014\u0010!\u001a\u00020\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0014\u0010#\u001a\u00020$X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0013R\u0014\u0010)\u001a\u00020*X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0014\u00101\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0013¨\u0006?"}, d2 = {"Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterBooking;", "Ldk/molslinjen/domain/model/agreement/IAgreementDeparture;", "deleteAllowed", BuildConfig.FLAVOR, "outbound", "Ldk/molslinjen/domain/model/agreement/commuter/CommuterTicket;", "reservationNumber", BuildConfig.FLAVOR, "phone", "<init>", "(ZLdk/molslinjen/domain/model/agreement/commuter/CommuterTicket;Ljava/lang/String;Ljava/lang/String;)V", "dto", "Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterBookingResponseDTO;", "(Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterBookingResponseDTO;)V", "getDeleteAllowed", "()Z", "getOutbound", "()Ldk/molslinjen/domain/model/agreement/commuter/CommuterTicket;", "getReservationNumber", "()Ljava/lang/String;", "getPhone", "arrivalHarborName", "getArrivalHarborName", "date", "Lorg/threeten/bp/LocalDate;", "getDate", "()Lorg/threeten/bp/LocalDate;", "arrivalTime", "Lorg/threeten/bp/LocalTime;", "getArrivalTime", "()Lorg/threeten/bp/LocalTime;", "departureHarborName", "getDepartureHarborName", "departureTime", "getDepartureTime", "ferry", "Ldk/molslinjen/domain/model/booking/Ferry;", "getFerry", "()Ldk/molslinjen/domain/model/booking/Ferry;", "routeId", "getRouteId", "routeType", "Ldk/molslinjen/domain/model/booking/RouteType;", "getRouteType", "()Ldk/molslinjen/domain/model/booking/RouteType;", "travelTime", "Lorg/threeten/bp/Duration;", "getTravelTime", "()Lorg/threeten/bp/Duration;", "timeTableId", "getTimeTableId", "component1", "component2", "component3", "component4", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class BornholmCommuterBooking implements IAgreementDeparture {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final BornholmCommuterBooking mock = new BornholmCommuterBooking(true, CommuterTicket.INSTANCE.getMock(), "84631844", "12345678");
    private final String arrivalHarborName;
    private final LocalTime arrivalTime;
    private final LocalDate date;
    private final boolean deleteAllowed;
    private final String departureHarborName;
    private final LocalTime departureTime;
    private final Ferry ferry;
    private final CommuterTicket outbound;
    private final String phone;
    private final String reservationNumber;
    private final String routeId;
    private final RouteType routeType;
    private final String timeTableId;
    private final Duration travelTime;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterBooking$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterBooking;", "getMock", "()Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterBooking;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BornholmCommuterBooking getMock() {
            return BornholmCommuterBooking.mock;
        }

        private Companion() {
        }
    }

    public BornholmCommuterBooking(boolean z5, CommuterTicket outbound, String reservationNumber, String phone) {
        Intrinsics.checkNotNullParameter(outbound, "outbound");
        Intrinsics.checkNotNullParameter(reservationNumber, "reservationNumber");
        Intrinsics.checkNotNullParameter(phone, "phone");
        this.deleteAllowed = z5;
        this.outbound = outbound;
        this.reservationNumber = reservationNumber;
        this.phone = phone;
        this.arrivalHarborName = outbound.getArrivalHarborName();
        this.date = outbound.getDepartureDate();
        this.arrivalTime = outbound.getArrivalTime();
        this.departureHarborName = outbound.getDepartureHarborName();
        this.departureTime = outbound.getDepartureTime();
        this.ferry = new Ferry(null, null, null, getDepartureHarborName(), getArrivalHarborName(), outbound.getFerryName(), null);
        this.routeId = BuildConfig.FLAVOR;
        this.routeType = RouteType.Ferry;
        this.travelTime = outbound.getTravelTime();
        this.timeTableId = BuildConfig.FLAVOR;
    }

    public static /* synthetic */ BornholmCommuterBooking copy$default(BornholmCommuterBooking bornholmCommuterBooking, boolean z5, CommuterTicket commuterTicket, String str, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = bornholmCommuterBooking.deleteAllowed;
        }
        if ((i5 & 2) != 0) {
            commuterTicket = bornholmCommuterBooking.outbound;
        }
        if ((i5 & 4) != 0) {
            str = bornholmCommuterBooking.reservationNumber;
        }
        if ((i5 & 8) != 0) {
            str2 = bornholmCommuterBooking.phone;
        }
        return bornholmCommuterBooking.copy(z5, commuterTicket, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getDeleteAllowed() {
        return this.deleteAllowed;
    }

    /* renamed from: component2, reason: from getter */
    public final CommuterTicket getOutbound() {
        return this.outbound;
    }

    /* renamed from: component3, reason: from getter */
    public final String getReservationNumber() {
        return this.reservationNumber;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    public final BornholmCommuterBooking copy(boolean deleteAllowed, CommuterTicket outbound, String reservationNumber, String phone) {
        Intrinsics.checkNotNullParameter(outbound, "outbound");
        Intrinsics.checkNotNullParameter(reservationNumber, "reservationNumber");
        Intrinsics.checkNotNullParameter(phone, "phone");
        return new BornholmCommuterBooking(deleteAllowed, outbound, reservationNumber, phone);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BornholmCommuterBooking)) {
            return false;
        }
        BornholmCommuterBooking bornholmCommuterBooking = (BornholmCommuterBooking) other;
        return this.deleteAllowed == bornholmCommuterBooking.deleteAllowed && Intrinsics.areEqual(this.outbound, bornholmCommuterBooking.outbound) && Intrinsics.areEqual(this.reservationNumber, bornholmCommuterBooking.reservationNumber) && Intrinsics.areEqual(this.phone, bornholmCommuterBooking.phone);
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public String getArrivalHarborName() {
        return this.arrivalHarborName;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public LocalTime getArrivalTime() {
        return this.arrivalTime;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public LocalDate getDate() {
        return this.date;
    }

    public final boolean getDeleteAllowed() {
        return this.deleteAllowed;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public String getDepartureHarborName() {
        return this.departureHarborName;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public LocalTime getDepartureTime() {
        return this.departureTime;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public Ferry getFerry() {
        return this.ferry;
    }

    public final CommuterTicket getOutbound() {
        return this.outbound;
    }

    @Override // dk.molslinjen.domain.model.agreement.IAgreementDeparture
    public String getPhone() {
        return this.phone;
    }

    @Override // dk.molslinjen.domain.model.agreement.IAgreementDeparture
    public String getReservationNumber() {
        return this.reservationNumber;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public String getRouteId() {
        return this.routeId;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public RouteType getRouteType() {
        return this.routeType;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public String getTimeTableId() {
        return this.timeTableId;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public String getTransportSwitchDescription() {
        return IAgreementDeparture.DefaultImpls.getTransportSwitchDescription(this);
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public Duration getTravelTime() {
        return this.travelTime;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.deleteAllowed) * 31) + this.outbound.hashCode()) * 31) + this.reservationNumber.hashCode()) * 31) + this.phone.hashCode();
    }

    public String toString() {
        return "BornholmCommuterBooking(deleteAllowed=" + this.deleteAllowed + ", outbound=" + this.outbound + ", reservationNumber=" + this.reservationNumber + ", phone=" + this.phone + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BornholmCommuterBooking(BornholmCommuterBookingResponseDTO dto) {
        this(dto.getDeleteAllowed(), new CommuterTicket(dto.getOutbound()), dto.getReservationNumber(), dto.getTelephone());
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
