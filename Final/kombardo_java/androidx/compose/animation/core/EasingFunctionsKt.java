package androidx.compose.animation.core;

import androidx.compose.animation.core.EasingFunctionsKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\bG\"\u0017\u0010\u0001\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0004\"\u0017\u0010\u0007\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\u0004\"\u0017\u0010\t\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0004\"\u0017\u0010\u000b\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\u0004\"\u0017\u0010\r\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0004\"\u0017\u0010\u000f\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0004\"\u0017\u0010\u0011\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\u0004\"\u0017\u0010\u0013\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u0004\"\u0017\u0010\u0015\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0004\"\u0017\u0010\u0017\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0002\u001a\u0004\b\u0018\u0010\u0004\"\u0017\u0010\u0019\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u001a\u0010\u0004\"\u0017\u0010\u001b\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0002\u001a\u0004\b\u001c\u0010\u0004\"\u0017\u0010\u001d\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0002\u001a\u0004\b\u001e\u0010\u0004\"\u0017\u0010\u001f\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0002\u001a\u0004\b \u0010\u0004\"\u0017\u0010!\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b!\u0010\u0002\u001a\u0004\b\"\u0010\u0004\"\u0017\u0010#\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b#\u0010\u0002\u001a\u0004\b$\u0010\u0004\"\u0017\u0010%\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b%\u0010\u0002\u001a\u0004\b&\u0010\u0004\"\u0017\u0010'\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b'\u0010\u0002\u001a\u0004\b(\u0010\u0004\"\u0017\u0010)\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b)\u0010\u0002\u001a\u0004\b*\u0010\u0004\"\u0017\u0010+\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b+\u0010\u0002\u001a\u0004\b,\u0010\u0004\"\u0017\u0010-\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b-\u0010\u0002\u001a\u0004\b.\u0010\u0004\"\u0017\u0010/\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b/\u0010\u0002\u001a\u0004\b0\u0010\u0004\"\u0017\u00101\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b1\u0010\u0002\u001a\u0004\b2\u0010\u0004\"\u0017\u00103\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b3\u0010\u0002\u001a\u0004\b4\u0010\u0004\"\u0017\u00105\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b5\u0010\u0002\u001a\u0004\b6\u0010\u0004\"\u0017\u00107\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b7\u0010\u0002\u001a\u0004\b8\u0010\u0004\"\u0017\u00109\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b9\u0010\u0002\u001a\u0004\b:\u0010\u0004\"\u0017\u0010;\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b;\u0010\u0002\u001a\u0004\b<\u0010\u0004\"\u0017\u0010=\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b=\u0010\u0002\u001a\u0004\b>\u0010\u0004\"\u0017\u0010?\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b?\u0010\u0002\u001a\u0004\b@\u0010\u0004\"\u0017\u0010A\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\bA\u0010\u0002\u001a\u0004\bB\u0010\u0004\"\u0017\u0010C\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\bC\u0010\u0002\u001a\u0004\bD\u0010\u0004\"\u0017\u0010E\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\bE\u0010\u0002\u001a\u0004\bF\u0010\u0004¨\u0006G"}, d2 = {"Landroidx/compose/animation/core/Easing;", "Ease", "Landroidx/compose/animation/core/Easing;", "getEase", "()Landroidx/compose/animation/core/Easing;", "EaseOut", "getEaseOut", "EaseIn", "getEaseIn", "EaseInOut", "getEaseInOut", "EaseInSine", "getEaseInSine", "EaseOutSine", "getEaseOutSine", "EaseInOutSine", "getEaseInOutSine", "EaseInCubic", "getEaseInCubic", "EaseOutCubic", "getEaseOutCubic", "EaseInOutCubic", "getEaseInOutCubic", "EaseInQuint", "getEaseInQuint", "EaseOutQuint", "getEaseOutQuint", "EaseInOutQuint", "getEaseInOutQuint", "EaseInCirc", "getEaseInCirc", "EaseOutCirc", "getEaseOutCirc", "EaseInOutCirc", "getEaseInOutCirc", "EaseInQuad", "getEaseInQuad", "EaseOutQuad", "getEaseOutQuad", "EaseInOutQuad", "getEaseInOutQuad", "EaseInQuart", "getEaseInQuart", "EaseOutQuart", "getEaseOutQuart", "EaseInOutQuart", "getEaseInOutQuart", "EaseInExpo", "getEaseInExpo", "EaseOutExpo", "getEaseOutExpo", "EaseInOutExpo", "getEaseInOutExpo", "EaseInBack", "getEaseInBack", "EaseOutBack", "getEaseOutBack", "EaseInOutBack", "getEaseInOutBack", "EaseInElastic", "getEaseInElastic", "EaseOutElastic", "getEaseOutElastic", "EaseInOutElastic", "getEaseInOutElastic", "EaseOutBounce", "getEaseOutBounce", "EaseInBounce", "getEaseInBounce", "EaseInOutBounce", "getEaseInOutBounce", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class EasingFunctionsKt {
    private static final Easing Ease = new CubicBezierEasing(0.25f, 0.1f, 0.25f, 1.0f);
    private static final Easing EaseOut = new CubicBezierEasing(0.0f, 0.0f, 0.58f, 1.0f);
    private static final Easing EaseIn = new CubicBezierEasing(0.42f, 0.0f, 1.0f, 1.0f);
    private static final Easing EaseInOut = new CubicBezierEasing(0.42f, 0.0f, 0.58f, 1.0f);
    private static final Easing EaseInSine = new CubicBezierEasing(0.12f, 0.0f, 0.39f, 0.0f);
    private static final Easing EaseOutSine = new CubicBezierEasing(0.61f, 1.0f, 0.88f, 1.0f);
    private static final Easing EaseInOutSine = new CubicBezierEasing(0.37f, 0.0f, 0.63f, 1.0f);
    private static final Easing EaseInCubic = new CubicBezierEasing(0.32f, 0.0f, 0.67f, 0.0f);
    private static final Easing EaseOutCubic = new CubicBezierEasing(0.33f, 1.0f, 0.68f, 1.0f);
    private static final Easing EaseInOutCubic = new CubicBezierEasing(0.65f, 0.0f, 0.35f, 1.0f);
    private static final Easing EaseInQuint = new CubicBezierEasing(0.64f, 0.0f, 0.78f, 0.0f);
    private static final Easing EaseOutQuint = new CubicBezierEasing(0.22f, 1.0f, 0.36f, 1.0f);
    private static final Easing EaseInOutQuint = new CubicBezierEasing(0.83f, 0.0f, 0.17f, 1.0f);
    private static final Easing EaseInCirc = new CubicBezierEasing(0.55f, 0.0f, 1.0f, 0.45f);
    private static final Easing EaseOutCirc = new CubicBezierEasing(0.0f, 0.55f, 0.45f, 1.0f);
    private static final Easing EaseInOutCirc = new CubicBezierEasing(0.85f, 0.0f, 0.15f, 1.0f);
    private static final Easing EaseInQuad = new CubicBezierEasing(0.11f, 0.0f, 0.5f, 0.0f);
    private static final Easing EaseOutQuad = new CubicBezierEasing(0.5f, 1.0f, 0.89f, 1.0f);
    private static final Easing EaseInOutQuad = new CubicBezierEasing(0.45f, 0.0f, 0.55f, 1.0f);
    private static final Easing EaseInQuart = new CubicBezierEasing(0.5f, 0.0f, 0.75f, 0.0f);
    private static final Easing EaseOutQuart = new CubicBezierEasing(0.25f, 1.0f, 0.5f, 1.0f);
    private static final Easing EaseInOutQuart = new CubicBezierEasing(0.76f, 0.0f, 0.24f, 1.0f);
    private static final Easing EaseInExpo = new CubicBezierEasing(0.7f, 0.0f, 0.84f, 0.0f);
    private static final Easing EaseOutExpo = new CubicBezierEasing(0.16f, 1.0f, 0.3f, 1.0f);
    private static final Easing EaseInOutExpo = new CubicBezierEasing(0.87f, 0.0f, 0.13f, 1.0f);
    private static final Easing EaseInBack = new CubicBezierEasing(0.36f, 0.0f, 0.66f, -0.56f);
    private static final Easing EaseOutBack = new CubicBezierEasing(0.34f, 1.56f, 0.64f, 1.0f);
    private static final Easing EaseInOutBack = new CubicBezierEasing(0.68f, -0.6f, 0.32f, 1.6f);
    private static final Easing EaseInElastic = new Easing() { // from class: e.a
        @Override // androidx.compose.animation.core.Easing
        public final float transform(float f5) {
            float EaseInElastic$lambda$0;
            EaseInElastic$lambda$0 = EasingFunctionsKt.EaseInElastic$lambda$0(f5);
            return EaseInElastic$lambda$0;
        }
    };
    private static final Easing EaseOutElastic = new Easing() { // from class: e.b
        @Override // androidx.compose.animation.core.Easing
        public final float transform(float f5) {
            float EaseOutElastic$lambda$1;
            EaseOutElastic$lambda$1 = EasingFunctionsKt.EaseOutElastic$lambda$1(f5);
            return EaseOutElastic$lambda$1;
        }
    };
    private static final Easing EaseInOutElastic = new Easing() { // from class: e.c
        @Override // androidx.compose.animation.core.Easing
        public final float transform(float f5) {
            float EaseInOutElastic$lambda$2;
            EaseInOutElastic$lambda$2 = EasingFunctionsKt.EaseInOutElastic$lambda$2(f5);
            return EaseInOutElastic$lambda$2;
        }
    };
    private static final Easing EaseOutBounce = new Easing() { // from class: e.d
        @Override // androidx.compose.animation.core.Easing
        public final float transform(float f5) {
            float EaseOutBounce$lambda$3;
            EaseOutBounce$lambda$3 = EasingFunctionsKt.EaseOutBounce$lambda$3(f5);
            return EaseOutBounce$lambda$3;
        }
    };
    private static final Easing EaseInBounce = new Easing() { // from class: e.e
        @Override // androidx.compose.animation.core.Easing
        public final float transform(float f5) {
            float EaseInBounce$lambda$4;
            EaseInBounce$lambda$4 = EasingFunctionsKt.EaseInBounce$lambda$4(f5);
            return EaseInBounce$lambda$4;
        }
    };
    private static final Easing EaseInOutBounce = new Easing() { // from class: e.f
        @Override // androidx.compose.animation.core.Easing
        public final float transform(float f5) {
            float EaseInOutBounce$lambda$5;
            EaseInOutBounce$lambda$5 = EasingFunctionsKt.EaseInOutBounce$lambda$5(f5);
            return EaseInOutBounce$lambda$5;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final float EaseInBounce$lambda$4(float f5) {
        return 1 - EaseOutBounce.transform(1.0f - f5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float EaseInElastic$lambda$0(float f5) {
        if (f5 == 0.0f) {
            return 0.0f;
        }
        if (f5 == 1.0f) {
            return 1.0f;
        }
        float f6 = f5 * 10.0f;
        return (float) ((-((float) Math.pow(2.0f, f6 - 10.0f))) * Math.sin((f6 - 10.75f) * 2.0943951023931953d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float EaseInOutBounce$lambda$5(float f5) {
        return (((double) f5) < 0.5d ? 1 - EaseOutBounce.transform(1.0f - (f5 * 2.0f)) : 1 + EaseOutBounce.transform((f5 * 2.0f) - 1.0f)) / 2.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float EaseInOutElastic$lambda$2(float f5) {
        if (f5 == 0.0f) {
            return 0.0f;
        }
        if (f5 == 1.0f) {
            return 1.0f;
        }
        if (0.0f > f5 || f5 > 0.5f) {
            return ((float) ((((float) Math.pow(r8, ((-20.0f) * f5) + 10.0f)) * Math.sin(((f5 * 20.0f) - 11.125f) * 1.3962634015954636d)) / 2.0f)) + 1.0f;
        }
        float f6 = f5 * 20.0f;
        return (float) ((-(((float) Math.pow(r0, f6 - 10.0f)) * Math.sin((f6 - 11.125f) * 1.3962634015954636d))) / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float EaseOutBounce$lambda$3(float f5) {
        float f6;
        float f7;
        if (f5 < 0.36363637f) {
            return 7.5625f * f5 * f5;
        }
        if (f5 < 0.72727275f) {
            float f8 = f5 - 0.54545456f;
            f6 = 7.5625f * f8 * f8;
            f7 = 0.75f;
        } else if (f5 < 0.90909094f) {
            float f9 = f5 - 0.8181818f;
            f6 = 7.5625f * f9 * f9;
            f7 = 0.9375f;
        } else {
            float f10 = f5 - 0.95454544f;
            f6 = 7.5625f * f10 * f10;
            f7 = 0.984375f;
        }
        return f6 + f7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float EaseOutElastic$lambda$1(float f5) {
        if (f5 == 0.0f) {
            return 0.0f;
        }
        if (f5 == 1.0f) {
            return 1.0f;
        }
        return (float) ((((float) Math.pow(2.0f, (-10.0f) * f5)) * Math.sin(((f5 * 10.0f) - 0.75f) * 2.0943951023931953d)) + 1.0f);
    }

    public static final Easing getEaseOut() {
        return EaseOut;
    }
}
