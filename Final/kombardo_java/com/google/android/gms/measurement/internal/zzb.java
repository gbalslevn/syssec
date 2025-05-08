package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzb implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ zza zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(zza zzaVar, String str, long j5) {
        this.zza = str;
        this.zzb = j5;
        this.zzc = zzaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zza.zzb(this.zzc, this.zza, this.zzb);
    }
}
