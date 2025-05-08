package com.google.firebase.perf.metrics;

import com.google.firebase.perf.application.AppStateMonitor;
import com.google.firebase.perf.application.AppStateUpdateHandler;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.network.NetworkRequestMetricBuilderUtil;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.session.SessionAwareObject;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class NetworkRequestMetricBuilder extends AppStateUpdateHandler implements SessionAwareObject {
    private static final char HIGHEST_ASCII_CHAR = 127;
    private static final char HIGHEST_CONTROL_CHAR = 31;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final NetworkRequestMetric.Builder builder;
    private final GaugeManager gaugeManager;
    private boolean isManualNetworkRequestMetric;
    private boolean isReportSent;
    private final List<PerfSession> sessions;
    private final TransportManager transportManager;
    private String userAgent;
    private final WeakReference<SessionAwareObject> weakReference;

    private NetworkRequestMetricBuilder(TransportManager transportManager) {
        this(transportManager, AppStateMonitor.getInstance(), GaugeManager.getInstance());
    }

    public static NetworkRequestMetricBuilder builder(TransportManager transportManager) {
        return new NetworkRequestMetricBuilder(transportManager);
    }

    private boolean hasStarted() {
        return this.builder.hasClientStartTimeUs();
    }

    private boolean isStopped() {
        return this.builder.hasTimeToResponseCompletedUs();
    }

    private static boolean isValidContentType(String str) {
        if (str.length() > 128) {
            return false;
        }
        for (int i5 = 0; i5 < str.length(); i5++) {
            char charAt = str.charAt(i5);
            if (charAt <= 31 || charAt > 127) {
                return false;
            }
        }
        return true;
    }

    public NetworkRequestMetric build() {
        SessionManager.getInstance().unregisterForSessionUpdates(this.weakReference);
        unregisterForAppState();
        com.google.firebase.perf.v1.PerfSession[] buildAndSort = PerfSession.buildAndSort(getSessions());
        if (buildAndSort != null) {
            this.builder.addAllPerfSessions(Arrays.asList(buildAndSort));
        }
        NetworkRequestMetric build = this.builder.build();
        if (!NetworkRequestMetricBuilderUtil.isAllowedUserAgent(this.userAgent)) {
            logger.debug("Dropping network request from a 'User-Agent' that is not allowed");
            return build;
        }
        if (this.isReportSent) {
            if (this.isManualNetworkRequestMetric) {
                logger.debug("This metric has already been queued for transmission.  Please create a new HttpMetric for each request/response");
            }
            return build;
        }
        this.transportManager.log(build, getAppState());
        this.isReportSent = true;
        return build;
    }

    List<PerfSession> getSessions() {
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

    public long getTimeToResponseInitiatedMicros() {
        return this.builder.getTimeToResponseInitiatedUs();
    }

    public boolean hasHttpResponseCode() {
        return this.builder.hasHttpResponseCode();
    }

    public NetworkRequestMetricBuilder setHttpMethod(String str) {
        NetworkRequestMetric.HttpMethod httpMethod;
        if (str != null) {
            NetworkRequestMetric.HttpMethod httpMethod2 = NetworkRequestMetric.HttpMethod.HTTP_METHOD_UNKNOWN;
            String upperCase = str.toUpperCase();
            upperCase.hashCode();
            char c5 = 65535;
            switch (upperCase.hashCode()) {
                case -531492226:
                    if (upperCase.equals("OPTIONS")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case 70454:
                    if (upperCase.equals("GET")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 79599:
                    if (upperCase.equals("PUT")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 2213344:
                    if (upperCase.equals("HEAD")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case 2461856:
                    if (upperCase.equals("POST")) {
                        c5 = 4;
                        break;
                    }
                    break;
                case 75900968:
                    if (upperCase.equals("PATCH")) {
                        c5 = 5;
                        break;
                    }
                    break;
                case 80083237:
                    if (upperCase.equals("TRACE")) {
                        c5 = 6;
                        break;
                    }
                    break;
                case 1669334218:
                    if (upperCase.equals("CONNECT")) {
                        c5 = 7;
                        break;
                    }
                    break;
                case 2012838315:
                    if (upperCase.equals("DELETE")) {
                        c5 = '\b';
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    httpMethod = NetworkRequestMetric.HttpMethod.OPTIONS;
                    break;
                case 1:
                    httpMethod = NetworkRequestMetric.HttpMethod.GET;
                    break;
                case 2:
                    httpMethod = NetworkRequestMetric.HttpMethod.PUT;
                    break;
                case 3:
                    httpMethod = NetworkRequestMetric.HttpMethod.HEAD;
                    break;
                case 4:
                    httpMethod = NetworkRequestMetric.HttpMethod.POST;
                    break;
                case 5:
                    httpMethod = NetworkRequestMetric.HttpMethod.PATCH;
                    break;
                case 6:
                    httpMethod = NetworkRequestMetric.HttpMethod.TRACE;
                    break;
                case 7:
                    httpMethod = NetworkRequestMetric.HttpMethod.CONNECT;
                    break;
                case '\b':
                    httpMethod = NetworkRequestMetric.HttpMethod.DELETE;
                    break;
                default:
                    httpMethod = NetworkRequestMetric.HttpMethod.HTTP_METHOD_UNKNOWN;
                    break;
            }
            this.builder.setHttpMethod(httpMethod);
        }
        return this;
    }

    public NetworkRequestMetricBuilder setHttpResponseCode(int i5) {
        this.builder.setHttpResponseCode(i5);
        return this;
    }

    public NetworkRequestMetricBuilder setNetworkClientErrorReason() {
        this.builder.setNetworkClientErrorReason(NetworkRequestMetric.NetworkClientErrorReason.GENERIC_CLIENT_ERROR);
        return this;
    }

    public NetworkRequestMetricBuilder setRequestPayloadBytes(long j5) {
        this.builder.setRequestPayloadBytes(j5);
        return this;
    }

    public NetworkRequestMetricBuilder setRequestStartTimeMicros(long j5) {
        PerfSession perfSession = SessionManager.getInstance().perfSession();
        SessionManager.getInstance().registerForSessionUpdates(this.weakReference);
        this.builder.setClientStartTimeUs(j5);
        updateSession(perfSession);
        if (perfSession.isGaugeAndEventCollectionEnabled()) {
            this.gaugeManager.collectGaugeMetricOnce(perfSession.getTimer());
        }
        return this;
    }

    public NetworkRequestMetricBuilder setResponseContentType(String str) {
        if (str == null) {
            this.builder.clearResponseContentType();
            return this;
        }
        if (isValidContentType(str)) {
            this.builder.setResponseContentType(str);
        } else {
            logger.warn("The content type of the response is not a valid content-type:" + str);
        }
        return this;
    }

    public NetworkRequestMetricBuilder setResponsePayloadBytes(long j5) {
        this.builder.setResponsePayloadBytes(j5);
        return this;
    }

    public NetworkRequestMetricBuilder setTimeToRequestCompletedMicros(long j5) {
        this.builder.setTimeToRequestCompletedUs(j5);
        return this;
    }

    public NetworkRequestMetricBuilder setTimeToResponseCompletedMicros(long j5) {
        this.builder.setTimeToResponseCompletedUs(j5);
        if (SessionManager.getInstance().perfSession().isGaugeAndEventCollectionEnabled()) {
            this.gaugeManager.collectGaugeMetricOnce(SessionManager.getInstance().perfSession().getTimer());
        }
        return this;
    }

    public NetworkRequestMetricBuilder setTimeToResponseInitiatedMicros(long j5) {
        this.builder.setTimeToResponseInitiatedUs(j5);
        return this;
    }

    public NetworkRequestMetricBuilder setUrl(String str) {
        if (str != null) {
            this.builder.setUrl(Utils.truncateURL(Utils.stripSensitiveInfo(str), 2000));
        }
        return this;
    }

    public NetworkRequestMetricBuilder setUserAgent(String str) {
        this.userAgent = str;
        return this;
    }

    @Override // com.google.firebase.perf.session.SessionAwareObject
    public void updateSession(PerfSession perfSession) {
        if (perfSession == null) {
            logger.warn("Unable to add new SessionId to the Network Trace. Continuing without it.");
        } else {
            if (!hasStarted() || isStopped()) {
                return;
            }
            this.sessions.add(perfSession);
        }
    }

    public NetworkRequestMetricBuilder(TransportManager transportManager, AppStateMonitor appStateMonitor, GaugeManager gaugeManager) {
        super(appStateMonitor);
        this.builder = NetworkRequestMetric.newBuilder();
        this.weakReference = new WeakReference<>(this);
        this.transportManager = transportManager;
        this.gaugeManager = gaugeManager;
        this.sessions = Collections.synchronizedList(new ArrayList());
        registerForAppState();
    }
}
