package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzky implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb = null;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzju zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzky(zzju zzjuVar, AtomicReference atomicReference, String str, String str2, String str3) {
        this.zza = atomicReference;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = zzjuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zzu.zzt().zza(this.zza, (String) null, this.zzc, this.zzd);
    }
}
