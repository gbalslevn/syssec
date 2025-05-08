package com.google.firebase.perf.session;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.perf.application.AppStateMonitor;
import com.google.firebase.perf.application.AppStateUpdateHandler;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.perf.v1.ApplicationProcessState;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Keep
/* loaded from: classes2.dex */
public class SessionManager extends AppStateUpdateHandler {

    @SuppressLint({"StaticFieldLeak"})
    private static final SessionManager instance = new SessionManager();
    private final AppStateMonitor appStateMonitor;
    private final Set<WeakReference<SessionAwareObject>> clients;
    private final GaugeManager gaugeManager;
    private PerfSession perfSession;
    private Future syncInitFuture;

    private SessionManager() {
        this(GaugeManager.getInstance(), PerfSession.createWithId(UUID.randomUUID().toString()), AppStateMonitor.getInstance());
    }

    public static SessionManager getInstance() {
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setApplicationContext$0(Context context, PerfSession perfSession) {
        this.gaugeManager.initializeGaugeMetadataManager(context);
        if (perfSession.isGaugeAndEventCollectionEnabled()) {
            this.gaugeManager.logGaugeMetadata(perfSession.sessionId(), ApplicationProcessState.FOREGROUND);
        }
    }

    private void logGaugeMetadataIfCollectionEnabled(ApplicationProcessState applicationProcessState) {
        if (this.perfSession.isGaugeAndEventCollectionEnabled()) {
            this.gaugeManager.logGaugeMetadata(this.perfSession.sessionId(), applicationProcessState);
        }
    }

    private void startOrStopCollectingGauges(ApplicationProcessState applicationProcessState) {
        if (this.perfSession.isGaugeAndEventCollectionEnabled()) {
            this.gaugeManager.startCollectingGauges(this.perfSession, applicationProcessState);
        } else {
            this.gaugeManager.stopCollectingGauges();
        }
    }

    public Future getSyncInitFuture() {
        return this.syncInitFuture;
    }

    public void initializeGaugeCollection() {
        ApplicationProcessState applicationProcessState = ApplicationProcessState.FOREGROUND;
        logGaugeMetadataIfCollectionEnabled(applicationProcessState);
        startOrStopCollectingGauges(applicationProcessState);
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler, com.google.firebase.perf.application.AppStateMonitor.AppStateCallback
    public void onUpdateAppState(ApplicationProcessState applicationProcessState) {
        super.onUpdateAppState(applicationProcessState);
        if (this.appStateMonitor.isColdStart()) {
            return;
        }
        if (applicationProcessState == ApplicationProcessState.FOREGROUND) {
            updatePerfSession(PerfSession.createWithId(UUID.randomUUID().toString()));
        } else if (this.perfSession.isSessionRunningTooLong()) {
            updatePerfSession(PerfSession.createWithId(UUID.randomUUID().toString()));
        } else {
            startOrStopCollectingGauges(applicationProcessState);
        }
    }

    public final PerfSession perfSession() {
        return this.perfSession;
    }

    public void registerForSessionUpdates(WeakReference<SessionAwareObject> weakReference) {
        synchronized (this.clients) {
            this.clients.add(weakReference);
        }
    }

    public void setApplicationContext(final Context context) {
        final PerfSession perfSession = this.perfSession;
        this.syncInitFuture = Executors.newSingleThreadExecutor().submit(new Runnable() { // from class: U0.a
            @Override // java.lang.Runnable
            public final void run() {
                SessionManager.this.lambda$setApplicationContext$0(context, perfSession);
            }
        });
    }

    public void setPerfSession(PerfSession perfSession) {
        this.perfSession = perfSession;
    }

    public void stopGaugeCollectionIfSessionRunningTooLong() {
        if (this.perfSession.isSessionRunningTooLong()) {
            this.gaugeManager.stopCollectingGauges();
        }
    }

    public void unregisterForSessionUpdates(WeakReference<SessionAwareObject> weakReference) {
        synchronized (this.clients) {
            this.clients.remove(weakReference);
        }
    }

    public void updatePerfSession(PerfSession perfSession) {
        if (perfSession.sessionId() == this.perfSession.sessionId()) {
            return;
        }
        this.perfSession = perfSession;
        synchronized (this.clients) {
            try {
                Iterator<WeakReference<SessionAwareObject>> it = this.clients.iterator();
                while (it.hasNext()) {
                    SessionAwareObject sessionAwareObject = it.next().get();
                    if (sessionAwareObject != null) {
                        sessionAwareObject.updateSession(perfSession);
                    } else {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        logGaugeMetadataIfCollectionEnabled(this.appStateMonitor.getAppState());
        startOrStopCollectingGauges(this.appStateMonitor.getAppState());
    }

    public SessionManager(GaugeManager gaugeManager, PerfSession perfSession, AppStateMonitor appStateMonitor) {
        this.clients = new HashSet();
        this.gaugeManager = gaugeManager;
        this.perfSession = perfSession;
        this.appStateMonitor = appStateMonitor;
        registerForAppState();
    }
}
