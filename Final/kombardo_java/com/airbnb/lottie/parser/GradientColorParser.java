package com.airbnb.lottie.parser;

import android.graphics.Color;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class GradientColorParser implements ValueParser<GradientColor> {
    private int colorPoints;

    public GradientColorParser(int i5) {
        this.colorPoints = i5;
    }

    private GradientColor addOpacityStopsToGradientIfNeeded(GradientColor gradientColor, List<Float> list) {
        int i5 = this.colorPoints * 4;
        if (list.size() <= i5) {
            return gradientColor;
        }
        float[] positions = gradientColor.getPositions();
        int[] colors = gradientColor.getColors();
        int size = (list.size() - i5) / 2;
        float[] fArr = new float[size];
        float[] fArr2 = new float[size];
        int i6 = 0;
        while (i5 < list.size()) {
            if (i5 % 2 == 0) {
                fArr[i6] = list.get(i5).floatValue();
            } else {
                fArr2[i6] = list.get(i5).floatValue();
                i6++;
            }
            i5++;
        }
        float[] mergeUniqueElements = mergeUniqueElements(gradientColor.getPositions(), fArr);
        int length = mergeUniqueElements.length;
        int[] iArr = new int[length];
        for (int i7 = 0; i7 < length; i7++) {
            float f5 = mergeUniqueElements[i7];
            int binarySearch = Arrays.binarySearch(positions, f5);
            int binarySearch2 = Arrays.binarySearch(fArr, f5);
            if (binarySearch < 0 || binarySearch2 > 0) {
                if (binarySearch2 < 0) {
                    binarySearch2 = -(binarySearch2 + 1);
                }
                iArr[i7] = getColorInBetweenColorStops(f5, fArr2[binarySearch2], positions, colors);
            } else {
                iArr[i7] = getColorInBetweenOpacityStops(f5, colors[binarySearch], fArr, fArr2);
            }
        }
        return new GradientColor(mergeUniqueElements, iArr);
    }

    private int getColorInBetweenOpacityStops(float f5, int i5, float[] fArr, float[] fArr2) {
        float lerp;
        if (fArr2.length < 2 || f5 <= fArr[0]) {
            return Color.argb((int) (fArr2[0] * 255.0f), Color.red(i5), Color.green(i5), Color.blue(i5));
        }
        for (int i6 = 1; i6 < fArr.length; i6++) {
            float f6 = fArr[i6];
            if (f6 >= f5 || i6 == fArr.length - 1) {
                if (f6 <= f5) {
                    lerp = fArr2[i6];
                } else {
                    int i7 = i6 - 1;
                    float f7 = fArr[i7];
                    lerp = MiscUtils.lerp(fArr2[i7], fArr2[i6], (f5 - f7) / (f6 - f7));
                }
                return Color.argb((int) (lerp * 255.0f), Color.red(i5), Color.green(i5), Color.blue(i5));
            }
        }
        throw new IllegalArgumentException("Unreachable code.");
    }

    protected static float[] mergeUniqueElements(float[] fArr, float[] fArr2) {
        if (fArr.length == 0) {
            return fArr2;
        }
        if (fArr2.length == 0) {
            return fArr;
        }
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            float f5 = i6 < fArr.length ? fArr[i6] : Float.NaN;
            float f6 = i7 < fArr2.length ? fArr2[i7] : Float.NaN;
            if (Float.isNaN(f6) || f5 < f6) {
                fArr3[i8] = f5;
                i6++;
            } else if (Float.isNaN(f5) || f6 < f5) {
                fArr3[i8] = f6;
                i7++;
            } else {
                fArr3[i8] = f5;
                i6++;
                i7++;
                i5++;
            }
        }
        return i5 == 0 ? fArr3 : Arrays.copyOf(fArr3, length - i5);
    }

    int getColorInBetweenColorStops(float f5, float f6, float[] fArr, int[] iArr) {
        if (iArr.length < 2 || f5 == fArr[0]) {
            return iArr[0];
        }
        for (int i5 = 1; i5 < fArr.length; i5++) {
            float f7 = fArr[i5];
            if (f7 >= f5 || i5 == fArr.length - 1) {
                int i6 = i5 - 1;
                float f8 = fArr[i6];
                float f9 = (f5 - f8) / (f7 - f8);
                int i7 = iArr[i5];
                int i8 = iArr[i6];
                return Color.argb((int) (f6 * 255.0f), GammaEvaluator.evaluate(f9, Color.red(i8), Color.red(i7)), GammaEvaluator.evaluate(f9, Color.green(i8), Color.green(i7)), GammaEvaluator.evaluate(f9, Color.blue(i8), Color.blue(i7)));
            }
        }
        throw new IllegalArgumentException("Unreachable code.");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public GradientColor parse(JsonReader jsonReader, float f5) {
        ArrayList arrayList = new ArrayList();
        boolean z5 = jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY;
        if (z5) {
            jsonReader.beginArray();
        }
        while (jsonReader.hasNext()) {
            arrayList.add(Float.valueOf((float) jsonReader.nextDouble()));
        }
        if (arrayList.size() == 4 && arrayList.get(0).floatValue() == 1.0f) {
            arrayList.set(0, Float.valueOf(0.0f));
            arrayList.add(Float.valueOf(1.0f));
            arrayList.add(arrayList.get(1));
            arrayList.add(arrayList.get(2));
            arrayList.add(arrayList.get(3));
            this.colorPoints = 2;
        }
        if (z5) {
            jsonReader.endArray();
        }
        if (this.colorPoints == -1) {
            this.colorPoints = arrayList.size() / 4;
        }
        int i5 = this.colorPoints;
        float[] fArr = new float[i5];
        int[] iArr = new int[i5];
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < this.colorPoints * 4; i8++) {
            int i9 = i8 / 4;
            double floatValue = arrayList.get(i8).floatValue();
            int i10 = i8 % 4;
            if (i10 == 0) {
                if (i9 > 0) {
                    float f6 = (float) floatValue;
                    if (fArr[i9 - 1] >= f6) {
                        fArr[i9] = f6 + 0.01f;
                    }
                }
                fArr[i9] = (float) floatValue;
            } else if (i10 == 1) {
                i6 = (int) (floatValue * 255.0d);
            } else if (i10 == 2) {
                i7 = (int) (floatValue * 255.0d);
            } else if (i10 == 3) {
                iArr[i9] = Color.argb(Function.USE_VARARGS, i6, i7, (int) (floatValue * 255.0d));
            }
        }
        return addOpacityStopsToGradientIfNeeded(new GradientColor(fArr, iArr), arrayList);
    }
}
