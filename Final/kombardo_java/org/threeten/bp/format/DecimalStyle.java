package org.threeten.bp.format;

import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes3.dex */
public final class DecimalStyle {
    private final char decimalSeparator;
    private final char negativeSign;
    private final char positiveSign;
    private final char zeroDigit;
    public static final DecimalStyle STANDARD = new DecimalStyle('0', '+', '-', '.');
    private static final ConcurrentMap<Locale, DecimalStyle> CACHE = new ConcurrentHashMap(16, 0.75f, 2);

    private DecimalStyle(char c5, char c6, char c7, char c8) {
        this.zeroDigit = c5;
        this.positiveSign = c6;
        this.negativeSign = c7;
        this.decimalSeparator = c8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String convertNumberToI18N(String str) {
        char c5 = this.zeroDigit;
        if (c5 == '0') {
            return str;
        }
        int i5 = c5 - '0';
        char[] charArray = str.toCharArray();
        for (int i6 = 0; i6 < charArray.length; i6++) {
            charArray[i6] = (char) (charArray[i6] + i5);
        }
        return new String(charArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int convertToDigit(char c5) {
        int i5 = c5 - this.zeroDigit;
        if (i5 < 0 || i5 > 9) {
            return -1;
        }
        return i5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DecimalStyle)) {
            return false;
        }
        DecimalStyle decimalStyle = (DecimalStyle) obj;
        return this.zeroDigit == decimalStyle.zeroDigit && this.positiveSign == decimalStyle.positiveSign && this.negativeSign == decimalStyle.negativeSign && this.decimalSeparator == decimalStyle.decimalSeparator;
    }

    public char getDecimalSeparator() {
        return this.decimalSeparator;
    }

    public char getNegativeSign() {
        return this.negativeSign;
    }

    public char getPositiveSign() {
        return this.positiveSign;
    }

    public char getZeroDigit() {
        return this.zeroDigit;
    }

    public int hashCode() {
        return this.zeroDigit + this.positiveSign + this.negativeSign + this.decimalSeparator;
    }

    public String toString() {
        return "DecimalStyle[" + this.zeroDigit + this.positiveSign + this.negativeSign + this.decimalSeparator + "]";
    }
}
