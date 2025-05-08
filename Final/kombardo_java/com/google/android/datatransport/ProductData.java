package com.google.android.datatransport;

import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes.dex */
public abstract class ProductData {
    public static ProductData withProductId(Integer num) {
        return new AutoValue_ProductData(num);
    }

    public abstract Integer getProductId();
}
