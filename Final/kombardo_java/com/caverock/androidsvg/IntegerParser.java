package com.caverock.androidsvg;

/* loaded from: classes.dex */
class IntegerParser {
    private int pos;
    private long value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IntegerParser(long j5, int i5) {
        this.value = j5;
        this.pos = i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IntegerParser parseHex(String str, int i5, int i6) {
        long j5;
        int i7;
        if (i5 >= i6) {
            return null;
        }
        long j6 = 0;
        int i8 = i5;
        while (i8 < i6) {
            char charAt = str.charAt(i8);
            if (charAt < '0' || charAt > '9') {
                if (charAt >= 'A' && charAt <= 'F') {
                    j5 = j6 * 16;
                    i7 = charAt - 'A';
                } else {
                    if (charAt < 'a' || charAt > 'f') {
                        break;
                    }
                    j5 = j6 * 16;
                    i7 = charAt - 'a';
                }
                j6 = j5 + i7 + 10;
            } else {
                j6 = (j6 * 16) + (charAt - '0');
            }
            if (j6 > 4294967295L) {
                return null;
            }
            i8++;
        }
        if (i8 == i5) {
            return null;
        }
        return new IntegerParser(j6, i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IntegerParser parseInt(String str, int i5, int i6, boolean z5) {
        if (i5 >= i6) {
            return null;
        }
        if (z5) {
            char charAt = str.charAt(i5);
            if (charAt != '+') {
                r1 = charAt == '-';
            }
            i5++;
        }
        long j5 = 0;
        int i7 = i5;
        while (i7 < i6) {
            char charAt2 = str.charAt(i7);
            if (charAt2 < '0' || charAt2 > '9') {
                break;
            }
            if (r1) {
                j5 = (j5 * 10) - (charAt2 - '0');
                if (j5 < -2147483648L) {
                    return null;
                }
            } else {
                j5 = (j5 * 10) + (charAt2 - '0');
                if (j5 > 2147483647L) {
                    return null;
                }
            }
            i7++;
        }
        if (i7 == i5) {
            return null;
        }
        return new IntegerParser(j5, i7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getEndPos() {
        return this.pos;
    }

    public int value() {
        return (int) this.value;
    }
}
