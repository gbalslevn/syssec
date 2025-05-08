package com.google.firebase.perf.session;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.PerfSession;
import com.google.firebase.perf.v1.SessionVerbosity;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public class PerfSession implements Parcelable {
    public static final Parcelable.Creator<PerfSession> CREATOR = new Parcelable.Creator<PerfSession>() { // from class: com.google.firebase.perf.session.PerfSession.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PerfSession createFromParcel(Parcel parcel) {
            return new PerfSession(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PerfSession[] newArray(int i5) {
            return new PerfSession[i5];
        }
    };
    private final Timer creationTime;
    private boolean isGaugeAndEventCollectionEnabled;
    private final String sessionId;

    public static com.google.firebase.perf.v1.PerfSession[] buildAndSort(List<PerfSession> list) {
        if (list.isEmpty()) {
            return null;
        }
        com.google.firebase.perf.v1.PerfSession[] perfSessionArr = new com.google.firebase.perf.v1.PerfSession[list.size()];
        com.google.firebase.perf.v1.PerfSession build = list.get(0).build();
        boolean z5 = false;
        for (int i5 = 1; i5 < list.size(); i5++) {
            com.google.firebase.perf.v1.PerfSession build2 = list.get(i5).build();
            if (z5 || !list.get(i5).isVerbose()) {
                perfSessionArr[i5] = build2;
            } else {
                perfSessionArr[0] = build2;
                perfSessionArr[i5] = build;
                z5 = true;
            }
        }
        if (!z5) {
            perfSessionArr[0] = build;
        }
        return perfSessionArr;
    }

    public static PerfSession createWithId(String str) {
        PerfSession perfSession = new PerfSession(str.replace("-", BuildConfig.FLAVOR), new Clock());
        perfSession.setGaugeAndEventCollectionEnabled(shouldCollectGaugesAndEvents());
        return perfSession;
    }

    public static boolean shouldCollectGaugesAndEvents() {
        ConfigResolver configResolver = ConfigResolver.getInstance();
        return configResolver.isPerformanceMonitoringEnabled() && Math.random() < configResolver.getSessionsSamplingRate();
    }

    public com.google.firebase.perf.v1.PerfSession build() {
        PerfSession.Builder sessionId = com.google.firebase.perf.v1.PerfSession.newBuilder().setSessionId(this.sessionId);
        if (this.isGaugeAndEventCollectionEnabled) {
            sessionId.addSessionVerbosity(SessionVerbosity.GAUGES_AND_SYSTEM_EVENTS);
        }
        return sessionId.build();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Timer getTimer() {
        return this.creationTime;
    }

    public boolean isGaugeAndEventCollectionEnabled() {
        return this.isGaugeAndEventCollectionEnabled;
    }

    public boolean isSessionRunningTooLong() {
        return TimeUnit.MICROSECONDS.toMinutes(this.creationTime.getDurationMicros()) > ConfigResolver.getInstance().getSessionsMaxDurationMinutes();
    }

    public boolean isVerbose() {
        return this.isGaugeAndEventCollectionEnabled;
    }

    public String sessionId() {
        return this.sessionId;
    }

    public void setGaugeAndEventCollectionEnabled(boolean z5) {
        this.isGaugeAndEventCollectionEnabled = z5;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeString(this.sessionId);
        parcel.writeByte(this.isGaugeAndEventCollectionEnabled ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.creationTime, 0);
    }

    public PerfSession(String str, Clock clock) {
        this.isGaugeAndEventCollectionEnabled = false;
        this.sessionId = str;
        this.creationTime = clock.getTime();
    }

    private PerfSession(Parcel parcel) {
        this.isGaugeAndEventCollectionEnabled = false;
        this.sessionId = parcel.readString();
        this.isGaugeAndEventCollectionEnabled = parcel.readByte() != 0;
        this.creationTime = (Timer) parcel.readParcelable(Timer.class.getClassLoader());
    }
}
