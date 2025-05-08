package com.google.android.gms.internal.measurement;

import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public abstract class zzco {
    public static final zzco zza;
    static final zzco zzb;

    static {
        zzcn zza2 = new zzcd().zza(BuildConfig.FLAVOR).zza(false).zza(zzcq.ALL_CHECKS);
        zzcp zzcpVar = zzcp.READ_AND_WRITE;
        zza = zza2.zza(zzcpVar).zza();
        zzb = new zzcd().zza(BuildConfig.FLAVOR).zza(false).zza(zzcq.NO_CHECKS).zza(zzcpVar).zza();
        new zzcd().zza(BuildConfig.FLAVOR).zza(false).zza(zzcq.SKIP_COMPLIANCE_CHECK).zza(zzcpVar).zza();
    }

    public abstract zzcc zza();

    public abstract zzcb zzb();

    public abstract zzcq zzc();

    public abstract zzcp zzd();

    public abstract String zze();

    public abstract boolean zzf();
}
