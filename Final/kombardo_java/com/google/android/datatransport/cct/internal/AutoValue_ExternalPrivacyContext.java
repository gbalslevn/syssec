package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.ExternalPrivacyContext;

/* loaded from: classes.dex */
final class AutoValue_ExternalPrivacyContext extends ExternalPrivacyContext {
    private final ExternalPRequestContext prequest;

    /* loaded from: classes.dex */
    static final class Builder extends ExternalPrivacyContext.Builder {
        private ExternalPRequestContext prequest;

        @Override // com.google.android.datatransport.cct.internal.ExternalPrivacyContext.Builder
        public ExternalPrivacyContext build() {
            return new AutoValue_ExternalPrivacyContext(this.prequest);
        }

        @Override // com.google.android.datatransport.cct.internal.ExternalPrivacyContext.Builder
        public ExternalPrivacyContext.Builder setPrequest(ExternalPRequestContext externalPRequestContext) {
            this.prequest = externalPRequestContext;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExternalPrivacyContext)) {
            return false;
        }
        ExternalPRequestContext externalPRequestContext = this.prequest;
        ExternalPRequestContext prequest = ((ExternalPrivacyContext) obj).getPrequest();
        return externalPRequestContext == null ? prequest == null : externalPRequestContext.equals(prequest);
    }

    @Override // com.google.android.datatransport.cct.internal.ExternalPrivacyContext
    public ExternalPRequestContext getPrequest() {
        return this.prequest;
    }

    public int hashCode() {
        ExternalPRequestContext externalPRequestContext = this.prequest;
        return (externalPRequestContext == null ? 0 : externalPRequestContext.hashCode()) ^ 1000003;
    }

    public String toString() {
        return "ExternalPrivacyContext{prequest=" + this.prequest + "}";
    }

    private AutoValue_ExternalPrivacyContext(ExternalPRequestContext externalPRequestContext) {
        this.prequest = externalPRequestContext;
    }
}
