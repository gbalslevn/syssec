package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* loaded from: classes.dex */
final class zznl implements Runnable {
    private final /* synthetic */ ComponentName zza;
    private final /* synthetic */ zznj zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznl(zznj zznjVar, ComponentName componentName) {
        this.zza = componentName;
        this.zzb = zznjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzme.zza(this.zzb.zza, this.zza);
    }
}
