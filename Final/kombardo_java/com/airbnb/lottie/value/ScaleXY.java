package com.airbnb.lottie.value;

/* loaded from: classes.dex */
public class ScaleXY {
    private float scaleX;
    private float scaleY;

    public ScaleXY(float f5, float f6) {
        this.scaleX = f5;
        this.scaleY = f6;
    }

    public boolean equals(float f5, float f6) {
        return this.scaleX == f5 && this.scaleY == f6;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public void set(float f5, float f6) {
        this.scaleX = f5;
        this.scaleY = f6;
    }

    public String toString() {
        return getScaleX() + "x" + getScaleY();
    }

    public ScaleXY() {
        this(1.0f, 1.0f);
    }
}
