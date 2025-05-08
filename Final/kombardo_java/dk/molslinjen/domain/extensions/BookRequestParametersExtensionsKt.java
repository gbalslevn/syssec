package dk.molslinjen.domain.extensions;

import dk.molslinjen.api.services.booking.request.BookRequestParameters;
import dk.molslinjen.api.services.booking.request.DirectionDTO;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.domain.model.booking.BookingTicket;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureTicket;
import dk.molslinjen.domain.model.booking.Goods;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.booking.RouteDirection;
import dk.molslinjen.domain.model.booking.TransportationCargoInfo;
import dk.molslinjen.domain.model.booking.product.CheckoutSeatReservation;
import dk.molslinjen.domain.model.booking.product.ISummaryProduct;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.config.Transportation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a|\u0010\u0019\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0086\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a^\u0010\u0019\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001d0\t2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0086\u0002¢\u0006\u0004\b\u0019\u0010\u001e\u001a2\u0010\u0019\u001a\u00020!*\u00020\u001f2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010 \u001a\u00020\u0012H\u0082\u0002¢\u0006\u0004\b\u0019\u0010\"\u001a\u001c\u0010\u0019\u001a\u00020%*\u00020#2\u0006\u0010$\u001a\u00020\u001dH\u0082\u0002¢\u0006\u0004\b\u0019\u0010&¨\u0006'"}, d2 = {"Ldk/molslinjen/api/services/booking/request/BookRequestParameters$TicketRequestParameters$Companion;", "Ldk/molslinjen/domain/model/booking/Departure;", "departure", "Ldk/molslinjen/domain/model/booking/DepartureTicket;", "departureTicket", "Ldk/molslinjen/domain/model/booking/RouteDirection;", "direction", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "passengerInfo", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "passengers", "Ldk/molslinjen/domain/model/config/Transportation;", "transportation", "Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;", "cargoInfo", "Ldk/molslinjen/domain/model/booking/product/Product;", "products", BuildConfig.FLAVOR, "earlyCheckIn", BuildConfig.FLAVOR, "regionId", "Ldk/molslinjen/domain/model/booking/product/CheckoutSeatReservation;", "seatReservation", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$TicketRequestParameters;", "invoke", "(Ldk/molslinjen/api/services/booking/request/BookRequestParameters$TicketRequestParameters$Companion;Ldk/molslinjen/domain/model/booking/Departure;Ldk/molslinjen/domain/model/booking/DepartureTicket;Ldk/molslinjen/domain/model/booking/RouteDirection;Ldk/molslinjen/domain/model/booking/PassengerInfo;Ljava/util/List;Ldk/molslinjen/domain/model/config/Transportation;Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;Ljava/util/List;ZLjava/lang/String;Ldk/molslinjen/domain/model/booking/product/CheckoutSeatReservation;)Ldk/molslinjen/api/services/booking/request/BookRequestParameters$TicketRequestParameters;", "Ldk/molslinjen/domain/model/booking/BookingTicket;", "bookingTicket", "Ldk/molslinjen/domain/model/booking/product/ISummaryProduct;", "(Ldk/molslinjen/api/services/booking/request/BookRequestParameters$TicketRequestParameters$Companion;Ldk/molslinjen/domain/model/booking/BookingTicket;Ldk/molslinjen/domain/model/booking/RouteDirection;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ldk/molslinjen/domain/model/booking/product/CheckoutSeatReservation;)Ldk/molslinjen/api/services/booking/request/BookRequestParameters$TicketRequestParameters;", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$PassengerInfoRequestParameters$Companion;", "isWalking", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$PassengerInfoRequestParameters;", "(Ldk/molslinjen/api/services/booking/request/BookRequestParameters$PassengerInfoRequestParameters$Companion;Ldk/molslinjen/domain/model/booking/PassengerInfo;Ljava/util/List;Z)Ldk/molslinjen/api/services/booking/request/BookRequestParameters$PassengerInfoRequestParameters;", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$ProductRequestParameters$Companion;", "product", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$ProductRequestParameters;", "(Ldk/molslinjen/api/services/booking/request/BookRequestParameters$ProductRequestParameters$Companion;Ldk/molslinjen/domain/model/booking/product/ISummaryProduct;)Ldk/molslinjen/api/services/booking/request/BookRequestParameters$ProductRequestParameters;", "domain_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BookRequestParametersExtensionsKt {
    public static final BookRequestParameters.TicketRequestParameters invoke(BookRequestParameters.TicketRequestParameters.Companion companion, Departure departure, DepartureTicket departureTicket, RouteDirection direction, PassengerInfo passengerInfo, List<BookingPassenger> passengers, Transportation transportation, TransportationCargoInfo transportationCargoInfo, List<? extends Product> products, boolean z5, String regionId, CheckoutSeatReservation checkoutSeatReservation) {
        Double totalWeight;
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(departure, "departure");
        Intrinsics.checkNotNullParameter(departureTicket, "departureTicket");
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(passengerInfo, "passengerInfo");
        Intrinsics.checkNotNullParameter(passengers, "passengers");
        Intrinsics.checkNotNullParameter(transportation, "transportation");
        Intrinsics.checkNotNullParameter(products, "products");
        Intrinsics.checkNotNullParameter(regionId, "regionId");
        String carId = departureTicket.getCarId();
        LocalDate date = departure.getDate();
        String id = departure.getId();
        DirectionDTO dto = direction.toDTO();
        BookRequestParameters.GoodsRequestParameters goodsRequestParameters = (transportationCargoInfo == null || (totalWeight = transportationCargoInfo.getTotalWeight()) == null) ? null : new BookRequestParameters.GoodsRequestParameters((int) totalWeight.doubleValue());
        List<String> listOf = CollectionsKt.listOf((Object[]) new String[]{transportationCargoInfo != null ? transportationCargoInfo.getNote1() : null, transportationCargoInfo != null ? transportationCargoInfo.getNote2() : null, transportationCargoInfo != null ? transportationCargoInfo.getNote3() : null});
        ArrayList arrayList = new ArrayList();
        for (String str : listOf) {
            if (str != null) {
                arrayList.add(str);
            }
        }
        BookRequestParameters.PassengerInfoRequestParameters invoke = invoke(BookRequestParameters.PassengerInfoRequestParameters.INSTANCE, passengerInfo, passengers, transportation.isWalking());
        List<? extends Product> list = products;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(invoke(BookRequestParameters.ProductRequestParameters.INSTANCE, (Product) it.next()));
        }
        return new BookRequestParameters.TicketRequestParameters(carId, date, id, dto, goodsRequestParameters, z5, arrayList, invoke, arrayList2, regionId, departure.getRouteId(), departureTicket.getCategory().getId(), transportation.getId(), checkoutSeatReservation != null ? checkoutSeatReservation.toBookRequestParameter() : null);
    }

    public static final BookRequestParameters.TicketRequestParameters invoke(BookRequestParameters.TicketRequestParameters.Companion companion, BookingTicket bookingTicket, RouteDirection direction, List<? extends ISummaryProduct> products, String regionId, Boolean bool, List<BookingPassenger> list, CheckoutSeatReservation checkoutSeatReservation) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(bookingTicket, "bookingTicket");
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(products, "products");
        Intrinsics.checkNotNullParameter(regionId, "regionId");
        String carId = bookingTicket.getCarId();
        LocalDate date = bookingTicket.getDeparture().getDate();
        String departureId = bookingTicket.getDeparture().getDepartureId();
        DirectionDTO dto = direction.toDTO();
        Goods goods = bookingTicket.getGoods();
        BookRequestParameters.GoodsRequestParameters goodsRequestParameters = goods != null ? new BookRequestParameters.GoodsRequestParameters((int) goods.getWeight()) : null;
        boolean booleanValue = bool != null ? bool.booleanValue() : bookingTicket.isCheckedIn();
        List<String> notes = bookingTicket.getNotes();
        ArrayList arrayList = new ArrayList();
        for (String str : notes) {
            if (str != null) {
                arrayList.add(str);
            }
        }
        BookRequestParameters.PassengerInfoRequestParameters invoke = invoke(BookRequestParameters.PassengerInfoRequestParameters.INSTANCE, bookingTicket.getPassengerInfo().toPassengerInfo(), list == null ? bookingTicket.getPassengerInfo().getPassengerData() : list, bookingTicket.getTransport().isWalking());
        List<? extends ISummaryProduct> list2 = products;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList2.add(invoke(BookRequestParameters.ProductRequestParameters.INSTANCE, (ISummaryProduct) it.next()));
        }
        return new BookRequestParameters.TicketRequestParameters(carId, date, departureId, dto, goodsRequestParameters, booleanValue, arrayList, invoke, arrayList2, regionId, bookingTicket.getDeparture().getRouteId(), bookingTicket.getTicketTypeId(), bookingTicket.getTransport().getId(), checkoutSeatReservation != null ? checkoutSeatReservation.toBookRequestParameter() : null);
    }

    private static final BookRequestParameters.PassengerInfoRequestParameters invoke(BookRequestParameters.PassengerInfoRequestParameters.Companion companion, PassengerInfo passengerInfo, List<BookingPassenger> list, boolean z5) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        List<BookingPassenger> list2 = list;
        boolean z6 = (list2.isEmpty() || z5) ? false : true;
        int size = z6 ? list2.size() : passengerInfo.getAdultCount();
        int childCount = z6 ? 0 : passengerInfo.getChildCount();
        int infantCount = z6 ? 0 : passengerInfo.getInfantCount();
        List<BookingPassenger> list3 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        for (BookingPassenger bookingPassenger : list3) {
            arrayList.add(new BookRequestParameters.PassengerDataRequestParameters(bookingPassenger.getBirthDate(), bookingPassenger.getFirstName(), bookingPassenger.getGender().toDTO(), bookingPassenger.getLastName(), bookingPassenger.getNationality()));
        }
        return new BookRequestParameters.PassengerInfoRequestParameters(size, childCount, infantCount, arrayList);
    }

    private static final BookRequestParameters.ProductRequestParameters invoke(BookRequestParameters.ProductRequestParameters.Companion companion, ISummaryProduct iSummaryProduct) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return new BookRequestParameters.ProductRequestParameters(iSummaryProduct.getId(), iSummaryProduct.getProductType().toDTO(), iSummaryProduct.getQuantity());
    }
}
