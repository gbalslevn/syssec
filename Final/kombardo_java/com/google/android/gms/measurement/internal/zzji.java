package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zzji extends zzjf {
    private boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzji(zzic zzicVar) {
        super(zzicVar);
        this.zzu.zzac();
    }

    protected void zzab() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzad() {
        if (!zzag()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzae() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (zzh()) {
            return;
        }
        this.zzu.zzab();
        this.zza = true;
    }

    public final void zzaf() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzab();
        this.zzu.zzab();
        this.zza = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzag() {
        return this.zza;
    }

    protected abstract boolean zzh();
}
