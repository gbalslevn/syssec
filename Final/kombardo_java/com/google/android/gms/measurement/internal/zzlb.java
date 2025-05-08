package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzlb implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb = null;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ boolean zze;
    private final /* synthetic */ zzju zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlb(zzju zzjuVar, AtomicReference atomicReference, String str, String str2, String str3, boolean z5) {
        this.zza = atomicReference;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = z5;
        this.zzf = zzjuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzf.zzu.zzt().zza(this.zza, null, this.zzc, this.zzd, this.zze);
    }
}
