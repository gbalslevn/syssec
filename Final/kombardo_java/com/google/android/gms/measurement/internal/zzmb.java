package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzmb implements Runnable {
    private final /* synthetic */ zzlw zza;
    private final /* synthetic */ zzlw zzb;
    private final /* synthetic */ long zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ zzlz zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmb(zzlz zzlzVar, zzlw zzlwVar, zzlw zzlwVar2, long j5, boolean z5) {
        this.zza = zzlwVar;
        this.zzb = zzlwVar2;
        this.zzc = j5;
        this.zzd = z5;
        this.zze = zzlzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zza(this.zza, this.zzb, this.zzc, this.zzd, (Bundle) null);
    }
}
