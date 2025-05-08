package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.domain.analytics.AnalyticsEvent;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.agreement.commuter.bornholm.IBornholmCommuterManager;
import dk.molslinjen.domain.managers.agreement.multiride.IMultiRideManager;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.checkout.IPaymentManager;
import dk.molslinjen.domain.managers.checkout.PaymentManager;
import dk.molslinjen.domain.managers.ticket.ITicketsManager;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.CheckoutContactInfo;
import dk.molslinjen.domain.model.payment.PaymentOrigin;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CheckoutManager$handlePurchaseCompleted$2<T> implements FlowCollector {
    final /* synthetic */ CheckoutManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.checkout.CheckoutManager$handlePurchaseCompleted$2$1", f = "CheckoutManager.kt", l = {437}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.checkout.CheckoutManager$handlePurchaseCompleted$2$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PhoneNumber $phoneNumber;
        final /* synthetic */ String $reservationNumber;
        int label;
        final /* synthetic */ CheckoutManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CheckoutManager checkoutManager, PhoneNumber phoneNumber, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = checkoutManager;
            this.$phoneNumber = phoneNumber;
            this.$reservationNumber = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$phoneNumber, this.$reservationNumber, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ITicketsManager iTicketsManager;
            Object returnReservationNumber;
            CheckoutManager.CheckoutState checkoutState;
            MutableStateFlow<CheckoutManager.CheckoutState> mutableStateFlow;
            CheckoutManager.CheckoutState checkoutState2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                iTicketsManager = this.this$0.ticketsManager;
                PhoneNumber phoneNumber = this.$phoneNumber;
                String str = this.$reservationNumber;
                this.label = 1;
                returnReservationNumber = iTicketsManager.getReturnReservationNumber(phoneNumber, str, this);
                if (returnReservationNumber == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                returnReservationNumber = obj;
            }
            String str2 = (String) ManagerResultExtensionsKt.toData((ManagerResult) returnReservationNumber);
            Logger.log$default(Logger.INSTANCE, "Load purchased ticket returnReservationNumber: '" + str2 + "'", "ReturnReservationNumber", 0, 4, null);
            MutableStateFlow<CheckoutManager.CheckoutState> checkoutState3 = this.this$0.getCheckoutState();
            while (true) {
                CheckoutManager.CheckoutState value = checkoutState3.getValue();
                CheckoutManager.CheckoutState checkoutState4 = value;
                if (checkoutState4 != null) {
                    checkoutState = value;
                    mutableStateFlow = checkoutState3;
                    checkoutState2 = CheckoutManager.CheckoutState.copy$default(checkoutState4, null, null, null, null, false, false, null, null, null, null, str2, null, false, null, false, null, null, null, null, false, null, 2096127, null);
                } else {
                    checkoutState = value;
                    mutableStateFlow = checkoutState3;
                    checkoutState2 = null;
                }
                if (mutableStateFlow.compareAndSet(checkoutState, checkoutState2)) {
                    return Unit.INSTANCE;
                }
                checkoutState3 = mutableStateFlow;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.checkout.CheckoutManager$handlePurchaseCompleted$2$2", f = "CheckoutManager.kt", l = {448}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.checkout.CheckoutManager$handlePurchaseCompleted$2$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PhoneNumber $phoneNumber;
        final /* synthetic */ String $reservationNumber;
        int label;
        final /* synthetic */ CheckoutManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(CheckoutManager checkoutManager, PhoneNumber phoneNumber, String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = checkoutManager;
            this.$phoneNumber = phoneNumber;
            this.$reservationNumber = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$phoneNumber, this.$reservationNumber, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ITicketsManager iTicketsManager;
            Object addTicketsAfterPurchase;
            CheckoutManager.CheckoutState checkoutState;
            MutableStateFlow<CheckoutManager.CheckoutState> mutableStateFlow;
            CheckoutManager.CheckoutState checkoutState2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                iTicketsManager = this.this$0.ticketsManager;
                PhoneNumber phoneNumber = this.$phoneNumber;
                String str = this.$reservationNumber;
                this.label = 1;
                addTicketsAfterPurchase = iTicketsManager.addTicketsAfterPurchase(phoneNumber, str, this);
                if (addTicketsAfterPurchase == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                addTicketsAfterPurchase = obj;
            }
            String str2 = (String) ManagerResultExtensionsKt.toData((ManagerResult) addTicketsAfterPurchase);
            Logger.log$default(Logger.INSTANCE, "Load purchased ticket returnReservationNumber: '" + str2 + "'", "ReturnReservationNumber", 0, 4, null);
            MutableStateFlow<CheckoutManager.CheckoutState> checkoutState3 = this.this$0.getCheckoutState();
            while (true) {
                CheckoutManager.CheckoutState value = checkoutState3.getValue();
                CheckoutManager.CheckoutState checkoutState4 = value;
                if (checkoutState4 != null) {
                    checkoutState = value;
                    mutableStateFlow = checkoutState3;
                    checkoutState2 = CheckoutManager.CheckoutState.copy$default(checkoutState4, null, null, null, null, false, false, null, null, null, null, str2, null, false, null, false, null, null, null, null, false, null, 2096127, null);
                } else {
                    checkoutState = value;
                    mutableStateFlow = checkoutState3;
                    checkoutState2 = null;
                }
                if (mutableStateFlow.compareAndSet(checkoutState, checkoutState2)) {
                    return Unit.INSTANCE;
                }
                checkoutState3 = mutableStateFlow;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PaymentOrigin.values().length];
            try {
                iArr[PaymentOrigin.MultiRideTicketFromDetails.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PaymentOrigin.MultiRideTicketFromAgreements.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PaymentOrigin.CommuterTicketFromDetails.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PaymentOrigin.CommuterTicketFromAgreements.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CheckoutManager$handlePurchaseCompleted$2(CheckoutManager checkoutManager) {
        this.this$0 = checkoutManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x01b9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01f9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(PaymentManager.PaymentState paymentState, Continuation<? super Unit> continuation) {
        CheckoutManager$handlePurchaseCompleted$2$emit$1 checkoutManager$handlePurchaseCompleted$2$emit$1;
        Object coroutine_suspended;
        int i5;
        CheckoutManager.CheckoutState value;
        String reservationNumber;
        PhoneNumber phoneNumber;
        PaymentManager.PaymentState paymentState2;
        String str;
        CheckoutManager$handlePurchaseCompleted$2<T> checkoutManager$handlePurchaseCompleted$2;
        Object updatePurchaseCount;
        CheckoutManager$handlePurchaseCompleted$2<T> checkoutManager$handlePurchaseCompleted$22;
        CheckoutContactInfo personalInfo;
        IAnalyticsTracker iAnalyticsTracker;
        IUserManager iUserManager;
        ITicketsManager iTicketsManager;
        PaymentManager.PaymentState paymentState3;
        IUserManager iUserManager2;
        CoroutineScope coroutineScope;
        ITicketsManager iTicketsManager2;
        CoroutineScope coroutineScope2;
        int i6;
        IMultiRideManager iMultiRideManager;
        CheckoutManager$handlePurchaseCompleted$2<T> checkoutManager$handlePurchaseCompleted$23;
        IBornholmCommuterManager iBornholmCommuterManager;
        IPaymentManager iPaymentManager;
        if (continuation instanceof CheckoutManager$handlePurchaseCompleted$2$emit$1) {
            checkoutManager$handlePurchaseCompleted$2$emit$1 = (CheckoutManager$handlePurchaseCompleted$2$emit$1) continuation;
            int i7 = checkoutManager$handlePurchaseCompleted$2$emit$1.label;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                checkoutManager$handlePurchaseCompleted$2$emit$1.label = i7 - Integer.MIN_VALUE;
                Object obj = checkoutManager$handlePurchaseCompleted$2$emit$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = checkoutManager$handlePurchaseCompleted$2$emit$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    List listOf = CollectionsKt.listOf((Object[]) new PaymentOrigin[]{PaymentOrigin.Ticket, PaymentOrigin.TicketChange, PaymentOrigin.MultiRideTicketFromDetails, PaymentOrigin.MultiRideTicketFromAgreements, PaymentOrigin.CommuterTicketFromDetails, PaymentOrigin.CommuterTicketFromAgreements});
                    if (Intrinsics.areEqual(paymentState.getPaymentSucceeded(), Boxing.boxBoolean(true)) && listOf.contains(paymentState.getPaymentOrigin())) {
                        value = this.this$0.getCheckoutState().getValue();
                        reservationNumber = paymentState.getReservationNumber();
                        phoneNumber = (value == null || (personalInfo = value.getPersonalInfo()) == null) ? null : personalInfo.getPhoneNumber();
                        if (value != null && reservationNumber != null && phoneNumber != null) {
                            if (value.getEditingBooking() == null) {
                                CheckoutManager checkoutManager = this.this$0;
                                checkoutManager$handlePurchaseCompleted$2$emit$1.L$0 = this;
                                paymentState2 = paymentState;
                                checkoutManager$handlePurchaseCompleted$2$emit$1.L$1 = paymentState2;
                                checkoutManager$handlePurchaseCompleted$2$emit$1.L$2 = value;
                                checkoutManager$handlePurchaseCompleted$2$emit$1.L$3 = reservationNumber;
                                checkoutManager$handlePurchaseCompleted$2$emit$1.L$4 = phoneNumber;
                                checkoutManager$handlePurchaseCompleted$2$emit$1.label = 1;
                                updatePurchaseCount = checkoutManager.updatePurchaseCount(checkoutManager$handlePurchaseCompleted$2$emit$1);
                                if (updatePurchaseCount == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                checkoutManager$handlePurchaseCompleted$22 = this;
                            } else {
                                paymentState2 = paymentState;
                                str = reservationNumber;
                                checkoutManager$handlePurchaseCompleted$2 = this;
                                iAnalyticsTracker = checkoutManager$handlePurchaseCompleted$2.this$0.analyticsTracker;
                                CheckoutManager checkoutManager2 = checkoutManager$handlePurchaseCompleted$2.this$0;
                                iUserManager = checkoutManager2.userManager;
                                iAnalyticsTracker.trackPurchase(checkoutManager2, iUserManager);
                                if (value.getEditingBooking() == null) {
                                    iUserManager2 = checkoutManager$handlePurchaseCompleted$2.this$0.userManager;
                                    if (iUserManager2.getAuthenticationType().getValue().isAuthenticated()) {
                                        if (value.getBookingType() == BookingType.TwoWay) {
                                            coroutineScope2 = checkoutManager$handlePurchaseCompleted$2.this$0.coroutineScope;
                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(checkoutManager$handlePurchaseCompleted$2.this$0, phoneNumber, str, null), 3, null);
                                        }
                                        iTicketsManager2 = checkoutManager$handlePurchaseCompleted$2.this$0.ticketsManager;
                                        checkoutManager$handlePurchaseCompleted$2$emit$1.L$0 = checkoutManager$handlePurchaseCompleted$2;
                                        checkoutManager$handlePurchaseCompleted$2$emit$1.L$1 = paymentState2;
                                        checkoutManager$handlePurchaseCompleted$2$emit$1.L$2 = null;
                                        checkoutManager$handlePurchaseCompleted$2$emit$1.L$3 = null;
                                        checkoutManager$handlePurchaseCompleted$2$emit$1.L$4 = null;
                                        checkoutManager$handlePurchaseCompleted$2$emit$1.label = 2;
                                        if (iTicketsManager2.updateLocalBookings(checkoutManager$handlePurchaseCompleted$2$emit$1) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        coroutineScope = checkoutManager$handlePurchaseCompleted$2.this$0.coroutineScope;
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass2(checkoutManager$handlePurchaseCompleted$2.this$0, phoneNumber, str, null), 3, null);
                                    }
                                } else {
                                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(checkoutManager$handlePurchaseCompleted$2$emit$1.getContext()), null, null, new CheckoutManager$handlePurchaseCompleted$2$3$1(checkoutManager$handlePurchaseCompleted$2.this$0, value, null), 3, null);
                                    iTicketsManager = checkoutManager$handlePurchaseCompleted$2.this$0.ticketsManager;
                                    checkoutManager$handlePurchaseCompleted$2$emit$1.L$0 = checkoutManager$handlePurchaseCompleted$2;
                                    checkoutManager$handlePurchaseCompleted$2$emit$1.L$1 = paymentState2;
                                    checkoutManager$handlePurchaseCompleted$2$emit$1.L$2 = null;
                                    checkoutManager$handlePurchaseCompleted$2$emit$1.L$3 = null;
                                    checkoutManager$handlePurchaseCompleted$2$emit$1.L$4 = null;
                                    checkoutManager$handlePurchaseCompleted$2$emit$1.label = 3;
                                    if (iTicketsManager.updateLocalBookings(checkoutManager$handlePurchaseCompleted$2$emit$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                                paymentState3 = paymentState2;
                                AnalyticsEvent.BookingInitiated.INSTANCE.reset();
                                i6 = WhenMappings.$EnumSwitchMapping$0[paymentState3.getPaymentOrigin().ordinal()];
                                if (i6 != 1) {
                                }
                                iMultiRideManager = checkoutManager$handlePurchaseCompleted$2.this$0.multiRideManager;
                                checkoutManager$handlePurchaseCompleted$2$emit$1.L$0 = checkoutManager$handlePurchaseCompleted$2;
                                checkoutManager$handlePurchaseCompleted$2$emit$1.L$1 = null;
                                checkoutManager$handlePurchaseCompleted$2$emit$1.L$2 = null;
                                checkoutManager$handlePurchaseCompleted$2$emit$1.L$3 = null;
                                checkoutManager$handlePurchaseCompleted$2$emit$1.L$4 = null;
                                checkoutManager$handlePurchaseCompleted$2$emit$1.label = 4;
                                if (iMultiRideManager.loadMultiRides(checkoutManager$handlePurchaseCompleted$2$emit$1) != coroutine_suspended) {
                                }
                            }
                        } else {
                            Logger.INSTANCE.logCritical(new CriticalLog("Load purchased ticket failed: ReservationNumber: '" + reservationNumber + "', PhoneNumber '" + phoneNumber + "'"));
                            return Unit.INSTANCE;
                        }
                    }
                    return Unit.INSTANCE;
                }
                if (i5 != 1) {
                    if (i5 != 2 && i5 != 3) {
                        if (i5 == 4) {
                            checkoutManager$handlePurchaseCompleted$23 = (CheckoutManager$handlePurchaseCompleted$2) checkoutManager$handlePurchaseCompleted$2$emit$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            checkoutManager$handlePurchaseCompleted$2 = checkoutManager$handlePurchaseCompleted$23;
                            iPaymentManager = checkoutManager$handlePurchaseCompleted$2.this$0.paymentManager;
                            IPaymentManager.DefaultImpls.readyForPaymentStateReset$default(iPaymentManager, Boxing.boxBoolean(true), null, 2, null);
                            return Unit.INSTANCE;
                        }
                        if (i5 != 5) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        checkoutManager$handlePurchaseCompleted$23 = (CheckoutManager$handlePurchaseCompleted$2) checkoutManager$handlePurchaseCompleted$2$emit$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        Unit unit = Unit.INSTANCE;
                        checkoutManager$handlePurchaseCompleted$2 = checkoutManager$handlePurchaseCompleted$23;
                        iPaymentManager = checkoutManager$handlePurchaseCompleted$2.this$0.paymentManager;
                        IPaymentManager.DefaultImpls.readyForPaymentStateReset$default(iPaymentManager, Boxing.boxBoolean(true), null, 2, null);
                        return Unit.INSTANCE;
                    }
                    paymentState3 = (PaymentManager.PaymentState) checkoutManager$handlePurchaseCompleted$2$emit$1.L$1;
                    checkoutManager$handlePurchaseCompleted$2 = (CheckoutManager$handlePurchaseCompleted$2) checkoutManager$handlePurchaseCompleted$2$emit$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    AnalyticsEvent.BookingInitiated.INSTANCE.reset();
                    i6 = WhenMappings.$EnumSwitchMapping$0[paymentState3.getPaymentOrigin().ordinal()];
                    if (i6 != 1 || i6 == 2) {
                        iMultiRideManager = checkoutManager$handlePurchaseCompleted$2.this$0.multiRideManager;
                        checkoutManager$handlePurchaseCompleted$2$emit$1.L$0 = checkoutManager$handlePurchaseCompleted$2;
                        checkoutManager$handlePurchaseCompleted$2$emit$1.L$1 = null;
                        checkoutManager$handlePurchaseCompleted$2$emit$1.L$2 = null;
                        checkoutManager$handlePurchaseCompleted$2$emit$1.L$3 = null;
                        checkoutManager$handlePurchaseCompleted$2$emit$1.L$4 = null;
                        checkoutManager$handlePurchaseCompleted$2$emit$1.label = 4;
                        if (iMultiRideManager.loadMultiRides(checkoutManager$handlePurchaseCompleted$2$emit$1) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        checkoutManager$handlePurchaseCompleted$23 = checkoutManager$handlePurchaseCompleted$2;
                        checkoutManager$handlePurchaseCompleted$2 = checkoutManager$handlePurchaseCompleted$23;
                        iPaymentManager = checkoutManager$handlePurchaseCompleted$2.this$0.paymentManager;
                        IPaymentManager.DefaultImpls.readyForPaymentStateReset$default(iPaymentManager, Boxing.boxBoolean(true), null, 2, null);
                        return Unit.INSTANCE;
                    }
                    if (i6 != 3 && i6 != 4) {
                        Unit unit2 = Unit.INSTANCE;
                        iPaymentManager = checkoutManager$handlePurchaseCompleted$2.this$0.paymentManager;
                        IPaymentManager.DefaultImpls.readyForPaymentStateReset$default(iPaymentManager, Boxing.boxBoolean(true), null, 2, null);
                        return Unit.INSTANCE;
                    }
                    iBornholmCommuterManager = checkoutManager$handlePurchaseCompleted$2.this$0.commuterManager;
                    checkoutManager$handlePurchaseCompleted$2$emit$1.L$0 = checkoutManager$handlePurchaseCompleted$2;
                    checkoutManager$handlePurchaseCompleted$2$emit$1.L$1 = null;
                    checkoutManager$handlePurchaseCompleted$2$emit$1.L$2 = null;
                    checkoutManager$handlePurchaseCompleted$2$emit$1.L$3 = null;
                    checkoutManager$handlePurchaseCompleted$2$emit$1.L$4 = null;
                    checkoutManager$handlePurchaseCompleted$2$emit$1.label = 5;
                    if (iBornholmCommuterManager.loadAgreements(checkoutManager$handlePurchaseCompleted$2$emit$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    checkoutManager$handlePurchaseCompleted$23 = checkoutManager$handlePurchaseCompleted$2;
                    Unit unit3 = Unit.INSTANCE;
                    checkoutManager$handlePurchaseCompleted$2 = checkoutManager$handlePurchaseCompleted$23;
                    iPaymentManager = checkoutManager$handlePurchaseCompleted$2.this$0.paymentManager;
                    IPaymentManager.DefaultImpls.readyForPaymentStateReset$default(iPaymentManager, Boxing.boxBoolean(true), null, 2, null);
                    return Unit.INSTANCE;
                }
                phoneNumber = (PhoneNumber) checkoutManager$handlePurchaseCompleted$2$emit$1.L$4;
                reservationNumber = (String) checkoutManager$handlePurchaseCompleted$2$emit$1.L$3;
                value = (CheckoutManager.CheckoutState) checkoutManager$handlePurchaseCompleted$2$emit$1.L$2;
                paymentState2 = (PaymentManager.PaymentState) checkoutManager$handlePurchaseCompleted$2$emit$1.L$1;
                checkoutManager$handlePurchaseCompleted$22 = (CheckoutManager$handlePurchaseCompleted$2) checkoutManager$handlePurchaseCompleted$2$emit$1.L$0;
                ResultKt.throwOnFailure(obj);
                str = reservationNumber;
                checkoutManager$handlePurchaseCompleted$2 = checkoutManager$handlePurchaseCompleted$22;
                iAnalyticsTracker = checkoutManager$handlePurchaseCompleted$2.this$0.analyticsTracker;
                CheckoutManager checkoutManager22 = checkoutManager$handlePurchaseCompleted$2.this$0;
                iUserManager = checkoutManager22.userManager;
                iAnalyticsTracker.trackPurchase(checkoutManager22, iUserManager);
                if (value.getEditingBooking() == null) {
                }
                paymentState3 = paymentState2;
                AnalyticsEvent.BookingInitiated.INSTANCE.reset();
                i6 = WhenMappings.$EnumSwitchMapping$0[paymentState3.getPaymentOrigin().ordinal()];
                if (i6 != 1) {
                }
                iMultiRideManager = checkoutManager$handlePurchaseCompleted$2.this$0.multiRideManager;
                checkoutManager$handlePurchaseCompleted$2$emit$1.L$0 = checkoutManager$handlePurchaseCompleted$2;
                checkoutManager$handlePurchaseCompleted$2$emit$1.L$1 = null;
                checkoutManager$handlePurchaseCompleted$2$emit$1.L$2 = null;
                checkoutManager$handlePurchaseCompleted$2$emit$1.L$3 = null;
                checkoutManager$handlePurchaseCompleted$2$emit$1.L$4 = null;
                checkoutManager$handlePurchaseCompleted$2$emit$1.label = 4;
                if (iMultiRideManager.loadMultiRides(checkoutManager$handlePurchaseCompleted$2$emit$1) != coroutine_suspended) {
                }
            }
        }
        checkoutManager$handlePurchaseCompleted$2$emit$1 = new CheckoutManager$handlePurchaseCompleted$2$emit$1(this, continuation);
        Object obj2 = checkoutManager$handlePurchaseCompleted$2$emit$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = checkoutManager$handlePurchaseCompleted$2$emit$1.label;
        if (i5 != 0) {
        }
        str = reservationNumber;
        checkoutManager$handlePurchaseCompleted$2 = checkoutManager$handlePurchaseCompleted$22;
        iAnalyticsTracker = checkoutManager$handlePurchaseCompleted$2.this$0.analyticsTracker;
        CheckoutManager checkoutManager222 = checkoutManager$handlePurchaseCompleted$2.this$0;
        iUserManager = checkoutManager222.userManager;
        iAnalyticsTracker.trackPurchase(checkoutManager222, iUserManager);
        if (value.getEditingBooking() == null) {
        }
        paymentState3 = paymentState2;
        AnalyticsEvent.BookingInitiated.INSTANCE.reset();
        i6 = WhenMappings.$EnumSwitchMapping$0[paymentState3.getPaymentOrigin().ordinal()];
        if (i6 != 1) {
        }
        iMultiRideManager = checkoutManager$handlePurchaseCompleted$2.this$0.multiRideManager;
        checkoutManager$handlePurchaseCompleted$2$emit$1.L$0 = checkoutManager$handlePurchaseCompleted$2;
        checkoutManager$handlePurchaseCompleted$2$emit$1.L$1 = null;
        checkoutManager$handlePurchaseCompleted$2$emit$1.L$2 = null;
        checkoutManager$handlePurchaseCompleted$2$emit$1.L$3 = null;
        checkoutManager$handlePurchaseCompleted$2$emit$1.L$4 = null;
        checkoutManager$handlePurchaseCompleted$2$emit$1.label = 4;
        if (iMultiRideManager.loadMultiRides(checkoutManager$handlePurchaseCompleted$2$emit$1) != coroutine_suspended) {
        }
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return emit((PaymentManager.PaymentState) obj, (Continuation<? super Unit>) continuation);
    }
}
