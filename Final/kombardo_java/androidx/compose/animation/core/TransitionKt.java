package androidx.compose.animation.core;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000d\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\u001a/\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a5\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\t\u0010\n\u001a5\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\f\u001ac\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0012R\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u0000\"\b\b\u0002\u0010\u000f*\u00020\u000e*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00102\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001aC\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0015\u001a\u00028\u00012\u0006\u0010\u0001\u001a\u00028\u00012\u0006\u0010\u0016\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001ao\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u001d\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u0000\"\b\b\u0002\u0010\u000f*\u00020\u000e*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0019\u001a\u00028\u00012\u0006\u0010\u001a\u001a\u00028\u00012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u001e\u0010\u001f\"$\u0010#\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030!\u0012\u0004\u0012\u00020\"0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$\"\u001b\u0010*\u001a\u00020%8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0014\u0010,\u001a\u00020+8\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010-\"\u0014\u0010.\u001a\u00020+8\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010-\"\u0014\u0010/\u001a\u00020+8\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u0010-\"\u0014\u00100\u001a\u00020+8\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u0010-\"\u0014\u00101\u001a\u00020+8\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u0010-¨\u00062"}, d2 = {"T", "targetState", BuildConfig.FLAVOR, "label", "Landroidx/compose/animation/core/Transition;", "updateTransition", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/core/TransitionState;", "transitionState", "rememberTransition", "(Landroidx/compose/animation/core/TransitionState;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/core/MutableTransitionState;", "(Landroidx/compose/animation/core/MutableTransitionState;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "S", "Landroidx/compose/animation/core/AnimationVector;", "V", "Landroidx/compose/animation/core/TwoWayConverter;", "typeConverter", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "createDeferredAnimation", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition$DeferredAnimation;", "initialState", "childLabel", "createChildTransitionInternal", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/Transition;", "initialValue", "targetValue", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "animationSpec", "Landroidx/compose/runtime/State;", "createTransitionAnimation", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "Lkotlin/Function1;", "Landroidx/compose/animation/core/SeekableTransitionState;", BuildConfig.FLAVOR, "SeekableTransitionStateTotalDurationChanged", "Lkotlin/jvm/functions/Function1;", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "SeekableStateObserver$delegate", "Lkotlin/Lazy;", "getSeekableStateObserver", "()Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "SeekableStateObserver", BuildConfig.FLAVOR, "NoReset", "F", "ResetNoSnap", "ResetAnimationSnap", "ResetAnimationSnapCurrent", "ResetAnimationSnapTarget", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class TransitionKt {
    private static final float NoReset = -1.0f;
    private static final float ResetAnimationSnap = -3.0f;
    private static final float ResetAnimationSnapCurrent = -4.0f;
    private static final float ResetAnimationSnapTarget = -5.0f;
    private static final float ResetNoSnap = -2.0f;
    private static final Function1<SeekableTransitionState<?>, Unit> SeekableTransitionStateTotalDurationChanged = new Function1<SeekableTransitionState<?>, Unit>() { // from class: androidx.compose.animation.core.TransitionKt$SeekableTransitionStateTotalDurationChanged$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SeekableTransitionState<?> seekableTransitionState) {
            invoke2(seekableTransitionState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SeekableTransitionState<?> seekableTransitionState) {
            seekableTransitionState.onTotalDurationChanged$animation_core_release();
        }
    };
    private static final Lazy SeekableStateObserver$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<SnapshotStateObserver>() { // from class: androidx.compose.animation.core.TransitionKt$SeekableStateObserver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SnapshotStateObserver invoke() {
            SnapshotStateObserver snapshotStateObserver = new SnapshotStateObserver(new Function1<Function0<? extends Unit>, Unit>() { // from class: androidx.compose.animation.core.TransitionKt$SeekableStateObserver$2.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0) {
                    invoke2((Function0<Unit>) function0);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Function0<Unit> function0) {
                    function0.invoke();
                }
            });
            snapshotStateObserver.start();
            return snapshotStateObserver;
        }
    });

    public static final <S, T> Transition<T> createChildTransitionInternal(final Transition<S> transition, T t5, T t6, String str, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-198307638, i5, -1, "androidx.compose.animation.core.createChildTransitionInternal (Transition.kt:1825)");
        }
        int i6 = (i5 & 14) ^ 6;
        boolean z5 = true;
        boolean z6 = (i6 > 4 && composer.changed(transition)) || (i5 & 6) == 4;
        Object rememberedValue = composer.rememberedValue();
        if (z6 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Transition(new MutableTransitionState(t5), transition, transition.getLabel() + " > " + str);
            composer.updateRememberedValue(rememberedValue);
        }
        final Transition<T> transition2 = (Transition) rememberedValue;
        if ((i6 <= 4 || !composer.changed(transition)) && (i5 & 6) != 4) {
            z5 = false;
        }
        boolean changed = composer.changed(transition2) | z5;
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$createChildTransitionInternal$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    transition.addTransition$animation_core_release(transition2);
                    final Transition<S> transition3 = transition;
                    final Transition<T> transition4 = transition2;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$createChildTransitionInternal$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            Transition.this.removeTransition$animation_core_release(transition4);
                        }
                    };
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        EffectsKt.DisposableEffect(transition2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue2, composer, 0);
        if (transition.isSeeking()) {
            transition2.seek(t5, t6, transition.getLastSeekedTimeNanos());
        } else {
            transition2.updateTarget$animation_core_release(t6);
            transition2.setSeeking$animation_core_release(false);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return transition2;
    }

    public static final <S, T, V extends AnimationVector> Transition<S>.DeferredAnimation<T, V> createDeferredAnimation(final Transition<S> transition, TwoWayConverter<T, V> twoWayConverter, String str, Composer composer, int i5, int i6) {
        if ((i6 & 2) != 0) {
            str = "DeferredAnimation";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1714122528, i5, -1, "androidx.compose.animation.core.createDeferredAnimation (Transition.kt:1779)");
        }
        int i7 = (i5 & 14) ^ 6;
        boolean z5 = true;
        boolean z6 = (i7 > 4 && composer.changed(transition)) || (i5 & 6) == 4;
        Object rememberedValue = composer.rememberedValue();
        if (z6 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Transition.DeferredAnimation(twoWayConverter, str);
            composer.updateRememberedValue(rememberedValue);
        }
        final Transition<S>.DeferredAnimation<T, V> deferredAnimation = (Transition.DeferredAnimation) rememberedValue;
        if ((i7 <= 4 || !composer.changed(transition)) && (i5 & 6) != 4) {
            z5 = false;
        }
        boolean changedInstance = composer.changedInstance(deferredAnimation) | z5;
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$createDeferredAnimation$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    final Transition<S> transition2 = transition;
                    final Transition<S>.DeferredAnimation<T, V> deferredAnimation2 = deferredAnimation;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$createDeferredAnimation$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            Transition.this.removeAnimation$animation_core_release(deferredAnimation2);
                        }
                    };
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        EffectsKt.DisposableEffect(deferredAnimation, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue2, composer, 0);
        if (transition.isSeeking()) {
            deferredAnimation.setupSeeking$animation_core_release();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return deferredAnimation;
    }

    public static final <S, T, V extends AnimationVector> State<T> createTransitionAnimation(final Transition<S> transition, T t5, T t6, FiniteAnimationSpec<T> finiteAnimationSpec, TwoWayConverter<T, V> twoWayConverter, String str, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-304821198, i5, -1, "androidx.compose.animation.core.createTransitionAnimation (Transition.kt:1900)");
        }
        int i6 = (i5 & 14) ^ 6;
        boolean z5 = true;
        boolean z6 = (i6 > 4 && composer.changed(transition)) || (i5 & 6) == 4;
        Object rememberedValue = composer.rememberedValue();
        if (z6 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            Object transitionAnimationState = new Transition.TransitionAnimationState(t5, AnimationStateKt.createZeroVectorFrom(twoWayConverter, t6), twoWayConverter, str);
            composer.updateRememberedValue(transitionAnimationState);
            rememberedValue = transitionAnimationState;
        }
        final Transition.TransitionAnimationState transitionAnimationState2 = (Transition.TransitionAnimationState) rememberedValue;
        if (transition.isSeeking()) {
            transitionAnimationState2.updateInitialAndTargetValue$animation_core_release(t5, t6, finiteAnimationSpec);
        } else {
            transitionAnimationState2.updateTargetValue$animation_core_release(t6, finiteAnimationSpec);
        }
        if ((i6 <= 4 || !composer.changed(transition)) && (i5 & 6) != 4) {
            z5 = false;
        }
        boolean changed = composer.changed(transitionAnimationState2) | z5;
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$createTransitionAnimation$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    transition.addAnimation$animation_core_release(transitionAnimationState2);
                    final Transition<S> transition2 = transition;
                    final Transition<S>.TransitionAnimationState<T, V> transitionAnimationState3 = transitionAnimationState2;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$createTransitionAnimation$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            Transition.this.removeAnimation$animation_core_release(transitionAnimationState3);
                        }
                    };
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        EffectsKt.DisposableEffect(transitionAnimationState2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return transitionAnimationState2;
    }

    public static final SnapshotStateObserver getSeekableStateObserver() {
        return (SnapshotStateObserver) SeekableStateObserver$delegate.getValue();
    }

    public static final <T> Transition<T> rememberTransition(TransitionState<T> transitionState, String str, Composer composer, int i5, int i6) {
        if ((i6 & 2) != 0) {
            str = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1643203617, i5, -1, "androidx.compose.animation.core.rememberTransition (Transition.kt:820)");
        }
        int i7 = (i5 & 14) ^ 6;
        boolean z5 = true;
        boolean z6 = (i7 > 4 && composer.changed(transitionState)) || (i5 & 6) == 4;
        Object rememberedValue = composer.rememberedValue();
        if (z6 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Transition((TransitionState) transitionState, str);
            composer.updateRememberedValue(rememberedValue);
        }
        final Transition<T> transition = (Transition) rememberedValue;
        if (transitionState instanceof SeekableTransitionState) {
            composer.startReplaceGroup(1030413636);
            T currentState = transitionState.getCurrentState();
            T targetState = transitionState.getTargetState();
            if ((i7 <= 4 || !composer.changed(transitionState)) && (i5 & 6) != 4) {
                z5 = false;
            }
            Object rememberedValue2 = composer.rememberedValue();
            if (z5 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new TransitionKt$rememberTransition$1$1(transitionState, null);
                composer.updateRememberedValue(rememberedValue2);
            }
            EffectsKt.LaunchedEffect(currentState, targetState, (Function2) rememberedValue2, composer, 0);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(1030875195);
            transition.animateTo$animation_core_release(transitionState.getTargetState(), composer, 0);
            composer.endReplaceGroup();
        }
        boolean changed = composer.changed(transition);
        Object rememberedValue3 = composer.rememberedValue();
        if (changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$rememberTransition$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    final Transition<T> transition2 = transition;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$rememberTransition$2$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            Transition.this.onDisposed$animation_core_release();
                        }
                    };
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        EffectsKt.DisposableEffect(transition, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue3, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return transition;
    }

    public static final <T> Transition<T> updateTransition(T t5, String str, Composer composer, int i5, int i6) {
        if ((i6 & 2) != 0) {
            str = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2029166765, i5, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:91)");
        }
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new Transition(t5, str);
            composer.updateRememberedValue(rememberedValue);
        }
        final Transition<T> transition = (Transition) rememberedValue;
        transition.animateTo$animation_core_release(t5, composer, (i5 & 8) | 48 | (i5 & 14));
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$updateTransition$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    final Transition<T> transition2 = transition;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$updateTransition$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            Transition.this.onDisposed$animation_core_release();
                        }
                    };
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        EffectsKt.DisposableEffect(transition, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue2, composer, 54);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return transition;
    }

    @Deprecated
    public static final <T> Transition<T> updateTransition(MutableTransitionState<T> mutableTransitionState, String str, Composer composer, int i5, int i6) {
        if ((i6 & 2) != 0) {
            str = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(882913843, i5, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:873)");
        }
        Transition<T> rememberTransition = rememberTransition(mutableTransitionState, str, composer, i5 & 126, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return rememberTransition;
    }
}
