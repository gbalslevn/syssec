package dk.molslinjen.domain.managers.departure;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.booking.IBookingService;
import dk.molslinjen.api.services.booking.request.DepartureRequestParameters;
import dk.molslinjen.api.services.booking.response.DeparturesResponseDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.shared.response.CurrencyTypeDTO;
import dk.molslinjen.domain.managers.route.RouteSelectedState;
import dk.molslinjen.domain.managers.route.RouteSharedSelectedState;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardRouteState;
import dk.molslinjen.domain.model.booking.AuthenticationInfo;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.CommuterBookingData;
import dk.molslinjen.domain.model.booking.CustomerInfo;
import dk.molslinjen.domain.model.booking.DayDepartures;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureLoadingState;
import dk.molslinjen.domain.model.booking.DeparturesResponse;
import dk.molslinjen.domain.model.booking.MultiRideBookingData;
import dk.molslinjen.domain.model.booking.MultiRideInfo;
import dk.molslinjen.domain.model.booking.TimeTableStatus;
import dk.molslinjen.domain.model.booking.TransportationCargoInfo;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.TrailerProduct;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JX\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096@¢\u0006\u0002\u0010\u0019J2\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ:\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001eH\u0082@¢\u0006\u0002\u0010\u001fJ>\u0010 \u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0018\u0010 \u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u001aH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Ldk/molslinjen/domain/managers/departure/DepartureRequestHandler;", "Ldk/molslinjen/domain/managers/departure/IDepartureRequestHandler;", "bookingService", "Ldk/molslinjen/api/services/booking/IBookingService;", "<init>", "(Ldk/molslinjen/api/services/booking/IBookingService;)V", "currentRequestId", BuildConfig.FLAVOR, "currentRequestParameters", "Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters;", "getDepartures", "Ldk/molslinjen/domain/model/booking/DayDepartures;", "requestId", "sessionKey", "date", "Lorg/threeten/bp/LocalDate;", "state", "Ldk/molslinjen/domain/managers/route/RouteSelectedState;", "sharedState", "Ldk/molslinjen/domain/managers/route/RouteSharedSelectedState;", "outboundTripDepartureForReturn", "Ldk/molslinjen/domain/model/booking/Departure;", "outboundTripRouteStateForReturn", "existingBooking", "Ldk/molslinjen/domain/model/booking/Booking;", "(Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Ldk/molslinjen/domain/managers/route/RouteSelectedState;Ldk/molslinjen/domain/managers/route/RouteSharedSelectedState;Ldk/molslinjen/domain/model/booking/Departure;Ldk/molslinjen/domain/managers/route/RouteSelectedState;Ldk/molslinjen/domain/model/booking/Booking;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardRouteState;", "(Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardRouteState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestParameters", "site", "Ldk/molslinjen/domain/model/config/Site;", "(Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters;Ldk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildDepartureRequestParameters", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DepartureRequestHandler implements IDepartureRequestHandler {
    private final IBookingService bookingService;
    private String currentRequestId;
    private DepartureRequestParameters currentRequestParameters;

    public DepartureRequestHandler(IBookingService bookingService) {
        Intrinsics.checkNotNullParameter(bookingService, "bookingService");
        this.bookingService = bookingService;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0148 A[LOOP:0: B:30:0x0142->B:32:0x0148, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final DepartureRequestParameters buildDepartureRequestParameters(LocalDate date, RouteSelectedState state, RouteSharedSelectedState sharedState, Departure outboundTripDepartureForReturn, RouteSelectedState outboundTripRouteStateForReturn, Booking existingBooking) {
        String str;
        AuthenticationInfo authenticationInfo;
        String commuteAgreementId;
        MultiRideBookingData multiRideBookingData;
        DepartureRequestParameters.MultiRideRequestParameters multiRideRequestParameters;
        AuthenticationInfo authenticationInfo2;
        MultiRideInfo multiRideInfo;
        DepartureRequestParameters.MultiRideRequestParameters multiRideRequestParameters2;
        List emptyList;
        TrailerProduct copy;
        CustomerInfo customerInfo;
        PhoneNumber phoneNumber;
        DepartureRequestParameters.OutboundTripRequestParameters outboundTripRequestParameters = (outboundTripRouteStateForReturn == null || outboundTripDepartureForReturn == null) ? null : new DepartureRequestParameters.OutboundTripRequestParameters(outboundTripDepartureForReturn.getDate(), outboundTripDepartureForReturn.getDepartureTime(), new DepartureRequestParameters.DeparturePassengerInfoRequestParameters(outboundTripRouteStateForReturn.getPassengerInfo().getAdultCount(), outboundTripRouteStateForReturn.getPassengerInfo().getChildCount(), outboundTripRouteStateForReturn.getPassengerInfo().getInfantCount()), outboundTripRouteStateForReturn.getSelectedRouteDirectionGroup().getDepartureHarbor().getRegion().getId(), sharedState.getSelectedTransportation().getId());
        CommuterBookingData commuterBookingData = sharedState.getCommuterBookingData();
        if (commuterBookingData == null || (commuteAgreementId = commuterBookingData.getAgreementId()) == null) {
            if (existingBooking == null || (authenticationInfo = existingBooking.getAuthenticationInfo()) == null) {
                str = null;
                TransportationCargoInfo transportationCargoInfo = state.getTransportationCargoInfo();
                DepartureRequestParameters.GoodsRequestParameters goodsRequestParameters = new DepartureRequestParameters.GoodsRequestParameters(false, false, transportationCargoInfo == null ? transportationCargoInfo.getTotalWeight() : null);
                multiRideBookingData = sharedState.getMultiRideBookingData();
                if (multiRideBookingData == null) {
                    multiRideRequestParameters2 = new DepartureRequestParameters.MultiRideRequestParameters(multiRideBookingData.getTypeId(), multiRideBookingData.getCustomer(), multiRideBookingData.getAgreementNumber());
                } else if (existingBooking != null && (authenticationInfo2 = existingBooking.getAuthenticationInfo()) != null && (multiRideInfo = authenticationInfo2.getMultiRideInfo()) != null) {
                    multiRideRequestParameters2 = new DepartureRequestParameters.MultiRideRequestParameters(multiRideInfo.getCardType(), multiRideInfo.getCustomerId(), multiRideInfo.getCardNumber());
                } else {
                    multiRideRequestParameters = null;
                    DepartureRequestParameters.DeparturePassengerInfoRequestParameters departurePassengerInfoRequestParameters = new DepartureRequestParameters.DeparturePassengerInfoRequestParameters(state.getPassengerInfo().getAdultCount(), state.getPassengerInfo().getChildCount(), state.getPassengerInfo().getInfantCount());
                    String nationalNumber = (existingBooking != null || (customerInfo = existingBooking.getCustomerInfo()) == null || (phoneNumber = customerInfo.getPhoneNumber()) == null) ? null : phoneNumber.getNationalNumber();
                    String reservationNumber = existingBooking != null ? existingBooking.getReservationNumber() : null;
                    List<Product> selectedTransportProducts = state.getSelectedTransportProducts();
                    if (state.getSelectedTrailer() != null) {
                        copy = r19.copy((r33 & 1) != 0 ? r19.id : null, (r33 & 2) != 0 ? r19.name : null, (r33 & 4) != 0 ? r19.price : null, (r33 & 8) != 0 ? r19.originalPrice : null, (r33 & 16) != 0 ? r19.quantity : 1, (r33 & 32) != 0 ? r19.originalQuantity : 0, (r33 & 64) != 0 ? r19.disabled : false, (r33 & 128) != 0 ? r19.presentation : null, (r33 & 256) != 0 ? r19.productType : null, (r33 & 512) != 0 ? r19.recommended : false, (r33 & 1024) != 0 ? r19.tag : null, (r33 & 2048) != 0 ? r19.maxHeight : 0.0d, (r33 & 4096) != 0 ? r19.maxLength : 0.0d, (r33 & 8192) != 0 ? state.getSelectedTrailer().sortOrder : 0);
                        emptyList = CollectionsKt.listOf(copy);
                    } else {
                        emptyList = CollectionsKt.emptyList();
                    }
                    Set<Product> union = CollectionsKt.union(selectedTransportProducts, emptyList);
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(union, 10));
                    for (Product product : union) {
                        arrayList.add(new DepartureRequestParameters.ProductRequestParameters(product.getId(), product.getProductType().toDTO(), product.getQuantity()));
                    }
                    return new DepartureRequestParameters(str, date, goodsRequestParameters, multiRideRequestParameters, outboundTripRequestParameters, departurePassengerInfoRequestParameters, nationalNumber, (List) arrayList, state.getSelectedRouteDirectionGroup().getDepartureHarbor().getRegion().getId(), reservationNumber, state.getSelectedRouteDirectionGroup().getMainRouteId(), sharedState.getSelectedTransportation().getId(), sharedState.getCurrency().toDTO(), false, 8192, (DefaultConstructorMarker) null);
                }
                multiRideRequestParameters = multiRideRequestParameters2;
                DepartureRequestParameters.DeparturePassengerInfoRequestParameters departurePassengerInfoRequestParameters2 = new DepartureRequestParameters.DeparturePassengerInfoRequestParameters(state.getPassengerInfo().getAdultCount(), state.getPassengerInfo().getChildCount(), state.getPassengerInfo().getInfantCount());
                if (existingBooking != null) {
                }
                String reservationNumber2 = existingBooking != null ? existingBooking.getReservationNumber() : null;
                List<Product> selectedTransportProducts2 = state.getSelectedTransportProducts();
                if (state.getSelectedTrailer() != null) {
                }
                Set<Product> union2 = CollectionsKt.union(selectedTransportProducts2, emptyList);
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(union2, 10));
                while (r0.hasNext()) {
                }
                return new DepartureRequestParameters(str, date, goodsRequestParameters, multiRideRequestParameters, outboundTripRequestParameters, departurePassengerInfoRequestParameters2, nationalNumber, (List) arrayList2, state.getSelectedRouteDirectionGroup().getDepartureHarbor().getRegion().getId(), reservationNumber2, state.getSelectedRouteDirectionGroup().getMainRouteId(), sharedState.getSelectedTransportation().getId(), sharedState.getCurrency().toDTO(), false, 8192, (DefaultConstructorMarker) null);
            }
            commuteAgreementId = authenticationInfo.getCommuteAgreementId();
        }
        str = commuteAgreementId;
        TransportationCargoInfo transportationCargoInfo2 = state.getTransportationCargoInfo();
        DepartureRequestParameters.GoodsRequestParameters goodsRequestParameters2 = new DepartureRequestParameters.GoodsRequestParameters(false, false, transportationCargoInfo2 == null ? transportationCargoInfo2.getTotalWeight() : null);
        multiRideBookingData = sharedState.getMultiRideBookingData();
        if (multiRideBookingData == null) {
        }
        multiRideRequestParameters = multiRideRequestParameters2;
        DepartureRequestParameters.DeparturePassengerInfoRequestParameters departurePassengerInfoRequestParameters22 = new DepartureRequestParameters.DeparturePassengerInfoRequestParameters(state.getPassengerInfo().getAdultCount(), state.getPassengerInfo().getChildCount(), state.getPassengerInfo().getInfantCount());
        if (existingBooking != null) {
        }
        String reservationNumber22 = existingBooking != null ? existingBooking.getReservationNumber() : null;
        List<Product> selectedTransportProducts22 = state.getSelectedTransportProducts();
        if (state.getSelectedTrailer() != null) {
        }
        Set<Product> union22 = CollectionsKt.union(selectedTransportProducts22, emptyList);
        ArrayList arrayList22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(union22, 10));
        while (r0.hasNext()) {
        }
        return new DepartureRequestParameters(str, date, goodsRequestParameters2, multiRideRequestParameters, outboundTripRequestParameters, departurePassengerInfoRequestParameters22, nationalNumber, (List) arrayList22, state.getSelectedRouteDirectionGroup().getDepartureHarbor().getRegion().getId(), reservationNumber22, state.getSelectedRouteDirectionGroup().getMainRouteId(), sharedState.getSelectedTransportation().getId(), sharedState.getCurrency().toDTO(), false, 8192, (DefaultConstructorMarker) null);
    }

    @Override // dk.molslinjen.domain.managers.departure.IDepartureRequestHandler
    public Object getDepartures(String str, String str2, LocalDate localDate, RouteSelectedState routeSelectedState, RouteSharedSelectedState routeSharedSelectedState, Departure departure, RouteSelectedState routeSelectedState2, Booking booking, Continuation<? super DayDepartures> continuation) {
        return getDepartures(str, str2, localDate, buildDepartureRequestParameters(localDate, routeSelectedState, routeSharedSelectedState, departure, routeSelectedState2, booking), routeSharedSelectedState.getSite(), continuation);
    }

    @Override // dk.molslinjen.domain.managers.departure.IDepartureRequestHandler
    public Object getDepartures(String str, String str2, LocalDate localDate, SaleOnBoardRouteState saleOnBoardRouteState, Continuation<? super DayDepartures> continuation) {
        return getDepartures(str, str2, localDate, buildDepartureRequestParameters(localDate, saleOnBoardRouteState), saleOnBoardRouteState.getSite(), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getDepartures(String str, String str2, LocalDate localDate, DepartureRequestParameters departureRequestParameters, Site site, Continuation<? super DayDepartures> continuation) {
        DepartureRequestHandler$getDepartures$3 departureRequestHandler$getDepartures$3;
        int i5;
        DepartureRequestParameters departureRequestParameters2;
        LocalDate localDate2;
        Object departures;
        DepartureRequestHandler departureRequestHandler;
        ApiResult apiResult;
        String str3 = str;
        if (continuation instanceof DepartureRequestHandler$getDepartures$3) {
            departureRequestHandler$getDepartures$3 = (DepartureRequestHandler$getDepartures$3) continuation;
            int i6 = departureRequestHandler$getDepartures$3.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                departureRequestHandler$getDepartures$3.label = i6 - Integer.MIN_VALUE;
                Object obj = departureRequestHandler$getDepartures$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = departureRequestHandler$getDepartures$3.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!Intrinsics.areEqual(this.currentRequestId, str)) {
                        this.currentRequestParameters = null;
                    }
                    departureRequestParameters2 = this.currentRequestParameters;
                    if (departureRequestParameters2 == null) {
                        departureRequestParameters2 = departureRequestParameters;
                    }
                    this.currentRequestId = str3;
                    IBookingService iBookingService = this.bookingService;
                    SiteDTO dto = site.toDTO();
                    departureRequestHandler$getDepartures$3.L$0 = this;
                    departureRequestHandler$getDepartures$3.L$1 = str3;
                    localDate2 = localDate;
                    departureRequestHandler$getDepartures$3.L$2 = localDate2;
                    departureRequestHandler$getDepartures$3.L$3 = departureRequestParameters2;
                    departureRequestHandler$getDepartures$3.label = 1;
                    departures = iBookingService.getDepartures(departureRequestParameters2, dto, str2, departureRequestHandler$getDepartures$3);
                    if (departures == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    departureRequestHandler = this;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    DepartureRequestParameters departureRequestParameters3 = (DepartureRequestParameters) departureRequestHandler$getDepartures$3.L$3;
                    LocalDate localDate3 = (LocalDate) departureRequestHandler$getDepartures$3.L$2;
                    String str4 = (String) departureRequestHandler$getDepartures$3.L$1;
                    DepartureRequestHandler departureRequestHandler2 = (DepartureRequestHandler) departureRequestHandler$getDepartures$3.L$0;
                    ResultKt.throwOnFailure(obj);
                    localDate2 = localDate3;
                    departureRequestHandler = departureRequestHandler2;
                    departures = obj;
                    departureRequestParameters2 = departureRequestParameters3;
                    str3 = str4;
                }
                apiResult = (ApiResult) departures;
                if (!(apiResult instanceof ApiResult.Success)) {
                    if (!Intrinsics.areEqual(departureRequestHandler.currentRequestId, str3)) {
                        return null;
                    }
                    DeparturesResponse departuresResponse = new DeparturesResponse((DeparturesResponseDTO) ((ApiResult.Success) apiResult).getData(), departureRequestParameters2.getMultiRide() != null, departureRequestParameters2.getReservationNumber() != null);
                    return new DayDepartures(localDate2, departuresResponse.getDepartures(), DepartureLoadingState.Loaded, departuresResponse.getTimeTableStatus(), departuresResponse.getSiteDeparturesNotice());
                }
                if (apiResult instanceof ApiResult.Error) {
                    return new DayDepartures(localDate2, CollectionsKt.emptyList(), DepartureLoadingState.Error, TimeTableStatus.NotAvailable, null);
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        departureRequestHandler$getDepartures$3 = new DepartureRequestHandler$getDepartures$3(this, continuation);
        Object obj2 = departureRequestHandler$getDepartures$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = departureRequestHandler$getDepartures$3.label;
        if (i5 != 0) {
        }
        apiResult = (ApiResult) departures;
        if (!(apiResult instanceof ApiResult.Success)) {
        }
    }

    private final DepartureRequestParameters buildDepartureRequestParameters(LocalDate date, SaleOnBoardRouteState state) {
        return new DepartureRequestParameters(null, date, null, null, null, new DepartureRequestParameters.DeparturePassengerInfoRequestParameters(1, 0, 0), null, CollectionsKt.emptyList(), state.getSelectedRouteDirectionGroup().getDepartureHarbor().getRegion().getId(), null, state.getSelectedRouteDirectionGroup().getMainRouteId(), state.getTransportation().getId(), CurrencyTypeDTO.DKK, true);
    }
}
