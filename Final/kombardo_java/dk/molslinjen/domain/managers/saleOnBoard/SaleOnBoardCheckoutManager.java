package dk.molslinjen.domain.managers.saleOnBoard;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.payment.IPaymentService;
import dk.molslinjen.api.services.payment.request.PaymentServiceAppPaymentRedirectDetailsDTO;
import dk.molslinjen.api.services.paymentTypes.response.PaymentTypeDTO;
import dk.molslinjen.api.services.saleOnBoard.ISaleOnBoardService;
import dk.molslinjen.api.services.saleOnBoard.response.CreateOrderResponseDTO;
import dk.molslinjen.api.shared.response.CurrencyTypeDTO;
import dk.molslinjen.core.extensions.IpHelperKt;
import dk.molslinjen.core.providers.IPaymentCallbackUrlProvider;
import dk.molslinjen.domain.analytics.AnalyticsEvent;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.analytics.SaleOnBoardAnalyticsEvent;
import dk.molslinjen.domain.extensions.ApiResultExtensionsKt;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.checkout.IPaymentManager;
import dk.molslinjen.domain.managers.checkout.PaymentManager;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.account.CreditCard;
import dk.molslinjen.domain.model.account.user.UserContactDetails;
import dk.molslinjen.domain.model.account.user.UserInfo;
import dk.molslinjen.domain.model.account.user.UserPersonalDetails;
import dk.molslinjen.domain.model.booking.BookingCompleted;
import dk.molslinjen.domain.model.booking.BookingProcessingResult;
import dk.molslinjen.domain.model.booking.IDepartureInfo;
import dk.molslinjen.domain.model.booking.SaleOnBoardContactInfo;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.payment.PaymentType;
import dk.molslinjen.domain.model.saleOnBoard.NotificationType;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardCategory;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardLineItem;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProduct;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardStore;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardStoreTimeSlots;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardTimeSlot;
import dk.molslinjen.domain.model.settings.ISettings;
import dk.molslinjen.domain.model.shared.CurrencyType;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001OBI\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u001a\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"H\u0096@¢\u0006\u0002\u0010%J\u001a\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0#0\"H\u0096@¢\u0006\u0002\u0010%J\u0012\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+H\u0016J\u0018\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016J\u001a\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u00106\u001a\u00020\u001cH\u0002J\u0010\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\u0016H\u0002J\u0010\u00109\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020+H\u0016J\u0010\u0010>\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020+H\u0016J\u0010\u0010@\u001a\u00020\u001c2\u0006\u0010A\u001a\u00020BH\u0016J\u0010\u0010C\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020EH\u0016J\u0010\u0010F\u001a\u00020\u001c2\u0006\u0010G\u001a\u00020+H\u0016J$\u0010H\u001a\b\u0012\u0004\u0012\u00020I0\"2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020KH\u0096@¢\u0006\u0002\u0010MJ\u000e\u0010N\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010%R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager;", "Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardCheckoutManager;", "saleOnBoardService", "Ldk/molslinjen/api/services/saleOnBoard/ISaleOnBoardService;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "paymentManager", "Ldk/molslinjen/domain/managers/checkout/IPaymentManager;", "paymentService", "Ldk/molslinjen/api/services/payment/IPaymentService;", "saleOnBoardManager", "Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardManager;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "settings", "Ldk/molslinjen/domain/model/settings/ISettings;", "paymentCallbackUrlProvider", "Ldk/molslinjen/core/providers/IPaymentCallbackUrlProvider;", "<init>", "(Ldk/molslinjen/api/services/saleOnBoard/ISaleOnBoardService;Ldk/molslinjen/domain/managers/user/IUserManager;Ldk/molslinjen/domain/managers/checkout/IPaymentManager;Ldk/molslinjen/api/services/payment/IPaymentService;Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardManager;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;Ldk/molslinjen/domain/model/settings/ISettings;Ldk/molslinjen/core/providers/IPaymentCallbackUrlProvider;)V", "saleOnBoardCheckoutState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", "getSaleOnBoardCheckoutState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "listenForPayment", BuildConfig.FLAVOR, "setDefaultContactInfo", "setupWithDeparture", "departure", "Ldk/molslinjen/domain/model/booking/IDepartureInfo;", "loadShopsAndProducts", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardStore;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadTimeSlots", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardStoreTimeSlots;", "getProduct", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;", Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "addToBasket", "basketLineItem", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "updateExisting", BuildConfig.FLAVOR, "selectPaymentMethod", "paymentType", "Ldk/molslinjen/domain/model/payment/PaymentType;", "creditCard", "Ldk/molslinjen/domain/model/account/CreditCard;", "totalPriceUpdater", "updateTotalPrice", "state", "selectTimeSlot", "timeSlot", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardTimeSlot;", "updateName", "name", "updateEmail", "email", "updatePhoneNumber", "phoneNumber", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "updateNotificationType", "notificationType", "Ldk/molslinjen/domain/model/saleOnBoard/NotificationType;", "removeLineItem", "lineItemId", "createBooking", "Ldk/molslinjen/domain/model/booking/BookingCompleted;", "screenWidth", BuildConfig.FLAVOR, "screenHeight", "(FFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handlePaymentCompleted", "SaleOnBoardCheckoutState", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaleOnBoardCheckoutManager implements ISaleOnBoardCheckoutManager {
    private final IAnalyticsTracker analyticsTracker;
    private final CoroutineScope coroutineScope;
    private final IPaymentCallbackUrlProvider paymentCallbackUrlProvider;
    private final IPaymentManager paymentManager;
    private final IPaymentService paymentService;
    private final MutableStateFlow<SaleOnBoardCheckoutState> saleOnBoardCheckoutState;
    private final ISaleOnBoardManager saleOnBoardManager;
    private final ISaleOnBoardService saleOnBoardService;
    private final ISettings settings;
    private final IUserManager userManager;

    public SaleOnBoardCheckoutManager(ISaleOnBoardService saleOnBoardService, IUserManager userManager, IPaymentManager paymentManager, IPaymentService paymentService, ISaleOnBoardManager saleOnBoardManager, IAnalyticsTracker analyticsTracker, ISettings settings, IPaymentCallbackUrlProvider paymentCallbackUrlProvider) {
        Intrinsics.checkNotNullParameter(saleOnBoardService, "saleOnBoardService");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(paymentManager, "paymentManager");
        Intrinsics.checkNotNullParameter(paymentService, "paymentService");
        Intrinsics.checkNotNullParameter(saleOnBoardManager, "saleOnBoardManager");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(paymentCallbackUrlProvider, "paymentCallbackUrlProvider");
        this.saleOnBoardService = saleOnBoardService;
        this.userManager = userManager;
        this.paymentManager = paymentManager;
        this.paymentService = paymentService;
        this.saleOnBoardManager = saleOnBoardManager;
        this.analyticsTracker = analyticsTracker;
        this.settings = settings;
        this.paymentCallbackUrlProvider = paymentCallbackUrlProvider;
        this.saleOnBoardCheckoutState = StateFlowKt.MutableStateFlow(new SaleOnBoardCheckoutState(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null));
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        totalPriceUpdater();
        listenForPayment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handlePaymentCompleted(Continuation<? super Unit> continuation) {
        SaleOnBoardCheckoutManager$handlePaymentCompleted$1 saleOnBoardCheckoutManager$handlePaymentCompleted$1;
        int i5;
        if (continuation instanceof SaleOnBoardCheckoutManager$handlePaymentCompleted$1) {
            saleOnBoardCheckoutManager$handlePaymentCompleted$1 = (SaleOnBoardCheckoutManager$handlePaymentCompleted$1) continuation;
            int i6 = saleOnBoardCheckoutManager$handlePaymentCompleted$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                saleOnBoardCheckoutManager$handlePaymentCompleted$1.label = i6 - Integer.MIN_VALUE;
                Object obj = saleOnBoardCheckoutManager$handlePaymentCompleted$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = saleOnBoardCheckoutManager$handlePaymentCompleted$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    StateFlow<PaymentManager.PaymentState> paymentState = this.paymentManager.getPaymentState();
                    SaleOnBoardCheckoutManager$handlePaymentCompleted$2 saleOnBoardCheckoutManager$handlePaymentCompleted$2 = new SaleOnBoardCheckoutManager$handlePaymentCompleted$2(this);
                    saleOnBoardCheckoutManager$handlePaymentCompleted$1.label = 1;
                    if (paymentState.collect(saleOnBoardCheckoutManager$handlePaymentCompleted$2, saleOnBoardCheckoutManager$handlePaymentCompleted$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
        }
        saleOnBoardCheckoutManager$handlePaymentCompleted$1 = new SaleOnBoardCheckoutManager$handlePaymentCompleted$1(this, continuation);
        Object obj2 = saleOnBoardCheckoutManager$handlePaymentCompleted$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = saleOnBoardCheckoutManager$handlePaymentCompleted$1.label;
        if (i5 != 0) {
        }
        throw new KotlinNothingValueException();
    }

    private final void listenForPayment() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new SaleOnBoardCheckoutManager$listenForPayment$1(this, null), 3, null);
    }

    private final void setDefaultContactInfo() {
        SaleOnBoardCheckoutState value;
        SaleOnBoardCheckoutState saleOnBoardCheckoutState;
        UserPersonalDetails personalDetails;
        SaleOnBoardCheckoutState value2;
        SaleOnBoardCheckoutState saleOnBoardCheckoutState2;
        UserContactDetails contactDetails;
        SaleOnBoardCheckoutState value3;
        SaleOnBoardCheckoutState saleOnBoardCheckoutState3;
        UserInfo details = this.userManager.getCurrentUserState().getValue().getUser().getDetails();
        if (details != null && (contactDetails = details.getContactDetails()) != null) {
            MutableStateFlow<SaleOnBoardCheckoutState> saleOnBoardCheckoutState4 = getSaleOnBoardCheckoutState();
            do {
                value3 = saleOnBoardCheckoutState4.getValue();
                saleOnBoardCheckoutState3 = value3;
            } while (!saleOnBoardCheckoutState4.compareAndSet(value3, SaleOnBoardCheckoutState.copy$default(saleOnBoardCheckoutState3, null, null, null, null, null, null, null, null, null, null, null, SaleOnBoardContactInfo.copy$default(saleOnBoardCheckoutState3.getContactInfo(), null, contactDetails.getEmail(), contactDetails.getPhoneNumber(), false, 9, null), null, null, null, 30719, null)));
        }
        if (details != null && (personalDetails = details.getPersonalDetails()) != null) {
            MutableStateFlow<SaleOnBoardCheckoutState> saleOnBoardCheckoutState5 = getSaleOnBoardCheckoutState();
            do {
                value2 = saleOnBoardCheckoutState5.getValue();
                saleOnBoardCheckoutState2 = value2;
            } while (!saleOnBoardCheckoutState5.compareAndSet(value2, SaleOnBoardCheckoutState.copy$default(saleOnBoardCheckoutState2, null, null, null, null, null, null, null, null, null, null, null, SaleOnBoardContactInfo.copy$default(saleOnBoardCheckoutState2.getContactInfo(), personalDetails.getFullName(), null, null, false, 14, null), null, null, null, 30719, null)));
        }
        SaleOnBoardContactInfo contactInfo = getSaleOnBoardCheckoutState().getValue().getContactInfo();
        if (contactInfo.getName().length() <= 0 || contactInfo.getEmail().length() <= 0) {
            return;
        }
        MutableStateFlow<SaleOnBoardCheckoutState> saleOnBoardCheckoutState6 = getSaleOnBoardCheckoutState();
        do {
            value = saleOnBoardCheckoutState6.getValue();
            saleOnBoardCheckoutState = value;
        } while (!saleOnBoardCheckoutState6.compareAndSet(value, SaleOnBoardCheckoutState.copy$default(saleOnBoardCheckoutState, null, null, null, null, null, null, null, null, null, null, null, SaleOnBoardContactInfo.copy$default(saleOnBoardCheckoutState.getContactInfo(), null, null, null, true, 7, null), null, null, null, 30719, null)));
    }

    private final void totalPriceUpdater() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new SaleOnBoardCheckoutManager$totalPriceUpdater$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTotalPrice(SaleOnBoardCheckoutState state) {
        SaleOnBoardCheckoutState value;
        Iterator<T> it = state.getBasketLineItems().iterator();
        int i5 = 0;
        while (it.hasNext()) {
            i5 += ((SaleOnBoardLineItem) it.next()).totalPrice().getValue();
        }
        MutableStateFlow<SaleOnBoardCheckoutState> saleOnBoardCheckoutState = getSaleOnBoardCheckoutState();
        do {
            value = saleOnBoardCheckoutState.getValue();
        } while (!saleOnBoardCheckoutState.compareAndSet(value, SaleOnBoardCheckoutState.copy$default(value, null, null, null, null, null, null, new PriceWithCurrency(i5, state.getCurrencyType()), null, null, null, null, null, null, null, null, 32703, null)));
    }

    @Override // dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardCheckoutManager
    public void addToBasket(SaleOnBoardLineItem basketLineItem, boolean updateExisting) {
        SaleOnBoardCheckoutState value;
        SaleOnBoardCheckoutState saleOnBoardCheckoutState;
        SaleOnBoardCheckoutState value2;
        Object obj;
        SaleOnBoardCheckoutState copy$default;
        Intrinsics.checkNotNullParameter(basketLineItem, "basketLineItem");
        int i5 = 0;
        if (updateExisting) {
            MutableStateFlow<SaleOnBoardCheckoutState> saleOnBoardCheckoutState2 = getSaleOnBoardCheckoutState();
            do {
                value2 = saleOnBoardCheckoutState2.getValue();
                SaleOnBoardCheckoutState saleOnBoardCheckoutState3 = value2;
                Iterator<T> it = saleOnBoardCheckoutState3.getBasketLineItems().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it.next();
                        if (Intrinsics.areEqual(((SaleOnBoardLineItem) obj).getId(), basketLineItem.getId())) {
                            break;
                        }
                    }
                }
                SaleOnBoardLineItem saleOnBoardLineItem = (SaleOnBoardLineItem) obj;
                if (saleOnBoardLineItem != null) {
                    i5 = saleOnBoardLineItem.getQuantity();
                    copy$default = SaleOnBoardCheckoutState.copy$default(saleOnBoardCheckoutState3, null, null, null, null, null, null, null, CollectionsKt.plus((Collection<? extends SaleOnBoardLineItem>) CollectionsKt.minus(saleOnBoardCheckoutState3.getBasketLineItems(), saleOnBoardLineItem), basketLineItem), null, null, null, null, null, null, null, 32639, null);
                } else {
                    copy$default = SaleOnBoardCheckoutState.copy$default(saleOnBoardCheckoutState3, null, null, null, null, null, null, null, CollectionsKt.plus((Collection<? extends SaleOnBoardLineItem>) saleOnBoardCheckoutState3.getBasketLineItems(), basketLineItem), null, null, null, null, null, null, null, 32639, null);
                }
            } while (!saleOnBoardCheckoutState2.compareAndSet(value2, copy$default));
        } else {
            MutableStateFlow<SaleOnBoardCheckoutState> saleOnBoardCheckoutState4 = getSaleOnBoardCheckoutState();
            do {
                value = saleOnBoardCheckoutState4.getValue();
                saleOnBoardCheckoutState = value;
            } while (!saleOnBoardCheckoutState4.compareAndSet(value, SaleOnBoardCheckoutState.copy$default(saleOnBoardCheckoutState, null, null, null, null, null, null, null, CollectionsKt.plus((Collection<? extends SaleOnBoardLineItem>) saleOnBoardCheckoutState.getBasketLineItems(), basketLineItem), null, null, null, null, null, null, null, 32639, null)));
        }
        this.analyticsTracker.trackAddSaleOnBoardProductToCart(this, basketLineItem, i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x01bd A[PHI: r1
      0x01bd: PHI (r1v14 java.lang.Object) = (r1v13 java.lang.Object), (r1v1 java.lang.Object) binds: [B:18:0x01ba, B:11:0x002f] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01bc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    @Override // dk.molslinjen.domain.managers.checkout.ICreateBooking
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object createBooking(float f5, float f6, Continuation<? super ManagerResult<BookingCompleted>> continuation) {
        SaleOnBoardCheckoutManager$createBooking$1 saleOnBoardCheckoutManager$createBooking$1;
        int i5;
        SaleOnBoardCheckoutState value;
        float f7;
        float f8;
        SaleOnBoardCheckoutManager saleOnBoardCheckoutManager;
        ApiResult apiResult;
        SaleOnBoardCheckoutState value2;
        ApiResult.Success success;
        Continuation continuation2;
        ApiResult apiResult2;
        if (continuation instanceof SaleOnBoardCheckoutManager$createBooking$1) {
            saleOnBoardCheckoutManager$createBooking$1 = (SaleOnBoardCheckoutManager$createBooking$1) continuation;
            int i6 = saleOnBoardCheckoutManager$createBooking$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                saleOnBoardCheckoutManager$createBooking$1.label = i6 - Integer.MIN_VALUE;
                Object obj = saleOnBoardCheckoutManager$createBooking$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = saleOnBoardCheckoutManager$createBooking$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    this.paymentManager.restartPaymentFlow();
                    value = getSaleOnBoardCheckoutState().getValue();
                    ISaleOnBoardService iSaleOnBoardService = this.saleOnBoardService;
                    String name = value.getContactInfo().getName();
                    String nationalNumber = value.getContactInfo().getPhoneNumber().getNationalNumber();
                    saleOnBoardCheckoutManager$createBooking$1.L$0 = this;
                    saleOnBoardCheckoutManager$createBooking$1.L$1 = value;
                    saleOnBoardCheckoutManager$createBooking$1.F$0 = f5;
                    saleOnBoardCheckoutManager$createBooking$1.F$1 = f6;
                    saleOnBoardCheckoutManager$createBooking$1.label = 1;
                    obj = iSaleOnBoardService.createOrder(name, nationalNumber, saleOnBoardCheckoutManager$createBooking$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    f7 = f5;
                    f8 = f6;
                    saleOnBoardCheckoutManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 == 3) {
                                ResultKt.throwOnFailure(obj);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        apiResult2 = (ApiResult) saleOnBoardCheckoutManager$createBooking$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        continuation2 = null;
                        SaleOnBoardCheckoutManager$createBooking$3 saleOnBoardCheckoutManager$createBooking$3 = new SaleOnBoardCheckoutManager$createBooking$3(apiResult2, continuation2);
                        saleOnBoardCheckoutManager$createBooking$1.L$0 = continuation2;
                        saleOnBoardCheckoutManager$createBooking$1.label = 3;
                        obj = ApiResultExtensionsKt.mapToManagerResult((ApiResult) obj, saleOnBoardCheckoutManager$createBooking$3, saleOnBoardCheckoutManager$createBooking$1);
                        return obj != coroutine_suspended ? coroutine_suspended : obj;
                    }
                    f8 = saleOnBoardCheckoutManager$createBooking$1.F$1;
                    f7 = saleOnBoardCheckoutManager$createBooking$1.F$0;
                    value = (SaleOnBoardCheckoutState) saleOnBoardCheckoutManager$createBooking$1.L$1;
                    saleOnBoardCheckoutManager = (SaleOnBoardCheckoutManager) saleOnBoardCheckoutManager$createBooking$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                apiResult = (ApiResult) obj;
                if (!(apiResult instanceof ApiResult.Error)) {
                    saleOnBoardCheckoutManager.analyticsTracker.trackEvent(AnalyticsEvent.SaleOnBoardOrderError.INSTANCE);
                    return ManagerResultExtensionsKt.toManagerResult(apiResult);
                }
                if (!(apiResult instanceof ApiResult.Success)) {
                    throw new NoWhenBranchMatchedException();
                }
                MutableStateFlow<SaleOnBoardCheckoutState> saleOnBoardCheckoutState = saleOnBoardCheckoutManager.getSaleOnBoardCheckoutState();
                do {
                    value2 = saleOnBoardCheckoutState.getValue();
                    success = (ApiResult.Success) apiResult;
                } while (!saleOnBoardCheckoutState.compareAndSet(value2, SaleOnBoardCheckoutState.copy$default(value2, null, null, null, null, null, null, null, null, null, null, null, null, null, Boxing.boxInt(((CreateOrderResponseDTO) success.getData()).getOrderId()), null, 24575, null)));
                saleOnBoardCheckoutManager.paymentManager.setPaymentData(String.valueOf(((CreateOrderResponseDTO) success.getData()).getOrderId()), value.getSelectedPaymentType(), BookingProcessingResult.Pay, true);
                IPaymentService iPaymentService = saleOnBoardCheckoutManager.paymentService;
                SiteDTO dto = Site.Mols.toDTO();
                String valueOf = String.valueOf(((CreateOrderResponseDTO) success.getData()).getOrderId());
                int value3 = value.getTotalPrice().getValue();
                CurrencyTypeDTO dto2 = value.getCurrencyType().toDTO();
                CreditCard selectedCreditCard = value.getSelectedCreditCard();
                String creditCardToken = selectedCreditCard != null ? selectedCreditCard.getCreditCardToken() : null;
                PaymentTypeDTO dto3 = value.getSelectedPaymentType().toDTO();
                String str = Intrinsics.areEqual(Locale.getDefault().getLanguage(), "da") ? "da" : "en";
                String paymentCallbackUrl = saleOnBoardCheckoutManager.paymentCallbackUrlProvider.getPaymentCallbackUrl();
                String email = value.getContactInfo().getEmail();
                String language = Locale.getDefault().getLanguage();
                Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
                PaymentServiceAppPaymentRedirectDetailsDTO paymentServiceAppPaymentRedirectDetailsDTO = new PaymentServiceAppPaymentRedirectDetailsDTO(f8, f7, language, IpHelperKt.getIpAddress());
                saleOnBoardCheckoutManager$createBooking$1.L$0 = apiResult;
                saleOnBoardCheckoutManager$createBooking$1.L$1 = null;
                saleOnBoardCheckoutManager$createBooking$1.label = 2;
                continuation2 = null;
                Object saleOnBoardPaymentWindowUrl = iPaymentService.getSaleOnBoardPaymentWindowUrl(dto, valueOf, value3, dto2, creditCardToken, dto3, str, paymentCallbackUrl, email, paymentServiceAppPaymentRedirectDetailsDTO, saleOnBoardCheckoutManager$createBooking$1);
                if (saleOnBoardPaymentWindowUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                apiResult2 = apiResult;
                obj = saleOnBoardPaymentWindowUrl;
                SaleOnBoardCheckoutManager$createBooking$3 saleOnBoardCheckoutManager$createBooking$32 = new SaleOnBoardCheckoutManager$createBooking$3(apiResult2, continuation2);
                saleOnBoardCheckoutManager$createBooking$1.L$0 = continuation2;
                saleOnBoardCheckoutManager$createBooking$1.label = 3;
                obj = ApiResultExtensionsKt.mapToManagerResult((ApiResult) obj, saleOnBoardCheckoutManager$createBooking$32, saleOnBoardCheckoutManager$createBooking$1);
                if (obj != coroutine_suspended) {
                }
            }
        }
        saleOnBoardCheckoutManager$createBooking$1 = new SaleOnBoardCheckoutManager$createBooking$1(this, continuation);
        Object obj2 = saleOnBoardCheckoutManager$createBooking$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = saleOnBoardCheckoutManager$createBooking$1.label;
        if (i5 != 0) {
        }
        apiResult = (ApiResult) obj2;
        if (!(apiResult instanceof ApiResult.Error)) {
        }
    }

    @Override // dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardCheckoutManager
    public SaleOnBoardProduct getProduct(String id) {
        List<SaleOnBoardCategory> categories;
        Object obj;
        Intrinsics.checkNotNullParameter(id, "id");
        SaleOnBoardStore selectedStore = getSaleOnBoardCheckoutState().getValue().getSelectedStore();
        if (selectedStore != null && (categories = selectedStore.getCategories()) != null) {
            Iterator<T> it = categories.iterator();
            while (it.hasNext()) {
                Iterator<T> it2 = ((SaleOnBoardCategory) it.next()).getProducts().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    if (Intrinsics.areEqual(((SaleOnBoardProduct) obj).getId(), id)) {
                        break;
                    }
                }
                SaleOnBoardProduct saleOnBoardProduct = (SaleOnBoardProduct) obj;
                if (saleOnBoardProduct != null) {
                    return saleOnBoardProduct;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0098 A[PHI: r8
      0x0098: PHI (r8v17 java.lang.Object) = (r8v16 java.lang.Object), (r8v1 java.lang.Object) binds: [B:18:0x0095, B:11:0x002c] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0097 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0081 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardCheckoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadShopsAndProducts(Continuation<? super ManagerResult<? extends List<SaleOnBoardStore>>> continuation) {
        SaleOnBoardCheckoutManager$loadShopsAndProducts$1 saleOnBoardCheckoutManager$loadShopsAndProducts$1;
        Object obj;
        Object coroutine_suspended;
        int i5;
        String timeTableId;
        SaleOnBoardCheckoutManager saleOnBoardCheckoutManager;
        if (continuation instanceof SaleOnBoardCheckoutManager$loadShopsAndProducts$1) {
            saleOnBoardCheckoutManager$loadShopsAndProducts$1 = (SaleOnBoardCheckoutManager$loadShopsAndProducts$1) continuation;
            int i6 = saleOnBoardCheckoutManager$loadShopsAndProducts$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                saleOnBoardCheckoutManager$loadShopsAndProducts$1.label = i6 - Integer.MIN_VALUE;
                obj = saleOnBoardCheckoutManager$loadShopsAndProducts$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = saleOnBoardCheckoutManager$loadShopsAndProducts$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IDepartureInfo selectedDeparture = getSaleOnBoardCheckoutState().getValue().getSelectedDeparture();
                    if (selectedDeparture == null || (timeTableId = selectedDeparture.getTimeTableId()) == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    ISaleOnBoardService iSaleOnBoardService = this.saleOnBoardService;
                    saleOnBoardCheckoutManager$loadShopsAndProducts$1.L$0 = this;
                    saleOnBoardCheckoutManager$loadShopsAndProducts$1.label = 1;
                    obj = iSaleOnBoardService.getShopsAndProducts(timeTableId, saleOnBoardCheckoutManager$loadShopsAndProducts$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    saleOnBoardCheckoutManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 == 3) {
                                ResultKt.throwOnFailure(obj);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        saleOnBoardCheckoutManager = (SaleOnBoardCheckoutManager) saleOnBoardCheckoutManager$loadShopsAndProducts$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        ManagerResult managerResult = ManagerResultExtensionsKt.toManagerResult((ApiResult) obj);
                        SaleOnBoardCheckoutManager$loadShopsAndProducts$3 saleOnBoardCheckoutManager$loadShopsAndProducts$3 = new SaleOnBoardCheckoutManager$loadShopsAndProducts$3(saleOnBoardCheckoutManager, null);
                        saleOnBoardCheckoutManager$loadShopsAndProducts$1.L$0 = null;
                        saleOnBoardCheckoutManager$loadShopsAndProducts$1.label = 3;
                        obj = ManagerResultExtensionsKt.onSuccess(managerResult, saleOnBoardCheckoutManager$loadShopsAndProducts$3, saleOnBoardCheckoutManager$loadShopsAndProducts$1);
                        return obj == coroutine_suspended ? coroutine_suspended : obj;
                    }
                    saleOnBoardCheckoutManager = (SaleOnBoardCheckoutManager) saleOnBoardCheckoutManager$loadShopsAndProducts$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                SaleOnBoardCheckoutManager$loadShopsAndProducts$2 saleOnBoardCheckoutManager$loadShopsAndProducts$2 = new SaleOnBoardCheckoutManager$loadShopsAndProducts$2(saleOnBoardCheckoutManager, null);
                saleOnBoardCheckoutManager$loadShopsAndProducts$1.L$0 = saleOnBoardCheckoutManager;
                saleOnBoardCheckoutManager$loadShopsAndProducts$1.label = 2;
                obj = dk.molslinjen.api.extensions.ApiResultExtensionsKt.mapOnSuccess((ApiResult) obj, saleOnBoardCheckoutManager$loadShopsAndProducts$2, saleOnBoardCheckoutManager$loadShopsAndProducts$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ManagerResult managerResult2 = ManagerResultExtensionsKt.toManagerResult((ApiResult) obj);
                SaleOnBoardCheckoutManager$loadShopsAndProducts$3 saleOnBoardCheckoutManager$loadShopsAndProducts$32 = new SaleOnBoardCheckoutManager$loadShopsAndProducts$3(saleOnBoardCheckoutManager, null);
                saleOnBoardCheckoutManager$loadShopsAndProducts$1.L$0 = null;
                saleOnBoardCheckoutManager$loadShopsAndProducts$1.label = 3;
                obj = ManagerResultExtensionsKt.onSuccess(managerResult2, saleOnBoardCheckoutManager$loadShopsAndProducts$32, saleOnBoardCheckoutManager$loadShopsAndProducts$1);
                if (obj == coroutine_suspended) {
                }
            }
        }
        saleOnBoardCheckoutManager$loadShopsAndProducts$1 = new SaleOnBoardCheckoutManager$loadShopsAndProducts$1(this, continuation);
        obj = saleOnBoardCheckoutManager$loadShopsAndProducts$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = saleOnBoardCheckoutManager$loadShopsAndProducts$1.label;
        if (i5 != 0) {
        }
        SaleOnBoardCheckoutManager$loadShopsAndProducts$2 saleOnBoardCheckoutManager$loadShopsAndProducts$22 = new SaleOnBoardCheckoutManager$loadShopsAndProducts$2(saleOnBoardCheckoutManager, null);
        saleOnBoardCheckoutManager$loadShopsAndProducts$1.L$0 = saleOnBoardCheckoutManager;
        saleOnBoardCheckoutManager$loadShopsAndProducts$1.label = 2;
        obj = dk.molslinjen.api.extensions.ApiResultExtensionsKt.mapOnSuccess((ApiResult) obj, saleOnBoardCheckoutManager$loadShopsAndProducts$22, saleOnBoardCheckoutManager$loadShopsAndProducts$1);
        if (obj == coroutine_suspended) {
        }
        ManagerResult managerResult22 = ManagerResultExtensionsKt.toManagerResult((ApiResult) obj);
        SaleOnBoardCheckoutManager$loadShopsAndProducts$3 saleOnBoardCheckoutManager$loadShopsAndProducts$322 = new SaleOnBoardCheckoutManager$loadShopsAndProducts$3(saleOnBoardCheckoutManager, null);
        saleOnBoardCheckoutManager$loadShopsAndProducts$1.L$0 = null;
        saleOnBoardCheckoutManager$loadShopsAndProducts$1.label = 3;
        obj = ManagerResultExtensionsKt.onSuccess(managerResult22, saleOnBoardCheckoutManager$loadShopsAndProducts$322, saleOnBoardCheckoutManager$loadShopsAndProducts$1);
        if (obj == coroutine_suspended) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0098 A[PHI: r8
      0x0098: PHI (r8v17 java.lang.Object) = (r8v16 java.lang.Object), (r8v1 java.lang.Object) binds: [B:18:0x0095, B:11:0x002c] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0097 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0081 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardCheckoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadTimeSlots(Continuation<? super ManagerResult<? extends List<SaleOnBoardStoreTimeSlots>>> continuation) {
        SaleOnBoardCheckoutManager$loadTimeSlots$1 saleOnBoardCheckoutManager$loadTimeSlots$1;
        Object obj;
        Object coroutine_suspended;
        int i5;
        String timeTableId;
        SaleOnBoardCheckoutManager saleOnBoardCheckoutManager;
        if (continuation instanceof SaleOnBoardCheckoutManager$loadTimeSlots$1) {
            saleOnBoardCheckoutManager$loadTimeSlots$1 = (SaleOnBoardCheckoutManager$loadTimeSlots$1) continuation;
            int i6 = saleOnBoardCheckoutManager$loadTimeSlots$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                saleOnBoardCheckoutManager$loadTimeSlots$1.label = i6 - Integer.MIN_VALUE;
                obj = saleOnBoardCheckoutManager$loadTimeSlots$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = saleOnBoardCheckoutManager$loadTimeSlots$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IDepartureInfo selectedDeparture = getSaleOnBoardCheckoutState().getValue().getSelectedDeparture();
                    if (selectedDeparture == null || (timeTableId = selectedDeparture.getTimeTableId()) == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    ISaleOnBoardService iSaleOnBoardService = this.saleOnBoardService;
                    saleOnBoardCheckoutManager$loadTimeSlots$1.L$0 = this;
                    saleOnBoardCheckoutManager$loadTimeSlots$1.label = 1;
                    obj = iSaleOnBoardService.getTimeSlots(timeTableId, saleOnBoardCheckoutManager$loadTimeSlots$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    saleOnBoardCheckoutManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 == 3) {
                                ResultKt.throwOnFailure(obj);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        saleOnBoardCheckoutManager = (SaleOnBoardCheckoutManager) saleOnBoardCheckoutManager$loadTimeSlots$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        ManagerResult managerResult = ManagerResultExtensionsKt.toManagerResult((ApiResult) obj);
                        SaleOnBoardCheckoutManager$loadTimeSlots$3 saleOnBoardCheckoutManager$loadTimeSlots$3 = new SaleOnBoardCheckoutManager$loadTimeSlots$3(saleOnBoardCheckoutManager, null);
                        saleOnBoardCheckoutManager$loadTimeSlots$1.L$0 = null;
                        saleOnBoardCheckoutManager$loadTimeSlots$1.label = 3;
                        obj = ManagerResultExtensionsKt.onSuccess(managerResult, saleOnBoardCheckoutManager$loadTimeSlots$3, saleOnBoardCheckoutManager$loadTimeSlots$1);
                        return obj == coroutine_suspended ? coroutine_suspended : obj;
                    }
                    saleOnBoardCheckoutManager = (SaleOnBoardCheckoutManager) saleOnBoardCheckoutManager$loadTimeSlots$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                SaleOnBoardCheckoutManager$loadTimeSlots$2 saleOnBoardCheckoutManager$loadTimeSlots$2 = new SaleOnBoardCheckoutManager$loadTimeSlots$2(null);
                saleOnBoardCheckoutManager$loadTimeSlots$1.L$0 = saleOnBoardCheckoutManager;
                saleOnBoardCheckoutManager$loadTimeSlots$1.label = 2;
                obj = dk.molslinjen.api.extensions.ApiResultExtensionsKt.mapOnSuccess((ApiResult) obj, saleOnBoardCheckoutManager$loadTimeSlots$2, saleOnBoardCheckoutManager$loadTimeSlots$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ManagerResult managerResult2 = ManagerResultExtensionsKt.toManagerResult((ApiResult) obj);
                SaleOnBoardCheckoutManager$loadTimeSlots$3 saleOnBoardCheckoutManager$loadTimeSlots$32 = new SaleOnBoardCheckoutManager$loadTimeSlots$3(saleOnBoardCheckoutManager, null);
                saleOnBoardCheckoutManager$loadTimeSlots$1.L$0 = null;
                saleOnBoardCheckoutManager$loadTimeSlots$1.label = 3;
                obj = ManagerResultExtensionsKt.onSuccess(managerResult2, saleOnBoardCheckoutManager$loadTimeSlots$32, saleOnBoardCheckoutManager$loadTimeSlots$1);
                if (obj == coroutine_suspended) {
                }
            }
        }
        saleOnBoardCheckoutManager$loadTimeSlots$1 = new SaleOnBoardCheckoutManager$loadTimeSlots$1(this, continuation);
        obj = saleOnBoardCheckoutManager$loadTimeSlots$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = saleOnBoardCheckoutManager$loadTimeSlots$1.label;
        if (i5 != 0) {
        }
        SaleOnBoardCheckoutManager$loadTimeSlots$2 saleOnBoardCheckoutManager$loadTimeSlots$22 = new SaleOnBoardCheckoutManager$loadTimeSlots$2(null);
        saleOnBoardCheckoutManager$loadTimeSlots$1.L$0 = saleOnBoardCheckoutManager;
        saleOnBoardCheckoutManager$loadTimeSlots$1.label = 2;
        obj = dk.molslinjen.api.extensions.ApiResultExtensionsKt.mapOnSuccess((ApiResult) obj, saleOnBoardCheckoutManager$loadTimeSlots$22, saleOnBoardCheckoutManager$loadTimeSlots$1);
        if (obj == coroutine_suspended) {
        }
        ManagerResult managerResult22 = ManagerResultExtensionsKt.toManagerResult((ApiResult) obj);
        SaleOnBoardCheckoutManager$loadTimeSlots$3 saleOnBoardCheckoutManager$loadTimeSlots$322 = new SaleOnBoardCheckoutManager$loadTimeSlots$3(saleOnBoardCheckoutManager, null);
        saleOnBoardCheckoutManager$loadTimeSlots$1.L$0 = null;
        saleOnBoardCheckoutManager$loadTimeSlots$1.label = 3;
        obj = ManagerResultExtensionsKt.onSuccess(managerResult22, saleOnBoardCheckoutManager$loadTimeSlots$322, saleOnBoardCheckoutManager$loadTimeSlots$1);
        if (obj == coroutine_suspended) {
        }
    }

    @Override // dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardCheckoutManager
    public void removeLineItem(String lineItemId) {
        Object obj;
        SaleOnBoardCheckoutState value;
        SaleOnBoardCheckoutState saleOnBoardCheckoutState;
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(lineItemId, "lineItemId");
        Iterator<T> it = getSaleOnBoardCheckoutState().getValue().getBasketLineItems().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((SaleOnBoardLineItem) obj).getId(), lineItemId)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        SaleOnBoardLineItem saleOnBoardLineItem = (SaleOnBoardLineItem) obj;
        if (saleOnBoardLineItem == null) {
            return;
        }
        MutableStateFlow<SaleOnBoardCheckoutState> saleOnBoardCheckoutState2 = getSaleOnBoardCheckoutState();
        do {
            value = saleOnBoardCheckoutState2.getValue();
            saleOnBoardCheckoutState = value;
            List<SaleOnBoardLineItem> basketLineItems = saleOnBoardCheckoutState.getBasketLineItems();
            arrayList = new ArrayList();
            for (Object obj2 : basketLineItems) {
                if (!Intrinsics.areEqual(((SaleOnBoardLineItem) obj2).getId(), lineItemId)) {
                    arrayList.add(obj2);
                }
            }
        } while (!saleOnBoardCheckoutState2.compareAndSet(value, SaleOnBoardCheckoutState.copy$default(saleOnBoardCheckoutState, null, null, null, null, null, null, null, arrayList, null, null, null, null, null, null, null, 32639, null)));
        this.analyticsTracker.trackSaleOnBoardEvent(new SaleOnBoardAnalyticsEvent.RemoveFromCart(getSaleOnBoardCheckoutState().getValue(), saleOnBoardLineItem, saleOnBoardLineItem.getQuantity()));
    }

    @Override // dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardCheckoutManager
    public void selectPaymentMethod(PaymentType paymentType, CreditCard creditCard) {
        SaleOnBoardCheckoutState value;
        Intrinsics.checkNotNullParameter(paymentType, "paymentType");
        MutableStateFlow<SaleOnBoardCheckoutState> saleOnBoardCheckoutState = getSaleOnBoardCheckoutState();
        do {
            value = saleOnBoardCheckoutState.getValue();
        } while (!saleOnBoardCheckoutState.compareAndSet(value, SaleOnBoardCheckoutState.copy$default(value, null, null, null, null, null, null, null, null, paymentType, creditCard, null, null, null, null, null, 31999, null)));
    }

    @Override // dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardCheckoutManager
    public void selectTimeSlot(SaleOnBoardTimeSlot timeSlot) {
        SaleOnBoardCheckoutState value;
        Intrinsics.checkNotNullParameter(timeSlot, "timeSlot");
        MutableStateFlow<SaleOnBoardCheckoutState> saleOnBoardCheckoutState = getSaleOnBoardCheckoutState();
        do {
            value = saleOnBoardCheckoutState.getValue();
        } while (!saleOnBoardCheckoutState.compareAndSet(value, SaleOnBoardCheckoutState.copy$default(value, null, null, null, null, null, null, null, null, null, null, timeSlot, null, null, null, null, 31743, null)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardCheckoutManager
    public void setupWithDeparture(IDepartureInfo departure) {
        Intrinsics.checkNotNullParameter(departure, "departure");
        this.paymentManager.resetPaymentState();
        MutableStateFlow<SaleOnBoardCheckoutState> saleOnBoardCheckoutState = getSaleOnBoardCheckoutState();
        while (true) {
            MutableStateFlow<SaleOnBoardCheckoutState> mutableStateFlow = saleOnBoardCheckoutState;
            if (mutableStateFlow.compareAndSet(saleOnBoardCheckoutState.getValue(), new SaleOnBoardCheckoutState(null, departure, null, null, null, null, null, null, null, null, null, null, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 32765, null))) {
                setDefaultContactInfo();
                return;
            }
            saleOnBoardCheckoutState = mutableStateFlow;
        }
    }

    @Override // dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardCheckoutManager
    public void updateEmail(String email) {
        SaleOnBoardCheckoutState value;
        SaleOnBoardCheckoutState saleOnBoardCheckoutState;
        Intrinsics.checkNotNullParameter(email, "email");
        MutableStateFlow<SaleOnBoardCheckoutState> saleOnBoardCheckoutState2 = getSaleOnBoardCheckoutState();
        do {
            value = saleOnBoardCheckoutState2.getValue();
            saleOnBoardCheckoutState = value;
        } while (!saleOnBoardCheckoutState2.compareAndSet(value, SaleOnBoardCheckoutState.copy$default(saleOnBoardCheckoutState, null, null, null, null, null, null, null, null, null, null, null, SaleOnBoardContactInfo.copy$default(saleOnBoardCheckoutState.getContactInfo(), null, email, null, false, 13, null), null, null, null, 30719, null)));
    }

    @Override // dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardCheckoutManager
    public void updateName(String name) {
        SaleOnBoardCheckoutState value;
        SaleOnBoardCheckoutState saleOnBoardCheckoutState;
        Intrinsics.checkNotNullParameter(name, "name");
        MutableStateFlow<SaleOnBoardCheckoutState> saleOnBoardCheckoutState2 = getSaleOnBoardCheckoutState();
        do {
            value = saleOnBoardCheckoutState2.getValue();
            saleOnBoardCheckoutState = value;
        } while (!saleOnBoardCheckoutState2.compareAndSet(value, SaleOnBoardCheckoutState.copy$default(saleOnBoardCheckoutState, null, null, null, null, null, null, null, null, null, null, null, SaleOnBoardContactInfo.copy$default(saleOnBoardCheckoutState.getContactInfo(), name, null, null, false, 14, null), null, null, null, 30719, null)));
    }

    @Override // dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardCheckoutManager
    public void updateNotificationType(NotificationType notificationType) {
        SaleOnBoardCheckoutState value;
        Intrinsics.checkNotNullParameter(notificationType, "notificationType");
        MutableStateFlow<SaleOnBoardCheckoutState> saleOnBoardCheckoutState = getSaleOnBoardCheckoutState();
        do {
            value = saleOnBoardCheckoutState.getValue();
        } while (!saleOnBoardCheckoutState.compareAndSet(value, SaleOnBoardCheckoutState.copy$default(value, null, null, null, null, null, null, null, null, null, null, null, null, notificationType, null, null, 28671, null)));
    }

    @Override // dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardCheckoutManager
    public void updatePhoneNumber(PhoneNumber phoneNumber) {
        SaleOnBoardCheckoutState value;
        SaleOnBoardCheckoutState saleOnBoardCheckoutState;
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        MutableStateFlow<SaleOnBoardCheckoutState> saleOnBoardCheckoutState2 = getSaleOnBoardCheckoutState();
        do {
            value = saleOnBoardCheckoutState2.getValue();
            saleOnBoardCheckoutState = value;
        } while (!saleOnBoardCheckoutState2.compareAndSet(value, SaleOnBoardCheckoutState.copy$default(saleOnBoardCheckoutState, null, null, null, null, null, null, null, null, null, null, null, SaleOnBoardContactInfo.copy$default(saleOnBoardCheckoutState.getContactInfo(), null, null, phoneNumber, false, 11, null), null, null, null, 30719, null)));
    }

    @Override // dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardCheckoutManager
    public MutableStateFlow<SaleOnBoardCheckoutState> getSaleOnBoardCheckoutState() {
        return this.saleOnBoardCheckoutState;
    }

    @Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b+\b\u0086\b\u0018\u00002\u00020\u0001B»\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\b\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b \u0010!JÄ\u0001\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\b2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010*\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b*\u0010+R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010,\u001a\u0004\b-\u0010.R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010/\u001a\u0004\b0\u00101R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00102\u001a\u0004\b3\u00104R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0006¢\u0006\f\n\u0004\b\t\u00105\u001a\u0004\b6\u00107R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\b8\u0006¢\u0006\f\n\u0004\b\u000b\u00105\u001a\u0004\b8\u00107R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u00109\u001a\u0004\b:\u0010;R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010<\u001a\u0004\b=\u0010>R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\b8\u0006¢\u0006\f\n\u0004\b\u0011\u00105\u001a\u0004\b?\u00107R\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010@\u001a\u0004\bA\u0010BR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010C\u001a\u0004\bD\u0010ER\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010F\u001a\u0004\bG\u0010HR\u0017\u0010\u0019\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010I\u001a\u0004\bJ\u0010KR\u0017\u0010\u001b\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010L\u001a\u0004\bM\u0010NR\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010O\u001a\u0004\bP\u0010QR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010R\u001a\u0004\bS\u0010%¨\u0006T"}, d2 = {"Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/config/Site;", "site", "Ldk/molslinjen/domain/model/booking/IDepartureInfo;", "selectedDeparture", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardStore;", "selectedStore", BuildConfig.FLAVOR, "stores", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardStoreTimeSlots;", "storesWithTimeSlots", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "currencyType", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "totalPrice", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "basketLineItems", "Ldk/molslinjen/domain/model/payment/PaymentType;", "selectedPaymentType", "Ldk/molslinjen/domain/model/account/CreditCard;", "selectedCreditCard", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardTimeSlot;", "selectedTimeSlot", "Ldk/molslinjen/domain/model/booking/SaleOnBoardContactInfo;", "contactInfo", "Ldk/molslinjen/domain/model/saleOnBoard/NotificationType;", "notificationType", BuildConfig.FLAVOR, "preOrderId", BuildConfig.FLAVOR, "orderNumber", "<init>", "(Ldk/molslinjen/domain/model/config/Site;Ldk/molslinjen/domain/model/booking/IDepartureInfo;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardStore;Ljava/util/List;Ljava/util/List;Ldk/molslinjen/domain/model/shared/CurrencyType;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Ljava/util/List;Ldk/molslinjen/domain/model/payment/PaymentType;Ldk/molslinjen/domain/model/account/CreditCard;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardTimeSlot;Ldk/molslinjen/domain/model/booking/SaleOnBoardContactInfo;Ldk/molslinjen/domain/model/saleOnBoard/NotificationType;Ljava/lang/Integer;Ljava/lang/String;)V", "copy", "(Ldk/molslinjen/domain/model/config/Site;Ldk/molslinjen/domain/model/booking/IDepartureInfo;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardStore;Ljava/util/List;Ljava/util/List;Ldk/molslinjen/domain/model/shared/CurrencyType;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Ljava/util/List;Ldk/molslinjen/domain/model/payment/PaymentType;Ldk/molslinjen/domain/model/account/CreditCard;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardTimeSlot;Ldk/molslinjen/domain/model/booking/SaleOnBoardContactInfo;Ldk/molslinjen/domain/model/saleOnBoard/NotificationType;Ljava/lang/Integer;Ljava/lang/String;)Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/config/Site;", "getSite", "()Ldk/molslinjen/domain/model/config/Site;", "Ldk/molslinjen/domain/model/booking/IDepartureInfo;", "getSelectedDeparture", "()Ldk/molslinjen/domain/model/booking/IDepartureInfo;", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardStore;", "getSelectedStore", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardStore;", "Ljava/util/List;", "getStores", "()Ljava/util/List;", "getStoresWithTimeSlots", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "getCurrencyType", "()Ldk/molslinjen/domain/model/shared/CurrencyType;", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "getTotalPrice", "()Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "getBasketLineItems", "Ldk/molslinjen/domain/model/payment/PaymentType;", "getSelectedPaymentType", "()Ldk/molslinjen/domain/model/payment/PaymentType;", "Ldk/molslinjen/domain/model/account/CreditCard;", "getSelectedCreditCard", "()Ldk/molslinjen/domain/model/account/CreditCard;", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardTimeSlot;", "getSelectedTimeSlot", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardTimeSlot;", "Ldk/molslinjen/domain/model/booking/SaleOnBoardContactInfo;", "getContactInfo", "()Ldk/molslinjen/domain/model/booking/SaleOnBoardContactInfo;", "Ldk/molslinjen/domain/model/saleOnBoard/NotificationType;", "getNotificationType", "()Ldk/molslinjen/domain/model/saleOnBoard/NotificationType;", "Ljava/lang/Integer;", "getPreOrderId", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getOrderNumber", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class SaleOnBoardCheckoutState {
        private final List<SaleOnBoardLineItem> basketLineItems;
        private final SaleOnBoardContactInfo contactInfo;
        private final CurrencyType currencyType;
        private final NotificationType notificationType;
        private final String orderNumber;
        private final Integer preOrderId;
        private final CreditCard selectedCreditCard;
        private final IDepartureInfo selectedDeparture;
        private final PaymentType selectedPaymentType;
        private final SaleOnBoardStore selectedStore;
        private final SaleOnBoardTimeSlot selectedTimeSlot;
        private final Site site;
        private final List<SaleOnBoardStore> stores;
        private final List<SaleOnBoardStoreTimeSlots> storesWithTimeSlots;
        private final PriceWithCurrency totalPrice;

        public SaleOnBoardCheckoutState(Site site, IDepartureInfo iDepartureInfo, SaleOnBoardStore saleOnBoardStore, List<SaleOnBoardStore> stores, List<SaleOnBoardStoreTimeSlots> storesWithTimeSlots, CurrencyType currencyType, PriceWithCurrency totalPrice, List<SaleOnBoardLineItem> basketLineItems, PaymentType selectedPaymentType, CreditCard creditCard, SaleOnBoardTimeSlot saleOnBoardTimeSlot, SaleOnBoardContactInfo contactInfo, NotificationType notificationType, Integer num, String str) {
            Intrinsics.checkNotNullParameter(site, "site");
            Intrinsics.checkNotNullParameter(stores, "stores");
            Intrinsics.checkNotNullParameter(storesWithTimeSlots, "storesWithTimeSlots");
            Intrinsics.checkNotNullParameter(currencyType, "currencyType");
            Intrinsics.checkNotNullParameter(totalPrice, "totalPrice");
            Intrinsics.checkNotNullParameter(basketLineItems, "basketLineItems");
            Intrinsics.checkNotNullParameter(selectedPaymentType, "selectedPaymentType");
            Intrinsics.checkNotNullParameter(contactInfo, "contactInfo");
            Intrinsics.checkNotNullParameter(notificationType, "notificationType");
            this.site = site;
            this.selectedDeparture = iDepartureInfo;
            this.selectedStore = saleOnBoardStore;
            this.stores = stores;
            this.storesWithTimeSlots = storesWithTimeSlots;
            this.currencyType = currencyType;
            this.totalPrice = totalPrice;
            this.basketLineItems = basketLineItems;
            this.selectedPaymentType = selectedPaymentType;
            this.selectedCreditCard = creditCard;
            this.selectedTimeSlot = saleOnBoardTimeSlot;
            this.contactInfo = contactInfo;
            this.notificationType = notificationType;
            this.preOrderId = num;
            this.orderNumber = str;
        }

        public static /* synthetic */ SaleOnBoardCheckoutState copy$default(SaleOnBoardCheckoutState saleOnBoardCheckoutState, Site site, IDepartureInfo iDepartureInfo, SaleOnBoardStore saleOnBoardStore, List list, List list2, CurrencyType currencyType, PriceWithCurrency priceWithCurrency, List list3, PaymentType paymentType, CreditCard creditCard, SaleOnBoardTimeSlot saleOnBoardTimeSlot, SaleOnBoardContactInfo saleOnBoardContactInfo, NotificationType notificationType, Integer num, String str, int i5, Object obj) {
            return saleOnBoardCheckoutState.copy((i5 & 1) != 0 ? saleOnBoardCheckoutState.site : site, (i5 & 2) != 0 ? saleOnBoardCheckoutState.selectedDeparture : iDepartureInfo, (i5 & 4) != 0 ? saleOnBoardCheckoutState.selectedStore : saleOnBoardStore, (i5 & 8) != 0 ? saleOnBoardCheckoutState.stores : list, (i5 & 16) != 0 ? saleOnBoardCheckoutState.storesWithTimeSlots : list2, (i5 & 32) != 0 ? saleOnBoardCheckoutState.currencyType : currencyType, (i5 & 64) != 0 ? saleOnBoardCheckoutState.totalPrice : priceWithCurrency, (i5 & 128) != 0 ? saleOnBoardCheckoutState.basketLineItems : list3, (i5 & 256) != 0 ? saleOnBoardCheckoutState.selectedPaymentType : paymentType, (i5 & 512) != 0 ? saleOnBoardCheckoutState.selectedCreditCard : creditCard, (i5 & 1024) != 0 ? saleOnBoardCheckoutState.selectedTimeSlot : saleOnBoardTimeSlot, (i5 & 2048) != 0 ? saleOnBoardCheckoutState.contactInfo : saleOnBoardContactInfo, (i5 & 4096) != 0 ? saleOnBoardCheckoutState.notificationType : notificationType, (i5 & 8192) != 0 ? saleOnBoardCheckoutState.preOrderId : num, (i5 & 16384) != 0 ? saleOnBoardCheckoutState.orderNumber : str);
        }

        public final SaleOnBoardCheckoutState copy(Site site, IDepartureInfo selectedDeparture, SaleOnBoardStore selectedStore, List<SaleOnBoardStore> stores, List<SaleOnBoardStoreTimeSlots> storesWithTimeSlots, CurrencyType currencyType, PriceWithCurrency totalPrice, List<SaleOnBoardLineItem> basketLineItems, PaymentType selectedPaymentType, CreditCard selectedCreditCard, SaleOnBoardTimeSlot selectedTimeSlot, SaleOnBoardContactInfo contactInfo, NotificationType notificationType, Integer preOrderId, String orderNumber) {
            Intrinsics.checkNotNullParameter(site, "site");
            Intrinsics.checkNotNullParameter(stores, "stores");
            Intrinsics.checkNotNullParameter(storesWithTimeSlots, "storesWithTimeSlots");
            Intrinsics.checkNotNullParameter(currencyType, "currencyType");
            Intrinsics.checkNotNullParameter(totalPrice, "totalPrice");
            Intrinsics.checkNotNullParameter(basketLineItems, "basketLineItems");
            Intrinsics.checkNotNullParameter(selectedPaymentType, "selectedPaymentType");
            Intrinsics.checkNotNullParameter(contactInfo, "contactInfo");
            Intrinsics.checkNotNullParameter(notificationType, "notificationType");
            return new SaleOnBoardCheckoutState(site, selectedDeparture, selectedStore, stores, storesWithTimeSlots, currencyType, totalPrice, basketLineItems, selectedPaymentType, selectedCreditCard, selectedTimeSlot, contactInfo, notificationType, preOrderId, orderNumber);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SaleOnBoardCheckoutState)) {
                return false;
            }
            SaleOnBoardCheckoutState saleOnBoardCheckoutState = (SaleOnBoardCheckoutState) other;
            return this.site == saleOnBoardCheckoutState.site && Intrinsics.areEqual(this.selectedDeparture, saleOnBoardCheckoutState.selectedDeparture) && Intrinsics.areEqual(this.selectedStore, saleOnBoardCheckoutState.selectedStore) && Intrinsics.areEqual(this.stores, saleOnBoardCheckoutState.stores) && Intrinsics.areEqual(this.storesWithTimeSlots, saleOnBoardCheckoutState.storesWithTimeSlots) && this.currencyType == saleOnBoardCheckoutState.currencyType && Intrinsics.areEqual(this.totalPrice, saleOnBoardCheckoutState.totalPrice) && Intrinsics.areEqual(this.basketLineItems, saleOnBoardCheckoutState.basketLineItems) && this.selectedPaymentType == saleOnBoardCheckoutState.selectedPaymentType && Intrinsics.areEqual(this.selectedCreditCard, saleOnBoardCheckoutState.selectedCreditCard) && Intrinsics.areEqual(this.selectedTimeSlot, saleOnBoardCheckoutState.selectedTimeSlot) && Intrinsics.areEqual(this.contactInfo, saleOnBoardCheckoutState.contactInfo) && this.notificationType == saleOnBoardCheckoutState.notificationType && Intrinsics.areEqual(this.preOrderId, saleOnBoardCheckoutState.preOrderId) && Intrinsics.areEqual(this.orderNumber, saleOnBoardCheckoutState.orderNumber);
        }

        public final List<SaleOnBoardLineItem> getBasketLineItems() {
            return this.basketLineItems;
        }

        public final SaleOnBoardContactInfo getContactInfo() {
            return this.contactInfo;
        }

        public final CurrencyType getCurrencyType() {
            return this.currencyType;
        }

        public final NotificationType getNotificationType() {
            return this.notificationType;
        }

        public final String getOrderNumber() {
            return this.orderNumber;
        }

        public final Integer getPreOrderId() {
            return this.preOrderId;
        }

        public final CreditCard getSelectedCreditCard() {
            return this.selectedCreditCard;
        }

        public final IDepartureInfo getSelectedDeparture() {
            return this.selectedDeparture;
        }

        public final PaymentType getSelectedPaymentType() {
            return this.selectedPaymentType;
        }

        public final SaleOnBoardStore getSelectedStore() {
            return this.selectedStore;
        }

        public final SaleOnBoardTimeSlot getSelectedTimeSlot() {
            return this.selectedTimeSlot;
        }

        public final Site getSite() {
            return this.site;
        }

        public final List<SaleOnBoardStoreTimeSlots> getStoresWithTimeSlots() {
            return this.storesWithTimeSlots;
        }

        public final PriceWithCurrency getTotalPrice() {
            return this.totalPrice;
        }

        public int hashCode() {
            int hashCode = this.site.hashCode() * 31;
            IDepartureInfo iDepartureInfo = this.selectedDeparture;
            int hashCode2 = (hashCode + (iDepartureInfo == null ? 0 : iDepartureInfo.hashCode())) * 31;
            SaleOnBoardStore saleOnBoardStore = this.selectedStore;
            int hashCode3 = (((((((((((((hashCode2 + (saleOnBoardStore == null ? 0 : saleOnBoardStore.hashCode())) * 31) + this.stores.hashCode()) * 31) + this.storesWithTimeSlots.hashCode()) * 31) + this.currencyType.hashCode()) * 31) + this.totalPrice.hashCode()) * 31) + this.basketLineItems.hashCode()) * 31) + this.selectedPaymentType.hashCode()) * 31;
            CreditCard creditCard = this.selectedCreditCard;
            int hashCode4 = (hashCode3 + (creditCard == null ? 0 : creditCard.hashCode())) * 31;
            SaleOnBoardTimeSlot saleOnBoardTimeSlot = this.selectedTimeSlot;
            int hashCode5 = (((((hashCode4 + (saleOnBoardTimeSlot == null ? 0 : saleOnBoardTimeSlot.hashCode())) * 31) + this.contactInfo.hashCode()) * 31) + this.notificationType.hashCode()) * 31;
            Integer num = this.preOrderId;
            int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
            String str = this.orderNumber;
            return hashCode6 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "SaleOnBoardCheckoutState(site=" + this.site + ", selectedDeparture=" + this.selectedDeparture + ", selectedStore=" + this.selectedStore + ", stores=" + this.stores + ", storesWithTimeSlots=" + this.storesWithTimeSlots + ", currencyType=" + this.currencyType + ", totalPrice=" + this.totalPrice + ", basketLineItems=" + this.basketLineItems + ", selectedPaymentType=" + this.selectedPaymentType + ", selectedCreditCard=" + this.selectedCreditCard + ", selectedTimeSlot=" + this.selectedTimeSlot + ", contactInfo=" + this.contactInfo + ", notificationType=" + this.notificationType + ", preOrderId=" + this.preOrderId + ", orderNumber=" + this.orderNumber + ")";
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ SaleOnBoardCheckoutState(Site site, IDepartureInfo iDepartureInfo, SaleOnBoardStore saleOnBoardStore, List list, List list2, CurrencyType currencyType, PriceWithCurrency priceWithCurrency, List list3, PaymentType paymentType, CreditCard creditCard, SaleOnBoardTimeSlot saleOnBoardTimeSlot, SaleOnBoardContactInfo saleOnBoardContactInfo, NotificationType notificationType, Integer num, String str, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(r1, r2, r4, r5, r6, r7, (i5 & 64) != 0 ? new PriceWithCurrency(0, r7) : priceWithCurrency, (i5 & 128) != 0 ? CollectionsKt.emptyList() : list3, (i5 & 256) != 0 ? PaymentType.Card : paymentType, (i5 & 512) != 0 ? null : creditCard, (i5 & 1024) != 0 ? null : saleOnBoardTimeSlot, (i5 & 2048) != 0 ? new SaleOnBoardContactInfo(BuildConfig.FLAVOR, BuildConfig.FLAVOR, PhoneNumber.Companion.default$default(PhoneNumber.INSTANCE, null, 1, null), false) : saleOnBoardContactInfo, (i5 & 4096) != 0 ? NotificationType.Sms : notificationType, (i5 & 8192) != 0 ? null : num, (i5 & 16384) != 0 ? null : str);
            Site site2 = (i5 & 1) != 0 ? Site.Mols : site;
            IDepartureInfo iDepartureInfo2 = (i5 & 2) != 0 ? null : iDepartureInfo;
            SaleOnBoardStore saleOnBoardStore2 = (i5 & 4) != 0 ? null : saleOnBoardStore;
            List emptyList = (i5 & 8) != 0 ? CollectionsKt.emptyList() : list;
            List emptyList2 = (i5 & 16) != 0 ? CollectionsKt.emptyList() : list2;
            CurrencyType currencyType2 = (i5 & 32) != 0 ? CurrencyType.DKK : currencyType;
        }
    }
}
