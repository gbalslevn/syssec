package androidx.view.compose;

import androidx.view.BackEventCompat;
import androidx.view.OnBackPressedCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.activity.compose.OnBackInstance$job$1", f = "PredictiveBackHandler.kt", l = {121}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class OnBackInstance$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OnBackPressedCallback $callback;
    final /* synthetic */ Function2<Flow<BackEventCompat>, Continuation<? super Unit>, Object> $onBack;
    Object L$0;
    int label;
    final /* synthetic */ OnBackInstance this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/activity/BackEventCompat;", "it", BuildConfig.FLAVOR}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.activity.compose.OnBackInstance$job$1$1", f = "PredictiveBackHandler.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.activity.compose.OnBackInstance$job$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<FlowCollector<? super BackEventCompat>, Throwable, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref$BooleanRef $completed;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref$BooleanRef ref$BooleanRef, Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
            this.$completed = ref$BooleanRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$completed.element = true;
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super BackEventCompat> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            return new AnonymousClass1(this.$completed, continuation).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OnBackInstance$job$1(OnBackPressedCallback onBackPressedCallback, Function2<? super Flow<BackEventCompat>, ? super Continuation<? super Unit>, ? extends Object> function2, OnBackInstance onBackInstance, Continuation<? super OnBackInstance$job$1> continuation) {
        super(2, continuation);
        this.$callback = onBackPressedCallback;
        this.$onBack = function2;
        this.this$0 = onBackInstance;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnBackInstance$job$1(this.$callback, this.$onBack, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Ref$BooleanRef ref$BooleanRef;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$callback.getIsEnabled()) {
                Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
                Function2<Flow<BackEventCompat>, Continuation<? super Unit>, Object> function2 = this.$onBack;
                Flow<BackEventCompat> onCompletion = FlowKt.onCompletion(FlowKt.consumeAsFlow(this.this$0.getChannel()), new AnonymousClass1(ref$BooleanRef2, null));
                this.L$0 = ref$BooleanRef2;
                this.label = 1;
                if (function2.invoke(onCompletion, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ref$BooleanRef = ref$BooleanRef2;
            }
            return Unit.INSTANCE;
        }
        if (i5 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ref$BooleanRef = (Ref$BooleanRef) this.L$0;
        ResultKt.throwOnFailure(obj);
        if (!ref$BooleanRef.element) {
            throw new IllegalStateException("You must collect the progress flow");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OnBackInstance$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
