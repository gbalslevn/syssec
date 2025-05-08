package dk.molslinjen.ui.views.screens.booking.summary;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.analytics.AnalyticsEvent;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.checkout.EditManager;
import dk.molslinjen.domain.managers.checkout.ICheckoutManager;
import dk.molslinjen.domain.managers.checkout.IEditManager;
import dk.molslinjen.domain.managers.checkout.IPaymentManager;
import dk.molslinjen.domain.managers.checkout.IReturnManager;
import dk.molslinjen.domain.managers.checkout.ISummaryAddonHelper;
import dk.molslinjen.domain.managers.checkout.SummaryAddonHelper;
import dk.molslinjen.domain.managers.departure.IDepartureManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.managers.site.ISiteManager;
import dk.molslinjen.domain.managers.splitTest.ISplitTestManager;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.managers.user.creditcards.IUserCreditCardsManager;
import dk.molslinjen.domain.model.account.CreditCard;
import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.domain.model.booking.CheckoutContactInfo;
import dk.molslinjen.domain.model.booking.CommuterBookingData;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.MultiRideBookingData;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.payment.PaymentOrigin;
import dk.molslinjen.domain.model.payment.PaymentType;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.domain.model.site.SiteInfo;
import dk.molslinjen.ui.views.screens.booking.shared.expiration.ExpirableCheckoutHandler;
import dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001hBq\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u000209H\u0002J\u0010\u0010;\u001a\u0002092\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010<\u001a\u000209H\u0002J\u0006\u0010=\u001a\u000209J\u0006\u0010>\u001a\u000209J\u0018\u0010?\u001a\u0002092\u0006\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010CJ\u001a\u0010D\u001a\u0002092\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u0002090EJ\u0014\u0010G\u001a\u0002092\f\u0010D\u001a\b\u0012\u0004\u0012\u0002090HJ\u0010\u0010I\u001a\u0002092\b\u0010J\u001a\u0004\u0018\u00010KJ\u0010\u0010L\u001a\u0002092\b\u0010M\u001a\u0004\u0018\u00010NJ\u000e\u0010O\u001a\u0002092\u0006\u0010P\u001a\u00020QJ\u000e\u0010R\u001a\u0002092\u0006\u0010S\u001a\u00020NJ\u000e\u0010T\u001a\u0002092\u0006\u0010U\u001a\u00020NJ\u000e\u0010V\u001a\u0002092\u0006\u0010W\u001a\u000205J\u0006\u0010X\u001a\u000209J\u001e\u0010Y\u001a\u0002092\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_J\u0006\u0010`\u001a\u000209J\t\u0010a\u001a\u000205H\u0096\u0001J\t\u0010b\u001a\u000205H\u0096\u0001J\t\u0010c\u001a\u000205H\u0096\u0001J\t\u0010d\u001a\u000205H\u0096\u0001J\t\u0010e\u001a\u000205H\u0096\u0001J\t\u0010f\u001a\u000209H\u0096\u0001J\t\u0010g\u001a\u000205H\u0096\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0019\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0#¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u0019\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0#¢\u0006\b\n\u0000\u001a\u0004\b+\u0010%R\u0019\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0#¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020/0#¢\u0006\b\n\u0000\u001a\u0004\b0\u0010%R\u0017\u00101\u001a\b\u0012\u0004\u0012\u0002020#¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%R\u0011\u00104\u001a\u000205¢\u0006\b\n\u0000\u001a\u0004\b6\u00107¨\u0006i"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/summary/BookingSummaryViewModel;", "Landroidx/lifecycle/ViewModel;", "Ldk/molslinjen/ui/views/screens/booking/shared/expiration/IExpirableCheckout;", "checkoutManager", "Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;", "creditCardsManager", "Ldk/molslinjen/domain/managers/user/creditcards/IUserCreditCardsManager;", "siteManager", "Ldk/molslinjen/domain/managers/site/ISiteManager;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "routeManager", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "departureManager", "Ldk/molslinjen/domain/managers/departure/IDepartureManager;", "returnManager", "Ldk/molslinjen/domain/managers/checkout/IReturnManager;", "editManager", "Ldk/molslinjen/domain/managers/checkout/IEditManager;", "paymentManager", "Ldk/molslinjen/domain/managers/checkout/IPaymentManager;", "summaryAddonHelper", "Ldk/molslinjen/domain/managers/checkout/ISummaryAddonHelper;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "splitTestManager", "Ldk/molslinjen/domain/managers/splitTest/ISplitTestManager;", "<init>", "(Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;Ldk/molslinjen/domain/managers/user/creditcards/IUserCreditCardsManager;Ldk/molslinjen/domain/managers/site/ISiteManager;Ldk/molslinjen/core/snackbar/ISnackbarService;Ldk/molslinjen/domain/managers/route/IRouteManager;Ldk/molslinjen/domain/managers/departure/IDepartureManager;Ldk/molslinjen/domain/managers/checkout/IReturnManager;Ldk/molslinjen/domain/managers/checkout/IEditManager;Ldk/molslinjen/domain/managers/checkout/IPaymentManager;Ldk/molslinjen/domain/managers/checkout/ISummaryAddonHelper;Ldk/molslinjen/domain/managers/user/IUserManager;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;Ldk/molslinjen/domain/managers/splitTest/ISplitTestManager;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/booking/summary/BookingSummaryViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "checkoutState", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;", "getCheckoutState", "outboundCheckoutState", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutDirectionState;", "getOutboundCheckoutState", "returnCheckoutState", "getReturnCheckoutState", "editState", "Ldk/molslinjen/domain/managers/checkout/EditManager$EditState;", "getEditState", "summaryAddonState", "Ldk/molslinjen/domain/managers/checkout/SummaryAddonHelper$SummaryAddonState;", "getSummaryAddonState", "highlightReturnTicketButton", BuildConfig.FLAVOR, "getHighlightReturnTicketButton", "()Z", "listenForPersonalInfoChangeAfterLogin", BuildConfig.FLAVOR, "loadSummaryProducts", "loadSiteInfo", "loadPaymentMethods", "toggleNewsletterSignup", "toggleAcceptMarketing", "paymentMethodSelected", "paymentType", "Ldk/molslinjen/domain/model/payment/PaymentType;", "creditCard", "Ldk/molslinjen/domain/model/account/CreditCard;", "proceed", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/payment/PaymentOrigin;", "proceedToReturnBooking", "Lkotlin/Function0;", "updateSelectedVehicle", "vehicle", "Ldk/molslinjen/domain/model/account/UserVehicle;", "updatePhoneNumberCode", "phoneNumberCode", BuildConfig.FLAVOR, "onPhoneNumberChange", "phoneNumber", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "onEmailChange", "email", "onPostalCodeChange", "postalCode", "onEarlyCheckInChange", "earlyCheckIn", "startPersonalInfoEdit", "onProductQuantityChanged", "direction", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "product", "Ldk/molslinjen/domain/model/booking/product/Product;", "quantity", BuildConfig.FLAVOR, "clearSelectedVehicle", "isCommuter", "isEditing", "isExpired", "isInCheckoutFlow", "isMultiRide", "resetCheckoutAfterExpiredDepartures", "showReloadDialog", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BookingSummaryViewModel extends ViewModel implements IExpirableCheckout {
    private final /* synthetic */ ExpirableCheckoutHandler $$delegate_0;
    private final MutableStateFlow<ViewState> _viewState;
    private final IAnalyticsTracker analyticsTracker;
    private final ICheckoutManager checkoutManager;
    private final StateFlow<CheckoutManager.CheckoutState> checkoutState;
    private final IUserCreditCardsManager creditCardsManager;
    private final IDepartureManager departureManager;
    private final IEditManager editManager;
    private final StateFlow<EditManager.EditState> editState;
    private final boolean highlightReturnTicketButton;
    private final StateFlow<CheckoutManager.CheckoutDirectionState> outboundCheckoutState;
    private final IPaymentManager paymentManager;
    private final StateFlow<CheckoutManager.CheckoutDirectionState> returnCheckoutState;
    private final IReturnManager returnManager;
    private final IRouteManager routeManager;
    private final ISnackbarService snackbarService;
    private final ISummaryAddonHelper summaryAddonHelper;
    private final StateFlow<SummaryAddonHelper.SummaryAddonState> summaryAddonState;
    private final IUserManager userManager;
    private final StateFlow<ViewState> viewState;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryViewModel$1", f = "BookingSummaryViewModel.kt", l = {80}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryViewModel$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "summaryAddonState", "Ldk/molslinjen/domain/managers/checkout/SummaryAddonHelper$SummaryAddonState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryViewModel$1$1", f = "BookingSummaryViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00581 extends SuspendLambda implements Function2<SummaryAddonHelper.SummaryAddonState, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ BookingSummaryViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00581(BookingSummaryViewModel bookingSummaryViewModel, Continuation<? super C00581> continuation) {
                super(2, continuation);
                this.this$0 = bookingSummaryViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00581 c00581 = new C00581(this.this$0, continuation);
                c00581.L$0 = obj;
                return c00581;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(SummaryAddonHelper.SummaryAddonState summaryAddonState, Continuation<? super Unit> continuation) {
                return ((C00581) create(summaryAddonState, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.checkoutManager.updateSummaryAddons((SummaryAddonHelper.SummaryAddonState) this.L$0);
                return Unit.INSTANCE;
            }
        }

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
                StateFlow<SummaryAddonHelper.SummaryAddonState> summaryAddonState = BookingSummaryViewModel.this.summaryAddonHelper.getSummaryAddonState();
                C00581 c00581 = new C00581(BookingSummaryViewModel.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(summaryAddonState, c00581, this) == coroutine_suspended) {
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

    public BookingSummaryViewModel(ICheckoutManager checkoutManager, IUserCreditCardsManager creditCardsManager, ISiteManager siteManager, ISnackbarService snackbarService, IRouteManager routeManager, IDepartureManager departureManager, IReturnManager returnManager, IEditManager editManager, IPaymentManager paymentManager, ISummaryAddonHelper summaryAddonHelper, IUserManager userManager, IAnalyticsTracker analyticsTracker, ISplitTestManager splitTestManager) {
        Intrinsics.checkNotNullParameter(checkoutManager, "checkoutManager");
        Intrinsics.checkNotNullParameter(creditCardsManager, "creditCardsManager");
        Intrinsics.checkNotNullParameter(siteManager, "siteManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(routeManager, "routeManager");
        Intrinsics.checkNotNullParameter(departureManager, "departureManager");
        Intrinsics.checkNotNullParameter(returnManager, "returnManager");
        Intrinsics.checkNotNullParameter(editManager, "editManager");
        Intrinsics.checkNotNullParameter(paymentManager, "paymentManager");
        Intrinsics.checkNotNullParameter(summaryAddonHelper, "summaryAddonHelper");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        Intrinsics.checkNotNullParameter(splitTestManager, "splitTestManager");
        this.$$delegate_0 = new ExpirableCheckoutHandler(routeManager, departureManager, editManager, returnManager, paymentManager, null, false, analyticsTracker, 96, null);
        this.checkoutManager = checkoutManager;
        this.creditCardsManager = creditCardsManager;
        this.snackbarService = snackbarService;
        this.routeManager = routeManager;
        this.departureManager = departureManager;
        this.returnManager = returnManager;
        this.editManager = editManager;
        this.paymentManager = paymentManager;
        this.summaryAddonHelper = summaryAddonHelper;
        this.userManager = userManager;
        this.analyticsTracker = analyticsTracker;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, null, null, false, false, 31, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        this.checkoutState = checkoutManager.getCheckoutState();
        this.outboundCheckoutState = checkoutManager.getOutboundDirectionState();
        this.returnCheckoutState = checkoutManager.getReturnDirectionState();
        this.editState = editManager.getEditState();
        this.summaryAddonState = summaryAddonHelper.getSummaryAddonState();
        this.highlightReturnTicketButton = splitTestManager.getEnableReturnTicketAttractionView();
        loadSiteInfo(siteManager);
        loadSummaryProducts();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
        listenForPersonalInfoChangeAfterLogin();
    }

    private final void listenForPersonalInfoChangeAfterLogin() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BookingSummaryViewModel$listenForPersonalInfoChangeAfterLogin$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadPaymentMethods() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BookingSummaryViewModel$loadPaymentMethods$1(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BookingSummaryViewModel$loadPaymentMethods$2(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BookingSummaryViewModel$loadPaymentMethods$3(this, null), 3, null);
    }

    private final void loadSiteInfo(ISiteManager siteManager) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BookingSummaryViewModel$loadSiteInfo$1(this, siteManager, null), 3, null);
    }

    private final void loadSummaryProducts() {
        CheckoutManager.CheckoutDirectionState value;
        CheckoutManager.CheckoutState value2;
        if (this.editManager.getEditState().getValue().getIsEditing() || (value = this.checkoutManager.getOutboundDirectionState().getValue()) == null || (value2 = this.checkoutManager.getCheckoutState().getValue()) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BookingSummaryViewModel$loadSummaryProducts$1(this, value, value2, null), 3, null);
    }

    public final void clearSelectedVehicle() {
        this.checkoutManager.updateSelectedVehicle(null);
    }

    public final StateFlow<CheckoutManager.CheckoutState> getCheckoutState() {
        return this.checkoutState;
    }

    public final StateFlow<EditManager.EditState> getEditState() {
        return this.editState;
    }

    public final boolean getHighlightReturnTicketButton() {
        return this.highlightReturnTicketButton;
    }

    public final StateFlow<CheckoutManager.CheckoutDirectionState> getOutboundCheckoutState() {
        return this.outboundCheckoutState;
    }

    public final StateFlow<CheckoutManager.CheckoutDirectionState> getReturnCheckoutState() {
        return this.returnCheckoutState;
    }

    public final StateFlow<SummaryAddonHelper.SummaryAddonState> getSummaryAddonState() {
        return this.summaryAddonState;
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

    public final void onEarlyCheckInChange(boolean earlyCheckIn) {
        this.checkoutManager.updateEarlyCheckIn(earlyCheckIn);
    }

    public final void onEmailChange(String email) {
        Intrinsics.checkNotNullParameter(email, "email");
        this.checkoutManager.updateEmail(email);
    }

    public final void onPhoneNumberChange(PhoneNumber phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        this.checkoutManager.updatePhoneNumber(phoneNumber);
    }

    public final void onPostalCodeChange(String postalCode) {
        Intrinsics.checkNotNullParameter(postalCode, "postalCode");
        this.checkoutManager.updatePostalCode(postalCode);
    }

    public final void onProductQuantityChanged(DepartureDirection direction, Product product, int quantity) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(product, "product");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BookingSummaryViewModel$onProductQuantityChanged$1(this, product, quantity, direction, null), 3, null);
    }

    public final void paymentMethodSelected(PaymentType paymentType, CreditCard creditCard) {
        Intrinsics.checkNotNullParameter(paymentType, "paymentType");
        CheckoutManager.CheckoutState value = this.checkoutManager.getCheckoutState().getValue();
        if (value == null) {
            return;
        }
        boolean z5 = value.getSelectedPaymentType() != paymentType;
        if (creditCard == null) {
            creditCard = (z5 && paymentType == PaymentType.Card) ? (CreditCard) CollectionsKt.firstOrNull((List) this.viewState.getValue().getSavedCreditCards()) : null;
        }
        this.checkoutManager.selectPaymentMethod(paymentType, creditCard);
    }

    public final void proceed(Function1<? super PaymentOrigin, Unit> proceed) {
        CommuterBookingData commuterBookingData;
        MultiRideBookingData multiRideBookingData;
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        CheckoutManager.CheckoutState value = this.checkoutState.getValue();
        PaymentOrigin flowOrigin = (value == null || (multiRideBookingData = value.getMultiRideBookingData()) == null) ? null : multiRideBookingData.getFlowOrigin();
        CheckoutManager.CheckoutState value2 = this.checkoutState.getValue();
        PaymentOrigin flowOrigin2 = (value2 == null || (commuterBookingData = value2.getCommuterBookingData()) == null) ? null : commuterBookingData.getFlowOrigin();
        if (this.editManager.getEditState().getValue().getIsEditing()) {
            flowOrigin = PaymentOrigin.TicketChange;
        } else if (flowOrigin == null) {
            flowOrigin = flowOrigin2 == null ? PaymentOrigin.Ticket : flowOrigin2;
        }
        CheckoutManager.CheckoutState value3 = this.checkoutState.getValue();
        if ((value3 != null ? value3.getSelectedPaymentType() : null) == PaymentType.MobilePay) {
            this.analyticsTracker.trackEvent(AnalyticsEvent.MobilePayEvent.INSTANCE);
        } else if (!this.viewState.getValue().getSavedCreditCards().isEmpty()) {
            CheckoutManager.CheckoutState value4 = this.checkoutState.getValue();
            if ((value4 != null ? value4.getSelectedCreditCard() : null) == null) {
                this.analyticsTracker.trackEvent(AnalyticsEvent.OtherPaymentCardWhenHasSavedCardsEvent.INSTANCE);
            }
        }
        proceed.invoke(flowOrigin);
    }

    public final void proceedToReturnBooking(Function0<Unit> proceed) {
        MultiRideBookingData multiRideBookingData;
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        CheckoutManager.CheckoutState value = this.checkoutState.getValue();
        Integer valueOf = (value == null || (multiRideBookingData = value.getMultiRideBookingData()) == null) ? null : Integer.valueOf(multiRideBookingData.getRemainingCharges());
        if (valueOf == null || valueOf.intValue() > 1) {
            proceed.invoke();
        } else {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BookingSummaryViewModel$proceedToReturnBooking$1(this, null), 3, null);
        }
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public void resetCheckoutAfterExpiredDepartures() {
        this.$$delegate_0.resetCheckoutAfterExpiredDepartures();
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public boolean showReloadDialog() {
        return this.$$delegate_0.showReloadDialog();
    }

    public final void startPersonalInfoEdit() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, null, false, true, 15, null)));
    }

    public final void toggleAcceptMarketing() {
        this.checkoutManager.toggleAcceptMarketing();
    }

    public final void toggleNewsletterSignup() {
        this.checkoutManager.toggleNewsletterSignup();
    }

    public final void updatePhoneNumberCode(String phoneNumberCode) {
        CheckoutContactInfo personalInfo;
        CheckoutManager.CheckoutState value = this.checkoutState.getValue();
        if (value == null || (personalInfo = value.getPersonalInfo()) == null) {
            return;
        }
        PhoneNumber phoneNumber = personalInfo.getPhoneNumber();
        if (phoneNumberCode == null) {
            return;
        }
        onPhoneNumberChange(PhoneNumber.copy$default(phoneNumber, phoneNumberCode, null, 2, null));
    }

    public final void updateSelectedVehicle(UserVehicle vehicle) {
        this.checkoutManager.updateSelectedVehicle(vehicle);
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJP\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b\n\u0010!R\u0017\u0010\u000b\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b\"\u0010!¨\u0006#"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/summary/BookingSummaryViewModel$ViewState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/site/SiteInfo;", "siteInfo", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/payment/PaymentType;", "paymentTypes", "Ldk/molslinjen/domain/model/account/CreditCard;", "savedCreditCards", BuildConfig.FLAVOR, "isEarlyCheckInPossible", "personalInfoIsInEditMode", "<init>", "(Ldk/molslinjen/domain/model/site/SiteInfo;Ljava/util/List;Ljava/util/List;ZZ)V", "copy", "(Ldk/molslinjen/domain/model/site/SiteInfo;Ljava/util/List;Ljava/util/List;ZZ)Ldk/molslinjen/ui/views/screens/booking/summary/BookingSummaryViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/site/SiteInfo;", "getSiteInfo", "()Ldk/molslinjen/domain/model/site/SiteInfo;", "Ljava/util/List;", "getPaymentTypes", "()Ljava/util/List;", "getSavedCreditCards", "Z", "()Z", "getPersonalInfoIsInEditMode", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final boolean isEarlyCheckInPossible;
        private final List<PaymentType> paymentTypes;
        private final boolean personalInfoIsInEditMode;
        private final List<CreditCard> savedCreditCards;
        private final SiteInfo siteInfo;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(SiteInfo siteInfo, List<? extends PaymentType> paymentTypes, List<CreditCard> savedCreditCards, boolean z5, boolean z6) {
            Intrinsics.checkNotNullParameter(paymentTypes, "paymentTypes");
            Intrinsics.checkNotNullParameter(savedCreditCards, "savedCreditCards");
            this.siteInfo = siteInfo;
            this.paymentTypes = paymentTypes;
            this.savedCreditCards = savedCreditCards;
            this.isEarlyCheckInPossible = z5;
            this.personalInfoIsInEditMode = z6;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, SiteInfo siteInfo, List list, List list2, boolean z5, boolean z6, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                siteInfo = viewState.siteInfo;
            }
            if ((i5 & 2) != 0) {
                list = viewState.paymentTypes;
            }
            List list3 = list;
            if ((i5 & 4) != 0) {
                list2 = viewState.savedCreditCards;
            }
            List list4 = list2;
            if ((i5 & 8) != 0) {
                z5 = viewState.isEarlyCheckInPossible;
            }
            boolean z7 = z5;
            if ((i5 & 16) != 0) {
                z6 = viewState.personalInfoIsInEditMode;
            }
            return viewState.copy(siteInfo, list3, list4, z7, z6);
        }

        public final ViewState copy(SiteInfo siteInfo, List<? extends PaymentType> paymentTypes, List<CreditCard> savedCreditCards, boolean isEarlyCheckInPossible, boolean personalInfoIsInEditMode) {
            Intrinsics.checkNotNullParameter(paymentTypes, "paymentTypes");
            Intrinsics.checkNotNullParameter(savedCreditCards, "savedCreditCards");
            return new ViewState(siteInfo, paymentTypes, savedCreditCards, isEarlyCheckInPossible, personalInfoIsInEditMode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics.areEqual(this.siteInfo, viewState.siteInfo) && Intrinsics.areEqual(this.paymentTypes, viewState.paymentTypes) && Intrinsics.areEqual(this.savedCreditCards, viewState.savedCreditCards) && this.isEarlyCheckInPossible == viewState.isEarlyCheckInPossible && this.personalInfoIsInEditMode == viewState.personalInfoIsInEditMode;
        }

        public final List<PaymentType> getPaymentTypes() {
            return this.paymentTypes;
        }

        public final boolean getPersonalInfoIsInEditMode() {
            return this.personalInfoIsInEditMode;
        }

        public final List<CreditCard> getSavedCreditCards() {
            return this.savedCreditCards;
        }

        public final SiteInfo getSiteInfo() {
            return this.siteInfo;
        }

        public int hashCode() {
            SiteInfo siteInfo = this.siteInfo;
            return ((((((((siteInfo == null ? 0 : siteInfo.hashCode()) * 31) + this.paymentTypes.hashCode()) * 31) + this.savedCreditCards.hashCode()) * 31) + Boolean.hashCode(this.isEarlyCheckInPossible)) * 31) + Boolean.hashCode(this.personalInfoIsInEditMode);
        }

        public String toString() {
            return "ViewState(siteInfo=" + this.siteInfo + ", paymentTypes=" + this.paymentTypes + ", savedCreditCards=" + this.savedCreditCards + ", isEarlyCheckInPossible=" + this.isEarlyCheckInPossible + ", personalInfoIsInEditMode=" + this.personalInfoIsInEditMode + ")";
        }

        public /* synthetic */ ViewState(SiteInfo siteInfo, List list, List list2, boolean z5, boolean z6, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? null : siteInfo, (i5 & 2) != 0 ? IPaymentManager.INSTANCE.getDefaultPaymentMethods() : list, (i5 & 4) != 0 ? CollectionsKt.emptyList() : list2, (i5 & 8) != 0 ? false : z5, (i5 & 16) != 0 ? false : z6);
        }
    }
}
