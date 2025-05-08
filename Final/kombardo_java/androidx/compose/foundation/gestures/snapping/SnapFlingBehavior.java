package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.ui.MotionDurationScale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.conscrypt.BuildConfig;

@Deprecated
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0004\b\t\u0010\nJ<\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u0010*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\rH\u0082@¢\u0006\u0004\b\u0012\u0010\u0013JD\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u0017*\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\rH\u0082@¢\u0006\u0004\b\u0018\u0010\u0019JD\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u0010*\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\rH\u0082@¢\u0006\u0004\b\u001c\u0010\u0019J\u001f\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ0\u0010!\u001a\u00020\u0005*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\rH\u0096@¢\u0006\u0004\b!\u0010\u0013J\u001a\u0010$\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0096\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010)R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010*R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010+R\"\u0010-\u001a\u00020,8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00063"}, d2 = {"Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "snapLayoutInfoProvider", "Landroidx/compose/animation/core/DecayAnimationSpec;", BuildConfig.FLAVOR, "decayAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "snapAnimationSpec", "<init>", "(Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;)V", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onRemainingScrollOffsetUpdate", "Landroidx/compose/foundation/gestures/snapping/AnimationResult;", "Landroidx/compose/animation/core/AnimationVector1D;", "fling", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "offset", "velocity", "updateRemainingScrollOffset", "Landroidx/compose/animation/core/AnimationState;", "tryApproach", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initialTargetOffset", "onAnimationStep", "runApproach", BuildConfig.FLAVOR, "isDecayApproachPossible", "(FF)Z", "onRemainingDistanceUpdated", "performFling", BuildConfig.FLAVOR, "other", "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "Landroidx/compose/animation/core/DecayAnimationSpec;", "Landroidx/compose/animation/core/AnimationSpec;", "Landroidx/compose/ui/MotionDurationScale;", "motionScaleDuration", "Landroidx/compose/ui/MotionDurationScale;", "getMotionScaleDuration$foundation_release", "()Landroidx/compose/ui/MotionDurationScale;", "setMotionScaleDuration$foundation_release", "(Landroidx/compose/ui/MotionDurationScale;)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapFlingBehavior implements TargetedFlingBehavior {
    private final DecayAnimationSpec<Float> decayAnimationSpec;
    private MotionDurationScale motionScaleDuration = ScrollableKt.getDefaultScrollMotionDurationScale();
    private final AnimationSpec<Float> snapAnimationSpec;
    private final SnapLayoutInfoProvider snapLayoutInfoProvider;

    public SnapFlingBehavior(SnapLayoutInfoProvider snapLayoutInfoProvider, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec) {
        this.snapLayoutInfoProvider = snapLayoutInfoProvider;
        this.decayAnimationSpec = decayAnimationSpec;
        this.snapAnimationSpec = animationSpec;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fling(ScrollScope scrollScope, float f5, Function1<? super Float, Unit> function1, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        SnapFlingBehavior$fling$1 snapFlingBehavior$fling$1;
        int i5;
        if (continuation instanceof SnapFlingBehavior$fling$1) {
            snapFlingBehavior$fling$1 = (SnapFlingBehavior$fling$1) continuation;
            int i6 = snapFlingBehavior$fling$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                snapFlingBehavior$fling$1.label = i6 - Integer.MIN_VALUE;
                Object obj = snapFlingBehavior$fling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = snapFlingBehavior$fling$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    MotionDurationScale motionDurationScale = this.motionScaleDuration;
                    SnapFlingBehavior$fling$result$1 snapFlingBehavior$fling$result$1 = new SnapFlingBehavior$fling$result$1(this, f5, function1, scrollScope, null);
                    snapFlingBehavior$fling$1.L$0 = function1;
                    snapFlingBehavior$fling$1.label = 1;
                    obj = BuildersKt.withContext(motionDurationScale, snapFlingBehavior$fling$result$1, snapFlingBehavior$fling$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    function1 = (Function1) snapFlingBehavior$fling$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                AnimationResult animationResult = (AnimationResult) obj;
                function1.invoke(Boxing.boxFloat(0.0f));
                return animationResult;
            }
        }
        snapFlingBehavior$fling$1 = new SnapFlingBehavior$fling$1(this, continuation);
        Object obj2 = snapFlingBehavior$fling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = snapFlingBehavior$fling$1.label;
        if (i5 != 0) {
        }
        AnimationResult animationResult2 = (AnimationResult) obj2;
        function1.invoke(Boxing.boxFloat(0.0f));
        return animationResult2;
    }

    private final boolean isDecayApproachPossible(float offset, float velocity) {
        return Math.abs(DecayAnimationSpecKt.calculateTargetValue(this.decayAnimationSpec, 0.0f, velocity)) >= Math.abs(offset);
    }

    private final Object runApproach(ScrollScope scrollScope, float f5, float f6, Function1<? super Float, Unit> function1, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        Object approach;
        approach = SnapFlingBehaviorKt.approach(scrollScope, f5, f6, isDecayApproachPossible(f5, f6) ? new DecayApproachAnimation(this.decayAnimationSpec) : new TargetApproachAnimation(this.snapAnimationSpec), function1, continuation);
        return approach;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object tryApproach(ScrollScope scrollScope, float f5, float f6, Function1<? super Float, Unit> function1, Continuation<? super AnimationState<Float, AnimationVector1D>> continuation) {
        SnapFlingBehavior$tryApproach$1 snapFlingBehavior$tryApproach$1;
        int i5;
        if (continuation instanceof SnapFlingBehavior$tryApproach$1) {
            snapFlingBehavior$tryApproach$1 = (SnapFlingBehavior$tryApproach$1) continuation;
            int i6 = snapFlingBehavior$tryApproach$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                snapFlingBehavior$tryApproach$1.label = i6 - Integer.MIN_VALUE;
                SnapFlingBehavior$tryApproach$1 snapFlingBehavior$tryApproach$12 = snapFlingBehavior$tryApproach$1;
                Object obj = snapFlingBehavior$tryApproach$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = snapFlingBehavior$tryApproach$12.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (Math.abs(f5) == 0.0f || Math.abs(f6) == 0.0f) {
                        return AnimationStateKt.AnimationState$default(f5, f6, 0L, 0L, false, 28, null);
                    }
                    snapFlingBehavior$tryApproach$12.label = 1;
                    obj = runApproach(scrollScope, f5, f6, function1, snapFlingBehavior$tryApproach$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((AnimationResult) obj).getCurrentAnimationState();
            }
        }
        snapFlingBehavior$tryApproach$1 = new SnapFlingBehavior$tryApproach$1(this, continuation);
        SnapFlingBehavior$tryApproach$1 snapFlingBehavior$tryApproach$122 = snapFlingBehavior$tryApproach$1;
        Object obj2 = snapFlingBehavior$tryApproach$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = snapFlingBehavior$tryApproach$122.label;
        if (i5 != 0) {
        }
        return ((AnimationResult) obj2).getCurrentAnimationState();
    }

    public boolean equals(Object other) {
        if (!(other instanceof SnapFlingBehavior)) {
            return false;
        }
        SnapFlingBehavior snapFlingBehavior = (SnapFlingBehavior) other;
        return Intrinsics.areEqual(snapFlingBehavior.snapAnimationSpec, this.snapAnimationSpec) && Intrinsics.areEqual(snapFlingBehavior.decayAnimationSpec, this.decayAnimationSpec) && Intrinsics.areEqual(snapFlingBehavior.snapLayoutInfoProvider, this.snapLayoutInfoProvider);
    }

    public int hashCode() {
        return (((this.snapAnimationSpec.hashCode() * 31) + this.decayAnimationSpec.hashCode()) * 31) + this.snapLayoutInfoProvider.hashCode();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // androidx.compose.foundation.gestures.TargetedFlingBehavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object performFling(ScrollScope scrollScope, float f5, Function1<? super Float, Unit> function1, Continuation<? super Float> continuation) {
        SnapFlingBehavior$performFling$1 snapFlingBehavior$performFling$1;
        int i5;
        if (continuation instanceof SnapFlingBehavior$performFling$1) {
            snapFlingBehavior$performFling$1 = (SnapFlingBehavior$performFling$1) continuation;
            int i6 = snapFlingBehavior$performFling$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                snapFlingBehavior$performFling$1.label = i6 - Integer.MIN_VALUE;
                Object obj = snapFlingBehavior$performFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = snapFlingBehavior$performFling$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    snapFlingBehavior$performFling$1.label = 1;
                    obj = fling(scrollScope, f5, function1, snapFlingBehavior$performFling$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                AnimationResult animationResult = (AnimationResult) obj;
                return Boxing.boxFloat(((Number) animationResult.component1()).floatValue() != 0.0f ? ((Number) animationResult.component2().getVelocity()).floatValue() : 0.0f);
            }
        }
        snapFlingBehavior$performFling$1 = new SnapFlingBehavior$performFling$1(this, continuation);
        Object obj2 = snapFlingBehavior$performFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = snapFlingBehavior$performFling$1.label;
        if (i5 != 0) {
        }
        AnimationResult animationResult2 = (AnimationResult) obj2;
        return Boxing.boxFloat(((Number) animationResult2.component1()).floatValue() != 0.0f ? ((Number) animationResult2.component2().getVelocity()).floatValue() : 0.0f);
    }
}
