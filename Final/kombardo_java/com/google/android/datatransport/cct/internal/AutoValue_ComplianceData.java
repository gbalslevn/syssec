package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.ComplianceData;

/* loaded from: classes.dex */
final class AutoValue_ComplianceData extends ComplianceData {
    private final ExternalPrivacyContext privacyContext;
    private final ComplianceData.ProductIdOrigin productIdOrigin;

    /* loaded from: classes.dex */
    static final class Builder extends ComplianceData.Builder {
        private ExternalPrivacyContext privacyContext;
        private ComplianceData.ProductIdOrigin productIdOrigin;

        @Override // com.google.android.datatransport.cct.internal.ComplianceData.Builder
        public ComplianceData build() {
            return new AutoValue_ComplianceData(this.privacyContext, this.productIdOrigin);
        }

        @Override // com.google.android.datatransport.cct.internal.ComplianceData.Builder
        public ComplianceData.Builder setPrivacyContext(ExternalPrivacyContext externalPrivacyContext) {
            this.privacyContext = externalPrivacyContext;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.ComplianceData.Builder
        public ComplianceData.Builder setProductIdOrigin(ComplianceData.ProductIdOrigin productIdOrigin) {
            this.productIdOrigin = productIdOrigin;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ComplianceData)) {
            return false;
        }
        ComplianceData complianceData = (ComplianceData) obj;
        ExternalPrivacyContext externalPrivacyContext = this.privacyContext;
        if (externalPrivacyContext != null ? externalPrivacyContext.equals(complianceData.getPrivacyContext()) : complianceData.getPrivacyContext() == null) {
            ComplianceData.ProductIdOrigin productIdOrigin = this.productIdOrigin;
            if (productIdOrigin == null) {
                if (complianceData.getProductIdOrigin() == null) {
                    return true;
                }
            } else if (productIdOrigin.equals(complianceData.getProductIdOrigin())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.ComplianceData
    public ExternalPrivacyContext getPrivacyContext() {
        return this.privacyContext;
    }

    @Override // com.google.android.datatransport.cct.internal.ComplianceData
    public ComplianceData.ProductIdOrigin getProductIdOrigin() {
        return this.productIdOrigin;
    }

    public int hashCode() {
        ExternalPrivacyContext externalPrivacyContext = this.privacyContext;
        int hashCode = ((externalPrivacyContext == null ? 0 : externalPrivacyContext.hashCode()) ^ 1000003) * 1000003;
        ComplianceData.ProductIdOrigin productIdOrigin = this.productIdOrigin;
        return hashCode ^ (productIdOrigin != null ? productIdOrigin.hashCode() : 0);
    }

    public String toString() {
        return "ComplianceData{privacyContext=" + this.privacyContext + ", productIdOrigin=" + this.productIdOrigin + "}";
    }

    private AutoValue_ComplianceData(ExternalPrivacyContext externalPrivacyContext, ComplianceData.ProductIdOrigin productIdOrigin) {
        this.privacyContext = externalPrivacyContext;
        this.productIdOrigin = productIdOrigin;
    }
}
