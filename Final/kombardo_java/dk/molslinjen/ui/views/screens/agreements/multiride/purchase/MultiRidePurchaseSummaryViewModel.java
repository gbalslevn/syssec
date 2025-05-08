package dk.molslinjen.ui.views.screens.agreements.multiride.purchase;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.agreement.multiride.purchase.IMultiRideCardCheckoutManager;
import dk.molslinjen.domain.managers.checkout.IPaymentManager;
import dk.molslinjen.domain.managers.user.creditcards.IUserCreditCardsManager;
import dk.molslinjen.domain.model.account.CreditCard;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.payment.PaymentOrigin;
import dk.molslinjen.domain.model.payment.PaymentType;
import dk.molslinjen.domain.model.shared.CurrencyType;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.domain.model.site.SiteInfo;
import dk.molslinjen.extensions.ManagerResultExtensionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00012B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0018\u001a\u00020\u0019H\u0082@¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u000e\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\"J\u000e\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\"J\u0006\u0010*\u001a\u00020\u0019J\u000e\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020-J\u001a\u0010.\u001a\u00020\u00192\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u001900R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0012¨\u00063"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/multiride/purchase/MultiRidePurchaseSummaryViewModel;", "Landroidx/lifecycle/ViewModel;", "multiRideCheckoutManager", "Ldk/molslinjen/domain/managers/agreement/multiride/purchase/IMultiRideCardCheckoutManager;", "paymentManager", "Ldk/molslinjen/domain/managers/checkout/IPaymentManager;", "creditCardsManager", "Ldk/molslinjen/domain/managers/user/creditcards/IUserCreditCardsManager;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "<init>", "(Ldk/molslinjen/domain/managers/agreement/multiride/purchase/IMultiRideCardCheckoutManager;Ldk/molslinjen/domain/managers/checkout/IPaymentManager;Ldk/molslinjen/domain/managers/user/creditcards/IUserCreditCardsManager;Ldk/molslinjen/core/snackbar/ISnackbarService;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;)V", "checkoutState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/agreement/multiride/purchase/IMultiRideCardCheckoutManager$CheckoutState;", "getCheckoutState", "()Lkotlinx/coroutines/flow/StateFlow;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/agreements/multiride/purchase/MultiRidePurchaseSummaryViewModel$ViewState;", "viewState", "getViewState", "loadPaymentMethods", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPaymentMethodSelected", "paymentType", "Ldk/molslinjen/domain/model/payment/PaymentType;", "creditCard", "Ldk/molslinjen/domain/model/account/CreditCard;", "updatePhoneNumberCode", "phoneNumberCode", BuildConfig.FLAVOR, "onPhoneNumberChange", "phoneNumber", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "onEmailChange", "email", "onPostalCodeChange", "postalCode", "startPersonalInfoEdit", "onTermsAcceptUpdated", "termsAccepted", BuildConfig.FLAVOR, "initiatePayment", "proceed", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/payment/PaymentOrigin;", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MultiRidePurchaseSummaryViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final IAnalyticsTracker analyticsTracker;
    private final StateFlow<IMultiRideCardCheckoutManager.CheckoutState> checkoutState;
    private final IUserCreditCardsManager creditCardsManager;
    private final IMultiRideCardCheckoutManager multiRideCheckoutManager;
    private final IPaymentManager paymentManager;
    private final ISnackbarService snackbarService;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseSummaryViewModel$1", f = "MultiRidePurchaseSummaryViewModel.kt", l = {42, 43, 44}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseSummaryViewModel$1, reason: invalid class name */
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

        /* JADX WARN: Removed duplicated region for block: B:20:0x0052 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            MultiRidePurchaseSummaryViewModel multiRidePurchaseSummaryViewModel;
            MutableStateFlow mutableStateFlow;
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                IMultiRideCardCheckoutManager iMultiRideCardCheckoutManager = MultiRidePurchaseSummaryViewModel.this.multiRideCheckoutManager;
                this.label = 1;
                obj = iMultiRideCardCheckoutManager.loadSummaryInfo(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        mutableStateFlow = MultiRidePurchaseSummaryViewModel.this._viewState;
                        do {
                            value = mutableStateFlow.getValue();
                        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default((ViewState) value, false, null, null, false, false, 30, null)));
                        MultiRidePurchaseSummaryViewModel.this.analyticsTracker.trackBeginCheckout(MultiRidePurchaseSummaryViewModel.this.multiRideCheckoutManager);
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                    multiRidePurchaseSummaryViewModel = MultiRidePurchaseSummaryViewModel.this;
                    this.label = 3;
                    if (multiRidePurchaseSummaryViewModel.loadPaymentMethods(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutableStateFlow = MultiRidePurchaseSummaryViewModel.this._viewState;
                    do {
                        value = mutableStateFlow.getValue();
                    } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default((ViewState) value, false, null, null, false, false, 30, null)));
                    MultiRidePurchaseSummaryViewModel.this.analyticsTracker.trackBeginCheckout(MultiRidePurchaseSummaryViewModel.this.multiRideCheckoutManager);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            ISnackbarService iSnackbarService = MultiRidePurchaseSummaryViewModel.this.snackbarService;
            this.label = 2;
            if (ManagerResultExtensionsKt.handlePotentialError((ManagerResult) obj, iSnackbarService, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            multiRidePurchaseSummaryViewModel = MultiRidePurchaseSummaryViewModel.this;
            this.label = 3;
            if (multiRidePurchaseSummaryViewModel.loadPaymentMethods(this) == coroutine_suspended) {
            }
            mutableStateFlow = MultiRidePurchaseSummaryViewModel.this._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default((ViewState) value, false, null, null, false, false, 30, null)));
            MultiRidePurchaseSummaryViewModel.this.analyticsTracker.trackBeginCheckout(MultiRidePurchaseSummaryViewModel.this.multiRideCheckoutManager);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public MultiRidePurchaseSummaryViewModel(IMultiRideCardCheckoutManager multiRideCheckoutManager, IPaymentManager paymentManager, IUserCreditCardsManager creditCardsManager, ISnackbarService snackbarService, IAnalyticsTracker analyticsTracker) {
        Intrinsics.checkNotNullParameter(multiRideCheckoutManager, "multiRideCheckoutManager");
        Intrinsics.checkNotNullParameter(paymentManager, "paymentManager");
        Intrinsics.checkNotNullParameter(creditCardsManager, "creditCardsManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        this.multiRideCheckoutManager = multiRideCheckoutManager;
        this.paymentManager = paymentManager;
        this.creditCardsManager = creditCardsManager;
        this.snackbarService = snackbarService;
        this.analyticsTracker = analyticsTracker;
        this.checkoutState = multiRideCheckoutManager.getCheckoutState();
        this._viewState = StateFlowKt.MutableStateFlow(new ViewState(false, null, null, false, !r9.getValue().getPersonalInfo().getWasPrefilled(), 15, null));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadPaymentMethods(Continuation<? super Unit> continuation) {
        MultiRidePurchaseSummaryViewModel$loadPaymentMethods$1 multiRidePurchaseSummaryViewModel$loadPaymentMethods$1;
        Object obj;
        Object coroutine_suspended;
        int i5;
        Site site;
        CurrencyType currencyType;
        MultiRidePurchaseSummaryViewModel multiRidePurchaseSummaryViewModel;
        List list;
        MutableStateFlow<ViewState> mutableStateFlow;
        ViewState value;
        ISnackbarService iSnackbarService;
        MultiRidePurchaseSummaryViewModel multiRidePurchaseSummaryViewModel2;
        if (continuation instanceof MultiRidePurchaseSummaryViewModel$loadPaymentMethods$1) {
            multiRidePurchaseSummaryViewModel$loadPaymentMethods$1 = (MultiRidePurchaseSummaryViewModel$loadPaymentMethods$1) continuation;
            int i6 = multiRidePurchaseSummaryViewModel$loadPaymentMethods$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                multiRidePurchaseSummaryViewModel$loadPaymentMethods$1.label = i6 - Integer.MIN_VALUE;
                obj = multiRidePurchaseSummaryViewModel$loadPaymentMethods$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = multiRidePurchaseSummaryViewModel$loadPaymentMethods$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IMultiRideCardCheckoutManager.CheckoutState value2 = this.checkoutState.getValue();
                    SiteInfo siteInfo = value2.getSiteInfo();
                    if (siteInfo == null || (site = siteInfo.getSite()) == null) {
                        return Unit.INSTANCE;
                    }
                    IPaymentManager iPaymentManager = this.paymentManager;
                    PriceWithCurrency totalPrice = value2.getTotalPrice();
                    if (totalPrice == null || (currencyType = totalPrice.getCurrencyType()) == null) {
                        return Unit.INSTANCE;
                    }
                    multiRidePurchaseSummaryViewModel$loadPaymentMethods$1.L$0 = this;
                    multiRidePurchaseSummaryViewModel$loadPaymentMethods$1.label = 1;
                    obj = iPaymentManager.getPaymentMethodsForOthers(site, currencyType, multiRidePurchaseSummaryViewModel$loadPaymentMethods$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    multiRidePurchaseSummaryViewModel = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            multiRidePurchaseSummaryViewModel2 = (MultiRidePurchaseSummaryViewModel) multiRidePurchaseSummaryViewModel$loadPaymentMethods$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(multiRidePurchaseSummaryViewModel2), null, null, new MultiRidePurchaseSummaryViewModel$loadPaymentMethods$3(multiRidePurchaseSummaryViewModel2, null), 3, null);
                            return Unit.INSTANCE;
                        }
                        multiRidePurchaseSummaryViewModel = (MultiRidePurchaseSummaryViewModel) multiRidePurchaseSummaryViewModel$loadPaymentMethods$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        iSnackbarService = multiRidePurchaseSummaryViewModel.snackbarService;
                        multiRidePurchaseSummaryViewModel$loadPaymentMethods$1.L$0 = multiRidePurchaseSummaryViewModel;
                        multiRidePurchaseSummaryViewModel$loadPaymentMethods$1.label = 3;
                        if (ManagerResultExtensionsKt.handlePotentialError((ManagerResult) obj, iSnackbarService, multiRidePurchaseSummaryViewModel$loadPaymentMethods$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        multiRidePurchaseSummaryViewModel2 = multiRidePurchaseSummaryViewModel;
                        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(multiRidePurchaseSummaryViewModel2), null, null, new MultiRidePurchaseSummaryViewModel$loadPaymentMethods$3(multiRidePurchaseSummaryViewModel2, null), 3, null);
                        return Unit.INSTANCE;
                    }
                    multiRidePurchaseSummaryViewModel = (MultiRidePurchaseSummaryViewModel) multiRidePurchaseSummaryViewModel$loadPaymentMethods$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                list = (List) obj;
                mutableStateFlow = multiRidePurchaseSummaryViewModel._viewState;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, null, list, false, false, 27, null)));
                IUserCreditCardsManager iUserCreditCardsManager = multiRidePurchaseSummaryViewModel.creditCardsManager;
                multiRidePurchaseSummaryViewModel$loadPaymentMethods$1.L$0 = multiRidePurchaseSummaryViewModel;
                multiRidePurchaseSummaryViewModel$loadPaymentMethods$1.label = 2;
                obj = iUserCreditCardsManager.loadCreditCards(multiRidePurchaseSummaryViewModel$loadPaymentMethods$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                iSnackbarService = multiRidePurchaseSummaryViewModel.snackbarService;
                multiRidePurchaseSummaryViewModel$loadPaymentMethods$1.L$0 = multiRidePurchaseSummaryViewModel;
                multiRidePurchaseSummaryViewModel$loadPaymentMethods$1.label = 3;
                if (ManagerResultExtensionsKt.handlePotentialError((ManagerResult) obj, iSnackbarService, multiRidePurchaseSummaryViewModel$loadPaymentMethods$1) == coroutine_suspended) {
                }
            }
        }
        multiRidePurchaseSummaryViewModel$loadPaymentMethods$1 = new MultiRidePurchaseSummaryViewModel$loadPaymentMethods$1(this, continuation);
        obj = multiRidePurchaseSummaryViewModel$loadPaymentMethods$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = multiRidePurchaseSummaryViewModel$loadPaymentMethods$1.label;
        if (i5 != 0) {
        }
        list = (List) obj;
        mutableStateFlow = multiRidePurchaseSummaryViewModel._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, null, list, false, false, 27, null)));
        IUserCreditCardsManager iUserCreditCardsManager2 = multiRidePurchaseSummaryViewModel.creditCardsManager;
        multiRidePurchaseSummaryViewModel$loadPaymentMethods$1.L$0 = multiRidePurchaseSummaryViewModel;
        multiRidePurchaseSummaryViewModel$loadPaymentMethods$1.label = 2;
        obj = iUserCreditCardsManager2.loadCreditCards(multiRidePurchaseSummaryViewModel$loadPaymentMethods$1);
        if (obj == coroutine_suspended) {
        }
        iSnackbarService = multiRidePurchaseSummaryViewModel.snackbarService;
        multiRidePurchaseSummaryViewModel$loadPaymentMethods$1.L$0 = multiRidePurchaseSummaryViewModel;
        multiRidePurchaseSummaryViewModel$loadPaymentMethods$1.label = 3;
        if (ManagerResultExtensionsKt.handlePotentialError((ManagerResult) obj, iSnackbarService, multiRidePurchaseSummaryViewModel$loadPaymentMethods$1) == coroutine_suspended) {
        }
    }

    public final StateFlow<IMultiRideCardCheckoutManager.CheckoutState> getCheckoutState() {
        return this.checkoutState;
    }

    public final StateFlow<ViewState> getViewState() {
        return this._viewState;
    }

    public final void initiatePayment(Function1<? super PaymentOrigin, Unit> proceed) {
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        PaymentOrigin flowOrigin = this.checkoutState.getValue().getFlowOrigin();
        if (flowOrigin != null) {
            proceed.invoke(flowOrigin);
        }
    }

    public final void onEmailChange(String email) {
        Intrinsics.checkNotNullParameter(email, "email");
        this.multiRideCheckoutManager.updateEmail(email);
    }

    public final void onPaymentMethodSelected(PaymentType paymentType, CreditCard creditCard) {
        Intrinsics.checkNotNullParameter(paymentType, "paymentType");
        boolean z5 = this.checkoutState.getValue().getSelectedPaymentType() != paymentType;
        if (creditCard == null) {
            creditCard = (z5 && paymentType == PaymentType.Card) ? (CreditCard) CollectionsKt.firstOrNull((List) getViewState().getValue().getSavedCreditCards()) : null;
        }
        this.multiRideCheckoutManager.selectPaymentMethod(paymentType, creditCard);
    }

    public final void onPhoneNumberChange(PhoneNumber phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        this.multiRideCheckoutManager.updatePhoneNumber(phoneNumber);
    }

    public final void onPostalCodeChange(String postalCode) {
        Intrinsics.checkNotNullParameter(postalCode, "postalCode");
        this.multiRideCheckoutManager.updatePostalCode(postalCode);
    }

    public final void onTermsAcceptUpdated(boolean termsAccepted) {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, null, null, termsAccepted, false, 23, null)));
    }

    public final void startPersonalInfoEdit() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, null, null, false, true, 15, null)));
    }

    public final void updatePhoneNumberCode(String phoneNumberCode) {
        Intrinsics.checkNotNullParameter(phoneNumberCode, "phoneNumberCode");
        onPhoneNumberChange(PhoneNumber.copy$default(this.checkoutState.getValue().getPersonalInfo().getPhoneNumber(), phoneNumberCode, null, 2, null));
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJN\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0003\u0010\u0019R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u001e\u0010\u0019R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001f\u0010\u0019¨\u0006 "}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/multiride/purchase/MultiRidePurchaseSummaryViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isLoading", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/account/CreditCard;", "savedCreditCards", "Ldk/molslinjen/domain/model/payment/PaymentType;", "paymentTypes", "termsAccepted", "personalInfoIsInEditMode", "<init>", "(ZLjava/util/List;Ljava/util/List;ZZ)V", "copy", "(ZLjava/util/List;Ljava/util/List;ZZ)Ldk/molslinjen/ui/views/screens/agreements/multiride/purchase/MultiRidePurchaseSummaryViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "Ljava/util/List;", "getSavedCreditCards", "()Ljava/util/List;", "getPaymentTypes", "getTermsAccepted", "getPersonalInfoIsInEditMode", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final boolean isLoading;
        private final List<PaymentType> paymentTypes;
        private final boolean personalInfoIsInEditMode;
        private final List<CreditCard> savedCreditCards;
        private final boolean termsAccepted;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(boolean z5, List<CreditCard> savedCreditCards, List<? extends PaymentType> paymentTypes, boolean z6, boolean z7) {
            Intrinsics.checkNotNullParameter(savedCreditCards, "savedCreditCards");
            Intrinsics.checkNotNullParameter(paymentTypes, "paymentTypes");
            this.isLoading = z5;
            this.savedCreditCards = savedCreditCards;
            this.paymentTypes = paymentTypes;
            this.termsAccepted = z6;
            this.personalInfoIsInEditMode = z7;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z5, List list, List list2, boolean z6, boolean z7, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z5 = viewState.isLoading;
            }
            if ((i5 & 2) != 0) {
                list = viewState.savedCreditCards;
            }
            List list3 = list;
            if ((i5 & 4) != 0) {
                list2 = viewState.paymentTypes;
            }
            List list4 = list2;
            if ((i5 & 8) != 0) {
                z6 = viewState.termsAccepted;
            }
            boolean z8 = z6;
            if ((i5 & 16) != 0) {
                z7 = viewState.personalInfoIsInEditMode;
            }
            return viewState.copy(z5, list3, list4, z8, z7);
        }

        public final ViewState copy(boolean isLoading, List<CreditCard> savedCreditCards, List<? extends PaymentType> paymentTypes, boolean termsAccepted, boolean personalInfoIsInEditMode) {
            Intrinsics.checkNotNullParameter(savedCreditCards, "savedCreditCards");
            Intrinsics.checkNotNullParameter(paymentTypes, "paymentTypes");
            return new ViewState(isLoading, savedCreditCards, paymentTypes, termsAccepted, personalInfoIsInEditMode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isLoading == viewState.isLoading && Intrinsics.areEqual(this.savedCreditCards, viewState.savedCreditCards) && Intrinsics.areEqual(this.paymentTypes, viewState.paymentTypes) && this.termsAccepted == viewState.termsAccepted && this.personalInfoIsInEditMode == viewState.personalInfoIsInEditMode;
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

        public final boolean getTermsAccepted() {
            return this.termsAccepted;
        }

        public int hashCode() {
            return (((((((Boolean.hashCode(this.isLoading) * 31) + this.savedCreditCards.hashCode()) * 31) + this.paymentTypes.hashCode()) * 31) + Boolean.hashCode(this.termsAccepted)) * 31) + Boolean.hashCode(this.personalInfoIsInEditMode);
        }

        public String toString() {
            return "ViewState(isLoading=" + this.isLoading + ", savedCreditCards=" + this.savedCreditCards + ", paymentTypes=" + this.paymentTypes + ", termsAccepted=" + this.termsAccepted + ", personalInfoIsInEditMode=" + this.personalInfoIsInEditMode + ")";
        }

        public /* synthetic */ ViewState(boolean z5, List list, List list2, boolean z6, boolean z7, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? true : z5, (i5 & 2) != 0 ? CollectionsKt.emptyList() : list, (i5 & 4) != 0 ? IPaymentManager.INSTANCE.getDefaultPaymentMethods() : list2, (i5 & 8) != 0 ? false : z6, z7);
        }
    }
}
