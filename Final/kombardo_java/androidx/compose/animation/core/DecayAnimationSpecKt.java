package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0004\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0004\b\u0000\u0010\u0006*\u00020\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/compose/animation/core/DecayAnimationSpec;", BuildConfig.FLAVOR, "initialValue", "initialVelocity", "calculateTargetValue", "(Landroidx/compose/animation/core/DecayAnimationSpec;FF)F", "T", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "generateDecayAnimationSpec", "(Landroidx/compose/animation/core/FloatDecayAnimationSpec;)Landroidx/compose/animation/core/DecayAnimationSpec;", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class DecayAnimationSpecKt {
    public static final float calculateTargetValue(DecayAnimationSpec<Float> decayAnimationSpec, float f5, float f6) {
        return ((AnimationVector1D) decayAnimationSpec.vectorize(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE)).getTargetValue(AnimationVectorsKt.AnimationVector(f5), AnimationVectorsKt.AnimationVector(f6))).getValue();
    }

    public static final <T> DecayAnimationSpec<T> generateDecayAnimationSpec(FloatDecayAnimationSpec floatDecayAnimationSpec) {
        return new DecayAnimationSpecImpl(floatDecayAnimationSpec);
    }
}
