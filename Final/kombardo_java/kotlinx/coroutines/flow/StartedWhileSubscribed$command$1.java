package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.DelayKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/flow/SharingCommand;", "count", BuildConfig.FLAVOR}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", l = {178, 180, 182, 183, 185}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class StartedWhileSubscribed$command$1 extends SuspendLambda implements Function3<FlowCollector<? super SharingCommand>, Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StartedWhileSubscribed this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartedWhileSubscribed$command$1(StartedWhileSubscribed startedWhileSubscribed, Continuation<? super StartedWhileSubscribed$command$1> continuation) {
        super(3, continuation);
        this.this$0 = startedWhileSubscribed;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super SharingCommand> flowCollector, Integer num, Continuation<? super Unit> continuation) {
        return invoke(flowCollector, num.intValue(), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0070  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        long j5;
        long j6;
        long j7;
        SharingCommand sharingCommand;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
            if (this.I$0 > 0) {
                SharingCommand sharingCommand2 = SharingCommand.START;
                this.label = 1;
                if (flowCollector.emit(sharingCommand2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            j5 = this.this$0.stopTimeout;
            this.L$0 = flowCollector;
            this.label = 2;
            if (DelayKt.delay(j5, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            j6 = this.this$0.replayExpiration;
            if (j6 > 0) {
            }
            sharingCommand = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
            this.L$0 = null;
            this.label = 5;
            if (flowCollector.emit(sharingCommand, this) == coroutine_suspended) {
            }
            return Unit.INSTANCE;
        }
        if (i5 != 1) {
            if (i5 == 2) {
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                j6 = this.this$0.replayExpiration;
                if (j6 > 0) {
                    SharingCommand sharingCommand3 = SharingCommand.STOP;
                    this.L$0 = flowCollector;
                    this.label = 3;
                    if (flowCollector.emit(sharingCommand3, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j7 = this.this$0.replayExpiration;
                    this.L$0 = flowCollector;
                    this.label = 4;
                    if (DelayKt.delay(j7, this) == coroutine_suspended) {
                    }
                }
                sharingCommand = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
                this.L$0 = null;
                this.label = 5;
                if (flowCollector.emit(sharingCommand, this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            }
            if (i5 == 3) {
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                j7 = this.this$0.replayExpiration;
                this.L$0 = flowCollector;
                this.label = 4;
                if (DelayKt.delay(j7, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                sharingCommand = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
                this.L$0 = null;
                this.label = 5;
                if (flowCollector.emit(sharingCommand, this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            }
            if (i5 == 4) {
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                sharingCommand = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
                this.L$0 = null;
                this.label = 5;
                if (flowCollector.emit(sharingCommand, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            if (i5 != 5) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
        ResultKt.throwOnFailure(obj);
        return Unit.INSTANCE;
    }

    public final Object invoke(FlowCollector<? super SharingCommand> flowCollector, int i5, Continuation<? super Unit> continuation) {
        StartedWhileSubscribed$command$1 startedWhileSubscribed$command$1 = new StartedWhileSubscribed$command$1(this.this$0, continuation);
        startedWhileSubscribed$command$1.L$0 = flowCollector;
        startedWhileSubscribed$command$1.I$0 = i5;
        return startedWhileSubscribed$command$1.invokeSuspend(Unit.INSTANCE);
    }
}
