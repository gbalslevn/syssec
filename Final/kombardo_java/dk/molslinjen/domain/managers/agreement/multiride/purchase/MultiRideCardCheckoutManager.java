package dk.molslinjen.domain.managers.agreement.multiride.purchase;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.multiRide.IMultiRideService;
import dk.molslinjen.api.services.multiRide.response.MultiRideCardSummaryResponseDTO;
import dk.molslinjen.api.services.multiRide.response.MultiRidePurchaseInfoResponseDTO;
import dk.molslinjen.api.services.multiRide.response.MultiRidePurchaseInfosResponseDTO;
import dk.molslinjen.api.services.paymentTypes.response.PaymentTypeDTO;
import dk.molslinjen.api.shared.response.CurrencyTypeDTO;
import dk.molslinjen.api.shared.response.PhoneNumberDTO;
import dk.molslinjen.domain.analytics.AnalyticsStateTrackingHelper;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.extensions.ApiResultExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.agreement.multiride.IMultiRideManager;
import dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager;
import dk.molslinjen.domain.managers.agreement.multiride.purchase.IMultiRideCardCheckoutManager;
import dk.molslinjen.domain.managers.checkout.ICurrencyManager;
import dk.molslinjen.domain.managers.checkout.IPaymentManager;
import dk.molslinjen.domain.managers.site.ISiteManager;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.account.CreditCard;
import dk.molslinjen.domain.model.account.user.UserContactDetails;
import dk.molslinjen.domain.model.account.user.UserInfo;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCard;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCardSummaryInfo;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRidePriceStep;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRidePurchaseInfo;
import dk.molslinjen.domain.model.booking.BookingCompleted;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.CheckoutContactInfo;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.payment.PaymentOrigin;
import dk.molslinjen.domain.model.payment.PaymentType;
import dk.molslinjen.domain.model.settings.ISettings;
import dk.molslinjen.domain.model.shared.CurrencyType;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.domain.model.site.SiteInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001BI\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J.\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#H\u0096@¢\u0006\u0002\u0010$J\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0096@¢\u0006\u0002\u0010&J\u001e\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\b\u0010(\u001a\u0004\u0018\u00010!H\u0082@¢\u0006\u0002\u0010)J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020\u001dH\u0002J&\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u00100\u001a\u0004\u0018\u00010!H\u0082@¢\u0006\u0002\u00101J\b\u00102\u001a\u00020\u001dH\u0002J\u0010\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020\u001d2\u0006\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u00020\u001d2\u0006\u0010=\u001a\u00020>H\u0016J\u0010\u0010?\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020!H\u0016J\u0010\u0010A\u001a\u00020\u001d2\u0006\u0010B\u001a\u00020!H\u0016J\u001a\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J$\u0010H\u001a\b\u0012\u0004\u0012\u00020I0\u001c2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020KH\u0096@¢\u0006\u0002\u0010MR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006N"}, d2 = {"Ldk/molslinjen/domain/managers/agreement/multiride/purchase/MultiRideCardCheckoutManager;", "Ldk/molslinjen/domain/managers/agreement/multiride/purchase/IMultiRideCardCheckoutManager;", "multiRideService", "Ldk/molslinjen/api/services/multiRide/IMultiRideService;", "paymentManager", "Ldk/molslinjen/domain/managers/checkout/IPaymentManager;", "multiRideManager", "Ldk/molslinjen/domain/managers/agreement/multiride/IMultiRideManager;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "siteManager", "Ldk/molslinjen/domain/managers/site/ISiteManager;", "currencyManager", "Ldk/molslinjen/domain/managers/checkout/ICurrencyManager;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "settings", "Ldk/molslinjen/domain/model/settings/ISettings;", "<init>", "(Ldk/molslinjen/api/services/multiRide/IMultiRideService;Ldk/molslinjen/domain/managers/checkout/IPaymentManager;Ldk/molslinjen/domain/managers/agreement/multiride/IMultiRideManager;Ldk/molslinjen/domain/managers/user/IUserManager;Ldk/molslinjen/domain/managers/site/ISiteManager;Ldk/molslinjen/domain/managers/checkout/ICurrencyManager;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;Ldk/molslinjen/domain/model/settings/ISettings;)V", "localScope", "Lkotlinx/coroutines/CoroutineScope;", "checkoutState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/managers/agreement/multiride/purchase/IMultiRideCardCheckoutManager$CheckoutState;", "getCheckoutState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "setup", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "site", "Ldk/molslinjen/domain/model/config/Site;", "multiRideIdToRefill", BuildConfig.FLAVOR, "flowOrigin", "Ldk/molslinjen/domain/model/payment/PaymentOrigin;", "(Ldk/molslinjen/domain/model/config/Site;Ljava/lang/String;Ldk/molslinjen/domain/model/payment/PaymentOrigin;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadSummaryInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadReceiptInfo", "reservationNumber", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSummaryInfo", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCardSummaryInfo;", "summaryDto", "Ldk/molslinjen/api/services/multiRide/response/MultiRideCardSummaryResponseDTO;", "setupTotalPriceUpdater", "loadPurchaseInfo", "multiRideTypeId", "(Ldk/molslinjen/domain/model/config/Site;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listenForPaymentSuccess", "updateSelectedPurchaseInfo", "purchaseInfo", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePurchaseInfo;", "updateSelectedPriceStep", "priceStep", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePriceStep;", "updateChargeCount", "chargeCount", BuildConfig.FLAVOR, "updatePhoneNumber", "phoneNumber", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "updateEmail", "email", "updatePostalCode", "postalCode", "selectPaymentMethod", "paymentType", "Ldk/molslinjen/domain/model/payment/PaymentType;", "creditCard", "Ldk/molslinjen/domain/model/account/CreditCard;", "createBooking", "Ldk/molslinjen/domain/model/booking/BookingCompleted;", "screenWidth", BuildConfig.FLAVOR, "screenHeight", "(FFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MultiRideCardCheckoutManager implements IMultiRideCardCheckoutManager {
    private final IAnalyticsTracker analyticsTracker;
    private final MutableStateFlow<IMultiRideCardCheckoutManager.CheckoutState> checkoutState;
    private final ICurrencyManager currencyManager;
    private final CoroutineScope localScope;
    private final IMultiRideManager multiRideManager;
    private final IMultiRideService multiRideService;
    private final IPaymentManager paymentManager;
    private final ISettings settings;
    private final ISiteManager siteManager;
    private final IUserManager userManager;

    public MultiRideCardCheckoutManager(IMultiRideService multiRideService, IPaymentManager paymentManager, IMultiRideManager multiRideManager, IUserManager userManager, ISiteManager siteManager, ICurrencyManager currencyManager, IAnalyticsTracker analyticsTracker, ISettings settings) {
        Intrinsics.checkNotNullParameter(multiRideService, "multiRideService");
        Intrinsics.checkNotNullParameter(paymentManager, "paymentManager");
        Intrinsics.checkNotNullParameter(multiRideManager, "multiRideManager");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(siteManager, "siteManager");
        Intrinsics.checkNotNullParameter(currencyManager, "currencyManager");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.multiRideService = multiRideService;
        this.paymentManager = paymentManager;
        this.multiRideManager = multiRideManager;
        this.userManager = userManager;
        this.siteManager = siteManager;
        this.currencyManager = currencyManager;
        this.analyticsTracker = analyticsTracker;
        this.settings = settings;
        this.localScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        UserInfo details = userManager.getCurrentUserState().getValue().getUser().getDetails();
        this.checkoutState = StateFlowKt.MutableStateFlow(new IMultiRideCardCheckoutManager.CheckoutState(null, null, null, null, null, 0, null, null, new CheckoutContactInfo(details != null ? details.getContactDetails() : null), null, null, null, 3839, null));
        setupTotalPriceUpdater();
        listenForPaymentSuccess();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MultiRideCardSummaryInfo createSummaryInfo(MultiRideCardSummaryResponseDTO summaryDto) {
        MultiRideCard multiRideCardToRefill = getCheckoutState().getValue().getMultiRideCardToRefill();
        String cardNumber = summaryDto.getCardNumber();
        if (cardNumber == null) {
            cardNumber = multiRideCardToRefill != null ? multiRideCardToRefill.getId() : null;
        }
        return new MultiRideCardSummaryInfo(summaryDto, cardNumber, multiRideCardToRefill != null ? multiRideCardToRefill.isExpired() ? 0 : Integer.valueOf(multiRideCardToRefill.getRemainingCharges()) : null);
    }

    private final void listenForPaymentSuccess() {
        BuildersKt__Builders_commonKt.launch$default(this.localScope, null, null, new MultiRideCardCheckoutManager$listenForPaymentSuccess$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadPurchaseInfo(Site site, String str, Continuation<? super ManagerResult<Unit>> continuation) {
        MultiRideCardCheckoutManager$loadPurchaseInfo$1 multiRideCardCheckoutManager$loadPurchaseInfo$1;
        Object obj;
        Object coroutine_suspended;
        int i5;
        SiteDTO dto;
        String str2;
        MultiRideCardCheckoutManager multiRideCardCheckoutManager;
        IMultiRideService iMultiRideService;
        String str3;
        MultiRideCardCheckoutManager multiRideCardCheckoutManager2;
        ApiResult apiResult;
        IMultiRideCardCheckoutManager.CheckoutState copy;
        if (continuation instanceof MultiRideCardCheckoutManager$loadPurchaseInfo$1) {
            multiRideCardCheckoutManager$loadPurchaseInfo$1 = (MultiRideCardCheckoutManager$loadPurchaseInfo$1) continuation;
            int i6 = multiRideCardCheckoutManager$loadPurchaseInfo$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                multiRideCardCheckoutManager$loadPurchaseInfo$1.label = i6 - Integer.MIN_VALUE;
                obj = multiRideCardCheckoutManager$loadPurchaseInfo$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = multiRideCardCheckoutManager$loadPurchaseInfo$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IMultiRideService iMultiRideService2 = this.multiRideService;
                    dto = site.toDTO();
                    ICurrencyManager iCurrencyManager = this.currencyManager;
                    multiRideCardCheckoutManager$loadPurchaseInfo$1.L$0 = this;
                    multiRideCardCheckoutManager$loadPurchaseInfo$1.L$1 = str;
                    multiRideCardCheckoutManager$loadPurchaseInfo$1.L$2 = iMultiRideService2;
                    multiRideCardCheckoutManager$loadPurchaseInfo$1.L$3 = dto;
                    multiRideCardCheckoutManager$loadPurchaseInfo$1.label = 1;
                    Object selectedCurrency = iCurrencyManager.getSelectedCurrency(site, multiRideCardCheckoutManager$loadPurchaseInfo$1);
                    if (selectedCurrency == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str2 = str;
                    multiRideCardCheckoutManager = this;
                    iMultiRideService = iMultiRideService2;
                    obj = selectedCurrency;
                } else if (i5 == 1) {
                    dto = (SiteDTO) multiRideCardCheckoutManager$loadPurchaseInfo$1.L$3;
                    iMultiRideService = (IMultiRideService) multiRideCardCheckoutManager$loadPurchaseInfo$1.L$2;
                    str2 = (String) multiRideCardCheckoutManager$loadPurchaseInfo$1.L$1;
                    multiRideCardCheckoutManager = (MultiRideCardCheckoutManager) multiRideCardCheckoutManager$loadPurchaseInfo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i5 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str3 = (String) multiRideCardCheckoutManager$loadPurchaseInfo$1.L$1;
                    multiRideCardCheckoutManager2 = (MultiRideCardCheckoutManager) multiRideCardCheckoutManager$loadPurchaseInfo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    apiResult = (ApiResult) obj;
                    if (!(apiResult instanceof ApiResult.Error)) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    if (!(apiResult instanceof ApiResult.Success)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    List<MultiRidePurchaseInfoResponseDTO> multiRideTickets = ((MultiRidePurchaseInfosResponseDTO) ((ApiResult.Success) apiResult).getData()).getMultiRideTickets();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : multiRideTickets) {
                        MultiRidePurchaseInfoResponseDTO multiRidePurchaseInfoResponseDTO = (MultiRidePurchaseInfoResponseDTO) obj2;
                        if (str3 == null || Intrinsics.areEqual(multiRidePurchaseInfoResponseDTO.getId(), str3)) {
                            arrayList.add(obj2);
                        }
                    }
                    List reversed = CollectionsKt.reversed(arrayList);
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(reversed, 10));
                    Iterator it = reversed.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(new MultiRidePurchaseInfo((MultiRidePurchaseInfoResponseDTO) it.next()));
                    }
                    MutableStateFlow<IMultiRideCardCheckoutManager.CheckoutState> checkoutState = multiRideCardCheckoutManager2.getCheckoutState();
                    while (true) {
                        IMultiRideCardCheckoutManager.CheckoutState value = checkoutState.getValue();
                        IMultiRideCardCheckoutManager.CheckoutState checkoutState2 = value;
                        MultiRidePurchaseInfo selectedPurchaseInfo = checkoutState2.getSelectedPurchaseInfo();
                        if (selectedPurchaseInfo == null) {
                            selectedPurchaseInfo = (MultiRidePurchaseInfo) CollectionsKt.firstOrNull((List) arrayList2);
                        }
                        ArrayList arrayList3 = arrayList2;
                        copy = checkoutState2.copy((r26 & 1) != 0 ? checkoutState2.flowOrigin : null, (r26 & 2) != 0 ? checkoutState2.siteInfo : null, (r26 & 4) != 0 ? checkoutState2.multiRideCardToRefill : null, (r26 & 8) != 0 ? checkoutState2.purchaseInfos : arrayList2, (r26 & 16) != 0 ? checkoutState2.selectedPurchaseInfo : selectedPurchaseInfo, (r26 & 32) != 0 ? checkoutState2.numberOfCharges : 0, (r26 & 64) != 0 ? checkoutState2.selectedPriceStep : null, (r26 & 128) != 0 ? checkoutState2.totalPrice : null, (r26 & 256) != 0 ? checkoutState2.personalInfo : null, (r26 & 512) != 0 ? checkoutState2.selectedPaymentType : null, (r26 & 1024) != 0 ? checkoutState2.selectedCreditCard : null, (r26 & 2048) != 0 ? checkoutState2.summaryCardInfo : null);
                        if (checkoutState.compareAndSet(value, copy)) {
                            return new ManagerResult.Success(Unit.INSTANCE);
                        }
                        arrayList2 = arrayList3;
                    }
                }
                CurrencyTypeDTO dto2 = ((CurrencyType) obj).toDTO();
                multiRideCardCheckoutManager$loadPurchaseInfo$1.L$0 = multiRideCardCheckoutManager;
                multiRideCardCheckoutManager$loadPurchaseInfo$1.L$1 = str2;
                multiRideCardCheckoutManager$loadPurchaseInfo$1.L$2 = null;
                multiRideCardCheckoutManager$loadPurchaseInfo$1.L$3 = null;
                multiRideCardCheckoutManager$loadPurchaseInfo$1.label = 2;
                obj = iMultiRideService.getCardPurchasesInfo(dto, dto2, multiRideCardCheckoutManager$loadPurchaseInfo$1);
                if (obj != coroutine_suspended) {
                    return coroutine_suspended;
                }
                str3 = str2;
                multiRideCardCheckoutManager2 = multiRideCardCheckoutManager;
                apiResult = (ApiResult) obj;
                if (!(apiResult instanceof ApiResult.Error)) {
                }
            }
        }
        multiRideCardCheckoutManager$loadPurchaseInfo$1 = new MultiRideCardCheckoutManager$loadPurchaseInfo$1(this, continuation);
        obj = multiRideCardCheckoutManager$loadPurchaseInfo$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = multiRideCardCheckoutManager$loadPurchaseInfo$1.label;
        if (i5 != 0) {
        }
        CurrencyTypeDTO dto22 = ((CurrencyType) obj).toDTO();
        multiRideCardCheckoutManager$loadPurchaseInfo$1.L$0 = multiRideCardCheckoutManager;
        multiRideCardCheckoutManager$loadPurchaseInfo$1.L$1 = str2;
        multiRideCardCheckoutManager$loadPurchaseInfo$1.L$2 = null;
        multiRideCardCheckoutManager$loadPurchaseInfo$1.L$3 = null;
        multiRideCardCheckoutManager$loadPurchaseInfo$1.label = 2;
        obj = iMultiRideService.getCardPurchasesInfo(dto, dto22, multiRideCardCheckoutManager$loadPurchaseInfo$1);
        if (obj != coroutine_suspended) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00a0 A[PHI: r10
      0x00a0: PHI (r10v7 java.lang.Object) = (r10v6 java.lang.Object), (r10v1 java.lang.Object) binds: [B:18:0x009d, B:11:0x002c] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0093 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadReceiptInfo(String str, Continuation<? super ManagerResult<Unit>> continuation) {
        MultiRideCardCheckoutManager$loadReceiptInfo$1 multiRideCardCheckoutManager$loadReceiptInfo$1;
        Object coroutine_suspended;
        int i5;
        MultiRideCardCheckoutManager multiRideCardCheckoutManager;
        ApiResult apiResult;
        MultiRideCardCheckoutManager$loadReceiptInfo$2 multiRideCardCheckoutManager$loadReceiptInfo$2;
        ApiResult apiResult2;
        if (continuation instanceof MultiRideCardCheckoutManager$loadReceiptInfo$1) {
            multiRideCardCheckoutManager$loadReceiptInfo$1 = (MultiRideCardCheckoutManager$loadReceiptInfo$1) continuation;
            int i6 = multiRideCardCheckoutManager$loadReceiptInfo$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                multiRideCardCheckoutManager$loadReceiptInfo$1.label = i6 - Integer.MIN_VALUE;
                Object obj = multiRideCardCheckoutManager$loadReceiptInfo$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = multiRideCardCheckoutManager$loadReceiptInfo$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (str == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    IMultiRideService iMultiRideService = this.multiRideService;
                    PhoneNumberDTO dto = getCheckoutState().getValue().getPersonalInfo().getPhoneNumber().toDto();
                    SiteDTO dto2 = MultiRideManager.INSTANCE.getForceMolsSite().toDTO();
                    multiRideCardCheckoutManager$loadReceiptInfo$1.L$0 = this;
                    multiRideCardCheckoutManager$loadReceiptInfo$1.label = 1;
                    obj = iMultiRideService.getReceipt(str, dto, dto2, multiRideCardCheckoutManager$loadReceiptInfo$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    multiRideCardCheckoutManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 == 3) {
                                ResultKt.throwOnFailure(obj);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        apiResult2 = (ApiResult) multiRideCardCheckoutManager$loadReceiptInfo$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        multiRideCardCheckoutManager$loadReceiptInfo$1.L$0 = null;
                        multiRideCardCheckoutManager$loadReceiptInfo$1.label = 3;
                        obj = ApiResultExtensionsKt.toUnitManagerResult(apiResult2, multiRideCardCheckoutManager$loadReceiptInfo$1);
                        return obj != coroutine_suspended ? coroutine_suspended : obj;
                    }
                    multiRideCardCheckoutManager = (MultiRideCardCheckoutManager) multiRideCardCheckoutManager$loadReceiptInfo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                apiResult = (ApiResult) obj;
                multiRideCardCheckoutManager$loadReceiptInfo$2 = new MultiRideCardCheckoutManager$loadReceiptInfo$2(multiRideCardCheckoutManager, null);
                multiRideCardCheckoutManager$loadReceiptInfo$1.L$0 = apiResult;
                multiRideCardCheckoutManager$loadReceiptInfo$1.label = 2;
                if (dk.molslinjen.api.extensions.ApiResultExtensionsKt.onSuccess(apiResult, multiRideCardCheckoutManager$loadReceiptInfo$2, multiRideCardCheckoutManager$loadReceiptInfo$1) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                apiResult2 = apiResult;
                multiRideCardCheckoutManager$loadReceiptInfo$1.L$0 = null;
                multiRideCardCheckoutManager$loadReceiptInfo$1.label = 3;
                obj = ApiResultExtensionsKt.toUnitManagerResult(apiResult2, multiRideCardCheckoutManager$loadReceiptInfo$1);
                if (obj != coroutine_suspended) {
                }
            }
        }
        multiRideCardCheckoutManager$loadReceiptInfo$1 = new MultiRideCardCheckoutManager$loadReceiptInfo$1(this, continuation);
        Object obj2 = multiRideCardCheckoutManager$loadReceiptInfo$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = multiRideCardCheckoutManager$loadReceiptInfo$1.label;
        if (i5 != 0) {
        }
        apiResult = (ApiResult) obj2;
        multiRideCardCheckoutManager$loadReceiptInfo$2 = new MultiRideCardCheckoutManager$loadReceiptInfo$2(multiRideCardCheckoutManager, null);
        multiRideCardCheckoutManager$loadReceiptInfo$1.L$0 = apiResult;
        multiRideCardCheckoutManager$loadReceiptInfo$1.label = 2;
        if (dk.molslinjen.api.extensions.ApiResultExtensionsKt.onSuccess(apiResult, multiRideCardCheckoutManager$loadReceiptInfo$2, multiRideCardCheckoutManager$loadReceiptInfo$1) != coroutine_suspended) {
        }
    }

    private final void setupTotalPriceUpdater() {
        BuildersKt__Builders_commonKt.launch$default(this.localScope, null, null, new MultiRideCardCheckoutManager$setupTotalPriceUpdater$1(this, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x017a A[PHI: r1
      0x017a: PHI (r1v14 java.lang.Object) = (r1v13 java.lang.Object), (r1v1 java.lang.Object) binds: [B:19:0x0177, B:12:0x0033] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0179 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0167 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x014a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    @Override // dk.molslinjen.domain.managers.checkout.ICreateBooking
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object createBooking(float f5, float f6, Continuation<? super ManagerResult<BookingCompleted>> continuation) {
        MultiRideCardCheckoutManager$createBooking$1 multiRideCardCheckoutManager$createBooking$1;
        int i5;
        IMultiRideCardCheckoutManager.CheckoutState value;
        Site site;
        MultiRidePurchaseInfo selectedPurchaseInfo;
        CheckoutContactInfo personalInfo;
        float f7;
        float f8;
        MultiRideCardCheckoutManager multiRideCardCheckoutManager;
        Object obj;
        Object purchaseOrRefillMultiRide;
        MultiRideCardCheckoutManager multiRideCardCheckoutManager2;
        IMultiRideCardCheckoutManager.CheckoutState checkoutState;
        ApiResult apiResult;
        MultiRideCardCheckoutManager$createBooking$2 multiRideCardCheckoutManager$createBooking$2;
        Continuation continuation2;
        ApiResult apiResult2;
        if (continuation instanceof MultiRideCardCheckoutManager$createBooking$1) {
            multiRideCardCheckoutManager$createBooking$1 = (MultiRideCardCheckoutManager$createBooking$1) continuation;
            int i6 = multiRideCardCheckoutManager$createBooking$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                multiRideCardCheckoutManager$createBooking$1.label = i6 - Integer.MIN_VALUE;
                Object obj2 = multiRideCardCheckoutManager$createBooking$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = multiRideCardCheckoutManager$createBooking$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    this.paymentManager.restartPaymentFlow();
                    value = getCheckoutState().getValue();
                    SiteInfo siteInfo = value.getSiteInfo();
                    if (siteInfo == null || (site = siteInfo.getSite()) == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    selectedPurchaseInfo = value.getSelectedPurchaseInfo();
                    if (selectedPurchaseInfo == null) {
                        return ManagerResult.Error.INSTANCE.noMessage();
                    }
                    personalInfo = value.getPersonalInfo();
                    IUserManager iUserManager = this.userManager;
                    UserContactDetails userContactDetails = personalInfo.toUserContactDetails();
                    multiRideCardCheckoutManager$createBooking$1.L$0 = this;
                    multiRideCardCheckoutManager$createBooking$1.L$1 = value;
                    multiRideCardCheckoutManager$createBooking$1.L$2 = site;
                    multiRideCardCheckoutManager$createBooking$1.L$3 = selectedPurchaseInfo;
                    multiRideCardCheckoutManager$createBooking$1.L$4 = personalInfo;
                    multiRideCardCheckoutManager$createBooking$1.F$0 = f5;
                    multiRideCardCheckoutManager$createBooking$1.F$1 = f6;
                    multiRideCardCheckoutManager$createBooking$1.label = 1;
                    if (iUserManager.updateLocalUser(userContactDetails, multiRideCardCheckoutManager$createBooking$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    f7 = f5;
                    f8 = f6;
                    multiRideCardCheckoutManager = this;
                } else if (i5 == 1) {
                    float f9 = multiRideCardCheckoutManager$createBooking$1.F$1;
                    float f10 = multiRideCardCheckoutManager$createBooking$1.F$0;
                    personalInfo = (CheckoutContactInfo) multiRideCardCheckoutManager$createBooking$1.L$4;
                    selectedPurchaseInfo = (MultiRidePurchaseInfo) multiRideCardCheckoutManager$createBooking$1.L$3;
                    site = (Site) multiRideCardCheckoutManager$createBooking$1.L$2;
                    IMultiRideCardCheckoutManager.CheckoutState checkoutState2 = (IMultiRideCardCheckoutManager.CheckoutState) multiRideCardCheckoutManager$createBooking$1.L$1;
                    MultiRideCardCheckoutManager multiRideCardCheckoutManager3 = (MultiRideCardCheckoutManager) multiRideCardCheckoutManager$createBooking$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    f8 = f9;
                    f7 = f10;
                    value = checkoutState2;
                    multiRideCardCheckoutManager = multiRideCardCheckoutManager3;
                } else {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (i5 == 4) {
                                ResultKt.throwOnFailure(obj2);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        apiResult2 = (ApiResult) multiRideCardCheckoutManager$createBooking$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        continuation2 = null;
                        obj = coroutine_suspended;
                        MultiRideCardCheckoutManager$createBooking$3 multiRideCardCheckoutManager$createBooking$3 = new MultiRideCardCheckoutManager$createBooking$3(continuation2);
                        multiRideCardCheckoutManager$createBooking$1.L$0 = continuation2;
                        multiRideCardCheckoutManager$createBooking$1.label = 4;
                        obj2 = ApiResultExtensionsKt.mapToManagerResult(apiResult2, multiRideCardCheckoutManager$createBooking$3, multiRideCardCheckoutManager$createBooking$1);
                        return obj2 != obj ? obj : obj2;
                    }
                    checkoutState = (IMultiRideCardCheckoutManager.CheckoutState) multiRideCardCheckoutManager$createBooking$1.L$1;
                    multiRideCardCheckoutManager2 = (MultiRideCardCheckoutManager) multiRideCardCheckoutManager$createBooking$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    obj = coroutine_suspended;
                    apiResult = (ApiResult) obj2;
                    continuation2 = null;
                    multiRideCardCheckoutManager$createBooking$2 = new MultiRideCardCheckoutManager$createBooking$2(multiRideCardCheckoutManager2, checkoutState, null);
                    multiRideCardCheckoutManager$createBooking$1.L$0 = apiResult;
                    multiRideCardCheckoutManager$createBooking$1.L$1 = null;
                    multiRideCardCheckoutManager$createBooking$1.label = 3;
                    if (dk.molslinjen.api.extensions.ApiResultExtensionsKt.onSuccess(apiResult, multiRideCardCheckoutManager$createBooking$2, multiRideCardCheckoutManager$createBooking$1) != obj) {
                        return obj;
                    }
                    apiResult2 = apiResult;
                    MultiRideCardCheckoutManager$createBooking$3 multiRideCardCheckoutManager$createBooking$32 = new MultiRideCardCheckoutManager$createBooking$3(continuation2);
                    multiRideCardCheckoutManager$createBooking$1.L$0 = continuation2;
                    multiRideCardCheckoutManager$createBooking$1.label = 4;
                    obj2 = ApiResultExtensionsKt.mapToManagerResult(apiResult2, multiRideCardCheckoutManager$createBooking$32, multiRideCardCheckoutManager$createBooking$1);
                    if (obj2 != obj) {
                    }
                }
                IMultiRideService iMultiRideService = multiRideCardCheckoutManager.multiRideService;
                String multiRideTypeId = selectedPurchaseInfo.getMultiRideTypeId();
                String email = personalInfo.getEmail();
                int numberOfCharges = value.getNumberOfCharges();
                PaymentTypeDTO dto = value.getSelectedPaymentType().toDTO();
                String nationalNumber = personalInfo.getPhoneNumber().getNationalNumber();
                String countryCode = personalInfo.getPhoneNumber().getCountryCode();
                String postalCode = personalInfo.getPostalCode();
                SiteDTO dto2 = site.toDTO();
                CreditCard selectedCreditCard = value.getSelectedCreditCard();
                String creditCardToken = selectedCreditCard == null ? selectedCreditCard.getCreditCardToken() : null;
                MultiRideCard multiRideCardToRefill = value.getMultiRideCardToRefill();
                String id = multiRideCardToRefill == null ? multiRideCardToRefill.getId() : null;
                multiRideCardCheckoutManager$createBooking$1.L$0 = multiRideCardCheckoutManager;
                multiRideCardCheckoutManager$createBooking$1.L$1 = value;
                multiRideCardCheckoutManager$createBooking$1.L$2 = null;
                multiRideCardCheckoutManager$createBooking$1.L$3 = null;
                multiRideCardCheckoutManager$createBooking$1.L$4 = null;
                multiRideCardCheckoutManager$createBooking$1.label = 2;
                MultiRideCardCheckoutManager multiRideCardCheckoutManager4 = multiRideCardCheckoutManager;
                obj = coroutine_suspended;
                purchaseOrRefillMultiRide = iMultiRideService.purchaseOrRefillMultiRide(multiRideTypeId, email, numberOfCharges, dto, nationalNumber, countryCode, postalCode, dto2, creditCardToken, id, f7, f8, multiRideCardCheckoutManager$createBooking$1);
                if (purchaseOrRefillMultiRide != obj) {
                    return obj;
                }
                multiRideCardCheckoutManager2 = multiRideCardCheckoutManager4;
                checkoutState = value;
                obj2 = purchaseOrRefillMultiRide;
                apiResult = (ApiResult) obj2;
                continuation2 = null;
                multiRideCardCheckoutManager$createBooking$2 = new MultiRideCardCheckoutManager$createBooking$2(multiRideCardCheckoutManager2, checkoutState, null);
                multiRideCardCheckoutManager$createBooking$1.L$0 = apiResult;
                multiRideCardCheckoutManager$createBooking$1.L$1 = null;
                multiRideCardCheckoutManager$createBooking$1.label = 3;
                if (dk.molslinjen.api.extensions.ApiResultExtensionsKt.onSuccess(apiResult, multiRideCardCheckoutManager$createBooking$2, multiRideCardCheckoutManager$createBooking$1) != obj) {
                }
            }
        }
        multiRideCardCheckoutManager$createBooking$1 = new MultiRideCardCheckoutManager$createBooking$1(this, continuation);
        Object obj22 = multiRideCardCheckoutManager$createBooking$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = multiRideCardCheckoutManager$createBooking$1.label;
        if (i5 != 0) {
        }
        IMultiRideService iMultiRideService2 = multiRideCardCheckoutManager.multiRideService;
        String multiRideTypeId2 = selectedPurchaseInfo.getMultiRideTypeId();
        String email2 = personalInfo.getEmail();
        int numberOfCharges2 = value.getNumberOfCharges();
        PaymentTypeDTO dto3 = value.getSelectedPaymentType().toDTO();
        String nationalNumber2 = personalInfo.getPhoneNumber().getNationalNumber();
        String countryCode2 = personalInfo.getPhoneNumber().getCountryCode();
        String postalCode2 = personalInfo.getPostalCode();
        SiteDTO dto22 = site.toDTO();
        CreditCard selectedCreditCard2 = value.getSelectedCreditCard();
        if (selectedCreditCard2 == null) {
        }
        MultiRideCard multiRideCardToRefill2 = value.getMultiRideCardToRefill();
        if (multiRideCardToRefill2 == null) {
        }
        multiRideCardCheckoutManager$createBooking$1.L$0 = multiRideCardCheckoutManager;
        multiRideCardCheckoutManager$createBooking$1.L$1 = value;
        multiRideCardCheckoutManager$createBooking$1.L$2 = null;
        multiRideCardCheckoutManager$createBooking$1.L$3 = null;
        multiRideCardCheckoutManager$createBooking$1.L$4 = null;
        multiRideCardCheckoutManager$createBooking$1.label = 2;
        MultiRideCardCheckoutManager multiRideCardCheckoutManager42 = multiRideCardCheckoutManager;
        obj = coroutine_suspended2;
        purchaseOrRefillMultiRide = iMultiRideService2.purchaseOrRefillMultiRide(multiRideTypeId2, email2, numberOfCharges2, dto3, nationalNumber2, countryCode2, postalCode2, dto22, creditCardToken, id, f7, f8, multiRideCardCheckoutManager$createBooking$1);
        if (purchaseOrRefillMultiRide != obj) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00ee A[PHI: r14
      0x00ee: PHI (r14v16 java.lang.Object) = (r14v15 java.lang.Object), (r14v1 java.lang.Object) binds: [B:19:0x00eb, B:12:0x002f] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ed A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ce A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // dk.molslinjen.domain.managers.agreement.multiride.purchase.IMultiRideCardCheckoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadSummaryInfo(Continuation<? super ManagerResult<Unit>> continuation) {
        MultiRideCardCheckoutManager$loadSummaryInfo$1 multiRideCardCheckoutManager$loadSummaryInfo$1;
        Object obj;
        Object coroutine_suspended;
        int i5;
        String multiRideTypeId;
        MultiRideCardCheckoutManager multiRideCardCheckoutManager;
        IMultiRideService iMultiRideService;
        int i6;
        String str;
        MultiRideCardCheckoutManager multiRideCardCheckoutManager2;
        ApiResult apiResult;
        MultiRideCardCheckoutManager$loadSummaryInfo$2 multiRideCardCheckoutManager$loadSummaryInfo$2;
        ApiResult apiResult2;
        if (continuation instanceof MultiRideCardCheckoutManager$loadSummaryInfo$1) {
            multiRideCardCheckoutManager$loadSummaryInfo$1 = (MultiRideCardCheckoutManager$loadSummaryInfo$1) continuation;
            int i7 = multiRideCardCheckoutManager$loadSummaryInfo$1.label;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                multiRideCardCheckoutManager$loadSummaryInfo$1.label = i7 - Integer.MIN_VALUE;
                obj = multiRideCardCheckoutManager$loadSummaryInfo$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = multiRideCardCheckoutManager$loadSummaryInfo$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IMultiRideCardCheckoutManager.CheckoutState value = getCheckoutState().getValue();
                    MultiRidePurchaseInfo selectedPurchaseInfo = value.getSelectedPurchaseInfo();
                    if (selectedPurchaseInfo == null || (multiRideTypeId = selectedPurchaseInfo.getMultiRideTypeId()) == null) {
                        MultiRideCard multiRideCardToRefill = value.getMultiRideCardToRefill();
                        if (multiRideCardToRefill == null) {
                            return ManagerResult.Error.INSTANCE.noMessage();
                        }
                        multiRideTypeId = multiRideCardToRefill.getMultiRideTypeId();
                    }
                    IMultiRideService iMultiRideService2 = this.multiRideService;
                    int numberOfCharges = value.getNumberOfCharges();
                    ICurrencyManager iCurrencyManager = this.currencyManager;
                    Site forceMolsSite = MultiRideManager.INSTANCE.getForceMolsSite();
                    multiRideCardCheckoutManager$loadSummaryInfo$1.L$0 = this;
                    multiRideCardCheckoutManager$loadSummaryInfo$1.L$1 = iMultiRideService2;
                    multiRideCardCheckoutManager$loadSummaryInfo$1.L$2 = multiRideTypeId;
                    multiRideCardCheckoutManager$loadSummaryInfo$1.I$0 = numberOfCharges;
                    multiRideCardCheckoutManager$loadSummaryInfo$1.label = 1;
                    Object selectedCurrency = iCurrencyManager.getSelectedCurrency(forceMolsSite, multiRideCardCheckoutManager$loadSummaryInfo$1);
                    if (selectedCurrency == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    multiRideCardCheckoutManager = this;
                    iMultiRideService = iMultiRideService2;
                    i6 = numberOfCharges;
                    obj = selectedCurrency;
                    str = multiRideTypeId;
                } else if (i5 == 1) {
                    int i8 = multiRideCardCheckoutManager$loadSummaryInfo$1.I$0;
                    str = (String) multiRideCardCheckoutManager$loadSummaryInfo$1.L$2;
                    IMultiRideService iMultiRideService3 = (IMultiRideService) multiRideCardCheckoutManager$loadSummaryInfo$1.L$1;
                    MultiRideCardCheckoutManager multiRideCardCheckoutManager3 = (MultiRideCardCheckoutManager) multiRideCardCheckoutManager$loadSummaryInfo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    multiRideCardCheckoutManager = multiRideCardCheckoutManager3;
                    iMultiRideService = iMultiRideService3;
                    i6 = i8;
                } else {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (i5 == 4) {
                                ResultKt.throwOnFailure(obj);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        apiResult2 = (ApiResult) multiRideCardCheckoutManager$loadSummaryInfo$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        multiRideCardCheckoutManager$loadSummaryInfo$1.L$0 = null;
                        multiRideCardCheckoutManager$loadSummaryInfo$1.label = 4;
                        obj = ApiResultExtensionsKt.toUnitManagerResult(apiResult2, multiRideCardCheckoutManager$loadSummaryInfo$1);
                        return obj != coroutine_suspended ? coroutine_suspended : obj;
                    }
                    multiRideCardCheckoutManager2 = (MultiRideCardCheckoutManager) multiRideCardCheckoutManager$loadSummaryInfo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    apiResult = (ApiResult) obj;
                    multiRideCardCheckoutManager$loadSummaryInfo$2 = new MultiRideCardCheckoutManager$loadSummaryInfo$2(multiRideCardCheckoutManager2, null);
                    multiRideCardCheckoutManager$loadSummaryInfo$1.L$0 = apiResult;
                    multiRideCardCheckoutManager$loadSummaryInfo$1.label = 3;
                    if (dk.molslinjen.api.extensions.ApiResultExtensionsKt.onSuccess(apiResult, multiRideCardCheckoutManager$loadSummaryInfo$2, multiRideCardCheckoutManager$loadSummaryInfo$1) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    apiResult2 = apiResult;
                    multiRideCardCheckoutManager$loadSummaryInfo$1.L$0 = null;
                    multiRideCardCheckoutManager$loadSummaryInfo$1.label = 4;
                    obj = ApiResultExtensionsKt.toUnitManagerResult(apiResult2, multiRideCardCheckoutManager$loadSummaryInfo$1);
                    if (obj != coroutine_suspended) {
                    }
                }
                IMultiRideService iMultiRideService4 = iMultiRideService;
                CurrencyTypeDTO dto = ((CurrencyType) obj).toDTO();
                SiteDTO dto2 = MultiRideManager.INSTANCE.getForceMolsSite().toDTO();
                multiRideCardCheckoutManager$loadSummaryInfo$1.L$0 = multiRideCardCheckoutManager;
                multiRideCardCheckoutManager$loadSummaryInfo$1.L$1 = null;
                multiRideCardCheckoutManager$loadSummaryInfo$1.L$2 = null;
                multiRideCardCheckoutManager$loadSummaryInfo$1.label = 2;
                obj = iMultiRideService4.getSummaryInfo(str, i6, dto, dto2, multiRideCardCheckoutManager$loadSummaryInfo$1);
                if (obj != coroutine_suspended) {
                    return coroutine_suspended;
                }
                multiRideCardCheckoutManager2 = multiRideCardCheckoutManager;
                apiResult = (ApiResult) obj;
                multiRideCardCheckoutManager$loadSummaryInfo$2 = new MultiRideCardCheckoutManager$loadSummaryInfo$2(multiRideCardCheckoutManager2, null);
                multiRideCardCheckoutManager$loadSummaryInfo$1.L$0 = apiResult;
                multiRideCardCheckoutManager$loadSummaryInfo$1.label = 3;
                if (dk.molslinjen.api.extensions.ApiResultExtensionsKt.onSuccess(apiResult, multiRideCardCheckoutManager$loadSummaryInfo$2, multiRideCardCheckoutManager$loadSummaryInfo$1) != coroutine_suspended) {
                }
            }
        }
        multiRideCardCheckoutManager$loadSummaryInfo$1 = new MultiRideCardCheckoutManager$loadSummaryInfo$1(this, continuation);
        obj = multiRideCardCheckoutManager$loadSummaryInfo$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = multiRideCardCheckoutManager$loadSummaryInfo$1.label;
        if (i5 != 0) {
        }
        IMultiRideService iMultiRideService42 = iMultiRideService;
        CurrencyTypeDTO dto3 = ((CurrencyType) obj).toDTO();
        SiteDTO dto22 = MultiRideManager.INSTANCE.getForceMolsSite().toDTO();
        multiRideCardCheckoutManager$loadSummaryInfo$1.L$0 = multiRideCardCheckoutManager;
        multiRideCardCheckoutManager$loadSummaryInfo$1.L$1 = null;
        multiRideCardCheckoutManager$loadSummaryInfo$1.L$2 = null;
        multiRideCardCheckoutManager$loadSummaryInfo$1.label = 2;
        obj = iMultiRideService42.getSummaryInfo(str, i6, dto3, dto22, multiRideCardCheckoutManager$loadSummaryInfo$1);
        if (obj != coroutine_suspended) {
        }
    }

    @Override // dk.molslinjen.domain.managers.agreement.multiride.purchase.IMultiRideCardCheckoutManager
    public void selectPaymentMethod(PaymentType paymentType, CreditCard creditCard) {
        IMultiRideCardCheckoutManager.CheckoutState value;
        IMultiRideCardCheckoutManager.CheckoutState copy;
        Intrinsics.checkNotNullParameter(paymentType, "paymentType");
        MutableStateFlow<IMultiRideCardCheckoutManager.CheckoutState> checkoutState = getCheckoutState();
        do {
            value = checkoutState.getValue();
            copy = r1.copy((r26 & 1) != 0 ? r1.flowOrigin : null, (r26 & 2) != 0 ? r1.siteInfo : null, (r26 & 4) != 0 ? r1.multiRideCardToRefill : null, (r26 & 8) != 0 ? r1.purchaseInfos : null, (r26 & 16) != 0 ? r1.selectedPurchaseInfo : null, (r26 & 32) != 0 ? r1.numberOfCharges : 0, (r26 & 64) != 0 ? r1.selectedPriceStep : null, (r26 & 128) != 0 ? r1.totalPrice : null, (r26 & 256) != 0 ? r1.personalInfo : null, (r26 & 512) != 0 ? r1.selectedPaymentType : paymentType, (r26 & 1024) != 0 ? r1.selectedCreditCard : creditCard, (r26 & 2048) != 0 ? value.summaryCardInfo : null);
        } while (!checkoutState.compareAndSet(value, copy));
    }

    @Override // dk.molslinjen.domain.managers.agreement.multiride.purchase.IMultiRideCardCheckoutManager
    public Object setup(Site site, String str, PaymentOrigin paymentOrigin, Continuation<? super ManagerResult<Unit>> continuation) {
        Object obj;
        MultiRideCard multiRideCard;
        IMultiRideCardCheckoutManager.CheckoutState value;
        UserInfo details;
        Continuation<? super ManagerResult<Unit>> continuation2;
        String str2;
        Object obj2;
        this.paymentManager.resetPaymentState();
        List<SiteInfo> value2 = this.siteManager.getAvailableSites().getValue();
        if (value2 != null) {
            Iterator<T> it = value2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((SiteInfo) obj).getSite() == site) {
                    break;
                }
            }
            SiteInfo siteInfo = (SiteInfo) obj;
            if (siteInfo != null) {
                if (str != null) {
                    Iterator<T> it2 = this.multiRideManager.getState().getValue().getMultiRideCards().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it2.next();
                        if (Intrinsics.areEqual(((MultiRideCard) obj2).getId(), str)) {
                            break;
                        }
                    }
                    multiRideCard = (MultiRideCard) obj2;
                } else {
                    multiRideCard = null;
                }
                MutableStateFlow<IMultiRideCardCheckoutManager.CheckoutState> checkoutState = getCheckoutState();
                do {
                    value = checkoutState.getValue();
                    details = this.userManager.getCurrentUserState().getValue().getUser().getDetails();
                } while (!checkoutState.compareAndSet(value, new IMultiRideCardCheckoutManager.CheckoutState(paymentOrigin, siteInfo, multiRideCard, null, null, 0, null, null, new CheckoutContactInfo(details != null ? details.getContactDetails() : null), null, null, null, 3832, null)));
                this.analyticsTracker.updateBookingTypeStateTracking(false, AnalyticsStateTrackingHelper.BookingFlowTypeTracking.MultiRideCard);
                this.analyticsTracker.updateBookingStateTracking(siteInfo.getSite(), BookingType.Single, null);
                if (multiRideCard != null) {
                    str2 = multiRideCard.getMultiRideTypeId();
                    continuation2 = continuation;
                } else {
                    continuation2 = continuation;
                    str2 = null;
                }
                return loadPurchaseInfo(site, str2, continuation2);
            }
        }
        return ManagerResult.Error.INSTANCE.noMessage();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // dk.molslinjen.domain.managers.agreement.multiride.purchase.IMultiRideCardCheckoutManager
    public void updateChargeCount(int chargeCount) {
        IMultiRideCardCheckoutManager.CheckoutState copy;
        List<MultiRidePriceStep> priceSteps;
        int i5 = chargeCount;
        MutableStateFlow<IMultiRideCardCheckoutManager.CheckoutState> checkoutState = getCheckoutState();
        while (true) {
            IMultiRideCardCheckoutManager.CheckoutState value = checkoutState.getValue();
            IMultiRideCardCheckoutManager.CheckoutState checkoutState2 = value;
            MultiRidePurchaseInfo selectedPurchaseInfo = checkoutState2.getSelectedPurchaseInfo();
            MultiRidePriceStep multiRidePriceStep = null;
            if (selectedPurchaseInfo != null && (priceSteps = selectedPurchaseInfo.getPriceSteps()) != null) {
                Iterator<T> it = priceSteps.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    MultiRidePriceStep multiRidePriceStep2 = (MultiRidePriceStep) next;
                    if (multiRidePriceStep2.getMin() <= i5) {
                        Integer max = multiRidePriceStep2.getMax();
                        if (i5 <= (max != null ? max.intValue() : Integer.MAX_VALUE)) {
                            multiRidePriceStep = next;
                            break;
                        }
                    }
                }
                multiRidePriceStep = multiRidePriceStep;
            }
            MutableStateFlow<IMultiRideCardCheckoutManager.CheckoutState> mutableStateFlow = checkoutState;
            copy = checkoutState2.copy((r26 & 1) != 0 ? checkoutState2.flowOrigin : null, (r26 & 2) != 0 ? checkoutState2.siteInfo : null, (r26 & 4) != 0 ? checkoutState2.multiRideCardToRefill : null, (r26 & 8) != 0 ? checkoutState2.purchaseInfos : null, (r26 & 16) != 0 ? checkoutState2.selectedPurchaseInfo : null, (r26 & 32) != 0 ? checkoutState2.numberOfCharges : chargeCount, (r26 & 64) != 0 ? checkoutState2.selectedPriceStep : multiRidePriceStep, (r26 & 128) != 0 ? checkoutState2.totalPrice : null, (r26 & 256) != 0 ? checkoutState2.personalInfo : null, (r26 & 512) != 0 ? checkoutState2.selectedPaymentType : null, (r26 & 1024) != 0 ? checkoutState2.selectedCreditCard : null, (r26 & 2048) != 0 ? checkoutState2.summaryCardInfo : null);
            if (mutableStateFlow.compareAndSet(value, copy)) {
                return;
            }
            checkoutState = mutableStateFlow;
            i5 = chargeCount;
        }
    }

    @Override // dk.molslinjen.domain.managers.agreement.multiride.purchase.IMultiRideCardCheckoutManager
    public void updateEmail(String email) {
        IMultiRideCardCheckoutManager.CheckoutState value;
        IMultiRideCardCheckoutManager.CheckoutState copy;
        Intrinsics.checkNotNullParameter(email, "email");
        MutableStateFlow<IMultiRideCardCheckoutManager.CheckoutState> checkoutState = getCheckoutState();
        do {
            value = checkoutState.getValue();
            IMultiRideCardCheckoutManager.CheckoutState checkoutState2 = value;
            copy = checkoutState2.copy((r26 & 1) != 0 ? checkoutState2.flowOrigin : null, (r26 & 2) != 0 ? checkoutState2.siteInfo : null, (r26 & 4) != 0 ? checkoutState2.multiRideCardToRefill : null, (r26 & 8) != 0 ? checkoutState2.purchaseInfos : null, (r26 & 16) != 0 ? checkoutState2.selectedPurchaseInfo : null, (r26 & 32) != 0 ? checkoutState2.numberOfCharges : 0, (r26 & 64) != 0 ? checkoutState2.selectedPriceStep : null, (r26 & 128) != 0 ? checkoutState2.totalPrice : null, (r26 & 256) != 0 ? checkoutState2.personalInfo : CheckoutContactInfo.copy$default(checkoutState2.getPersonalInfo(), null, email, null, false, 13, null), (r26 & 512) != 0 ? checkoutState2.selectedPaymentType : null, (r26 & 1024) != 0 ? checkoutState2.selectedCreditCard : null, (r26 & 2048) != 0 ? checkoutState2.summaryCardInfo : null);
        } while (!checkoutState.compareAndSet(value, copy));
    }

    @Override // dk.molslinjen.domain.managers.agreement.multiride.purchase.IMultiRideCardCheckoutManager
    public void updatePhoneNumber(PhoneNumber phoneNumber) {
        IMultiRideCardCheckoutManager.CheckoutState value;
        IMultiRideCardCheckoutManager.CheckoutState copy;
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        MutableStateFlow<IMultiRideCardCheckoutManager.CheckoutState> checkoutState = getCheckoutState();
        do {
            value = checkoutState.getValue();
            IMultiRideCardCheckoutManager.CheckoutState checkoutState2 = value;
            copy = checkoutState2.copy((r26 & 1) != 0 ? checkoutState2.flowOrigin : null, (r26 & 2) != 0 ? checkoutState2.siteInfo : null, (r26 & 4) != 0 ? checkoutState2.multiRideCardToRefill : null, (r26 & 8) != 0 ? checkoutState2.purchaseInfos : null, (r26 & 16) != 0 ? checkoutState2.selectedPurchaseInfo : null, (r26 & 32) != 0 ? checkoutState2.numberOfCharges : 0, (r26 & 64) != 0 ? checkoutState2.selectedPriceStep : null, (r26 & 128) != 0 ? checkoutState2.totalPrice : null, (r26 & 256) != 0 ? checkoutState2.personalInfo : CheckoutContactInfo.copy$default(checkoutState2.getPersonalInfo(), phoneNumber, null, null, false, 14, null), (r26 & 512) != 0 ? checkoutState2.selectedPaymentType : null, (r26 & 1024) != 0 ? checkoutState2.selectedCreditCard : null, (r26 & 2048) != 0 ? checkoutState2.summaryCardInfo : null);
        } while (!checkoutState.compareAndSet(value, copy));
    }

    @Override // dk.molslinjen.domain.managers.agreement.multiride.purchase.IMultiRideCardCheckoutManager
    public void updatePostalCode(String postalCode) {
        IMultiRideCardCheckoutManager.CheckoutState value;
        IMultiRideCardCheckoutManager.CheckoutState copy;
        Intrinsics.checkNotNullParameter(postalCode, "postalCode");
        MutableStateFlow<IMultiRideCardCheckoutManager.CheckoutState> checkoutState = getCheckoutState();
        do {
            value = checkoutState.getValue();
            IMultiRideCardCheckoutManager.CheckoutState checkoutState2 = value;
            copy = checkoutState2.copy((r26 & 1) != 0 ? checkoutState2.flowOrigin : null, (r26 & 2) != 0 ? checkoutState2.siteInfo : null, (r26 & 4) != 0 ? checkoutState2.multiRideCardToRefill : null, (r26 & 8) != 0 ? checkoutState2.purchaseInfos : null, (r26 & 16) != 0 ? checkoutState2.selectedPurchaseInfo : null, (r26 & 32) != 0 ? checkoutState2.numberOfCharges : 0, (r26 & 64) != 0 ? checkoutState2.selectedPriceStep : null, (r26 & 128) != 0 ? checkoutState2.totalPrice : null, (r26 & 256) != 0 ? checkoutState2.personalInfo : CheckoutContactInfo.copy$default(checkoutState2.getPersonalInfo(), null, null, postalCode, false, 11, null), (r26 & 512) != 0 ? checkoutState2.selectedPaymentType : null, (r26 & 1024) != 0 ? checkoutState2.selectedCreditCard : null, (r26 & 2048) != 0 ? checkoutState2.summaryCardInfo : null);
        } while (!checkoutState.compareAndSet(value, copy));
    }

    @Override // dk.molslinjen.domain.managers.agreement.multiride.purchase.IMultiRideCardCheckoutManager
    public void updateSelectedPriceStep(MultiRidePriceStep priceStep) {
        IMultiRideCardCheckoutManager.CheckoutState value;
        IMultiRideCardCheckoutManager.CheckoutState copy;
        Intrinsics.checkNotNullParameter(priceStep, "priceStep");
        MutableStateFlow<IMultiRideCardCheckoutManager.CheckoutState> checkoutState = getCheckoutState();
        do {
            value = checkoutState.getValue();
            copy = r1.copy((r26 & 1) != 0 ? r1.flowOrigin : null, (r26 & 2) != 0 ? r1.siteInfo : null, (r26 & 4) != 0 ? r1.multiRideCardToRefill : null, (r26 & 8) != 0 ? r1.purchaseInfos : null, (r26 & 16) != 0 ? r1.selectedPurchaseInfo : null, (r26 & 32) != 0 ? r1.numberOfCharges : priceStep.getMin(), (r26 & 64) != 0 ? r1.selectedPriceStep : priceStep, (r26 & 128) != 0 ? r1.totalPrice : null, (r26 & 256) != 0 ? r1.personalInfo : null, (r26 & 512) != 0 ? r1.selectedPaymentType : null, (r26 & 1024) != 0 ? r1.selectedCreditCard : null, (r26 & 2048) != 0 ? value.summaryCardInfo : null);
        } while (!checkoutState.compareAndSet(value, copy));
    }

    @Override // dk.molslinjen.domain.managers.agreement.multiride.purchase.IMultiRideCardCheckoutManager
    public void updateSelectedPurchaseInfo(MultiRidePurchaseInfo purchaseInfo) {
        IMultiRideCardCheckoutManager.CheckoutState value;
        Object obj;
        IMultiRideCardCheckoutManager.CheckoutState copy;
        Intrinsics.checkNotNullParameter(purchaseInfo, "purchaseInfo");
        MutableStateFlow<IMultiRideCardCheckoutManager.CheckoutState> checkoutState = getCheckoutState();
        do {
            value = checkoutState.getValue();
            IMultiRideCardCheckoutManager.CheckoutState checkoutState2 = value;
            Iterator<T> it = purchaseInfo.getPriceSteps().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                MultiRidePriceStep multiRidePriceStep = (MultiRidePriceStep) obj;
                if (multiRidePriceStep.getMin() <= checkoutState2.getNumberOfCharges()) {
                    int numberOfCharges = checkoutState2.getNumberOfCharges();
                    Integer max = multiRidePriceStep.getMax();
                    if (numberOfCharges <= (max != null ? max.intValue() : Integer.MAX_VALUE)) {
                        break;
                    }
                }
            }
            copy = checkoutState2.copy((r26 & 1) != 0 ? checkoutState2.flowOrigin : null, (r26 & 2) != 0 ? checkoutState2.siteInfo : null, (r26 & 4) != 0 ? checkoutState2.multiRideCardToRefill : null, (r26 & 8) != 0 ? checkoutState2.purchaseInfos : null, (r26 & 16) != 0 ? checkoutState2.selectedPurchaseInfo : purchaseInfo, (r26 & 32) != 0 ? checkoutState2.numberOfCharges : 0, (r26 & 64) != 0 ? checkoutState2.selectedPriceStep : (MultiRidePriceStep) obj, (r26 & 128) != 0 ? checkoutState2.totalPrice : null, (r26 & 256) != 0 ? checkoutState2.personalInfo : null, (r26 & 512) != 0 ? checkoutState2.selectedPaymentType : null, (r26 & 1024) != 0 ? checkoutState2.selectedCreditCard : null, (r26 & 2048) != 0 ? checkoutState2.summaryCardInfo : null);
        } while (!checkoutState.compareAndSet(value, copy));
    }

    @Override // dk.molslinjen.domain.managers.agreement.multiride.purchase.IMultiRideCardCheckoutManager
    public MutableStateFlow<IMultiRideCardCheckoutManager.CheckoutState> getCheckoutState() {
        return this.checkoutState;
    }
}
