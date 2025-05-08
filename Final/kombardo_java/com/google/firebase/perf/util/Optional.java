package com.google.firebase.perf.util;

import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class Optional<T> {
    private final T value;

    private Optional() {
        this.value = null;
    }

    public static <T> Optional<T> absent() {
        return new Optional<>();
    }

    public static <T> Optional<T> fromNullable(T t5) {
        return t5 == null ? absent() : of(t5);
    }

    public static <T> Optional<T> of(T t5) {
        return new Optional<>(t5);
    }

    public T get() {
        T t5 = this.value;
        if (t5 != null) {
            return t5;
        }
        throw new NoSuchElementException("No value present");
    }

    public boolean isAvailable() {
        return this.value != null;
    }

    private Optional(T t5) {
        if (t5 != null) {
            this.value = t5;
            return;
        }
        throw new NullPointerException("value for optional is empty.");
    }
}
