package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public final class zzjs {
    final Context zza;
    String zzb;
    String zzc;
    String zzd;
    Boolean zze;
    long zzf;
    com.google.android.gms.internal.measurement.zzdz zzg;
    boolean zzh;
    Long zzi;
    String zzj;

    public zzjs(Context context, com.google.android.gms.internal.measurement.zzdz zzdzVar, Long l5) {
        this.zzh = true;
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zza = applicationContext;
        this.zzi = l5;
        if (zzdzVar != null) {
            this.zzg = zzdzVar;
            this.zzb = zzdzVar.zzf;
            this.zzc = zzdzVar.zze;
            this.zzd = zzdzVar.zzd;
            this.zzh = zzdzVar.zzc;
            this.zzf = zzdzVar.zzb;
            this.zzj = zzdzVar.zzh;
            Bundle bundle = zzdzVar.zzg;
            if (bundle != null) {
                this.zze = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
