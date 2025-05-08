package dk.molslinjen.ui.views.screens.tickets.details;

import android.content.Context;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.TicketDetailsScreenDestination;
import dk.molslinjen.core.Feature;
import dk.molslinjen.core.helpers.ExternalActionHelper;
import dk.molslinjen.core.location.GoogleMapsNavigationHandler;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.checkout.IEditManager;
import dk.molslinjen.domain.managers.checkout.ISimpleChangeCheckoutManager;
import dk.molslinjen.domain.managers.configuration.IConfigurationManager;
import dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardManager;
import dk.molslinjen.domain.managers.ticket.ITicketsManager;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.BookingDeparture;
import dk.molslinjen.domain.model.booking.IDepartureInfo;
import dk.molslinjen.domain.model.config.Harbor;
import dk.molslinjen.domain.model.config.LocalizedSiteConfiguration;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails.KombardoTravelDetailsHandler;
import dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails.TravelDetailsState;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001VBS\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ \u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001aH\u0082@¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u001c¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u001c¢\u0006\u0004\b%\u0010$J\r\u0010&\u001a\u00020\u001c¢\u0006\u0004\b&\u0010$J#\u0010)\u001a\u00020\u001c2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001c0'2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b)\u0010*J\u0015\u0010+\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b+\u0010\"J#\u0010-\u001a\u00020\u001c2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001c0'2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b-\u0010*J\r\u0010.\u001a\u00020\u001c¢\u0006\u0004\b.\u0010$J\r\u0010/\u001a\u00020\u001c¢\u0006\u0004\b/\u0010$J\u001d\u00101\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b1\u00102J\u001b\u00104\u001a\u00020\u001c2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001c0'¢\u0006\u0004\b4\u00105J\u0015\u00106\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b6\u0010\"J>\u0010>\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u0002072\u0006\u0010;\u001a\u00020:2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002070<H\u0096\u0001¢\u0006\u0004\b>\u0010?R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010@R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010AR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010BR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010CR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010DR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010ER\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010FR\u0014\u0010H\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020K0J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u001d\u0010O\u001a\b\u0012\u0004\u0012\u00020K0N8\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020S0N8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bT\u0010R¨\u0006W"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/details/TicketDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", BuildConfig.FLAVOR, "Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "snackbarService", "Ldk/molslinjen/domain/managers/ticket/ITicketsManager;", "ticketsManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "userManager", "Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;", "configurationManager", "Ldk/molslinjen/domain/managers/checkout/ISimpleChangeCheckoutManager;", "simpleChangeCheckoutManager", "Ldk/molslinjen/domain/managers/checkout/IEditManager;", "editManager", "Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardManager;", "saleOnBoardManager", "Landroid/content/Context;", "context", "<init>", "(Landroidx/lifecycle/SavedStateHandle;Ldk/molslinjen/core/snackbar/ISnackbarService;Ldk/molslinjen/domain/managers/ticket/ITicketsManager;Ldk/molslinjen/domain/managers/user/IUserManager;Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;Ldk/molslinjen/domain/managers/checkout/ISimpleChangeCheckoutManager;Ldk/molslinjen/domain/managers/checkout/IEditManager;Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardManager;Landroid/content/Context;)V", BuildConfig.FLAVOR, "reservationNumber", "phone", "Ldk/molslinjen/domain/model/config/Site;", "site", BuildConfig.FLAVOR, "loadTicket", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/config/Site;Landroid/content/Context;)V", "buildKombardoRouteDetailsModel", "(Landroid/content/Context;Ldk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reloadTicket", "(Landroid/content/Context;)V", "showRefundDialog", "()V", "hideRefundDialog", "showNotRefundableMessage", "Lkotlin/Function0;", "showRefundReceipt", "refund", "(Lkotlin/jvm/functions/Function0;Landroid/content/Context;)V", "shareReceipt", "startEdit", "editTicket", "showReceiptDisabledMessage", "clearPdfReceiptPath", "address", "showOnMap", "(Ljava/lang/String;Landroid/content/Context;)V", "proceed", "startSimpleChangeFlow", "(Lkotlin/jvm/functions/Function0;)V", "addToCalendar", "Ldk/molslinjen/domain/model/config/Harbor;", "departureHarbor", "arrivalHarbor", "Ldk/molslinjen/domain/model/booking/IDepartureInfo;", "departure", BuildConfig.FLAVOR, "harbors", "buildTravelDetails", "(Landroid/content/Context;Ldk/molslinjen/domain/model/config/Harbor;Ldk/molslinjen/domain/model/config/Harbor;Ldk/molslinjen/domain/model/booking/IDepartureInfo;Ljava/util/List;)V", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "Ldk/molslinjen/domain/managers/ticket/ITicketsManager;", "Ldk/molslinjen/domain/managers/user/IUserManager;", "Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;", "Ldk/molslinjen/domain/managers/checkout/ISimpleChangeCheckoutManager;", "Ldk/molslinjen/domain/managers/checkout/IEditManager;", "Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardManager;", "Ldk/molslinjen/ui/views/screens/tickets/details/TicketDetailsScreenNavArgs;", "navArgs", "Ldk/molslinjen/ui/views/screens/tickets/details/TicketDetailsScreenNavArgs;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/tickets/details/TicketDetailsViewModel$ViewState;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/ui/views/screens/booking/shared/kombardoTravelDetails/IKombardoTravelDetailsHandler$TravelDetailsState;", "getTravelDetailsState", "travelDetailsState", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TicketDetailsViewModel extends ViewModel {
    private final /* synthetic */ KombardoTravelDetailsHandler $$delegate_0;
    private final MutableStateFlow<ViewState> _viewState;
    private final IConfigurationManager configurationManager;
    private final IEditManager editManager;
    private final TicketDetailsScreenNavArgs navArgs;
    private final ISaleOnBoardManager saleOnBoardManager;
    private final ISimpleChangeCheckoutManager simpleChangeCheckoutManager;
    private final ISnackbarService snackbarService;
    private final ITicketsManager ticketsManager;
    private final IUserManager userManager;
    private final StateFlow<ViewState> viewState;

    public TicketDetailsViewModel(SavedStateHandle savedStateHandle, ISnackbarService snackbarService, ITicketsManager ticketsManager, IUserManager userManager, IConfigurationManager configurationManager, ISimpleChangeCheckoutManager simpleChangeCheckoutManager, IEditManager editManager, ISaleOnBoardManager saleOnBoardManager, Context context) {
        ViewState value;
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(ticketsManager, "ticketsManager");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(configurationManager, "configurationManager");
        Intrinsics.checkNotNullParameter(simpleChangeCheckoutManager, "simpleChangeCheckoutManager");
        Intrinsics.checkNotNullParameter(editManager, "editManager");
        Intrinsics.checkNotNullParameter(saleOnBoardManager, "saleOnBoardManager");
        Intrinsics.checkNotNullParameter(context, "context");
        this.$$delegate_0 = new KombardoTravelDetailsHandler();
        this.snackbarService = snackbarService;
        this.ticketsManager = ticketsManager;
        this.userManager = userManager;
        this.configurationManager = configurationManager;
        this.simpleChangeCheckoutManager = simpleChangeCheckoutManager;
        this.editManager = editManager;
        this.saleOnBoardManager = saleOnBoardManager;
        this.navArgs = TicketDetailsScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, null, null, null, null, false, false, false, null, false, false, false, null, 8191, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        do {
            value = MutableStateFlow.getValue();
        } while (!MutableStateFlow.compareAndSet(value, ViewState.copy$default(value, this.navArgs.getId(), this.navArgs.getPhone(), this.navArgs.getSite(), null, null, false, false, false, null, false, this.navArgs.getIsHistory(), false, null, 7160, null)));
        loadTicket(this.navArgs.getId(), this.navArgs.getPhone(), this.navArgs.getSite(), context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object buildKombardoRouteDetailsModel(Context context, Site site, Continuation<? super Unit> continuation) {
        TicketDetailsViewModel$buildKombardoRouteDetailsModel$1 ticketDetailsViewModel$buildKombardoRouteDetailsModel$1;
        int i5;
        TicketDetailsViewModel ticketDetailsViewModel;
        Context context2;
        Booking booking;
        Harbor harbor;
        Harbor harbor2;
        LocalizedSiteConfiguration localizedSiteConfiguration;
        if (continuation instanceof TicketDetailsViewModel$buildKombardoRouteDetailsModel$1) {
            ticketDetailsViewModel$buildKombardoRouteDetailsModel$1 = (TicketDetailsViewModel$buildKombardoRouteDetailsModel$1) continuation;
            int i6 = ticketDetailsViewModel$buildKombardoRouteDetailsModel$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                ticketDetailsViewModel$buildKombardoRouteDetailsModel$1.label = i6 - Integer.MIN_VALUE;
                Object obj = ticketDetailsViewModel$buildKombardoRouteDetailsModel$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = ticketDetailsViewModel$buildKombardoRouteDetailsModel$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Booking booking2 = this.viewState.getValue().getBooking();
                    if (booking2 == null) {
                        return Unit.INSTANCE;
                    }
                    Harbor departureHarbor = booking2.getTicket().getDeparture().getDepartureHarbor();
                    Harbor arrivalHarbor = booking2.getTicket().getDeparture().getArrivalHarbor();
                    IConfigurationManager iConfigurationManager = this.configurationManager;
                    ticketDetailsViewModel$buildKombardoRouteDetailsModel$1.L$0 = this;
                    ticketDetailsViewModel$buildKombardoRouteDetailsModel$1.L$1 = context;
                    ticketDetailsViewModel$buildKombardoRouteDetailsModel$1.L$2 = booking2;
                    ticketDetailsViewModel$buildKombardoRouteDetailsModel$1.L$3 = departureHarbor;
                    ticketDetailsViewModel$buildKombardoRouteDetailsModel$1.L$4 = arrivalHarbor;
                    ticketDetailsViewModel$buildKombardoRouteDetailsModel$1.label = 1;
                    Object activeConfiguration = iConfigurationManager.getActiveConfiguration(site, ticketDetailsViewModel$buildKombardoRouteDetailsModel$1);
                    if (activeConfiguration == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ticketDetailsViewModel = this;
                    context2 = context;
                    booking = booking2;
                    harbor = departureHarbor;
                    harbor2 = arrivalHarbor;
                    obj = activeConfiguration;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Harbor harbor3 = (Harbor) ticketDetailsViewModel$buildKombardoRouteDetailsModel$1.L$4;
                    Harbor harbor4 = (Harbor) ticketDetailsViewModel$buildKombardoRouteDetailsModel$1.L$3;
                    booking = (Booking) ticketDetailsViewModel$buildKombardoRouteDetailsModel$1.L$2;
                    Context context3 = (Context) ticketDetailsViewModel$buildKombardoRouteDetailsModel$1.L$1;
                    TicketDetailsViewModel ticketDetailsViewModel2 = (TicketDetailsViewModel) ticketDetailsViewModel$buildKombardoRouteDetailsModel$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    harbor2 = harbor3;
                    harbor = harbor4;
                    ticketDetailsViewModel = ticketDetailsViewModel2;
                    context2 = context3;
                }
                localizedSiteConfiguration = (LocalizedSiteConfiguration) obj;
                if (localizedSiteConfiguration != null) {
                    return Unit.INSTANCE;
                }
                ticketDetailsViewModel.buildTravelDetails(context2, harbor, harbor2, booking.getTicket().getDeparture(), localizedSiteConfiguration.getHarbors());
                return Unit.INSTANCE;
            }
        }
        ticketDetailsViewModel$buildKombardoRouteDetailsModel$1 = new TicketDetailsViewModel$buildKombardoRouteDetailsModel$1(this, continuation);
        Object obj2 = ticketDetailsViewModel$buildKombardoRouteDetailsModel$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = ticketDetailsViewModel$buildKombardoRouteDetailsModel$1.label;
        if (i5 != 0) {
        }
        localizedSiteConfiguration = (LocalizedSiteConfiguration) obj2;
        if (localizedSiteConfiguration != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadTicket(String reservationNumber, String phone, Site site, Context context) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TicketDetailsViewModel$loadTicket$1(this, reservationNumber, phone, site, context, null), 3, null);
    }

    public final void addToCalendar(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Booking booking = this.viewState.getValue().getBooking();
        if (booking == null) {
            return;
        }
        BookingDeparture departure = booking.getTicket().getDeparture();
        ExternalActionHelper externalActionHelper = ExternalActionHelper.INSTANCE;
        LocalDateTime atDate = departure.getDepartureTime().atDate(departure.getDate());
        Intrinsics.checkNotNullExpressionValue(atDate, "atDate(...)");
        LocalDateTime atDate2 = departure.getArrivalTime().atDate(departure.getDate());
        Intrinsics.checkNotNullExpressionValue(atDate2, "atDate(...)");
        externalActionHelper.addToCalendar(context, atDate, atDate2, departure.getDepartureHarborName(), departure.getArrivalHarborName(), booking.getSite().name(), booking.getReservationNumber());
    }

    public void buildTravelDetails(Context context, Harbor departureHarbor, Harbor arrivalHarbor, IDepartureInfo departure, List<Harbor> harbors) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(departureHarbor, "departureHarbor");
        Intrinsics.checkNotNullParameter(arrivalHarbor, "arrivalHarbor");
        Intrinsics.checkNotNullParameter(departure, "departure");
        Intrinsics.checkNotNullParameter(harbors, "harbors");
        this.$$delegate_0.buildTravelDetails(context, departureHarbor, arrivalHarbor, departure, harbors);
    }

    public final void clearPdfReceiptPath() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, null, null, null, false, false, false, null, false, false, false, null, 7935, null)));
    }

    public final void editTicket(Function0<Unit> startEdit, Context context) {
        Intrinsics.checkNotNullParameter(startEdit, "startEdit");
        Intrinsics.checkNotNullParameter(context, "context");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TicketDetailsViewModel$editTicket$1(this, context, startEdit, null), 3, null);
    }

    public StateFlow<TravelDetailsState> getTravelDetailsState() {
        return this.$$delegate_0.getTravelDetailsState();
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void hideRefundDialog() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, null, null, null, false, false, false, null, false, false, false, null, 7679, null)));
    }

    public final void refund(Function0<Unit> showRefundReceipt, Context context) {
        ViewState value;
        Intrinsics.checkNotNullParameter(showRefundReceipt, "showRefundReceipt");
        Intrinsics.checkNotNullParameter(context, "context");
        Booking booking = this.viewState.getValue().getBooking();
        if (booking == null) {
            return;
        }
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, null, null, null, true, false, false, null, false, false, false, null, 8159, null)));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TicketDetailsViewModel$refund$2(this, booking, context, showRefundReceipt, null), 3, null);
    }

    public final void reloadTicket(Context context) {
        ViewState value;
        Intrinsics.checkNotNullParameter(context, "context");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, null, null, null, false, true, false, null, false, false, false, null, 8119, null)));
        loadTicket(this.viewState.getValue().getReservationNumber(), this.viewState.getValue().getPhone(), this.viewState.getValue().getSite(), context);
    }

    public final void shareReceipt(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new TicketDetailsViewModel$shareReceipt$1(this, context, null), 2, null);
    }

    public final void showNotRefundableMessage() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TicketDetailsViewModel$showNotRefundableMessage$1(this, null), 3, null);
    }

    public final void showOnMap(String address, Context context) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(context, "context");
        GoogleMapsNavigationHandler.INSTANCE.startNavigation(address, context, !Feature.OnlyWalkingPassengers.isEnabled());
    }

    public final void showReceiptDisabledMessage() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TicketDetailsViewModel$showReceiptDisabledMessage$1(this, null), 3, null);
    }

    public final void showRefundDialog() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, null, null, null, false, false, false, null, true, false, false, null, 7679, null)));
    }

    public final void startSimpleChangeFlow(Function0<Unit> proceed) {
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        Booking booking = this.viewState.getValue().getBooking();
        if (booking == null) {
            return;
        }
        this.simpleChangeCheckoutManager.setup(booking, booking.getTicket().isCheckedIn());
        proceed.invoke();
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0017\b\u0087\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u009e\u0001\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u001f\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010\u001aR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010!\u001a\u0004\b#\u0010\u001aR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010'\u001a\u0004\b(\u0010)R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010-\u001a\u0004\b\r\u0010.R\u0017\u0010\u000e\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010-\u001a\u0004\b\u000e\u0010.R\u0017\u0010\u000f\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u000f\u0010-\u001a\u0004\b\u000f\u0010.R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b/\u0010\u001aR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010-\u001a\u0004\b0\u0010.R\u0017\u0010\u0012\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0012\u0010-\u001a\u0004\b\u0012\u0010.R\u0017\u0010\u0013\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0013\u0010-\u001a\u0004\b\u0013\u0010.R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b1\u0010\u001a¨\u00062"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/details/TicketDetailsViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "reservationNumber", "phone", "Ldk/molslinjen/domain/model/config/Site;", "site", "Ldk/molslinjen/domain/model/booking/Booking;", "booking", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "saleOnBoardOrders", BuildConfig.FLAVOR, "isRefunding", "isLoading", "isLoadingPdfReceipt", "pdfReceiptPath", "showRefundDialog", "isHistory", "isReceiptShareable", "lineLogoUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/config/Site;Ldk/molslinjen/domain/model/booking/Booking;Ljava/util/List;ZZZLjava/lang/String;ZZZLjava/lang/String;)V", "copy", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/config/Site;Ldk/molslinjen/domain/model/booking/Booking;Ljava/util/List;ZZZLjava/lang/String;ZZZLjava/lang/String;)Ldk/molslinjen/ui/views/screens/tickets/details/TicketDetailsViewModel$ViewState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getReservationNumber", "getPhone", "Ldk/molslinjen/domain/model/config/Site;", "getSite", "()Ldk/molslinjen/domain/model/config/Site;", "Ldk/molslinjen/domain/model/booking/Booking;", "getBooking", "()Ldk/molslinjen/domain/model/booking/Booking;", "Ljava/util/List;", "getSaleOnBoardOrders", "()Ljava/util/List;", "Z", "()Z", "getPdfReceiptPath", "getShowRefundDialog", "getLineLogoUrl", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final Booking booking;
        private final boolean isHistory;
        private final boolean isLoading;
        private final boolean isLoadingPdfReceipt;
        private final boolean isReceiptShareable;
        private final boolean isRefunding;
        private final String lineLogoUrl;
        private final String pdfReceiptPath;
        private final String phone;
        private final String reservationNumber;
        private final List<SaleOnBoardOrder> saleOnBoardOrders;
        private final boolean showRefundDialog;
        private final Site site;

        public ViewState(String reservationNumber, String phone, Site site, Booking booking, List<SaleOnBoardOrder> saleOnBoardOrders, boolean z5, boolean z6, boolean z7, String str, boolean z8, boolean z9, boolean z10, String str2) {
            Intrinsics.checkNotNullParameter(reservationNumber, "reservationNumber");
            Intrinsics.checkNotNullParameter(phone, "phone");
            Intrinsics.checkNotNullParameter(site, "site");
            Intrinsics.checkNotNullParameter(saleOnBoardOrders, "saleOnBoardOrders");
            this.reservationNumber = reservationNumber;
            this.phone = phone;
            this.site = site;
            this.booking = booking;
            this.saleOnBoardOrders = saleOnBoardOrders;
            this.isRefunding = z5;
            this.isLoading = z6;
            this.isLoadingPdfReceipt = z7;
            this.pdfReceiptPath = str;
            this.showRefundDialog = z8;
            this.isHistory = z9;
            this.isReceiptShareable = z10;
            this.lineLogoUrl = str2;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, String str, String str2, Site site, Booking booking, List list, boolean z5, boolean z6, boolean z7, String str3, boolean z8, boolean z9, boolean z10, String str4, int i5, Object obj) {
            return viewState.copy((i5 & 1) != 0 ? viewState.reservationNumber : str, (i5 & 2) != 0 ? viewState.phone : str2, (i5 & 4) != 0 ? viewState.site : site, (i5 & 8) != 0 ? viewState.booking : booking, (i5 & 16) != 0 ? viewState.saleOnBoardOrders : list, (i5 & 32) != 0 ? viewState.isRefunding : z5, (i5 & 64) != 0 ? viewState.isLoading : z6, (i5 & 128) != 0 ? viewState.isLoadingPdfReceipt : z7, (i5 & 256) != 0 ? viewState.pdfReceiptPath : str3, (i5 & 512) != 0 ? viewState.showRefundDialog : z8, (i5 & 1024) != 0 ? viewState.isHistory : z9, (i5 & 2048) != 0 ? viewState.isReceiptShareable : z10, (i5 & 4096) != 0 ? viewState.lineLogoUrl : str4);
        }

        public final ViewState copy(String reservationNumber, String phone, Site site, Booking booking, List<SaleOnBoardOrder> saleOnBoardOrders, boolean isRefunding, boolean isLoading, boolean isLoadingPdfReceipt, String pdfReceiptPath, boolean showRefundDialog, boolean isHistory, boolean isReceiptShareable, String lineLogoUrl) {
            Intrinsics.checkNotNullParameter(reservationNumber, "reservationNumber");
            Intrinsics.checkNotNullParameter(phone, "phone");
            Intrinsics.checkNotNullParameter(site, "site");
            Intrinsics.checkNotNullParameter(saleOnBoardOrders, "saleOnBoardOrders");
            return new ViewState(reservationNumber, phone, site, booking, saleOnBoardOrders, isRefunding, isLoading, isLoadingPdfReceipt, pdfReceiptPath, showRefundDialog, isHistory, isReceiptShareable, lineLogoUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics.areEqual(this.reservationNumber, viewState.reservationNumber) && Intrinsics.areEqual(this.phone, viewState.phone) && this.site == viewState.site && Intrinsics.areEqual(this.booking, viewState.booking) && Intrinsics.areEqual(this.saleOnBoardOrders, viewState.saleOnBoardOrders) && this.isRefunding == viewState.isRefunding && this.isLoading == viewState.isLoading && this.isLoadingPdfReceipt == viewState.isLoadingPdfReceipt && Intrinsics.areEqual(this.pdfReceiptPath, viewState.pdfReceiptPath) && this.showRefundDialog == viewState.showRefundDialog && this.isHistory == viewState.isHistory && this.isReceiptShareable == viewState.isReceiptShareable && Intrinsics.areEqual(this.lineLogoUrl, viewState.lineLogoUrl);
        }

        public final Booking getBooking() {
            return this.booking;
        }

        public final String getLineLogoUrl() {
            return this.lineLogoUrl;
        }

        public final String getPdfReceiptPath() {
            return this.pdfReceiptPath;
        }

        public final String getPhone() {
            return this.phone;
        }

        public final String getReservationNumber() {
            return this.reservationNumber;
        }

        public final List<SaleOnBoardOrder> getSaleOnBoardOrders() {
            return this.saleOnBoardOrders;
        }

        public final boolean getShowRefundDialog() {
            return this.showRefundDialog;
        }

        public final Site getSite() {
            return this.site;
        }

        public int hashCode() {
            int hashCode = ((((this.reservationNumber.hashCode() * 31) + this.phone.hashCode()) * 31) + this.site.hashCode()) * 31;
            Booking booking = this.booking;
            int hashCode2 = (((((((((hashCode + (booking == null ? 0 : booking.hashCode())) * 31) + this.saleOnBoardOrders.hashCode()) * 31) + Boolean.hashCode(this.isRefunding)) * 31) + Boolean.hashCode(this.isLoading)) * 31) + Boolean.hashCode(this.isLoadingPdfReceipt)) * 31;
            String str = this.pdfReceiptPath;
            int hashCode3 = (((((((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.showRefundDialog)) * 31) + Boolean.hashCode(this.isHistory)) * 31) + Boolean.hashCode(this.isReceiptShareable)) * 31;
            String str2 = this.lineLogoUrl;
            return hashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        /* renamed from: isHistory, reason: from getter */
        public final boolean getIsHistory() {
            return this.isHistory;
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        /* renamed from: isLoadingPdfReceipt, reason: from getter */
        public final boolean getIsLoadingPdfReceipt() {
            return this.isLoadingPdfReceipt;
        }

        /* renamed from: isReceiptShareable, reason: from getter */
        public final boolean getIsReceiptShareable() {
            return this.isReceiptShareable;
        }

        /* renamed from: isRefunding, reason: from getter */
        public final boolean getIsRefunding() {
            return this.isRefunding;
        }

        public String toString() {
            return "ViewState(reservationNumber=" + this.reservationNumber + ", phone=" + this.phone + ", site=" + this.site + ", booking=" + this.booking + ", saleOnBoardOrders=" + this.saleOnBoardOrders + ", isRefunding=" + this.isRefunding + ", isLoading=" + this.isLoading + ", isLoadingPdfReceipt=" + this.isLoadingPdfReceipt + ", pdfReceiptPath=" + this.pdfReceiptPath + ", showRefundDialog=" + this.showRefundDialog + ", isHistory=" + this.isHistory + ", isReceiptShareable=" + this.isReceiptShareable + ", lineLogoUrl=" + this.lineLogoUrl + ")";
        }

        public /* synthetic */ ViewState(String str, String str2, Site site, Booking booking, List list, boolean z5, boolean z6, boolean z7, String str3, boolean z8, boolean z9, boolean z10, String str4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? BuildConfig.FLAVOR : str, (i5 & 2) == 0 ? str2 : BuildConfig.FLAVOR, (i5 & 4) != 0 ? Site.Mols : site, (i5 & 8) != 0 ? null : booking, (i5 & 16) != 0 ? CollectionsKt.emptyList() : list, (i5 & 32) != 0 ? false : z5, (i5 & 64) != 0 ? true : z6, (i5 & 128) != 0 ? false : z7, (i5 & 256) != 0 ? null : str3, (i5 & 512) != 0 ? false : z8, (i5 & 1024) != 0 ? false : z9, (i5 & 2048) == 0 ? z10 : false, (i5 & 4096) == 0 ? str4 : null);
        }
    }
}
