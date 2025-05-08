package androidx.compose.animation.core;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u0010\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0005R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0016\u0010\u001d\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017R*\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0005R$\u0010$\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0005\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006%"}, d2 = {"Landroidx/compose/animation/core/SpringSimulation;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "finalPosition", "<init>", "(F)V", BuildConfig.FLAVOR, "init", "()V", "lastDisplacement", "lastVelocity", BuildConfig.FLAVOR, "timeElapsed", "Landroidx/compose/animation/core/Motion;", "updateValues-IJZedt4$animation_core_release", "(FFJ)J", "updateValues", "F", "getFinalPosition", "()F", "setFinalPosition", BuildConfig.FLAVOR, "naturalFreq", "D", BuildConfig.FLAVOR, "initialized", "Z", "gammaPlus", "gammaMinus", "dampedFreq", "value", "dampingRatio", "getDampingRatio", "setDampingRatio", "getStiffness", "setStiffness", "stiffness", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SpringSimulation {
    private double dampedFreq;
    private float finalPosition;
    private double gammaMinus;
    private double gammaPlus;
    private boolean initialized;
    private double naturalFreq = Math.sqrt(50.0d);
    private float dampingRatio = 1.0f;

    public SpringSimulation(float f5) {
        this.finalPosition = f5;
    }

    private final void init() {
        if (this.initialized) {
            return;
        }
        if (this.finalPosition == SpringSimulationKt.getUNSET()) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        float f5 = this.dampingRatio;
        double d5 = f5 * f5;
        if (f5 > 1.0f) {
            double d6 = this.naturalFreq;
            double d7 = d5 - 1;
            this.gammaPlus = ((-f5) * d6) + (d6 * Math.sqrt(d7));
            double d8 = -this.dampingRatio;
            double d9 = this.naturalFreq;
            this.gammaMinus = (d8 * d9) - (d9 * Math.sqrt(d7));
        } else if (f5 >= 0.0f && f5 < 1.0f) {
            this.dampedFreq = this.naturalFreq * Math.sqrt(1 - d5);
        }
        this.initialized = true;
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public final float getStiffness() {
        double d5 = this.naturalFreq;
        return (float) (d5 * d5);
    }

    public final void setDampingRatio(float f5) {
        if (f5 < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.dampingRatio = f5;
        this.initialized = false;
    }

    public final void setFinalPosition(float f5) {
        this.finalPosition = f5;
    }

    public final void setStiffness(float f5) {
        if (getStiffness() <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.naturalFreq = Math.sqrt(f5);
        this.initialized = false;
    }

    /* renamed from: updateValues-IJZedt4$animation_core_release, reason: not valid java name */
    public final long m68updateValuesIJZedt4$animation_core_release(float lastDisplacement, float lastVelocity, long timeElapsed) {
        double cos;
        double d5;
        init();
        float f5 = lastDisplacement - this.finalPosition;
        double d6 = timeElapsed / 1000.0d;
        float f6 = this.dampingRatio;
        if (f6 > 1.0f) {
            double d7 = f5;
            double d8 = this.gammaMinus;
            double d9 = lastVelocity;
            double d10 = this.gammaPlus;
            double d11 = d7 - (((d8 * d7) - d9) / (d8 - d10));
            double d12 = ((d7 * d8) - d9) / (d8 - d10);
            d5 = (Math.exp(d8 * d6) * d11) + (Math.exp(this.gammaPlus * d6) * d12);
            double d13 = this.gammaMinus;
            double exp = d11 * d13 * Math.exp(d13 * d6);
            double d14 = this.gammaPlus;
            cos = exp + (d12 * d14 * Math.exp(d14 * d6));
        } else if (f6 == 1.0f) {
            double d15 = this.naturalFreq;
            double d16 = f5;
            double d17 = lastVelocity + (d15 * d16);
            double d18 = d16 + (d17 * d6);
            double exp2 = Math.exp((-d15) * d6) * d18;
            double exp3 = d18 * Math.exp((-this.naturalFreq) * d6);
            double d19 = this.naturalFreq;
            cos = (exp3 * (-d19)) + (d17 * Math.exp((-d19) * d6));
            d5 = exp2;
        } else {
            double d20 = 1 / this.dampedFreq;
            double d21 = this.naturalFreq;
            double d22 = f5;
            double d23 = d20 * ((f6 * d21 * d22) + lastVelocity);
            double exp4 = Math.exp((-f6) * d21 * d6) * ((Math.cos(this.dampedFreq * d6) * d22) + (Math.sin(this.dampedFreq * d6) * d23));
            double d24 = this.naturalFreq;
            double d25 = (-d24) * exp4 * this.dampingRatio;
            double exp5 = Math.exp((-r5) * d24 * d6);
            double d26 = this.dampedFreq;
            double sin = (-d26) * d22 * Math.sin(d26 * d6);
            double d27 = this.dampedFreq;
            cos = d25 + (exp5 * (sin + (d23 * d27 * Math.cos(d27 * d6))));
            d5 = exp4;
        }
        return SpringSimulationKt.Motion((float) (d5 + this.finalPosition), (float) cos);
    }
}
