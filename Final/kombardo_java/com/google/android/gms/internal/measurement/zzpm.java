package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzpm implements zzpj {
    private static final zzhx<Boolean> zza;

    static {
        zzif zza2 = new zzif(zzhu.zza("com.google.android.gms.measurement")).zzb().zza();
        zza2.zza("measurement.client.sessions.background_sessions_enabled", true);
        zza = zza2.zza("measurement.client.sessions.enable_fix_background_engagement", false);
        zza2.zza("measurement.client.sessions.immediate_start_enabled_foreground", true);
        zza2.zza("measurement.client.sessions.enable_pause_engagement_in_background", true);
        zza2.zza("measurement.client.sessions.remove_expired_session_properties_enabled", true);
        zza2.zza("measurement.client.sessions.session_id_enabled", true);
        zza2.zza("measurement.id.client.sessions.enable_fix_background_engagement", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzpj
    public final boolean zza() {
        return zza.zza().booleanValue();
    }
}
