package androidx.compose.animation.core;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a7\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a7\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0007\u0010\n\u001a/\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a/\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0010\u001a7\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a?\u0010\u0016\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0016\u0010\u0017\"\u0014\u0010\u0018\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {BuildConfig.FLAVOR, "stiffness", "dampingRatio", "initialVelocity", "initialDisplacement", "delta", BuildConfig.FLAVOR, "estimateAnimationDurationMillis", "(FFFFF)J", BuildConfig.FLAVOR, "(DDDDD)J", "Landroidx/compose/animation/core/ComplexDouble;", "firstRoot", "p0", "v0", "estimateUnderDamped", "(Landroidx/compose/animation/core/ComplexDouble;DDD)D", "estimateCriticallyDamped", "secondRoot", "estimateOverDamped", "(Landroidx/compose/animation/core/ComplexDouble;Landroidx/compose/animation/core/ComplexDouble;DDD)D", "initialPosition", "estimateDurationInternal", "(Landroidx/compose/animation/core/ComplexDouble;Landroidx/compose/animation/core/ComplexDouble;DDDD)J", "MAX_LONG_MILLIS", "J", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SpringEstimationKt {
    private static final long MAX_LONG_MILLIS = 9223372036854L;

    public static final long estimateAnimationDurationMillis(float f5, float f6, float f7, float f8, float f9) {
        return f6 == 0.0f ? MAX_LONG_MILLIS : estimateAnimationDurationMillis(f5, f6, f7, f8, f9);
    }

    private static final double estimateCriticallyDamped(ComplexDouble complexDouble, double d5, double d6, double d7) {
        double d8;
        int i5;
        double d9 = d7;
        double d10 = complexDouble.get_real();
        double d11 = d10 * d5;
        double d12 = d6 - d11;
        double log = Math.log(Math.abs(d9 / d5)) / d10;
        double log2 = Math.log(Math.abs(d9 / d12));
        double d13 = log2;
        for (int i6 = 0; i6 < 6; i6++) {
            d13 = log2 - Math.log(Math.abs(d13 / d10));
        }
        double d14 = d13 / d10;
        if (!((Double.isInfinite(log) || Double.isNaN(log)) ? false : true)) {
            log = d14;
        } else if ((Double.isInfinite(d14) || Double.isNaN(d14)) ? false : true) {
            log = Math.max(log, d14);
        }
        double d15 = (-(d11 + d12)) / (d10 * d12);
        double d16 = d10 * d15;
        double exp = (Math.exp(d16) * d5) + (d12 * d15 * Math.exp(d16));
        if (!Double.isNaN(d15) && d15 > 0.0d) {
            if (d15 <= 0.0d || (-exp) >= d9) {
                log = (-(2.0d / d10)) - (d5 / d12);
                d8 = Double.MAX_VALUE;
                i5 = 0;
                while (d8 > 0.001d && i5 < 100) {
                    i5++;
                    double d17 = d10 * log;
                    double d18 = d9;
                    double exp2 = log - ((((d5 + (d12 * log)) * Math.exp(d17)) + d9) / ((((1 + d17) * d12) + d11) * Math.exp(d17)));
                    d8 = Math.abs(log - exp2);
                    log = exp2;
                    d9 = d18;
                }
                return log;
            }
            if (d12 < 0.0d && d5 > 0.0d) {
                log = 0.0d;
            }
        }
        d9 = -d9;
        d8 = Double.MAX_VALUE;
        i5 = 0;
        while (d8 > 0.001d) {
            i5++;
            double d172 = d10 * log;
            double d182 = d9;
            double exp22 = log - ((((d5 + (d12 * log)) * Math.exp(d172)) + d9) / ((((1 + d172) * d12) + d11) * Math.exp(d172)));
            d8 = Math.abs(log - exp22);
            log = exp22;
            d9 = d182;
        }
        return log;
    }

    private static final long estimateDurationInternal(ComplexDouble complexDouble, ComplexDouble complexDouble2, double d5, double d6, double d7, double d8) {
        double d9 = d6;
        if (d7 == 0.0d && d9 == 0.0d) {
            return 0L;
        }
        if (d7 < 0.0d) {
            d9 = -d9;
        }
        double abs = Math.abs(d7);
        return (long) ((d5 > 1.0d ? estimateOverDamped(complexDouble, complexDouble2, abs, d9, d8) : d5 < 1.0d ? estimateUnderDamped(complexDouble, abs, d9, d8) : estimateCriticallyDamped(complexDouble, abs, d9, d8)) * 1000.0d);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00c6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final double estimateOverDamped(ComplexDouble complexDouble, ComplexDouble complexDouble2, double d5, double d6, double d7) {
        double d8;
        double d9;
        double d10;
        double d11 = d7;
        double d12 = complexDouble.get_real();
        double d13 = complexDouble2.get_real();
        double d14 = d12 - d13;
        double d15 = ((d12 * d5) - d6) / d14;
        double d16 = d5 - d15;
        double log = Math.log(Math.abs(d11 / d16)) / d12;
        double log2 = Math.log(Math.abs(d11 / d15)) / d13;
        if ((Double.isInfinite(log) || Double.isNaN(log)) ? false : true) {
            if ((Double.isInfinite(log2) || Double.isNaN(log2)) ? false : true) {
                log = Math.max(log, log2);
            }
            d8 = log;
        } else {
            d8 = log2;
        }
        double d17 = d16 * d12;
        double log3 = Math.log(d17 / ((-d15) * d13)) / (d13 - d12);
        if (!Double.isNaN(log3) && log3 > 0.0d) {
            if (log3 > 0.0d) {
                d9 = d15;
                if ((-estimateOverDamped$xInflection(d16, d12, log3, d15, d13)) < d11) {
                    if (d9 > 0.0d && d16 < 0.0d) {
                        d8 = 0.0d;
                    }
                }
            } else {
                d9 = d15;
            }
            d8 = Math.log((-((d9 * d13) * d13)) / (d17 * d12)) / d14;
            d10 = d9 * d13;
            if (Math.abs((Math.exp(d12 * d8) * d17) + (Math.exp(d13 * d8) * d10)) >= 1.0E-4d) {
                return d8;
            }
            double d18 = Double.MAX_VALUE;
            int i5 = 0;
            while (d18 > 0.001d && i5 < 100) {
                i5++;
                double d19 = d12 * d8;
                double d20 = d13 * d8;
                double exp = d8 - ((((Math.exp(d19) * d16) + (Math.exp(d20) * d9)) + d11) / ((Math.exp(d19) * d17) + (Math.exp(d20) * d10)));
                double abs = Math.abs(d8 - exp);
                d8 = exp;
                d18 = abs;
            }
            return d8;
        }
        d9 = d15;
        d11 = -d11;
        d10 = d9 * d13;
        if (Math.abs((Math.exp(d12 * d8) * d17) + (Math.exp(d13 * d8) * d10)) >= 1.0E-4d) {
        }
    }

    private static final double estimateOverDamped$xInflection(double d5, double d6, double d7, double d8, double d9) {
        return (d5 * Math.exp(d6 * d7)) + (d8 * Math.exp(d9 * d7));
    }

    private static final double estimateUnderDamped(ComplexDouble complexDouble, double d5, double d6, double d7) {
        double d8 = complexDouble.get_real();
        double d9 = (d6 - (d8 * d5)) / complexDouble.get_imaginary();
        return Math.log(d7 / Math.sqrt((d5 * d5) + (d9 * d9))) / d8;
    }

    public static final long estimateAnimationDurationMillis(double d5, double d6, double d7, double d8, double d9) {
        double d10;
        double d11;
        double d12;
        double d13;
        double d14;
        double d15;
        double d16;
        double d17;
        double sqrt = 2.0d * d6 * Math.sqrt(d5);
        double d18 = (sqrt * sqrt) - (4.0d * d5);
        double d19 = -sqrt;
        ComplexDouble complexSqrt = ComplexDoubleKt.complexSqrt(d18);
        d10 = complexSqrt._real;
        complexSqrt._real = d10 + d19;
        d11 = complexSqrt._real;
        complexSqrt._real = d11 * 0.5d;
        d12 = complexSqrt._imaginary;
        complexSqrt._imaginary = d12 * 0.5d;
        ComplexDouble complexSqrt2 = ComplexDoubleKt.complexSqrt(d18);
        d13 = complexSqrt2._real;
        double d20 = -1;
        complexSqrt2._real = d13 * d20;
        d14 = complexSqrt2._imaginary;
        complexSqrt2._imaginary = d14 * d20;
        d15 = complexSqrt2._real;
        complexSqrt2._real = d15 + d19;
        d16 = complexSqrt2._real;
        complexSqrt2._real = d16 * 0.5d;
        d17 = complexSqrt2._imaginary;
        complexSqrt2._imaginary = d17 * 0.5d;
        return estimateDurationInternal(complexSqrt, complexSqrt2, d6, d7, d8, d9);
    }
}
