package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* loaded from: classes2.dex */
public class Code93Writer extends OneDimensionalCodeWriter {
    private static int appendPattern(boolean[] zArr, int i5, int[] iArr) {
        int length = iArr.length;
        int i6 = 0;
        while (i6 < length) {
            int i7 = i5 + 1;
            zArr[i5] = iArr[i6] != 0;
            i6++;
            i5 = i7;
        }
        return 9;
    }

    private static int computeChecksumIndex(String str, int i5) {
        int i6 = 0;
        int i7 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            i6 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i7;
            i7++;
            if (i7 > i5) {
                i7 = 1;
            }
        }
        return i6 % 47;
    }

    private static void toIntArray(int i5, int[] iArr) {
        for (int i6 = 0; i6 < 9; i6++) {
            int i7 = 1;
            if (((1 << (8 - i6)) & i5) == 0) {
                i7 = 0;
            }
            iArr[i6] = i7;
        }
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i5, int i6, Map<EncodeHintType, ?> map) {
        if (barcodeFormat == BarcodeFormat.CODE_93) {
            return super.encode(str, barcodeFormat, i5, i6, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_93, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            int length2 = ((str.length() + 4) * 9) + 1;
            toIntArray(Code93Reader.CHARACTER_ENCODINGS[47], iArr);
            boolean[] zArr = new boolean[length2];
            int appendPattern = appendPattern(zArr, 0, iArr);
            for (int i5 = 0; i5 < length; i5++) {
                toIntArray(Code93Reader.CHARACTER_ENCODINGS["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(i5))], iArr);
                appendPattern += appendPattern(zArr, appendPattern, iArr);
            }
            int computeChecksumIndex = computeChecksumIndex(str, 20);
            int[] iArr2 = Code93Reader.CHARACTER_ENCODINGS;
            toIntArray(iArr2[computeChecksumIndex], iArr);
            int appendPattern2 = appendPattern + appendPattern(zArr, appendPattern, iArr);
            toIntArray(iArr2[computeChecksumIndex(str + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(computeChecksumIndex), 15)], iArr);
            int appendPattern3 = appendPattern2 + appendPattern(zArr, appendPattern2, iArr);
            toIntArray(iArr2[47], iArr);
            zArr[appendPattern3 + appendPattern(zArr, appendPattern3, iArr)] = true;
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
    }
}
