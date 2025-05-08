package io.noties.markwon.html.jsoup.helper;

/* loaded from: classes2.dex */
public abstract class Validate {
    public static void fail(String str) {
        throw new IllegalArgumentException(str);
    }

    public static void isFalse(boolean z5) {
        if (z5) {
            throw new IllegalArgumentException("Must be false");
        }
    }

    public static void isTrue(boolean z5) {
        if (!z5) {
            throw new IllegalArgumentException("Must be true");
        }
    }

    public static void notEmpty(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("String must not be empty");
        }
    }

    public static void notNull(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object must not be null");
        }
    }

    public static void isFalse(boolean z5, String str) {
        if (z5) {
            throw new IllegalArgumentException(str);
        }
    }
}
