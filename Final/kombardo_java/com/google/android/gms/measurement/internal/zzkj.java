package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzkj extends zzbb {
    private final /* synthetic */ zzju zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzkj(zzju zzjuVar, zzjh zzjhVar) {
        super(zzjhVar);
        this.zza = zzjuVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzbb
    public final void zzb() {
        final zzju zzm = this.zza.zzm();
        Objects.requireNonNull(zzm);
        new Thread(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzki
            @Override // java.lang.Runnable
            public final void run() {
                zzju.this.zzas();
            }
        }).start();
    }
}
