package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* loaded from: classes2.dex */
public class Lazy<T> implements Provider<T> {
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider<T> provider;

    public Lazy(Provider<T> provider) {
        this.provider = provider;
    }

    @Override // com.google.firebase.inject.Provider
    public T get() {
        T t5 = (T) this.instance;
        Object obj = UNINITIALIZED;
        if (t5 == obj) {
            synchronized (this) {
                try {
                    t5 = (T) this.instance;
                    if (t5 == obj) {
                        t5 = this.provider.get();
                        this.instance = t5;
                        this.provider = null;
                    }
                } finally {
                }
            }
        }
        return t5;
    }
}
