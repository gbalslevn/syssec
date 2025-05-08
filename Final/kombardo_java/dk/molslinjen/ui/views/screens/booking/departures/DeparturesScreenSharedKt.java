package dk.molslinjen.ui.views.screens.booking.departures;

import android.content.Context;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.LifecycleEffectKt;
import androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult;
import androidx.lifecycle.compose.LifecycleResumePauseEffectScope;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.CalendarScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.CargoDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.PassengerCountSelectorScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.RouteSelectorScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TicketTypeScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TrailerSelectorScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TransportProductSelectorScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TransportationSelectorScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.OpenResultRecipientKt;
import com.ramcosta.composedestinations.result.ResultRecipient;
import com.ramcosta.composedestinations.spec.Direction;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.managers.checkout.EditManager;
import dk.molslinjen.domain.managers.checkout.ReturnManager;
import dk.molslinjen.domain.managers.departure.DepartureState;
import dk.molslinjen.domain.managers.route.RouteSelectedState;
import dk.molslinjen.domain.managers.route.RouteSharedSelectedState;
import dk.molslinjen.domain.managers.route.RouteState;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.DepartureTicket;
import dk.molslinjen.domain.model.booking.MultiRideBookingData;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.booking.RouteDirection;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.config.HarborReference;
import dk.molslinjen.domain.model.config.RouteDirectionGroup;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.IndexHolder;
import dk.molslinjen.ui.views.reusable.ItemIndexedKt;
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetButtonKt;
import dk.molslinjen.ui.views.screens.booking.departures.DeparturesScreenSharedKt;
import dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel;
import dk.molslinjen.ui.views.screens.booking.departures.calendar.CalendarSheetType;
import dk.molslinjen.ui.views.screens.booking.departures.infoAlert.InfoAlertViewKt;
import dk.molslinjen.ui.views.screens.booking.departures.infoAlert.InfoAlertViewModel;
import dk.molslinjen.ui.views.screens.booking.departures.rows.TimeToLocationViewKt;
import dk.molslinjen.ui.views.screens.config.regular.checkout.helpers.ICheckoutExpirationDialogHandler;
import dk.molslinjen.ui.views.shared.infoBanner.InfoBannerViewKt;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001ac\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001aU\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0003¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0083\u0004\u0010M\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010'\u001a\u0004\u0018\u00010%2\b\u0010(\u001a\u0004\u0018\u00010%2\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010+2\b\u0010-\u001a\u0004\u0018\u00010+2\u0006\u0010.\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00172\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00100/2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u0010022\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00100/2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u0010022\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00100/2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u0010022\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u0010022\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u0010022\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0010022\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u0010022\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00100/2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u0010022\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00100/2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00100/2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u0010022\u0018\u0010D\u001a\u0014\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u00100A2\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u0010022\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00100/2$\u0010I\u001a \u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00100Gj\u0002`H2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u0010022\u0006\u0010K\u001a\u00020\t2\u0006\u0010L\u001a\u00020\tH\u0003¢\u0006\u0004\bM\u0010N\u001a]\u0010S\u001a\u00020\u0010*\u00020O2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010Q\u001a\u00020P2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u0010022\u0018\u0010D\u001a\u0014\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u00100A2\b\u0010R\u001a\u0004\u0018\u00010BH\u0002¢\u0006\u0004\bS\u0010T\u001aK\u0010U\u001a\u00020\u0010*\u00020O2\u0006\u0010!\u001a\u00020 2\u0006\u0010Q\u001a\u00020P2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u0010022\u0018\u0010D\u001a\u0014\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u00100AH\u0002¢\u0006\u0004\bU\u0010V*>\u0010W\"\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00100G2\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00100G¨\u0006[²\u0006\f\u0010X\u001a\u00020\t8\nX\u008a\u0084\u0002²\u0006\f\u0010Y\u001a\u00020\t8\nX\u008a\u0084\u0002²\u0006\f\u0010Z\u001a\u00020\t8\nX\u008a\u0084\u0002"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/DeparturesViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Lcom/ramcosta/composedestinations/result/ResultRecipient;", "Lcom/ramcosta/composedestinations/generated/destinations/CalendarScreenDestination;", "Lorg/threeten/bp/LocalDate;", "calendarResultRecipient", "Lcom/ramcosta/composedestinations/generated/destinations/TransportationSelectorScreenDestination;", BuildConfig.FLAVOR, "transportationSelectorResultRecipient", "Lcom/ramcosta/composedestinations/generated/destinations/TicketTypeScreenDestination;", "Ljava/util/UUID;", "onOutboundDepartureSelectedResultRecipient", "Ldk/molslinjen/ui/views/screens/config/regular/checkout/helpers/ICheckoutExpirationDialogHandler;", "checkoutExpirationDialogHandler", BuildConfig.FLAVOR, "DeparturesScreenShared", "(Ldk/molslinjen/ui/views/screens/booking/departures/DeparturesViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Lcom/ramcosta/composedestinations/result/ResultRecipient;Lcom/ramcosta/composedestinations/result/ResultRecipient;Lcom/ramcosta/composedestinations/result/ResultRecipient;Ldk/molslinjen/ui/views/screens/config/regular/checkout/helpers/ICheckoutExpirationDialogHandler;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/domain/managers/departure/DepartureState;", "outboundDepartureState", "Ldk/molslinjen/domain/model/booking/BookingType;", "bookingType", "Ldk/molslinjen/domain/managers/checkout/EditManager$EditState;", "editState", "Landroidx/compose/foundation/lazy/LazyListState;", "listState", "selectedCalendarDate", "HandleDepartureSelectionChanges", "(Ldk/molslinjen/domain/managers/departure/DepartureState;Lcom/ramcosta/composedestinations/result/ResultRecipient;Ldk/molslinjen/domain/model/booking/BookingType;Ldk/molslinjen/ui/views/screens/booking/departures/DeparturesViewModel;Ldk/molslinjen/domain/managers/checkout/EditManager$EditState;Landroidx/compose/foundation/lazy/LazyListState;Lorg/threeten/bp/LocalDate;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "selectedTripDirection", "Ldk/molslinjen/ui/views/screens/booking/departures/DepartureTabState;", "departureTabState", "departureState", "Ldk/molslinjen/domain/managers/route/RouteState;", "routeState", "Ldk/molslinjen/domain/managers/route/RouteSelectedState;", "routeSelectedState", "outboundRouteSelectedState", "returnRouteSelectedState", "Ldk/molslinjen/domain/managers/route/RouteSharedSelectedState;", "routeSharedSelectedState", "Ldk/molslinjen/domain/model/booking/Departure;", "outboundDeparture", "returnDeparture", "isAddingReturnFromBookingSummary", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/booking/RouteDirection;", "showRouteSelector", "Lkotlin/Function0;", "showTransportationSelector", "updateBookingType", "flipDirection", "updateDepartureDirection", "showPassengerCountSelector", "showTrailerSelector", "showTransportProductsSelector", "removeSelectedTrailer", "removeAllSelectedTransportProducts", "departureSelected", "proceedWithEditDeparture", "updateShownHeaderDate", "departureDayHeaderShown", "locationPermissionGranted", "Lkotlin/Function2;", BuildConfig.FLAVOR, "Landroid/content/Context;", "showDirections", "onTripTypeDisabledClick", "reloadDeparturesAfterError", "Lkotlin/Function3;", "Ldk/molslinjen/ui/views/screens/booking/departures/ShowCalendarCallback;", "showCalendar", "onOpenedDatePicker", "splitTestMoveReturnTripSelector", "splitTestShowRouteSwitchWithText", "DeparturesContent", "(Ldk/molslinjen/domain/model/booking/BookingType;Ldk/molslinjen/domain/model/booking/DepartureDirection;Ldk/molslinjen/ui/views/screens/booking/departures/DepartureTabState;Ldk/molslinjen/domain/managers/departure/DepartureState;Ldk/molslinjen/domain/managers/route/RouteState;Ldk/molslinjen/domain/managers/route/RouteSelectedState;Ldk/molslinjen/domain/managers/route/RouteSelectedState;Ldk/molslinjen/domain/managers/route/RouteSelectedState;Ldk/molslinjen/domain/managers/route/RouteSharedSelectedState;Ldk/molslinjen/domain/model/booking/Departure;Ldk/molslinjen/domain/model/booking/Departure;ZLdk/molslinjen/domain/managers/checkout/EditManager$EditState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;ZZLandroidx/compose/runtime/Composer;IIII)V", "Landroidx/compose/foundation/lazy/LazyListScope;", "Ldk/molslinjen/ui/views/reusable/IndexHolder;", "indexCounter", "siteDepartureNotice", "departureInfoViews", "(Landroidx/compose/foundation/lazy/LazyListScope;Ldk/molslinjen/domain/model/booking/DepartureDirection;Ldk/molslinjen/ui/views/screens/booking/departures/DepartureTabState;Ldk/molslinjen/ui/views/reusable/IndexHolder;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Ljava/lang/String;)V", "timeToHarborView", "(Landroidx/compose/foundation/lazy/LazyListScope;Ldk/molslinjen/ui/views/screens/booking/departures/DepartureTabState;Ldk/molslinjen/ui/views/reusable/IndexHolder;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;)V", "ShowCalendarCallback", "showScrollToTop", "isDepartureHarbourNordby", "isSticky", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DeparturesScreenSharedKt {

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

    private static final void DeparturesContent(final BookingType bookingType, final DepartureDirection departureDirection, final DepartureTabState departureTabState, final DepartureState departureState, final RouteState routeState, final RouteSelectedState routeSelectedState, final RouteSelectedState routeSelectedState2, final RouteSelectedState routeSelectedState3, final RouteSharedSelectedState routeSharedSelectedState, final Departure departure, final Departure departure2, final boolean z5, final EditManager.EditState editState, final Function1<? super RouteDirection, Unit> function1, final Function0<Unit> function0, final Function1<? super BookingType, Unit> function12, final Function0<Unit> function02, final Function1<? super DepartureDirection, Unit> function13, final Function0<Unit> function03, final Function0<Unit> function04, final Function0<Unit> function05, final Function0<Unit> function06, final Function0<Unit> function07, final Function1<? super Departure, Unit> function14, final Function0<Unit> function08, final Function1<? super LocalDate, Unit> function15, final Function1<? super LocalDate, Unit> function16, final Function0<Unit> function09, final Function2<? super String, ? super Context, Unit> function2, final LazyListState lazyListState, final Function0<Unit> function010, final Function1<? super DepartureDirection, Unit> function17, final Function3<? super LocalDate, ? super LocalDate, ? super LocalDate, Unit> function3, final Function0<Unit> function011, final boolean z6, final boolean z7, Composer composer, final int i5, final int i6, final int i7, final int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        Function0 function012;
        int i15;
        BoxScopeInstance boxScopeInstance;
        Composer composer2;
        Composer composer3;
        BoxScopeInstance boxScopeInstance2;
        RouteDirectionGroup selectedRouteDirectionGroup;
        HarborReference departureHarbor;
        Composer startRestartGroup = composer.startRestartGroup(1368790375);
        if ((i5 & 6) == 0) {
            i9 = i5 | (startRestartGroup.changed(bookingType) ? 4 : 2);
        } else {
            i9 = i5;
        }
        if ((i5 & 48) == 0) {
            i9 |= startRestartGroup.changed(departureDirection) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i9 |= startRestartGroup.changedInstance(departureTabState) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i9 |= startRestartGroup.changedInstance(departureState) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i9 |= startRestartGroup.changedInstance(routeState) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i9 |= startRestartGroup.changedInstance(routeSelectedState) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i9 |= startRestartGroup.changedInstance(routeSelectedState2) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i9 |= startRestartGroup.changedInstance(routeSelectedState3) ? 8388608 : 4194304;
        }
        if ((100663296 & i5) == 0) {
            i9 |= startRestartGroup.changedInstance(routeSharedSelectedState) ? 67108864 : 33554432;
        }
        if ((805306368 & i5) == 0) {
            i9 |= startRestartGroup.changedInstance(departure) ? 536870912 : 268435456;
        }
        int i16 = i9;
        if ((i6 & 6) == 0) {
            i10 = i6 | (startRestartGroup.changedInstance(departure2) ? 4 : 2);
        } else {
            i10 = i6;
        }
        if ((i6 & 48) == 0) {
            i10 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i10 |= startRestartGroup.changedInstance(editState) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i10 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            i10 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((i6 & 196608) == 0) {
            i10 |= startRestartGroup.changedInstance(function12) ? 131072 : 65536;
        }
        if ((i6 & 1572864) == 0) {
            i10 |= startRestartGroup.changedInstance(function02) ? 1048576 : 524288;
        }
        if ((i6 & 12582912) == 0) {
            i10 |= startRestartGroup.changedInstance(function13) ? 8388608 : 4194304;
        }
        if ((i6 & 100663296) == 0) {
            i10 |= startRestartGroup.changedInstance(function03) ? 67108864 : 33554432;
        }
        if ((i6 & 805306368) == 0) {
            i10 |= startRestartGroup.changedInstance(function04) ? 536870912 : 268435456;
        }
        int i17 = i10;
        if ((i7 & 6) == 0) {
            i11 = i7 | (startRestartGroup.changedInstance(function05) ? 4 : 2);
        } else {
            i11 = i7;
        }
        if ((i7 & 48) == 0) {
            i11 |= startRestartGroup.changedInstance(function06) ? 32 : 16;
        }
        if ((i7 & 384) == 0) {
            i11 |= startRestartGroup.changedInstance(function07) ? 256 : 128;
        }
        if ((i7 & 3072) == 0) {
            i11 |= startRestartGroup.changedInstance(function14) ? 2048 : 1024;
        }
        if ((i7 & 24576) == 0) {
            i11 |= startRestartGroup.changedInstance(function08) ? 16384 : 8192;
        }
        if ((i7 & 196608) == 0) {
            i11 |= startRestartGroup.changedInstance(function15) ? 131072 : 65536;
        }
        if ((i7 & 1572864) == 0) {
            i11 |= startRestartGroup.changedInstance(function16) ? 1048576 : 524288;
        }
        if ((i7 & 12582912) == 0) {
            i11 |= startRestartGroup.changedInstance(function09) ? 8388608 : 4194304;
        }
        if ((i7 & 100663296) == 0) {
            i11 |= startRestartGroup.changedInstance(function2) ? 67108864 : 33554432;
        }
        if ((i7 & 805306368) == 0) {
            i11 |= startRestartGroup.changed(lazyListState) ? 536870912 : 268435456;
        }
        int i18 = i11;
        if ((i8 & 6) == 0) {
            i12 = i8 | (startRestartGroup.changedInstance(function010) ? 4 : 2);
        } else {
            i12 = i8;
        }
        if ((i8 & 48) == 0) {
            i12 |= startRestartGroup.changedInstance(function17) ? 32 : 16;
        }
        if ((i8 & 384) == 0) {
            i12 |= startRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if ((i8 & 3072) == 0) {
            i12 |= startRestartGroup.changedInstance(function011) ? 2048 : 1024;
        }
        if ((i8 & 24576) == 0) {
            i12 |= startRestartGroup.changed(z6) ? 16384 : 8192;
        }
        if ((i8 & 196608) == 0) {
            i12 |= startRestartGroup.changed(z7) ? 131072 : 65536;
        }
        int i19 = i12;
        if ((i16 & 306783379) == 306783378 && (306783379 & i17) == 306783378 && (306783379 & i18) == 306783378 && (74899 & i19) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer3 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1368790375, i16, i17, "dk.molslinjen.ui.views.screens.booking.departures.DeparturesContent (DeparturesScreenShared.kt:335)");
            }
            final boolean z8 = (routeSharedSelectedState != null ? routeSharedSelectedState.getSite() : null) == Site.Fanoe;
            boolean z9 = (routeSharedSelectedState != null ? routeSharedSelectedState.getSite() : null) == Site.Oeresund && routeSharedSelectedState.getSelectedTransportation().isTura();
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.startReplaceGroup(-1632778411);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: J2.P
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        boolean DeparturesContent$lambda$51$lambda$50;
                        DeparturesContent$lambda$51$lambda$50 = DeparturesScreenSharedKt.DeparturesContent$lambda$51$lambda$50(LazyListState.this);
                        return Boolean.valueOf(DeparturesContent$lambda$51$lambda$50);
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            State state = (State) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1632774493);
            int i20 = 1879048192 & i18;
            boolean changedInstance = startRestartGroup.changedInstance(coroutineScope) | (i20 == 536870912);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: J2.S
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeparturesContent$lambda$54$lambda$53;
                        DeparturesContent$lambda$54$lambda$53 = DeparturesScreenSharedKt.DeparturesContent$lambda$54$lambda$53(CoroutineScope.this, lazyListState);
                        return DeparturesContent$lambda$54$lambda$53;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            Function0 function013 = (Function0) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            String id = (routeSelectedState == null || (selectedRouteDirectionGroup = routeSelectedState.getSelectedRouteDirectionGroup()) == null || (departureHarbor = selectedRouteDirectionGroup.getDepartureHarbor()) == null) ? null : departureHarbor.getId();
            startRestartGroup.startReplaceGroup(-1632770059);
            boolean changed = startRestartGroup.changed(id) | startRestartGroup.changed(z8);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: J2.T
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        boolean DeparturesContent$lambda$56$lambda$55;
                        DeparturesContent$lambda$56$lambda$55 = DeparturesScreenSharedKt.DeparturesContent$lambda$56$lambda$55(z8, routeSelectedState);
                        return Boolean.valueOf(DeparturesContent$lambda$56$lambda$55);
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final State state2 = (State) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion2);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion4.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion3.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion2);
            Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
            Modifier weight$default = ColumnScope.weight$default(ColumnScopeInstance.INSTANCE, companion2, 1.0f, false, 2, null);
            AppColor appColor = AppColor.INSTANCE;
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(weight$default, appColor.m3269getGrey60d7_KjU(), null, 2, null);
            PaddingValues m310PaddingValuesa9UjIt4$default = PaddingKt.m310PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(24), 7, null);
            startRestartGroup.startReplaceGroup(-979541214);
            boolean changedInstance2 = startRestartGroup.changedInstance(departure) | startRestartGroup.changedInstance(departure2) | startRestartGroup.changedInstance(editState) | startRestartGroup.changed(z8) | startRestartGroup.changed(z9) | startRestartGroup.changedInstance(routeSelectedState2) | startRestartGroup.changedInstance(routeSelectedState3) | startRestartGroup.changedInstance(routeSharedSelectedState) | ((i16 & 14) == 4) | ((i16 & 112) == 32) | startRestartGroup.changedInstance(routeState) | ((i17 & 112) == 32) | ((i17 & 7168) == 2048) | ((57344 & i17) == 16384) | ((458752 & i17) == 131072) | ((3670016 & i17) == 1048576) | ((29360128 & i17) == 8388608) | ((234881024 & i17) == 67108864) | ((i17 & 1879048192) == 536870912) | ((i18 & 14) == 4) | ((i18 & 112) == 32) | ((i18 & 896) == 256) | ((i19 & 14) == 4) | ((i19 & 57344) == 16384) | ((i19 & 458752) == 131072) | startRestartGroup.changedInstance(routeSelectedState) | (i20 == 536870912) | startRestartGroup.changedInstance(departureState) | ((i19 & 896) == 256) | ((i19 & 7168) == 2048) | startRestartGroup.changedInstance(departureTabState) | ((29360128 & i18) == 8388608) | ((234881024 & i18) == 67108864) | startRestartGroup.changed(state2) | ((458752 & i18) == 131072) | ((3670016 & i18) == 1048576) | ((i18 & 7168) == 2048);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue5 == companion.getEmpty()) {
                i13 = i16;
                i14 = i18;
                function012 = function013;
                final boolean z10 = z8;
                final boolean z11 = z9;
                i15 = i19;
                boxScopeInstance = boxScopeInstance3;
                Function1 function18 = new Function1() { // from class: J2.U
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DeparturesContent$lambda$66$lambda$61$lambda$59$lambda$58;
                        DeparturesContent$lambda$66$lambda$61$lambda$59$lambda$58 = DeparturesScreenSharedKt.DeparturesContent$lambda$66$lambda$61$lambda$59$lambda$58(DepartureDirection.this, departureTabState, function09, function2, departureState, routeSelectedState, lazyListState, function15, function16, function14, departure, departure2, editState, z10, z11, routeSelectedState2, routeSelectedState3, routeSharedSelectedState, bookingType, routeState, z5, function1, function0, function12, function02, function13, function03, function04, function05, function06, function07, function010, z6, z7, function3, function011, state2, (LazyListScope) obj);
                        return DeparturesContent$lambda$66$lambda$61$lambda$59$lambda$58;
                    }
                };
                composer2 = startRestartGroup;
                composer2.updateRememberedValue(function18);
                rememberedValue5 = function18;
            } else {
                composer2 = startRestartGroup;
                i15 = i19;
                function012 = function013;
                boxScopeInstance = boxScopeInstance3;
                i13 = i16;
                i14 = i18;
            }
            composer2.endReplaceGroup();
            LazyDslKt.LazyColumn(m104backgroundbw27NRU$default, lazyListState, m310PaddingValuesa9UjIt4$default, false, null, null, null, false, (Function1) rememberedValue5, composer2, ((i14 >> 24) & 112) | 384, 248);
            composer2.startReplaceGroup(-979376650);
            if (editState.getBooking() != null) {
                Modifier m104backgroundbw27NRU$default2 = BackgroundKt.m104backgroundbw27NRU$default(ModifierExtensionsKt.topShadow(companion2), appColor.m3281getWhite0d7_KjU(), null, 2, null);
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, m104backgroundbw27NRU$default2);
                Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor3);
                } else {
                    composer2.useNode();
                }
                Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer2);
                Updater.m1227setimpl(m1226constructorimpl3, maybeCachedBoxMeasurePolicy2, companion4.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
                if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion4.getSetModifier());
                composer3 = composer2;
                BottomSheetButtonKt.m3397BottomSheetButton1YH7lEI(StringResources_androidKt.stringResource(R.string.checkout_buttonBar_proceed, composer2, 6), null, departure != null, false, false, 0L, null, function08, composer2, (i14 << 9) & 29360128, 122);
                composer3.endNode();
            } else {
                composer3 = composer2;
            }
            composer3.endReplaceGroup();
            composer3.endNode();
            composer3.startReplaceGroup(-1248462513);
            if (departureTabState.getShowLoadDepartureError()) {
                boxScopeInstance2 = boxScopeInstance;
                DepartureErrorViewKt.DepartureErrorView(boxScopeInstance2, function17, departureDirection, composer3, (i15 & 112) | 6 | ((i13 << 3) & 896));
            } else {
                boxScopeInstance2 = boxScopeInstance;
            }
            composer3.endReplaceGroup();
            Modifier align = boxScopeInstance2.align(companion2, companion3.getBottomEnd());
            boolean DeparturesContent$lambda$52 = DeparturesContent$lambda$52(state);
            composer3.startReplaceGroup(-1248452854);
            Object rememberedValue6 = composer3.rememberedValue();
            if (rememberedValue6 == companion.getEmpty()) {
                rememberedValue6 = new Function1() { // from class: J2.V
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        int DeparturesContent$lambda$66$lambda$63$lambda$62;
                        DeparturesContent$lambda$66$lambda$63$lambda$62 = DeparturesScreenSharedKt.DeparturesContent$lambda$66$lambda$63$lambda$62(((Integer) obj).intValue());
                        return Integer.valueOf(DeparturesContent$lambda$66$lambda$63$lambda$62);
                    }
                };
                composer3.updateRememberedValue(rememberedValue6);
            }
            composer3.endReplaceGroup();
            EnterTransition slideInVertically$default = EnterExitTransitionKt.slideInVertically$default(null, (Function1) rememberedValue6, 1, null);
            composer3.startReplaceGroup(-1248451382);
            Object rememberedValue7 = composer3.rememberedValue();
            if (rememberedValue7 == companion.getEmpty()) {
                rememberedValue7 = new Function1() { // from class: J2.W
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        int DeparturesContent$lambda$66$lambda$65$lambda$64;
                        DeparturesContent$lambda$66$lambda$65$lambda$64 = DeparturesScreenSharedKt.DeparturesContent$lambda$66$lambda$65$lambda$64(((Integer) obj).intValue());
                        return Integer.valueOf(DeparturesContent$lambda$66$lambda$65$lambda$64);
                    }
                };
                composer3.updateRememberedValue(rememberedValue7);
            }
            composer3.endReplaceGroup();
            final Function0 function014 = function012;
            AnimatedVisibilityKt.AnimatedVisibility(DeparturesContent$lambda$52, align, slideInVertically$default, EnterExitTransitionKt.slideOutVertically$default(null, (Function1) rememberedValue7, 1, null), null, ComposableLambdaKt.rememberComposableLambda(53776841, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.DeparturesScreenSharedKt$DeparturesContent$1$4
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer4, Integer num) {
                    invoke(animatedVisibilityScope, composer4, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer4, int i21) {
                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(53776841, i21, -1, "dk.molslinjen.ui.views.screens.booking.departures.DeparturesContent.<anonymous>.<anonymous> (DeparturesScreenShared.kt:482)");
                    }
                    Modifier.Companion companion5 = Modifier.INSTANCE;
                    float f5 = 16;
                    Modifier m122clickableXHw0xAI$default = ClickableKt.m122clickableXHw0xAI$default(ClipKt.clip(PaddingKt.m311padding3ABfNKs(companion5, Dp.m2599constructorimpl(f5)), RoundedCornerShapeKt.getCircleShape()), false, null, null, function014, 7, null);
                    AppColor appColor2 = AppColor.INSTANCE;
                    Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BackgroundKt.m103backgroundbw27NRU(m122clickableXHw0xAI$default, appColor2.m3255getBrandBlue10d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.m2599constructorimpl(12));
                    MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = composer4.getCurrentCompositionLocalMap();
                    Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer4, m311padding3ABfNKs);
                    ComposeUiNode.Companion companion6 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor4 = companion6.getConstructor();
                    if (composer4.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer4.startReusableNode();
                    if (composer4.getInserting()) {
                        composer4.createNode(constructor4);
                    } else {
                        composer4.useNode();
                    }
                    Composer m1226constructorimpl4 = Updater.m1226constructorimpl(composer4);
                    Updater.m1227setimpl(m1226constructorimpl4, maybeCachedBoxMeasurePolicy3, companion6.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion6.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion6.getSetCompositeKeyHash();
                    if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    }
                    Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion6.getSetModifier());
                    BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                    IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_arrow_up, composer4, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion5, Dp.m2599constructorimpl(f5)), appColor2.m3281getWhite0d7_KjU(), composer4, 3456, 0);
                    composer4.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer3, 54), composer3, 200064, 16);
            composer3.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: J2.X
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeparturesContent$lambda$67;
                    DeparturesContent$lambda$67 = DeparturesScreenSharedKt.DeparturesContent$lambda$67(BookingType.this, departureDirection, departureTabState, departureState, routeState, routeSelectedState, routeSelectedState2, routeSelectedState3, routeSharedSelectedState, departure, departure2, z5, editState, function1, function0, function12, function02, function13, function03, function04, function05, function06, function07, function14, function08, function15, function16, function09, function2, lazyListState, function010, function17, function3, function011, z6, z7, i5, i6, i7, i8, (Composer) obj, ((Integer) obj2).intValue());
                    return DeparturesContent$lambda$67;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DeparturesContent$lambda$51$lambda$50(LazyListState lazyListState) {
        return lazyListState.getFirstVisibleItemIndex() != 0;
    }

    private static final boolean DeparturesContent$lambda$52(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturesContent$lambda$54$lambda$53(CoroutineScope coroutineScope, LazyListState lazyListState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DeparturesScreenSharedKt$DeparturesContent$scrollToTopOnclick$1$1$1(lazyListState, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DeparturesContent$lambda$56$lambda$55(boolean z5, RouteSelectedState routeSelectedState) {
        RouteDirectionGroup selectedRouteDirectionGroup;
        HarborReference departureHarbor;
        if (z5) {
            if (!Intrinsics.areEqual((routeSelectedState == null || (selectedRouteDirectionGroup = routeSelectedState.getSelectedRouteDirectionGroup()) == null || (departureHarbor = selectedRouteDirectionGroup.getDepartureHarbor()) == null) ? null : departureHarbor.getId(), Constants.Data.EsbjergHarborId)) {
                return true;
            }
        }
        return false;
    }

    private static final boolean DeparturesContent$lambda$57(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturesContent$lambda$66$lambda$61$lambda$59$lambda$58(final DepartureDirection departureDirection, final DepartureTabState departureTabState, Function0 function0, Function2 function2, DepartureState departureState, RouteSelectedState routeSelectedState, LazyListState lazyListState, Function1 function1, Function1 function12, Function1 function13, final Departure departure, final Departure departure2, final EditManager.EditState editState, final boolean z5, final boolean z6, final RouteSelectedState routeSelectedState2, final RouteSelectedState routeSelectedState3, final RouteSharedSelectedState routeSharedSelectedState, final BookingType bookingType, final RouteState routeState, final boolean z7, final Function1 function14, final Function0 function02, final Function1 function15, final Function0 function03, final Function1 function16, final Function0 function04, final Function0 function05, final Function0 function06, final Function0 function07, final Function0 function08, final Function0 function09, final boolean z8, final boolean z9, Function3 function3, Function0 function010, State state, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        IndexHolder indexHolder = new IndexHolder(0, 1, null);
        LocalDate localDate = null;
        ItemIndexedKt.itemIndexed$default(LazyColumn, indexHolder, null, null, ComposableLambdaKt.composableLambdaInstance(108792336, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.DeparturesScreenSharedKt$DeparturesContent$1$1$1$1$1
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope itemIndexed, int i5, Composer composer, int i6) {
                MultiRideBookingData multiRideBookingData;
                Intrinsics.checkNotNullParameter(itemIndexed, "$this$itemIndexed");
                if ((i6 & 129) == 128 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(108792336, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.DeparturesContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DeparturesScreenShared.kt:373)");
                }
                boolean z10 = Departure.this != null;
                boolean z11 = departure2 != null;
                boolean isEditing = editState.getIsEditing();
                boolean z12 = z5 || z6;
                RouteSelectedState routeSelectedState4 = routeSelectedState2;
                PassengerInfo passengerInfo = routeSelectedState4 != null ? routeSelectedState4.getPassengerInfo() : null;
                RouteSelectedState routeSelectedState5 = routeSelectedState3;
                PassengerInfo passengerInfo2 = routeSelectedState5 != null ? routeSelectedState5.getPassengerInfo() : null;
                RouteSelectedState routeSelectedState6 = routeSelectedState2;
                List<Product> selectedTransportProducts = routeSelectedState6 != null ? routeSelectedState6.getSelectedTransportProducts() : null;
                RouteSelectedState routeSelectedState7 = routeSelectedState3;
                List<Product> selectedTransportProducts2 = routeSelectedState7 != null ? routeSelectedState7.getSelectedTransportProducts() : null;
                RouteSharedSelectedState routeSharedSelectedState2 = routeSharedSelectedState;
                DepartureFiltersViewKt.DepartureFiltersView(bookingType, departureDirection, routeState, passengerInfo, passengerInfo2, selectedTransportProducts, selectedTransportProducts2, routeSharedSelectedState, routeSelectedState2, routeSelectedState3, z10, z11, z7, isEditing, function14, function02, function15, function03, function16, function04, function05, function06, function07, function08, z12, (routeSharedSelectedState2 == null || (multiRideBookingData = routeSharedSelectedState2.getMultiRideBookingData()) == null || multiRideBookingData.getRemainingCharges() != 1) ? false : true, function09, z8, z9, composer, 0, 0, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 6, null);
        ItemIndexedKt.stickyHeaderIndexed$default(LazyColumn, indexHolder, null, null, ComposableLambdaKt.composableLambdaInstance(1213265747, true, new DeparturesScreenSharedKt$DeparturesContent$1$1$1$1$2(routeSelectedState, lazyListState, departureState, function3, departureDirection, departure, editState, function010)), 6, null);
        ItemIndexedKt.itemIndexed$default(LazyColumn, indexHolder, null, null, ComposableSingletons$DeparturesScreenSharedKt.INSTANCE.m3457getLambda1$app_kombardoProd(), 6, null);
        departureInfoViews(LazyColumn, departureDirection, departureTabState, indexHolder, function0, function2, departureState.getSiteDepartureNotice());
        if (routeSelectedState != null) {
            localDate = routeSelectedState.getSelectedStartDate();
        }
        DepartureItemsViewKt.departureItemsView(LazyColumn, departureState, localDate, indexHolder, lazyListState.getFirstVisibleItemIndex(), (r21 & 16) != 0 ? false : false, (r21 & 32) != 0 ? true : !DeparturesContent$lambda$57(state), function1, function12, function13);
        ItemIndexedKt.itemIndexed$default(LazyColumn, indexHolder, null, null, ComposableLambdaKt.composableLambdaInstance(-1014507624, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.DeparturesScreenSharedKt$DeparturesContent$1$1$1$1$3
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope itemIndexed, int i5, Composer composer, int i6) {
                Intrinsics.checkNotNullParameter(itemIndexed, "$this$itemIndexed");
                if ((i6 & 129) == 128 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1014507624, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.DeparturesContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DeparturesScreenShared.kt:455)");
                }
                LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, 0.0f, DepartureTabState.this.getIsLoading(), 0, false, null, ComposableSingletons$DeparturesScreenSharedKt.INSTANCE.m3458getLambda2$app_kombardoProd(), composer, 1572864, 59);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int DeparturesContent$lambda$66$lambda$63$lambda$62(int i5) {
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int DeparturesContent$lambda$66$lambda$65$lambda$64(int i5) {
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturesContent$lambda$67(BookingType bookingType, DepartureDirection departureDirection, DepartureTabState departureTabState, DepartureState departureState, RouteState routeState, RouteSelectedState routeSelectedState, RouteSelectedState routeSelectedState2, RouteSelectedState routeSelectedState3, RouteSharedSelectedState routeSharedSelectedState, Departure departure, Departure departure2, boolean z5, EditManager.EditState editState, Function1 function1, Function0 function0, Function1 function12, Function0 function02, Function1 function13, Function0 function03, Function0 function04, Function0 function05, Function0 function06, Function0 function07, Function1 function14, Function0 function08, Function1 function15, Function1 function16, Function0 function09, Function2 function2, LazyListState lazyListState, Function0 function010, Function1 function17, Function3 function3, Function0 function011, boolean z6, boolean z7, int i5, int i6, int i7, int i8, Composer composer, int i9) {
        DeparturesContent(bookingType, departureDirection, departureTabState, departureState, routeState, routeSelectedState, routeSelectedState2, routeSelectedState3, routeSharedSelectedState, departure, departure2, z5, editState, function1, function0, function12, function02, function13, function03, function04, function05, function06, function07, function14, function08, function15, function16, function09, function2, lazyListState, function010, function17, function3, function011, z6, z7, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6), RecomposeScopeImplKt.updateChangedFlags(i7), RecomposeScopeImplKt.updateChangedFlags(i8));
        return Unit.INSTANCE;
    }

    public static final void DeparturesScreenShared(final DeparturesViewModel viewModel, final DestinationsNavigator navigator, final ResultRecipient<CalendarScreenDestination, LocalDate> calendarResultRecipient, final ResultRecipient<TransportationSelectorScreenDestination, Boolean> transportationSelectorResultRecipient, final ResultRecipient<TicketTypeScreenDestination, UUID> onOutboundDepartureSelectedResultRecipient, final ICheckoutExpirationDialogHandler checkoutExpirationDialogHandler, Composer composer, final int i5) {
        int i6;
        DepartureTabState departureTabState;
        DepartureState departureState;
        RouteSelectedState routeSelectedState;
        LocalDate selectedStartDate;
        Composer composer2;
        Composer composer3;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(calendarResultRecipient, "calendarResultRecipient");
        Intrinsics.checkNotNullParameter(transportationSelectorResultRecipient, "transportationSelectorResultRecipient");
        Intrinsics.checkNotNullParameter(onOutboundDepartureSelectedResultRecipient, "onOutboundDepartureSelectedResultRecipient");
        Intrinsics.checkNotNullParameter(checkoutExpirationDialogHandler, "checkoutExpirationDialogHandler");
        Composer startRestartGroup = composer.startRestartGroup(908798254);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(calendarResultRecipient) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(transportationSelectorResultRecipient) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(onOutboundDepartureSelectedResultRecipient) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= (262144 & i5) == 0 ? startRestartGroup.changed(checkoutExpirationDialogHandler) : startRestartGroup.changedInstance(checkoutExpirationDialogHandler) ? 131072 : 65536;
        }
        int i7 = i6;
        if ((74899 & i7) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer3 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(908798254, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.DeparturesScreenShared (DeparturesScreenShared.kt:102)");
            }
            int i8 = i7 & 112;
            int i9 = i7 >> 9;
            checkoutExpirationDialogHandler.HandleDepartureExpiration(viewModel, navigator, startRestartGroup, (i7 & 126) | (i9 & 896));
            startRestartGroup.startReplaceGroup(-1559823511);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: J2.F
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DeparturesScreenShared$lambda$1$lambda$0;
                        DeparturesScreenShared$lambda$1$lambda$0 = DeparturesScreenSharedKt.DeparturesScreenShared$lambda$1$lambda$0(DeparturesViewModel.this, ((Boolean) obj).booleanValue());
                        return DeparturesScreenShared$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            OpenResultRecipientKt.onResult(transportationSelectorResultRecipient, null, (Function1) rememberedValue, startRestartGroup, i9 & 14, 1);
            startRestartGroup.startReplaceGroup(-1559819127);
            boolean changedInstance2 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: J2.d0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DeparturesScreenShared$lambda$3$lambda$2;
                        DeparturesScreenShared$lambda$3$lambda$2 = DeparturesScreenSharedKt.DeparturesScreenShared$lambda$3$lambda$2(DeparturesViewModel.this, (LocalDate) obj);
                        return DeparturesScreenShared$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            OpenResultRecipientKt.onResult(calendarResultRecipient, null, (Function1) rememberedValue2, startRestartGroup, (i7 >> 6) & 14, 1);
            DepartureDirection departureDirection = (DepartureDirection) SnapshotStateKt.collectAsState(viewModel.getActiveDepartureDirectionState(), null, startRestartGroup, 0, 1).getValue();
            DepartureTabState departureTabState2 = (DepartureTabState) SnapshotStateKt.collectAsState(viewModel.getOutboundDepartureTabState(), null, startRestartGroup, 0, 1).getValue();
            DepartureTabState departureTabState3 = (DepartureTabState) SnapshotStateKt.collectAsState(viewModel.getReturnDepartureTabState(), null, startRestartGroup, 0, 1).getValue();
            DepartureState departureState2 = (DepartureState) SnapshotStateKt.collectAsState(viewModel.getOutboundDepartureState(), null, startRestartGroup, 0, 1).getValue();
            DepartureState departureState3 = (DepartureState) SnapshotStateKt.collectAsState(viewModel.getReturnDepartureState(), null, startRestartGroup, 0, 1).getValue();
            RouteState routeState = (RouteState) SnapshotStateKt.collectAsState(viewModel.getRouteState(), null, startRestartGroup, 0, 1).getValue();
            RouteSharedSelectedState routeSharedSelectedState = (RouteSharedSelectedState) SnapshotStateKt.collectAsState(viewModel.getSharedSelectedState(), null, startRestartGroup, 0, 1).getValue();
            RouteSelectedState routeSelectedState2 = (RouteSelectedState) SnapshotStateKt.collectAsState(viewModel.getOutboundSelectedState(), null, startRestartGroup, 0, 1).getValue();
            RouteSelectedState routeSelectedState3 = (RouteSelectedState) SnapshotStateKt.collectAsState(viewModel.getReturnSelectedState(), null, startRestartGroup, 0, 1).getValue();
            BookingType bookingType = (BookingType) SnapshotStateKt.collectAsState(viewModel.getBookingTypeState(), null, startRestartGroup, 0, 1).getValue();
            ReturnManager.ReturnState returnState = (ReturnManager.ReturnState) SnapshotStateKt.collectAsState(viewModel.getReturnState(), null, startRestartGroup, 0, 1).getValue();
            EditManager.EditState editState = (EditManager.EditState) SnapshotStateKt.collectAsState(viewModel.getEditState(), null, startRestartGroup, 0, 1).getValue();
            int[] iArr = WhenMappings.$EnumSwitchMapping$0;
            int i10 = iArr[departureDirection.ordinal()];
            if (i10 == 1) {
                departureTabState = departureTabState2;
            } else {
                if (i10 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                departureTabState = departureTabState3;
            }
            int i11 = iArr[departureDirection.ordinal()];
            if (i11 == 1) {
                departureState = departureState2;
            } else {
                if (i11 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                departureState = departureState3;
            }
            int i12 = iArr[departureDirection.ordinal()];
            if (i12 == 1) {
                routeSelectedState = routeSelectedState2;
            } else {
                if (i12 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                routeSelectedState = routeSelectedState3;
            }
            LazyListState rememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
            if (routeSelectedState == null || (selectedStartDate = routeSelectedState.getSelectedStartDate()) == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: J2.e0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit DeparturesScreenShared$lambda$4;
                            DeparturesScreenShared$lambda$4 = DeparturesScreenSharedKt.DeparturesScreenShared$lambda$4(DeparturesViewModel.this, navigator, calendarResultRecipient, transportationSelectorResultRecipient, onOutboundDepartureSelectedResultRecipient, checkoutExpirationDialogHandler, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return DeparturesScreenShared$lambda$4;
                        }
                    });
                    return;
                }
                return;
            }
            boolean z5 = true;
            HandleDepartureSelectionChanges(departureState2, onOutboundDepartureSelectedResultRecipient, bookingType, viewModel, editState, rememberLazyListState, selectedStartDate, startRestartGroup, (i9 & 112) | ((i7 << 9) & 7168));
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue3 == companion.getEmpty()) {
                composer2 = startRestartGroup;
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2));
                composer2.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue3 = compositionScopedCoroutineScopeCanceller;
            } else {
                composer2 = startRestartGroup;
            }
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue3).getCoroutineScope();
            Unit unit = Unit.INSTANCE;
            composer2.startReplaceGroup(-1559745953);
            boolean changedInstance3 = composer2.changedInstance(coroutineScope) | composer2.changedInstance(viewModel);
            Object rememberedValue4 = composer2.rememberedValue();
            if (changedInstance3 || rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: J2.f0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DisposableEffectResult DeparturesScreenShared$lambda$7$lambda$6;
                        DeparturesScreenShared$lambda$7$lambda$6 = DeparturesScreenSharedKt.DeparturesScreenShared$lambda$7$lambda$6(CoroutineScope.this, viewModel, (DisposableEffectScope) obj);
                        return DeparturesScreenShared$lambda$7$lambda$6;
                    }
                };
                composer2.updateRememberedValue(rememberedValue4);
            }
            composer2.endReplaceGroup();
            EffectsKt.DisposableEffect(unit, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue4, composer2, 6);
            composer2.startReplaceGroup(-1559738749);
            boolean changedInstance4 = composer2.changedInstance(viewModel);
            Object rememberedValue5 = composer2.rememberedValue();
            if (changedInstance4 || rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = new Function1() { // from class: J2.g0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        LifecyclePauseOrDisposeEffectResult DeparturesScreenShared$lambda$10$lambda$9;
                        DeparturesScreenShared$lambda$10$lambda$9 = DeparturesScreenSharedKt.DeparturesScreenShared$lambda$10$lambda$9(DeparturesViewModel.this, (LifecycleResumePauseEffectScope) obj);
                        return DeparturesScreenShared$lambda$10$lambda$9;
                    }
                };
                composer2.updateRememberedValue(rememberedValue5);
            }
            composer2.endReplaceGroup();
            LifecycleEffectKt.LifecycleResumeEffect(unit, null, (Function1) rememberedValue5, composer2, 6, 2);
            Departure selectedDeparture = departureState2.getSelectedDeparture();
            Departure selectedDeparture2 = departureState3.getSelectedDeparture();
            boolean isAddingReturnFromBookingSummary = returnState.getIsAddingReturnFromBookingSummary();
            composer2.startReplaceGroup(-1559690019);
            boolean changedInstance5 = composer2.changedInstance(viewModel);
            Object rememberedValue6 = composer2.rememberedValue();
            if (changedInstance5 || rememberedValue6 == companion.getEmpty()) {
                rememberedValue6 = new DeparturesScreenSharedKt$DeparturesScreenShared$6$1(viewModel);
                composer2.updateRememberedValue(rememberedValue6);
            }
            KFunction kFunction = (KFunction) rememberedValue6;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-1559688056);
            boolean changedInstance6 = composer2.changedInstance(viewModel);
            Object rememberedValue7 = composer2.rememberedValue();
            if (changedInstance6 || rememberedValue7 == companion.getEmpty()) {
                rememberedValue7 = new DeparturesScreenSharedKt$DeparturesScreenShared$7$1(viewModel);
                composer2.updateRememberedValue(rememberedValue7);
            }
            Function1 function1 = (Function1) rememberedValue7;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-1559674427);
            boolean changedInstance7 = composer2.changedInstance(viewModel);
            Object rememberedValue8 = composer2.rememberedValue();
            if (changedInstance7 || rememberedValue8 == companion.getEmpty()) {
                rememberedValue8 = new DeparturesScreenSharedKt$DeparturesScreenShared$8$1(viewModel);
                composer2.updateRememberedValue(rememberedValue8);
            }
            KFunction kFunction2 = (KFunction) rememberedValue8;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-1559671886);
            boolean changedInstance8 = composer2.changedInstance(viewModel);
            Object rememberedValue9 = composer2.rememberedValue();
            if (changedInstance8 || rememberedValue9 == companion.getEmpty()) {
                rememberedValue9 = new DeparturesScreenSharedKt$DeparturesScreenShared$9$1(viewModel);
                composer2.updateRememberedValue(rememberedValue9);
            }
            KFunction kFunction3 = (KFunction) rememberedValue9;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-1559656187);
            boolean changedInstance9 = composer2.changedInstance(viewModel);
            Object rememberedValue10 = composer2.rememberedValue();
            if (changedInstance9 || rememberedValue10 == companion.getEmpty()) {
                rememberedValue10 = new DeparturesScreenSharedKt$DeparturesScreenShared$10$1(viewModel);
                composer2.updateRememberedValue(rememberedValue10);
            }
            KFunction kFunction4 = (KFunction) rememberedValue10;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-1559654009);
            boolean changedInstance10 = composer2.changedInstance(viewModel);
            Object rememberedValue11 = composer2.rememberedValue();
            if (changedInstance10 || rememberedValue11 == companion.getEmpty()) {
                rememberedValue11 = new DeparturesScreenSharedKt$DeparturesScreenShared$11$1(viewModel);
                composer2.updateRememberedValue(rememberedValue11);
            }
            KFunction kFunction5 = (KFunction) rememberedValue11;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-1559651703);
            boolean changedInstance11 = composer2.changedInstance(viewModel);
            Object rememberedValue12 = composer2.rememberedValue();
            if (changedInstance11 || rememberedValue12 == companion.getEmpty()) {
                rememberedValue12 = new DeparturesScreenSharedKt$DeparturesScreenShared$12$1(viewModel);
                composer2.updateRememberedValue(rememberedValue12);
            }
            KFunction kFunction6 = (KFunction) rememberedValue12;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-1559649698);
            boolean changedInstance12 = composer2.changedInstance(viewModel);
            Object rememberedValue13 = composer2.rememberedValue();
            if (changedInstance12 || rememberedValue13 == companion.getEmpty()) {
                rememberedValue13 = new DeparturesScreenSharedKt$DeparturesScreenShared$13$1(viewModel);
                composer2.updateRememberedValue(rememberedValue13);
            }
            KFunction kFunction7 = (KFunction) rememberedValue13;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-1559647737);
            boolean changedInstance13 = composer2.changedInstance(viewModel);
            Object rememberedValue14 = composer2.rememberedValue();
            if (changedInstance13 || rememberedValue14 == companion.getEmpty()) {
                rememberedValue14 = new DeparturesScreenSharedKt$DeparturesScreenShared$14$1(viewModel);
                composer2.updateRememberedValue(rememberedValue14);
            }
            KFunction kFunction8 = (KFunction) rememberedValue14;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-1559645398);
            boolean changedInstance14 = composer2.changedInstance(viewModel);
            Object rememberedValue15 = composer2.rememberedValue();
            if (changedInstance14 || rememberedValue15 == companion.getEmpty()) {
                rememberedValue15 = new DeparturesScreenSharedKt$DeparturesScreenShared$15$1(viewModel);
                composer2.updateRememberedValue(rememberedValue15);
            }
            KFunction kFunction9 = (KFunction) rememberedValue15;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-1559631515);
            boolean changedInstance15 = composer2.changedInstance(viewModel);
            Object rememberedValue16 = composer2.rememberedValue();
            if (changedInstance15 || rememberedValue16 == companion.getEmpty()) {
                rememberedValue16 = new DeparturesScreenSharedKt$DeparturesScreenShared$16$1(viewModel);
                composer2.updateRememberedValue(rememberedValue16);
            }
            KFunction kFunction10 = (KFunction) rememberedValue16;
            composer2.endReplaceGroup();
            boolean splitTestMoveReturnTripSelector = viewModel.getSplitTestMoveReturnTripSelector();
            boolean splitTestShowRouteSwitchWithText = viewModel.getSplitTestShowRouteSwitchWithText();
            composer2.startReplaceGroup(-1559712057);
            boolean z6 = i8 == 32;
            Object rememberedValue17 = composer2.rememberedValue();
            if (z6 || rememberedValue17 == companion.getEmpty()) {
                rememberedValue17 = new Function1() { // from class: J2.G
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DeparturesScreenShared$lambda$23$lambda$22;
                        DeparturesScreenShared$lambda$23$lambda$22 = DeparturesScreenSharedKt.DeparturesScreenShared$lambda$23$lambda$22(DestinationsNavigator.this, (RouteDirection) obj);
                        return DeparturesScreenShared$lambda$23$lambda$22;
                    }
                };
                composer2.updateRememberedValue(rememberedValue17);
            }
            Function1 function12 = (Function1) rememberedValue17;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-1559707688);
            boolean z7 = i8 == 32;
            Object rememberedValue18 = composer2.rememberedValue();
            if (z7 || rememberedValue18 == companion.getEmpty()) {
                rememberedValue18 = new Function0() { // from class: J2.H
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeparturesScreenShared$lambda$25$lambda$24;
                        DeparturesScreenShared$lambda$25$lambda$24 = DeparturesScreenSharedKt.DeparturesScreenShared$lambda$25$lambda$24(DestinationsNavigator.this);
                        return DeparturesScreenShared$lambda$25$lambda$24;
                    }
                };
                composer2.updateRememberedValue(rememberedValue18);
            }
            Function0 function0 = (Function0) rememberedValue18;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-1559700981);
            boolean changedInstance16 = (i8 == 32) | composer2.changedInstance(viewModel);
            Object rememberedValue19 = composer2.rememberedValue();
            if (changedInstance16 || rememberedValue19 == companion.getEmpty()) {
                rememberedValue19 = new Function1() { // from class: J2.I
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DeparturesScreenShared$lambda$28$lambda$27;
                        DeparturesScreenShared$lambda$28$lambda$27 = DeparturesScreenSharedKt.DeparturesScreenShared$lambda$28$lambda$27(DeparturesViewModel.this, navigator, (BookingType) obj);
                        return DeparturesScreenShared$lambda$28$lambda$27;
                    }
                };
                composer2.updateRememberedValue(rememberedValue19);
            }
            Function1 function13 = (Function1) rememberedValue19;
            composer2.endReplaceGroup();
            Function0 function02 = (Function0) kFunction;
            composer2.startReplaceGroup(-1559685640);
            boolean z8 = i8 == 32;
            Object rememberedValue20 = composer2.rememberedValue();
            if (z8 || rememberedValue20 == companion.getEmpty()) {
                rememberedValue20 = new Function0() { // from class: J2.J
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeparturesScreenShared$lambda$30$lambda$29;
                        DeparturesScreenShared$lambda$30$lambda$29 = DeparturesScreenSharedKt.DeparturesScreenShared$lambda$30$lambda$29(DestinationsNavigator.this);
                        return DeparturesScreenShared$lambda$30$lambda$29;
                    }
                };
                composer2.updateRememberedValue(rememberedValue20);
            }
            Function0 function03 = (Function0) rememberedValue20;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-1559681967);
            boolean z9 = i8 == 32;
            Object rememberedValue21 = composer2.rememberedValue();
            if (z9 || rememberedValue21 == companion.getEmpty()) {
                rememberedValue21 = new Function0() { // from class: J2.K
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeparturesScreenShared$lambda$32$lambda$31;
                        DeparturesScreenShared$lambda$32$lambda$31 = DeparturesScreenSharedKt.DeparturesScreenShared$lambda$32$lambda$31(DestinationsNavigator.this);
                        return DeparturesScreenShared$lambda$32$lambda$31;
                    }
                };
                composer2.updateRememberedValue(rememberedValue21);
            }
            Function0 function04 = (Function0) rememberedValue21;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-1559678182);
            boolean z10 = i8 == 32;
            Object rememberedValue22 = composer2.rememberedValue();
            if (z10 || rememberedValue22 == companion.getEmpty()) {
                rememberedValue22 = new Function0() { // from class: J2.Q
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeparturesScreenShared$lambda$34$lambda$33;
                        DeparturesScreenShared$lambda$34$lambda$33 = DeparturesScreenSharedKt.DeparturesScreenShared$lambda$34$lambda$33(DestinationsNavigator.this);
                        return DeparturesScreenShared$lambda$34$lambda$33;
                    }
                };
                composer2.updateRememberedValue(rememberedValue22);
            }
            Function0 function05 = (Function0) rememberedValue22;
            composer2.endReplaceGroup();
            Function0 function06 = (Function0) kFunction2;
            Function0 function07 = (Function0) kFunction3;
            composer2.startReplaceGroup(-1559669320);
            boolean changedInstance17 = (i8 == 32) | composer2.changedInstance(viewModel);
            Object rememberedValue23 = composer2.rememberedValue();
            if (changedInstance17 || rememberedValue23 == companion.getEmpty()) {
                rememberedValue23 = new Function1() { // from class: J2.Z
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DeparturesScreenShared$lambda$37$lambda$36;
                        DeparturesScreenShared$lambda$37$lambda$36 = DeparturesScreenSharedKt.DeparturesScreenShared$lambda$37$lambda$36(DeparturesViewModel.this, navigator, (Departure) obj);
                        return DeparturesScreenShared$lambda$37$lambda$36;
                    }
                };
                composer2.updateRememberedValue(rememberedValue23);
            }
            Function1 function14 = (Function1) rememberedValue23;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-1559661461);
            boolean changedInstance18 = (i8 == 32) | composer2.changedInstance(viewModel);
            Object rememberedValue24 = composer2.rememberedValue();
            if (changedInstance18 || rememberedValue24 == companion.getEmpty()) {
                rememberedValue24 = new Function0() { // from class: J2.a0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeparturesScreenShared$lambda$40$lambda$39;
                        DeparturesScreenShared$lambda$40$lambda$39 = DeparturesScreenSharedKt.DeparturesScreenShared$lambda$40$lambda$39(DeparturesViewModel.this, navigator);
                        return DeparturesScreenShared$lambda$40$lambda$39;
                    }
                };
                composer2.updateRememberedValue(rememberedValue24);
            }
            Function0 function08 = (Function0) rememberedValue24;
            composer2.endReplaceGroup();
            Function1 function15 = (Function1) kFunction4;
            Function1 function16 = (Function1) kFunction5;
            Function0 function09 = (Function0) kFunction6;
            Function2 function2 = (Function2) kFunction7;
            Function0 function010 = (Function0) kFunction8;
            Function1 function17 = (Function1) kFunction9;
            composer2.startReplaceGroup(-1559643110);
            if (i8 != 32) {
                z5 = false;
            }
            Object rememberedValue25 = composer2.rememberedValue();
            if (z5 || rememberedValue25 == companion.getEmpty()) {
                rememberedValue25 = new Function3() { // from class: J2.b0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit DeparturesScreenShared$lambda$42$lambda$41;
                        DeparturesScreenShared$lambda$42$lambda$41 = DeparturesScreenSharedKt.DeparturesScreenShared$lambda$42$lambda$41(DestinationsNavigator.this, (LocalDate) obj, (LocalDate) obj2, (LocalDate) obj3);
                        return DeparturesScreenShared$lambda$42$lambda$41;
                    }
                };
                composer2.updateRememberedValue(rememberedValue25);
            }
            composer2.endReplaceGroup();
            DeparturesContent(bookingType, departureDirection, departureTabState, departureState, routeState, routeSelectedState, routeSelectedState2, routeSelectedState3, routeSharedSelectedState, selectedDeparture, selectedDeparture2, isAddingReturnFromBookingSummary, editState, function12, function0, function13, function02, function1, function03, function04, function05, function06, function07, function14, function08, function15, function16, function09, function2, rememberLazyListState, function010, function17, (Function3) rememberedValue25, (Function0) kFunction10, splitTestMoveReturnTripSelector, splitTestShowRouteSwitchWithText, composer2, 0, 0, 0, 0);
            composer2.startReplaceableGroup(1890788296);
            ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer2, LocalViewModelStoreOwner.$stable);
            if (current == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer2, 0);
            composer2.startReplaceableGroup(1729797275);
            composer3 = composer2;
            ViewModel viewModel2 = ViewModelKt.viewModel((Class<ViewModel>) InfoAlertViewModel.class, current, (String) null, createHiltViewModelFactory, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composer2, 36936, 0);
            composer3.endReplaceableGroup();
            composer3.endReplaceableGroup();
            InfoAlertViewKt.InfoAlertView((InfoAlertViewModel) viewModel2, composer3, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = composer3.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: J2.c0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeparturesScreenShared$lambda$43;
                    DeparturesScreenShared$lambda$43 = DeparturesScreenSharedKt.DeparturesScreenShared$lambda$43(DeparturesViewModel.this, navigator, calendarResultRecipient, transportationSelectorResultRecipient, onOutboundDepartureSelectedResultRecipient, checkoutExpirationDialogHandler, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DeparturesScreenShared$lambda$43;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturesScreenShared$lambda$1$lambda$0(DeparturesViewModel departuresViewModel, boolean z5) {
        if (z5) {
            departuresViewModel.onCargoFlowCancelled();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LifecyclePauseOrDisposeEffectResult DeparturesScreenShared$lambda$10$lambda$9(DeparturesViewModel departuresViewModel, final LifecycleResumePauseEffectScope LifecycleResumeEffect) {
        Intrinsics.checkNotNullParameter(LifecycleResumeEffect, "$this$LifecycleResumeEffect");
        departuresViewModel.showCompanyAccountPopup();
        departuresViewModel.updateBookingStateTracking();
        return new LifecyclePauseOrDisposeEffectResult() { // from class: dk.molslinjen.ui.views.screens.booking.departures.DeparturesScreenSharedKt$DeparturesScreenShared$lambda$10$lambda$9$$inlined$onPauseOrDispose$1
            @Override // androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult
            public void runPauseOrOnDisposeEffect() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturesScreenShared$lambda$23$lambda$22(DestinationsNavigator destinationsNavigator, RouteDirection direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, RouteSelectorScreenDestination.INSTANCE.invoke(direction), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturesScreenShared$lambda$25$lambda$24(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, TransportationSelectorScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturesScreenShared$lambda$28$lambda$27(DeparturesViewModel departuresViewModel, final DestinationsNavigator destinationsNavigator, BookingType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        departuresViewModel.updateBookingType(it, new Function1() { // from class: J2.L
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit DeparturesScreenShared$lambda$28$lambda$27$lambda$26;
                DeparturesScreenShared$lambda$28$lambda$27$lambda$26 = DeparturesScreenSharedKt.DeparturesScreenShared$lambda$28$lambda$27$lambda$26(DestinationsNavigator.this, (String) obj);
                return DeparturesScreenShared$lambda$28$lambda$27$lambda$26;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturesScreenShared$lambda$28$lambda$27$lambda$26(DestinationsNavigator destinationsNavigator, String transportationId) {
        Intrinsics.checkNotNullParameter(transportationId, "transportationId");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, CargoDetailsScreenDestination.INSTANCE.invoke(transportationId), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturesScreenShared$lambda$3$lambda$2(DeparturesViewModel departuresViewModel, LocalDate selectedDate) {
        Intrinsics.checkNotNullParameter(selectedDate, "selectedDate");
        departuresViewModel.dateSelected(selectedDate);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturesScreenShared$lambda$30$lambda$29(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, PassengerCountSelectorScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturesScreenShared$lambda$32$lambda$31(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, TrailerSelectorScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturesScreenShared$lambda$34$lambda$33(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, TransportProductSelectorScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturesScreenShared$lambda$37$lambda$36(DeparturesViewModel departuresViewModel, final DestinationsNavigator destinationsNavigator, Departure it) {
        Intrinsics.checkNotNullParameter(it, "it");
        departuresViewModel.departureSelected(it, new Function2() { // from class: J2.M
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit DeparturesScreenShared$lambda$37$lambda$36$lambda$35;
                DeparturesScreenShared$lambda$37$lambda$36$lambda$35 = DeparturesScreenSharedKt.DeparturesScreenShared$lambda$37$lambda$36$lambda$35(DestinationsNavigator.this, (Departure) obj, (DepartureDirection) obj2);
                return DeparturesScreenShared$lambda$37$lambda$36$lambda$35;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturesScreenShared$lambda$37$lambda$36$lambda$35(DestinationsNavigator destinationsNavigator, Departure departure, DepartureDirection direction) {
        Intrinsics.checkNotNullParameter(departure, "departure");
        Intrinsics.checkNotNullParameter(direction, "direction");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, TicketTypeScreenDestination.INSTANCE.invoke(departure.getId(), direction), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturesScreenShared$lambda$4(DeparturesViewModel departuresViewModel, DestinationsNavigator destinationsNavigator, ResultRecipient resultRecipient, ResultRecipient resultRecipient2, ResultRecipient resultRecipient3, ICheckoutExpirationDialogHandler iCheckoutExpirationDialogHandler, int i5, Composer composer, int i6) {
        DeparturesScreenShared(departuresViewModel, destinationsNavigator, resultRecipient, resultRecipient2, resultRecipient3, iCheckoutExpirationDialogHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturesScreenShared$lambda$40$lambda$39(DeparturesViewModel departuresViewModel, final DestinationsNavigator destinationsNavigator) {
        departuresViewModel.proceedWithEditDeparture(new Function1() { // from class: J2.Y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit DeparturesScreenShared$lambda$40$lambda$39$lambda$38;
                DeparturesScreenShared$lambda$40$lambda$39$lambda$38 = DeparturesScreenSharedKt.DeparturesScreenShared$lambda$40$lambda$39$lambda$38(DestinationsNavigator.this, (Direction) obj);
                return DeparturesScreenShared$lambda$40$lambda$39$lambda$38;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturesScreenShared$lambda$40$lambda$39$lambda$38(DestinationsNavigator destinationsNavigator, Direction direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, direction, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturesScreenShared$lambda$42$lambda$41(DestinationsNavigator destinationsNavigator, LocalDate selectedDate, LocalDate minDate, LocalDate localDate) {
        Intrinsics.checkNotNullParameter(selectedDate, "selectedDate");
        Intrinsics.checkNotNullParameter(minDate, "minDate");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, CalendarScreenDestination.INSTANCE.invoke(selectedDate, CalendarSheetType.LowPrice, minDate, localDate), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturesScreenShared$lambda$43(DeparturesViewModel departuresViewModel, DestinationsNavigator destinationsNavigator, ResultRecipient resultRecipient, ResultRecipient resultRecipient2, ResultRecipient resultRecipient3, ICheckoutExpirationDialogHandler iCheckoutExpirationDialogHandler, int i5, Composer composer, int i6) {
        DeparturesScreenShared(departuresViewModel, destinationsNavigator, resultRecipient, resultRecipient2, resultRecipient3, iCheckoutExpirationDialogHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult DeparturesScreenShared$lambda$7$lambda$6(CoroutineScope coroutineScope, DeparturesViewModel departuresViewModel, DisposableEffectScope DisposableEffect) {
        final Job launch$default;
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DeparturesScreenSharedKt$DeparturesScreenShared$4$1$job$1(departuresViewModel, null), 3, null);
        return new DisposableEffectResult() { // from class: dk.molslinjen.ui.views.screens.booking.departures.DeparturesScreenSharedKt$DeparturesScreenShared$lambda$7$lambda$6$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                Job.DefaultImpls.cancel$default(Job.this, null, 1, null);
            }
        };
    }

    private static final void HandleDepartureSelectionChanges(final DepartureState departureState, final ResultRecipient<TicketTypeScreenDestination, UUID> resultRecipient, final BookingType bookingType, final DeparturesViewModel departuresViewModel, final EditManager.EditState editState, final LazyListState lazyListState, final LocalDate localDate, Composer composer, final int i5) {
        int i6;
        Object obj;
        Departure departure;
        Composer startRestartGroup = composer.startRestartGroup(750369802);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(departureState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(resultRecipient) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(bookingType) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(departuresViewModel) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(editState) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changed(lazyListState) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(localDate) ? 1048576 : 524288;
        }
        int i7 = i6;
        if ((599187 & i7) == 599186 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(750369802, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.HandleDepartureSelectionChanges (DeparturesScreenShared.kt:258)");
            }
            startRestartGroup.startReplaceGroup(1203465718);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1203468871);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: J2.N
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit HandleDepartureSelectionChanges$lambda$46$lambda$45;
                        HandleDepartureSelectionChanges$lambda$46$lambda$45 = DeparturesScreenSharedKt.HandleDepartureSelectionChanges$lambda$46$lambda$45(MutableState.this, (UUID) obj2);
                        return HandleDepartureSelectionChanges$lambda$46$lambda$45;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            OpenResultRecipientKt.onResult(resultRecipient, null, (Function1) rememberedValue2, startRestartGroup, ((i7 >> 3) & 14) | 384, 1);
            Departure selectedDeparture = departureState.getSelectedDeparture();
            Object value = mutableState.getValue();
            startRestartGroup.startReplaceGroup(1203476214);
            boolean changedInstance = startRestartGroup.changedInstance(departureState) | ((i7 & 896) == 256) | startRestartGroup.changedInstance(departuresViewModel) | startRestartGroup.changedInstance(localDate);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue3 == companion.getEmpty()) {
                obj = value;
                departure = selectedDeparture;
                DeparturesScreenSharedKt$HandleDepartureSelectionChanges$2$1 departuresScreenSharedKt$HandleDepartureSelectionChanges$2$1 = new DeparturesScreenSharedKt$HandleDepartureSelectionChanges$2$1(departureState, mutableState, bookingType, departuresViewModel, localDate, null);
                startRestartGroup.updateRememberedValue(departuresScreenSharedKt$HandleDepartureSelectionChanges$2$1);
                rememberedValue3 = departuresScreenSharedKt$HandleDepartureSelectionChanges$2$1;
            } else {
                obj = value;
                departure = selectedDeparture;
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(departure, obj, (Function2) rememberedValue3, startRestartGroup, 0);
            Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            DepartureTicket selectedDepartureTicket = departureState.getSelectedDepartureTicket();
            startRestartGroup.startReplaceGroup(1203490559);
            boolean changedInstance2 = startRestartGroup.changedInstance(departureState) | startRestartGroup.changedInstance(editState) | startRestartGroup.changedInstance(departuresViewModel) | startRestartGroup.changedInstance(context) | startRestartGroup.changedInstance(localDate) | ((458752 & i7) == 131072);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue4 == companion.getEmpty()) {
                DeparturesScreenSharedKt$HandleDepartureSelectionChanges$3$1 departuresScreenSharedKt$HandleDepartureSelectionChanges$3$1 = new DeparturesScreenSharedKt$HandleDepartureSelectionChanges$3$1(departureState, editState, departuresViewModel, context, localDate, lazyListState, null);
                startRestartGroup.updateRememberedValue(departuresScreenSharedKt$HandleDepartureSelectionChanges$3$1);
                rememberedValue4 = departuresScreenSharedKt$HandleDepartureSelectionChanges$3$1;
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(selectedDepartureTicket, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue4, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: J2.O
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit HandleDepartureSelectionChanges$lambda$49;
                    HandleDepartureSelectionChanges$lambda$49 = DeparturesScreenSharedKt.HandleDepartureSelectionChanges$lambda$49(DepartureState.this, resultRecipient, bookingType, departuresViewModel, editState, lazyListState, localDate, i5, (Composer) obj2, ((Integer) obj3).intValue());
                    return HandleDepartureSelectionChanges$lambda$49;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HandleDepartureSelectionChanges$lambda$46$lambda$45(MutableState mutableState, UUID triggerKey) {
        Intrinsics.checkNotNullParameter(triggerKey, "triggerKey");
        mutableState.setValue(triggerKey);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HandleDepartureSelectionChanges$lambda$49(DepartureState departureState, ResultRecipient resultRecipient, BookingType bookingType, DeparturesViewModel departuresViewModel, EditManager.EditState editState, LazyListState lazyListState, LocalDate localDate, int i5, Composer composer, int i6) {
        HandleDepartureSelectionChanges(departureState, resultRecipient, bookingType, departuresViewModel, editState, lazyListState, localDate, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void departureInfoViews(LazyListScope lazyListScope, DepartureDirection departureDirection, DepartureTabState departureTabState, IndexHolder indexHolder, Function0<Unit> function0, Function2<? super String, ? super Context, Unit> function2, final String str) {
        if (departureDirection == DepartureDirection.Outbound) {
            timeToHarborView(lazyListScope, departureTabState, indexHolder, function0, function2);
        }
        if (str != null) {
            ItemIndexedKt.itemIndexed$default(lazyListScope, indexHolder, null, null, ComposableLambdaKt.composableLambdaInstance(-2032611371, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.DeparturesScreenSharedKt$departureInfoViews$1$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                    invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope itemIndexed, int i5, Composer composer, int i6) {
                    Intrinsics.checkNotNullParameter(itemIndexed, "$this$itemIndexed");
                    if ((i6 & 129) == 128 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2032611371, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.departureInfoViews.<anonymous>.<anonymous> (DeparturesScreenShared.kt:520)");
                    }
                    float f5 = 16;
                    InfoBannerViewKt.InfoBannerMarkdownView(PaddingKt.m315paddingqDBjuR0$default(PaddingKt.m313paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m2599constructorimpl(f5), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 7, null), R.drawable.icon_alert_warning, str, composer, 54, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 6, null);
        }
    }

    private static final void timeToHarborView(LazyListScope lazyListScope, final DepartureTabState departureTabState, IndexHolder indexHolder, final Function0<Unit> function0, final Function2<? super String, ? super Context, Unit> function2) {
        ItemIndexedKt.itemIndexed$default(lazyListScope, indexHolder, null, null, ComposableLambdaKt.composableLambdaInstance(1686801198, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.DeparturesScreenSharedKt$timeToHarborView$1
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope itemIndexed, int i5, Composer composer, int i6) {
                Intrinsics.checkNotNullParameter(itemIndexed, "$this$itemIndexed");
                if ((i6 & 129) == 128 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1686801198, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.timeToHarborView.<anonymous> (DeparturesScreenShared.kt:538)");
                }
                float f5 = 16;
                TimeToLocationViewKt.TimeToLocationView(PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m2599constructorimpl(f5), 0.0f, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5), 2, null), DepartureTabState.this.getTravelTime(), function0, function2, composer, 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 6, null);
    }
}
