package com.google.zxing.qrcode.encoder;

/* loaded from: classes2.dex */
abstract class MaskUtil {

    /* renamed from: N1, reason: collision with root package name */
    private static final int f4516N1 = 3;

    /* renamed from: N2, reason: collision with root package name */
    private static final int f4517N2 = 3;

    /* renamed from: N3, reason: collision with root package name */
    private static final int f4518N3 = 40;
    private static final int N4 = 10;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int applyMaskPenaltyRule1(ByteMatrix byteMatrix) {
        return applyMaskPenaltyRule1Internal(byteMatrix, true) + applyMaskPenaltyRule1Internal(byteMatrix, false);
    }

    private static int applyMaskPenaltyRule1Internal(ByteMatrix byteMatrix, boolean z5) {
        int height = z5 ? byteMatrix.getHeight() : byteMatrix.getWidth();
        int width = z5 ? byteMatrix.getWidth() : byteMatrix.getHeight();
        byte[][] array = byteMatrix.getArray();
        int i5 = 0;
        for (int i6 = 0; i6 < height; i6++) {
            byte b5 = -1;
            int i7 = 0;
            for (int i8 = 0; i8 < width; i8++) {
                byte b6 = z5 ? array[i6][i8] : array[i8][i6];
                if (b6 == b5) {
                    i7++;
                } else {
                    if (i7 >= 5) {
                        i5 += i7 - 2;
                    }
                    i7 = 1;
                    b5 = b6;
                }
            }
            if (i7 >= 5) {
                i5 += i7 - 2;
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int applyMaskPenaltyRule2(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i5 = 0;
        for (int i6 = 0; i6 < height - 1; i6++) {
            byte[] bArr = array[i6];
            int i7 = 0;
            while (i7 < width - 1) {
                byte b5 = bArr[i7];
                int i8 = i7 + 1;
                if (b5 == bArr[i8]) {
                    byte[] bArr2 = array[i6 + 1];
                    if (b5 == bArr2[i7] && b5 == bArr2[i8]) {
                        i5++;
                    }
                }
                i7 = i8;
            }
        }
        return i5 * 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int applyMaskPenaltyRule3(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i5 = 0;
        for (int i6 = 0; i6 < height; i6++) {
            for (int i7 = 0; i7 < width; i7++) {
                byte[] bArr = array[i6];
                int i8 = i7 + 6;
                if (i8 < width && bArr[i7] == 1 && bArr[i7 + 1] == 0 && bArr[i7 + 2] == 1 && bArr[i7 + 3] == 1 && bArr[i7 + 4] == 1 && bArr[i7 + 5] == 0 && bArr[i8] == 1 && (isWhiteHorizontal(bArr, i7 - 4, i7) || isWhiteHorizontal(bArr, i7 + 7, i7 + 11))) {
                    i5++;
                }
                int i9 = i6 + 6;
                if (i9 < height && array[i6][i7] == 1 && array[i6 + 1][i7] == 0 && array[i6 + 2][i7] == 1 && array[i6 + 3][i7] == 1 && array[i6 + 4][i7] == 1 && array[i6 + 5][i7] == 0 && array[i9][i7] == 1 && (isWhiteVertical(array, i7, i6 - 4, i6) || isWhiteVertical(array, i7, i6 + 7, i6 + 11))) {
                    i5++;
                }
            }
        }
        return i5 * f4518N3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int applyMaskPenaltyRule4(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i5 = 0;
        for (int i6 = 0; i6 < height; i6++) {
            byte[] bArr = array[i6];
            for (int i7 = 0; i7 < width; i7++) {
                if (bArr[i7] == 1) {
                    i5++;
                }
            }
        }
        int height2 = byteMatrix.getHeight() * byteMatrix.getWidth();
        return ((Math.abs((i5 << 1) - height2) * 10) / height2) * 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0001. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean getDataMaskBit(int i5, int i6, int i7) {
        int i8;
        int i9;
        switch (i5) {
            case 0:
                i7 += i6;
                i8 = i7 & 1;
                return i8 != 0;
            case 1:
                i8 = i7 & 1;
                if (i8 != 0) {
                }
                break;
            case 2:
                i8 = i6 % 3;
                if (i8 != 0) {
                }
                break;
            case 3:
                i8 = (i7 + i6) % 3;
                if (i8 != 0) {
                }
                break;
            case 4:
                i7 /= 2;
                i6 /= 3;
                i7 += i6;
                i8 = i7 & 1;
                if (i8 != 0) {
                }
                break;
            case 5:
                int i10 = i7 * i6;
                i8 = (i10 & 1) + (i10 % 3);
                if (i8 != 0) {
                }
                break;
            case 6:
                int i11 = i7 * i6;
                i9 = (i11 & 1) + (i11 % 3);
                i8 = i9 & 1;
                if (i8 != 0) {
                }
                break;
            case 7:
                i9 = ((i7 * i6) % 3) + ((i7 + i6) & 1);
                i8 = i9 & 1;
                if (i8 != 0) {
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid mask pattern: ".concat(String.valueOf(i5)));
        }
    }

    private static boolean isWhiteHorizontal(byte[] bArr, int i5, int i6) {
        int min = Math.min(i6, bArr.length);
        for (int max = Math.max(i5, 0); max < min; max++) {
            if (bArr[max] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isWhiteVertical(byte[][] bArr, int i5, int i6, int i7) {
        int min = Math.min(i7, bArr.length);
        for (int max = Math.max(i6, 0); max < min; max++) {
            if (bArr[max][i5] == 1) {
                return false;
            }
        }
        return true;
    }
}
