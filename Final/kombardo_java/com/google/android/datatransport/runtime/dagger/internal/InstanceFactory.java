package com.google.android.datatransport.runtime.dagger.internal;

/* loaded from: classes.dex */
public final class InstanceFactory<T> implements Factory<T> {
    private static final InstanceFactory<Object> NULL_INSTANCE_FACTORY = new InstanceFactory<>(null);
    private final T instance;

    private InstanceFactory(T t5) {
        this.instance = t5;
    }

    public static <T> Factory<T> create(T t5) {
        return new InstanceFactory(Preconditions.checkNotNull(t5, "instance cannot be null"));
    }

    @Override // javax.inject.Provider
    public T get() {
        return this.instance;
    }
}
