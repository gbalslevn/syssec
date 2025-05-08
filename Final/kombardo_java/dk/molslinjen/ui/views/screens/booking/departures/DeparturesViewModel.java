package dk.molslinjen.ui.views.screens.booking.departures;

import android.content.Context;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.DeparturesReturnScreenDestination;
import com.ramcosta.composedestinations.spec.Direction;
import com.sun.jna.Function;
import dk.molslinjen.core.Feature;
import dk.molslinjen.core.location.GoogleMapsNavigationHandler;
import dk.molslinjen.core.location.IDirectionsManager;
import dk.molslinjen.core.location.ILocationManager;
import dk.molslinjen.core.navigation.ICheckoutNavigator;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.analytics.AnalyticsEvent;
import dk.molslinjen.domain.analytics.AnalyticsStateTrackingHelper;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.checkout.EditManager;
import dk.molslinjen.domain.managers.checkout.IEditManager;
import dk.molslinjen.domain.managers.checkout.IPaymentManager;
import dk.molslinjen.domain.managers.checkout.IReturnManager;
import dk.molslinjen.domain.managers.checkout.ReturnManager;
import dk.molslinjen.domain.managers.company.ICompanyViewHelper;
import dk.molslinjen.domain.managers.departure.DepartureState;
import dk.molslinjen.domain.managers.departure.IDepartureManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.managers.route.RouteSelectedState;
import dk.molslinjen.domain.managers.route.RouteSharedSelectedState;
import dk.molslinjen.domain.managers.route.RouteState;
import dk.molslinjen.domain.managers.splitTest.ISplitTestManager;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.DepartureTicket;
import dk.molslinjen.domain.model.booking.TravelTimeToNearestHarborOnRoute;
import dk.molslinjen.domain.model.config.HarborReference;
import dk.molslinjen.domain.model.config.RouteDirectionGroup;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel;
import dk.molslinjen.ui.views.screens.booking.shared.expiration.ExpirableCheckoutHandler;
import dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout;
import dk.molslinjen.ui.views.shared.routeSelector.helpers.IRouteLocationHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000\u0082\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0081\u0001\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u001d\u0010(\u001a\u00020'2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b(\u0010)J\u0015\u0010,\u001a\u00020'2\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J)\u00103\u001a\u00020'2\u0006\u0010/\u001a\u00020.2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020'00¢\u0006\u0004\b3\u00104J!\u00105\u001a\u00020'2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020'00¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020'¢\u0006\u0004\b7\u00108J!\u0010;\u001a\u00020'2\u0006\u0010+\u001a\u00020*2\n\b\u0002\u0010:\u001a\u0004\u0018\u000109¢\u0006\u0004\b;\u0010<J\r\u0010=\u001a\u00020'¢\u0006\u0004\b=\u00108J\r\u0010>\u001a\u00020'¢\u0006\u0004\b>\u00108J\u0015\u0010@\u001a\u00020'2\u0006\u0010?\u001a\u000209¢\u0006\u0004\b@\u0010AJ/\u0010F\u001a\u00020'2\u0006\u0010C\u001a\u00020B2\u0018\u0010E\u001a\u0014\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020'0D¢\u0006\u0004\bF\u0010GJ!\u0010I\u001a\u00020'2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020'00¢\u0006\u0004\bI\u00106J\u0015\u0010J\u001a\u00020'2\u0006\u0010?\u001a\u000209¢\u0006\u0004\bJ\u0010AJ\u0015\u0010K\u001a\u00020'2\u0006\u0010?\u001a\u000209¢\u0006\u0004\bK\u0010AJ\r\u0010L\u001a\u00020'¢\u0006\u0004\bL\u00108J\r\u0010M\u001a\u00020'¢\u0006\u0004\bM\u00108J\u001d\u0010O\u001a\u00020'2\u0006\u0010N\u001a\u0002012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\bO\u0010PJ\r\u0010Q\u001a\u00020'¢\u0006\u0004\bQ\u00108J\r\u0010R\u001a\u00020'¢\u0006\u0004\bR\u00108J\r\u0010S\u001a\u00020'¢\u0006\u0004\bS\u00108J\r\u0010T\u001a\u00020'¢\u0006\u0004\bT\u00108J\r\u0010U\u001a\u00020'¢\u0006\u0004\bU\u00108J\r\u0010V\u001a\u00020'¢\u0006\u0004\bV\u00108J\u0010\u0010X\u001a\u00020WH\u0096\u0001¢\u0006\u0004\bX\u0010YJ\u0010\u0010Z\u001a\u00020'H\u0096\u0001¢\u0006\u0004\bZ\u00108J\u0010\u0010[\u001a\u00020WH\u0096\u0001¢\u0006\u0004\b[\u0010YJ\u0010\u0010\\\u001a\u00020WH\u0096\u0001¢\u0006\u0004\b\\\u0010YJ\u0010\u0010]\u001a\u00020WH\u0096\u0001¢\u0006\u0004\b]\u0010YJ\u0010\u0010^\u001a\u00020WH\u0096\u0001¢\u0006\u0004\b^\u0010YJ\u0010\u0010_\u001a\u00020WH\u0096\u0001¢\u0006\u0004\b_\u0010YJ\u0010\u0010`\u001a\u00020'H\u0082@¢\u0006\u0004\b`\u0010aJ\u0017\u0010b\u001a\u00020'2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\bb\u0010-J\u0010\u0010c\u001a\u00020'H\u0082@¢\u0006\u0004\bc\u0010aJ+\u0010j\u001a\u00020'2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020e0d2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020h0gH\u0002¢\u0006\u0004\bj\u0010kJ\u0018\u0010m\u001a\u00020'2\u0006\u0010l\u001a\u000201H\u0082@¢\u0006\u0004\bm\u0010nR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010oR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010pR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010qR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010rR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010sR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010tR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010uR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010vR\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010wR\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010xR\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010yR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010zR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010{R\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010|R\u0014\u0010~\u001a\u00020}8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010\u007fR\"\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020*0d8\u0006¢\u0006\u0010\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001d\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020h0g8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\"\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020h0d8\u0006¢\u0006\u0010\n\u0006\b\u0086\u0001\u0010\u0081\u0001\u001a\u0006\b\u0087\u0001\u0010\u0083\u0001R\u001d\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020h0g8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0085\u0001R\"\u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020h0d8\u0006¢\u0006\u0010\n\u0006\b\u0089\u0001\u0010\u0081\u0001\u001a\u0006\b\u008a\u0001\u0010\u0083\u0001R\u001d\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020e0g8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u0085\u0001R\"\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020e0d8\u0006¢\u0006\u0010\n\u0006\b\u008c\u0001\u0010\u0081\u0001\u001a\u0006\b\u008d\u0001\u0010\u0083\u0001R\u001d\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u00020e0g8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u0085\u0001R\"\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020e0d8\u0006¢\u0006\u0010\n\u0006\b\u008f\u0001\u0010\u0081\u0001\u001a\u0006\b\u0090\u0001\u0010\u0083\u0001R%\u0010\u0092\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u0091\u00010d8\u0006¢\u0006\u0010\n\u0006\b\u0092\u0001\u0010\u0081\u0001\u001a\u0006\b\u0093\u0001\u0010\u0083\u0001R%\u0010\u0095\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u0094\u00010d8\u0006¢\u0006\u0010\n\u0006\b\u0095\u0001\u0010\u0081\u0001\u001a\u0006\b\u0096\u0001\u0010\u0083\u0001R\"\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020.0d8\u0006¢\u0006\u0010\n\u0006\b\u0097\u0001\u0010\u0081\u0001\u001a\u0006\b\u0098\u0001\u0010\u0083\u0001R%\u0010\u009a\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u0099\u00010d8\u0006¢\u0006\u0010\n\u0006\b\u009a\u0001\u0010\u0081\u0001\u001a\u0006\b\u009b\u0001\u0010\u0083\u0001R%\u0010\u009c\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u0099\u00010d8\u0006¢\u0006\u0010\n\u0006\b\u009c\u0001\u0010\u0081\u0001\u001a\u0006\b\u009d\u0001\u0010\u0083\u0001R#\u0010\u009f\u0001\u001a\t\u0012\u0005\u0012\u00030\u009e\u00010d8\u0006¢\u0006\u0010\n\u0006\b\u009f\u0001\u0010\u0081\u0001\u001a\u0006\b \u0001\u0010\u0083\u0001R#\u0010¢\u0001\u001a\t\u0012\u0005\u0012\u00030¡\u00010d8\u0006¢\u0006\u0010\n\u0006\b¢\u0001\u0010\u0081\u0001\u001a\u0006\b£\u0001\u0010\u0083\u0001R\u001b\u0010¤\u0001\u001a\u00020W8\u0006¢\u0006\u000f\n\u0006\b¤\u0001\u0010¥\u0001\u001a\u0005\b¦\u0001\u0010YR\u001b\u0010§\u0001\u001a\u00020W8\u0006¢\u0006\u000f\n\u0006\b§\u0001\u0010¥\u0001\u001a\u0005\b¨\u0001\u0010YR&\u0010©\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001010d8\u0002X\u0082\u0004¢\u0006\u000f\n\u0006\b©\u0001\u0010\u0081\u0001\u0012\u0005\bª\u0001\u00108R\u001b\u0010«\u0001\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001¨\u0006\u00ad\u0001"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/DeparturesViewModel;", "Landroidx/lifecycle/ViewModel;", "Ldk/molslinjen/ui/views/screens/booking/shared/expiration/IExpirableCheckout;", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "routeManager", "Ldk/molslinjen/domain/managers/departure/IDepartureManager;", "departureManager", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "snackbarService", "Ldk/molslinjen/core/location/ILocationManager;", "locationManager", "Ldk/molslinjen/core/location/IDirectionsManager;", "directionsManager", "Ldk/molslinjen/domain/managers/checkout/IReturnManager;", "returnManager", "Ldk/molslinjen/domain/managers/checkout/IEditManager;", "editManager", "Ldk/molslinjen/domain/managers/checkout/IPaymentManager;", "paymentManager", "Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle", "Ldk/molslinjen/core/navigation/ICheckoutNavigator;", "checkoutNavigator", "Ldk/molslinjen/domain/managers/company/ICompanyViewHelper;", "companyViewHelper", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "analyticsTracker", "Ldk/molslinjen/domain/managers/user/IUserManager;", "userManager", "Ldk/molslinjen/ui/views/shared/routeSelector/helpers/IRouteLocationHelper;", "routeLocationHelper", "Ldk/molslinjen/domain/managers/splitTest/ISplitTestManager;", "splitTestManager", "<init>", "(Ldk/molslinjen/domain/managers/route/IRouteManager;Ldk/molslinjen/domain/managers/departure/IDepartureManager;Ldk/molslinjen/core/snackbar/ISnackbarService;Ldk/molslinjen/core/location/ILocationManager;Ldk/molslinjen/core/location/IDirectionsManager;Ldk/molslinjen/domain/managers/checkout/IReturnManager;Ldk/molslinjen/domain/managers/checkout/IEditManager;Ldk/molslinjen/domain/managers/checkout/IPaymentManager;Landroidx/lifecycle/SavedStateHandle;Ldk/molslinjen/core/navigation/ICheckoutNavigator;Ldk/molslinjen/domain/managers/company/ICompanyViewHelper;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;Ldk/molslinjen/domain/managers/user/IUserManager;Ldk/molslinjen/ui/views/shared/routeSelector/helpers/IRouteLocationHelper;Ldk/molslinjen/domain/managers/splitTest/ISplitTestManager;)V", "Landroid/content/Context;", "context", "Ldk/molslinjen/domain/model/booking/DepartureTicket;", "departureTicket", BuildConfig.FLAVOR, "showChangeFeeWarning", "(Landroid/content/Context;Ldk/molslinjen/domain/model/booking/DepartureTicket;)V", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "departureDirection", "reloadDeparturesAfterError", "(Ldk/molslinjen/domain/model/booking/DepartureDirection;)V", "Ldk/molslinjen/domain/model/booking/BookingType;", "type", "Lkotlin/Function1;", BuildConfig.FLAVOR, "promptForCargoDetails", "updateBookingType", "(Ldk/molslinjen/domain/model/booking/BookingType;Lkotlin/jvm/functions/Function1;)V", "handlePromptForCargoDetails", "(Lkotlin/jvm/functions/Function1;)V", "onCargoFlowCancelled", "()V", "Lorg/threeten/bp/LocalDate;", "calendarSelectedDate", "updateDepartureDirection", "(Ldk/molslinjen/domain/model/booking/DepartureDirection;Lorg/threeten/bp/LocalDate;)V", "removeSelectedTrailer", "removeAllSelectedTransportProducts", "date", "dateSelected", "(Lorg/threeten/bp/LocalDate;)V", "Ldk/molslinjen/domain/model/booking/Departure;", "departure", "Lkotlin/Function2;", "proceed", "departureSelected", "(Ldk/molslinjen/domain/model/booking/Departure;Lkotlin/jvm/functions/Function2;)V", "Lcom/ramcosta/composedestinations/spec/Direction;", "proceedWithEditDeparture", "updateShownHeaderDate", "departureDayHeaderShown", "flipDirection", "locationPermissionGranted", "directionsDestination", "showDirections", "(Ljava/lang/String;Landroid/content/Context;)V", "onTripTypeDisabledClick", "stopAddingReturnFromBookingSummary", "trackInitiatedBooking", "stopEdit", "showCompanyAccountPopup", "updateBookingStateTracking", BuildConfig.FLAVOR, "isExpired", "()Z", "resetCheckoutAfterExpiredDepartures", "isEditing", "isMultiRide", "isCommuter", "showReloadDialog", "isInCheckoutFlow", "switchToStartFromNearestHarbor", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupDepartureStateListener", "handleErrors", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/departure/DepartureState;", "departureState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/booking/departures/DepartureTabState;", "departureTabState", "handleDepartureErrors", "(Lkotlinx/coroutines/flow/StateFlow;Lkotlinx/coroutines/flow/MutableStateFlow;)V", "routeId", "loadTravelTime", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "Ldk/molslinjen/domain/managers/departure/IDepartureManager;", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "Ldk/molslinjen/core/location/ILocationManager;", "Ldk/molslinjen/core/location/IDirectionsManager;", "Ldk/molslinjen/domain/managers/checkout/IReturnManager;", "Ldk/molslinjen/domain/managers/checkout/IEditManager;", "Ldk/molslinjen/domain/managers/checkout/IPaymentManager;", "Ldk/molslinjen/core/navigation/ICheckoutNavigator;", "Ldk/molslinjen/domain/managers/company/ICompanyViewHelper;", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "Ldk/molslinjen/domain/managers/user/IUserManager;", "Ldk/molslinjen/ui/views/shared/routeSelector/helpers/IRouteLocationHelper;", "Ldk/molslinjen/domain/managers/splitTest/ISplitTestManager;", "Ldk/molslinjen/ui/views/screens/booking/departures/DeparturesScreenNavArgs;", "navArgs", "Ldk/molslinjen/ui/views/screens/booking/departures/DeparturesScreenNavArgs;", "activeDepartureDirectionState", "Lkotlinx/coroutines/flow/StateFlow;", "getActiveDepartureDirectionState", "()Lkotlinx/coroutines/flow/StateFlow;", "_outboundDepartureTabState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "outboundDepartureTabState", "getOutboundDepartureTabState", "_returnDepartureTabState", "returnDepartureTabState", "getReturnDepartureTabState", "_outboundDepartureState", "outboundDepartureState", "getOutboundDepartureState", "_returnDepartureState", "returnDepartureState", "getReturnDepartureState", "Ldk/molslinjen/domain/managers/route/RouteState;", "routeState", "getRouteState", "Ldk/molslinjen/domain/managers/route/RouteSharedSelectedState;", "sharedSelectedState", "getSharedSelectedState", "bookingTypeState", "getBookingTypeState", "Ldk/molslinjen/domain/managers/route/RouteSelectedState;", "outboundSelectedState", "getOutboundSelectedState", "returnSelectedState", "getReturnSelectedState", "Ldk/molslinjen/domain/managers/checkout/ReturnManager$ReturnState;", "returnState", "getReturnState", "Ldk/molslinjen/domain/managers/checkout/EditManager$EditState;", "editState", "getEditState", "splitTestMoveReturnTripSelector", "Z", "getSplitTestMoveReturnTripSelector", "splitTestShowRouteSwitchWithText", "getSplitTestShowRouteSwitchWithText", "outboundRouteId", "getOutboundRouteId$annotations", "previousSelectedBookingType", "Ldk/molslinjen/domain/model/booking/BookingType;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DeparturesViewModel extends ViewModel implements IExpirableCheckout {
    private final /* synthetic */ ExpirableCheckoutHandler $$delegate_0;
    private final MutableStateFlow<DepartureState> _outboundDepartureState;
    private final MutableStateFlow<DepartureTabState> _outboundDepartureTabState;
    private final MutableStateFlow<DepartureState> _returnDepartureState;
    private final MutableStateFlow<DepartureTabState> _returnDepartureTabState;
    private final StateFlow<DepartureDirection> activeDepartureDirectionState;
    private final IAnalyticsTracker analyticsTracker;
    private final StateFlow<BookingType> bookingTypeState;
    private final ICheckoutNavigator checkoutNavigator;
    private final ICompanyViewHelper companyViewHelper;
    private final IDepartureManager departureManager;
    private final IDirectionsManager directionsManager;
    private final IEditManager editManager;
    private final StateFlow<EditManager.EditState> editState;
    private final ILocationManager locationManager;
    private final DeparturesScreenNavArgs navArgs;
    private final StateFlow<DepartureState> outboundDepartureState;
    private final StateFlow<DepartureTabState> outboundDepartureTabState;
    private final StateFlow<String> outboundRouteId;
    private final StateFlow<RouteSelectedState> outboundSelectedState;
    private final IPaymentManager paymentManager;
    private BookingType previousSelectedBookingType;
    private final StateFlow<DepartureState> returnDepartureState;
    private final StateFlow<DepartureTabState> returnDepartureTabState;
    private final IReturnManager returnManager;
    private final StateFlow<RouteSelectedState> returnSelectedState;
    private final StateFlow<ReturnManager.ReturnState> returnState;
    private final IRouteLocationHelper routeLocationHelper;
    private final IRouteManager routeManager;
    private final StateFlow<RouteState> routeState;
    private final StateFlow<RouteSharedSelectedState> sharedSelectedState;
    private final ISnackbarService snackbarService;
    private final ISplitTestManager splitTestManager;
    private final boolean splitTestMoveReturnTripSelector;
    private final boolean splitTestShowRouteSwitchWithText;
    private final IUserManager userManager;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel$1", f = "DeparturesViewModel.kt", l = {135}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel$1, reason: invalid class name */
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
                IRouteManager iRouteManager = DeparturesViewModel.this.routeManager;
                this.label = 1;
                if (IRouteManager.DefaultImpls.loadTransportProducts$default(iRouteManager, null, this, 1, null) == coroutine_suspended) {
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

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel$2", f = "DeparturesViewModel.kt", l = {138}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                DeparturesViewModel departuresViewModel = DeparturesViewModel.this;
                this.label = 1;
                if (departuresViewModel.handleErrors(this) == coroutine_suspended) {
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
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel$3", f = "DeparturesViewModel.kt", l = {142}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel$3, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "routeId", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel$3$1", f = "DeparturesViewModel.kt", l = {144}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel$3$1, reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ DeparturesViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(DeparturesViewModel departuresViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = departuresViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i5 = this.label;
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    String str = (String) this.L$0;
                    if (str != null) {
                        DeparturesViewModel departuresViewModel = this.this$0;
                        this.label = 1;
                        if (departuresViewModel.loadTravelTime(str, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
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
            public final Object invoke(String str, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                Flow distinctUntilChanged = FlowKt.distinctUntilChanged(FlowKt.debounce(DeparturesViewModel.this.outboundRouteId, 500L));
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeparturesViewModel.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(distinctUntilChanged, anonymousClass1, this) == coroutine_suspended) {
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
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel$4", f = "DeparturesViewModel.kt", l = {153}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel$4, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                DeparturesViewModel departuresViewModel = DeparturesViewModel.this;
                this.label = 1;
                if (departuresViewModel.switchToStartFromNearestHarbor(this) == coroutine_suspended) {
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
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
    public DeparturesViewModel(IRouteManager routeManager, IDepartureManager departureManager, ISnackbarService snackbarService, ILocationManager locationManager, IDirectionsManager directionsManager, IReturnManager returnManager, IEditManager editManager, IPaymentManager paymentManager, SavedStateHandle savedStateHandle, ICheckoutNavigator checkoutNavigator, ICompanyViewHelper companyViewHelper, IAnalyticsTracker analyticsTracker, IUserManager userManager, IRouteLocationHelper routeLocationHelper, ISplitTestManager splitTestManager) {
        Intrinsics.checkNotNullParameter(routeManager, "routeManager");
        Intrinsics.checkNotNullParameter(departureManager, "departureManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(locationManager, "locationManager");
        Intrinsics.checkNotNullParameter(directionsManager, "directionsManager");
        Intrinsics.checkNotNullParameter(returnManager, "returnManager");
        Intrinsics.checkNotNullParameter(editManager, "editManager");
        Intrinsics.checkNotNullParameter(paymentManager, "paymentManager");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(checkoutNavigator, "checkoutNavigator");
        Intrinsics.checkNotNullParameter(companyViewHelper, "companyViewHelper");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(routeLocationHelper, "routeLocationHelper");
        Intrinsics.checkNotNullParameter(splitTestManager, "splitTestManager");
        this.$$delegate_0 = new ExpirableCheckoutHandler(routeManager, departureManager, editManager, returnManager, paymentManager, null, false, analyticsTracker, 96, null);
        this.routeManager = routeManager;
        this.departureManager = departureManager;
        this.snackbarService = snackbarService;
        this.locationManager = locationManager;
        this.directionsManager = directionsManager;
        this.returnManager = returnManager;
        this.editManager = editManager;
        this.paymentManager = paymentManager;
        this.checkoutNavigator = checkoutNavigator;
        this.companyViewHelper = companyViewHelper;
        this.analyticsTracker = analyticsTracker;
        this.userManager = userManager;
        this.routeLocationHelper = routeLocationHelper;
        this.splitTestManager = splitTestManager;
        DeparturesScreenNavArgs argsFrom = DeparturesReturnScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        this.navArgs = argsFrom;
        this.activeDepartureDirectionState = routeManager.getActiveDepartureDirectionState();
        MutableStateFlow<DepartureTabState> MutableStateFlow = StateFlowKt.MutableStateFlow(new DepartureTabState(false, null, false, 7, null));
        this._outboundDepartureTabState = MutableStateFlow;
        this.outboundDepartureTabState = MutableStateFlow;
        MutableStateFlow<DepartureTabState> MutableStateFlow2 = StateFlowKt.MutableStateFlow(new DepartureTabState(false, null, false, 7, null));
        this._returnDepartureTabState = MutableStateFlow2;
        this.returnDepartureTabState = MutableStateFlow2;
        int i5 = Function.USE_VARARGS;
        DefaultConstructorMarker defaultConstructorMarker = null;
        boolean z5 = false;
        List list = null;
        String str = null;
        Departure departure = null;
        DepartureTicket departureTicket = null;
        LocalDateTime localDateTime = null;
        MutableStateFlow<DepartureState> MutableStateFlow3 = StateFlowKt.MutableStateFlow(new DepartureState(z5, list, str, 0 == true ? 1 : 0, 0 == true ? 1 : 0, departure, departureTicket, localDateTime, i5, defaultConstructorMarker));
        this._outboundDepartureState = MutableStateFlow3;
        this.outboundDepartureState = MutableStateFlow3;
        MutableStateFlow<DepartureState> MutableStateFlow4 = StateFlowKt.MutableStateFlow(new DepartureState(z5, list, str, 0 == true ? 1 : 0, 0 == true ? 1 : 0, departure, departureTicket, localDateTime, i5, defaultConstructorMarker));
        this._returnDepartureState = MutableStateFlow4;
        this.returnDepartureState = MutableStateFlow4;
        this.routeState = routeManager.getRouteState();
        this.sharedSelectedState = routeManager.getSharedSelectedState();
        StateFlow<BookingType> bookingTypeState = routeManager.getBookingTypeState();
        this.bookingTypeState = bookingTypeState;
        StateFlow<RouteSelectedState> outboundSelectedState = routeManager.getOutboundSelectedState();
        this.outboundSelectedState = outboundSelectedState;
        this.returnSelectedState = routeManager.getReturnSelectedState();
        this.returnState = returnManager.getReturnState();
        this.editState = editManager.getEditState();
        this.splitTestMoveReturnTripSelector = splitTestManager.getMoveReturnTripSelector();
        this.splitTestShowRouteSwitchWithText = splitTestManager.getShowRouteSwitchWithText();
        this.outboundRouteId = FlowKt.stateIn(FlowKt.mapLatest(outboundSelectedState, new DeparturesViewModel$outboundRouteId$1(null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null), null);
        this.previousSelectedBookingType = bookingTypeState.getValue();
        if (argsFrom.getIsAddingReturnFromBookingSummary()) {
            returnManager.startAddingReturnFromBookingSummary();
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass3(null), 3, null);
        setupDepartureStateListener(DepartureDirection.Outbound);
        setupDepartureStateListener(DepartureDirection.Return);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass4(null), 3, null);
    }

    private final void handleDepartureErrors(StateFlow<DepartureState> departureState, MutableStateFlow<DepartureTabState> departureTabState) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new DeparturesViewModel$handleDepartureErrors$1(departureState, departureTabState, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleErrors(Continuation<? super Unit> continuation) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new DeparturesViewModel$handleErrors$2(this, null), 3, null);
        handleDepartureErrors(this.outboundDepartureState, this._outboundDepartureTabState);
        handleDepartureErrors(this.returnDepartureState, this._returnDepartureTabState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadTravelTime(String str, Continuation<? super Unit> continuation) {
        DeparturesViewModel$loadTravelTime$1 departuresViewModel$loadTravelTime$1;
        int i5;
        DepartureTabState value;
        DeparturesViewModel departuresViewModel;
        ManagerResult managerResult;
        DepartureTabState value2;
        DepartureTabState value3;
        if (continuation instanceof DeparturesViewModel$loadTravelTime$1) {
            departuresViewModel$loadTravelTime$1 = (DeparturesViewModel$loadTravelTime$1) continuation;
            int i6 = departuresViewModel$loadTravelTime$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                departuresViewModel$loadTravelTime$1.label = i6 - Integer.MIN_VALUE;
                Object obj = departuresViewModel$loadTravelTime$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = departuresViewModel$loadTravelTime$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    boolean isAuthorized = this.locationManager.isAuthorized();
                    RouteSharedSelectedState value4 = this.sharedSelectedState.getValue();
                    Site site = value4 != null ? value4.getSite() : null;
                    RouteSelectedState value5 = this.outboundSelectedState.getValue();
                    LocalDate selectedStartDate = value5 != null ? value5.getSelectedStartDate() : null;
                    if (isAuthorized && site != null) {
                        MutableStateFlow<DepartureTabState> mutableStateFlow = this._outboundDepartureTabState;
                        do {
                            value = mutableStateFlow.getValue();
                        } while (!mutableStateFlow.compareAndSet(value, DepartureTabState.copy$default(value, false, null, false, 5, null)));
                        if (!Intrinsics.areEqual(selectedStartDate, LocalDate.now())) {
                            return Unit.INSTANCE;
                        }
                        IDirectionsManager iDirectionsManager = this.directionsManager;
                        departuresViewModel$loadTravelTime$1.L$0 = this;
                        departuresViewModel$loadTravelTime$1.label = 1;
                        obj = iDirectionsManager.getTravelTimeToNearestHarborOnRoute(str, site, departuresViewModel$loadTravelTime$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        departuresViewModel = this;
                    }
                    return Unit.INSTANCE;
                }
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                departuresViewModel = (DeparturesViewModel) departuresViewModel$loadTravelTime$1.L$0;
                ResultKt.throwOnFailure(obj);
                managerResult = (ManagerResult) obj;
                if (!(managerResult instanceof ManagerResult.Success)) {
                    MutableStateFlow<DepartureTabState> mutableStateFlow2 = departuresViewModel._outboundDepartureTabState;
                    do {
                        value3 = mutableStateFlow2.getValue();
                    } while (!mutableStateFlow2.compareAndSet(value3, DepartureTabState.copy$default(value3, false, (TravelTimeToNearestHarborOnRoute) ((ManagerResult.Success) managerResult).getData(), false, 5, null)));
                } else {
                    if (!(managerResult instanceof ManagerResult.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    MutableStateFlow<DepartureTabState> mutableStateFlow3 = departuresViewModel._outboundDepartureTabState;
                    do {
                        value2 = mutableStateFlow3.getValue();
                    } while (!mutableStateFlow3.compareAndSet(value2, DepartureTabState.copy$default(value2, false, null, false, 5, null)));
                }
                return Unit.INSTANCE;
            }
        }
        departuresViewModel$loadTravelTime$1 = new DeparturesViewModel$loadTravelTime$1(this, continuation);
        Object obj2 = departuresViewModel$loadTravelTime$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = departuresViewModel$loadTravelTime$1.label;
        if (i5 != 0) {
        }
        managerResult = (ManagerResult) obj2;
        if (!(managerResult instanceof ManagerResult.Success)) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCargoFlowCancelled$lambda$2$lambda$1(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    private final void setupDepartureStateListener(DepartureDirection departureDirection) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new DeparturesViewModel$setupDepartureStateListener$1(departureDirection, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object switchToStartFromNearestHarbor(Continuation<? super Unit> continuation) {
        if (this.editState.getValue().getIsEditing() || this.returnState.getValue().getIsAddingReturnFromBookingSummary()) {
            return Unit.INSTANCE;
        }
        Object collect = FlowKt.take(FlowKt.filterNotNull(FlowKt.combine(this.sharedSelectedState, this.outboundSelectedState, new DeparturesViewModel$switchToStartFromNearestHarbor$2(null))), 1).collect(new DeparturesViewModel$switchToStartFromNearestHarbor$3(this), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public static /* synthetic */ void updateDepartureDirection$default(DeparturesViewModel departuresViewModel, DepartureDirection departureDirection, LocalDate localDate, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            localDate = null;
        }
        departuresViewModel.updateDepartureDirection(departureDirection, localDate);
    }

    public final void dateSelected(LocalDate date) {
        Intrinsics.checkNotNullParameter(date, "date");
        this.routeManager.dateSelected(date);
    }

    public final void departureDayHeaderShown(LocalDate date) {
        Intrinsics.checkNotNullParameter(date, "date");
        IDepartureManager iDepartureManager = this.departureManager;
        LocalDate plusDays = date.plusDays(2L);
        Intrinsics.checkNotNullExpressionValue(plusDays, "plusDays(...)");
        iDepartureManager.ensureLoadingDeparturesUntil(plusDays, this.activeDepartureDirectionState.getValue());
    }

    public final void departureSelected(Departure departure, Function2<? super Departure, ? super DepartureDirection, Unit> proceed) {
        Intrinsics.checkNotNullParameter(departure, "departure");
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        DepartureDirection value = this.activeDepartureDirectionState.getValue();
        this.departureManager.departureSelectionStarted(departure, value);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new DeparturesViewModel$departureSelected$1(this, departure, value, null), 3, null);
        proceed.invoke(departure, value);
    }

    public final void flipDirection() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new DeparturesViewModel$flipDirection$1(this, null), 3, null);
    }

    public final StateFlow<DepartureDirection> getActiveDepartureDirectionState() {
        return this.activeDepartureDirectionState;
    }

    public final StateFlow<BookingType> getBookingTypeState() {
        return this.bookingTypeState;
    }

    public final StateFlow<EditManager.EditState> getEditState() {
        return this.editState;
    }

    public final StateFlow<DepartureState> getOutboundDepartureState() {
        return this.outboundDepartureState;
    }

    public final StateFlow<DepartureTabState> getOutboundDepartureTabState() {
        return this.outboundDepartureTabState;
    }

    public final StateFlow<RouteSelectedState> getOutboundSelectedState() {
        return this.outboundSelectedState;
    }

    public final StateFlow<DepartureState> getReturnDepartureState() {
        return this.returnDepartureState;
    }

    public final StateFlow<DepartureTabState> getReturnDepartureTabState() {
        return this.returnDepartureTabState;
    }

    public final StateFlow<RouteSelectedState> getReturnSelectedState() {
        return this.returnSelectedState;
    }

    public final StateFlow<ReturnManager.ReturnState> getReturnState() {
        return this.returnState;
    }

    public final StateFlow<RouteState> getRouteState() {
        return this.routeState;
    }

    public final StateFlow<RouteSharedSelectedState> getSharedSelectedState() {
        return this.sharedSelectedState;
    }

    public final boolean getSplitTestMoveReturnTripSelector() {
        return this.splitTestMoveReturnTripSelector;
    }

    public final boolean getSplitTestShowRouteSwitchWithText() {
        return this.splitTestShowRouteSwitchWithText;
    }

    public final void handlePromptForCargoDetails(Function1<? super String, Unit> promptForCargoDetails) {
        Transportation selectedTransportation;
        Intrinsics.checkNotNullParameter(promptForCargoDetails, "promptForCargoDetails");
        RouteSharedSelectedState value = this.sharedSelectedState.getValue();
        if (value == null || (selectedTransportation = value.getSelectedTransportation()) == null || this.bookingTypeState.getValue() != BookingType.TwoWay || !selectedTransportation.isFreightPossible()) {
            return;
        }
        RouteSelectedState value2 = this.returnSelectedState.getValue();
        if ((value2 != null ? value2.getTransportationCargoInfo() : null) == null) {
            promptForCargoDetails.invoke(selectedTransportation.getId());
        }
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public boolean isCommuter() {
        return this.$$delegate_0.isCommuter();
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public boolean isEditing() {
        return this.$$delegate_0.isEditing();
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public boolean isExpired() {
        return this.$$delegate_0.isExpired();
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public boolean isInCheckoutFlow() {
        return this.$$delegate_0.isInCheckoutFlow();
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public boolean isMultiRide() {
        return this.$$delegate_0.isMultiRide();
    }

    public final void locationPermissionGranted() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new DeparturesViewModel$locationPermissionGranted$1(this, null), 3, null);
    }

    public final void onCargoFlowCancelled() {
        if (this.returnState.getValue().getIsAddingReturnFromBookingSummary()) {
            return;
        }
        BookingType bookingType = this.previousSelectedBookingType;
        if (bookingType != null) {
            updateBookingType(bookingType, new Function1() { // from class: J2.h0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit onCargoFlowCancelled$lambda$2$lambda$1;
                    onCargoFlowCancelled$lambda$2$lambda$1 = DeparturesViewModel.onCargoFlowCancelled$lambda$2$lambda$1((String) obj);
                    return onCargoFlowCancelled$lambda$2$lambda$1;
                }
            });
        }
        this.previousSelectedBookingType = null;
    }

    public final void onTripTypeDisabledClick() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new DeparturesViewModel$onTripTypeDisabledClick$1(this, null), 3, null);
    }

    public final void proceedWithEditDeparture(Function1<? super Direction, Unit> proceed) {
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        Direction startCheckout = this.checkoutNavigator.startCheckout();
        if (startCheckout == null) {
            return;
        }
        proceed.invoke(startCheckout);
    }

    public final void reloadDeparturesAfterError(DepartureDirection departureDirection) {
        DepartureTabState value;
        Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
        MutableStateFlow<DepartureTabState> mutableStateFlow = departureDirection == DepartureDirection.Outbound ? this._outboundDepartureTabState : this._returnDepartureTabState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, DepartureTabState.copy$default(value, true, null, false, 2, null)));
        this.departureManager.reloadDepartures(departureDirection);
    }

    public final void removeAllSelectedTransportProducts() {
        this.routeManager.removeAllSelectedTransportProducts(this.returnManager.getReturnState().getValue().getIsAddingReturnFromBookingSummary());
    }

    public final void removeSelectedTrailer() {
        this.routeManager.removeSelectedTrailer(this.returnManager.getReturnState().getValue().getIsAddingReturnFromBookingSummary());
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public void resetCheckoutAfterExpiredDepartures() {
        this.$$delegate_0.resetCheckoutAfterExpiredDepartures();
    }

    public final void showChangeFeeWarning(Context context, DepartureTicket departureTicket) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(departureTicket, "departureTicket");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new DeparturesViewModel$showChangeFeeWarning$1(departureTicket, context, this, null), 3, null);
    }

    public final void showCompanyAccountPopup() {
        this.companyViewHelper.showCompanyPopup();
    }

    public final void showDirections(String directionsDestination, Context context) {
        TravelTimeToNearestHarborOnRoute travelTime;
        String str;
        RouteDirectionGroup selectedRouteDirectionGroup;
        HarborReference departureHarbor;
        Intrinsics.checkNotNullParameter(directionsDestination, "directionsDestination");
        Intrinsics.checkNotNullParameter(context, "context");
        GoogleMapsNavigationHandler.INSTANCE.startNavigation(directionsDestination, context, !Feature.OnlyWalkingPassengers.isEnabled());
        int i5 = WhenMappings.$EnumSwitchMapping$0[this.activeDepartureDirectionState.getValue().ordinal()];
        if (i5 == 1) {
            travelTime = this.outboundDepartureTabState.getValue().getTravelTime();
        } else {
            if (i5 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            travelTime = this.returnDepartureTabState.getValue().getTravelTime();
        }
        IAnalyticsTracker iAnalyticsTracker = this.analyticsTracker;
        int travelTimeHours = travelTime == null ? 0 : (travelTime.getTravelTimeHours() * 60) + travelTime.getTravelTimeMinutes();
        RouteSelectedState value = this.routeManager.getActiveSelectedState().getValue();
        if (value == null || (selectedRouteDirectionGroup = value.getSelectedRouteDirectionGroup()) == null || (departureHarbor = selectedRouteDirectionGroup.getDepartureHarbor()) == null || (str = departureHarbor.getName()) == null) {
            str = BuildConfig.FLAVOR;
        }
        iAnalyticsTracker.trackEvent(new AnalyticsEvent.ShowDirectionsEvent(travelTimeHours, str));
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public boolean showReloadDialog() {
        return this.$$delegate_0.showReloadDialog();
    }

    public final void stopAddingReturnFromBookingSummary() {
        this.returnManager.stopAddingReturnFromBookingSummary();
    }

    public final void stopEdit() {
        this.editManager.stopEdit();
    }

    public final void trackInitiatedBooking() {
        this.analyticsTracker.trackEvent(AnalyticsEvent.BookingInitiated.INSTANCE);
    }

    public final void updateBookingStateTracking() {
        AnalyticsStateTrackingHelper.BookingFlowTypeTracking bookingFlowTypeTracking;
        Site site;
        IAnalyticsTracker iAnalyticsTracker = this.analyticsTracker;
        boolean isEditing = this.editState.getValue().getIsEditing();
        RouteSharedSelectedState value = this.routeManager.getSharedSelectedState().getValue();
        if ((value != null ? value.getMultiRideBookingData() : null) != null) {
            bookingFlowTypeTracking = AnalyticsStateTrackingHelper.BookingFlowTypeTracking.MultiRideTicket;
        } else {
            RouteSharedSelectedState value2 = this.routeManager.getSharedSelectedState().getValue();
            bookingFlowTypeTracking = (value2 != null ? value2.getCommuterBookingData() : null) != null ? AnalyticsStateTrackingHelper.BookingFlowTypeTracking.CommuteTicket : AnalyticsStateTrackingHelper.BookingFlowTypeTracking.Ticket;
        }
        iAnalyticsTracker.updateBookingTypeStateTracking(isEditing, bookingFlowTypeTracking);
        IAnalyticsTracker iAnalyticsTracker2 = this.analyticsTracker;
        RouteSharedSelectedState value3 = this.routeManager.getSharedSelectedState().getValue();
        if (value3 == null || (site = value3.getSite()) == null) {
            return;
        }
        BookingType value4 = this.bookingTypeState.getValue();
        RouteSharedSelectedState value5 = this.routeManager.getSharedSelectedState().getValue();
        iAnalyticsTracker2.updateBookingStateTracking(site, value4, value5 != null ? value5.getSelectedTransportation() : null);
    }

    public final void updateBookingType(BookingType type, Function1<? super String, Unit> promptForCargoDetails) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(promptForCargoDetails, "promptForCargoDetails");
        this.previousSelectedBookingType = this.bookingTypeState.getValue();
        IRouteManager iRouteManager = this.routeManager;
        Departure selectedDeparture = this.departureManager.getOutboundState().getValue().getSelectedDeparture();
        iRouteManager.updateBookingType(type, selectedDeparture != null ? selectedDeparture.getDate() : null);
        handlePromptForCargoDetails(promptForCargoDetails);
    }

    public final void updateDepartureDirection(DepartureDirection departureDirection, LocalDate calendarSelectedDate) {
        Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
        if (departureDirection == DepartureDirection.Return && this.outboundDepartureState.getValue().getSelectedDeparture() == null) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new DeparturesViewModel$updateDepartureDirection$1(this, null), 3, null);
            return;
        }
        this.routeManager.getReturnSelectedState().getValue();
        IRouteManager iRouteManager = this.routeManager;
        if (calendarSelectedDate == null) {
            Departure selectedDeparture = this.outboundDepartureState.getValue().getSelectedDeparture();
            calendarSelectedDate = selectedDeparture != null ? selectedDeparture.getDate() : null;
        }
        iRouteManager.updateDepartureDirection(departureDirection, calendarSelectedDate);
    }

    public final void updateShownHeaderDate(LocalDate date) {
        Intrinsics.checkNotNullParameter(date, "date");
        this.departureManager.updateShownHeaderDate(date, this.activeDepartureDirectionState.getValue());
    }
}
