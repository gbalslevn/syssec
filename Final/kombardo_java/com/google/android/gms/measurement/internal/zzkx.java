package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzkx implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzju zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkx(zzju zzjuVar, long j5) {
        this.zza = j5;
        this.zzb = zzjuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzb(this.zza);
        this.zzb.zzq().zza(new AtomicReference<>());
    }
}
