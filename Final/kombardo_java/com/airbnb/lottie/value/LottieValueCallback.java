package com.airbnb.lottie.value;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;

/* loaded from: classes.dex */
public abstract class LottieValueCallback<T> {
    private BaseKeyframeAnimation<?, ?> animation;
    private final LottieFrameInfo<T> frameInfo = new LottieFrameInfo<>();
    protected T value = null;

    public abstract T getValue(LottieFrameInfo<T> lottieFrameInfo);

    public final T getValueInternal(float f5, float f6, T t5, T t6, float f7, float f8, float f9) {
        return getValue(this.frameInfo.set(f5, f6, t5, t6, f7, f8, f9));
    }

    public final void setAnimation(BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        this.animation = baseKeyframeAnimation;
    }
}
