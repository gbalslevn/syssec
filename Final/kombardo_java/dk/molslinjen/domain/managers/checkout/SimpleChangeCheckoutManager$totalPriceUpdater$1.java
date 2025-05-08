package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.domain.managers.checkout.SimpleChangeCheckoutManager;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.BookingSeatReservation;
import dk.molslinjen.domain.model.booking.BookingTicket;
import dk.molslinjen.domain.model.booking.product.CheckoutSeatReservation;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.checkout.SimpleChangeCheckoutManager$totalPriceUpdater$1", f = "SimpleChangeCheckoutManager.kt", l = {229}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class SimpleChangeCheckoutManager$totalPriceUpdater$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SimpleChangeCheckoutManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "state", "Ldk/molslinjen/domain/managers/checkout/SimpleChangeCheckoutManager$SimpleChangeCheckoutState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.checkout.SimpleChangeCheckoutManager$totalPriceUpdater$1$1", f = "SimpleChangeCheckoutManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.checkout.SimpleChangeCheckoutManager$totalPriceUpdater$1$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<SimpleChangeCheckoutManager.SimpleChangeCheckoutState, Continuation<? super Unit>, Object> {
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
        public final Object invoke(SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(simpleChangeCheckoutState, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Booking existingBooking;
            SimpleChangeCheckoutManager.SimpleChangeCheckoutState value;
            Booking existingBooking2;
            BookingTicket ticket;
            BookingSeatReservation seatReservation;
            PriceWithCurrency paidPrice;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState = (SimpleChangeCheckoutManager.SimpleChangeCheckoutState) this.L$0;
            Set union = CollectionsKt.union(simpleChangeCheckoutState.getAddons(), simpleChangeCheckoutState.getFood());
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : union) {
                if (((Product) obj2).getQuantity() > 0) {
                    arrayList.add(obj2);
                }
            }
            Integer num = null;
            if (simpleChangeCheckoutState.getInvalidateSeatReservation() && (existingBooking2 = simpleChangeCheckoutState.getExistingBooking()) != null && (ticket = existingBooking2.getTicket()) != null && (seatReservation = ticket.getSeatReservation()) != null && (paidPrice = new CheckoutSeatReservation(seatReservation).getPaidPrice()) != null) {
                num = Boxing.boxInt(paidPrice.getValue());
            }
            int i5 = 0;
            int intValue = num != null ? num.intValue() : 0;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                i5 += ((Product) it.next()).sum().getValue();
            }
            int i6 = i5 - intValue;
            PriceWithCurrency totalPrice = simpleChangeCheckoutState.getTotalPrice();
            if ((totalPrice == null || i6 != totalPrice.getValue()) && (existingBooking = simpleChangeCheckoutState.getExistingBooking()) != null) {
                MutableStateFlow<SimpleChangeCheckoutManager.SimpleChangeCheckoutState> simpleChangeCheckoutState2 = this.this$0.getSimpleChangeCheckoutState();
                do {
                    value = simpleChangeCheckoutState2.getValue();
                } while (!simpleChangeCheckoutState2.compareAndSet(value, SimpleChangeCheckoutManager.SimpleChangeCheckoutState.copy$default(value, null, false, null, null, null, null, new PriceWithCurrency(i6, existingBooking.getOrderTotal().getPrice().getCurrencyType()), null, null, null, null, 1983, null)));
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleChangeCheckoutManager$totalPriceUpdater$1(SimpleChangeCheckoutManager simpleChangeCheckoutManager, Continuation<? super SimpleChangeCheckoutManager$totalPriceUpdater$1> continuation) {
        super(2, continuation);
        this.this$0 = simpleChangeCheckoutManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SimpleChangeCheckoutManager$totalPriceUpdater$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableStateFlow<SimpleChangeCheckoutManager.SimpleChangeCheckoutState> simpleChangeCheckoutState = this.this$0.getSimpleChangeCheckoutState();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (FlowKt.collectLatest(simpleChangeCheckoutState, anonymousClass1, this) == coroutine_suspended) {
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
        return ((SimpleChangeCheckoutManager$totalPriceUpdater$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
