package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.auto.value.AutoValue;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.conscrypt.BuildConfig;

@AutoValue
/* loaded from: classes.dex */
public abstract class EventInternal {

    @AutoValue.Builder
    /* loaded from: classes.dex */
    public static abstract class Builder {
        public final Builder addMetadata(String str, String str2) {
            getAutoMetadata().put(str, str2);
            return this;
        }

        public abstract EventInternal build();

        protected abstract Map<String, String> getAutoMetadata();

        protected abstract Builder setAutoMetadata(Map<String, String> map);

        public abstract Builder setCode(Integer num);

        public abstract Builder setEncodedPayload(EncodedPayload encodedPayload);

        public abstract Builder setEventMillis(long j5);

        public abstract Builder setExperimentIdsClear(byte[] bArr);

        public abstract Builder setExperimentIdsEncrypted(byte[] bArr);

        public abstract Builder setProductId(Integer num);

        public abstract Builder setPseudonymousId(String str);

        public abstract Builder setTransportName(String str);

        public abstract Builder setUptimeMillis(long j5);

        public final Builder addMetadata(String str, long j5) {
            getAutoMetadata().put(str, String.valueOf(j5));
            return this;
        }

        public final Builder addMetadata(String str, int i5) {
            getAutoMetadata().put(str, String.valueOf(i5));
            return this;
        }
    }

    public static Builder builder() {
        return new AutoValue_EventInternal.Builder().setAutoMetadata(new HashMap());
    }

    public final String get(String str) {
        String str2 = getAutoMetadata().get(str);
        return str2 == null ? BuildConfig.FLAVOR : str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Map<String, String> getAutoMetadata();

    public abstract Integer getCode();

    public abstract EncodedPayload getEncodedPayload();

    public abstract long getEventMillis();

    public abstract byte[] getExperimentIdsClear();

    public abstract byte[] getExperimentIdsEncrypted();

    public final int getInteger(String str) {
        String str2 = getAutoMetadata().get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final long getLong(String str) {
        String str2 = getAutoMetadata().get(str);
        if (str2 == null) {
            return 0L;
        }
        return Long.valueOf(str2).longValue();
    }

    public final Map<String, String> getMetadata() {
        return Collections.unmodifiableMap(getAutoMetadata());
    }

    public abstract Integer getProductId();

    public abstract String getPseudonymousId();

    public abstract String getTransportName();

    public abstract long getUptimeMillis();

    public Builder toBuilder() {
        return new AutoValue_EventInternal.Builder().setTransportName(getTransportName()).setCode(getCode()).setProductId(getProductId()).setPseudonymousId(getPseudonymousId()).setExperimentIdsClear(getExperimentIdsClear()).setExperimentIdsEncrypted(getExperimentIdsEncrypted()).setEncodedPayload(getEncodedPayload()).setEventMillis(getEventMillis()).setUptimeMillis(getUptimeMillis()).setAutoMetadata(new HashMap(getAutoMetadata()));
    }
}
