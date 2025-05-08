package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzov implements zzow {
    private static final zzhx<Boolean> zza;
    private static final zzhx<Long> zzb;
    private static final zzhx<Double> zzc;
    private static final zzhx<Long> zzd;
    private static final zzhx<Long> zze;
    private static final zzhx<String> zzf;

    static {
        zzif zza2 = new zzif(zzhu.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zza("measurement.test.boolean_flag", false);
        zzb = zza2.zza("measurement.test.cached_long_flag", -1L);
        zzc = zza2.zza("measurement.test.double_flag", -3.0d);
        zzd = zza2.zza("measurement.test.int_flag", -2L);
        zze = zza2.zza("measurement.test.long_flag", -1L);
        zzf = zza2.zza("measurement.test.string_flag", "---");
    }

    @Override // com.google.android.gms.internal.measurement.zzow
    public final double zza() {
        return zzc.zza().doubleValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzow
    public final long zzb() {
        return zzb.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzow
    public final long zzc() {
        return zzd.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzow
    public final long zzd() {
        return zze.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzow
    public final String zze() {
        return zzf.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzow
    public final boolean zzf() {
        return zza.zza().booleanValue();
    }
}
