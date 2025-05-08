package androidx.compose.animation.core;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u001ac\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0004\b\u000b\u0010\f\" \u0010\u0011\u001a\u00020\u000e*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"T", "Landroidx/compose/animation/core/AnimationVector;", "V", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpec", "Landroidx/compose/animation/core/TwoWayConverter;", "typeConverter", "initialValue", "targetValue", "initialVelocity", "Landroidx/compose/animation/core/TargetBasedAnimation;", "TargetBasedAnimation", "(Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/animation/core/TargetBasedAnimation;", "Landroidx/compose/animation/core/Animation;", BuildConfig.FLAVOR, "getDurationMillis", "(Landroidx/compose/animation/core/Animation;)J", "durationMillis", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AnimationKt {
    public static final <T, V extends AnimationVector> TargetBasedAnimation<T, V> TargetBasedAnimation(AnimationSpec<T> animationSpec, TwoWayConverter<T, V> twoWayConverter, T t5, T t6, T t7) {
        return new TargetBasedAnimation<>(animationSpec, twoWayConverter, t5, t6, twoWayConverter.getConvertToVector().invoke(t7));
    }

    public static final long getDurationMillis(Animation<?, ?> animation) {
        return animation.getDurationNanos() / 1000000;
    }
}
