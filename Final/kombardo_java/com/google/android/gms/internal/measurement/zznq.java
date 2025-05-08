package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zznq implements zznn {
    private static final zzhx<Boolean> zza;

    static {
        zzif zza2 = new zzif(zzhu.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zza("measurement.service.ad_impression.convert_value_to_double", true);
        zza2.zza("measurement.client.ad_impression", true);
        zza2.zza("measurement.service.separate_public_internal_event_blacklisting", true);
        zza2.zza("measurement.service.ad_impression", true);
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final boolean zza() {
        return zza.zza().booleanValue();
    }
}
