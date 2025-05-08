package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a+\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001aJ\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a+\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u0005\u001a+\u0010\u0013\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001aJ\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"T", "Lkotlinx/coroutines/flow/Flow;", BuildConfig.FLAVOR, "count", "drop", "(Lkotlinx/coroutines/flow/Flow;I)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "predicate", "dropWhile", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "take", "Lkotlinx/coroutines/flow/FlowCollector;", "value", BuildConfig.FLAVOR, "emitAbort$FlowKt__LimitKt", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitAbort", "takeWhile", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes3.dex */
abstract /* synthetic */ class FlowKt__LimitKt {
    public static final <T> Flow<T> drop(final Flow<? extends T> flow, final int i5) {
        if (i5 >= 0) {
            return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__LimitKt$drop$$inlined$unsafeFlow$1
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
                    Object collect = Flow.this.collect(new FlowKt__LimitKt$drop$2$1(new Ref$IntRef(), i5, flowCollector), continuation);
                    return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                }
            };
        }
        throw new IllegalArgumentException(("Drop count should be non-negative, but had " + i5).toString());
    }

    public static final <T> Flow<T> dropWhile(final Flow<? extends T> flow, final Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
                Object collect = Flow.this.collect(new FlowKt__LimitKt$dropWhile$1$1(new Ref$BooleanRef(), flowCollector, function2), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object emitAbort$FlowKt__LimitKt(FlowCollector<? super T> flowCollector, T t5, Continuation<? super Unit> continuation) {
        FlowKt__LimitKt$emitAbort$1 flowKt__LimitKt$emitAbort$1;
        int i5;
        if (continuation instanceof FlowKt__LimitKt$emitAbort$1) {
            flowKt__LimitKt$emitAbort$1 = (FlowKt__LimitKt$emitAbort$1) continuation;
            int i6 = flowKt__LimitKt$emitAbort$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                flowKt__LimitKt$emitAbort$1.label = i6 - Integer.MIN_VALUE;
                Object obj = flowKt__LimitKt$emitAbort$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = flowKt__LimitKt$emitAbort$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    flowKt__LimitKt$emitAbort$1.L$0 = flowCollector;
                    flowKt__LimitKt$emitAbort$1.label = 1;
                    if (flowCollector.emit(t5, flowKt__LimitKt$emitAbort$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    flowCollector = (FlowCollector) flowKt__LimitKt$emitAbort$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                throw new AbortFlowException(flowCollector);
            }
        }
        flowKt__LimitKt$emitAbort$1 = new FlowKt__LimitKt$emitAbort$1(continuation);
        Object obj2 = flowKt__LimitKt$emitAbort$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = flowKt__LimitKt$emitAbort$1.label;
        if (i5 != 0) {
        }
        throw new AbortFlowException(flowCollector);
    }

    public static final <T> Flow<T> take(Flow<? extends T> flow, int i5) {
        if (i5 > 0) {
            return new FlowKt__LimitKt$take$$inlined$unsafeFlow$1(flow, i5);
        }
        throw new IllegalArgumentException(("Requested element count " + i5 + " should be positive").toString());
    }

    public static final <T> Flow<T> takeWhile(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return new FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1(flow, function2);
    }
}
