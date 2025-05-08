package androidx.compose.animation.core;

import androidx.compose.animation.core.SeekableTransitionState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.sync.Mutex;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "S"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$animateTo$2", f = "Transition.kt", l = {623}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SeekableTransitionState$animateTo$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ FiniteAnimationSpec<Float> $animationSpec;
    final /* synthetic */ S $targetState;
    final /* synthetic */ Transition<S> $transition;
    int label;
    final /* synthetic */ SeekableTransitionState<S> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "S", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$animateTo$2$1", f = "Transition.kt", l = {2191, 636, 638, 690, 692}, m = "invokeSuspend")
    /* renamed from: androidx.compose.animation.core.SeekableTransitionState$animateTo$2$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FiniteAnimationSpec<Float> $animationSpec;
        final /* synthetic */ S $targetState;
        final /* synthetic */ Transition<S> $transition;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SeekableTransitionState<S> seekableTransitionState, S s5, Transition<S> transition, FiniteAnimationSpec<Float> finiteAnimationSpec, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = seekableTransitionState;
            this.$targetState = s5;
            this.$transition = transition;
            this.$animationSpec = finiteAnimationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$targetState, this.$transition, this.$animationSpec, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x01e7 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00c6  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x00b7 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Mutex mutex;
            SeekableTransitionState seekableTransitionState;
            Object doOneFrame;
            Object waitForCompositionAfterTargetStateChange;
            Object runAnimations;
            SeekableTransitionState.SeekingAnimationState seekingAnimationState;
            SeekableTransitionState.Companion companion;
            AnimationVector1D zeroVelocity;
            SeekableTransitionState.Companion companion2;
            long roundToLong;
            SeekableTransitionState.Companion companion3;
            SeekableTransitionState.Companion companion4;
            SeekableTransitionState.Companion companion5;
            Object waitForComposition;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            try {
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Object targetState = this.this$0.getTargetState();
                    if (!Intrinsics.areEqual(this.$targetState, targetState)) {
                        this.this$0.moveAnimationToInitialState();
                        this.this$0.setFraction(0.0f);
                        this.$transition.updateTarget$animation_core_release(this.$targetState);
                        this.$transition.setPlayTimeNanos(0L);
                        this.this$0.setCurrentState$animation_core_release(targetState);
                        this.this$0.setTargetState$animation_core_release(this.$targetState);
                    }
                    Mutex compositionContinuationMutex = this.this$0.getCompositionContinuationMutex();
                    SeekableTransitionState seekableTransitionState2 = this.this$0;
                    this.L$0 = compositionContinuationMutex;
                    this.L$1 = seekableTransitionState2;
                    this.label = 1;
                    if (compositionContinuationMutex.lock(null, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutex = compositionContinuationMutex;
                    seekableTransitionState = seekableTransitionState2;
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj);
                            SeekableTransitionState<S> seekableTransitionState3 = this.this$0;
                            this.label = 3;
                            waitForCompositionAfterTargetStateChange = seekableTransitionState3.waitForCompositionAfterTargetStateChange(this);
                            if (waitForCompositionAfterTargetStateChange == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            if (!Intrinsics.areEqual(this.this$0.getCurrentState(), this.$targetState)) {
                            }
                            return Unit.INSTANCE;
                        }
                        if (i5 != 3) {
                            if (i5 != 4) {
                                if (i5 != 5) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                                this.this$0.setFraction(0.0f);
                                return Unit.INSTANCE;
                            }
                            ResultKt.throwOnFailure(obj);
                            this.this$0.setCurrentState$animation_core_release(this.$targetState);
                            SeekableTransitionState<S> seekableTransitionState4 = this.this$0;
                            this.label = 5;
                            waitForComposition = seekableTransitionState4.waitForComposition(this);
                            if (waitForComposition == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            this.this$0.setFraction(0.0f);
                            return Unit.INSTANCE;
                        }
                        ResultKt.throwOnFailure(obj);
                        if (!Intrinsics.areEqual(this.this$0.getCurrentState(), this.$targetState)) {
                            if (this.this$0.getFraction() < 1.0f) {
                                seekingAnimationState = ((SeekableTransitionState) this.this$0).currentAnimation;
                                FiniteAnimationSpec<Float> finiteAnimationSpec = this.$animationSpec;
                                VectorizedAnimationSpec<AnimationVector1D> vectorize = finiteAnimationSpec != null ? finiteAnimationSpec.vectorize((TwoWayConverter<Float, V>) VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE)) : null;
                                if (seekingAnimationState == null || !Intrinsics.areEqual(vectorize, seekingAnimationState.getAnimationSpec())) {
                                    VectorizedAnimationSpec<AnimationVector1D> animationSpec = seekingAnimationState != null ? seekingAnimationState.getAnimationSpec() : null;
                                    if (animationSpec != null) {
                                        long progressNanos = seekingAnimationState.getProgressNanos();
                                        AnimationVector1D start = seekingAnimationState.getStart();
                                        companion4 = SeekableTransitionState.Companion;
                                        AnimationVector1D target1 = companion4.getTarget1();
                                        AnimationVector1D initialVelocity = seekingAnimationState.getInitialVelocity();
                                        if (initialVelocity == null) {
                                            companion5 = SeekableTransitionState.Companion;
                                            initialVelocity = companion5.getZeroVelocity();
                                        }
                                        zeroVelocity = animationSpec.getVelocityFromNanos(progressNanos, start, target1, initialVelocity);
                                    } else if (seekingAnimationState == null || seekingAnimationState.getProgressNanos() == 0) {
                                        companion = SeekableTransitionState.Companion;
                                        zeroVelocity = companion.getZeroVelocity();
                                    } else {
                                        long durationNanos = seekingAnimationState.getDurationNanos();
                                        if (durationNanos == Long.MIN_VALUE) {
                                            durationNanos = this.this$0.getTotalDurationNanos();
                                        }
                                        float f5 = ((float) durationNanos) / 1.0E9f;
                                        if (f5 <= 0.0f) {
                                            companion2 = SeekableTransitionState.Companion;
                                            zeroVelocity = companion2.getZeroVelocity();
                                        } else {
                                            zeroVelocity = new AnimationVector1D(1.0f / f5);
                                        }
                                    }
                                    if (seekingAnimationState == null) {
                                        seekingAnimationState = new SeekableTransitionState.SeekingAnimationState();
                                    }
                                    seekingAnimationState.setAnimationSpec(vectorize);
                                    seekingAnimationState.setComplete(false);
                                    seekingAnimationState.setValue(this.this$0.getFraction());
                                    seekingAnimationState.getStart().set$animation_core_release(0, this.this$0.getFraction());
                                    seekingAnimationState.setDurationNanos(this.this$0.getTotalDurationNanos());
                                    seekingAnimationState.setProgressNanos(0L);
                                    seekingAnimationState.setInitialVelocity(zeroVelocity);
                                    if (vectorize != null) {
                                        AnimationVector1D start2 = seekingAnimationState.getStart();
                                        companion3 = SeekableTransitionState.Companion;
                                        roundToLong = vectorize.getDurationNanos(start2, companion3.getTarget1(), zeroVelocity);
                                    } else {
                                        roundToLong = MathKt.roundToLong(this.this$0.getTotalDurationNanos() * (1.0d - this.this$0.getFraction()));
                                    }
                                    seekingAnimationState.setAnimationSpecDuration(roundToLong);
                                    ((SeekableTransitionState) this.this$0).currentAnimation = seekingAnimationState;
                                }
                            }
                            SeekableTransitionState<S> seekableTransitionState5 = this.this$0;
                            this.L$0 = null;
                            this.L$1 = null;
                            this.label = 4;
                            runAnimations = seekableTransitionState5.runAnimations(this);
                            if (runAnimations == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            this.this$0.setCurrentState$animation_core_release(this.$targetState);
                            SeekableTransitionState<S> seekableTransitionState42 = this.this$0;
                            this.label = 5;
                            waitForComposition = seekableTransitionState42.waitForComposition(this);
                            if (waitForComposition == coroutine_suspended) {
                            }
                            this.this$0.setFraction(0.0f);
                        }
                        return Unit.INSTANCE;
                    }
                    seekableTransitionState = (SeekableTransitionState) this.L$1;
                    mutex = (Mutex) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Object composedTargetState$animation_core_release = seekableTransitionState.getComposedTargetState$animation_core_release();
                mutex.unlock(null);
                if (!Intrinsics.areEqual(this.$targetState, composedTargetState$animation_core_release)) {
                    SeekableTransitionState<S> seekableTransitionState6 = this.this$0;
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 2;
                    doOneFrame = seekableTransitionState6.doOneFrame(this);
                    if (doOneFrame == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    SeekableTransitionState<S> seekableTransitionState32 = this.this$0;
                    this.label = 3;
                    waitForCompositionAfterTargetStateChange = seekableTransitionState32.waitForCompositionAfterTargetStateChange(this);
                    if (waitForCompositionAfterTargetStateChange == coroutine_suspended) {
                    }
                }
                if (!Intrinsics.areEqual(this.this$0.getCurrentState(), this.$targetState)) {
                }
                return Unit.INSTANCE;
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SeekableTransitionState$animateTo$2(Transition<S> transition, SeekableTransitionState<S> seekableTransitionState, S s5, FiniteAnimationSpec<Float> finiteAnimationSpec, Continuation<? super SeekableTransitionState$animateTo$2> continuation) {
        super(1, continuation);
        this.$transition = transition;
        this.this$0 = seekableTransitionState;
        this.$targetState = s5;
        this.$animationSpec = finiteAnimationSpec;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new SeekableTransitionState$animateTo$2(this.$transition, this.this$0, this.$targetState, this.$animationSpec, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$targetState, this.$transition, this.$animationSpec, null);
            this.label = 1;
            if (CoroutineScopeKt.coroutineScope(anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
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
        return ((SeekableTransitionState$animateTo$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
