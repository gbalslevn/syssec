package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004BG\b\u0000\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00018\u0001¢\u0006\u0004\b\f\u0010\rBG\b\u0016\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00018\u0001¢\u0006\u0004\b\f\u0010\u000fJ\u0017\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR*\u0010 \u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00028\u00008\u0000@@X\u0080\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R*\u0010&\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00028\u00008\u0000@@X\u0080\u000e¢\u0006\u0012\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u0016\u0010)\u001a\u00028\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00028\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010*R\u0014\u0010\u000b\u001a\u00028\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010*R\u0016\u0010,\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010.\u001a\u0004\u0018\u00018\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010*R\u0014\u00101\u001a\u00028\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0011\u0010\t\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b2\u0010#R\u0014\u0010\n\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u0010#R\u0014\u00105\u001a\u0002048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0014\u00109\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00108¨\u0006:"}, d2 = {"Landroidx/compose/animation/core/TargetBasedAnimation;", "T", "Landroidx/compose/animation/core/AnimationVector;", "V", "Landroidx/compose/animation/core/Animation;", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "animationSpec", "Landroidx/compose/animation/core/TwoWayConverter;", "typeConverter", "initialValue", "targetValue", "initialVelocityVector", "<init>", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", BuildConfig.FLAVOR, "playTimeNanos", "getValueFromNanos", "(J)Ljava/lang/Object;", "getVelocityVectorFromNanos", "(J)Landroidx/compose/animation/core/AnimationVector;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "getAnimationSpec$animation_core_release", "()Landroidx/compose/animation/core/VectorizedAnimationSpec;", "Landroidx/compose/animation/core/TwoWayConverter;", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "value", "mutableTargetValue", "Ljava/lang/Object;", "getMutableTargetValue$animation_core_release", "()Ljava/lang/Object;", "setMutableTargetValue$animation_core_release", "(Ljava/lang/Object;)V", "mutableInitialValue", "getMutableInitialValue$animation_core_release", "setMutableInitialValue$animation_core_release", "initialValueVector", "Landroidx/compose/animation/core/AnimationVector;", "targetValueVector", "_durationNanos", "J", "_endVelocity", "getEndVelocity", "()Landroidx/compose/animation/core/AnimationVector;", "endVelocity", "getInitialValue", "getTargetValue", BuildConfig.FLAVOR, "isInfinite", "()Z", "getDurationNanos", "()J", "durationNanos", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TargetBasedAnimation<T, V extends AnimationVector> implements Animation<T, V> {
    private long _durationNanos;
    private V _endVelocity;
    private final VectorizedAnimationSpec<V> animationSpec;
    private V initialValueVector;
    private final V initialVelocityVector;
    private T mutableInitialValue;
    private T mutableTargetValue;
    private V targetValueVector;
    private final TwoWayConverter<T, V> typeConverter;

    public TargetBasedAnimation(VectorizedAnimationSpec<V> vectorizedAnimationSpec, TwoWayConverter<T, V> twoWayConverter, T t5, T t6, V v5) {
        V v6;
        this.animationSpec = vectorizedAnimationSpec;
        this.typeConverter = twoWayConverter;
        this.mutableTargetValue = t6;
        this.mutableInitialValue = t5;
        this.initialValueVector = getTypeConverter().getConvertToVector().invoke(t5);
        this.targetValueVector = getTypeConverter().getConvertToVector().invoke(t6);
        this.initialVelocityVector = (v5 == null || (v6 = (V) AnimationVectorsKt.copy(v5)) == null) ? (V) AnimationVectorsKt.newInstance(getTypeConverter().getConvertToVector().invoke(t5)) : v6;
        this._durationNanos = -1L;
    }

    private final V getEndVelocity() {
        V v5 = this._endVelocity;
        if (v5 != null) {
            return v5;
        }
        V endVelocity = this.animationSpec.getEndVelocity(this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
        this._endVelocity = endVelocity;
        return endVelocity;
    }

    @Override // androidx.compose.animation.core.Animation
    public long getDurationNanos() {
        if (this._durationNanos < 0) {
            this._durationNanos = this.animationSpec.getDurationNanos(this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
        }
        return this._durationNanos;
    }

    public final T getInitialValue() {
        return this.mutableInitialValue;
    }

    @Override // androidx.compose.animation.core.Animation
    public T getTargetValue() {
        return this.mutableTargetValue;
    }

    @Override // androidx.compose.animation.core.Animation
    public TwoWayConverter<T, V> getTypeConverter() {
        return this.typeConverter;
    }

    @Override // androidx.compose.animation.core.Animation
    public T getValueFromNanos(long playTimeNanos) {
        if (isFinishedFromNanos(playTimeNanos)) {
            return getTargetValue();
        }
        V valueFromNanos = this.animationSpec.getValueFromNanos(playTimeNanos, this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
        int size = valueFromNanos.getSize();
        for (int i5 = 0; i5 < size; i5++) {
            if (Float.isNaN(valueFromNanos.get$animation_core_release(i5))) {
                PreconditionsKt.throwIllegalStateException("AnimationVector cannot contain a NaN. " + valueFromNanos + ". Animation: " + this + ", playTimeNanos: " + playTimeNanos);
            }
        }
        return getTypeConverter().getConvertFromVector().invoke(valueFromNanos);
    }

    @Override // androidx.compose.animation.core.Animation
    public V getVelocityVectorFromNanos(long playTimeNanos) {
        return !isFinishedFromNanos(playTimeNanos) ? this.animationSpec.getVelocityFromNanos(playTimeNanos, this.initialValueVector, this.targetValueVector, this.initialVelocityVector) : getEndVelocity();
    }

    @Override // androidx.compose.animation.core.Animation
    public boolean isInfinite() {
        return this.animationSpec.isInfinite();
    }

    public final void setMutableInitialValue$animation_core_release(T t5) {
        if (Intrinsics.areEqual(t5, this.mutableInitialValue)) {
            return;
        }
        this.mutableInitialValue = t5;
        this.initialValueVector = getTypeConverter().getConvertToVector().invoke(t5);
        this._endVelocity = null;
        this._durationNanos = -1L;
    }

    public final void setMutableTargetValue$animation_core_release(T t5) {
        if (Intrinsics.areEqual(this.mutableTargetValue, t5)) {
            return;
        }
        this.mutableTargetValue = t5;
        this.targetValueVector = getTypeConverter().getConvertToVector().invoke(t5);
        this._endVelocity = null;
        this._durationNanos = -1L;
    }

    public String toString() {
        return "TargetBasedAnimation: " + getInitialValue() + " -> " + getTargetValue() + ",initial velocity: " + this.initialVelocityVector + ", duration: " + AnimationKt.getDurationMillis(this) + " ms,animationSpec: " + this.animationSpec;
    }

    public /* synthetic */ TargetBasedAnimation(AnimationSpec animationSpec, TwoWayConverter twoWayConverter, Object obj, Object obj2, AnimationVector animationVector, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((AnimationSpec<Object>) animationSpec, (TwoWayConverter<Object, AnimationVector>) twoWayConverter, obj, obj2, (i5 & 16) != 0 ? null : animationVector);
    }

    public TargetBasedAnimation(AnimationSpec<T> animationSpec, TwoWayConverter<T, V> twoWayConverter, T t5, T t6, V v5) {
        this(animationSpec.vectorize(twoWayConverter), twoWayConverter, t5, t6, v5);
    }
}
