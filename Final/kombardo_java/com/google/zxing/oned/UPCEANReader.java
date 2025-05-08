package com.google.zxing.oned;

import com.google.zxing.FormatException;

/* loaded from: classes2.dex */
public abstract class UPCEANReader extends OneDReader {
    static final int[][] L_AND_G_PATTERNS;
    static final int[][] L_PATTERNS;
    private static final float MAX_AVG_VARIANCE = 0.48f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.7f;
    static final int[] START_END_PATTERN = {1, 1, 1};
    static final int[] MIDDLE_PATTERN = {1, 1, 1, 1, 1};
    static final int[] END_PATTERN = {1, 1, 1, 1, 1, 1};

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        L_PATTERNS = iArr;
        int[][] iArr2 = new int[20];
        L_AND_G_PATTERNS = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i5 = 10; i5 < 20; i5++) {
            int[] iArr3 = L_PATTERNS[i5 - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i6 = 0; i6 < iArr3.length; i6++) {
                iArr4[i6] = iArr3[(iArr3.length - i6) - 1];
            }
            L_AND_G_PATTERNS[i5] = iArr4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean checkStandardUPCEANChecksum(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i5 = length - 1;
        return getStandardUPCEANChecksum(charSequence.subSequence(0, i5)) == Character.digit(charSequence.charAt(i5), 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getStandardUPCEANChecksum(CharSequence charSequence) {
        int length = charSequence.length();
        int i5 = 0;
        for (int i6 = length - 1; i6 >= 0; i6 -= 2) {
            int charAt = charSequence.charAt(i6) - '0';
            if (charAt < 0 || charAt > 9) {
                throw FormatException.getFormatInstance();
            }
            i5 += charAt;
        }
        int i7 = i5 * 3;
        for (int i8 = length - 2; i8 >= 0; i8 -= 2) {
            int charAt2 = charSequence.charAt(i8) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw FormatException.getFormatInstance();
            }
            i7 += charAt2;
        }
        return (1000 - i7) % 10;
    }
}
