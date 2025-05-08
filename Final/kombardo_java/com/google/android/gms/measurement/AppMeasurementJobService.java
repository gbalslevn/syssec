package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import androidx.appcompat.R$styleable;
import com.google.android.gms.measurement.internal.zznr;
import com.google.android.gms.measurement.internal.zznu;

@TargetApi(R$styleable.Toolbar_titleMarginEnd)
/* loaded from: classes.dex */
public final class AppMeasurementJobService extends JobService implements zznu {
    private zznr<AppMeasurementJobService> zza;

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        zza().zza();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        zza().zzb();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        zza().zzb(intent);
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        return zza().zza(jobParameters);
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        return zza().zzc(intent);
    }

    @Override // com.google.android.gms.measurement.internal.zznu
    public final void zza(Intent intent) {
    }

    private final zznr<AppMeasurementJobService> zza() {
        if (this.zza == null) {
            this.zza = new zznr<>(this);
        }
        return this.zza;
    }

    @Override // com.google.android.gms.measurement.internal.zznu
    @TargetApi(R$styleable.Toolbar_titleMarginEnd)
    public final void zza(JobParameters jobParameters, boolean z5) {
        jobFinished(jobParameters, false);
    }

    @Override // com.google.android.gms.measurement.internal.zznu
    public final boolean zza(int i5) {
        throw new UnsupportedOperationException();
    }
}
