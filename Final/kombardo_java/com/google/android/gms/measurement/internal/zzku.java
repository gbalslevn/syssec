package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzku extends zzbb {
    private final /* synthetic */ zzju zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzku(zzju zzjuVar, zzjh zzjhVar) {
        super(zzjhVar);
        this.zza = zzjuVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzbb
    public final void zzb() {
        zzbb zzbbVar;
        if (this.zza.zzu.zzaj()) {
            zzbbVar = this.zza.zzr;
            zzbbVar.zza(2000L);
        }
    }
}
