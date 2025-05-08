package dk.molslinjen.domain.model.agreement.multiRide;

import dk.molslinjen.api.services.multiRide.response.MultiRideBookingTicketResponseDTO;
import dk.molslinjen.domain.model.agreement.IAgreementDeparture;
import dk.molslinjen.domain.model.booking.Ferry;
import dk.molslinjen.domain.model.booking.RouteType;
import dk.molslinjen.domain.model.config.Harbor;
import dk.molslinjen.domain.model.config.Region;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 K2\u00020\u0001:\u0001KBi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014B\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0004\b\u0013\u0010\u0017J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0006HÆ\u0003J\t\u0010<\u001a\u00020\bHÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0006HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u000eHÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0011HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0083\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010F\u001a\u00020\u000e2\b\u0010G\u001a\u0004\u0018\u00010HHÖ\u0003J\t\u0010I\u001a\u00020\u0011HÖ\u0001J\t\u0010J\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\t\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0014\u0010\u000b\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u0014\u0010)\u001a\u00020*X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0014\u00101\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0019R\u0014\u00103\u001a\u000204X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0014\u00107\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0019¨\u0006L"}, d2 = {"Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideBookingTicket;", "Ldk/molslinjen/domain/model/agreement/IAgreementDeparture;", "reservationNumber", BuildConfig.FLAVOR, "arrivalHarborName", "arrivalTime", "Lorg/threeten/bp/LocalTime;", "date", "Lorg/threeten/bp/LocalDate;", "departureHarborName", "departureRegionId", "departureTime", "ferryName", "noShow", BuildConfig.FLAVOR, "numberPlate", "passengers", BuildConfig.FLAVOR, "phone", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/LocalTime;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/LocalTime;Ljava/lang/String;ZLjava/lang/String;ILjava/lang/String;)V", "dto", "Ldk/molslinjen/api/services/multiRide/response/MultiRideBookingTicketResponseDTO;", "(Ldk/molslinjen/api/services/multiRide/response/MultiRideBookingTicketResponseDTO;)V", "getReservationNumber", "()Ljava/lang/String;", "getArrivalHarborName", "getArrivalTime", "()Lorg/threeten/bp/LocalTime;", "getDate", "()Lorg/threeten/bp/LocalDate;", "getDepartureHarborName", "getDepartureRegionId", "getDepartureTime", "getFerryName", "getNoShow", "()Z", "getNumberPlate", "getPassengers", "()I", "getPhone", "travelTime", "Lorg/threeten/bp/Duration;", "getTravelTime", "()Lorg/threeten/bp/Duration;", "ferry", "Ldk/molslinjen/domain/model/booking/Ferry;", "getFerry", "()Ldk/molslinjen/domain/model/booking/Ferry;", "routeId", "getRouteId", "routeType", "Ldk/molslinjen/domain/model/booking/RouteType;", "getRouteType", "()Ldk/molslinjen/domain/model/booking/RouteType;", "timeTableId", "getTimeTableId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class MultiRideBookingTicket implements IAgreementDeparture {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final MultiRideBookingTicket mock;
    private static final MultiRideBookingTicket mockNoDetails;
    private final String arrivalHarborName;
    private final LocalTime arrivalTime;
    private final LocalDate date;
    private final String departureHarborName;
    private final String departureRegionId;
    private final LocalTime departureTime;
    private final Ferry ferry;
    private final String ferryName;
    private final boolean noShow;
    private final String numberPlate;
    private final int passengers;
    private final String phone;
    private final String reservationNumber;
    private final String routeId;
    private final RouteType routeType;
    private final String timeTableId;
    private final Duration travelTime;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideBookingTicket$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideBookingTicket;", "getMock", "()Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideBookingTicket;", "mockNoDetails", "getMockNoDetails", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MultiRideBookingTicket getMock() {
            return MultiRideBookingTicket.mock;
        }

        public final MultiRideBookingTicket getMockNoDetails() {
            return MultiRideBookingTicket.mockNoDetails;
        }

        private Companion() {
        }
    }

    static {
        Harbor.Companion companion = Harbor.INSTANCE;
        String name = companion.getMockOdden().getName();
        LocalTime of = LocalTime.of(8, 55);
        Intrinsics.checkNotNullExpressionValue(of, "of(...)");
        LocalDate of2 = LocalDate.of(2023, 5, 18);
        Intrinsics.checkNotNullExpressionValue(of2, "of(...)");
        String name2 = companion.getMockAarhus().getName();
        Region.Companion companion2 = Region.INSTANCE;
        String id = companion2.getMockJutland().getId();
        LocalTime of3 = LocalTime.of(7, 40);
        Intrinsics.checkNotNullExpressionValue(of3, "of(...)");
        mock = new MultiRideBookingTicket("84326865", name, of, of2, name2, id, of3, "Express 4", false, "AB12345", 1, "004512345678");
        String name3 = companion.getMockOdden().getName();
        LocalTime of4 = LocalTime.of(8, 55);
        Intrinsics.checkNotNullExpressionValue(of4, "of(...)");
        LocalDate of5 = LocalDate.of(2023, 5, 18);
        Intrinsics.checkNotNullExpressionValue(of5, "of(...)");
        String name4 = companion.getMockAarhus().getName();
        String id2 = companion2.getMockJutland().getId();
        LocalTime of6 = LocalTime.of(7, 40);
        Intrinsics.checkNotNullExpressionValue(of6, "of(...)");
        mockNoDetails = new MultiRideBookingTicket("84326865", name3, of4, of5, name4, id2, of6, "Express 4", false, "AB12345", 1, null);
    }

    public MultiRideBookingTicket(String reservationNumber, String arrivalHarborName, LocalTime arrivalTime, LocalDate date, String departureHarborName, String departureRegionId, LocalTime departureTime, String ferryName, boolean z5, String numberPlate, int i5, String str) {
        Intrinsics.checkNotNullParameter(reservationNumber, "reservationNumber");
        Intrinsics.checkNotNullParameter(arrivalHarborName, "arrivalHarborName");
        Intrinsics.checkNotNullParameter(arrivalTime, "arrivalTime");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(departureHarborName, "departureHarborName");
        Intrinsics.checkNotNullParameter(departureRegionId, "departureRegionId");
        Intrinsics.checkNotNullParameter(departureTime, "departureTime");
        Intrinsics.checkNotNullParameter(ferryName, "ferryName");
        Intrinsics.checkNotNullParameter(numberPlate, "numberPlate");
        this.reservationNumber = reservationNumber;
        this.arrivalHarborName = arrivalHarborName;
        this.arrivalTime = arrivalTime;
        this.date = date;
        this.departureHarborName = departureHarborName;
        this.departureRegionId = departureRegionId;
        this.departureTime = departureTime;
        this.ferryName = ferryName;
        this.noShow = z5;
        this.numberPlate = numberPlate;
        this.passengers = i5;
        this.phone = str;
        Duration between = Duration.between(getDepartureTime(), getArrivalTime());
        Intrinsics.checkNotNullExpressionValue(between, "between(...)");
        this.travelTime = between;
        this.ferry = new Ferry(null, null, null, getDepartureHarborName(), getArrivalHarborName(), ferryName, null);
        this.routeId = BuildConfig.FLAVOR;
        this.routeType = RouteType.Ferry;
        this.timeTableId = BuildConfig.FLAVOR;
    }

    /* renamed from: component1, reason: from getter */
    public final String getReservationNumber() {
        return this.reservationNumber;
    }

    /* renamed from: component10, reason: from getter */
    public final String getNumberPlate() {
        return this.numberPlate;
    }

    /* renamed from: component11, reason: from getter */
    public final int getPassengers() {
        return this.passengers;
    }

    /* renamed from: component12, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* renamed from: component2, reason: from getter */
    public final String getArrivalHarborName() {
        return this.arrivalHarborName;
    }

    /* renamed from: component3, reason: from getter */
    public final LocalTime getArrivalTime() {
        return this.arrivalTime;
    }

    /* renamed from: component4, reason: from getter */
    public final LocalDate getDate() {
        return this.date;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDepartureHarborName() {
        return this.departureHarborName;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDepartureRegionId() {
        return this.departureRegionId;
    }

    /* renamed from: component7, reason: from getter */
    public final LocalTime getDepartureTime() {
        return this.departureTime;
    }

    /* renamed from: component8, reason: from getter */
    public final String getFerryName() {
        return this.ferryName;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getNoShow() {
        return this.noShow;
    }

    public final MultiRideBookingTicket copy(String reservationNumber, String arrivalHarborName, LocalTime arrivalTime, LocalDate date, String departureHarborName, String departureRegionId, LocalTime departureTime, String ferryName, boolean noShow, String numberPlate, int passengers, String phone) {
        Intrinsics.checkNotNullParameter(reservationNumber, "reservationNumber");
        Intrinsics.checkNotNullParameter(arrivalHarborName, "arrivalHarborName");
        Intrinsics.checkNotNullParameter(arrivalTime, "arrivalTime");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(departureHarborName, "departureHarborName");
        Intrinsics.checkNotNullParameter(departureRegionId, "departureRegionId");
        Intrinsics.checkNotNullParameter(departureTime, "departureTime");
        Intrinsics.checkNotNullParameter(ferryName, "ferryName");
        Intrinsics.checkNotNullParameter(numberPlate, "numberPlate");
        return new MultiRideBookingTicket(reservationNumber, arrivalHarborName, arrivalTime, date, departureHarborName, departureRegionId, departureTime, ferryName, noShow, numberPlate, passengers, phone);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiRideBookingTicket)) {
            return false;
        }
        MultiRideBookingTicket multiRideBookingTicket = (MultiRideBookingTicket) other;
        return Intrinsics.areEqual(this.reservationNumber, multiRideBookingTicket.reservationNumber) && Intrinsics.areEqual(this.arrivalHarborName, multiRideBookingTicket.arrivalHarborName) && Intrinsics.areEqual(this.arrivalTime, multiRideBookingTicket.arrivalTime) && Intrinsics.areEqual(this.date, multiRideBookingTicket.date) && Intrinsics.areEqual(this.departureHarborName, multiRideBookingTicket.departureHarborName) && Intrinsics.areEqual(this.departureRegionId, multiRideBookingTicket.departureRegionId) && Intrinsics.areEqual(this.departureTime, multiRideBookingTicket.departureTime) && Intrinsics.areEqual(this.ferryName, multiRideBookingTicket.ferryName) && this.noShow == multiRideBookingTicket.noShow && Intrinsics.areEqual(this.numberPlate, multiRideBookingTicket.numberPlate) && this.passengers == multiRideBookingTicket.passengers && Intrinsics.areEqual(this.phone, multiRideBookingTicket.phone);
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

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public String getDepartureHarborName() {
        return this.departureHarborName;
    }

    public final String getDepartureRegionId() {
        return this.departureRegionId;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public LocalTime getDepartureTime() {
        return this.departureTime;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public Ferry getFerry() {
        return this.ferry;
    }

    public final String getFerryName() {
        return this.ferryName;
    }

    public final boolean getNoShow() {
        return this.noShow;
    }

    public final String getNumberPlate() {
        return this.numberPlate;
    }

    public final int getPassengers() {
        return this.passengers;
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
        int hashCode = ((((((((((((((((((((this.reservationNumber.hashCode() * 31) + this.arrivalHarborName.hashCode()) * 31) + this.arrivalTime.hashCode()) * 31) + this.date.hashCode()) * 31) + this.departureHarborName.hashCode()) * 31) + this.departureRegionId.hashCode()) * 31) + this.departureTime.hashCode()) * 31) + this.ferryName.hashCode()) * 31) + Boolean.hashCode(this.noShow)) * 31) + this.numberPlate.hashCode()) * 31) + Integer.hashCode(this.passengers)) * 31;
        String str = this.phone;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "MultiRideBookingTicket(reservationNumber=" + this.reservationNumber + ", arrivalHarborName=" + this.arrivalHarborName + ", arrivalTime=" + this.arrivalTime + ", date=" + this.date + ", departureHarborName=" + this.departureHarborName + ", departureRegionId=" + this.departureRegionId + ", departureTime=" + this.departureTime + ", ferryName=" + this.ferryName + ", noShow=" + this.noShow + ", numberPlate=" + this.numberPlate + ", passengers=" + this.passengers + ", phone=" + this.phone + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MultiRideBookingTicket(MultiRideBookingTicketResponseDTO dto) {
        this(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, StringsKt.isBlank(r15) ? null : r15);
        Intrinsics.checkNotNullParameter(dto, "dto");
        String id = dto.getId();
        String arrivalHarbor = dto.getArrivalHarbor();
        LocalTime arrivalTime = dto.getArrivalTime();
        LocalDate date = dto.getDate();
        String departureHarbor = dto.getDepartureHarbor();
        String departureRegionId = dto.getDepartureRegionId();
        LocalTime departureTime = dto.getDepartureTime();
        String ferry = dto.getFerry();
        boolean noShow = dto.getNoShow();
        String numberPlate = dto.getNumberPlate();
        int passengers = dto.getPassengers();
        String phone = dto.getPhone();
    }
}
