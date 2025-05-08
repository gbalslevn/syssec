package dk.molslinjen.domain.managers.agreement.multiride;

import dk.molslinjen.api.services.multiRide.response.MultiRideActiveBookingsResponseDTO;
import dk.molslinjen.api.services.multiRide.response.MultiRideBookingResponseDTO;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideBookingTicket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideBookingTicket;", "response", "Ldk/molslinjen/api/services/multiRide/response/MultiRideActiveBookingsResponseDTO;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager$getActiveTickets$2", f = "MultiRideManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class MultiRideManager$getActiveTickets$2 extends SuspendLambda implements Function2<MultiRideActiveBookingsResponseDTO, Continuation<? super List<? extends MultiRideBookingTicket>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MultiRideManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiRideManager$getActiveTickets$2(MultiRideManager multiRideManager, Continuation<? super MultiRideManager$getActiveTickets$2> continuation) {
        super(2, continuation);
        this.this$0 = multiRideManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MultiRideManager$getActiveTickets$2 multiRideManager$getActiveTickets$2 = new MultiRideManager$getActiveTickets$2(this.this$0, continuation);
        multiRideManager$getActiveTickets$2.L$0 = obj;
        return multiRideManager$getActiveTickets$2;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(MultiRideActiveBookingsResponseDTO multiRideActiveBookingsResponseDTO, Continuation<? super List<MultiRideBookingTicket>> continuation) {
        return ((MultiRideManager$getActiveTickets$2) create(multiRideActiveBookingsResponseDTO, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List sortNewestFirst;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        MultiRideActiveBookingsResponseDTO multiRideActiveBookingsResponseDTO = (MultiRideActiveBookingsResponseDTO) this.L$0;
        MultiRideManager multiRideManager = this.this$0;
        List<MultiRideBookingResponseDTO> bookings = multiRideActiveBookingsResponseDTO.getBookings();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(bookings, 10));
        Iterator<T> it = bookings.iterator();
        while (it.hasNext()) {
            arrayList.add(new MultiRideBookingTicket(((MultiRideBookingResponseDTO) it.next()).getOutbound()));
        }
        sortNewestFirst = multiRideManager.sortNewestFirst(arrayList);
        return sortNewestFirst;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(MultiRideActiveBookingsResponseDTO multiRideActiveBookingsResponseDTO, Continuation<? super List<? extends MultiRideBookingTicket>> continuation) {
        return invoke2(multiRideActiveBookingsResponseDTO, (Continuation<? super List<MultiRideBookingTicket>>) continuation);
    }
}
