package dk.molslinjen.ui.views.screens.booking.payment;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.PaymentScreenDestination;
import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.agreement.multiride.purchase.IMultiRideCardCheckoutManager;
import dk.molslinjen.domain.managers.checkout.ICheckoutManager;
import dk.molslinjen.domain.managers.checkout.ICreateBooking;
import dk.molslinjen.domain.managers.checkout.IEditManager;
import dk.molslinjen.domain.managers.checkout.IPaymentManager;
import dk.molslinjen.domain.managers.checkout.IReturnManager;
import dk.molslinjen.domain.managers.checkout.ISimpleChangeCheckoutManager;
import dk.molslinjen.domain.managers.checkout.PaymentManager;
import dk.molslinjen.domain.managers.checkout.SimpleChangeCheckoutManager;
import dk.molslinjen.domain.managers.departure.IDepartureManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardCheckoutManager;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.BookingTicket;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.domain.model.payment.PaymentOrigin;
import dk.molslinjen.domain.model.payment.PaymentType;
import dk.molslinjen.ui.views.screens.booking.shared.expiration.ExpirableCheckoutHandler;
import dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.Duration;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001[Bi\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b!\u0010\"J+\u0010(\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001d0#2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020\u001d¢\u0006\u0004\b*\u0010\u001fJ'\u0010.\u001a\u00020\u001d2\u0018\u0010.\u001a\u0014\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u001d0+¢\u0006\u0004\b.\u0010/J\u0015\u00101\u001a\u00020\u001d2\u0006\u00100\u001a\u00020-¢\u0006\u0004\b1\u00102J\r\u00103\u001a\u00020\u001d¢\u0006\u0004\b3\u0010\u001fJ\u0010\u00104\u001a\u00020-H\u0096\u0001¢\u0006\u0004\b4\u00105J\u0010\u00106\u001a\u00020\u001dH\u0096\u0001¢\u0006\u0004\b6\u0010\u001fJ\u0010\u00107\u001a\u00020-H\u0096\u0001¢\u0006\u0004\b7\u00105J\u0010\u00108\u001a\u00020-H\u0096\u0001¢\u0006\u0004\b8\u00105J\u0010\u00109\u001a\u00020-H\u0096\u0001¢\u0006\u0004\b9\u00105J\u0010\u0010:\u001a\u00020-H\u0096\u0001¢\u0006\u0004\b:\u00105J\u0010\u0010;\u001a\u00020-H\u0096\u0001¢\u0006\u0004\b;\u00105R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010<R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010=R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010>R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010?R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010@R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010AR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010BR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010CR\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010DR\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010ER\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010FR\u0014\u0010H\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020K0J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u001d\u0010O\u001a\b\u0012\u0004\u0012\u00020K0N8\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u001d\u0010T\u001a\b\u0012\u0004\u0012\u00020S0N8\u0006¢\u0006\f\n\u0004\bT\u0010P\u001a\u0004\bU\u0010RR\u001a\u0010W\u001a\b\u0012\u0004\u0012\u00020-0V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u001a\u0010Y\u001a\b\u0012\u0004\u0012\u00020-0J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010MR\u001a\u0010Z\u001a\b\u0012\u0004\u0012\u00020-0N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010P¨\u0006\\"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/payment/PaymentViewModel;", "Landroidx/lifecycle/ViewModel;", "Ldk/molslinjen/ui/views/screens/booking/shared/expiration/IExpirableCheckout;", "Ldk/molslinjen/domain/managers/checkout/IPaymentManager;", "paymentManager", "Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;", "checkoutManager", "Ldk/molslinjen/domain/managers/checkout/ISimpleChangeCheckoutManager;", "simpleChangeCheckoutManager", "Ldk/molslinjen/domain/managers/agreement/multiride/purchase/IMultiRideCardCheckoutManager;", "multiRideCardCheckoutManager", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "snackbarService", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "routeManager", "Ldk/molslinjen/domain/managers/departure/IDepartureManager;", "departureManager", "Ldk/molslinjen/domain/managers/checkout/IReturnManager;", "returnManager", "Ldk/molslinjen/domain/managers/checkout/IEditManager;", "editManager", "Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardCheckoutManager;", "saleOnBoardCheckoutManager", "Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "analyticsTracker", "<init>", "(Ldk/molslinjen/domain/managers/checkout/IPaymentManager;Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;Ldk/molslinjen/domain/managers/checkout/ISimpleChangeCheckoutManager;Ldk/molslinjen/domain/managers/agreement/multiride/purchase/IMultiRideCardCheckoutManager;Ldk/molslinjen/core/snackbar/ISnackbarService;Ldk/molslinjen/domain/managers/route/IRouteManager;Ldk/molslinjen/domain/managers/departure/IDepartureManager;Ldk/molslinjen/domain/managers/checkout/IReturnManager;Ldk/molslinjen/domain/managers/checkout/IEditManager;Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardCheckoutManager;Landroidx/lifecycle/SavedStateHandle;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;)V", BuildConfig.FLAVOR, "setupBackAllowanceListener", "()V", "Ldk/molslinjen/domain/managers/checkout/ICreateBooking;", "getCreateBookingHandler", "()Ldk/molslinjen/domain/managers/checkout/ICreateBooking;", "Lkotlin/Function0;", "dismiss", BuildConfig.FLAVOR, "screenWith", "screenHeight", "startBooking", "(Lkotlin/jvm/functions/Function0;FF)V", "showPaymentError", "Lkotlin/Function2;", "Ldk/molslinjen/domain/model/payment/PaymentOrigin;", BuildConfig.FLAVOR, "proceed", "(Lkotlin/jvm/functions/Function2;)V", "allowed", "updateWebViewBackNavigationAllowed", "(Z)V", "switchToFallbackPaymentUrl", "isExpired", "()Z", "resetCheckoutAfterExpiredDepartures", "isEditing", "isMultiRide", "isCommuter", "showReloadDialog", "isInCheckoutFlow", "Ldk/molslinjen/domain/managers/checkout/IPaymentManager;", "Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;", "Ldk/molslinjen/domain/managers/checkout/ISimpleChangeCheckoutManager;", "Ldk/molslinjen/domain/managers/agreement/multiride/purchase/IMultiRideCardCheckoutManager;", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "Ldk/molslinjen/domain/managers/departure/IDepartureManager;", "Ldk/molslinjen/domain/managers/checkout/IReturnManager;", "Ldk/molslinjen/domain/managers/checkout/IEditManager;", "Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardCheckoutManager;", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "Ldk/molslinjen/ui/views/screens/booking/payment/PaymentScreenNavArgs;", "navArgs", "Ldk/molslinjen/ui/views/screens/booking/payment/PaymentScreenNavArgs;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/booking/payment/PaymentViewModel$ViewState;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/checkout/PaymentManager$PaymentState;", "paymentState", "getPaymentState", "Lkotlinx/coroutines/flow/Flow;", "paymentStateAllowsBackNavigation", "Lkotlinx/coroutines/flow/Flow;", "webViewAllowsBackNavigation", "backNavigationAllowed", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PaymentViewModel extends ViewModel implements IExpirableCheckout {
    private final /* synthetic */ ExpirableCheckoutHandler $$delegate_0;
    private final MutableStateFlow<ViewState> _viewState;
    private final IAnalyticsTracker analyticsTracker;
    private final StateFlow<Boolean> backNavigationAllowed;
    private final ICheckoutManager checkoutManager;
    private final IDepartureManager departureManager;
    private final IEditManager editManager;
    private final IMultiRideCardCheckoutManager multiRideCardCheckoutManager;
    private final PaymentScreenNavArgs navArgs;
    private final IPaymentManager paymentManager;
    private final StateFlow<PaymentManager.PaymentState> paymentState;
    private final Flow<Boolean> paymentStateAllowsBackNavigation;
    private final IReturnManager returnManager;
    private final IRouteManager routeManager;
    private final ISaleOnBoardCheckoutManager saleOnBoardCheckoutManager;
    private final ISimpleChangeCheckoutManager simpleChangeCheckoutManager;
    private final ISnackbarService snackbarService;
    private final StateFlow<ViewState> viewState;
    private final MutableStateFlow<Boolean> webViewAllowsBackNavigation;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PaymentOrigin.values().length];
            try {
                iArr[PaymentOrigin.CommuterTicketFromDetails.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PaymentOrigin.CommuterTicketFromAgreements.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PaymentOrigin.MultiRideTicketFromDetails.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PaymentOrigin.MultiRideTicketFromAgreements.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PaymentOrigin.Ticket.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PaymentOrigin.TicketChange.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PaymentOrigin.SimpleChangeOrEarlyCheckInTicket.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PaymentOrigin.SaleOnBoard.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[PaymentOrigin.MultiRideCardFromDetails.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[PaymentOrigin.MultiRideCardFromAgreements.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PaymentViewModel(IPaymentManager paymentManager, ICheckoutManager checkoutManager, ISimpleChangeCheckoutManager simpleChangeCheckoutManager, IMultiRideCardCheckoutManager multiRideCardCheckoutManager, ISnackbarService snackbarService, IRouteManager routeManager, IDepartureManager departureManager, IReturnManager returnManager, IEditManager editManager, ISaleOnBoardCheckoutManager saleOnBoardCheckoutManager, SavedStateHandle savedStateHandle, IAnalyticsTracker analyticsTracker) {
        Intrinsics.checkNotNullParameter(paymentManager, "paymentManager");
        Intrinsics.checkNotNullParameter(checkoutManager, "checkoutManager");
        Intrinsics.checkNotNullParameter(simpleChangeCheckoutManager, "simpleChangeCheckoutManager");
        Intrinsics.checkNotNullParameter(multiRideCardCheckoutManager, "multiRideCardCheckoutManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(routeManager, "routeManager");
        Intrinsics.checkNotNullParameter(departureManager, "departureManager");
        Intrinsics.checkNotNullParameter(returnManager, "returnManager");
        Intrinsics.checkNotNullParameter(editManager, "editManager");
        Intrinsics.checkNotNullParameter(saleOnBoardCheckoutManager, "saleOnBoardCheckoutManager");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        Duration paymentMinExpirationTime = Constants.Data.INSTANCE.getPaymentMinExpirationTime();
        PaymentScreenDestination paymentScreenDestination = PaymentScreenDestination.INSTANCE;
        this.$$delegate_0 = new ExpirableCheckoutHandler(routeManager, departureManager, editManager, returnManager, paymentManager, paymentMinExpirationTime, paymentScreenDestination.argsFrom(savedStateHandle).getPaymentOrigin() == PaymentOrigin.Ticket, analyticsTracker);
        this.paymentManager = paymentManager;
        this.checkoutManager = checkoutManager;
        this.simpleChangeCheckoutManager = simpleChangeCheckoutManager;
        this.multiRideCardCheckoutManager = multiRideCardCheckoutManager;
        this.snackbarService = snackbarService;
        this.routeManager = routeManager;
        this.departureManager = departureManager;
        this.returnManager = returnManager;
        this.editManager = editManager;
        this.saleOnBoardCheckoutManager = saleOnBoardCheckoutManager;
        this.analyticsTracker = analyticsTracker;
        PaymentScreenNavArgs argsFrom = paymentScreenDestination.argsFrom(savedStateHandle);
        this.navArgs = argsFrom;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(false, null, null, false, 15, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        final StateFlow<PaymentManager.PaymentState> paymentState = paymentManager.getPaymentState();
        this.paymentState = paymentState;
        Flow<Boolean> flow = new Flow<Boolean>() { // from class: dk.molslinjen.ui.views.screens.booking.payment.PaymentViewModel$special$$inlined$map$1

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "value", BuildConfig.FLAVOR, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
            /* renamed from: dk.molslinjen.ui.views.screens.booking.payment.PaymentViewModel$special$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.payment.PaymentViewModel$special$$inlined$map$1$2", f = "PaymentViewModel.kt", l = {223}, m = "emit")
                /* renamed from: dk.molslinjen.ui.views.screens.booking.payment.PaymentViewModel$special$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code restructure failed: missing block: B:24:0x0055, code lost:
                
                    if (kotlin.jvm.internal.Intrinsics.areEqual(r6.getPaymentSucceeded(), kotlin.coroutines.jvm.internal.Boxing.boxBoolean(false)) == false) goto L21;
                 */
                /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i5;
                    boolean z5;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i6 = anonymousClass1.label;
                        if ((i6 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i6 - Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i5 = anonymousClass1.label;
                            if (i5 != 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                PaymentManager.PaymentState paymentState = (PaymentManager.PaymentState) obj;
                                if (paymentState.getPaymentType() != PaymentType.MobilePay && paymentState.getPaymentCallbackReceived()) {
                                    z5 = false;
                                }
                                z5 = true;
                                Boolean boxBoolean = Boxing.boxBoolean(z5);
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(boxBoolean, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i5 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = anonymousClass1.label;
                    if (i5 != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
        this.paymentStateAllowsBackNavigation = flow;
        Boolean bool = Boolean.TRUE;
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(bool);
        this.webViewAllowsBackNavigation = MutableStateFlow2;
        this.backNavigationAllowed = FlowKt.stateIn(FlowKt.flowCombine(MutableStateFlow2, flow, new PaymentViewModel$backNavigationAllowed$1(null)), ViewModelKt.getViewModelScope(this), SharingStarted.INSTANCE.getEagerly(), bool);
        paymentManager.setPaymentOrigin(argsFrom.getPaymentOrigin());
        setupBackAllowanceListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ICreateBooking getCreateBookingHandler() {
        switch (WhenMappings.$EnumSwitchMapping$0[this.paymentState.getValue().getPaymentOrigin().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return this.checkoutManager;
            case 7:
                return this.simpleChangeCheckoutManager;
            case 8:
                return this.saleOnBoardCheckoutManager;
            case 9:
            case 10:
                return this.multiRideCardCheckoutManager;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final void setupBackAllowanceListener() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new PaymentViewModel$setupBackAllowanceListener$1(this, null), 3, null);
    }

    public final StateFlow<PaymentManager.PaymentState> getPaymentState() {
        return this.paymentState;
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
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

    public final void proceed(Function2<? super PaymentOrigin, ? super Boolean, Unit> proceed) {
        BookingTicket ticket;
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        Logger.log$default(Logger.INSTANCE, "PaymentViewModel proceed", "PaymentProcess", 0, 4, null);
        SimpleChangeCheckoutManager.SimpleChangeCheckoutState value = this.simpleChangeCheckoutManager.getSimpleChangeCheckoutState().getValue();
        Boolean earlyCheckIn = value.getEarlyCheckIn();
        boolean z5 = false;
        if (earlyCheckIn != null ? earlyCheckIn.booleanValue() : false) {
            Booking existingBooking = value.getExistingBooking();
            if ((existingBooking == null || (ticket = existingBooking.getTicket()) == null || ticket.isCheckedIn()) ? false : true) {
                z5 = true;
            }
        }
        proceed.invoke(this.paymentState.getValue().getPaymentOrigin(), Boolean.valueOf(z5));
        IPaymentManager.DefaultImpls.readyForPaymentStateReset$default(this.paymentManager, null, Boolean.TRUE, 1, null);
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public void resetCheckoutAfterExpiredDepartures() {
        this.$$delegate_0.resetCheckoutAfterExpiredDepartures();
    }

    public final void showPaymentError() {
        Logger.INSTANCE.logCritical(new CriticalLog("PaymentViewModel showPaymentError"));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new PaymentViewModel$showPaymentError$1(this, null), 3, null);
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public boolean showReloadDialog() {
        return this.$$delegate_0.showReloadDialog();
    }

    public final void startBooking(Function0<Unit> dismiss, float screenWith, float screenHeight) {
        Intrinsics.checkNotNullParameter(dismiss, "dismiss");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new PaymentViewModel$startBooking$1(this, screenHeight, screenWith, dismiss, null), 3, null);
    }

    public final void switchToFallbackPaymentUrl() {
        ViewState value;
        ViewState viewState;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
            viewState = value;
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(viewState, false, viewState.getFallbackPaymentWindowUrl(), null, false, 13, null)));
        if (this._viewState.getValue().getFallbackPaymentWindowUrl() == null) {
            showPaymentError();
        }
    }

    public final void updateWebViewBackNavigationAllowed(boolean allowed) {
        Boolean value;
        MutableStateFlow<Boolean> mutableStateFlow = this.webViewAllowsBackNavigation;
        do {
            value = mutableStateFlow.getValue();
            value.booleanValue();
        } while (!mutableStateFlow.compareAndSet(value, Boolean.valueOf(allowed)));
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ<\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0003\u0010\u0015R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\rR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0018\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0007\u0010\u0015¨\u0006\u0019"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/payment/PaymentViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isLoading", BuildConfig.FLAVOR, "paymentWindowUrl", "fallbackPaymentWindowUrl", "isBackNavigationAllowed", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Z)V", "copy", "(ZLjava/lang/String;Ljava/lang/String;Z)Ldk/molslinjen/ui/views/screens/booking/payment/PaymentViewModel$ViewState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "Ljava/lang/String;", "getPaymentWindowUrl", "getFallbackPaymentWindowUrl", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final String fallbackPaymentWindowUrl;
        private final boolean isBackNavigationAllowed;
        private final boolean isLoading;
        private final String paymentWindowUrl;

        public ViewState(boolean z5, String str, String str2, boolean z6) {
            this.isLoading = z5;
            this.paymentWindowUrl = str;
            this.fallbackPaymentWindowUrl = str2;
            this.isBackNavigationAllowed = z6;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z5, String str, String str2, boolean z6, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z5 = viewState.isLoading;
            }
            if ((i5 & 2) != 0) {
                str = viewState.paymentWindowUrl;
            }
            if ((i5 & 4) != 0) {
                str2 = viewState.fallbackPaymentWindowUrl;
            }
            if ((i5 & 8) != 0) {
                z6 = viewState.isBackNavigationAllowed;
            }
            return viewState.copy(z5, str, str2, z6);
        }

        public final ViewState copy(boolean isLoading, String paymentWindowUrl, String fallbackPaymentWindowUrl, boolean isBackNavigationAllowed) {
            return new ViewState(isLoading, paymentWindowUrl, fallbackPaymentWindowUrl, isBackNavigationAllowed);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isLoading == viewState.isLoading && Intrinsics.areEqual(this.paymentWindowUrl, viewState.paymentWindowUrl) && Intrinsics.areEqual(this.fallbackPaymentWindowUrl, viewState.fallbackPaymentWindowUrl) && this.isBackNavigationAllowed == viewState.isBackNavigationAllowed;
        }

        public final String getFallbackPaymentWindowUrl() {
            return this.fallbackPaymentWindowUrl;
        }

        public final String getPaymentWindowUrl() {
            return this.paymentWindowUrl;
        }

        public int hashCode() {
            int hashCode = Boolean.hashCode(this.isLoading) * 31;
            String str = this.paymentWindowUrl;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.fallbackPaymentWindowUrl;
            return ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Boolean.hashCode(this.isBackNavigationAllowed);
        }

        /* renamed from: isBackNavigationAllowed, reason: from getter */
        public final boolean getIsBackNavigationAllowed() {
            return this.isBackNavigationAllowed;
        }

        public String toString() {
            return "ViewState(isLoading=" + this.isLoading + ", paymentWindowUrl=" + this.paymentWindowUrl + ", fallbackPaymentWindowUrl=" + this.fallbackPaymentWindowUrl + ", isBackNavigationAllowed=" + this.isBackNavigationAllowed + ")";
        }

        public /* synthetic */ ViewState(boolean z5, String str, String str2, boolean z6, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? true : z5, (i5 & 2) != 0 ? null : str, (i5 & 4) != 0 ? null : str2, (i5 & 8) != 0 ? true : z6);
        }
    }
}
