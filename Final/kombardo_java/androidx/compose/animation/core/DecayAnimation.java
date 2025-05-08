package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004B9\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00028\u0001¢\u0006\u0004\b\u000b\u0010\fB;\b\u0016\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00028\u0001¢\u0006\u0004\b\u000b\u0010\u000eJ\u0017\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0015R&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\t\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00028\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0017\u0010\n\u001a\u00028\u00018\u0006¢\u0006\f\n\u0004\b\n\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00028\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001dR\u001a\u0010!\u001a\u00028\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001bR\u001a\u0010#\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010(\u001a\u00020'8\u0016X\u0096D¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b(\u0010*¨\u0006+"}, d2 = {"Landroidx/compose/animation/core/DecayAnimation;", "T", "Landroidx/compose/animation/core/AnimationVector;", "V", "Landroidx/compose/animation/core/Animation;", "Landroidx/compose/animation/core/VectorizedDecayAnimationSpec;", "animationSpec", "Landroidx/compose/animation/core/TwoWayConverter;", "typeConverter", "initialValue", "initialVelocityVector", "<init>", "(Landroidx/compose/animation/core/VectorizedDecayAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", "Landroidx/compose/animation/core/DecayAnimationSpec;", "(Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", BuildConfig.FLAVOR, "playTimeNanos", "getValueFromNanos", "(J)Ljava/lang/Object;", "getVelocityVectorFromNanos", "(J)Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDecayAnimationSpec;", "Landroidx/compose/animation/core/TwoWayConverter;", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "Ljava/lang/Object;", "getInitialValue", "()Ljava/lang/Object;", "initialValueVector", "Landroidx/compose/animation/core/AnimationVector;", "getInitialVelocityVector", "()Landroidx/compose/animation/core/AnimationVector;", "endVelocity", "targetValue", "getTargetValue", "durationNanos", "J", "getDurationNanos", "()J", BuildConfig.FLAVOR, "isInfinite", "Z", "()Z", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DecayAnimation<T, V extends AnimationVector> implements Animation<T, V> {
    private final VectorizedDecayAnimationSpec<V> animationSpec;
    private final long durationNanos;
    private final V endVelocity;
    private final T initialValue;
    private final V initialValueVector;
    private final V initialVelocityVector;
    private final boolean isInfinite;
    private final T targetValue;
    private final TwoWayConverter<T, V> typeConverter;

    public DecayAnimation(VectorizedDecayAnimationSpec<V> vectorizedDecayAnimationSpec, TwoWayConverter<T, V> twoWayConverter, T t5, V v5) {
        this.animationSpec = vectorizedDecayAnimationSpec;
        this.typeConverter = twoWayConverter;
        this.initialValue = t5;
        V invoke = getTypeConverter().getConvertToVector().invoke(t5);
        this.initialValueVector = invoke;
        this.initialVelocityVector = (V) AnimationVectorsKt.copy(v5);
        this.targetValue = getTypeConverter().getConvertFromVector().invoke(vectorizedDecayAnimationSpec.getTargetValue(invoke, v5));
        this.durationNanos = vectorizedDecayAnimationSpec.getDurationNanos(invoke, v5);
        V v6 = (V) AnimationVectorsKt.copy(vectorizedDecayAnimationSpec.getVelocityFromNanos(getDurationNanos(), invoke, v5));
        this.endVelocity = v6;
        int size = v6.getSize();
        for (int i5 = 0; i5 < size; i5++) {
            V v7 = this.endVelocity;
            v7.set$animation_core_release(i5, RangesKt.coerceIn(v7.get$animation_core_release(i5), -this.animationSpec.getAbsVelocityThreshold(), this.animationSpec.getAbsVelocityThreshold()));
        }
    }

    @Override // androidx.compose.animation.core.Animation
    public long getDurationNanos() {
        return this.durationNanos;
    }

    @Override // androidx.compose.animation.core.Animation
    public T getTargetValue() {
        return this.targetValue;
    }

    @Override // androidx.compose.animation.core.Animation
    public TwoWayConverter<T, V> getTypeConverter() {
        return this.typeConverter;
    }

    @Override // androidx.compose.animation.core.Animation
    public T getValueFromNanos(long playTimeNanos) {
        return !isFinishedFromNanos(playTimeNanos) ? (T) getTypeConverter().getConvertFromVector().invoke(this.animationSpec.getValueFromNanos(playTimeNanos, this.initialValueVector, this.initialVelocityVector)) : getTargetValue();
    }

    @Override // androidx.compose.animation.core.Animation
    public V getVelocityVectorFromNanos(long playTimeNanos) {
        return !isFinishedFromNanos(playTimeNanos) ? this.animationSpec.getVelocityFromNanos(playTimeNanos, this.initialValueVector, this.initialVelocityVector) : this.endVelocity;
    }

    @Override // androidx.compose.animation.core.Animation
    /* renamed from: isInfinite, reason: from getter */
    public boolean getIsInfinite() {
        return this.isInfinite;
    }

    public DecayAnimation(DecayAnimationSpec<T> decayAnimationSpec, TwoWayConverter<T, V> twoWayConverter, T t5, V v5) {
        this(decayAnimationSpec.vectorize(twoWayConverter), twoWayConverter, t5, v5);
    }
}
