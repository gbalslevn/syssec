package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzgf$zzj;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzpi {
    private long zza;
    private zzgf$zzj zzb;
    private String zzc;
    private Map<String, String> zzd;
    private zzlu zze;
    private long zzf;

    public final long zza() {
        return this.zza;
    }

    public final zzon zzb() {
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : this.zzd.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        return new zzon(this.zza, this.zzb.zzce(), this.zzc, bundle, this.zze.zza(), this.zzf);
    }

    public final zzov zzc() {
        return new zzov(this.zzc, this.zzd, this.zze);
    }

    public final zzgf$zzj zzd() {
        return this.zzb;
    }

    public final String zze() {
        return this.zzc;
    }

    private zzpi(long j5, zzgf$zzj zzgf_zzj, String str, Map<String, String> map, zzlu zzluVar, long j6, long j7) {
        this.zza = j5;
        this.zzb = zzgf_zzj;
        this.zzc = str;
        this.zzd = map;
        this.zze = zzluVar;
        this.zzf = j7;
    }
}
