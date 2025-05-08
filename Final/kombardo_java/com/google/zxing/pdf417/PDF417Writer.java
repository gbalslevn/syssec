package com.google.zxing.pdf417;

import android.support.v4.media.session.a;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.encoder.Compaction;
import com.google.zxing.pdf417.encoder.PDF417;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

/* loaded from: classes2.dex */
public final class PDF417Writer implements Writer {
    private static final int DEFAULT_ERROR_CORRECTION_LEVEL = 2;
    private static final int WHITE_SPACE = 30;

    private static BitMatrix bitMatrixFromBitArray(byte[][] bArr, int i5) {
        int i6 = i5 * 2;
        BitMatrix bitMatrix = new BitMatrix(bArr[0].length + i6, bArr.length + i6);
        bitMatrix.clear();
        int height = (bitMatrix.getHeight() - i5) - 1;
        int i7 = 0;
        while (i7 < bArr.length) {
            byte[] bArr2 = bArr[i7];
            for (int i8 = 0; i8 < bArr[0].length; i8++) {
                if (bArr2[i8] == 1) {
                    bitMatrix.set(i8 + i5, height);
                }
            }
            i7++;
            height--;
        }
        return bitMatrix;
    }

    private static BitMatrix bitMatrixFromEncoder(PDF417 pdf417, String str, int i5, int i6, int i7, int i8) {
        boolean z5;
        pdf417.generateBarcodeLogic(str, i5);
        byte[][] scaledMatrix = pdf417.getBarcodeMatrix().getScaledMatrix(1, 4);
        if ((i7 > i6) != (scaledMatrix[0].length < scaledMatrix.length)) {
            scaledMatrix = rotateArray(scaledMatrix);
            z5 = true;
        } else {
            z5 = false;
        }
        int length = i6 / scaledMatrix[0].length;
        int length2 = i7 / scaledMatrix.length;
        if (length >= length2) {
            length = length2;
        }
        if (length <= 1) {
            return bitMatrixFromBitArray(scaledMatrix, i8);
        }
        byte[][] scaledMatrix2 = pdf417.getBarcodeMatrix().getScaledMatrix(length, length << 2);
        if (z5) {
            scaledMatrix2 = rotateArray(scaledMatrix2);
        }
        return bitMatrixFromBitArray(scaledMatrix2, i8);
    }

    private static byte[][] rotateArray(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, bArr[0].length, bArr.length);
        for (int i5 = 0; i5 < bArr.length; i5++) {
            int length = (bArr.length - i5) - 1;
            for (int i6 = 0; i6 < bArr[0].length; i6++) {
                bArr2[i6][length] = bArr[i5][i6];
            }
        }
        return bArr2;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i5, int i6, Map<EncodeHintType, ?> map) {
        if (barcodeFormat != BarcodeFormat.PDF_417) {
            throw new IllegalArgumentException("Can only encode PDF_417, but got ".concat(String.valueOf(barcodeFormat)));
        }
        PDF417 pdf417 = new PDF417();
        int i7 = WHITE_SPACE;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.PDF417_COMPACT;
            if (map.containsKey(encodeHintType)) {
                pdf417.setCompact(Boolean.valueOf(map.get(encodeHintType).toString()).booleanValue());
            }
            EncodeHintType encodeHintType2 = EncodeHintType.PDF417_COMPACTION;
            if (map.containsKey(encodeHintType2)) {
                pdf417.setCompaction(Compaction.valueOf(map.get(encodeHintType2).toString()));
            }
            EncodeHintType encodeHintType3 = EncodeHintType.PDF417_DIMENSIONS;
            if (map.containsKey(encodeHintType3)) {
                a.a(map.get(encodeHintType3));
                throw null;
            }
            EncodeHintType encodeHintType4 = EncodeHintType.MARGIN;
            if (map.containsKey(encodeHintType4)) {
                i7 = Integer.parseInt(map.get(encodeHintType4).toString());
            }
            EncodeHintType encodeHintType5 = EncodeHintType.ERROR_CORRECTION;
            r0 = map.containsKey(encodeHintType5) ? Integer.parseInt(map.get(encodeHintType5).toString()) : 2;
            EncodeHintType encodeHintType6 = EncodeHintType.CHARACTER_SET;
            if (map.containsKey(encodeHintType6)) {
                pdf417.setEncoding(Charset.forName(map.get(encodeHintType6).toString()));
            }
        }
        return bitMatrixFromEncoder(pdf417, str, r0, i5, i6, i7);
    }
}
