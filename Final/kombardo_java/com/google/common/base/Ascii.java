package com.google.common.base;

/* loaded from: classes.dex */
public abstract class Ascii {
    private static final char CASE_MASK = ' ';

    public static boolean isUpperCase(char c5) {
        return c5 >= 'A' && c5 <= 'Z';
    }

    public static String toLowerCase(String str) {
        int length = str.length();
        int i5 = 0;
        while (i5 < length) {
            if (isUpperCase(str.charAt(i5))) {
                char[] charArray = str.toCharArray();
                while (i5 < length) {
                    char c5 = charArray[i5];
                    if (isUpperCase(c5)) {
                        charArray[i5] = (char) (c5 ^ CASE_MASK);
                    }
                    i5++;
                }
                return String.valueOf(charArray);
            }
            i5++;
        }
        return str;
    }
}
