package dk.molslinjen.core.push;

import android.content.Context;
import com.ramcosta.composedestinations.generated.destinations.TicketDetailsScreenDestination;
import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.domain.localstorage.bookings.IBookingsRepository;
import dk.molslinjen.domain.model.booking.BookingHeader;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.core.push.PushHandler$openedNotification$1", f = "PushHandler.kt", l = {108}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class PushHandler$openedNotification$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $tagValue;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PushHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushHandler$openedNotification$1(PushHandler pushHandler, String str, Context context, Continuation<? super PushHandler$openedNotification$1> continuation) {
        super(2, continuation);
        this.this$0 = pushHandler;
        this.$tagValue = str;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PushHandler$openedNotification$1 pushHandler$openedNotification$1 = new PushHandler$openedNotification$1(this.this$0, this.$tagValue, this.$context, continuation);
        pushHandler$openedNotification$1.L$0 = obj;
        return pushHandler$openedNotification$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IBookingsRepository iBookingsRepository;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            iBookingsRepository = this.this$0.bookingsRepository;
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = iBookingsRepository.getBookings(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        String str = this.$tagValue;
        Iterator it = ((Iterable) obj).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (Intrinsics.areEqual(((BookingHeader) obj2).getReservationId(), str)) {
                break;
            }
        }
        BookingHeader bookingHeader = (BookingHeader) obj2;
        if (bookingHeader != null) {
            this.this$0.navigateToDestination(TicketDetailsScreenDestination.INSTANCE.invoke(bookingHeader.getReservationId(), bookingHeader.getPhone(), bookingHeader.getSite(), false), this.$context);
        } else {
            String str2 = this.$tagValue;
            Logger.INSTANCE.logCritical(new CriticalLog("Received push notification Ticket #" + str2 + " but booking is not found in repository"));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PushHandler$openedNotification$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
