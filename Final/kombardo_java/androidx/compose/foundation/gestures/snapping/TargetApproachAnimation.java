package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007JH\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\fH\u0096@¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/gestures/snapping/TargetApproachAnimation;", "Landroidx/compose/foundation/gestures/snapping/ApproachAnimation;", BuildConfig.FLAVOR, "Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpec", "<init>", "(Landroidx/compose/animation/core/AnimationSpec;)V", "Landroidx/compose/foundation/gestures/ScrollScope;", "scope", "offset", "velocity", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onAnimationStep", "Landroidx/compose/foundation/gestures/snapping/AnimationResult;", "approachAnimation", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/animation/core/AnimationSpec;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class TargetApproachAnimation implements ApproachAnimation<Float, AnimationVector1D> {
    private final AnimationSpec<Float> animationSpec;

    public TargetApproachAnimation(AnimationSpec<Float> animationSpec) {
        this.animationSpec = animationSpec;
    }

    @Override // androidx.compose.foundation.gestures.snapping.ApproachAnimation
    public /* bridge */ /* synthetic */ Object approachAnimation(ScrollScope scrollScope, Float f5, Float f6, Function1<? super Float, Unit> function1, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        return approachAnimation(scrollScope, f5.floatValue(), f6.floatValue(), function1, continuation);
    }

    public Object approachAnimation(ScrollScope scrollScope, float f5, float f6, Function1<? super Float, Unit> function1, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        Object animateWithTarget;
        animateWithTarget = SnapFlingBehaviorKt.animateWithTarget(scrollScope, Math.abs(f5) * Math.signum(f6), f5, AnimationStateKt.AnimationState$default(0.0f, f6, 0L, 0L, false, 28, null), this.animationSpec, function1, continuation);
        return animateWithTarget == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateWithTarget : (AnimationResult) animateWithTarget;
    }
}
