package androidx.compose.animation.core;

import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.MotionDurationScale;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\\\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aT\u0010\t\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00002\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u00042\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@¢\u0006\u0004\b\t\u0010\n\u001az\u0010\t\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u000b\"\b\b\u0001\u0010\r*\u00020\f2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e2\u0006\u0010\u0001\u001a\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u00002\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@¢\u0006\u0004\b\t\u0010\u0010\u001at\u0010\u0016\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u000b\"\b\b\u0001\u0010\r*\u00020\f*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00112\u0006\u0010\u0002\u001a\u00028\u00002\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00122 \b\u0002\u0010\b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0015\u0012\u0004\u0012\u00020\u00070\u0014H\u0086@¢\u0006\u0004\b\u0016\u0010\u0017\u001aj\u0010\u0019\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u000b\"\b\b\u0001\u0010\r*\u00020\f*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00112\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\b\b\u0002\u0010\u0013\u001a\u00020\u00122 \b\u0002\u0010\b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0015\u0012\u0004\u0012\u00020\u00070\u0014H\u0086@¢\u0006\u0004\b\u0019\u0010\u001a\u001ap\u0010\t\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u000b\"\b\b\u0001\u0010\r*\u00020\f*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00112\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2 \b\u0002\u0010\b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0015\u0012\u0004\u0012\u00020\u00070\u0014H\u0080@¢\u0006\u0004\b\t\u0010\u001f\u001aJ\u0010\"\u001a\u00028\u0000\"\u0004\b\u0000\u0010 \"\u0004\b\u0001\u0010\u000b\"\b\b\u0002\u0010\r*\u00020\f*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u001b2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00028\u00000\u0014H\u0082@¢\u0006\u0004\b\"\u0010#\u001aC\u0010%\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u000b\"\b\b\u0001\u0010\r*\u00020\f*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00152\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011H\u0000¢\u0006\u0004\b%\u0010&\u001a\u0087\u0001\u0010*\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u000b\"\b\b\u0001\u0010\r*\u00020\f*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00152\u0006\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u00002\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001b2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00112\u001e\u0010\b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0015\u0012\u0004\u0012\u00020\u00070\u0014H\u0002¢\u0006\u0004\b*\u0010+\u001a\u0087\u0001\u0010-\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u000b\"\b\b\u0001\u0010\r*\u00020\f*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00152\u0006\u0010'\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u001d2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001b2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00112\u001e\u0010\b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0015\u0012\u0004\u0012\u00020\u00070\u0014H\u0002¢\u0006\u0004\b-\u0010.\"\u0018\u0010(\u001a\u00020\u0000*\u00020/8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00062"}, d2 = {BuildConfig.FLAVOR, "initialValue", "targetValue", "initialVelocity", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpec", "Lkotlin/Function2;", BuildConfig.FLAVOR, "block", "animate", "(FFFLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "Landroidx/compose/animation/core/AnimationVector;", "V", "Landroidx/compose/animation/core/TwoWayConverter;", "typeConverter", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/animation/core/AnimationState;", BuildConfig.FLAVOR, "sequentialAnimation", "Lkotlin/Function1;", "Landroidx/compose/animation/core/AnimationScope;", "animateTo", "(Landroidx/compose/animation/core/AnimationState;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/animation/core/DecayAnimationSpec;", "animateDecay", "(Landroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/DecayAnimationSpec;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/animation/core/Animation;", "animation", BuildConfig.FLAVOR, "startTimeNanos", "(Landroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/Animation;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "R", "onFrame", "callWithFrameNanos", "(Landroidx/compose/animation/core/Animation;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "state", "updateState", "(Landroidx/compose/animation/core/AnimationScope;Landroidx/compose/animation/core/AnimationState;)V", "frameTimeNanos", "durationScale", "anim", "doAnimationFrameWithScale", "(Landroidx/compose/animation/core/AnimationScope;JFLandroidx/compose/animation/core/Animation;Landroidx/compose/animation/core/AnimationState;Lkotlin/jvm/functions/Function1;)V", "playTimeNanos", "doAnimationFrame", "(Landroidx/compose/animation/core/AnimationScope;JJLandroidx/compose/animation/core/Animation;Landroidx/compose/animation/core/AnimationState;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/coroutines/CoroutineContext;", "getDurationScale", "(Lkotlin/coroutines/CoroutineContext;)F", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SuspendAnimationKt {
    public static final Object animate(float f5, float f6, float f7, AnimationSpec<Float> animationSpec, Function2<? super Float, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object animate = animate(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Boxing.boxFloat(f5), Boxing.boxFloat(f6), Boxing.boxFloat(f7), animationSpec, function2, continuation);
        return animate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animate$default(float f5, float f6, float f7, AnimationSpec animationSpec, Function2 function2, Continuation continuation, int i5, Object obj) {
        float f8 = (i5 & 4) != 0 ? 0.0f : f7;
        if ((i5 & 8) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        return animate(f5, f6, f8, animationSpec, function2, continuation);
    }

    public static final <T, V extends AnimationVector> Object animateDecay(AnimationState<T, V> animationState, DecayAnimationSpec<T> decayAnimationSpec, boolean z5, Function1<? super AnimationScope<T, V>, Unit> function1, Continuation<? super Unit> continuation) {
        Object animate = animate(animationState, new DecayAnimation(decayAnimationSpec, animationState.getTypeConverter(), animationState.getValue(), animationState.getVelocityVector()), z5 ? animationState.getLastFrameTimeNanos() : Long.MIN_VALUE, function1, continuation);
        return animate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateDecay$default(AnimationState animationState, DecayAnimationSpec decayAnimationSpec, boolean z5, Function1 function1, Continuation continuation, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        if ((i5 & 4) != 0) {
            function1 = new Function1() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animateDecay$4
                public final void invoke(AnimationScope animationScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((AnimationScope) obj2);
                    return Unit.INSTANCE;
                }
            };
        }
        return animateDecay(animationState, decayAnimationSpec, z5, function1, continuation);
    }

    public static final <T, V extends AnimationVector> Object animateTo(AnimationState<T, V> animationState, T t5, AnimationSpec<T> animationSpec, boolean z5, Function1<? super AnimationScope<T, V>, Unit> function1, Continuation<? super Unit> continuation) {
        Object animate = animate(animationState, new TargetBasedAnimation(animationSpec, animationState.getTypeConverter(), animationState.getValue(), t5, animationState.getVelocityVector()), z5 ? animationState.getLastFrameTimeNanos() : Long.MIN_VALUE, function1, continuation);
        return animate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateTo$default(AnimationState animationState, Object obj, AnimationSpec animationSpec, boolean z5, Function1 function1, Continuation continuation, int i5, Object obj2) {
        if ((i5 & 2) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i5 & 4) != 0) {
            z5 = false;
        }
        boolean z6 = z5;
        if ((i5 & 8) != 0) {
            function1 = new Function1() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animateTo$2
                public final void invoke(AnimationScope animationScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                    invoke((AnimationScope) obj3);
                    return Unit.INSTANCE;
                }
            };
        }
        return animateTo(animationState, obj, animationSpec2, z6, function1, continuation);
    }

    private static final <R, T, V extends AnimationVector> Object callWithFrameNanos(Animation<T, V> animation, final Function1<? super Long, ? extends R> function1, Continuation<? super R> continuation) {
        return animation.getIsInfinite() ? InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(function1, continuation) : MonotonicFrameClockKt.withFrameNanos(new Function1<Long, R>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$callWithFrameNanos$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Long l5) {
                return invoke(l5.longValue());
            }

            public final R invoke(long j5) {
                return function1.invoke(Long.valueOf(j5));
            }
        }, continuation);
    }

    private static final <T, V extends AnimationVector> void doAnimationFrame(AnimationScope<T, V> animationScope, long j5, long j6, Animation<T, V> animation, AnimationState<T, V> animationState, Function1<? super AnimationScope<T, V>, Unit> function1) {
        animationScope.setLastFrameTimeNanos$animation_core_release(j5);
        animationScope.setValue$animation_core_release(animation.getValueFromNanos(j6));
        animationScope.setVelocityVector$animation_core_release(animation.getVelocityVectorFromNanos(j6));
        if (animation.isFinishedFromNanos(j6)) {
            animationScope.setFinishedTimeNanos$animation_core_release(animationScope.getLastFrameTimeNanos());
            animationScope.setRunning$animation_core_release(false);
        }
        updateState(animationScope, animationState);
        function1.invoke(animationScope);
    }

    public static final <T, V extends AnimationVector> void doAnimationFrameWithScale(AnimationScope<T, V> animationScope, long j5, float f5, Animation<T, V> animation, AnimationState<T, V> animationState, Function1<? super AnimationScope<T, V>, Unit> function1) {
        doAnimationFrame(animationScope, j5, f5 == 0.0f ? animation.getDurationNanos() : ((float) (j5 - animationScope.getStartTimeNanos())) / f5, animation, animationState, function1);
    }

    public static final float getDurationScale(CoroutineContext coroutineContext) {
        MotionDurationScale motionDurationScale = (MotionDurationScale) coroutineContext.get(MotionDurationScale.INSTANCE);
        float scaleFactor = motionDurationScale != null ? motionDurationScale.getScaleFactor() : 1.0f;
        if (!(scaleFactor >= 0.0f)) {
            PreconditionsKt.throwIllegalStateException("negative scale factor");
        }
        return scaleFactor;
    }

    public static final <T, V extends AnimationVector> void updateState(AnimationScope<T, V> animationScope, AnimationState<T, V> animationState) {
        animationState.setValue$animation_core_release(animationScope.getValue());
        AnimationVectorsKt.copyFrom(animationState.getVelocityVector(), animationScope.getVelocityVector());
        animationState.setFinishedTimeNanos$animation_core_release(animationScope.getFinishedTimeNanos());
        animationState.setLastFrameTimeNanos$animation_core_release(animationScope.getLastFrameTimeNanos());
        animationState.setRunning$animation_core_release(animationScope.isRunning());
    }

    public static /* synthetic */ Object animate$default(AnimationState animationState, Animation animation, long j5, Function1 function1, Continuation continuation, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            j5 = Long.MIN_VALUE;
        }
        long j6 = j5;
        if ((i5 & 4) != 0) {
            function1 = new Function1() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animate$5
                public final void invoke(AnimationScope animationScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((AnimationScope) obj2);
                    return Unit.INSTANCE;
                }
            };
        }
        return animate(animationState, animation, j6, function1, continuation);
    }

    public static final <T, V extends AnimationVector> Object animate(final TwoWayConverter<T, V> twoWayConverter, T t5, T t6, T t7, AnimationSpec<T> animationSpec, final Function2<? super T, ? super T, Unit> function2, Continuation<? super Unit> continuation) {
        V newInstance;
        if (t7 == null || (newInstance = twoWayConverter.getConvertToVector().invoke(t7)) == null) {
            newInstance = AnimationVectorsKt.newInstance(twoWayConverter.getConvertToVector().invoke(t5));
        }
        Object animate$default = animate$default(new AnimationState(twoWayConverter, t5, newInstance, 0L, 0L, false, 56, null), new TargetBasedAnimation(animationSpec, twoWayConverter, t5, t6, newInstance), 0L, new Function1<AnimationScope<T, V>, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animate$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke((AnimationScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(AnimationScope<T, V> animationScope) {
                function2.invoke(animationScope.getValue(), twoWayConverter.getConvertFromVector().invoke(animationScope.getVelocityVector()));
            }
        }, continuation, 2, null);
        return animate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate$default : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00f3 A[Catch: CancellationException -> 0x0045, TRY_LEAVE, TryCatch #2 {CancellationException -> 0x0045, blocks: (B:13:0x0041, B:16:0x00e6, B:18:0x00f3), top: B:12:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x011d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /* JADX WARN: Type inference failed for: r13v1, types: [T, androidx.compose.animation.core.AnimationScope] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, V extends AnimationVector> Object animate(final AnimationState<T, V> animationState, final Animation<T, V> animation, long j5, final Function1<? super AnimationScope<T, V>, Unit> function1, Continuation<? super Unit> continuation) {
        SuspendAnimationKt$animate$4 suspendAnimationKt$animate$4;
        SuspendAnimationKt$animate$4 suspendAnimationKt$animate$42;
        Object coroutine_suspended;
        int i5;
        Ref$ObjectRef ref$ObjectRef;
        Function1<? super AnimationScope<T, V>, Unit> function12;
        AnimationState<T, V> animationState2;
        AnimationScope animationScope;
        AnimationScope animationScope2;
        T t5;
        Function1<Long, Unit> function13;
        Function1<? super AnimationScope<T, V>, Unit> function14;
        Animation<T, V> animation2;
        final AnimationState<T, V> animationState3 = animationState;
        Animation<T, V> animation3 = animation;
        if (continuation instanceof SuspendAnimationKt$animate$4) {
            suspendAnimationKt$animate$4 = (SuspendAnimationKt$animate$4) continuation;
            int i6 = suspendAnimationKt$animate$4.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                suspendAnimationKt$animate$4.label = i6 - Integer.MIN_VALUE;
                suspendAnimationKt$animate$42 = suspendAnimationKt$animate$4;
                Object obj = suspendAnimationKt$animate$42.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = suspendAnimationKt$animate$42.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    final T valueFromNanos = animation3.getValueFromNanos(0L);
                    final V velocityVectorFromNanos = animation3.getVelocityVectorFromNanos(0L);
                    final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                    try {
                        if (j5 == Long.MIN_VALUE) {
                            final float durationScale = getDurationScale(suspendAnimationKt$animate$42.getContext());
                            Function1<Long, Unit> function15 = new Function1<Long, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animate$6
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Incorrect types in method signature: (Lkotlin/jvm/internal/Ref$ObjectRef<Landroidx/compose/animation/core/AnimationScope<TT;TV;>;>;TT;Landroidx/compose/animation/core/Animation<TT;TV;>;TV;Landroidx/compose/animation/core/AnimationState<TT;TV;>;FLkotlin/jvm/functions/Function1<-Landroidx/compose/animation/core/AnimationScope<TT;TV;>;Lkotlin/Unit;>;)V */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Long l5) {
                                    invoke(l5.longValue());
                                    return Unit.INSTANCE;
                                }

                                /* JADX WARN: Type inference failed for: r12v0, types: [T, androidx.compose.animation.core.AnimationScope] */
                                public final void invoke(long j6) {
                                    Ref$ObjectRef<AnimationScope<T, V>> ref$ObjectRef3 = Ref$ObjectRef.this;
                                    T t6 = valueFromNanos;
                                    TwoWayConverter typeConverter = animation.getTypeConverter();
                                    AnimationVector animationVector = velocityVectorFromNanos;
                                    Object targetValue = animation.getTargetValue();
                                    final AnimationState<T, V> animationState4 = animationState;
                                    ?? animationScope3 = new AnimationScope(t6, typeConverter, animationVector, j6, targetValue, j6, true, new Function0<Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animate$6.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2() {
                                            animationState4.setRunning$animation_core_release(false);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public /* bridge */ /* synthetic */ Unit invoke() {
                                            invoke2();
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    SuspendAnimationKt.doAnimationFrameWithScale(animationScope3, j6, durationScale, animation, animationState, function1);
                                    ref$ObjectRef3.element = animationScope3;
                                }
                            };
                            suspendAnimationKt$animate$42.L$0 = animationState3;
                            suspendAnimationKt$animate$42.L$1 = animation3;
                            function12 = function1;
                            suspendAnimationKt$animate$42.L$2 = function12;
                            suspendAnimationKt$animate$42.L$3 = ref$ObjectRef2;
                            suspendAnimationKt$animate$42.label = 1;
                            if (callWithFrameNanos(animation3, function15, suspendAnimationKt$animate$42) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            function12 = function1;
                            try {
                                ?? r13 = (T) new AnimationScope(valueFromNanos, animation.getTypeConverter(), velocityVectorFromNanos, j5, animation.getTargetValue(), j5, true, new Function0<Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animate$7
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        animationState3.setRunning$animation_core_release(false);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }
                                });
                                ref$ObjectRef2 = ref$ObjectRef2;
                                doAnimationFrameWithScale(r13, j5, getDurationScale(suspendAnimationKt$animate$42.getContext()), animation, animationState, function1);
                                ref$ObjectRef2.element = r13;
                            } catch (CancellationException e5) {
                                e = e5;
                                ref$ObjectRef2 = ref$ObjectRef2;
                                ref$ObjectRef = ref$ObjectRef2;
                                animationScope = (AnimationScope) ref$ObjectRef.element;
                                if (animationScope != null) {
                                    animationScope.setRunning$animation_core_release(false);
                                }
                                animationScope2 = (AnimationScope) ref$ObjectRef.element;
                                if (animationScope2 != null && animationScope2.getLastFrameTimeNanos() == animationState3.getLastFrameTimeNanos()) {
                                    animationState3.setRunning$animation_core_release(false);
                                }
                                throw e;
                            }
                        }
                        animationState2 = animationState3;
                        ref$ObjectRef = ref$ObjectRef2;
                    } catch (CancellationException e6) {
                        e = e6;
                    }
                } else {
                    if (i5 == 1) {
                        ref$ObjectRef = (Ref$ObjectRef) suspendAnimationKt$animate$42.L$3;
                        function14 = (Function1) suspendAnimationKt$animate$42.L$2;
                        animation2 = (Animation) suspendAnimationKt$animate$42.L$1;
                        animationState2 = (AnimationState) suspendAnimationKt$animate$42.L$0;
                    } else {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ref$ObjectRef = (Ref$ObjectRef) suspendAnimationKt$animate$42.L$3;
                        function14 = (Function1) suspendAnimationKt$animate$42.L$2;
                        animation2 = (Animation) suspendAnimationKt$animate$42.L$1;
                        animationState2 = (AnimationState) suspendAnimationKt$animate$42.L$0;
                    }
                    try {
                        ResultKt.throwOnFailure(obj);
                        function12 = function14;
                        animation3 = animation2;
                    } catch (CancellationException e7) {
                        e = e7;
                        animationState3 = animationState2;
                        animationScope = (AnimationScope) ref$ObjectRef.element;
                        if (animationScope != null) {
                        }
                        animationScope2 = (AnimationScope) ref$ObjectRef.element;
                        if (animationScope2 != null) {
                            animationState3.setRunning$animation_core_release(false);
                        }
                        throw e;
                    }
                }
                do {
                    t5 = ref$ObjectRef.element;
                    Intrinsics.checkNotNull(t5);
                    if (!((AnimationScope) t5).isRunning()) {
                        final float durationScale2 = getDurationScale(suspendAnimationKt$animate$42.getContext());
                        final Ref$ObjectRef ref$ObjectRef3 = ref$ObjectRef;
                        final Animation<T, V> animation4 = animation3;
                        final AnimationState<T, V> animationState4 = animationState2;
                        final Function1<? super AnimationScope<T, V>, Unit> function16 = function12;
                        function13 = new Function1<Long, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animate$9
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Long l5) {
                                invoke(l5.longValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            public final void invoke(long j6) {
                                T t6 = ref$ObjectRef3.element;
                                Intrinsics.checkNotNull(t6);
                                SuspendAnimationKt.doAnimationFrameWithScale((AnimationScope) t6, j6, durationScale2, animation4, animationState4, function16);
                            }
                        };
                        suspendAnimationKt$animate$42.L$0 = animationState2;
                        suspendAnimationKt$animate$42.L$1 = animation3;
                        suspendAnimationKt$animate$42.L$2 = function12;
                        suspendAnimationKt$animate$42.L$3 = ref$ObjectRef;
                        suspendAnimationKt$animate$42.label = 2;
                    } else {
                        return Unit.INSTANCE;
                    }
                } while (callWithFrameNanos(animation3, function13, suspendAnimationKt$animate$42) != coroutine_suspended);
                return coroutine_suspended;
            }
        }
        suspendAnimationKt$animate$4 = new SuspendAnimationKt$animate$4(continuation);
        suspendAnimationKt$animate$42 = suspendAnimationKt$animate$4;
        Object obj2 = suspendAnimationKt$animate$42.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = suspendAnimationKt$animate$42.label;
        if (i5 != 0) {
        }
        do {
            t5 = ref$ObjectRef.element;
            Intrinsics.checkNotNull(t5);
            if (!((AnimationScope) t5).isRunning()) {
            }
        } while (callWithFrameNanos(animation3, function13, suspendAnimationKt$animate$42) != coroutine_suspended);
        return coroutine_suspended;
    }
}
