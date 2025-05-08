package androidx.core.content.res;

/* loaded from: classes.dex */
final class ViewingConditions {
    static final ViewingConditions DEFAULT = make(CamUtils.WHITE_POINT_D65, (float) ((CamUtils.yFromLStar(50.0f) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);
    private final float mAw;
    private final float mC;
    private final float mFl;
    private final float mFlRoot;
    private final float mN;
    private final float mNbb;
    private final float mNc;
    private final float mNcb;
    private final float[] mRgbD;
    private final float mZ;

    private ViewingConditions(float f5, float f6, float f7, float f8, float f9, float f10, float[] fArr, float f11, float f12, float f13) {
        this.mN = f5;
        this.mAw = f6;
        this.mNbb = f7;
        this.mNcb = f8;
        this.mC = f9;
        this.mNc = f10;
        this.mRgbD = fArr;
        this.mFl = f11;
        this.mFlRoot = f12;
        this.mZ = f13;
    }

    static ViewingConditions make(float[] fArr, float f5, float f6, float f7, boolean z5) {
        float[][] fArr2 = CamUtils.XYZ_TO_CAM16RGB;
        float f8 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f9 = fArr3[0] * f8;
        float f10 = fArr[1];
        float f11 = f9 + (fArr3[1] * f10);
        float f12 = fArr[2];
        float f13 = f11 + (fArr3[2] * f12);
        float[] fArr4 = fArr2[1];
        float f14 = (fArr4[0] * f8) + (fArr4[1] * f10) + (fArr4[2] * f12);
        float[] fArr5 = fArr2[2];
        float f15 = (f8 * fArr5[0]) + (f10 * fArr5[1]) + (f12 * fArr5[2]);
        float f16 = (f7 / 10.0f) + 0.8f;
        float lerp = ((double) f16) >= 0.9d ? CamUtils.lerp(0.59f, 0.69f, (f16 - 0.9f) * 10.0f) : CamUtils.lerp(0.525f, 0.59f, (f16 - 0.8f) * 10.0f);
        float exp = z5 ? 1.0f : (1.0f - (((float) Math.exp(((-f5) - 42.0f) / 92.0f)) * 0.2777778f)) * f16;
        double d5 = exp;
        if (d5 > 1.0d) {
            exp = 1.0f;
        } else if (d5 < 0.0d) {
            exp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f13) * exp) + 1.0f) - exp, (((100.0f / f14) * exp) + 1.0f) - exp, (((100.0f / f15) * exp) + 1.0f) - exp};
        float f17 = 1.0f / ((5.0f * f5) + 1.0f);
        float f18 = f17 * f17 * f17 * f17;
        float f19 = 1.0f - f18;
        float cbrt = (f18 * f5) + (0.1f * f19 * f19 * ((float) Math.cbrt(f5 * 5.0d)));
        float yFromLStar = CamUtils.yFromLStar(f6) / fArr[1];
        double d6 = yFromLStar;
        float sqrt = ((float) Math.sqrt(d6)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d6, 0.2d));
        float[] fArr7 = {(float) Math.pow(((fArr6[0] * cbrt) * f13) / 100.0d, 0.42d), (float) Math.pow(((fArr6[1] * cbrt) * f14) / 100.0d, 0.42d), (float) Math.pow(((fArr6[2] * cbrt) * f15) / 100.0d, 0.42d)};
        float f20 = fArr7[0];
        float f21 = (f20 * 400.0f) / (f20 + 27.13f);
        float f22 = fArr7[1];
        float f23 = (f22 * 400.0f) / (f22 + 27.13f);
        float f24 = fArr7[2];
        float[] fArr8 = {f21, f23, (400.0f * f24) / (f24 + 27.13f)};
        return new ViewingConditions(yFromLStar, ((fArr8[0] * 2.0f) + fArr8[1] + (fArr8[2] * 0.05f)) * pow, pow, pow, lerp, f16, fArr6, cbrt, (float) Math.pow(cbrt, 0.25d), sqrt);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getAw() {
        return this.mAw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getC() {
        return this.mC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getFl() {
        return this.mFl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getFlRoot() {
        return this.mFlRoot;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getN() {
        return this.mN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getNbb() {
        return this.mNbb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getNc() {
        return this.mNc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getNcb() {
        return this.mNcb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float[] getRgbD() {
        return this.mRgbD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getZ() {
        return this.mZ;
    }
}
