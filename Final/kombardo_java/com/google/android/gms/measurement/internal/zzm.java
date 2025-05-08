package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzm implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdq zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ AppMeasurementDynamiteService zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzm(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzdq zzdqVar, String str, String str2) {
        this.zza = zzdqVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzd.zza.zzt().zza(this.zza, this.zzb, this.zzc);
    }
}
