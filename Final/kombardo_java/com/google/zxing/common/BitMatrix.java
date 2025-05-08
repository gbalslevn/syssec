package com.google.zxing.common;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class BitMatrix implements Cloneable {
    private final int[] bits;
    private final int height;
    private final int rowSize;
    private final int width;

    public BitMatrix(int i5) {
        this(i5, i5);
    }

    private String buildToString(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.height * (this.width + 1));
        for (int i5 = 0; i5 < this.height; i5++) {
            for (int i6 = 0; i6 < this.width; i6++) {
                sb.append(get(i6, i5) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    public void clear() {
        int length = this.bits.length;
        for (int i5 = 0; i5 < length; i5++) {
            this.bits[i5] = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitMatrix)) {
            return false;
        }
        BitMatrix bitMatrix = (BitMatrix) obj;
        return this.width == bitMatrix.width && this.height == bitMatrix.height && this.rowSize == bitMatrix.rowSize && Arrays.equals(this.bits, bitMatrix.bits);
    }

    public boolean get(int i5, int i6) {
        return ((this.bits[(i6 * this.rowSize) + (i5 / 32)] >>> (i5 & 31)) & 1) != 0;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int i5 = this.width;
        return (((((((i5 * 31) + i5) * 31) + this.height) * 31) + this.rowSize) * 31) + Arrays.hashCode(this.bits);
    }

    public void set(int i5, int i6) {
        int i7 = (i6 * this.rowSize) + (i5 / 32);
        int[] iArr = this.bits;
        iArr[i7] = (1 << (i5 & 31)) | iArr[i7];
    }

    public void setRegion(int i5, int i6, int i7, int i8) {
        if (i6 < 0 || i5 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i8 <= 0 || i7 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i9 = i7 + i5;
        int i10 = i8 + i6;
        if (i10 > this.height || i9 > this.width) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i6 < i10) {
            int i11 = this.rowSize * i6;
            for (int i12 = i5; i12 < i9; i12++) {
                int[] iArr = this.bits;
                int i13 = (i12 / 32) + i11;
                iArr[i13] = iArr[i13] | (1 << (i12 & 31));
            }
            i6++;
        }
    }

    public String toString() {
        return toString("X ", "  ");
    }

    public BitMatrix(int i5, int i6) {
        if (i5 > 0 && i6 > 0) {
            this.width = i5;
            this.height = i6;
            int i7 = (i5 + 31) / 32;
            this.rowSize = i7;
            this.bits = new int[i7 * i6];
            return;
        }
        throw new IllegalArgumentException("Both dimensions must be greater than 0");
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BitMatrix m2924clone() {
        return new BitMatrix(this.width, this.height, this.rowSize, (int[]) this.bits.clone());
    }

    public String toString(String str, String str2) {
        return buildToString(str, str2, "\n");
    }

    private BitMatrix(int i5, int i6, int i7, int[] iArr) {
        this.width = i5;
        this.height = i6;
        this.rowSize = i7;
        this.bits = iArr;
    }
}
