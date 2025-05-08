package dk.molslinjen.ui.views.screens.booking.simpleChange.food;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.core.snackbar.SnackbarEvent;
import dk.molslinjen.domain.managers.checkout.AddonHelper;
import dk.molslinjen.domain.managers.checkout.IAddonHelper;
import dk.molslinjen.domain.managers.checkout.ISimpleChangeCheckoutManager;
import dk.molslinjen.domain.managers.checkout.SimpleChangeCheckoutManager;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.product.Product;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001!B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0016\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006\""}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/simpleChange/food/SimpleChangeFoodViewModel;", "Landroidx/lifecycle/ViewModel;", "addonHelper", "Ldk/molslinjen/domain/managers/checkout/IAddonHelper;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "simpleChangeCheckoutManager", "Ldk/molslinjen/domain/managers/checkout/ISimpleChangeCheckoutManager;", "<init>", "(Ldk/molslinjen/domain/managers/checkout/IAddonHelper;Ldk/molslinjen/core/snackbar/ISnackbarService;Ldk/molslinjen/domain/managers/checkout/ISimpleChangeCheckoutManager;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/booking/simpleChange/food/SimpleChangeFoodViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "addonState", "Ldk/molslinjen/domain/managers/checkout/AddonHelper$AddonState;", "getAddonState", "simpleChangeCheckoutState", "Ldk/molslinjen/domain/managers/checkout/SimpleChangeCheckoutManager$SimpleChangeCheckoutState;", "getSimpleChangeCheckoutState", "loadProducts", BuildConfig.FLAVOR, "onQuantityChanged", "product", "Ldk/molslinjen/domain/model/booking/product/Product;", "quantity", BuildConfig.FLAVOR, "showSnackbar", "event", "Ldk/molslinjen/core/snackbar/SnackbarEvent;", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SimpleChangeFoodViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final IAddonHelper addonHelper;
    private final StateFlow<AddonHelper.AddonState> addonState;
    private final ISimpleChangeCheckoutManager simpleChangeCheckoutManager;
    private final StateFlow<SimpleChangeCheckoutManager.SimpleChangeCheckoutState> simpleChangeCheckoutState;
    private final ISnackbarService snackbarService;
    private final StateFlow<ViewState> viewState;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.simpleChange.food.SimpleChangeFoodViewModel$1", f = "SimpleChangeFoodViewModel.kt", l = {38}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.booking.simpleChange.food.SimpleChangeFoodViewModel$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "addonState", "Ldk/molslinjen/domain/managers/checkout/AddonHelper$AddonState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.simpleChange.food.SimpleChangeFoodViewModel$1$1", f = "SimpleChangeFoodViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.booking.simpleChange.food.SimpleChangeFoodViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00571 extends SuspendLambda implements Function2<AddonHelper.AddonState, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ SimpleChangeFoodViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00571(SimpleChangeFoodViewModel simpleChangeFoodViewModel, Continuation<? super C00571> continuation) {
                super(2, continuation);
                this.this$0 = simpleChangeFoodViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00571 c00571 = new C00571(this.this$0, continuation);
                c00571.L$0 = obj;
                return c00571;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AddonHelper.AddonState addonState, Continuation<? super Unit> continuation) {
                return ((C00571) create(addonState, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.simpleChangeCheckoutManager.updateFood((AddonHelper.AddonState) this.L$0);
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
                StateFlow<AddonHelper.AddonState> addonState = SimpleChangeFoodViewModel.this.getAddonState();
                C00571 c00571 = new C00571(SimpleChangeFoodViewModel.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(addonState, c00571, this) == coroutine_suspended) {
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

    public SimpleChangeFoodViewModel(IAddonHelper addonHelper, ISnackbarService snackbarService, ISimpleChangeCheckoutManager simpleChangeCheckoutManager) {
        Intrinsics.checkNotNullParameter(addonHelper, "addonHelper");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(simpleChangeCheckoutManager, "simpleChangeCheckoutManager");
        this.addonHelper = addonHelper;
        this.snackbarService = snackbarService;
        this.simpleChangeCheckoutManager = simpleChangeCheckoutManager;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(false, 0, false, 7, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        this.addonState = addonHelper.getAddonState();
        this.simpleChangeCheckoutState = simpleChangeCheckoutManager.getSimpleChangeCheckoutState();
        loadProducts();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    private final void loadProducts() {
        Booking existingBooking = this.simpleChangeCheckoutManager.getSimpleChangeCheckoutState().getValue().getExistingBooking();
        if (existingBooking == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SimpleChangeFoodViewModel$loadProducts$1(this, existingBooking, this.simpleChangeCheckoutState.getValue().getFood(), null), 3, null);
    }

    public final StateFlow<AddonHelper.AddonState> getAddonState() {
        return this.addonState;
    }

    public final StateFlow<SimpleChangeCheckoutManager.SimpleChangeCheckoutState> getSimpleChangeCheckoutState() {
        return this.simpleChangeCheckoutState;
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void onQuantityChanged(Product product, int quantity) {
        Intrinsics.checkNotNullParameter(product, "product");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SimpleChangeFoodViewModel$onQuantityChanged$1(this, product, quantity, null), 3, null);
    }

    public final void showSnackbar(SnackbarEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SimpleChangeFoodViewModel$showSnackbar$1(this, event, null), 3, null);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0003\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0017\u0010\u0014¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/simpleChange/food/SimpleChangeFoodViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isLoading", BuildConfig.FLAVOR, "numberOfPassengers", "preselectedFood", "<init>", "(ZIZ)V", "copy", "(ZIZ)Ldk/molslinjen/ui/views/screens/booking/simpleChange/food/SimpleChangeFoodViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "I", "getNumberOfPassengers", "getPreselectedFood", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final boolean isLoading;
        private final int numberOfPassengers;
        private final boolean preselectedFood;

        public ViewState(boolean z5, int i5, boolean z6) {
            this.isLoading = z5;
            this.numberOfPassengers = i5;
            this.preselectedFood = z6;
        }

        public final ViewState copy(boolean isLoading, int numberOfPassengers, boolean preselectedFood) {
            return new ViewState(isLoading, numberOfPassengers, preselectedFood);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isLoading == viewState.isLoading && this.numberOfPassengers == viewState.numberOfPassengers && this.preselectedFood == viewState.preselectedFood;
        }

        public final boolean getPreselectedFood() {
            return this.preselectedFood;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.isLoading) * 31) + Integer.hashCode(this.numberOfPassengers)) * 31) + Boolean.hashCode(this.preselectedFood);
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public String toString() {
            return "ViewState(isLoading=" + this.isLoading + ", numberOfPassengers=" + this.numberOfPassengers + ", preselectedFood=" + this.preselectedFood + ")";
        }

        public /* synthetic */ ViewState(boolean z5, int i5, boolean z6, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this((i6 & 1) != 0 ? true : z5, (i6 & 2) != 0 ? 0 : i5, (i6 & 4) != 0 ? false : z6);
        }
    }
}
