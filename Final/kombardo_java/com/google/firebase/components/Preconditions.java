package com.google.firebase.components;

/* loaded from: classes2.dex */
public abstract class Preconditions {
    public static void checkArgument(boolean z5, String str) {
        if (!z5) {
            throw new IllegalArgumentException(str);
        }
    }

    public static <T> T checkNotNull(T t5) {
        t5.getClass();
        return t5;
    }

    public static void checkState(boolean z5, String str) {
        if (!z5) {
            throw new IllegalStateException(str);
        }
    }

    public static <T> T checkNotNull(T t5, String str) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(str);
    }
}
