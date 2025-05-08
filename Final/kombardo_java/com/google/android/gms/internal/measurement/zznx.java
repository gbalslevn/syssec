package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zznx implements zzny {
    private static final zzhx<Long> zza;

    static {
        zzif zza2 = new zzif(zzhu.zza("com.google.android.gms.measurement")).zzb().zza();
        zza2.zza("measurement.client.consent_state_v1", true);
        zza2.zza("measurement.client.3p_consent_state_v1", true);
        zza2.zza("measurement.service.consent_state_v1_W36", true);
        zza = zza2.zza("measurement.service.storage_consent_support_version", 203600L);
    }

    @Override // com.google.android.gms.internal.measurement.zzny
    public final long zza() {
        return zza.zza().longValue();
    }
}
