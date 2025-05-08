package dk.molslinjen.ui.views.screens.booking.receipt;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.helpers.ExternalActionHelper;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.analytics.SaleOnBoardAnalyticsEvent;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.checkout.ICheckoutManager;
import dk.molslinjen.domain.managers.checkout.IEditManager;
import dk.molslinjen.domain.managers.checkout.IReturnManager;
import dk.molslinjen.domain.managers.departure.IDepartureManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.booking.IDepartureInfo;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\f\u0010\u001f\u001a\u00020 *\u00020!H\u0002J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'J\u0014\u0010(\u001a\u00020#2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020#0*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0019\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0019\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016¨\u0006+"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/receipt/ReceiptViewModel;", "Landroidx/lifecycle/ViewModel;", "checkoutManager", "Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "departureManager", "Ldk/molslinjen/domain/managers/departure/IDepartureManager;", "routeManager", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "returnManager", "Ldk/molslinjen/domain/managers/checkout/IReturnManager;", "editManager", "Ldk/molslinjen/domain/managers/checkout/IEditManager;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "<init>", "(Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;Ldk/molslinjen/domain/managers/user/IUserManager;Ldk/molslinjen/domain/managers/departure/IDepartureManager;Ldk/molslinjen/domain/managers/route/IRouteManager;Ldk/molslinjen/domain/managers/checkout/IReturnManager;Ldk/molslinjen/domain/managers/checkout/IEditManager;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;)V", "checkoutState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;", "getCheckoutState", "()Lkotlinx/coroutines/flow/StateFlow;", "outboundCheckoutState", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutDirectionState;", "getOutboundCheckoutState", "returnCheckoutState", "getReturnCheckoutState", "accountCardData", "Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData;", "getAccountCardData", "nudgeForProfileCreate", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/config/Site;", "addToCalendar", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "departure", "Ldk/molslinjen/domain/model/booking/IDepartureInfo;", "goToSaleOnBoardReorder", "proceed", "Lkotlin/Function0;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ReceiptViewModel extends ViewModel {
    private final StateFlow<AccountCardData> accountCardData;
    private final IAnalyticsTracker analyticsTracker;
    private final ICheckoutManager checkoutManager;
    private final StateFlow<CheckoutManager.CheckoutState> checkoutState;
    private final StateFlow<CheckoutManager.CheckoutDirectionState> outboundCheckoutState;
    private final StateFlow<CheckoutManager.CheckoutDirectionState> returnCheckoutState;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Site.values().length];
            try {
                iArr[Site.Mols.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Site.Oeresund.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Site.Kombardo.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ReceiptViewModel(ICheckoutManager checkoutManager, IUserManager userManager, IDepartureManager departureManager, IRouteManager routeManager, IReturnManager returnManager, IEditManager editManager, IAnalyticsTracker analyticsTracker) {
        Intrinsics.checkNotNullParameter(checkoutManager, "checkoutManager");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(departureManager, "departureManager");
        Intrinsics.checkNotNullParameter(routeManager, "routeManager");
        Intrinsics.checkNotNullParameter(returnManager, "returnManager");
        Intrinsics.checkNotNullParameter(editManager, "editManager");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        this.checkoutManager = checkoutManager;
        this.analyticsTracker = analyticsTracker;
        StateFlow<CheckoutManager.CheckoutState> checkoutState = checkoutManager.getCheckoutState();
        this.checkoutState = checkoutState;
        this.outboundCheckoutState = checkoutManager.getOutboundDirectionState();
        this.returnCheckoutState = checkoutManager.getReturnDirectionState();
        this.accountCardData = FlowKt.stateIn(FlowKt.flowCombine(userManager.getPendingAccountActivation(), userManager.getAuthenticationType(), new ReceiptViewModel$accountCardData$1(this, null)), ViewModelKt.getViewModelScope(this), SharingStarted.INSTANCE.getLazily(), null);
        departureManager.clear();
        routeManager.reload();
        returnManager.clear();
        editManager.clear();
        CheckoutManager.CheckoutState value = checkoutState.getValue();
        if (value == null || !value.getHasCancelledSaleOnBoardOrdersOnEditedOrder()) {
            return;
        }
        analyticsTracker.trackSaleOnBoardEvent(SaleOnBoardAnalyticsEvent.ViewReorderPromotion.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean nudgeForProfileCreate(Site site) {
        int i5 = WhenMappings.$EnumSwitchMapping$0[site.ordinal()];
        return i5 == 1 || i5 == 2 || i5 == 3;
    }

    public final void addToCalendar(Context context, IDepartureInfo departure) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(departure, "departure");
        CheckoutManager.CheckoutState value = this.checkoutManager.getCheckoutState().getValue();
        if (value == null) {
            return;
        }
        ExternalActionHelper externalActionHelper = ExternalActionHelper.INSTANCE;
        LocalDateTime atDate = departure.getDepartureTime().atDate(departure.getDate());
        Intrinsics.checkNotNullExpressionValue(atDate, "atDate(...)");
        LocalDateTime atDate2 = departure.getArrivalTime().atDate(departure.getDate());
        Intrinsics.checkNotNullExpressionValue(atDate2, "atDate(...)");
        String departureHarborName = departure.getDepartureHarborName();
        String arrivalHarborName = departure.getArrivalHarborName();
        String name = value.getSite().name();
        String reservationNumber = value.getReservationNumber();
        if (reservationNumber == null) {
            reservationNumber = BuildConfig.FLAVOR;
        }
        externalActionHelper.addToCalendar(context, atDate, atDate2, departureHarborName, arrivalHarborName, name, reservationNumber);
    }

    public final StateFlow<AccountCardData> getAccountCardData() {
        return this.accountCardData;
    }

    public final StateFlow<CheckoutManager.CheckoutState> getCheckoutState() {
        return this.checkoutState;
    }

    public final StateFlow<CheckoutManager.CheckoutDirectionState> getOutboundCheckoutState() {
        return this.outboundCheckoutState;
    }

    public final StateFlow<CheckoutManager.CheckoutDirectionState> getReturnCheckoutState() {
        return this.returnCheckoutState;
    }

    public final void goToSaleOnBoardReorder(Function0<Unit> proceed) {
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        this.analyticsTracker.trackSaleOnBoardEvent(SaleOnBoardAnalyticsEvent.SelectReorderPromotion.INSTANCE);
        proceed.invoke();
    }
}
