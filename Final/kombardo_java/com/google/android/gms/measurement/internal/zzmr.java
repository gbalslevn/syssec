package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzmr extends zzge {
    private final /* synthetic */ AtomicReference zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmr(zzme zzmeVar, AtomicReference atomicReference) {
        this.zza = atomicReference;
    }

    @Override // com.google.android.gms.measurement.internal.zzgf
    public final void zza(zzor zzorVar) {
        synchronized (this.zza) {
            this.zza.set(zzorVar);
            this.zza.notifyAll();
        }
    }
}
