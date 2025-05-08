package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.services.booking.response.booking.BookingResponseDTO;
import dk.molslinjen.api.services.booking.response.booking.FerryResponseDTO;
import dk.molslinjen.api.shared.response.RouteTypeResponseDTO;
import dk.molslinjen.api.shared.response.SublineDTO;
import dk.molslinjen.domain.model.config.Harbor;
import dk.molslinjen.domain.model.config.Subline;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 U2\u00020\u0001:\u0001UB\u008f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001b\u0010\u001cB\u0011\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0004\b\u001b\u0010\u001fJ\u0006\u0010<\u001a\u00020=J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\t\u0010@\u001a\u00020\u0007HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0007HÆ\u0003J\t\u0010C\u001a\u00020\u0007HÆ\u0003J\t\u0010D\u001a\u00020\u0007HÆ\u0003J\t\u0010E\u001a\u00020\rHÆ\u0003J\t\u0010F\u001a\u00020\u0007HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010H\u001a\u00020\u0012HÆ\u0003J\t\u0010I\u001a\u00020\u0012HÆ\u0003J\t\u0010J\u001a\u00020\u0015HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010L\u001a\u00020\u0018HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u001aHÆ\u0003J¯\u0001\u0010N\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÆ\u0001J\u0013\u0010O\u001a\u00020\u00182\b\u0010P\u001a\u0004\u0018\u00010QHÖ\u0003J\t\u0010R\u001a\u00020SHÖ\u0001J\t\u0010T\u001a\u00020\u0007HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010\b\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u0014\u0010\u000b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0014\u0010\u000e\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010%R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0013\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b1\u00100R\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010%R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u00105R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0014\u00108\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010%R\u0014\u0010:\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010%¨\u0006V"}, d2 = {"Ldk/molslinjen/domain/model/booking/BookingDeparture;", "Ldk/molslinjen/domain/model/booking/IDepartureInfo;", "arrivalTime", "Lorg/threeten/bp/LocalTime;", "date", "Lorg/threeten/bp/LocalDate;", "departureId", BuildConfig.FLAVOR, "departureTime", "regionId", "mainRouteId", "routeId", "routeType", "Ldk/molslinjen/domain/model/booking/RouteType;", "timeTableId", "ferry", "Ldk/molslinjen/domain/model/booking/Ferry;", "arrivalHarbor", "Ldk/molslinjen/domain/model/config/Harbor;", "departureHarbor", "travelTime", "Lorg/threeten/bp/Duration;", "transportSwitchDescription", "isEarlyCheckInPossible", BuildConfig.FLAVOR, "subline", "Ldk/molslinjen/domain/model/config/Subline;", "<init>", "(Lorg/threeten/bp/LocalTime;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Lorg/threeten/bp/LocalTime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/booking/RouteType;Ljava/lang/String;Ldk/molslinjen/domain/model/booking/Ferry;Ldk/molslinjen/domain/model/config/Harbor;Ldk/molslinjen/domain/model/config/Harbor;Lorg/threeten/bp/Duration;Ljava/lang/String;ZLdk/molslinjen/domain/model/config/Subline;)V", "dto", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$DepartureResponseDTO;", "(Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$DepartureResponseDTO;)V", "getArrivalTime", "()Lorg/threeten/bp/LocalTime;", "getDate", "()Lorg/threeten/bp/LocalDate;", "getDepartureId", "()Ljava/lang/String;", "getDepartureTime", "getRegionId", "getMainRouteId", "getRouteId", "getRouteType", "()Ldk/molslinjen/domain/model/booking/RouteType;", "getTimeTableId", "getFerry", "()Ldk/molslinjen/domain/model/booking/Ferry;", "getArrivalHarbor", "()Ldk/molslinjen/domain/model/config/Harbor;", "getDepartureHarbor", "getTravelTime", "()Lorg/threeten/bp/Duration;", "getTransportSwitchDescription", "()Z", "getSubline", "()Ldk/molslinjen/domain/model/config/Subline;", "arrivalHarborName", "getArrivalHarborName", "departureHarborName", "getDepartureHarborName", "departureDateTime", "Lorg/threeten/bp/LocalDateTime;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class BookingDeparture implements IDepartureInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final BookingDeparture mock;
    private final Harbor arrivalHarbor;
    private final String arrivalHarborName;
    private final LocalTime arrivalTime;
    private final LocalDate date;
    private final Harbor departureHarbor;
    private final String departureHarborName;
    private final String departureId;
    private final LocalTime departureTime;
    private final Ferry ferry;
    private final boolean isEarlyCheckInPossible;
    private final String mainRouteId;
    private final String regionId;
    private final String routeId;
    private final RouteType routeType;
    private final Subline subline;
    private final String timeTableId;
    private final String transportSwitchDescription;
    private final Duration travelTime;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/BookingDeparture$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/BookingDeparture;", "getMock", "()Ldk/molslinjen/domain/model/booking/BookingDeparture;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BookingDeparture getMock() {
            return BookingDeparture.mock;
        }

        private Companion() {
        }
    }

    static {
        LocalTime of = LocalTime.of(12, 0);
        Intrinsics.checkNotNullExpressionValue(of, "of(...)");
        LocalDate of2 = LocalDate.of(2022, 1, 1);
        Intrinsics.checkNotNullExpressionValue(of2, "of(...)");
        LocalTime of3 = LocalTime.of(10, 0);
        Intrinsics.checkNotNullExpressionValue(of3, "of(...)");
        RouteType routeType = RouteType.Ferry;
        Ferry mock2 = Ferry.INSTANCE.getMock();
        Harbor.Companion companion = Harbor.INSTANCE;
        Harbor mockOdden = companion.getMockOdden();
        Harbor mockAarhus = companion.getMockAarhus();
        Duration ofMinutes = Duration.ofMinutes(120L);
        Intrinsics.checkNotNullExpressionValue(ofMinutes, "ofMinutes(...)");
        mock = new BookingDeparture(of, of2, "JYL_3_20220101_1000", of3, "JYL", "JYL3", "JYL3", routeType, "564621", mock2, mockAarhus, mockOdden, ofMinutes, null, false, Subline.INSTANCE.getMock(), 16384, null);
    }

    public BookingDeparture(LocalTime arrivalTime, LocalDate date, String departureId, LocalTime departureTime, String regionId, String mainRouteId, String routeId, RouteType routeType, String timeTableId, Ferry ferry, Harbor arrivalHarbor, Harbor departureHarbor, Duration travelTime, String str, boolean z5, Subline subline) {
        Intrinsics.checkNotNullParameter(arrivalTime, "arrivalTime");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(departureId, "departureId");
        Intrinsics.checkNotNullParameter(departureTime, "departureTime");
        Intrinsics.checkNotNullParameter(regionId, "regionId");
        Intrinsics.checkNotNullParameter(mainRouteId, "mainRouteId");
        Intrinsics.checkNotNullParameter(routeId, "routeId");
        Intrinsics.checkNotNullParameter(routeType, "routeType");
        Intrinsics.checkNotNullParameter(timeTableId, "timeTableId");
        Intrinsics.checkNotNullParameter(arrivalHarbor, "arrivalHarbor");
        Intrinsics.checkNotNullParameter(departureHarbor, "departureHarbor");
        Intrinsics.checkNotNullParameter(travelTime, "travelTime");
        this.arrivalTime = arrivalTime;
        this.date = date;
        this.departureId = departureId;
        this.departureTime = departureTime;
        this.regionId = regionId;
        this.mainRouteId = mainRouteId;
        this.routeId = routeId;
        this.routeType = routeType;
        this.timeTableId = timeTableId;
        this.ferry = ferry;
        this.arrivalHarbor = arrivalHarbor;
        this.departureHarbor = departureHarbor;
        this.travelTime = travelTime;
        this.transportSwitchDescription = str;
        this.isEarlyCheckInPossible = z5;
        this.subline = subline;
        this.arrivalHarborName = arrivalHarbor.getName();
        this.departureHarborName = departureHarbor.getName();
    }

    /* renamed from: component1, reason: from getter */
    public final LocalTime getArrivalTime() {
        return this.arrivalTime;
    }

    /* renamed from: component10, reason: from getter */
    public final Ferry getFerry() {
        return this.ferry;
    }

    /* renamed from: component11, reason: from getter */
    public final Harbor getArrivalHarbor() {
        return this.arrivalHarbor;
    }

    /* renamed from: component12, reason: from getter */
    public final Harbor getDepartureHarbor() {
        return this.departureHarbor;
    }

    /* renamed from: component13, reason: from getter */
    public final Duration getTravelTime() {
        return this.travelTime;
    }

    /* renamed from: component14, reason: from getter */
    public final String getTransportSwitchDescription() {
        return this.transportSwitchDescription;
    }

    /* renamed from: component15, reason: from getter */
    public final boolean getIsEarlyCheckInPossible() {
        return this.isEarlyCheckInPossible;
    }

    /* renamed from: component16, reason: from getter */
    public final Subline getSubline() {
        return this.subline;
    }

    /* renamed from: component2, reason: from getter */
    public final LocalDate getDate() {
        return this.date;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDepartureId() {
        return this.departureId;
    }

    /* renamed from: component4, reason: from getter */
    public final LocalTime getDepartureTime() {
        return this.departureTime;
    }

    /* renamed from: component5, reason: from getter */
    public final String getRegionId() {
        return this.regionId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getMainRouteId() {
        return this.mainRouteId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getRouteId() {
        return this.routeId;
    }

    /* renamed from: component8, reason: from getter */
    public final RouteType getRouteType() {
        return this.routeType;
    }

    /* renamed from: component9, reason: from getter */
    public final String getTimeTableId() {
        return this.timeTableId;
    }

    public final BookingDeparture copy(LocalTime arrivalTime, LocalDate date, String departureId, LocalTime departureTime, String regionId, String mainRouteId, String routeId, RouteType routeType, String timeTableId, Ferry ferry, Harbor arrivalHarbor, Harbor departureHarbor, Duration travelTime, String transportSwitchDescription, boolean isEarlyCheckInPossible, Subline subline) {
        Intrinsics.checkNotNullParameter(arrivalTime, "arrivalTime");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(departureId, "departureId");
        Intrinsics.checkNotNullParameter(departureTime, "departureTime");
        Intrinsics.checkNotNullParameter(regionId, "regionId");
        Intrinsics.checkNotNullParameter(mainRouteId, "mainRouteId");
        Intrinsics.checkNotNullParameter(routeId, "routeId");
        Intrinsics.checkNotNullParameter(routeType, "routeType");
        Intrinsics.checkNotNullParameter(timeTableId, "timeTableId");
        Intrinsics.checkNotNullParameter(arrivalHarbor, "arrivalHarbor");
        Intrinsics.checkNotNullParameter(departureHarbor, "departureHarbor");
        Intrinsics.checkNotNullParameter(travelTime, "travelTime");
        return new BookingDeparture(arrivalTime, date, departureId, departureTime, regionId, mainRouteId, routeId, routeType, timeTableId, ferry, arrivalHarbor, departureHarbor, travelTime, transportSwitchDescription, isEarlyCheckInPossible, subline);
    }

    public final LocalDateTime departureDateTime() {
        LocalDateTime of = LocalDateTime.of(getDate(), getDepartureTime());
        Intrinsics.checkNotNullExpressionValue(of, "of(...)");
        return of;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BookingDeparture)) {
            return false;
        }
        BookingDeparture bookingDeparture = (BookingDeparture) other;
        return Intrinsics.areEqual(this.arrivalTime, bookingDeparture.arrivalTime) && Intrinsics.areEqual(this.date, bookingDeparture.date) && Intrinsics.areEqual(this.departureId, bookingDeparture.departureId) && Intrinsics.areEqual(this.departureTime, bookingDeparture.departureTime) && Intrinsics.areEqual(this.regionId, bookingDeparture.regionId) && Intrinsics.areEqual(this.mainRouteId, bookingDeparture.mainRouteId) && Intrinsics.areEqual(this.routeId, bookingDeparture.routeId) && this.routeType == bookingDeparture.routeType && Intrinsics.areEqual(this.timeTableId, bookingDeparture.timeTableId) && Intrinsics.areEqual(this.ferry, bookingDeparture.ferry) && Intrinsics.areEqual(this.arrivalHarbor, bookingDeparture.arrivalHarbor) && Intrinsics.areEqual(this.departureHarbor, bookingDeparture.departureHarbor) && Intrinsics.areEqual(this.travelTime, bookingDeparture.travelTime) && Intrinsics.areEqual(this.transportSwitchDescription, bookingDeparture.transportSwitchDescription) && this.isEarlyCheckInPossible == bookingDeparture.isEarlyCheckInPossible && Intrinsics.areEqual(this.subline, bookingDeparture.subline);
    }

    public final Harbor getArrivalHarbor() {
        return this.arrivalHarbor;
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

    public final Harbor getDepartureHarbor() {
        return this.departureHarbor;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public String getDepartureHarborName() {
        return this.departureHarborName;
    }

    public final String getDepartureId() {
        return this.departureId;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public LocalTime getDepartureTime() {
        return this.departureTime;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public Ferry getFerry() {
        return this.ferry;
    }

    public final String getMainRouteId() {
        return this.mainRouteId;
    }

    public final String getRegionId() {
        return this.regionId;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public String getRouteId() {
        return this.routeId;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public RouteType getRouteType() {
        return this.routeType;
    }

    public final Subline getSubline() {
        return this.subline;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public String getTimeTableId() {
        return this.timeTableId;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public String getTransportSwitchDescription() {
        return this.transportSwitchDescription;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public Duration getTravelTime() {
        return this.travelTime;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((this.arrivalTime.hashCode() * 31) + this.date.hashCode()) * 31) + this.departureId.hashCode()) * 31) + this.departureTime.hashCode()) * 31) + this.regionId.hashCode()) * 31) + this.mainRouteId.hashCode()) * 31) + this.routeId.hashCode()) * 31) + this.routeType.hashCode()) * 31) + this.timeTableId.hashCode()) * 31;
        Ferry ferry = this.ferry;
        int hashCode2 = (((((((hashCode + (ferry == null ? 0 : ferry.hashCode())) * 31) + this.arrivalHarbor.hashCode()) * 31) + this.departureHarbor.hashCode()) * 31) + this.travelTime.hashCode()) * 31;
        String str = this.transportSwitchDescription;
        int hashCode3 = (((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isEarlyCheckInPossible)) * 31;
        Subline subline = this.subline;
        return hashCode3 + (subline != null ? subline.hashCode() : 0);
    }

    public final boolean isEarlyCheckInPossible() {
        return this.isEarlyCheckInPossible;
    }

    public String toString() {
        return "BookingDeparture(arrivalTime=" + this.arrivalTime + ", date=" + this.date + ", departureId=" + this.departureId + ", departureTime=" + this.departureTime + ", regionId=" + this.regionId + ", mainRouteId=" + this.mainRouteId + ", routeId=" + this.routeId + ", routeType=" + this.routeType + ", timeTableId=" + this.timeTableId + ", ferry=" + this.ferry + ", arrivalHarbor=" + this.arrivalHarbor + ", departureHarbor=" + this.departureHarbor + ", travelTime=" + this.travelTime + ", transportSwitchDescription=" + this.transportSwitchDescription + ", isEarlyCheckInPossible=" + this.isEarlyCheckInPossible + ", subline=" + this.subline + ")";
    }

    public /* synthetic */ BookingDeparture(LocalTime localTime, LocalDate localDate, String str, LocalTime localTime2, String str2, String str3, String str4, RouteType routeType, String str5, Ferry ferry, Harbor harbor, Harbor harbor2, Duration duration, String str6, boolean z5, Subline subline, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(localTime, localDate, str, localTime2, str2, str3, str4, routeType, str5, ferry, harbor, harbor2, duration, str6, (i5 & 16384) != 0 ? false : z5, subline);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BookingDeparture(BookingResponseDTO.DepartureResponseDTO dto) {
        this(r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r0, r13, r14, r15, r16, r1 != null ? new Subline(r1) : null);
        Intrinsics.checkNotNullParameter(dto, "dto");
        LocalTime arrivalTime = dto.getArrivalTime();
        LocalDate date = dto.getDate();
        String departureId = dto.getDepartureId();
        LocalTime departureTime = dto.getDepartureTime();
        String regionId = dto.getRegionId();
        String mainRouteId = dto.getMainRouteId();
        String routeId = dto.getRouteId();
        RouteType invoke = RouteType.INSTANCE.invoke((RouteTypeResponseDTO) CollectionsKt.first((List) dto.getRouteTypes()));
        String timeTableId = dto.getTimeTableId();
        FerryResponseDTO ferry = dto.getFerry();
        Ferry ferry2 = ferry != null ? new Ferry(ferry) : null;
        Harbor harbor = new Harbor(dto.getDepartureHarbor());
        Harbor harbor2 = new Harbor(dto.getArrivalHarbor());
        Duration travelTime = dto.getTravelTime();
        String transportSwitchDescription = dto.getTransportSwitchDescription();
        boolean isEarlyCheckInPossible = dto.isEarlyCheckInPossible();
        SublineDTO subline = dto.getSubline();
    }
}
