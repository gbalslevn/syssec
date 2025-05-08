package dk.molslinjen.domain.managers.route;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.booking.IBookingService;
import dk.molslinjen.api.services.booking.response.TransportProductsResponseDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.shared.response.CurrencyTypeDTO;
import dk.molslinjen.core.Feature;
import dk.molslinjen.core.extensions.CollectionExtensionsKt;
import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.domain.analytics.AnalyticsEvent;
import dk.molslinjen.domain.analytics.AnalyticsStateTrackingHelper;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.extensions.ApiResultExtensionsKt;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.extensions.domain.HarborExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.checkout.ICurrencyManager;
import dk.molslinjen.domain.managers.checkout.PriceTotal;
import dk.molslinjen.domain.managers.configuration.IConfigurationManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.managers.route.RouteManager;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.BookingTicket;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.CommuterBookingData;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.Goods;
import dk.molslinjen.domain.model.booking.LineItem;
import dk.molslinjen.domain.model.booking.MultiRideBookingData;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.booking.ProductType;
import dk.molslinjen.domain.model.booking.RouteDirection;
import dk.molslinjen.domain.model.booking.TransportProducts;
import dk.molslinjen.domain.model.booking.TransportationCargoInfo;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.TrailerProduct;
import dk.molslinjen.domain.model.config.LocalizedSiteConfiguration;
import dk.molslinjen.domain.model.config.Route;
import dk.molslinjen.domain.model.config.RouteDirectionGroup;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.domain.model.config.TransportationCategory;
import dk.molslinjen.domain.model.config.TransportationSelectionModel;
import dk.molslinjen.domain.model.settings.ISettings;
import dk.molslinjen.domain.model.settings.SettingsProperty;
import dk.molslinjen.domain.model.shared.CurrencyType;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000\u0082\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010&\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0097\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00122\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0011H\u0016J\u0010\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0011H\u0002J\b\u0010,\u001a\u00020&H\u0016J\u000e\u0010-\u001a\u00020&H\u0082@¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00020&2\u0006\u00100\u001a\u000201H\u0096@¢\u0006\u0002\u00102J\u001e\u00103\u001a\u00020&2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0096@¢\u0006\u0002\u00108J\u001e\u00109\u001a\u00020&2\u0006\u0010:\u001a\u00020;2\u0006\u00106\u001a\u000207H\u0096@¢\u0006\u0002\u0010<J\u000e\u0010=\u001a\u00020&H\u0082@¢\u0006\u0002\u0010.Jr\u0010>\u001a\u00020&2\u0006\u00106\u001a\u0002072\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010@2\u0006\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020G2\b\b\u0002\u0010H\u001a\u00020)2\n\b\u0002\u0010I\u001a\u0004\u0018\u0001012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;2\n\b\u0002\u00104\u001a\u0004\u0018\u000105H\u0082@¢\u0006\u0002\u0010JJ\u001a\u0010K\u001a\u00020&2\b\u0010L\u001a\u0004\u0018\u00010)2\u0006\u0010M\u001a\u00020NH\u0002J\b\u0010O\u001a\u00020&H\u0002J\b\u0010P\u001a\u00020&H\u0002J\b\u0010Q\u001a\u00020&H\u0002J\u000e\u0010R\u001a\u00020&H\u0082@¢\u0006\u0002\u0010.J\b\u0010S\u001a\u00020&H\u0002J\u0016\u0010T\u001a\u00020&2\u0006\u00106\u001a\u000207H\u0082@¢\u0006\u0002\u0010UJ\b\u0010V\u001a\u00020&H\u0002J\u0016\u0010W\u001a\u00020&2\u0006\u0010B\u001a\u00020CH\u0082@¢\u0006\u0002\u0010XJ\b\u0010Y\u001a\u00020&H\u0002J\u0012\u0010Z\u001a\u00020&2\b\u0010?\u001a\u0004\u0018\u00010@H\u0002J\b\u0010[\u001a\u00020&H\u0002J,\u0010\\\u001a\u00020&2\b\u0010A\u001a\u0004\u0018\u00010@2\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010]\u001a\u0004\u0018\u00010EH\u0082@¢\u0006\u0002\u0010^J\u0014\u0010_\u001a\u0004\u0018\u00010@2\b\u0010`\u001a\u0004\u0018\u00010@H\u0002J\b\u0010a\u001a\u00020&H\u0002J\b\u0010b\u001a\u00020cH\u0016J\u001c\u0010d\u001a\b\u0012\u0004\u0012\u00020&0e2\u0006\u0010A\u001a\u00020@H\u0096@¢\u0006\u0002\u0010fJ,\u0010g\u001a\u00020&2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020j0i2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020j0i2\u0006\u0010l\u001a\u00020NH\u0016J\u0010\u0010m\u001a\u00020&2\u0006\u0010n\u001a\u00020)H\u0016J$\u0010d\u001a\b\u0012\u0004\u0012\u00020&0e2\u000e\u0010o\u001a\n\u0012\u0004\u0012\u00020p\u0018\u00010iH\u0096@¢\u0006\u0002\u0010qJ\u0016\u0010r\u001a\u00020&2\u0006\u0010s\u001a\u00020tH\u0096@¢\u0006\u0002\u0010uJ*\u0010r\u001a\u00020&2\u0006\u0010A\u001a\u00020@2\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010]\u001a\u0004\u0018\u00010EH\u0096@¢\u0006\u0002\u0010^J$\u0010v\u001a\u00020&2\b\u0010w\u001a\u0004\u0018\u00010x2\b\u0010y\u001a\u0004\u0018\u00010x2\u0006\u0010l\u001a\u00020NH\u0016J\u0010\u0010z\u001a\u00020&2\u0006\u0010{\u001a\u00020NH\u0016J\u001a\u0010|\u001a\u00020&2\u0006\u0010}\u001a\u00020\u00162\b\u0010L\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010~\u001a\u00020&2\u0006\u0010{\u001a\u00020NH\u0016J\u000e\u0010\u007f\u001a\u00020&H\u0096@¢\u0006\u0002\u0010.J*\u0010\u0080\u0001\u001a\u00020&2\u0007\u0010\u0081\u0001\u001a\u00020G2\u0007\u0010\u0082\u0001\u001a\u00020G2\u0006\u0010l\u001a\u00020NH\u0096@¢\u0006\u0003\u0010\u0083\u0001J\"\u0010\u0084\u0001\u001a\u00020&2\u0007\u0010\u0081\u0001\u001a\u00020G2\u0007\u0010\u0082\u0001\u001a\u00020GH\u0082@¢\u0006\u0003\u0010\u0085\u0001J\u001a\u0010\u0086\u0001\u001a\u00020&2\u0006\u0010{\u001a\u00020N2\u0007\u0010\u0087\u0001\u001a\u00020NH\u0002J\u001b\u0010\u0088\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020x0i0eH\u0096@¢\u0006\u0002\u0010.J\u0019\u0010\u0089\u0001\u001a\u00020&2\u0007\u0010\u008a\u0001\u001a\u00020pH\u0082@¢\u0006\u0003\u0010\u008b\u0001J\u001d\u0010\u008c\u0001\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020@\u0012\u0005\u0012\u00030\u008e\u00010\u008d\u00010iH\u0016J3\u0010\u008f\u0001\u001a\u00020&2\u0006\u00106\u001a\u0002072\b\u0010\u0090\u0001\u001a\u00030\u0091\u00012\u0006\u0010B\u001a\u00020C2\u0007\u0010\u0092\u0001\u001a\u00020@H\u0096@¢\u0006\u0003\u0010\u0093\u0001J#\u0010\u0094\u0001\u001a\u00030\u0095\u00012\u0006\u00106\u001a\u0002072\b\u0010:\u001a\u0004\u0018\u00010;H\u0082@¢\u0006\u0003\u0010\u0096\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u001c\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u001c\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u001c\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u001c\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0098\u0001"}, d2 = {"Ldk/molslinjen/domain/managers/route/RouteManager;", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "bookingService", "Ldk/molslinjen/api/services/booking/IBookingService;", "configurationManager", "Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;", "settings", "Ldk/molslinjen/domain/model/settings/ISettings;", "currencyManager", "Ldk/molslinjen/domain/managers/checkout/ICurrencyManager;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "<init>", "(Ldk/molslinjen/api/services/booking/IBookingService;Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;Ldk/molslinjen/domain/model/settings/ISettings;Ldk/molslinjen/domain/managers/checkout/ICurrencyManager;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "activeDepartureDirectionState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "getActiveDepartureDirectionState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "bookingTypeState", "Ldk/molslinjen/domain/model/booking/BookingType;", "getBookingTypeState", "sharedSelectedState", "Ldk/molslinjen/domain/managers/route/RouteSharedSelectedState;", "getSharedSelectedState", "routeState", "Ldk/molslinjen/domain/managers/route/RouteState;", "getRouteState", "outboundSelectedState", "Ldk/molslinjen/domain/managers/route/RouteSelectedState;", "getOutboundSelectedState", "returnSelectedState", "getReturnSelectedState", "internalEditState", "Ldk/molslinjen/domain/managers/route/RouteManager$InternalEditState;", "updateDepartureDirection", BuildConfig.FLAVOR, "departureDirection", "outboundDepartureDate", "Lorg/threeten/bp/LocalDate;", "getActiveSelectedState", "getInactiveSelectedState", "reload", "setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupForEdit", "booking", "Ldk/molslinjen/domain/model/booking/Booking;", "(Ldk/molslinjen/domain/model/booking/Booking;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupForMultiRide", "multiRideBookingData", "Ldk/molslinjen/domain/model/booking/MultiRideBookingData;", "site", "Ldk/molslinjen/domain/model/config/Site;", "(Ldk/molslinjen/domain/model/booking/MultiRideBookingData;Ldk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupForCommuter", "commuterBookingData", "Ldk/molslinjen/domain/model/booking/CommuterBookingData;", "(Ldk/molslinjen/domain/model/booking/CommuterBookingData;Ldk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "setup", "routeId", BuildConfig.FLAVOR, "transportationId", "routeDirection", "Ldk/molslinjen/domain/model/booking/RouteDirection;", "outboundCargoInfo", "Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;", "passengerInfo", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "selectedStartDate", "editBooking", "(Ldk/molslinjen/domain/model/config/Site;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/booking/RouteDirection;Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;Ldk/molslinjen/domain/model/booking/PassengerInfo;Lorg/threeten/bp/LocalDate;Ldk/molslinjen/domain/model/booking/Booking;Ldk/molslinjen/domain/model/booking/CommuterBookingData;Ldk/molslinjen/domain/model/booking/MultiRideBookingData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupReturnState", "outboundSelectedDepartureDate", "copyOutboundToReturn", BuildConfig.FLAVOR, "setupConfigListener", "setupSettingsListeners", "currencyListener", "updateCurrency", "siteListener", "setSiteInternal", "(Ldk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "directionListener", "onDirectionChanged", "(Ldk/molslinjen/domain/model/booking/RouteDirection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "routeListener", "setRouteInternal", "transportationListener", "setTransportationInternal", "returnCargoInfo", "(Ljava/lang/String;Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveTransportationId", "settingsTransportationId", "passengerInfoListener", "getTransportationSelectionModel", "Ldk/molslinjen/domain/model/config/TransportationSelectionModel;", "loadTransportProducts", "Ldk/molslinjen/domain/managers/ManagerResult;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setTransportProducts", "outboundProducts", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/product/Product;", "returnProducts", "isAddingReturnFromBookingSummary", "dateSelected", "date", "selectedEditProductsAfterLoad", "Ldk/molslinjen/domain/model/booking/LineItem;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setTransportation", "transportation", "Ldk/molslinjen/domain/model/config/Transportation;", "(Ldk/molslinjen/domain/model/config/Transportation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setTrailer", "outboundTrailer", "Ldk/molslinjen/domain/model/booking/product/TrailerProduct;", "returnTrailer", "removeSelectedTrailer", "onlyActiveDirection", "updateBookingType", "bookingType", "removeAllSelectedTransportProducts", "flipDirection", "updatePassengers", "outboundPassengerInfo", "returnPassengerInfo", "(Ldk/molslinjen/domain/model/booking/PassengerInfo;Ldk/molslinjen/domain/model/booking/PassengerInfo;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPassengersInternal", "(Ldk/molslinjen/domain/model/booking/PassengerInfo;Ldk/molslinjen/domain/model/booking/PassengerInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetDirectionIfOnReturnTab", "outboundDataChanged", "loadTrailers", "selectTrailerForEdit", "selectedTrailer", "(Ldk/molslinjen/domain/model/booking/LineItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "purchaseCountPerCityId", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "selectRoute", "route", "Ldk/molslinjen/domain/model/config/Route;", "defaultTransportationId", "(Ldk/molslinjen/domain/model/config/Site;Ldk/molslinjen/domain/model/config/Route;Ldk/molslinjen/domain/model/booking/RouteDirection;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrency", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "(Ldk/molslinjen/domain/model/config/Site;Ldk/molslinjen/domain/model/booking/CommuterBookingData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "InternalEditState", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RouteManager implements IRouteManager {
    private final MutableStateFlow<DepartureDirection> activeDepartureDirectionState;
    private final IAnalyticsTracker analyticsTracker;
    private final IBookingService bookingService;
    private final MutableStateFlow<BookingType> bookingTypeState;
    private final IConfigurationManager configurationManager;
    private final CoroutineScope coroutineScope;
    private final ICurrencyManager currencyManager;
    private final MutableStateFlow<InternalEditState> internalEditState;
    private final MutableStateFlow<RouteSelectedState> outboundSelectedState;
    private final MutableStateFlow<RouteSelectedState> returnSelectedState;
    private final MutableStateFlow<RouteState> routeState;
    private final ISettings settings;
    private final MutableStateFlow<RouteSharedSelectedState> sharedSelectedState;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.route.RouteManager$1", f = "RouteManager.kt", l = {97}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.route.RouteManager$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                RouteManager routeManager = RouteManager.this;
                this.label = 1;
                if (routeManager.load(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

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

    /* JADX WARN: Multi-variable type inference failed */
    public RouteManager(IBookingService bookingService, IConfigurationManager configurationManager, ISettings settings, ICurrencyManager currencyManager, IAnalyticsTracker analyticsTracker) {
        Intrinsics.checkNotNullParameter(bookingService, "bookingService");
        Intrinsics.checkNotNullParameter(configurationManager, "configurationManager");
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(currencyManager, "currencyManager");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        this.bookingService = bookingService;
        this.configurationManager = configurationManager;
        this.settings = settings;
        this.currencyManager = currencyManager;
        this.analyticsTracker = analyticsTracker;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        this.coroutineScope = CoroutineScope;
        this.activeDepartureDirectionState = StateFlowKt.MutableStateFlow(DepartureDirection.Outbound);
        this.bookingTypeState = StateFlowKt.MutableStateFlow(BookingType.Single);
        this.sharedSelectedState = StateFlowKt.MutableStateFlow(null);
        this.routeState = StateFlowKt.MutableStateFlow(null);
        this.outboundSelectedState = StateFlowKt.MutableStateFlow(null);
        this.returnSelectedState = StateFlowKt.MutableStateFlow(null);
        this.internalEditState = StateFlowKt.MutableStateFlow(new InternalEditState(null, 1, 0 == true ? 1 : 0));
        setupSettingsListeners();
        setupConfigListener();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
    }

    private final void currencyListener() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new RouteManager$currencyListener$1(this, null), 3, null);
    }

    private final void directionListener() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new RouteManager$directionListener$1(this, null), 3, null);
    }

    private final Object getCurrency(Site site, CommuterBookingData commuterBookingData, Continuation<? super CurrencyType> continuation) {
        CurrencyType currency;
        PriceTotal orderTotal;
        PriceWithCurrency price;
        CurrencyType currencyType;
        Booking editingBooking = this.internalEditState.getValue().getEditingBooking();
        return (editingBooking == null || (orderTotal = editingBooking.getOrderTotal()) == null || (price = orderTotal.getPrice()) == null || (currencyType = price.getCurrencyType()) == null) ? (commuterBookingData == null || (currency = commuterBookingData.getCurrency()) == null) ? this.currencyManager.getSelectedCurrency(site, continuation) : currency : currencyType;
    }

    private final MutableStateFlow<RouteSelectedState> getInactiveSelectedState() {
        int i5 = WhenMappings.$EnumSwitchMapping$0[getActiveDepartureDirectionState().getValue().ordinal()];
        if (i5 == 1) {
            return getReturnSelectedState();
        }
        if (i5 == 2) {
            return getOutboundSelectedState();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object load(Continuation<? super Unit> continuation) {
        RouteManager$load$1 routeManager$load$1;
        int i5;
        RouteManager routeManager;
        if (continuation instanceof RouteManager$load$1) {
            routeManager$load$1 = (RouteManager$load$1) continuation;
            int i6 = routeManager$load$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                routeManager$load$1.label = i6 - Integer.MIN_VALUE;
                RouteManager$load$1 routeManager$load$12 = routeManager$load$1;
                Object obj = routeManager$load$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = routeManager$load$12.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Site site = (Site) this.settings.latestValueFor(SettingsProperty.Departures.CurrentSite.INSTANCE);
                    RouteDirection routeDirection = (RouteDirection) this.settings.latestValueFor(SettingsProperty.Departures.CurrentDirection.INSTANCE);
                    String str = (String) this.settings.latestValueFor(SettingsProperty.Departures.CurrentRouteId.INSTANCE);
                    String str2 = (String) this.settings.latestValueFor(SettingsProperty.Departures.CurrentTransportationId.INSTANCE);
                    PassengerInfo passengerInfo = (PassengerInfo) this.settings.latestValueFor(SettingsProperty.Departures.CurrentPassengerInfo.INSTANCE);
                    TransportationCargoInfo transportationCargoInfo = (TransportationCargoInfo) this.settings.latestValueFor(SettingsProperty.Departures.CurrentTransportationInfo.INSTANCE);
                    routeManager$load$12.L$0 = this;
                    routeManager$load$12.label = 1;
                    if (setup$default(this, site, str, str2, routeDirection, transportationCargoInfo, passengerInfo, null, null, null, null, routeManager$load$12, 960, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    routeManager = this;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    routeManager = (RouteManager) routeManager$load$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                routeManager.analyticsTracker.updateBookingTypeStateTracking(false, AnalyticsStateTrackingHelper.BookingFlowTypeTracking.Ticket);
                return Unit.INSTANCE;
            }
        }
        routeManager$load$1 = new RouteManager$load$1(this, continuation);
        RouteManager$load$1 routeManager$load$122 = routeManager$load$1;
        Object obj2 = routeManager$load$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = routeManager$load$122.label;
        if (i5 != 0) {
        }
        routeManager.analyticsTracker.updateBookingTypeStateTracking(false, AnalyticsStateTrackingHelper.BookingFlowTypeTracking.Ticket);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TransportProducts loadTransportProducts$lambda$40(TransportProductsResponseDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new TransportProducts(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object onDirectionChanged(RouteDirection routeDirection, Continuation<? super Unit> continuation) {
        Route selectedRoute;
        RouteSelectedState value;
        RouteSelectedState routeSelectedState;
        RouteSelectedState value2;
        RouteSelectedState routeSelectedState2;
        RouteSharedSelectedState value3 = getSharedSelectedState().getValue();
        if (value3 == null || (selectedRoute = value3.getSelectedRoute()) == null) {
            return Unit.INSTANCE;
        }
        MutableStateFlow<RouteSelectedState> activeSelectedState = getActiveSelectedState();
        do {
            value = activeSelectedState.getValue();
            routeSelectedState = value;
        } while (!activeSelectedState.compareAndSet(value, routeSelectedState != null ? RouteSelectedState.copy$default(routeSelectedState, routeDirection, selectedRoute.getRouteDirection(routeDirection), null, null, null, null, null, 124, null) : null));
        RouteDirection flip = routeDirection.flip();
        MutableStateFlow<RouteSelectedState> inactiveSelectedState = getInactiveSelectedState();
        do {
            value2 = inactiveSelectedState.getValue();
            routeSelectedState2 = value2;
        } while (!inactiveSelectedState.compareAndSet(value2, routeSelectedState2 != null ? RouteSelectedState.copy$default(routeSelectedState2, flip, selectedRoute.getRouteDirection(flip), null, null, null, null, null, 124, null) : null));
        Object loadTransportProducts$default = IRouteManager.DefaultImpls.loadTransportProducts$default(this, null, continuation, 1, null);
        return loadTransportProducts$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? loadTransportProducts$default : Unit.INSTANCE;
    }

    private final void passengerInfoListener() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new RouteManager$passengerInfoListener$1(this, null), 3, null);
    }

    private final void resetDirectionIfOnReturnTab(boolean onlyActiveDirection, boolean outboundDataChanged) {
        if (getBookingTypeState().getValue() == BookingType.TwoWay && outboundDataChanged && getActiveDepartureDirectionState().getValue() == DepartureDirection.Return && !onlyActiveDirection) {
            updateDepartureDirection(DepartureDirection.Outbound, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String resolveTransportationId(String settingsTransportationId) {
        RouteSharedSelectedState value = getSharedSelectedState().getValue();
        if ((value != null ? value.getMultiRideBookingData() : null) == null) {
            return (value != null ? value.getCommuterBookingData() : null) != null ? value.getCommuterBookingData().getTransportationId() : settingsTransportationId;
        }
        String id = value.getSelectedTransportation().getId();
        List<String> transportationIds = value.getMultiRideBookingData().getTransportationIds();
        return transportationIds.contains(id) ? id : CollectionsKt.contains(transportationIds, settingsTransportationId) ? settingsTransportationId : value.getMultiRideBookingData().getDefaultTransportId();
    }

    private final void routeListener() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new RouteManager$routeListener$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object selectTrailerForEdit(LineItem lineItem, Continuation<? super Unit> continuation) {
        RouteManager$selectTrailerForEdit$1 routeManager$selectTrailerForEdit$1;
        int i5;
        RouteManager routeManager;
        ManagerResult managerResult;
        Object obj;
        if (continuation instanceof RouteManager$selectTrailerForEdit$1) {
            routeManager$selectTrailerForEdit$1 = (RouteManager$selectTrailerForEdit$1) continuation;
            int i6 = routeManager$selectTrailerForEdit$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                routeManager$selectTrailerForEdit$1.label = i6 - Integer.MIN_VALUE;
                Object obj2 = routeManager$selectTrailerForEdit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = routeManager$selectTrailerForEdit$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    routeManager$selectTrailerForEdit$1.L$0 = this;
                    routeManager$selectTrailerForEdit$1.L$1 = lineItem;
                    routeManager$selectTrailerForEdit$1.label = 1;
                    obj2 = loadTrailers(routeManager$selectTrailerForEdit$1);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    routeManager = this;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lineItem = (LineItem) routeManager$selectTrailerForEdit$1.L$1;
                    routeManager = (RouteManager) routeManager$selectTrailerForEdit$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                }
                managerResult = (ManagerResult) obj2;
                if (managerResult instanceof ManagerResult.Success) {
                    Iterator it = ((Iterable) ((ManagerResult.Success) managerResult).getData()).iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (Intrinsics.areEqual(((TrailerProduct) obj).getId(), lineItem.getId())) {
                            break;
                        }
                    }
                    TrailerProduct trailerProduct = (TrailerProduct) obj;
                    if (trailerProduct != null) {
                        routeManager.setTrailer(trailerProduct, null, false);
                    }
                }
                return Unit.INSTANCE;
            }
        }
        routeManager$selectTrailerForEdit$1 = new RouteManager$selectTrailerForEdit$1(this, continuation);
        Object obj22 = routeManager$selectTrailerForEdit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = routeManager$selectTrailerForEdit$1.label;
        if (i5 != 0) {
        }
        managerResult = (ManagerResult) obj22;
        if (managerResult instanceof ManagerResult.Success) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object setPassengersInternal(PassengerInfo passengerInfo, PassengerInfo passengerInfo2, Continuation<? super Unit> continuation) {
        RouteManager$setPassengersInternal$1 routeManager$setPassengersInternal$1;
        int i5;
        PassengerInfo passengerInfo3;
        RouteSelectedState value;
        RouteSelectedState routeSelectedState;
        RouteManager routeManager;
        PassengerInfo passengerInfo4;
        MutableStateFlow<RouteSelectedState> returnSelectedState;
        RouteSelectedState value2;
        RouteSelectedState routeSelectedState2;
        if (continuation instanceof RouteManager$setPassengersInternal$1) {
            routeManager$setPassengersInternal$1 = (RouteManager$setPassengersInternal$1) continuation;
            int i6 = routeManager$setPassengersInternal$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                routeManager$setPassengersInternal$1.label = i6 - Integer.MIN_VALUE;
                Object obj = routeManager$setPassengersInternal$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = routeManager$setPassengersInternal$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    RouteSharedSelectedState value3 = getSharedSelectedState().getValue();
                    if (this.internalEditState.getValue().getEditingBooking() == null) {
                        if ((value3 != null ? value3.getMultiRideBookingData() : null) == null) {
                            if ((value3 != null ? value3.getCommuterBookingData() : null) == null) {
                                ISettings iSettings = this.settings;
                                SettingsProperty.Departures.CurrentPassengerInfo currentPassengerInfo = SettingsProperty.Departures.CurrentPassengerInfo.INSTANCE;
                                routeManager$setPassengersInternal$1.L$0 = this;
                                passengerInfo3 = passengerInfo2;
                                routeManager$setPassengersInternal$1.L$1 = passengerInfo3;
                                routeManager$setPassengersInternal$1.label = 1;
                                if (iSettings.update(currentPassengerInfo, passengerInfo, routeManager$setPassengersInternal$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                routeManager = this;
                                passengerInfo4 = passengerInfo3;
                            }
                        }
                    }
                    passengerInfo3 = passengerInfo2;
                    MutableStateFlow<RouteSelectedState> outboundSelectedState = getOutboundSelectedState();
                    do {
                        value = outboundSelectedState.getValue();
                        routeSelectedState = value;
                    } while (!outboundSelectedState.compareAndSet(value, routeSelectedState != null ? RouteSelectedState.copy$default(routeSelectedState, null, null, null, null, null, passengerInfo, null, 95, null) : null));
                    routeManager = this;
                    passengerInfo4 = passengerInfo3;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    passengerInfo4 = (PassengerInfo) routeManager$setPassengersInternal$1.L$1;
                    routeManager = (RouteManager) routeManager$setPassengersInternal$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                returnSelectedState = routeManager.getReturnSelectedState();
                do {
                    value2 = returnSelectedState.getValue();
                    routeSelectedState2 = value2;
                } while (!returnSelectedState.compareAndSet(value2, routeSelectedState2 == null ? RouteSelectedState.copy$default(routeSelectedState2, null, null, null, null, null, passengerInfo4, null, 95, null) : null));
                return Unit.INSTANCE;
            }
        }
        routeManager$setPassengersInternal$1 = new RouteManager$setPassengersInternal$1(this, continuation);
        Object obj2 = routeManager$setPassengersInternal$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = routeManager$setPassengersInternal$1.label;
        if (i5 != 0) {
        }
        returnSelectedState = routeManager.getReturnSelectedState();
        do {
            value2 = returnSelectedState.getValue();
            routeSelectedState2 = value2;
        } while (!returnSelectedState.compareAndSet(value2, routeSelectedState2 == null ? RouteSelectedState.copy$default(routeSelectedState2, null, null, null, null, null, passengerInfo4, null, 95, null) : null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setRouteInternal(String routeId) {
        Object obj;
        RouteSharedSelectedState routeSharedSelectedState;
        RouteSharedSelectedState routeSharedSelectedState2;
        RouteSelectedState value;
        RouteSelectedState routeSelectedState;
        RouteSelectedState value2;
        RouteSelectedState routeSelectedState2;
        if (routeId == null) {
            return;
        }
        RouteState value3 = getRouteState().getValue();
        LocalizedSiteConfiguration configuration = value3 != null ? value3.getConfiguration() : null;
        if (configuration != null) {
            Iterator<T> it = configuration.getRoutes().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (Intrinsics.areEqual(((Route) obj).getId(), routeId)) {
                        break;
                    }
                }
            }
            Route route = (Route) obj;
            if (route == null) {
                Logger.INSTANCE.logCriticalThenFatalError(new CriticalLog("Route not found for id: " + routeId));
                return;
            }
            updateDepartureDirection(DepartureDirection.Outbound, null);
            MutableStateFlow<RouteSharedSelectedState> sharedSelectedState = getSharedSelectedState();
            do {
                RouteSharedSelectedState value4 = sharedSelectedState.getValue();
                RouteSharedSelectedState routeSharedSelectedState3 = value4;
                if (routeSharedSelectedState3 != null) {
                    routeSharedSelectedState = value4;
                    routeSharedSelectedState2 = routeSharedSelectedState3.copy((r18 & 1) != 0 ? routeSharedSelectedState3.hasRouteManuallyBeenSelected : true, (r18 & 2) != 0 ? routeSharedSelectedState3.site : null, (r18 & 4) != 0 ? routeSharedSelectedState3.lineLogoUrl : configuration.getLineLogoUrl(), (r18 & 8) != 0 ? routeSharedSelectedState3.selectedTransportation : null, (r18 & 16) != 0 ? routeSharedSelectedState3.selectedRoute : route, (r18 & 32) != 0 ? routeSharedSelectedState3.currency : null, (r18 & 64) != 0 ? routeSharedSelectedState3.commuterBookingData : null, (r18 & 128) != 0 ? routeSharedSelectedState3.multiRideBookingData : null);
                } else {
                    routeSharedSelectedState = value4;
                    routeSharedSelectedState2 = null;
                }
            } while (!sharedSelectedState.compareAndSet(routeSharedSelectedState, routeSharedSelectedState2));
            MutableStateFlow<RouteSelectedState> activeSelectedState = getActiveSelectedState();
            do {
                value = activeSelectedState.getValue();
                routeSelectedState = value;
            } while (!activeSelectedState.compareAndSet(value, routeSelectedState != null ? RouteSelectedState.copy$default(routeSelectedState, null, route.getRouteDirection(routeSelectedState.getSelectedRouteDirection()), null, null, null, null, null, 125, null) : null));
            MutableStateFlow<RouteSelectedState> inactiveSelectedState = getInactiveSelectedState();
            do {
                value2 = inactiveSelectedState.getValue();
                routeSelectedState2 = value2;
            } while (!inactiveSelectedState.compareAndSet(value2, routeSelectedState2 != null ? RouteSelectedState.copy$default(routeSelectedState2, null, route.getRouteDirection(routeSelectedState2.getSelectedRouteDirection()), null, null, null, null, null, 125, null) : null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object setSiteInternal(Site site, Continuation<? super Unit> continuation) {
        RouteManager$setSiteInternal$1 routeManager$setSiteInternal$1;
        int i5;
        RouteSharedSelectedState value;
        RouteSharedSelectedState routeSharedSelectedState;
        RouteManager routeManager;
        Site site2;
        if (continuation instanceof RouteManager$setSiteInternal$1) {
            routeManager$setSiteInternal$1 = (RouteManager$setSiteInternal$1) continuation;
            int i6 = routeManager$setSiteInternal$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                routeManager$setSiteInternal$1.label = i6 - Integer.MIN_VALUE;
                Object obj = routeManager$setSiteInternal$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = routeManager$setSiteInternal$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    MutableStateFlow<RouteSharedSelectedState> sharedSelectedState = getSharedSelectedState();
                    do {
                        value = sharedSelectedState.getValue();
                        routeSharedSelectedState = value;
                    } while (!sharedSelectedState.compareAndSet(value, routeSharedSelectedState != null ? routeSharedSelectedState.copy((r18 & 1) != 0 ? routeSharedSelectedState.hasRouteManuallyBeenSelected : false, (r18 & 2) != 0 ? routeSharedSelectedState.site : site, (r18 & 4) != 0 ? routeSharedSelectedState.lineLogoUrl : null, (r18 & 8) != 0 ? routeSharedSelectedState.selectedTransportation : null, (r18 & 16) != 0 ? routeSharedSelectedState.selectedRoute : null, (r18 & 32) != 0 ? routeSharedSelectedState.currency : null, (r18 & 64) != 0 ? routeSharedSelectedState.commuterBookingData : null, (r18 & 128) != 0 ? routeSharedSelectedState.multiRideBookingData : null) : null));
                    routeManager$setSiteInternal$1.L$0 = this;
                    routeManager$setSiteInternal$1.L$1 = site;
                    routeManager$setSiteInternal$1.label = 1;
                    if (updateCurrency(routeManager$setSiteInternal$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    routeManager = this;
                    site2 = site;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    site2 = (Site) routeManager$setSiteInternal$1.L$1;
                    routeManager = (RouteManager) routeManager$setSiteInternal$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                IAnalyticsTracker iAnalyticsTracker = routeManager.analyticsTracker;
                BookingType value2 = routeManager.getBookingTypeState().getValue();
                RouteSharedSelectedState value3 = routeManager.getSharedSelectedState().getValue();
                iAnalyticsTracker.updateBookingStateTracking(site2, value2, value3 != null ? value3.getSelectedTransportation() : null);
                return Unit.INSTANCE;
            }
        }
        routeManager$setSiteInternal$1 = new RouteManager$setSiteInternal$1(this, continuation);
        Object obj2 = routeManager$setSiteInternal$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = routeManager$setSiteInternal$1.label;
        if (i5 != 0) {
        }
        IAnalyticsTracker iAnalyticsTracker2 = routeManager.analyticsTracker;
        BookingType value22 = routeManager.getBookingTypeState().getValue();
        RouteSharedSelectedState value32 = routeManager.getSharedSelectedState().getValue();
        iAnalyticsTracker2.updateBookingStateTracking(site2, value22, value32 != null ? value32.getSelectedTransportation() : null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object setTransportationInternal(String str, TransportationCargoInfo transportationCargoInfo, TransportationCargoInfo transportationCargoInfo2, Continuation<? super Unit> continuation) {
        RouteManager$setTransportationInternal$1 routeManager$setTransportationInternal$1;
        int i5;
        Object obj;
        RouteSharedSelectedState value;
        RouteSharedSelectedState routeSharedSelectedState;
        RouteSelectedState value2;
        RouteSelectedState routeSelectedState;
        RouteSelectedState value3;
        RouteSelectedState routeSelectedState2;
        RouteSelectedState value4;
        RouteSelectedState routeSelectedState3;
        RouteSelectedState value5;
        RouteSelectedState routeSelectedState4;
        RouteManager routeManager;
        MutableStateFlow<RouteSelectedState> mutableStateFlow;
        Transportation transportation;
        Transportation transportation2;
        RouteSharedSelectedState value6;
        Site site;
        if (continuation instanceof RouteManager$setTransportationInternal$1) {
            routeManager$setTransportationInternal$1 = (RouteManager$setTransportationInternal$1) continuation;
            int i6 = routeManager$setTransportationInternal$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                routeManager$setTransportationInternal$1.label = i6 - Integer.MIN_VALUE;
                Object obj2 = routeManager$setTransportationInternal$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = routeManager$setTransportationInternal$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    if (str == null) {
                        return Unit.INSTANCE;
                    }
                    RouteState value7 = getRouteState().getValue();
                    LocalizedSiteConfiguration configuration = value7 != null ? value7.getConfiguration() : null;
                    if (configuration != null) {
                        Iterator<T> it = configuration.getTransportations().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it.next();
                            if (Intrinsics.areEqual(((Transportation) obj).getId(), str)) {
                                break;
                            }
                        }
                        Transportation transportation3 = (Transportation) obj;
                        if (transportation3 == null) {
                            Logger logger = Logger.INSTANCE;
                            List<Transportation> transportations = configuration.getTransportations();
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(transportations, 10));
                            Iterator<T> it2 = transportations.iterator();
                            while (it2.hasNext()) {
                                arrayList.add(((Transportation) it2.next()).getId());
                            }
                            logger.logCritical(new CriticalLog("Transportation not found for id: " + str + ", transportations: " + arrayList + ", site: " + configuration.getSite()));
                            return Unit.INSTANCE;
                        }
                        RouteSharedSelectedState value8 = getSharedSelectedState().getValue();
                        Transportation selectedTransportation = value8 != null ? value8.getSelectedTransportation() : null;
                        if (!Intrinsics.areEqual(selectedTransportation, transportation3)) {
                            updateDepartureDirection(DepartureDirection.Outbound, null);
                        }
                        MutableStateFlow<RouteSharedSelectedState> sharedSelectedState = getSharedSelectedState();
                        do {
                            value = sharedSelectedState.getValue();
                            routeSharedSelectedState = value;
                        } while (!sharedSelectedState.compareAndSet(value, routeSharedSelectedState != null ? routeSharedSelectedState.copy((r18 & 1) != 0 ? routeSharedSelectedState.hasRouteManuallyBeenSelected : false, (r18 & 2) != 0 ? routeSharedSelectedState.site : null, (r18 & 4) != 0 ? routeSharedSelectedState.lineLogoUrl : null, (r18 & 8) != 0 ? routeSharedSelectedState.selectedTransportation : transportation3, (r18 & 16) != 0 ? routeSharedSelectedState.selectedRoute : null, (r18 & 32) != 0 ? routeSharedSelectedState.currency : null, (r18 & 64) != 0 ? routeSharedSelectedState.commuterBookingData : null, (r18 & 128) != 0 ? routeSharedSelectedState.multiRideBookingData : null) : null));
                        MutableStateFlow<RouteSelectedState> outboundSelectedState = getOutboundSelectedState();
                        do {
                            value2 = outboundSelectedState.getValue();
                            routeSelectedState = value2;
                        } while (!outboundSelectedState.compareAndSet(value2, routeSelectedState != null ? RouteSelectedState.copy$default(routeSelectedState, null, null, transportationCargoInfo, null, null, null, null, 123, null) : null));
                        MutableStateFlow<RouteSelectedState> returnSelectedState = getReturnSelectedState();
                        do {
                            value3 = returnSelectedState.getValue();
                            routeSelectedState2 = value3;
                        } while (!returnSelectedState.compareAndSet(value3, routeSelectedState2 != null ? RouteSelectedState.copy$default(routeSelectedState2, null, null, transportationCargoInfo2, null, null, null, null, 123, null) : null));
                        MutableStateFlow<RouteSelectedState> activeSelectedState = getActiveSelectedState();
                        do {
                            value4 = activeSelectedState.getValue();
                            routeSelectedState3 = value4;
                        } while (!activeSelectedState.compareAndSet(value4, routeSelectedState3 != null ? RouteSelectedState.copy$default(routeSelectedState3, null, null, null, null, null, null, CollectionsKt.emptyList(), 55, null) : null));
                        MutableStateFlow<RouteSelectedState> inactiveSelectedState = getInactiveSelectedState();
                        do {
                            value5 = inactiveSelectedState.getValue();
                            routeSelectedState4 = value5;
                        } while (!inactiveSelectedState.compareAndSet(value5, routeSelectedState4 != null ? RouteSelectedState.copy$default(routeSelectedState4, null, null, null, null, null, null, CollectionsKt.emptyList(), 55, null) : null));
                        routeManager$setTransportationInternal$1.L$0 = this;
                        routeManager$setTransportationInternal$1.L$1 = selectedTransportation;
                        routeManager$setTransportationInternal$1.L$2 = activeSelectedState;
                        routeManager$setTransportationInternal$1.L$3 = transportation3;
                        routeManager$setTransportationInternal$1.label = 1;
                        if (IRouteManager.DefaultImpls.loadTransportProducts$default(this, null, routeManager$setTransportationInternal$1, 1, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        routeManager = this;
                        mutableStateFlow = activeSelectedState;
                        transportation = selectedTransportation;
                        transportation2 = transportation3;
                    }
                    return Unit.INSTANCE;
                }
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                transportation2 = (Transportation) routeManager$setTransportationInternal$1.L$3;
                mutableStateFlow = (MutableStateFlow) routeManager$setTransportationInternal$1.L$2;
                transportation = (Transportation) routeManager$setTransportationInternal$1.L$1;
                routeManager = (RouteManager) routeManager$setTransportationInternal$1.L$0;
                ResultKt.throwOnFailure(obj2);
                IAnalyticsTracker iAnalyticsTracker = routeManager.analyticsTracker;
                value6 = routeManager.getSharedSelectedState().getValue();
                if (value6 != null || (site = value6.getSite()) == null) {
                    return Unit.INSTANCE;
                }
                BookingType value9 = routeManager.getBookingTypeState().getValue();
                RouteSharedSelectedState value10 = routeManager.getSharedSelectedState().getValue();
                iAnalyticsTracker.updateBookingStateTracking(site, value9, value10 != null ? value10.getSelectedTransportation() : null);
                IAnalyticsTracker iAnalyticsTracker2 = routeManager.analyticsTracker;
                RouteSelectedState value11 = mutableStateFlow.getValue();
                iAnalyticsTracker2.trackEvent(new AnalyticsEvent.ChangeTransportationEvent(transportation, transportation2, value11 != null ? value11.getPassengerInfo() : null));
                return Unit.INSTANCE;
            }
        }
        routeManager$setTransportationInternal$1 = new RouteManager$setTransportationInternal$1(this, continuation);
        Object obj22 = routeManager$setTransportationInternal$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = routeManager$setTransportationInternal$1.label;
        if (i5 != 0) {
        }
        IAnalyticsTracker iAnalyticsTracker3 = routeManager.analyticsTracker;
        value6 = routeManager.getSharedSelectedState().getValue();
        if (value6 != null) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected(Continuation<? super Unit> continuation) {
        RouteManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1 routeManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1;
        Object coroutine_suspended;
        int i5;
        Transportation selectedTransportation;
        RouteManager routeManager;
        String str;
        LocalizedSiteConfiguration localizedSiteConfiguration;
        List<Transportation> transportations;
        Iterator<T> it;
        Object obj;
        Transportation transportation;
        String id;
        ISettings iSettings;
        SettingsProperty.Departures.CurrentTransportationId currentTransportationId;
        if (continuation instanceof RouteManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1) {
            routeManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1 = (RouteManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1) continuation;
            int i6 = routeManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                routeManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1.label = i6 - Integer.MIN_VALUE;
                Object obj2 = routeManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = routeManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    RouteSharedSelectedState value = getSharedSelectedState().getValue();
                    if (value == null || (selectedTransportation = value.getSelectedTransportation()) == null || !selectedTransportation.isOnlyAvailableWithReturnTicket()) {
                        return Unit.INSTANCE;
                    }
                    Site site = value.getSite();
                    String id2 = value.getSelectedRoute().getId();
                    IConfigurationManager iConfigurationManager = this.configurationManager;
                    routeManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1.L$0 = this;
                    routeManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1.L$1 = id2;
                    routeManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1.label = 1;
                    Object activeConfiguration = iConfigurationManager.getActiveConfiguration(site, routeManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1);
                    if (activeConfiguration == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    routeManager = this;
                    str = id2;
                    obj2 = activeConfiguration;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                        return Unit.INSTANCE;
                    }
                    str = (String) routeManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1.L$1;
                    routeManager = (RouteManager) routeManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                }
                localizedSiteConfiguration = (LocalizedSiteConfiguration) obj2;
                if (localizedSiteConfiguration != null && (transportations = localizedSiteConfiguration.getTransportations()) != null) {
                    it = transportations.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (((Transportation) obj).getAllowedRouteIds().contains(str)) {
                            break;
                        }
                    }
                    transportation = (Transportation) obj;
                    if (transportation != null && (id = transportation.getId()) != null) {
                        iSettings = routeManager.settings;
                        currentTransportationId = SettingsProperty.Departures.CurrentTransportationId.INSTANCE;
                        routeManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1.L$0 = null;
                        routeManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1.L$1 = null;
                        routeManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1.label = 2;
                        if (iSettings.update(currentTransportationId, id, routeManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        routeManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1 = new RouteManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1(this, continuation);
        Object obj22 = routeManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = routeManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1.label;
        if (i5 != 0) {
        }
        localizedSiteConfiguration = (LocalizedSiteConfiguration) obj22;
        if (localizedSiteConfiguration != null) {
            it = transportations.iterator();
            while (true) {
                if (it.hasNext()) {
                }
            }
            transportation = (Transportation) obj;
            if (transportation != null) {
                iSettings = routeManager.settings;
                currentTransportationId = SettingsProperty.Departures.CurrentTransportationId.INSTANCE;
                routeManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1.L$0 = null;
                routeManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1.L$1 = null;
                routeManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1.label = 2;
                if (iSettings.update(currentTransportationId, id, routeManager$setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected$1) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0272 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0299  */
    /* JADX WARN: Type inference failed for: r12v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x0273 -> B:39:0x028e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object setup(Site site, String str, String str2, RouteDirection routeDirection, TransportationCargoInfo transportationCargoInfo, PassengerInfo passengerInfo, LocalDate localDate, Booking booking, CommuterBookingData commuterBookingData, MultiRideBookingData multiRideBookingData, Continuation<? super Unit> continuation) {
        RouteManager$setup$1 routeManager$setup$1;
        int i5;
        String str3;
        String str4;
        RouteDirection routeDirection2;
        TransportationCargoInfo transportationCargoInfo2;
        PassengerInfo passengerInfo2;
        LocalDate localDate2;
        Booking booking2;
        CommuterBookingData commuterBookingData2;
        RouteManager routeManager;
        Site site2;
        MultiRideBookingData multiRideBookingData2;
        LocalizedSiteConfiguration localizedSiteConfiguration;
        Object obj;
        Object obj2;
        MultiRideBookingData multiRideBookingData3;
        Object obj3;
        String str5;
        Booking booking3;
        CommuterBookingData commuterBookingData3;
        Route route;
        Transportation transportation;
        RouteDirectionGroup routeDirectionGroup;
        MutableStateFlow<RouteSharedSelectedState> sharedSelectedState;
        MultiRideBookingData multiRideBookingData4;
        int i6;
        Object currency;
        Object obj4;
        Transportation transportation2;
        RouteManager$setup$1 routeManager$setup$12;
        RouteManager routeManager2;
        ArrayList arrayList;
        Site site3;
        RouteManager routeManager3;
        BookingTicket ticket;
        List<LineItem> transportProducts;
        LineItem lineItem;
        Site site4;
        Transportation transportation3;
        BookingTicket ticket2;
        List<LineItem> transportProducts2;
        LineItem lineItem2;
        if (continuation instanceof RouteManager$setup$1) {
            routeManager$setup$1 = (RouteManager$setup$1) continuation;
            int i7 = routeManager$setup$1.label;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                routeManager$setup$1.label = i7 - Integer.MIN_VALUE;
                Object obj5 = routeManager$setup$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = routeManager$setup$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj5);
                    IConfigurationManager iConfigurationManager = this.configurationManager;
                    routeManager$setup$1.L$0 = this;
                    routeManager$setup$1.L$1 = site;
                    str3 = str;
                    routeManager$setup$1.L$2 = str3;
                    str4 = str2;
                    routeManager$setup$1.L$3 = str4;
                    routeDirection2 = routeDirection;
                    routeManager$setup$1.L$4 = routeDirection2;
                    transportationCargoInfo2 = transportationCargoInfo;
                    routeManager$setup$1.L$5 = transportationCargoInfo2;
                    passengerInfo2 = passengerInfo;
                    routeManager$setup$1.L$6 = passengerInfo2;
                    localDate2 = localDate;
                    routeManager$setup$1.L$7 = localDate2;
                    booking2 = booking;
                    routeManager$setup$1.L$8 = booking2;
                    commuterBookingData2 = commuterBookingData;
                    routeManager$setup$1.L$9 = commuterBookingData2;
                    routeManager$setup$1.L$10 = multiRideBookingData;
                    routeManager$setup$1.label = 1;
                    obj5 = iConfigurationManager.getActiveConfiguration(site, routeManager$setup$1);
                    if (obj5 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    routeManager = this;
                    site2 = site;
                    multiRideBookingData2 = multiRideBookingData;
                } else if (i5 == 1) {
                    multiRideBookingData2 = (MultiRideBookingData) routeManager$setup$1.L$10;
                    CommuterBookingData commuterBookingData4 = (CommuterBookingData) routeManager$setup$1.L$9;
                    Booking booking4 = (Booking) routeManager$setup$1.L$8;
                    LocalDate localDate3 = (LocalDate) routeManager$setup$1.L$7;
                    PassengerInfo passengerInfo3 = (PassengerInfo) routeManager$setup$1.L$6;
                    TransportationCargoInfo transportationCargoInfo3 = (TransportationCargoInfo) routeManager$setup$1.L$5;
                    RouteDirection routeDirection3 = (RouteDirection) routeManager$setup$1.L$4;
                    String str6 = (String) routeManager$setup$1.L$3;
                    String str7 = (String) routeManager$setup$1.L$2;
                    site2 = (Site) routeManager$setup$1.L$1;
                    RouteManager routeManager4 = (RouteManager) routeManager$setup$1.L$0;
                    ResultKt.throwOnFailure(obj5);
                    routeManager = routeManager4;
                    commuterBookingData2 = commuterBookingData4;
                    str3 = str7;
                    booking2 = booking4;
                    str4 = str6;
                    localDate2 = localDate3;
                    routeDirection2 = routeDirection3;
                    passengerInfo2 = passengerInfo3;
                    transportationCargoInfo2 = transportationCargoInfo3;
                } else {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (i5 != 4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            transportation3 = (Transportation) routeManager$setup$1.L$2;
                            site4 = (Site) routeManager$setup$1.L$1;
                            routeManager3 = (RouteManager) routeManager$setup$1.L$0;
                            ResultKt.throwOnFailure(obj5);
                            transportation2 = transportation3;
                            site3 = site4;
                            routeManager3.analyticsTracker.updateBookingStateTracking(site3, routeManager3.getBookingTypeState().getValue(), transportation2);
                            return Unit.INSTANCE;
                        }
                        Transportation transportation4 = (Transportation) routeManager$setup$1.L$3;
                        booking3 = (Booking) routeManager$setup$1.L$2;
                        site3 = (Site) routeManager$setup$1.L$1;
                        RouteManager routeManager5 = (RouteManager) routeManager$setup$1.L$0;
                        ResultKt.throwOnFailure(obj5);
                        transportation2 = transportation4;
                        obj4 = coroutine_suspended;
                        routeManager$setup$12 = routeManager$setup$1;
                        routeManager3 = routeManager5;
                        if (booking3 != null || (ticket2 = booking3.getTicket()) == null || (transportProducts2 = ticket2.getTransportProducts()) == null) {
                            lineItem = null;
                        } else {
                            Iterator it = transportProducts2.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    lineItem2 = 0;
                                    break;
                                }
                                lineItem2 = it.next();
                                if (((LineItem) lineItem2).getProductType() == ProductType.Trailer) {
                                    break;
                                }
                            }
                            lineItem = lineItem2;
                        }
                        if (lineItem != null) {
                            routeManager$setup$12.L$0 = routeManager3;
                            routeManager$setup$12.L$1 = site3;
                            routeManager$setup$12.L$2 = transportation2;
                            routeManager$setup$12.L$3 = null;
                            routeManager$setup$12.label = 4;
                            if (routeManager3.selectTrailerForEdit(lineItem, routeManager$setup$12) == obj4) {
                                return obj4;
                            }
                            site4 = site3;
                            transportation3 = transportation2;
                            transportation2 = transportation3;
                            site3 = site4;
                        }
                        routeManager3.analyticsTracker.updateBookingStateTracking(site3, routeManager3.getBookingTypeState().getValue(), transportation2);
                        return Unit.INSTANCE;
                    }
                    int i8 = routeManager$setup$1.I$0;
                    String str8 = (String) routeManager$setup$1.L$16;
                    ?? r12 = routeManager$setup$1.L$15;
                    MutableStateFlow<RouteSharedSelectedState> mutableStateFlow = (MutableStateFlow) routeManager$setup$1.L$14;
                    RouteDirectionGroup routeDirectionGroup2 = (RouteDirectionGroup) routeManager$setup$1.L$13;
                    transportation2 = (Transportation) routeManager$setup$1.L$12;
                    route = (Route) routeManager$setup$1.L$11;
                    LocalizedSiteConfiguration localizedSiteConfiguration2 = (LocalizedSiteConfiguration) routeManager$setup$1.L$10;
                    MultiRideBookingData multiRideBookingData5 = (MultiRideBookingData) routeManager$setup$1.L$9;
                    CommuterBookingData commuterBookingData5 = (CommuterBookingData) routeManager$setup$1.L$8;
                    Booking booking5 = (Booking) routeManager$setup$1.L$7;
                    LocalDate localDate4 = (LocalDate) routeManager$setup$1.L$6;
                    PassengerInfo passengerInfo4 = (PassengerInfo) routeManager$setup$1.L$5;
                    TransportationCargoInfo transportationCargoInfo4 = (TransportationCargoInfo) routeManager$setup$1.L$4;
                    RouteDirection routeDirection4 = (RouteDirection) routeManager$setup$1.L$3;
                    String str9 = (String) routeManager$setup$1.L$2;
                    Site site5 = (Site) routeManager$setup$1.L$1;
                    RouteManager routeManager6 = (RouteManager) routeManager$setup$1.L$0;
                    ResultKt.throwOnFailure(obj5);
                    i6 = i8;
                    Site site6 = site5;
                    RouteManager routeManager7 = routeManager6;
                    obj4 = coroutine_suspended;
                    String str10 = str8;
                    multiRideBookingData4 = multiRideBookingData5;
                    booking3 = booking5;
                    RouteDirectionGroup routeDirectionGroup3 = routeDirectionGroup2;
                    TransportationCargoInfo transportationCargoInfo5 = transportationCargoInfo4;
                    RouteDirection routeDirection5 = routeDirection4;
                    routeManager$setup$12 = routeManager$setup$1;
                    RouteSharedSelectedState routeSharedSelectedState = r12;
                    Object obj6 = obj5;
                    CommuterBookingData commuterBookingData6 = commuterBookingData5;
                    String str11 = str9;
                    LocalDate localDate5 = localDate4;
                    PassengerInfo passengerInfo5 = passengerInfo4;
                    if (!mutableStateFlow.compareAndSet(routeSharedSelectedState, new RouteSharedSelectedState(i6 == 0, site6, str10, transportation2, route, (CurrencyType) obj6, commuterBookingData6, multiRideBookingData4))) {
                        MutableStateFlow<RouteState> routeState = routeManager7.getRouteState();
                        do {
                        } while (!routeState.compareAndSet(routeState.getValue(), new RouteState(null, localizedSiteConfiguration2, null, 5, null)));
                        MutableStateFlow<RouteSelectedState> outboundSelectedState = routeManager7.getOutboundSelectedState();
                        do {
                        } while (!outboundSelectedState.compareAndSet(outboundSelectedState.getValue(), new RouteSelectedState(routeDirection5, routeDirectionGroup3, transportationCargoInfo5, null, localDate5, passengerInfo5, null, 72, null)));
                        MutableStateFlow<RouteSelectedState> returnSelectedState = routeManager7.getReturnSelectedState();
                        do {
                        } while (!returnSelectedState.compareAndSet(returnSelectedState.getValue(), null));
                        MutableStateFlow<BookingType> bookingTypeState = routeManager7.getBookingTypeState();
                        do {
                        } while (!bookingTypeState.compareAndSet(bookingTypeState.getValue(), BookingType.Single));
                        if (booking3 == null || (ticket = booking3.getTicket()) == null || (transportProducts = ticket.getTransportProducts()) == null) {
                            routeManager2 = routeManager7;
                            arrayList = null;
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            for (Object obj7 : transportProducts) {
                                if (((LineItem) obj7).getProductType() != ProductType.Trailer) {
                                    arrayList2.add(obj7);
                                }
                            }
                            arrayList = arrayList2;
                            routeManager2 = routeManager7;
                        }
                        routeManager$setup$12.L$0 = routeManager2;
                        site3 = site6;
                        routeManager$setup$12.L$1 = site3;
                        routeManager$setup$12.L$2 = booking3;
                        routeManager$setup$12.L$3 = transportation2;
                        routeManager$setup$12.L$4 = null;
                        routeManager$setup$12.L$5 = null;
                        routeManager$setup$12.L$6 = null;
                        routeManager$setup$12.L$7 = null;
                        routeManager$setup$12.L$8 = null;
                        routeManager$setup$12.L$9 = null;
                        routeManager$setup$12.L$10 = null;
                        routeManager$setup$12.L$11 = null;
                        routeManager$setup$12.L$12 = null;
                        routeManager$setup$12.L$13 = null;
                        routeManager$setup$12.L$14 = null;
                        routeManager$setup$12.L$15 = null;
                        routeManager$setup$12.L$16 = null;
                        routeManager$setup$12.label = 3;
                        if (routeManager2.loadTransportProducts(arrayList, routeManager$setup$12) == obj4) {
                            return obj4;
                        }
                        routeManager3 = routeManager2;
                        if (booking3 != null) {
                        }
                        lineItem = null;
                        if (lineItem != null) {
                        }
                        routeManager3.analyticsTracker.updateBookingStateTracking(site3, routeManager3.getBookingTypeState().getValue(), transportation2);
                        return Unit.INSTANCE;
                    }
                    RouteManager routeManager8 = routeManager7;
                    routeManager$setup$1 = routeManager$setup$12;
                    transportation = transportation2;
                    routeDirectionGroup = routeDirectionGroup3;
                    routeManager = routeManager8;
                    Site site7 = site6;
                    obj3 = obj4;
                    str5 = str11;
                    localizedSiteConfiguration = localizedSiteConfiguration2;
                    routeDirection2 = routeDirection5;
                    transportationCargoInfo2 = transportationCargoInfo5;
                    passengerInfo2 = passengerInfo5;
                    localDate2 = localDate5;
                    commuterBookingData3 = commuterBookingData6;
                    sharedSelectedState = mutableStateFlow;
                    site2 = site7;
                    RouteSharedSelectedState value = sharedSelectedState.getValue();
                    i6 = str5 == null ? 1 : 0;
                    String lineLogoUrl = localizedSiteConfiguration.getLineLogoUrl();
                    routeManager$setup$1.L$0 = routeManager;
                    routeManager$setup$1.L$1 = site2;
                    routeManager$setup$1.L$2 = str5;
                    routeManager$setup$1.L$3 = routeDirection2;
                    routeManager$setup$1.L$4 = transportationCargoInfo2;
                    routeManager$setup$1.L$5 = passengerInfo2;
                    routeManager$setup$1.L$6 = localDate2;
                    routeManager$setup$1.L$7 = booking3;
                    routeManager$setup$1.L$8 = commuterBookingData3;
                    routeManager$setup$1.L$9 = multiRideBookingData4;
                    routeManager$setup$1.L$10 = localizedSiteConfiguration;
                    routeManager$setup$1.L$11 = route;
                    routeManager$setup$1.L$12 = transportation;
                    MultiRideBookingData multiRideBookingData6 = multiRideBookingData4;
                    routeManager$setup$1.L$13 = routeDirectionGroup;
                    routeManager$setup$1.L$14 = sharedSelectedState;
                    routeManager$setup$1.L$15 = value;
                    routeManager$setup$1.L$16 = lineLogoUrl;
                    routeManager$setup$1.I$0 = i6;
                    routeManager$setup$1.label = 2;
                    currency = routeManager.getCurrency(site2, commuterBookingData3, routeManager$setup$1);
                    String str12 = str5;
                    obj4 = obj3;
                    if (currency != obj4) {
                        return obj4;
                    }
                    site6 = site2;
                    str10 = lineLogoUrl;
                    routeSharedSelectedState = value;
                    mutableStateFlow = sharedSelectedState;
                    commuterBookingData6 = commuterBookingData3;
                    localDate5 = localDate2;
                    passengerInfo5 = passengerInfo2;
                    transportationCargoInfo5 = transportationCargoInfo2;
                    routeDirection5 = routeDirection2;
                    localizedSiteConfiguration2 = localizedSiteConfiguration;
                    str11 = str12;
                    RouteManager$setup$1 routeManager$setup$13 = routeManager$setup$1;
                    obj6 = currency;
                    multiRideBookingData4 = multiRideBookingData6;
                    routeDirectionGroup3 = routeDirectionGroup;
                    routeManager7 = routeManager;
                    transportation2 = transportation;
                    routeManager$setup$12 = routeManager$setup$13;
                    if (!mutableStateFlow.compareAndSet(routeSharedSelectedState, new RouteSharedSelectedState(i6 == 0, site6, str10, transportation2, route, (CurrencyType) obj6, commuterBookingData6, multiRideBookingData4))) {
                    }
                }
                localizedSiteConfiguration = (LocalizedSiteConfiguration) obj5;
                if (localizedSiteConfiguration != null) {
                    return Unit.INSTANCE;
                }
                Iterator it2 = localizedSiteConfiguration.getRoutes().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    if (Intrinsics.areEqual(((Route) obj).getId(), str3)) {
                        break;
                    }
                }
                Route route2 = (Route) obj;
                if (route2 == null) {
                    route2 = (Route) CollectionsKt.first((List) localizedSiteConfiguration.getRoutes());
                }
                Route route3 = route2;
                Iterator it3 = localizedSiteConfiguration.getTransportations().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it3.next();
                    if (Intrinsics.areEqual(((Transportation) obj2).getId(), str4)) {
                        break;
                    }
                }
                Transportation transportation5 = (Transportation) obj2;
                if (transportation5 == null) {
                    Iterator it4 = localizedSiteConfiguration.getTransportations().iterator();
                    while (it4.hasNext()) {
                        transportation5 = (Transportation) it4.next();
                        Iterator it5 = it4;
                        if (!transportation5.getAllowedRouteIds().contains(route3.getId())) {
                            it4 = it5;
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
                RouteDirectionGroup routeDirection6 = route3.getRouteDirection(routeDirection2);
                MutableStateFlow<InternalEditState> mutableStateFlow2 = routeManager.internalEditState;
                while (true) {
                    InternalEditState value2 = mutableStateFlow2.getValue();
                    multiRideBookingData3 = multiRideBookingData2;
                    if (mutableStateFlow2.compareAndSet(value2, value2.copy(booking2))) {
                        break;
                    }
                    multiRideBookingData2 = multiRideBookingData3;
                }
                obj3 = coroutine_suspended;
                str5 = str3;
                booking3 = booking2;
                commuterBookingData3 = commuterBookingData2;
                route = route3;
                transportation = transportation5;
                routeDirectionGroup = routeDirection6;
                sharedSelectedState = routeManager.getSharedSelectedState();
                multiRideBookingData4 = multiRideBookingData3;
                RouteSharedSelectedState value3 = sharedSelectedState.getValue();
                if (str5 == null) {
                }
                String lineLogoUrl2 = localizedSiteConfiguration.getLineLogoUrl();
                routeManager$setup$1.L$0 = routeManager;
                routeManager$setup$1.L$1 = site2;
                routeManager$setup$1.L$2 = str5;
                routeManager$setup$1.L$3 = routeDirection2;
                routeManager$setup$1.L$4 = transportationCargoInfo2;
                routeManager$setup$1.L$5 = passengerInfo2;
                routeManager$setup$1.L$6 = localDate2;
                routeManager$setup$1.L$7 = booking3;
                routeManager$setup$1.L$8 = commuterBookingData3;
                routeManager$setup$1.L$9 = multiRideBookingData4;
                routeManager$setup$1.L$10 = localizedSiteConfiguration;
                routeManager$setup$1.L$11 = route;
                routeManager$setup$1.L$12 = transportation;
                MultiRideBookingData multiRideBookingData62 = multiRideBookingData4;
                routeManager$setup$1.L$13 = routeDirectionGroup;
                routeManager$setup$1.L$14 = sharedSelectedState;
                routeManager$setup$1.L$15 = value3;
                routeManager$setup$1.L$16 = lineLogoUrl2;
                routeManager$setup$1.I$0 = i6;
                routeManager$setup$1.label = 2;
                currency = routeManager.getCurrency(site2, commuterBookingData3, routeManager$setup$1);
                String str122 = str5;
                obj4 = obj3;
                if (currency != obj4) {
                }
            }
        }
        routeManager$setup$1 = new RouteManager$setup$1(this, continuation);
        Object obj52 = routeManager$setup$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = routeManager$setup$1.label;
        if (i5 != 0) {
        }
        localizedSiteConfiguration = (LocalizedSiteConfiguration) obj52;
        if (localizedSiteConfiguration != null) {
        }
    }

    static /* synthetic */ Object setup$default(RouteManager routeManager, Site site, String str, String str2, RouteDirection routeDirection, TransportationCargoInfo transportationCargoInfo, PassengerInfo passengerInfo, LocalDate localDate, Booking booking, CommuterBookingData commuterBookingData, MultiRideBookingData multiRideBookingData, Continuation continuation, int i5, Object obj) {
        return routeManager.setup(site, str, str2, routeDirection, transportationCargoInfo, passengerInfo, (i5 & 64) != 0 ? LocalDate.now() : localDate, (i5 & 128) != 0 ? null : booking, (i5 & 256) != 0 ? null : commuterBookingData, (i5 & 512) != 0 ? null : multiRideBookingData, continuation);
    }

    private final void setupConfigListener() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new RouteManager$setupConfigListener$1(this, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setupReturnState(LocalDate outboundSelectedDepartureDate, final boolean copyOutboundToReturn) {
        RouteSelectedState value;
        RouteSelectedState routeSelectedState;
        RouteDirection selectedRouteDirection;
        RouteDirection flip;
        RouteSharedSelectedState value2;
        Route selectedRoute;
        RouteDirectionGroup routeDirection;
        TrailerProduct trailerProduct;
        TrailerProduct selectedTrailer;
        if (getBookingTypeState().getValue() == BookingType.Single) {
            MutableStateFlow<RouteSelectedState> returnSelectedState = getReturnSelectedState();
            do {
            } while (!returnSelectedState.compareAndSet(returnSelectedState.getValue(), null));
            if (getActiveDepartureDirectionState().getValue() == DepartureDirection.Return) {
                updateDepartureDirection(DepartureDirection.Outbound, null);
            }
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new RouteManager$setupReturnState$2(this, null), 3, null);
            return;
        }
        MutableStateFlow<RouteSelectedState> returnSelectedState2 = getReturnSelectedState();
        do {
            value = returnSelectedState2.getValue();
            routeSelectedState = value;
            final RouteSelectedState value3 = getOutboundSelectedState().getValue();
            if (value3 != null && (selectedRouteDirection = value3.getSelectedRouteDirection()) != null && (flip = selectedRouteDirection.flip()) != null && (value2 = getSharedSelectedState().getValue()) != null && (selectedRoute = value2.getSelectedRoute()) != null && (routeDirection = selectedRoute.getRouteDirection(flip)) != null) {
                LocalDate selectedStartDate = outboundSelectedDepartureDate == null ? value3.getSelectedStartDate() : outboundSelectedDepartureDate;
                List<? extends Product> list = (List) CollectionExtensionsKt.ifNullOrEmpty(routeSelectedState != null ? routeSelectedState.getSelectedTransportProducts() : null, new Function0() { // from class: E1.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        List list2;
                        list2 = RouteManager.setupReturnState$lambda$16$lambda$15(copyOutboundToReturn, value3);
                        return list2;
                    }
                });
                if (routeSelectedState == null || (selectedTrailer = routeSelectedState.getSelectedTrailer()) == null) {
                    if (copyOutboundToReturn) {
                        selectedTrailer = value3.getSelectedTrailer();
                    } else {
                        trailerProduct = null;
                        if (routeSelectedState != null || (r4 = routeSelectedState.getPassengerInfo()) == null) {
                            PassengerInfo passengerInfo = value3.getPassengerInfo();
                        }
                        routeSelectedState = value3.copy(flip, routeDirection, routeSelectedState == null ? routeSelectedState.getTransportationCargoInfo() : null, trailerProduct, selectedStartDate, passengerInfo, list);
                    }
                }
                trailerProduct = selectedTrailer;
                if (routeSelectedState != null) {
                }
                PassengerInfo passengerInfo2 = value3.getPassengerInfo();
                routeSelectedState = value3.copy(flip, routeDirection, routeSelectedState == null ? routeSelectedState.getTransportationCargoInfo() : null, trailerProduct, selectedStartDate, passengerInfo2, list);
            }
        } while (!returnSelectedState2.compareAndSet(value, routeSelectedState));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List setupReturnState$lambda$16$lambda$15(boolean z5, RouteSelectedState routeSelectedState) {
        return z5 ? routeSelectedState.getSelectedTransportProducts() : CollectionsKt.emptyList();
    }

    private final void setupSettingsListeners() {
        currencyListener();
        siteListener();
        directionListener();
        routeListener();
        transportationListener();
        passengerInfoListener();
    }

    private final void siteListener() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new RouteManager$siteListener$1(this, null), 3, null);
    }

    private final void transportationListener() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new RouteManager$transportationListener$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updateCurrency(Continuation<? super Unit> continuation) {
        RouteManager$updateCurrency$1 routeManager$updateCurrency$1;
        int i5;
        RouteManager routeManager;
        CurrencyType currencyType;
        MutableStateFlow<RouteSharedSelectedState> sharedSelectedState;
        RouteSharedSelectedState value;
        RouteSharedSelectedState routeSharedSelectedState;
        if (continuation instanceof RouteManager$updateCurrency$1) {
            routeManager$updateCurrency$1 = (RouteManager$updateCurrency$1) continuation;
            int i6 = routeManager$updateCurrency$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                routeManager$updateCurrency$1.label = i6 - Integer.MIN_VALUE;
                Object obj = routeManager$updateCurrency$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = routeManager$updateCurrency$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    RouteSharedSelectedState value2 = getSharedSelectedState().getValue();
                    if (value2 != null && value2.getCommuterBookingData() == null) {
                        Site site = value2.getSite();
                        ICurrencyManager iCurrencyManager = this.currencyManager;
                        routeManager$updateCurrency$1.L$0 = this;
                        routeManager$updateCurrency$1.label = 1;
                        obj = iCurrencyManager.getSelectedCurrency(site, routeManager$updateCurrency$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        routeManager = this;
                    }
                    return Unit.INSTANCE;
                }
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                routeManager = (RouteManager) routeManager$updateCurrency$1.L$0;
                ResultKt.throwOnFailure(obj);
                currencyType = (CurrencyType) obj;
                sharedSelectedState = routeManager.getSharedSelectedState();
                do {
                    value = sharedSelectedState.getValue();
                    routeSharedSelectedState = value;
                } while (!sharedSelectedState.compareAndSet(value, routeSharedSelectedState == null ? routeSharedSelectedState.copy((r18 & 1) != 0 ? routeSharedSelectedState.hasRouteManuallyBeenSelected : false, (r18 & 2) != 0 ? routeSharedSelectedState.site : null, (r18 & 4) != 0 ? routeSharedSelectedState.lineLogoUrl : null, (r18 & 8) != 0 ? routeSharedSelectedState.selectedTransportation : null, (r18 & 16) != 0 ? routeSharedSelectedState.selectedRoute : null, (r18 & 32) != 0 ? routeSharedSelectedState.currency : currencyType, (r18 & 64) != 0 ? routeSharedSelectedState.commuterBookingData : null, (r18 & 128) != 0 ? routeSharedSelectedState.multiRideBookingData : null) : null));
                return Unit.INSTANCE;
            }
        }
        routeManager$updateCurrency$1 = new RouteManager$updateCurrency$1(this, continuation);
        Object obj2 = routeManager$updateCurrency$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = routeManager$updateCurrency$1.label;
        if (i5 != 0) {
        }
        currencyType = (CurrencyType) obj2;
        sharedSelectedState = routeManager.getSharedSelectedState();
        do {
            value = sharedSelectedState.getValue();
            routeSharedSelectedState = value;
        } while (!sharedSelectedState.compareAndSet(value, routeSharedSelectedState == null ? routeSharedSelectedState.copy((r18 & 1) != 0 ? routeSharedSelectedState.hasRouteManuallyBeenSelected : false, (r18 & 2) != 0 ? routeSharedSelectedState.site : null, (r18 & 4) != 0 ? routeSharedSelectedState.lineLogoUrl : null, (r18 & 8) != 0 ? routeSharedSelectedState.selectedTransportation : null, (r18 & 16) != 0 ? routeSharedSelectedState.selectedRoute : null, (r18 & 32) != 0 ? routeSharedSelectedState.currency : currencyType, (r18 & 64) != 0 ? routeSharedSelectedState.commuterBookingData : null, (r18 & 128) != 0 ? routeSharedSelectedState.multiRideBookingData : null) : null));
        return Unit.INSTANCE;
    }

    @Override // dk.molslinjen.domain.managers.route.IRouteManager
    public void dateSelected(LocalDate date) {
        RouteSelectedState value;
        RouteSelectedState routeSelectedState;
        Intrinsics.checkNotNullParameter(date, "date");
        MutableStateFlow<RouteSelectedState> activeSelectedState = getActiveSelectedState();
        do {
            value = activeSelectedState.getValue();
            routeSelectedState = value;
        } while (!activeSelectedState.compareAndSet(value, routeSelectedState != null ? RouteSelectedState.copy$default(routeSelectedState, null, null, null, null, date, null, null, 111, null) : null));
        this.analyticsTracker.trackEvent(new AnalyticsEvent.ChangeDateEvent(date));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // dk.molslinjen.domain.managers.route.IRouteManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object flipDirection(Continuation<? super Unit> continuation) {
        RouteManager$flipDirection$1 routeManager$flipDirection$1;
        int i5;
        RouteManager routeManager;
        RouteSelectedState routeSelectedState;
        if (continuation instanceof RouteManager$flipDirection$1) {
            routeManager$flipDirection$1 = (RouteManager$flipDirection$1) continuation;
            int i6 = routeManager$flipDirection$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                routeManager$flipDirection$1.label = i6 - Integer.MIN_VALUE;
                Object obj = routeManager$flipDirection$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = routeManager$flipDirection$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    RouteSelectedState value = getActiveSelectedState().getValue();
                    if (value == null) {
                        return Unit.INSTANCE;
                    }
                    RouteSharedSelectedState value2 = getSharedSelectedState().getValue();
                    if (this.internalEditState.getValue().getEditingBooking() == null) {
                        if ((value2 != null ? value2.getMultiRideBookingData() : null) == null) {
                            if ((value2 != null ? value2.getCommuterBookingData() : null) == null) {
                                ISettings iSettings = this.settings;
                                SettingsProperty.Departures.CurrentDirection currentDirection = SettingsProperty.Departures.CurrentDirection.INSTANCE;
                                RouteDirection flip = value.getSelectedRouteDirection().flip();
                                routeManager$flipDirection$1.L$0 = this;
                                routeManager$flipDirection$1.L$1 = value;
                                routeManager$flipDirection$1.label = 2;
                                if (iSettings.update(currentDirection, flip, routeManager$flipDirection$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                routeManager = this;
                                routeSelectedState = value;
                            }
                        }
                    }
                    RouteDirection flip2 = value.getSelectedRouteDirection().flip();
                    routeManager$flipDirection$1.L$0 = this;
                    routeManager$flipDirection$1.L$1 = value;
                    routeManager$flipDirection$1.label = 1;
                    if (onDirectionChanged(flip2, routeManager$flipDirection$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    routeManager = this;
                    routeSelectedState = value;
                } else {
                    if (i5 != 1 && i5 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    routeSelectedState = (RouteSelectedState) routeManager$flipDirection$1.L$1;
                    routeManager = (RouteManager) routeManager$flipDirection$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                routeManager.updateDepartureDirection(DepartureDirection.Outbound, null);
                routeManager.analyticsTracker.trackEvent(new AnalyticsEvent.ChangeRouteDirectionEvent(HarborExtensionsKt.harborName(routeSelectedState.getSelectedRouteDirectionGroup().getDepartureHarbor(), routeSelectedState.getSelectedRouteDirectionGroup().getUseRegionsAsHarbors()), HarborExtensionsKt.harborName(routeSelectedState.getSelectedRouteDirectionGroup().getArrivalHarbor(), routeSelectedState.getSelectedRouteDirectionGroup().getUseRegionsAsHarbors())));
                return Unit.INSTANCE;
            }
        }
        routeManager$flipDirection$1 = new RouteManager$flipDirection$1(this, continuation);
        Object obj2 = routeManager$flipDirection$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = routeManager$flipDirection$1.label;
        if (i5 != 0) {
        }
        routeManager.updateDepartureDirection(DepartureDirection.Outbound, null);
        routeManager.analyticsTracker.trackEvent(new AnalyticsEvent.ChangeRouteDirectionEvent(HarborExtensionsKt.harborName(routeSelectedState.getSelectedRouteDirectionGroup().getDepartureHarbor(), routeSelectedState.getSelectedRouteDirectionGroup().getUseRegionsAsHarbors()), HarborExtensionsKt.harborName(routeSelectedState.getSelectedRouteDirectionGroup().getArrivalHarbor(), routeSelectedState.getSelectedRouteDirectionGroup().getUseRegionsAsHarbors())));
        return Unit.INSTANCE;
    }

    @Override // dk.molslinjen.domain.managers.route.IRouteManager
    public TransportationSelectionModel getTransportationSelectionModel() {
        Route selectedRoute;
        String id;
        MultiRideBookingData multiRideBookingData;
        CommuterBookingData commuterBookingData;
        RouteState value = getRouteState().getValue();
        if (value == null) {
            return new TransportationSelectionModel(null, null, 3, null);
        }
        RouteSharedSelectedState value2 = getSharedSelectedState().getValue();
        if (value2 == null || (selectedRoute = value2.getSelectedRoute()) == null || (id = selectedRoute.getId()) == null) {
            return new TransportationSelectionModel(null, null, 3, null);
        }
        RouteSharedSelectedState value3 = getSharedSelectedState().getValue();
        String transportationId = (value3 == null || (commuterBookingData = value3.getCommuterBookingData()) == null) ? null : commuterBookingData.getTransportationId();
        RouteSharedSelectedState value4 = getSharedSelectedState().getValue();
        List<String> transportationIds = (value4 == null || (multiRideBookingData = value4.getMultiRideBookingData()) == null) ? null : multiRideBookingData.getTransportationIds();
        if (transportationId != null) {
            List<Transportation> transportations = value.getConfiguration().getTransportations();
            ArrayList arrayList = new ArrayList();
            for (Object obj : transportations) {
                if (Intrinsics.areEqual(((Transportation) obj).getId(), transportationId)) {
                    arrayList.add(obj);
                }
            }
            return new TransportationSelectionModel(arrayList, null, 2, null);
        }
        if (transportationIds != null) {
            List<Transportation> transportations2 = value.getConfiguration().getTransportations();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : transportations2) {
                if (transportationIds.contains(((Transportation) obj2).getId())) {
                    arrayList2.add(obj2);
                }
            }
            return new TransportationSelectionModel(arrayList2, null, 2, null);
        }
        List<TransportationCategory> transportationCategories = value.getConfiguration().getTransportationCategories();
        ArrayList<TransportationCategory> arrayList3 = new ArrayList();
        for (Object obj3 : transportationCategories) {
            TransportationCategory transportationCategory = (TransportationCategory) obj3;
            if (transportationCategory.getAllowedRouteIds().contains(id) && (getBookingTypeState().getValue() == BookingType.TwoWay || !transportationCategory.isOnlyAvailableWithReturnTicket())) {
                arrayList3.add(obj3);
            }
        }
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        for (TransportationCategory transportationCategory2 : arrayList3) {
            List<Transportation> transportations3 = transportationCategory2.getTransportations();
            ArrayList arrayList5 = new ArrayList();
            for (Object obj4 : transportations3) {
                Transportation transportation = (Transportation) obj4;
                if (transportation.getAllowedRouteIds().contains(id) && (getBookingTypeState().getValue() == BookingType.TwoWay || !transportation.isOnlyAvailableWithReturnTicket())) {
                    arrayList5.add(obj4);
                }
            }
            arrayList4.add(TransportationCategory.copy$default(transportationCategory2, null, false, null, arrayList5, 7, null));
        }
        return new TransportationSelectionModel(null, arrayList4, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x007a A[PHI: r7
      0x007a: PHI (r7v13 java.lang.Object) = (r7v12 java.lang.Object), (r7v1 java.lang.Object) binds: [B:17:0x0077, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0079 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.managers.route.IRouteManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadTrailers(Continuation<? super ManagerResult<? extends List<TrailerProduct>>> continuation) {
        RouteManager$loadTrailers$1 routeManager$loadTrailers$1;
        int i5;
        if (continuation instanceof RouteManager$loadTrailers$1) {
            routeManager$loadTrailers$1 = (RouteManager$loadTrailers$1) continuation;
            int i6 = routeManager$loadTrailers$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                routeManager$loadTrailers$1.label = i6 - Integer.MIN_VALUE;
                Object obj = routeManager$loadTrailers$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = routeManager$loadTrailers$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    RouteSharedSelectedState value = getSharedSelectedState().getValue();
                    if (value == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    String id = value.getSelectedTransportation().getId();
                    IBookingService iBookingService = this.bookingService;
                    SiteDTO dto = value.getSite().toDTO();
                    routeManager$loadTrailers$1.label = 1;
                    obj = iBookingService.getTrailers(id, dto, routeManager$loadTrailers$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                RouteManager$loadTrailers$2 routeManager$loadTrailers$2 = new RouteManager$loadTrailers$2(null);
                routeManager$loadTrailers$1.label = 2;
                obj = ApiResultExtensionsKt.mapToManagerResult((ApiResult) obj, routeManager$loadTrailers$2, routeManager$loadTrailers$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        routeManager$loadTrailers$1 = new RouteManager$loadTrailers$1(this, continuation);
        Object obj2 = routeManager$loadTrailers$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = routeManager$loadTrailers$1.label;
        if (i5 != 0) {
        }
        RouteManager$loadTrailers$2 routeManager$loadTrailers$22 = new RouteManager$loadTrailers$2(null);
        routeManager$loadTrailers$1.label = 2;
        obj2 = ApiResultExtensionsKt.mapToManagerResult((ApiResult) obj2, routeManager$loadTrailers$22, routeManager$loadTrailers$1);
        if (obj2 != coroutine_suspended2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    @Override // dk.molslinjen.domain.managers.route.IRouteManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadTransportProducts(String str, Continuation<? super ManagerResult<Unit>> continuation) {
        RouteManager$loadTransportProducts$1 routeManager$loadTransportProducts$1;
        int i5;
        RouteSharedSelectedState value;
        RouteState value2;
        RouteState routeState;
        RouteManager routeManager;
        ManagerResult managerResult;
        MutableStateFlow<RouteState> routeState2;
        RouteState value3;
        RouteState routeState3;
        if (continuation instanceof RouteManager$loadTransportProducts$1) {
            routeManager$loadTransportProducts$1 = (RouteManager$loadTransportProducts$1) continuation;
            int i6 = routeManager$loadTransportProducts$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                routeManager$loadTransportProducts$1.label = i6 - Integer.MIN_VALUE;
                RouteManager$loadTransportProducts$1 routeManager$loadTransportProducts$12 = routeManager$loadTransportProducts$1;
                Object obj = routeManager$loadTransportProducts$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = routeManager$loadTransportProducts$12.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    RouteSelectedState value4 = getActiveSelectedState().getValue();
                    if (value4 != null && (value = getSharedSelectedState().getValue()) != null) {
                        MutableStateFlow<RouteState> routeState4 = getRouteState();
                        do {
                            value2 = routeState4.getValue();
                            routeState = value2;
                        } while (!routeState4.compareAndSet(value2, routeState != null ? RouteState.copy$default(routeState, null, null, null, 3, null) : null));
                        IBookingService iBookingService = this.bookingService;
                        String mainRouteId = value4.getSelectedRouteDirectionGroup().getMainRouteId();
                        String id = value.getSelectedRoute().getUsesRegions() ? value4.getSelectedRouteDirectionGroup().getDepartureHarbor().getRegion().getId() : null;
                        String id2 = value.getSelectedRoute().getUsesRegions() ? value4.getSelectedRouteDirectionGroup().getArrivalHarbor().getRegion().getId() : null;
                        SiteDTO dto = value.getSite().toDTO();
                        CurrencyTypeDTO dto2 = value.getCurrency().toDTO();
                        routeManager$loadTransportProducts$12.L$0 = this;
                        routeManager$loadTransportProducts$12.label = 1;
                        obj = iBookingService.getTransportProducts(str, mainRouteId, id, id2, dto, dto2, routeManager$loadTransportProducts$12);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        routeManager = this;
                    }
                    return ManagerResult.Error.INSTANCE.noMessage();
                }
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                routeManager = (RouteManager) routeManager$loadTransportProducts$12.L$0;
                ResultKt.throwOnFailure(obj);
                managerResult = ManagerResultExtensionsKt.toManagerResult((ApiResult) obj, new Function1() { // from class: E1.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        TransportProducts loadTransportProducts$lambda$40;
                        loadTransportProducts$lambda$40 = RouteManager.loadTransportProducts$lambda$40((TransportProductsResponseDTO) obj2);
                        return loadTransportProducts$lambda$40;
                    }
                });
                routeState2 = routeManager.getRouteState();
                do {
                    value3 = routeState2.getValue();
                    routeState3 = value3;
                } while (!routeState2.compareAndSet(value3, routeState3 == null ? RouteState.copy$default(routeState3, null, null, managerResult, 3, null) : null));
                return ManagerResultExtensionsKt.toUnitManagerResult(managerResult);
            }
        }
        routeManager$loadTransportProducts$1 = new RouteManager$loadTransportProducts$1(this, continuation);
        RouteManager$loadTransportProducts$1 routeManager$loadTransportProducts$122 = routeManager$loadTransportProducts$1;
        Object obj2 = routeManager$loadTransportProducts$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = routeManager$loadTransportProducts$122.label;
        if (i5 != 0) {
        }
        managerResult = ManagerResultExtensionsKt.toManagerResult((ApiResult) obj2, new Function1() { // from class: E1.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj22) {
                TransportProducts loadTransportProducts$lambda$40;
                loadTransportProducts$lambda$40 = RouteManager.loadTransportProducts$lambda$40((TransportProductsResponseDTO) obj22);
                return loadTransportProducts$lambda$40;
            }
        });
        routeState2 = routeManager.getRouteState();
        do {
            value3 = routeState2.getValue();
            routeState3 = value3;
        } while (!routeState2.compareAndSet(value3, routeState3 == null ? RouteState.copy$default(routeState3, null, null, managerResult, 3, null) : null));
        return ManagerResultExtensionsKt.toUnitManagerResult(managerResult);
    }

    @Override // dk.molslinjen.domain.managers.route.IRouteManager
    public List<Map.Entry<String, Integer>> purchaseCountPerCityId() {
        Set entrySet = ((Map) this.settings.latestValueFor(SettingsProperty.Tracking.PurchaseCountPerCityId.INSTANCE)).entrySet();
        final Comparator comparator = new Comparator() { // from class: dk.molslinjen.domain.managers.route.RouteManager$purchaseCountPerCityId$$inlined$compareBy$1
            @Override // java.util.Comparator
            public final int compare(T t5, T t6) {
                return ComparisonsKt.compareValues((Comparable) ((Map.Entry) t5).getValue(), (Comparable) ((Map.Entry) t6).getValue());
            }
        };
        return CollectionsKt.sortedWith(entrySet, new Comparator() { // from class: dk.molslinjen.domain.managers.route.RouteManager$purchaseCountPerCityId$$inlined$thenBy$1
            @Override // java.util.Comparator
            public final int compare(T t5, T t6) {
                int compare = comparator.compare(t5, t6);
                return compare != 0 ? compare : ComparisonsKt.compareValues((Comparable) ((Map.Entry) t5).getKey(), (Comparable) ((Map.Entry) t6).getKey());
            }
        });
    }

    @Override // dk.molslinjen.domain.managers.route.IRouteManager
    public void reload() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new RouteManager$reload$1(this, null), 3, null);
    }

    @Override // dk.molslinjen.domain.managers.route.IRouteManager
    public void removeAllSelectedTransportProducts(boolean onlyActiveDirection) {
        RouteSelectedState value;
        RouteSelectedState routeSelectedState;
        RouteSelectedState value2;
        RouteSelectedState routeSelectedState2;
        List<Product> selectedTransportProducts;
        RouteSelectedState value3 = getActiveSelectedState().getValue();
        boolean z5 = (value3 == null || (selectedTransportProducts = value3.getSelectedTransportProducts()) == null) ? false : !selectedTransportProducts.isEmpty();
        MutableStateFlow<RouteSelectedState> activeSelectedState = getActiveSelectedState();
        do {
            value = activeSelectedState.getValue();
            routeSelectedState = value;
        } while (!activeSelectedState.compareAndSet(value, routeSelectedState != null ? RouteSelectedState.copy$default(routeSelectedState, null, null, null, null, null, null, CollectionsKt.emptyList(), 63, null) : null));
        if (onlyActiveDirection) {
            return;
        }
        MutableStateFlow<RouteSelectedState> inactiveSelectedState = getInactiveSelectedState();
        do {
            value2 = inactiveSelectedState.getValue();
            routeSelectedState2 = value2;
        } while (!inactiveSelectedState.compareAndSet(value2, routeSelectedState2 != null ? RouteSelectedState.copy$default(routeSelectedState2, null, null, null, null, null, null, CollectionsKt.emptyList(), 63, null) : null));
        resetDirectionIfOnReturnTab(false, z5);
    }

    @Override // dk.molslinjen.domain.managers.route.IRouteManager
    public void removeSelectedTrailer(boolean onlyActiveDirection) {
        RouteSelectedState value;
        RouteSelectedState routeSelectedState;
        RouteSelectedState value2;
        RouteSelectedState routeSelectedState2;
        RouteSelectedState value3 = getActiveSelectedState().getValue();
        boolean z5 = (value3 != null ? value3.getSelectedTrailer() : null) != null;
        MutableStateFlow<RouteSelectedState> activeSelectedState = getActiveSelectedState();
        do {
            value = activeSelectedState.getValue();
            routeSelectedState = value;
        } while (!activeSelectedState.compareAndSet(value, routeSelectedState != null ? RouteSelectedState.copy$default(routeSelectedState, null, null, null, null, null, null, null, 119, null) : null));
        if (onlyActiveDirection) {
            return;
        }
        MutableStateFlow<RouteSelectedState> inactiveSelectedState = getInactiveSelectedState();
        do {
            value2 = inactiveSelectedState.getValue();
            routeSelectedState2 = value2;
        } while (!inactiveSelectedState.compareAndSet(value2, routeSelectedState2 != null ? RouteSelectedState.copy$default(routeSelectedState2, null, null, null, null, null, null, null, 119, null) : null));
        resetDirectionIfOnReturnTab(false, z5);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0029. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0204 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01ed A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01d4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01bc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0258 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0239 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x021b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    @Override // dk.molslinjen.domain.managers.route.IRouteManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object selectRoute(Site site, Route route, RouteDirection routeDirection, String str, Continuation<? super Unit> continuation) {
        RouteManager$selectRoute$1 routeManager$selectRoute$1;
        RouteManager$selectRoute$1 routeManager$selectRoute$12;
        RouteDirection routeDirection2;
        RouteManager routeManager;
        Site site2;
        Route route2;
        String str2;
        RouteManager routeManager2;
        Object obj;
        RouteDirection routeDirection3;
        Route selectedRoute;
        RouteSharedSelectedState value;
        RouteDirection routeDirection4;
        Route route3;
        String str3;
        RouteDirection routeDirection5;
        Route route4;
        String str4;
        LocalizedSiteConfiguration localizedSiteConfiguration;
        RouteState value2;
        RouteState routeState;
        String str5;
        Route route5;
        RouteManager routeManager3;
        Route route6;
        RouteManager routeManager4;
        ISettings iSettings;
        SettingsProperty.Departures.CurrentRouteId currentRouteId;
        String id;
        ISettings iSettings2;
        SettingsProperty.Departures.CurrentDirection currentDirection;
        Route route7;
        RouteManager routeManager5;
        ISettings iSettings3;
        SettingsProperty.Departures.CurrentTransportationId currentTransportationId;
        Route route8;
        RouteManager routeManager6;
        ISettings iSettings4;
        SettingsProperty.Departures.CurrentTransportationInfo currentTransportationInfo;
        if (continuation instanceof RouteManager$selectRoute$1) {
            routeManager$selectRoute$1 = (RouteManager$selectRoute$1) continuation;
            int i5 = routeManager$selectRoute$1.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                routeManager$selectRoute$1.label = i5 - Integer.MIN_VALUE;
                routeManager$selectRoute$12 = routeManager$selectRoute$1;
                Object obj2 = routeManager$selectRoute$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (routeManager$selectRoute$12.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj2);
                        if (Feature.RoutesFromMultipleSites.isEnabled()) {
                            IConfigurationManager iConfigurationManager = this.configurationManager;
                            routeManager$selectRoute$12.L$0 = this;
                            routeManager$selectRoute$12.L$1 = site;
                            routeManager$selectRoute$12.L$2 = route;
                            routeManager$selectRoute$12.L$3 = routeDirection;
                            routeManager$selectRoute$12.L$4 = str;
                            routeManager$selectRoute$12.label = 1;
                            Object activeConfiguration = iConfigurationManager.getActiveConfiguration(site, routeManager$selectRoute$12);
                            if (activeConfiguration == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            routeManager2 = this;
                            site2 = site;
                            obj = activeConfiguration;
                            routeDirection3 = routeDirection;
                            route2 = route;
                            str2 = str;
                            localizedSiteConfiguration = (LocalizedSiteConfiguration) obj;
                            if (localizedSiteConfiguration != null) {
                                return Unit.INSTANCE;
                            }
                            MutableStateFlow<RouteState> routeState2 = routeManager2.getRouteState();
                            do {
                                value2 = routeState2.getValue();
                                routeState = value2;
                            } while (!routeState2.compareAndSet(value2, routeState != null ? RouteState.copy$default(routeState, null, localizedSiteConfiguration, null, 5, null) : null));
                            routeDirection2 = routeDirection3;
                            routeManager = routeManager2;
                            RouteSharedSelectedState value3 = routeManager.getSharedSelectedState().getValue();
                            selectedRoute = value3 == null ? value3.getSelectedRoute() : null;
                            value = routeManager.getSharedSelectedState().getValue();
                            if ((value == null ? value.getMultiRideBookingData() : null) == null) {
                                if ((value != null ? value.getCommuterBookingData() : null) == null) {
                                    ISettings iSettings5 = routeManager.settings;
                                    SettingsProperty.Departures.CurrentSite currentSite = SettingsProperty.Departures.CurrentSite.INSTANCE;
                                    routeManager$selectRoute$12.L$0 = routeManager;
                                    routeManager$selectRoute$12.L$1 = route2;
                                    routeManager$selectRoute$12.L$2 = routeDirection2;
                                    routeManager$selectRoute$12.L$3 = str2;
                                    routeManager$selectRoute$12.L$4 = selectedRoute;
                                    routeManager$selectRoute$12.label = 5;
                                    if (iSettings5.update(currentSite, site2, routeManager$selectRoute$12) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    routeDirection5 = routeDirection2;
                                    route4 = route2;
                                    str4 = str2;
                                    iSettings = routeManager.settings;
                                    currentRouteId = SettingsProperty.Departures.CurrentRouteId.INSTANCE;
                                    id = route4.getId();
                                    routeManager$selectRoute$12.L$0 = routeManager;
                                    routeManager$selectRoute$12.L$1 = route4;
                                    routeManager$selectRoute$12.L$2 = routeDirection5;
                                    routeManager$selectRoute$12.L$3 = str4;
                                    routeManager$selectRoute$12.L$4 = selectedRoute;
                                    routeManager$selectRoute$12.label = 6;
                                    if (iSettings.update(currentRouteId, id, routeManager$selectRoute$12) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    iSettings2 = routeManager.settings;
                                    currentDirection = SettingsProperty.Departures.CurrentDirection.INSTANCE;
                                    routeManager$selectRoute$12.L$0 = routeManager;
                                    routeManager$selectRoute$12.L$1 = route4;
                                    routeManager$selectRoute$12.L$2 = str4;
                                    routeManager$selectRoute$12.L$3 = selectedRoute;
                                    routeManager$selectRoute$12.L$4 = null;
                                    routeManager$selectRoute$12.label = 7;
                                    if (iSettings2.update(currentDirection, routeDirection5, routeManager$selectRoute$12) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    route7 = route4;
                                    routeManager5 = routeManager;
                                    iSettings3 = routeManager5.settings;
                                    currentTransportationId = SettingsProperty.Departures.CurrentTransportationId.INSTANCE;
                                    routeManager$selectRoute$12.L$0 = routeManager5;
                                    routeManager$selectRoute$12.L$1 = route7;
                                    routeManager$selectRoute$12.L$2 = selectedRoute;
                                    routeManager$selectRoute$12.L$3 = null;
                                    routeManager$selectRoute$12.label = 8;
                                    if (iSettings3.update(currentTransportationId, str4, routeManager$selectRoute$12) != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    route8 = route7;
                                    routeManager6 = routeManager5;
                                    iSettings4 = routeManager6.settings;
                                    currentTransportationInfo = SettingsProperty.Departures.CurrentTransportationInfo.INSTANCE;
                                    routeManager$selectRoute$12.L$0 = routeManager6;
                                    routeManager$selectRoute$12.L$1 = route8;
                                    routeManager$selectRoute$12.L$2 = selectedRoute;
                                    routeManager$selectRoute$12.label = 9;
                                    if (iSettings4.update(currentTransportationInfo, null, routeManager$selectRoute$12) != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    route6 = route8;
                                    routeManager4 = routeManager6;
                                    routeManager4.analyticsTracker.trackEvent(new AnalyticsEvent.ChangeRouteEvent(selectedRoute, route6));
                                    return Unit.INSTANCE;
                                }
                            }
                            routeManager$selectRoute$12.L$0 = routeManager;
                            routeManager$selectRoute$12.L$1 = route2;
                            routeManager$selectRoute$12.L$2 = routeDirection2;
                            routeManager$selectRoute$12.L$3 = str2;
                            routeManager$selectRoute$12.L$4 = selectedRoute;
                            routeManager$selectRoute$12.label = 2;
                            if (routeManager.setSiteInternal(site2, routeManager$selectRoute$12) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            routeDirection4 = routeDirection2;
                            route3 = route2;
                            str3 = str2;
                            routeManager.setRouteInternal(route3.getId());
                            routeManager$selectRoute$12.L$0 = routeManager;
                            routeManager$selectRoute$12.L$1 = route3;
                            routeManager$selectRoute$12.L$2 = str3;
                            routeManager$selectRoute$12.L$3 = selectedRoute;
                            routeManager$selectRoute$12.L$4 = null;
                            routeManager$selectRoute$12.label = 3;
                            if (routeManager.onDirectionChanged(routeDirection4, routeManager$selectRoute$12) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            str5 = str3;
                            route5 = route3;
                            routeManager3 = routeManager;
                            routeManager$selectRoute$12.L$0 = routeManager3;
                            routeManager$selectRoute$12.L$1 = route5;
                            routeManager$selectRoute$12.L$2 = selectedRoute;
                            routeManager$selectRoute$12.L$3 = null;
                            routeManager$selectRoute$12.label = 4;
                            if (IRouteManager.DefaultImpls.setTransportation$default(routeManager3, str5, null, null, routeManager$selectRoute$12, 6, null) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            route6 = route5;
                            routeManager4 = routeManager3;
                            routeManager4.analyticsTracker.trackEvent(new AnalyticsEvent.ChangeRouteEvent(selectedRoute, route6));
                            return Unit.INSTANCE;
                        }
                        routeDirection2 = routeDirection;
                        routeManager = this;
                        site2 = site;
                        route2 = route;
                        str2 = str;
                        RouteSharedSelectedState value32 = routeManager.getSharedSelectedState().getValue();
                        if (value32 == null) {
                        }
                        value = routeManager.getSharedSelectedState().getValue();
                        if ((value == null ? value.getMultiRideBookingData() : null) == null) {
                        }
                        routeManager$selectRoute$12.L$0 = routeManager;
                        routeManager$selectRoute$12.L$1 = route2;
                        routeManager$selectRoute$12.L$2 = routeDirection2;
                        routeManager$selectRoute$12.L$3 = str2;
                        routeManager$selectRoute$12.L$4 = selectedRoute;
                        routeManager$selectRoute$12.label = 2;
                        if (routeManager.setSiteInternal(site2, routeManager$selectRoute$12) != coroutine_suspended) {
                        }
                    case 1:
                        String str6 = (String) routeManager$selectRoute$12.L$4;
                        RouteDirection routeDirection6 = (RouteDirection) routeManager$selectRoute$12.L$3;
                        Route route9 = (Route) routeManager$selectRoute$12.L$2;
                        Site site3 = (Site) routeManager$selectRoute$12.L$1;
                        RouteManager routeManager7 = (RouteManager) routeManager$selectRoute$12.L$0;
                        ResultKt.throwOnFailure(obj2);
                        route2 = route9;
                        site2 = site3;
                        routeManager2 = routeManager7;
                        routeDirection3 = routeDirection6;
                        str2 = str6;
                        obj = obj2;
                        localizedSiteConfiguration = (LocalizedSiteConfiguration) obj;
                        if (localizedSiteConfiguration != null) {
                        }
                        break;
                    case 2:
                        selectedRoute = (Route) routeManager$selectRoute$12.L$4;
                        str3 = (String) routeManager$selectRoute$12.L$3;
                        routeDirection4 = (RouteDirection) routeManager$selectRoute$12.L$2;
                        route3 = (Route) routeManager$selectRoute$12.L$1;
                        routeManager = (RouteManager) routeManager$selectRoute$12.L$0;
                        ResultKt.throwOnFailure(obj2);
                        routeManager.setRouteInternal(route3.getId());
                        routeManager$selectRoute$12.L$0 = routeManager;
                        routeManager$selectRoute$12.L$1 = route3;
                        routeManager$selectRoute$12.L$2 = str3;
                        routeManager$selectRoute$12.L$3 = selectedRoute;
                        routeManager$selectRoute$12.L$4 = null;
                        routeManager$selectRoute$12.label = 3;
                        if (routeManager.onDirectionChanged(routeDirection4, routeManager$selectRoute$12) != coroutine_suspended) {
                        }
                        break;
                    case 3:
                        selectedRoute = (Route) routeManager$selectRoute$12.L$3;
                        String str7 = (String) routeManager$selectRoute$12.L$2;
                        Route route10 = (Route) routeManager$selectRoute$12.L$1;
                        RouteManager routeManager8 = (RouteManager) routeManager$selectRoute$12.L$0;
                        ResultKt.throwOnFailure(obj2);
                        route5 = route10;
                        routeManager3 = routeManager8;
                        str5 = str7;
                        routeManager$selectRoute$12.L$0 = routeManager3;
                        routeManager$selectRoute$12.L$1 = route5;
                        routeManager$selectRoute$12.L$2 = selectedRoute;
                        routeManager$selectRoute$12.L$3 = null;
                        routeManager$selectRoute$12.label = 4;
                        if (IRouteManager.DefaultImpls.setTransportation$default(routeManager3, str5, null, null, routeManager$selectRoute$12, 6, null) != coroutine_suspended) {
                        }
                        break;
                    case 4:
                    case 9:
                        selectedRoute = (Route) routeManager$selectRoute$12.L$2;
                        route6 = (Route) routeManager$selectRoute$12.L$1;
                        routeManager4 = (RouteManager) routeManager$selectRoute$12.L$0;
                        ResultKt.throwOnFailure(obj2);
                        routeManager4.analyticsTracker.trackEvent(new AnalyticsEvent.ChangeRouteEvent(selectedRoute, route6));
                        return Unit.INSTANCE;
                    case 5:
                        selectedRoute = (Route) routeManager$selectRoute$12.L$4;
                        str4 = (String) routeManager$selectRoute$12.L$3;
                        routeDirection5 = (RouteDirection) routeManager$selectRoute$12.L$2;
                        route4 = (Route) routeManager$selectRoute$12.L$1;
                        routeManager = (RouteManager) routeManager$selectRoute$12.L$0;
                        ResultKt.throwOnFailure(obj2);
                        iSettings = routeManager.settings;
                        currentRouteId = SettingsProperty.Departures.CurrentRouteId.INSTANCE;
                        id = route4.getId();
                        routeManager$selectRoute$12.L$0 = routeManager;
                        routeManager$selectRoute$12.L$1 = route4;
                        routeManager$selectRoute$12.L$2 = routeDirection5;
                        routeManager$selectRoute$12.L$3 = str4;
                        routeManager$selectRoute$12.L$4 = selectedRoute;
                        routeManager$selectRoute$12.label = 6;
                        if (iSettings.update(currentRouteId, id, routeManager$selectRoute$12) == coroutine_suspended) {
                        }
                        iSettings2 = routeManager.settings;
                        currentDirection = SettingsProperty.Departures.CurrentDirection.INSTANCE;
                        routeManager$selectRoute$12.L$0 = routeManager;
                        routeManager$selectRoute$12.L$1 = route4;
                        routeManager$selectRoute$12.L$2 = str4;
                        routeManager$selectRoute$12.L$3 = selectedRoute;
                        routeManager$selectRoute$12.L$4 = null;
                        routeManager$selectRoute$12.label = 7;
                        if (iSettings2.update(currentDirection, routeDirection5, routeManager$selectRoute$12) == coroutine_suspended) {
                        }
                        break;
                    case 6:
                        selectedRoute = (Route) routeManager$selectRoute$12.L$4;
                        str4 = (String) routeManager$selectRoute$12.L$3;
                        routeDirection5 = (RouteDirection) routeManager$selectRoute$12.L$2;
                        route4 = (Route) routeManager$selectRoute$12.L$1;
                        routeManager = (RouteManager) routeManager$selectRoute$12.L$0;
                        ResultKt.throwOnFailure(obj2);
                        iSettings2 = routeManager.settings;
                        currentDirection = SettingsProperty.Departures.CurrentDirection.INSTANCE;
                        routeManager$selectRoute$12.L$0 = routeManager;
                        routeManager$selectRoute$12.L$1 = route4;
                        routeManager$selectRoute$12.L$2 = str4;
                        routeManager$selectRoute$12.L$3 = selectedRoute;
                        routeManager$selectRoute$12.L$4 = null;
                        routeManager$selectRoute$12.label = 7;
                        if (iSettings2.update(currentDirection, routeDirection5, routeManager$selectRoute$12) == coroutine_suspended) {
                        }
                        break;
                    case 7:
                        selectedRoute = (Route) routeManager$selectRoute$12.L$3;
                        str4 = (String) routeManager$selectRoute$12.L$2;
                        route7 = (Route) routeManager$selectRoute$12.L$1;
                        routeManager5 = (RouteManager) routeManager$selectRoute$12.L$0;
                        ResultKt.throwOnFailure(obj2);
                        iSettings3 = routeManager5.settings;
                        currentTransportationId = SettingsProperty.Departures.CurrentTransportationId.INSTANCE;
                        routeManager$selectRoute$12.L$0 = routeManager5;
                        routeManager$selectRoute$12.L$1 = route7;
                        routeManager$selectRoute$12.L$2 = selectedRoute;
                        routeManager$selectRoute$12.L$3 = null;
                        routeManager$selectRoute$12.label = 8;
                        if (iSettings3.update(currentTransportationId, str4, routeManager$selectRoute$12) != coroutine_suspended) {
                        }
                        break;
                    case 8:
                        selectedRoute = (Route) routeManager$selectRoute$12.L$2;
                        route8 = (Route) routeManager$selectRoute$12.L$1;
                        routeManager6 = (RouteManager) routeManager$selectRoute$12.L$0;
                        ResultKt.throwOnFailure(obj2);
                        iSettings4 = routeManager6.settings;
                        currentTransportationInfo = SettingsProperty.Departures.CurrentTransportationInfo.INSTANCE;
                        routeManager$selectRoute$12.L$0 = routeManager6;
                        routeManager$selectRoute$12.L$1 = route8;
                        routeManager$selectRoute$12.L$2 = selectedRoute;
                        routeManager$selectRoute$12.label = 9;
                        if (iSettings4.update(currentTransportationInfo, null, routeManager$selectRoute$12) != coroutine_suspended) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        routeManager$selectRoute$1 = new RouteManager$selectRoute$1(this, continuation);
        routeManager$selectRoute$12 = routeManager$selectRoute$1;
        Object obj22 = routeManager$selectRoute$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (routeManager$selectRoute$12.label) {
        }
    }

    @Override // dk.molslinjen.domain.managers.route.IRouteManager
    public void setTrailer(TrailerProduct outboundTrailer, TrailerProduct returnTrailer, boolean isAddingReturnFromBookingSummary) {
        TrailerProduct trailerProduct;
        TrailerProduct trailerProduct2;
        RouteSelectedState value;
        RouteSelectedState routeSelectedState;
        RouteSelectedState value2;
        RouteSelectedState routeSelectedState2;
        RouteSelectedState value3 = getOutboundSelectedState().getValue();
        if (value3 != null) {
            trailerProduct2 = value3.getSelectedTrailer();
            trailerProduct = outboundTrailer;
        } else {
            trailerProduct = outboundTrailer;
            trailerProduct2 = null;
        }
        boolean z5 = !Intrinsics.areEqual(trailerProduct, trailerProduct2);
        MutableStateFlow<RouteSelectedState> outboundSelectedState = getOutboundSelectedState();
        do {
            value = outboundSelectedState.getValue();
            routeSelectedState = value;
        } while (!outboundSelectedState.compareAndSet(value, routeSelectedState != null ? RouteSelectedState.copy$default(routeSelectedState, null, null, null, outboundTrailer, null, null, null, 119, null) : null));
        MutableStateFlow<RouteSelectedState> returnSelectedState = getReturnSelectedState();
        do {
            value2 = returnSelectedState.getValue();
            routeSelectedState2 = value2;
        } while (!returnSelectedState.compareAndSet(value2, routeSelectedState2 != null ? RouteSelectedState.copy$default(routeSelectedState2, null, null, null, returnTrailer, null, null, null, 119, null) : null));
        resetDirectionIfOnReturnTab(isAddingReturnFromBookingSummary, z5);
    }

    @Override // dk.molslinjen.domain.managers.route.IRouteManager
    public void setTransportProducts(List<? extends Product> outboundProducts, List<? extends Product> returnProducts, boolean isAddingReturnFromBookingSummary) {
        RouteSelectedState value;
        RouteSelectedState routeSelectedState;
        RouteSelectedState value2;
        RouteSelectedState routeSelectedState2;
        Intrinsics.checkNotNullParameter(outboundProducts, "outboundProducts");
        Intrinsics.checkNotNullParameter(returnProducts, "returnProducts");
        RouteSelectedState value3 = getOutboundSelectedState().getValue();
        boolean z5 = !Intrinsics.areEqual(outboundProducts, value3 != null ? value3.getSelectedTransportProducts() : null);
        MutableStateFlow<RouteSelectedState> outboundSelectedState = getOutboundSelectedState();
        do {
            value = outboundSelectedState.getValue();
            routeSelectedState = value;
        } while (!outboundSelectedState.compareAndSet(value, routeSelectedState != null ? RouteSelectedState.copy$default(routeSelectedState, null, null, null, null, null, null, outboundProducts, 63, null) : null));
        MutableStateFlow<RouteSelectedState> returnSelectedState = getReturnSelectedState();
        do {
            value2 = returnSelectedState.getValue();
            routeSelectedState2 = value2;
        } while (!returnSelectedState.compareAndSet(value2, routeSelectedState2 != null ? RouteSelectedState.copy$default(routeSelectedState2, null, null, null, null, null, null, returnProducts, 63, null) : null));
        resetDirectionIfOnReturnTab(isAddingReturnFromBookingSummary, z5);
    }

    @Override // dk.molslinjen.domain.managers.route.IRouteManager
    public Object setTransportation(Transportation transportation, Continuation<? super Unit> continuation) {
        Object transportation$default = IRouteManager.DefaultImpls.setTransportation$default(this, transportation.getId(), null, null, continuation, 4, null);
        return transportation$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? transportation$default : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002d  */
    @Override // dk.molslinjen.domain.managers.route.IRouteManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object setupForCommuter(CommuterBookingData commuterBookingData, Site site, Continuation<? super Unit> continuation) {
        RouteManager$setupForCommuter$1 routeManager$setupForCommuter$1;
        int i5;
        Site site2;
        CommuterBookingData commuterBookingData2;
        RouteManager routeManager;
        LocalizedSiteConfiguration localizedSiteConfiguration;
        boolean z5;
        if (continuation instanceof RouteManager$setupForCommuter$1) {
            routeManager$setupForCommuter$1 = (RouteManager$setupForCommuter$1) continuation;
            int i6 = routeManager$setupForCommuter$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                routeManager$setupForCommuter$1.label = i6 - Integer.MIN_VALUE;
                RouteManager$setupForCommuter$1 routeManager$setupForCommuter$12 = routeManager$setupForCommuter$1;
                Object obj = routeManager$setupForCommuter$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = routeManager$setupForCommuter$12.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IConfigurationManager iConfigurationManager = this.configurationManager;
                    routeManager$setupForCommuter$12.L$0 = this;
                    routeManager$setupForCommuter$12.L$1 = commuterBookingData;
                    routeManager$setupForCommuter$12.L$2 = site;
                    routeManager$setupForCommuter$12.label = 1;
                    obj = iConfigurationManager.getActiveConfiguration(site, routeManager$setupForCommuter$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    site2 = site;
                    commuterBookingData2 = commuterBookingData;
                    routeManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        routeManager = (RouteManager) routeManager$setupForCommuter$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        z5 = false;
                        routeManager.analyticsTracker.updateBookingTypeStateTracking(z5, AnalyticsStateTrackingHelper.BookingFlowTypeTracking.CommuteTicket);
                        return Unit.INSTANCE;
                    }
                    Site site3 = (Site) routeManager$setupForCommuter$12.L$2;
                    CommuterBookingData commuterBookingData3 = (CommuterBookingData) routeManager$setupForCommuter$12.L$1;
                    RouteManager routeManager2 = (RouteManager) routeManager$setupForCommuter$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    commuterBookingData2 = commuterBookingData3;
                    site2 = site3;
                    routeManager = routeManager2;
                }
                localizedSiteConfiguration = (LocalizedSiteConfiguration) obj;
                if (localizedSiteConfiguration != null) {
                    return Unit.INSTANCE;
                }
                String id = ((Route) CollectionsKt.first((List) localizedSiteConfiguration.getRoutes())).getId();
                String transportationId = commuterBookingData2.getTransportationId();
                RouteDirection routeDirection = RouteDirection.Outbound;
                PassengerInfo passengerInfo = new PassengerInfo(1, 0, 0);
                routeManager$setupForCommuter$12.L$0 = routeManager;
                routeManager$setupForCommuter$12.L$1 = null;
                routeManager$setupForCommuter$12.L$2 = null;
                routeManager$setupForCommuter$12.label = 2;
                z5 = false;
                if (setup$default(routeManager, site2, id, transportationId, routeDirection, null, passengerInfo, null, null, commuterBookingData2, null, routeManager$setupForCommuter$12, 704, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                routeManager.analyticsTracker.updateBookingTypeStateTracking(z5, AnalyticsStateTrackingHelper.BookingFlowTypeTracking.CommuteTicket);
                return Unit.INSTANCE;
            }
        }
        routeManager$setupForCommuter$1 = new RouteManager$setupForCommuter$1(this, continuation);
        RouteManager$setupForCommuter$1 routeManager$setupForCommuter$122 = routeManager$setupForCommuter$1;
        Object obj2 = routeManager$setupForCommuter$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = routeManager$setupForCommuter$122.label;
        if (i5 != 0) {
        }
        localizedSiteConfiguration = (LocalizedSiteConfiguration) obj2;
        if (localizedSiteConfiguration != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    @Override // dk.molslinjen.domain.managers.route.IRouteManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object setupForEdit(Booking booking, Continuation<? super Unit> continuation) {
        RouteManager$setupForEdit$1 routeManager$setupForEdit$1;
        int i5;
        String mainRouteId;
        String routeId;
        RouteManager routeManager;
        Booking booking2;
        Site site;
        LocalizedSiteConfiguration localizedSiteConfiguration;
        Object obj;
        Site site2;
        Double d5;
        String replace$default;
        RouteManager routeManager2;
        if (continuation instanceof RouteManager$setupForEdit$1) {
            routeManager$setupForEdit$1 = (RouteManager$setupForEdit$1) continuation;
            int i6 = routeManager$setupForEdit$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                routeManager$setupForEdit$1.label = i6 - Integer.MIN_VALUE;
                RouteManager$setupForEdit$1 routeManager$setupForEdit$12 = routeManager$setupForEdit$1;
                Object obj2 = routeManager$setupForEdit$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = routeManager$setupForEdit$12.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Site site3 = booking.getSite();
                    mainRouteId = booking.getTicket().getDeparture().getMainRouteId();
                    routeId = booking.getTicket().getDeparture().getRouteId();
                    IConfigurationManager iConfigurationManager = this.configurationManager;
                    routeManager$setupForEdit$12.L$0 = this;
                    routeManager$setupForEdit$12.L$1 = booking;
                    routeManager$setupForEdit$12.L$2 = site3;
                    routeManager$setupForEdit$12.L$3 = mainRouteId;
                    routeManager$setupForEdit$12.L$4 = routeId;
                    routeManager$setupForEdit$12.label = 1;
                    Object activeConfiguration = iConfigurationManager.getActiveConfiguration(site3, routeManager$setupForEdit$12);
                    if (activeConfiguration == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    routeManager = this;
                    booking2 = booking;
                    site = site3;
                    obj2 = activeConfiguration;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        routeManager2 = (RouteManager) routeManager$setupForEdit$12.L$0;
                        ResultKt.throwOnFailure(obj2);
                        routeManager2.analyticsTracker.updateBookingTypeStateTracking(true, AnalyticsStateTrackingHelper.BookingFlowTypeTracking.Ticket);
                        return Unit.INSTANCE;
                    }
                    routeId = (String) routeManager$setupForEdit$12.L$4;
                    mainRouteId = (String) routeManager$setupForEdit$12.L$3;
                    site = (Site) routeManager$setupForEdit$12.L$2;
                    Booking booking3 = (Booking) routeManager$setupForEdit$12.L$1;
                    RouteManager routeManager3 = (RouteManager) routeManager$setupForEdit$12.L$0;
                    ResultKt.throwOnFailure(obj2);
                    booking2 = booking3;
                    routeManager = routeManager3;
                }
                localizedSiteConfiguration = (LocalizedSiteConfiguration) obj2;
                if (localizedSiteConfiguration != null) {
                    return Unit.INSTANCE;
                }
                Iterator<T> it = localizedSiteConfiguration.getRoutes().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    Route route = (Route) obj;
                    if (Intrinsics.areEqual(route.getOutRoute().getMainRouteId(), mainRouteId) || Intrinsics.areEqual(route.getReturnRoute().getMainRouteId(), mainRouteId)) {
                        break;
                    }
                }
                Route route2 = (Route) obj;
                if (route2 == null) {
                    Logger.INSTANCE.logCritical(new CriticalLog("Starting edit but could not find route with direction main id " + mainRouteId + " for site " + site + " and booking " + booking2.getReservationNumber()));
                    return Unit.INSTANCE;
                }
                Site site4 = Site.Kombardo;
                if (site == site4) {
                    replace$default = route2.getId();
                    site2 = site4;
                    d5 = null;
                } else {
                    site2 = site4;
                    d5 = null;
                    replace$default = StringsKt.replace$default(mainRouteId, booking2.getTicket().getDeparture().getRegionId(), BuildConfig.FLAVOR, false, 4, (Object) null);
                }
                String mainRouteId2 = route2.getOutRoute().getMainRouteId();
                if (site != site2) {
                    routeId = mainRouteId;
                }
                RouteDirection routeDirection = Intrinsics.areEqual(mainRouteId2, routeId) ? RouteDirection.Outbound : RouteDirection.Return;
                String id = booking2.getTicket().getTransport().getId();
                PassengerInfo passengerInfo = booking2.getTicket().getPassengerInfo().toPassengerInfo();
                Goods goods = booking2.getTicket().getGoods();
                TransportationCargoInfo transportationCargoInfo = new TransportationCargoInfo(goods != null ? Boxing.boxDouble(goods.getWeight()) : d5, booking2.getTicket().getNotes());
                LocalDate date = booking2.getTicket().getDeparture().getDate();
                routeManager$setupForEdit$12.L$0 = routeManager;
                routeManager$setupForEdit$12.L$1 = d5;
                routeManager$setupForEdit$12.L$2 = d5;
                routeManager$setupForEdit$12.L$3 = d5;
                routeManager$setupForEdit$12.L$4 = d5;
                routeManager$setupForEdit$12.label = 2;
                RouteManager routeManager4 = routeManager;
                if (setup$default(routeManager, site, replace$default, id, routeDirection, transportationCargoInfo, passengerInfo, date, booking2, null, null, routeManager$setupForEdit$12, 768, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                routeManager2 = routeManager4;
                routeManager2.analyticsTracker.updateBookingTypeStateTracking(true, AnalyticsStateTrackingHelper.BookingFlowTypeTracking.Ticket);
                return Unit.INSTANCE;
            }
        }
        routeManager$setupForEdit$1 = new RouteManager$setupForEdit$1(this, continuation);
        RouteManager$setupForEdit$1 routeManager$setupForEdit$122 = routeManager$setupForEdit$1;
        Object obj22 = routeManager$setupForEdit$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = routeManager$setupForEdit$122.label;
        if (i5 != 0) {
        }
        localizedSiteConfiguration = (LocalizedSiteConfiguration) obj22;
        if (localizedSiteConfiguration != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002d  */
    @Override // dk.molslinjen.domain.managers.route.IRouteManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object setupForMultiRide(MultiRideBookingData multiRideBookingData, Site site, Continuation<? super Unit> continuation) {
        RouteManager$setupForMultiRide$1 routeManager$setupForMultiRide$1;
        int i5;
        Site site2;
        MultiRideBookingData multiRideBookingData2;
        RouteManager routeManager;
        LocalizedSiteConfiguration localizedSiteConfiguration;
        boolean z5;
        if (continuation instanceof RouteManager$setupForMultiRide$1) {
            routeManager$setupForMultiRide$1 = (RouteManager$setupForMultiRide$1) continuation;
            int i6 = routeManager$setupForMultiRide$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                routeManager$setupForMultiRide$1.label = i6 - Integer.MIN_VALUE;
                RouteManager$setupForMultiRide$1 routeManager$setupForMultiRide$12 = routeManager$setupForMultiRide$1;
                Object obj = routeManager$setupForMultiRide$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = routeManager$setupForMultiRide$12.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IConfigurationManager iConfigurationManager = this.configurationManager;
                    routeManager$setupForMultiRide$12.L$0 = this;
                    routeManager$setupForMultiRide$12.L$1 = multiRideBookingData;
                    routeManager$setupForMultiRide$12.L$2 = site;
                    routeManager$setupForMultiRide$12.label = 1;
                    obj = iConfigurationManager.getActiveConfiguration(site, routeManager$setupForMultiRide$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    site2 = site;
                    multiRideBookingData2 = multiRideBookingData;
                    routeManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        routeManager = (RouteManager) routeManager$setupForMultiRide$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        z5 = false;
                        routeManager.analyticsTracker.updateBookingTypeStateTracking(z5, AnalyticsStateTrackingHelper.BookingFlowTypeTracking.MultiRideTicket);
                        return Unit.INSTANCE;
                    }
                    Site site3 = (Site) routeManager$setupForMultiRide$12.L$2;
                    MultiRideBookingData multiRideBookingData3 = (MultiRideBookingData) routeManager$setupForMultiRide$12.L$1;
                    RouteManager routeManager2 = (RouteManager) routeManager$setupForMultiRide$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    multiRideBookingData2 = multiRideBookingData3;
                    site2 = site3;
                    routeManager = routeManager2;
                }
                localizedSiteConfiguration = (LocalizedSiteConfiguration) obj;
                if (localizedSiteConfiguration != null) {
                    return Unit.INSTANCE;
                }
                String id = ((Route) CollectionsKt.first((List) localizedSiteConfiguration.getRoutes())).getId();
                String defaultTransportId = multiRideBookingData2.getDefaultTransportId();
                RouteDirection routeDirection = RouteDirection.Outbound;
                PassengerInfo passengerInfo = new PassengerInfo(1, 0, 0);
                routeManager$setupForMultiRide$12.L$0 = routeManager;
                routeManager$setupForMultiRide$12.L$1 = null;
                routeManager$setupForMultiRide$12.L$2 = null;
                routeManager$setupForMultiRide$12.label = 2;
                z5 = false;
                if (setup$default(routeManager, site2, id, defaultTransportId, routeDirection, null, passengerInfo, null, null, null, multiRideBookingData2, routeManager$setupForMultiRide$12, 448, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                routeManager.analyticsTracker.updateBookingTypeStateTracking(z5, AnalyticsStateTrackingHelper.BookingFlowTypeTracking.MultiRideTicket);
                return Unit.INSTANCE;
            }
        }
        routeManager$setupForMultiRide$1 = new RouteManager$setupForMultiRide$1(this, continuation);
        RouteManager$setupForMultiRide$1 routeManager$setupForMultiRide$122 = routeManager$setupForMultiRide$1;
        Object obj2 = routeManager$setupForMultiRide$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = routeManager$setupForMultiRide$122.label;
        if (i5 != 0) {
        }
        localizedSiteConfiguration = (LocalizedSiteConfiguration) obj2;
        if (localizedSiteConfiguration != null) {
        }
    }

    @Override // dk.molslinjen.domain.managers.route.IRouteManager
    public void updateBookingType(BookingType bookingType, LocalDate outboundSelectedDepartureDate) {
        Site site;
        Intrinsics.checkNotNullParameter(bookingType, "bookingType");
        MutableStateFlow<BookingType> bookingTypeState = getBookingTypeState();
        do {
        } while (!bookingTypeState.compareAndSet(bookingTypeState.getValue(), bookingType));
        setupReturnState(outboundSelectedDepartureDate, true);
        IAnalyticsTracker iAnalyticsTracker = this.analyticsTracker;
        RouteSharedSelectedState value = getSharedSelectedState().getValue();
        if (value == null || (site = value.getSite()) == null) {
            return;
        }
        BookingType value2 = getBookingTypeState().getValue();
        RouteSharedSelectedState value3 = getSharedSelectedState().getValue();
        iAnalyticsTracker.updateBookingStateTracking(site, value2, value3 != null ? value3.getSelectedTransportation() : null);
        this.analyticsTracker.trackEvent(new AnalyticsEvent.ChangeReturnTripEvent(bookingType));
    }

    @Override // dk.molslinjen.domain.managers.route.IRouteManager
    public void updateDepartureDirection(DepartureDirection departureDirection, LocalDate outboundDepartureDate) {
        Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
        MutableStateFlow<DepartureDirection> activeDepartureDirectionState = getActiveDepartureDirectionState();
        do {
        } while (!activeDepartureDirectionState.compareAndSet(activeDepartureDirectionState.getValue(), departureDirection));
        setupReturnState(outboundDepartureDate, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // dk.molslinjen.domain.managers.route.IRouteManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object updatePassengers(PassengerInfo passengerInfo, PassengerInfo passengerInfo2, boolean z5, Continuation<? super Unit> continuation) {
        RouteManager$updatePassengers$1 routeManager$updatePassengers$1;
        int i5;
        RouteManager routeManager;
        int i6;
        if (continuation instanceof RouteManager$updatePassengers$1) {
            routeManager$updatePassengers$1 = (RouteManager$updatePassengers$1) continuation;
            int i7 = routeManager$updatePassengers$1.label;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                routeManager$updatePassengers$1.label = i7 - Integer.MIN_VALUE;
                Object obj = routeManager$updatePassengers$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = routeManager$updatePassengers$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    RouteSelectedState value = getOutboundSelectedState().getValue();
                    int i8 = !Intrinsics.areEqual(value != null ? value.getPassengerInfo() : null, passengerInfo) ? 1 : 0;
                    routeManager$updatePassengers$1.L$0 = this;
                    routeManager$updatePassengers$1.Z$0 = z5;
                    routeManager$updatePassengers$1.I$0 = i8;
                    routeManager$updatePassengers$1.label = 1;
                    if (setPassengersInternal(passengerInfo, passengerInfo2, routeManager$updatePassengers$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    routeManager = this;
                    i6 = i8;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i6 = routeManager$updatePassengers$1.I$0;
                    z5 = routeManager$updatePassengers$1.Z$0;
                    routeManager = (RouteManager) routeManager$updatePassengers$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                routeManager.resetDirectionIfOnReturnTab(z5, i6 != 0);
                return Unit.INSTANCE;
            }
        }
        routeManager$updatePassengers$1 = new RouteManager$updatePassengers$1(this, continuation);
        Object obj2 = routeManager$updatePassengers$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = routeManager$updatePassengers$1.label;
        if (i5 != 0) {
        }
        routeManager.resetDirectionIfOnReturnTab(z5, i6 != 0);
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/domain/managers/route/RouteManager$InternalEditState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/Booking;", "editingBooking", "<init>", "(Ldk/molslinjen/domain/model/booking/Booking;)V", "copy", "(Ldk/molslinjen/domain/model/booking/Booking;)Ldk/molslinjen/domain/managers/route/RouteManager$InternalEditState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/booking/Booking;", "getEditingBooking", "()Ldk/molslinjen/domain/model/booking/Booking;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class InternalEditState {
        private final Booking editingBooking;

        public InternalEditState(Booking booking) {
            this.editingBooking = booking;
        }

        public final InternalEditState copy(Booking editingBooking) {
            return new InternalEditState(editingBooking);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof InternalEditState) && Intrinsics.areEqual(this.editingBooking, ((InternalEditState) other).editingBooking);
        }

        public final Booking getEditingBooking() {
            return this.editingBooking;
        }

        public int hashCode() {
            Booking booking = this.editingBooking;
            if (booking == null) {
                return 0;
            }
            return booking.hashCode();
        }

        public String toString() {
            return "InternalEditState(editingBooking=" + this.editingBooking + ")";
        }

        public /* synthetic */ InternalEditState(Booking booking, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? null : booking);
        }
    }

    @Override // dk.molslinjen.domain.managers.route.IRouteManager
    public MutableStateFlow<DepartureDirection> getActiveDepartureDirectionState() {
        return this.activeDepartureDirectionState;
    }

    @Override // dk.molslinjen.domain.managers.route.IRouteManager
    public MutableStateFlow<RouteSelectedState> getActiveSelectedState() {
        int i5 = WhenMappings.$EnumSwitchMapping$0[getActiveDepartureDirectionState().getValue().ordinal()];
        if (i5 == 1) {
            return getOutboundSelectedState();
        }
        if (i5 == 2) {
            return getReturnSelectedState();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // dk.molslinjen.domain.managers.route.IRouteManager
    public MutableStateFlow<BookingType> getBookingTypeState() {
        return this.bookingTypeState;
    }

    @Override // dk.molslinjen.domain.managers.route.IRouteManager
    public MutableStateFlow<RouteSelectedState> getOutboundSelectedState() {
        return this.outboundSelectedState;
    }

    @Override // dk.molslinjen.domain.managers.route.IRouteManager
    public MutableStateFlow<RouteSelectedState> getReturnSelectedState() {
        return this.returnSelectedState;
    }

    @Override // dk.molslinjen.domain.managers.route.IRouteManager
    public MutableStateFlow<RouteState> getRouteState() {
        return this.routeState;
    }

    @Override // dk.molslinjen.domain.managers.route.IRouteManager
    public MutableStateFlow<RouteSharedSelectedState> getSharedSelectedState() {
        return this.sharedSelectedState;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00c0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    @Override // dk.molslinjen.domain.managers.route.IRouteManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object setTransportation(String str, TransportationCargoInfo transportationCargoInfo, TransportationCargoInfo transportationCargoInfo2, Continuation<? super Unit> continuation) {
        RouteManager$setTransportation$2 routeManager$setTransportation$2;
        int i5;
        RouteSelectedState value;
        RouteSelectedState routeSelectedState;
        TransportationCargoInfo transportationCargoInfo3;
        RouteManager routeManager;
        ISettings iSettings;
        SettingsProperty.Departures.CurrentTransportationInfo currentTransportationInfo;
        if (continuation instanceof RouteManager$setTransportation$2) {
            routeManager$setTransportation$2 = (RouteManager$setTransportation$2) continuation;
            int i6 = routeManager$setTransportation$2.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                routeManager$setTransportation$2.label = i6 - Integer.MIN_VALUE;
                Object obj = routeManager$setTransportation$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = routeManager$setTransportation$2.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    RouteSharedSelectedState value2 = getSharedSelectedState().getValue();
                    if ((value2 != null ? value2.getMultiRideBookingData() : null) == null) {
                        if ((value2 != null ? value2.getCommuterBookingData() : null) == null) {
                            MutableStateFlow<RouteSelectedState> returnSelectedState = getReturnSelectedState();
                            do {
                                value = returnSelectedState.getValue();
                                routeSelectedState = value;
                            } while (!returnSelectedState.compareAndSet(value, routeSelectedState != null ? RouteSelectedState.copy$default(routeSelectedState, null, null, transportationCargoInfo2, null, null, null, null, 123, null) : null));
                            ISettings iSettings2 = this.settings;
                            SettingsProperty.Departures.CurrentTransportationId currentTransportationId = SettingsProperty.Departures.CurrentTransportationId.INSTANCE;
                            routeManager$setTransportation$2.L$0 = this;
                            routeManager$setTransportation$2.L$1 = transportationCargoInfo;
                            routeManager$setTransportation$2.label = 2;
                            if (iSettings2.update(currentTransportationId, str, routeManager$setTransportation$2) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            transportationCargoInfo3 = transportationCargoInfo;
                            routeManager = this;
                            iSettings = routeManager.settings;
                            currentTransportationInfo = SettingsProperty.Departures.CurrentTransportationInfo.INSTANCE;
                            routeManager$setTransportation$2.L$0 = null;
                            routeManager$setTransportation$2.L$1 = null;
                            routeManager$setTransportation$2.label = 3;
                            if (iSettings.update(currentTransportationInfo, transportationCargoInfo3, routeManager$setTransportation$2) == coroutine_suspended) {
                            }
                        }
                    }
                    routeManager$setTransportation$2.label = 1;
                    if (setTransportationInternal(str, transportationCargoInfo, transportationCargoInfo2, routeManager$setTransportation$2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                if (i5 == 1) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i5 == 2) {
                    transportationCargoInfo3 = (TransportationCargoInfo) routeManager$setTransportation$2.L$1;
                    routeManager = (RouteManager) routeManager$setTransportation$2.L$0;
                    ResultKt.throwOnFailure(obj);
                    iSettings = routeManager.settings;
                    currentTransportationInfo = SettingsProperty.Departures.CurrentTransportationInfo.INSTANCE;
                    routeManager$setTransportation$2.L$0 = null;
                    routeManager$setTransportation$2.L$1 = null;
                    routeManager$setTransportation$2.label = 3;
                    if (iSettings.update(currentTransportationInfo, transportationCargoInfo3, routeManager$setTransportation$2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }
        routeManager$setTransportation$2 = new RouteManager$setTransportation$2(this, continuation);
        Object obj2 = routeManager$setTransportation$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = routeManager$setTransportation$2.label;
        if (i5 != 0) {
        }
        return Unit.INSTANCE;
    }

    @Override // dk.molslinjen.domain.managers.route.IRouteManager
    public Object loadTransportProducts(List<LineItem> list, Continuation<? super ManagerResult<Unit>> continuation) {
        RouteSharedSelectedState value = getSharedSelectedState().getValue();
        return value == null ? ManagerResult.Error.INSTANCE.noMessage() : loadTransportProducts(value.getSelectedTransportation().getId(), continuation);
    }
}
