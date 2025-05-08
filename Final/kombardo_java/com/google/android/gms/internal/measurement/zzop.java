package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzop implements zzoq {
    private static final zzhx<Boolean> zza;

    static {
        zzif zza2 = new zzif(zzhu.zza("com.google.android.gms.measurement")).zzb().zza();
        zza2.zza("measurement.gmscore_feature_tracking", true);
        zza = zza2.zza("measurement.gmscore_client_telemetry", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzoq
    public final boolean zza() {
        return zza.zza().booleanValue();
    }
}
