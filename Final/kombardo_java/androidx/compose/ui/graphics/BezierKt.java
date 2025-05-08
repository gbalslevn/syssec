package androidx.compose.ui.graphics;

import androidx.collection.FloatFloatPair;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\u001a7\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0006\u0010\b\u001a/\u0010\t\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\t\u0010\n\u001a9\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001aA\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a'\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0019\u0010\u001a\"\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d\"\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001d\"\u0014\u0010\u001f\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {BuildConfig.FLAVOR, "p0", "p1", "p2", "p3", "t", "evaluateCubic", "(FFFFF)F", "(FFF)F", "findFirstCubicRoot", "(FFFF)F", BuildConfig.FLAVOR, "roots", BuildConfig.FLAVOR, "index", "findQuadraticRoots", "(FFF[FI)I", "p0y", "p1y", "p2y", "p3y", "Landroidx/collection/FloatFloatPair;", "computeCubicVerticalBounds", "(FFFF[FI)J", "r", "writeValidRootInUnitRange", "(F[FI)I", BuildConfig.FLAVOR, "Tau", "D", "Epsilon", "FloatEpsilon", "F", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class BezierKt {
    private static final double Epsilon = 1.0E-7d;
    private static final float FloatEpsilon = 8.34465E-7f;
    private static final double Tau = 6.283185307179586d;

    public static final long computeCubicVerticalBounds(float f5, float f6, float f7, float f8, float[] fArr, int i5) {
        float f9 = (f6 - f5) * 3.0f;
        float f10 = (f7 - f6) * 3.0f;
        float f11 = (f8 - f7) * 3.0f;
        int findQuadraticRoots = findQuadraticRoots(f9, f10, f11, fArr, i5);
        float f12 = (f10 - f9) * 2.0f;
        int writeValidRootInUnitRange = findQuadraticRoots + writeValidRootInUnitRange((-f12) / (((f11 - f10) * 2.0f) - f12), fArr, i5 + findQuadraticRoots);
        float min = Math.min(f5, f8);
        float max = Math.max(f5, f8);
        for (int i6 = 0; i6 < writeValidRootInUnitRange; i6++) {
            float evaluateCubic = evaluateCubic(f5, f6, f7, f8, fArr[i6]);
            min = Math.min(min, evaluateCubic);
            max = Math.max(max, evaluateCubic);
        }
        return FloatFloatPair.m4constructorimpl(min, max);
    }

    public static final float evaluateCubic(float f5, float f6, float f7) {
        return ((((((f5 - f6) + 0.33333334f) * f7) + (f6 - (2.0f * f5))) * f7) + f5) * 3.0f * f7;
    }

    public static final float findFirstCubicRoot(float f5, float f6, float f7, float f8) {
        double d5 = f5;
        double d6 = ((d5 - (f6 * 2.0d)) + f7) * 3.0d;
        double d7 = (f6 - f5) * 3.0d;
        double d8 = (-f5) + ((f6 - f7) * 3.0d) + f8;
        if (Math.abs(d8 - 0.0d) < Epsilon) {
            if (Math.abs(d6 - 0.0d) < Epsilon) {
                if (Math.abs(d7 - 0.0d) < Epsilon) {
                    return Float.NaN;
                }
                float f9 = (float) ((-d5) / d7);
                if (f9 < 0.0f) {
                    if (f9 >= -8.34465E-7f) {
                        return 0.0f;
                    }
                } else {
                    if (f9 <= 1.0f) {
                        return f9;
                    }
                    if (f9 <= 1.0000008f) {
                        return 1.0f;
                    }
                }
                return Float.NaN;
            }
            double sqrt = Math.sqrt((d7 * d7) - ((4.0d * d6) * d5));
            double d9 = d6 * 2.0d;
            float f10 = (float) ((sqrt - d7) / d9);
            if (f10 < 0.0f) {
                if (f10 >= -8.34465E-7f) {
                    f10 = 0.0f;
                }
                f10 = Float.NaN;
            } else if (f10 > 1.0f) {
                if (f10 <= 1.0000008f) {
                    f10 = 1.0f;
                }
                f10 = Float.NaN;
            }
            if (!Float.isNaN(f10)) {
                return f10;
            }
            float f11 = (float) (((-d7) - sqrt) / d9);
            if (f11 < 0.0f) {
                if (f11 >= -8.34465E-7f) {
                    return 0.0f;
                }
            } else {
                if (f11 <= 1.0f) {
                    return f11;
                }
                if (f11 <= 1.0000008f) {
                    return 1.0f;
                }
            }
            return Float.NaN;
        }
        double d10 = d6 / d8;
        double d11 = d7 / d8;
        double d12 = d5 / d8;
        double d13 = ((d11 * 3.0d) - (d10 * d10)) / 9.0d;
        double d14 = (((((2.0d * d10) * d10) * d10) - ((9.0d * d10) * d11)) + (d12 * 27.0d)) / 54.0d;
        double d15 = d13 * d13 * d13;
        double d16 = (d14 * d14) + d15;
        double d17 = d10 / 3.0d;
        if (d16 >= 0.0d) {
            if (d16 != 0.0d) {
                double sqrt2 = Math.sqrt(d16);
                float fastCbrt = (float) ((MathHelpersKt.fastCbrt((float) ((-d14) + sqrt2)) - MathHelpersKt.fastCbrt((float) (d14 + sqrt2))) - d17);
                if (fastCbrt < 0.0f) {
                    if (fastCbrt >= -8.34465E-7f) {
                        return 0.0f;
                    }
                } else {
                    if (fastCbrt <= 1.0f) {
                        return fastCbrt;
                    }
                    if (fastCbrt <= 1.0000008f) {
                        return 1.0f;
                    }
                }
                return Float.NaN;
            }
            float f12 = -MathHelpersKt.fastCbrt((float) d14);
            float f13 = (float) d17;
            float f14 = (2.0f * f12) - f13;
            if (f14 < 0.0f) {
                if (f14 >= -8.34465E-7f) {
                    f14 = 0.0f;
                }
                f14 = Float.NaN;
            } else if (f14 > 1.0f) {
                if (f14 <= 1.0000008f) {
                    f14 = 1.0f;
                }
                f14 = Float.NaN;
            }
            if (!Float.isNaN(f14)) {
                return f14;
            }
            float f15 = (-f12) - f13;
            if (f15 < 0.0f) {
                if (f15 >= -8.34465E-7f) {
                    return 0.0f;
                }
            } else {
                if (f15 <= 1.0f) {
                    return f15;
                }
                if (f15 <= 1.0000008f) {
                    return 1.0f;
                }
            }
            return Float.NaN;
        }
        double sqrt3 = Math.sqrt(-d15);
        double d18 = (-d14) / sqrt3;
        if (d18 < -1.0d) {
            d18 = -1.0d;
        }
        if (d18 > 1.0d) {
            d18 = 1.0d;
        }
        double acos = Math.acos(d18);
        double fastCbrt2 = MathHelpersKt.fastCbrt((float) sqrt3) * 2.0f;
        float cos = (float) ((Math.cos(acos / 3.0d) * fastCbrt2) - d17);
        if (cos < 0.0f) {
            if (cos >= -8.34465E-7f) {
                cos = 0.0f;
            }
            cos = Float.NaN;
        } else if (cos > 1.0f) {
            if (cos <= 1.0000008f) {
                cos = 1.0f;
            }
            cos = Float.NaN;
        }
        if (!Float.isNaN(cos)) {
            return cos;
        }
        float cos2 = (float) ((Math.cos((Tau + acos) / 3.0d) * fastCbrt2) - d17);
        if (cos2 < 0.0f) {
            if (cos2 >= -8.34465E-7f) {
                cos2 = 0.0f;
            }
            cos2 = Float.NaN;
        } else if (cos2 > 1.0f) {
            if (cos2 <= 1.0000008f) {
                cos2 = 1.0f;
            }
            cos2 = Float.NaN;
        }
        if (!Float.isNaN(cos2)) {
            return cos2;
        }
        float cos3 = (float) ((fastCbrt2 * Math.cos((acos + 12.566370614359172d) / 3.0d)) - d17);
        if (cos3 < 0.0f) {
            if (cos3 >= -8.34465E-7f) {
                return 0.0f;
            }
        } else {
            if (cos3 <= 1.0f) {
                return cos3;
            }
            if (cos3 <= 1.0000008f) {
                return 1.0f;
            }
        }
        return Float.NaN;
    }

    private static final int findQuadraticRoots(float f5, float f6, float f7, float[] fArr, int i5) {
        double d5 = f5;
        double d6 = f6;
        double d7 = f7;
        double d8 = d6 * 2.0d;
        double d9 = (d5 - d8) + d7;
        if (d9 == 0.0d) {
            if (d6 == d7) {
                return 0;
            }
            return writeValidRootInUnitRange((float) ((d8 - d7) / (d8 - (d7 * 2.0d))), fArr, i5);
        }
        double d10 = -Math.sqrt((d6 * d6) - (d7 * d5));
        double d11 = (-d5) + d6;
        int writeValidRootInUnitRange = writeValidRootInUnitRange((float) ((-(d10 + d11)) / d9), fArr, i5);
        int writeValidRootInUnitRange2 = writeValidRootInUnitRange + writeValidRootInUnitRange((float) ((d10 - d11) / d9), fArr, i5 + writeValidRootInUnitRange);
        if (writeValidRootInUnitRange2 > 1) {
            float f8 = fArr[i5];
            int i6 = i5 + 1;
            float f9 = fArr[i6];
            if (f8 > f9) {
                fArr[i5] = f9;
                fArr[i6] = f8;
            } else if (f8 == f9) {
                return writeValidRootInUnitRange2 - 1;
            }
        }
        return writeValidRootInUnitRange2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
    
        if (r3 <= 1.0000008f) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000b, code lost:
    
        if (r3 >= (-8.34465E-7f)) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
    
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x000f, code lost:
    
        r3 = Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int writeValidRootInUnitRange(float f5, float[] fArr, int i5) {
        float f6 = 0.0f;
        if (f5 >= 0.0f) {
            f6 = 1.0f;
            if (f5 > 1.0f) {
            }
        }
        fArr[i5] = f5;
        return !Float.isNaN(f5) ? 1 : 0;
    }

    private static final float evaluateCubic(float f5, float f6, float f7, float f8, float f9) {
        float f10 = (f8 + ((f6 - f7) * 3.0f)) - f5;
        return (((((f10 * f9) + (((f7 - (2.0f * f6)) + f5) * 3.0f)) * f9) + ((f6 - f5) * 3.0f)) * f9) + f5;
    }
}
