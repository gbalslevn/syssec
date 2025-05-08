package com.airbnb.lottie.value;

/* loaded from: classes.dex */
public class LottieFrameInfo<T> {
    private float endFrame;
    private T endValue;
    private float interpolatedKeyframeProgress;
    private float linearKeyframeProgress;
    private float overallProgress;
    private float startFrame;
    private T startValue;

    public float getEndFrame() {
        return this.endFrame;
    }

    public T getEndValue() {
        return this.endValue;
    }

    public float getInterpolatedKeyframeProgress() {
        return this.interpolatedKeyframeProgress;
    }

    public float getLinearKeyframeProgress() {
        return this.linearKeyframeProgress;
    }

    public float getOverallProgress() {
        return this.overallProgress;
    }

    public float getStartFrame() {
        return this.startFrame;
    }

    public T getStartValue() {
        return this.startValue;
    }

    public LottieFrameInfo<T> set(float f5, float f6, T t5, T t6, float f7, float f8, float f9) {
        this.startFrame = f5;
        this.endFrame = f6;
        this.startValue = t5;
        this.endValue = t6;
        this.linearKeyframeProgress = f7;
        this.interpolatedKeyframeProgress = f8;
        this.overallProgress = f9;
        return this;
    }
}
