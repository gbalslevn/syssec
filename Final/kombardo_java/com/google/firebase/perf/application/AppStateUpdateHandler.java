package com.google.firebase.perf.application;

import com.google.firebase.perf.application.AppStateMonitor;
import com.google.firebase.perf.v1.ApplicationProcessState;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public abstract class AppStateUpdateHandler implements AppStateMonitor.AppStateCallback {
    private final WeakReference<AppStateMonitor.AppStateCallback> appStateCallback;
    private final AppStateMonitor appStateMonitor;
    private ApplicationProcessState currentAppState;
    private boolean isRegisteredForAppState;

    /* JADX INFO: Access modifiers changed from: protected */
    public AppStateUpdateHandler() {
        this(AppStateMonitor.getInstance());
    }

    public ApplicationProcessState getAppState() {
        return this.currentAppState;
    }

    public WeakReference<AppStateMonitor.AppStateCallback> getAppStateCallback() {
        return this.appStateCallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void incrementTsnsCount(int i5) {
        this.appStateMonitor.incrementTsnsCount(i5);
    }

    @Override // com.google.firebase.perf.application.AppStateMonitor.AppStateCallback
    public void onUpdateAppState(ApplicationProcessState applicationProcessState) {
        ApplicationProcessState applicationProcessState2 = this.currentAppState;
        ApplicationProcessState applicationProcessState3 = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
        if (applicationProcessState2 == applicationProcessState3) {
            this.currentAppState = applicationProcessState;
        } else {
            if (applicationProcessState2 == applicationProcessState || applicationProcessState == applicationProcessState3) {
                return;
            }
            this.currentAppState = ApplicationProcessState.FOREGROUND_BACKGROUND;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void registerForAppState() {
        if (this.isRegisteredForAppState) {
            return;
        }
        this.currentAppState = this.appStateMonitor.getAppState();
        this.appStateMonitor.registerForAppState(this.appStateCallback);
        this.isRegisteredForAppState = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unregisterForAppState() {
        if (this.isRegisteredForAppState) {
            this.appStateMonitor.unregisterForAppState(this.appStateCallback);
            this.isRegisteredForAppState = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AppStateUpdateHandler(AppStateMonitor appStateMonitor) {
        this.isRegisteredForAppState = false;
        this.currentAppState = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
        this.appStateMonitor = appStateMonitor;
        this.appStateCallback = new WeakReference<>(this);
    }
}
