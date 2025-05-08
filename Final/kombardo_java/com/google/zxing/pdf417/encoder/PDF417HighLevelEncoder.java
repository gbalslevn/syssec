package com.google.zxing.pdf417.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* loaded from: classes2.dex */
abstract class PDF417HighLevelEncoder {
    private static final int BYTE_COMPACTION = 1;
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final int LATCH_TO_BYTE = 924;
    private static final int LATCH_TO_BYTE_PADDED = 901;
    private static final int LATCH_TO_NUMERIC = 902;
    private static final int LATCH_TO_TEXT = 900;
    private static final byte[] MIXED;
    private static final int NUMERIC_COMPACTION = 2;
    private static final int SHIFT_TO_BYTE = 913;
    private static final int SUBMODE_ALPHA = 0;
    private static final int SUBMODE_LOWER = 1;
    private static final int SUBMODE_MIXED = 2;
    private static final int SUBMODE_PUNCTUATION = 3;
    private static final int TEXT_COMPACTION = 0;
    private static final byte[] TEXT_MIXED_RAW = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};
    private static final byte[] TEXT_PUNCTUATION_RAW = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0};
    private static final byte[] PUNCTUATION = new byte[128];
    private static final Charset DEFAULT_ENCODING = StandardCharsets.ISO_8859_1;

    /* renamed from: com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$pdf417$encoder$Compaction;

        static {
            int[] iArr = new int[Compaction.values().length];
            $SwitchMap$com$google$zxing$pdf417$encoder$Compaction = iArr;
            try {
                iArr[Compaction.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$encoder$Compaction[Compaction.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$encoder$Compaction[Compaction.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        int i5 = 0;
        byte[] bArr = new byte[128];
        MIXED = bArr;
        Arrays.fill(bArr, (byte) -1);
        int i6 = 0;
        while (true) {
            byte[] bArr2 = TEXT_MIXED_RAW;
            if (i6 >= bArr2.length) {
                break;
            }
            byte b5 = bArr2[i6];
            if (b5 > 0) {
                MIXED[b5] = (byte) i6;
            }
            i6++;
        }
        Arrays.fill(PUNCTUATION, (byte) -1);
        while (true) {
            byte[] bArr3 = TEXT_PUNCTUATION_RAW;
            if (i5 >= bArr3.length) {
                return;
            }
            byte b6 = bArr3[i5];
            if (b6 > 0) {
                PUNCTUATION[b6] = (byte) i5;
            }
            i5++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0028, code lost:
    
        return r1 - r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int determineConsecutiveBinaryCount(String str, int i5, Charset charset) {
        int i6;
        CharsetEncoder newEncoder = charset.newEncoder();
        int length = str.length();
        int i7 = i5;
        while (i7 < length) {
            char charAt = str.charAt(i7);
            int i8 = 0;
            while (i8 < 13 && isDigit(charAt) && (i6 = i7 + (i8 = i8 + 1)) < length) {
                charAt = str.charAt(i6);
            }
            char charAt2 = str.charAt(i7);
            if (!newEncoder.canEncode(charAt2)) {
                throw new WriterException("Non-encodable character detected: " + charAt2 + " (Unicode: " + ((int) charAt2) + ')');
            }
            i7++;
        }
        return i7 - i5;
    }

    private static int determineConsecutiveDigitCount(CharSequence charSequence, int i5) {
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

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0027, code lost:
    
        return (r1 - r7) - r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int determineConsecutiveTextCount(CharSequence charSequence, int i5) {
        int length = charSequence.length();
        int i6 = i5;
        while (i6 < length) {
            char charAt = charSequence.charAt(i6);
            int i7 = 0;
            while (i7 < 13 && isDigit(charAt) && i6 < length) {
                i7++;
                i6++;
                if (i6 < length) {
                    charAt = charSequence.charAt(i6);
                }
            }
            if (i7 <= 0) {
                if (!isText(charSequence.charAt(i6))) {
                    break;
                }
                i6++;
            }
        }
        return i6 - i5;
    }

    private static void encodeBinary(byte[] bArr, int i5, int i6, int i7, StringBuilder sb) {
        int i8;
        if (i6 == 1 && i7 == 0) {
            sb.append((char) 913);
        } else if (i6 % 6 == 0) {
            sb.append((char) 924);
        } else {
            sb.append((char) 901);
        }
        if (i6 >= 6) {
            char[] cArr = new char[5];
            i8 = i5;
            while ((i5 + i6) - i8 >= 6) {
                long j5 = 0;
                for (int i9 = 0; i9 < 6; i9++) {
                    j5 = (j5 << 8) + (bArr[i8 + i9] & 255);
                }
                for (int i10 = 0; i10 < 5; i10++) {
                    cArr[i10] = (char) (j5 % 900);
                    j5 /= 900;
                }
                for (int i11 = 4; i11 >= 0; i11--) {
                    sb.append(cArr[i11]);
                }
                i8 += 6;
            }
        } else {
            i8 = i5;
        }
        while (i8 < i5 + i6) {
            sb.append((char) (bArr[i8] & 255));
            i8++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String encodeHighLevel(String str, Compaction compaction, Charset charset) {
        CharacterSetECI characterSetECIByName;
        StringBuilder sb = new StringBuilder(str.length());
        if (charset == null) {
            charset = DEFAULT_ENCODING;
        } else if (!DEFAULT_ENCODING.equals(charset) && (characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(charset.name())) != null) {
            encodingECI(characterSetECIByName.getValue(), sb);
        }
        int length = str.length();
        int i5 = AnonymousClass1.$SwitchMap$com$google$zxing$pdf417$encoder$Compaction[compaction.ordinal()];
        if (i5 == 1) {
            encodeText(str, 0, length, sb, 0);
        } else if (i5 == 2) {
            byte[] bytes = str.getBytes(charset);
            encodeBinary(bytes, 0, bytes.length, 1, sb);
        } else if (i5 != 3) {
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (i6 < length) {
                int determineConsecutiveDigitCount = determineConsecutiveDigitCount(str, i6);
                if (determineConsecutiveDigitCount >= 13) {
                    sb.append((char) 902);
                    encodeNumeric(str, i6, determineConsecutiveDigitCount, sb);
                    i6 += determineConsecutiveDigitCount;
                    i7 = 0;
                    i8 = 2;
                } else {
                    int determineConsecutiveTextCount = determineConsecutiveTextCount(str, i6);
                    if (determineConsecutiveTextCount >= 5 || determineConsecutiveDigitCount == length) {
                        if (i8 != 0) {
                            sb.append((char) 900);
                            i7 = 0;
                            i8 = 0;
                        }
                        i7 = encodeText(str, i6, determineConsecutiveTextCount, sb, i7);
                        i6 += determineConsecutiveTextCount;
                    } else {
                        int determineConsecutiveBinaryCount = determineConsecutiveBinaryCount(str, i6, charset);
                        if (determineConsecutiveBinaryCount == 0) {
                            determineConsecutiveBinaryCount = 1;
                        }
                        int i9 = determineConsecutiveBinaryCount + i6;
                        byte[] bytes2 = str.substring(i6, i9).getBytes(charset);
                        if (bytes2.length == 1 && i8 == 0) {
                            encodeBinary(bytes2, 0, 1, 0, sb);
                        } else {
                            encodeBinary(bytes2, 0, bytes2.length, i8, sb);
                            i8 = 1;
                            i7 = 0;
                        }
                        i6 = i9;
                    }
                }
            }
        } else {
            sb.append((char) 902);
            encodeNumeric(str, 0, length, sb);
        }
        return sb.toString();
    }

    private static void encodeNumeric(String str, int i5, int i6, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i6 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900L);
        BigInteger valueOf2 = BigInteger.valueOf(0L);
        int i7 = 0;
        while (i7 < i6) {
            sb2.setLength(0);
            int min = Math.min(44, i6 - i7);
            StringBuilder sb3 = new StringBuilder("1");
            int i8 = i5 + i7;
            sb3.append(str.substring(i8, i8 + min));
            BigInteger bigInteger = new BigInteger(sb3.toString());
            do {
                sb2.append((char) bigInteger.mod(valueOf).intValue());
                bigInteger = bigInteger.divide(valueOf);
            } while (!bigInteger.equals(valueOf2));
            for (int length = sb2.length() - 1; length >= 0; length--) {
                sb.append(sb2.charAt(length));
            }
            i7 += min;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00f4 A[EDGE_INSN: B:21:0x00f4->B:22:0x00f4 BREAK  A[LOOP:0: B:2:0x000f->B:16:0x000f], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x000f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int encodeText(CharSequence charSequence, int i5, int i6, StringBuilder sb, int i7) {
        StringBuilder sb2 = new StringBuilder(i6);
        int i8 = i7;
        int i9 = 0;
        while (true) {
            int i10 = i5 + i9;
            char charAt = charSequence.charAt(i10);
            if (i8 != 0) {
                if (i8 != 1) {
                    if (i8 != 2) {
                        if (isPunctuation(charAt)) {
                            sb2.append((char) PUNCTUATION[charAt]);
                        } else {
                            sb2.append((char) 29);
                            i8 = 0;
                        }
                    } else if (isMixed(charAt)) {
                        sb2.append((char) MIXED[charAt]);
                    } else if (isAlphaUpper(charAt)) {
                        sb2.append((char) 28);
                        i8 = 0;
                    } else if (isAlphaLower(charAt)) {
                        sb2.append((char) 27);
                        i8 = 1;
                    } else {
                        int i11 = i10 + 1;
                        if (i11 >= i6 || !isPunctuation(charSequence.charAt(i11))) {
                            sb2.append((char) 29);
                            sb2.append((char) PUNCTUATION[charAt]);
                        } else {
                            sb2.append((char) 25);
                            i8 = 3;
                        }
                    }
                } else if (isAlphaLower(charAt)) {
                    if (charAt == ' ') {
                        sb2.append((char) 26);
                    } else {
                        sb2.append((char) (charAt - 'a'));
                    }
                } else if (isAlphaUpper(charAt)) {
                    sb2.append((char) 27);
                    sb2.append((char) (charAt - 'A'));
                } else if (isMixed(charAt)) {
                    sb2.append((char) 28);
                    i8 = 2;
                } else {
                    sb2.append((char) 29);
                    sb2.append((char) PUNCTUATION[charAt]);
                }
                i9++;
                if (i9 < i6) {
                    break;
                }
            } else {
                if (isAlphaUpper(charAt)) {
                    if (charAt == ' ') {
                        sb2.append((char) 26);
                    } else {
                        sb2.append((char) (charAt - 'A'));
                    }
                } else if (isAlphaLower(charAt)) {
                    sb2.append((char) 27);
                    i8 = 1;
                } else if (isMixed(charAt)) {
                    sb2.append((char) 28);
                    i8 = 2;
                } else {
                    sb2.append((char) 29);
                    sb2.append((char) PUNCTUATION[charAt]);
                }
                i9++;
                if (i9 < i6) {
                }
            }
        }
        int length = sb2.length();
        char c5 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            if (i12 % 2 != 0) {
                c5 = (char) ((c5 * 30) + sb2.charAt(i12));
                sb.append(c5);
            } else {
                c5 = sb2.charAt(i12);
            }
        }
        if (length % 2 != 0) {
            sb.append((char) ((c5 * 30) + 29));
        }
        return i8;
    }

    private static void encodingECI(int i5, StringBuilder sb) {
        if (i5 >= 0 && i5 < LATCH_TO_TEXT) {
            sb.append((char) 927);
            sb.append((char) i5);
        } else if (i5 < 810900) {
            sb.append((char) 926);
            sb.append((char) ((i5 / LATCH_TO_TEXT) - 1));
            sb.append((char) (i5 % LATCH_TO_TEXT));
        } else {
            if (i5 >= 811800) {
                throw new WriterException("ECI number not in valid range from 0..811799, but was ".concat(String.valueOf(i5)));
            }
            sb.append((char) 925);
            sb.append((char) (810900 - i5));
        }
    }

    private static boolean isAlphaLower(char c5) {
        if (c5 != ' ') {
            return c5 >= 'a' && c5 <= 'z';
        }
        return true;
    }

    private static boolean isAlphaUpper(char c5) {
        if (c5 != ' ') {
            return c5 >= 'A' && c5 <= 'Z';
        }
        return true;
    }

    private static boolean isDigit(char c5) {
        return c5 >= '0' && c5 <= '9';
    }

    private static boolean isMixed(char c5) {
        return MIXED[c5] != -1;
    }

    private static boolean isPunctuation(char c5) {
        return PUNCTUATION[c5] != -1;
    }

    private static boolean isText(char c5) {
        if (c5 == '\t' || c5 == '\n' || c5 == '\r') {
            return true;
        }
        return c5 >= ' ' && c5 <= '~';
    }
}
