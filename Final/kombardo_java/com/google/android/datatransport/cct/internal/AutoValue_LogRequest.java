package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.LogRequest;
import java.util.List;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
final class AutoValue_LogRequest extends LogRequest {
    private final ClientInfo clientInfo;
    private final List<LogEvent> logEvents;
    private final Integer logSource;
    private final String logSourceName;
    private final QosTier qosTier;
    private final long requestTimeMs;
    private final long requestUptimeMs;

    /* loaded from: classes.dex */
    static final class Builder extends LogRequest.Builder {
        private ClientInfo clientInfo;
        private List<LogEvent> logEvents;
        private Integer logSource;
        private String logSourceName;
        private QosTier qosTier;
        private Long requestTimeMs;
        private Long requestUptimeMs;

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest build() {
            Long l5 = this.requestTimeMs;
            String str = BuildConfig.FLAVOR;
            if (l5 == null) {
                str = BuildConfig.FLAVOR + " requestTimeMs";
            }
            if (this.requestUptimeMs == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new AutoValue_LogRequest(this.requestTimeMs.longValue(), this.requestUptimeMs.longValue(), this.clientInfo, this.logSource, this.logSourceName, this.logEvents, this.qosTier);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder setClientInfo(ClientInfo clientInfo) {
            this.clientInfo = clientInfo;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder setLogEvents(List<LogEvent> list) {
            this.logEvents = list;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        LogRequest.Builder setLogSource(Integer num) {
            this.logSource = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        LogRequest.Builder setLogSourceName(String str) {
            this.logSourceName = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder setQosTier(QosTier qosTier) {
            this.qosTier = qosTier;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder setRequestTimeMs(long j5) {
            this.requestTimeMs = Long.valueOf(j5);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder setRequestUptimeMs(long j5) {
            this.requestUptimeMs = Long.valueOf(j5);
            return this;
        }
    }

    public boolean equals(Object obj) {
        ClientInfo clientInfo;
        Integer num;
        String str;
        List<LogEvent> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogRequest)) {
            return false;
        }
        LogRequest logRequest = (LogRequest) obj;
        if (this.requestTimeMs == logRequest.getRequestTimeMs() && this.requestUptimeMs == logRequest.getRequestUptimeMs() && ((clientInfo = this.clientInfo) != null ? clientInfo.equals(logRequest.getClientInfo()) : logRequest.getClientInfo() == null) && ((num = this.logSource) != null ? num.equals(logRequest.getLogSource()) : logRequest.getLogSource() == null) && ((str = this.logSourceName) != null ? str.equals(logRequest.getLogSourceName()) : logRequest.getLogSourceName() == null) && ((list = this.logEvents) != null ? list.equals(logRequest.getLogEvents()) : logRequest.getLogEvents() == null)) {
            QosTier qosTier = this.qosTier;
            if (qosTier == null) {
                if (logRequest.getQosTier() == null) {
                    return true;
                }
            } else if (qosTier.equals(logRequest.getQosTier())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public ClientInfo getClientInfo() {
        return this.clientInfo;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public List<LogEvent> getLogEvents() {
        return this.logEvents;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public Integer getLogSource() {
        return this.logSource;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public String getLogSourceName() {
        return this.logSourceName;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public QosTier getQosTier() {
        return this.qosTier;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public long getRequestTimeMs() {
        return this.requestTimeMs;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public long getRequestUptimeMs() {
        return this.requestUptimeMs;
    }

    public int hashCode() {
        long j5 = this.requestTimeMs;
        long j6 = this.requestUptimeMs;
        int i5 = (((((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j6 >>> 32) ^ j6))) * 1000003;
        ClientInfo clientInfo = this.clientInfo;
        int hashCode = (i5 ^ (clientInfo == null ? 0 : clientInfo.hashCode())) * 1000003;
        Integer num = this.logSource;
        int hashCode2 = (hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.logSourceName;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<LogEvent> list = this.logEvents;
        int hashCode4 = (hashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        QosTier qosTier = this.qosTier;
        return hashCode4 ^ (qosTier != null ? qosTier.hashCode() : 0);
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.requestTimeMs + ", requestUptimeMs=" + this.requestUptimeMs + ", clientInfo=" + this.clientInfo + ", logSource=" + this.logSource + ", logSourceName=" + this.logSourceName + ", logEvents=" + this.logEvents + ", qosTier=" + this.qosTier + "}";
    }

    private AutoValue_LogRequest(long j5, long j6, ClientInfo clientInfo, Integer num, String str, List<LogEvent> list, QosTier qosTier) {
        this.requestTimeMs = j5;
        this.requestUptimeMs = j6;
        this.clientInfo = clientInfo;
        this.logSource = num;
        this.logSourceName = str;
        this.logEvents = list;
        this.qosTier = qosTier;
    }
}
