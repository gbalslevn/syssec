package org.commonmark.internal.util;

import com.sun.jna.Function;

/* loaded from: classes3.dex */
public abstract class Parsing {
    private static final String ATTRIBUTE = "(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)";
    private static final String ATTRIBUTENAME = "[a-zA-Z_:][a-zA-Z0-9:._-]*";
    private static final String ATTRIBUTEVALUE = "(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\")";
    private static final String ATTRIBUTEVALUESPEC = "(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))";
    public static int CODE_BLOCK_INDENT = 4;
    private static final String DOUBLEQUOTEDVALUE = "\"[^\"]*\"";
    private static final String SINGLEQUOTEDVALUE = "'[^']*'";
    private static final String TAGNAME = "[A-Za-z][A-Za-z0-9-]*";
    private static final String UNQUOTEDVALUE = "[^\"'=<>`\\x00-\\x20]+";

    public static int columnsToNextTabStop(int i5) {
        return 4 - (i5 % 4);
    }

    public static int find(char c5, CharSequence charSequence, int i5) {
        int length = charSequence.length();
        while (i5 < length) {
            if (charSequence.charAt(i5) == c5) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public static int findLineBreak(CharSequence charSequence, int i5) {
        int length = charSequence.length();
        while (i5 < length) {
            char charAt = charSequence.charAt(i5);
            if (charAt == '\n' || charAt == '\r') {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    private static int findNonSpace(CharSequence charSequence, int i5) {
        int length = charSequence.length();
        while (i5 < length) {
            char charAt = charSequence.charAt(i5);
            if (charAt != ' ') {
                switch (charAt) {
                    case '\t':
                    case '\n':
                    case 11:
                    case '\f':
                    case '\r':
                        break;
                    default:
                        return i5;
                }
            }
            i5++;
        }
        return -1;
    }

    public static boolean hasNonSpace(CharSequence charSequence) {
        int length = charSequence.length();
        return skip(' ', charSequence, 0, length) != length;
    }

    public static boolean isBlank(CharSequence charSequence) {
        return findNonSpace(charSequence, 0) == -1;
    }

    public static boolean isEscapable(CharSequence charSequence, int i5) {
        if (i5 >= charSequence.length()) {
            return false;
        }
        char charAt = charSequence.charAt(i5);
        switch (charAt) {
            case '!':
            case '\"':
            case '#':
            case '$':
            case '%':
            case '&':
            case '\'':
            case '(':
            case ')':
            case '*':
            case '+':
            case ',':
            case '-':
            case '.':
            case '/':
                return true;
            default:
                switch (charAt) {
                    case ':':
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                    case Function.ALT_CONVENTION /* 63 */:
                    case Function.THROW_LAST_ERROR /* 64 */:
                        return true;
                    default:
                        switch (charAt) {
                            case '[':
                            case '\\':
                            case ']':
                            case '^':
                            case '_':
                            case '`':
                                return true;
                            default:
                                switch (charAt) {
                                    case '{':
                                    case '|':
                                    case '}':
                                    case '~':
                                        return true;
                                    default:
                                        return false;
                                }
                        }
                }
        }
    }

    public static boolean isLetter(CharSequence charSequence, int i5) {
        return Character.isLetter(Character.codePointAt(charSequence, i5));
    }

    public static boolean isSpaceOrTab(CharSequence charSequence, int i5) {
        if (i5 >= charSequence.length()) {
            return false;
        }
        char charAt = charSequence.charAt(i5);
        return charAt == '\t' || charAt == ' ';
    }

    public static CharSequence prepareLine(CharSequence charSequence) {
        int length = charSequence.length();
        StringBuilder sb = null;
        for (int i5 = 0; i5 < length; i5++) {
            char charAt = charSequence.charAt(i5);
            if (charAt == 0) {
                if (sb == null) {
                    sb = new StringBuilder(length);
                    sb.append(charSequence, 0, i5);
                }
                sb.append((char) 65533);
            } else if (sb != null) {
                sb.append(charAt);
            }
        }
        return sb != null ? sb.toString() : charSequence;
    }

    public static int skip(char c5, CharSequence charSequence, int i5, int i6) {
        while (i5 < i6) {
            if (charSequence.charAt(i5) != c5) {
                return i5;
            }
            i5++;
        }
        return i6;
    }

    public static int skipBackwards(char c5, CharSequence charSequence, int i5, int i6) {
        while (i5 >= i6) {
            if (charSequence.charAt(i5) != c5) {
                return i5;
            }
            i5--;
        }
        return i6 - 1;
    }

    public static int skipSpaceTab(CharSequence charSequence, int i5, int i6) {
        while (i5 < i6) {
            char charAt = charSequence.charAt(i5);
            if (charAt != '\t' && charAt != ' ') {
                return i5;
            }
            i5++;
        }
        return i6;
    }

    public static int skipSpaceTabBackwards(CharSequence charSequence, int i5, int i6) {
        while (i5 >= i6) {
            char charAt = charSequence.charAt(i5);
            if (charAt != '\t' && charAt != ' ') {
                return i5;
            }
            i5--;
        }
        return i6 - 1;
    }
}
