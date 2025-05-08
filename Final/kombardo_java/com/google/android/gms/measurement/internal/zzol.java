package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzol extends zzbb {
    private final /* synthetic */ zzoi zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzol(zzoi zzoiVar, zzjh zzjhVar) {
        super(zzjhVar);
        this.zza = zzoiVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzbb
    public final void zzb() {
        this.zza.zzr();
        this.zza.zzj().zzq().zza("Starting upload from DelayedRunnable");
        this.zza.zzg.zzx();
    }
}
