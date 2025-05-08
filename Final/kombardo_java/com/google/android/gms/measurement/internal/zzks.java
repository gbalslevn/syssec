package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzks implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzju zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzks(zzju zzjuVar, AtomicReference atomicReference) {
        this.zza = atomicReference;
        this.zzb = zzjuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                try {
                    this.zza.set(this.zzb.zze().zzf(this.zzb.zzg().zzaf()));
                } finally {
                    this.zza.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
