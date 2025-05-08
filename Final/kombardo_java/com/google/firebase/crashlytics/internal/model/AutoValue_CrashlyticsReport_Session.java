package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

/* loaded from: classes2.dex */
final class AutoValue_CrashlyticsReport_Session extends CrashlyticsReport.Session {
    private final CrashlyticsReport.Session.Application app;
    private final String appQualitySessionId;
    private final boolean crashed;
    private final CrashlyticsReport.Session.Device device;
    private final Long endedAt;
    private final List<CrashlyticsReport.Session.Event> events;
    private final String generator;
    private final int generatorType;
    private final String identifier;
    private final CrashlyticsReport.Session.OperatingSystem os;
    private final long startedAt;
    private final CrashlyticsReport.Session.User user;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class Builder extends CrashlyticsReport.Session.Builder {
        private CrashlyticsReport.Session.Application app;
        private String appQualitySessionId;
        private boolean crashed;
        private CrashlyticsReport.Session.Device device;
        private Long endedAt;
        private List<CrashlyticsReport.Session.Event> events;
        private String generator;
        private int generatorType;
        private String identifier;
        private CrashlyticsReport.Session.OperatingSystem os;
        private byte set$0;
        private long startedAt;
        private CrashlyticsReport.Session.User user;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session build() {
            String str;
            String str2;
            CrashlyticsReport.Session.Application application;
            if (this.set$0 == 7 && (str = this.generator) != null && (str2 = this.identifier) != null && (application = this.app) != null) {
                return new AutoValue_CrashlyticsReport_Session(str, str2, this.appQualitySessionId, this.startedAt, this.endedAt, this.crashed, application, this.user, this.os, this.device, this.events, this.generatorType);
            }
            StringBuilder sb = new StringBuilder();
            if (this.generator == null) {
                sb.append(" generator");
            }
            if (this.identifier == null) {
                sb.append(" identifier");
            }
            if ((this.set$0 & 1) == 0) {
                sb.append(" startedAt");
            }
            if ((this.set$0 & 2) == 0) {
                sb.append(" crashed");
            }
            if (this.app == null) {
                sb.append(" app");
            }
            if ((this.set$0 & 4) == 0) {
                sb.append(" generatorType");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setApp(CrashlyticsReport.Session.Application application) {
            if (application == null) {
                throw new NullPointerException("Null app");
            }
            this.app = application;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setAppQualitySessionId(String str) {
            this.appQualitySessionId = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setCrashed(boolean z5) {
            this.crashed = z5;
            this.set$0 = (byte) (this.set$0 | 2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setDevice(CrashlyticsReport.Session.Device device) {
            this.device = device;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setEndedAt(Long l5) {
            this.endedAt = l5;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setEvents(List<CrashlyticsReport.Session.Event> list) {
            this.events = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setGenerator(String str) {
            if (str == null) {
                throw new NullPointerException("Null generator");
            }
            this.generator = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setGeneratorType(int i5) {
            this.generatorType = i5;
            this.set$0 = (byte) (this.set$0 | 4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setIdentifier(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.identifier = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setOs(CrashlyticsReport.Session.OperatingSystem operatingSystem) {
            this.os = operatingSystem;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setStartedAt(long j5) {
            this.startedAt = j5;
            this.set$0 = (byte) (this.set$0 | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder setUser(CrashlyticsReport.Session.User user) {
            this.user = user;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder() {
        }

        private Builder(CrashlyticsReport.Session session) {
            this.generator = session.getGenerator();
            this.identifier = session.getIdentifier();
            this.appQualitySessionId = session.getAppQualitySessionId();
            this.startedAt = session.getStartedAt();
            this.endedAt = session.getEndedAt();
            this.crashed = session.isCrashed();
            this.app = session.getApp();
            this.user = session.getUser();
            this.os = session.getOs();
            this.device = session.getDevice();
            this.events = session.getEvents();
            this.generatorType = session.getGeneratorType();
            this.set$0 = (byte) 7;
        }
    }

    public boolean equals(Object obj) {
        String str;
        Long l5;
        CrashlyticsReport.Session.User user;
        CrashlyticsReport.Session.OperatingSystem operatingSystem;
        CrashlyticsReport.Session.Device device;
        List<CrashlyticsReport.Session.Event> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session)) {
            return false;
        }
        CrashlyticsReport.Session session = (CrashlyticsReport.Session) obj;
        return this.generator.equals(session.getGenerator()) && this.identifier.equals(session.getIdentifier()) && ((str = this.appQualitySessionId) != null ? str.equals(session.getAppQualitySessionId()) : session.getAppQualitySessionId() == null) && this.startedAt == session.getStartedAt() && ((l5 = this.endedAt) != null ? l5.equals(session.getEndedAt()) : session.getEndedAt() == null) && this.crashed == session.isCrashed() && this.app.equals(session.getApp()) && ((user = this.user) != null ? user.equals(session.getUser()) : session.getUser() == null) && ((operatingSystem = this.os) != null ? operatingSystem.equals(session.getOs()) : session.getOs() == null) && ((device = this.device) != null ? device.equals(session.getDevice()) : session.getDevice() == null) && ((list = this.events) != null ? list.equals(session.getEvents()) : session.getEvents() == null) && this.generatorType == session.getGeneratorType();
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public CrashlyticsReport.Session.Application getApp() {
        return this.app;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public String getAppQualitySessionId() {
        return this.appQualitySessionId;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public CrashlyticsReport.Session.Device getDevice() {
        return this.device;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public Long getEndedAt() {
        return this.endedAt;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public List<CrashlyticsReport.Session.Event> getEvents() {
        return this.events;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public String getGenerator() {
        return this.generator;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public int getGeneratorType() {
        return this.generatorType;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public String getIdentifier() {
        return this.identifier;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public CrashlyticsReport.Session.OperatingSystem getOs() {
        return this.os;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public long getStartedAt() {
        return this.startedAt;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public CrashlyticsReport.Session.User getUser() {
        return this.user;
    }

    public int hashCode() {
        int hashCode = (((this.generator.hashCode() ^ 1000003) * 1000003) ^ this.identifier.hashCode()) * 1000003;
        String str = this.appQualitySessionId;
        int hashCode2 = str == null ? 0 : str.hashCode();
        long j5 = this.startedAt;
        int i5 = (((hashCode ^ hashCode2) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003;
        Long l5 = this.endedAt;
        int hashCode3 = (((((i5 ^ (l5 == null ? 0 : l5.hashCode())) * 1000003) ^ (this.crashed ? 1231 : 1237)) * 1000003) ^ this.app.hashCode()) * 1000003;
        CrashlyticsReport.Session.User user = this.user;
        int hashCode4 = (hashCode3 ^ (user == null ? 0 : user.hashCode())) * 1000003;
        CrashlyticsReport.Session.OperatingSystem operatingSystem = this.os;
        int hashCode5 = (hashCode4 ^ (operatingSystem == null ? 0 : operatingSystem.hashCode())) * 1000003;
        CrashlyticsReport.Session.Device device = this.device;
        int hashCode6 = (hashCode5 ^ (device == null ? 0 : device.hashCode())) * 1000003;
        List<CrashlyticsReport.Session.Event> list = this.events;
        return ((hashCode6 ^ (list != null ? list.hashCode() : 0)) * 1000003) ^ this.generatorType;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public boolean isCrashed() {
        return this.crashed;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public CrashlyticsReport.Session.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "Session{generator=" + this.generator + ", identifier=" + this.identifier + ", appQualitySessionId=" + this.appQualitySessionId + ", startedAt=" + this.startedAt + ", endedAt=" + this.endedAt + ", crashed=" + this.crashed + ", app=" + this.app + ", user=" + this.user + ", os=" + this.os + ", device=" + this.device + ", events=" + this.events + ", generatorType=" + this.generatorType + "}";
    }

    private AutoValue_CrashlyticsReport_Session(String str, String str2, String str3, long j5, Long l5, boolean z5, CrashlyticsReport.Session.Application application, CrashlyticsReport.Session.User user, CrashlyticsReport.Session.OperatingSystem operatingSystem, CrashlyticsReport.Session.Device device, List<CrashlyticsReport.Session.Event> list, int i5) {
        this.generator = str;
        this.identifier = str2;
        this.appQualitySessionId = str3;
        this.startedAt = j5;
        this.endedAt = l5;
        this.crashed = z5;
        this.app = application;
        this.user = user;
        this.os = operatingSystem;
        this.device = device;
        this.events = list;
        this.generatorType = i5;
    }
}
