package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;

/* loaded from: classes.dex */
public interface WorkScheduler {
    void schedule(TransportContext transportContext, int i5);

    void schedule(TransportContext transportContext, int i5, boolean z5);
}
