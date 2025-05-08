package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzmx extends zzbb {
    private final /* synthetic */ zzme zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzmx(zzme zzmeVar, zzjh zzjhVar) {
        super(zzjhVar);
        this.zza = zzmeVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzbb
    public final void zzb() {
        this.zza.zzj().zzr().zza("Tasks have been queued for a long time");
    }
}
