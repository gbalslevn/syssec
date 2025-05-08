package androidx.compose.animation.core;

import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001ae\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u0007*\u00020\u0006*\u00020\u00022\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\b\b\u0002\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001aA\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00110\f2\b\b\u0002\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {BuildConfig.FLAVOR, "label", "Landroidx/compose/animation/core/InfiniteTransition;", "rememberInfiniteTransition", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/InfiniteTransition;", "T", "Landroidx/compose/animation/core/AnimationVector;", "V", "initialValue", "targetValue", "Landroidx/compose/animation/core/TwoWayConverter;", "typeConverter", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "animationSpec", "Landroidx/compose/runtime/State;", "animateValue", "(Landroidx/compose/animation/core/InfiniteTransition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/InfiniteRepeatableSpec;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", BuildConfig.FLAVOR, "animateFloat", "(Landroidx/compose/animation/core/InfiniteTransition;FFLandroidx/compose/animation/core/InfiniteRepeatableSpec;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class InfiniteTransitionKt {
    public static final State<Float> animateFloat(InfiniteTransition infiniteTransition, float f5, float f6, InfiniteRepeatableSpec<Float> infiniteRepeatableSpec, String str, Composer composer, int i5, int i6) {
        String str2 = (i6 & 8) != 0 ? "FloatAnimation" : str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-644770905, i5, -1, "androidx.compose.animation.core.animateFloat (InfiniteTransition.kt:316)");
        }
        int i7 = i5 << 3;
        State<Float> animateValue = animateValue(infiniteTransition, Float.valueOf(f5), Float.valueOf(f6), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), infiniteRepeatableSpec, str2, composer, (i5 & 1022) | (57344 & i7) | (i7 & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return animateValue;
    }

    public static final <T, V extends AnimationVector> State<T> animateValue(final InfiniteTransition infiniteTransition, final T t5, final T t6, TwoWayConverter<T, V> twoWayConverter, final InfiniteRepeatableSpec<T> infiniteRepeatableSpec, String str, Composer composer, int i5, int i6) {
        if ((i6 & 16) != 0) {
            str = "ValueAnimation";
        }
        String str2 = str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1062847727, i5, -1, "androidx.compose.animation.core.animateValue (InfiniteTransition.kt:260)");
        }
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new InfiniteTransition.TransitionAnimationState(t5, t6, twoWayConverter, infiniteRepeatableSpec, str2);
            composer.updateRememberedValue(rememberedValue);
        }
        final InfiniteTransition.TransitionAnimationState transitionAnimationState = (InfiniteTransition.TransitionAnimationState) rememberedValue;
        boolean z5 = true;
        boolean z6 = ((((i5 & 112) ^ 48) > 32 && composer.changedInstance(t5)) || (i5 & 48) == 32) | ((((i5 & 896) ^ 384) > 256 && composer.changedInstance(t6)) || (i5 & 384) == 256);
        if ((((57344 & i5) ^ 24576) <= 16384 || !composer.changedInstance(infiniteRepeatableSpec)) && (i5 & 24576) != 16384) {
            z5 = false;
        }
        boolean z7 = z6 | z5;
        Object rememberedValue2 = composer.rememberedValue();
        if (z7 || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Function0<Unit>() { // from class: androidx.compose.animation.core.InfiniteTransitionKt$animateValue$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (Intrinsics.areEqual(t5, transitionAnimationState.getInitialValue$animation_core_release()) && Intrinsics.areEqual(t6, transitionAnimationState.getTargetValue$animation_core_release())) {
                        return;
                    }
                    transitionAnimationState.updateValues$animation_core_release(t5, t6, infiniteRepeatableSpec);
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        EffectsKt.SideEffect((Function0) rememberedValue2, composer, 0);
        boolean changedInstance = composer.changedInstance(infiniteTransition);
        Object rememberedValue3 = composer.rememberedValue();
        if (changedInstance || rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.InfiniteTransitionKt$animateValue$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    InfiniteTransition.this.addAnimation$animation_core_release(transitionAnimationState);
                    final InfiniteTransition infiniteTransition2 = InfiniteTransition.this;
                    final InfiniteTransition.TransitionAnimationState<T, V> transitionAnimationState2 = transitionAnimationState;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.InfiniteTransitionKt$animateValue$2$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            InfiniteTransition.this.removeAnimation$animation_core_release(transitionAnimationState2);
                        }
                    };
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        EffectsKt.DisposableEffect(transitionAnimationState, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue3, composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return transitionAnimationState;
    }

    public static final InfiniteTransition rememberInfiniteTransition(String str, Composer composer, int i5, int i6) {
        if ((i6 & 1) != 0) {
            str = "InfiniteTransition";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1013651573, i5, -1, "androidx.compose.animation.core.rememberInfiniteTransition (InfiniteTransition.kt:44)");
        }
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new InfiniteTransition(str);
            composer.updateRememberedValue(rememberedValue);
        }
        InfiniteTransition infiniteTransition = (InfiniteTransition) rememberedValue;
        infiniteTransition.run$animation_core_release(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return infiniteTransition;
    }
}
