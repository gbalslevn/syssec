package kotlin.math;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0004*\u00020\u0000H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0007H\u0007¢\u0006\u0004\b\u0002\u0010\b\u001a\u0013\u0010\u0005\u001a\u00020\u0004*\u00020\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\t\"\u001e\u0010\u000e\u001a\u00020\u0001*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b\"\u001e\u0010\u000e\u001a\u00020\u0001*\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u000f¨\u0006\u0011"}, d2 = {BuildConfig.FLAVOR, BuildConfig.FLAVOR, "roundToInt", "(D)I", BuildConfig.FLAVOR, "roundToLong", "(D)J", BuildConfig.FLAVOR, "(F)I", "(F)J", "getSign", "(I)I", "getSign$annotations", "(I)V", "sign", "(J)I", "(J)V", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/math/MathKt")
/* loaded from: classes2.dex */
public abstract class MathKt__MathJVMKt extends MathKt__MathHKt {
    public static int getSign(int i5) {
        return Integer.signum(i5);
    }

    public static int roundToInt(double d5) {
        if (Double.isNaN(d5)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d5 > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        if (d5 < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d5);
    }

    public static long roundToLong(double d5) {
        if (Double.isNaN(d5)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(d5);
    }

    public static int getSign(long j5) {
        return Long.signum(j5);
    }

    public static long roundToLong(float f5) {
        return MathKt.roundToLong(f5);
    }

    public static int roundToInt(float f5) {
        if (Float.isNaN(f5)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(f5);
    }
}
