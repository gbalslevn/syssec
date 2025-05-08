package com.google.zxing.common;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class BitArray implements Cloneable {
    private int[] bits;
    private int size;

    public BitArray() {
        this.size = 0;
        this.bits = new int[1];
    }

    private void ensureCapacity(int i5) {
        if (i5 > (this.bits.length << 5)) {
            int[] makeArray = makeArray(i5);
            int[] iArr = this.bits;
            System.arraycopy(iArr, 0, makeArray, 0, iArr.length);
            this.bits = makeArray;
        }
    }

    private static int[] makeArray(int i5) {
        return new int[(i5 + 31) / 32];
    }

    public void appendBit(boolean z5) {
        ensureCapacity(this.size + 1);
        if (z5) {
            int[] iArr = this.bits;
            int i5 = this.size;
            int i6 = i5 / 32;
            iArr[i6] = (1 << (i5 & 31)) | iArr[i6];
        }
        this.size++;
    }

    public void appendBitArray(BitArray bitArray) {
        int i5 = bitArray.size;
        ensureCapacity(this.size + i5);
        for (int i6 = 0; i6 < i5; i6++) {
            appendBit(bitArray.get(i6));
        }
    }

    public void appendBits(int i5, int i6) {
        if (i6 < 0 || i6 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        ensureCapacity(this.size + i6);
        while (i6 > 0) {
            boolean z5 = true;
            if (((i5 >> (i6 - 1)) & 1) != 1) {
                z5 = false;
            }
            appendBit(z5);
            i6--;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitArray)) {
            return false;
        }
        BitArray bitArray = (BitArray) obj;
        return this.size == bitArray.size && Arrays.equals(this.bits, bitArray.bits);
    }

    public boolean get(int i5) {
        return ((1 << (i5 & 31)) & this.bits[i5 / 32]) != 0;
    }

    public int getSize() {
        return this.size;
    }

    public int getSizeInBytes() {
        return (this.size + 7) / 8;
    }

    public int hashCode() {
        return (this.size * 31) + Arrays.hashCode(this.bits);
    }

    public void toBytes(int i5, byte[] bArr, int i6, int i7) {
        for (int i8 = 0; i8 < i7; i8++) {
            int i9 = 0;
            for (int i10 = 0; i10 < 8; i10++) {
                if (get(i5)) {
                    i9 |= 1 << (7 - i10);
                }
                i5++;
            }
            bArr[i6 + i8] = (byte) i9;
        }
    }

    public String toString() {
        int i5 = this.size;
        StringBuilder sb = new StringBuilder(i5 + (i5 / 8) + 1);
        for (int i6 = 0; i6 < this.size; i6++) {
            if ((i6 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(get(i6) ? 'X' : '.');
        }
        return sb.toString();
    }

    public void xor(BitArray bitArray) {
        if (this.size != bitArray.size) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i5 = 0;
        while (true) {
            int[] iArr = this.bits;
            if (i5 >= iArr.length) {
                return;
            }
            iArr[i5] = iArr[i5] ^ bitArray.bits[i5];
            i5++;
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BitArray m2923clone() {
        return new BitArray((int[]) this.bits.clone(), this.size);
    }

    BitArray(int[] iArr, int i5) {
        this.bits = iArr;
        this.size = i5;
    }
}
