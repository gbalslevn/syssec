package com.google.common.base;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    public static <T> Optional<T> of(T t5) {
        return new Present(Preconditions.checkNotNull(t5));
    }

    public abstract T get();

    public abstract boolean isPresent();
}
