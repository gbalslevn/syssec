package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AutoValue_ExternalPrivacyContext;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes.dex */
public abstract class ExternalPrivacyContext {

    @AutoValue.Builder
    /* loaded from: classes.dex */
    public static abstract class Builder {
        public abstract ExternalPrivacyContext build();

        public abstract Builder setPrequest(ExternalPRequestContext externalPRequestContext);
    }

    public static Builder builder() {
        return new AutoValue_ExternalPrivacyContext.Builder();
    }

    public abstract ExternalPRequestContext getPrequest();
}
