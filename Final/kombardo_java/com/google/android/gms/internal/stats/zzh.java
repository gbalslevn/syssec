package com.google.android.gms.internal.stats;

/* loaded from: classes.dex */
public abstract class zzh {
    private static final zze zza;
    private static volatile zze zzb;

    static {
        zzg zzgVar = new zzg(null);
        zza = zzgVar;
        zzb = zzgVar;
    }

    public static zze zza() {
        return zzb;
    }
}
