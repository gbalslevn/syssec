package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import androidx.appcompat.R$styleable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzgf$zzo;

/* loaded from: classes.dex */
public final class zzls extends zzf {
    private JobScheduler zza;

    public zzls(zzic zzicVar) {
        super(zzicVar);
    }

    private final int zzad() {
        return ("measurement-client" + zza().getPackageName()).hashCode();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzab() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzgf$zzo.zza zzac() {
        zzw();
        zzv();
        return !zze().zza(zzbn.zzcl) ? zzgf$zzo.zza.CLIENT_FLAG_OFF : this.zza == null ? zzgf$zzo.zza.MISSING_JOB_SCHEDULER : !zze().zzab() ? zzgf$zzo.zza.NOT_ENABLED_IN_MANIFEST : !zze().zza(zzbn.zzcn) ? zzgf$zzo.zza.SDK_TOO_OLD : !zzpn.zzb(zza(), "com.google.android.gms.measurement.AppMeasurementJobService") ? zzgf$zzo.zza.MEASUREMENT_SERVICE_NOT_ENABLED : !zzq().zzap() ? zzgf$zzo.zza.NON_PLAY_MODE : zzgf$zzo.zza.CLIENT_UPLOAD_ELIGIBLE;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
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

    @Override // com.google.android.gms.measurement.internal.zzf
    @TargetApi(R$styleable.Toolbar_titleMarginEnd)
    protected final void zzz() {
        this.zza = (JobScheduler) zza().getSystemService("jobscheduler");
    }

    @TargetApi(R$styleable.Toolbar_titleMarginEnd)
    public final void zza(long j5) {
        zzw();
        zzv();
        JobScheduler jobScheduler = this.zza;
        if (jobScheduler != null && jobScheduler.getPendingJob(zzad()) != null) {
            zzj().zzq().zza("[sgtm] There's an existing pending job, skip this schedule.");
            return;
        }
        zzgf$zzo.zza zzac = zzac();
        if (zzac != zzgf$zzo.zza.CLIENT_UPLOAD_ELIGIBLE) {
            zzj().zzq().zza("[sgtm] Not eligible for Scion upload", zzac.name());
            return;
        }
        zzj().zzq().zza("[sgtm] Scheduling Scion upload, millis", Long.valueOf(j5));
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.SCION_UPLOAD");
        zzj().zzq().zza("[sgtm] Scion upload job scheduled with result", ((JobScheduler) Preconditions.checkNotNull(this.zza)).schedule(new JobInfo.Builder(zzad(), new ComponentName(zza(), "com.google.android.gms.measurement.AppMeasurementJobService")).setRequiredNetworkType(1).setMinimumLatency(j5).setOverrideDeadline(j5 << 1).setExtras(persistableBundle).build()) == 1 ? "SUCCESS" : "FAILURE");
    }
}
