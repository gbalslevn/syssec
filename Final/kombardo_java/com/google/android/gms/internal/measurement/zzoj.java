package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzoj implements zzok {
    private static final zzhx<Boolean> zza;
    private static final zzhx<Boolean> zzb;
    private static final zzhx<Boolean> zzc;

    static {
        zzif zza2 = new zzif(zzhu.zza("com.google.android.gms.measurement")).zzb().zza();
        zza2.zza("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        zza = zza2.zza("measurement.audience.refresh_event_count_filters_timestamp", false);
        zzb = zza2.zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        zzc = zza2.zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final boolean zzc() {
        return zzb.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final boolean zzd() {
        return zzc.zza().booleanValue();
    }
}
