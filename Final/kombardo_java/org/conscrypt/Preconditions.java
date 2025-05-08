package org.conscrypt;

/* loaded from: classes3.dex */
final class Preconditions {
    private Preconditions() {
    }

    private static String badPositionIndex(int i5, int i6, String str) {
        if (i5 < 0) {
            return String.format("%s (%s) must not be negative", str, Integer.valueOf(i5));
        }
        if (i6 >= 0) {
            return String.format("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i5), Integer.valueOf(i6));
        }
        throw new IllegalArgumentException("negative size: " + i6);
    }

    private static String badPositionIndexes(int i5, int i6, int i7) {
        return (i5 < 0 || i5 > i7) ? badPositionIndex(i5, i7, "start index") : (i6 < 0 || i6 > i7) ? badPositionIndex(i6, i7, "end index") : String.format("end index (%s) must not be less than start index (%s)", Integer.valueOf(i6), Integer.valueOf(i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkArgument(boolean z5, String str) {
        if (!z5) {
            throw new IllegalArgumentException(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T checkNotNull(T t5, String str) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkPositionIndexes(int i5, int i6, int i7) {
        if (i5 < 0 || i6 < i5 || i6 > i7) {
            throw new IndexOutOfBoundsException(badPositionIndexes(i5, i6, i7));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkArgument(boolean z5, String str, Object obj) {
        if (!z5) {
            throw new IllegalArgumentException(String.format(str, obj));
        }
    }
}
