package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* loaded from: classes2.dex */
public final class UPCEWriter extends UPCEANWriter {
    private static final int CODE_WIDTH = 51;

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i5, int i6, Map<EncodeHintType, ?> map) {
        if (barcodeFormat == BarcodeFormat.UPC_E) {
            return super.encode(str, barcodeFormat, i5, i6, map);
        }
        throw new IllegalArgumentException("Can only encode UPC_E, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + UPCEANReader.getStandardUPCEANChecksum(UPCEReader.convertUPCEtoUPCA(str));
            } catch (FormatException e5) {
                throw new IllegalArgumentException(e5);
            }
        } else if (length == 8) {
            try {
                if (!UPCEANReader.checkStandardUPCEANChecksum(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 8 digits long, but got ".concat(String.valueOf(length)));
        }
        int digit = Character.digit(str.charAt(0), 10);
        if (digit != 0 && digit != 1) {
            throw new IllegalArgumentException("Number system must be 0 or 1");
        }
        int i5 = UPCEReader.NUMSYS_AND_CHECK_DIGIT_PATTERNS[digit][Character.digit(str.charAt(7), 10)];
        boolean[] zArr = new boolean[CODE_WIDTH];
        int appendPattern = OneDimensionalCodeWriter.appendPattern(zArr, 0, UPCEANReader.START_END_PATTERN, true);
        for (int i6 = 1; i6 <= 6; i6++) {
            int digit2 = Character.digit(str.charAt(i6), 10);
            if (((i5 >> (6 - i6)) & 1) == 1) {
                digit2 += 10;
            }
            appendPattern += OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, UPCEANReader.L_AND_G_PATTERNS[digit2], false);
        }
        OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, UPCEANReader.END_PATTERN, false);
        return zArr;
    }
}
