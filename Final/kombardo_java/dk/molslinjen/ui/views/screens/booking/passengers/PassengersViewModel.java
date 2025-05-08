package dk.molslinjen.ui.views.screens.booking.passengers;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.PassengersScreenDestination;
import com.ramcosta.composedestinations.spec.Direction;
import dk.molslinjen.core.navigation.ICheckoutNavigator;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.checkout.EditManager;
import dk.molslinjen.domain.managers.checkout.ICheckoutManager;
import dk.molslinjen.domain.managers.checkout.ICheckoutPassengerManager;
import dk.molslinjen.domain.managers.checkout.IEditManager;
import dk.molslinjen.domain.managers.checkout.IPaymentManager;
import dk.molslinjen.domain.managers.checkout.IReturnManager;
import dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper;
import dk.molslinjen.domain.managers.checkout.passengers.ISharedPassengerSelectionViewState;
import dk.molslinjen.domain.managers.departure.IDepartureManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.managers.splitTest.ISplitTestManager;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.booking.TicketSection;
import dk.molslinjen.domain.model.config.Transportation;
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

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001QBq\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u00106\u001a\u000207H\u0002J$\u00108\u001a\u0002072\u0006\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u0002032\b\b\u0002\u0010<\u001a\u000203H\u0002J\u000e\u0010=\u001a\u0002072\u0006\u0010>\u001a\u00020?J\u001a\u0010@\u001a\u0002072\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u0002070AJ\u0006\u0010C\u001a\u000207J\u0006\u0010D\u001a\u000207J\u000e\u0010E\u001a\u0002072\u0006\u0010F\u001a\u000203J\u000e\u0010G\u001a\u0002072\u0006\u0010H\u001a\u00020IJ\t\u0010J\u001a\u000203H\u0096\u0001J\t\u0010K\u001a\u000203H\u0096\u0001J\t\u0010L\u001a\u000203H\u0096\u0001J\t\u0010M\u001a\u000203H\u0096\u0001J\t\u0010N\u001a\u000203H\u0096\u0001J\t\u0010O\u001a\u000207H\u0096\u0001J\t\u0010P\u001a\u000203H\u0096\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\"¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\"¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\"¢\u0006\b\n\u0000\u001a\u0004\b+\u0010%R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u00102\u001a\u000203¢\u0006\b\n\u0000\u001a\u0004\b4\u00105¨\u0006R"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/passengers/PassengersViewModel;", "Landroidx/lifecycle/ViewModel;", "Ldk/molslinjen/ui/views/screens/booking/shared/expiration/IExpirableCheckout;", "checkoutManager", "Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;", "checkoutNavigator", "Ldk/molslinjen/core/navigation/ICheckoutNavigator;", "checkoutPassengerManager", "Ldk/molslinjen/domain/managers/checkout/ICheckoutPassengerManager;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "routeManager", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "departureManager", "Ldk/molslinjen/domain/managers/departure/IDepartureManager;", "returnManager", "Ldk/molslinjen/domain/managers/checkout/IReturnManager;", "editManager", "Ldk/molslinjen/domain/managers/checkout/IEditManager;", "paymentManager", "Ldk/molslinjen/domain/managers/checkout/IPaymentManager;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "splitTestManager", "Ldk/molslinjen/domain/managers/splitTest/ISplitTestManager;", "<init>", "(Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;Ldk/molslinjen/core/navigation/ICheckoutNavigator;Ldk/molslinjen/domain/managers/checkout/ICheckoutPassengerManager;Ldk/molslinjen/core/snackbar/ISnackbarService;Ldk/molslinjen/domain/managers/user/IUserManager;Landroidx/lifecycle/SavedStateHandle;Ldk/molslinjen/domain/managers/route/IRouteManager;Ldk/molslinjen/domain/managers/departure/IDepartureManager;Ldk/molslinjen/domain/managers/checkout/IReturnManager;Ldk/molslinjen/domain/managers/checkout/IEditManager;Ldk/molslinjen/domain/managers/checkout/IPaymentManager;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;Ldk/molslinjen/domain/managers/splitTest/ISplitTestManager;)V", "navArgs", "Ldk/molslinjen/ui/views/screens/booking/passengers/PassengersScreenNavArgs;", "checkoutState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;", "getCheckoutState", "()Lkotlinx/coroutines/flow/StateFlow;", "passengerState", "Ldk/molslinjen/domain/managers/checkout/PassengerSelectionHelper$PassengerState;", "getPassengerState", "editState", "Ldk/molslinjen/domain/managers/checkout/EditManager$EditState;", "getEditState", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/booking/passengers/PassengersViewModel$ViewState;", "viewState", "getViewState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "movePassengerInfo", BuildConfig.FLAVOR, "getMovePassengerInfo", "()Z", "listenForLoginChange", BuildConfig.FLAVOR, "loadPassengers", "departureDirection", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "onlySelectMe", "mergeAfterProfileChange", "toggleSelected", "passenger", "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "proceed", "Lkotlin/Function1;", "Lcom/ramcosta/composedestinations/spec/Direction;", "showAgeGroupError", "onCurrentUserCreatedAsPassenger", "changeSameReturnPassengersAsOutbound", "sameAsOutbound", "showValidationMessage", "errorMessage", BuildConfig.FLAVOR, "isCommuter", "isEditing", "isExpired", "isInCheckoutFlow", "isMultiRide", "resetCheckoutAfterExpiredDepartures", "showReloadDialog", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PassengersViewModel extends ViewModel implements IExpirableCheckout {
    private final /* synthetic */ ExpirableCheckoutHandler $$delegate_0;
    private final MutableStateFlow<ViewState> _viewState;
    private final IAnalyticsTracker analyticsTracker;
    private final ICheckoutManager checkoutManager;
    private final ICheckoutNavigator checkoutNavigator;
    private final ICheckoutPassengerManager checkoutPassengerManager;
    private final StateFlow<CheckoutManager.CheckoutState> checkoutState;
    private final IDepartureManager departureManager;
    private final IEditManager editManager;
    private final StateFlow<EditManager.EditState> editState;
    private final boolean movePassengerInfo;
    private final PassengersScreenNavArgs navArgs;
    private final StateFlow<PassengerSelectionHelper.PassengerState> passengerState;
    private final IPaymentManager paymentManager;
    private final IReturnManager returnManager;
    private final IRouteManager routeManager;
    private final ISnackbarService snackbarService;
    private final IUserManager userManager;
    private final MutableStateFlow<ViewState> viewState;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.passengers.PassengersViewModel$2", f = "PassengersViewModel.kt", l = {97}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.booking.passengers.PassengersViewModel$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CheckoutManager.CheckoutDirectionState $checkoutDirectionState;
        final /* synthetic */ DepartureDirection $departureDirection;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "<unused var>", "Ldk/molslinjen/domain/managers/checkout/PassengerSelectionHelper$PassengerState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.passengers.PassengersViewModel$2$1", f = "PassengersViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.booking.passengers.PassengersViewModel$2$1, reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<PassengerSelectionHelper.PassengerState, Continuation<? super Unit>, Object> {
            final /* synthetic */ CheckoutManager.CheckoutDirectionState $checkoutDirectionState;
            final /* synthetic */ DepartureDirection $departureDirection;
            int label;
            final /* synthetic */ PassengersViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(PassengersViewModel passengersViewModel, CheckoutManager.CheckoutDirectionState checkoutDirectionState, DepartureDirection departureDirection, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = passengersViewModel;
                this.$checkoutDirectionState = checkoutDirectionState;
                this.$departureDirection = departureDirection;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$checkoutDirectionState, this.$departureDirection, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(PassengerSelectionHelper.PassengerState passengerState, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(passengerState, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                CheckoutManager.CheckoutState value = this.this$0.checkoutManager.getCheckoutState().getValue();
                if (value != null && this.$checkoutDirectionState != null) {
                    boolean isWalking = value.getTransportation().isWalking();
                    PassengerInfo passengerInfo = this.$checkoutDirectionState.getPassengerInfo();
                    ISharedPassengerSelectionViewState calculatePassengerSelectionState = this.this$0.checkoutPassengerManager.calculatePassengerSelectionState(passengerInfo, value.getTransportation(), this.$departureDirection);
                    MutableStateFlow mutableStateFlow = this.this$0._viewState;
                    while (true) {
                        Object value2 = mutableStateFlow.getValue();
                        MutableStateFlow mutableStateFlow2 = mutableStateFlow;
                        PassengerInfo passengerInfo2 = passengerInfo;
                        if (mutableStateFlow2.compareAndSet(value2, ViewState.copy$default((ViewState) value2, false, calculatePassengerSelectionState.getRemainingPassengerCount(), calculatePassengerSelectionState.getRemainingAdultCount(), calculatePassengerSelectionState.getRemainingChildCount(), calculatePassengerSelectionState.getRemainingInfantCount(), calculatePassengerSelectionState.getPassengerCount(), isWalking, false, false, null, value.getBookingType(), passengerInfo, 897, null))) {
                            return Unit.INSTANCE;
                        }
                        mutableStateFlow = mutableStateFlow2;
                        passengerInfo = passengerInfo2;
                    }
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(CheckoutManager.CheckoutDirectionState checkoutDirectionState, DepartureDirection departureDirection, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$checkoutDirectionState = checkoutDirectionState;
            this.$departureDirection = departureDirection;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$checkoutDirectionState, this.$departureDirection, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<PassengerSelectionHelper.PassengerState> passengerState = PassengersViewModel.this.getPassengerState();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(PassengersViewModel.this, this.$checkoutDirectionState, this.$departureDirection, null);
                this.label = 1;
                if (FlowKt.collectLatest(passengerState, anonymousClass1, this) == coroutine_suspended) {
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

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0116, code lost:
    
        if (r9.equals(r1 != null ? r1.getPassengerInfo() : null) == true) goto L15;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PassengersViewModel(ICheckoutManager checkoutManager, ICheckoutNavigator checkoutNavigator, ICheckoutPassengerManager checkoutPassengerManager, ISnackbarService snackbarService, IUserManager userManager, SavedStateHandle savedStateHandle, IRouteManager routeManager, IDepartureManager departureManager, IReturnManager returnManager, IEditManager editManager, IPaymentManager paymentManager, IAnalyticsTracker analyticsTracker, ISplitTestManager splitTestManager) {
        Object[] objArr;
        boolean z5;
        boolean z6;
        ViewState value;
        Transportation transportation;
        Intrinsics.checkNotNullParameter(checkoutManager, "checkoutManager");
        Intrinsics.checkNotNullParameter(checkoutNavigator, "checkoutNavigator");
        Intrinsics.checkNotNullParameter(checkoutPassengerManager, "checkoutPassengerManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(routeManager, "routeManager");
        Intrinsics.checkNotNullParameter(departureManager, "departureManager");
        Intrinsics.checkNotNullParameter(returnManager, "returnManager");
        Intrinsics.checkNotNullParameter(editManager, "editManager");
        Intrinsics.checkNotNullParameter(paymentManager, "paymentManager");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        Intrinsics.checkNotNullParameter(splitTestManager, "splitTestManager");
        this.$$delegate_0 = new ExpirableCheckoutHandler(routeManager, departureManager, editManager, returnManager, paymentManager, null, false, analyticsTracker, 96, null);
        this.checkoutManager = checkoutManager;
        this.checkoutNavigator = checkoutNavigator;
        this.checkoutPassengerManager = checkoutPassengerManager;
        this.snackbarService = snackbarService;
        this.userManager = userManager;
        this.routeManager = routeManager;
        this.departureManager = departureManager;
        this.returnManager = returnManager;
        this.editManager = editManager;
        this.paymentManager = paymentManager;
        this.analyticsTracker = analyticsTracker;
        PassengersScreenNavArgs argsFrom = PassengersScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        this.navArgs = argsFrom;
        StateFlow<CheckoutManager.CheckoutState> checkoutState = checkoutManager.getCheckoutState();
        this.checkoutState = checkoutState;
        this.editState = editManager.getEditState();
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(false, 0, 0, 0, 0, 0, false, false, false, null, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 4095, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        this.movePassengerInfo = splitTestManager.getMovePassengerInfo();
        DepartureDirection departureDirection = argsFrom.getDepartureDirection();
        CheckoutManager.CheckoutDirectionState value2 = checkoutManager.directionState(departureDirection).getValue();
        this.passengerState = checkoutPassengerManager.passengerState(departureDirection);
        DepartureDirection departureDirection2 = DepartureDirection.Outbound;
        if (departureDirection != departureDirection2) {
            if (value2 != null && (r9 = value2.getPassengerInfo()) != null) {
                CheckoutManager.CheckoutDirectionState value3 = checkoutManager.directionState(departureDirection2).getValue();
            }
            objArr = false;
            CheckoutManager.CheckoutState value4 = checkoutState.getValue();
            Object[] objArr2 = value4 == null && (transportation = value4.getTransportation()) != null && transportation.isWalking();
            z5 = objArr2 == true || objArr == true;
            z6 = objArr2 == true || objArr == true;
            do {
                value = MutableStateFlow.getValue();
            } while (!MutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, 0, 0, 0, 0, 0, false, z5, z6, departureDirection, null, null, 3199, null)));
            listenForLoginChange();
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(value2, departureDirection, null), 3, null);
        }
        objArr = true;
        CheckoutManager.CheckoutState value42 = checkoutState.getValue();
        if (value42 == null) {
        }
        if (objArr2 == true) {
        }
        if (objArr2 == true) {
        }
        do {
            value = MutableStateFlow.getValue();
        } while (!MutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, 0, 0, 0, 0, 0, false, z5, z6, departureDirection, null, null, 3199, null)));
        listenForLoginChange();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(value2, departureDirection, null), 3, null);
    }

    private final void listenForLoginChange() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new PassengersViewModel$listenForLoginChange$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadPassengers(DepartureDirection departureDirection, boolean onlySelectMe, boolean mergeAfterProfileChange) {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, true, 0, 0, 0, 0, 0, false, false, false, null, null, null, 4094, null)));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new PassengersViewModel$loadPassengers$2(this, departureDirection, onlySelectMe, mergeAfterProfileChange, null), 3, null);
    }

    static /* synthetic */ void loadPassengers$default(PassengersViewModel passengersViewModel, DepartureDirection departureDirection, boolean z5, boolean z6, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        if ((i5 & 4) != 0) {
            z6 = false;
        }
        passengersViewModel.loadPassengers(departureDirection, z5, z6);
    }

    public final void changeSameReturnPassengersAsOutbound(boolean sameAsOutbound) {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, 0, 0, 0, 0, 0, false, sameAsOutbound, false, null, null, null, 3967, null)));
    }

    public final StateFlow<CheckoutManager.CheckoutState> getCheckoutState() {
        return this.checkoutState;
    }

    public final StateFlow<EditManager.EditState> getEditState() {
        return this.editState;
    }

    public final boolean getMovePassengerInfo() {
        return this.movePassengerInfo;
    }

    public final StateFlow<PassengerSelectionHelper.PassengerState> getPassengerState() {
        return this.passengerState;
    }

    public final MutableStateFlow<ViewState> getViewState() {
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

    public final void onCurrentUserCreatedAsPassenger() {
        loadPassengers$default(this, this.viewState.getValue().getDepartureDirection(), false, true, 2, null);
    }

    public final void proceed(Function1<? super Direction, Unit> proceed) {
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        Direction nextStep = this.checkoutNavigator.nextStep(TicketSection.Passenger, this.viewState.getValue().getBookingType(), this.viewState.getValue().getDepartureDirection());
        if (nextStep == null) {
            return;
        }
        proceed.invoke(nextStep);
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public void resetCheckoutAfterExpiredDepartures() {
        this.$$delegate_0.resetCheckoutAfterExpiredDepartures();
    }

    public final void showAgeGroupError() {
        if (this.viewState.getValue().getRemainingPassengerCount() == 0) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new PassengersViewModel$showAgeGroupError$1(this, null), 3, null);
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public boolean showReloadDialog() {
        return this.$$delegate_0.showReloadDialog();
    }

    public final void showValidationMessage(String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new PassengersViewModel$showValidationMessage$1(this, errorMessage, null), 3, null);
    }

    public final void toggleSelected(BookingPassenger passenger) {
        Intrinsics.checkNotNullParameter(passenger, "passenger");
        this.checkoutPassengerManager.toggleSelected(passenger, this.viewState.getValue().getDepartureDirection());
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0018\b\u0087\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u008a\u0001\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b\u0003\u0010!R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010\u001bR\u001a\u0010\u0006\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\"\u001a\u0004\b$\u0010\u001bR\u001a\u0010\u0007\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b%\u0010\u001bR\u001a\u0010\b\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\"\u001a\u0004\b&\u0010\u001bR\u001a\u0010\t\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\"\u001a\u0004\b'\u0010\u001bR\u001a\u0010\n\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b(\u0010!R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b)\u0010!R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b*\u0010!R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010.\u001a\u0004\b/\u00100R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u00101\u001a\u0004\b2\u00103¨\u00064"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/passengers/PassengersViewModel$ViewState;", "Ldk/molslinjen/domain/managers/checkout/passengers/ISharedPassengerSelectionViewState;", BuildConfig.FLAVOR, "isLoading", BuildConfig.FLAVOR, "remainingPassengerCount", "remainingAdultCount", "remainingChildCount", "remainingInfantCount", "passengerCount", "showAgeGroup", "sameReturnPassengersAsOutbound", "sameReturnPassengersAsOutboundChangePossible", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "departureDirection", "Ldk/molslinjen/domain/model/booking/BookingType;", "bookingType", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "passengerInfo", "<init>", "(ZIIIIIZZZLdk/molslinjen/domain/model/booking/DepartureDirection;Ldk/molslinjen/domain/model/booking/BookingType;Ldk/molslinjen/domain/model/booking/PassengerInfo;)V", "copy", "(ZIIIIIZZZLdk/molslinjen/domain/model/booking/DepartureDirection;Ldk/molslinjen/domain/model/booking/BookingType;Ldk/molslinjen/domain/model/booking/PassengerInfo;)Ldk/molslinjen/ui/views/screens/booking/passengers/PassengersViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", BuildConfig.FLAVOR, "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "I", "getRemainingPassengerCount", "getRemainingAdultCount", "getRemainingChildCount", "getRemainingInfantCount", "getPassengerCount", "getShowAgeGroup", "getSameReturnPassengersAsOutbound", "getSameReturnPassengersAsOutboundChangePossible", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "getDepartureDirection", "()Ldk/molslinjen/domain/model/booking/DepartureDirection;", "Ldk/molslinjen/domain/model/booking/BookingType;", "getBookingType", "()Ldk/molslinjen/domain/model/booking/BookingType;", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "getPassengerInfo", "()Ldk/molslinjen/domain/model/booking/PassengerInfo;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState implements ISharedPassengerSelectionViewState {
        private final BookingType bookingType;
        private final DepartureDirection departureDirection;
        private final boolean isLoading;
        private final int passengerCount;
        private final PassengerInfo passengerInfo;
        private final int remainingAdultCount;
        private final int remainingChildCount;
        private final int remainingInfantCount;
        private final int remainingPassengerCount;
        private final boolean sameReturnPassengersAsOutbound;
        private final boolean sameReturnPassengersAsOutboundChangePossible;
        private final boolean showAgeGroup;

        public ViewState(boolean z5, int i5, int i6, int i7, int i8, int i9, boolean z6, boolean z7, boolean z8, DepartureDirection departureDirection, BookingType bookingType, PassengerInfo passengerInfo) {
            Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
            Intrinsics.checkNotNullParameter(bookingType, "bookingType");
            this.isLoading = z5;
            this.remainingPassengerCount = i5;
            this.remainingAdultCount = i6;
            this.remainingChildCount = i7;
            this.remainingInfantCount = i8;
            this.passengerCount = i9;
            this.showAgeGroup = z6;
            this.sameReturnPassengersAsOutbound = z7;
            this.sameReturnPassengersAsOutboundChangePossible = z8;
            this.departureDirection = departureDirection;
            this.bookingType = bookingType;
            this.passengerInfo = passengerInfo;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z5, int i5, int i6, int i7, int i8, int i9, boolean z6, boolean z7, boolean z8, DepartureDirection departureDirection, BookingType bookingType, PassengerInfo passengerInfo, int i10, Object obj) {
            return viewState.copy((i10 & 1) != 0 ? viewState.isLoading : z5, (i10 & 2) != 0 ? viewState.remainingPassengerCount : i5, (i10 & 4) != 0 ? viewState.remainingAdultCount : i6, (i10 & 8) != 0 ? viewState.remainingChildCount : i7, (i10 & 16) != 0 ? viewState.remainingInfantCount : i8, (i10 & 32) != 0 ? viewState.passengerCount : i9, (i10 & 64) != 0 ? viewState.showAgeGroup : z6, (i10 & 128) != 0 ? viewState.sameReturnPassengersAsOutbound : z7, (i10 & 256) != 0 ? viewState.sameReturnPassengersAsOutboundChangePossible : z8, (i10 & 512) != 0 ? viewState.departureDirection : departureDirection, (i10 & 1024) != 0 ? viewState.bookingType : bookingType, (i10 & 2048) != 0 ? viewState.passengerInfo : passengerInfo);
        }

        public final ViewState copy(boolean isLoading, int remainingPassengerCount, int remainingAdultCount, int remainingChildCount, int remainingInfantCount, int passengerCount, boolean showAgeGroup, boolean sameReturnPassengersAsOutbound, boolean sameReturnPassengersAsOutboundChangePossible, DepartureDirection departureDirection, BookingType bookingType, PassengerInfo passengerInfo) {
            Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
            Intrinsics.checkNotNullParameter(bookingType, "bookingType");
            return new ViewState(isLoading, remainingPassengerCount, remainingAdultCount, remainingChildCount, remainingInfantCount, passengerCount, showAgeGroup, sameReturnPassengersAsOutbound, sameReturnPassengersAsOutboundChangePossible, departureDirection, bookingType, passengerInfo);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isLoading == viewState.isLoading && this.remainingPassengerCount == viewState.remainingPassengerCount && this.remainingAdultCount == viewState.remainingAdultCount && this.remainingChildCount == viewState.remainingChildCount && this.remainingInfantCount == viewState.remainingInfantCount && this.passengerCount == viewState.passengerCount && this.showAgeGroup == viewState.showAgeGroup && this.sameReturnPassengersAsOutbound == viewState.sameReturnPassengersAsOutbound && this.sameReturnPassengersAsOutboundChangePossible == viewState.sameReturnPassengersAsOutboundChangePossible && this.departureDirection == viewState.departureDirection && this.bookingType == viewState.bookingType && Intrinsics.areEqual(this.passengerInfo, viewState.passengerInfo);
        }

        public final BookingType getBookingType() {
            return this.bookingType;
        }

        public final DepartureDirection getDepartureDirection() {
            return this.departureDirection;
        }

        @Override // dk.molslinjen.domain.managers.checkout.passengers.ISharedPassengerSelectionViewState
        public int getPassengerCount() {
            return this.passengerCount;
        }

        public final PassengerInfo getPassengerInfo() {
            return this.passengerInfo;
        }

        @Override // dk.molslinjen.domain.managers.checkout.passengers.ISharedPassengerSelectionViewState
        public int getRemainingAdultCount() {
            return this.remainingAdultCount;
        }

        @Override // dk.molslinjen.domain.managers.checkout.passengers.ISharedPassengerSelectionViewState
        public int getRemainingChildCount() {
            return this.remainingChildCount;
        }

        @Override // dk.molslinjen.domain.managers.checkout.passengers.ISharedPassengerSelectionViewState
        public int getRemainingInfantCount() {
            return this.remainingInfantCount;
        }

        @Override // dk.molslinjen.domain.managers.checkout.passengers.ISharedPassengerSelectionViewState
        public int getRemainingPassengerCount() {
            return this.remainingPassengerCount;
        }

        public final boolean getSameReturnPassengersAsOutbound() {
            return this.sameReturnPassengersAsOutbound;
        }

        public final boolean getSameReturnPassengersAsOutboundChangePossible() {
            return this.sameReturnPassengersAsOutboundChangePossible;
        }

        @Override // dk.molslinjen.domain.managers.checkout.passengers.ISharedPassengerSelectionViewState
        public boolean getShowAgeGroup() {
            return this.showAgeGroup;
        }

        public int hashCode() {
            int hashCode = ((((((((((((((((((((Boolean.hashCode(this.isLoading) * 31) + Integer.hashCode(this.remainingPassengerCount)) * 31) + Integer.hashCode(this.remainingAdultCount)) * 31) + Integer.hashCode(this.remainingChildCount)) * 31) + Integer.hashCode(this.remainingInfantCount)) * 31) + Integer.hashCode(this.passengerCount)) * 31) + Boolean.hashCode(this.showAgeGroup)) * 31) + Boolean.hashCode(this.sameReturnPassengersAsOutbound)) * 31) + Boolean.hashCode(this.sameReturnPassengersAsOutboundChangePossible)) * 31) + this.departureDirection.hashCode()) * 31) + this.bookingType.hashCode()) * 31;
            PassengerInfo passengerInfo = this.passengerInfo;
            return hashCode + (passengerInfo == null ? 0 : passengerInfo.hashCode());
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public String toString() {
            return "ViewState(isLoading=" + this.isLoading + ", remainingPassengerCount=" + this.remainingPassengerCount + ", remainingAdultCount=" + this.remainingAdultCount + ", remainingChildCount=" + this.remainingChildCount + ", remainingInfantCount=" + this.remainingInfantCount + ", passengerCount=" + this.passengerCount + ", showAgeGroup=" + this.showAgeGroup + ", sameReturnPassengersAsOutbound=" + this.sameReturnPassengersAsOutbound + ", sameReturnPassengersAsOutboundChangePossible=" + this.sameReturnPassengersAsOutboundChangePossible + ", departureDirection=" + this.departureDirection + ", bookingType=" + this.bookingType + ", passengerInfo=" + this.passengerInfo + ")";
        }

        public /* synthetic */ ViewState(boolean z5, int i5, int i6, int i7, int i8, int i9, boolean z6, boolean z7, boolean z8, DepartureDirection departureDirection, BookingType bookingType, PassengerInfo passengerInfo, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? true : z5, (i10 & 2) != 0 ? 0 : i5, (i10 & 4) != 0 ? 0 : i6, (i10 & 8) != 0 ? 0 : i7, (i10 & 16) != 0 ? 0 : i8, (i10 & 32) != 0 ? 0 : i9, (i10 & 64) == 0 ? z6 : false, (i10 & 128) != 0 ? true : z7, (i10 & 256) == 0 ? z8 : true, (i10 & 512) != 0 ? DepartureDirection.Outbound : departureDirection, (i10 & 1024) != 0 ? BookingType.Single : bookingType, (i10 & 2048) != 0 ? null : passengerInfo);
        }
    }
}
