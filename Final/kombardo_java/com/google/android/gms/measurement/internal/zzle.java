package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzle implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzju zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzle(zzju zzjuVar, AtomicReference atomicReference) {
        this.zza = atomicReference;
        this.zzb = zzjuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                try {
                    this.zza.set(Double.valueOf(this.zzb.zze().zza(this.zzb.zzg().zzaf(), zzbn.zzay)));
                } finally {
                    this.zza.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
