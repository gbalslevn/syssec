package dk.molslinjen.domain.managers.checkout;

import com.adjust.sdk.Constants;
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
import dk.molslinjen.core.Feature;
import dk.molslinjen.core.extensions.CollectionExtensionsKt;
import dk.molslinjen.core.extensions.IpHelperKt;
import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.core.providers.IPaymentCallbackUrlProvider;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.extensions.BookRequestParametersExtensionsKt;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.agreement.commuter.bornholm.IBornholmCommuterManager;
import dk.molslinjen.domain.managers.agreement.multiride.IMultiRideManager;
import dk.molslinjen.domain.managers.checkout.AddonHelper;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.checkout.IPaymentManager;
import dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper;
import dk.molslinjen.domain.managers.checkout.PaymentManager;
import dk.molslinjen.domain.managers.checkout.SummaryAddonHelper;
import dk.molslinjen.domain.managers.configuration.IConfigurationManager;
import dk.molslinjen.domain.managers.departure.DepartureState;
import dk.molslinjen.domain.managers.departure.IDepartureManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.managers.route.RouteSelectedState;
import dk.molslinjen.domain.managers.route.RouteSharedSelectedState;
import dk.molslinjen.domain.managers.route.RouteState;
import dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardManager;
import dk.molslinjen.domain.managers.ticket.ITicketsManager;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.managers.user.vehicles.IUserVehiclesManager;
import dk.molslinjen.domain.model.account.AuthToken;
import dk.molslinjen.domain.model.account.CreditCard;
import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.domain.model.account.user.UserContactDetails;
import dk.molslinjen.domain.model.account.user.UserInfo;
import dk.molslinjen.domain.model.booking.AuthenticationInfo;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.BookingCompleted;
import dk.molslinjen.domain.model.booking.BookingDeparture;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.domain.model.booking.BookingPassengerInfo;
import dk.molslinjen.domain.model.booking.BookingSeatReservation;
import dk.molslinjen.domain.model.booking.BookingTicket;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.CheckoutContactInfo;
import dk.molslinjen.domain.model.booking.CommuterBookingData;
import dk.molslinjen.domain.model.booking.CustomerInfo;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.DepartureTicket;
import dk.molslinjen.domain.model.booking.MultiRideBookingData;
import dk.molslinjen.domain.model.booking.MultiRideInfo;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.booking.RouteDirection;
import dk.molslinjen.domain.model.booking.TicketCategoryType;
import dk.molslinjen.domain.model.booking.TransportationCargoInfo;
import dk.molslinjen.domain.model.booking.product.CheckoutSeatReservation;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.ProductGroup;
import dk.molslinjen.domain.model.booking.product.TrailerProduct;
import dk.molslinjen.domain.model.booking.product.UnavailableProduct;
import dk.molslinjen.domain.model.booking.product.UnavailableSeatReservation;
import dk.molslinjen.domain.model.config.RouteDirectionDetails;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.domain.model.payment.PaymentType;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import dk.molslinjen.domain.model.settings.ISettings;
import dk.molslinjen.domain.model.settings.SettingsProperty;
import dk.molslinjen.domain.model.shared.CurrencyType;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
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
import org.threeten.bp.LocalDateTime;
import uniffi.molslinjen_shared.SeatReservationId;

@Metadata(d1 = {"\u0000º\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0004\u0089\u0001\u008a\u0001B\u0089\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!¢\u0006\u0004\b\"\u0010#J\u0018\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0%2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0016JH\u00107\u001a\u0002042\b\u00108\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010>\u001a\u00020?2\u0006\u00105\u001a\u0002062\u0006\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J\u0018\u0010D\u001a\u0002042\u0006\u0010@\u001a\u00020A2\u0006\u0010E\u001a\u000206H\u0002J\"\u0010F\u001a\u00020G2\u0006\u0010E\u001a\u0002062\u0006\u0010H\u001a\u0002092\b\u0010I\u001a\u0004\u0018\u00010GH\u0002J\b\u0010J\u001a\u000204H\u0002J\b\u0010K\u001a\u000204H\u0002J\b\u0010L\u001a\u000204H\u0002J\u001a\u0010M\u001a\u0002042\b\u0010N\u001a\u0004\u0018\u00010*2\u0006\u00101\u001a\u000202H\u0002J\u0018\u0010O\u001a\u0002042\u0006\u0010P\u001a\u00020Q2\u0006\u00101\u001a\u000202H\u0016J\u0018\u0010R\u001a\u0002042\u0006\u0010P\u001a\u00020Q2\u0006\u00101\u001a\u000202H\u0016J\u0010\u0010S\u001a\u0002042\u0006\u0010T\u001a\u00020UH\u0016J\b\u0010V\u001a\u000204H\u0002J\u000e\u0010W\u001a\u000204H\u0082@¢\u0006\u0002\u0010XJ\u001e\u0010Y\u001a\u0002042\u0006\u0010$\u001a\u00020&2\u0006\u0010Z\u001a\u00020[H\u0082@¢\u0006\u0002\u0010\\J\u000e\u0010]\u001a\u000204H\u0082@¢\u0006\u0002\u0010XJ\u001a\u0010^\u001a\u0002042\u0006\u0010_\u001a\u00020`2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\b\u0010c\u001a\u000204H\u0016J\b\u0010d\u001a\u000204H\u0016J$\u0010e\u001a\b\u0012\u0004\u0012\u00020g0f2\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020iH\u0096@¢\u0006\u0002\u0010kJ \u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020*2\u0006\u0010o\u001a\u00020p2\u0006\u0010$\u001a\u00020&H\u0002J\u000e\u0010q\u001a\u000204H\u0082@¢\u0006\u0002\u0010XJ\u0012\u0010r\u001a\u0002042\b\u0010s\u001a\u0004\u0018\u00010tH\u0016J\u0010\u0010u\u001a\u0002042\u0006\u0010v\u001a\u000206H\u0016J\u0010\u0010w\u001a\u0002042\u0006\u0010x\u001a\u00020yH\u0016J\u0010\u0010z\u001a\u0002042\u0006\u0010{\u001a\u00020|H\u0016J\u0010\u0010}\u001a\u0002042\u0006\u0010~\u001a\u00020|H\u0016J\u001a\u0010\u007f\u001a\u0002042\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0006\u00101\u001a\u000202H\u0016J\t\u0010\u0082\u0001\u001a\u000204H\u0016J$\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u0002040f2\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u00012\u0007\u0010\u0086\u0001\u001a\u000202H\u0016J\t\u0010\u0087\u0001\u001a\u000204H\u0016J\t\u0010\u0088\u0001\u001a\u000204H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0%X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001c\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0%X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010(R\u001c\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0%X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010(R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u008b\u0001"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/CheckoutManager;", "Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;", "routeManager", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "departureManager", "Ldk/molslinjen/domain/managers/departure/IDepartureManager;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "bookingService", "Ldk/molslinjen/api/services/booking/IBookingService;", "paymentManager", "Ldk/molslinjen/domain/managers/checkout/IPaymentManager;", "passengerManager", "Ldk/molslinjen/domain/managers/checkout/ICheckoutPassengerManager;", "ticketsManager", "Ldk/molslinjen/domain/managers/ticket/ITicketsManager;", "editManager", "Ldk/molslinjen/domain/managers/checkout/IEditManager;", "multiRideManager", "Ldk/molslinjen/domain/managers/agreement/multiride/IMultiRideManager;", "commuterManager", "Ldk/molslinjen/domain/managers/agreement/commuter/bornholm/IBornholmCommuterManager;", "settings", "Ldk/molslinjen/domain/model/settings/ISettings;", "vehiclesManager", "Ldk/molslinjen/domain/managers/user/vehicles/IUserVehiclesManager;", "saleOnBoardManager", "Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardManager;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "paymentCallbackUrl", "Ldk/molslinjen/core/providers/IPaymentCallbackUrlProvider;", "configurationManager", "Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;", "<init>", "(Ldk/molslinjen/domain/managers/route/IRouteManager;Ldk/molslinjen/domain/managers/departure/IDepartureManager;Ldk/molslinjen/domain/managers/user/IUserManager;Ldk/molslinjen/api/services/booking/IBookingService;Ldk/molslinjen/domain/managers/checkout/IPaymentManager;Ldk/molslinjen/domain/managers/checkout/ICheckoutPassengerManager;Ldk/molslinjen/domain/managers/ticket/ITicketsManager;Ldk/molslinjen/domain/managers/checkout/IEditManager;Ldk/molslinjen/domain/managers/agreement/multiride/IMultiRideManager;Ldk/molslinjen/domain/managers/agreement/commuter/bornholm/IBornholmCommuterManager;Ldk/molslinjen/domain/model/settings/ISettings;Ldk/molslinjen/domain/managers/user/vehicles/IUserVehiclesManager;Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardManager;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;Ldk/molslinjen/core/providers/IPaymentCallbackUrlProvider;Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;)V", "checkoutState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;", "getCheckoutState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "outboundDirectionState", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutDirectionState;", "getOutboundDirectionState", "returnDirectionState", "getReturnDirectionState", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "directionState", "departureDirection", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "setup", BuildConfig.FLAVOR, "isAddingReturnFromBookingSummary", BuildConfig.FLAVOR, "setupDirectionStates", "outboundRouteSelectedState", "Ldk/molslinjen/domain/managers/route/RouteSelectedState;", "outboundDeparture", "Ldk/molslinjen/domain/model/booking/Departure;", "outboundDepartureTicket", "Ldk/molslinjen/domain/model/booking/DepartureTicket;", "transportation", "Ldk/molslinjen/domain/model/config/Transportation;", "bookingType", "Ldk/molslinjen/domain/model/booking/BookingType;", "existingTicket", "Ldk/molslinjen/domain/model/booking/BookingTicket;", "setupReturnState", "isWalking", "setupPassengerInfo", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "routeSelectedState", "existingOutboundPassengerInfo", "listenForCheckoutStateUpdates", "listenForLoginChange", "totalPriceUpdater", "updateTotalPrice", "state", "updateAddons", "addonState", "Ldk/molslinjen/domain/managers/checkout/AddonHelper$AddonState;", "updateFood", "updateSummaryAddons", "summaryAddonState", "Ldk/molslinjen/domain/managers/checkout/SummaryAddonHelper$SummaryAddonState;", "listenForPayment", "handlePurchaseCompleted", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelExistingSaleOnBoardOrders", "editingBooking", "Ldk/molslinjen/domain/model/booking/Booking;", "(Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;Ldk/molslinjen/domain/model/booking/Booking;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePurchaseCount", "selectPaymentMethod", "paymentType", "Ldk/molslinjen/domain/model/payment/PaymentType;", "creditCard", "Ldk/molslinjen/domain/model/account/CreditCard;", "toggleNewsletterSignup", "toggleAcceptMarketing", "createBooking", "Ldk/molslinjen/domain/managers/ManagerResult;", "Ldk/molslinjen/domain/model/booking/BookingCompleted;", "screenWidth", BuildConfig.FLAVOR, "screenHeight", "(FFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildTicketRequestParameters", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$TicketRequestParameters;", "checkoutDirectionState", "routeDirection", "Ldk/molslinjen/domain/model/booking/RouteDirection;", "updateLocalUserData", "updateSelectedVehicle", "vehicle", "Ldk/molslinjen/domain/model/account/UserVehicle;", "updateEarlyCheckIn", "earlyCheckIn", "updatePhoneNumber", "phoneNumber", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "updateEmail", "email", BuildConfig.FLAVOR, "updatePostalCode", "postalCode", "updatePassengerCount", "passengerCount", BuildConfig.FLAVOR, "clearOutboundState", "setSeatReservation", "seatReservation", "Ldk/molslinjen/domain/model/booking/product/CheckoutSeatReservation;", "direction", "clearReturnState", "selectDefaultVehicle", "CheckoutDirectionState", "CheckoutState", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CheckoutManager implements ICheckoutManager {
    private final IAnalyticsTracker analyticsTracker;
    private final IBookingService bookingService;
    private final MutableStateFlow<CheckoutState> checkoutState;
    private final IBornholmCommuterManager commuterManager;
    private final IConfigurationManager configurationManager;
    private final CoroutineScope coroutineScope;
    private final IDepartureManager departureManager;
    private final IEditManager editManager;
    private final IMultiRideManager multiRideManager;
    private final MutableStateFlow<CheckoutDirectionState> outboundDirectionState;
    private final ICheckoutPassengerManager passengerManager;
    private final IPaymentCallbackUrlProvider paymentCallbackUrl;
    private final IPaymentManager paymentManager;
    private final MutableStateFlow<CheckoutDirectionState> returnDirectionState;
    private final IRouteManager routeManager;
    private final ISaleOnBoardManager saleOnBoardManager;
    private final ISettings settings;
    private final ITicketsManager ticketsManager;
    private final IUserManager userManager;
    private final IUserVehiclesManager vehiclesManager;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DepartureDirection.values().length];
            try {
                iArr[DepartureDirection.Outbound.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DepartureDirection.Return.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public CheckoutManager(IRouteManager routeManager, IDepartureManager departureManager, IUserManager userManager, IBookingService bookingService, IPaymentManager paymentManager, ICheckoutPassengerManager passengerManager, ITicketsManager ticketsManager, IEditManager editManager, IMultiRideManager multiRideManager, IBornholmCommuterManager commuterManager, ISettings settings, IUserVehiclesManager vehiclesManager, ISaleOnBoardManager saleOnBoardManager, IAnalyticsTracker analyticsTracker, IPaymentCallbackUrlProvider paymentCallbackUrl, IConfigurationManager configurationManager) {
        Intrinsics.checkNotNullParameter(routeManager, "routeManager");
        Intrinsics.checkNotNullParameter(departureManager, "departureManager");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(bookingService, "bookingService");
        Intrinsics.checkNotNullParameter(paymentManager, "paymentManager");
        Intrinsics.checkNotNullParameter(passengerManager, "passengerManager");
        Intrinsics.checkNotNullParameter(ticketsManager, "ticketsManager");
        Intrinsics.checkNotNullParameter(editManager, "editManager");
        Intrinsics.checkNotNullParameter(multiRideManager, "multiRideManager");
        Intrinsics.checkNotNullParameter(commuterManager, "commuterManager");
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(vehiclesManager, "vehiclesManager");
        Intrinsics.checkNotNullParameter(saleOnBoardManager, "saleOnBoardManager");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        Intrinsics.checkNotNullParameter(paymentCallbackUrl, "paymentCallbackUrl");
        Intrinsics.checkNotNullParameter(configurationManager, "configurationManager");
        this.routeManager = routeManager;
        this.departureManager = departureManager;
        this.userManager = userManager;
        this.bookingService = bookingService;
        this.paymentManager = paymentManager;
        this.passengerManager = passengerManager;
        this.ticketsManager = ticketsManager;
        this.editManager = editManager;
        this.multiRideManager = multiRideManager;
        this.commuterManager = commuterManager;
        this.settings = settings;
        this.vehiclesManager = vehiclesManager;
        this.saleOnBoardManager = saleOnBoardManager;
        this.analyticsTracker = analyticsTracker;
        this.paymentCallbackUrl = paymentCallbackUrl;
        this.configurationManager = configurationManager;
        this.checkoutState = StateFlowKt.MutableStateFlow(null);
        this.outboundDirectionState = StateFlowKt.MutableStateFlow(null);
        this.returnDirectionState = StateFlowKt.MutableStateFlow(null);
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        listenForPayment();
        listenForCheckoutStateUpdates();
        totalPriceUpdater();
        listenForLoginChange();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final BookRequestParameters.TicketRequestParameters buildTicketRequestParameters(CheckoutDirectionState checkoutDirectionState, RouteDirection routeDirection, CheckoutState checkoutState) {
        List emptyList;
        UnavailableSeatReservation unavailableSeatReservation;
        CheckoutSeatReservation seatReservation;
        TrailerProduct copy;
        BookRequestParameters.TicketRequestParameters.Companion companion = BookRequestParameters.TicketRequestParameters.INSTANCE;
        DepartureTicket departureTicket = checkoutDirectionState.getDepartureTicket();
        Departure departure = checkoutDirectionState.getDeparture();
        PassengerInfo passengerInfo = checkoutDirectionState.getPassengerInfo();
        List<BookingPassenger> passengers = checkoutDirectionState.getPassengers();
        Transportation transportation = checkoutState.getTransportation();
        TransportationCargoInfo transportationCargoInfo = checkoutDirectionState.getTransportationCargoInfo();
        Set union = CollectionsKt.union(CollectionsKt.union(CollectionsKt.union(checkoutDirectionState.getTransportProducts(), checkoutDirectionState.getAddons()), checkoutDirectionState.getSummaryAddons()), checkoutDirectionState.getFood());
        TrailerProduct trailer = checkoutDirectionState.getTrailer();
        TrailerProduct trailerProduct = trailer != null ? trailer : null;
        if (trailerProduct != null) {
            copy = trailerProduct.copy((r33 & 1) != 0 ? trailerProduct.id : null, (r33 & 2) != 0 ? trailerProduct.name : null, (r33 & 4) != 0 ? trailerProduct.price : null, (r33 & 8) != 0 ? trailerProduct.originalPrice : null, (r33 & 16) != 0 ? trailerProduct.quantity : 1, (r33 & 32) != 0 ? trailerProduct.originalQuantity : 0, (r33 & 64) != 0 ? trailerProduct.disabled : false, (r33 & 128) != 0 ? trailerProduct.presentation : null, (r33 & 256) != 0 ? trailerProduct.productType : null, (r33 & 512) != 0 ? trailerProduct.recommended : false, (r33 & 1024) != 0 ? trailerProduct.tag : null, (r33 & 2048) != 0 ? trailerProduct.maxHeight : 0.0d, (r33 & 4096) != 0 ? trailerProduct.maxLength : 0.0d, (r33 & 8192) != 0 ? trailerProduct.sortOrder : 0);
            List listOf = CollectionsKt.listOf(copy);
            if (listOf != null) {
                emptyList = listOf;
                List list = CollectionsKt.toList(CollectionsKt.union(union, emptyList));
                boolean makeEarlyCheckIn = checkoutState.getMakeEarlyCheckIn();
                String id = checkoutDirectionState.getRouteDirectionDetails().getDepartureHarbor().getRegion().getId();
                unavailableSeatReservation = checkoutDirectionState.getUnavailableSeatReservation();
                if (unavailableSeatReservation != null) {
                    SeatReservationId id2 = unavailableSeatReservation.getReservation().getId();
                    CheckoutSeatReservation seatReservation2 = checkoutDirectionState.getSeatReservation();
                    CheckoutSeatReservation seatReservation3 = Intrinsics.areEqual(id2, seatReservation2 != null ? seatReservation2.getId() : null) ? null : checkoutDirectionState.getSeatReservation();
                    if (seatReservation3 != null) {
                        seatReservation = seatReservation3;
                        return BookRequestParametersExtensionsKt.invoke(companion, departure, departureTicket, routeDirection, passengerInfo, passengers, transportation, transportationCargoInfo, list, makeEarlyCheckIn, id, seatReservation);
                    }
                }
                seatReservation = checkoutDirectionState.getSeatReservation();
                return BookRequestParametersExtensionsKt.invoke(companion, departure, departureTicket, routeDirection, passengerInfo, passengers, transportation, transportationCargoInfo, list, makeEarlyCheckIn, id, seatReservation);
            }
        }
        emptyList = CollectionsKt.emptyList();
        List list2 = CollectionsKt.toList(CollectionsKt.union(union, emptyList));
        boolean makeEarlyCheckIn2 = checkoutState.getMakeEarlyCheckIn();
        String id3 = checkoutDirectionState.getRouteDirectionDetails().getDepartureHarbor().getRegion().getId();
        unavailableSeatReservation = checkoutDirectionState.getUnavailableSeatReservation();
        if (unavailableSeatReservation != null) {
        }
        seatReservation = checkoutDirectionState.getSeatReservation();
        return BookRequestParametersExtensionsKt.invoke(companion, departure, departureTicket, routeDirection, passengerInfo, passengers, transportation, transportationCargoInfo, list2, makeEarlyCheckIn2, id3, seatReservation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object cancelExistingSaleOnBoardOrders(CheckoutState checkoutState, Booking booking, Continuation<? super Unit> continuation) {
        CheckoutManager$cancelExistingSaleOnBoardOrders$1 checkoutManager$cancelExistingSaleOnBoardOrders$1;
        int i5;
        CheckoutManager checkoutManager;
        List list;
        MutableStateFlow<CheckoutState> checkoutState2;
        CheckoutState value;
        CheckoutState checkoutState3;
        CheckoutManager checkoutManager2;
        Iterator it;
        if (continuation instanceof CheckoutManager$cancelExistingSaleOnBoardOrders$1) {
            checkoutManager$cancelExistingSaleOnBoardOrders$1 = (CheckoutManager$cancelExistingSaleOnBoardOrders$1) continuation;
            int i6 = checkoutManager$cancelExistingSaleOnBoardOrders$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                checkoutManager$cancelExistingSaleOnBoardOrders$1.label = i6 - Integer.MIN_VALUE;
                Object obj = checkoutManager$cancelExistingSaleOnBoardOrders$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = checkoutManager$cancelExistingSaleOnBoardOrders$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (Feature.SaleOnboard.isEnabled() && checkoutState.getEditingBooking() != null) {
                        ISaleOnBoardManager iSaleOnBoardManager = this.saleOnBoardManager;
                        String timeTableId = booking.getTicket().getDeparture().getTimeTableId();
                        checkoutManager$cancelExistingSaleOnBoardOrders$1.L$0 = this;
                        checkoutManager$cancelExistingSaleOnBoardOrders$1.label = 1;
                        obj = iSaleOnBoardManager.getSaleOnBoardOrders(timeTableId, checkoutManager$cancelExistingSaleOnBoardOrders$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        checkoutManager = this;
                    }
                    return Unit.INSTANCE;
                }
                if (i5 != 1) {
                    if (i5 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (Iterator) checkoutManager$cancelExistingSaleOnBoardOrders$1.L$1;
                    checkoutManager2 = (CheckoutManager) checkoutManager$cancelExistingSaleOnBoardOrders$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    while (it.hasNext()) {
                        SaleOnBoardOrder saleOnBoardOrder = (SaleOnBoardOrder) it.next();
                        ISaleOnBoardManager iSaleOnBoardManager2 = checkoutManager2.saleOnBoardManager;
                        checkoutManager$cancelExistingSaleOnBoardOrders$1.L$0 = checkoutManager2;
                        checkoutManager$cancelExistingSaleOnBoardOrders$1.L$1 = it;
                        checkoutManager$cancelExistingSaleOnBoardOrders$1.label = 2;
                        if (iSaleOnBoardManager2.cancelOrder(saleOnBoardOrder, checkoutManager$cancelExistingSaleOnBoardOrders$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }
                checkoutManager = (CheckoutManager) checkoutManager$cancelExistingSaleOnBoardOrders$1.L$0;
                ResultKt.throwOnFailure(obj);
                list = (List) obj;
                checkoutState2 = checkoutManager.getCheckoutState();
                do {
                    value = checkoutState2.getValue();
                    checkoutState3 = value;
                } while (!checkoutState2.compareAndSet(value, checkoutState3 == null ? CheckoutState.copy$default(checkoutState3, null, null, null, null, false, false, null, null, null, null, null, null, false, null, false, null, null, null, null, !list.isEmpty(), null, 1572863, null) : null));
                checkoutManager2 = checkoutManager;
                it = list.iterator();
                while (it.hasNext()) {
                }
                return Unit.INSTANCE;
            }
        }
        checkoutManager$cancelExistingSaleOnBoardOrders$1 = new CheckoutManager$cancelExistingSaleOnBoardOrders$1(this, continuation);
        Object obj2 = checkoutManager$cancelExistingSaleOnBoardOrders$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = checkoutManager$cancelExistingSaleOnBoardOrders$1.label;
        if (i5 != 0) {
        }
        list = (List) obj2;
        checkoutState2 = checkoutManager.getCheckoutState();
        do {
            value = checkoutState2.getValue();
            checkoutState3 = value;
        } while (!checkoutState2.compareAndSet(value, checkoutState3 == null ? CheckoutState.copy$default(checkoutState3, null, null, null, null, false, false, null, null, null, null, null, null, false, null, false, null, null, null, null, !list.isEmpty(), null, 1572863, null) : null));
        checkoutManager2 = checkoutManager;
        it = list.iterator();
        while (it.hasNext()) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BookingCompleted createBooking$lambda$35(CheckoutManager checkoutManager, CheckoutState checkoutState, BookingCompletedResponseDTO it) {
        CheckoutState value;
        CheckoutState checkoutState2;
        String outboundReservationNumber;
        Intrinsics.checkNotNullParameter(it, "it");
        BookingCompleted invoke = BookingCompleted.INSTANCE.invoke(it);
        MutableStateFlow<CheckoutState> checkoutState3 = checkoutManager.getCheckoutState();
        do {
            value = checkoutState3.getValue();
            checkoutState2 = value;
        } while (!checkoutState3.compareAndSet(value, checkoutState2 != null ? CheckoutState.copy$default(checkoutState2, null, null, null, null, false, false, null, null, null, invoke.getOutboundReservationNumber(), null, null, false, null, false, null, null, null, null, false, null, 2096639, null) : null));
        IPaymentManager iPaymentManager = checkoutManager.paymentManager;
        Booking editingBooking = checkoutState.getEditingBooking();
        if (editingBooking == null || (outboundReservationNumber = editingBooking.getReservationNumber()) == null) {
            outboundReservationNumber = invoke.getOutboundReservationNumber();
        }
        IPaymentManager.DefaultImpls.setPaymentData$default(iPaymentManager, outboundReservationNumber, checkoutState.getSelectedPaymentType(), invoke.getBookingProcessingResult(), false, 8, null);
        return invoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handlePurchaseCompleted(Continuation<? super Unit> continuation) {
        CheckoutManager$handlePurchaseCompleted$1 checkoutManager$handlePurchaseCompleted$1;
        int i5;
        if (continuation instanceof CheckoutManager$handlePurchaseCompleted$1) {
            checkoutManager$handlePurchaseCompleted$1 = (CheckoutManager$handlePurchaseCompleted$1) continuation;
            int i6 = checkoutManager$handlePurchaseCompleted$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                checkoutManager$handlePurchaseCompleted$1.label = i6 - Integer.MIN_VALUE;
                Object obj = checkoutManager$handlePurchaseCompleted$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = checkoutManager$handlePurchaseCompleted$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    StateFlow<PaymentManager.PaymentState> paymentState = this.paymentManager.getPaymentState();
                    CheckoutManager$handlePurchaseCompleted$2 checkoutManager$handlePurchaseCompleted$2 = new CheckoutManager$handlePurchaseCompleted$2(this);
                    checkoutManager$handlePurchaseCompleted$1.label = 1;
                    if (paymentState.collect(checkoutManager$handlePurchaseCompleted$2, checkoutManager$handlePurchaseCompleted$1) == coroutine_suspended) {
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
        checkoutManager$handlePurchaseCompleted$1 = new CheckoutManager$handlePurchaseCompleted$1(this, continuation);
        Object obj2 = checkoutManager$handlePurchaseCompleted$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = checkoutManager$handlePurchaseCompleted$1.label;
        if (i5 != 0) {
        }
        throw new KotlinNothingValueException();
    }

    private final void listenForCheckoutStateUpdates() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new CheckoutManager$listenForCheckoutStateUpdates$1(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new CheckoutManager$listenForCheckoutStateUpdates$2(this, null), 3, null);
    }

    private final void listenForLoginChange() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new CheckoutManager$listenForLoginChange$1(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new CheckoutManager$listenForLoginChange$2(this, null), 3, null);
    }

    private final void listenForPayment() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new CheckoutManager$listenForPayment$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void selectDefaultVehicle() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new CheckoutManager$selectDefaultVehicle$1(this, null), 3, null);
    }

    private final void setupDirectionStates(RouteSelectedState outboundRouteSelectedState, Departure outboundDeparture, DepartureTicket outboundDepartureTicket, Transportation transportation, boolean isAddingReturnFromBookingSummary, BookingType bookingType, BookingTicket existingTicket) {
        CheckoutSeatReservation checkoutSeatReservation;
        UnavailableSeatReservation.Invalid invalid;
        List<Product> emptyList;
        List<Product> emptyList2;
        List<BookingPassenger> emptyList3;
        BookingPassengerInfo passengerInfo;
        BookingDeparture departure;
        BookingSeatReservation seatReservation;
        if (outboundRouteSelectedState == null || outboundDeparture == null || outboundDepartureTicket == null) {
            return;
        }
        CheckoutSeatReservation checkoutSeatReservation2 = (existingTicket == null || (seatReservation = existingTicket.getSeatReservation()) == null) ? null : new CheckoutSeatReservation(seatReservation);
        boolean areEqual = Intrinsics.areEqual(outboundDeparture.getId(), (existingTicket == null || (departure = existingTicket.getDeparture()) == null) ? null : departure.getDepartureId());
        boolean z5 = outboundDepartureTicket.getCategory().getType() == TicketCategoryType.BlueClass;
        if (checkoutSeatReservation2 == null || (areEqual && !z5)) {
            checkoutSeatReservation = checkoutSeatReservation2;
            invalid = null;
        } else {
            invalid = new UnavailableSeatReservation.Invalid(checkoutSeatReservation2);
            checkoutSeatReservation = null;
        }
        boolean isWalking = transportation.isWalking();
        PassengerInfo passengerInfo2 = setupPassengerInfo(isWalking, outboundRouteSelectedState, (existingTicket == null || (passengerInfo = existingTicket.getPassengerInfo()) == null) ? null : passengerInfo.toPassengerInfo());
        RouteState value = this.routeManager.getRouteState().getValue();
        RouteDirectionDetails selectedRouteDirectionDetails = outboundRouteSelectedState.getSelectedRouteDirectionDetails(value != null ? value.getConfiguration() : null, outboundDeparture.getRouteId());
        if (selectedRouteDirectionDetails == null) {
            Logger.INSTANCE.logCritical(new CriticalLog("No route direction details found for route id: " + outboundDeparture.getRouteId()));
            return;
        }
        MutableStateFlow<CheckoutDirectionState> outboundDirectionState = getOutboundDirectionState();
        while (true) {
            CheckoutDirectionState value2 = outboundDirectionState.getValue();
            CheckoutDirectionState checkoutDirectionState = value2;
            RouteDirection selectedRouteDirection = outboundRouteSelectedState.getSelectedRouteDirection();
            TransportationCargoInfo transportationCargoInfo = outboundRouteSelectedState.getTransportationCargoInfo();
            TrailerProduct selectedTrailer = outboundRouteSelectedState.getSelectedTrailer();
            List<Product> selectedTransportProducts = outboundRouteSelectedState.getSelectedTransportProducts();
            if (!isAddingReturnFromBookingSummary || checkoutDirectionState == null || (emptyList = checkoutDirectionState.getAddons()) == null) {
                emptyList = CollectionsKt.emptyList();
            }
            List<Product> list = emptyList;
            if (!isAddingReturnFromBookingSummary || checkoutDirectionState == null || (emptyList2 = checkoutDirectionState.getFood()) == null) {
                emptyList2 = CollectionsKt.emptyList();
            }
            List<Product> list2 = emptyList2;
            CheckoutSeatReservation seatReservation2 = isAddingReturnFromBookingSummary ? checkoutDirectionState != null ? checkoutDirectionState.getSeatReservation() : null : checkoutSeatReservation;
            UnavailableSeatReservation unavailableSeatReservation = isAddingReturnFromBookingSummary ? checkoutDirectionState != null ? checkoutDirectionState.getUnavailableSeatReservation() : null : invalid;
            if (!isAddingReturnFromBookingSummary || checkoutDirectionState == null || (emptyList3 = checkoutDirectionState.getPassengers()) == null) {
                emptyList3 = CollectionsKt.emptyList();
            }
            MutableStateFlow<CheckoutDirectionState> mutableStateFlow = outboundDirectionState;
            boolean z6 = isWalking;
            if (mutableStateFlow.compareAndSet(value2, new CheckoutDirectionState(outboundDeparture, outboundDepartureTicket, selectedRouteDirection, selectedRouteDirectionDetails, transportationCargoInfo, selectedTrailer, passengerInfo2, selectedTransportProducts, list, null, list2, seatReservation2, unavailableSeatReservation, emptyList3, new PriceTotal(outboundDepartureTicket.getPrice()), null, null, null, null, 492032, null))) {
                updateTotalPrice(getOutboundDirectionState().getValue(), DepartureDirection.Outbound);
                setupReturnState(bookingType, z6);
                return;
            } else {
                outboundDirectionState = mutableStateFlow;
                isWalking = z6;
            }
        }
    }

    private final PassengerInfo setupPassengerInfo(boolean isWalking, RouteSelectedState routeSelectedState, PassengerInfo existingOutboundPassengerInfo) {
        PassengerInfo passengerInfo;
        if (isWalking) {
            return routeSelectedState.getPassengerInfo();
        }
        if (existingOutboundPassengerInfo != null) {
            return existingOutboundPassengerInfo;
        }
        CheckoutDirectionState value = getOutboundDirectionState().getValue();
        return new PassengerInfo((value == null || (passengerInfo = value.getPassengerInfo()) == null) ? 1 : passengerInfo.getAdultCount(), 0, 0);
    }

    private final void setupReturnState(BookingType bookingType, boolean isWalking) {
        RouteSelectedState value = this.routeManager.getReturnSelectedState().getValue();
        DepartureState value2 = this.departureManager.getReturnState().getValue();
        Departure selectedDeparture = value2.getSelectedDeparture();
        DepartureTicket selectedDepartureTicket = value2.getSelectedDepartureTicket();
        if (bookingType != BookingType.TwoWay) {
            MutableStateFlow<CheckoutDirectionState> returnDirectionState = getReturnDirectionState();
            do {
            } while (!returnDirectionState.compareAndSet(returnDirectionState.getValue(), null));
            return;
        }
        if (value == null || selectedDeparture == null || selectedDepartureTicket == null) {
            MutableStateFlow<CheckoutDirectionState> returnDirectionState2 = getReturnDirectionState();
            do {
            } while (!returnDirectionState2.compareAndSet(returnDirectionState2.getValue(), null));
            return;
        }
        RouteState value3 = this.routeManager.getRouteState().getValue();
        RouteDirectionDetails selectedRouteDirectionDetails = value.getSelectedRouteDirectionDetails(value3 != null ? value3.getConfiguration() : null, selectedDeparture.getRouteId());
        if (selectedRouteDirectionDetails == null) {
            Logger.INSTANCE.logCritical(new CriticalLog("No route direction details found for route id: " + selectedDeparture.getRouteId()));
            return;
        }
        CheckoutDirectionState value4 = getOutboundDirectionState().getValue();
        PassengerInfo passengerInfo = setupPassengerInfo(isWalking, value, value4 != null ? value4.getPassengerInfo() : null);
        MutableStateFlow<CheckoutDirectionState> returnDirectionState3 = getReturnDirectionState();
        while (true) {
            RouteSelectedState routeSelectedState = value;
            MutableStateFlow<CheckoutDirectionState> mutableStateFlow = returnDirectionState3;
            if (mutableStateFlow.compareAndSet(returnDirectionState3.getValue(), new CheckoutDirectionState(selectedDeparture, selectedDepartureTicket, value.getSelectedRouteDirection(), selectedRouteDirectionDetails, value.getTransportationCargoInfo(), value.getSelectedTrailer(), passengerInfo, value.getSelectedTransportProducts(), null, null, null, null, null, null, new PriceTotal(selectedDepartureTicket.getPrice()), null, null, null, null, 505600, null))) {
                updateTotalPrice(getReturnDirectionState().getValue(), DepartureDirection.Return);
                return;
            } else {
                returnDirectionState3 = mutableStateFlow;
                value = routeSelectedState;
            }
        }
    }

    private final void totalPriceUpdater() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new CheckoutManager$totalPriceUpdater$1(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new CheckoutManager$totalPriceUpdater$2(this, null), 3, null);
    }

    private final Object updateLocalUserData(Continuation<? super Unit> continuation) {
        CheckoutContactInfo personalInfo;
        UserContactDetails userContactDetails;
        if (this.editManager.getEditState().getValue().getIsEditing()) {
            return Unit.INSTANCE;
        }
        CheckoutState value = getCheckoutState().getValue();
        if (value != null && (personalInfo = value.getPersonalInfo()) != null && (userContactDetails = personalInfo.toUserContactDetails()) != null) {
            Object updateLocalUser = this.userManager.updateLocalUser(userContactDetails, (Continuation<? super ManagerResult<Unit>>) continuation);
            if (updateLocalUser == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return updateLocalUser;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ce A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updatePurchaseCount(Continuation<? super Unit> continuation) {
        CheckoutManager$updatePurchaseCount$1 checkoutManager$updatePurchaseCount$1;
        Object coroutine_suspended;
        int i5;
        RouteDirectionDetails routeDirectionDetails;
        CheckoutManager checkoutManager;
        SettingsProperty.Tracking.TicketsPurchasedCount ticketsPurchasedCount;
        ISettings iSettings;
        Integer boxInt;
        if (continuation instanceof CheckoutManager$updatePurchaseCount$1) {
            checkoutManager$updatePurchaseCount$1 = (CheckoutManager$updatePurchaseCount$1) continuation;
            int i6 = checkoutManager$updatePurchaseCount$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                checkoutManager$updatePurchaseCount$1.label = i6 - Integer.MIN_VALUE;
                Object obj = checkoutManager$updatePurchaseCount$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = checkoutManager$updatePurchaseCount$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ISettings iSettings2 = this.settings;
                    SettingsProperty.Tracking.PurchaseCountPerCityId purchaseCountPerCityId = SettingsProperty.Tracking.PurchaseCountPerCityId.INSTANCE;
                    Map mutableMap = MapsKt.toMutableMap((Map) iSettings2.latestValueFor(purchaseCountPerCityId));
                    CheckoutDirectionState value = directionState(DepartureDirection.Outbound).getValue();
                    if (value == null || (routeDirectionDetails = value.getRouteDirectionDetails()) == null) {
                        return Unit.INSTANCE;
                    }
                    String id = routeDirectionDetails.getDepartureHarbor().getId();
                    String id2 = routeDirectionDetails.getArrivalHarbor().getId();
                    Integer num = (Integer) mutableMap.get(id);
                    mutableMap.put(id, Boxing.boxInt(num != null ? num.intValue() + 1 : 1));
                    Integer num2 = (Integer) mutableMap.get(id2);
                    mutableMap.put(id2, Boxing.boxInt(num2 != null ? num2.intValue() + 1 : 1));
                    ISettings iSettings3 = this.settings;
                    checkoutManager$updatePurchaseCount$1.L$0 = this;
                    checkoutManager$updatePurchaseCount$1.label = 1;
                    if (iSettings3.update(purchaseCountPerCityId, mutableMap, checkoutManager$updatePurchaseCount$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    checkoutManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    checkoutManager = (CheckoutManager) checkoutManager$updatePurchaseCount$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                ISettings iSettings4 = checkoutManager.settings;
                ticketsPurchasedCount = SettingsProperty.Tracking.TicketsPurchasedCount.INSTANCE;
                int intValue = ((Number) iSettings4.latestValueFor(ticketsPurchasedCount)).intValue();
                iSettings = checkoutManager.settings;
                boxInt = Boxing.boxInt(intValue + 1);
                checkoutManager$updatePurchaseCount$1.L$0 = null;
                checkoutManager$updatePurchaseCount$1.label = 2;
                if (iSettings.update(ticketsPurchasedCount, boxInt, checkoutManager$updatePurchaseCount$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        checkoutManager$updatePurchaseCount$1 = new CheckoutManager$updatePurchaseCount$1(this, continuation);
        Object obj2 = checkoutManager$updatePurchaseCount$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = checkoutManager$updatePurchaseCount$1.label;
        if (i5 != 0) {
        }
        ISettings iSettings42 = checkoutManager.settings;
        ticketsPurchasedCount = SettingsProperty.Tracking.TicketsPurchasedCount.INSTANCE;
        int intValue2 = ((Number) iSettings42.latestValueFor(ticketsPurchasedCount)).intValue();
        iSettings = checkoutManager.settings;
        boxInt = Boxing.boxInt(intValue2 + 1);
        checkoutManager$updatePurchaseCount$1.L$0 = null;
        checkoutManager$updatePurchaseCount$1.label = 2;
        if (iSettings.update(ticketsPurchasedCount, boxInt, checkoutManager$updatePurchaseCount$1) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTotalPrice(CheckoutDirectionState state, DepartureDirection departureDirection) {
        CheckoutDirectionState value;
        CheckoutDirectionState checkoutDirectionState;
        CheckoutState value2;
        CheckoutState checkoutState;
        CheckoutState value3 = getCheckoutState().getValue();
        if (value3 == null) {
            return;
        }
        PriceTotal calculateDirectionSum = PriceHelper.INSTANCE.calculateDirectionSum(state, value3.getCurrency());
        MutableStateFlow<CheckoutDirectionState> directionState = directionState(departureDirection);
        do {
            value = directionState.getValue();
            checkoutDirectionState = value;
        } while (!directionState.compareAndSet(value, checkoutDirectionState != null ? CheckoutDirectionState.copy$default(checkoutDirectionState, null, null, null, null, null, null, null, null, null, null, null, null, null, null, calculateDirectionSum, null, null, null, null, 507903, null) : null));
        PriceHelper priceHelper = PriceHelper.INSTANCE;
        CheckoutDirectionState value4 = getOutboundDirectionState().getValue();
        if (value4 == null) {
            return;
        }
        PriceDetails calculatePriceDetails = priceHelper.calculatePriceDetails(value4, getReturnDirectionState().getValue(), value3, Feature.AddonsNoneRefundable.isEnabled(), value3.getCurrency());
        MutableStateFlow<CheckoutState> checkoutState2 = getCheckoutState();
        do {
            value2 = checkoutState2.getValue();
            checkoutState = value2;
        } while (!checkoutState2.compareAndSet(value2, checkoutState != null ? CheckoutState.copy$default(checkoutState, null, null, null, null, false, false, null, null, null, null, null, null, false, calculatePriceDetails, false, null, null, null, null, false, null, 2088959, null) : null));
    }

    public void clearOutboundState() {
        MutableStateFlow<CheckoutDirectionState> outboundDirectionState = getOutboundDirectionState();
        do {
        } while (!outboundDirectionState.compareAndSet(outboundDirectionState.getValue(), null));
    }

    @Override // dk.molslinjen.domain.managers.checkout.ICheckoutManager
    public void clearReturnState() {
        CheckoutState value;
        CheckoutState checkoutState;
        MutableStateFlow<CheckoutState> checkoutState2 = getCheckoutState();
        do {
            value = checkoutState2.getValue();
            checkoutState = value;
        } while (!checkoutState2.compareAndSet(value, checkoutState != null ? CheckoutState.copy$default(checkoutState, BookingType.Single, null, null, null, false, false, null, null, null, null, null, null, false, null, false, null, null, null, null, false, null, 2097150, null) : null));
        MutableStateFlow<CheckoutDirectionState> returnDirectionState = getReturnDirectionState();
        do {
        } while (!returnDirectionState.compareAndSet(returnDirectionState.getValue(), null));
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x026b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    @Override // dk.molslinjen.domain.managers.checkout.ICreateBooking
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object createBooking(float f5, float f6, Continuation<? super ManagerResult<BookingCompleted>> continuation) {
        CheckoutManager$createBooking$1 checkoutManager$createBooking$1;
        Object coroutine_suspended;
        int i5;
        CheckoutState value;
        float f7;
        float f8;
        CheckoutManager checkoutManager;
        String str;
        CommuterBookingData commuterBookingData;
        Booking editingBooking;
        String str2;
        AuthenticationInfo authenticationInfo;
        String commuteAgreementId;
        MultiRideBookingData multiRideBookingData;
        BookRequestParameters.MultiRideRequestParameters multiRideRequestParameters;
        AuthenticationInfo authenticationInfo2;
        MultiRideInfo multiRideInfo;
        BookRequestParameters.MultiRideRequestParameters multiRideRequestParameters2;
        Object book;
        final CheckoutState checkoutState;
        final CheckoutManager checkoutManager2;
        CustomerInfo customerInfo;
        PhoneNumber phoneNumber;
        if (continuation instanceof CheckoutManager$createBooking$1) {
            checkoutManager$createBooking$1 = (CheckoutManager$createBooking$1) continuation;
            int i6 = checkoutManager$createBooking$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                checkoutManager$createBooking$1.label = i6 - Integer.MIN_VALUE;
                CheckoutManager$createBooking$1 checkoutManager$createBooking$12 = checkoutManager$createBooking$1;
                Object obj = checkoutManager$createBooking$12.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = checkoutManager$createBooking$12.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    this.paymentManager.restartPaymentFlow();
                    value = getCheckoutState().getValue();
                    if (value == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    checkoutManager$createBooking$12.L$0 = this;
                    checkoutManager$createBooking$12.L$1 = value;
                    f7 = f5;
                    checkoutManager$createBooking$12.F$0 = f7;
                    f8 = f6;
                    checkoutManager$createBooking$12.F$1 = f8;
                    checkoutManager$createBooking$12.label = 1;
                    if (updateLocalUserData(checkoutManager$createBooking$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    checkoutManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        checkoutState = (CheckoutState) checkoutManager$createBooking$12.L$1;
                        checkoutManager2 = (CheckoutManager) checkoutManager$createBooking$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj, new Function1() { // from class: B1.a
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                BookingCompleted createBooking$lambda$35;
                                createBooking$lambda$35 = CheckoutManager.createBooking$lambda$35(CheckoutManager.this, checkoutState, (BookingCompletedResponseDTO) obj2);
                                return createBooking$lambda$35;
                            }
                        });
                    }
                    float f9 = checkoutManager$createBooking$12.F$1;
                    float f10 = checkoutManager$createBooking$12.F$0;
                    CheckoutState checkoutState2 = (CheckoutState) checkoutManager$createBooking$12.L$1;
                    checkoutManager = (CheckoutManager) checkoutManager$createBooking$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    value = checkoutState2;
                    f8 = f9;
                    f7 = f10;
                }
                str = (String) checkoutManager.settings.latestValueFor(SettingsProperty.DeparturesSessionKey.INSTANCE);
                if (str == null) {
                    str = BuildConfig.FLAVOR;
                }
                IBookingService iBookingService = checkoutManager.bookingService;
                CurrencyTypeDTO dto = value.getCurrency().toDTO();
                String email = value.getPersonalInfo().getEmail();
                String nationalNumber = value.getPersonalInfo().getPhoneNumber().getNationalNumber();
                String postalCode = value.getPersonalInfo().getPostalCode();
                String countryCode = value.getPersonalInfo().getPhoneNumber().getCountryCode();
                UserVehicle selectedVehicle = value.getSelectedVehicle();
                BookRequestParameters.CustomerInfoRequestParameters customerInfoRequestParameters = new BookRequestParameters.CustomerInfoRequestParameters(email, nationalNumber, postalCode, countryCode, selectedVehicle == null ? selectedVehicle.getLicensePlate() : null);
                int i7 = 0;
                List<CheckoutDirectionState> listOf = CollectionsKt.listOf((Object[]) new CheckoutDirectionState[]{checkoutManager.getOutboundDirectionState().getValue(), checkoutManager.getReturnDirectionState().getValue()});
                ArrayList arrayList = new ArrayList();
                for (CheckoutDirectionState checkoutDirectionState : listOf) {
                    if (checkoutDirectionState != null) {
                        arrayList.add(checkoutDirectionState);
                    }
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                for (Object obj2 : arrayList) {
                    int i8 = i7 + 1;
                    if (i7 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    arrayList2.add(checkoutManager.buildTicketRequestParameters((CheckoutDirectionState) obj2, i7 == 0 ? RouteDirection.Outbound : RouteDirection.Return, value));
                    i7 = i8;
                }
                commuterBookingData = value.getCommuterBookingData();
                if (commuterBookingData != null || (commuteAgreementId = commuterBookingData.getAgreementId()) == null) {
                    editingBooking = value.getEditingBooking();
                    if (editingBooking != null || (authenticationInfo = editingBooking.getAuthenticationInfo()) == null) {
                        str2 = null;
                        multiRideBookingData = value.getMultiRideBookingData();
                        if (multiRideBookingData != null) {
                            multiRideRequestParameters2 = new BookRequestParameters.MultiRideRequestParameters(multiRideBookingData.getAgreementNumber(), multiRideBookingData.getTypeId(), multiRideBookingData.getCustomer());
                        } else {
                            Booking editingBooking2 = value.getEditingBooking();
                            if (editingBooking2 == null || (authenticationInfo2 = editingBooking2.getAuthenticationInfo()) == null || (multiRideInfo = authenticationInfo2.getMultiRideInfo()) == null) {
                                multiRideRequestParameters = null;
                                Booking editingBooking3 = value.getEditingBooking();
                                String reservationNumber = editingBooking3 == null ? editingBooking3.getReservationNumber() : null;
                                Booking editingBooking4 = value.getEditingBooking();
                                BookRequestParameters.BookingRequestParameters bookingRequestParameters = new BookRequestParameters.BookingRequestParameters(customerInfoRequestParameters, arrayList2, str2, multiRideRequestParameters, reservationNumber, dto, (editingBooking4 != null || (customerInfo = editingBooking4.getCustomerInfo()) == null || (phoneNumber = customerInfo.getPhoneNumber()) == null) ? null : phoneNumber.getNationalNumber());
                                PaymentTypeRequestParameters requestParameters = value.getSelectedPaymentType().toDTO().toRequestParameters();
                                boolean signedUpForNewsletter = value.getSignedUpForNewsletter();
                                boolean acceptedMarketing = value.getAcceptedMarketing();
                                String paymentCallbackUrl = checkoutManager.paymentCallbackUrl.getPaymentCallbackUrl();
                                String paymentCallbackUrl2 = checkoutManager.paymentCallbackUrl.getPaymentCallbackUrl();
                                CreditCard selectedCreditCard = value.getSelectedCreditCard();
                                PaymentDataRequestParameters paymentDataRequestParameters = new PaymentDataRequestParameters(selectedCreditCard == null ? selectedCreditCard.getCreditCardToken() : null, paymentCallbackUrl, paymentCallbackUrl2);
                                String str3 = !Environment.INSTANCE.isMolslinjen() ? "AP51" : "KE11";
                                String language = Locale.getDefault().getLanguage();
                                Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
                                BookRequestParameters bookRequestParameters = new BookRequestParameters(bookingRequestParameters, requestParameters, signedUpForNewsletter, acceptedMarketing, new ApiAppPaymentRedirectDetailsDTO(f8, f7, language, IpHelperKt.getIpAddress()), paymentDataRequestParameters, str3);
                                SiteDTO dto2 = value.getSite().toDTO();
                                String mo3198getAuthTokenOEbVFrA = checkoutManager.userManager.mo3198getAuthTokenOEbVFrA();
                                AuthTokenDTO m3214toDTOimpl = mo3198getAuthTokenOEbVFrA != null ? AuthToken.m3214toDTOimpl(mo3198getAuthTokenOEbVFrA) : null;
                                checkoutManager$createBooking$12.L$0 = checkoutManager;
                                checkoutManager$createBooking$12.L$1 = value;
                                checkoutManager$createBooking$12.label = 2;
                                book = iBookingService.book(bookRequestParameters, dto2, m3214toDTOimpl, str, checkoutManager$createBooking$12);
                                if (book != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                checkoutState = value;
                                obj = book;
                                checkoutManager2 = checkoutManager;
                                return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj, new Function1() { // from class: B1.a
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj22) {
                                        BookingCompleted createBooking$lambda$35;
                                        createBooking$lambda$35 = CheckoutManager.createBooking$lambda$35(CheckoutManager.this, checkoutState, (BookingCompletedResponseDTO) obj22);
                                        return createBooking$lambda$35;
                                    }
                                });
                            }
                            multiRideRequestParameters2 = new BookRequestParameters.MultiRideRequestParameters(multiRideInfo.getCardNumber(), multiRideInfo.getCardType(), multiRideInfo.getCustomerId());
                        }
                        multiRideRequestParameters = multiRideRequestParameters2;
                        Booking editingBooking32 = value.getEditingBooking();
                        if (editingBooking32 == null) {
                        }
                        Booking editingBooking42 = value.getEditingBooking();
                        BookRequestParameters.BookingRequestParameters bookingRequestParameters2 = new BookRequestParameters.BookingRequestParameters(customerInfoRequestParameters, arrayList2, str2, multiRideRequestParameters, reservationNumber, dto, (editingBooking42 != null || (customerInfo = editingBooking42.getCustomerInfo()) == null || (phoneNumber = customerInfo.getPhoneNumber()) == null) ? null : phoneNumber.getNationalNumber());
                        PaymentTypeRequestParameters requestParameters2 = value.getSelectedPaymentType().toDTO().toRequestParameters();
                        boolean signedUpForNewsletter2 = value.getSignedUpForNewsletter();
                        boolean acceptedMarketing2 = value.getAcceptedMarketing();
                        String paymentCallbackUrl3 = checkoutManager.paymentCallbackUrl.getPaymentCallbackUrl();
                        String paymentCallbackUrl22 = checkoutManager.paymentCallbackUrl.getPaymentCallbackUrl();
                        CreditCard selectedCreditCard2 = value.getSelectedCreditCard();
                        PaymentDataRequestParameters paymentDataRequestParameters2 = new PaymentDataRequestParameters(selectedCreditCard2 == null ? selectedCreditCard2.getCreditCardToken() : null, paymentCallbackUrl3, paymentCallbackUrl22);
                        String str32 = !Environment.INSTANCE.isMolslinjen() ? "AP51" : "KE11";
                        String language2 = Locale.getDefault().getLanguage();
                        Intrinsics.checkNotNullExpressionValue(language2, "getLanguage(...)");
                        BookRequestParameters bookRequestParameters2 = new BookRequestParameters(bookingRequestParameters2, requestParameters2, signedUpForNewsletter2, acceptedMarketing2, new ApiAppPaymentRedirectDetailsDTO(f8, f7, language2, IpHelperKt.getIpAddress()), paymentDataRequestParameters2, str32);
                        SiteDTO dto22 = value.getSite().toDTO();
                        String mo3198getAuthTokenOEbVFrA2 = checkoutManager.userManager.mo3198getAuthTokenOEbVFrA();
                        if (mo3198getAuthTokenOEbVFrA2 != null) {
                        }
                        checkoutManager$createBooking$12.L$0 = checkoutManager;
                        checkoutManager$createBooking$12.L$1 = value;
                        checkoutManager$createBooking$12.label = 2;
                        book = iBookingService.book(bookRequestParameters2, dto22, m3214toDTOimpl, str, checkoutManager$createBooking$12);
                        if (book != coroutine_suspended) {
                        }
                    } else {
                        commuteAgreementId = authenticationInfo.getCommuteAgreementId();
                    }
                }
                str2 = commuteAgreementId;
                multiRideBookingData = value.getMultiRideBookingData();
                if (multiRideBookingData != null) {
                }
                multiRideRequestParameters = multiRideRequestParameters2;
                Booking editingBooking322 = value.getEditingBooking();
                if (editingBooking322 == null) {
                }
                Booking editingBooking422 = value.getEditingBooking();
                BookRequestParameters.BookingRequestParameters bookingRequestParameters22 = new BookRequestParameters.BookingRequestParameters(customerInfoRequestParameters, arrayList2, str2, multiRideRequestParameters, reservationNumber, dto, (editingBooking422 != null || (customerInfo = editingBooking422.getCustomerInfo()) == null || (phoneNumber = customerInfo.getPhoneNumber()) == null) ? null : phoneNumber.getNationalNumber());
                PaymentTypeRequestParameters requestParameters22 = value.getSelectedPaymentType().toDTO().toRequestParameters();
                boolean signedUpForNewsletter22 = value.getSignedUpForNewsletter();
                boolean acceptedMarketing22 = value.getAcceptedMarketing();
                String paymentCallbackUrl32 = checkoutManager.paymentCallbackUrl.getPaymentCallbackUrl();
                String paymentCallbackUrl222 = checkoutManager.paymentCallbackUrl.getPaymentCallbackUrl();
                CreditCard selectedCreditCard22 = value.getSelectedCreditCard();
                PaymentDataRequestParameters paymentDataRequestParameters22 = new PaymentDataRequestParameters(selectedCreditCard22 == null ? selectedCreditCard22.getCreditCardToken() : null, paymentCallbackUrl32, paymentCallbackUrl222);
                String str322 = !Environment.INSTANCE.isMolslinjen() ? "AP51" : "KE11";
                String language22 = Locale.getDefault().getLanguage();
                Intrinsics.checkNotNullExpressionValue(language22, "getLanguage(...)");
                BookRequestParameters bookRequestParameters22 = new BookRequestParameters(bookingRequestParameters22, requestParameters22, signedUpForNewsletter22, acceptedMarketing22, new ApiAppPaymentRedirectDetailsDTO(f8, f7, language22, IpHelperKt.getIpAddress()), paymentDataRequestParameters22, str322);
                SiteDTO dto222 = value.getSite().toDTO();
                String mo3198getAuthTokenOEbVFrA22 = checkoutManager.userManager.mo3198getAuthTokenOEbVFrA();
                if (mo3198getAuthTokenOEbVFrA22 != null) {
                }
                checkoutManager$createBooking$12.L$0 = checkoutManager;
                checkoutManager$createBooking$12.L$1 = value;
                checkoutManager$createBooking$12.label = 2;
                book = iBookingService.book(bookRequestParameters22, dto222, m3214toDTOimpl, str, checkoutManager$createBooking$12);
                if (book != coroutine_suspended) {
                }
            }
        }
        checkoutManager$createBooking$1 = new CheckoutManager$createBooking$1(this, continuation);
        CheckoutManager$createBooking$1 checkoutManager$createBooking$122 = checkoutManager$createBooking$1;
        Object obj3 = checkoutManager$createBooking$122.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = checkoutManager$createBooking$122.label;
        if (i5 != 0) {
        }
        str = (String) checkoutManager.settings.latestValueFor(SettingsProperty.DeparturesSessionKey.INSTANCE);
        if (str == null) {
        }
        IBookingService iBookingService2 = checkoutManager.bookingService;
        CurrencyTypeDTO dto3 = value.getCurrency().toDTO();
        String email2 = value.getPersonalInfo().getEmail();
        String nationalNumber2 = value.getPersonalInfo().getPhoneNumber().getNationalNumber();
        String postalCode2 = value.getPersonalInfo().getPostalCode();
        String countryCode2 = value.getPersonalInfo().getPhoneNumber().getCountryCode();
        UserVehicle selectedVehicle2 = value.getSelectedVehicle();
        BookRequestParameters.CustomerInfoRequestParameters customerInfoRequestParameters2 = new BookRequestParameters.CustomerInfoRequestParameters(email2, nationalNumber2, postalCode2, countryCode2, selectedVehicle2 == null ? selectedVehicle2.getLicensePlate() : null);
        int i72 = 0;
        List<CheckoutDirectionState> listOf2 = CollectionsKt.listOf((Object[]) new CheckoutDirectionState[]{checkoutManager.getOutboundDirectionState().getValue(), checkoutManager.getReturnDirectionState().getValue()});
        ArrayList arrayList3 = new ArrayList();
        while (r5.hasNext()) {
        }
        ArrayList arrayList22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        while (r5.hasNext()) {
        }
        commuterBookingData = value.getCommuterBookingData();
        if (commuterBookingData != null) {
        }
        editingBooking = value.getEditingBooking();
        if (editingBooking != null) {
        }
        str2 = null;
        multiRideBookingData = value.getMultiRideBookingData();
        if (multiRideBookingData != null) {
        }
        multiRideRequestParameters = multiRideRequestParameters2;
        Booking editingBooking3222 = value.getEditingBooking();
        if (editingBooking3222 == null) {
        }
        Booking editingBooking4222 = value.getEditingBooking();
        BookRequestParameters.BookingRequestParameters bookingRequestParameters222 = new BookRequestParameters.BookingRequestParameters(customerInfoRequestParameters2, arrayList22, str2, multiRideRequestParameters, reservationNumber, dto3, (editingBooking4222 != null || (customerInfo = editingBooking4222.getCustomerInfo()) == null || (phoneNumber = customerInfo.getPhoneNumber()) == null) ? null : phoneNumber.getNationalNumber());
        PaymentTypeRequestParameters requestParameters222 = value.getSelectedPaymentType().toDTO().toRequestParameters();
        boolean signedUpForNewsletter222 = value.getSignedUpForNewsletter();
        boolean acceptedMarketing222 = value.getAcceptedMarketing();
        String paymentCallbackUrl322 = checkoutManager.paymentCallbackUrl.getPaymentCallbackUrl();
        String paymentCallbackUrl2222 = checkoutManager.paymentCallbackUrl.getPaymentCallbackUrl();
        CreditCard selectedCreditCard222 = value.getSelectedCreditCard();
        PaymentDataRequestParameters paymentDataRequestParameters222 = new PaymentDataRequestParameters(selectedCreditCard222 == null ? selectedCreditCard222.getCreditCardToken() : null, paymentCallbackUrl322, paymentCallbackUrl2222);
        String str3222 = !Environment.INSTANCE.isMolslinjen() ? "AP51" : "KE11";
        String language222 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(language222, "getLanguage(...)");
        BookRequestParameters bookRequestParameters222 = new BookRequestParameters(bookingRequestParameters222, requestParameters222, signedUpForNewsletter222, acceptedMarketing222, new ApiAppPaymentRedirectDetailsDTO(f8, f7, language222, IpHelperKt.getIpAddress()), paymentDataRequestParameters222, str3222);
        SiteDTO dto2222 = value.getSite().toDTO();
        String mo3198getAuthTokenOEbVFrA222 = checkoutManager.userManager.mo3198getAuthTokenOEbVFrA();
        if (mo3198getAuthTokenOEbVFrA222 != null) {
        }
        checkoutManager$createBooking$122.L$0 = checkoutManager;
        checkoutManager$createBooking$122.L$1 = value;
        checkoutManager$createBooking$122.label = 2;
        book = iBookingService2.book(bookRequestParameters222, dto2222, m3214toDTOimpl, str, checkoutManager$createBooking$122);
        if (book != coroutine_suspended) {
        }
    }

    @Override // dk.molslinjen.domain.managers.checkout.ICheckoutManager
    public void selectPaymentMethod(PaymentType paymentType, CreditCard creditCard) {
        CheckoutState checkoutState;
        CheckoutState checkoutState2;
        Intrinsics.checkNotNullParameter(paymentType, "paymentType");
        MutableStateFlow<CheckoutState> checkoutState3 = getCheckoutState();
        do {
            CheckoutState value = checkoutState3.getValue();
            CheckoutState checkoutState4 = value;
            if (checkoutState4 != null) {
                checkoutState = value;
                checkoutState2 = CheckoutState.copy$default(checkoutState4, null, null, null, null, false, false, paymentType, creditCard, null, null, null, null, false, null, false, null, null, null, null, false, null, 2096959, null);
            } else {
                checkoutState = value;
                checkoutState2 = null;
            }
        } while (!checkoutState3.compareAndSet(checkoutState, checkoutState2));
    }

    @Override // dk.molslinjen.domain.managers.checkout.ICheckoutManager
    public ManagerResult<Unit> setSeatReservation(CheckoutSeatReservation seatReservation, DepartureDirection direction) {
        UnavailableSeatReservation unavailableSeatReservation;
        CheckoutDirectionState checkoutDirectionState;
        CheckoutDirectionState checkoutDirectionState2;
        Intrinsics.checkNotNullParameter(direction, "direction");
        MutableStateFlow<CheckoutDirectionState> directionState = directionState(direction);
        if (directionState.getValue() == null) {
            Logger.log$default(Logger.INSTANCE, "Trying to add seat, but checkout state was not set for " + direction, null, 0, 6, null);
            return ManagerResult.Error.INSTANCE.noMessage();
        }
        CheckoutDirectionState value = directionState.getValue();
        if (value == null || (unavailableSeatReservation = value.getUnavailableSeatReservation()) == null) {
            unavailableSeatReservation = null;
        } else if (unavailableSeatReservation instanceof UnavailableSeatReservation.Invalid) {
            unavailableSeatReservation = new UnavailableSeatReservation.Invalidated(unavailableSeatReservation.getReservation());
        }
        do {
            CheckoutDirectionState value2 = directionState.getValue();
            CheckoutDirectionState checkoutDirectionState3 = value2;
            if (checkoutDirectionState3 != null) {
                checkoutDirectionState = value2;
                checkoutDirectionState2 = CheckoutDirectionState.copy$default(checkoutDirectionState3, null, null, null, null, null, null, null, null, null, null, null, seatReservation, unavailableSeatReservation, null, null, null, null, null, null, 518143, null);
            } else {
                checkoutDirectionState = value2;
                checkoutDirectionState2 = null;
            }
        } while (!directionState.compareAndSet(checkoutDirectionState, checkoutDirectionState2));
        return new ManagerResult.Success(Unit.INSTANCE);
    }

    @Override // dk.molslinjen.domain.managers.checkout.ICheckoutManager
    public void setup(boolean isAddingReturnFromBookingSummary) {
        CheckoutContactInfo checkoutContactInfo;
        CustomerInfo customerInfo;
        if (!isAddingReturnFromBookingSummary) {
            clearOutboundState();
            clearReturnState();
        }
        DepartureState value = this.departureManager.getOutboundState().getValue();
        RouteSelectedState value2 = this.routeManager.getOutboundSelectedState().getValue();
        RouteSharedSelectedState value3 = this.routeManager.getSharedSelectedState().getValue();
        BookingType value4 = this.routeManager.getBookingTypeState().getValue();
        Departure selectedDeparture = value.getSelectedDeparture();
        DepartureTicket selectedDepartureTicket = value.getSelectedDepartureTicket();
        UserInfo details = this.userManager.getCurrentUserState().getValue().getUser().getDetails();
        if (value3 != null) {
            Transportation selectedTransportation = value3.getSelectedTransportation();
            boolean z5 = value3.getSelectedRoute().isEarlyCheckInPossible() && value3.getSelectedTransportation().isEarlyCheckInAllowed();
            Booking booking = this.editManager.getEditState().getValue().getBooking();
            CommuterBookingData commuterBookingData = value3.getCommuterBookingData();
            MutableStateFlow<CheckoutState> checkoutState = getCheckoutState();
            while (true) {
                CheckoutState value5 = checkoutState.getValue();
                Site site = value3.getSite();
                String id = value3.getSelectedRoute().getId();
                Transportation selectedTransportation2 = value3.getSelectedTransportation();
                if (booking == null || (customerInfo = booking.getCustomerInfo()) == null) {
                    checkoutContactInfo = new CheckoutContactInfo(details != null ? details.getContactDetails() : null);
                } else {
                    checkoutContactInfo = new CheckoutContactInfo(customerInfo);
                }
                MutableStateFlow<CheckoutState> mutableStateFlow = checkoutState;
                if (mutableStateFlow.compareAndSet(value5, new CheckoutState(value4, selectedTransportation2, site, id, false, false, null, null, booking, null, null, null, z5 && selectedTransportation.isWalking(), new PriceDetails(null, false, null, false, null, 31, null), z5, checkoutContactInfo, value3.getCurrency(), commuterBookingData, value3.getMultiRideBookingData(), false, value3.getLineLogoUrl(), 528112, null))) {
                    break;
                } else {
                    checkoutState = mutableStateFlow;
                }
            }
            setupDirectionStates(value2, selectedDeparture, selectedDepartureTicket, selectedTransportation, isAddingReturnFromBookingSummary, value4, booking != null ? booking.getTicket() : null);
            selectDefaultVehicle();
        }
    }

    @Override // dk.molslinjen.domain.managers.checkout.ICheckoutManager
    public void toggleAcceptMarketing() {
        CheckoutState value;
        CheckoutState checkoutState;
        MutableStateFlow<CheckoutState> checkoutState2 = getCheckoutState();
        do {
            value = checkoutState2.getValue();
            checkoutState = value;
        } while (!checkoutState2.compareAndSet(value, checkoutState != null ? CheckoutState.copy$default(checkoutState, null, null, null, null, false, !checkoutState.getAcceptedMarketing(), null, null, null, null, null, null, false, null, false, null, null, null, null, false, null, 2097119, null) : null));
    }

    @Override // dk.molslinjen.domain.managers.checkout.ICheckoutManager
    public void toggleNewsletterSignup() {
        CheckoutState value;
        CheckoutState checkoutState;
        MutableStateFlow<CheckoutState> checkoutState2 = getCheckoutState();
        do {
            value = checkoutState2.getValue();
            checkoutState = value;
        } while (!checkoutState2.compareAndSet(value, checkoutState != null ? CheckoutState.copy$default(checkoutState, null, null, null, null, !checkoutState.getSignedUpForNewsletter(), false, null, null, null, null, null, null, false, null, false, null, null, null, null, false, null, 2097135, null) : null));
    }

    @Override // dk.molslinjen.domain.managers.checkout.ICheckoutManager
    public void updateAddons(AddonHelper.AddonState addonState, DepartureDirection departureDirection) {
        CheckoutDirectionState value;
        Collection emptyList;
        CheckoutDirectionState checkoutDirectionState;
        List emptyList2;
        Intrinsics.checkNotNullParameter(addonState, "addonState");
        Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
        MutableStateFlow<CheckoutDirectionState> directionState = directionState(departureDirection);
        do {
            value = directionState.getValue();
            CheckoutDirectionState checkoutDirectionState2 = value;
            List<ProductGroup> productGroups = addonState.getProductGroups();
            if (productGroups != null) {
                emptyList = new ArrayList();
                Iterator<T> it = productGroups.iterator();
                while (it.hasNext()) {
                    CollectionsKt.addAll(emptyList, ((ProductGroup) it.next()).getProducts());
                }
            } else {
                emptyList = CollectionsKt.emptyList();
            }
            if (checkoutDirectionState2 != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : emptyList) {
                    if (((Product) obj).getQuantity() > 0) {
                        arrayList.add(obj);
                    }
                }
                List<ProductGroup> productGroups2 = addonState.getProductGroups();
                if (productGroups2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<T> it2 = productGroups2.iterator();
                    while (it2.hasNext()) {
                        CollectionsKt.addAll(arrayList2, ((ProductGroup) it2.next()).getProducts());
                    }
                    emptyList2 = arrayList2;
                } else {
                    emptyList2 = CollectionsKt.emptyList();
                }
                checkoutDirectionState = CheckoutDirectionState.copy$default(checkoutDirectionState2, null, null, null, null, null, null, null, null, arrayList, null, null, null, null, null, null, emptyList2, null, addonState.getUnavailableProducts(), null, 360191, null);
            } else {
                checkoutDirectionState = null;
            }
        } while (!directionState.compareAndSet(value, checkoutDirectionState));
    }

    @Override // dk.molslinjen.domain.managers.checkout.ICheckoutManager
    public void updateEarlyCheckIn(boolean earlyCheckIn) {
        CheckoutState value;
        CheckoutState checkoutState;
        MutableStateFlow<CheckoutState> checkoutState2 = getCheckoutState();
        do {
            value = checkoutState2.getValue();
            checkoutState = value;
        } while (!checkoutState2.compareAndSet(value, checkoutState != null ? CheckoutState.copy$default(checkoutState, null, null, null, null, false, false, null, null, null, null, null, null, earlyCheckIn, null, false, null, null, null, null, false, null, 2093055, null) : null));
    }

    @Override // dk.molslinjen.domain.managers.checkout.ICheckoutManager
    public void updateEmail(String email) {
        CheckoutState value;
        CheckoutState checkoutState;
        Intrinsics.checkNotNullParameter(email, "email");
        MutableStateFlow<CheckoutState> checkoutState2 = getCheckoutState();
        do {
            value = checkoutState2.getValue();
            checkoutState = value;
        } while (!checkoutState2.compareAndSet(value, checkoutState != null ? CheckoutState.copy$default(checkoutState, null, null, null, null, false, false, null, null, null, null, null, null, false, null, false, CheckoutContactInfo.copy$default(checkoutState.getPersonalInfo(), null, email, null, false, 13, null), null, null, null, false, null, 2064383, null) : null));
    }

    @Override // dk.molslinjen.domain.managers.checkout.ICheckoutManager
    public void updateFood(AddonHelper.AddonState addonState, DepartureDirection departureDirection) {
        Collection emptyList;
        CheckoutDirectionState value;
        CheckoutDirectionState checkoutDirectionState;
        List emptyList2;
        Intrinsics.checkNotNullParameter(addonState, "addonState");
        Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
        List<ProductGroup> food = addonState.getFood();
        if (food != null) {
            emptyList = new ArrayList();
            Iterator<T> it = food.iterator();
            while (it.hasNext()) {
                CollectionsKt.addAll(emptyList, ((ProductGroup) it.next()).getProducts());
            }
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        MutableStateFlow<CheckoutDirectionState> directionState = directionState(departureDirection);
        do {
            value = directionState.getValue();
            CheckoutDirectionState checkoutDirectionState2 = value;
            if (checkoutDirectionState2 != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : emptyList) {
                    if (((Product) obj).getQuantity() > 0) {
                        arrayList.add(obj);
                    }
                }
                List<ProductGroup> food2 = addonState.getFood();
                if (food2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<T> it2 = food2.iterator();
                    while (it2.hasNext()) {
                        CollectionsKt.addAll(arrayList2, ((ProductGroup) it2.next()).getProducts());
                    }
                    emptyList2 = arrayList2;
                } else {
                    emptyList2 = CollectionsKt.emptyList();
                }
                checkoutDirectionState = CheckoutDirectionState.copy$default(checkoutDirectionState2, null, null, null, null, null, null, null, null, null, null, arrayList, null, null, null, null, null, emptyList2, null, addonState.getUnavailableFood(), 195583, null);
            } else {
                checkoutDirectionState = null;
            }
        } while (!directionState.compareAndSet(value, checkoutDirectionState));
    }

    @Override // dk.molslinjen.domain.managers.checkout.ICheckoutManager
    public void updatePassengerCount(int passengerCount, DepartureDirection departureDirection) {
        CheckoutDirectionState value;
        CheckoutDirectionState checkoutDirectionState;
        Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
        MutableStateFlow<CheckoutDirectionState> outboundDirectionState = departureDirection == DepartureDirection.Outbound ? getOutboundDirectionState() : getReturnDirectionState();
        do {
            value = outboundDirectionState.getValue();
            checkoutDirectionState = value;
        } while (!outboundDirectionState.compareAndSet(value, checkoutDirectionState != null ? CheckoutDirectionState.copy$default(checkoutDirectionState, null, null, null, null, null, null, new PassengerInfo(passengerCount, 0, 0), null, null, null, null, null, null, null, null, null, null, null, null, 524223, null) : null));
    }

    @Override // dk.molslinjen.domain.managers.checkout.ICheckoutManager
    public void updatePhoneNumber(PhoneNumber phoneNumber) {
        CheckoutState value;
        CheckoutState checkoutState;
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        MutableStateFlow<CheckoutState> checkoutState2 = getCheckoutState();
        do {
            value = checkoutState2.getValue();
            checkoutState = value;
        } while (!checkoutState2.compareAndSet(value, checkoutState != null ? CheckoutState.copy$default(checkoutState, null, null, null, null, false, false, null, null, null, null, null, null, false, null, false, CheckoutContactInfo.copy$default(checkoutState.getPersonalInfo(), phoneNumber, null, null, false, 14, null), null, null, null, false, null, 2064383, null) : null));
    }

    @Override // dk.molslinjen.domain.managers.checkout.ICheckoutManager
    public void updatePostalCode(String postalCode) {
        CheckoutState value;
        CheckoutState checkoutState;
        Intrinsics.checkNotNullParameter(postalCode, "postalCode");
        MutableStateFlow<CheckoutState> checkoutState2 = getCheckoutState();
        do {
            value = checkoutState2.getValue();
            checkoutState = value;
        } while (!checkoutState2.compareAndSet(value, checkoutState != null ? CheckoutState.copy$default(checkoutState, null, null, null, null, false, false, null, null, null, null, null, null, false, null, false, CheckoutContactInfo.copy$default(checkoutState.getPersonalInfo(), null, null, postalCode, false, 11, null), null, null, null, false, null, 2064383, null) : null));
    }

    @Override // dk.molslinjen.domain.managers.checkout.ICheckoutManager
    public void updateSelectedVehicle(UserVehicle vehicle) {
        UserVehicle userVehicle;
        CheckoutState checkoutState;
        CheckoutState checkoutState2;
        Transportation transportation;
        Departure departure;
        CheckoutState value;
        CheckoutState checkoutState3;
        UserVehicle userVehicle2 = vehicle;
        MutableStateFlow<CheckoutState> checkoutState4 = getCheckoutState();
        while (true) {
            CheckoutState value2 = checkoutState4.getValue();
            CheckoutState checkoutState5 = value2;
            if (checkoutState5 != null) {
                userVehicle = userVehicle2;
                checkoutState2 = CheckoutState.copy$default(checkoutState5, null, null, null, null, false, false, null, null, null, null, null, vehicle, false, null, false, null, null, null, null, false, null, 2095103, null);
                checkoutState = value2;
                checkoutState4 = checkoutState4;
            } else {
                userVehicle = userVehicle2;
                checkoutState = value2;
                checkoutState2 = null;
            }
            if (checkoutState4.compareAndSet(checkoutState, checkoutState2)) {
                break;
            } else {
                userVehicle2 = userVehicle;
            }
        }
        CheckoutState value3 = getCheckoutState().getValue();
        if (value3 == null || (transportation = value3.getTransportation()) == null) {
            return;
        }
        CheckoutDirectionState value4 = getOutboundDirectionState().getValue();
        if (value4 == null || (departure = value4.getDeparture()) == null) {
            return;
        }
        boolean isBefore = departure.getDepartureDateTime().isBefore(LocalDateTime.now().plusDays(2L));
        CheckoutState value5 = getCheckoutState().getValue();
        if (value5 != null) {
            if (value5.getIsEarlyCheckInPossible() && !transportation.isWalking() && isBefore) {
                MutableStateFlow<CheckoutState> checkoutState6 = getCheckoutState();
                do {
                    value = checkoutState6.getValue();
                    CheckoutState checkoutState7 = value;
                    if (checkoutState7 != null) {
                        checkoutState3 = CheckoutState.copy$default(checkoutState7, null, null, null, null, false, false, null, null, null, null, null, null, userVehicle != null, null, false, null, null, null, null, false, null, 2093055, null);
                    } else {
                        checkoutState3 = null;
                    }
                } while (!checkoutState6.compareAndSet(value, checkoutState3));
            }
            if (userVehicle != null) {
                BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new CheckoutManager$updateSelectedVehicle$3(this, userVehicle, null), 3, null);
            }
        }
    }

    @Override // dk.molslinjen.domain.managers.checkout.ICheckoutManager
    public void updateSummaryAddons(SummaryAddonHelper.SummaryAddonState summaryAddonState) {
        CheckoutDirectionState value;
        CheckoutDirectionState checkoutDirectionState;
        CheckoutDirectionState value2;
        CheckoutDirectionState checkoutDirectionState2;
        Intrinsics.checkNotNullParameter(summaryAddonState, "summaryAddonState");
        MutableStateFlow<CheckoutDirectionState> directionState = directionState(DepartureDirection.Outbound);
        do {
            value = directionState.getValue();
            CheckoutDirectionState checkoutDirectionState3 = value;
            if (checkoutDirectionState3 != null) {
                List<Product> outboundProducts = summaryAddonState.getOutboundProducts();
                ArrayList arrayList = new ArrayList();
                for (Object obj : outboundProducts) {
                    if (((Product) obj).getQuantity() > 0) {
                        arrayList.add(obj);
                    }
                }
                checkoutDirectionState = CheckoutDirectionState.copy$default(checkoutDirectionState3, null, null, null, null, null, null, null, null, null, arrayList, null, null, null, null, null, null, null, null, null, 523775, null);
            } else {
                checkoutDirectionState = null;
            }
        } while (!directionState.compareAndSet(value, checkoutDirectionState));
        MutableStateFlow<CheckoutDirectionState> directionState2 = directionState(DepartureDirection.Return);
        do {
            value2 = directionState2.getValue();
            CheckoutDirectionState checkoutDirectionState4 = value2;
            if (checkoutDirectionState4 != null) {
                List<Product> returnProducts = summaryAddonState.getReturnProducts();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : returnProducts) {
                    if (((Product) obj2).getQuantity() > 0) {
                        arrayList2.add(obj2);
                    }
                }
                checkoutDirectionState2 = CheckoutDirectionState.copy$default(checkoutDirectionState4, null, null, null, null, null, null, null, null, null, arrayList2, null, null, null, null, null, null, null, null, null, 523775, null);
            } else {
                checkoutDirectionState2 = null;
            }
        } while (!directionState2.compareAndSet(value2, checkoutDirectionState2));
    }

    @Override // dk.molslinjen.domain.managers.checkout.ICheckoutManager
    public MutableStateFlow<CheckoutDirectionState> directionState(DepartureDirection departureDirection) {
        Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
        int i5 = WhenMappings.$EnumSwitchMapping$0[departureDirection.ordinal()];
        if (i5 == 1) {
            return getOutboundDirectionState();
        }
        if (i5 == 2) {
            return getReturnDirectionState();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // dk.molslinjen.domain.managers.checkout.ICheckoutManager
    public MutableStateFlow<CheckoutState> getCheckoutState() {
        return this.checkoutState;
    }

    @Override // dk.molslinjen.domain.managers.checkout.ICheckoutManager
    public MutableStateFlow<CheckoutDirectionState> getOutboundDirectionState() {
        return this.outboundDirectionState;
    }

    @Override // dk.molslinjen.domain.managers.checkout.ICheckoutManager
    public MutableStateFlow<CheckoutDirectionState> getReturnDirectionState() {
        return this.returnDirectionState;
    }

    @Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b/\b\u0086\b\u0018\u0000 `2\u00020\u0001:\u0001`Bñ\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0010\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u0010\u0012\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u0010¢\u0006\u0004\b#\u0010$J\u0015\u0010'\u001a\u00020\u00002\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u008c\u0002\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00102\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u00102\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u0010HÆ\u0001¢\u0006\u0004\b)\u0010*J\u0010\u0010,\u001a\u00020+HÖ\u0001¢\u0006\u0004\b,\u0010-J\u0010\u0010/\u001a\u00020.HÖ\u0001¢\u0006\u0004\b/\u00100J\u001a\u00103\u001a\u0002022\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b3\u00104R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00105\u001a\u0004\b6\u00107R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00108\u001a\u0004\b9\u0010:R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010;\u001a\u0004\b<\u0010=R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010>\u001a\u0004\b?\u0010@R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010A\u001a\u0004\bB\u0010CR\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010D\u001a\u0004\bE\u0010FR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010G\u001a\u0004\bH\u0010IR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006¢\u0006\f\n\u0004\b\u0012\u0010J\u001a\u0004\bK\u0010LR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006¢\u0006\f\n\u0004\b\u0013\u0010J\u001a\u0004\bM\u0010LR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006¢\u0006\f\n\u0004\b\u0014\u0010J\u001a\u0004\bN\u0010LR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006¢\u0006\f\n\u0004\b\u0015\u0010J\u001a\u0004\bO\u0010LR\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010P\u001a\u0004\bQ\u0010RR\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010S\u001a\u0004\bT\u0010UR\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00108\u0006¢\u0006\f\n\u0004\b\u001b\u0010J\u001a\u0004\bV\u0010LR\u0017\u0010\u001d\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010W\u001a\u0004\bX\u0010YR\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006¢\u0006\f\n\u0004\b\u001e\u0010J\u001a\u0004\bZ\u0010LR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006¢\u0006\f\n\u0004\b\u001f\u0010J\u001a\u0004\b[\u0010LR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u00108\u0006¢\u0006\f\n\u0004\b!\u0010J\u001a\u0004\b\\\u0010LR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u00108\u0006¢\u0006\f\n\u0004\b\"\u0010J\u001a\u0004\b]\u0010LR\u0011\u0010_\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\b^\u00100¨\u0006a"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutDirectionState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/Departure;", "departure", "Ldk/molslinjen/domain/model/booking/DepartureTicket;", "departureTicket", "Ldk/molslinjen/domain/model/booking/RouteDirection;", "routeDirection", "Ldk/molslinjen/domain/model/config/RouteDirectionDetails;", "routeDirectionDetails", "Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;", "transportationCargoInfo", "Ldk/molslinjen/domain/model/booking/product/TrailerProduct;", "trailer", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "passengerInfo", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/product/Product;", "transportProducts", "addons", "summaryAddons", "food", "Ldk/molslinjen/domain/model/booking/product/CheckoutSeatReservation;", "seatReservation", "Ldk/molslinjen/domain/model/booking/product/UnavailableSeatReservation;", "unavailableSeatReservation", "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "passengers", "Ldk/molslinjen/domain/managers/checkout/PriceTotal;", "totalPrice", "editAddons", "editFood", "Ldk/molslinjen/domain/model/booking/product/UnavailableProduct;", "editUnavailableProducts", "editUnavailableFood", "<init>", "(Ldk/molslinjen/domain/model/booking/Departure;Ldk/molslinjen/domain/model/booking/DepartureTicket;Ldk/molslinjen/domain/model/booking/RouteDirection;Ldk/molslinjen/domain/model/config/RouteDirectionDetails;Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;Ldk/molslinjen/domain/model/booking/product/TrailerProduct;Ldk/molslinjen/domain/model/booking/PassengerInfo;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ldk/molslinjen/domain/model/booking/product/CheckoutSeatReservation;Ldk/molslinjen/domain/model/booking/product/UnavailableSeatReservation;Ljava/util/List;Ldk/molslinjen/domain/managers/checkout/PriceTotal;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "Ldk/molslinjen/domain/managers/checkout/PassengerSelectionHelper$PassengerState;", "passengerState", "updatedForPassengerState", "(Ldk/molslinjen/domain/managers/checkout/PassengerSelectionHelper$PassengerState;)Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutDirectionState;", "copy", "(Ldk/molslinjen/domain/model/booking/Departure;Ldk/molslinjen/domain/model/booking/DepartureTicket;Ldk/molslinjen/domain/model/booking/RouteDirection;Ldk/molslinjen/domain/model/config/RouteDirectionDetails;Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;Ldk/molslinjen/domain/model/booking/product/TrailerProduct;Ldk/molslinjen/domain/model/booking/PassengerInfo;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ldk/molslinjen/domain/model/booking/product/CheckoutSeatReservation;Ldk/molslinjen/domain/model/booking/product/UnavailableSeatReservation;Ljava/util/List;Ldk/molslinjen/domain/managers/checkout/PriceTotal;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutDirectionState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/booking/Departure;", "getDeparture", "()Ldk/molslinjen/domain/model/booking/Departure;", "Ldk/molslinjen/domain/model/booking/DepartureTicket;", "getDepartureTicket", "()Ldk/molslinjen/domain/model/booking/DepartureTicket;", "Ldk/molslinjen/domain/model/booking/RouteDirection;", "getRouteDirection", "()Ldk/molslinjen/domain/model/booking/RouteDirection;", "Ldk/molslinjen/domain/model/config/RouteDirectionDetails;", "getRouteDirectionDetails", "()Ldk/molslinjen/domain/model/config/RouteDirectionDetails;", "Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;", "getTransportationCargoInfo", "()Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;", "Ldk/molslinjen/domain/model/booking/product/TrailerProduct;", "getTrailer", "()Ldk/molslinjen/domain/model/booking/product/TrailerProduct;", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "getPassengerInfo", "()Ldk/molslinjen/domain/model/booking/PassengerInfo;", "Ljava/util/List;", "getTransportProducts", "()Ljava/util/List;", "getAddons", "getSummaryAddons", "getFood", "Ldk/molslinjen/domain/model/booking/product/CheckoutSeatReservation;", "getSeatReservation", "()Ldk/molslinjen/domain/model/booking/product/CheckoutSeatReservation;", "Ldk/molslinjen/domain/model/booking/product/UnavailableSeatReservation;", "getUnavailableSeatReservation", "()Ldk/molslinjen/domain/model/booking/product/UnavailableSeatReservation;", "getPassengers", "Ldk/molslinjen/domain/managers/checkout/PriceTotal;", "getTotalPrice", "()Ldk/molslinjen/domain/managers/checkout/PriceTotal;", "getEditAddons", "getEditFood", "getEditUnavailableProducts", "getEditUnavailableFood", "getPassengerCount", "passengerCount", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class CheckoutDirectionState {
        private static final CheckoutDirectionState mock = new CheckoutDirectionState(Departure.INSTANCE.getMock(), DepartureTicket.INSTANCE.getMockLowPrice(), RouteDirection.Outbound, RouteDirectionDetails.INSTANCE.getMockAarhusOdden(), null, TrailerProduct.INSTANCE.getMock(), PassengerInfo.INSTANCE.getMock(), CollectionsKt.emptyList(), null, null, null, null, null, null, new PriceTotal(PriceWithCurrency.INSTANCE.mock(Constants.ONE_SECOND)), null, null, null, null, 505616, null);
        private final List<Product> addons;
        private final Departure departure;
        private final DepartureTicket departureTicket;
        private final List<Product> editAddons;
        private final List<Product> editFood;
        private final List<UnavailableProduct> editUnavailableFood;
        private final List<UnavailableProduct> editUnavailableProducts;
        private final List<Product> food;
        private final PassengerInfo passengerInfo;
        private final List<BookingPassenger> passengers;
        private final RouteDirection routeDirection;
        private final RouteDirectionDetails routeDirectionDetails;
        private final CheckoutSeatReservation seatReservation;
        private final List<Product> summaryAddons;
        private final PriceTotal totalPrice;
        private final TrailerProduct trailer;
        private final List<Product> transportProducts;
        private final TransportationCargoInfo transportationCargoInfo;
        private final UnavailableSeatReservation unavailableSeatReservation;

        /* JADX WARN: Multi-variable type inference failed */
        public CheckoutDirectionState(Departure departure, DepartureTicket departureTicket, RouteDirection routeDirection, RouteDirectionDetails routeDirectionDetails, TransportationCargoInfo transportationCargoInfo, TrailerProduct trailerProduct, PassengerInfo passengerInfo, List<? extends Product> transportProducts, List<? extends Product> addons, List<? extends Product> summaryAddons, List<? extends Product> food, CheckoutSeatReservation checkoutSeatReservation, UnavailableSeatReservation unavailableSeatReservation, List<BookingPassenger> passengers, PriceTotal totalPrice, List<? extends Product> editAddons, List<? extends Product> editFood, List<UnavailableProduct> editUnavailableProducts, List<UnavailableProduct> editUnavailableFood) {
            Intrinsics.checkNotNullParameter(departure, "departure");
            Intrinsics.checkNotNullParameter(departureTicket, "departureTicket");
            Intrinsics.checkNotNullParameter(routeDirection, "routeDirection");
            Intrinsics.checkNotNullParameter(routeDirectionDetails, "routeDirectionDetails");
            Intrinsics.checkNotNullParameter(passengerInfo, "passengerInfo");
            Intrinsics.checkNotNullParameter(transportProducts, "transportProducts");
            Intrinsics.checkNotNullParameter(addons, "addons");
            Intrinsics.checkNotNullParameter(summaryAddons, "summaryAddons");
            Intrinsics.checkNotNullParameter(food, "food");
            Intrinsics.checkNotNullParameter(passengers, "passengers");
            Intrinsics.checkNotNullParameter(totalPrice, "totalPrice");
            Intrinsics.checkNotNullParameter(editAddons, "editAddons");
            Intrinsics.checkNotNullParameter(editFood, "editFood");
            Intrinsics.checkNotNullParameter(editUnavailableProducts, "editUnavailableProducts");
            Intrinsics.checkNotNullParameter(editUnavailableFood, "editUnavailableFood");
            this.departure = departure;
            this.departureTicket = departureTicket;
            this.routeDirection = routeDirection;
            this.routeDirectionDetails = routeDirectionDetails;
            this.transportationCargoInfo = transportationCargoInfo;
            this.trailer = trailerProduct;
            this.passengerInfo = passengerInfo;
            this.transportProducts = transportProducts;
            this.addons = addons;
            this.summaryAddons = summaryAddons;
            this.food = food;
            this.seatReservation = checkoutSeatReservation;
            this.unavailableSeatReservation = unavailableSeatReservation;
            this.passengers = passengers;
            this.totalPrice = totalPrice;
            this.editAddons = editAddons;
            this.editFood = editFood;
            this.editUnavailableProducts = editUnavailableProducts;
            this.editUnavailableFood = editUnavailableFood;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List _get_passengerCount_$lambda$0() {
            return null;
        }

        public static /* synthetic */ CheckoutDirectionState copy$default(CheckoutDirectionState checkoutDirectionState, Departure departure, DepartureTicket departureTicket, RouteDirection routeDirection, RouteDirectionDetails routeDirectionDetails, TransportationCargoInfo transportationCargoInfo, TrailerProduct trailerProduct, PassengerInfo passengerInfo, List list, List list2, List list3, List list4, CheckoutSeatReservation checkoutSeatReservation, UnavailableSeatReservation unavailableSeatReservation, List list5, PriceTotal priceTotal, List list6, List list7, List list8, List list9, int i5, Object obj) {
            return checkoutDirectionState.copy((i5 & 1) != 0 ? checkoutDirectionState.departure : departure, (i5 & 2) != 0 ? checkoutDirectionState.departureTicket : departureTicket, (i5 & 4) != 0 ? checkoutDirectionState.routeDirection : routeDirection, (i5 & 8) != 0 ? checkoutDirectionState.routeDirectionDetails : routeDirectionDetails, (i5 & 16) != 0 ? checkoutDirectionState.transportationCargoInfo : transportationCargoInfo, (i5 & 32) != 0 ? checkoutDirectionState.trailer : trailerProduct, (i5 & 64) != 0 ? checkoutDirectionState.passengerInfo : passengerInfo, (i5 & 128) != 0 ? checkoutDirectionState.transportProducts : list, (i5 & 256) != 0 ? checkoutDirectionState.addons : list2, (i5 & 512) != 0 ? checkoutDirectionState.summaryAddons : list3, (i5 & 1024) != 0 ? checkoutDirectionState.food : list4, (i5 & 2048) != 0 ? checkoutDirectionState.seatReservation : checkoutSeatReservation, (i5 & 4096) != 0 ? checkoutDirectionState.unavailableSeatReservation : unavailableSeatReservation, (i5 & 8192) != 0 ? checkoutDirectionState.passengers : list5, (i5 & 16384) != 0 ? checkoutDirectionState.totalPrice : priceTotal, (i5 & 32768) != 0 ? checkoutDirectionState.editAddons : list6, (i5 & 65536) != 0 ? checkoutDirectionState.editFood : list7, (i5 & 131072) != 0 ? checkoutDirectionState.editUnavailableProducts : list8, (i5 & 262144) != 0 ? checkoutDirectionState.editUnavailableFood : list9);
        }

        public final CheckoutDirectionState copy(Departure departure, DepartureTicket departureTicket, RouteDirection routeDirection, RouteDirectionDetails routeDirectionDetails, TransportationCargoInfo transportationCargoInfo, TrailerProduct trailer, PassengerInfo passengerInfo, List<? extends Product> transportProducts, List<? extends Product> addons, List<? extends Product> summaryAddons, List<? extends Product> food, CheckoutSeatReservation seatReservation, UnavailableSeatReservation unavailableSeatReservation, List<BookingPassenger> passengers, PriceTotal totalPrice, List<? extends Product> editAddons, List<? extends Product> editFood, List<UnavailableProduct> editUnavailableProducts, List<UnavailableProduct> editUnavailableFood) {
            Intrinsics.checkNotNullParameter(departure, "departure");
            Intrinsics.checkNotNullParameter(departureTicket, "departureTicket");
            Intrinsics.checkNotNullParameter(routeDirection, "routeDirection");
            Intrinsics.checkNotNullParameter(routeDirectionDetails, "routeDirectionDetails");
            Intrinsics.checkNotNullParameter(passengerInfo, "passengerInfo");
            Intrinsics.checkNotNullParameter(transportProducts, "transportProducts");
            Intrinsics.checkNotNullParameter(addons, "addons");
            Intrinsics.checkNotNullParameter(summaryAddons, "summaryAddons");
            Intrinsics.checkNotNullParameter(food, "food");
            Intrinsics.checkNotNullParameter(passengers, "passengers");
            Intrinsics.checkNotNullParameter(totalPrice, "totalPrice");
            Intrinsics.checkNotNullParameter(editAddons, "editAddons");
            Intrinsics.checkNotNullParameter(editFood, "editFood");
            Intrinsics.checkNotNullParameter(editUnavailableProducts, "editUnavailableProducts");
            Intrinsics.checkNotNullParameter(editUnavailableFood, "editUnavailableFood");
            return new CheckoutDirectionState(departure, departureTicket, routeDirection, routeDirectionDetails, transportationCargoInfo, trailer, passengerInfo, transportProducts, addons, summaryAddons, food, seatReservation, unavailableSeatReservation, passengers, totalPrice, editAddons, editFood, editUnavailableProducts, editUnavailableFood);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CheckoutDirectionState)) {
                return false;
            }
            CheckoutDirectionState checkoutDirectionState = (CheckoutDirectionState) other;
            return Intrinsics.areEqual(this.departure, checkoutDirectionState.departure) && Intrinsics.areEqual(this.departureTicket, checkoutDirectionState.departureTicket) && this.routeDirection == checkoutDirectionState.routeDirection && Intrinsics.areEqual(this.routeDirectionDetails, checkoutDirectionState.routeDirectionDetails) && Intrinsics.areEqual(this.transportationCargoInfo, checkoutDirectionState.transportationCargoInfo) && Intrinsics.areEqual(this.trailer, checkoutDirectionState.trailer) && Intrinsics.areEqual(this.passengerInfo, checkoutDirectionState.passengerInfo) && Intrinsics.areEqual(this.transportProducts, checkoutDirectionState.transportProducts) && Intrinsics.areEqual(this.addons, checkoutDirectionState.addons) && Intrinsics.areEqual(this.summaryAddons, checkoutDirectionState.summaryAddons) && Intrinsics.areEqual(this.food, checkoutDirectionState.food) && Intrinsics.areEqual(this.seatReservation, checkoutDirectionState.seatReservation) && Intrinsics.areEqual(this.unavailableSeatReservation, checkoutDirectionState.unavailableSeatReservation) && Intrinsics.areEqual(this.passengers, checkoutDirectionState.passengers) && Intrinsics.areEqual(this.totalPrice, checkoutDirectionState.totalPrice) && Intrinsics.areEqual(this.editAddons, checkoutDirectionState.editAddons) && Intrinsics.areEqual(this.editFood, checkoutDirectionState.editFood) && Intrinsics.areEqual(this.editUnavailableProducts, checkoutDirectionState.editUnavailableProducts) && Intrinsics.areEqual(this.editUnavailableFood, checkoutDirectionState.editUnavailableFood);
        }

        public final List<Product> getAddons() {
            return this.addons;
        }

        public final Departure getDeparture() {
            return this.departure;
        }

        public final DepartureTicket getDepartureTicket() {
            return this.departureTicket;
        }

        public final List<Product> getEditAddons() {
            return this.editAddons;
        }

        public final List<Product> getEditFood() {
            return this.editFood;
        }

        public final List<UnavailableProduct> getEditUnavailableFood() {
            return this.editUnavailableFood;
        }

        public final List<UnavailableProduct> getEditUnavailableProducts() {
            return this.editUnavailableProducts;
        }

        public final List<Product> getFood() {
            return this.food;
        }

        public final int getPassengerCount() {
            List list = (List) CollectionExtensionsKt.ifNullOrEmpty(this.passengers, new Function0() { // from class: B1.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    List _get_passengerCount_$lambda$0;
                    _get_passengerCount_$lambda$0 = CheckoutManager.CheckoutDirectionState._get_passengerCount_$lambda$0();
                    return _get_passengerCount_$lambda$0;
                }
            });
            return list != null ? list.size() : this.passengerInfo.getTotalPassengerCount();
        }

        public final PassengerInfo getPassengerInfo() {
            return this.passengerInfo;
        }

        public final List<BookingPassenger> getPassengers() {
            return this.passengers;
        }

        public final RouteDirectionDetails getRouteDirectionDetails() {
            return this.routeDirectionDetails;
        }

        public final CheckoutSeatReservation getSeatReservation() {
            return this.seatReservation;
        }

        public final List<Product> getSummaryAddons() {
            return this.summaryAddons;
        }

        public final PriceTotal getTotalPrice() {
            return this.totalPrice;
        }

        public final TrailerProduct getTrailer() {
            return this.trailer;
        }

        public final List<Product> getTransportProducts() {
            return this.transportProducts;
        }

        public final TransportationCargoInfo getTransportationCargoInfo() {
            return this.transportationCargoInfo;
        }

        public final UnavailableSeatReservation getUnavailableSeatReservation() {
            return this.unavailableSeatReservation;
        }

        public int hashCode() {
            int hashCode = ((((((this.departure.hashCode() * 31) + this.departureTicket.hashCode()) * 31) + this.routeDirection.hashCode()) * 31) + this.routeDirectionDetails.hashCode()) * 31;
            TransportationCargoInfo transportationCargoInfo = this.transportationCargoInfo;
            int hashCode2 = (hashCode + (transportationCargoInfo == null ? 0 : transportationCargoInfo.hashCode())) * 31;
            TrailerProduct trailerProduct = this.trailer;
            int hashCode3 = (((((((((((hashCode2 + (trailerProduct == null ? 0 : trailerProduct.hashCode())) * 31) + this.passengerInfo.hashCode()) * 31) + this.transportProducts.hashCode()) * 31) + this.addons.hashCode()) * 31) + this.summaryAddons.hashCode()) * 31) + this.food.hashCode()) * 31;
            CheckoutSeatReservation checkoutSeatReservation = this.seatReservation;
            int hashCode4 = (hashCode3 + (checkoutSeatReservation == null ? 0 : checkoutSeatReservation.hashCode())) * 31;
            UnavailableSeatReservation unavailableSeatReservation = this.unavailableSeatReservation;
            return ((((((((((((hashCode4 + (unavailableSeatReservation != null ? unavailableSeatReservation.hashCode() : 0)) * 31) + this.passengers.hashCode()) * 31) + this.totalPrice.hashCode()) * 31) + this.editAddons.hashCode()) * 31) + this.editFood.hashCode()) * 31) + this.editUnavailableProducts.hashCode()) * 31) + this.editUnavailableFood.hashCode();
        }

        public String toString() {
            return "CheckoutDirectionState(departure=" + this.departure + ", departureTicket=" + this.departureTicket + ", routeDirection=" + this.routeDirection + ", routeDirectionDetails=" + this.routeDirectionDetails + ", transportationCargoInfo=" + this.transportationCargoInfo + ", trailer=" + this.trailer + ", passengerInfo=" + this.passengerInfo + ", transportProducts=" + this.transportProducts + ", addons=" + this.addons + ", summaryAddons=" + this.summaryAddons + ", food=" + this.food + ", seatReservation=" + this.seatReservation + ", unavailableSeatReservation=" + this.unavailableSeatReservation + ", passengers=" + this.passengers + ", totalPrice=" + this.totalPrice + ", editAddons=" + this.editAddons + ", editFood=" + this.editFood + ", editUnavailableProducts=" + this.editUnavailableProducts + ", editUnavailableFood=" + this.editUnavailableFood + ")";
        }

        public final CheckoutDirectionState updatedForPassengerState(PassengerSelectionHelper.PassengerState passengerState) {
            Intrinsics.checkNotNullParameter(passengerState, "passengerState");
            List<BookingPassenger> selectedPassengers = (!passengerState.getCurrentUserSelected() || passengerState.getCurrentUser() == null) ? passengerState.getSelectedPassengers() : CollectionsKt.plus((Collection<? extends BookingPassenger>) passengerState.getSelectedPassengers(), passengerState.getCurrentUser());
            CheckoutSeatReservation checkoutSeatReservation = this.seatReservation;
            UnavailableSeatReservation invalid = checkoutSeatReservation != null ? checkoutSeatReservation.getSeats().size() != selectedPassengers.size() ? new UnavailableSeatReservation.Invalid(checkoutSeatReservation) : this.unavailableSeatReservation : null;
            return copy$default(this, null, null, null, null, null, null, null, null, null, null, null, null, invalid == null ? this.unavailableSeatReservation : invalid, selectedPassengers, null, null, null, null, null, 511999, null);
        }

        public /* synthetic */ CheckoutDirectionState(Departure departure, DepartureTicket departureTicket, RouteDirection routeDirection, RouteDirectionDetails routeDirectionDetails, TransportationCargoInfo transportationCargoInfo, TrailerProduct trailerProduct, PassengerInfo passengerInfo, List list, List list2, List list3, List list4, CheckoutSeatReservation checkoutSeatReservation, UnavailableSeatReservation unavailableSeatReservation, List list5, PriceTotal priceTotal, List list6, List list7, List list8, List list9, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(departure, departureTicket, routeDirection, routeDirectionDetails, (i5 & 16) != 0 ? null : transportationCargoInfo, trailerProduct, passengerInfo, list, (i5 & 256) != 0 ? CollectionsKt.emptyList() : list2, (i5 & 512) != 0 ? CollectionsKt.emptyList() : list3, (i5 & 1024) != 0 ? CollectionsKt.emptyList() : list4, checkoutSeatReservation, (i5 & 4096) != 0 ? null : unavailableSeatReservation, (i5 & 8192) != 0 ? CollectionsKt.emptyList() : list5, priceTotal, (32768 & i5) != 0 ? CollectionsKt.emptyList() : list6, (65536 & i5) != 0 ? CollectionsKt.emptyList() : list7, (131072 & i5) != 0 ? CollectionsKt.emptyList() : list8, (i5 & 262144) != 0 ? CollectionsKt.emptyList() : list9);
        }
    }

    @Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b6\b\u0086\b\u0018\u0000 `2\u00020\u0001:\u0001`B×\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\n\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001a\u001a\u00020\n\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010#\u001a\u00020\n\u0012\b\u0010$\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b%\u0010&Jò\u0001\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\b\b\u0002\u0010#\u001a\u00020\n2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b)\u0010*J\u0010\u0010,\u001a\u00020+HÖ\u0001¢\u0006\u0004\b,\u0010-J\u001a\u0010/\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b/\u00100R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00101\u001a\u0004\b2\u00103R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00104\u001a\u0004\b5\u00106R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00107\u001a\u0004\b8\u00109R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010:\u001a\u0004\b;\u0010*R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010<\u001a\u0004\b=\u0010>R\u0017\u0010\f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\f\u0010<\u001a\u0004\b?\u0010>R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010@\u001a\u0004\bA\u0010BR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010C\u001a\u0004\bD\u0010ER\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010F\u001a\u0004\bG\u0010HR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0013\u0010:\u001a\u0004\bI\u0010*R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0014\u0010:\u001a\u0004\bJ\u0010*R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010K\u001a\u0004\bL\u0010MR\u0017\u0010\u0017\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0017\u0010<\u001a\u0004\bN\u0010>R\u0017\u0010\u0019\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010O\u001a\u0004\bP\u0010QR\u0017\u0010\u001a\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u001a\u0010<\u001a\u0004\b\u001a\u0010>R\u0017\u0010\u001c\u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010R\u001a\u0004\bS\u0010TR\u0017\u0010\u001e\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010U\u001a\u0004\bV\u0010WR\u0019\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006¢\u0006\f\n\u0004\b \u0010X\u001a\u0004\bY\u0010ZR\u0019\u0010\"\u001a\u0004\u0018\u00010!8\u0006¢\u0006\f\n\u0004\b\"\u0010[\u001a\u0004\b\\\u0010]R\u0017\u0010#\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b#\u0010<\u001a\u0004\b^\u0010>R\u0019\u0010$\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b$\u0010:\u001a\u0004\b_\u0010*¨\u0006a"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingType;", "bookingType", "Ldk/molslinjen/domain/model/config/Transportation;", "transportation", "Ldk/molslinjen/domain/model/config/Site;", "site", BuildConfig.FLAVOR, "routeId", BuildConfig.FLAVOR, "signedUpForNewsletter", "acceptedMarketing", "Ldk/molslinjen/domain/model/payment/PaymentType;", "selectedPaymentType", "Ldk/molslinjen/domain/model/account/CreditCard;", "selectedCreditCard", "Ldk/molslinjen/domain/model/booking/Booking;", "editingBooking", "reservationNumber", "returnReservationNumber", "Ldk/molslinjen/domain/model/account/UserVehicle;", "selectedVehicle", "makeEarlyCheckIn", "Ldk/molslinjen/domain/managers/checkout/PriceDetails;", "priceDetails", "isEarlyCheckInPossible", "Ldk/molslinjen/domain/model/booking/CheckoutContactInfo;", "personalInfo", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "currency", "Ldk/molslinjen/domain/model/booking/CommuterBookingData;", "commuterBookingData", "Ldk/molslinjen/domain/model/booking/MultiRideBookingData;", "multiRideBookingData", "hasCancelledSaleOnBoardOrdersOnEditedOrder", "lineLogoUrl", "<init>", "(Ldk/molslinjen/domain/model/booking/BookingType;Ldk/molslinjen/domain/model/config/Transportation;Ldk/molslinjen/domain/model/config/Site;Ljava/lang/String;ZZLdk/molslinjen/domain/model/payment/PaymentType;Ldk/molslinjen/domain/model/account/CreditCard;Ldk/molslinjen/domain/model/booking/Booking;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/account/UserVehicle;ZLdk/molslinjen/domain/managers/checkout/PriceDetails;ZLdk/molslinjen/domain/model/booking/CheckoutContactInfo;Ldk/molslinjen/domain/model/shared/CurrencyType;Ldk/molslinjen/domain/model/booking/CommuterBookingData;Ldk/molslinjen/domain/model/booking/MultiRideBookingData;ZLjava/lang/String;)V", "copy", "(Ldk/molslinjen/domain/model/booking/BookingType;Ldk/molslinjen/domain/model/config/Transportation;Ldk/molslinjen/domain/model/config/Site;Ljava/lang/String;ZZLdk/molslinjen/domain/model/payment/PaymentType;Ldk/molslinjen/domain/model/account/CreditCard;Ldk/molslinjen/domain/model/booking/Booking;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/account/UserVehicle;ZLdk/molslinjen/domain/managers/checkout/PriceDetails;ZLdk/molslinjen/domain/model/booking/CheckoutContactInfo;Ldk/molslinjen/domain/model/shared/CurrencyType;Ldk/molslinjen/domain/model/booking/CommuterBookingData;Ldk/molslinjen/domain/model/booking/MultiRideBookingData;ZLjava/lang/String;)Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/booking/BookingType;", "getBookingType", "()Ldk/molslinjen/domain/model/booking/BookingType;", "Ldk/molslinjen/domain/model/config/Transportation;", "getTransportation", "()Ldk/molslinjen/domain/model/config/Transportation;", "Ldk/molslinjen/domain/model/config/Site;", "getSite", "()Ldk/molslinjen/domain/model/config/Site;", "Ljava/lang/String;", "getRouteId", "Z", "getSignedUpForNewsletter", "()Z", "getAcceptedMarketing", "Ldk/molslinjen/domain/model/payment/PaymentType;", "getSelectedPaymentType", "()Ldk/molslinjen/domain/model/payment/PaymentType;", "Ldk/molslinjen/domain/model/account/CreditCard;", "getSelectedCreditCard", "()Ldk/molslinjen/domain/model/account/CreditCard;", "Ldk/molslinjen/domain/model/booking/Booking;", "getEditingBooking", "()Ldk/molslinjen/domain/model/booking/Booking;", "getReservationNumber", "getReturnReservationNumber", "Ldk/molslinjen/domain/model/account/UserVehicle;", "getSelectedVehicle", "()Ldk/molslinjen/domain/model/account/UserVehicle;", "getMakeEarlyCheckIn", "Ldk/molslinjen/domain/managers/checkout/PriceDetails;", "getPriceDetails", "()Ldk/molslinjen/domain/managers/checkout/PriceDetails;", "Ldk/molslinjen/domain/model/booking/CheckoutContactInfo;", "getPersonalInfo", "()Ldk/molslinjen/domain/model/booking/CheckoutContactInfo;", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "getCurrency", "()Ldk/molslinjen/domain/model/shared/CurrencyType;", "Ldk/molslinjen/domain/model/booking/CommuterBookingData;", "getCommuterBookingData", "()Ldk/molslinjen/domain/model/booking/CommuterBookingData;", "Ldk/molslinjen/domain/model/booking/MultiRideBookingData;", "getMultiRideBookingData", "()Ldk/molslinjen/domain/model/booking/MultiRideBookingData;", "getHasCancelledSaleOnBoardOrdersOnEditedOrder", "getLineLogoUrl", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class CheckoutState {
        private static final CheckoutState mock = new CheckoutState(BookingType.Single, Transportation.INSTANCE.getMockCar(), Site.Mols, "14", false, false, null, null, null, null, null, null, false, PriceDetails.INSTANCE.getMock(), true, new CheckoutContactInfo((UserContactDetails) null), CurrencyType.DKK, null, null, false, null, 925680, null);
        private final boolean acceptedMarketing;
        private final BookingType bookingType;
        private final CommuterBookingData commuterBookingData;
        private final CurrencyType currency;
        private final Booking editingBooking;
        private final boolean hasCancelledSaleOnBoardOrdersOnEditedOrder;
        private final boolean isEarlyCheckInPossible;
        private final String lineLogoUrl;
        private final boolean makeEarlyCheckIn;
        private final MultiRideBookingData multiRideBookingData;
        private final CheckoutContactInfo personalInfo;
        private final PriceDetails priceDetails;
        private final String reservationNumber;
        private final String returnReservationNumber;
        private final String routeId;
        private final CreditCard selectedCreditCard;
        private final PaymentType selectedPaymentType;
        private final UserVehicle selectedVehicle;
        private final boolean signedUpForNewsletter;
        private final Site site;
        private final Transportation transportation;

        public CheckoutState(BookingType bookingType, Transportation transportation, Site site, String routeId, boolean z5, boolean z6, PaymentType selectedPaymentType, CreditCard creditCard, Booking booking, String str, String str2, UserVehicle userVehicle, boolean z7, PriceDetails priceDetails, boolean z8, CheckoutContactInfo personalInfo, CurrencyType currency, CommuterBookingData commuterBookingData, MultiRideBookingData multiRideBookingData, boolean z9, String str3) {
            Intrinsics.checkNotNullParameter(bookingType, "bookingType");
            Intrinsics.checkNotNullParameter(transportation, "transportation");
            Intrinsics.checkNotNullParameter(site, "site");
            Intrinsics.checkNotNullParameter(routeId, "routeId");
            Intrinsics.checkNotNullParameter(selectedPaymentType, "selectedPaymentType");
            Intrinsics.checkNotNullParameter(priceDetails, "priceDetails");
            Intrinsics.checkNotNullParameter(personalInfo, "personalInfo");
            Intrinsics.checkNotNullParameter(currency, "currency");
            this.bookingType = bookingType;
            this.transportation = transportation;
            this.site = site;
            this.routeId = routeId;
            this.signedUpForNewsletter = z5;
            this.acceptedMarketing = z6;
            this.selectedPaymentType = selectedPaymentType;
            this.selectedCreditCard = creditCard;
            this.editingBooking = booking;
            this.reservationNumber = str;
            this.returnReservationNumber = str2;
            this.selectedVehicle = userVehicle;
            this.makeEarlyCheckIn = z7;
            this.priceDetails = priceDetails;
            this.isEarlyCheckInPossible = z8;
            this.personalInfo = personalInfo;
            this.currency = currency;
            this.commuterBookingData = commuterBookingData;
            this.multiRideBookingData = multiRideBookingData;
            this.hasCancelledSaleOnBoardOrdersOnEditedOrder = z9;
            this.lineLogoUrl = str3;
        }

        public static /* synthetic */ CheckoutState copy$default(CheckoutState checkoutState, BookingType bookingType, Transportation transportation, Site site, String str, boolean z5, boolean z6, PaymentType paymentType, CreditCard creditCard, Booking booking, String str2, String str3, UserVehicle userVehicle, boolean z7, PriceDetails priceDetails, boolean z8, CheckoutContactInfo checkoutContactInfo, CurrencyType currencyType, CommuterBookingData commuterBookingData, MultiRideBookingData multiRideBookingData, boolean z9, String str4, int i5, Object obj) {
            return checkoutState.copy((i5 & 1) != 0 ? checkoutState.bookingType : bookingType, (i5 & 2) != 0 ? checkoutState.transportation : transportation, (i5 & 4) != 0 ? checkoutState.site : site, (i5 & 8) != 0 ? checkoutState.routeId : str, (i5 & 16) != 0 ? checkoutState.signedUpForNewsletter : z5, (i5 & 32) != 0 ? checkoutState.acceptedMarketing : z6, (i5 & 64) != 0 ? checkoutState.selectedPaymentType : paymentType, (i5 & 128) != 0 ? checkoutState.selectedCreditCard : creditCard, (i5 & 256) != 0 ? checkoutState.editingBooking : booking, (i5 & 512) != 0 ? checkoutState.reservationNumber : str2, (i5 & 1024) != 0 ? checkoutState.returnReservationNumber : str3, (i5 & 2048) != 0 ? checkoutState.selectedVehicle : userVehicle, (i5 & 4096) != 0 ? checkoutState.makeEarlyCheckIn : z7, (i5 & 8192) != 0 ? checkoutState.priceDetails : priceDetails, (i5 & 16384) != 0 ? checkoutState.isEarlyCheckInPossible : z8, (i5 & 32768) != 0 ? checkoutState.personalInfo : checkoutContactInfo, (i5 & 65536) != 0 ? checkoutState.currency : currencyType, (i5 & 131072) != 0 ? checkoutState.commuterBookingData : commuterBookingData, (i5 & 262144) != 0 ? checkoutState.multiRideBookingData : multiRideBookingData, (i5 & 524288) != 0 ? checkoutState.hasCancelledSaleOnBoardOrdersOnEditedOrder : z9, (i5 & 1048576) != 0 ? checkoutState.lineLogoUrl : str4);
        }

        public final CheckoutState copy(BookingType bookingType, Transportation transportation, Site site, String routeId, boolean signedUpForNewsletter, boolean acceptedMarketing, PaymentType selectedPaymentType, CreditCard selectedCreditCard, Booking editingBooking, String reservationNumber, String returnReservationNumber, UserVehicle selectedVehicle, boolean makeEarlyCheckIn, PriceDetails priceDetails, boolean isEarlyCheckInPossible, CheckoutContactInfo personalInfo, CurrencyType currency, CommuterBookingData commuterBookingData, MultiRideBookingData multiRideBookingData, boolean hasCancelledSaleOnBoardOrdersOnEditedOrder, String lineLogoUrl) {
            Intrinsics.checkNotNullParameter(bookingType, "bookingType");
            Intrinsics.checkNotNullParameter(transportation, "transportation");
            Intrinsics.checkNotNullParameter(site, "site");
            Intrinsics.checkNotNullParameter(routeId, "routeId");
            Intrinsics.checkNotNullParameter(selectedPaymentType, "selectedPaymentType");
            Intrinsics.checkNotNullParameter(priceDetails, "priceDetails");
            Intrinsics.checkNotNullParameter(personalInfo, "personalInfo");
            Intrinsics.checkNotNullParameter(currency, "currency");
            return new CheckoutState(bookingType, transportation, site, routeId, signedUpForNewsletter, acceptedMarketing, selectedPaymentType, selectedCreditCard, editingBooking, reservationNumber, returnReservationNumber, selectedVehicle, makeEarlyCheckIn, priceDetails, isEarlyCheckInPossible, personalInfo, currency, commuterBookingData, multiRideBookingData, hasCancelledSaleOnBoardOrdersOnEditedOrder, lineLogoUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CheckoutState)) {
                return false;
            }
            CheckoutState checkoutState = (CheckoutState) other;
            return this.bookingType == checkoutState.bookingType && Intrinsics.areEqual(this.transportation, checkoutState.transportation) && this.site == checkoutState.site && Intrinsics.areEqual(this.routeId, checkoutState.routeId) && this.signedUpForNewsletter == checkoutState.signedUpForNewsletter && this.acceptedMarketing == checkoutState.acceptedMarketing && this.selectedPaymentType == checkoutState.selectedPaymentType && Intrinsics.areEqual(this.selectedCreditCard, checkoutState.selectedCreditCard) && Intrinsics.areEqual(this.editingBooking, checkoutState.editingBooking) && Intrinsics.areEqual(this.reservationNumber, checkoutState.reservationNumber) && Intrinsics.areEqual(this.returnReservationNumber, checkoutState.returnReservationNumber) && Intrinsics.areEqual(this.selectedVehicle, checkoutState.selectedVehicle) && this.makeEarlyCheckIn == checkoutState.makeEarlyCheckIn && Intrinsics.areEqual(this.priceDetails, checkoutState.priceDetails) && this.isEarlyCheckInPossible == checkoutState.isEarlyCheckInPossible && Intrinsics.areEqual(this.personalInfo, checkoutState.personalInfo) && this.currency == checkoutState.currency && Intrinsics.areEqual(this.commuterBookingData, checkoutState.commuterBookingData) && Intrinsics.areEqual(this.multiRideBookingData, checkoutState.multiRideBookingData) && this.hasCancelledSaleOnBoardOrdersOnEditedOrder == checkoutState.hasCancelledSaleOnBoardOrdersOnEditedOrder && Intrinsics.areEqual(this.lineLogoUrl, checkoutState.lineLogoUrl);
        }

        public final boolean getAcceptedMarketing() {
            return this.acceptedMarketing;
        }

        public final BookingType getBookingType() {
            return this.bookingType;
        }

        public final CommuterBookingData getCommuterBookingData() {
            return this.commuterBookingData;
        }

        public final CurrencyType getCurrency() {
            return this.currency;
        }

        public final Booking getEditingBooking() {
            return this.editingBooking;
        }

        public final boolean getHasCancelledSaleOnBoardOrdersOnEditedOrder() {
            return this.hasCancelledSaleOnBoardOrdersOnEditedOrder;
        }

        public final String getLineLogoUrl() {
            return this.lineLogoUrl;
        }

        public final boolean getMakeEarlyCheckIn() {
            return this.makeEarlyCheckIn;
        }

        public final MultiRideBookingData getMultiRideBookingData() {
            return this.multiRideBookingData;
        }

        public final CheckoutContactInfo getPersonalInfo() {
            return this.personalInfo;
        }

        public final PriceDetails getPriceDetails() {
            return this.priceDetails;
        }

        public final String getReservationNumber() {
            return this.reservationNumber;
        }

        public final String getReturnReservationNumber() {
            return this.returnReservationNumber;
        }

        public final String getRouteId() {
            return this.routeId;
        }

        public final CreditCard getSelectedCreditCard() {
            return this.selectedCreditCard;
        }

        public final PaymentType getSelectedPaymentType() {
            return this.selectedPaymentType;
        }

        public final UserVehicle getSelectedVehicle() {
            return this.selectedVehicle;
        }

        public final boolean getSignedUpForNewsletter() {
            return this.signedUpForNewsletter;
        }

        public final Site getSite() {
            return this.site;
        }

        public final Transportation getTransportation() {
            return this.transportation;
        }

        public int hashCode() {
            int hashCode = ((((((((((((this.bookingType.hashCode() * 31) + this.transportation.hashCode()) * 31) + this.site.hashCode()) * 31) + this.routeId.hashCode()) * 31) + Boolean.hashCode(this.signedUpForNewsletter)) * 31) + Boolean.hashCode(this.acceptedMarketing)) * 31) + this.selectedPaymentType.hashCode()) * 31;
            CreditCard creditCard = this.selectedCreditCard;
            int hashCode2 = (hashCode + (creditCard == null ? 0 : creditCard.hashCode())) * 31;
            Booking booking = this.editingBooking;
            int hashCode3 = (hashCode2 + (booking == null ? 0 : booking.hashCode())) * 31;
            String str = this.reservationNumber;
            int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.returnReservationNumber;
            int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
            UserVehicle userVehicle = this.selectedVehicle;
            int hashCode6 = (((((((((((hashCode5 + (userVehicle == null ? 0 : userVehicle.hashCode())) * 31) + Boolean.hashCode(this.makeEarlyCheckIn)) * 31) + this.priceDetails.hashCode()) * 31) + Boolean.hashCode(this.isEarlyCheckInPossible)) * 31) + this.personalInfo.hashCode()) * 31) + this.currency.hashCode()) * 31;
            CommuterBookingData commuterBookingData = this.commuterBookingData;
            int hashCode7 = (hashCode6 + (commuterBookingData == null ? 0 : commuterBookingData.hashCode())) * 31;
            MultiRideBookingData multiRideBookingData = this.multiRideBookingData;
            int hashCode8 = (((hashCode7 + (multiRideBookingData == null ? 0 : multiRideBookingData.hashCode())) * 31) + Boolean.hashCode(this.hasCancelledSaleOnBoardOrdersOnEditedOrder)) * 31;
            String str3 = this.lineLogoUrl;
            return hashCode8 + (str3 != null ? str3.hashCode() : 0);
        }

        /* renamed from: isEarlyCheckInPossible, reason: from getter */
        public final boolean getIsEarlyCheckInPossible() {
            return this.isEarlyCheckInPossible;
        }

        public String toString() {
            return "CheckoutState(bookingType=" + this.bookingType + ", transportation=" + this.transportation + ", site=" + this.site + ", routeId=" + this.routeId + ", signedUpForNewsletter=" + this.signedUpForNewsletter + ", acceptedMarketing=" + this.acceptedMarketing + ", selectedPaymentType=" + this.selectedPaymentType + ", selectedCreditCard=" + this.selectedCreditCard + ", editingBooking=" + this.editingBooking + ", reservationNumber=" + this.reservationNumber + ", returnReservationNumber=" + this.returnReservationNumber + ", selectedVehicle=" + this.selectedVehicle + ", makeEarlyCheckIn=" + this.makeEarlyCheckIn + ", priceDetails=" + this.priceDetails + ", isEarlyCheckInPossible=" + this.isEarlyCheckInPossible + ", personalInfo=" + this.personalInfo + ", currency=" + this.currency + ", commuterBookingData=" + this.commuterBookingData + ", multiRideBookingData=" + this.multiRideBookingData + ", hasCancelledSaleOnBoardOrdersOnEditedOrder=" + this.hasCancelledSaleOnBoardOrdersOnEditedOrder + ", lineLogoUrl=" + this.lineLogoUrl + ")";
        }

        public /* synthetic */ CheckoutState(BookingType bookingType, Transportation transportation, Site site, String str, boolean z5, boolean z6, PaymentType paymentType, CreditCard creditCard, Booking booking, String str2, String str3, UserVehicle userVehicle, boolean z7, PriceDetails priceDetails, boolean z8, CheckoutContactInfo checkoutContactInfo, CurrencyType currencyType, CommuterBookingData commuterBookingData, MultiRideBookingData multiRideBookingData, boolean z9, String str4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(bookingType, transportation, site, str, (i5 & 16) != 0 ? false : z5, (i5 & 32) != 0 ? true : z6, (i5 & 64) != 0 ? PaymentType.Card : paymentType, (i5 & 128) != 0 ? null : creditCard, (i5 & 256) != 0 ? null : booking, (i5 & 512) != 0 ? null : str2, (i5 & 1024) != 0 ? null : str3, (i5 & 2048) != 0 ? null : userVehicle, (i5 & 4096) != 0 ? false : z7, priceDetails, z8, checkoutContactInfo, currencyType, (131072 & i5) != 0 ? null : commuterBookingData, (262144 & i5) != 0 ? null : multiRideBookingData, (i5 & 524288) != 0 ? false : z9, str4);
        }
    }
}
