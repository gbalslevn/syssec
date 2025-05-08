package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzoi implements zzof {
    private static final zzhx<Boolean> zza;
    private static final zzhx<Boolean> zzb;

    static {
        zzif zza2 = new zzif(zzhu.zza("com.google.android.gms.measurement")).zzb().zza();
        zza2.zza("measurement.collection.event_safelist", true);
        zza = zza2.zza("measurement.service.store_null_safelist", true);
        zzb = zza2.zza("measurement.service.store_safelist", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzof
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzof
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzof
    public final boolean zzc() {
        return zzb.zza().booleanValue();
    }
}
