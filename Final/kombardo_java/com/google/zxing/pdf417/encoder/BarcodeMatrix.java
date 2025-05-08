package com.google.zxing.pdf417.encoder;

import java.lang.reflect.Array;

/* loaded from: classes2.dex */
public final class BarcodeMatrix {
    private int currentRow;
    private final int height;
    private final BarcodeRow[] matrix;
    private final int width;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BarcodeMatrix(int i5, int i6) {
        BarcodeRow[] barcodeRowArr = new BarcodeRow[i5];
        this.matrix = barcodeRowArr;
        int length = barcodeRowArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            this.matrix[i7] = new BarcodeRow(((i6 + 4) * 17) + 1);
        }
        this.width = i6 * 17;
        this.height = i5;
        this.currentRow = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BarcodeRow getCurrentRow() {
        return this.matrix[this.currentRow];
    }

    public byte[][] getScaledMatrix(int i5, int i6) {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, this.height * i6, this.width * i5);
        int i7 = this.height * i6;
        for (int i8 = 0; i8 < i7; i8++) {
            bArr[(i7 - i8) - 1] = this.matrix[i8 / i6].getScaledRow(i5);
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startRow() {
        this.currentRow++;
    }
}
