package androidx.core.util;

import java.util.Objects;

/* loaded from: classes.dex */
public abstract class ObjectsCompat {
    public static boolean equals(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static int hash(Object... objArr) {
        return Objects.hash(objArr);
    }

    public static <T> T requireNonNull(T t5) {
        t5.getClass();
        return t5;
    }

    public static String toString(Object obj, String str) {
        return obj != null ? obj.toString() : str;
    }

    public static <T> T requireNonNull(T t5, String str) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(str);
    }
}
