package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* loaded from: classes.dex */
final class zznn implements Runnable {
    private final /* synthetic */ zznj zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznn(zznj zznjVar) {
        this.zza = zznjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzme.zza(this.zza.zza, new ComponentName(this.zza.zza.zza(), "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
