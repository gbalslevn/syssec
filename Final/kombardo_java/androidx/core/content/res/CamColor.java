package androidx.core.content.res;

import androidx.core.graphics.ColorUtils;

/* loaded from: classes.dex */
public class CamColor {
    private static final float CHROMA_SEARCH_ENDPOINT = 0.4f;
    private static final float DE_MAX = 1.0f;
    private static final float DL_MAX = 0.2f;
    private static final float LIGHTNESS_SEARCH_ENDPOINT = 0.01f;
    private final float mAstar;
    private final float mBstar;
    private final float mChroma;
    private final float mHue;
    private final float mJ;
    private final float mJstar;
    private final float mM;
    private final float mQ;
    private final float mS;

    CamColor(float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        this.mHue = f5;
        this.mChroma = f6;
        this.mJ = f7;
        this.mQ = f8;
        this.mM = f9;
        this.mS = f10;
        this.mJstar = f11;
        this.mAstar = f12;
        this.mBstar = f13;
    }

    private static CamColor findCamByJ(float f5, float f6, float f7) {
        float f8 = 100.0f;
        float f9 = 1000.0f;
        float f10 = 0.0f;
        CamColor camColor = null;
        float f11 = 1000.0f;
        while (Math.abs(f10 - f8) > LIGHTNESS_SEARCH_ENDPOINT) {
            float f12 = ((f8 - f10) / 2.0f) + f10;
            int viewedInSrgb = fromJch(f12, f6, f5).viewedInSrgb();
            float lStarFromInt = CamUtils.lStarFromInt(viewedInSrgb);
            float abs = Math.abs(f7 - lStarFromInt);
            if (abs < DL_MAX) {
                CamColor fromColor = fromColor(viewedInSrgb);
                float distance = fromColor.distance(fromJch(fromColor.getJ(), fromColor.getChroma(), f5));
                if (distance <= DE_MAX) {
                    camColor = fromColor;
                    f9 = abs;
                    f11 = distance;
                }
            }
            if (f9 == 0.0f && f11 == 0.0f) {
                break;
            }
            if (lStarFromInt < f7) {
                f10 = f12;
            } else {
                f8 = f12;
            }
        }
        return camColor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CamColor fromColor(int i5) {
        float[] fArr = new float[7];
        float[] fArr2 = new float[3];
        fromColorInViewingConditions(i5, ViewingConditions.DEFAULT, fArr, fArr2);
        return new CamColor(fArr2[0], fArr2[1], fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6]);
    }

    static void fromColorInViewingConditions(int i5, ViewingConditions viewingConditions, float[] fArr, float[] fArr2) {
        CamUtils.xyzFromInt(i5, fArr2);
        float[][] fArr3 = CamUtils.XYZ_TO_CAM16RGB;
        float f5 = fArr2[0];
        float[] fArr4 = fArr3[0];
        float f6 = fArr4[0] * f5;
        float f7 = fArr2[1];
        float f8 = f6 + (fArr4[1] * f7);
        float f9 = fArr2[2];
        float f10 = f8 + (fArr4[2] * f9);
        float[] fArr5 = fArr3[1];
        float f11 = (fArr5[0] * f5) + (fArr5[1] * f7) + (fArr5[2] * f9);
        float[] fArr6 = fArr3[2];
        float f12 = (f5 * fArr6[0]) + (f7 * fArr6[1]) + (f9 * fArr6[2]);
        float f13 = viewingConditions.getRgbD()[0] * f10;
        float f14 = viewingConditions.getRgbD()[1] * f11;
        float f15 = viewingConditions.getRgbD()[2] * f12;
        float pow = (float) Math.pow((viewingConditions.getFl() * Math.abs(f13)) / 100.0d, 0.42d);
        float pow2 = (float) Math.pow((viewingConditions.getFl() * Math.abs(f14)) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow((viewingConditions.getFl() * Math.abs(f15)) / 100.0d, 0.42d);
        float signum = ((Math.signum(f13) * 400.0f) * pow) / (pow + 27.13f);
        float signum2 = ((Math.signum(f14) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum3 = ((Math.signum(f15) * 400.0f) * pow3) / (pow3 + 27.13f);
        double d5 = signum3;
        float f16 = ((float) (((signum * 11.0d) + (signum2 * (-12.0d))) + d5)) / 11.0f;
        float f17 = ((float) ((signum + signum2) - (d5 * 2.0d))) / 9.0f;
        float f18 = signum2 * 20.0f;
        float f19 = (((signum * 20.0f) + f18) + (21.0f * signum3)) / 20.0f;
        float f20 = (((signum * 40.0f) + f18) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2(f17, f16)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f21 = (3.1415927f * atan2) / 180.0f;
        float pow4 = ((float) Math.pow((f20 * viewingConditions.getNbb()) / viewingConditions.getAw(), viewingConditions.getC() * viewingConditions.getZ())) * 100.0f;
        float c5 = (4.0f / viewingConditions.getC()) * ((float) Math.sqrt(pow4 / 100.0f)) * (viewingConditions.getAw() + 4.0f) * viewingConditions.getFlRoot();
        float sqrt = ((float) Math.sqrt(pow4 / 100.0d)) * ((float) Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos((((((double) atan2) < 20.14d ? 360.0f + atan2 : atan2) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * viewingConditions.getNc()) * viewingConditions.getNcb()) * ((float) Math.sqrt((f16 * f16) + (f17 * f17)))) / (f19 + 0.305f), 0.9d));
        float flRoot = viewingConditions.getFlRoot() * sqrt;
        float sqrt2 = ((float) Math.sqrt((r7 * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0f))) * 50.0f;
        float f22 = (1.7f * pow4) / ((0.007f * pow4) + DE_MAX);
        float log = ((float) Math.log((0.0228f * flRoot) + DE_MAX)) * 43.85965f;
        double d6 = f21;
        float cos = ((float) Math.cos(d6)) * log;
        float sin = log * ((float) Math.sin(d6));
        fArr2[0] = atan2;
        fArr2[1] = sqrt;
        if (fArr != null) {
            fArr[0] = pow4;
            fArr[1] = c5;
            fArr[2] = flRoot;
            fArr[3] = sqrt2;
            fArr[4] = f22;
            fArr[5] = cos;
            fArr[6] = sin;
        }
    }

    private static CamColor fromJch(float f5, float f6, float f7) {
        return fromJchInFrame(f5, f6, f7, ViewingConditions.DEFAULT);
    }

    private static CamColor fromJchInFrame(float f5, float f6, float f7, ViewingConditions viewingConditions) {
        float c5 = (4.0f / viewingConditions.getC()) * ((float) Math.sqrt(f5 / 100.0d)) * (viewingConditions.getAw() + 4.0f) * viewingConditions.getFlRoot();
        float flRoot = f6 * viewingConditions.getFlRoot();
        float sqrt = ((float) Math.sqrt(((f6 / ((float) Math.sqrt(r4))) * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0f))) * 50.0f;
        float f8 = (1.7f * f5) / ((0.007f * f5) + DE_MAX);
        float log = ((float) Math.log((flRoot * 0.0228d) + 1.0d)) * 43.85965f;
        double d5 = (3.1415927f * f7) / 180.0f;
        return new CamColor(f7, f6, f5, c5, flRoot, sqrt, f8, log * ((float) Math.cos(d5)), log * ((float) Math.sin(d5)));
    }

    public static int toColor(float f5, float f6, float f7) {
        return toColor(f5, f6, f7, ViewingConditions.DEFAULT);
    }

    float distance(CamColor camColor) {
        float jStar = getJStar() - camColor.getJStar();
        float aStar = getAStar() - camColor.getAStar();
        float bStar = getBStar() - camColor.getBStar();
        return (float) (Math.pow(Math.sqrt((jStar * jStar) + (aStar * aStar) + (bStar * bStar)), 0.63d) * 1.41d);
    }

    float getAStar() {
        return this.mAstar;
    }

    float getBStar() {
        return this.mBstar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getChroma() {
        return this.mChroma;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getHue() {
        return this.mHue;
    }

    float getJ() {
        return this.mJ;
    }

    float getJStar() {
        return this.mJstar;
    }

    int viewed(ViewingConditions viewingConditions) {
        float pow = (float) Math.pow(((((double) getChroma()) == 0.0d || ((double) getJ()) == 0.0d) ? 0.0f : getChroma() / ((float) Math.sqrt(getJ() / 100.0d))) / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d), 1.1111111111111112d);
        double hue = (getHue() * 3.1415927f) / 180.0f;
        float cos = ((float) (Math.cos(2.0d + hue) + 3.8d)) * 0.25f;
        float aw = viewingConditions.getAw() * ((float) Math.pow(getJ() / 100.0d, (1.0d / viewingConditions.getC()) / viewingConditions.getZ()));
        float nc = cos * 3846.1538f * viewingConditions.getNc() * viewingConditions.getNcb();
        float nbb = aw / viewingConditions.getNbb();
        float sin = (float) Math.sin(hue);
        float cos2 = (float) Math.cos(hue);
        float f5 = (((0.305f + nbb) * 23.0f) * pow) / (((nc * 23.0f) + ((11.0f * pow) * cos2)) + ((pow * 108.0f) * sin));
        float f6 = cos2 * f5;
        float f7 = f5 * sin;
        float f8 = nbb * 460.0f;
        float f9 = (((451.0f * f6) + f8) + (288.0f * f7)) / 1403.0f;
        float f10 = ((f8 - (891.0f * f6)) - (261.0f * f7)) / 1403.0f;
        float signum = Math.signum(f9) * (100.0f / viewingConditions.getFl()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f9) * 27.13d) / (400.0d - Math.abs(f9))), 2.380952380952381d));
        float signum2 = Math.signum(f10) * (100.0f / viewingConditions.getFl()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f10) * 27.13d) / (400.0d - Math.abs(f10))), 2.380952380952381d));
        float signum3 = Math.signum(((f8 - (f6 * 220.0f)) - (f7 * 6300.0f)) / 1403.0f) * (100.0f / viewingConditions.getFl()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(r8) * 27.13d) / (400.0d - Math.abs(r8))), 2.380952380952381d));
        float f11 = signum / viewingConditions.getRgbD()[0];
        float f12 = signum2 / viewingConditions.getRgbD()[1];
        float f13 = signum3 / viewingConditions.getRgbD()[2];
        float[][] fArr = CamUtils.CAM16RGB_TO_XYZ;
        float[] fArr2 = fArr[0];
        float f14 = (fArr2[0] * f11) + (fArr2[1] * f12) + (fArr2[2] * f13);
        float[] fArr3 = fArr[1];
        float f15 = (fArr3[0] * f11) + (fArr3[1] * f12) + (fArr3[2] * f13);
        float[] fArr4 = fArr[2];
        return ColorUtils.XYZToColor(f14, f15, (f11 * fArr4[0]) + (f12 * fArr4[1]) + (f13 * fArr4[2]));
    }

    int viewedInSrgb() {
        return viewed(ViewingConditions.DEFAULT);
    }

    static int toColor(float f5, float f6, float f7, ViewingConditions viewingConditions) {
        if (f6 >= 1.0d && Math.round(f7) > 0.0d && Math.round(f7) < 100.0d) {
            float min = f5 < 0.0f ? 0.0f : Math.min(360.0f, f5);
            CamColor camColor = null;
            boolean z5 = true;
            float f8 = 0.0f;
            float f9 = f6;
            while (Math.abs(f8 - f6) >= CHROMA_SEARCH_ENDPOINT) {
                CamColor findCamByJ = findCamByJ(min, f9, f7);
                if (!z5) {
                    if (findCamByJ == null) {
                        f6 = f9;
                    } else {
                        f8 = f9;
                        camColor = findCamByJ;
                    }
                    f9 = ((f6 - f8) / 2.0f) + f8;
                } else {
                    if (findCamByJ != null) {
                        return findCamByJ.viewed(viewingConditions);
                    }
                    f9 = ((f6 - f8) / 2.0f) + f8;
                    z5 = false;
                }
            }
            if (camColor == null) {
                return CamUtils.intFromLStar(f7);
            }
            return camColor.viewed(viewingConditions);
        }
        return CamUtils.intFromLStar(f7);
    }
}
