package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzoc implements zznz {
    private static final zzhx<Boolean> zza;

    static {
        zzif zza2 = new zzif(zzhu.zza("com.google.android.gms.measurement")).zzb().zza();
        zza2.zza("measurement.set_default_event_parameters_with_backfill.client.dev", false);
        zza2.zza("measurement.defensively_copy_bundles_validate_default_params", true);
        zza2.zza("measurement.set_default_event_parameters_with_backfill.service", true);
        zza = zza2.zza("measurement.set_default_event_parameters.fix_deferred_analytics_collection", false);
        zza2.zza("measurement.id.set_default_event_parameters.fix_deferred_analytics_collection", 0L);
        zza2.zza("measurement.set_default_event_parameters.fix_subsequent_launches", true);
    }

    @Override // com.google.android.gms.internal.measurement.zznz
    public final boolean zza() {
        return zza.zza().booleanValue();
    }
}
