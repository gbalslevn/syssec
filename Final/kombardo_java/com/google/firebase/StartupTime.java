package com.google.firebase;

import android.os.SystemClock;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes2.dex */
public abstract class StartupTime {
    public static StartupTime create(long j5, long j6, long j7) {
        return new AutoValue_StartupTime(j5, j6, j7);
    }

    public static StartupTime now() {
        return create(System.currentTimeMillis(), SystemClock.elapsedRealtime(), SystemClock.uptimeMillis());
    }

    public abstract long getElapsedRealtime();

    public abstract long getEpochMillis();

    public abstract long getUptimeMillis();
}
