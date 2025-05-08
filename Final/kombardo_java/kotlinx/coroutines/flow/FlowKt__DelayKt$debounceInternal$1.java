package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.OnTimeoutKt;
import kotlinx.coroutines.selects.SelectImplementation;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "T", "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", l = {221, 426}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FlowKt__DelayKt$debounceInternal$1<T> extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<T> $this_debounceInternal;
    final /* synthetic */ Function1<T, Long> $timeoutMillisSelector;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$debounceInternal$1(Function1<? super T, Long> function1, Flow<? extends T> flow, Continuation<? super FlowKt__DelayKt$debounceInternal$1> continuation) {
        super(3, continuation);
        this.$timeoutMillisSelector = function1;
        this.$this_debounceInternal = flow;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0066  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00e2 -> B:6:0x001e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Ref$ObjectRef ref$ObjectRef;
        FlowCollector flowCollector;
        ReceiveChannel receiveChannel;
        Ref$LongRef ref$LongRef;
        Ref$ObjectRef ref$ObjectRef2;
        ReceiveChannel receiveChannel2;
        FlowCollector flowCollector2;
        SelectImplementation selectImplementation;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            FlowCollector flowCollector3 = (FlowCollector) this.L$1;
            ReceiveChannel produce$default = ProduceKt.produce$default(coroutineScope, null, 0, new FlowKt__DelayKt$debounceInternal$1$values$1(this.$this_debounceInternal, null), 3, null);
            ref$ObjectRef = new Ref$ObjectRef();
            flowCollector = flowCollector3;
            receiveChannel = produce$default;
            if (ref$ObjectRef.element == NullSurrogateKt.DONE) {
            }
        } else if (i5 == 1) {
            ref$LongRef = (Ref$LongRef) this.L$3;
            ref$ObjectRef = (Ref$ObjectRef) this.L$2;
            receiveChannel = (ReceiveChannel) this.L$1;
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
            ref$ObjectRef.element = null;
            Ref$LongRef ref$LongRef2 = ref$LongRef;
            ref$ObjectRef2 = ref$ObjectRef;
            receiveChannel2 = receiveChannel;
            flowCollector2 = flowCollector;
            selectImplementation = new SelectImplementation(getContext());
            if (ref$ObjectRef2.element != null) {
            }
            selectImplementation.invoke(receiveChannel2.getOnReceiveCatching(), new FlowKt__DelayKt$debounceInternal$1$3$2(ref$ObjectRef2, flowCollector2, null));
            this.L$0 = flowCollector2;
            this.L$1 = receiveChannel2;
            this.L$2 = ref$ObjectRef2;
            this.L$3 = null;
            this.label = 2;
            if (selectImplementation.doSelect(this) == coroutine_suspended) {
            }
            flowCollector = flowCollector2;
            receiveChannel = receiveChannel2;
            ref$ObjectRef = ref$ObjectRef2;
            if (ref$ObjectRef.element == NullSurrogateKt.DONE) {
            }
        } else {
            if (i5 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ref$ObjectRef2 = (Ref$ObjectRef) this.L$2;
            receiveChannel2 = (ReceiveChannel) this.L$1;
            flowCollector2 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
            flowCollector = flowCollector2;
            receiveChannel = receiveChannel2;
            ref$ObjectRef = ref$ObjectRef2;
            if (ref$ObjectRef.element == NullSurrogateKt.DONE) {
                ref$LongRef = new Ref$LongRef();
                T t5 = ref$ObjectRef.element;
                if (t5 != null) {
                    Function1<T, Long> function1 = this.$timeoutMillisSelector;
                    Symbol symbol = NullSurrogateKt.NULL;
                    if (t5 == symbol) {
                        t5 = null;
                    }
                    long longValue = function1.invoke(t5).longValue();
                    ref$LongRef.element = longValue;
                    if (longValue < 0) {
                        throw new IllegalArgumentException("Debounce timeout should not be negative");
                    }
                    if (longValue == 0) {
                        T t6 = ref$ObjectRef.element;
                        if (t6 == symbol) {
                            t6 = null;
                        }
                        this.L$0 = flowCollector;
                        this.L$1 = receiveChannel;
                        this.L$2 = ref$ObjectRef;
                        this.L$3 = ref$LongRef;
                        this.label = 1;
                        if (flowCollector.emit(t6, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ref$ObjectRef.element = null;
                    }
                }
                Ref$LongRef ref$LongRef22 = ref$LongRef;
                ref$ObjectRef2 = ref$ObjectRef;
                receiveChannel2 = receiveChannel;
                flowCollector2 = flowCollector;
                selectImplementation = new SelectImplementation(getContext());
                if (ref$ObjectRef2.element != null) {
                    OnTimeoutKt.onTimeout(selectImplementation, ref$LongRef22.element, new FlowKt__DelayKt$debounceInternal$1$3$1(flowCollector2, ref$ObjectRef2, null));
                }
                selectImplementation.invoke(receiveChannel2.getOnReceiveCatching(), new FlowKt__DelayKt$debounceInternal$1$3$2(ref$ObjectRef2, flowCollector2, null));
                this.L$0 = flowCollector2;
                this.L$1 = receiveChannel2;
                this.L$2 = ref$ObjectRef2;
                this.L$3 = null;
                this.label = 2;
                if (selectImplementation.doSelect(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                flowCollector = flowCollector2;
                receiveChannel = receiveChannel2;
                ref$ObjectRef = ref$ObjectRef2;
                if (ref$ObjectRef.element == NullSurrogateKt.DONE) {
                    return Unit.INSTANCE;
                }
            }
        }
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(this.$timeoutMillisSelector, this.$this_debounceInternal, continuation);
        flowKt__DelayKt$debounceInternal$1.L$0 = coroutineScope;
        flowKt__DelayKt$debounceInternal$1.L$1 = flowCollector;
        return flowKt__DelayKt$debounceInternal$1.invokeSuspend(Unit.INSTANCE);
    }
}
