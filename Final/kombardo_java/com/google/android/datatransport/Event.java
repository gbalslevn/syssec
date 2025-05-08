package com.google.android.datatransport;

import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes.dex */
public abstract class Event<T> {
    public static <T> Event<T> ofData(T t5, ProductData productData) {
        return new AutoValue_Event(null, t5, Priority.DEFAULT, productData, null);
    }

    public static <T> Event<T> ofUrgent(T t5) {
        return new AutoValue_Event(null, t5, Priority.HIGHEST, null, null);
    }

    public abstract Integer getCode();

    public abstract EventContext getEventContext();

    public abstract T getPayload();

    public abstract Priority getPriority();

    public abstract ProductData getProductData();

    public static <T> Event<T> ofData(T t5) {
        return new AutoValue_Event(null, t5, Priority.DEFAULT, null, null);
    }
}
