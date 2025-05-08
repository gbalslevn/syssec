package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AutoValue_ExternalPRequestContext;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes.dex */
public abstract class ExternalPRequestContext {

    @AutoValue.Builder
    /* loaded from: classes.dex */
    public static abstract class Builder {
        public abstract ExternalPRequestContext build();

        public abstract Builder setOriginAssociatedProductId(Integer num);
    }

    public static Builder builder() {
        return new AutoValue_ExternalPRequestContext.Builder();
    }

    public abstract Integer getOriginAssociatedProductId();
}
