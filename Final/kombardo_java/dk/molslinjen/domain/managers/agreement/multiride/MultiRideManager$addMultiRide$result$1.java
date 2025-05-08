package dk.molslinjen.domain.managers.agreement.multiride;

import dk.molslinjen.api.services.multiRide.response.MultiRideResponseDTO;
import dk.molslinjen.domain.localstorage.agreements.multiride.IMultiRideRepository;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCard;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Ldk/molslinjen/api/services/multiRide/response/MultiRideResponseDTO;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager$addMultiRide$result$1", f = "MultiRideManager.kt", l = {84, 85}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class MultiRideManager$addMultiRide$result$1 extends SuspendLambda implements Function2<MultiRideResponseDTO, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MultiRideManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiRideManager$addMultiRide$result$1(MultiRideManager multiRideManager, Continuation<? super MultiRideManager$addMultiRide$result$1> continuation) {
        super(2, continuation);
        this.this$0 = multiRideManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MultiRideManager$addMultiRide$result$1 multiRideManager$addMultiRide$result$1 = new MultiRideManager$addMultiRide$result$1(this.this$0, continuation);
        multiRideManager$addMultiRide$result$1.L$0 = obj;
        return multiRideManager$addMultiRide$result$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(MultiRideResponseDTO multiRideResponseDTO, Continuation<? super Unit> continuation) {
        return ((MultiRideManager$addMultiRide$result$1) create(multiRideResponseDTO, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IMultiRideRepository iMultiRideRepository;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            MultiRideResponseDTO multiRideResponseDTO = (MultiRideResponseDTO) this.L$0;
            iMultiRideRepository = this.this$0.multiRideRepo;
            MultiRideCard multiRideCard = new MultiRideCard(multiRideResponseDTO.getMultiRideTicket());
            this.label = 1;
            if (iMultiRideRepository.save(multiRideCard, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        MultiRideManager multiRideManager = this.this$0;
        this.label = 2;
        if (multiRideManager.loadMultiRides(this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
