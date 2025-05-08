package org.commonmark.internal.util;

/* loaded from: classes3.dex */
public abstract class LinkScanner {
    public static int scanLinkDestination(CharSequence charSequence, int i5) {
        char charAt;
        if (i5 >= charSequence.length()) {
            return -1;
        }
        if (charSequence.charAt(i5) != '<') {
            return scanLinkDestinationWithBalancedParens(charSequence, i5);
        }
        while (true) {
            i5++;
            if (i5 >= charSequence.length() || (charAt = charSequence.charAt(i5)) == '\n' || charAt == '<') {
                break;
            }
            if (charAt == '>') {
                return i5 + 1;
            }
            if (charAt == '\\') {
                int i6 = i5 + 1;
                if (Parsing.isEscapable(charSequence, i6)) {
                    i5 = i6;
                }
            }
        }
        return -1;
    }

    private static int scanLinkDestinationWithBalancedParens(CharSequence charSequence, int i5) {
        int i6 = 0;
        int i7 = i5;
        while (i7 < charSequence.length()) {
            char charAt = charSequence.charAt(i7);
            if (charAt == 0 || charAt == ' ') {
                if (i7 != i5) {
                    return i7;
                }
                return -1;
            }
            if (charAt == '\\') {
                int i8 = i7 + 1;
                if (Parsing.isEscapable(charSequence, i8)) {
                    i7 = i8;
                }
            } else if (charAt == '(') {
                i6++;
                if (i6 > 32) {
                    return -1;
                }
            } else if (charAt != ')') {
                if (Character.isISOControl(charAt)) {
                    if (i7 != i5) {
                        return i7;
                    }
                    return -1;
                }
            } else {
                if (i6 == 0) {
                    return i7;
                }
                i6--;
            }
            i7++;
        }
        return charSequence.length();
    }

    public static int scanLinkLabelContent(CharSequence charSequence, int i5) {
        while (i5 < charSequence.length()) {
            switch (charSequence.charAt(i5)) {
                case '[':
                    return -1;
                case '\\':
                    int i6 = i5 + 1;
                    if (!Parsing.isEscapable(charSequence, i6)) {
                        break;
                    } else {
                        i5 = i6;
                        break;
                    }
                case ']':
                    return i5;
            }
            i5++;
        }
        return charSequence.length();
    }

    public static int scanLinkTitle(CharSequence charSequence, int i5) {
        if (i5 >= charSequence.length()) {
            return -1;
        }
        char charAt = charSequence.charAt(i5);
        char c5 = '\"';
        if (charAt != '\"') {
            c5 = '\'';
            if (charAt != '\'') {
                if (charAt != '(') {
                    return -1;
                }
                c5 = ')';
            }
        }
        int scanLinkTitleContent = scanLinkTitleContent(charSequence, i5 + 1, c5);
        if (scanLinkTitleContent != -1 && scanLinkTitleContent < charSequence.length() && charSequence.charAt(scanLinkTitleContent) == c5) {
            return scanLinkTitleContent + 1;
        }
        return -1;
    }

    public static int scanLinkTitleContent(CharSequence charSequence, int i5, char c5) {
        while (i5 < charSequence.length()) {
            char charAt = charSequence.charAt(i5);
            if (charAt == '\\') {
                int i6 = i5 + 1;
                if (Parsing.isEscapable(charSequence, i6)) {
                    i5 = i6;
                    i5++;
                }
            }
            if (charAt == c5) {
                return i5;
            }
            if (c5 == ')' && charAt == '(') {
                return -1;
            }
            i5++;
        }
        return charSequence.length();
    }
}
