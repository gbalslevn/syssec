package com.google.android.datatransport.runtime.dagger.internal;

import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DoubleCheck<T> implements Provider<T> {
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider<T> provider;

    private DoubleCheck(Provider<T> provider) {
        this.provider = provider;
    }

    public static <P extends Provider<T>, T> Provider<T> provider(P p5) {
        Preconditions.checkNotNull(p5);
        return p5 instanceof DoubleCheck ? p5 : new DoubleCheck(p5);
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
        Object obj = UNINITIALIZED;
        if (t5 == obj) {
            synchronized (this) {
                try {
                    t5 = (T) this.instance;
                    if (t5 == obj) {
                        t5 = this.provider.get();
                        this.instance = reentrantCheck(this.instance, t5);
                        this.provider = null;
                    }
                } finally {
                }
            }
        }
        return t5;
    }
}
