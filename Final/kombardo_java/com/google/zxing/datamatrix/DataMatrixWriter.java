package com.google.zxing.datamatrix;

import android.support.v4.media.session.a;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.encoder.DefaultPlacement;
import com.google.zxing.datamatrix.encoder.ErrorCorrection;
import com.google.zxing.datamatrix.encoder.HighLevelEncoder;
import com.google.zxing.datamatrix.encoder.SymbolInfo;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import java.util.Map;

/* loaded from: classes2.dex */
public final class DataMatrixWriter implements Writer {
    private static BitMatrix convertByteMatrixToBitMatrix(ByteMatrix byteMatrix, int i5, int i6) {
        BitMatrix bitMatrix;
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int max = Math.max(i5, width);
        int max2 = Math.max(i6, height);
        int min = Math.min(max / width, max2 / height);
        int i7 = (max - (width * min)) / 2;
        int i8 = (max2 - (height * min)) / 2;
        if (i6 < height || i5 < width) {
            bitMatrix = new BitMatrix(width, height);
            i7 = 0;
            i8 = 0;
        } else {
            bitMatrix = new BitMatrix(i5, i6);
        }
        bitMatrix.clear();
        int i9 = 0;
        while (i9 < height) {
            int i10 = i7;
            int i11 = 0;
            while (i11 < width) {
                if (byteMatrix.get(i11, i9) == 1) {
                    bitMatrix.setRegion(i10, i8, min, min);
                }
                i11++;
                i10 += min;
            }
            i9++;
            i8 += min;
        }
        return bitMatrix;
    }

    private static BitMatrix encodeLowLevel(DefaultPlacement defaultPlacement, SymbolInfo symbolInfo, int i5, int i6) {
        int symbolDataWidth = symbolInfo.getSymbolDataWidth();
        int symbolDataHeight = symbolInfo.getSymbolDataHeight();
        ByteMatrix byteMatrix = new ByteMatrix(symbolInfo.getSymbolWidth(), symbolInfo.getSymbolHeight());
        int i7 = 0;
        for (int i8 = 0; i8 < symbolDataHeight; i8++) {
            if (i8 % symbolInfo.matrixHeight == 0) {
                int i9 = 0;
                for (int i10 = 0; i10 < symbolInfo.getSymbolWidth(); i10++) {
                    byteMatrix.set(i9, i7, i10 % 2 == 0);
                    i9++;
                }
                i7++;
            }
            int i11 = 0;
            for (int i12 = 0; i12 < symbolDataWidth; i12++) {
                if (i12 % symbolInfo.matrixWidth == 0) {
                    byteMatrix.set(i11, i7, true);
                    i11++;
                }
                byteMatrix.set(i11, i7, defaultPlacement.getBit(i12, i8));
                int i13 = i11 + 1;
                int i14 = symbolInfo.matrixWidth;
                if (i12 % i14 == i14 - 1) {
                    byteMatrix.set(i13, i7, i8 % 2 == 0);
                    i11 += 2;
                } else {
                    i11 = i13;
                }
            }
            int i15 = i7 + 1;
            int i16 = symbolInfo.matrixHeight;
            if (i8 % i16 == i16 - 1) {
                int i17 = 0;
                for (int i18 = 0; i18 < symbolInfo.getSymbolWidth(); i18++) {
                    byteMatrix.set(i17, i15, true);
                    i17++;
                }
                i7 += 2;
            } else {
                i7 = i15;
            }
        }
        return convertByteMatrixToBitMatrix(byteMatrix, i5, i6);
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i5, int i6, Map<EncodeHintType, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(String.valueOf(barcodeFormat)));
        }
        if (i5 < 0 || i6 < 0) {
            throw new IllegalArgumentException("Requested dimensions can't be negative: " + i5 + 'x' + i6);
        }
        SymbolShapeHint symbolShapeHint = SymbolShapeHint.FORCE_NONE;
        if (map != null) {
            SymbolShapeHint symbolShapeHint2 = (SymbolShapeHint) map.get(EncodeHintType.DATA_MATRIX_SHAPE);
            if (symbolShapeHint2 != null) {
                symbolShapeHint = symbolShapeHint2;
            }
            a.a(map.get(EncodeHintType.MIN_SIZE));
            a.a(map.get(EncodeHintType.MAX_SIZE));
        }
        String encodeHighLevel = HighLevelEncoder.encodeHighLevel(str, symbolShapeHint, null, null);
        SymbolInfo lookup = SymbolInfo.lookup(encodeHighLevel.length(), symbolShapeHint, null, null, true);
        DefaultPlacement defaultPlacement = new DefaultPlacement(ErrorCorrection.encodeECC200(encodeHighLevel, lookup), lookup.getSymbolDataWidth(), lookup.getSymbolDataHeight());
        defaultPlacement.place();
        return encodeLowLevel(defaultPlacement, lookup, i5, i6);
    }
}
