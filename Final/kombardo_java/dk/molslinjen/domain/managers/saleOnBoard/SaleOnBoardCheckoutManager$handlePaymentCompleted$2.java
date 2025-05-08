package dk.molslinjen.domain.managers.saleOnBoard;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.saleOnBoard.ISaleOnBoardService;
import dk.molslinjen.api.services.saleOnBoard.request.PatchOrderRequestParameters;
import dk.molslinjen.api.services.saleOnBoard.response.PlaceOrderResponseDTO;
import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.domain.analytics.AnalyticsEvent;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.extensions.PatchOrderRequestParametersExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.checkout.IPaymentManager;
import dk.molslinjen.domain.managers.checkout.PaymentManager;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager;
import dk.molslinjen.domain.model.booking.IDepartureInfo;
import dk.molslinjen.domain.model.payment.PaymentOrigin;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardDeparture;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardLineItem;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardStore;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardTimeSlot;
import dk.molslinjen.domain.model.settings.ISettings;
import dk.molslinjen.domain.model.settings.SettingsProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaleOnBoardCheckoutManager$handlePaymentCompleted$2<T> implements FlowCollector {
    final /* synthetic */ SaleOnBoardCheckoutManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager$handlePaymentCompleted$2$1", f = "SaleOnBoardCheckoutManager.kt", l = {336, 336, 361}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager$handlePaymentCompleted$2$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
        final /* synthetic */ Integer $preOrderId;
        final /* synthetic */ SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState $saleOnBoardState;
        int label;
        final /* synthetic */ SaleOnBoardCheckoutManager this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Ldk/molslinjen/api/services/saleOnBoard/response/PlaceOrderResponseDTO;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager$handlePaymentCompleted$2$1$1", f = "SaleOnBoardCheckoutManager.kt", l = {353, 357}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager$handlePaymentCompleted$2$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00381 extends SuspendLambda implements Function2<PlaceOrderResponseDTO, Continuation<? super Unit>, Object> {
            final /* synthetic */ SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState $saleOnBoardState;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ SaleOnBoardCheckoutManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00381(SaleOnBoardCheckoutManager saleOnBoardCheckoutManager, SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState, Continuation<? super C00381> continuation) {
                super(2, continuation);
                this.this$0 = saleOnBoardCheckoutManager;
                this.$saleOnBoardState = saleOnBoardCheckoutState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00381 c00381 = new C00381(this.this$0, this.$saleOnBoardState, continuation);
                c00381.L$0 = obj;
                return c00381;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(PlaceOrderResponseDTO placeOrderResponseDTO, Continuation<? super Unit> continuation) {
                return ((C00381) create(placeOrderResponseDTO, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState value;
                SaleOnBoardOrder saleOnBoardOrder;
                ISaleOnBoardManager iSaleOnBoardManager;
                IPaymentManager iPaymentManager;
                ISettings iSettings;
                ISettings iSettings2;
                SaleOnBoardOrder saleOnBoardOrder2;
                IAnalyticsTracker iAnalyticsTracker;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i5 = this.label;
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    PlaceOrderResponseDTO placeOrderResponseDTO = (PlaceOrderResponseDTO) this.L$0;
                    MutableStateFlow<SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState> saleOnBoardCheckoutState = this.this$0.getSaleOnBoardCheckoutState();
                    do {
                        value = saleOnBoardCheckoutState.getValue();
                    } while (!saleOnBoardCheckoutState.compareAndSet(value, SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState.copy$default(value, null, null, null, null, null, null, null, null, null, null, null, null, null, null, placeOrderResponseDTO.getPlacedOrderId(), 16383, null)));
                    String placedOrderId = placeOrderResponseDTO.getPlacedOrderId();
                    String storeLocation = this.$saleOnBoardState.getSelectedStore().getStoreLocation();
                    String iconUrl = this.$saleOnBoardState.getSelectedStore().getIconUrl();
                    List<SaleOnBoardLineItem> basketLineItems = this.$saleOnBoardState.getBasketLineItems();
                    SaleOnBoardDeparture saleOnBoardDeparture = new SaleOnBoardDeparture(this.$saleOnBoardState.getSelectedDeparture());
                    saleOnBoardOrder = new SaleOnBoardOrder(placedOrderId, this.$saleOnBoardState.getSelectedTimeSlot().getStartDateTime(), this.$saleOnBoardState.getSelectedTimeSlot().getEndDateTime(), saleOnBoardDeparture, SaleOnBoardOrder.OrderStatus.Received, basketLineItems, iconUrl, storeLocation, this.$saleOnBoardState.getContactInfo(), this.$saleOnBoardState.getNotificationType());
                    iSaleOnBoardManager = this.this$0.saleOnBoardManager;
                    this.L$0 = saleOnBoardOrder;
                    this.label = 1;
                    if (iSaleOnBoardManager.addOrder(saleOnBoardOrder, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        saleOnBoardOrder2 = (SaleOnBoardOrder) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        iAnalyticsTracker = this.this$0.analyticsTracker;
                        iAnalyticsTracker.trackPurchase(this.this$0, saleOnBoardOrder2);
                        AnalyticsEvent.BookingInitiated.INSTANCE.reset();
                        return Unit.INSTANCE;
                    }
                    saleOnBoardOrder = (SaleOnBoardOrder) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                iPaymentManager = this.this$0.paymentManager;
                iPaymentManager.setPaymentCompletedAfterOrderProcessingPostPayment();
                iSettings = this.this$0.settings;
                SettingsProperty.Tracking.SaleOnBoardPurchasedCount saleOnBoardPurchasedCount = SettingsProperty.Tracking.SaleOnBoardPurchasedCount.INSTANCE;
                Object latestValueFor = iSettings.latestValueFor(saleOnBoardPurchasedCount);
                SaleOnBoardCheckoutManager saleOnBoardCheckoutManager = this.this$0;
                int intValue = ((Number) latestValueFor).intValue();
                iSettings2 = saleOnBoardCheckoutManager.settings;
                Integer boxInt = Boxing.boxInt(intValue + 1);
                this.L$0 = saleOnBoardOrder;
                this.label = 2;
                if (iSettings2.update(saleOnBoardPurchasedCount, boxInt, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                saleOnBoardOrder2 = saleOnBoardOrder;
                iAnalyticsTracker = this.this$0.analyticsTracker;
                iAnalyticsTracker.trackPurchase(this.this$0, saleOnBoardOrder2);
                AnalyticsEvent.BookingInitiated.INSTANCE.reset();
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager$handlePaymentCompleted$2$1$2", f = "SaleOnBoardCheckoutManager.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager$handlePaymentCompleted$2$1$2, reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ SaleOnBoardCheckoutManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(SaleOnBoardCheckoutManager saleOnBoardCheckoutManager, Continuation<? super AnonymousClass2> continuation) {
                super(1, continuation);
                this.this$0 = saleOnBoardCheckoutManager;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IPaymentManager iPaymentManager;
                IAnalyticsTracker iAnalyticsTracker;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                iPaymentManager = this.this$0.paymentManager;
                iPaymentManager.setPaymentFailedAfterOrderProcessingPostPayment();
                iAnalyticsTracker = this.this$0.analyticsTracker;
                iAnalyticsTracker.trackEvent(AnalyticsEvent.SaleOnBoardOrderError.INSTANCE);
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SaleOnBoardCheckoutManager saleOnBoardCheckoutManager, Integer num, SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = saleOnBoardCheckoutManager;
            this.$preOrderId = num;
            this.$saleOnBoardState = saleOnBoardCheckoutState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$preOrderId, this.$saleOnBoardState, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0067 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ISaleOnBoardService iSaleOnBoardService;
            AnonymousClass2 anonymousClass2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                iSaleOnBoardService = this.this$0.saleOnBoardService;
                int intValue = this.$preOrderId.intValue();
                this.label = 1;
                obj = iSaleOnBoardService.placeOrder(intValue, this);
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
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                    anonymousClass2 = new AnonymousClass2(this.this$0, null);
                    this.label = 3;
                    if (ManagerResultExtensionsKt.onFailure((ManagerResult) obj, anonymousClass2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            ManagerResult managerResult = ManagerResultExtensionsKt.toManagerResult((ApiResult) obj);
            C00381 c00381 = new C00381(this.this$0, this.$saleOnBoardState, null);
            this.label = 2;
            obj = ManagerResultExtensionsKt.onSuccess(managerResult, c00381, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            anonymousClass2 = new AnonymousClass2(this.this$0, null);
            this.label = 3;
            if (ManagerResultExtensionsKt.onFailure((ManagerResult) obj, anonymousClass2, this) == coroutine_suspended) {
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager$handlePaymentCompleted$2$2", f = "SaleOnBoardCheckoutManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager$handlePaymentCompleted$2$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SaleOnBoardCheckoutManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(SaleOnBoardCheckoutManager saleOnBoardCheckoutManager, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.this$0 = saleOnBoardCheckoutManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IPaymentManager iPaymentManager;
            IAnalyticsTracker iAnalyticsTracker;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            iPaymentManager = this.this$0.paymentManager;
            iPaymentManager.setPaymentFailedAfterOrderProcessingPostPayment();
            iAnalyticsTracker = this.this$0.analyticsTracker;
            iAnalyticsTracker.trackEvent(AnalyticsEvent.SaleOnBoardOrderError.INSTANCE);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SaleOnBoardCheckoutManager$handlePaymentCompleted$2(SaleOnBoardCheckoutManager saleOnBoardCheckoutManager) {
        this.this$0 = saleOnBoardCheckoutManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0171 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x015d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(PaymentManager.PaymentState paymentState, Continuation<? super Unit> continuation) {
        SaleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1 saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1;
        Object obj;
        Object coroutine_suspended;
        int i5;
        Integer preOrderId;
        IPaymentManager iPaymentManager;
        IAnalyticsTracker iAnalyticsTracker;
        ISaleOnBoardService iSaleOnBoardService;
        SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState;
        SaleOnBoardCheckoutManager$handlePaymentCompleted$2<T> saleOnBoardCheckoutManager$handlePaymentCompleted$2;
        AnonymousClass2 anonymousClass2;
        if (continuation instanceof SaleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1) {
            saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1 = (SaleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1) continuation;
            int i6 = saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1.label = i6 - Integer.MIN_VALUE;
                obj = saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (Intrinsics.areEqual(paymentState.getPaymentSucceeded(), Boxing.boxBoolean(true)) && paymentState.getPaymentOrigin() == PaymentOrigin.SaleOnBoard) {
                        if (Intrinsics.areEqual(paymentState.getPaymentAndOrderCompleted(), Boxing.boxBoolean(true))) {
                            return Unit.INSTANCE;
                        }
                        SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState value = this.this$0.getSaleOnBoardCheckoutState().getValue();
                        SaleOnBoardTimeSlot selectedTimeSlot = value.getSelectedTimeSlot();
                        Integer boxInt = selectedTimeSlot != null ? Boxing.boxInt(selectedTimeSlot.getId()) : null;
                        preOrderId = value.getPreOrderId();
                        String transactionId = paymentState.getTransactionId();
                        IDepartureInfo selectedDeparture = value.getSelectedDeparture();
                        String timeTableId = selectedDeparture != null ? selectedDeparture.getTimeTableId() : null;
                        SaleOnBoardStore selectedStore = value.getSelectedStore();
                        String storeNumber = selectedStore != null ? selectedStore.getStoreNumber() : null;
                        if (preOrderId != null && boxInt != null && transactionId != null && timeTableId != null && storeNumber != null) {
                            PatchOrderRequestParameters invoke = PatchOrderRequestParametersExtensionsKt.invoke(PatchOrderRequestParameters.INSTANCE, value.getContactInfo().getName(), value.getContactInfo().getPhoneNumber().getNationalNumber(), value.getContactInfo().getPhoneNumber().getCountryCode(), value.getContactInfo().getEmail(), value.getNotificationType(), timeTableId, storeNumber, boxInt.intValue(), value.getBasketLineItems(), transactionId, paymentState.getCardType());
                            iSaleOnBoardService = this.this$0.saleOnBoardService;
                            int intValue = preOrderId.intValue();
                            saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1.L$0 = this;
                            saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1.L$1 = value;
                            saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1.L$2 = preOrderId;
                            saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1.label = 1;
                            Object patchOrder = iSaleOnBoardService.patchOrder(intValue, invoke, saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1);
                            if (patchOrder == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            saleOnBoardCheckoutState = value;
                            obj = patchOrder;
                            saleOnBoardCheckoutManager$handlePaymentCompleted$2 = this;
                        } else {
                            String str = storeNumber;
                            String str2 = timeTableId;
                            iPaymentManager = this.this$0.paymentManager;
                            iPaymentManager.setPaymentFailedAfterOrderProcessingPostPayment();
                            iAnalyticsTracker = this.this$0.analyticsTracker;
                            iAnalyticsTracker.trackEvent(AnalyticsEvent.SaleOnBoardOrderError.INSTANCE);
                            Logger.INSTANCE.logCritical(new CriticalLog("SaleOnBoard handlePaymentCompleted failed. preOrderId(" + preOrderId + ") or timeSlotId(" + boxInt + ") or transactionId(" + transactionId + ") or timeTableId(" + str2 + ") or storeNumber(" + str + ") is null"));
                            return Unit.INSTANCE;
                        }
                    } else {
                        return Unit.INSTANCE;
                    }
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        saleOnBoardCheckoutManager$handlePaymentCompleted$2 = (SaleOnBoardCheckoutManager$handlePaymentCompleted$2) saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        anonymousClass2 = new AnonymousClass2(saleOnBoardCheckoutManager$handlePaymentCompleted$2.this$0, null);
                        saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1.L$0 = null;
                        saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1.label = 3;
                        if (ManagerResultExtensionsKt.onFailure((ManagerResult) obj, anonymousClass2, saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    Integer num = (Integer) saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1.L$2;
                    saleOnBoardCheckoutState = (SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState) saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1.L$1;
                    SaleOnBoardCheckoutManager$handlePaymentCompleted$2<T> saleOnBoardCheckoutManager$handlePaymentCompleted$22 = (SaleOnBoardCheckoutManager$handlePaymentCompleted$2) saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    preOrderId = num;
                    saleOnBoardCheckoutManager$handlePaymentCompleted$2 = saleOnBoardCheckoutManager$handlePaymentCompleted$22;
                }
                ManagerResult managerResult = ManagerResultExtensionsKt.toManagerResult((ApiResult) obj);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(saleOnBoardCheckoutManager$handlePaymentCompleted$2.this$0, preOrderId, saleOnBoardCheckoutState, null);
                saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1.L$0 = saleOnBoardCheckoutManager$handlePaymentCompleted$2;
                saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1.L$1 = null;
                saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1.L$2 = null;
                saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1.label = 2;
                obj = ManagerResultExtensionsKt.onSuccess(managerResult, anonymousClass1, saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                anonymousClass2 = new AnonymousClass2(saleOnBoardCheckoutManager$handlePaymentCompleted$2.this$0, null);
                saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1.L$0 = null;
                saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1.label = 3;
                if (ManagerResultExtensionsKt.onFailure((ManagerResult) obj, anonymousClass2, saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            }
        }
        saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1 = new SaleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1(this, continuation);
        obj = saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1.label;
        if (i5 != 0) {
        }
        ManagerResult managerResult2 = ManagerResultExtensionsKt.toManagerResult((ApiResult) obj);
        AnonymousClass1 anonymousClass12 = new AnonymousClass1(saleOnBoardCheckoutManager$handlePaymentCompleted$2.this$0, preOrderId, saleOnBoardCheckoutState, null);
        saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1.L$0 = saleOnBoardCheckoutManager$handlePaymentCompleted$2;
        saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1.L$1 = null;
        saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1.L$2 = null;
        saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1.label = 2;
        obj = ManagerResultExtensionsKt.onSuccess(managerResult2, anonymousClass12, saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1);
        if (obj == coroutine_suspended) {
        }
        anonymousClass2 = new AnonymousClass2(saleOnBoardCheckoutManager$handlePaymentCompleted$2.this$0, null);
        saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1.L$0 = null;
        saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1.label = 3;
        if (ManagerResultExtensionsKt.onFailure((ManagerResult) obj, anonymousClass2, saleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return emit((PaymentManager.PaymentState) obj, (Continuation<? super Unit>) continuation);
    }
}
