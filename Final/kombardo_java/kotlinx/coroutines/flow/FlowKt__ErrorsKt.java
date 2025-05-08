package kotlinx.coroutines.flow;

import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.Job;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u001aV\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012.\u0010\b\u001a*\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\\\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000124\u0010\u000e\u001a0\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a3\u0010\u0012\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001b\u0010\u0018\u001a\u00020\r*\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001d\u0010\u001c\u001a\u00020\r*\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", BuildConfig.FLAVOR, "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "action", "catch", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function4;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "predicate", "retryWhen", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "collector", "catchImpl", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "isCancellationCause$FlowKt__ErrorsKt", "(Ljava/lang/Throwable;Lkotlin/coroutines/CoroutineContext;)Z", "isCancellationCause", "other", "isSameExceptionAs$FlowKt__ErrorsKt", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)Z", "isSameExceptionAs", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes3.dex */
public abstract /* synthetic */ class FlowKt__ErrorsKt {
    /* renamed from: catch, reason: not valid java name */
    public static final <T> Flow<T> m3786catch(Flow<? extends T> flow, Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(flow, function3);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object catchImpl(Flow<? extends T> flow, FlowCollector<? super T> flowCollector, Continuation<? super Throwable> continuation) {
        FlowKt__ErrorsKt$catchImpl$1 flowKt__ErrorsKt$catchImpl$1;
        int i5;
        Ref$ObjectRef ref$ObjectRef;
        Throwable th;
        if (continuation instanceof FlowKt__ErrorsKt$catchImpl$1) {
            flowKt__ErrorsKt$catchImpl$1 = (FlowKt__ErrorsKt$catchImpl$1) continuation;
            int i6 = flowKt__ErrorsKt$catchImpl$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                flowKt__ErrorsKt$catchImpl$1.label = i6 - Integer.MIN_VALUE;
                Object obj = flowKt__ErrorsKt$catchImpl$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = flowKt__ErrorsKt$catchImpl$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                    try {
                        FlowCollector<? super Object> flowKt__ErrorsKt$catchImpl$2 = new FlowKt__ErrorsKt$catchImpl$2<>(flowCollector, ref$ObjectRef2);
                        flowKt__ErrorsKt$catchImpl$1.L$0 = ref$ObjectRef2;
                        flowKt__ErrorsKt$catchImpl$1.label = 1;
                        if (flow.collect(flowKt__ErrorsKt$catchImpl$2, flowKt__ErrorsKt$catchImpl$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        ref$ObjectRef = ref$ObjectRef2;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ref$ObjectRef = (Ref$ObjectRef) flowKt__ErrorsKt$catchImpl$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                th = (Throwable) ref$ObjectRef.element;
                if (!isSameExceptionAs$FlowKt__ErrorsKt(th, th) || isCancellationCause$FlowKt__ErrorsKt(th, flowKt__ErrorsKt$catchImpl$1.getContext())) {
                    throw th;
                }
                if (th == null) {
                    return th;
                }
                if (th instanceof CancellationException) {
                    ExceptionsKt.addSuppressed(th, th);
                    throw th;
                }
                ExceptionsKt.addSuppressed(th, th);
                throw th;
            }
        }
        flowKt__ErrorsKt$catchImpl$1 = new FlowKt__ErrorsKt$catchImpl$1(continuation);
        Object obj2 = flowKt__ErrorsKt$catchImpl$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = flowKt__ErrorsKt$catchImpl$1.label;
        if (i5 != 0) {
        }
        th = (Throwable) ref$ObjectRef.element;
        if (isSameExceptionAs$FlowKt__ErrorsKt(th, th)) {
        }
        throw th;
    }

    private static final boolean isCancellationCause$FlowKt__ErrorsKt(Throwable th, CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.INSTANCE);
        if (job == null || !job.isCancelled()) {
            return false;
        }
        return isSameExceptionAs$FlowKt__ErrorsKt(th, job.getCancellationException());
    }

    private static final boolean isSameExceptionAs$FlowKt__ErrorsKt(Throwable th, Throwable th2) {
        return th2 != null && Intrinsics.areEqual(th2, th);
    }

    public static final <T> Flow<T> retryWhen(Flow<? extends T> flow, Function4<? super FlowCollector<? super T>, ? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> function4) {
        return new FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(flow, function4);
    }
}
