package com.google.android.gms.measurement.internal;

import android.content.Intent;
import java.util.Deque;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzpb extends zzbb {
    private final /* synthetic */ zzou zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzpb(zzou zzouVar, zzjh zzjhVar) {
        super(zzjhVar);
        this.zza = zzouVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzbb
    public final void zzb() {
        Deque deque;
        this.zza.zzr();
        deque = this.zza.zzr;
        String str = (String) deque.pollFirst();
        if (str != null) {
            zzou zzouVar = this.zza;
            zzouVar.zzaj = zzouVar.zzb().elapsedRealtime();
            this.zza.zzj().zzq().zza("Sending trigger URI notification to app", str);
            Intent intent = new Intent();
            intent.setAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
            intent.setPackage(str);
            this.zza.zza().sendBroadcast(intent);
        }
        this.zza.zzae();
    }
}
