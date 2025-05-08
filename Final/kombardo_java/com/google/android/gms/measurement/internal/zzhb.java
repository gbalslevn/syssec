package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzhb implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzgy zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhb(zzgy zzgyVar, boolean z5) {
        this.zza = z5;
        this.zzb = zzgyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzou zzouVar;
        zzouVar = this.zzb.zza;
        zzouVar.zza(this.zza);
    }
}
