package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzgc$zzd;
import com.google.android.gms.internal.measurement.zzgf$zzo;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzos extends zzok {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzos(zzou zzouVar) {
        super(zzouVar);
    }

    private static boolean zzc(String str) {
        String zza = zzbn.zzs.zza(null);
        if (TextUtils.isEmpty(zza)) {
            return false;
        }
        for (String str2 : zza.split(",")) {
            if (str.equalsIgnoreCase(str2.trim())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzpj h_() {
        return super.h_();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ zzaf zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzai zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzbf zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzx zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzar zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzgl zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ zzgo zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzha zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ zzhv zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzhm zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzlp zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zznp zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzos zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzpn zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzu() {
        super.zzu();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzv() {
        super.zzv();
    }

    private final String zzb(String str) {
        String zzf = zzm().zzf(str);
        if (!TextUtils.isEmpty(zzf)) {
            Uri parse = Uri.parse(zzbn.zzq.zza(null));
            Uri.Builder buildUpon = parse.buildUpon();
            buildUpon.authority(zzf + "." + parse.getAuthority());
            return buildUpon.build().toString();
        }
        return zzbn.zzq.zza(null);
    }

    public final zzov zza(String str) {
        zzai zze = zze();
        zzfx<Boolean> zzfxVar = zzbn.zzcj;
        zzov zzovVar = null;
        if (zze.zza(zzfxVar)) {
            zzh zzd = zzh().zzd(str);
            if (zzd != null && zzd.zzat()) {
                zzgf$zzo.zzb zza = zzgf$zzo.zza();
                zzgf$zzo.zzd zzdVar = zzgf$zzo.zzd.GA_UPLOAD;
                zzgf$zzo.zzb zza2 = zza.zza(zzdVar).zza((zzgf$zzo.zza) Preconditions.checkNotNull(zzgf$zzo.zza.zza(zzd.zzb())));
                if (!zza(str, zzd.zzad())) {
                    zza2.zza(zzgf$zzo.zzc.NOT_IN_ROLLOUT);
                    return new zzov(zzb(str), Collections.emptyMap(), zzlu.GOOGLE_ANALYTICS, (zzgf$zzo) ((com.google.android.gms.internal.measurement.zzkg) zza2.zzaj()));
                }
                String zzac = zzd.zzac();
                zza2.zza(zzdVar);
                zzgc$zzd zzc = zzm().zzc(zzd.zzac());
                if (zzc != null && zzc.zzq()) {
                    HashMap hashMap = new HashMap();
                    if (!TextUtils.isEmpty(zzd.zzam())) {
                        hashMap.put("x-gtm-server-preview", zzd.zzam());
                    }
                    String zze2 = zzc.zzh().zze();
                    zzgf$zzo.zza zza3 = zzgf$zzo.zza.zza(zzd.zzb());
                    if (zza3 != null && zza3 != zzgf$zzo.zza.CLIENT_UPLOAD_ELIGIBLE) {
                        zza2.zza(zza3);
                    } else if (!zze().zza(zzfxVar)) {
                        zza2.zza(zzgf$zzo.zza.SERVICE_FLAG_OFF);
                    } else if (zzc(zzd.zzac())) {
                        zza2.zza(zzgf$zzo.zza.PINNED_TO_SERVICE_UPLOAD);
                    } else if (TextUtils.isEmpty(zze2)) {
                        zza2.zza(zzgf$zzo.zza.MISSING_SGTM_SERVER_URL);
                    } else {
                        zzj().zzq().zza("[sgtm] Eligible for client side upload. appId", zzac);
                        zza2.zza(zzgf$zzo.zzd.SDK_CLIENT_UPLOAD).zza(zzgf$zzo.zza.CLIENT_UPLOAD_ELIGIBLE);
                        zzovVar = new zzov(zze2, hashMap, zzlu.SGTM_CLIENT, (zzgf$zzo) ((com.google.android.gms.internal.measurement.zzkg) zza2.zzaj()));
                    }
                    zzc.zzh().zzf();
                    zzc.zzh().zzd();
                    if (!TextUtils.isEmpty(zze2)) {
                        zzj().zzq().zza("[sgtm] Eligible for local service direct upload. appId", zzac);
                        zza2.zza(zzgf$zzo.zzd.SDK_SERVICE_UPLOAD).zza(zzgf$zzo.zzc.SERVICE_UPLOAD_ELIGIBLE);
                        zzovVar = new zzov(zze2, hashMap, zzlu.SGTM, (zzgf$zzo) ((com.google.android.gms.internal.measurement.zzkg) zza2.zzaj()));
                    } else {
                        zza2.zza(zzgf$zzo.zzc.NON_PLAY_MISSING_SGTM_SERVER_URL);
                        zzj().zzq().zza("[sgtm] Local service, missing sgtm_server_url", zzd.zzac());
                    }
                } else {
                    zzj().zzq().zza("[sgtm] Missing sgtm_setting in remote config. appId", zzac);
                    zza2.zza(zzgf$zzo.zzc.MISSING_SGTM_SETTINGS);
                }
                return zzovVar != null ? zzovVar : new zzov(zzb(str), Collections.emptyMap(), zzlu.GOOGLE_ANALYTICS, (zzgf$zzo) ((com.google.android.gms.internal.measurement.zzkg) zza2.zzaj()));
            }
            return new zzov(zzb(str), zzlu.GOOGLE_ANALYTICS);
        }
        zzh zzd2 = zzh().zzd(str);
        if (zzd2 == null) {
            return new zzov(zzb(str), zzlu.GOOGLE_ANALYTICS);
        }
        if (!zza(str, zzd2.zzad())) {
            return new zzov(zzb(str), zzlu.GOOGLE_ANALYTICS);
        }
        if (zzd2.zzat()) {
            zzj().zzq().zza("sgtm upload enabled in manifest.");
            zzgc$zzd zzc2 = zzm().zzc(zzd2.zzac());
            if (zzc2 != null && zzc2.zzq()) {
                String zzf = zzc2.zzh().zzf();
                if (!TextUtils.isEmpty(zzf)) {
                    String zzd3 = zzc2.zzh().zzd();
                    zzj().zzq().zza("sgtm configured with upload_url, server_info", zzf, TextUtils.isEmpty(zzd3) ? "Y" : "N");
                    if (TextUtils.isEmpty(zzd3)) {
                        zzovVar = new zzov(zzf, zzlu.SGTM);
                    } else {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("x-sgtm-server-info", zzd3);
                        if (!TextUtils.isEmpty(zzd2.zzam())) {
                            hashMap2.put("x-gtm-server-preview", zzd2.zzam());
                        }
                        zzovVar = new zzov(zzf, hashMap2, zzlu.SGTM);
                    }
                }
            }
        }
        return zzovVar != null ? zzovVar : new zzov(zzb(str), zzlu.GOOGLE_ANALYTICS);
    }

    private final boolean zza(String str, String str2) {
        zzh zzd;
        zzgc$zzd zzc = zzm().zzc(str);
        if (zzc == null || (zzd = zzh().zzd(str)) == null) {
            return false;
        }
        if ((zzc.zzq() && zzc.zzh().zza() == 100) || zzs().zzd(str, zzd.zzam())) {
            return true;
        }
        return !TextUtils.isEmpty(str2) && Math.abs(str2.hashCode() % 100) < zzc.zzh().zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(String str, zzgf$zzo.zza zzaVar) {
        zzgc$zzd zzc;
        zzv();
        return zze().zza(zzbn.zzcj) && zzaVar == zzgf$zzo.zza.CLIENT_UPLOAD_ELIGIBLE && !zzc(str) && (zzc = zzm().zzc(str)) != null && zzc.zzq() && !zzc.zzh().zze().isEmpty();
    }
}
