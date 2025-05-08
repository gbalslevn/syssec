package androidx.core.graphics;

import android.graphics.Color;
import com.sun.jna.Function;

/* loaded from: classes.dex */
public abstract class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final ThreadLocal<double[]> TEMP_ARRAY = new ThreadLocal<>();
    private static final double XYZ_EPSILON = 0.008856d;
    private static final double XYZ_KAPPA = 903.3d;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047d;
    private static final double XYZ_WHITE_REFERENCE_Y = 100.0d;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883d;

    public static int XYZToColor(double d5, double d6, double d7) {
        double d8 = (((3.2406d * d5) + ((-1.5372d) * d6)) + ((-0.4986d) * d7)) / XYZ_WHITE_REFERENCE_Y;
        double d9 = ((((-0.9689d) * d5) + (1.8758d * d6)) + (0.0415d * d7)) / XYZ_WHITE_REFERENCE_Y;
        double d10 = (((0.0557d * d5) + ((-0.204d) * d6)) + (1.057d * d7)) / XYZ_WHITE_REFERENCE_Y;
        return Color.rgb(constrain((int) Math.round((d8 > 0.0031308d ? (Math.pow(d8, 0.4166666666666667d) * 1.055d) - 0.055d : d8 * 12.92d) * 255.0d), 0, Function.USE_VARARGS), constrain((int) Math.round((d9 > 0.0031308d ? (Math.pow(d9, 0.4166666666666667d) * 1.055d) - 0.055d : d9 * 12.92d) * 255.0d), 0, Function.USE_VARARGS), constrain((int) Math.round((d10 > 0.0031308d ? (Math.pow(d10, 0.4166666666666667d) * 1.055d) - 0.055d : d10 * 12.92d) * 255.0d), 0, Function.USE_VARARGS));
    }

    private static int compositeAlpha(int i5, int i6) {
        return 255 - (((255 - i6) * (255 - i5)) / Function.USE_VARARGS);
    }

    public static int compositeColors(int i5, int i6) {
        int alpha = Color.alpha(i6);
        int alpha2 = Color.alpha(i5);
        int compositeAlpha = compositeAlpha(alpha2, alpha);
        return Color.argb(compositeAlpha, compositeComponent(Color.red(i5), alpha2, Color.red(i6), alpha, compositeAlpha), compositeComponent(Color.green(i5), alpha2, Color.green(i6), alpha, compositeAlpha), compositeComponent(Color.blue(i5), alpha2, Color.blue(i6), alpha, compositeAlpha));
    }

    private static int compositeComponent(int i5, int i6, int i7, int i8, int i9) {
        if (i9 == 0) {
            return 0;
        }
        return (((i5 * Function.USE_VARARGS) * i6) + ((i7 * i8) * (255 - i6))) / (i9 * Function.USE_VARARGS);
    }

    private static int constrain(int i5, int i6, int i7) {
        return i5 < i6 ? i6 : Math.min(i5, i7);
    }

    public static int setAlphaComponent(int i5, int i6) {
        if (i6 < 0 || i6 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i5 & 16777215) | (i6 << 24);
    }
}
