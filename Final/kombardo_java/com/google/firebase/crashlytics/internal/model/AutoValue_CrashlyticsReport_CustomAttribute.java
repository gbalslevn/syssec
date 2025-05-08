package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes2.dex */
final class AutoValue_CrashlyticsReport_CustomAttribute extends CrashlyticsReport.CustomAttribute {
    private final String key;
    private final String value;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class Builder extends CrashlyticsReport.CustomAttribute.Builder {
        private String key;
        private String value;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute.Builder
        public CrashlyticsReport.CustomAttribute build() {
            String str;
            String str2 = this.key;
            if (str2 != null && (str = this.value) != null) {
                return new AutoValue_CrashlyticsReport_CustomAttribute(str2, str);
            }
            StringBuilder sb = new StringBuilder();
            if (this.key == null) {
                sb.append(" key");
            }
            if (this.value == null) {
                sb.append(" value");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute.Builder
        public CrashlyticsReport.CustomAttribute.Builder setKey(String str) {
            if (str == null) {
                throw new NullPointerException("Null key");
            }
            this.key = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute.Builder
        public CrashlyticsReport.CustomAttribute.Builder setValue(String str) {
            if (str == null) {
                throw new NullPointerException("Null value");
            }
            this.value = str;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.CustomAttribute)) {
            return false;
        }
        CrashlyticsReport.CustomAttribute customAttribute = (CrashlyticsReport.CustomAttribute) obj;
        return this.key.equals(customAttribute.getKey()) && this.value.equals(customAttribute.getValue());
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute
    public String getKey() {
        return this.key;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute
    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return ((this.key.hashCode() ^ 1000003) * 1000003) ^ this.value.hashCode();
    }

    public String toString() {
        return "CustomAttribute{key=" + this.key + ", value=" + this.value + "}";
    }

    private AutoValue_CrashlyticsReport_CustomAttribute(String str, String str2) {
        this.key = str;
        this.value = str2;
    }
}
