package dk.molslinjen.domain.model.booking;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.booking.response.DeparturesResponseDTO;
import dk.molslinjen.api.services.booking.response.ProductTypeResponseDTO;
import dk.molslinjen.api.services.booking.response.booking.FerryResponseDTO;
import dk.molslinjen.api.shared.response.RouteTypeResponseDTO;
import dk.molslinjen.core.extensions.StringExtensionsKt;
import dk.molslinjen.domain.model.config.Harbor;
import dk.molslinjen.domain.model.config.RouteDirectionDetails;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import java.util.ArrayList;
import java.util.Iterator;
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

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 n2\u00020\u0001:\u0001nBÏ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d\u0012\u0006\u0010\u001f\u001a\u00020 \u0012\u0006\u0010!\u001a\u00020\u0007\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u001d¢\u0006\u0004\b$\u0010%B!\b\u0016\u0012\u0006\u0010&\u001a\u00020'\u0012\u0006\u0010(\u001a\u00020\u0007\u0012\u0006\u0010)\u001a\u00020\u0007¢\u0006\u0004\b$\u0010*J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003J\t\u0010S\u001a\u00020\u0007HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010U\u001a\u00020\nHÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0005HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\t\u0010`\u001a\u00020\u0019HÆ\u0003J\t\u0010a\u001a\u00020\u0007HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dHÆ\u0003J\t\u0010d\u001a\u00020 HÆ\u0003J\t\u0010e\u001a\u00020\u0007HÆ\u0003J\u000f\u0010f\u001a\b\u0012\u0004\u0012\u00020#0\u001dHÆ\u0003Jý\u0001\u0010g\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00072\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00072\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u001dHÆ\u0001J\u0013\u0010h\u001a\u00020\u00072\b\u0010i\u001a\u0004\u0018\u00010jHÖ\u0003J\t\u0010k\u001a\u00020lHÖ\u0001J\t\u0010m\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010,R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0014\u0010\u000b\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010,R\u0014\u0010\f\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010.R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010,R\u0014\u0010\u0010\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010,R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010,R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010,R\u0014\u0010\u0017\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010,R\u0014\u0010\u0018\u001a\u00020\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0011\u0010\u001a\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bC\u00100R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010,R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0014\u0010\u001f\u001a\u00020 X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0011\u0010!\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bI\u00100R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u001d¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010FR\u0011\u0010K\u001a\u00020L¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0011\u0010O\u001a\u00020L¢\u0006\b\n\u0000\u001a\u0004\bP\u0010N¨\u0006o"}, d2 = {"Ldk/molslinjen/domain/model/booking/Departure;", "Ldk/molslinjen/domain/model/booking/IDepartureInfo;", "arrivalHarborName", BuildConfig.FLAVOR, "arrivalTime", "Lorg/threeten/bp/LocalTime;", "cancelled", BuildConfig.FLAVOR, "customRouteTypeText", "date", "Lorg/threeten/bp/LocalDate;", "departureHarborName", "departureTime", "ferry", "Ldk/molslinjen/domain/model/booking/Ferry;", Constants.ID_ATTRIBUTE_KEY, "timeTableId", "information", "fromPrice", "Ldk/molslinjen/domain/model/shared/Price;", "cheapestTicketType", "Ldk/molslinjen/domain/model/booking/CheapestTicketType;", "mainRouteId", "routeId", "routeType", "Ldk/molslinjen/domain/model/booking/RouteType;", "soldOut", "transportSwitchDescription", "tickets", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/DepartureTicket;", "travelTime", "Lorg/threeten/bp/Duration;", "limitedAvailability", "availableProductTypes", "Ldk/molslinjen/domain/model/booking/ProductType;", "<init>", "(Ljava/lang/String;Lorg/threeten/bp/LocalTime;ZLjava/lang/String;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Lorg/threeten/bp/LocalTime;Ldk/molslinjen/domain/model/booking/Ferry;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/shared/Price;Ldk/molslinjen/domain/model/booking/CheapestTicketType;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/booking/RouteType;ZLjava/lang/String;Ljava/util/List;Lorg/threeten/bp/Duration;ZLjava/util/List;)V", "dto", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$DepartureResponseDTO;", "isMultiRide", "isEdit", "(Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$DepartureResponseDTO;ZZ)V", "getArrivalHarborName", "()Ljava/lang/String;", "getArrivalTime", "()Lorg/threeten/bp/LocalTime;", "getCancelled", "()Z", "getCustomRouteTypeText", "getDate", "()Lorg/threeten/bp/LocalDate;", "getDepartureHarborName", "getDepartureTime", "getFerry", "()Ldk/molslinjen/domain/model/booking/Ferry;", "getId", "getTimeTableId", "getInformation", "getFromPrice", "()Ldk/molslinjen/domain/model/shared/Price;", "getCheapestTicketType", "()Ldk/molslinjen/domain/model/booking/CheapestTicketType;", "getMainRouteId", "getRouteId", "getRouteType", "()Ldk/molslinjen/domain/model/booking/RouteType;", "getSoldOut", "getTransportSwitchDescription", "getTickets", "()Ljava/util/List;", "getTravelTime", "()Lorg/threeten/bp/Duration;", "getLimitedAvailability", "getAvailableProductTypes", "departureDateTime", "Lorg/threeten/bp/LocalDateTime;", "getDepartureDateTime", "()Lorg/threeten/bp/LocalDateTime;", "arrivalDateTime", "getArrivalDateTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class Departure implements IDepartureInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Departure mock;
    private final LocalDateTime arrivalDateTime;
    private final String arrivalHarborName;
    private final LocalTime arrivalTime;
    private final List<ProductType> availableProductTypes;
    private final boolean cancelled;
    private final CheapestTicketType cheapestTicketType;
    private final String customRouteTypeText;
    private final LocalDate date;
    private final LocalDateTime departureDateTime;
    private final String departureHarborName;
    private final LocalTime departureTime;
    private final Ferry ferry;
    private final Price fromPrice;
    private final String id;
    private final String information;
    private final boolean limitedAvailability;
    private final String mainRouteId;
    private final String routeId;
    private final RouteType routeType;
    private final boolean soldOut;
    private final List<DepartureTicket> tickets;
    private final String timeTableId;
    private final String transportSwitchDescription;
    private final Duration travelTime;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/Departure$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/Departure;", "getMock", "()Ldk/molslinjen/domain/model/booking/Departure;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Departure getMock() {
            return Departure.mock;
        }

        private Companion() {
        }
    }

    static {
        Harbor.Companion companion = Harbor.INSTANCE;
        String name = companion.getMockOdden().getName();
        LocalTime of = LocalTime.of(11, 15);
        Intrinsics.checkNotNullExpressionValue(of, "of(...)");
        LocalDate of2 = LocalDate.of(2022, 10, 10);
        Intrinsics.checkNotNullExpressionValue(of2, "of(...)");
        String name2 = companion.getMockAarhus().getName();
        LocalTime of3 = LocalTime.of(9, 45);
        Intrinsics.checkNotNullExpressionValue(of3, "of(...)");
        Ferry mock2 = Ferry.INSTANCE.getMock();
        PriceWithCurrency mock3 = PriceWithCurrency.INSTANCE.mock(123);
        CheapestTicketType cheapestTicketType = new CheapestTicketType(CheapestTicketPriceIndicator.Regular, TicketCategoryType.Standard, "Standard");
        RouteDirectionDetails.Companion companion2 = RouteDirectionDetails.INSTANCE;
        String id = companion2.getMockAarhusOdden().getId();
        String id2 = companion2.getMockAarhusOdden().getId();
        RouteType routeType = RouteType.Ferry;
        List listOf = CollectionsKt.listOf(DepartureTicket.INSTANCE.getMockLowPrice());
        Duration ofMinutes = Duration.ofMinutes(90L);
        Intrinsics.checkNotNullExpressionValue(ofMinutes, "ofMinutes(...)");
        mock = new Departure(name, of, false, null, of2, name2, of3, mock2, "JYL_3_20221010_0945", "667117", null, mock3, cheapestTicketType, id, id2, routeType, false, "Gå fra borde og find bussen på Hamntorget, lige uden for færgeterminalen", listOf, ofMinutes, false, CollectionsKt.listOf((Object[]) new ProductType[]{ProductType.Catering, ProductType.Extra, ProductType.Bunk}));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Departure(String arrivalHarborName, LocalTime arrivalTime, boolean z5, String str, LocalDate date, String departureHarborName, LocalTime departureTime, Ferry ferry, String id, String timeTableId, String str2, Price price, CheapestTicketType cheapestTicketType, String mainRouteId, String routeId, RouteType routeType, boolean z6, String str3, List<DepartureTicket> tickets, Duration travelTime, boolean z7, List<? extends ProductType> availableProductTypes) {
        Intrinsics.checkNotNullParameter(arrivalHarborName, "arrivalHarborName");
        Intrinsics.checkNotNullParameter(arrivalTime, "arrivalTime");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(departureHarborName, "departureHarborName");
        Intrinsics.checkNotNullParameter(departureTime, "departureTime");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(timeTableId, "timeTableId");
        Intrinsics.checkNotNullParameter(mainRouteId, "mainRouteId");
        Intrinsics.checkNotNullParameter(routeId, "routeId");
        Intrinsics.checkNotNullParameter(routeType, "routeType");
        Intrinsics.checkNotNullParameter(tickets, "tickets");
        Intrinsics.checkNotNullParameter(travelTime, "travelTime");
        Intrinsics.checkNotNullParameter(availableProductTypes, "availableProductTypes");
        this.arrivalHarborName = arrivalHarborName;
        this.arrivalTime = arrivalTime;
        this.cancelled = z5;
        this.customRouteTypeText = str;
        this.date = date;
        this.departureHarborName = departureHarborName;
        this.departureTime = departureTime;
        this.ferry = ferry;
        this.id = id;
        this.timeTableId = timeTableId;
        this.information = str2;
        this.fromPrice = price;
        this.cheapestTicketType = cheapestTicketType;
        this.mainRouteId = mainRouteId;
        this.routeId = routeId;
        this.routeType = routeType;
        this.soldOut = z6;
        this.transportSwitchDescription = str3;
        this.tickets = tickets;
        this.travelTime = travelTime;
        this.limitedAvailability = z7;
        this.availableProductTypes = availableProductTypes;
        LocalDateTime of = LocalDateTime.of(getDate(), getDepartureTime());
        Intrinsics.checkNotNullExpressionValue(of, "of(...)");
        this.departureDateTime = of;
        LocalDateTime of2 = LocalDateTime.of(getDate(), getArrivalTime());
        Intrinsics.checkNotNullExpressionValue(of2, "of(...)");
        this.arrivalDateTime = of2;
    }

    /* renamed from: component1, reason: from getter */
    public final String getArrivalHarborName() {
        return this.arrivalHarborName;
    }

    /* renamed from: component10, reason: from getter */
    public final String getTimeTableId() {
        return this.timeTableId;
    }

    /* renamed from: component11, reason: from getter */
    public final String getInformation() {
        return this.information;
    }

    /* renamed from: component12, reason: from getter */
    public final Price getFromPrice() {
        return this.fromPrice;
    }

    /* renamed from: component13, reason: from getter */
    public final CheapestTicketType getCheapestTicketType() {
        return this.cheapestTicketType;
    }

    /* renamed from: component14, reason: from getter */
    public final String getMainRouteId() {
        return this.mainRouteId;
    }

    /* renamed from: component15, reason: from getter */
    public final String getRouteId() {
        return this.routeId;
    }

    /* renamed from: component16, reason: from getter */
    public final RouteType getRouteType() {
        return this.routeType;
    }

    /* renamed from: component17, reason: from getter */
    public final boolean getSoldOut() {
        return this.soldOut;
    }

    /* renamed from: component18, reason: from getter */
    public final String getTransportSwitchDescription() {
        return this.transportSwitchDescription;
    }

    public final List<DepartureTicket> component19() {
        return this.tickets;
    }

    /* renamed from: component2, reason: from getter */
    public final LocalTime getArrivalTime() {
        return this.arrivalTime;
    }

    /* renamed from: component20, reason: from getter */
    public final Duration getTravelTime() {
        return this.travelTime;
    }

    /* renamed from: component21, reason: from getter */
    public final boolean getLimitedAvailability() {
        return this.limitedAvailability;
    }

    public final List<ProductType> component22() {
        return this.availableProductTypes;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getCancelled() {
        return this.cancelled;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCustomRouteTypeText() {
        return this.customRouteTypeText;
    }

    /* renamed from: component5, reason: from getter */
    public final LocalDate getDate() {
        return this.date;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDepartureHarborName() {
        return this.departureHarborName;
    }

    /* renamed from: component7, reason: from getter */
    public final LocalTime getDepartureTime() {
        return this.departureTime;
    }

    /* renamed from: component8, reason: from getter */
    public final Ferry getFerry() {
        return this.ferry;
    }

    /* renamed from: component9, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final Departure copy(String arrivalHarborName, LocalTime arrivalTime, boolean cancelled, String customRouteTypeText, LocalDate date, String departureHarborName, LocalTime departureTime, Ferry ferry, String id, String timeTableId, String information, Price fromPrice, CheapestTicketType cheapestTicketType, String mainRouteId, String routeId, RouteType routeType, boolean soldOut, String transportSwitchDescription, List<DepartureTicket> tickets, Duration travelTime, boolean limitedAvailability, List<? extends ProductType> availableProductTypes) {
        Intrinsics.checkNotNullParameter(arrivalHarborName, "arrivalHarborName");
        Intrinsics.checkNotNullParameter(arrivalTime, "arrivalTime");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(departureHarborName, "departureHarborName");
        Intrinsics.checkNotNullParameter(departureTime, "departureTime");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(timeTableId, "timeTableId");
        Intrinsics.checkNotNullParameter(mainRouteId, "mainRouteId");
        Intrinsics.checkNotNullParameter(routeId, "routeId");
        Intrinsics.checkNotNullParameter(routeType, "routeType");
        Intrinsics.checkNotNullParameter(tickets, "tickets");
        Intrinsics.checkNotNullParameter(travelTime, "travelTime");
        Intrinsics.checkNotNullParameter(availableProductTypes, "availableProductTypes");
        return new Departure(arrivalHarborName, arrivalTime, cancelled, customRouteTypeText, date, departureHarborName, departureTime, ferry, id, timeTableId, information, fromPrice, cheapestTicketType, mainRouteId, routeId, routeType, soldOut, transportSwitchDescription, tickets, travelTime, limitedAvailability, availableProductTypes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Departure)) {
            return false;
        }
        Departure departure = (Departure) other;
        return Intrinsics.areEqual(this.arrivalHarborName, departure.arrivalHarborName) && Intrinsics.areEqual(this.arrivalTime, departure.arrivalTime) && this.cancelled == departure.cancelled && Intrinsics.areEqual(this.customRouteTypeText, departure.customRouteTypeText) && Intrinsics.areEqual(this.date, departure.date) && Intrinsics.areEqual(this.departureHarborName, departure.departureHarborName) && Intrinsics.areEqual(this.departureTime, departure.departureTime) && Intrinsics.areEqual(this.ferry, departure.ferry) && Intrinsics.areEqual(this.id, departure.id) && Intrinsics.areEqual(this.timeTableId, departure.timeTableId) && Intrinsics.areEqual(this.information, departure.information) && Intrinsics.areEqual(this.fromPrice, departure.fromPrice) && Intrinsics.areEqual(this.cheapestTicketType, departure.cheapestTicketType) && Intrinsics.areEqual(this.mainRouteId, departure.mainRouteId) && Intrinsics.areEqual(this.routeId, departure.routeId) && this.routeType == departure.routeType && this.soldOut == departure.soldOut && Intrinsics.areEqual(this.transportSwitchDescription, departure.transportSwitchDescription) && Intrinsics.areEqual(this.tickets, departure.tickets) && Intrinsics.areEqual(this.travelTime, departure.travelTime) && this.limitedAvailability == departure.limitedAvailability && Intrinsics.areEqual(this.availableProductTypes, departure.availableProductTypes);
    }

    public final LocalDateTime getArrivalDateTime() {
        return this.arrivalDateTime;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public String getArrivalHarborName() {
        return this.arrivalHarborName;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public LocalTime getArrivalTime() {
        return this.arrivalTime;
    }

    public final List<ProductType> getAvailableProductTypes() {
        return this.availableProductTypes;
    }

    public final boolean getCancelled() {
        return this.cancelled;
    }

    public final CheapestTicketType getCheapestTicketType() {
        return this.cheapestTicketType;
    }

    public final String getCustomRouteTypeText() {
        return this.customRouteTypeText;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public LocalDate getDate() {
        return this.date;
    }

    public final LocalDateTime getDepartureDateTime() {
        return this.departureDateTime;
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

    public final Price getFromPrice() {
        return this.fromPrice;
    }

    public final String getId() {
        return this.id;
    }

    public final String getInformation() {
        return this.information;
    }

    public final boolean getLimitedAvailability() {
        return this.limitedAvailability;
    }

    public final String getMainRouteId() {
        return this.mainRouteId;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public String getRouteId() {
        return this.routeId;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public RouteType getRouteType() {
        return this.routeType;
    }

    public final boolean getSoldOut() {
        return this.soldOut;
    }

    public final List<DepartureTicket> getTickets() {
        return this.tickets;
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
        int hashCode = ((((this.arrivalHarborName.hashCode() * 31) + this.arrivalTime.hashCode()) * 31) + Boolean.hashCode(this.cancelled)) * 31;
        String str = this.customRouteTypeText;
        int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.date.hashCode()) * 31) + this.departureHarborName.hashCode()) * 31) + this.departureTime.hashCode()) * 31;
        Ferry ferry = this.ferry;
        int hashCode3 = (((((hashCode2 + (ferry == null ? 0 : ferry.hashCode())) * 31) + this.id.hashCode()) * 31) + this.timeTableId.hashCode()) * 31;
        String str2 = this.information;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Price price = this.fromPrice;
        int hashCode5 = (hashCode4 + (price == null ? 0 : price.hashCode())) * 31;
        CheapestTicketType cheapestTicketType = this.cheapestTicketType;
        int hashCode6 = (((((((((hashCode5 + (cheapestTicketType == null ? 0 : cheapestTicketType.hashCode())) * 31) + this.mainRouteId.hashCode()) * 31) + this.routeId.hashCode()) * 31) + this.routeType.hashCode()) * 31) + Boolean.hashCode(this.soldOut)) * 31;
        String str3 = this.transportSwitchDescription;
        return ((((((((hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.tickets.hashCode()) * 31) + this.travelTime.hashCode()) * 31) + Boolean.hashCode(this.limitedAvailability)) * 31) + this.availableProductTypes.hashCode();
    }

    public String toString() {
        return "Departure(arrivalHarborName=" + this.arrivalHarborName + ", arrivalTime=" + this.arrivalTime + ", cancelled=" + this.cancelled + ", customRouteTypeText=" + this.customRouteTypeText + ", date=" + this.date + ", departureHarborName=" + this.departureHarborName + ", departureTime=" + this.departureTime + ", ferry=" + this.ferry + ", id=" + this.id + ", timeTableId=" + this.timeTableId + ", information=" + this.information + ", fromPrice=" + this.fromPrice + ", cheapestTicketType=" + this.cheapestTicketType + ", mainRouteId=" + this.mainRouteId + ", routeId=" + this.routeId + ", routeType=" + this.routeType + ", soldOut=" + this.soldOut + ", transportSwitchDescription=" + this.transportSwitchDescription + ", tickets=" + this.tickets + ", travelTime=" + this.travelTime + ", limitedAvailability=" + this.limitedAvailability + ", availableProductTypes=" + this.availableProductTypes + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v13, types: [dk.molslinjen.domain.model.shared.Price$Charge] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Departure(DeparturesResponseDTO.DepartureResponseDTO dto, boolean z5, boolean z6) {
        this(r4, r5, r6, r7, r8, r9, r10, r11, r12, r0, r14, r15, r16, r17, r18, r19, r20, r21, r13, r23, r24, r2);
        PriceWithCurrency priceWithCurrency;
        Intrinsics.checkNotNullParameter(dto, "dto");
        String name = dto.getArrivalHarbor().getName();
        LocalTime arrivalTime = dto.getArrivalTime();
        boolean cancelled = dto.getCancelled();
        String nullIfEmpty = StringExtensionsKt.nullIfEmpty(dto.getCustomRouteTypeText());
        LocalDate date = dto.getDate();
        LocalTime departureTime = dto.getDepartureTime();
        FerryResponseDTO ferry = dto.getFerry();
        Ferry ferry2 = ferry != null ? new Ferry(ferry) : null;
        String id = dto.getId();
        String nullIfEmpty2 = StringExtensionsKt.nullIfEmpty(dto.getInformation());
        if (z5) {
            priceWithCurrency = new Price.Charge(!z6 ? 1 : 0);
        } else {
            DeparturesResponseDTO.CheapestTicketDTO lowestPrice = dto.getLowestPrice();
            priceWithCurrency = lowestPrice != null ? new PriceWithCurrency(lowestPrice.getPrice()) : null;
        }
        DeparturesResponseDTO.CheapestTicketDTO lowestPrice2 = dto.getLowestPrice();
        CheapestTicketType cheapestTicketType = lowestPrice2 != null ? new CheapestTicketType(lowestPrice2) : null;
        String mainRouteId = dto.getMainRouteId();
        String routeId = dto.getRouteId();
        RouteType invoke = RouteType.INSTANCE.invoke((RouteTypeResponseDTO) CollectionsKt.first((List) dto.getRouteTypes()));
        boolean soldOut = dto.getSoldOut();
        String transportSwitchDescription = dto.getTransportSwitchDescription();
        List<DeparturesResponseDTO.TicketResponseDTO> tickets = dto.getTickets();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(tickets, 10));
        Iterator it = tickets.iterator();
        while (it.hasNext()) {
            arrayList.add(new DepartureTicket((DeparturesResponseDTO.TicketResponseDTO) it.next(), z5, z6));
        }
        Duration travelTime = dto.getTravelTime();
        String name2 = dto.getDepartureHarbor().getName();
        String timeTableId = dto.getTimeTableId();
        boolean limitedAvailability = dto.getLimitedAvailability();
        List<ProductTypeResponseDTO> availableProductTypes = dto.getAvailableProductTypes();
        List<ProductTypeResponseDTO> emptyList = availableProductTypes == null ? CollectionsKt.emptyList() : availableProductTypes;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(emptyList, 10));
        for (Iterator it2 = emptyList.iterator(); it2.hasNext(); it2 = it2) {
            arrayList2.add(ProductType.INSTANCE.invoke((ProductTypeResponseDTO) it2.next()));
        }
    }
}
