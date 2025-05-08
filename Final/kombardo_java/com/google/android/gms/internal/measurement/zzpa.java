package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzpa implements zzox {
    private static final zzhx<Boolean> zza;
    private static final zzhx<Boolean> zzb;
    private static final zzhx<Boolean> zzc;
    private static final zzhx<Boolean> zzd;
    private static final zzhx<Boolean> zze;
    private static final zzhx<Boolean> zzf;
    private static final zzhx<Boolean> zzg;
    private static final zzhx<Boolean> zzh;
    private static final zzhx<Boolean> zzi;
    private static final zzhx<Boolean> zzj;

    static {
        zzif zza2 = new zzif(zzhu.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zza("measurement.rb.attribution.ad_campaign_info", true);
        zza2.zza("measurement.rb.attribution.client.bundle_on_backgrounded", true);
        zza2.zza("measurement.rb.attribution.service.bundle_on_backgrounded", true);
        zzb = zza2.zza("measurement.rb.attribution.client2", true);
        zza2.zza("measurement.rb.attribution.dma_fix", true);
        zzc = zza2.zza("measurement.rb.attribution.followup1.service", false);
        zzd = zza2.zza("measurement.rb.attribution.client.get_trigger_uris_async", false);
        zze = zza2.zza("measurement.rb.attribution.service.trigger_uris_high_priority", true);
        zza2.zza("measurement.rb.attribution.index_out_of_bounds_fix", true);
        zzf = zza2.zza("measurement.rb.attribution.service.enable_max_trigger_uris_queried_at_once", true);
        zzg = zza2.zza("measurement.rb.attribution.retry_disposition", false);
        zzh = zza2.zza("measurement.rb.attribution.service", true);
        zzi = zza2.zza("measurement.rb.attribution.enable_trigger_redaction", true);
        zzj = zza2.zza("measurement.rb.attribution.uuid_generation", true);
        zza2.zza("measurement.id.rb.attribution.retry_disposition", 0L);
        zza2.zza("measurement.id.rb.attribution.client.get_trigger_uris_async", 0L);
        zza2.zza("measurement.rb.attribution.improved_retry", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzc() {
        return zzb.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzd() {
        return zzc.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zze() {
        return zzd.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzf() {
        return zze.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzg() {
        return zzf.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzh() {
        return zzg.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzi() {
        return zzh.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzj() {
        return zzi.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzk() {
        return zzj.zza().booleanValue();
    }
}
