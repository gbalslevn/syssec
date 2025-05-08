package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzlh implements Runnable {
    private final /* synthetic */ Boolean zza;
    private final /* synthetic */ zzju zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlh(zzju zzjuVar, Boolean bool) {
        this.zza = bool;
        this.zzb = zzjuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza(this.zza, true);
    }
}
