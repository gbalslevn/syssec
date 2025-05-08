package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzip implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ zzig zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzip(zzig zzigVar, String str, String str2, String str3, long j5) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = j5;
        this.zze = zzigVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzou zzouVar;
        zzou zzouVar2;
        String str = this.zza;
        if (str == null) {
            zzouVar2 = this.zze.zza;
            zzouVar2.zza(this.zzb, (zzlw) null);
        } else {
            zzlw zzlwVar = new zzlw(this.zzc, str, this.zzd);
            zzouVar = this.zze.zza;
            zzouVar.zza(this.zzb, zzlwVar);
        }
    }
}
