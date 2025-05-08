package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zznr;
import com.google.android.gms.measurement.internal.zznu;

/* loaded from: classes.dex */
public final class AppMeasurementService extends Service implements zznu {
    private zznr<AppMeasurementService> zza;

    private final zznr<AppMeasurementService> zza() {
        if (this.zza == null) {
            this.zza = new zznr<>(this);
        }
        return this.zza;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return zza().zza(intent);
    }

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

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i5, int i6) {
        return zza().zza(intent, i5, i6);
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        return zza().zzc(intent);
    }

    @Override // com.google.android.gms.measurement.internal.zznu
    public final void zza(Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }

    @Override // com.google.android.gms.measurement.internal.zznu
    public final void zza(JobParameters jobParameters, boolean z5) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.measurement.internal.zznu
    public final boolean zza(int i5) {
        return stopSelfResult(i5);
    }
}
