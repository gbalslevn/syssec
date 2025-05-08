package dagger.internal;

/* loaded from: classes2.dex */
public abstract class Preconditions {
    public static <T> void checkBuilderRequirement(T t5, Class<T> cls) {
        if (t5 != null) {
            return;
        }
        throw new IllegalStateException(cls.getCanonicalName() + " must be set");
    }

    public static <T> T checkNotNull(T t5) {
        t5.getClass();
        return t5;
    }

    public static <T> T checkNotNullFromProvides(T t5) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
}
