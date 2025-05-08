package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AutoValue_ExperimentIds;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes.dex */
public abstract class ExperimentIds {

    @AutoValue.Builder
    /* loaded from: classes.dex */
    public static abstract class Builder {
        public abstract ExperimentIds build();

        public abstract Builder setClearBlob(byte[] bArr);

        public abstract Builder setEncryptedBlob(byte[] bArr);
    }

    public static Builder builder() {
        return new AutoValue_ExperimentIds.Builder();
    }

    public abstract byte[] getClearBlob();

    public abstract byte[] getEncryptedBlob();
}
