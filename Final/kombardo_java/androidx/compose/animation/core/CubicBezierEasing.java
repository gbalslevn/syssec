package androidx.compose.animation.core;

import androidx.compose.ui.graphics.BezierKt;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/animation/core/CubicBezierEasing;", "Landroidx/compose/animation/core/Easing;", "a", BuildConfig.FLAVOR, "b", "c", "d", "(FFFF)V", "max", "min", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "throwNoSolution", BuildConfig.FLAVOR, "fraction", "toString", BuildConfig.FLAVOR, "transform", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CubicBezierEasing implements Easing {
    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private final float max;
    private final float min;

    public CubicBezierEasing(float f5, float f6, float f7, float f8) {
        this.a = f5;
        this.b = f6;
        this.c = f7;
        this.d = f8;
        if (!((Float.isNaN(f5) || Float.isNaN(f6) || Float.isNaN(f7) || Float.isNaN(f8)) ? false : true)) {
            PreconditionsKt.throwIllegalArgumentException("Parameters to CubicBezierEasing cannot be NaN. Actual parameters are: " + f5 + ", " + f6 + ", " + f7 + ", " + f8 + '.');
        }
        long computeCubicVerticalBounds = BezierKt.computeCubicVerticalBounds(0.0f, f6, f8, 1.0f, new float[5], 0);
        this.min = Float.intBitsToFloat((int) (computeCubicVerticalBounds >> 32));
        this.max = Float.intBitsToFloat((int) (computeCubicVerticalBounds & 4294967295L));
    }

    private final void throwNoSolution(float fraction) {
        throw new IllegalArgumentException("The cubic curve with parameters (" + this.a + ", " + this.b + ", " + this.c + ", " + this.d + ") has no solution at " + fraction);
    }

    public boolean equals(Object other) {
        if (other instanceof CubicBezierEasing) {
            CubicBezierEasing cubicBezierEasing = (CubicBezierEasing) other;
            if (this.a == cubicBezierEasing.a && this.b == cubicBezierEasing.b && this.c == cubicBezierEasing.c && this.d == cubicBezierEasing.d) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.a) * 31) + Float.hashCode(this.b)) * 31) + Float.hashCode(this.c)) * 31) + Float.hashCode(this.d);
    }

    public String toString() {
        return "CubicBezierEasing(a=" + this.a + ", b=" + this.b + ", c=" + this.c + ", d=" + this.d + ')';
    }

    @Override // androidx.compose.animation.core.Easing
    public float transform(float fraction) {
        if (fraction <= 0.0f || fraction >= 1.0f) {
            return fraction;
        }
        float findFirstCubicRoot = BezierKt.findFirstCubicRoot(0.0f - fraction, this.a - fraction, this.c - fraction, 1.0f - fraction);
        if (Float.isNaN(findFirstCubicRoot)) {
            throwNoSolution(fraction);
        }
        float evaluateCubic = BezierKt.evaluateCubic(this.b, this.d, findFirstCubicRoot);
        float f5 = this.min;
        float f6 = this.max;
        if (evaluateCubic < f5) {
            evaluateCubic = f5;
        }
        return evaluateCubic > f6 ? f6 : evaluateCubic;
    }
}
