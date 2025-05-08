package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzmp extends zzgd {
    private final /* synthetic */ AtomicReference zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmp(zzme zzmeVar, AtomicReference atomicReference) {
        this.zza = atomicReference;
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void zza(List<zzog> list) {
        synchronized (this.zza) {
            this.zza.set(list);
            this.zza.notifyAll();
        }
    }
}
