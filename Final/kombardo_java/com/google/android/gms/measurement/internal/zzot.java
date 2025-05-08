package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zzot extends zzok {
    private boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzot(zzou zzouVar) {
        super(zzouVar);
        this.zzg.zzv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzam() {
        if (!zzao()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzan() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzc();
        this.zzg.zzu();
        this.zza = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzao() {
        return this.zza;
    }

    protected abstract boolean zzc();
}
