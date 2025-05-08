package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.Clock;

/* loaded from: classes.dex */
public final class zznx extends zzf {
    protected final zzof zza;
    protected final zzod zzb;
    private Handler zzc;
    private boolean zzd;
    private final zzny zze;

    public zznx(zzic zzicVar) {
        super(zzicVar);
        this.zzd = true;
        this.zza = new zzof(this);
        this.zzb = new zzod(this);
        this.zze = new zzny(this);
    }

    public final void zzad() {
        zzv();
        if (this.zzc == null) {
            this.zzc = new com.google.android.gms.internal.measurement.zzdj(Looper.getMainLooper());
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzab() {
        return false;
    }

    public final boolean zzac() {
        zzv();
        return this.zzd;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zza zzc() {
        return super.zzc();
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

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzgg zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzgj zzh() {
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

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzju zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzlp zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzls zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzlz zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzme zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zznx zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzpn zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzg, com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzg, com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzu() {
        super.zzu();
    }

    @Override // com.google.android.gms.measurement.internal.zzg, com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzv() {
        super.zzv();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    public static /* synthetic */ void zza(zznx zznxVar, long j5) {
        zznxVar.zzv();
        zznxVar.zzad();
        zznxVar.zzj().zzq().zza("Activity paused, time", Long.valueOf(j5));
        zznxVar.zze.zza(j5);
        if (zznxVar.zze().zzx()) {
            zznxVar.zzb.zzb(j5);
        }
    }

    public static /* synthetic */ void zzb(zznx zznxVar, long j5) {
        zznxVar.zzv();
        zznxVar.zzad();
        zznxVar.zzj().zzq().zza("Activity resumed, time", Long.valueOf(j5));
        if (zznxVar.zze().zza(zzbn.zzcv)) {
            if (zznxVar.zze().zzx() || zznxVar.zzd) {
                zznxVar.zzb.zzc(j5);
            }
        } else if (zznxVar.zze().zzx() || zznxVar.zzk().zzn.zza()) {
            zznxVar.zzb.zzc(j5);
        }
        zznxVar.zze.zza();
        zzof zzofVar = zznxVar.zza;
        zzofVar.zza.zzv();
        if (zzofVar.zza.zzu.zzae()) {
            zzofVar.zza(zzofVar.zza.zzb().currentTimeMillis(), false);
        }
    }

    public final void zza(boolean z5) {
        zzv();
        this.zzd = z5;
    }

    public final boolean zza(boolean z5, boolean z6, long j5) {
        return this.zzb.zza(z5, z6, j5);
    }
}
