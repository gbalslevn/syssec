package com.airbnb.lottie.utils;

import com.sun.jna.Function;

/* loaded from: classes.dex */
public abstract class GammaEvaluator {
    private static float EOCF_sRGB(float f5) {
        return f5 <= 0.04045f ? f5 / 12.92f : (float) Math.pow((f5 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    private static float OECF_sRGB(float f5) {
        return f5 <= 0.0031308f ? f5 * 12.92f : (float) ((Math.pow(f5, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int evaluate(float f5, int i5, int i6) {
        if (i5 == i6) {
            return i5;
        }
        float f6 = ((i5 >> 24) & Function.USE_VARARGS) / 255.0f;
        float f7 = ((i5 >> 16) & Function.USE_VARARGS) / 255.0f;
        float f8 = ((i5 >> 8) & Function.USE_VARARGS) / 255.0f;
        float f9 = ((i6 >> 24) & Function.USE_VARARGS) / 255.0f;
        float f10 = ((i6 >> 16) & Function.USE_VARARGS) / 255.0f;
        float f11 = ((i6 >> 8) & Function.USE_VARARGS) / 255.0f;
        float EOCF_sRGB = EOCF_sRGB(f7);
        float EOCF_sRGB2 = EOCF_sRGB(f8);
        float EOCF_sRGB3 = EOCF_sRGB((i5 & Function.USE_VARARGS) / 255.0f);
        float EOCF_sRGB4 = EOCF_sRGB(f10);
        float f12 = f6 + ((f9 - f6) * f5);
        float EOCF_sRGB5 = EOCF_sRGB2 + ((EOCF_sRGB(f11) - EOCF_sRGB2) * f5);
        float EOCF_sRGB6 = EOCF_sRGB3 + (f5 * (EOCF_sRGB((i6 & Function.USE_VARARGS) / 255.0f) - EOCF_sRGB3));
        return (Math.round(OECF_sRGB(EOCF_sRGB + ((EOCF_sRGB4 - EOCF_sRGB) * f5)) * 255.0f) << 16) | (Math.round(f12 * 255.0f) << 24) | (Math.round(OECF_sRGB(EOCF_sRGB5) * 255.0f) << 8) | Math.round(OECF_sRGB(EOCF_sRGB6) * 255.0f);
    }
}
