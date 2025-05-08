package androidx.cardview.widget;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
abstract class RoundRectDrawableWithShadow extends Drawable {
    private static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    private static final float SHADOW_MULTIPLIER = 1.5f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float calculateHorizontalPadding(float f5, float f6, boolean z5) {
        return z5 ? (float) (f5 + ((1.0d - COS_45) * f6)) : f5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float calculateVerticalPadding(float f5, float f6, boolean z5) {
        return z5 ? (float) ((f5 * SHADOW_MULTIPLIER) + ((1.0d - COS_45) * f6)) : f5 * SHADOW_MULTIPLIER;
    }
}
