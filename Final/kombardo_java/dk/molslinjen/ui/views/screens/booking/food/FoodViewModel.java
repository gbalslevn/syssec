package dk.molslinjen.ui.views.screens.booking.food;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.FoodScreenDestination;
import com.ramcosta.composedestinations.spec.Direction;
import dk.molslinjen.core.navigation.ICheckoutNavigator;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.checkout.AddonHelper;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.checkout.EditManager;
import dk.molslinjen.domain.managers.checkout.IAddonHelper;
import dk.molslinjen.domain.managers.checkout.ICheckoutManager;
import dk.molslinjen.domain.managers.checkout.IEditManager;
import dk.molslinjen.domain.managers.checkout.IPaymentManager;
import dk.molslinjen.domain.managers.checkout.IReturnManager;
import dk.molslinjen.domain.managers.departure.IDepartureManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.TicketSection;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.ui.views.screens.booking.shared.expiration.ExpirableCheckoutHandler;
import dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout;
import kotlin.Metadata;
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
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001BBa\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020.H\u0002J\u0016\u00102\u001a\u00020.2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206J\u001a\u00107\u001a\u00020.2\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020.08J\t\u0010:\u001a\u00020;H\u0096\u0001J\t\u0010<\u001a\u00020;H\u0096\u0001J\t\u0010=\u001a\u00020;H\u0096\u0001J\t\u0010>\u001a\u00020;H\u0096\u0001J\t\u0010?\u001a\u00020;H\u0096\u0001J\t\u0010@\u001a\u00020.H\u0096\u0001J\t\u0010A\u001a\u00020;H\u0096\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0019\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0!¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020(0!¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020+0!¢\u0006\b\n\u0000\u001a\u0004\b,\u0010#¨\u0006C"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/food/FoodViewModel;", "Landroidx/lifecycle/ViewModel;", "Ldk/molslinjen/ui/views/screens/booking/shared/expiration/IExpirableCheckout;", "checkoutManager", "Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;", "addonHelper", "Ldk/molslinjen/domain/managers/checkout/IAddonHelper;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "checkoutNavigator", "Ldk/molslinjen/core/navigation/ICheckoutNavigator;", "editManager", "Ldk/molslinjen/domain/managers/checkout/IEditManager;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "routeManager", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "departureManager", "Ldk/molslinjen/domain/managers/departure/IDepartureManager;", "returnManager", "Ldk/molslinjen/domain/managers/checkout/IReturnManager;", "paymentManager", "Ldk/molslinjen/domain/managers/checkout/IPaymentManager;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "<init>", "(Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;Ldk/molslinjen/domain/managers/checkout/IAddonHelper;Ldk/molslinjen/core/snackbar/ISnackbarService;Ldk/molslinjen/core/navigation/ICheckoutNavigator;Ldk/molslinjen/domain/managers/checkout/IEditManager;Landroidx/lifecycle/SavedStateHandle;Ldk/molslinjen/domain/managers/route/IRouteManager;Ldk/molslinjen/domain/managers/departure/IDepartureManager;Ldk/molslinjen/domain/managers/checkout/IReturnManager;Ldk/molslinjen/domain/managers/checkout/IPaymentManager;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;)V", "navArgs", "Ldk/molslinjen/ui/views/screens/booking/food/FoodScreenNavArgs;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/booking/food/FoodViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "checkoutState", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;", "getCheckoutState", "addonState", "Ldk/molslinjen/domain/managers/checkout/AddonHelper$AddonState;", "getAddonState", "editState", "Ldk/molslinjen/domain/managers/checkout/EditManager$EditState;", "getEditState", "loadDepartureDirection", BuildConfig.FLAVOR, "departureDirection", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "loadProducts", "onQuantityChanged", "product", "Ldk/molslinjen/domain/model/booking/product/Product;", "quantity", BuildConfig.FLAVOR, "proceed", "Lkotlin/Function1;", "Lcom/ramcosta/composedestinations/spec/Direction;", "isCommuter", BuildConfig.FLAVOR, "isEditing", "isExpired", "isInCheckoutFlow", "isMultiRide", "resetCheckoutAfterExpiredDepartures", "showReloadDialog", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FoodViewModel extends ViewModel implements IExpirableCheckout {
    private final /* synthetic */ ExpirableCheckoutHandler $$delegate_0;
    private final MutableStateFlow<ViewState> _viewState;
    private final IAddonHelper addonHelper;
    private final StateFlow<AddonHelper.AddonState> addonState;
    private final IAnalyticsTracker analyticsTracker;
    private final ICheckoutManager checkoutManager;
    private final ICheckoutNavigator checkoutNavigator;
    private final StateFlow<CheckoutManager.CheckoutState> checkoutState;
    private final IDepartureManager departureManager;
    private final IEditManager editManager;
    private final StateFlow<EditManager.EditState> editState;
    private final FoodScreenNavArgs navArgs;
    private final IPaymentManager paymentManager;
    private final IReturnManager returnManager;
    private final IRouteManager routeManager;
    private final ISnackbarService snackbarService;
    private final StateFlow<ViewState> viewState;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.food.FoodViewModel$1", f = "FoodViewModel.kt", l = {72}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.booking.food.FoodViewModel$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "addonState", "Ldk/molslinjen/domain/managers/checkout/AddonHelper$AddonState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.food.FoodViewModel$1$1", f = "FoodViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.booking.food.FoodViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00551 extends SuspendLambda implements Function2<AddonHelper.AddonState, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ FoodViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00551(FoodViewModel foodViewModel, Continuation<? super C00551> continuation) {
                super(2, continuation);
                this.this$0 = foodViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00551 c00551 = new C00551(this.this$0, continuation);
                c00551.L$0 = obj;
                return c00551;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AddonHelper.AddonState addonState, Continuation<? super Unit> continuation) {
                return ((C00551) create(addonState, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.checkoutManager.updateFood((AddonHelper.AddonState) this.L$0, ((ViewState) this.this$0._viewState.getValue()).getDepartureDirection());
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
                StateFlow<AddonHelper.AddonState> addonState = FoodViewModel.this.addonHelper.getAddonState();
                C00551 c00551 = new C00551(FoodViewModel.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(addonState, c00551, this) == coroutine_suspended) {
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

    public FoodViewModel(ICheckoutManager checkoutManager, IAddonHelper addonHelper, ISnackbarService snackbarService, ICheckoutNavigator checkoutNavigator, IEditManager editManager, SavedStateHandle savedStateHandle, IRouteManager routeManager, IDepartureManager departureManager, IReturnManager returnManager, IPaymentManager paymentManager, IAnalyticsTracker analyticsTracker) {
        Intrinsics.checkNotNullParameter(checkoutManager, "checkoutManager");
        Intrinsics.checkNotNullParameter(addonHelper, "addonHelper");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(checkoutNavigator, "checkoutNavigator");
        Intrinsics.checkNotNullParameter(editManager, "editManager");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(routeManager, "routeManager");
        Intrinsics.checkNotNullParameter(departureManager, "departureManager");
        Intrinsics.checkNotNullParameter(returnManager, "returnManager");
        Intrinsics.checkNotNullParameter(paymentManager, "paymentManager");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        this.$$delegate_0 = new ExpirableCheckoutHandler(routeManager, departureManager, editManager, returnManager, paymentManager, null, false, analyticsTracker, 96, null);
        this.checkoutManager = checkoutManager;
        this.addonHelper = addonHelper;
        this.snackbarService = snackbarService;
        this.checkoutNavigator = checkoutNavigator;
        this.editManager = editManager;
        this.routeManager = routeManager;
        this.departureManager = departureManager;
        this.returnManager = returnManager;
        this.paymentManager = paymentManager;
        this.analyticsTracker = analyticsTracker;
        FoodScreenNavArgs argsFrom = FoodScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        this.navArgs = argsFrom;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(false, null, null, 7, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        this.checkoutState = checkoutManager.getCheckoutState();
        this.addonState = addonHelper.getAddonState();
        this.editState = editManager.getEditState();
        loadDepartureDirection(argsFrom.getDepartureDirection());
        loadProducts();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    private final void loadDepartureDirection(DepartureDirection departureDirection) {
        BookingType bookingType;
        ViewState value;
        CheckoutManager.CheckoutState value2 = this.checkoutState.getValue();
        if (value2 == null || (bookingType = value2.getBookingType()) == null) {
            return;
        }
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, departureDirection, bookingType, 1, null)));
    }

    private final void loadProducts() {
        CheckoutManager.CheckoutDirectionState value;
        CheckoutManager.CheckoutState value2 = this.checkoutState.getValue();
        if (value2 == null || (value = this.checkoutManager.directionState(this.viewState.getValue().getDepartureDirection()).getValue()) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new FoodViewModel$loadProducts$1(this, value, value2, null), 3, null);
    }

    public final StateFlow<AddonHelper.AddonState> getAddonState() {
        return this.addonState;
    }

    public final StateFlow<CheckoutManager.CheckoutState> getCheckoutState() {
        return this.checkoutState;
    }

    public final StateFlow<EditManager.EditState> getEditState() {
        return this.editState;
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

    public final void onQuantityChanged(Product product, int quantity) {
        Intrinsics.checkNotNullParameter(product, "product");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new FoodViewModel$onQuantityChanged$1(quantity, product, this, null), 3, null);
    }

    public final void proceed(Function1<? super Direction, Unit> proceed) {
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        Direction nextStep = this.checkoutNavigator.nextStep(TicketSection.Food, this.viewState.getValue().getBookingType(), this.viewState.getValue().getDepartureDirection());
        if (nextStep == null) {
            return;
        }
        proceed.invoke(nextStep);
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public void resetCheckoutAfterExpiredDepartures() {
        this.$$delegate_0.resetCheckoutAfterExpiredDepartures();
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public boolean showReloadDialog() {
        return this.$$delegate_0.showReloadDialog();
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0003\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/food/FoodViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isLoading", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "departureDirection", "Ldk/molslinjen/domain/model/booking/BookingType;", "bookingType", "<init>", "(ZLdk/molslinjen/domain/model/booking/DepartureDirection;Ldk/molslinjen/domain/model/booking/BookingType;)V", "copy", "(ZLdk/molslinjen/domain/model/booking/DepartureDirection;Ldk/molslinjen/domain/model/booking/BookingType;)Ldk/molslinjen/ui/views/screens/booking/food/FoodViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "getDepartureDirection", "()Ldk/molslinjen/domain/model/booking/DepartureDirection;", "Ldk/molslinjen/domain/model/booking/BookingType;", "getBookingType", "()Ldk/molslinjen/domain/model/booking/BookingType;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final BookingType bookingType;
        private final DepartureDirection departureDirection;
        private final boolean isLoading;

        public ViewState(boolean z5, DepartureDirection departureDirection, BookingType bookingType) {
            Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
            Intrinsics.checkNotNullParameter(bookingType, "bookingType");
            this.isLoading = z5;
            this.departureDirection = departureDirection;
            this.bookingType = bookingType;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z5, DepartureDirection departureDirection, BookingType bookingType, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z5 = viewState.isLoading;
            }
            if ((i5 & 2) != 0) {
                departureDirection = viewState.departureDirection;
            }
            if ((i5 & 4) != 0) {
                bookingType = viewState.bookingType;
            }
            return viewState.copy(z5, departureDirection, bookingType);
        }

        public final ViewState copy(boolean isLoading, DepartureDirection departureDirection, BookingType bookingType) {
            Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
            Intrinsics.checkNotNullParameter(bookingType, "bookingType");
            return new ViewState(isLoading, departureDirection, bookingType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isLoading == viewState.isLoading && this.departureDirection == viewState.departureDirection && this.bookingType == viewState.bookingType;
        }

        public final BookingType getBookingType() {
            return this.bookingType;
        }

        public final DepartureDirection getDepartureDirection() {
            return this.departureDirection;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.isLoading) * 31) + this.departureDirection.hashCode()) * 31) + this.bookingType.hashCode();
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public String toString() {
            return "ViewState(isLoading=" + this.isLoading + ", departureDirection=" + this.departureDirection + ", bookingType=" + this.bookingType + ")";
        }

        public /* synthetic */ ViewState(boolean z5, DepartureDirection departureDirection, BookingType bookingType, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? true : z5, (i5 & 2) != 0 ? DepartureDirection.Outbound : departureDirection, (i5 & 4) != 0 ? BookingType.Single : bookingType);
        }
    }
}
