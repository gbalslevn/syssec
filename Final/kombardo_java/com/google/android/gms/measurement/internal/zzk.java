package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzk implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdq zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ AppMeasurementDynamiteService zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzk(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzdq zzdqVar, String str, String str2, boolean z5) {
        this.zza = zzdqVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = z5;
        this.zze = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zza.zzt().zza(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
