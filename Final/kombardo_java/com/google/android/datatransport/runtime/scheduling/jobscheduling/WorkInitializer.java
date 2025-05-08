package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class WorkInitializer {
    private final Executor executor;
    private final SynchronizationGuard guard;
    private final WorkScheduler scheduler;
    private final EventStore store;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WorkInitializer(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        this.executor = executor;
        this.store = eventStore;
        this.scheduler = workScheduler;
        this.guard = synchronizationGuard;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$ensureContextsScheduled$0() {
        Iterator<TransportContext> it = this.store.loadActiveContexts().iterator();
        while (it.hasNext()) {
            this.scheduler.schedule(it.next(), 1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$ensureContextsScheduled$1() {
        this.guard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: y0.o
            @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
            public final Object execute() {
                Object lambda$ensureContextsScheduled$0;
                lambda$ensureContextsScheduled$0 = WorkInitializer.this.lambda$ensureContextsScheduled$0();
                return lambda$ensureContextsScheduled$0;
            }
        });
    }

    public void ensureContextsScheduled() {
        this.executor.execute(new Runnable() { // from class: y0.n
            @Override // java.lang.Runnable
            public final void run() {
                WorkInitializer.this.lambda$ensureContextsScheduled$1();
            }
        });
    }
}
