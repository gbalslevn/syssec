package dk.molslinjen.ui.views.screens.agreements.multiride.purchase;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.MultiRidePurchaseScreenDestination;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.agreement.multiride.purchase.IMultiRideCardCheckoutManager;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRidePriceStep;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRidePurchaseInfo;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.payment.PaymentOrigin;
import dk.molslinjen.extensions.ManagerResultExtensionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001$B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!J\u0014\u0010\"\u001a\u00020\u00192\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190#R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014¨\u0006%"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/multiride/purchase/MultiRidePurchaseViewModel;", "Landroidx/lifecycle/ViewModel;", "multiRideCheckoutManager", "Ldk/molslinjen/domain/managers/agreement/multiride/purchase/IMultiRideCardCheckoutManager;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "<init>", "(Ldk/molslinjen/domain/managers/agreement/multiride/purchase/IMultiRideCardCheckoutManager;Ldk/molslinjen/core/snackbar/ISnackbarService;Landroidx/lifecycle/SavedStateHandle;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;)V", "navArgs", "Ldk/molslinjen/ui/views/screens/agreements/multiride/purchase/MultiRidePurchaseScreenNavArgs;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/agreements/multiride/purchase/MultiRidePurchaseViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "checkoutState", "Ldk/molslinjen/domain/managers/agreement/multiride/purchase/IMultiRideCardCheckoutManager$CheckoutState;", "getCheckoutState", "updateSelectedPurchaseInfo", BuildConfig.FLAVOR, "purchaseInfo", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePurchaseInfo;", "updateChargeCount", "chargeCount", BuildConfig.FLAVOR, "updateSelectedPriceStep", "priceStep", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePriceStep;", "proceed", "Lkotlin/Function0;", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MultiRidePurchaseViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final IAnalyticsTracker analyticsTracker;
    private final StateFlow<IMultiRideCardCheckoutManager.CheckoutState> checkoutState;
    private final IMultiRideCardCheckoutManager multiRideCheckoutManager;
    private final MultiRidePurchaseScreenNavArgs navArgs;
    private final ISnackbarService snackbarService;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseViewModel$1", f = "MultiRidePurchaseViewModel.kt", l = {36, 37}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseViewModel$1, reason: invalid class name */
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
            MutableStateFlow mutableStateFlow;
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                IMultiRideCardCheckoutManager iMultiRideCardCheckoutManager = MultiRidePurchaseViewModel.this.multiRideCheckoutManager;
                Site site = MultiRidePurchaseViewModel.this.navArgs.getSite();
                PaymentOrigin paymentOrigin = MultiRidePurchaseViewModel.this.navArgs.getPaymentOrigin();
                this.label = 1;
                obj = IMultiRideCardCheckoutManager.DefaultImpls.setup$default(iMultiRideCardCheckoutManager, site, null, paymentOrigin, this, 2, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    if (i5 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    mutableStateFlow = MultiRidePurchaseViewModel.this._viewState;
                    do {
                        value = mutableStateFlow.getValue();
                    } while (!mutableStateFlow.compareAndSet(value, ((ViewState) value).copy(false)));
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            ISnackbarService iSnackbarService = MultiRidePurchaseViewModel.this.snackbarService;
            this.label = 2;
            if (ManagerResultExtensionsKt.handlePotentialError((ManagerResult) obj, iSnackbarService, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableStateFlow = MultiRidePurchaseViewModel.this._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, ((ViewState) value).copy(false)));
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public MultiRidePurchaseViewModel(IMultiRideCardCheckoutManager multiRideCheckoutManager, ISnackbarService snackbarService, SavedStateHandle savedStateHandle, IAnalyticsTracker analyticsTracker) {
        Intrinsics.checkNotNullParameter(multiRideCheckoutManager, "multiRideCheckoutManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        this.multiRideCheckoutManager = multiRideCheckoutManager;
        this.snackbarService = snackbarService;
        this.analyticsTracker = analyticsTracker;
        this.navArgs = MultiRidePurchaseScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        this._viewState = StateFlowKt.MutableStateFlow(new ViewState(false, 1, null));
        this.checkoutState = multiRideCheckoutManager.getCheckoutState();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    public final StateFlow<IMultiRideCardCheckoutManager.CheckoutState> getCheckoutState() {
        return this.checkoutState;
    }

    public final StateFlow<ViewState> getViewState() {
        return this._viewState;
    }

    public final void proceed(Function0<Unit> proceed) {
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        this.analyticsTracker.trackAddMultiRideToCart(this.multiRideCheckoutManager);
        proceed.invoke();
    }

    public final void updateChargeCount(int chargeCount) {
        this.multiRideCheckoutManager.updateChargeCount(chargeCount);
    }

    public final void updateSelectedPriceStep(MultiRidePriceStep priceStep) {
        Intrinsics.checkNotNullParameter(priceStep, "priceStep");
        this.multiRideCheckoutManager.updateSelectedPriceStep(priceStep);
    }

    public final void updateSelectedPurchaseInfo(MultiRidePurchaseInfo purchaseInfo) {
        Intrinsics.checkNotNullParameter(purchaseInfo, "purchaseInfo");
        this.multiRideCheckoutManager.updateSelectedPurchaseInfo(purchaseInfo);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0003\u0010\u0012¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/multiride/purchase/MultiRidePurchaseViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isLoading", "<init>", "(Z)V", "copy", "(Z)Ldk/molslinjen/ui/views/screens/agreements/multiride/purchase/MultiRidePurchaseViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final boolean isLoading;

        public ViewState(boolean z5) {
            this.isLoading = z5;
        }

        public final ViewState copy(boolean isLoading) {
            return new ViewState(isLoading);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ViewState) && this.isLoading == ((ViewState) other).isLoading;
        }

        public int hashCode() {
            return Boolean.hashCode(this.isLoading);
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public String toString() {
            return "ViewState(isLoading=" + this.isLoading + ")";
        }

        public /* synthetic */ ViewState(boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? true : z5);
        }
    }
}
