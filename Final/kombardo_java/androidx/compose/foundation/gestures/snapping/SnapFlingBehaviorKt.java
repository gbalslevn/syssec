package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.FinalSnappingItem;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.adjust.sdk.Constants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a1\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\b\u0010\t\u001a\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001aX\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100\u0015*\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100\u000f2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u0012H\u0082@¢\u0006\u0004\b\u0016\u0010\u0017\u001a^\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100\u0015*\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00032\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100\u00192\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u0012H\u0082@¢\u0006\u0004\b\u001b\u0010\u001c\u001af\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100\u0015*\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00032\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100\u00192\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u0012H\u0082@¢\u0006\u0004\b\u001f\u0010 \u001a\u001b\u0010\"\u001a\u00020\u0003*\u00020\u00032\u0006\u0010!\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\"\u0010#\u001a*\u0010*\u001a\u00020\u00032\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b(\u0010)\"\u001a\u0010,\u001a\u00020+8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0014\u00101\u001a\u0002008\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u00102\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00063"}, d2 = {"Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "snapLayoutInfoProvider", "Landroidx/compose/animation/core/DecayAnimationSpec;", BuildConfig.FLAVOR, "decayAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "snapAnimationSpec", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "snapFlingBehavior", "(Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;)Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "rememberSnapFlingBehavior", "(Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialTargetOffset", "initialVelocity", "Landroidx/compose/foundation/gestures/snapping/ApproachAnimation;", "Landroidx/compose/animation/core/AnimationVector1D;", "animation", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onAnimationStep", "Landroidx/compose/foundation/gestures/snapping/AnimationResult;", "approach", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLandroidx/compose/foundation/gestures/snapping/ApproachAnimation;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "targetOffset", "Landroidx/compose/animation/core/AnimationState;", "animationState", "animateDecay", "(Landroidx/compose/foundation/gestures/ScrollScope;FLandroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelOffset", "animationSpec", "animateWithTarget", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLandroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "target", "coerceToTarget", "(FF)F", "Landroidx/compose/foundation/gestures/snapping/FinalSnappingItem;", "snappingOffset", "lowerBound", "upperBound", "calculateFinalOffset-Fhqu1e0", "(IFF)F", "calculateFinalOffset", "Landroidx/compose/ui/unit/Dp;", "MinFlingVelocityDp", "F", "getMinFlingVelocityDp", "()F", BuildConfig.FLAVOR, "DEBUG", "Z", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SnapFlingBehaviorKt {
    private static final boolean DEBUG = false;
    private static final float MinFlingVelocityDp = Dp.m2599constructorimpl(Constants.MINIMAL_ERROR_STATUS_CODE);

    public static final /* synthetic */ Object access$animateDecay(ScrollScope scrollScope, float f5, AnimationState animationState, DecayAnimationSpec decayAnimationSpec, Function1 function1, Continuation continuation) {
        return animateDecay(scrollScope, f5, animationState, decayAnimationSpec, function1, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object animateDecay(final ScrollScope scrollScope, final float f5, AnimationState<Float, AnimationVector1D> animationState, DecayAnimationSpec<Float> decayAnimationSpec, final Function1<? super Float, Unit> function1, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        SnapFlingBehaviorKt$animateDecay$1 snapFlingBehaviorKt$animateDecay$1;
        int i5;
        Ref$FloatRef ref$FloatRef;
        if (continuation instanceof SnapFlingBehaviorKt$animateDecay$1) {
            snapFlingBehaviorKt$animateDecay$1 = (SnapFlingBehaviorKt$animateDecay$1) continuation;
            int i6 = snapFlingBehaviorKt$animateDecay$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                snapFlingBehaviorKt$animateDecay$1.label = i6 - Integer.MIN_VALUE;
                Object obj = snapFlingBehaviorKt$animateDecay$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = snapFlingBehaviorKt$animateDecay$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    final Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
                    boolean z5 = animationState.getVelocity().floatValue() == 0.0f;
                    Function1<AnimationScope<Float, AnimationVector1D>, Unit> function12 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
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
                            float coerceToTarget;
                            if (Math.abs(animationScope.getValue().floatValue()) >= Math.abs(f5)) {
                                coerceToTarget = SnapFlingBehaviorKt.coerceToTarget(animationScope.getValue().floatValue(), f5);
                                SnapFlingBehaviorKt.animateDecay$consumeDelta(animationScope, scrollScope, function1, coerceToTarget - ref$FloatRef2.element);
                                animationScope.cancelAnimation();
                                ref$FloatRef2.element = coerceToTarget;
                                return;
                            }
                            SnapFlingBehaviorKt.animateDecay$consumeDelta(animationScope, scrollScope, function1, animationScope.getValue().floatValue() - ref$FloatRef2.element);
                            ref$FloatRef2.element = animationScope.getValue().floatValue();
                        }
                    };
                    snapFlingBehaviorKt$animateDecay$1.L$0 = animationState;
                    snapFlingBehaviorKt$animateDecay$1.L$1 = ref$FloatRef2;
                    snapFlingBehaviorKt$animateDecay$1.F$0 = f5;
                    snapFlingBehaviorKt$animateDecay$1.label = 1;
                    if (SuspendAnimationKt.animateDecay(animationState, decayAnimationSpec, !z5, function12, snapFlingBehaviorKt$animateDecay$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ref$FloatRef = ref$FloatRef2;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    f5 = snapFlingBehaviorKt$animateDecay$1.F$0;
                    ref$FloatRef = (Ref$FloatRef) snapFlingBehaviorKt$animateDecay$1.L$1;
                    animationState = (AnimationState) snapFlingBehaviorKt$animateDecay$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return new AnimationResult(Boxing.boxFloat(f5 - ref$FloatRef.element), animationState);
            }
        }
        snapFlingBehaviorKt$animateDecay$1 = new SnapFlingBehaviorKt$animateDecay$1(continuation);
        Object obj2 = snapFlingBehaviorKt$animateDecay$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = snapFlingBehaviorKt$animateDecay$1.label;
        if (i5 != 0) {
        }
        return new AnimationResult(Boxing.boxFloat(f5 - ref$FloatRef.element), animationState);
    }

    public static final void animateDecay$consumeDelta(AnimationScope<Float, AnimationVector1D> animationScope, ScrollScope scrollScope, Function1<? super Float, Unit> function1, float f5) {
        float scrollBy = scrollScope.scrollBy(f5);
        function1.invoke(Float.valueOf(scrollBy));
        if (Math.abs(f5 - scrollBy) > 0.5f) {
            animationScope.cancelAnimation();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object animateWithTarget(final ScrollScope scrollScope, float f5, final float f6, AnimationState<Float, AnimationVector1D> animationState, AnimationSpec<Float> animationSpec, final Function1<? super Float, Unit> function1, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        SnapFlingBehaviorKt$animateWithTarget$1 snapFlingBehaviorKt$animateWithTarget$1;
        int i5;
        float f7;
        Ref$FloatRef ref$FloatRef;
        float f8;
        AnimationState<Float, AnimationVector1D> animationState2;
        if (continuation instanceof SnapFlingBehaviorKt$animateWithTarget$1) {
            snapFlingBehaviorKt$animateWithTarget$1 = (SnapFlingBehaviorKt$animateWithTarget$1) continuation;
            int i6 = snapFlingBehaviorKt$animateWithTarget$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                snapFlingBehaviorKt$animateWithTarget$1.label = i6 - Integer.MIN_VALUE;
                SnapFlingBehaviorKt$animateWithTarget$1 snapFlingBehaviorKt$animateWithTarget$12 = snapFlingBehaviorKt$animateWithTarget$1;
                Object obj = snapFlingBehaviorKt$animateWithTarget$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = snapFlingBehaviorKt$animateWithTarget$12.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    final Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
                    float floatValue = animationState.getVelocity().floatValue();
                    Float boxFloat = Boxing.boxFloat(f5);
                    boolean z5 = animationState.getVelocity().floatValue() == 0.0f;
                    Function1<AnimationScope<Float, AnimationVector1D>, Unit> function12 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateWithTarget$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
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
                            float coerceToTarget;
                            coerceToTarget = SnapFlingBehaviorKt.coerceToTarget(animationScope.getValue().floatValue(), f6);
                            float f9 = coerceToTarget - ref$FloatRef2.element;
                            float scrollBy = scrollScope.scrollBy(f9);
                            function1.invoke(Float.valueOf(scrollBy));
                            if (Math.abs(f9 - scrollBy) > 0.5f || coerceToTarget != animationScope.getValue().floatValue()) {
                                animationScope.cancelAnimation();
                            }
                            ref$FloatRef2.element += scrollBy;
                        }
                    };
                    snapFlingBehaviorKt$animateWithTarget$12.L$0 = animationState;
                    snapFlingBehaviorKt$animateWithTarget$12.L$1 = ref$FloatRef2;
                    f7 = f5;
                    snapFlingBehaviorKt$animateWithTarget$12.F$0 = f7;
                    snapFlingBehaviorKt$animateWithTarget$12.F$1 = floatValue;
                    snapFlingBehaviorKt$animateWithTarget$12.label = 1;
                    if (SuspendAnimationKt.animateTo(animationState, boxFloat, animationSpec, !z5, function12, snapFlingBehaviorKt$animateWithTarget$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ref$FloatRef = ref$FloatRef2;
                    f8 = floatValue;
                    animationState2 = animationState;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    f8 = snapFlingBehaviorKt$animateWithTarget$12.F$1;
                    float f9 = snapFlingBehaviorKt$animateWithTarget$12.F$0;
                    ref$FloatRef = (Ref$FloatRef) snapFlingBehaviorKt$animateWithTarget$12.L$1;
                    AnimationState<Float, AnimationVector1D> animationState3 = (AnimationState) snapFlingBehaviorKt$animateWithTarget$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    f7 = f9;
                    animationState2 = animationState3;
                }
                return new AnimationResult(Boxing.boxFloat(f7 - ref$FloatRef.element), AnimationStateKt.copy$default((AnimationState) animationState2, 0.0f, coerceToTarget(animationState2.getVelocity().floatValue(), f8), 0L, 0L, false, 29, (Object) null));
            }
        }
        snapFlingBehaviorKt$animateWithTarget$1 = new SnapFlingBehaviorKt$animateWithTarget$1(continuation);
        SnapFlingBehaviorKt$animateWithTarget$1 snapFlingBehaviorKt$animateWithTarget$122 = snapFlingBehaviorKt$animateWithTarget$1;
        Object obj2 = snapFlingBehaviorKt$animateWithTarget$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = snapFlingBehaviorKt$animateWithTarget$122.label;
        if (i5 != 0) {
        }
        return new AnimationResult(Boxing.boxFloat(f7 - ref$FloatRef.element), AnimationStateKt.copy$default((AnimationState) animationState2, 0.0f, coerceToTarget(animationState2.getVelocity().floatValue(), f8), 0L, 0L, false, 29, (Object) null));
    }

    public static final Object approach(ScrollScope scrollScope, float f5, float f6, ApproachAnimation<Float, AnimationVector1D> approachAnimation, Function1<? super Float, Unit> function1, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        return approachAnimation.approachAnimation(scrollScope, Boxing.boxFloat(f5), Boxing.boxFloat(f6), function1, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0017, code lost:
    
        if (java.lang.Math.abs(r5) <= java.lang.Math.abs(r4)) goto L28;
     */
    /* renamed from: calculateFinalOffset-Fhqu1e0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final float m256calculateFinalOffsetFhqu1e0(int i5, float f5, float f6) {
        FinalSnappingItem.Companion companion = FinalSnappingItem.INSTANCE;
        if (!FinalSnappingItem.m252equalsimpl0(i5, companion.m253getClosestItembbeMdSM())) {
            if (!FinalSnappingItem.m252equalsimpl0(i5, companion.m254getNextItembbeMdSM())) {
                if (!FinalSnappingItem.m252equalsimpl0(i5, companion.m255getPreviousItembbeMdSM())) {
                    f5 = 0.0f;
                }
            }
            f5 = f6;
        }
        if (calculateFinalOffset_Fhqu1e0$isValidDistance(f5)) {
            return f5;
        }
        return 0.0f;
    }

    private static final boolean calculateFinalOffset_Fhqu1e0$isValidDistance(float f5) {
        return (f5 == Float.POSITIVE_INFINITY || f5 == Float.NEGATIVE_INFINITY) ? false : true;
    }

    public static final float coerceToTarget(float f5, float f6) {
        if (f6 == 0.0f) {
            return 0.0f;
        }
        return f6 > 0.0f ? RangesKt.coerceAtMost(f5, f6) : RangesKt.coerceAtLeast(f5, f6);
    }

    public static final float getMinFlingVelocityDp() {
        return MinFlingVelocityDp;
    }

    public static final TargetedFlingBehavior rememberSnapFlingBehavior(SnapLayoutInfoProvider snapLayoutInfoProvider, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1921733134, i5, -1, "androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior (SnapFlingBehavior.kt:256)");
        }
        Object obj = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        DecayAnimationSpec rememberSplineBasedDecay = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer, 0);
        boolean changed = composer.changed(rememberSplineBasedDecay) | ((((i5 & 14) ^ 6) > 4 && composer.changed(snapLayoutInfoProvider)) || (i5 & 6) == 4) | composer.changed(obj);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = snapFlingBehavior(snapLayoutInfoProvider, rememberSplineBasedDecay, AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null));
            composer.updateRememberedValue(rememberedValue);
        }
        TargetedFlingBehavior targetedFlingBehavior = (TargetedFlingBehavior) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return targetedFlingBehavior;
    }

    public static final TargetedFlingBehavior snapFlingBehavior(SnapLayoutInfoProvider snapLayoutInfoProvider, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec) {
        return new SnapFlingBehavior(snapLayoutInfoProvider, decayAnimationSpec, animationSpec);
    }
}
