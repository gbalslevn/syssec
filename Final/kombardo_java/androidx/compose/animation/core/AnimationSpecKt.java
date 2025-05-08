package androidx.compose.animation.core;

import androidx.compose.animation.core.KeyframesSpec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u001a;\u0010\u0005\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a9\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a;\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00018\u0000H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a5\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a\"\u0004\b\u0000\u0010\u00002\u0018\u0010\u0019\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0017\u0012\u0004\u0012\u00020\u00180\u0016H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a@\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000#\"\u0004\b\u0000\u0010\u00002\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020!H\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a1\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000'\"\u0004\b\u0000\u0010\u00002\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'2\u0006\u0010*\u001a\u00020)H\u0001¢\u0006\u0004\b+\u0010,\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"T", "Landroidx/compose/animation/core/AnimationVector;", "V", "Landroidx/compose/animation/core/TwoWayConverter;", "data", "convert", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;)Landroidx/compose/animation/core/AnimationVector;", BuildConfig.FLAVOR, "durationMillis", "delayMillis", "Landroidx/compose/animation/core/Easing;", "easing", "Landroidx/compose/animation/core/TweenSpec;", "tween", "(IILandroidx/compose/animation/core/Easing;)Landroidx/compose/animation/core/TweenSpec;", BuildConfig.FLAVOR, "dampingRatio", "stiffness", "visibilityThreshold", "Landroidx/compose/animation/core/SpringSpec;", "spring", "(FFLjava/lang/Object;)Landroidx/compose/animation/core/SpringSpec;", "Lkotlin/Function1;", "Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", BuildConfig.FLAVOR, "init", "Landroidx/compose/animation/core/KeyframesSpec;", "keyframes", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/animation/core/KeyframesSpec;", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "animation", "Landroidx/compose/animation/core/RepeatMode;", "repeatMode", "Landroidx/compose/animation/core/StartOffset;", "initialStartOffset", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "infiniteRepeatable-9IiC70o", "(Landroidx/compose/animation/core/DurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;J)Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "infiniteRepeatable", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpec", BuildConfig.FLAVOR, "startDelayNanos", "delayed", "(Landroidx/compose/animation/core/AnimationSpec;J)Landroidx/compose/animation/core/AnimationSpec;", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AnimationSpecKt {
    public static final <T, V extends AnimationVector> V convert(TwoWayConverter<T, V> twoWayConverter, T t5) {
        if (t5 == null) {
            return null;
        }
        return twoWayConverter.getConvertToVector().invoke(t5);
    }

    public static final <T> AnimationSpec<T> delayed(AnimationSpec<T> animationSpec, long j5) {
        return new StartDelayAnimationSpec(animationSpec, j5);
    }

    /* renamed from: infiniteRepeatable-9IiC70o */
    public static final <T> InfiniteRepeatableSpec<T> m57infiniteRepeatable9IiC70o(DurationBasedAnimationSpec<T> durationBasedAnimationSpec, RepeatMode repeatMode, long j5) {
        return new InfiniteRepeatableSpec<>(durationBasedAnimationSpec, repeatMode, j5, null);
    }

    /* renamed from: infiniteRepeatable-9IiC70o$default */
    public static /* synthetic */ InfiniteRepeatableSpec m58infiniteRepeatable9IiC70o$default(DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, long j5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            repeatMode = RepeatMode.Restart;
        }
        if ((i5 & 4) != 0) {
            j5 = StartOffset.m71constructorimpl$default(0, 0, 2, null);
        }
        return m57infiniteRepeatable9IiC70o(durationBasedAnimationSpec, repeatMode, j5);
    }

    public static final <T> KeyframesSpec<T> keyframes(Function1<? super KeyframesSpec.KeyframesSpecConfig<T>, Unit> function1) {
        KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig = new KeyframesSpec.KeyframesSpecConfig();
        function1.invoke(keyframesSpecConfig);
        return new KeyframesSpec<>(keyframesSpecConfig);
    }

    public static final <T> SpringSpec<T> spring(float f5, float f6, T t5) {
        return new SpringSpec<>(f5, f6, t5);
    }

    public static /* synthetic */ SpringSpec spring$default(float f5, float f6, Object obj, int i5, Object obj2) {
        if ((i5 & 1) != 0) {
            f5 = 1.0f;
        }
        if ((i5 & 2) != 0) {
            f6 = 1500.0f;
        }
        if ((i5 & 4) != 0) {
            obj = null;
        }
        return spring(f5, f6, obj);
    }

    public static final <T> TweenSpec<T> tween(int i5, int i6, Easing easing) {
        return new TweenSpec<>(i5, i6, easing);
    }

    public static /* synthetic */ TweenSpec tween$default(int i5, int i6, Easing easing, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i5 = 300;
        }
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        if ((i7 & 4) != 0) {
            easing = EasingKt.getFastOutSlowInEasing();
        }
        return tween(i5, i6, easing);
    }
}
