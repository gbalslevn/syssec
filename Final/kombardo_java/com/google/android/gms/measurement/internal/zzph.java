package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzgf$zzj;
import java.util.Map;

/* loaded from: classes.dex */
final class zzph {
    private long zza;
    private zzgf$zzj zzb;
    private String zzc;
    private Map<String, String> zzd;
    private zzlu zze;
    private long zzf;
    private long zzg;

    public final zzph zza(long j5) {
        this.zzg = j5;
        return this;
    }

    public final zzph zzb(long j5) {
        this.zzf = j5;
        return this;
    }

    public final zzph zzc(long j5) {
        this.zza = j5;
        return this;
    }

    public final zzph zza(zzgf$zzj zzgf_zzj) {
        this.zzb = zzgf_zzj;
        return this;
    }

    public final zzph zza(Map<String, String> map) {
        this.zzd = map;
        return this;
    }

    public final zzph zza(zzlu zzluVar) {
        this.zze = zzluVar;
        return this;
    }

    public final zzph zza(String str) {
        this.zzc = str;
        return this;
    }

    public final zzpi zza() {
        return new zzpi(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
    }
}
