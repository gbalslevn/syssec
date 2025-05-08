package dagger.internal;

/* loaded from: classes2.dex */
public abstract class Providers {
    public static <T> Provider<T> asDaggerProvider(final javax.inject.Provider<T> provider) {
        Preconditions.checkNotNull(provider);
        return provider instanceof Provider ? (Provider) provider : new Provider<T>() { // from class: dagger.internal.Providers.1
            @Override // javax.inject.Provider
            public T get() {
                return (T) javax.inject.Provider.this.get();
            }
        };
    }
}
