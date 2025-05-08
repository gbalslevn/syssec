package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzma implements Runnable {
    private final /* synthetic */ zzlz zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzma(zzlz zzlzVar) {
        this.zza = zzlzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlw zzlwVar;
        zzlz zzlzVar = this.zza;
        zzlwVar = zzlzVar.zzh;
        zzlzVar.zza = zzlwVar;
    }
}
