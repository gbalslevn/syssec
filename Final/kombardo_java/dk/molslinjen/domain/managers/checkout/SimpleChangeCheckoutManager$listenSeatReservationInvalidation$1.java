package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper;
import dk.molslinjen.domain.managers.checkout.SimpleChangeCheckoutManager;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.BookingPassengerInfo;
import dk.molslinjen.domain.model.booking.BookingTicket;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.checkout.SimpleChangeCheckoutManager$listenSeatReservationInvalidation$1", f = "SimpleChangeCheckoutManager.kt", l = {61}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class SimpleChangeCheckoutManager$listenSeatReservationInvalidation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SimpleChangeCheckoutManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "passengerState", "Ldk/molslinjen/domain/managers/checkout/PassengerSelectionHelper$PassengerState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.checkout.SimpleChangeCheckoutManager$listenSeatReservationInvalidation$1$1", f = "SimpleChangeCheckoutManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.checkout.SimpleChangeCheckoutManager$listenSeatReservationInvalidation$1$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<PassengerSelectionHelper.PassengerState, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SimpleChangeCheckoutManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SimpleChangeCheckoutManager simpleChangeCheckoutManager, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = simpleChangeCheckoutManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PassengerSelectionHelper.PassengerState passengerState, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(passengerState, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SimpleChangeCheckoutManager.SimpleChangeCheckoutState value;
            SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState;
            Integer boxInt;
            BookingTicket ticket;
            BookingPassengerInfo passengerInfo;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            PassengerSelectionHelper.PassengerState passengerState = (PassengerSelectionHelper.PassengerState) this.L$0;
            MutableStateFlow<SimpleChangeCheckoutManager.SimpleChangeCheckoutState> simpleChangeCheckoutState2 = this.this$0.getSimpleChangeCheckoutState();
            do {
                value = simpleChangeCheckoutState2.getValue();
                simpleChangeCheckoutState = value;
                Booking existingBooking = simpleChangeCheckoutState.getExistingBooking();
                boxInt = (existingBooking == null || (ticket = existingBooking.getTicket()) == null || (passengerInfo = ticket.getPassengerInfo()) == null) ? null : Boxing.boxInt(passengerInfo.getTotalPassengerCount());
            } while (!simpleChangeCheckoutState2.compareAndSet(value, SimpleChangeCheckoutManager.SimpleChangeCheckoutState.copy$default(simpleChangeCheckoutState, null, boxInt == null || boxInt.intValue() != passengerState.getAllSelectedPassengers().size(), null, null, null, null, null, null, null, null, null, 2045, null)));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleChangeCheckoutManager$listenSeatReservationInvalidation$1(SimpleChangeCheckoutManager simpleChangeCheckoutManager, Continuation<? super SimpleChangeCheckoutManager$listenSeatReservationInvalidation$1> continuation) {
        super(2, continuation);
        this.this$0 = simpleChangeCheckoutManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SimpleChangeCheckoutManager$listenSeatReservationInvalidation$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IEarlyCheckInPassengerManager iEarlyCheckInPassengerManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iEarlyCheckInPassengerManager = this.this$0.earlyCheckInPassengerManager;
            StateFlow<PassengerSelectionHelper.PassengerState> passengerState = iEarlyCheckInPassengerManager.getPassengerState();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (FlowKt.collectLatest(passengerState, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SimpleChangeCheckoutManager$listenSeatReservationInvalidation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
