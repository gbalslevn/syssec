package androidx.compose.material;

import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "I", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.AnchoredDraggableKt$restartable$2", f = "AnchoredDraggable.kt", l = {740}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AnchoredDraggableKt$restartable$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ Function0<I> $inputs;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "I", "latestInputs", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.material.AnchoredDraggableKt$restartable$2$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ CoroutineScope $$this$coroutineScope;
        final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Ref$ObjectRef<Job> $previousDrag;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "I", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.material.AnchoredDraggableKt$restartable$2$1$2", f = "AnchoredDraggable.kt", l = {746}, m = "invokeSuspend")
        /* renamed from: androidx.compose.material.AnchoredDraggableKt$restartable$2$1$2, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
            final /* synthetic */ I $latestInputs;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> function2, I i5, CoroutineScope coroutineScope, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$block = function2;
                this.$latestInputs = i5;
                this.$$this$coroutineScope = coroutineScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$block, this.$latestInputs, this.$$this$coroutineScope, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i5 = this.label;
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Function2<I, Continuation<? super Unit>, Object> function2 = this.$block;
                    I i6 = this.$latestInputs;
                    this.label = 1;
                    if (function2.invoke(i6, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                CoroutineScopeKt.cancel(this.$$this$coroutineScope, new AnchoredDragFinishedSignal());
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Ref$ObjectRef<Job> ref$ObjectRef, CoroutineScope coroutineScope, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> function2) {
            this.$previousDrag = ref$ObjectRef;
            this.$$this$coroutineScope = coroutineScope;
            this.$block = function2;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(I i5, Continuation<? super Unit> continuation) {
            AnchoredDraggableKt$restartable$2$1$emit$1 anchoredDraggableKt$restartable$2$1$emit$1;
            int i6;
            AnonymousClass1<T> anonymousClass1;
            Object obj;
            Job launch$default;
            if (continuation instanceof AnchoredDraggableKt$restartable$2$1$emit$1) {
                anchoredDraggableKt$restartable$2$1$emit$1 = (AnchoredDraggableKt$restartable$2$1$emit$1) continuation;
                int i7 = anchoredDraggableKt$restartable$2$1$emit$1.label;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    anchoredDraggableKt$restartable$2$1$emit$1.label = i7 - Integer.MIN_VALUE;
                    Object obj2 = anchoredDraggableKt$restartable$2$1$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i6 = anchoredDraggableKt$restartable$2$1$emit$1.label;
                    if (i6 != 0) {
                        ResultKt.throwOnFailure(obj2);
                        Job job = this.$previousDrag.element;
                        if (job != null) {
                            job.cancel(new AnchoredDragFinishedSignal());
                            anchoredDraggableKt$restartable$2$1$emit$1.L$0 = this;
                            anchoredDraggableKt$restartable$2$1$emit$1.L$1 = i5;
                            anchoredDraggableKt$restartable$2$1$emit$1.L$2 = job;
                            anchoredDraggableKt$restartable$2$1$emit$1.label = 1;
                            if (job.join(anchoredDraggableKt$restartable$2$1$emit$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        anonymousClass1 = this;
                        obj = i5;
                    } else {
                        if (i6 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Object obj3 = anchoredDraggableKt$restartable$2$1$emit$1.L$1;
                        anonymousClass1 = (AnonymousClass1) anchoredDraggableKt$restartable$2$1$emit$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        obj = obj3;
                    }
                    Ref$ObjectRef<Job> ref$ObjectRef = anonymousClass1.$previousDrag;
                    CoroutineScope coroutineScope = anonymousClass1.$$this$coroutineScope;
                    launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(anonymousClass1.$block, obj, coroutineScope, null), 1, null);
                    ref$ObjectRef.element = (T) launch$default;
                    return Unit.INSTANCE;
                }
            }
            anchoredDraggableKt$restartable$2$1$emit$1 = new AnchoredDraggableKt$restartable$2$1$emit$1(this, continuation);
            Object obj22 = anchoredDraggableKt$restartable$2$1$emit$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i6 = anchoredDraggableKt$restartable$2$1$emit$1.label;
            if (i6 != 0) {
            }
            Ref$ObjectRef<Job> ref$ObjectRef2 = anonymousClass1.$previousDrag;
            CoroutineScope coroutineScope2 = anonymousClass1.$$this$coroutineScope;
            launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(anonymousClass1.$block, obj, coroutineScope2, null), 1, null);
            ref$ObjectRef2.element = (T) launch$default;
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AnchoredDraggableKt$restartable$2(Function0<? extends I> function0, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super AnchoredDraggableKt$restartable$2> continuation) {
        super(2, continuation);
        this.$inputs = function0;
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AnchoredDraggableKt$restartable$2 anchoredDraggableKt$restartable$2 = new AnchoredDraggableKt$restartable$2(this.$inputs, this.$block, continuation);
        anchoredDraggableKt$restartable$2.L$0 = obj;
        return anchoredDraggableKt$restartable$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            Flow snapshotFlow = SnapshotStateKt.snapshotFlow(this.$inputs);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(ref$ObjectRef, coroutineScope, this.$block);
            this.label = 1;
            if (snapshotFlow.collect(anonymousClass1, this) == coroutine_suspended) {
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
        return ((AnchoredDraggableKt$restartable$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
