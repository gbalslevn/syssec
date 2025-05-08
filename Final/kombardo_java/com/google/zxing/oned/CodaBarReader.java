package com.google.zxing.oned;

/* loaded from: classes2.dex */
public abstract class CodaBarReader extends OneDReader {
    private static final float MAX_ACCEPTABLE = 2.0f;
    private static final int MIN_CHARACTER_LENGTH = 3;
    private static final float PADDING = 1.5f;
    private static final String ALPHABET_STRING = "0123456789-$:/.+ABCD";
    static final char[] ALPHABET = ALPHABET_STRING.toCharArray();
    static final int[] CHARACTER_ENCODINGS = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
    private static final char[] STARTEND_ENCODING = {'A', 'B', 'C', 'D'};

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean arrayContains(char[] cArr, char c5) {
        if (cArr != null) {
            for (char c6 : cArr) {
                if (c6 == c5) {
                    return true;
                }
            }
        }
        return false;
    }
}
