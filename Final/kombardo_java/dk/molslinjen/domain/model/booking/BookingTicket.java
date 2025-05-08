package dk.molslinjen.domain.model.booking;

import com.adjust.sdk.Constants;
import dk.molslinjen.api.services.booking.response.ProductTypeResponseDTO;
import dk.molslinjen.api.services.booking.response.booking.BookingResponseDTO;
import dk.molslinjen.api.shared.response.TicketSurchargeDTO;
import dk.molslinjen.api.shared.response.TransportResponseDTO;
import dk.molslinjen.domain.managers.checkout.PriceTotal;
import dk.molslinjen.domain.model.booking.LineItem;
import dk.molslinjen.domain.model.config.Transportation;
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

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 d2\u00020\u0001:\u0001dBÁ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000b\u0012\u0006\u0010\u001c\u001a\u00020\u000f\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u000b¢\u0006\u0004\b#\u0010$B)\b\u0016\u0012\u0006\u0010%\u001a\u00020&\u0012\u0006\u0010'\u001a\u00020\t\u0012\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000b¢\u0006\u0004\b#\u0010)J\u0006\u0010H\u001a\u00020IJ\u0006\u0010J\u001a\u00020KJ\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010O\u001a\u00020\tHÆ\u0003J\u000f\u0010P\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u000f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u0011\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000bHÆ\u0003J\t\u0010S\u001a\u00020\u0011HÆ\u0003J\t\u0010T\u001a\u00020\u0013HÆ\u0003J\t\u0010U\u001a\u00020\u0015HÆ\u0003J\t\u0010V\u001a\u00020\u000fHÆ\u0003J\t\u0010W\u001a\u00020\u000fHÆ\u0003J\t\u0010X\u001a\u00020\u0019HÆ\u0003J\u000f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000bHÆ\u0003J\t\u0010Z\u001a\u00020\u000fHÆ\u0003J\u000f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000bHÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010 HÆ\u0003J\u000f\u0010]\u001a\b\u0012\u0004\u0012\u00020\"0\u000bHÆ\u0003Jç\u0001\u0010^\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u000bHÆ\u0001J\u0013\u0010_\u001a\u00020\t2\b\u0010`\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010a\u001a\u00020bHÖ\u0001J\t\u0010c\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u00100R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b3\u00102R\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b4\u00102R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0011\u0010\u0016\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0011\u0010\u0017\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b=\u0010<R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b@\u00102R\u001a\u0010\u001c\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010<\"\u0004\bB\u0010CR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000b¢\u0006\b\n\u0000\u001a\u0004\bD\u00102R\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u000b¢\u0006\b\n\u0000\u001a\u0004\bG\u00102¨\u0006e"}, d2 = {"Ldk/molslinjen/domain/model/booking/BookingTicket;", BuildConfig.FLAVOR, "departure", "Ldk/molslinjen/domain/model/booking/BookingDeparture;", "editInfo", "Ldk/molslinjen/domain/model/booking/EditInfo;", "goods", "Ldk/molslinjen/domain/model/booking/Goods;", "isCheckedIn", BuildConfig.FLAVOR, "products", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/LineItem;", "transportProducts", "notes", BuildConfig.FLAVOR, "passengerInfo", "Ldk/molslinjen/domain/model/booking/BookingPassengerInfo;", "totalPrice", "Ldk/molslinjen/domain/managers/checkout/PriceTotal;", "ticketPrice", "Ldk/molslinjen/domain/model/shared/Price;", "ticketTypeId", "ticketTypeName", "transport", "Ldk/molslinjen/domain/model/config/Transportation;", "barcodes", "Ldk/molslinjen/domain/model/booking/Barcode;", "carId", "availableProductTypes", "Ldk/molslinjen/domain/model/booking/ProductType;", "seatReservation", "Ldk/molslinjen/domain/model/booking/BookingSeatReservation;", "surcharges", "Ldk/molslinjen/domain/model/booking/TicketSurcharge;", "<init>", "(Ldk/molslinjen/domain/model/booking/BookingDeparture;Ldk/molslinjen/domain/model/booking/EditInfo;Ldk/molslinjen/domain/model/booking/Goods;ZLjava/util/List;Ljava/util/List;Ljava/util/List;Ldk/molslinjen/domain/model/booking/BookingPassengerInfo;Ldk/molslinjen/domain/managers/checkout/PriceTotal;Ldk/molslinjen/domain/model/shared/Price;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/config/Transportation;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ldk/molslinjen/domain/model/booking/BookingSeatReservation;Ljava/util/List;)V", "dto", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$TicketResponseDTO;", "isBoughtWithMultiRide", "allTransportations", "(Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$TicketResponseDTO;ZLjava/util/List;)V", "getDeparture", "()Ldk/molslinjen/domain/model/booking/BookingDeparture;", "getEditInfo", "()Ldk/molslinjen/domain/model/booking/EditInfo;", "getGoods", "()Ldk/molslinjen/domain/model/booking/Goods;", "()Z", "getProducts", "()Ljava/util/List;", "getTransportProducts", "getNotes", "getPassengerInfo", "()Ldk/molslinjen/domain/model/booking/BookingPassengerInfo;", "getTotalPrice", "()Ldk/molslinjen/domain/managers/checkout/PriceTotal;", "getTicketPrice", "()Ldk/molslinjen/domain/model/shared/Price;", "getTicketTypeId", "()Ljava/lang/String;", "getTicketTypeName", "getTransport", "()Ldk/molslinjen/domain/model/config/Transportation;", "getBarcodes", "getCarId", "setCarId", "(Ljava/lang/String;)V", "getAvailableProductTypes", "getSeatReservation", "()Ldk/molslinjen/domain/model/booking/BookingSeatReservation;", "getSurcharges", "toTicketCategory", "Ldk/molslinjen/domain/model/booking/TicketCategory;", "getCargoInfo", "Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "equals", "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class BookingTicket {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final BookingTicket mock;
    private final List<ProductType> availableProductTypes;
    private final List<Barcode> barcodes;
    private String carId;
    private final BookingDeparture departure;
    private final EditInfo editInfo;
    private final Goods goods;
    private final boolean isCheckedIn;
    private final List<String> notes;
    private final BookingPassengerInfo passengerInfo;
    private final List<LineItem> products;
    private final BookingSeatReservation seatReservation;
    private final List<TicketSurcharge> surcharges;
    private final Price ticketPrice;
    private final String ticketTypeId;
    private final String ticketTypeName;
    private final PriceTotal totalPrice;
    private final Transportation transport;
    private final List<LineItem> transportProducts;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/BookingTicket$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/BookingTicket;", "getMock", "()Ldk/molslinjen/domain/model/booking/BookingTicket;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BookingTicket getMock() {
            return BookingTicket.mock;
        }

        private Companion() {
        }
    }

    static {
        BookingDeparture mock2 = BookingDeparture.INSTANCE.getMock();
        EditInfo mock3 = EditInfo.INSTANCE.getMock();
        Goods mock4 = Goods.INSTANCE.getMock();
        LineItem.Companion companion = LineItem.INSTANCE;
        List listOf = CollectionsKt.listOf(companion.getMock());
        List listOf2 = CollectionsKt.listOf(companion.getMock());
        List listOf3 = CollectionsKt.listOf((Object[]) new String[]{"Note 1", "Note 2", "Note 3"});
        BookingPassengerInfo mock5 = BookingPassengerInfo.INSTANCE.getMock();
        PriceWithCurrency.Companion companion2 = PriceWithCurrency.INSTANCE;
        mock = new BookingTicket(mock2, mock3, mock4, false, listOf, listOf2, listOf3, mock5, new PriceTotal(companion2.mock(Constants.ONE_SECOND)), companion2.mock(249), "1", "Lavpris", Transportation.INSTANCE.getMockCar(), CollectionsKt.listOf(Barcode.INSTANCE.getMock()), "8296K", CollectionsKt.listOf(ProductType.Extra), BookingSeatReservation.INSTANCE.getMock(), CollectionsKt.listOf(TicketSurcharge.INSTANCE.getMock()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BookingTicket(BookingDeparture departure, EditInfo editInfo, Goods goods, boolean z5, List<LineItem> products, List<LineItem> transportProducts, List<String> notes, BookingPassengerInfo passengerInfo, PriceTotal totalPrice, Price ticketPrice, String ticketTypeId, String ticketTypeName, Transportation transport, List<Barcode> barcodes, String carId, List<? extends ProductType> availableProductTypes, BookingSeatReservation bookingSeatReservation, List<TicketSurcharge> surcharges) {
        Intrinsics.checkNotNullParameter(departure, "departure");
        Intrinsics.checkNotNullParameter(editInfo, "editInfo");
        Intrinsics.checkNotNullParameter(products, "products");
        Intrinsics.checkNotNullParameter(transportProducts, "transportProducts");
        Intrinsics.checkNotNullParameter(notes, "notes");
        Intrinsics.checkNotNullParameter(passengerInfo, "passengerInfo");
        Intrinsics.checkNotNullParameter(totalPrice, "totalPrice");
        Intrinsics.checkNotNullParameter(ticketPrice, "ticketPrice");
        Intrinsics.checkNotNullParameter(ticketTypeId, "ticketTypeId");
        Intrinsics.checkNotNullParameter(ticketTypeName, "ticketTypeName");
        Intrinsics.checkNotNullParameter(transport, "transport");
        Intrinsics.checkNotNullParameter(barcodes, "barcodes");
        Intrinsics.checkNotNullParameter(carId, "carId");
        Intrinsics.checkNotNullParameter(availableProductTypes, "availableProductTypes");
        Intrinsics.checkNotNullParameter(surcharges, "surcharges");
        this.departure = departure;
        this.editInfo = editInfo;
        this.goods = goods;
        this.isCheckedIn = z5;
        this.products = products;
        this.transportProducts = transportProducts;
        this.notes = notes;
        this.passengerInfo = passengerInfo;
        this.totalPrice = totalPrice;
        this.ticketPrice = ticketPrice;
        this.ticketTypeId = ticketTypeId;
        this.ticketTypeName = ticketTypeName;
        this.transport = transport;
        this.barcodes = barcodes;
        this.carId = carId;
        this.availableProductTypes = availableProductTypes;
        this.seatReservation = bookingSeatReservation;
        this.surcharges = surcharges;
    }

    /* renamed from: component1, reason: from getter */
    public final BookingDeparture getDeparture() {
        return this.departure;
    }

    /* renamed from: component10, reason: from getter */
    public final Price getTicketPrice() {
        return this.ticketPrice;
    }

    /* renamed from: component11, reason: from getter */
    public final String getTicketTypeId() {
        return this.ticketTypeId;
    }

    /* renamed from: component12, reason: from getter */
    public final String getTicketTypeName() {
        return this.ticketTypeName;
    }

    /* renamed from: component13, reason: from getter */
    public final Transportation getTransport() {
        return this.transport;
    }

    public final List<Barcode> component14() {
        return this.barcodes;
    }

    /* renamed from: component15, reason: from getter */
    public final String getCarId() {
        return this.carId;
    }

    public final List<ProductType> component16() {
        return this.availableProductTypes;
    }

    /* renamed from: component17, reason: from getter */
    public final BookingSeatReservation getSeatReservation() {
        return this.seatReservation;
    }

    public final List<TicketSurcharge> component18() {
        return this.surcharges;
    }

    /* renamed from: component2, reason: from getter */
    public final EditInfo getEditInfo() {
        return this.editInfo;
    }

    /* renamed from: component3, reason: from getter */
    public final Goods getGoods() {
        return this.goods;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsCheckedIn() {
        return this.isCheckedIn;
    }

    public final List<LineItem> component5() {
        return this.products;
    }

    public final List<LineItem> component6() {
        return this.transportProducts;
    }

    public final List<String> component7() {
        return this.notes;
    }

    /* renamed from: component8, reason: from getter */
    public final BookingPassengerInfo getPassengerInfo() {
        return this.passengerInfo;
    }

    /* renamed from: component9, reason: from getter */
    public final PriceTotal getTotalPrice() {
        return this.totalPrice;
    }

    public final BookingTicket copy(BookingDeparture departure, EditInfo editInfo, Goods goods, boolean isCheckedIn, List<LineItem> products, List<LineItem> transportProducts, List<String> notes, BookingPassengerInfo passengerInfo, PriceTotal totalPrice, Price ticketPrice, String ticketTypeId, String ticketTypeName, Transportation transport, List<Barcode> barcodes, String carId, List<? extends ProductType> availableProductTypes, BookingSeatReservation seatReservation, List<TicketSurcharge> surcharges) {
        Intrinsics.checkNotNullParameter(departure, "departure");
        Intrinsics.checkNotNullParameter(editInfo, "editInfo");
        Intrinsics.checkNotNullParameter(products, "products");
        Intrinsics.checkNotNullParameter(transportProducts, "transportProducts");
        Intrinsics.checkNotNullParameter(notes, "notes");
        Intrinsics.checkNotNullParameter(passengerInfo, "passengerInfo");
        Intrinsics.checkNotNullParameter(totalPrice, "totalPrice");
        Intrinsics.checkNotNullParameter(ticketPrice, "ticketPrice");
        Intrinsics.checkNotNullParameter(ticketTypeId, "ticketTypeId");
        Intrinsics.checkNotNullParameter(ticketTypeName, "ticketTypeName");
        Intrinsics.checkNotNullParameter(transport, "transport");
        Intrinsics.checkNotNullParameter(barcodes, "barcodes");
        Intrinsics.checkNotNullParameter(carId, "carId");
        Intrinsics.checkNotNullParameter(availableProductTypes, "availableProductTypes");
        Intrinsics.checkNotNullParameter(surcharges, "surcharges");
        return new BookingTicket(departure, editInfo, goods, isCheckedIn, products, transportProducts, notes, passengerInfo, totalPrice, ticketPrice, ticketTypeId, ticketTypeName, transport, barcodes, carId, availableProductTypes, seatReservation, surcharges);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BookingTicket)) {
            return false;
        }
        BookingTicket bookingTicket = (BookingTicket) other;
        return Intrinsics.areEqual(this.departure, bookingTicket.departure) && Intrinsics.areEqual(this.editInfo, bookingTicket.editInfo) && Intrinsics.areEqual(this.goods, bookingTicket.goods) && this.isCheckedIn == bookingTicket.isCheckedIn && Intrinsics.areEqual(this.products, bookingTicket.products) && Intrinsics.areEqual(this.transportProducts, bookingTicket.transportProducts) && Intrinsics.areEqual(this.notes, bookingTicket.notes) && Intrinsics.areEqual(this.passengerInfo, bookingTicket.passengerInfo) && Intrinsics.areEqual(this.totalPrice, bookingTicket.totalPrice) && Intrinsics.areEqual(this.ticketPrice, bookingTicket.ticketPrice) && Intrinsics.areEqual(this.ticketTypeId, bookingTicket.ticketTypeId) && Intrinsics.areEqual(this.ticketTypeName, bookingTicket.ticketTypeName) && Intrinsics.areEqual(this.transport, bookingTicket.transport) && Intrinsics.areEqual(this.barcodes, bookingTicket.barcodes) && Intrinsics.areEqual(this.carId, bookingTicket.carId) && Intrinsics.areEqual(this.availableProductTypes, bookingTicket.availableProductTypes) && Intrinsics.areEqual(this.seatReservation, bookingTicket.seatReservation) && Intrinsics.areEqual(this.surcharges, bookingTicket.surcharges);
    }

    public final List<ProductType> getAvailableProductTypes() {
        return this.availableProductTypes;
    }

    public final List<Barcode> getBarcodes() {
        return this.barcodes;
    }

    public final String getCarId() {
        return this.carId;
    }

    public final TransportationCargoInfo getCargoInfo() {
        Goods goods = this.goods;
        return new TransportationCargoInfo(goods != null ? Double.valueOf(goods.getWeight()) : null, this.notes);
    }

    public final BookingDeparture getDeparture() {
        return this.departure;
    }

    public final EditInfo getEditInfo() {
        return this.editInfo;
    }

    public final Goods getGoods() {
        return this.goods;
    }

    public final List<String> getNotes() {
        return this.notes;
    }

    public final BookingPassengerInfo getPassengerInfo() {
        return this.passengerInfo;
    }

    public final List<LineItem> getProducts() {
        return this.products;
    }

    public final BookingSeatReservation getSeatReservation() {
        return this.seatReservation;
    }

    public final List<TicketSurcharge> getSurcharges() {
        return this.surcharges;
    }

    public final Price getTicketPrice() {
        return this.ticketPrice;
    }

    public final String getTicketTypeId() {
        return this.ticketTypeId;
    }

    public final String getTicketTypeName() {
        return this.ticketTypeName;
    }

    public final PriceTotal getTotalPrice() {
        return this.totalPrice;
    }

    public final Transportation getTransport() {
        return this.transport;
    }

    public final List<LineItem> getTransportProducts() {
        return this.transportProducts;
    }

    public int hashCode() {
        int hashCode = ((this.departure.hashCode() * 31) + this.editInfo.hashCode()) * 31;
        Goods goods = this.goods;
        int hashCode2 = (((((((((((((((((((((((((((hashCode + (goods == null ? 0 : goods.hashCode())) * 31) + Boolean.hashCode(this.isCheckedIn)) * 31) + this.products.hashCode()) * 31) + this.transportProducts.hashCode()) * 31) + this.notes.hashCode()) * 31) + this.passengerInfo.hashCode()) * 31) + this.totalPrice.hashCode()) * 31) + this.ticketPrice.hashCode()) * 31) + this.ticketTypeId.hashCode()) * 31) + this.ticketTypeName.hashCode()) * 31) + this.transport.hashCode()) * 31) + this.barcodes.hashCode()) * 31) + this.carId.hashCode()) * 31) + this.availableProductTypes.hashCode()) * 31;
        BookingSeatReservation bookingSeatReservation = this.seatReservation;
        return ((hashCode2 + (bookingSeatReservation != null ? bookingSeatReservation.hashCode() : 0)) * 31) + this.surcharges.hashCode();
    }

    public final boolean isCheckedIn() {
        return this.isCheckedIn;
    }

    public final void setCarId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.carId = str;
    }

    public String toString() {
        return "BookingTicket(departure=" + this.departure + ", editInfo=" + this.editInfo + ", goods=" + this.goods + ", isCheckedIn=" + this.isCheckedIn + ", products=" + this.products + ", transportProducts=" + this.transportProducts + ", notes=" + this.notes + ", passengerInfo=" + this.passengerInfo + ", totalPrice=" + this.totalPrice + ", ticketPrice=" + this.ticketPrice + ", ticketTypeId=" + this.ticketTypeId + ", ticketTypeName=" + this.ticketTypeName + ", transport=" + this.transport + ", barcodes=" + this.barcodes + ", carId=" + this.carId + ", availableProductTypes=" + this.availableProductTypes + ", seatReservation=" + this.seatReservation + ", surcharges=" + this.surcharges + ")";
    }

    public final TicketCategory toTicketCategory() {
        String str = this.ticketTypeId;
        return new TicketCategory(str, TicketCategoryType.INSTANCE.invoke(str), this.ticketTypeName, BuildConfig.FLAVOR, CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0157, code lost:
    
        if (r4 != null) goto L48;
     */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BookingTicket(BookingResponseDTO.TicketResponseDTO dto, boolean z5, List<Transportation> list) {
        this(r2, r3, r5, r0, r6, r7, r9, r10, r12, r11, r14, r13, r22, r23, r16, r8, r18, r15);
        PriceTotal priceTotal;
        String name;
        Transportation transportation;
        List emptyList;
        Object obj;
        Intrinsics.checkNotNullParameter(dto, "dto");
        BookingDeparture bookingDeparture = new BookingDeparture(dto.getDeparture());
        EditInfo editInfo = new EditInfo(dto.getEditInfo());
        BookingResponseDTO.GoodsResponseDTO goods = dto.getGoods();
        Goods goods2 = goods != null ? new Goods(goods) : null;
        boolean isCheckedIn = dto.isCheckedIn();
        List<BookingResponseDTO.LineItemResponseDTO> products = dto.getProducts();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : products) {
            if (((BookingResponseDTO.LineItemResponseDTO) obj2).getAvailability() != BookingResponseDTO.AvailabilityResponseDTO.Route) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new LineItem((BookingResponseDTO.LineItemResponseDTO) it.next()));
        }
        List<BookingResponseDTO.LineItemResponseDTO> products2 = dto.getProducts();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : products2) {
            if (((BookingResponseDTO.LineItemResponseDTO) obj3).getAvailability() == BookingResponseDTO.AvailabilityResponseDTO.Route) {
                arrayList3.add(obj3);
            }
        }
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(new LineItem((BookingResponseDTO.LineItemResponseDTO) it2.next()));
        }
        List<String> notes = dto.getNotes();
        BookingPassengerInfo bookingPassengerInfo = new BookingPassengerInfo(dto.getPassengerInfo());
        if (z5) {
            priceTotal = new PriceTotal(new PriceWithCurrency(dto.getTotalPrice()), new Price.Charge(1), false, 4, null);
        } else {
            priceTotal = new PriceTotal(new PriceWithCurrency(dto.getTotalPrice()));
        }
        Price charge = z5 ? new Price.Charge(1) : new PriceWithCurrency(dto.getTicketPrice());
        String ticketCategoryName = dto.getTicketCategoryName();
        String ticketTypeId = dto.getTicketTypeId();
        TransportResponseDTO transport = dto.getTransportInfo().getTransport();
        if (list != null) {
            Iterator<T> it3 = list.iterator();
            while (true) {
                if (it3.hasNext()) {
                    obj = it3.next();
                    if (Intrinsics.areEqual(((Transportation) obj).getId(), dto.getTransportInfo().getTransport().getId())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            Transportation transportation2 = (Transportation) obj;
            if (transportation2 != null) {
                name = transportation2.getName();
            }
        }
        name = dto.getTransportInfo().getTransport().getName();
        Transportation transportation3 = new Transportation(transport, name);
        String carId = dto.getTransportInfo().getCarId();
        List<BookingResponseDTO.BarcodeResponseDTO> barcodes = dto.getBarcodes();
        if (barcodes != null) {
            List<BookingResponseDTO.BarcodeResponseDTO> list2 = barcodes;
            transportation = transportation3;
            emptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it4 = list2.iterator();
            while (it4.hasNext()) {
                emptyList.add(new Barcode((BookingResponseDTO.BarcodeResponseDTO) it4.next()));
            }
        } else {
            transportation = transportation3;
            emptyList = CollectionsKt.emptyList();
        }
        List<ProductTypeResponseDTO> availableProductTypes = dto.getAvailableProductTypes();
        List<ProductTypeResponseDTO> emptyList2 = availableProductTypes == null ? CollectionsKt.emptyList() : availableProductTypes;
        List list3 = emptyList;
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(emptyList2, 10));
        Iterator<T> it5 = emptyList2.iterator();
        while (it5.hasNext()) {
            arrayList5.add(ProductType.INSTANCE.invoke((ProductTypeResponseDTO) it5.next()));
        }
        BookingResponseDTO.BookingSeatReservationDTO seatReservation = dto.getSeatReservation();
        BookingSeatReservation bookingSeatReservation = seatReservation != null ? new BookingSeatReservation(seatReservation) : null;
        List<TicketSurchargeDTO> surcharges = dto.getSurcharges();
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(surcharges, 10));
        for (Iterator it6 = surcharges.iterator(); it6.hasNext(); it6 = it6) {
            arrayList6.add(new TicketSurcharge((TicketSurchargeDTO) it6.next()));
        }
    }
}
