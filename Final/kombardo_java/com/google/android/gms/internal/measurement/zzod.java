package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzod implements zzoe {
    private static final zzhx<Boolean> zza;
    private static final zzhx<Boolean> zzb;

    static {
        zzif zza2 = new zzif(zzhu.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zza("measurement.set_default_event_parameters_propagate_clear.client.dev", false);
        zzb = zza2.zza("measurement.set_default_event_parameters_propagate_clear.service", false);
        zza2.zza("measurement.id.set_default_event_parameters_propagate_clear.experiment_id", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzoe
    public final boolean zza() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoe
    public final boolean zzb() {
        return zzb.zza().booleanValue();
    }
}
