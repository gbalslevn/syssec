package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzlc implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzju zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlc(zzju zzjuVar, AtomicReference atomicReference) {
        this.zza = atomicReference;
        this.zzb = zzjuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                try {
                    this.zza.set(Long.valueOf(this.zzb.zze().zzc(this.zzb.zzg().zzaf(), zzbn.zzaw)));
                } finally {
                    this.zza.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
