package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.Clock;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zznp extends zzot {
    public final zzhf zza;
    public final zzhf zzb;
    public final zzhf zzc;
    public final zzhf zzd;
    public final zzhf zze;
    public final zzhf zzf;
    private final Map<String, zzno> zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznp(zzou zzouVar) {
        super(zzouVar);
        this.zzh = new HashMap();
        zzha zzk = zzk();
        Objects.requireNonNull(zzk);
        this.zza = new zzhf(zzk, "last_delete_stale", 0L);
        zzha zzk2 = zzk();
        Objects.requireNonNull(zzk2);
        this.zzb = new zzhf(zzk2, "last_delete_stale_batch", 0L);
        zzha zzk3 = zzk();
        Objects.requireNonNull(zzk3);
        this.zzc = new zzhf(zzk3, "backoff", 0L);
        zzha zzk4 = zzk();
        Objects.requireNonNull(zzk4);
        this.zzd = new zzhf(zzk4, "last_upload", 0L);
        zzha zzk5 = zzk();
        Objects.requireNonNull(zzk5);
        this.zze = new zzhf(zzk5, "last_upload_attempt", 0L);
        zzha zzk6 = zzk();
        Objects.requireNonNull(zzk6);
        this.zzf = new zzhf(zzk6, "midnight_offset", 0L);
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

    @Override // com.google.android.gms.measurement.internal.zzot
    protected final boolean zzc() {
        return false;
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

    @Deprecated
    private final Pair<String, Boolean> zza(String str) {
        zzno zznoVar;
        AdvertisingIdClient.Info info;
        zzv();
        long elapsedRealtime = zzb().elapsedRealtime();
        zzno zznoVar2 = this.zzh.get(str);
        if (zznoVar2 != null && elapsedRealtime < zznoVar2.zzc) {
            return new Pair<>(zznoVar2.zza, Boolean.valueOf(zznoVar2.zzb));
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        long zzd = zze().zzd(str) + elapsedRealtime;
        try {
            try {
                info = AdvertisingIdClient.getAdvertisingIdInfo(zza());
            } catch (PackageManager.NameNotFoundException unused) {
                if (zznoVar2 != null && elapsedRealtime < zznoVar2.zzc + zze().zzc(str, zzbn.zzb)) {
                    return new Pair<>(zznoVar2.zza, Boolean.valueOf(zznoVar2.zzb));
                }
                info = null;
            }
        } catch (Exception e5) {
            zzj().zzc().zza("Unable to get advertising id", e5);
            zznoVar = new zzno(BuildConfig.FLAVOR, false, zzd);
        }
        if (info == null) {
            return new Pair<>("00000000-0000-0000-0000-000000000000", Boolean.FALSE);
        }
        String id = info.getId();
        if (id != null) {
            zznoVar = new zzno(id, info.isLimitAdTrackingEnabled(), zzd);
        } else {
            zznoVar = new zzno(BuildConfig.FLAVOR, info.isLimitAdTrackingEnabled(), zzd);
        }
        this.zzh.put(str, zznoVar);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(zznoVar.zza, Boolean.valueOf(zznoVar.zzb));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Pair<String, Boolean> zza(String str, zzjj zzjjVar) {
        if (zzjjVar.zzg()) {
            return zza(str);
        }
        return new Pair<>(BuildConfig.FLAVOR, Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public final String zza(String str, boolean z5) {
        String str2;
        zzv();
        if (z5) {
            str2 = (String) zza(str).first;
        } else {
            str2 = "00000000-0000-0000-0000-000000000000";
        }
        MessageDigest zzr = zzpn.zzr();
        if (zzr == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, zzr.digest(str2.getBytes())));
    }
}
