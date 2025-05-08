package dk.molslinjen.domain.managers.agreement.multiride;

import dk.molslinjen.api.services.multiRide.response.MultiRideResponseDTO;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCard;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;", "it", "Ldk/molslinjen/api/services/multiRide/response/MultiRideResponseDTO;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager$getMultiRide$2", f = "MultiRideManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class MultiRideManager$getMultiRide$2 extends SuspendLambda implements Function2<MultiRideResponseDTO, Continuation<? super MultiRideCard>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiRideManager$getMultiRide$2(Continuation<? super MultiRideManager$getMultiRide$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MultiRideManager$getMultiRide$2 multiRideManager$getMultiRide$2 = new MultiRideManager$getMultiRide$2(continuation);
        multiRideManager$getMultiRide$2.L$0 = obj;
        return multiRideManager$getMultiRide$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(MultiRideResponseDTO multiRideResponseDTO, Continuation<? super MultiRideCard> continuation) {
        return ((MultiRideManager$getMultiRide$2) create(multiRideResponseDTO, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return new MultiRideCard(((MultiRideResponseDTO) this.L$0).getMultiRideTicket());
    }
}
