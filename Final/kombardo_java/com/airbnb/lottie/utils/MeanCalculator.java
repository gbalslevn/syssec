package com.airbnb.lottie.utils;

/* loaded from: classes.dex */
public class MeanCalculator {

    /* renamed from: n, reason: collision with root package name */
    private int f4236n;
    private float sum;

    public void add(float f5) {
        float f6 = this.sum + f5;
        this.sum = f6;
        int i5 = this.f4236n + 1;
        this.f4236n = i5;
        if (i5 == Integer.MAX_VALUE) {
            this.sum = f6 / 2.0f;
            this.f4236n = i5 / 2;
        }
    }
}
