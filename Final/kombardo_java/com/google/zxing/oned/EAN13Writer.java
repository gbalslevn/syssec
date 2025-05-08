package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* loaded from: classes2.dex */
public final class EAN13Writer extends UPCEANWriter {
    private static final int CODE_WIDTH = 95;

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i5, int i6, Map<EncodeHintType, ?> map) {
        if (barcodeFormat == BarcodeFormat.EAN_13) {
            return super.encode(str, barcodeFormat, i5, i6, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length == 12) {
            try {
                str = str + UPCEANReader.getStandardUPCEANChecksum(str);
            } catch (FormatException e5) {
                throw new IllegalArgumentException(e5);
            }
        } else if (length == 13) {
            try {
                if (!UPCEANReader.checkStandardUPCEANChecksum(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got ".concat(String.valueOf(length)));
        }
        int i5 = EAN13Reader.FIRST_DIGIT_ENCODINGS[Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[CODE_WIDTH];
        int appendPattern = OneDimensionalCodeWriter.appendPattern(zArr, 0, UPCEANReader.START_END_PATTERN, true);
        for (int i6 = 1; i6 <= 6; i6++) {
            int digit = Character.digit(str.charAt(i6), 10);
            if (((i5 >> (6 - i6)) & 1) == 1) {
                digit += 10;
            }
            appendPattern += OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, UPCEANReader.L_AND_G_PATTERNS[digit], false);
        }
        int appendPattern2 = appendPattern + OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, UPCEANReader.MIDDLE_PATTERN, false);
        for (int i7 = 7; i7 <= 12; i7++) {
            appendPattern2 += OneDimensionalCodeWriter.appendPattern(zArr, appendPattern2, UPCEANReader.L_PATTERNS[Character.digit(str.charAt(i7), 10)], true);
        }
        OneDimensionalCodeWriter.appendPattern(zArr, appendPattern2, UPCEANReader.START_END_PATTERN, true);
        return zArr;
    }
}
