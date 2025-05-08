package com.google.zxing.datamatrix.encoder;

import com.google.zxing.Dimension;
import java.util.Arrays;

/* loaded from: classes2.dex */
public abstract class HighLevelEncoder {
    private static final char MACRO_05 = 236;
    private static final String MACRO_05_HEADER = "[)>\u001e05\u001d";
    private static final char MACRO_06 = 237;
    private static final String MACRO_06_HEADER = "[)>\u001e06\u001d";
    private static final String MACRO_TRAILER = "\u001e\u0004";
    private static final char PAD = 129;

    public static int determineConsecutiveDigitCount(CharSequence charSequence, int i5) {
        int length = charSequence.length();
        int i6 = 0;
        if (i5 < length) {
            char charAt = charSequence.charAt(i5);
            while (isDigit(charAt) && i5 < length) {
                i6++;
                i5++;
                if (i5 < length) {
                    charAt = charSequence.charAt(i5);
                }
            }
        }
        return i6;
    }

    public static String encodeHighLevel(String str, SymbolShapeHint symbolShapeHint, Dimension dimension, Dimension dimension2) {
        int i5 = 0;
        Encoder[] encoderArr = {new ASCIIEncoder(), new C40Encoder(), new TextEncoder(), new X12Encoder(), new EdifactEncoder(), new Base256Encoder()};
        EncoderContext encoderContext = new EncoderContext(str);
        encoderContext.setSymbolShape(symbolShapeHint);
        encoderContext.setSizeConstraints(dimension, dimension2);
        if (str.startsWith(MACRO_05_HEADER) && str.endsWith(MACRO_TRAILER)) {
            encoderContext.writeCodeword(MACRO_05);
            encoderContext.setSkipAtEnd(2);
            encoderContext.pos += 7;
        } else if (str.startsWith(MACRO_06_HEADER) && str.endsWith(MACRO_TRAILER)) {
            encoderContext.writeCodeword(MACRO_06);
            encoderContext.setSkipAtEnd(2);
            encoderContext.pos += 7;
        }
        while (encoderContext.hasMoreCharacters()) {
            encoderArr[i5].encode(encoderContext);
            if (encoderContext.getNewEncoding() >= 0) {
                i5 = encoderContext.getNewEncoding();
                encoderContext.resetEncoderSignal();
            }
        }
        int codewordCount = encoderContext.getCodewordCount();
        encoderContext.updateSymbolInfo();
        int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity();
        if (codewordCount < dataCapacity && i5 != 0 && i5 != 5 && i5 != 4) {
            encoderContext.writeCodeword((char) 254);
        }
        StringBuilder codewords = encoderContext.getCodewords();
        if (codewords.length() < dataCapacity) {
            codewords.append(PAD);
        }
        while (codewords.length() < dataCapacity) {
            codewords.append(randomize253State(PAD, codewords.length() + 1));
        }
        return encoderContext.getCodewords().toString();
    }

    private static int findMinimums(float[] fArr, int[] iArr, int i5, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        for (int i6 = 0; i6 < 6; i6++) {
            int ceil = (int) Math.ceil(fArr[i6]);
            iArr[i6] = ceil;
            if (i5 > ceil) {
                Arrays.fill(bArr, (byte) 0);
                i5 = ceil;
            }
            if (i5 == ceil) {
                bArr[i6] = (byte) (bArr[i6] + 1);
            }
        }
        return i5;
    }

    private static int getMinimumCount(byte[] bArr) {
        int i5 = 0;
        for (int i6 = 0; i6 < 6; i6++) {
            i5 += bArr[i6];
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void illegalCharacter(char c5) {
        String hexString = Integer.toHexString(c5);
        throw new IllegalArgumentException("Illegal character: " + c5 + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isDigit(char c5) {
        return c5 >= '0' && c5 <= '9';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isExtendedASCII(char c5) {
        return c5 >= 128 && c5 <= 255;
    }

    private static boolean isNativeC40(char c5) {
        if (c5 == ' ') {
            return true;
        }
        if (c5 < '0' || c5 > '9') {
            return c5 >= 'A' && c5 <= 'Z';
        }
        return true;
    }

    private static boolean isNativeEDIFACT(char c5) {
        return c5 >= ' ' && c5 <= '^';
    }

    private static boolean isNativeText(char c5) {
        if (c5 == ' ') {
            return true;
        }
        if (c5 < '0' || c5 > '9') {
            return c5 >= 'a' && c5 <= 'z';
        }
        return true;
    }

    private static boolean isNativeX12(char c5) {
        if (isX12TermSep(c5) || c5 == ' ') {
            return true;
        }
        if (c5 < '0' || c5 > '9') {
            return c5 >= 'A' && c5 <= 'Z';
        }
        return true;
    }

    private static boolean isSpecialB256(char c5) {
        return false;
    }

    private static boolean isX12TermSep(char c5) {
        return c5 == '\r' || c5 == '*' || c5 == '>';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int lookAheadTest(CharSequence charSequence, int i5, int i6) {
        float[] fArr;
        int i7;
        int i8;
        if (i5 >= charSequence.length()) {
            return i6;
        }
        float f5 = 2.0f;
        int i9 = 6;
        int i10 = 4;
        int i11 = 3;
        if (i6 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[6];
            fArr[0] = 1.0f;
            fArr[1] = 2.0f;
            fArr[2] = 2.0f;
            fArr[3] = 2.0f;
            fArr[4] = 2.0f;
            fArr[5] = 2.25f;
            fArr[i6] = 0.0f;
        }
        int i12 = 0;
        while (true) {
            int i13 = i5 + i12;
            if (i13 == charSequence.length()) {
                byte[] bArr = new byte[i9];
                int[] iArr = new int[i9];
                int findMinimums = findMinimums(fArr, iArr, Integer.MAX_VALUE, bArr);
                int minimumCount = getMinimumCount(bArr);
                if (iArr[0] == findMinimums) {
                    return 0;
                }
                if (minimumCount == 1 && bArr[5] > 0) {
                    return 5;
                }
                if (minimumCount == 1 && bArr[i10] > 0) {
                    return i10;
                }
                if (minimumCount == 1 && bArr[2] > 0) {
                    return 2;
                }
                if (minimumCount != 1 || bArr[i11] <= 0) {
                    return 1;
                }
                return i11;
            }
            char charAt = charSequence.charAt(i13);
            i12++;
            if (isDigit(charAt)) {
                fArr[0] = fArr[0] + 0.5f;
            } else if (isExtendedASCII(charAt)) {
                float ceil = (float) Math.ceil(fArr[0]);
                fArr[0] = ceil;
                fArr[0] = ceil + f5;
            } else {
                float ceil2 = (float) Math.ceil(fArr[0]);
                fArr[0] = ceil2;
                fArr[0] = ceil2 + 1.0f;
            }
            if (isNativeC40(charAt)) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (isExtendedASCII(charAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (isNativeText(charAt)) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (isExtendedASCII(charAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (isNativeX12(charAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (isExtendedASCII(charAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (isNativeEDIFACT(charAt)) {
                fArr[4] = fArr[4] + 0.75f;
            } else if (isExtendedASCII(charAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            if (isSpecialB256(charAt)) {
                fArr[5] = fArr[5] + 4.0f;
            } else {
                fArr[5] = fArr[5] + 1.0f;
            }
            if (i12 >= 4) {
                int[] iArr2 = new int[i9];
                byte[] bArr2 = new byte[i9];
                findMinimums(fArr, iArr2, Integer.MAX_VALUE, bArr2);
                int minimumCount2 = getMinimumCount(bArr2);
                int i14 = iArr2[0];
                int i15 = iArr2[5];
                if (i14 < i15 && i14 < iArr2[1] && i14 < iArr2[2] && i14 < iArr2[3] && i14 < iArr2[4]) {
                    return 0;
                }
                if (i15 < i14) {
                    break;
                }
                byte b5 = bArr2[1];
                byte b6 = bArr2[2];
                byte b7 = bArr2[3];
                byte b8 = bArr2[4];
                if (b5 + b6 + b7 + b8 == 0) {
                    break;
                }
                if (minimumCount2 == 1 && b8 > 0) {
                    return 4;
                }
                if (minimumCount2 == 1 && b6 > 0) {
                    return 2;
                }
                if (minimumCount2 == 1 && b7 > 0) {
                    return 3;
                }
                int i16 = iArr2[1];
                if (i16 + 1 >= i14 || i16 + 1 >= i15) {
                    i8 = 3;
                    i7 = 4;
                    i10 = i7;
                    i9 = 6;
                    i11 = i8;
                    f5 = 2.0f;
                } else {
                    i7 = 4;
                    if (i16 + 1 < iArr2[4] && i16 + 1 < iArr2[2]) {
                        int i17 = iArr2[3];
                        if (i16 < i17) {
                            return 1;
                        }
                        if (i16 == i17) {
                            for (int i18 = i5 + i12 + 1; i18 < charSequence.length(); i18++) {
                                char charAt2 = charSequence.charAt(i18);
                                if (isX12TermSep(charAt2)) {
                                    return 3;
                                }
                                if (!isNativeX12(charAt2)) {
                                    break;
                                }
                            }
                            return 1;
                        }
                    }
                }
            } else {
                i7 = 4;
            }
            i8 = 3;
            i10 = i7;
            i9 = 6;
            i11 = i8;
            f5 = 2.0f;
        }
        return 5;
    }

    private static char randomize253State(char c5, int i5) {
        int i6 = c5 + ((i5 * 149) % 253) + 1;
        if (i6 > 254) {
            i6 -= 254;
        }
        return (char) i6;
    }
}
