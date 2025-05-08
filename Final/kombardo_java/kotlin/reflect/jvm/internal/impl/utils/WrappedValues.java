package kotlin.reflect.jvm.internal.impl.utils;

/* loaded from: classes3.dex */
public abstract class WrappedValues {
    private static final Object NULL_VALUE = new Object() { // from class: kotlin.reflect.jvm.internal.impl.utils.WrappedValues.1
        public String toString() {
            return "NULL_VALUE";
        }
    };
    public static volatile boolean throwWrappedProcessCanceledException = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class ThrowableWrapper {
        private final Throwable throwable;

        private static /* synthetic */ void $$$reportNull$$$0(int i5) {
            String str = i5 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i5 != 1 ? 3 : 2];
            if (i5 != 1) {
                objArr[0] = "throwable";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            }
            if (i5 != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            } else {
                objArr[1] = "getThrowable";
            }
            if (i5 != 1) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i5 == 1) {
                throw new IllegalStateException(format);
            }
        }

        public Throwable getThrowable() {
            Throwable th = this.throwable;
            if (th == null) {
                $$$reportNull$$$0(1);
            }
            return th;
        }

        public String toString() {
            return this.throwable.toString();
        }

        private ThrowableWrapper(Throwable th) {
            if (th == null) {
                $$$reportNull$$$0(0);
            }
            this.throwable = th;
        }
    }

    /* loaded from: classes3.dex */
    public static class WrappedProcessCanceledException extends RuntimeException {
        public WrappedProcessCanceledException(Throwable th) {
            super("Rethrow stored exception", th);
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int i5) {
        String str = (i5 == 1 || i5 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i5 == 1 || i5 == 2) ? 2 : 3];
        if (i5 == 1 || i5 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
        } else if (i5 != 3) {
            objArr[0] = "value";
        } else {
            objArr[0] = "throwable";
        }
        if (i5 == 1 || i5 == 2) {
            objArr[1] = "escapeNull";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
        }
        if (i5 != 1 && i5 != 2) {
            if (i5 == 3) {
                objArr[2] = "escapeThrowable";
            } else if (i5 != 4) {
                objArr[2] = "unescapeNull";
            } else {
                objArr[2] = "unescapeExceptionOrNull";
            }
        }
        String format = String.format(str, objArr);
        if (i5 != 1 && i5 != 2) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    public static <V> Object escapeNull(V v5) {
        if (v5 == null && (v5 = (V) NULL_VALUE) == null) {
            $$$reportNull$$$0(1);
        }
        return v5;
    }

    public static Object escapeThrowable(Throwable th) {
        if (th == null) {
            $$$reportNull$$$0(3);
        }
        return new ThrowableWrapper(th);
    }

    public static <V> V unescapeExceptionOrNull(Object obj) {
        if (obj == null) {
            $$$reportNull$$$0(4);
        }
        return (V) unescapeNull(unescapeThrowable(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> V unescapeNull(Object obj) {
        if (obj == 0) {
            $$$reportNull$$$0(0);
        }
        if (obj == NULL_VALUE) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> V unescapeThrowable(Object obj) {
        if (!(obj instanceof ThrowableWrapper)) {
            return obj;
        }
        Throwable throwable = ((ThrowableWrapper) obj).getThrowable();
        if (throwWrappedProcessCanceledException && ExceptionUtilsKt.isProcessCanceledException(throwable)) {
            throw new WrappedProcessCanceledException(throwable);
        }
        throw ExceptionUtilsKt.rethrow(throwable);
    }
}
