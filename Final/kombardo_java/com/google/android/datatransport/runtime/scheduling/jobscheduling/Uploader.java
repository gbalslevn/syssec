package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class Uploader {
    private static final String CLIENT_HEALTH_METRICS_LOG_SOURCE = "GDT_CLIENT_METRICS";
    private static final String LOG_TAG = "Uploader";
    private final BackendRegistry backendRegistry;
    private final ClientHealthMetricsStore clientHealthMetricsStore;
    private final Clock clock;
    private final Context context;
    private final EventStore eventStore;
    private final Executor executor;
    private final SynchronizationGuard guard;
    private final Clock uptimeClock;
    private final WorkScheduler workScheduler;

    public Uploader(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, Clock clock, Clock clock2, ClientHealthMetricsStore clientHealthMetricsStore) {
        this.context = context;
        this.backendRegistry = backendRegistry;
        this.eventStore = eventStore;
        this.workScheduler = workScheduler;
        this.executor = executor;
        this.guard = synchronizationGuard;
        this.clock = clock;
        this.uptimeClock = clock2;
        this.clientHealthMetricsStore = clientHealthMetricsStore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$logAndUpdateState$2(TransportContext transportContext) {
        return Boolean.valueOf(this.eventStore.hasPendingEventsFor(transportContext));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Iterable lambda$logAndUpdateState$3(TransportContext transportContext) {
        return this.eventStore.loadBatch(transportContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$logAndUpdateState$4(Iterable iterable, TransportContext transportContext, long j5) {
        this.eventStore.recordFailure(iterable);
        this.eventStore.recordNextCallTime(transportContext, this.clock.getTime() + j5);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$logAndUpdateState$5(Iterable iterable) {
        this.eventStore.recordSuccess(iterable);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$logAndUpdateState$6() {
        this.clientHealthMetricsStore.resetClientMetrics();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$logAndUpdateState$7(Map map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            this.clientHealthMetricsStore.recordLogEventDropped(((Integer) r0.getValue()).intValue(), LogEventDropped.Reason.INVALID_PAYLOD, (String) ((Map.Entry) it.next()).getKey());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$logAndUpdateState$8(TransportContext transportContext, long j5) {
        this.eventStore.recordNextCallTime(transportContext, this.clock.getTime() + j5);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$upload$0(TransportContext transportContext, int i5) {
        this.workScheduler.schedule(transportContext, i5 + 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$upload$1(final TransportContext transportContext, final int i5, Runnable runnable) {
        try {
            try {
                SynchronizationGuard synchronizationGuard = this.guard;
                final EventStore eventStore = this.eventStore;
                Objects.requireNonNull(eventStore);
                synchronizationGuard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: y0.e
                    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                    public final Object execute() {
                        return Integer.valueOf(EventStore.this.cleanUp());
                    }
                });
                if (isNetworkAvailable()) {
                    logAndUpdateState(transportContext, i5);
                } else {
                    this.guard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: y0.f
                        @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                        public final Object execute() {
                            Object lambda$upload$0;
                            lambda$upload$0 = Uploader.this.lambda$upload$0(transportContext, i5);
                            return lambda$upload$0;
                        }
                    });
                }
            } catch (SynchronizationException unused) {
                this.workScheduler.schedule(transportContext, i5 + 1);
            }
            runnable.run();
        } catch (Throwable th) {
            runnable.run();
            throw th;
        }
    }

    public EventInternal createMetricsEvent(TransportBackend transportBackend) {
        SynchronizationGuard synchronizationGuard = this.guard;
        final ClientHealthMetricsStore clientHealthMetricsStore = this.clientHealthMetricsStore;
        Objects.requireNonNull(clientHealthMetricsStore);
        return transportBackend.decorate(EventInternal.builder().setEventMillis(this.clock.getTime()).setUptimeMillis(this.uptimeClock.getTime()).setTransportName(CLIENT_HEALTH_METRICS_LOG_SOURCE).setEncodedPayload(new EncodedPayload(Encoding.of("proto"), ((ClientMetrics) synchronizationGuard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: y0.d
            @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
            public final Object execute() {
                return ClientHealthMetricsStore.this.loadClientMetrics();
            }
        })).toByteArray())).build());
    }

    boolean isNetworkAvailable() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public BackendResponse logAndUpdateState(final TransportContext transportContext, int i5) {
        BackendResponse send;
        TransportBackend transportBackend = this.backendRegistry.get(transportContext.getBackendName());
        long j5 = 0;
        BackendResponse ok = BackendResponse.ok(0L);
        while (true) {
            final long j6 = j5;
            while (((Boolean) this.guard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: y0.g
                @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                public final Object execute() {
                    Boolean lambda$logAndUpdateState$2;
                    lambda$logAndUpdateState$2 = Uploader.this.lambda$logAndUpdateState$2(transportContext);
                    return lambda$logAndUpdateState$2;
                }
            })).booleanValue()) {
                final Iterable iterable = (Iterable) this.guard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: y0.h
                    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                    public final Object execute() {
                        Iterable lambda$logAndUpdateState$3;
                        lambda$logAndUpdateState$3 = Uploader.this.lambda$logAndUpdateState$3(transportContext);
                        return lambda$logAndUpdateState$3;
                    }
                });
                if (!iterable.iterator().hasNext()) {
                    return ok;
                }
                if (transportBackend == null) {
                    Logging.d(LOG_TAG, "Unknown backend for %s, deleting event batch for it...", transportContext);
                    send = BackendResponse.fatalError();
                } else {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = iterable.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((PersistedEvent) it.next()).getEvent());
                    }
                    if (transportContext.shouldUploadClientHealthMetrics()) {
                        arrayList.add(createMetricsEvent(transportBackend));
                    }
                    send = transportBackend.send(BackendRequest.builder().setEvents(arrayList).setExtras(transportContext.getExtras()).build());
                }
                ok = send;
                if (ok.getStatus() == BackendResponse.Status.TRANSIENT_ERROR) {
                    this.guard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: y0.i
                        @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                        public final Object execute() {
                            Object lambda$logAndUpdateState$4;
                            lambda$logAndUpdateState$4 = Uploader.this.lambda$logAndUpdateState$4(iterable, transportContext, j6);
                            return lambda$logAndUpdateState$4;
                        }
                    });
                    this.workScheduler.schedule(transportContext, i5 + 1, true);
                    return ok;
                }
                this.guard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: y0.j
                    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                    public final Object execute() {
                        Object lambda$logAndUpdateState$5;
                        lambda$logAndUpdateState$5 = Uploader.this.lambda$logAndUpdateState$5(iterable);
                        return lambda$logAndUpdateState$5;
                    }
                });
                if (ok.getStatus() == BackendResponse.Status.OK) {
                    j5 = Math.max(j6, ok.getNextRequestWaitMillis());
                    if (transportContext.shouldUploadClientHealthMetrics()) {
                        this.guard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: y0.k
                            @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                            public final Object execute() {
                                Object lambda$logAndUpdateState$6;
                                lambda$logAndUpdateState$6 = Uploader.this.lambda$logAndUpdateState$6();
                                return lambda$logAndUpdateState$6;
                            }
                        });
                    }
                } else if (ok.getStatus() == BackendResponse.Status.INVALID_PAYLOAD) {
                    final HashMap hashMap = new HashMap();
                    Iterator it2 = iterable.iterator();
                    while (it2.hasNext()) {
                        String transportName = ((PersistedEvent) it2.next()).getEvent().getTransportName();
                        if (hashMap.containsKey(transportName)) {
                            hashMap.put(transportName, Integer.valueOf(((Integer) hashMap.get(transportName)).intValue() + 1));
                        } else {
                            hashMap.put(transportName, 1);
                        }
                    }
                    this.guard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: y0.l
                        @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                        public final Object execute() {
                            Object lambda$logAndUpdateState$7;
                            lambda$logAndUpdateState$7 = Uploader.this.lambda$logAndUpdateState$7(hashMap);
                            return lambda$logAndUpdateState$7;
                        }
                    });
                }
            }
            this.guard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: y0.m
                @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                public final Object execute() {
                    Object lambda$logAndUpdateState$8;
                    lambda$logAndUpdateState$8 = Uploader.this.lambda$logAndUpdateState$8(transportContext, j6);
                    return lambda$logAndUpdateState$8;
                }
            });
            return ok;
        }
    }

    public void upload(final TransportContext transportContext, final int i5, final Runnable runnable) {
        this.executor.execute(new Runnable() { // from class: y0.c
            @Override // java.lang.Runnable
            public final void run() {
                Uploader.this.lambda$upload$1(transportContext, i5, runnable);
            }
        });
    }
}
