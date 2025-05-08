package androidx.core.content.res;

import android.graphics.Color;
import androidx.core.graphics.ColorUtils;

/* loaded from: classes.dex */
abstract class CamUtils {
    static final float[][] XYZ_TO_CAM16RGB = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};
    static final float[][] CAM16RGB_TO_XYZ = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};
    static final float[] WHITE_POINT_D65 = {95.047f, 100.0f, 108.883f};
    static final float[][] SRGB_TO_XYZ = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int intFromLStar(float f5) {
        if (f5 < 1.0f) {
            return -16777216;
        }
        if (f5 > 99.0f) {
            return -1;
        }
        float f6 = (f5 + 16.0f) / 116.0f;
        float f7 = f5 > 8.0f ? f6 * f6 * f6 : f5 / 903.2963f;
        float f8 = f6 * f6 * f6;
        boolean z5 = f8 > 0.008856452f;
        float f9 = z5 ? f8 : ((f6 * 116.0f) - 16.0f) / 903.2963f;
        if (!z5) {
            f8 = ((f6 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = WHITE_POINT_D65;
        return ColorUtils.XYZToColor(f9 * fArr[0], f7 * fArr[1], f8 * fArr[2]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float lStarFromInt(int i5) {
        return lStarFromY(yFromInt(i5));
    }

    static float lStarFromY(float f5) {
        float f6 = f5 / 100.0f;
        return f6 <= 0.008856452f ? f6 * 903.2963f : (((float) Math.cbrt(f6)) * 116.0f) - 16.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float lerp(float f5, float f6, float f7) {
        return f5 + ((f6 - f5) * f7);
    }

    static float linearized(int i5) {
        float f5 = i5 / 255.0f;
        return (f5 <= 0.04045f ? f5 / 12.92f : (float) Math.pow((f5 + 0.055f) / 1.055f, 2.4000000953674316d)) * 100.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void xyzFromInt(int i5, float[] fArr) {
        float linearized = linearized(Color.red(i5));
        float linearized2 = linearized(Color.green(i5));
        float linearized3 = linearized(Color.blue(i5));
        float[][] fArr2 = SRGB_TO_XYZ;
        float[] fArr3 = fArr2[0];
        fArr[0] = (fArr3[0] * linearized) + (fArr3[1] * linearized2) + (fArr3[2] * linearized3);
        float[] fArr4 = fArr2[1];
        fArr[1] = (fArr4[0] * linearized) + (fArr4[1] * linearized2) + (fArr4[2] * linearized3);
        float[] fArr5 = fArr2[2];
        fArr[2] = (linearized * fArr5[0]) + (linearized2 * fArr5[1]) + (linearized3 * fArr5[2]);
    }

    static float yFromInt(int i5) {
        float linearized = linearized(Color.red(i5));
        float linearized2 = linearized(Color.green(i5));
        float linearized3 = linearized(Color.blue(i5));
        float[] fArr = SRGB_TO_XYZ[1];
        return (linearized * fArr[0]) + (linearized2 * fArr[1]) + (linearized3 * fArr[2]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float yFromLStar(float f5) {
        return (f5 > 8.0f ? (float) Math.pow((f5 + 16.0d) / 116.0d, 3.0d) : f5 / 903.2963f) * 100.0f;
    }
}
