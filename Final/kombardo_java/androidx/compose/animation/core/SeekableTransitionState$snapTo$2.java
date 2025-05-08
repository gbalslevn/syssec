package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "S"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$snapTo$2", f = "Transition.kt", l = {477}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SeekableTransitionState$snapTo$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ S $targetState;
    final /* synthetic */ Transition<S> $transition;
    int label;
    final /* synthetic */ SeekableTransitionState<S> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SeekableTransitionState$snapTo$2(SeekableTransitionState<S> seekableTransitionState, S s5, Transition<S> transition, Continuation<? super SeekableTransitionState$snapTo$2> continuation) {
        super(1, continuation);
        this.this$0 = seekableTransitionState;
        this.$targetState = s5;
        this.$transition = transition;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new SeekableTransitionState$snapTo$2(this.this$0, this.$targetState, this.$transition, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object waitForCompositionAfterTargetStateChange;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.endAllAnimations();
            ((SeekableTransitionState) this.this$0).lastFrameTimeNanos = Long.MIN_VALUE;
            this.this$0.setFraction(0.0f);
            S s5 = this.$targetState;
            float f5 = Intrinsics.areEqual(s5, this.this$0.getCurrentState()) ? -4.0f : Intrinsics.areEqual(s5, this.this$0.getTargetState()) ? -5.0f : -3.0f;
            this.$transition.updateTarget$animation_core_release(this.$targetState);
            this.$transition.setPlayTimeNanos(0L);
            this.this$0.setTargetState$animation_core_release(this.$targetState);
            this.this$0.setFraction(0.0f);
            this.this$0.setCurrentState$animation_core_release(this.$targetState);
            this.$transition.resetAnimationFraction$animation_core_release(f5);
            if (f5 == -3.0f) {
                SeekableTransitionState<S> seekableTransitionState = this.this$0;
                this.label = 1;
                waitForCompositionAfterTargetStateChange = seekableTransitionState.waitForCompositionAfterTargetStateChange(this);
                if (waitForCompositionAfterTargetStateChange == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.$transition.onTransitionEnd$animation_core_release();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((SeekableTransitionState$snapTo$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
