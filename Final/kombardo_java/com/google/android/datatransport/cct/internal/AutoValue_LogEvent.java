package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.LogEvent;
import java.util.Arrays;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
final class AutoValue_LogEvent extends LogEvent {
    private final ComplianceData complianceData;
    private final Integer eventCode;
    private final long eventTimeMs;
    private final long eventUptimeMs;
    private final ExperimentIds experimentIds;
    private final NetworkConnectionInfo networkConnectionInfo;
    private final byte[] sourceExtension;
    private final String sourceExtensionJsonProto3;
    private final long timezoneOffsetSeconds;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class Builder extends LogEvent.Builder {
        private ComplianceData complianceData;
        private Integer eventCode;
        private Long eventTimeMs;
        private Long eventUptimeMs;
        private ExperimentIds experimentIds;
        private NetworkConnectionInfo networkConnectionInfo;
        private byte[] sourceExtension;
        private String sourceExtensionJsonProto3;
        private Long timezoneOffsetSeconds;

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent build() {
            Long l5 = this.eventTimeMs;
            String str = BuildConfig.FLAVOR;
            if (l5 == null) {
                str = BuildConfig.FLAVOR + " eventTimeMs";
            }
            if (this.eventUptimeMs == null) {
                str = str + " eventUptimeMs";
            }
            if (this.timezoneOffsetSeconds == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new AutoValue_LogEvent(this.eventTimeMs.longValue(), this.eventCode, this.complianceData, this.eventUptimeMs.longValue(), this.sourceExtension, this.sourceExtensionJsonProto3, this.timezoneOffsetSeconds.longValue(), this.networkConnectionInfo, this.experimentIds);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder setComplianceData(ComplianceData complianceData) {
            this.complianceData = complianceData;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder setEventCode(Integer num) {
            this.eventCode = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder setEventTimeMs(long j5) {
            this.eventTimeMs = Long.valueOf(j5);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder setEventUptimeMs(long j5) {
            this.eventUptimeMs = Long.valueOf(j5);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder setExperimentIds(ExperimentIds experimentIds) {
            this.experimentIds = experimentIds;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder setNetworkConnectionInfo(NetworkConnectionInfo networkConnectionInfo) {
            this.networkConnectionInfo = networkConnectionInfo;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        LogEvent.Builder setSourceExtension(byte[] bArr) {
            this.sourceExtension = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        LogEvent.Builder setSourceExtensionJsonProto3(String str) {
            this.sourceExtensionJsonProto3 = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder setTimezoneOffsetSeconds(long j5) {
            this.timezoneOffsetSeconds = Long.valueOf(j5);
            return this;
        }
    }

    public boolean equals(Object obj) {
        Integer num;
        ComplianceData complianceData;
        String str;
        NetworkConnectionInfo networkConnectionInfo;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogEvent)) {
            return false;
        }
        LogEvent logEvent = (LogEvent) obj;
        if (this.eventTimeMs == logEvent.getEventTimeMs() && ((num = this.eventCode) != null ? num.equals(logEvent.getEventCode()) : logEvent.getEventCode() == null) && ((complianceData = this.complianceData) != null ? complianceData.equals(logEvent.getComplianceData()) : logEvent.getComplianceData() == null) && this.eventUptimeMs == logEvent.getEventUptimeMs()) {
            if (Arrays.equals(this.sourceExtension, logEvent instanceof AutoValue_LogEvent ? ((AutoValue_LogEvent) logEvent).sourceExtension : logEvent.getSourceExtension()) && ((str = this.sourceExtensionJsonProto3) != null ? str.equals(logEvent.getSourceExtensionJsonProto3()) : logEvent.getSourceExtensionJsonProto3() == null) && this.timezoneOffsetSeconds == logEvent.getTimezoneOffsetSeconds() && ((networkConnectionInfo = this.networkConnectionInfo) != null ? networkConnectionInfo.equals(logEvent.getNetworkConnectionInfo()) : logEvent.getNetworkConnectionInfo() == null)) {
                ExperimentIds experimentIds = this.experimentIds;
                if (experimentIds == null) {
                    if (logEvent.getExperimentIds() == null) {
                        return true;
                    }
                } else if (experimentIds.equals(logEvent.getExperimentIds())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public ComplianceData getComplianceData() {
        return this.complianceData;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public Integer getEventCode() {
        return this.eventCode;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public long getEventTimeMs() {
        return this.eventTimeMs;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public long getEventUptimeMs() {
        return this.eventUptimeMs;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public ExperimentIds getExperimentIds() {
        return this.experimentIds;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public NetworkConnectionInfo getNetworkConnectionInfo() {
        return this.networkConnectionInfo;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public byte[] getSourceExtension() {
        return this.sourceExtension;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public String getSourceExtensionJsonProto3() {
        return this.sourceExtensionJsonProto3;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public long getTimezoneOffsetSeconds() {
        return this.timezoneOffsetSeconds;
    }

    public int hashCode() {
        long j5 = this.eventTimeMs;
        int i5 = (((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.eventCode;
        int hashCode = (i5 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        ComplianceData complianceData = this.complianceData;
        int hashCode2 = complianceData == null ? 0 : complianceData.hashCode();
        long j6 = this.eventUptimeMs;
        int hashCode3 = (((((hashCode ^ hashCode2) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.sourceExtension)) * 1000003;
        String str = this.sourceExtensionJsonProto3;
        int hashCode4 = str == null ? 0 : str.hashCode();
        long j7 = this.timezoneOffsetSeconds;
        int i6 = (((hashCode3 ^ hashCode4) * 1000003) ^ ((int) ((j7 >>> 32) ^ j7))) * 1000003;
        NetworkConnectionInfo networkConnectionInfo = this.networkConnectionInfo;
        int hashCode5 = (i6 ^ (networkConnectionInfo == null ? 0 : networkConnectionInfo.hashCode())) * 1000003;
        ExperimentIds experimentIds = this.experimentIds;
        return hashCode5 ^ (experimentIds != null ? experimentIds.hashCode() : 0);
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.eventTimeMs + ", eventCode=" + this.eventCode + ", complianceData=" + this.complianceData + ", eventUptimeMs=" + this.eventUptimeMs + ", sourceExtension=" + Arrays.toString(this.sourceExtension) + ", sourceExtensionJsonProto3=" + this.sourceExtensionJsonProto3 + ", timezoneOffsetSeconds=" + this.timezoneOffsetSeconds + ", networkConnectionInfo=" + this.networkConnectionInfo + ", experimentIds=" + this.experimentIds + "}";
    }

    private AutoValue_LogEvent(long j5, Integer num, ComplianceData complianceData, long j6, byte[] bArr, String str, long j7, NetworkConnectionInfo networkConnectionInfo, ExperimentIds experimentIds) {
        this.eventTimeMs = j5;
        this.eventCode = num;
        this.complianceData = complianceData;
        this.eventUptimeMs = j6;
        this.sourceExtension = bArr;
        this.sourceExtensionJsonProto3 = str;
        this.timezoneOffsetSeconds = j7;
        this.networkConnectionInfo = networkConnectionInfo;
        this.experimentIds = experimentIds;
    }
}
