package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzph implements zzpi {
    private static final zzhx<Boolean> zza;

    static {
        zzif zza2 = new zzif(zzhu.zza("com.google.android.gms.measurement")).zzb().zza();
        zza2.zza("measurement.collection.enable_session_stitching_token.client.dev", true);
        zza2.zza("measurement.collection.enable_session_stitching_token.first_open_fix", true);
        zza = zza2.zza("measurement.session_stitching_token_enabled", false);
        zza2.zza("measurement.link_sst_to_sid", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzpi
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzpi
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }
}
