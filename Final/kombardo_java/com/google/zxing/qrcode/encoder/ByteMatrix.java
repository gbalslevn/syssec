package com.google.zxing.qrcode.encoder;

import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class ByteMatrix {
    private final byte[][] bytes;
    private final int height;
    private final int width;

    public ByteMatrix(int i5, int i6) {
        this.bytes = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i6, i5);
        this.width = i5;
        this.height = i6;
    }

    public void clear(byte b5) {
        for (byte[] bArr : this.bytes) {
            Arrays.fill(bArr, b5);
        }
    }

    public byte get(int i5, int i6) {
        return this.bytes[i6][i5];
    }

    public byte[][] getArray() {
        return this.bytes;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void set(int i5, int i6, int i7) {
        this.bytes[i6][i5] = (byte) i7;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.width * 2 * this.height) + 2);
        for (int i5 = 0; i5 < this.height; i5++) {
            byte[] bArr = this.bytes[i5];
            for (int i6 = 0; i6 < this.width; i6++) {
                byte b5 = bArr[i6];
                if (b5 == 0) {
                    sb.append(" 0");
                } else if (b5 != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public void set(int i5, int i6, boolean z5) {
        this.bytes[i6][i5] = z5 ? (byte) 1 : (byte) 0;
    }
}
