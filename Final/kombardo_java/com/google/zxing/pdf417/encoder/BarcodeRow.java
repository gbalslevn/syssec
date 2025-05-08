package com.google.zxing.pdf417.encoder;

/* loaded from: classes2.dex */
final class BarcodeRow {
    private int currentLocation = 0;
    private final byte[] row;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BarcodeRow(int i5) {
        this.row = new byte[i5];
    }

    private void set(int i5, boolean z5) {
        this.row[i5] = z5 ? (byte) 1 : (byte) 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addBar(boolean z5, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = this.currentLocation;
            this.currentLocation = i7 + 1;
            set(i7, z5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getScaledRow(int i5) {
        int length = this.row.length * i5;
        byte[] bArr = new byte[length];
        for (int i6 = 0; i6 < length; i6++) {
            bArr[i6] = this.row[i6 / i5];
        }
        return bArr;
    }
}
