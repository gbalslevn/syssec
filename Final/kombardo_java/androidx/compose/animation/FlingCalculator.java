package androidx.compose.animation;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0016¨\u0006\u001c"}, d2 = {"Landroidx/compose/animation/FlingCalculator;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "friction", "Landroidx/compose/ui/unit/Density;", "density", "<init>", "(FLandroidx/compose/ui/unit/Density;)V", "computeDeceleration", "(Landroidx/compose/ui/unit/Density;)F", "velocity", BuildConfig.FLAVOR, "getSplineDeceleration", "(F)D", BuildConfig.FLAVOR, "flingDuration", "(F)J", "flingDistance", "(F)F", "Landroidx/compose/animation/FlingCalculator$FlingInfo;", "flingInfo", "(F)Landroidx/compose/animation/FlingCalculator$FlingInfo;", "F", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "magicPhysicalCoefficient", "FlingInfo", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FlingCalculator {
    private final Density density;
    private final float friction;
    private final float magicPhysicalCoefficient;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Landroidx/compose/animation/FlingCalculator$FlingInfo;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "initialVelocity", "distance", BuildConfig.FLAVOR, "duration", "<init>", "(FFJ)V", "time", "position", "(J)F", "velocity", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "F", "getInitialVelocity", "()F", "getDistance", "J", "getDuration", "()J", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final /* data */ class FlingInfo {
        private final float distance;
        private final long duration;
        private final float initialVelocity;

        public FlingInfo(float f5, float f6, long j5) {
            this.initialVelocity = f5;
            this.distance = f6;
            this.duration = j5;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FlingInfo)) {
                return false;
            }
            FlingInfo flingInfo = (FlingInfo) other;
            return Float.compare(this.initialVelocity, flingInfo.initialVelocity) == 0 && Float.compare(this.distance, flingInfo.distance) == 0 && this.duration == flingInfo.duration;
        }

        public int hashCode() {
            return (((Float.hashCode(this.initialVelocity) * 31) + Float.hashCode(this.distance)) * 31) + Long.hashCode(this.duration);
        }

        public final float position(long time) {
            long j5 = this.duration;
            return this.distance * Math.signum(this.initialVelocity) * AndroidFlingSpline.INSTANCE.flingPosition(j5 > 0 ? ((float) time) / ((float) j5) : 1.0f).getDistanceCoefficient();
        }

        public String toString() {
            return "FlingInfo(initialVelocity=" + this.initialVelocity + ", distance=" + this.distance + ", duration=" + this.duration + ')';
        }

        public final float velocity(long time) {
            long j5 = this.duration;
            return (((AndroidFlingSpline.INSTANCE.flingPosition(j5 > 0 ? ((float) time) / ((float) j5) : 1.0f).getVelocityCoefficient() * Math.signum(this.initialVelocity)) * this.distance) / ((float) this.duration)) * 1000.0f;
        }
    }

    public FlingCalculator(float f5, Density density) {
        this.friction = f5;
        this.density = density;
        this.magicPhysicalCoefficient = computeDeceleration(density);
    }

    private final float computeDeceleration(Density density) {
        float computeDeceleration;
        computeDeceleration = FlingCalculatorKt.computeDeceleration(0.84f, density.getDensity());
        return computeDeceleration;
    }

    private final double getSplineDeceleration(float velocity) {
        return AndroidFlingSpline.INSTANCE.deceleration(velocity, this.friction * this.magicPhysicalCoefficient);
    }

    public final float flingDistance(float velocity) {
        float f5;
        float f6;
        double splineDeceleration = getSplineDeceleration(velocity);
        f5 = FlingCalculatorKt.DecelerationRate;
        double d5 = f5 - 1.0d;
        double d6 = this.friction * this.magicPhysicalCoefficient;
        f6 = FlingCalculatorKt.DecelerationRate;
        return (float) (d6 * Math.exp((f6 / d5) * splineDeceleration));
    }

    public final long flingDuration(float velocity) {
        float f5;
        double splineDeceleration = getSplineDeceleration(velocity);
        f5 = FlingCalculatorKt.DecelerationRate;
        return (long) (Math.exp(splineDeceleration / (f5 - 1.0d)) * 1000.0d);
    }

    public final FlingInfo flingInfo(float velocity) {
        float f5;
        float f6;
        double splineDeceleration = getSplineDeceleration(velocity);
        f5 = FlingCalculatorKt.DecelerationRate;
        double d5 = f5 - 1.0d;
        double d6 = this.friction * this.magicPhysicalCoefficient;
        f6 = FlingCalculatorKt.DecelerationRate;
        return new FlingInfo(velocity, (float) (d6 * Math.exp((f6 / d5) * splineDeceleration)), (long) (Math.exp(splineDeceleration / d5) * 1000.0d));
    }
}
