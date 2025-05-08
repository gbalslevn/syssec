package dagger.internal;

/* loaded from: classes2.dex */
public final class DoubleCheck<T> implements Provider<T> {
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider<T> provider;

    private DoubleCheck(Provider<T> provider) {
        this.provider = provider;
    }

    private synchronized Object getSynchronized() {
        Object obj;
        obj = this.instance;
        if (obj == UNINITIALIZED) {
            obj = this.provider.get();
            this.instance = reentrantCheck(this.instance, obj);
            this.provider = null;
        }
        return obj;
    }

    public static <T> Provider<T> provider(Provider<T> provider) {
        Preconditions.checkNotNull(provider);
        return provider instanceof DoubleCheck ? provider : new DoubleCheck(provider);
    }

    private static Object reentrantCheck(Object obj, Object obj2) {
        if (obj == UNINITIALIZED || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // javax.inject.Provider
    public T get() {
        T t5 = (T) this.instance;
        return t5 == UNINITIALIZED ? (T) getSynchronized() : t5;
    }

    @Deprecated
    public static <P extends javax.inject.Provider<T>, T> javax.inject.Provider<T> provider(P p5) {
        return provider(Providers.asDaggerProvider(p5));
    }
}
