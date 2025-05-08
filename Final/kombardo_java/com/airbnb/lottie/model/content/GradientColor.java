package com.airbnb.lottie.model.content;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;
import java.util.Arrays;

/* loaded from: classes.dex */
public class GradientColor {
    private final int[] colors;
    private final float[] positions;

    public GradientColor(float[] fArr, int[] iArr) {
        this.positions = fArr;
        this.colors = iArr;
    }

    private int getColorForPosition(float f5) {
        int binarySearch = Arrays.binarySearch(this.positions, f5);
        if (binarySearch >= 0) {
            return this.colors[binarySearch];
        }
        int i5 = -(binarySearch + 1);
        if (i5 == 0) {
            return this.colors[0];
        }
        int[] iArr = this.colors;
        if (i5 == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.positions;
        int i6 = i5 - 1;
        float f6 = fArr[i6];
        return GammaEvaluator.evaluate((f5 - f6) / (fArr[i5] - f6), iArr[i6], iArr[i5]);
    }

    public GradientColor copyWithPositions(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i5 = 0; i5 < fArr.length; i5++) {
            iArr[i5] = getColorForPosition(fArr[i5]);
        }
        return new GradientColor(fArr, iArr);
    }

    public int[] getColors() {
        return this.colors;
    }

    public float[] getPositions() {
        return this.positions;
    }

    public int getSize() {
        return this.colors.length;
    }

    public void lerp(GradientColor gradientColor, GradientColor gradientColor2, float f5) {
        if (gradientColor.colors.length == gradientColor2.colors.length) {
            for (int i5 = 0; i5 < gradientColor.colors.length; i5++) {
                this.positions[i5] = MiscUtils.lerp(gradientColor.positions[i5], gradientColor2.positions[i5], f5);
                this.colors[i5] = GammaEvaluator.evaluate(f5, gradientColor.colors[i5], gradientColor2.colors[i5]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + gradientColor.colors.length + " vs " + gradientColor2.colors.length + ")");
    }
}
