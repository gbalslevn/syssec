package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u001am\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00028\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\f\u001a[\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u0003*\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0002\u0010\u0004\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\u0010\u001aI\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014\u001ak\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00152\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0017\u001a5\u0010\u0018\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00152\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"T", "Landroidx/compose/animation/core/AnimationVector;", "V", "Landroidx/compose/animation/core/AnimationState;", "value", "velocityVector", BuildConfig.FLAVOR, "lastFrameTimeNanos", "finishedTimeNanos", BuildConfig.FLAVOR, "isRunning", "copy", "(Landroidx/compose/animation/core/AnimationState;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;JJZ)Landroidx/compose/animation/core/AnimationState;", BuildConfig.FLAVOR, "Landroidx/compose/animation/core/AnimationVector1D;", "velocity", "(Landroidx/compose/animation/core/AnimationState;FFJJZ)Landroidx/compose/animation/core/AnimationState;", "initialValue", "initialVelocity", "AnimationState", "(FFJJZ)Landroidx/compose/animation/core/AnimationState;", "Landroidx/compose/animation/core/TwoWayConverter;", "typeConverter", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;JJZ)Landroidx/compose/animation/core/AnimationState;", "createZeroVectorFrom", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;)Landroidx/compose/animation/core/AnimationVector;", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AnimationStateKt {
    public static final AnimationState<Float, AnimationVector1D> AnimationState(float f5, float f6, long j5, long j6, boolean z5) {
        return new AnimationState<>(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Float.valueOf(f5), AnimationVectorsKt.AnimationVector(f6), j5, j6, z5);
    }

    public static /* synthetic */ AnimationState AnimationState$default(float f5, float f6, long j5, long j6, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            f6 = 0.0f;
        }
        long j7 = (i5 & 4) != 0 ? Long.MIN_VALUE : j5;
        long j8 = (i5 & 8) == 0 ? j6 : Long.MIN_VALUE;
        if ((i5 & 16) != 0) {
            z5 = false;
        }
        return AnimationState(f5, f6, j7, j8, z5);
    }

    public static final <T, V extends AnimationVector> AnimationState<T, V> copy(AnimationState<T, V> animationState, T t5, V v5, long j5, long j6, boolean z5) {
        return new AnimationState<>(animationState.getTypeConverter(), t5, v5, j5, j6, z5);
    }

    public static /* synthetic */ AnimationState copy$default(AnimationState animationState, Object obj, AnimationVector animationVector, long j5, long j6, boolean z5, int i5, Object obj2) {
        if ((i5 & 1) != 0) {
            obj = animationState.getValue();
        }
        if ((i5 & 2) != 0) {
            animationVector = AnimationVectorsKt.copy(animationState.getVelocityVector());
        }
        AnimationVector animationVector2 = animationVector;
        if ((i5 & 4) != 0) {
            j5 = animationState.getLastFrameTimeNanos();
        }
        long j7 = j5;
        if ((i5 & 8) != 0) {
            j6 = animationState.getFinishedTimeNanos();
        }
        long j8 = j6;
        if ((i5 & 16) != 0) {
            z5 = animationState.getIsRunning();
        }
        return copy((AnimationState<Object, AnimationVector>) animationState, obj, animationVector2, j7, j8, z5);
    }

    public static final <T, V extends AnimationVector> V createZeroVectorFrom(TwoWayConverter<T, V> twoWayConverter, T t5) {
        V invoke = twoWayConverter.getConvertToVector().invoke(t5);
        invoke.reset$animation_core_release();
        return invoke;
    }

    public static final AnimationState<Float, AnimationVector1D> copy(AnimationState<Float, AnimationVector1D> animationState, float f5, float f6, long j5, long j6, boolean z5) {
        return new AnimationState<>(animationState.getTypeConverter(), Float.valueOf(f5), AnimationVectorsKt.AnimationVector(f6), j5, j6, z5);
    }

    public static final <T, V extends AnimationVector> AnimationState<T, V> AnimationState(TwoWayConverter<T, V> twoWayConverter, T t5, T t6, long j5, long j6, boolean z5) {
        return new AnimationState<>(twoWayConverter, t5, twoWayConverter.getConvertToVector().invoke(t6), j5, j6, z5);
    }

    public static /* synthetic */ AnimationState copy$default(AnimationState animationState, float f5, float f6, long j5, long j6, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = ((Number) animationState.getValue()).floatValue();
        }
        if ((i5 & 2) != 0) {
            f6 = ((AnimationVector1D) animationState.getVelocityVector()).getValue();
        }
        float f7 = f6;
        if ((i5 & 4) != 0) {
            j5 = animationState.getLastFrameTimeNanos();
        }
        long j7 = j5;
        if ((i5 & 8) != 0) {
            j6 = animationState.getFinishedTimeNanos();
        }
        long j8 = j6;
        if ((i5 & 16) != 0) {
            z5 = animationState.getIsRunning();
        }
        return copy((AnimationState<Float, AnimationVector1D>) animationState, f5, f7, j7, j8, z5);
    }
}
