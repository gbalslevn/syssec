package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref$IntRef;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "T", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FlowKt__LimitKt$take$2$1<T> implements FlowCollector {
    final /* synthetic */ Ref$IntRef $consumed;
    final /* synthetic */ int $count;
    final /* synthetic */ FlowCollector<T> $this_unsafeFlow;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$take$2$1(Ref$IntRef ref$IntRef, int i5, FlowCollector<? super T> flowCollector) {
        this.$consumed = ref$IntRef;
        this.$count = i5;
        this.$this_unsafeFlow = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t5, Continuation<? super Unit> continuation) {
        FlowKt__LimitKt$take$2$1$emit$1 flowKt__LimitKt$take$2$1$emit$1;
        int i5;
        Object emitAbort$FlowKt__LimitKt;
        if (continuation instanceof FlowKt__LimitKt$take$2$1$emit$1) {
            flowKt__LimitKt$take$2$1$emit$1 = (FlowKt__LimitKt$take$2$1$emit$1) continuation;
            int i6 = flowKt__LimitKt$take$2$1$emit$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                flowKt__LimitKt$take$2$1$emit$1.label = i6 - Integer.MIN_VALUE;
                Object obj = flowKt__LimitKt$take$2$1$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = flowKt__LimitKt$take$2$1$emit$1.label;
                if (i5 == 0) {
                    if (i5 == 1) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    if (i5 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                Ref$IntRef ref$IntRef = this.$consumed;
                int i7 = ref$IntRef.element + 1;
                ref$IntRef.element = i7;
                if (i7 < this.$count) {
                    FlowCollector<T> flowCollector = this.$this_unsafeFlow;
                    flowKt__LimitKt$take$2$1$emit$1.label = 1;
                    if (flowCollector.emit(t5, flowKt__LimitKt$take$2$1$emit$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                FlowCollector<T> flowCollector2 = this.$this_unsafeFlow;
                flowKt__LimitKt$take$2$1$emit$1.label = 2;
                emitAbort$FlowKt__LimitKt = FlowKt__LimitKt.emitAbort$FlowKt__LimitKt(flowCollector2, t5, flowKt__LimitKt$take$2$1$emit$1);
                if (emitAbort$FlowKt__LimitKt == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        flowKt__LimitKt$take$2$1$emit$1 = new FlowKt__LimitKt$take$2$1$emit$1(this, continuation);
        Object obj2 = flowKt__LimitKt$take$2$1$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = flowKt__LimitKt$take$2$1$emit$1.label;
        if (i5 == 0) {
        }
    }
}
