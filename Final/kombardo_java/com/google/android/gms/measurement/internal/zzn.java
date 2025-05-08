package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* loaded from: classes.dex */
final class zzn implements Runnable {
    private final /* synthetic */ AppMeasurementDynamiteService.zza zza;
    private final /* synthetic */ AppMeasurementDynamiteService zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzn(AppMeasurementDynamiteService appMeasurementDynamiteService, AppMeasurementDynamiteService.zza zzaVar) {
        this.zza = zzaVar;
        this.zzb = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzp().zza(this.zza);
    }
}
