package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "T", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", f = "Merge.kt", l = {27}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class ChannelFlowTransformLatest$flowCollect$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowCollector<R> $collector;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChannelFlowTransformLatest<T, R> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ CoroutineScope $$this$coroutineScope;
        final /* synthetic */ FlowCollector<R> $collector;
        final /* synthetic */ Ref$ObjectRef<Job> $previousFlow;
        final /* synthetic */ ChannelFlowTransformLatest<T, R> this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "T", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2", f = "Merge.kt", l = {34}, m = "invokeSuspend")
        /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2, reason: invalid class name */
        /* loaded from: classes3.dex */
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ FlowCollector<R> $collector;
            final /* synthetic */ T $value;
            int label;
            final /* synthetic */ ChannelFlowTransformLatest<T, R> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, FlowCollector<? super R> flowCollector, T t5, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = channelFlowTransformLatest;
                this.$collector = flowCollector;
                this.$value = t5;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$collector, this.$value, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Function3 function3;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i5 = this.label;
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    function3 = ((ChannelFlowTransformLatest) this.this$0).transform;
                    Object obj2 = this.$collector;
                    T t5 = this.$value;
                    this.label = 1;
                    if (function3.invoke(obj2, t5, this) == coroutine_suspended) {
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

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Ref$ObjectRef<Job> ref$ObjectRef, CoroutineScope coroutineScope, ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, FlowCollector<? super R> flowCollector) {
            this.$previousFlow = ref$ObjectRef;
            this.$$this$coroutineScope = coroutineScope;
            this.this$0 = channelFlowTransformLatest;
            this.$collector = flowCollector;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(T t5, Continuation<? super Unit> continuation) {
            ChannelFlowTransformLatest$flowCollect$3$1$emit$1 channelFlowTransformLatest$flowCollect$3$1$emit$1;
            int i5;
            AnonymousClass1<T> anonymousClass1;
            Job launch$default;
            if (continuation instanceof ChannelFlowTransformLatest$flowCollect$3$1$emit$1) {
                channelFlowTransformLatest$flowCollect$3$1$emit$1 = (ChannelFlowTransformLatest$flowCollect$3$1$emit$1) continuation;
                int i6 = channelFlowTransformLatest$flowCollect$3$1$emit$1.label;
                if ((i6 & Integer.MIN_VALUE) != 0) {
                    channelFlowTransformLatest$flowCollect$3$1$emit$1.label = i6 - Integer.MIN_VALUE;
                    Object obj = channelFlowTransformLatest$flowCollect$3$1$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = channelFlowTransformLatest$flowCollect$3$1$emit$1.label;
                    if (i5 != 0) {
                        ResultKt.throwOnFailure(obj);
                        Job job = this.$previousFlow.element;
                        if (job != null) {
                            job.cancel(new ChildCancelledException());
                            channelFlowTransformLatest$flowCollect$3$1$emit$1.L$0 = this;
                            channelFlowTransformLatest$flowCollect$3$1$emit$1.L$1 = t5;
                            channelFlowTransformLatest$flowCollect$3$1$emit$1.L$2 = job;
                            channelFlowTransformLatest$flowCollect$3$1$emit$1.label = 1;
                            if (job.join(channelFlowTransformLatest$flowCollect$3$1$emit$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        anonymousClass1 = this;
                    } else {
                        if (i5 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        t5 = (T) channelFlowTransformLatest$flowCollect$3$1$emit$1.L$1;
                        anonymousClass1 = (AnonymousClass1) channelFlowTransformLatest$flowCollect$3$1$emit$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    Ref$ObjectRef<Job> ref$ObjectRef = anonymousClass1.$previousFlow;
                    launch$default = BuildersKt__Builders_commonKt.launch$default(anonymousClass1.$$this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(anonymousClass1.this$0, anonymousClass1.$collector, t5, null), 1, null);
                    ref$ObjectRef.element = (T) launch$default;
                    return Unit.INSTANCE;
                }
            }
            channelFlowTransformLatest$flowCollect$3$1$emit$1 = new ChannelFlowTransformLatest$flowCollect$3$1$emit$1(this, continuation);
            Object obj2 = channelFlowTransformLatest$flowCollect$3$1$emit$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i5 = channelFlowTransformLatest$flowCollect$3$1$emit$1.label;
            if (i5 != 0) {
            }
            Ref$ObjectRef<Job> ref$ObjectRef2 = anonymousClass1.$previousFlow;
            launch$default = BuildersKt__Builders_commonKt.launch$default(anonymousClass1.$$this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(anonymousClass1.this$0, anonymousClass1.$collector, t5, null), 1, null);
            ref$ObjectRef2.element = (T) launch$default;
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowTransformLatest$flowCollect$3(ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, FlowCollector<? super R> flowCollector, Continuation<? super ChannelFlowTransformLatest$flowCollect$3> continuation) {
        super(2, continuation);
        this.this$0 = channelFlowTransformLatest;
        this.$collector = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelFlowTransformLatest$flowCollect$3 channelFlowTransformLatest$flowCollect$3 = new ChannelFlowTransformLatest$flowCollect$3(this.this$0, this.$collector, continuation);
        channelFlowTransformLatest$flowCollect$3.L$0 = obj;
        return channelFlowTransformLatest$flowCollect$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ChannelFlowTransformLatest<T, R> channelFlowTransformLatest = this.this$0;
            Flow<S> flow = channelFlowTransformLatest.flow;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(ref$ObjectRef, coroutineScope, channelFlowTransformLatest, this.$collector);
            this.label = 1;
            if (flow.collect(anonymousClass1, this) == coroutine_suspended) {
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

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChannelFlowTransformLatest$flowCollect$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
