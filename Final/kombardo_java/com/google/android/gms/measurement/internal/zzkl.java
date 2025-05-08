package com.google.android.gms.measurement.internal;

import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzkl implements Executor {
    private final /* synthetic */ zzju zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkl(zzju zzjuVar) {
        this.zza = zzjuVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.zza.zzl().zzb(runnable);
    }
}
