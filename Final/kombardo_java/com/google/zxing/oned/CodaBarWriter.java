package com.google.zxing.oned;

/* loaded from: classes2.dex */
public final class CodaBarWriter extends OneDimensionalCodeWriter {
    private static final char[] ALT_START_END_CHARS = {'T', 'N', '*', 'E'};
    private static final char[] CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED = {'/', ':', '+', '.'};
    private static final char DEFAULT_GUARD;
    private static final char[] START_END_CHARS;

    static {
        char[] cArr = {'A', 'B', 'C', 'D'};
        START_END_CHARS = cArr;
        DEFAULT_GUARD = cArr[0];
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int i5;
        if (str.length() < 2) {
            StringBuilder sb = new StringBuilder();
            char c5 = DEFAULT_GUARD;
            sb.append(c5);
            sb.append(str);
            sb.append(c5);
            str = sb.toString();
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            char[] cArr = START_END_CHARS;
            boolean arrayContains = CodaBarReader.arrayContains(cArr, upperCase);
            boolean arrayContains2 = CodaBarReader.arrayContains(cArr, upperCase2);
            char[] cArr2 = ALT_START_END_CHARS;
            boolean arrayContains3 = CodaBarReader.arrayContains(cArr2, upperCase);
            boolean arrayContains4 = CodaBarReader.arrayContains(cArr2, upperCase2);
            if (arrayContains) {
                if (!arrayContains2) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
                }
            } else if (!arrayContains3) {
                if (arrayContains2 || arrayContains4) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
                }
                StringBuilder sb2 = new StringBuilder();
                char c6 = DEFAULT_GUARD;
                sb2.append(c6);
                sb2.append(str);
                sb2.append(c6);
                str = sb2.toString();
            } else if (!arrayContains4) {
                throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
            }
        }
        int i6 = 20;
        for (int i7 = 1; i7 < str.length() - 1; i7++) {
            if (Character.isDigit(str.charAt(i7)) || str.charAt(i7) == '-' || str.charAt(i7) == '$') {
                i6 += 9;
            } else {
                if (!CodaBarReader.arrayContains(CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED, str.charAt(i7))) {
                    throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i7) + '\'');
                }
                i6 += 10;
            }
        }
        boolean[] zArr = new boolean[i6 + (str.length() - 1)];
        int i8 = 0;
        for (int i9 = 0; i9 < str.length(); i9++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i9));
            if (i9 == 0 || i9 == str.length() - 1) {
                if (upperCase3 == '*') {
                    upperCase3 = 'C';
                } else if (upperCase3 == 'E') {
                    upperCase3 = 'D';
                } else if (upperCase3 == 'N') {
                    upperCase3 = 'B';
                } else if (upperCase3 == 'T') {
                    upperCase3 = 'A';
                }
            }
            int i10 = 0;
            while (true) {
                char[] cArr3 = CodaBarReader.ALPHABET;
                if (i10 >= cArr3.length) {
                    i5 = 0;
                    break;
                }
                if (upperCase3 == cArr3[i10]) {
                    i5 = CodaBarReader.CHARACTER_ENCODINGS[i10];
                    break;
                }
                i10++;
            }
            int i11 = 0;
            int i12 = 0;
            boolean z5 = true;
            while (i11 < 7) {
                zArr[i8] = z5;
                i8++;
                if (((i5 >> (6 - i11)) & 1) == 0 || i12 == 1) {
                    z5 = !z5;
                    i11++;
                    i12 = 0;
                } else {
                    i12++;
                }
            }
            if (i9 < str.length() - 1) {
                zArr[i8] = false;
                i8++;
            }
        }
        return zArr;
    }
}
