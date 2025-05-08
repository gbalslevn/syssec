package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* loaded from: classes2.dex */
public final class Code39Writer extends OneDimensionalCodeWriter {
    private static void toIntArray(int i5, int[] iArr) {
        for (int i6 = 0; i6 < 9; i6++) {
            int i7 = 1;
            if (((1 << (8 - i6)) & i5) != 0) {
                i7 = 2;
            }
            iArr[i6] = i7;
        }
    }

    private static String tryToConvertToExtendedMode(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < length; i5++) {
            char charAt = str.charAt(i5);
            if (charAt != 0) {
                if (charAt != ' ') {
                    if (charAt == '@') {
                        sb.append("%V");
                    } else if (charAt == '`') {
                        sb.append("%W");
                    } else if (charAt != '-' && charAt != '.') {
                        if (charAt <= 26) {
                            sb.append('$');
                            sb.append((char) (charAt + '@'));
                        } else if (charAt < ' ') {
                            sb.append('%');
                            sb.append((char) (charAt + '&'));
                        } else if (charAt <= ',' || charAt == '/' || charAt == ':') {
                            sb.append('/');
                            sb.append((char) (charAt + ' '));
                        } else if (charAt <= '9') {
                            sb.append(charAt);
                        } else if (charAt <= '?') {
                            sb.append('%');
                            sb.append((char) (charAt + 11));
                        } else if (charAt <= 'Z') {
                            sb.append(charAt);
                        } else if (charAt <= '_') {
                            sb.append('%');
                            sb.append((char) (charAt - 16));
                        } else if (charAt <= 'z') {
                            sb.append('+');
                            sb.append((char) (charAt - ' '));
                        } else {
                            if (charAt > 127) {
                                throw new IllegalArgumentException("Requested content contains a non-encodable character: '" + str.charAt(i5) + "'");
                            }
                            sb.append('%');
                            sb.append((char) (charAt - '+'));
                        }
                    }
                }
                sb.append(charAt);
            } else {
                sb.append("%U");
            }
        }
        return sb.toString();
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i5, int i6, Map<EncodeHintType, ?> map) {
        if (barcodeFormat == BarcodeFormat.CODE_39) {
            return super.encode(str, barcodeFormat, i5, i6, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_39, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length <= 80) {
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    break;
                }
                if ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i5)) < 0) {
                    str = tryToConvertToExtendedMode(str);
                    length = str.length();
                    if (length > 80) {
                        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length + " (extended full ASCII mode)");
                    }
                } else {
                    i5++;
                }
            }
            int[] iArr = new int[9];
            int i6 = length + 25;
            for (int i7 = 0; i7 < length; i7++) {
                toIntArray(Code39Reader.CHARACTER_ENCODINGS["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i7))], iArr);
                for (int i8 = 0; i8 < 9; i8++) {
                    i6 += iArr[i8];
                }
            }
            boolean[] zArr = new boolean[i6];
            toIntArray(148, iArr);
            int appendPattern = OneDimensionalCodeWriter.appendPattern(zArr, 0, iArr, true);
            int[] iArr2 = {1};
            int appendPattern2 = appendPattern + OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, iArr2, false);
            for (int i9 = 0; i9 < length; i9++) {
                toIntArray(Code39Reader.CHARACTER_ENCODINGS["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i9))], iArr);
                int appendPattern3 = appendPattern2 + OneDimensionalCodeWriter.appendPattern(zArr, appendPattern2, iArr, true);
                appendPattern2 = appendPattern3 + OneDimensionalCodeWriter.appendPattern(zArr, appendPattern3, iArr2, false);
            }
            toIntArray(148, iArr);
            OneDimensionalCodeWriter.appendPattern(zArr, appendPattern2, iArr, true);
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
    }
}
