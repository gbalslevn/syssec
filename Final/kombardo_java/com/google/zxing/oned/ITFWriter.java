package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* loaded from: classes2.dex */
public final class ITFWriter extends OneDimensionalCodeWriter {

    /* renamed from: N, reason: collision with root package name */
    private static final int f4510N = 1;

    /* renamed from: W, reason: collision with root package name */
    private static final int f4511W = 3;
    private static final int[] START_PATTERN = {1, 1, 1, 1};
    private static final int[] END_PATTERN = {3, 1, 1};
    private static final int[][] PATTERNS = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i5, int i6, Map<EncodeHintType, ?> map) {
        if (barcodeFormat == BarcodeFormat.ITF) {
            return super.encode(str, barcodeFormat, i5, i6, map);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        }
        if (length <= 80) {
            boolean[] zArr = new boolean[(length * 9) + 9];
            int appendPattern = OneDimensionalCodeWriter.appendPattern(zArr, 0, START_PATTERN, true);
            for (int i5 = 0; i5 < length; i5 += 2) {
                int digit = Character.digit(str.charAt(i5), 10);
                int digit2 = Character.digit(str.charAt(i5 + 1), 10);
                int[] iArr = new int[10];
                for (int i6 = 0; i6 < 5; i6++) {
                    int i7 = i6 * 2;
                    int[][] iArr2 = PATTERNS;
                    iArr[i7] = iArr2[digit][i6];
                    iArr[i7 + 1] = iArr2[digit2][i6];
                }
                appendPattern += OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, iArr, true);
            }
            OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, END_PATTERN, true);
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
    }
}
