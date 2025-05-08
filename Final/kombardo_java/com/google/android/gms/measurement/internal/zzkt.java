package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzkt implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ Object zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ zzju zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkt(zzju zzjuVar, String str, String str2, Object obj, long j5) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = obj;
        this.zzd = j5;
        this.zze = zzjuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zza(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
