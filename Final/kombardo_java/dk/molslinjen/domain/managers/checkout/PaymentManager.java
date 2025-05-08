package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.payment.IPaymentService;
import dk.molslinjen.api.services.payment.response.PaymentStatusResponseDTO;
import dk.molslinjen.api.services.paymentTypes.IPaymentTypesService;
import dk.molslinjen.api.services.paymentTypes.response.AllowedPaymentTypeDTO;
import dk.molslinjen.api.services.paymentTypes.response.PaymentTypesResponseDTO;
import dk.molslinjen.api.shared.response.CurrencyTypeDTO;
import dk.molslinjen.core.extensions.CollectionExtensionsKt;
import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.extensions.PaymentStatusResponseDTOExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.checkout.PaymentManager;
import dk.molslinjen.domain.managers.user.creditcards.IUserCreditCardsManager;
import dk.molslinjen.domain.model.account.CreditCardType;
import dk.molslinjen.domain.model.booking.BookingProcessingResult;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.payment.PaymentOrigin;
import dk.molslinjen.domain.model.payment.PaymentType;
import dk.molslinjen.domain.model.shared.CurrencyType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001=B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J(\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0014H\u0016J\b\u0010#\u001a\u00020\u0017H\u0016J\b\u0010$\u001a\u00020\u0017H\u0016J\b\u0010%\u001a\u00020\u0017H\u0016J\"\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u00142\b\u0010(\u001a\u0004\u0018\u00010\u001d2\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020\u0017H\u0016J\u0016\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020.H\u0082@¢\u0006\u0002\u0010/J!\u00100\u001a\u00020\u00172\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u00101J\b\u00102\u001a\u00020\u0017H\u0016J,\u00103\u001a\b\u0012\u0004\u0012\u00020\u001f042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010:J$\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001f042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0096@¢\u0006\u0002\u0010<R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/PaymentManager;", "Ldk/molslinjen/domain/managers/checkout/IPaymentManager;", "paymentService", "Ldk/molslinjen/api/services/payment/IPaymentService;", "paymentTypesService", "Ldk/molslinjen/api/services/paymentTypes/IPaymentTypesService;", "userCreditCardsManager", "Ldk/molslinjen/domain/managers/user/creditcards/IUserCreditCardsManager;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "<init>", "(Ldk/molslinjen/api/services/payment/IPaymentService;Ldk/molslinjen/api/services/paymentTypes/IPaymentTypesService;Ldk/molslinjen/domain/managers/user/creditcards/IUserCreditCardsManager;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;)V", "paymentState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/managers/checkout/PaymentManager$PaymentState;", "getPaymentState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "localScope", "Lkotlinx/coroutines/CoroutineScope;", "ticketLoaded", BuildConfig.FLAVOR, "navigatedToReceipt", "restartPaymentFlow", BuildConfig.FLAVOR, "setPaymentOrigin", "paymentOrigin", "Ldk/molslinjen/domain/model/payment/PaymentOrigin;", "setPaymentData", "reservationNumber", BuildConfig.FLAVOR, "paymentType", "Ldk/molslinjen/domain/model/payment/PaymentType;", "bookingProcessingResult", "Ldk/molslinjen/domain/model/booking/BookingProcessingResult;", "paymentCapturedLater", "setPaymentCompletedAfterOrderProcessingPostPayment", "setPaymentFailedAfterOrderProcessingPostPayment", "setPaymentCallbackReceived", "paymentSucceeded", "isCompleted", "transactionId", "cardType", "Ldk/molslinjen/domain/model/account/CreditCardType;", "clearPaymentError", "saveCreditCard", "paymentResult", "Ldk/molslinjen/api/services/payment/response/PaymentStatusResponseDTO;", "(Ldk/molslinjen/api/services/payment/response/PaymentStatusResponseDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readyForPaymentStateReset", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "resetPaymentState", "getPaymentMethodsForBooking", BuildConfig.FLAVOR, "site", "Ldk/molslinjen/domain/model/config/Site;", "currency", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "routeId", "(Ldk/molslinjen/domain/model/config/Site;Ldk/molslinjen/domain/model/shared/CurrencyType;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPaymentMethodsForOthers", "(Ldk/molslinjen/domain/model/config/Site;Ldk/molslinjen/domain/model/shared/CurrencyType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PaymentState", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PaymentManager implements IPaymentManager {
    private final IAnalyticsTracker analyticsTracker;
    private final CoroutineScope localScope;
    private boolean navigatedToReceipt;
    private final IPaymentService paymentService;
    private final MutableStateFlow<PaymentState> paymentState;
    private final IPaymentTypesService paymentTypesService;
    private boolean ticketLoaded;
    private final IUserCreditCardsManager userCreditCardsManager;

    public PaymentManager(IPaymentService paymentService, IPaymentTypesService paymentTypesService, IUserCreditCardsManager userCreditCardsManager, IAnalyticsTracker analyticsTracker) {
        Intrinsics.checkNotNullParameter(paymentService, "paymentService");
        Intrinsics.checkNotNullParameter(paymentTypesService, "paymentTypesService");
        Intrinsics.checkNotNullParameter(userCreditCardsManager, "userCreditCardsManager");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        this.paymentService = paymentService;
        this.paymentTypesService = paymentTypesService;
        this.userCreditCardsManager = userCreditCardsManager;
        this.analyticsTracker = analyticsTracker;
        this.paymentState = StateFlowKt.MutableStateFlow(new PaymentState(false, null, null, null, null, false, null, null, null, null, 1023, null));
        this.localScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getPaymentMethodsForBooking$lambda$10(PaymentTypesResponseDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        List<AllowedPaymentTypeDTO> allowedPaymentTypes = it.getAllowedPaymentTypes();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(allowedPaymentTypes, 10));
        Iterator<T> it2 = allowedPaymentTypes.iterator();
        while (it2.hasNext()) {
            arrayList.add(PaymentType.INSTANCE.invoke(((AllowedPaymentTypeDTO) it2.next()).getType()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ManagerResult getPaymentMethodsForBooking$lambda$11(ApiResult.Error it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new ManagerResult.Success(IPaymentManager.INSTANCE.getDefaultPaymentMethods());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getPaymentMethodsForBooking$lambda$12() {
        return CollectionsKt.listOf(PaymentType.Card);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getPaymentMethodsForOthers$lambda$14(PaymentTypesResponseDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        List<AllowedPaymentTypeDTO> allowedPaymentTypes = it.getAllowedPaymentTypes();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(allowedPaymentTypes, 10));
        Iterator<T> it2 = allowedPaymentTypes.iterator();
        while (it2.hasNext()) {
            arrayList.add(PaymentType.INSTANCE.invoke(((AllowedPaymentTypeDTO) it2.next()).getType()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ManagerResult getPaymentMethodsForOthers$lambda$15(ApiResult.Error it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new ManagerResult.Success(IPaymentManager.INSTANCE.getDefaultPaymentMethods());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getPaymentMethodsForOthers$lambda$16() {
        return CollectionsKt.listOf(PaymentType.Card);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void paymentSucceeded(boolean isCompleted, String transactionId, CreditCardType cardType) {
        PaymentState value;
        MutableStateFlow<PaymentState> paymentState = getPaymentState();
        do {
            value = paymentState.getValue();
        } while (!paymentState.compareAndSet(value, PaymentState.copy$default(value, false, Boolean.valueOf(isCompleted), Boolean.valueOf(getPaymentState().getValue().getPaymentCapturedLater() ? false : isCompleted), null, BookingProcessingResult.Pay, false, null, null, transactionId, cardType, 233, null)));
        Logger.log$default(Logger.INSTANCE, "paymentSucceeded with new state:  " + getPaymentState().getValue(), "PaymentProcess", 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object saveCreditCard(PaymentStatusResponseDTO paymentStatusResponseDTO, Continuation<? super Unit> continuation) {
        String creditCardToken = paymentStatusResponseDTO.getCreditCardToken();
        if (creditCardToken == null || creditCardToken.length() == 0) {
            return Unit.INSTANCE;
        }
        IUserCreditCardsManager iUserCreditCardsManager = this.userCreditCardsManager;
        String cardNumber = paymentStatusResponseDTO.getCardNumber();
        if (cardNumber == null) {
            cardNumber = BuildConfig.FLAVOR;
        }
        Object addCreditCard = iUserCreditCardsManager.addCreditCard(cardNumber, PaymentStatusResponseDTOExtensionsKt.getCardType(paymentStatusResponseDTO), paymentStatusResponseDTO.getExpirationMonth(), paymentStatusResponseDTO.getExpirationYear(), creditCardToken, continuation);
        return addCreditCard == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? addCreditCard : Unit.INSTANCE;
    }

    @Override // dk.molslinjen.domain.managers.checkout.IPaymentManager
    public void clearPaymentError() {
        PaymentState value;
        Logger.log$default(Logger.INSTANCE, "clearPaymentError", "PaymentProcess", 0, 4, null);
        MutableStateFlow<PaymentState> paymentState = getPaymentState();
        do {
            value = paymentState.getValue();
        } while (!paymentState.compareAndSet(value, PaymentState.copy$default(value, false, null, null, null, null, false, null, null, null, null, 1016, null)));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // dk.molslinjen.domain.managers.checkout.IPaymentManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getPaymentMethodsForBooking(Site site, CurrencyType currencyType, String str, Continuation<? super List<? extends PaymentType>> continuation) {
        PaymentManager$getPaymentMethodsForBooking$1 paymentManager$getPaymentMethodsForBooking$1;
        int i5;
        if (continuation instanceof PaymentManager$getPaymentMethodsForBooking$1) {
            paymentManager$getPaymentMethodsForBooking$1 = (PaymentManager$getPaymentMethodsForBooking$1) continuation;
            int i6 = paymentManager$getPaymentMethodsForBooking$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                paymentManager$getPaymentMethodsForBooking$1.label = i6 - Integer.MIN_VALUE;
                Object obj = paymentManager$getPaymentMethodsForBooking$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = paymentManager$getPaymentMethodsForBooking$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IPaymentTypesService iPaymentTypesService = this.paymentTypesService;
                    SiteDTO dto = site.toDTO();
                    CurrencyTypeDTO dto2 = currencyType.toDTO();
                    paymentManager$getPaymentMethodsForBooking$1.label = 1;
                    obj = iPaymentTypesService.getPaymentTypes(dto, dto2, str, paymentManager$getPaymentMethodsForBooking$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return CollectionExtensionsKt.ifNullOrEmpty((Collection) ManagerResultExtensionsKt.toData(ManagerResultExtensionsKt.toManagerResult((ApiResult) obj, new Function1() { // from class: B1.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        List paymentMethodsForBooking$lambda$10;
                        paymentMethodsForBooking$lambda$10 = PaymentManager.getPaymentMethodsForBooking$lambda$10((PaymentTypesResponseDTO) obj2);
                        return paymentMethodsForBooking$lambda$10;
                    }
                }, new Function1() { // from class: B1.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        ManagerResult paymentMethodsForBooking$lambda$11;
                        paymentMethodsForBooking$lambda$11 = PaymentManager.getPaymentMethodsForBooking$lambda$11((ApiResult.Error) obj2);
                        return paymentMethodsForBooking$lambda$11;
                    }
                })), new Function0() { // from class: B1.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        List paymentMethodsForBooking$lambda$12;
                        paymentMethodsForBooking$lambda$12 = PaymentManager.getPaymentMethodsForBooking$lambda$12();
                        return paymentMethodsForBooking$lambda$12;
                    }
                });
            }
        }
        paymentManager$getPaymentMethodsForBooking$1 = new PaymentManager$getPaymentMethodsForBooking$1(this, continuation);
        Object obj2 = paymentManager$getPaymentMethodsForBooking$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = paymentManager$getPaymentMethodsForBooking$1.label;
        if (i5 != 0) {
        }
        return CollectionExtensionsKt.ifNullOrEmpty((Collection) ManagerResultExtensionsKt.toData(ManagerResultExtensionsKt.toManagerResult((ApiResult) obj2, new Function1() { // from class: B1.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj22) {
                List paymentMethodsForBooking$lambda$10;
                paymentMethodsForBooking$lambda$10 = PaymentManager.getPaymentMethodsForBooking$lambda$10((PaymentTypesResponseDTO) obj22);
                return paymentMethodsForBooking$lambda$10;
            }
        }, new Function1() { // from class: B1.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj22) {
                ManagerResult paymentMethodsForBooking$lambda$11;
                paymentMethodsForBooking$lambda$11 = PaymentManager.getPaymentMethodsForBooking$lambda$11((ApiResult.Error) obj22);
                return paymentMethodsForBooking$lambda$11;
            }
        })), new Function0() { // from class: B1.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List paymentMethodsForBooking$lambda$12;
                paymentMethodsForBooking$lambda$12 = PaymentManager.getPaymentMethodsForBooking$lambda$12();
                return paymentMethodsForBooking$lambda$12;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    @Override // dk.molslinjen.domain.managers.checkout.IPaymentManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getPaymentMethodsForOthers(Site site, CurrencyType currencyType, Continuation<? super List<? extends PaymentType>> continuation) {
        PaymentManager$getPaymentMethodsForOthers$1 paymentManager$getPaymentMethodsForOthers$1;
        int i5;
        if (continuation instanceof PaymentManager$getPaymentMethodsForOthers$1) {
            paymentManager$getPaymentMethodsForOthers$1 = (PaymentManager$getPaymentMethodsForOthers$1) continuation;
            int i6 = paymentManager$getPaymentMethodsForOthers$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                paymentManager$getPaymentMethodsForOthers$1.label = i6 - Integer.MIN_VALUE;
                PaymentManager$getPaymentMethodsForOthers$1 paymentManager$getPaymentMethodsForOthers$12 = paymentManager$getPaymentMethodsForOthers$1;
                Object obj = paymentManager$getPaymentMethodsForOthers$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = paymentManager$getPaymentMethodsForOthers$12.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IPaymentTypesService iPaymentTypesService = this.paymentTypesService;
                    SiteDTO dto = site.toDTO();
                    CurrencyTypeDTO dto2 = currencyType.toDTO();
                    paymentManager$getPaymentMethodsForOthers$12.label = 1;
                    obj = IPaymentTypesService.DefaultImpls.getPaymentTypes$default(iPaymentTypesService, dto, dto2, null, paymentManager$getPaymentMethodsForOthers$12, 4, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return CollectionExtensionsKt.ifNullOrEmpty((Collection) ManagerResultExtensionsKt.toData(ManagerResultExtensionsKt.toManagerResult((ApiResult) obj, new Function1() { // from class: B1.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        List paymentMethodsForOthers$lambda$14;
                        paymentMethodsForOthers$lambda$14 = PaymentManager.getPaymentMethodsForOthers$lambda$14((PaymentTypesResponseDTO) obj2);
                        return paymentMethodsForOthers$lambda$14;
                    }
                }, new Function1() { // from class: B1.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        ManagerResult paymentMethodsForOthers$lambda$15;
                        paymentMethodsForOthers$lambda$15 = PaymentManager.getPaymentMethodsForOthers$lambda$15((ApiResult.Error) obj2);
                        return paymentMethodsForOthers$lambda$15;
                    }
                })), new Function0() { // from class: B1.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        List paymentMethodsForOthers$lambda$16;
                        paymentMethodsForOthers$lambda$16 = PaymentManager.getPaymentMethodsForOthers$lambda$16();
                        return paymentMethodsForOthers$lambda$16;
                    }
                });
            }
        }
        paymentManager$getPaymentMethodsForOthers$1 = new PaymentManager$getPaymentMethodsForOthers$1(this, continuation);
        PaymentManager$getPaymentMethodsForOthers$1 paymentManager$getPaymentMethodsForOthers$122 = paymentManager$getPaymentMethodsForOthers$1;
        Object obj2 = paymentManager$getPaymentMethodsForOthers$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = paymentManager$getPaymentMethodsForOthers$122.label;
        if (i5 != 0) {
        }
        return CollectionExtensionsKt.ifNullOrEmpty((Collection) ManagerResultExtensionsKt.toData(ManagerResultExtensionsKt.toManagerResult((ApiResult) obj2, new Function1() { // from class: B1.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj22) {
                List paymentMethodsForOthers$lambda$14;
                paymentMethodsForOthers$lambda$14 = PaymentManager.getPaymentMethodsForOthers$lambda$14((PaymentTypesResponseDTO) obj22);
                return paymentMethodsForOthers$lambda$14;
            }
        }, new Function1() { // from class: B1.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj22) {
                ManagerResult paymentMethodsForOthers$lambda$15;
                paymentMethodsForOthers$lambda$15 = PaymentManager.getPaymentMethodsForOthers$lambda$15((ApiResult.Error) obj22);
                return paymentMethodsForOthers$lambda$15;
            }
        })), new Function0() { // from class: B1.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List paymentMethodsForOthers$lambda$16;
                paymentMethodsForOthers$lambda$16 = PaymentManager.getPaymentMethodsForOthers$lambda$16();
                return paymentMethodsForOthers$lambda$16;
            }
        });
    }

    @Override // dk.molslinjen.domain.managers.checkout.IPaymentManager
    public synchronized void readyForPaymentStateReset(Boolean ticketLoaded, Boolean navigatedToReceipt) {
        if (ticketLoaded != null) {
            try {
                this.ticketLoaded = ticketLoaded.booleanValue();
                Logger.log$default(Logger.INSTANCE, "readyForPaymentStateReset ticketLoaded: " + ticketLoaded, "PaymentProcess", 0, 4, null);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (navigatedToReceipt != null) {
            this.navigatedToReceipt = navigatedToReceipt.booleanValue();
            Logger.log$default(Logger.INSTANCE, "readyForPaymentStateReset navigatedToReceipt: " + navigatedToReceipt, "PaymentProcess", 0, 4, null);
        }
        if (this.ticketLoaded && this.navigatedToReceipt) {
            Logger.log$default(Logger.INSTANCE, "readyForPaymentStateReset resetting", "PaymentProcess", 0, 4, null);
            resetPaymentState();
        }
    }

    @Override // dk.molslinjen.domain.managers.checkout.IPaymentManager
    public void resetPaymentState() {
        Logger.log$default(Logger.INSTANCE, "resetPaymentState", "PaymentProcess", 0, 4, null);
        MutableStateFlow<PaymentState> paymentState = getPaymentState();
        do {
        } while (!paymentState.compareAndSet(paymentState.getValue(), new PaymentState(false, null, null, null, null, false, null, null, null, null, 1023, null)));
        this.ticketLoaded = false;
        this.navigatedToReceipt = false;
    }

    @Override // dk.molslinjen.domain.managers.checkout.IPaymentManager
    public void restartPaymentFlow() {
        PaymentState value;
        Logger.log$default(Logger.INSTANCE, "restartPaymentFlow", "PaymentProcess", 0, 4, null);
        MutableStateFlow<PaymentState> paymentState = getPaymentState();
        do {
            value = paymentState.getValue();
        } while (!paymentState.compareAndSet(value, PaymentState.copy$default(value, false, null, null, null, null, false, null, null, null, null, 1022, null)));
        this.ticketLoaded = false;
        this.navigatedToReceipt = false;
    }

    @Override // dk.molslinjen.domain.managers.checkout.IPaymentManager
    public void setPaymentCallbackReceived() {
        PaymentState value;
        if (getPaymentState().getValue().getPaymentCallbackReceived()) {
            return;
        }
        Logger.log$default(Logger.INSTANCE, "setPaymentCallbackReceived", "PaymentProcess", 0, 4, null);
        MutableStateFlow<PaymentState> paymentState = getPaymentState();
        do {
            value = paymentState.getValue();
        } while (!paymentState.compareAndSet(value, PaymentState.copy$default(value, true, null, null, null, null, false, null, null, null, null, 1022, null)));
        String reservationNumber = getPaymentState().getValue().getReservationNumber();
        if (reservationNumber == null) {
            Logger.INSTANCE.logCritical(new CriticalLog("Reservation number is null"));
        } else {
            BuildersKt__Builders_commonKt.launch$default(this.localScope, null, null, new PaymentManager$setPaymentCallbackReceived$2(this, reservationNumber, null), 3, null);
        }
    }

    @Override // dk.molslinjen.domain.managers.checkout.IPaymentManager
    public void setPaymentCompletedAfterOrderProcessingPostPayment() {
        PaymentState value;
        Logger.log$default(Logger.INSTANCE, "setPaymentCompletedAfterOrderProcessingPostPayment", "PaymentProcess", 0, 4, null);
        MutableStateFlow<PaymentState> paymentState = getPaymentState();
        do {
            value = paymentState.getValue();
        } while (!paymentState.compareAndSet(value, PaymentState.copy$default(value, false, null, Boolean.TRUE, null, null, false, null, null, null, null, 1019, null)));
    }

    @Override // dk.molslinjen.domain.managers.checkout.IPaymentManager
    public void setPaymentData(String reservationNumber, PaymentType paymentType, BookingProcessingResult bookingProcessingResult, boolean paymentCapturedLater) {
        Intrinsics.checkNotNullParameter(reservationNumber, "reservationNumber");
        Intrinsics.checkNotNullParameter(paymentType, "paymentType");
        Intrinsics.checkNotNullParameter(bookingProcessingResult, "bookingProcessingResult");
        Logger logger = Logger.INSTANCE;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "getStackTrace(...)");
        Logger.log$default(logger, "setPaymentData: reservationNumber: " + reservationNumber + ", paymentType: " + paymentType + ", bookingProcessingResult: " + bookingProcessingResult + ", paymentCapturedLater: " + paymentCapturedLater + ", callstack: " + ArraysKt.joinToString$default(stackTrace, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), "PaymentProcess", 0, 4, null);
        MutableStateFlow<PaymentState> paymentState = getPaymentState();
        while (true) {
            PaymentState value = paymentState.getValue();
            MutableStateFlow<PaymentState> mutableStateFlow = paymentState;
            if (mutableStateFlow.compareAndSet(value, PaymentState.copy$default(value, false, null, null, reservationNumber, bookingProcessingResult, paymentCapturedLater, paymentType, null, null, null, 903, null))) {
                return;
            } else {
                paymentState = mutableStateFlow;
            }
        }
    }

    @Override // dk.molslinjen.domain.managers.checkout.IPaymentManager
    public void setPaymentFailedAfterOrderProcessingPostPayment() {
        PaymentState value;
        Logger.log$default(Logger.INSTANCE, "setPaymentFailedAfterOrderProcessingPostPayment", "PaymentProcess", 0, 4, null);
        MutableStateFlow<PaymentState> paymentState = getPaymentState();
        do {
            value = paymentState.getValue();
        } while (!paymentState.compareAndSet(value, PaymentState.copy$default(value, false, Boolean.FALSE, null, null, null, false, null, null, null, null, 1021, null)));
    }

    @Override // dk.molslinjen.domain.managers.checkout.IPaymentManager
    public void setPaymentOrigin(PaymentOrigin paymentOrigin) {
        PaymentState value;
        Intrinsics.checkNotNullParameter(paymentOrigin, "paymentOrigin");
        MutableStateFlow<PaymentState> paymentState = getPaymentState();
        do {
            value = paymentState.getValue();
        } while (!paymentState.compareAndSet(value, PaymentState.copy$default(value, false, null, null, null, null, false, null, paymentOrigin, null, null, 895, null)));
    }

    @Override // dk.molslinjen.domain.managers.checkout.IPaymentManager
    public MutableStateFlow<PaymentState> getPaymentState() {
        return this.paymentState;
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b'\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J|\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0010HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010#\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010*\u001a\u0004\b+\u0010\u0017\"\u0004\b,\u0010-R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001e\u001a\u0004\b3\u0010 \"\u0004\b4\u0010\"R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u00105\u001a\u0004\b6\u00107R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u00108\u001a\u0004\b9\u0010:R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010*\u001a\u0004\b;\u0010\u0017R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010<\u001a\u0004\b=\u0010>¨\u0006?"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/PaymentManager$PaymentState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "paymentCallbackReceived", "paymentSucceeded", "paymentAndOrderCompleted", BuildConfig.FLAVOR, "reservationNumber", "Ldk/molslinjen/domain/model/booking/BookingProcessingResult;", "bookingProcessingResult", "paymentCapturedLater", "Ldk/molslinjen/domain/model/payment/PaymentType;", "paymentType", "Ldk/molslinjen/domain/model/payment/PaymentOrigin;", "paymentOrigin", "transactionId", "Ldk/molslinjen/domain/model/account/CreditCardType;", "cardType", "<init>", "(ZLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ldk/molslinjen/domain/model/booking/BookingProcessingResult;ZLdk/molslinjen/domain/model/payment/PaymentType;Ldk/molslinjen/domain/model/payment/PaymentOrigin;Ljava/lang/String;Ldk/molslinjen/domain/model/account/CreditCardType;)V", "copy", "(ZLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ldk/molslinjen/domain/model/booking/BookingProcessingResult;ZLdk/molslinjen/domain/model/payment/PaymentType;Ldk/molslinjen/domain/model/payment/PaymentOrigin;Ljava/lang/String;Ldk/molslinjen/domain/model/account/CreditCardType;)Ldk/molslinjen/domain/managers/checkout/PaymentManager$PaymentState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getPaymentCallbackReceived", "()Z", "setPaymentCallbackReceived", "(Z)V", "Ljava/lang/Boolean;", "getPaymentSucceeded", "()Ljava/lang/Boolean;", "setPaymentSucceeded", "(Ljava/lang/Boolean;)V", "getPaymentAndOrderCompleted", "setPaymentAndOrderCompleted", "Ljava/lang/String;", "getReservationNumber", "setReservationNumber", "(Ljava/lang/String;)V", "Ldk/molslinjen/domain/model/booking/BookingProcessingResult;", "getBookingProcessingResult", "()Ldk/molslinjen/domain/model/booking/BookingProcessingResult;", "setBookingProcessingResult", "(Ldk/molslinjen/domain/model/booking/BookingProcessingResult;)V", "getPaymentCapturedLater", "setPaymentCapturedLater", "Ldk/molslinjen/domain/model/payment/PaymentType;", "getPaymentType", "()Ldk/molslinjen/domain/model/payment/PaymentType;", "Ldk/molslinjen/domain/model/payment/PaymentOrigin;", "getPaymentOrigin", "()Ldk/molslinjen/domain/model/payment/PaymentOrigin;", "getTransactionId", "Ldk/molslinjen/domain/model/account/CreditCardType;", "getCardType", "()Ldk/molslinjen/domain/model/account/CreditCardType;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class PaymentState {
        private BookingProcessingResult bookingProcessingResult;
        private final CreditCardType cardType;
        private Boolean paymentAndOrderCompleted;
        private boolean paymentCallbackReceived;
        private boolean paymentCapturedLater;
        private final PaymentOrigin paymentOrigin;
        private Boolean paymentSucceeded;
        private final PaymentType paymentType;
        private String reservationNumber;
        private final String transactionId;

        public PaymentState(boolean z5, Boolean bool, Boolean bool2, String str, BookingProcessingResult bookingProcessingResult, boolean z6, PaymentType paymentType, PaymentOrigin paymentOrigin, String str2, CreditCardType cardType) {
            Intrinsics.checkNotNullParameter(bookingProcessingResult, "bookingProcessingResult");
            Intrinsics.checkNotNullParameter(paymentType, "paymentType");
            Intrinsics.checkNotNullParameter(paymentOrigin, "paymentOrigin");
            Intrinsics.checkNotNullParameter(cardType, "cardType");
            this.paymentCallbackReceived = z5;
            this.paymentSucceeded = bool;
            this.paymentAndOrderCompleted = bool2;
            this.reservationNumber = str;
            this.bookingProcessingResult = bookingProcessingResult;
            this.paymentCapturedLater = z6;
            this.paymentType = paymentType;
            this.paymentOrigin = paymentOrigin;
            this.transactionId = str2;
            this.cardType = cardType;
        }

        public static /* synthetic */ PaymentState copy$default(PaymentState paymentState, boolean z5, Boolean bool, Boolean bool2, String str, BookingProcessingResult bookingProcessingResult, boolean z6, PaymentType paymentType, PaymentOrigin paymentOrigin, String str2, CreditCardType creditCardType, int i5, Object obj) {
            return paymentState.copy((i5 & 1) != 0 ? paymentState.paymentCallbackReceived : z5, (i5 & 2) != 0 ? paymentState.paymentSucceeded : bool, (i5 & 4) != 0 ? paymentState.paymentAndOrderCompleted : bool2, (i5 & 8) != 0 ? paymentState.reservationNumber : str, (i5 & 16) != 0 ? paymentState.bookingProcessingResult : bookingProcessingResult, (i5 & 32) != 0 ? paymentState.paymentCapturedLater : z6, (i5 & 64) != 0 ? paymentState.paymentType : paymentType, (i5 & 128) != 0 ? paymentState.paymentOrigin : paymentOrigin, (i5 & 256) != 0 ? paymentState.transactionId : str2, (i5 & 512) != 0 ? paymentState.cardType : creditCardType);
        }

        public final PaymentState copy(boolean paymentCallbackReceived, Boolean paymentSucceeded, Boolean paymentAndOrderCompleted, String reservationNumber, BookingProcessingResult bookingProcessingResult, boolean paymentCapturedLater, PaymentType paymentType, PaymentOrigin paymentOrigin, String transactionId, CreditCardType cardType) {
            Intrinsics.checkNotNullParameter(bookingProcessingResult, "bookingProcessingResult");
            Intrinsics.checkNotNullParameter(paymentType, "paymentType");
            Intrinsics.checkNotNullParameter(paymentOrigin, "paymentOrigin");
            Intrinsics.checkNotNullParameter(cardType, "cardType");
            return new PaymentState(paymentCallbackReceived, paymentSucceeded, paymentAndOrderCompleted, reservationNumber, bookingProcessingResult, paymentCapturedLater, paymentType, paymentOrigin, transactionId, cardType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PaymentState)) {
                return false;
            }
            PaymentState paymentState = (PaymentState) other;
            return this.paymentCallbackReceived == paymentState.paymentCallbackReceived && Intrinsics.areEqual(this.paymentSucceeded, paymentState.paymentSucceeded) && Intrinsics.areEqual(this.paymentAndOrderCompleted, paymentState.paymentAndOrderCompleted) && Intrinsics.areEqual(this.reservationNumber, paymentState.reservationNumber) && this.bookingProcessingResult == paymentState.bookingProcessingResult && this.paymentCapturedLater == paymentState.paymentCapturedLater && this.paymentType == paymentState.paymentType && this.paymentOrigin == paymentState.paymentOrigin && Intrinsics.areEqual(this.transactionId, paymentState.transactionId) && this.cardType == paymentState.cardType;
        }

        public final BookingProcessingResult getBookingProcessingResult() {
            return this.bookingProcessingResult;
        }

        public final CreditCardType getCardType() {
            return this.cardType;
        }

        public final Boolean getPaymentAndOrderCompleted() {
            return this.paymentAndOrderCompleted;
        }

        public final boolean getPaymentCallbackReceived() {
            return this.paymentCallbackReceived;
        }

        public final boolean getPaymentCapturedLater() {
            return this.paymentCapturedLater;
        }

        public final PaymentOrigin getPaymentOrigin() {
            return this.paymentOrigin;
        }

        public final Boolean getPaymentSucceeded() {
            return this.paymentSucceeded;
        }

        public final PaymentType getPaymentType() {
            return this.paymentType;
        }

        public final String getReservationNumber() {
            return this.reservationNumber;
        }

        public final String getTransactionId() {
            return this.transactionId;
        }

        public int hashCode() {
            int hashCode = Boolean.hashCode(this.paymentCallbackReceived) * 31;
            Boolean bool = this.paymentSucceeded;
            int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.paymentAndOrderCompleted;
            int hashCode3 = (hashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            String str = this.reservationNumber;
            int hashCode4 = (((((((((hashCode3 + (str == null ? 0 : str.hashCode())) * 31) + this.bookingProcessingResult.hashCode()) * 31) + Boolean.hashCode(this.paymentCapturedLater)) * 31) + this.paymentType.hashCode()) * 31) + this.paymentOrigin.hashCode()) * 31;
            String str2 = this.transactionId;
            return ((hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.cardType.hashCode();
        }

        public String toString() {
            return "PaymentState(paymentCallbackReceived=" + this.paymentCallbackReceived + ", paymentSucceeded=" + this.paymentSucceeded + ", paymentAndOrderCompleted=" + this.paymentAndOrderCompleted + ", reservationNumber=" + this.reservationNumber + ", bookingProcessingResult=" + this.bookingProcessingResult + ", paymentCapturedLater=" + this.paymentCapturedLater + ", paymentType=" + this.paymentType + ", paymentOrigin=" + this.paymentOrigin + ", transactionId=" + this.transactionId + ", cardType=" + this.cardType + ")";
        }

        public /* synthetic */ PaymentState(boolean z5, Boolean bool, Boolean bool2, String str, BookingProcessingResult bookingProcessingResult, boolean z6, PaymentType paymentType, PaymentOrigin paymentOrigin, String str2, CreditCardType creditCardType, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? false : z5, (i5 & 2) != 0 ? null : bool, (i5 & 4) != 0 ? null : bool2, (i5 & 8) != 0 ? null : str, (i5 & 16) != 0 ? BookingProcessingResult.Pay : bookingProcessingResult, (i5 & 32) == 0 ? z6 : false, (i5 & 64) != 0 ? PaymentType.Card : paymentType, (i5 & 128) != 0 ? PaymentOrigin.Ticket : paymentOrigin, (i5 & 256) == 0 ? str2 : null, (i5 & 512) != 0 ? CreditCardType.Other : creditCardType);
        }
    }
}
