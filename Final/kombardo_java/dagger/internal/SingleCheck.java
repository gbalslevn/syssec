package dagger.internal;

/* loaded from: classes2.dex */
public final class SingleCheck<T> implements Provider<T> {
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider<T> provider;

    private SingleCheck(Provider<T> provider) {
        this.provider = provider;
    }

    public static <T> Provider<T> provider(Provider<T> provider) {
        return ((provider instanceof SingleCheck) || (provider instanceof DoubleCheck)) ? provider : new SingleCheck((Provider) Preconditions.checkNotNull(provider));
    }

    @Override // javax.inject.Provider
    public T get() {
        T t5 = (T) this.instance;
        if (t5 != UNINITIALIZED) {
            return t5;
        }
        Provider<T> provider = this.provider;
        if (provider == null) {
            return (T) this.instance;
        }
        T t6 = provider.get();
        this.instance = t6;
        this.provider = null;
        return t6;
    }
}
