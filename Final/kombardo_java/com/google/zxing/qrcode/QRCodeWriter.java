package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import java.util.Map;

/* loaded from: classes2.dex */
public final class QRCodeWriter implements Writer {
    private static final int QUIET_ZONE_SIZE = 4;

    private static BitMatrix renderResult(QRCode qRCode, int i5, int i6, int i7) {
        ByteMatrix matrix = qRCode.getMatrix();
        if (matrix == null) {
            throw new IllegalStateException();
        }
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        int i8 = i7 << 1;
        int i9 = width + i8;
        int i10 = i8 + height;
        int max = Math.max(i5, i9);
        int max2 = Math.max(i6, i10);
        int min = Math.min(max / i9, max2 / i10);
        int i11 = (max - (width * min)) / 2;
        int i12 = (max2 - (height * min)) / 2;
        BitMatrix bitMatrix = new BitMatrix(max, max2);
        int i13 = 0;
        while (i13 < height) {
            int i14 = 0;
            int i15 = i11;
            while (i14 < width) {
                if (matrix.get(i14, i13) == 1) {
                    bitMatrix.setRegion(i15, i12, min, min);
                }
                i14++;
                i15 += min;
            }
            i13++;
            i12 += min;
        }
        return bitMatrix;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i5, int i6, Map<EncodeHintType, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(barcodeFormat)));
        }
        if (i5 < 0 || i6 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i5 + 'x' + i6);
        }
        ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.L;
        int i7 = 4;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.ERROR_CORRECTION;
            if (map.containsKey(encodeHintType)) {
                errorCorrectionLevel = ErrorCorrectionLevel.valueOf(map.get(encodeHintType).toString());
            }
            EncodeHintType encodeHintType2 = EncodeHintType.MARGIN;
            if (map.containsKey(encodeHintType2)) {
                i7 = Integer.parseInt(map.get(encodeHintType2).toString());
            }
        }
        return renderResult(Encoder.encode(str, errorCorrectionLevel, map), i5, i6, i7);
    }
}
