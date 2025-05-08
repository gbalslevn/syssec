package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "T", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
final class DistinctFlowImpl$collect$2<T> implements FlowCollector {
    final /* synthetic */ FlowCollector<T> $collector;
    final /* synthetic */ Ref$ObjectRef<Object> $previousKey;
    final /* synthetic */ DistinctFlowImpl<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public DistinctFlowImpl$collect$2(DistinctFlowImpl<T> distinctFlowImpl, Ref$ObjectRef<Object> ref$ObjectRef, FlowCollector<? super T> flowCollector) {
        this.this$0 = distinctFlowImpl;
        this.$previousKey = ref$ObjectRef;
        this.$collector = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t5, Continuation<? super Unit> continuation) {
        DistinctFlowImpl$collect$2$emit$1 distinctFlowImpl$collect$2$emit$1;
        int i5;
        if (continuation instanceof DistinctFlowImpl$collect$2$emit$1) {
            distinctFlowImpl$collect$2$emit$1 = (DistinctFlowImpl$collect$2$emit$1) continuation;
            int i6 = distinctFlowImpl$collect$2$emit$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                distinctFlowImpl$collect$2$emit$1.label = i6 - Integer.MIN_VALUE;
                Object obj = distinctFlowImpl$collect$2$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = distinctFlowImpl$collect$2$emit$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    T t6 = (T) this.this$0.keySelector.invoke(t5);
                    Object obj2 = this.$previousKey.element;
                    if (obj2 != NullSurrogateKt.NULL && this.this$0.areEquivalent.invoke(obj2, t6).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    this.$previousKey.element = t6;
                    FlowCollector<T> flowCollector = this.$collector;
                    distinctFlowImpl$collect$2$emit$1.label = 1;
                    if (flowCollector.emit(t5, distinctFlowImpl$collect$2$emit$1) == coroutine_suspended) {
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
        }
        distinctFlowImpl$collect$2$emit$1 = new DistinctFlowImpl$collect$2$emit$1(this, continuation);
        Object obj3 = distinctFlowImpl$collect$2$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = distinctFlowImpl$collect$2$emit$1.label;
        if (i5 != 0) {
        }
        return Unit.INSTANCE;
    }
}
