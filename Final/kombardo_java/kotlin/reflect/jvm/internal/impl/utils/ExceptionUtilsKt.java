package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public abstract class ExceptionUtilsKt {
    public static final boolean isProcessCanceledException(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        Class<?> cls = th.getClass();
        while (!Intrinsics.areEqual(cls.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            cls = cls.getSuperclass();
            if (cls == null) {
                return false;
            }
        }
        return true;
    }

    public static final RuntimeException rethrow(Throwable e5) {
        Intrinsics.checkNotNullParameter(e5, "e");
        throw e5;
    }
}
