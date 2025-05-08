package com.google.zxing.aztec;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.aztec.encoder.AztecCode;
import com.google.zxing.aztec.encoder.Encoder;
import com.google.zxing.common.BitMatrix;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* loaded from: classes2.dex */
public final class AztecWriter implements Writer {
    private static BitMatrix renderResult(AztecCode aztecCode, int i5, int i6) {
        BitMatrix matrix = aztecCode.getMatrix();
        if (matrix == null) {
            throw new IllegalStateException();
        }
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        int max = Math.max(i5, width);
        int max2 = Math.max(i6, height);
        int min = Math.min(max / width, max2 / height);
        int i7 = (max - (width * min)) / 2;
        int i8 = (max2 - (height * min)) / 2;
        BitMatrix bitMatrix = new BitMatrix(max, max2);
        int i9 = 0;
        while (i9 < height) {
            int i10 = 0;
            int i11 = i7;
            while (i10 < width) {
                if (matrix.get(i10, i9)) {
                    bitMatrix.setRegion(i11, i8, min, min);
                }
                i10++;
                i11 += min;
            }
            i9++;
            i8 += min;
        }
        return bitMatrix;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i5, int i6, Map<EncodeHintType, ?> map) {
        Charset charset = StandardCharsets.ISO_8859_1;
        int i7 = 0;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.CHARACTER_SET;
            if (map.containsKey(encodeHintType)) {
                charset = Charset.forName(map.get(encodeHintType).toString());
            }
            EncodeHintType encodeHintType2 = EncodeHintType.ERROR_CORRECTION;
            r1 = map.containsKey(encodeHintType2) ? Integer.parseInt(map.get(encodeHintType2).toString()) : 33;
            EncodeHintType encodeHintType3 = EncodeHintType.AZTEC_LAYERS;
            if (map.containsKey(encodeHintType3)) {
                i7 = Integer.parseInt(map.get(encodeHintType3).toString());
            }
        }
        return encode(str, barcodeFormat, i5, i6, charset, r1, i7);
    }

    private static BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i5, int i6, Charset charset, int i7, int i8) {
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            return renderResult(Encoder.encode(str.getBytes(charset), i7, i8), i5, i6);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got ".concat(String.valueOf(barcodeFormat)));
    }
}
