package dk.molslinjen.domain.managers.checkout;

import com.sun.jna.Function;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import dk.molslinjen.api.services.booking.IBookingService;
import dk.molslinjen.api.services.booking.request.BookRequestParameters;
import dk.molslinjen.api.services.booking.request.PaymentTypeRequestParameters;
import dk.molslinjen.api.services.booking.response.booking.ApiAppPaymentRedirectDetailsDTO;
import dk.molslinjen.api.services.booking.response.booking.BookingCompletedResponseDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.shared.request.PaymentDataRequestParameters;
import dk.molslinjen.api.shared.response.CurrencyTypeDTO;
import dk.molslinjen.core.Environment;
import dk.molslinjen.core.extensions.IpHelperKt;
import dk.molslinjen.core.providers.IPaymentCallbackUrlProvider;
import dk.molslinjen.domain.analytics.AnalyticsStateTrackingHelper;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.extensions.BookRequestParametersExtensionsKt;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.checkout.AddonHelper;
import dk.molslinjen.domain.managers.checkout.IPaymentManager;
import dk.molslinjen.domain.managers.checkout.PaymentManager;
import dk.molslinjen.domain.managers.checkout.SimpleChangeCheckoutManager;
import dk.molslinjen.domain.managers.ticket.ITicketsManager;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.account.AuthToken;
import dk.molslinjen.domain.model.account.CreditCard;
import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.BookingCompleted;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.domain.model.booking.BookingSeatReservation;
import dk.molslinjen.domain.model.booking.BookingTicket;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.CustomerInfo;
import dk.molslinjen.domain.model.booking.MultiRideInfo;
import dk.molslinjen.domain.model.booking.RouteDirection;
import dk.molslinjen.domain.model.booking.product.CheckoutSeatReservation;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.ProductGroup;
import dk.molslinjen.domain.model.payment.PaymentType;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.SeatReservationId;
import uniffi.molslinjen_shared.SelectSeatingHandlerInterface;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001>BI\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J \u0010\"\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010,\u001a\u00020\u001cH\u0002J\u000e\u0010-\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010.J\u001a\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0016J$\u00104\u001a\b\u0012\u0004\u0012\u000206052\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u000208H\u0096@¢\u0006\u0002\u0010:J\u0018\u0010;\u001a\u00020<2\u0006\u0010\u0014\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010=\u001a\u00020\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/SimpleChangeCheckoutManager;", "Ldk/molslinjen/domain/managers/checkout/ISimpleChangeCheckoutManager;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "bookingService", "Ldk/molslinjen/api/services/booking/IBookingService;", "paymentManager", "Ldk/molslinjen/domain/managers/checkout/IPaymentManager;", "earlyCheckInPassengerManager", "Ldk/molslinjen/domain/managers/checkout/IEarlyCheckInPassengerManager;", "ticketsManager", "Ldk/molslinjen/domain/managers/ticket/ITicketsManager;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "selectSeatingHandler", "Luniffi/molslinjen_shared/SelectSeatingHandlerInterface;", "paymentCallbackUrlProvider", "Ldk/molslinjen/core/providers/IPaymentCallbackUrlProvider;", "<init>", "(Ldk/molslinjen/domain/managers/user/IUserManager;Ldk/molslinjen/api/services/booking/IBookingService;Ldk/molslinjen/domain/managers/checkout/IPaymentManager;Ldk/molslinjen/domain/managers/checkout/IEarlyCheckInPassengerManager;Ldk/molslinjen/domain/managers/ticket/ITicketsManager;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;Luniffi/molslinjen_shared/SelectSeatingHandlerInterface;Ldk/molslinjen/core/providers/IPaymentCallbackUrlProvider;)V", "simpleChangeCheckoutState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/managers/checkout/SimpleChangeCheckoutManager$SimpleChangeCheckoutState;", "getSimpleChangeCheckoutState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "listenSeatReservationInvalidation", BuildConfig.FLAVOR, "setup", "existingBooking", "Ldk/molslinjen/domain/model/booking/Booking;", "earlyCheckIn", BuildConfig.FLAVOR, "setEarlyCheckIn", "passengers", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "vehicle", "Ldk/molslinjen/domain/model/account/UserVehicle;", "updateAddons", "addonState", "Ldk/molslinjen/domain/managers/checkout/AddonHelper$AddonState;", "updateFood", "listenForPayment", "handlePurchaseCompleted", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectPaymentMethod", "paymentType", "Ldk/molslinjen/domain/model/payment/PaymentType;", "creditCard", "Ldk/molslinjen/domain/model/account/CreditCard;", "createBooking", "Ldk/molslinjen/domain/managers/ManagerResult;", "Ldk/molslinjen/domain/model/booking/BookingCompleted;", "screenWidth", BuildConfig.FLAVOR, "screenHeight", "(FFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildTicketRequestParameters", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$TicketRequestParameters;", "totalPriceUpdater", "SimpleChangeCheckoutState", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SimpleChangeCheckoutManager implements ISimpleChangeCheckoutManager {
    private final IAnalyticsTracker analyticsTracker;
    private final IBookingService bookingService;
    private final CoroutineScope coroutineScope;
    private final IEarlyCheckInPassengerManager earlyCheckInPassengerManager;
    private final IPaymentCallbackUrlProvider paymentCallbackUrlProvider;
    private final IPaymentManager paymentManager;
    private final SelectSeatingHandlerInterface selectSeatingHandler;
    private final MutableStateFlow<SimpleChangeCheckoutState> simpleChangeCheckoutState;
    private final ITicketsManager ticketsManager;
    private final IUserManager userManager;

    public SimpleChangeCheckoutManager(IUserManager userManager, IBookingService bookingService, IPaymentManager paymentManager, IEarlyCheckInPassengerManager earlyCheckInPassengerManager, ITicketsManager ticketsManager, IAnalyticsTracker analyticsTracker, SelectSeatingHandlerInterface selectSeatingHandler, IPaymentCallbackUrlProvider paymentCallbackUrlProvider) {
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(bookingService, "bookingService");
        Intrinsics.checkNotNullParameter(paymentManager, "paymentManager");
        Intrinsics.checkNotNullParameter(earlyCheckInPassengerManager, "earlyCheckInPassengerManager");
        Intrinsics.checkNotNullParameter(ticketsManager, "ticketsManager");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        Intrinsics.checkNotNullParameter(selectSeatingHandler, "selectSeatingHandler");
        Intrinsics.checkNotNullParameter(paymentCallbackUrlProvider, "paymentCallbackUrlProvider");
        this.userManager = userManager;
        this.bookingService = bookingService;
        this.paymentManager = paymentManager;
        this.earlyCheckInPassengerManager = earlyCheckInPassengerManager;
        this.ticketsManager = ticketsManager;
        this.analyticsTracker = analyticsTracker;
        this.selectSeatingHandler = selectSeatingHandler;
        this.paymentCallbackUrlProvider = paymentCallbackUrlProvider;
        this.simpleChangeCheckoutState = StateFlowKt.MutableStateFlow(new SimpleChangeCheckoutState(null, false, null, null, null, null, null, null, null, null, null, 2047, null));
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        listenForPayment();
        totalPriceUpdater();
        listenSeatReservationInvalidation();
    }

    private final BookRequestParameters.TicketRequestParameters buildTicketRequestParameters(SimpleChangeCheckoutState simpleChangeCheckoutState, Booking existingBooking) {
        BookRequestParameters.TicketRequestParameters.Companion companion = BookRequestParameters.TicketRequestParameters.INSTANCE;
        BookingTicket ticket = existingBooking.getTicket();
        RouteDirection routeDirection = RouteDirection.Outbound;
        List list = CollectionsKt.toList(CollectionsKt.union(CollectionsKt.union(CollectionsKt.union(existingBooking.getTicket().getTransportProducts(), existingBooking.getTicket().getProducts()), simpleChangeCheckoutState.getAddons()), simpleChangeCheckoutState.getFood()));
        String regionId = existingBooking.getTicket().getDeparture().getRegionId();
        Boolean earlyCheckIn = simpleChangeCheckoutState.getEarlyCheckIn();
        List<BookingPassenger> earlyCheckInPassengers = simpleChangeCheckoutState.getEarlyCheckInPassengers();
        CheckoutSeatReservation checkoutSeatReservation = null;
        if (earlyCheckInPassengers.isEmpty()) {
            earlyCheckInPassengers = null;
        }
        List<BookingPassenger> list2 = earlyCheckInPassengers;
        BookingSeatReservation seatReservation = existingBooking.getTicket().getSeatReservation();
        if (seatReservation != null && !simpleChangeCheckoutState.getInvalidateSeatReservation()) {
            checkoutSeatReservation = new CheckoutSeatReservation(seatReservation);
        }
        return BookRequestParametersExtensionsKt.invoke(companion, ticket, routeDirection, list, regionId, earlyCheckIn, list2, checkoutSeatReservation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BookingCompleted createBooking$lambda$10(SimpleChangeCheckoutManager simpleChangeCheckoutManager, SimpleChangeCheckoutState simpleChangeCheckoutState, BookingCompletedResponseDTO it) {
        SimpleChangeCheckoutState value;
        Intrinsics.checkNotNullParameter(it, "it");
        BookingCompleted invoke = BookingCompleted.INSTANCE.invoke(it);
        MutableStateFlow<SimpleChangeCheckoutState> simpleChangeCheckoutState2 = simpleChangeCheckoutManager.getSimpleChangeCheckoutState();
        do {
            value = simpleChangeCheckoutState2.getValue();
        } while (!simpleChangeCheckoutState2.compareAndSet(value, SimpleChangeCheckoutState.copy$default(value, null, false, null, null, null, null, null, invoke.getOutboundReservationNumber(), null, null, null, 1919, null)));
        IPaymentManager.DefaultImpls.setPaymentData$default(simpleChangeCheckoutManager.paymentManager, invoke.getOutboundReservationNumber(), simpleChangeCheckoutState.getSelectedPaymentType(), invoke.getBookingProcessingResult(), false, 8, null);
        return invoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handlePurchaseCompleted(Continuation<? super Unit> continuation) {
        SimpleChangeCheckoutManager$handlePurchaseCompleted$1 simpleChangeCheckoutManager$handlePurchaseCompleted$1;
        int i5;
        if (continuation instanceof SimpleChangeCheckoutManager$handlePurchaseCompleted$1) {
            simpleChangeCheckoutManager$handlePurchaseCompleted$1 = (SimpleChangeCheckoutManager$handlePurchaseCompleted$1) continuation;
            int i6 = simpleChangeCheckoutManager$handlePurchaseCompleted$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                simpleChangeCheckoutManager$handlePurchaseCompleted$1.label = i6 - Integer.MIN_VALUE;
                Object obj = simpleChangeCheckoutManager$handlePurchaseCompleted$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = simpleChangeCheckoutManager$handlePurchaseCompleted$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    StateFlow<PaymentManager.PaymentState> paymentState = this.paymentManager.getPaymentState();
                    SimpleChangeCheckoutManager$handlePurchaseCompleted$2 simpleChangeCheckoutManager$handlePurchaseCompleted$2 = new SimpleChangeCheckoutManager$handlePurchaseCompleted$2(this);
                    simpleChangeCheckoutManager$handlePurchaseCompleted$1.label = 1;
                    if (paymentState.collect(simpleChangeCheckoutManager$handlePurchaseCompleted$2, simpleChangeCheckoutManager$handlePurchaseCompleted$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
        }
        simpleChangeCheckoutManager$handlePurchaseCompleted$1 = new SimpleChangeCheckoutManager$handlePurchaseCompleted$1(this, continuation);
        Object obj2 = simpleChangeCheckoutManager$handlePurchaseCompleted$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = simpleChangeCheckoutManager$handlePurchaseCompleted$1.label;
        if (i5 != 0) {
        }
        throw new KotlinNothingValueException();
    }

    private final void listenForPayment() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new SimpleChangeCheckoutManager$listenForPayment$1(this, null), 3, null);
    }

    private final void listenSeatReservationInvalidation() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new SimpleChangeCheckoutManager$listenSeatReservationInvalidation$1(this, null), 3, null);
    }

    private final void totalPriceUpdater() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new SimpleChangeCheckoutManager$totalPriceUpdater$1(this, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01bf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    @Override // dk.molslinjen.domain.managers.checkout.ISimpleChangeCheckoutManager, dk.molslinjen.domain.managers.checkout.ICreateBooking
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object createBooking(float f5, float f6, Continuation<? super ManagerResult<BookingCompleted>> continuation) {
        SimpleChangeCheckoutManager$createBooking$1 simpleChangeCheckoutManager$createBooking$1;
        Object obj;
        Object coroutine_suspended;
        int i5;
        SimpleChangeCheckoutState value;
        Booking existingBooking;
        CustomerInfo customerInfo;
        float f7;
        float f8;
        float f9;
        float f10;
        SimpleChangeCheckoutManager simpleChangeCheckoutManager;
        final SimpleChangeCheckoutState simpleChangeCheckoutState;
        final SimpleChangeCheckoutManager simpleChangeCheckoutManager2;
        String licensePlate;
        if (continuation instanceof SimpleChangeCheckoutManager$createBooking$1) {
            simpleChangeCheckoutManager$createBooking$1 = (SimpleChangeCheckoutManager$createBooking$1) continuation;
            int i6 = simpleChangeCheckoutManager$createBooking$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                simpleChangeCheckoutManager$createBooking$1.label = i6 - Integer.MIN_VALUE;
                SimpleChangeCheckoutManager$createBooking$1 simpleChangeCheckoutManager$createBooking$12 = simpleChangeCheckoutManager$createBooking$1;
                obj = simpleChangeCheckoutManager$createBooking$12.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = simpleChangeCheckoutManager$createBooking$12.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    this.paymentManager.restartPaymentFlow();
                    value = getSimpleChangeCheckoutState().getValue();
                    existingBooking = value.getExistingBooking();
                    if (existingBooking == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    customerInfo = existingBooking.getCustomerInfo();
                    BookingSeatReservation seatReservation = existingBooking.getTicket().getSeatReservation();
                    if (!value.getInvalidateSeatReservation() || seatReservation == null) {
                        f7 = f5;
                        f8 = f6;
                    } else {
                        SelectSeatingHandlerInterface selectSeatingHandlerInterface = this.selectSeatingHandler;
                        SeatReservationId id = seatReservation.getId();
                        simpleChangeCheckoutManager$createBooking$12.L$0 = this;
                        simpleChangeCheckoutManager$createBooking$12.L$1 = value;
                        simpleChangeCheckoutManager$createBooking$12.L$2 = existingBooking;
                        simpleChangeCheckoutManager$createBooking$12.L$3 = customerInfo;
                        f7 = f5;
                        simpleChangeCheckoutManager$createBooking$12.F$0 = f7;
                        f8 = f6;
                        simpleChangeCheckoutManager$createBooking$12.F$1 = f8;
                        simpleChangeCheckoutManager$createBooking$12.label = 1;
                        if (selectSeatingHandlerInterface.unReserveSeats(id, simpleChangeCheckoutManager$createBooking$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    f9 = f7;
                    f10 = f8;
                    simpleChangeCheckoutManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        simpleChangeCheckoutState = (SimpleChangeCheckoutState) simpleChangeCheckoutManager$createBooking$12.L$1;
                        simpleChangeCheckoutManager2 = (SimpleChangeCheckoutManager) simpleChangeCheckoutManager$createBooking$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj, new Function1() { // from class: B1.j
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                BookingCompleted createBooking$lambda$10;
                                createBooking$lambda$10 = SimpleChangeCheckoutManager.createBooking$lambda$10(SimpleChangeCheckoutManager.this, simpleChangeCheckoutState, (BookingCompletedResponseDTO) obj2);
                                return createBooking$lambda$10;
                            }
                        });
                    }
                    f10 = simpleChangeCheckoutManager$createBooking$12.F$1;
                    f9 = simpleChangeCheckoutManager$createBooking$12.F$0;
                    customerInfo = (CustomerInfo) simpleChangeCheckoutManager$createBooking$12.L$3;
                    existingBooking = (Booking) simpleChangeCheckoutManager$createBooking$12.L$2;
                    value = (SimpleChangeCheckoutState) simpleChangeCheckoutManager$createBooking$12.L$1;
                    simpleChangeCheckoutManager = (SimpleChangeCheckoutManager) simpleChangeCheckoutManager$createBooking$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                IBookingService iBookingService = simpleChangeCheckoutManager.bookingService;
                CurrencyTypeDTO dto = existingBooking.getOrderTotal().getPrice().getCurrencyType().toDTO();
                String email = customerInfo.getEmail();
                String nationalNumber = customerInfo.getPhoneNumber().getNationalNumber();
                String postalCode = customerInfo.getPostalCode();
                String countryCode = customerInfo.getPhoneNumber().getCountryCode();
                UserVehicle earlyCheckInVehicle = value.getEarlyCheckInVehicle();
                BookRequestParameters.CustomerInfoRequestParameters customerInfoRequestParameters = new BookRequestParameters.CustomerInfoRequestParameters(email, nationalNumber, postalCode, countryCode, (earlyCheckInVehicle != null || (licensePlate = earlyCheckInVehicle.getLicensePlate()) == null) ? customerInfo.getLicensePlate() : licensePlate);
                List listOf = CollectionsKt.listOf(simpleChangeCheckoutManager.buildTicketRequestParameters(value, existingBooking));
                String commuteAgreementId = existingBooking.getCommuteAgreementId();
                MultiRideInfo multiRideInfo = existingBooking.getMultiRideInfo();
                BookRequestParameters.BookingRequestParameters bookingRequestParameters = new BookRequestParameters.BookingRequestParameters(customerInfoRequestParameters, listOf, commuteAgreementId, multiRideInfo == null ? multiRideInfo.toRequestParameters() : null, existingBooking.getReservationNumber(), dto, existingBooking.getCustomerInfo().getPhoneNumber().getNationalNumber());
                PaymentTypeRequestParameters requestParameters = value.getSelectedPaymentType().toDTO().toRequestParameters();
                String paymentCallbackUrl = simpleChangeCheckoutManager.paymentCallbackUrlProvider.getPaymentCallbackUrl();
                String paymentCallbackUrl2 = simpleChangeCheckoutManager.paymentCallbackUrlProvider.getPaymentCallbackUrl();
                CreditCard selectedCreditCard = value.getSelectedCreditCard();
                PaymentDataRequestParameters paymentDataRequestParameters = new PaymentDataRequestParameters(selectedCreditCard == null ? selectedCreditCard.getCreditCardToken() : null, paymentCallbackUrl, paymentCallbackUrl2);
                String str = (!Environment.INSTANCE.isMolslinjen() ? "AP51" : "KE11").toString();
                String language = Locale.getDefault().getLanguage();
                Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
                BookRequestParameters bookRequestParameters = new BookRequestParameters(bookingRequestParameters, requestParameters, false, false, new ApiAppPaymentRedirectDetailsDTO(f10, f9, language, IpHelperKt.getIpAddress()), paymentDataRequestParameters, str);
                SiteDTO dto2 = existingBooking.getSite().toDTO();
                String mo3198getAuthTokenOEbVFrA = simpleChangeCheckoutManager.userManager.mo3198getAuthTokenOEbVFrA();
                AuthTokenDTO m3214toDTOimpl = mo3198getAuthTokenOEbVFrA == null ? AuthToken.m3214toDTOimpl(mo3198getAuthTokenOEbVFrA) : null;
                simpleChangeCheckoutManager$createBooking$12.L$0 = simpleChangeCheckoutManager;
                simpleChangeCheckoutManager$createBooking$12.L$1 = value;
                simpleChangeCheckoutManager$createBooking$12.L$2 = null;
                simpleChangeCheckoutManager$createBooking$12.L$3 = null;
                simpleChangeCheckoutManager$createBooking$12.label = 2;
                obj = iBookingService.book(bookRequestParameters, dto2, m3214toDTOimpl, null, simpleChangeCheckoutManager$createBooking$12);
                if (obj != coroutine_suspended) {
                    return coroutine_suspended;
                }
                simpleChangeCheckoutState = value;
                simpleChangeCheckoutManager2 = simpleChangeCheckoutManager;
                return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj, new Function1() { // from class: B1.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        BookingCompleted createBooking$lambda$10;
                        createBooking$lambda$10 = SimpleChangeCheckoutManager.createBooking$lambda$10(SimpleChangeCheckoutManager.this, simpleChangeCheckoutState, (BookingCompletedResponseDTO) obj2);
                        return createBooking$lambda$10;
                    }
                });
            }
        }
        simpleChangeCheckoutManager$createBooking$1 = new SimpleChangeCheckoutManager$createBooking$1(this, continuation);
        SimpleChangeCheckoutManager$createBooking$1 simpleChangeCheckoutManager$createBooking$122 = simpleChangeCheckoutManager$createBooking$1;
        obj = simpleChangeCheckoutManager$createBooking$122.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = simpleChangeCheckoutManager$createBooking$122.label;
        if (i5 != 0) {
        }
        IBookingService iBookingService2 = simpleChangeCheckoutManager.bookingService;
        CurrencyTypeDTO dto3 = existingBooking.getOrderTotal().getPrice().getCurrencyType().toDTO();
        String email2 = customerInfo.getEmail();
        String nationalNumber2 = customerInfo.getPhoneNumber().getNationalNumber();
        String postalCode2 = customerInfo.getPostalCode();
        String countryCode2 = customerInfo.getPhoneNumber().getCountryCode();
        UserVehicle earlyCheckInVehicle2 = value.getEarlyCheckInVehicle();
        BookRequestParameters.CustomerInfoRequestParameters customerInfoRequestParameters2 = new BookRequestParameters.CustomerInfoRequestParameters(email2, nationalNumber2, postalCode2, countryCode2, (earlyCheckInVehicle2 != null || (licensePlate = earlyCheckInVehicle2.getLicensePlate()) == null) ? customerInfo.getLicensePlate() : licensePlate);
        List listOf2 = CollectionsKt.listOf(simpleChangeCheckoutManager.buildTicketRequestParameters(value, existingBooking));
        String commuteAgreementId2 = existingBooking.getCommuteAgreementId();
        MultiRideInfo multiRideInfo2 = existingBooking.getMultiRideInfo();
        BookRequestParameters.BookingRequestParameters bookingRequestParameters2 = new BookRequestParameters.BookingRequestParameters(customerInfoRequestParameters2, listOf2, commuteAgreementId2, multiRideInfo2 == null ? multiRideInfo2.toRequestParameters() : null, existingBooking.getReservationNumber(), dto3, existingBooking.getCustomerInfo().getPhoneNumber().getNationalNumber());
        PaymentTypeRequestParameters requestParameters2 = value.getSelectedPaymentType().toDTO().toRequestParameters();
        String paymentCallbackUrl3 = simpleChangeCheckoutManager.paymentCallbackUrlProvider.getPaymentCallbackUrl();
        String paymentCallbackUrl22 = simpleChangeCheckoutManager.paymentCallbackUrlProvider.getPaymentCallbackUrl();
        CreditCard selectedCreditCard2 = value.getSelectedCreditCard();
        PaymentDataRequestParameters paymentDataRequestParameters2 = new PaymentDataRequestParameters(selectedCreditCard2 == null ? selectedCreditCard2.getCreditCardToken() : null, paymentCallbackUrl3, paymentCallbackUrl22);
        String str2 = (!Environment.INSTANCE.isMolslinjen() ? "AP51" : "KE11").toString();
        String language2 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(language2, "getLanguage(...)");
        BookRequestParameters bookRequestParameters2 = new BookRequestParameters(bookingRequestParameters2, requestParameters2, false, false, new ApiAppPaymentRedirectDetailsDTO(f10, f9, language2, IpHelperKt.getIpAddress()), paymentDataRequestParameters2, str2);
        SiteDTO dto22 = existingBooking.getSite().toDTO();
        String mo3198getAuthTokenOEbVFrA2 = simpleChangeCheckoutManager.userManager.mo3198getAuthTokenOEbVFrA();
        if (mo3198getAuthTokenOEbVFrA2 == null) {
        }
        simpleChangeCheckoutManager$createBooking$122.L$0 = simpleChangeCheckoutManager;
        simpleChangeCheckoutManager$createBooking$122.L$1 = value;
        simpleChangeCheckoutManager$createBooking$122.L$2 = null;
        simpleChangeCheckoutManager$createBooking$122.L$3 = null;
        simpleChangeCheckoutManager$createBooking$122.label = 2;
        obj = iBookingService2.book(bookRequestParameters2, dto22, m3214toDTOimpl, null, simpleChangeCheckoutManager$createBooking$122);
        if (obj != coroutine_suspended) {
        }
    }

    @Override // dk.molslinjen.domain.managers.checkout.ISimpleChangeCheckoutManager
    public void selectPaymentMethod(PaymentType paymentType, CreditCard creditCard) {
        SimpleChangeCheckoutState value;
        Intrinsics.checkNotNullParameter(paymentType, "paymentType");
        MutableStateFlow<SimpleChangeCheckoutState> simpleChangeCheckoutState = getSimpleChangeCheckoutState();
        do {
            value = simpleChangeCheckoutState.getValue();
        } while (!simpleChangeCheckoutState.compareAndSet(value, SimpleChangeCheckoutState.copy$default(value, null, false, paymentType, creditCard, null, null, null, null, null, null, null, 2035, null)));
    }

    @Override // dk.molslinjen.domain.managers.checkout.ISimpleChangeCheckoutManager
    public void setEarlyCheckIn(List<BookingPassenger> passengers, UserVehicle vehicle) {
        SimpleChangeCheckoutState value;
        Intrinsics.checkNotNullParameter(passengers, "passengers");
        MutableStateFlow<SimpleChangeCheckoutState> simpleChangeCheckoutState = getSimpleChangeCheckoutState();
        do {
            value = simpleChangeCheckoutState.getValue();
        } while (!simpleChangeCheckoutState.compareAndSet(value, SimpleChangeCheckoutState.copy$default(value, null, false, null, null, null, null, null, null, Boolean.TRUE, vehicle, passengers, Function.USE_VARARGS, null)));
    }

    @Override // dk.molslinjen.domain.managers.checkout.ISimpleChangeCheckoutManager
    public void setup(Booking existingBooking, boolean earlyCheckIn) {
        Intrinsics.checkNotNullParameter(existingBooking, "existingBooking");
        this.paymentManager.resetPaymentState();
        MutableStateFlow<SimpleChangeCheckoutState> simpleChangeCheckoutState = getSimpleChangeCheckoutState();
        do {
        } while (!simpleChangeCheckoutState.compareAndSet(simpleChangeCheckoutState.getValue(), new SimpleChangeCheckoutState(existingBooking, false, null, null, null, null, null, null, Boolean.valueOf(earlyCheckIn), null, null, 1790, null)));
        this.analyticsTracker.updateBookingTypeStateTracking(true, AnalyticsStateTrackingHelper.BookingFlowTypeTracking.SimpleChange);
        this.analyticsTracker.updateBookingStateTracking(existingBooking.getSite(), BookingType.Single, existingBooking.getTicket().getTransport());
    }

    @Override // dk.molslinjen.domain.managers.checkout.ISimpleChangeCheckoutManager
    public void updateAddons(AddonHelper.AddonState addonState) {
        SimpleChangeCheckoutState value;
        SimpleChangeCheckoutState simpleChangeCheckoutState;
        List emptyList;
        Intrinsics.checkNotNullParameter(addonState, "addonState");
        MutableStateFlow<SimpleChangeCheckoutState> simpleChangeCheckoutState2 = getSimpleChangeCheckoutState();
        do {
            value = simpleChangeCheckoutState2.getValue();
            simpleChangeCheckoutState = value;
            List<ProductGroup> productGroups = addonState.getProductGroups();
            if (productGroups != null) {
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = productGroups.iterator();
                while (it.hasNext()) {
                    CollectionsKt.addAll(arrayList, ((ProductGroup) it.next()).getProducts());
                }
                emptyList = new ArrayList();
                for (Object obj : arrayList) {
                    if (((Product) obj).getQuantity() > 0) {
                        emptyList.add(obj);
                    }
                }
            } else {
                emptyList = CollectionsKt.emptyList();
            }
        } while (!simpleChangeCheckoutState2.compareAndSet(value, SimpleChangeCheckoutState.copy$default(simpleChangeCheckoutState, null, false, null, null, emptyList, null, null, null, null, null, null, 2031, null)));
    }

    @Override // dk.molslinjen.domain.managers.checkout.ISimpleChangeCheckoutManager
    public void updateFood(AddonHelper.AddonState addonState) {
        SimpleChangeCheckoutState value;
        SimpleChangeCheckoutState simpleChangeCheckoutState;
        List emptyList;
        Intrinsics.checkNotNullParameter(addonState, "addonState");
        MutableStateFlow<SimpleChangeCheckoutState> simpleChangeCheckoutState2 = getSimpleChangeCheckoutState();
        do {
            value = simpleChangeCheckoutState2.getValue();
            simpleChangeCheckoutState = value;
            List<ProductGroup> food = addonState.getFood();
            if (food != null) {
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = food.iterator();
                while (it.hasNext()) {
                    CollectionsKt.addAll(arrayList, ((ProductGroup) it.next()).getProducts());
                }
                emptyList = new ArrayList();
                for (Object obj : arrayList) {
                    if (((Product) obj).getQuantity() > 0) {
                        emptyList.add(obj);
                    }
                }
            } else {
                emptyList = CollectionsKt.emptyList();
            }
        } while (!simpleChangeCheckoutState2.compareAndSet(value, SimpleChangeCheckoutState.copy$default(simpleChangeCheckoutState, null, false, null, null, null, emptyList, null, null, null, null, null, 2015, null)));
    }

    @Override // dk.molslinjen.domain.managers.checkout.ISimpleChangeCheckoutManager
    public MutableStateFlow<SimpleChangeCheckoutState> getSimpleChangeCheckoutState() {
        return this.simpleChangeCheckoutState;
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0004\b\u0017\u0010\u0018J\u009c\u0001\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\nHÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010)\u001a\u0004\b*\u0010+R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010,\u001a\u0004\b-\u0010.R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\f\u0010/\u001a\u0004\b0\u00101R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\r\u0010/\u001a\u0004\b2\u00101R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u00103\u001a\u0004\b4\u00105R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u00106\u001a\u0004\b7\u0010\u001cR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u00108\u001a\u0004\b9\u0010:R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010;\u001a\u0004\b<\u0010=R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\n8\u0006¢\u0006\f\n\u0004\b\u0016\u0010/\u001a\u0004\b>\u00101¨\u0006?"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/SimpleChangeCheckoutManager$SimpleChangeCheckoutState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/Booking;", "existingBooking", BuildConfig.FLAVOR, "invalidateSeatReservation", "Ldk/molslinjen/domain/model/payment/PaymentType;", "selectedPaymentType", "Ldk/molslinjen/domain/model/account/CreditCard;", "selectedCreditCard", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/product/Product;", "addons", "food", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "totalPrice", BuildConfig.FLAVOR, "reservationNumber", "earlyCheckIn", "Ldk/molslinjen/domain/model/account/UserVehicle;", "earlyCheckInVehicle", "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "earlyCheckInPassengers", "<init>", "(Ldk/molslinjen/domain/model/booking/Booking;ZLdk/molslinjen/domain/model/payment/PaymentType;Ldk/molslinjen/domain/model/account/CreditCard;Ljava/util/List;Ljava/util/List;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Ljava/lang/String;Ljava/lang/Boolean;Ldk/molslinjen/domain/model/account/UserVehicle;Ljava/util/List;)V", "copy", "(Ldk/molslinjen/domain/model/booking/Booking;ZLdk/molslinjen/domain/model/payment/PaymentType;Ldk/molslinjen/domain/model/account/CreditCard;Ljava/util/List;Ljava/util/List;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Ljava/lang/String;Ljava/lang/Boolean;Ldk/molslinjen/domain/model/account/UserVehicle;Ljava/util/List;)Ldk/molslinjen/domain/managers/checkout/SimpleChangeCheckoutManager$SimpleChangeCheckoutState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/booking/Booking;", "getExistingBooking", "()Ldk/molslinjen/domain/model/booking/Booking;", "Z", "getInvalidateSeatReservation", "()Z", "Ldk/molslinjen/domain/model/payment/PaymentType;", "getSelectedPaymentType", "()Ldk/molslinjen/domain/model/payment/PaymentType;", "Ldk/molslinjen/domain/model/account/CreditCard;", "getSelectedCreditCard", "()Ldk/molslinjen/domain/model/account/CreditCard;", "Ljava/util/List;", "getAddons", "()Ljava/util/List;", "getFood", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "getTotalPrice", "()Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "Ljava/lang/String;", "getReservationNumber", "Ljava/lang/Boolean;", "getEarlyCheckIn", "()Ljava/lang/Boolean;", "Ldk/molslinjen/domain/model/account/UserVehicle;", "getEarlyCheckInVehicle", "()Ldk/molslinjen/domain/model/account/UserVehicle;", "getEarlyCheckInPassengers", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class SimpleChangeCheckoutState {
        private final List<Product> addons;
        private final Boolean earlyCheckIn;
        private final List<BookingPassenger> earlyCheckInPassengers;
        private final UserVehicle earlyCheckInVehicle;
        private final Booking existingBooking;
        private final List<Product> food;
        private final boolean invalidateSeatReservation;
        private final String reservationNumber;
        private final CreditCard selectedCreditCard;
        private final PaymentType selectedPaymentType;
        private final PriceWithCurrency totalPrice;

        /* JADX WARN: Multi-variable type inference failed */
        public SimpleChangeCheckoutState(Booking booking, boolean z5, PaymentType selectedPaymentType, CreditCard creditCard, List<? extends Product> addons, List<? extends Product> food, PriceWithCurrency priceWithCurrency, String str, Boolean bool, UserVehicle userVehicle, List<BookingPassenger> earlyCheckInPassengers) {
            Intrinsics.checkNotNullParameter(selectedPaymentType, "selectedPaymentType");
            Intrinsics.checkNotNullParameter(addons, "addons");
            Intrinsics.checkNotNullParameter(food, "food");
            Intrinsics.checkNotNullParameter(earlyCheckInPassengers, "earlyCheckInPassengers");
            this.existingBooking = booking;
            this.invalidateSeatReservation = z5;
            this.selectedPaymentType = selectedPaymentType;
            this.selectedCreditCard = creditCard;
            this.addons = addons;
            this.food = food;
            this.totalPrice = priceWithCurrency;
            this.reservationNumber = str;
            this.earlyCheckIn = bool;
            this.earlyCheckInVehicle = userVehicle;
            this.earlyCheckInPassengers = earlyCheckInPassengers;
        }

        public static /* synthetic */ SimpleChangeCheckoutState copy$default(SimpleChangeCheckoutState simpleChangeCheckoutState, Booking booking, boolean z5, PaymentType paymentType, CreditCard creditCard, List list, List list2, PriceWithCurrency priceWithCurrency, String str, Boolean bool, UserVehicle userVehicle, List list3, int i5, Object obj) {
            return simpleChangeCheckoutState.copy((i5 & 1) != 0 ? simpleChangeCheckoutState.existingBooking : booking, (i5 & 2) != 0 ? simpleChangeCheckoutState.invalidateSeatReservation : z5, (i5 & 4) != 0 ? simpleChangeCheckoutState.selectedPaymentType : paymentType, (i5 & 8) != 0 ? simpleChangeCheckoutState.selectedCreditCard : creditCard, (i5 & 16) != 0 ? simpleChangeCheckoutState.addons : list, (i5 & 32) != 0 ? simpleChangeCheckoutState.food : list2, (i5 & 64) != 0 ? simpleChangeCheckoutState.totalPrice : priceWithCurrency, (i5 & 128) != 0 ? simpleChangeCheckoutState.reservationNumber : str, (i5 & 256) != 0 ? simpleChangeCheckoutState.earlyCheckIn : bool, (i5 & 512) != 0 ? simpleChangeCheckoutState.earlyCheckInVehicle : userVehicle, (i5 & 1024) != 0 ? simpleChangeCheckoutState.earlyCheckInPassengers : list3);
        }

        public final SimpleChangeCheckoutState copy(Booking existingBooking, boolean invalidateSeatReservation, PaymentType selectedPaymentType, CreditCard selectedCreditCard, List<? extends Product> addons, List<? extends Product> food, PriceWithCurrency totalPrice, String reservationNumber, Boolean earlyCheckIn, UserVehicle earlyCheckInVehicle, List<BookingPassenger> earlyCheckInPassengers) {
            Intrinsics.checkNotNullParameter(selectedPaymentType, "selectedPaymentType");
            Intrinsics.checkNotNullParameter(addons, "addons");
            Intrinsics.checkNotNullParameter(food, "food");
            Intrinsics.checkNotNullParameter(earlyCheckInPassengers, "earlyCheckInPassengers");
            return new SimpleChangeCheckoutState(existingBooking, invalidateSeatReservation, selectedPaymentType, selectedCreditCard, addons, food, totalPrice, reservationNumber, earlyCheckIn, earlyCheckInVehicle, earlyCheckInPassengers);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SimpleChangeCheckoutState)) {
                return false;
            }
            SimpleChangeCheckoutState simpleChangeCheckoutState = (SimpleChangeCheckoutState) other;
            return Intrinsics.areEqual(this.existingBooking, simpleChangeCheckoutState.existingBooking) && this.invalidateSeatReservation == simpleChangeCheckoutState.invalidateSeatReservation && this.selectedPaymentType == simpleChangeCheckoutState.selectedPaymentType && Intrinsics.areEqual(this.selectedCreditCard, simpleChangeCheckoutState.selectedCreditCard) && Intrinsics.areEqual(this.addons, simpleChangeCheckoutState.addons) && Intrinsics.areEqual(this.food, simpleChangeCheckoutState.food) && Intrinsics.areEqual(this.totalPrice, simpleChangeCheckoutState.totalPrice) && Intrinsics.areEqual(this.reservationNumber, simpleChangeCheckoutState.reservationNumber) && Intrinsics.areEqual(this.earlyCheckIn, simpleChangeCheckoutState.earlyCheckIn) && Intrinsics.areEqual(this.earlyCheckInVehicle, simpleChangeCheckoutState.earlyCheckInVehicle) && Intrinsics.areEqual(this.earlyCheckInPassengers, simpleChangeCheckoutState.earlyCheckInPassengers);
        }

        public final List<Product> getAddons() {
            return this.addons;
        }

        public final Boolean getEarlyCheckIn() {
            return this.earlyCheckIn;
        }

        public final List<BookingPassenger> getEarlyCheckInPassengers() {
            return this.earlyCheckInPassengers;
        }

        public final UserVehicle getEarlyCheckInVehicle() {
            return this.earlyCheckInVehicle;
        }

        public final Booking getExistingBooking() {
            return this.existingBooking;
        }

        public final List<Product> getFood() {
            return this.food;
        }

        public final boolean getInvalidateSeatReservation() {
            return this.invalidateSeatReservation;
        }

        public final CreditCard getSelectedCreditCard() {
            return this.selectedCreditCard;
        }

        public final PaymentType getSelectedPaymentType() {
            return this.selectedPaymentType;
        }

        public final PriceWithCurrency getTotalPrice() {
            return this.totalPrice;
        }

        public int hashCode() {
            Booking booking = this.existingBooking;
            int hashCode = (((((booking == null ? 0 : booking.hashCode()) * 31) + Boolean.hashCode(this.invalidateSeatReservation)) * 31) + this.selectedPaymentType.hashCode()) * 31;
            CreditCard creditCard = this.selectedCreditCard;
            int hashCode2 = (((((hashCode + (creditCard == null ? 0 : creditCard.hashCode())) * 31) + this.addons.hashCode()) * 31) + this.food.hashCode()) * 31;
            PriceWithCurrency priceWithCurrency = this.totalPrice;
            int hashCode3 = (hashCode2 + (priceWithCurrency == null ? 0 : priceWithCurrency.hashCode())) * 31;
            String str = this.reservationNumber;
            int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
            Boolean bool = this.earlyCheckIn;
            int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
            UserVehicle userVehicle = this.earlyCheckInVehicle;
            return ((hashCode5 + (userVehicle != null ? userVehicle.hashCode() : 0)) * 31) + this.earlyCheckInPassengers.hashCode();
        }

        public String toString() {
            return "SimpleChangeCheckoutState(existingBooking=" + this.existingBooking + ", invalidateSeatReservation=" + this.invalidateSeatReservation + ", selectedPaymentType=" + this.selectedPaymentType + ", selectedCreditCard=" + this.selectedCreditCard + ", addons=" + this.addons + ", food=" + this.food + ", totalPrice=" + this.totalPrice + ", reservationNumber=" + this.reservationNumber + ", earlyCheckIn=" + this.earlyCheckIn + ", earlyCheckInVehicle=" + this.earlyCheckInVehicle + ", earlyCheckInPassengers=" + this.earlyCheckInPassengers + ")";
        }

        public /* synthetic */ SimpleChangeCheckoutState(Booking booking, boolean z5, PaymentType paymentType, CreditCard creditCard, List list, List list2, PriceWithCurrency priceWithCurrency, String str, Boolean bool, UserVehicle userVehicle, List list3, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? null : booking, (i5 & 2) != 0 ? false : z5, (i5 & 4) != 0 ? PaymentType.Card : paymentType, (i5 & 8) != 0 ? null : creditCard, (i5 & 16) != 0 ? CollectionsKt.emptyList() : list, (i5 & 32) != 0 ? CollectionsKt.emptyList() : list2, (i5 & 64) != 0 ? null : priceWithCurrency, (i5 & 128) != 0 ? null : str, (i5 & 256) != 0 ? null : bool, (i5 & 512) == 0 ? userVehicle : null, (i5 & 1024) != 0 ? CollectionsKt.emptyList() : list3);
        }
    }
}
