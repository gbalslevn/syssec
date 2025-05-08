package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2", f = "Scrollable.kt", l = {893}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class DefaultFlingBehavior$performFling$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Float>, Object> {
    final /* synthetic */ float $initialVelocity;
    final /* synthetic */ ScrollScope $this_performFling;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DefaultFlingBehavior this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultFlingBehavior$performFling$2(float f5, DefaultFlingBehavior defaultFlingBehavior, ScrollScope scrollScope, Continuation<? super DefaultFlingBehavior$performFling$2> continuation) {
        super(2, continuation);
        this.$initialVelocity = f5;
        this.this$0 = defaultFlingBehavior;
        this.$this_performFling = scrollScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultFlingBehavior$performFling$2(this.$initialVelocity, this.this$0, this.$this_performFling, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        float f5;
        Ref$FloatRef ref$FloatRef;
        AnimationState animationState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            if (Math.abs(this.$initialVelocity) <= 1.0f) {
                f5 = this.$initialVelocity;
                return Boxing.boxFloat(f5);
            }
            final Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
            ref$FloatRef2.element = this.$initialVelocity;
            final Ref$FloatRef ref$FloatRef3 = new Ref$FloatRef();
            AnimationState AnimationState$default = AnimationStateKt.AnimationState$default(0.0f, this.$initialVelocity, 0L, 0L, false, 28, null);
            try {
                DecayAnimationSpec<Float> flingDecay = this.this$0.getFlingDecay();
                final ScrollScope scrollScope = this.$this_performFling;
                final DefaultFlingBehavior defaultFlingBehavior = this.this$0;
                Function1<AnimationScope<Float, AnimationVector1D>, Unit> function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                        invoke2(animationScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                        float floatValue = animationScope.getValue().floatValue() - Ref$FloatRef.this.element;
                        float scrollBy = scrollScope.scrollBy(floatValue);
                        Ref$FloatRef.this.element = animationScope.getValue().floatValue();
                        ref$FloatRef2.element = animationScope.getVelocity().floatValue();
                        if (Math.abs(floatValue - scrollBy) > 0.5f) {
                            animationScope.cancelAnimation();
                        }
                        DefaultFlingBehavior defaultFlingBehavior2 = defaultFlingBehavior;
                        defaultFlingBehavior2.setLastAnimationCycleCount(defaultFlingBehavior2.getLastAnimationCycleCount() + 1);
                    }
                };
                this.L$0 = ref$FloatRef2;
                this.L$1 = AnimationState$default;
                this.label = 1;
                if (SuspendAnimationKt.animateDecay$default(AnimationState$default, flingDecay, false, function1, this, 2, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ref$FloatRef = ref$FloatRef2;
            } catch (CancellationException unused) {
                ref$FloatRef = ref$FloatRef2;
                animationState = AnimationState$default;
                ref$FloatRef.element = ((Number) animationState.getVelocity()).floatValue();
                f5 = ref$FloatRef.element;
                return Boxing.boxFloat(f5);
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            animationState = (AnimationState) this.L$1;
            ref$FloatRef = (Ref$FloatRef) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (CancellationException unused2) {
                ref$FloatRef.element = ((Number) animationState.getVelocity()).floatValue();
                f5 = ref$FloatRef.element;
                return Boxing.boxFloat(f5);
            }
        }
        f5 = ref$FloatRef.element;
        return Boxing.boxFloat(f5);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Float> continuation) {
        return ((DefaultFlingBehavior$performFling$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
