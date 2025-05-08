package kotlinx.coroutines.flow;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a#\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001aG\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"T", "Lkotlinx/coroutines/flow/Flow;", "first", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "predicate", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes3.dex */
public abstract /* synthetic */ class FlowKt__ReduceKt {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0068 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object first(Flow<? extends T> flow, Continuation<? super T> continuation) {
        FlowKt__ReduceKt$first$1 flowKt__ReduceKt$first$1;
        int i5;
        Ref$ObjectRef ref$ObjectRef;
        AbortFlowException e5;
        FlowCollector<T> flowCollector;
        T t5;
        if (continuation instanceof FlowKt__ReduceKt$first$1) {
            flowKt__ReduceKt$first$1 = (FlowKt__ReduceKt$first$1) continuation;
            int i6 = flowKt__ReduceKt$first$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$first$1.label = i6 - Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$first$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = flowKt__ReduceKt$first$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                    ref$ObjectRef2.element = (T) NullSurrogateKt.NULL;
                    FlowCollector<T> flowCollector2 = new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public Object emit(T t6, Continuation<? super Unit> continuation2) {
                            Ref$ObjectRef.this.element = t6;
                            throw new AbortFlowException(this);
                        }
                    };
                    try {
                        flowKt__ReduceKt$first$1.L$0 = ref$ObjectRef2;
                        flowKt__ReduceKt$first$1.L$1 = flowCollector2;
                        flowKt__ReduceKt$first$1.label = 1;
                        if (flow.collect(flowCollector2, flowKt__ReduceKt$first$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ref$ObjectRef = ref$ObjectRef2;
                    } catch (AbortFlowException e6) {
                        ref$ObjectRef = ref$ObjectRef2;
                        e5 = e6;
                        flowCollector = flowCollector2;
                        FlowExceptions_commonKt.checkOwnership(e5, flowCollector);
                        t5 = ref$ObjectRef.element;
                        if (t5 == NullSurrogateKt.NULL) {
                        }
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    flowCollector = (FlowKt__ReduceKt$first$$inlined$collectWhile$1) flowKt__ReduceKt$first$1.L$1;
                    ref$ObjectRef = (Ref$ObjectRef) flowKt__ReduceKt$first$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (AbortFlowException e7) {
                        e5 = e7;
                        FlowExceptions_commonKt.checkOwnership(e5, flowCollector);
                        t5 = ref$ObjectRef.element;
                        if (t5 == NullSurrogateKt.NULL) {
                        }
                    }
                }
                t5 = ref$ObjectRef.element;
                if (t5 == NullSurrogateKt.NULL) {
                    return t5;
                }
                throw new NoSuchElementException("Expected at least one element");
            }
        }
        flowKt__ReduceKt$first$1 = new FlowKt__ReduceKt$first$1(continuation);
        Object obj2 = flowKt__ReduceKt$first$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = flowKt__ReduceKt$first$1.label;
        if (i5 != 0) {
        }
        t5 = ref$ObjectRef.element;
        if (t5 == NullSurrogateKt.NULL) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object first(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super T> continuation) {
        FlowKt__ReduceKt$first$3 flowKt__ReduceKt$first$3;
        int i5;
        Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function22;
        Ref$ObjectRef ref$ObjectRef;
        AbortFlowException e5;
        FlowCollector<? super Object> flowCollector;
        T t5;
        if (continuation instanceof FlowKt__ReduceKt$first$3) {
            flowKt__ReduceKt$first$3 = (FlowKt__ReduceKt$first$3) continuation;
            int i6 = flowKt__ReduceKt$first$3.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$first$3.label = i6 - Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$first$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = flowKt__ReduceKt$first$3.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                    ref$ObjectRef2.element = (T) NullSurrogateKt.NULL;
                    FlowCollector<? super Object> flowKt__ReduceKt$first$$inlined$collectWhile$2 = new FlowKt__ReduceKt$first$$inlined$collectWhile$2<>(function2, ref$ObjectRef2);
                    try {
                        flowKt__ReduceKt$first$3.L$0 = function2;
                        flowKt__ReduceKt$first$3.L$1 = ref$ObjectRef2;
                        flowKt__ReduceKt$first$3.L$2 = flowKt__ReduceKt$first$$inlined$collectWhile$2;
                        flowKt__ReduceKt$first$3.label = 1;
                        if (flow.collect(flowKt__ReduceKt$first$$inlined$collectWhile$2, flowKt__ReduceKt$first$3) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function22 = function2;
                        ref$ObjectRef = ref$ObjectRef2;
                    } catch (AbortFlowException e6) {
                        function22 = function2;
                        ref$ObjectRef = ref$ObjectRef2;
                        e5 = e6;
                        flowCollector = flowKt__ReduceKt$first$$inlined$collectWhile$2;
                        FlowExceptions_commonKt.checkOwnership(e5, flowCollector);
                        t5 = ref$ObjectRef.element;
                        if (t5 == NullSurrogateKt.NULL) {
                        }
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    flowCollector = (FlowKt__ReduceKt$first$$inlined$collectWhile$2) flowKt__ReduceKt$first$3.L$2;
                    ref$ObjectRef = (Ref$ObjectRef) flowKt__ReduceKt$first$3.L$1;
                    function22 = (Function2) flowKt__ReduceKt$first$3.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (AbortFlowException e7) {
                        e5 = e7;
                        FlowExceptions_commonKt.checkOwnership(e5, flowCollector);
                        t5 = ref$ObjectRef.element;
                        if (t5 == NullSurrogateKt.NULL) {
                        }
                    }
                }
                t5 = ref$ObjectRef.element;
                if (t5 == NullSurrogateKt.NULL) {
                    return t5;
                }
                throw new NoSuchElementException("Expected at least one element matching the predicate " + function22);
            }
        }
        flowKt__ReduceKt$first$3 = new FlowKt__ReduceKt$first$3(continuation);
        Object obj2 = flowKt__ReduceKt$first$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = flowKt__ReduceKt$first$3.label;
        if (i5 != 0) {
        }
        t5 = ref$ObjectRef.element;
        if (t5 == NullSurrogateKt.NULL) {
        }
    }
}
