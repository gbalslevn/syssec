package org.conscrypt;

/* loaded from: classes3.dex */
final class ArrayUtils {
    private ArrayUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkOffsetAndCount(int i5, int i6, int i7) {
        if ((i6 | i7) < 0 || i6 > i5 || i5 - i6 < i7) {
            throw new ArrayIndexOutOfBoundsException("length=" + i5 + "; regionStart=" + i6 + "; regionLength=" + i7);
        }
    }
}
