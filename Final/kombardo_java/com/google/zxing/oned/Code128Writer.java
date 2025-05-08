package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class Code128Writer extends OneDimensionalCodeWriter {
    private static final int CODE_CODE_A = 101;
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_A = 101;
    private static final int CODE_FNC_4_B = 100;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final char ESCAPE_FNC_1 = 241;
    private static final char ESCAPE_FNC_2 = 242;
    private static final char ESCAPE_FNC_3 = 243;
    private static final char ESCAPE_FNC_4 = 244;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    private static int chooseCode(CharSequence charSequence, int i5, int i6) {
        CType findCType;
        CType findCType2;
        char charAt;
        CType findCType3 = findCType(charSequence, i5);
        CType cType = CType.ONE_DIGIT;
        if (findCType3 == cType) {
            return 100;
        }
        CType cType2 = CType.UNCODABLE;
        if (findCType3 == cType2) {
            return (i5 >= charSequence.length() || ((charAt = charSequence.charAt(i5)) >= ' ' && (i6 != 101 || charAt >= CODE_FNC_3))) ? 100 : 101;
        }
        if (i6 == CODE_CODE_C) {
            return CODE_CODE_C;
        }
        if (i6 != 100) {
            if (findCType3 == CType.FNC_1) {
                findCType3 = findCType(charSequence, i5 + 1);
            }
            if (findCType3 == CType.TWO_DIGITS) {
                return CODE_CODE_C;
            }
            return 100;
        }
        CType cType3 = CType.FNC_1;
        if (findCType3 == cType3 || (findCType = findCType(charSequence, i5 + 2)) == cType2 || findCType == cType) {
            return 100;
        }
        if (findCType == cType3) {
            if (findCType(charSequence, i5 + 3) == CType.TWO_DIGITS) {
                return CODE_CODE_C;
            }
            return 100;
        }
        int i7 = i5 + 4;
        while (true) {
            findCType2 = findCType(charSequence, i7);
            if (findCType2 != CType.TWO_DIGITS) {
                break;
            }
            i7 += 2;
        }
        if (findCType2 == CType.ONE_DIGIT) {
            return 100;
        }
        return CODE_CODE_C;
    }

    private static CType findCType(CharSequence charSequence, int i5) {
        int length = charSequence.length();
        if (i5 >= length) {
            return CType.UNCODABLE;
        }
        char charAt = charSequence.charAt(i5);
        if (charAt == 241) {
            return CType.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return CType.UNCODABLE;
        }
        int i6 = i5 + 1;
        if (i6 >= length) {
            return CType.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i6);
        return (charAt2 < '0' || charAt2 > '9') ? CType.ONE_DIGIT : CType.TWO_DIGITS;
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i5, int i6, Map<EncodeHintType, ?> map) {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.encode(str, barcodeFormat, i5, i6, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length > 0 && length <= 80) {
            int i5 = 0;
            for (int i6 = 0; i6 < length; i6++) {
                char charAt = str.charAt(i6);
                switch (charAt) {
                    case 241:
                    case 242:
                    case 243:
                    case 244:
                        break;
                    default:
                        if (charAt > 127) {
                            throw new IllegalArgumentException("Bad character in input: ".concat(String.valueOf(charAt)));
                        }
                        break;
                }
            }
            ArrayList<int[]> arrayList = new ArrayList();
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 1;
            while (true) {
                int i11 = CODE_START_A;
                if (i7 < length) {
                    int chooseCode = chooseCode(str, i7, i9);
                    int i12 = 100;
                    if (chooseCode == i9) {
                        switch (str.charAt(i7)) {
                            case 241:
                                i12 = CODE_FNC_1;
                                break;
                            case 242:
                                i12 = CODE_FNC_2;
                                break;
                            case 243:
                                i12 = CODE_FNC_3;
                                break;
                            case 244:
                                if (i9 == 101) {
                                    i12 = 101;
                                    break;
                                }
                                break;
                            default:
                                if (i9 != 100) {
                                    if (i9 != 101) {
                                        i12 = Integer.parseInt(str.substring(i7, i7 + 2));
                                        i7++;
                                        break;
                                    } else {
                                        char charAt2 = str.charAt(i7);
                                        i12 = charAt2 - ' ';
                                        if (i12 < 0) {
                                            i12 = charAt2 + '@';
                                            break;
                                        }
                                    }
                                } else {
                                    i12 = str.charAt(i7) - ' ';
                                    break;
                                }
                                break;
                        }
                        i7++;
                    } else {
                        if (i9 != 0) {
                            i11 = chooseCode;
                        } else if (chooseCode == 100) {
                            i11 = CODE_START_B;
                        } else if (chooseCode != 101) {
                            i11 = CODE_START_C;
                        }
                        i12 = i11;
                        i9 = chooseCode;
                    }
                    arrayList.add(Code128Reader.CODE_PATTERNS[i12]);
                    i8 += i12 * i10;
                    if (i7 != 0) {
                        i10++;
                    }
                } else {
                    int i13 = i8 % CODE_START_A;
                    int[][] iArr = Code128Reader.CODE_PATTERNS;
                    arrayList.add(iArr[i13]);
                    arrayList.add(iArr[CODE_STOP]);
                    int i14 = 0;
                    for (int[] iArr2 : arrayList) {
                        for (int i15 : iArr2) {
                            i14 += i15;
                        }
                    }
                    boolean[] zArr = new boolean[i14];
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        i5 += OneDimensionalCodeWriter.appendPattern(zArr, i5, (int[]) it.next(), true);
                    }
                    return zArr;
                }
            }
        } else {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got ".concat(String.valueOf(length)));
        }
    }
}
