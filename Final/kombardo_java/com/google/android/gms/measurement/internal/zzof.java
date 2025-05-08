package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzof {
    final /* synthetic */ zznx zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzof(zznx zznxVar) {
        this.zza = zznxVar;
    }

    private final void zzb(long j5, boolean z5) {
        this.zza.zzv();
        if (this.zza.zzu.zzae()) {
            this.zza.zzk().zzk.zza(j5);
            this.zza.zzj().zzq().zza("Session started, time", Long.valueOf(this.zza.zzb().elapsedRealtime()));
            long j6 = j5 / 1000;
            this.zza.zzm().zza("auto", "_sid", Long.valueOf(j6), j5);
            this.zza.zzk().zzl.zza(j6);
            this.zza.zzk().zzg.zza(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", j6);
            this.zza.zzm().zza("auto", "_s", j5, bundle);
            String zza = this.zza.zzk().zzq.zza();
            if (TextUtils.isEmpty(zza)) {
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_ffr", zza);
            this.zza.zzm().zza("auto", "_ssr", j5, bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza() {
        this.zza.zzv();
        if (this.zza.zzk().zza(this.zza.zzb().currentTimeMillis())) {
            this.zza.zzk().zzg.zza(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.zza.zzj().zzq().zza("Detected application was in foreground");
                zzb(this.zza.zzb().currentTimeMillis(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(long j5, boolean z5) {
        this.zza.zzv();
        this.zza.zzad();
        if (this.zza.zzk().zza(j5)) {
            this.zza.zzk().zzg.zza(true);
            this.zza.zzg().zzaj();
        }
        this.zza.zzk().zzk.zza(j5);
        if (this.zza.zzk().zzg.zza()) {
            zzb(j5, z5);
        }
    }
}
