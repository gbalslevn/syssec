package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzpn implements zzpo {
    private static final zzhx<Boolean> zza;
    private static final zzhx<Boolean> zzb;
    private static final zzhx<Boolean> zzc;
    private static final zzhx<Boolean> zzd;
    private static final zzhx<Boolean> zze;
    private static final zzhx<Boolean> zzf;
    private static final zzhx<Boolean> zzg;

    static {
        zzif zza2 = new zzif(zzhu.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zza("measurement.sgtm.client.scion_upload_action.dev", false);
        zzb = zza2.zza("measurement.sgtm.client.upload_on_backgrounded.dev", false);
        zzc = zza2.zza("measurement.sgtm.google_signal.enable", false);
        zzd = zza2.zza("measurement.sgtm.no_proxy.client.dev", false);
        zze = zza2.zza("measurement.sgtm.no_proxy.service", false);
        zza2.zza("measurement.sgtm.preview_mode_enabled", true);
        zza2.zza("measurement.sgtm.rollout_percentage_fix", true);
        zza2.zza("measurement.sgtm.service", true);
        zzf = zza2.zza("measurement.sgtm.service.batching_on_backgrounded", false);
        zzg = zza2.zza("measurement.sgtm.upload_queue", false);
        zza2.zza("measurement.id.sgtm", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzpo
    public final boolean zza() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpo
    public final boolean zzb() {
        return zzb.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpo
    public final boolean zzc() {
        return zzc.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpo
    public final boolean zzd() {
        return zzd.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpo
    public final boolean zze() {
        return zze.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpo
    public final boolean zzf() {
        return zzf.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpo
    public final boolean zzg() {
        return zzg.zza().booleanValue();
    }
}
