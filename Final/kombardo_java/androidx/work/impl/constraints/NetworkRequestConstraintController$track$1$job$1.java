package androidx.work.impl.constraints;

import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintsState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.work.impl.constraints.NetworkRequestConstraintController$track$1$job$1", f = "WorkConstraintsTracker.kt", l = {148}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class NetworkRequestConstraintController$track$1$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ProducerScope<ConstraintsState> $$this$callbackFlow;
    int label;
    final /* synthetic */ NetworkRequestConstraintController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NetworkRequestConstraintController$track$1$job$1(NetworkRequestConstraintController networkRequestConstraintController, ProducerScope<? super ConstraintsState> producerScope, Continuation<? super NetworkRequestConstraintController$track$1$job$1> continuation) {
        super(2, continuation);
        this.this$0 = networkRequestConstraintController;
        this.$$this$callbackFlow = producerScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NetworkRequestConstraintController$track$1$job$1(this.this$0, this.$$this$callbackFlow, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        long j5;
        String str;
        long j6;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            j5 = this.this$0.timeoutMs;
            this.label = 1;
            if (DelayKt.delay(j5, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Logger logger = Logger.get();
        str = WorkConstraintsTrackerKt.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("NetworkRequestConstraintController didn't receive neither  onCapabilitiesChanged/onLost callback, sending `ConstraintsNotMet` after ");
        j6 = this.this$0.timeoutMs;
        sb.append(j6);
        sb.append(" ms");
        logger.debug(str, sb.toString());
        this.$$this$callbackFlow.mo3767trySendJP2dKIU(new ConstraintsState.ConstraintsNotMet(7));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NetworkRequestConstraintController$track$1$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
