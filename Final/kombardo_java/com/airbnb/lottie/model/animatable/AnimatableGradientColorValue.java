package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.GradientColorKeyframeAnimation;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.value.Keyframe;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class AnimatableGradientColorValue extends BaseAnimatableValue<GradientColor, GradientColor> {
    public AnimatableGradientColorValue(List<Keyframe<GradientColor>> list) {
        super(ensureInterpolatableKeyframes(list));
    }

    private static Keyframe<GradientColor> ensureInterpolatableKeyframe(Keyframe<GradientColor> keyframe) {
        GradientColor gradientColor = keyframe.startValue;
        GradientColor gradientColor2 = keyframe.endValue;
        if (gradientColor == null || gradientColor2 == null || gradientColor.getPositions().length == gradientColor2.getPositions().length) {
            return keyframe;
        }
        float[] mergePositions = mergePositions(gradientColor.getPositions(), gradientColor2.getPositions());
        return keyframe.copyWith(gradientColor.copyWithPositions(mergePositions), gradientColor2.copyWithPositions(mergePositions));
    }

    private static List<Keyframe<GradientColor>> ensureInterpolatableKeyframes(List<Keyframe<GradientColor>> list) {
        for (int i5 = 0; i5 < list.size(); i5++) {
            list.set(i5, ensureInterpolatableKeyframe(list.get(i5)));
        }
        return list;
    }

    static float[] mergePositions(float[] fArr, float[] fArr2) {
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        Arrays.sort(fArr3);
        float f5 = Float.NaN;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            float f6 = fArr3[i6];
            if (f6 != f5) {
                fArr3[i5] = f6;
                i5++;
                f5 = fArr3[i6];
            }
        }
        return Arrays.copyOfRange(fArr3, 0, i5);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<GradientColor, GradientColor> createAnimation() {
        return new GradientColorKeyframeAnimation(this.keyframes);
    }

    @Override // com.airbnb.lottie.model.animatable.BaseAnimatableValue, com.airbnb.lottie.model.animatable.AnimatableValue
    public /* bridge */ /* synthetic */ List getKeyframes() {
        return super.getKeyframes();
    }

    @Override // com.airbnb.lottie.model.animatable.BaseAnimatableValue, com.airbnb.lottie.model.animatable.AnimatableValue
    public /* bridge */ /* synthetic */ boolean isStatic() {
        return super.isStatic();
    }

    @Override // com.airbnb.lottie.model.animatable.BaseAnimatableValue
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
