package dk.molslinjen.ui.views.screens.booking.simpleChange;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.checkout.IPaymentManager;
import dk.molslinjen.domain.managers.checkout.ISimpleChangeCheckoutManager;
import dk.molslinjen.domain.managers.checkout.SimpleChangeCheckoutManager;
import dk.molslinjen.domain.managers.site.ISiteManager;
import dk.molslinjen.domain.managers.user.creditcards.IUserCreditCardsManager;
import dk.molslinjen.domain.model.account.CreditCard;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.payment.PaymentType;
import dk.molslinjen.domain.model.site.SiteInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001 B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u0018\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014¨\u0006!"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/simpleChange/SimpleChangeSummaryViewModel;", "Landroidx/lifecycle/ViewModel;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "creditCardsManager", "Ldk/molslinjen/domain/managers/user/creditcards/IUserCreditCardsManager;", "paymentManager", "Ldk/molslinjen/domain/managers/checkout/IPaymentManager;", "simpleChangeCheckoutManager", "Ldk/molslinjen/domain/managers/checkout/ISimpleChangeCheckoutManager;", "siteManager", "Ldk/molslinjen/domain/managers/site/ISiteManager;", "<init>", "(Ldk/molslinjen/core/snackbar/ISnackbarService;Ldk/molslinjen/domain/managers/user/creditcards/IUserCreditCardsManager;Ldk/molslinjen/domain/managers/checkout/IPaymentManager;Ldk/molslinjen/domain/managers/checkout/ISimpleChangeCheckoutManager;Ldk/molslinjen/domain/managers/site/ISiteManager;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/booking/simpleChange/SimpleChangeSummaryViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "simpleChangeCheckoutState", "Ldk/molslinjen/domain/managers/checkout/SimpleChangeCheckoutManager$SimpleChangeCheckoutState;", "getSimpleChangeCheckoutState", "setupSiteInfo", BuildConfig.FLAVOR, "loadPaymentMethods", "paymentMethodSelected", "paymentType", "Ldk/molslinjen/domain/model/payment/PaymentType;", "creditCard", "Ldk/molslinjen/domain/model/account/CreditCard;", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SimpleChangeSummaryViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final IUserCreditCardsManager creditCardsManager;
    private final IPaymentManager paymentManager;
    private final ISimpleChangeCheckoutManager simpleChangeCheckoutManager;
    private final StateFlow<SimpleChangeCheckoutManager.SimpleChangeCheckoutState> simpleChangeCheckoutState;
    private final ISiteManager siteManager;
    private final ISnackbarService snackbarService;
    private final StateFlow<ViewState> viewState;

    public SimpleChangeSummaryViewModel(ISnackbarService snackbarService, IUserCreditCardsManager creditCardsManager, IPaymentManager paymentManager, ISimpleChangeCheckoutManager simpleChangeCheckoutManager, ISiteManager siteManager) {
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(creditCardsManager, "creditCardsManager");
        Intrinsics.checkNotNullParameter(paymentManager, "paymentManager");
        Intrinsics.checkNotNullParameter(simpleChangeCheckoutManager, "simpleChangeCheckoutManager");
        Intrinsics.checkNotNullParameter(siteManager, "siteManager");
        this.snackbarService = snackbarService;
        this.creditCardsManager = creditCardsManager;
        this.paymentManager = paymentManager;
        this.simpleChangeCheckoutManager = simpleChangeCheckoutManager;
        this.siteManager = siteManager;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(false, null, null, null, 15, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        this.simpleChangeCheckoutState = simpleChangeCheckoutManager.getSimpleChangeCheckoutState();
        loadPaymentMethods();
        setupSiteInfo();
    }

    private final void loadPaymentMethods() {
        SimpleChangeCheckoutManager.SimpleChangeCheckoutState value = this.simpleChangeCheckoutState.getValue();
        Booking existingBooking = value.getExistingBooking();
        if (existingBooking == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SimpleChangeSummaryViewModel$loadPaymentMethods$1(this, existingBooking, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SimpleChangeSummaryViewModel$loadPaymentMethods$2(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SimpleChangeSummaryViewModel$loadPaymentMethods$3(this, value, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setupSiteInfo() {
        ViewState value;
        Booking existingBooking = this.simpleChangeCheckoutState.getValue().getExistingBooking();
        SiteInfo siteInfo = null;
        Site site = existingBooking != null ? existingBooking.getSite() : null;
        List<SiteInfo> value2 = this.siteManager.getAvailableSites().getValue();
        if (value2 != null) {
            Iterator<T> it = value2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((SiteInfo) next).getSite() == site) {
                    siteInfo = next;
                    break;
                }
            }
            siteInfo = siteInfo;
        }
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, siteInfo, null, null, 13, null)));
    }

    public final StateFlow<SimpleChangeCheckoutManager.SimpleChangeCheckoutState> getSimpleChangeCheckoutState() {
        return this.simpleChangeCheckoutState;
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void paymentMethodSelected(PaymentType paymentType, CreditCard creditCard) {
        Intrinsics.checkNotNullParameter(paymentType, "paymentType");
        boolean z5 = this.simpleChangeCheckoutManager.getSimpleChangeCheckoutState().getValue().getSelectedPaymentType() != paymentType;
        if (creditCard == null) {
            creditCard = (z5 && paymentType == PaymentType.Card) ? (CreditCard) CollectionsKt.firstOrNull((List) this.viewState.getValue().getSavedCreditCards()) : null;
        }
        this.simpleChangeCheckoutManager.selectPaymentMethod(paymentType, creditCard);
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0004\b\u000b\u0010\fJF\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0003\u0010\u0019R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010\u001d\u001a\u0004\b \u0010\u001f¨\u0006!"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/simpleChange/SimpleChangeSummaryViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isLoading", "Ldk/molslinjen/domain/model/site/SiteInfo;", "siteInfo", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/payment/PaymentType;", "paymentTypes", "Ldk/molslinjen/domain/model/account/CreditCard;", "savedCreditCards", "<init>", "(ZLdk/molslinjen/domain/model/site/SiteInfo;Ljava/util/List;Ljava/util/List;)V", "copy", "(ZLdk/molslinjen/domain/model/site/SiteInfo;Ljava/util/List;Ljava/util/List;)Ldk/molslinjen/ui/views/screens/booking/simpleChange/SimpleChangeSummaryViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "Ldk/molslinjen/domain/model/site/SiteInfo;", "getSiteInfo", "()Ldk/molslinjen/domain/model/site/SiteInfo;", "Ljava/util/List;", "getPaymentTypes", "()Ljava/util/List;", "getSavedCreditCards", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final boolean isLoading;
        private final List<PaymentType> paymentTypes;
        private final List<CreditCard> savedCreditCards;
        private final SiteInfo siteInfo;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(boolean z5, SiteInfo siteInfo, List<? extends PaymentType> paymentTypes, List<CreditCard> savedCreditCards) {
            Intrinsics.checkNotNullParameter(paymentTypes, "paymentTypes");
            Intrinsics.checkNotNullParameter(savedCreditCards, "savedCreditCards");
            this.isLoading = z5;
            this.siteInfo = siteInfo;
            this.paymentTypes = paymentTypes;
            this.savedCreditCards = savedCreditCards;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z5, SiteInfo siteInfo, List list, List list2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z5 = viewState.isLoading;
            }
            if ((i5 & 2) != 0) {
                siteInfo = viewState.siteInfo;
            }
            if ((i5 & 4) != 0) {
                list = viewState.paymentTypes;
            }
            if ((i5 & 8) != 0) {
                list2 = viewState.savedCreditCards;
            }
            return viewState.copy(z5, siteInfo, list, list2);
        }

        public final ViewState copy(boolean isLoading, SiteInfo siteInfo, List<? extends PaymentType> paymentTypes, List<CreditCard> savedCreditCards) {
            Intrinsics.checkNotNullParameter(paymentTypes, "paymentTypes");
            Intrinsics.checkNotNullParameter(savedCreditCards, "savedCreditCards");
            return new ViewState(isLoading, siteInfo, paymentTypes, savedCreditCards);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isLoading == viewState.isLoading && Intrinsics.areEqual(this.siteInfo, viewState.siteInfo) && Intrinsics.areEqual(this.paymentTypes, viewState.paymentTypes) && Intrinsics.areEqual(this.savedCreditCards, viewState.savedCreditCards);
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

        public int hashCode() {
            int hashCode = Boolean.hashCode(this.isLoading) * 31;
            SiteInfo siteInfo = this.siteInfo;
            return ((((hashCode + (siteInfo == null ? 0 : siteInfo.hashCode())) * 31) + this.paymentTypes.hashCode()) * 31) + this.savedCreditCards.hashCode();
        }

        public String toString() {
            return "ViewState(isLoading=" + this.isLoading + ", siteInfo=" + this.siteInfo + ", paymentTypes=" + this.paymentTypes + ", savedCreditCards=" + this.savedCreditCards + ")";
        }

        public /* synthetic */ ViewState(boolean z5, SiteInfo siteInfo, List list, List list2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? true : z5, (i5 & 2) != 0 ? null : siteInfo, (i5 & 4) != 0 ? IPaymentManager.INSTANCE.getDefaultPaymentMethods() : list, (i5 & 8) != 0 ? CollectionsKt.emptyList() : list2);
        }
    }
}
