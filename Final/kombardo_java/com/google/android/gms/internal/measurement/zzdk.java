package com.google.android.gms.internal.measurement;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class zzdk implements zzdf {
    @Override // com.google.android.gms.internal.measurement.zzdf
    public final Runnable zza(Runnable runnable) {
        return runnable;
    }

    @Override // com.google.android.gms.internal.measurement.zzdf
    public final <V> Callable<V> zza(Callable<V> callable) {
        return callable;
    }
}
