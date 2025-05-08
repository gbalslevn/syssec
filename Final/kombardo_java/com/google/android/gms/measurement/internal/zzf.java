package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zzf extends zzg {
    private boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzf(zzic zzicVar) {
        super(zzicVar);
        this.zzu.zzac();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzaa() {
        return this.zza;
    }

    protected abstract boolean zzab();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzw() {
        if (!zzaa()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzx() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (zzab()) {
            return;
        }
        this.zzu.zzab();
        this.zza = true;
    }

    public final void zzy() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzz();
        this.zzu.zzab();
        this.zza = true;
    }

    protected void zzz() {
    }
}
