package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;
import org.conscrypt.BuildConfig;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", BuildConfig.FLAVOR, "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Function4 $predicate$inlined;
    final /* synthetic */ Flow $this_retryWhen$inlined;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1", f = "Errors.kt", l = {118, 120}, m = "collect")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(Flow flow, Function4 function4) {
        this.$this_retryWhen$inlined = flow;
        this.$predicate$inlined = function4;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0076 -> B:14:0x00a6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0097 -> B:11:0x009a). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        int i5;
        long j5;
        FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1<T> flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
        int i6;
        FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1<T> flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
        FlowCollector<? super T> flowCollector2;
        Throwable th;
        Object catchImpl;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i7 = anonymousClass1.label;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i7 - Integer.MIN_VALUE;
                Object obj = anonymousClass1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = anonymousClass1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    j5 = 0;
                    flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 = this;
                    Flow flow = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.$this_retryWhen$inlined;
                    anonymousClass1.L$0 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
                    anonymousClass1.L$1 = flowCollector;
                    anonymousClass1.L$2 = null;
                    anonymousClass1.J$0 = j5;
                    anonymousClass1.I$0 = 0;
                    anonymousClass1.label = 1;
                    catchImpl = FlowKt.catchImpl(flow, flowCollector, anonymousClass1);
                    if (catchImpl != coroutine_suspended) {
                    }
                } else if (i5 == 1) {
                    i6 = anonymousClass1.I$0;
                    j5 = anonymousClass1.J$0;
                    flowCollector2 = (FlowCollector) anonymousClass1.L$1;
                    flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12 = (FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                    th = (Throwable) obj;
                    if (th != null) {
                    }
                    flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
                    if (i6 == 0) {
                    }
                } else {
                    if (i5 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j5 = anonymousClass1.J$0;
                    Throwable th2 = (Throwable) anonymousClass1.L$2;
                    flowCollector2 = (FlowCollector) anonymousClass1.L$1;
                    flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12 = (FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (!((Boolean) obj).booleanValue()) {
                        j5++;
                        i6 = 1;
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
                        if (i6 == 0) {
                            return Unit.INSTANCE;
                        }
                        flowCollector = flowCollector2;
                        Flow flow2 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.$this_retryWhen$inlined;
                        anonymousClass1.L$0 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
                        anonymousClass1.L$1 = flowCollector;
                        anonymousClass1.L$2 = null;
                        anonymousClass1.J$0 = j5;
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        catchImpl = FlowKt.catchImpl(flow2, flowCollector, anonymousClass1);
                        if (catchImpl != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        flowCollector2 = flowCollector;
                        i6 = 0;
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
                        obj = catchImpl;
                        th = (Throwable) obj;
                        if (th != null) {
                            Function4 function4 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12.$predicate$inlined;
                            Long boxLong = Boxing.boxLong(j5);
                            anonymousClass1.L$0 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
                            anonymousClass1.L$1 = flowCollector2;
                            anonymousClass1.L$2 = th;
                            anonymousClass1.J$0 = j5;
                            anonymousClass1.label = 2;
                            InlineMarker.mark(6);
                            Object invoke = function4.invoke(flowCollector2, th, boxLong, anonymousClass1);
                            InlineMarker.mark(7);
                            if (invoke == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj = invoke;
                            th2 = th;
                            if (!((Boolean) obj).booleanValue()) {
                                throw th2;
                            }
                        }
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
                        if (i6 == 0) {
                        }
                    }
                }
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj2 = anonymousClass1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = anonymousClass1.label;
        if (i5 != 0) {
        }
    }
}
