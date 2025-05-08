package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class OneDimensionalCodeWriter implements Writer {
    /* JADX INFO: Access modifiers changed from: protected */
    public static int appendPattern(boolean[] zArr, int i5, int[] iArr, boolean z5) {
        int i6 = 0;
        for (int i7 : iArr) {
            int i8 = 0;
            while (i8 < i7) {
                zArr[i5] = z5;
                i8++;
                i5++;
            }
            i6 += i7;
            z5 = !z5;
        }
        return i6;
    }

    private static BitMatrix renderResult(boolean[] zArr, int i5, int i6, int i7) {
        int length = zArr.length;
        int i8 = i7 + length;
        int max = Math.max(i5, i8);
        int max2 = Math.max(1, i6);
        int i9 = max / i8;
        int i10 = (max - (length * i9)) / 2;
        BitMatrix bitMatrix = new BitMatrix(max, max2);
        int i11 = 0;
        while (i11 < length) {
            if (zArr[i11]) {
                bitMatrix.setRegion(i10, 0, i9, max2);
            }
            i11++;
            i10 += i9;
        }
        return bitMatrix;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i5, int i6, Map<EncodeHintType, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i5 >= 0 && i6 >= 0) {
            int defaultMargin = getDefaultMargin();
            if (map != null) {
                EncodeHintType encodeHintType = EncodeHintType.MARGIN;
                if (map.containsKey(encodeHintType)) {
                    defaultMargin = Integer.parseInt(map.get(encodeHintType).toString());
                }
            }
            return renderResult(encode(str), i5, i6, defaultMargin);
        }
        throw new IllegalArgumentException("Negative size is not allowed. Input: " + i5 + 'x' + i6);
    }

    public abstract boolean[] encode(String str);

    public int getDefaultMargin() {
        return 10;
    }
}
