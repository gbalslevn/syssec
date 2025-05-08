package com.google.android.datatransport.cct.internal;

import android.util.SparseArray;
import com.google.android.datatransport.cct.internal.AutoValue_ComplianceData;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes.dex */
public abstract class ComplianceData {

    @AutoValue.Builder
    /* loaded from: classes.dex */
    public static abstract class Builder {
        public abstract ComplianceData build();

        public abstract Builder setPrivacyContext(ExternalPrivacyContext externalPrivacyContext);

        public abstract Builder setProductIdOrigin(ProductIdOrigin productIdOrigin);
    }

    /* loaded from: classes.dex */
    public enum ProductIdOrigin {
        NOT_SET(0),
        EVENT_OVERRIDE(5);

        private static final SparseArray<ProductIdOrigin> valueMap;
        private final int value;

        static {
            ProductIdOrigin productIdOrigin = NOT_SET;
            ProductIdOrigin productIdOrigin2 = EVENT_OVERRIDE;
            SparseArray<ProductIdOrigin> sparseArray = new SparseArray<>();
            valueMap = sparseArray;
            sparseArray.put(0, productIdOrigin);
            sparseArray.put(5, productIdOrigin2);
        }

        ProductIdOrigin(int i5) {
            this.value = i5;
        }
    }

    public static Builder builder() {
        return new AutoValue_ComplianceData.Builder();
    }

    public abstract ExternalPrivacyContext getPrivacyContext();

    public abstract ProductIdOrigin getProductIdOrigin();
}
