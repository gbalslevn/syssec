package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AutoValue_ClientInfo;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes.dex */
public abstract class ClientInfo {

    @AutoValue.Builder
    /* loaded from: classes.dex */
    public static abstract class Builder {
        public abstract ClientInfo build();

        public abstract Builder setAndroidClientInfo(AndroidClientInfo androidClientInfo);

        public abstract Builder setClientType(ClientType clientType);
    }

    /* loaded from: classes.dex */
    public enum ClientType {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);

        private final int value;

        ClientType(int i5) {
            this.value = i5;
        }
    }

    public static Builder builder() {
        return new AutoValue_ClientInfo.Builder();
    }

    public abstract AndroidClientInfo getAndroidClientInfo();

    public abstract ClientType getClientType();
}
