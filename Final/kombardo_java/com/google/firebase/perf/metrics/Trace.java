package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.firebase.perf.application.AppStateMonitor;
import com.google.firebase.perf.application.AppStateUpdateHandler;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.metrics.validator.PerfMetricValidator;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.session.SessionAwareObject;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Timer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class Trace extends AppStateUpdateHandler implements Parcelable, SessionAwareObject {
    private final Clock clock;
    private final Map<String, Counter> counterNameToCounterMap;
    private final Map<String, String> customAttributesMap;
    private Timer endTime;
    private final GaugeManager gaugeManager;
    private final String name;
    private final Trace parent;
    private final WeakReference<SessionAwareObject> sessionAwareObject;
    private final List<PerfSession> sessions;
    private Timer startTime;
    private final List<Trace> subtraces;
    private final TransportManager transportManager;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private static final Map<String, Trace> traceNameToTraceMap = new ConcurrentHashMap();

    @Keep
    public static final Parcelable.Creator<Trace> CREATOR = new Parcelable.Creator<Trace>() { // from class: com.google.firebase.perf.metrics.Trace.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Trace createFromParcel(Parcel parcel) {
            return new Trace(parcel, false);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Trace[] newArray(int i5) {
            return new Trace[i5];
        }
    };
    static final Parcelable.Creator<Trace> CREATOR_DATAONLY = new Parcelable.Creator<Trace>() { // from class: com.google.firebase.perf.metrics.Trace.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Trace createFromParcel(Parcel parcel) {
            return new Trace(parcel, true);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Trace[] newArray(int i5) {
            return new Trace[i5];
        }
    };

    private void checkAttribute(String str, String str2) {
        if (isStopped()) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Trace '%s' has been stopped", this.name));
        }
        if (!this.customAttributesMap.containsKey(str) && this.customAttributesMap.size() >= 5) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Exceeds max limit of number of attributes - %d", 5));
        }
        PerfMetricValidator.validateAttribute(str, str2);
    }

    private Counter obtainOrCreateCounterByName(String str) {
        Counter counter = this.counterNameToCounterMap.get(str);
        if (counter != null) {
            return counter;
        }
        Counter counter2 = new Counter(str);
        this.counterNameToCounterMap.put(str, counter2);
        return counter2;
    }

    private void setEndTimeOfLastStage(Timer timer) {
        if (this.subtraces.isEmpty()) {
            return;
        }
        Trace trace = this.subtraces.get(this.subtraces.size() - 1);
        if (trace.endTime == null) {
            trace.endTime = timer;
        }
    }

    @Override // android.os.Parcelable
    @Keep
    public int describeContents() {
        return 0;
    }

    protected void finalize() {
        try {
            if (isActive()) {
                logger.warn("Trace '%s' is started but not stopped when it is destructed!", this.name);
                incrementTsnsCount(1);
            }
        } finally {
            super.finalize();
        }
    }

    @Keep
    public String getAttribute(String str) {
        return this.customAttributesMap.get(str);
    }

    @Keep
    public Map<String, String> getAttributes() {
        return new HashMap(this.customAttributesMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, Counter> getCounters() {
        return this.counterNameToCounterMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Timer getEndTime() {
        return this.endTime;
    }

    @Keep
    public long getLongMetric(String str) {
        Counter counter = str != null ? this.counterNameToCounterMap.get(str.trim()) : null;
        if (counter == null) {
            return 0L;
        }
        return counter.getCount();
    }

    public String getName() {
        return this.name;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<PerfSession> getSessions() {
        List<PerfSession> unmodifiableList;
        synchronized (this.sessions) {
            try {
                ArrayList arrayList = new ArrayList();
                for (PerfSession perfSession : this.sessions) {
                    if (perfSession != null) {
                        arrayList.add(perfSession);
                    }
                }
                unmodifiableList = Collections.unmodifiableList(arrayList);
            } catch (Throwable th) {
                throw th;
            }
        }
        return unmodifiableList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Timer getStartTime() {
        return this.startTime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Trace> getSubtraces() {
        return this.subtraces;
    }

    boolean hasStarted() {
        return this.startTime != null;
    }

    @Keep
    public void incrementMetric(String str, long j5) {
        String validateMetricName = PerfMetricValidator.validateMetricName(str);
        if (validateMetricName != null) {
            logger.error("Cannot increment metric '%s'. Metric name is invalid.(%s)", str, validateMetricName);
            return;
        }
        if (!hasStarted()) {
            logger.warn("Cannot increment metric '%s' for trace '%s' because it's not started", str, this.name);
        } else {
            if (isStopped()) {
                logger.warn("Cannot increment metric '%s' for trace '%s' because it's been stopped", str, this.name);
                return;
            }
            Counter obtainOrCreateCounterByName = obtainOrCreateCounterByName(str.trim());
            obtainOrCreateCounterByName.increment(j5);
            logger.debug("Incrementing metric '%s' to %d on trace '%s'", str, Long.valueOf(obtainOrCreateCounterByName.getCount()), this.name);
        }
    }

    boolean isActive() {
        return hasStarted() && !isStopped();
    }

    boolean isStopped() {
        return this.endTime != null;
    }

    @Keep
    public void putAttribute(String str, String str2) {
        boolean z5;
        try {
            str = str.trim();
            str2 = str2.trim();
            checkAttribute(str, str2);
            logger.debug("Setting attribute '%s' to '%s' on trace '%s'", str, str2, this.name);
            z5 = true;
        } catch (Exception e5) {
            logger.error("Can not set attribute '%s' with value '%s' (%s)", str, str2, e5.getMessage());
            z5 = false;
        }
        if (z5) {
            this.customAttributesMap.put(str, str2);
        }
    }

    @Keep
    public void putMetric(String str, long j5) {
        String validateMetricName = PerfMetricValidator.validateMetricName(str);
        if (validateMetricName != null) {
            logger.error("Cannot set value for metric '%s'. Metric name is invalid.(%s)", str, validateMetricName);
            return;
        }
        if (!hasStarted()) {
            logger.warn("Cannot set value for metric '%s' for trace '%s' because it's not started", str, this.name);
        } else if (isStopped()) {
            logger.warn("Cannot set value for metric '%s' for trace '%s' because it's been stopped", str, this.name);
        } else {
            obtainOrCreateCounterByName(str.trim()).setCount(j5);
            logger.debug("Setting metric '%s' to '%s' on trace '%s'", str, Long.valueOf(j5), this.name);
        }
    }

    @Keep
    public void removeAttribute(String str) {
        if (isStopped()) {
            logger.error("Can't remove a attribute from a Trace that's stopped.");
        } else {
            this.customAttributesMap.remove(str);
        }
    }

    @Keep
    public void start() {
        if (!ConfigResolver.getInstance().isPerformanceMonitoringEnabled()) {
            logger.debug("Trace feature is disabled.");
            return;
        }
        String validateTraceName = PerfMetricValidator.validateTraceName(this.name);
        if (validateTraceName != null) {
            logger.error("Cannot start trace '%s'. Trace name is invalid.(%s)", this.name, validateTraceName);
            return;
        }
        if (this.startTime != null) {
            logger.error("Trace '%s' has already started, should not start again!", this.name);
            return;
        }
        this.startTime = this.clock.getTime();
        registerForAppState();
        PerfSession perfSession = SessionManager.getInstance().perfSession();
        SessionManager.getInstance().registerForSessionUpdates(this.sessionAwareObject);
        updateSession(perfSession);
        if (perfSession.isGaugeAndEventCollectionEnabled()) {
            this.gaugeManager.collectGaugeMetricOnce(perfSession.getTimer());
        }
    }

    @Keep
    public void stop() {
        if (!hasStarted()) {
            logger.error("Trace '%s' has not been started so unable to stop!", this.name);
            return;
        }
        if (isStopped()) {
            logger.error("Trace '%s' has already stopped, should not stop again!", this.name);
            return;
        }
        SessionManager.getInstance().unregisterForSessionUpdates(this.sessionAwareObject);
        unregisterForAppState();
        Timer time = this.clock.getTime();
        this.endTime = time;
        if (this.parent == null) {
            setEndTimeOfLastStage(time);
            if (this.name.isEmpty()) {
                logger.error("Trace name is empty, no log is sent to server");
                return;
            }
            this.transportManager.log(new TraceMetricBuilder(this).build(), getAppState());
            if (SessionManager.getInstance().perfSession().isGaugeAndEventCollectionEnabled()) {
                this.gaugeManager.collectGaugeMetricOnce(SessionManager.getInstance().perfSession().getTimer());
            }
        }
    }

    @Override // com.google.firebase.perf.session.SessionAwareObject
    public void updateSession(PerfSession perfSession) {
        if (perfSession == null) {
            logger.warn("Unable to add new SessionId to the Trace. Continuing without it.");
        } else {
            if (!hasStarted() || isStopped()) {
                return;
            }
            this.sessions.add(perfSession);
        }
    }

    @Override // android.os.Parcelable
    @Keep
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeParcelable(this.parent, 0);
        parcel.writeString(this.name);
        parcel.writeList(this.subtraces);
        parcel.writeMap(this.counterNameToCounterMap);
        parcel.writeParcelable(this.startTime, 0);
        parcel.writeParcelable(this.endTime, 0);
        synchronized (this.sessions) {
            parcel.writeList(this.sessions);
        }
    }

    public Trace(String str, TransportManager transportManager, Clock clock, AppStateMonitor appStateMonitor) {
        this(str, transportManager, clock, appStateMonitor, GaugeManager.getInstance());
    }

    public Trace(String str, TransportManager transportManager, Clock clock, AppStateMonitor appStateMonitor, GaugeManager gaugeManager) {
        super(appStateMonitor);
        this.sessionAwareObject = new WeakReference<>(this);
        this.parent = null;
        this.name = str.trim();
        this.subtraces = new ArrayList();
        this.counterNameToCounterMap = new ConcurrentHashMap();
        this.customAttributesMap = new ConcurrentHashMap();
        this.clock = clock;
        this.transportManager = transportManager;
        this.sessions = Collections.synchronizedList(new ArrayList());
        this.gaugeManager = gaugeManager;
    }

    private Trace(Parcel parcel, boolean z5) {
        super(z5 ? null : AppStateMonitor.getInstance());
        this.sessionAwareObject = new WeakReference<>(this);
        this.parent = (Trace) parcel.readParcelable(Trace.class.getClassLoader());
        this.name = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.subtraces = arrayList;
        parcel.readList(arrayList, Trace.class.getClassLoader());
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.counterNameToCounterMap = concurrentHashMap;
        this.customAttributesMap = new ConcurrentHashMap();
        parcel.readMap(concurrentHashMap, Counter.class.getClassLoader());
        this.startTime = (Timer) parcel.readParcelable(Timer.class.getClassLoader());
        this.endTime = (Timer) parcel.readParcelable(Timer.class.getClassLoader());
        List<PerfSession> synchronizedList = Collections.synchronizedList(new ArrayList());
        this.sessions = synchronizedList;
        parcel.readList(synchronizedList, PerfSession.class.getClassLoader());
        if (z5) {
            this.transportManager = null;
            this.clock = null;
            this.gaugeManager = null;
        } else {
            this.transportManager = TransportManager.getInstance();
            this.clock = new Clock();
            this.gaugeManager = GaugeManager.getInstance();
        }
    }
}
