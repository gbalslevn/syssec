package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zzok extends zzjf implements zzjh {
    protected final zzou zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzok(zzou zzouVar) {
        super(zzouVar.zzk());
        Preconditions.checkNotNull(zzouVar);
        this.zzg = zzouVar;
    }

    public zzpj h_() {
        return this.zzg.zzp();
    }

    public zzx zzg() {
        return this.zzg.zzc();
    }

    public zzar zzh() {
        return this.zzg.zzf();
    }

    public zzhm zzm() {
        return this.zzg.zzi();
    }

    public zznp zzo() {
        return this.zzg.zzn();
    }

    public zzos zzp() {
        return this.zzg.zzo();
    }
}
