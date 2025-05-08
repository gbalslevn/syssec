package kotlin.jvm.internal;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

/* loaded from: classes2.dex */
public abstract class Intrinsics {

    /* loaded from: classes2.dex */
    public static class Kotlin {
    }

    public static boolean areEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static void checkExpressionValueIsNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(str + " must not be null")));
    }

    public static void checkNotNull(Object obj) {
        if (obj == null) {
            throwJavaNpe();
        }
    }

    public static void checkNotNullExpressionValue(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException(str + " must not be null")));
    }

    public static void checkNotNullParameter(Object obj, String str) {
        if (obj == null) {
            throwParameterIsNullNPE(str);
        }
    }

    public static void checkParameterIsNotNull(Object obj, String str) {
        if (obj == null) {
            throwParameterIsNullIAE(str);
        }
    }

    public static int compare(int i5, int i6) {
        if (i5 < i6) {
            return -1;
        }
        return i5 == i6 ? 0 : 1;
    }

    private static String createParameterIsNullExceptionMessage(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = Intrinsics.class.getName();
        int i5 = 0;
        while (!stackTrace[i5].getClassName().equals(name)) {
            i5++;
        }
        while (stackTrace[i5].getClassName().equals(name)) {
            i5++;
        }
        StackTraceElement stackTraceElement = stackTrace[i5];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    public static void reifiedOperationMarker(int i5, String str) {
        throwUndefinedForReified();
    }

    private static <T extends Throwable> T sanitizeStackTrace(T t5) {
        return (T) sanitizeStackTrace(t5, Intrinsics.class.getName());
    }

    public static String stringPlus(String str, Object obj) {
        return str + obj;
    }

    public static void throwJavaNpe() {
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException()));
    }

    public static void throwNpe() {
        throw ((KotlinNullPointerException) sanitizeStackTrace(new KotlinNullPointerException()));
    }

    private static void throwParameterIsNullIAE(String str) {
        throw ((IllegalArgumentException) sanitizeStackTrace(new IllegalArgumentException(createParameterIsNullExceptionMessage(str))));
    }

    private static void throwParameterIsNullNPE(String str) {
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException(createParameterIsNullExceptionMessage(str))));
    }

    public static void throwUndefinedForReified() {
        throwUndefinedForReified("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void throwUninitializedProperty(String str) {
        throw ((UninitializedPropertyAccessException) sanitizeStackTrace(new UninitializedPropertyAccessException(str)));
    }

    public static void throwUninitializedPropertyAccessException(String str) {
        throwUninitializedProperty("lateinit property " + str + " has not been initialized");
    }

    public static boolean areEqual(Float f5, Float f6) {
        if (f5 == null) {
            if (f6 != null) {
                return false;
            }
        } else if (f6 == null || f5.floatValue() != f6.floatValue()) {
            return false;
        }
        return true;
    }

    public static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throwJavaNpe(str);
        }
    }

    public static int compare(long j5, long j6) {
        if (j5 < j6) {
            return -1;
        }
        return j5 == j6 ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends Throwable> T sanitizeStackTrace(T t5, String str) {
        StackTraceElement[] stackTrace = t5.getStackTrace();
        int length = stackTrace.length;
        int i5 = -1;
        for (int i6 = 0; i6 < length; i6++) {
            if (str.equals(stackTrace[i6].getClassName())) {
                i5 = i6;
            }
        }
        t5.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i5 + 1, length));
        return t5;
    }

    public static void throwJavaNpe(String str) {
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException(str)));
    }

    public static void throwUndefinedForReified(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static boolean areEqual(Float f5, float f6) {
        return f5 != null && f5.floatValue() == f6;
    }
}
