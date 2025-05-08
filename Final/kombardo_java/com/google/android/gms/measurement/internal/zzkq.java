package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzkq implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ long zzc;
    private final /* synthetic */ Bundle zzd;
    private final /* synthetic */ boolean zze;
    private final /* synthetic */ boolean zzf;
    private final /* synthetic */ boolean zzg;
    private final /* synthetic */ String zzh;
    private final /* synthetic */ zzju zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkq(zzju zzjuVar, String str, String str2, long j5, Bundle bundle, boolean z5, boolean z6, boolean z7, String str3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j5;
        this.zzd = bundle;
        this.zze = z5;
        this.zzf = z6;
        this.zzg = z7;
        this.zzh = str3;
        this.zzi = zzjuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzi.zza(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh);
    }
}
