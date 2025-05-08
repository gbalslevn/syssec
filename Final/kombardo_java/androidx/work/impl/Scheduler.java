package androidx.work.impl;

import androidx.work.impl.model.WorkSpec;

/* loaded from: classes.dex */
public interface Scheduler {
    void cancel(String str);

    boolean hasLimitedSchedulingSlots();

    void schedule(WorkSpec... workSpecArr);
}
