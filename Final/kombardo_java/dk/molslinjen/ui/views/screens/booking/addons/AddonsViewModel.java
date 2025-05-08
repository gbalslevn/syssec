package dk.molslinjen.ui.views.screens.booking.addons;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.AddonsScreenDestination;
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
import dk.molslinjen.domain.managers.seating.ISelectSeatingManager;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.TicketSection;
import dk.molslinjen.domain.model.booking.product.CheckoutSeatReservation;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.UnavailableSeatReservation;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.ui.views.screens.booking.shared.expiration.ExpirableCheckoutHandler;
import dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout;
import java.util.List;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FerrySeat;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001FBi\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002J\u0006\u00103\u001a\u000200J\b\u00104\u001a\u000200H\u0002J\u0016\u00105\u001a\u0002002\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209J\u001a\u0010:\u001a\u0002002\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002000;J\u0006\u0010=\u001a\u000200J\t\u0010>\u001a\u00020?H\u0096\u0001J\t\u0010@\u001a\u00020?H\u0096\u0001J\t\u0010A\u001a\u00020?H\u0096\u0001J\t\u0010B\u001a\u00020?H\u0096\u0001J\t\u0010C\u001a\u00020?H\u0096\u0001J\t\u0010D\u001a\u000200H\u0096\u0001J\t\u0010E\u001a\u00020?H\u0096\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0019\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0#¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020*0#¢\u0006\b\n\u0000\u001a\u0004\b+\u0010%R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020-0#¢\u0006\b\n\u0000\u001a\u0004\b.\u0010%¨\u0006G"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel;", "Landroidx/lifecycle/ViewModel;", "Ldk/molslinjen/ui/views/screens/booking/shared/expiration/IExpirableCheckout;", "checkoutManager", "Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;", "addonHelper", "Ldk/molslinjen/domain/managers/checkout/IAddonHelper;", "seatingManager", "Ldk/molslinjen/domain/managers/seating/ISelectSeatingManager;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "checkoutNavigator", "Ldk/molslinjen/core/navigation/ICheckoutNavigator;", "editManager", "Ldk/molslinjen/domain/managers/checkout/IEditManager;", "routeManager", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "departureManager", "Ldk/molslinjen/domain/managers/departure/IDepartureManager;", "returnManager", "Ldk/molslinjen/domain/managers/checkout/IReturnManager;", "paymentManager", "Ldk/molslinjen/domain/managers/checkout/IPaymentManager;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;Ldk/molslinjen/domain/managers/checkout/IAddonHelper;Ldk/molslinjen/domain/managers/seating/ISelectSeatingManager;Ldk/molslinjen/core/snackbar/ISnackbarService;Ldk/molslinjen/core/navigation/ICheckoutNavigator;Ldk/molslinjen/domain/managers/checkout/IEditManager;Ldk/molslinjen/domain/managers/route/IRouteManager;Ldk/molslinjen/domain/managers/departure/IDepartureManager;Ldk/molslinjen/domain/managers/checkout/IReturnManager;Ldk/molslinjen/domain/managers/checkout/IPaymentManager;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;Landroidx/lifecycle/SavedStateHandle;)V", "navArgs", "Ldk/molslinjen/ui/views/screens/booking/addons/AddonsScreenNavArgs;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "checkoutState", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;", "getCheckoutState", "addonState", "Ldk/molslinjen/domain/managers/checkout/AddonHelper$AddonState;", "getAddonState", "editState", "Ldk/molslinjen/domain/managers/checkout/EditManager$EditState;", "getEditState", "loadDepartureDirection", BuildConfig.FLAVOR, "departureDirection", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "syncSeats", "loadProducts", "onQuantityChanged", "product", "Ldk/molslinjen/domain/model/booking/product/Product;", "quantity", BuildConfig.FLAVOR, "proceed", "Lkotlin/Function1;", "Lcom/ramcosta/composedestinations/spec/Direction;", "retrySeatSync", "isCommuter", BuildConfig.FLAVOR, "isEditing", "isExpired", "isInCheckoutFlow", "isMultiRide", "resetCheckoutAfterExpiredDepartures", "showReloadDialog", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AddonsViewModel extends ViewModel implements IExpirableCheckout {
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
    private final AddonsScreenNavArgs navArgs;
    private final IPaymentManager paymentManager;
    private final IReturnManager returnManager;
    private final IRouteManager routeManager;
    private final ISelectSeatingManager seatingManager;
    private final ISnackbarService snackbarService;
    private final StateFlow<ViewState> viewState;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.addons.AddonsViewModel$1", f = "AddonsViewModel.kt", l = {76}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.booking.addons.AddonsViewModel$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DepartureDirection $departureDirection;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "addonState", "Ldk/molslinjen/domain/managers/checkout/AddonHelper$AddonState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.addons.AddonsViewModel$1$1", f = "AddonsViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.booking.addons.AddonsViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00511 extends SuspendLambda implements Function2<AddonHelper.AddonState, Continuation<? super Unit>, Object> {
            final /* synthetic */ DepartureDirection $departureDirection;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AddonsViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00511(AddonsViewModel addonsViewModel, DepartureDirection departureDirection, Continuation<? super C00511> continuation) {
                super(2, continuation);
                this.this$0 = addonsViewModel;
                this.$departureDirection = departureDirection;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00511 c00511 = new C00511(this.this$0, this.$departureDirection, continuation);
                c00511.L$0 = obj;
                return c00511;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AddonHelper.AddonState addonState, Continuation<? super Unit> continuation) {
                return ((C00511) create(addonState, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.checkoutManager.updateAddons((AddonHelper.AddonState) this.L$0, this.$departureDirection);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DepartureDirection departureDirection, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$departureDirection = departureDirection;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$departureDirection, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<AddonHelper.AddonState> addonState = AddonsViewModel.this.addonHelper.getAddonState();
                C00511 c00511 = new C00511(AddonsViewModel.this, this.$departureDirection, null);
                this.label = 1;
                if (FlowKt.collectLatest(addonState, c00511, this) == coroutine_suspended) {
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
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.addons.AddonsViewModel$2", f = "AddonsViewModel.kt", l = {86}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.booking.addons.AddonsViewModel$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DepartureDirection $departureDirection;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "directionState", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutDirectionState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.addons.AddonsViewModel$2$1", f = "AddonsViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.booking.addons.AddonsViewModel$2$1, reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CheckoutManager.CheckoutDirectionState, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AddonsViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(AddonsViewModel addonsViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = addonsViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CheckoutManager.CheckoutDirectionState checkoutDirectionState, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(checkoutDirectionState, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object value;
                UnavailableSeatReservation unavailableSeatReservation;
                CheckoutSeatReservation reservation;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                CheckoutManager.CheckoutDirectionState checkoutDirectionState = (CheckoutManager.CheckoutDirectionState) this.L$0;
                MutableStateFlow mutableStateFlow = this.this$0._viewState;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default((ViewState) value, false, null, 0, null, null, (checkoutDirectionState == null || (unavailableSeatReservation = checkoutDirectionState.getUnavailableSeatReservation()) == null || (reservation = unavailableSeatReservation.getReservation()) == null) ? null : reservation.getPaidPrice(), 31, null)));
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DepartureDirection departureDirection, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$departureDirection = departureDirection;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$departureDirection, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<CheckoutManager.CheckoutDirectionState> directionState = AddonsViewModel.this.checkoutManager.directionState(this.$departureDirection);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(AddonsViewModel.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(directionState, anonymousClass1, this) == coroutine_suspended) {
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

    public AddonsViewModel(ICheckoutManager checkoutManager, IAddonHelper addonHelper, ISelectSeatingManager seatingManager, ISnackbarService snackbarService, ICheckoutNavigator checkoutNavigator, IEditManager editManager, IRouteManager routeManager, IDepartureManager departureManager, IReturnManager returnManager, IPaymentManager paymentManager, IAnalyticsTracker analyticsTracker, SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(checkoutManager, "checkoutManager");
        Intrinsics.checkNotNullParameter(addonHelper, "addonHelper");
        Intrinsics.checkNotNullParameter(seatingManager, "seatingManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(checkoutNavigator, "checkoutNavigator");
        Intrinsics.checkNotNullParameter(editManager, "editManager");
        Intrinsics.checkNotNullParameter(routeManager, "routeManager");
        Intrinsics.checkNotNullParameter(departureManager, "departureManager");
        Intrinsics.checkNotNullParameter(returnManager, "returnManager");
        Intrinsics.checkNotNullParameter(paymentManager, "paymentManager");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.$$delegate_0 = new ExpirableCheckoutHandler(routeManager, departureManager, editManager, returnManager, paymentManager, null, false, analyticsTracker, 96, null);
        this.checkoutManager = checkoutManager;
        this.addonHelper = addonHelper;
        this.seatingManager = seatingManager;
        this.snackbarService = snackbarService;
        this.checkoutNavigator = checkoutNavigator;
        this.editManager = editManager;
        this.routeManager = routeManager;
        this.departureManager = departureManager;
        this.returnManager = returnManager;
        this.paymentManager = paymentManager;
        this.analyticsTracker = analyticsTracker;
        AddonsScreenNavArgs argsFrom = AddonsScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        this.navArgs = argsFrom;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(false, null, 0, null, null, null, 63, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        this.checkoutState = checkoutManager.getCheckoutState();
        this.addonState = addonHelper.getAddonState();
        this.editState = editManager.getEditState();
        DepartureDirection departureDirection = argsFrom.getDepartureDirection();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(departureDirection, null), 3, null);
        loadDepartureDirection(departureDirection);
        syncSeats();
        loadProducts();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(departureDirection, null), 3, null);
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
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, departureDirection, 0, bookingType, null, null, 53, null)));
    }

    private final void loadProducts() {
        CheckoutManager.CheckoutState value;
        CheckoutManager.CheckoutDirectionState value2;
        DepartureDirection departureDirection = this.viewState.getValue().getDepartureDirection();
        if (departureDirection == null || (value = this.checkoutState.getValue()) == null || (value2 = this.checkoutManager.directionState(departureDirection).getValue()) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AddonsViewModel$loadProducts$1(this, value2, departureDirection, value, null), 3, null);
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
        DepartureDirection departureDirection = this.viewState.getValue().getDepartureDirection();
        if (departureDirection == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AddonsViewModel$onQuantityChanged$1(quantity, product, this, departureDirection, null), 3, null);
    }

    public final void proceed(Function1<? super Direction, Unit> proceed) {
        Direction nextStep;
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        DepartureDirection departureDirection = this.viewState.getValue().getDepartureDirection();
        if (departureDirection == null || (nextStep = this.checkoutNavigator.nextStep(TicketSection.Addons, this.viewState.getValue().getBookingType(), departureDirection)) == null) {
            return;
        }
        proceed.invoke(nextStep);
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public void resetCheckoutAfterExpiredDepartures() {
        this.$$delegate_0.resetCheckoutAfterExpiredDepartures();
    }

    public final void retrySeatSync() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AddonsViewModel$retrySeatSync$1(this, null), 3, null);
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public boolean showReloadDialog() {
        return this.$$delegate_0.showReloadDialog();
    }

    public final void syncSeats() {
        DepartureDirection departureDirection = this.viewState.getValue().getDepartureDirection();
        if (departureDirection == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getDefault(), null, new AddonsViewModel$syncSeats$1(this, departureDirection, null), 2, null);
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0087\b\u0018\u00002\u00020\u0001:\u0001*BG\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJP\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u0003\u0010\u001bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b \u0010\u0016R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010'\u001a\u0004\b(\u0010)¨\u0006+"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isLoading", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "departureDirection", BuildConfig.FLAVOR, "numberOfPassengers", "Ldk/molslinjen/domain/model/booking/BookingType;", "bookingType", "Ldk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel$ViewState$SeatsState;", "seatReservation", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "unavailableSeatReservationPrice", "<init>", "(ZLdk/molslinjen/domain/model/booking/DepartureDirection;ILdk/molslinjen/domain/model/booking/BookingType;Ldk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel$ViewState$SeatsState;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;)V", "copy", "(ZLdk/molslinjen/domain/model/booking/DepartureDirection;ILdk/molslinjen/domain/model/booking/BookingType;Ldk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel$ViewState$SeatsState;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;)Ldk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "getDepartureDirection", "()Ldk/molslinjen/domain/model/booking/DepartureDirection;", "I", "getNumberOfPassengers", "Ldk/molslinjen/domain/model/booking/BookingType;", "getBookingType", "()Ldk/molslinjen/domain/model/booking/BookingType;", "Ldk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel$ViewState$SeatsState;", "getSeatReservation", "()Ldk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel$ViewState$SeatsState;", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "getUnavailableSeatReservationPrice", "()Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "SeatsState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final BookingType bookingType;
        private final DepartureDirection departureDirection;
        private final boolean isLoading;
        private final int numberOfPassengers;
        private final SeatsState seatReservation;
        private final PriceWithCurrency unavailableSeatReservationPrice;

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel$ViewState$SeatsState;", BuildConfig.FLAVOR, "<init>", "()V", "Loading", "Empty", "Error", "Reserved", "Ldk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel$ViewState$SeatsState$Empty;", "Ldk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel$ViewState$SeatsState$Error;", "Ldk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel$ViewState$SeatsState$Loading;", "Ldk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel$ViewState$SeatsState$Reserved;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static abstract class SeatsState {

            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel$ViewState$SeatsState$Empty;", "Ldk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel$ViewState$SeatsState;", "<init>", "()V", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
            /* loaded from: classes2.dex */
            public static final /* data */ class Empty extends SeatsState {
                public static final Empty INSTANCE = new Empty();

                private Empty() {
                    super(null);
                }

                public boolean equals(Object other) {
                    return this == other || (other instanceof Empty);
                }

                public int hashCode() {
                    return 505867106;
                }

                public String toString() {
                    return "Empty";
                }
            }

            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel$ViewState$SeatsState$Error;", "Ldk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel$ViewState$SeatsState;", "<init>", "()V", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
            /* loaded from: classes2.dex */
            public static final /* data */ class Error extends SeatsState {
                public static final Error INSTANCE = new Error();

                private Error() {
                    super(null);
                }

                public boolean equals(Object other) {
                    return this == other || (other instanceof Error);
                }

                public int hashCode() {
                    return 506017821;
                }

                public String toString() {
                    return "Error";
                }
            }

            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel$ViewState$SeatsState$Loading;", "Ldk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel$ViewState$SeatsState;", "<init>", "()V", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
            /* loaded from: classes2.dex */
            public static final /* data */ class Loading extends SeatsState {
                public static final Loading INSTANCE = new Loading();

                private Loading() {
                    super(null);
                }

                public boolean equals(Object other) {
                    return this == other || (other instanceof Loading);
                }

                public int hashCode() {
                    return -1527507439;
                }

                public String toString() {
                    return "Loading";
                }
            }

            @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel$ViewState$SeatsState$Reserved;", "Ldk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel$ViewState$SeatsState;", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/FerrySeat;", "seats", "<init>", "(Ljava/util/List;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getSeats", "()Ljava/util/List;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
            /* loaded from: classes2.dex */
            public static final /* data */ class Reserved extends SeatsState {
                private final List<FerrySeat> seats;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Reserved(List<FerrySeat> seats) {
                    super(null);
                    Intrinsics.checkNotNullParameter(seats, "seats");
                    this.seats = seats;
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    return (other instanceof Reserved) && Intrinsics.areEqual(this.seats, ((Reserved) other).seats);
                }

                public final List<FerrySeat> getSeats() {
                    return this.seats;
                }

                public int hashCode() {
                    return this.seats.hashCode();
                }

                public String toString() {
                    return "Reserved(seats=" + this.seats + ")";
                }
            }

            public /* synthetic */ SeatsState(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private SeatsState() {
            }
        }

        public ViewState(boolean z5, DepartureDirection departureDirection, int i5, BookingType bookingType, SeatsState seatReservation, PriceWithCurrency priceWithCurrency) {
            Intrinsics.checkNotNullParameter(bookingType, "bookingType");
            Intrinsics.checkNotNullParameter(seatReservation, "seatReservation");
            this.isLoading = z5;
            this.departureDirection = departureDirection;
            this.numberOfPassengers = i5;
            this.bookingType = bookingType;
            this.seatReservation = seatReservation;
            this.unavailableSeatReservationPrice = priceWithCurrency;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z5, DepartureDirection departureDirection, int i5, BookingType bookingType, SeatsState seatsState, PriceWithCurrency priceWithCurrency, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                z5 = viewState.isLoading;
            }
            if ((i6 & 2) != 0) {
                departureDirection = viewState.departureDirection;
            }
            DepartureDirection departureDirection2 = departureDirection;
            if ((i6 & 4) != 0) {
                i5 = viewState.numberOfPassengers;
            }
            int i7 = i5;
            if ((i6 & 8) != 0) {
                bookingType = viewState.bookingType;
            }
            BookingType bookingType2 = bookingType;
            if ((i6 & 16) != 0) {
                seatsState = viewState.seatReservation;
            }
            SeatsState seatsState2 = seatsState;
            if ((i6 & 32) != 0) {
                priceWithCurrency = viewState.unavailableSeatReservationPrice;
            }
            return viewState.copy(z5, departureDirection2, i7, bookingType2, seatsState2, priceWithCurrency);
        }

        public final ViewState copy(boolean isLoading, DepartureDirection departureDirection, int numberOfPassengers, BookingType bookingType, SeatsState seatReservation, PriceWithCurrency unavailableSeatReservationPrice) {
            Intrinsics.checkNotNullParameter(bookingType, "bookingType");
            Intrinsics.checkNotNullParameter(seatReservation, "seatReservation");
            return new ViewState(isLoading, departureDirection, numberOfPassengers, bookingType, seatReservation, unavailableSeatReservationPrice);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isLoading == viewState.isLoading && this.departureDirection == viewState.departureDirection && this.numberOfPassengers == viewState.numberOfPassengers && this.bookingType == viewState.bookingType && Intrinsics.areEqual(this.seatReservation, viewState.seatReservation) && Intrinsics.areEqual(this.unavailableSeatReservationPrice, viewState.unavailableSeatReservationPrice);
        }

        public final BookingType getBookingType() {
            return this.bookingType;
        }

        public final DepartureDirection getDepartureDirection() {
            return this.departureDirection;
        }

        public final int getNumberOfPassengers() {
            return this.numberOfPassengers;
        }

        public final SeatsState getSeatReservation() {
            return this.seatReservation;
        }

        public final PriceWithCurrency getUnavailableSeatReservationPrice() {
            return this.unavailableSeatReservationPrice;
        }

        public int hashCode() {
            int hashCode = Boolean.hashCode(this.isLoading) * 31;
            DepartureDirection departureDirection = this.departureDirection;
            int hashCode2 = (((((((hashCode + (departureDirection == null ? 0 : departureDirection.hashCode())) * 31) + Integer.hashCode(this.numberOfPassengers)) * 31) + this.bookingType.hashCode()) * 31) + this.seatReservation.hashCode()) * 31;
            PriceWithCurrency priceWithCurrency = this.unavailableSeatReservationPrice;
            return hashCode2 + (priceWithCurrency != null ? priceWithCurrency.hashCode() : 0);
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public String toString() {
            return "ViewState(isLoading=" + this.isLoading + ", departureDirection=" + this.departureDirection + ", numberOfPassengers=" + this.numberOfPassengers + ", bookingType=" + this.bookingType + ", seatReservation=" + this.seatReservation + ", unavailableSeatReservationPrice=" + this.unavailableSeatReservationPrice + ")";
        }

        public /* synthetic */ ViewState(boolean z5, DepartureDirection departureDirection, int i5, BookingType bookingType, SeatsState seatsState, PriceWithCurrency priceWithCurrency, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this((i6 & 1) != 0 ? true : z5, (i6 & 2) != 0 ? null : departureDirection, (i6 & 4) != 0 ? 0 : i5, (i6 & 8) != 0 ? BookingType.Single : bookingType, (i6 & 16) != 0 ? SeatsState.Loading.INSTANCE : seatsState, (i6 & 32) == 0 ? priceWithCurrency : null);
        }
    }
}
