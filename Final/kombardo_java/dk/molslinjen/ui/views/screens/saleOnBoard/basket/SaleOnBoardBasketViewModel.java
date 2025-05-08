package dk.molslinjen.ui.views.screens.saleOnBoard.basket;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.sun.jna.Function;
import dk.molslinjen.core.push.IPushHandler;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.analytics.SaleOnBoardAnalyticsEvent;
import dk.molslinjen.domain.managers.checkout.IPaymentManager;
import dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardCheckoutManager;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager;
import dk.molslinjen.domain.managers.site.ISiteManager;
import dk.molslinjen.domain.managers.user.creditcards.IUserCreditCardsManager;
import dk.molslinjen.domain.model.account.CreditCard;
import dk.molslinjen.domain.model.payment.PaymentType;
import dk.molslinjen.domain.model.saleOnBoard.NotificationType;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardCategory;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardCrossSaleProduct;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardLineItem;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProduct;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardStore;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardTimeSlot;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.domain.model.site.SiteInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001EBA\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\b\u0010#\u001a\u00020\u001dH\u0002J\b\u0010$\u001a\u00020\u001dH\u0002J\u0018\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)J\u000e\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u000202J\u000e\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u00020,J\u000e\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u00020,J\u000e\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u00020,J\u000e\u00109\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020;J\u000e\u0010<\u001a\u00020\u001d2\u0006\u0010=\u001a\u00020>J\u000e\u0010?\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020/J\u0006\u0010A\u001a\u00020\u001dJ\u0014\u0010B\u001a\u00020\u001d2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001d0DR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018¨\u0006F"}, d2 = {"Ldk/molslinjen/ui/views/screens/saleOnBoard/basket/SaleOnBoardBasketViewModel;", "Landroidx/lifecycle/ViewModel;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "saleOnBoardCheckoutManager", "Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardCheckoutManager;", "paymentManager", "Ldk/molslinjen/domain/managers/checkout/IPaymentManager;", "creditCardsManager", "Ldk/molslinjen/domain/managers/user/creditcards/IUserCreditCardsManager;", "pushHandler", "Ldk/molslinjen/core/push/IPushHandler;", "siteManager", "Ldk/molslinjen/domain/managers/site/ISiteManager;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "<init>", "(Ldk/molslinjen/core/snackbar/ISnackbarService;Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardCheckoutManager;Ldk/molslinjen/domain/managers/checkout/IPaymentManager;Ldk/molslinjen/domain/managers/user/creditcards/IUserCreditCardsManager;Ldk/molslinjen/core/push/IPushHandler;Ldk/molslinjen/domain/managers/site/ISiteManager;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/saleOnBoard/basket/SaleOnBoardBasketViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "saleOnBoardCheckoutState", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", "getSaleOnBoardCheckoutState", "listenerToUpdateCrossSaleProducts", BuildConfig.FLAVOR, "getProduct", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;", "crossSaleProduct", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCrossSaleProduct;", "setupTimeSlotListener", "loadTimeSlots", "loadPaymentMethods", "paymentMethodSelected", "paymentType", "Ldk/molslinjen/domain/model/payment/PaymentType;", "creditCard", "Ldk/molslinjen/domain/model/account/CreditCard;", "removeLineItem", "lineItemId", BuildConfig.FLAVOR, "onPickupTimeCategorySelection", "asEarlyAsPossible", BuildConfig.FLAVOR, "onTimeSlotSelected", "timeSlot", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardTimeSlot;", "onNameChange", "name", "onEmailChange", "email", "updatePhoneNumberCode", "phoneNumberCode", "onPhoneNumberChange", "phoneNumber", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "onNotificationTypeChange", "notificationType", "Ldk/molslinjen/domain/model/saleOnBoard/NotificationType;", "togglePushNotificationPermission", "enabled", "undoRemoveLastLineItem", "proceedToPayment", "proceed", "Lkotlin/Function0;", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaleOnBoardBasketViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final IAnalyticsTracker analyticsTracker;
    private final IUserCreditCardsManager creditCardsManager;
    private final IPaymentManager paymentManager;
    private final IPushHandler pushHandler;
    private final ISaleOnBoardCheckoutManager saleOnBoardCheckoutManager;
    private final StateFlow<SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState> saleOnBoardCheckoutState;
    private final ISnackbarService snackbarService;
    private final StateFlow<ViewState> viewState;

    /* JADX WARN: Multi-variable type inference failed */
    public SaleOnBoardBasketViewModel(ISnackbarService snackbarService, ISaleOnBoardCheckoutManager saleOnBoardCheckoutManager, IPaymentManager paymentManager, IUserCreditCardsManager creditCardsManager, IPushHandler pushHandler, ISiteManager siteManager, IAnalyticsTracker analyticsTracker) {
        ViewState value;
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(saleOnBoardCheckoutManager, "saleOnBoardCheckoutManager");
        Intrinsics.checkNotNullParameter(paymentManager, "paymentManager");
        Intrinsics.checkNotNullParameter(creditCardsManager, "creditCardsManager");
        Intrinsics.checkNotNullParameter(pushHandler, "pushHandler");
        Intrinsics.checkNotNullParameter(siteManager, "siteManager");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        this.snackbarService = snackbarService;
        this.saleOnBoardCheckoutManager = saleOnBoardCheckoutManager;
        this.paymentManager = paymentManager;
        this.creditCardsManager = creditCardsManager;
        this.pushHandler = pushHandler;
        this.analyticsTracker = analyticsTracker;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(false, false, null, null, null, false, null, null, null, 511, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        this.saleOnBoardCheckoutState = saleOnBoardCheckoutManager.getSaleOnBoardCheckoutState();
        loadTimeSlots();
        setupTimeSlotListener();
        loadPaymentMethods();
        listenerToUpdateCrossSaleProducts();
        List<SiteInfo> value2 = siteManager.getAvailableSites().getValue();
        SiteInfo siteInfo = null;
        if (value2 != null) {
            Iterator<T> it = value2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((SiteInfo) next).getSite() == this.saleOnBoardCheckoutState.getValue().getSite()) {
                    siteInfo = next;
                    break;
                }
            }
            siteInfo = siteInfo;
        }
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, false, null, null, null, this.pushHandler.isPushEnabled(), siteInfo, null, null, 415, null)));
        this.analyticsTracker.trackSaleOnBoardEvent(new SaleOnBoardAnalyticsEvent.ViewCart(this.saleOnBoardCheckoutState.getValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SaleOnBoardProduct getProduct(SaleOnBoardCrossSaleProduct crossSaleProduct) {
        List<SaleOnBoardCategory> categories;
        Object obj;
        SaleOnBoardStore selectedStore = this.saleOnBoardCheckoutState.getValue().getSelectedStore();
        r1 = null;
        if (selectedStore != null && (categories = selectedStore.getCategories()) != null) {
            Iterator<T> it = categories.iterator();
            loop0: while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                List<SaleOnBoardProduct> products = ((SaleOnBoardCategory) obj).getProducts();
                if (!(products instanceof Collection) || !products.isEmpty()) {
                    Iterator<T> it2 = products.iterator();
                    while (it2.hasNext()) {
                        if (Intrinsics.areEqual(((SaleOnBoardProduct) it2.next()).getId(), crossSaleProduct.getProductId())) {
                            break loop0;
                        }
                    }
                }
            }
            SaleOnBoardCategory saleOnBoardCategory = (SaleOnBoardCategory) obj;
            if (saleOnBoardCategory != null) {
                for (SaleOnBoardProduct saleOnBoardProduct : saleOnBoardCategory.getProducts()) {
                    if (Intrinsics.areEqual(saleOnBoardProduct.getId(), crossSaleProduct.getProductId())) {
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
        return saleOnBoardProduct;
    }

    private final void listenerToUpdateCrossSaleProducts() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SaleOnBoardBasketViewModel$listenerToUpdateCrossSaleProducts$1(this, null), 3, null);
    }

    private final void loadPaymentMethods() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SaleOnBoardBasketViewModel$loadPaymentMethods$1(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SaleOnBoardBasketViewModel$loadPaymentMethods$2(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SaleOnBoardBasketViewModel$loadPaymentMethods$3(this, null), 3, null);
    }

    private final void loadTimeSlots() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SaleOnBoardBasketViewModel$loadTimeSlots$1(this, null), 3, null);
    }

    private final void setupTimeSlotListener() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SaleOnBoardBasketViewModel$setupTimeSlotListener$1(this, null), 3, null);
    }

    public final StateFlow<SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState> getSaleOnBoardCheckoutState() {
        return this.saleOnBoardCheckoutState;
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void onEmailChange(String email) {
        Intrinsics.checkNotNullParameter(email, "email");
        this.saleOnBoardCheckoutManager.updateEmail(email);
    }

    public final void onNameChange(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.saleOnBoardCheckoutManager.updateName(name);
    }

    public final void onNotificationTypeChange(NotificationType notificationType) {
        Intrinsics.checkNotNullParameter(notificationType, "notificationType");
        this.saleOnBoardCheckoutManager.updateNotificationType(notificationType);
    }

    public final void onPhoneNumberChange(PhoneNumber phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        this.saleOnBoardCheckoutManager.updatePhoneNumber(phoneNumber);
    }

    public final void onPickupTimeCategorySelection(boolean asEarlyAsPossible) {
        ViewState value;
        Object obj;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, asEarlyAsPossible, null, null, null, false, null, null, null, 509, null)));
        ISaleOnBoardCheckoutManager iSaleOnBoardCheckoutManager = this.saleOnBoardCheckoutManager;
        Iterator<T> it = this.viewState.getValue().getTimeSlots().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (!((SaleOnBoardTimeSlot) obj).getFullyBooked()) {
                    break;
                }
            }
        }
        SaleOnBoardTimeSlot saleOnBoardTimeSlot = (SaleOnBoardTimeSlot) obj;
        if (saleOnBoardTimeSlot == null) {
            return;
        }
        iSaleOnBoardCheckoutManager.selectTimeSlot(saleOnBoardTimeSlot);
    }

    public final void onTimeSlotSelected(SaleOnBoardTimeSlot timeSlot) {
        Intrinsics.checkNotNullParameter(timeSlot, "timeSlot");
        this.saleOnBoardCheckoutManager.selectTimeSlot(timeSlot);
    }

    public final void paymentMethodSelected(PaymentType paymentType, CreditCard creditCard) {
        Intrinsics.checkNotNullParameter(paymentType, "paymentType");
        boolean z5 = this.saleOnBoardCheckoutState.getValue().getSelectedPaymentType() != paymentType;
        if (creditCard == null) {
            creditCard = (z5 && paymentType == PaymentType.Card) ? (CreditCard) CollectionsKt.firstOrNull((List) this.viewState.getValue().getSavedCreditCards()) : null;
        }
        this.saleOnBoardCheckoutManager.selectPaymentMethod(paymentType, creditCard);
    }

    public final void proceedToPayment(Function0<Unit> proceed) {
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        this.analyticsTracker.trackBeginCheckout(this.saleOnBoardCheckoutManager);
        proceed.invoke();
    }

    public final void removeLineItem(String lineItemId) {
        Object obj;
        Intrinsics.checkNotNullParameter(lineItemId, "lineItemId");
        Iterator<T> it = this.saleOnBoardCheckoutState.getValue().getBasketLineItems().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((SaleOnBoardLineItem) obj).getId(), lineItemId)) {
                    break;
                }
            }
        }
        SaleOnBoardLineItem saleOnBoardLineItem = (SaleOnBoardLineItem) obj;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        while (true) {
            ViewState value = mutableStateFlow.getValue();
            SaleOnBoardLineItem saleOnBoardLineItem2 = saleOnBoardLineItem;
            if (mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, false, null, null, null, false, null, null, saleOnBoardLineItem, Function.USE_VARARGS, null))) {
                this.saleOnBoardCheckoutManager.removeLineItem(lineItemId);
                return;
            }
            saleOnBoardLineItem = saleOnBoardLineItem2;
        }
    }

    public final void togglePushNotificationPermission(boolean enabled) {
        ViewState value;
        this.pushHandler.setPushEnabled(enabled);
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, false, null, null, null, enabled, null, null, null, 479, null)));
    }

    public final void undoRemoveLastLineItem() {
        SaleOnBoardLineItem lastRemovedLineItem = this.viewState.getValue().getLastRemovedLineItem();
        if (lastRemovedLineItem == null) {
            return;
        }
        ISaleOnBoardCheckoutManager.DefaultImpls.addToBasket$default(this.saleOnBoardCheckoutManager, lastRemovedLineItem, false, 2, null);
    }

    public final void updatePhoneNumberCode(String phoneNumberCode) {
        Intrinsics.checkNotNullParameter(phoneNumberCode, "phoneNumberCode");
        onPhoneNumberChange(PhoneNumber.copy$default(this.saleOnBoardCheckoutState.getValue().getContactInfo().getPhoneNumber(), phoneNumberCode, null, 2, null));
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0086\u0001\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b\u0003\u0010!R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010 \u001a\u0004\b\"\u0010!R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010#\u001a\u0004\b$\u0010%R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006¢\u0006\f\n\u0004\b\t\u0010#\u001a\u0004\b&\u0010%R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00058\u0006¢\u0006\f\n\u0004\b\u000b\u0010#\u001a\u0004\b'\u0010%R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b\f\u0010!R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010(\u001a\u0004\b)\u0010*R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00058\u0006¢\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b+\u0010%R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010,\u001a\u0004\b-\u0010.¨\u0006/"}, d2 = {"Ldk/molslinjen/ui/views/screens/saleOnBoard/basket/SaleOnBoardBasketViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isLoadingTimeSlots", "timeSlotAsEarlyAsPossible", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardTimeSlot;", "timeSlots", "Ldk/molslinjen/domain/model/payment/PaymentType;", "paymentTypes", "Ldk/molslinjen/domain/model/account/CreditCard;", "savedCreditCards", "isPushNotificationEnabled", "Ldk/molslinjen/domain/model/site/SiteInfo;", "siteInfo", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCrossSaleProduct;", "crossSaleProducts", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "lastRemovedLineItem", "<init>", "(ZZLjava/util/List;Ljava/util/List;Ljava/util/List;ZLdk/molslinjen/domain/model/site/SiteInfo;Ljava/util/List;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;)V", "copy", "(ZZLjava/util/List;Ljava/util/List;Ljava/util/List;ZLdk/molslinjen/domain/model/site/SiteInfo;Ljava/util/List;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;)Ldk/molslinjen/ui/views/screens/saleOnBoard/basket/SaleOnBoardBasketViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "getTimeSlotAsEarlyAsPossible", "Ljava/util/List;", "getTimeSlots", "()Ljava/util/List;", "getPaymentTypes", "getSavedCreditCards", "Ldk/molslinjen/domain/model/site/SiteInfo;", "getSiteInfo", "()Ldk/molslinjen/domain/model/site/SiteInfo;", "getCrossSaleProducts", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "getLastRemovedLineItem", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final List<SaleOnBoardCrossSaleProduct> crossSaleProducts;
        private final boolean isLoadingTimeSlots;
        private final boolean isPushNotificationEnabled;
        private final SaleOnBoardLineItem lastRemovedLineItem;
        private final List<PaymentType> paymentTypes;
        private final List<CreditCard> savedCreditCards;
        private final SiteInfo siteInfo;
        private final boolean timeSlotAsEarlyAsPossible;
        private final List<SaleOnBoardTimeSlot> timeSlots;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(boolean z5, boolean z6, List<SaleOnBoardTimeSlot> timeSlots, List<? extends PaymentType> paymentTypes, List<CreditCard> savedCreditCards, boolean z7, SiteInfo siteInfo, List<SaleOnBoardCrossSaleProduct> crossSaleProducts, SaleOnBoardLineItem saleOnBoardLineItem) {
            Intrinsics.checkNotNullParameter(timeSlots, "timeSlots");
            Intrinsics.checkNotNullParameter(paymentTypes, "paymentTypes");
            Intrinsics.checkNotNullParameter(savedCreditCards, "savedCreditCards");
            Intrinsics.checkNotNullParameter(crossSaleProducts, "crossSaleProducts");
            this.isLoadingTimeSlots = z5;
            this.timeSlotAsEarlyAsPossible = z6;
            this.timeSlots = timeSlots;
            this.paymentTypes = paymentTypes;
            this.savedCreditCards = savedCreditCards;
            this.isPushNotificationEnabled = z7;
            this.siteInfo = siteInfo;
            this.crossSaleProducts = crossSaleProducts;
            this.lastRemovedLineItem = saleOnBoardLineItem;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z5, boolean z6, List list, List list2, List list3, boolean z7, SiteInfo siteInfo, List list4, SaleOnBoardLineItem saleOnBoardLineItem, int i5, Object obj) {
            return viewState.copy((i5 & 1) != 0 ? viewState.isLoadingTimeSlots : z5, (i5 & 2) != 0 ? viewState.timeSlotAsEarlyAsPossible : z6, (i5 & 4) != 0 ? viewState.timeSlots : list, (i5 & 8) != 0 ? viewState.paymentTypes : list2, (i5 & 16) != 0 ? viewState.savedCreditCards : list3, (i5 & 32) != 0 ? viewState.isPushNotificationEnabled : z7, (i5 & 64) != 0 ? viewState.siteInfo : siteInfo, (i5 & 128) != 0 ? viewState.crossSaleProducts : list4, (i5 & 256) != 0 ? viewState.lastRemovedLineItem : saleOnBoardLineItem);
        }

        public final ViewState copy(boolean isLoadingTimeSlots, boolean timeSlotAsEarlyAsPossible, List<SaleOnBoardTimeSlot> timeSlots, List<? extends PaymentType> paymentTypes, List<CreditCard> savedCreditCards, boolean isPushNotificationEnabled, SiteInfo siteInfo, List<SaleOnBoardCrossSaleProduct> crossSaleProducts, SaleOnBoardLineItem lastRemovedLineItem) {
            Intrinsics.checkNotNullParameter(timeSlots, "timeSlots");
            Intrinsics.checkNotNullParameter(paymentTypes, "paymentTypes");
            Intrinsics.checkNotNullParameter(savedCreditCards, "savedCreditCards");
            Intrinsics.checkNotNullParameter(crossSaleProducts, "crossSaleProducts");
            return new ViewState(isLoadingTimeSlots, timeSlotAsEarlyAsPossible, timeSlots, paymentTypes, savedCreditCards, isPushNotificationEnabled, siteInfo, crossSaleProducts, lastRemovedLineItem);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isLoadingTimeSlots == viewState.isLoadingTimeSlots && this.timeSlotAsEarlyAsPossible == viewState.timeSlotAsEarlyAsPossible && Intrinsics.areEqual(this.timeSlots, viewState.timeSlots) && Intrinsics.areEqual(this.paymentTypes, viewState.paymentTypes) && Intrinsics.areEqual(this.savedCreditCards, viewState.savedCreditCards) && this.isPushNotificationEnabled == viewState.isPushNotificationEnabled && Intrinsics.areEqual(this.siteInfo, viewState.siteInfo) && Intrinsics.areEqual(this.crossSaleProducts, viewState.crossSaleProducts) && Intrinsics.areEqual(this.lastRemovedLineItem, viewState.lastRemovedLineItem);
        }

        public final List<SaleOnBoardCrossSaleProduct> getCrossSaleProducts() {
            return this.crossSaleProducts;
        }

        public final SaleOnBoardLineItem getLastRemovedLineItem() {
            return this.lastRemovedLineItem;
        }

        public final List<PaymentType> getPaymentTypes() {
            return this.paymentTypes;
        }

        public final List<CreditCard> getSavedCreditCards() {
            return this.savedCreditCards;
        }

        public final SiteInfo getSiteInfo() {
            return this.siteInfo;
        }

        public final boolean getTimeSlotAsEarlyAsPossible() {
            return this.timeSlotAsEarlyAsPossible;
        }

        public final List<SaleOnBoardTimeSlot> getTimeSlots() {
            return this.timeSlots;
        }

        public int hashCode() {
            int hashCode = ((((((((((Boolean.hashCode(this.isLoadingTimeSlots) * 31) + Boolean.hashCode(this.timeSlotAsEarlyAsPossible)) * 31) + this.timeSlots.hashCode()) * 31) + this.paymentTypes.hashCode()) * 31) + this.savedCreditCards.hashCode()) * 31) + Boolean.hashCode(this.isPushNotificationEnabled)) * 31;
            SiteInfo siteInfo = this.siteInfo;
            int hashCode2 = (((hashCode + (siteInfo == null ? 0 : siteInfo.hashCode())) * 31) + this.crossSaleProducts.hashCode()) * 31;
            SaleOnBoardLineItem saleOnBoardLineItem = this.lastRemovedLineItem;
            return hashCode2 + (saleOnBoardLineItem != null ? saleOnBoardLineItem.hashCode() : 0);
        }

        /* renamed from: isLoadingTimeSlots, reason: from getter */
        public final boolean getIsLoadingTimeSlots() {
            return this.isLoadingTimeSlots;
        }

        /* renamed from: isPushNotificationEnabled, reason: from getter */
        public final boolean getIsPushNotificationEnabled() {
            return this.isPushNotificationEnabled;
        }

        public String toString() {
            return "ViewState(isLoadingTimeSlots=" + this.isLoadingTimeSlots + ", timeSlotAsEarlyAsPossible=" + this.timeSlotAsEarlyAsPossible + ", timeSlots=" + this.timeSlots + ", paymentTypes=" + this.paymentTypes + ", savedCreditCards=" + this.savedCreditCards + ", isPushNotificationEnabled=" + this.isPushNotificationEnabled + ", siteInfo=" + this.siteInfo + ", crossSaleProducts=" + this.crossSaleProducts + ", lastRemovedLineItem=" + this.lastRemovedLineItem + ")";
        }

        public /* synthetic */ ViewState(boolean z5, boolean z6, List list, List list2, List list3, boolean z7, SiteInfo siteInfo, List list4, SaleOnBoardLineItem saleOnBoardLineItem, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? true : z5, (i5 & 2) == 0 ? z6 : true, (i5 & 4) != 0 ? CollectionsKt.emptyList() : list, (i5 & 8) != 0 ? IPaymentManager.INSTANCE.getDefaultPaymentMethods() : list2, (i5 & 16) != 0 ? CollectionsKt.emptyList() : list3, (i5 & 32) != 0 ? false : z7, (i5 & 64) != 0 ? null : siteInfo, (i5 & 128) != 0 ? CollectionsKt.emptyList() : list4, (i5 & 256) == 0 ? saleOnBoardLineItem : null);
        }
    }
}
