package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;

/* loaded from: classes2.dex */
public abstract class Encoder {
    private static final int MAX_NB_BITS = 32;
    private static final int MAX_NB_BITS_COMPACT = 4;
    private static final int[] WORD_SIZE = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private static int[] bitsToWords(BitArray bitArray, int i5, int i6) {
        int[] iArr = new int[i6];
        int size = bitArray.getSize() / i5;
        for (int i7 = 0; i7 < size; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 |= bitArray.get((i7 * i5) + i9) ? 1 << ((i5 - i9) - 1) : 0;
            }
            iArr[i7] = i8;
        }
        return iArr;
    }

    private static void drawBullsEye(BitMatrix bitMatrix, int i5, int i6) {
        for (int i7 = 0; i7 < i6; i7 += 2) {
            int i8 = i5 - i7;
            int i9 = i8;
            while (true) {
                int i10 = i5 + i7;
                if (i9 <= i10) {
                    bitMatrix.set(i9, i8);
                    bitMatrix.set(i9, i10);
                    bitMatrix.set(i8, i9);
                    bitMatrix.set(i10, i9);
                    i9++;
                }
            }
        }
        int i11 = i5 - i6;
        bitMatrix.set(i11, i11);
        int i12 = i11 + 1;
        bitMatrix.set(i12, i11);
        bitMatrix.set(i11, i12);
        int i13 = i5 + i6;
        bitMatrix.set(i13, i11);
        bitMatrix.set(i13, i12);
        bitMatrix.set(i13, i13 - 1);
    }

    private static void drawModeMessage(BitMatrix bitMatrix, boolean z5, int i5, BitArray bitArray) {
        int i6 = i5 / 2;
        int i7 = 0;
        if (z5) {
            while (i7 < 7) {
                int i8 = (i6 - 3) + i7;
                if (bitArray.get(i7)) {
                    bitMatrix.set(i8, i6 - 5);
                }
                if (bitArray.get(i7 + 7)) {
                    bitMatrix.set(i6 + 5, i8);
                }
                if (bitArray.get(20 - i7)) {
                    bitMatrix.set(i8, i6 + 5);
                }
                if (bitArray.get(27 - i7)) {
                    bitMatrix.set(i6 - 5, i8);
                }
                i7++;
            }
            return;
        }
        while (i7 < 10) {
            int i9 = (i6 - 5) + i7 + (i7 / 5);
            if (bitArray.get(i7)) {
                bitMatrix.set(i9, i6 - 7);
            }
            if (bitArray.get(i7 + 10)) {
                bitMatrix.set(i6 + 7, i9);
            }
            if (bitArray.get(29 - i7)) {
                bitMatrix.set(i9, i6 + 7);
            }
            if (bitArray.get(39 - i7)) {
                bitMatrix.set(i6 - 7, i9);
            }
            i7++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static AztecCode encode(byte[] bArr, int i5, int i6) {
        BitArray bitArray;
        int i7;
        boolean z5;
        int i8;
        int i9;
        int i10;
        BitArray encode = new HighLevelEncoder(bArr).encode();
        int size = ((encode.getSize() * i5) / 100) + 11;
        int size2 = encode.getSize() + size;
        int i11 = 1;
        if (i6 == 0) {
            BitArray bitArray2 = null;
            int i12 = 0;
            int i13 = 0;
            while (i12 <= 32) {
                boolean z6 = i12 <= 3 ? i11 : 0;
                int i14 = z6 != 0 ? i12 + 1 : i12;
                int i15 = totalBitsInLayer(i14, z6);
                if (size2 <= i15) {
                    if (bitArray2 == null || i13 != WORD_SIZE[i14]) {
                        int i16 = WORD_SIZE[i14];
                        i13 = i16;
                        bitArray2 = stuffBits(encode, i16);
                    }
                    int i17 = i15 - (i15 % i13);
                    if ((z6 == 0 || bitArray2.getSize() <= (i13 << 6)) && bitArray2.getSize() + size <= i17) {
                        bitArray = bitArray2;
                        i7 = i13;
                        z5 = z6;
                        i8 = i14;
                        i9 = i15;
                    }
                }
                i12++;
                i11 = i11;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        z5 = i6 < 0;
        i8 = Math.abs(i6);
        if (i8 > (z5 ? 4 : 32)) {
            throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i6)));
        }
        i9 = totalBitsInLayer(i8, z5);
        i7 = WORD_SIZE[i8];
        int i18 = i9 - (i9 % i7);
        bitArray = stuffBits(encode, i7);
        if (bitArray.getSize() + size > i18) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        if (z5 && bitArray.getSize() > (i7 << 6)) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        BitArray generateCheckWords = generateCheckWords(bitArray, i9, i7);
        int size3 = bitArray.getSize() / i7;
        BitArray generateModeMessage = generateModeMessage(z5, i8, size3);
        int i19 = (z5 ? 11 : 14) + (i8 << 2);
        int[] iArr = new int[i19];
        int i20 = 2;
        if (z5) {
            for (int i21 = 0; i21 < i19; i21++) {
                iArr[i21] = i21;
            }
            i10 = i19;
        } else {
            int i22 = i19 / 2;
            i10 = i19 + 1 + (((i22 - 1) / 15) * 2);
            int i23 = i10 / 2;
            for (int i24 = 0; i24 < i22; i24++) {
                iArr[(i22 - i24) - i11] = (i23 - r14) - 1;
                iArr[i22 + i24] = (i24 / 15) + i24 + i23 + i11;
            }
        }
        BitMatrix bitMatrix = new BitMatrix(i10);
        int i25 = 0;
        int i26 = 0;
        while (i25 < i8) {
            int i27 = ((i8 - i25) << i20) + (z5 ? 9 : 12);
            int i28 = 0;
            while (i28 < i27) {
                int i29 = i28 << 1;
                int i30 = 0;
                while (i30 < i20) {
                    if (generateCheckWords.get(i26 + i29 + i30)) {
                        int i31 = i25 << 1;
                        bitMatrix.set(iArr[i31 + i30], iArr[i31 + i28]);
                    }
                    if (generateCheckWords.get((i27 << 1) + i26 + i29 + i30)) {
                        int i32 = i25 << 1;
                        bitMatrix.set(iArr[i32 + i28], iArr[((i19 - 1) - i32) - i30]);
                    }
                    if (generateCheckWords.get((i27 << 2) + i26 + i29 + i30)) {
                        int i33 = (i19 - 1) - (i25 << 1);
                        bitMatrix.set(iArr[i33 - i30], iArr[i33 - i28]);
                    }
                    if (generateCheckWords.get((i27 * 6) + i26 + i29 + i30)) {
                        int i34 = i25 << 1;
                        bitMatrix.set(iArr[((i19 - 1) - i34) - i28], iArr[i34 + i30]);
                    }
                    i30++;
                    i20 = 2;
                }
                i28++;
                i20 = 2;
            }
            i26 += i27 << 3;
            i25++;
            i20 = 2;
        }
        drawModeMessage(bitMatrix, z5, i10, generateModeMessage);
        if (z5) {
            drawBullsEye(bitMatrix, i10 / 2, 5);
        } else {
            int i35 = i10 / 2;
            drawBullsEye(bitMatrix, i35, 7);
            int i36 = 0;
            int i37 = 0;
            while (i37 < (i19 / 2) - 1) {
                for (int i38 = i35 & 1; i38 < i10; i38 += 2) {
                    int i39 = i35 - i36;
                    bitMatrix.set(i39, i38);
                    int i40 = i35 + i36;
                    bitMatrix.set(i40, i38);
                    bitMatrix.set(i38, i39);
                    bitMatrix.set(i38, i40);
                }
                i37 += 15;
                i36 += 16;
            }
        }
        AztecCode aztecCode = new AztecCode();
        aztecCode.setCompact(z5);
        aztecCode.setSize(i10);
        aztecCode.setLayers(i8);
        aztecCode.setCodeWords(size3);
        aztecCode.setMatrix(bitMatrix);
        return aztecCode;
    }

    private static BitArray generateCheckWords(BitArray bitArray, int i5, int i6) {
        int size = bitArray.getSize() / i6;
        ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(getGF(i6));
        int i7 = i5 / i6;
        int[] bitsToWords = bitsToWords(bitArray, i6, i7);
        reedSolomonEncoder.encode(bitsToWords, i7 - size);
        BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(0, i5 % i6);
        for (int i8 : bitsToWords) {
            bitArray2.appendBits(i8, i6);
        }
        return bitArray2;
    }

    static BitArray generateModeMessage(boolean z5, int i5, int i6) {
        BitArray bitArray = new BitArray();
        if (z5) {
            bitArray.appendBits(i5 - 1, 2);
            bitArray.appendBits(i6 - 1, 6);
            return generateCheckWords(bitArray, 28, 4);
        }
        bitArray.appendBits(i5 - 1, 5);
        bitArray.appendBits(i6 - 1, 11);
        return generateCheckWords(bitArray, 40, 4);
    }

    private static GenericGF getGF(int i5) {
        if (i5 == 4) {
            return GenericGF.AZTEC_PARAM;
        }
        if (i5 == 6) {
            return GenericGF.AZTEC_DATA_6;
        }
        if (i5 == 8) {
            return GenericGF.AZTEC_DATA_8;
        }
        if (i5 == 10) {
            return GenericGF.AZTEC_DATA_10;
        }
        if (i5 == 12) {
            return GenericGF.AZTEC_DATA_12;
        }
        throw new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i5)));
    }

    static BitArray stuffBits(BitArray bitArray, int i5) {
        BitArray bitArray2 = new BitArray();
        int size = bitArray.getSize();
        int i6 = (1 << i5) - 2;
        int i7 = 0;
        while (i7 < size) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                int i10 = i7 + i9;
                if (i10 >= size || bitArray.get(i10)) {
                    i8 |= 1 << ((i5 - 1) - i9);
                }
            }
            int i11 = i8 & i6;
            if (i11 == i6) {
                bitArray2.appendBits(i11, i5);
            } else if (i11 == 0) {
                bitArray2.appendBits(i8 | 1, i5);
            } else {
                bitArray2.appendBits(i8, i5);
                i7 += i5;
            }
            i7--;
            i7 += i5;
        }
        return bitArray2;
    }

    private static int totalBitsInLayer(int i5, boolean z5) {
        return ((z5 ? 88 : 112) + (i5 << 4)) * i5;
    }
}
