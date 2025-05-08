package com.google.common.base;

/* loaded from: classes.dex */
public abstract class Preconditions {
    private static String badElementIndex(int i5, int i6, String str) {
        if (i5 < 0) {
            return Strings.lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(i5));
        }
        if (i6 >= 0) {
            return Strings.lenientFormat("%s (%s) must be less than size (%s)", str, Integer.valueOf(i5), Integer.valueOf(i6));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i6);
        throw new IllegalArgumentException(sb.toString());
    }

    private static String badPositionIndex(int i5, int i6, String str) {
        if (i5 < 0) {
            return Strings.lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(i5));
        }
        if (i6 >= 0) {
            return Strings.lenientFormat("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i5), Integer.valueOf(i6));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i6);
        throw new IllegalArgumentException(sb.toString());
    }

    private static String badPositionIndexes(int i5, int i6, int i7) {
        return (i5 < 0 || i5 > i7) ? badPositionIndex(i5, i7, "start index") : (i6 < 0 || i6 > i7) ? badPositionIndex(i6, i7, "end index") : Strings.lenientFormat("end index (%s) must not be less than start index (%s)", Integer.valueOf(i6), Integer.valueOf(i5));
    }

    public static void checkArgument(boolean z5) {
        if (!z5) {
            throw new IllegalArgumentException();
        }
    }

    public static int checkElementIndex(int i5, int i6) {
        return checkElementIndex(i5, i6, "index");
    }

    public static <T> T checkNotNull(T t5) {
        t5.getClass();
        return t5;
    }

    public static int checkPositionIndex(int i5, int i6) {
        return checkPositionIndex(i5, i6, "index");
    }

    public static void checkPositionIndexes(int i5, int i6, int i7) {
        if (i5 < 0 || i6 < i5 || i6 > i7) {
            throw new IndexOutOfBoundsException(badPositionIndexes(i5, i6, i7));
        }
    }

    public static void checkState(boolean z5) {
        if (!z5) {
            throw new IllegalStateException();
        }
    }

    public static void checkArgument(boolean z5, Object obj) {
        if (!z5) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int checkElementIndex(int i5, int i6, String str) {
        if (i5 < 0 || i5 >= i6) {
            throw new IndexOutOfBoundsException(badElementIndex(i5, i6, str));
        }
        return i5;
    }

    public static <T> T checkNotNull(T t5, Object obj) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static int checkPositionIndex(int i5, int i6, String str) {
        if (i5 < 0 || i5 > i6) {
            throw new IndexOutOfBoundsException(badPositionIndex(i5, i6, str));
        }
        return i5;
    }

    public static void checkState(boolean z5, Object obj) {
        if (!z5) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void checkArgument(boolean z5, String str, int i5, int i6) {
        if (!z5) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i5), Integer.valueOf(i6)));
        }
    }

    public static void checkState(boolean z5, String str, int i5) {
        if (!z5) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i5)));
        }
    }

    public static void checkState(boolean z5, String str, Object obj) {
        if (!z5) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj));
        }
    }
}
