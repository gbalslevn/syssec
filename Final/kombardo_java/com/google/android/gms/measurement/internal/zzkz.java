package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzkz implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzju zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkz(zzju zzjuVar, Bundle bundle) {
        this.zza = bundle;
        this.zzb = zzjuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzju.zzb(this.zzb, this.zza);
    }
}
