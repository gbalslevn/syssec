package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\f\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0010\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0010\u0010\rJ\u001f\u0010\u0011\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00028\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00028\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0019\u001a\u00028\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Landroidx/compose/animation/core/VectorizedFloatDecaySpec;", "Landroidx/compose/animation/core/AnimationVector;", "V", "Landroidx/compose/animation/core/VectorizedDecayAnimationSpec;", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "floatDecaySpec", "<init>", "(Landroidx/compose/animation/core/FloatDecayAnimationSpec;)V", BuildConfig.FLAVOR, "playTimeNanos", "initialValue", "initialVelocity", "getValueFromNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getDurationNanos", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getVelocityFromNanos", "getTargetValue", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "getFloatDecaySpec", "()Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "valueVector", "Landroidx/compose/animation/core/AnimationVector;", "velocityVector", "targetVector", BuildConfig.FLAVOR, "absVelocityThreshold", "F", "getAbsVelocityThreshold", "()F", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class VectorizedFloatDecaySpec<V extends AnimationVector> implements VectorizedDecayAnimationSpec<V> {
    private final float absVelocityThreshold;
    private final FloatDecayAnimationSpec floatDecaySpec;
    private V targetVector;
    private V valueVector;
    private V velocityVector;

    public VectorizedFloatDecaySpec(FloatDecayAnimationSpec floatDecayAnimationSpec) {
        this.floatDecaySpec = floatDecayAnimationSpec;
        this.absVelocityThreshold = floatDecayAnimationSpec.getAbsVelocityThreshold();
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public float getAbsVelocityThreshold() {
        return this.absVelocityThreshold;
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public long getDurationNanos(V initialValue, V initialVelocity) {
        if (this.velocityVector == null) {
            this.velocityVector = (V) AnimationVectorsKt.newInstance(initialValue);
        }
        V v5 = this.velocityVector;
        if (v5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            v5 = null;
        }
        int size = v5.getSize();
        long j5 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            j5 = Math.max(j5, this.floatDecaySpec.getDurationNanos(initialValue.get$animation_core_release(i5), initialVelocity.get$animation_core_release(i5)));
        }
        return j5;
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public V getTargetValue(V initialValue, V initialVelocity) {
        if (this.targetVector == null) {
            this.targetVector = (V) AnimationVectorsKt.newInstance(initialValue);
        }
        V v5 = this.targetVector;
        if (v5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("targetVector");
            v5 = null;
        }
        int size = v5.getSize();
        for (int i5 = 0; i5 < size; i5++) {
            V v6 = this.targetVector;
            if (v6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("targetVector");
                v6 = null;
            }
            v6.set$animation_core_release(i5, this.floatDecaySpec.getTargetValue(initialValue.get$animation_core_release(i5), initialVelocity.get$animation_core_release(i5)));
        }
        V v7 = this.targetVector;
        if (v7 != null) {
            return v7;
        }
        Intrinsics.throwUninitializedPropertyAccessException("targetVector");
        return null;
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public V getValueFromNanos(long playTimeNanos, V initialValue, V initialVelocity) {
        if (this.valueVector == null) {
            this.valueVector = (V) AnimationVectorsKt.newInstance(initialValue);
        }
        V v5 = this.valueVector;
        if (v5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            v5 = null;
        }
        int size = v5.getSize();
        for (int i5 = 0; i5 < size; i5++) {
            V v6 = this.valueVector;
            if (v6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                v6 = null;
            }
            v6.set$animation_core_release(i5, this.floatDecaySpec.getValueFromNanos(playTimeNanos, initialValue.get$animation_core_release(i5), initialVelocity.get$animation_core_release(i5)));
        }
        V v7 = this.valueVector;
        if (v7 != null) {
            return v7;
        }
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        return null;
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public V getVelocityFromNanos(long playTimeNanos, V initialValue, V initialVelocity) {
        if (this.velocityVector == null) {
            this.velocityVector = (V) AnimationVectorsKt.newInstance(initialValue);
        }
        V v5 = this.velocityVector;
        if (v5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            v5 = null;
        }
        int size = v5.getSize();
        for (int i5 = 0; i5 < size; i5++) {
            V v6 = this.velocityVector;
            if (v6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                v6 = null;
            }
            v6.set$animation_core_release(i5, this.floatDecaySpec.getVelocityFromNanos(playTimeNanos, initialValue.get$animation_core_release(i5), initialVelocity.get$animation_core_release(i5)));
        }
        V v7 = this.velocityVector;
        if (v7 != null) {
            return v7;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        return null;
    }
}
