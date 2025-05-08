package androidx.core.view.animation;

import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* loaded from: classes.dex */
public abstract class PathInterpolatorCompat {

    /* loaded from: classes.dex */
    static class Api21Impl {
        static Interpolator createPathInterpolator(float f5, float f6, float f7, float f8) {
            return new PathInterpolator(f5, f6, f7, f8);
        }
    }

    public static Interpolator create(float f5, float f6, float f7, float f8) {
        return Api21Impl.createPathInterpolator(f5, f6, f7, f8);
    }
}
