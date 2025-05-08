package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zzjf implements zzjh {
    protected final zzic zzu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjf(zzic zzicVar) {
        Preconditions.checkNotNull(zzicVar);
        this.zzu = zzicVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzjh
    public Context zza() {
        return this.zzu.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzjh
    public Clock zzb() {
        return this.zzu.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzjh
    public zzaf zzd() {
        return this.zzu.zzd();
    }

    public zzai zze() {
        return this.zzu.zzf();
    }

    public zzbf zzf() {
        return this.zzu.zzg();
    }

    public zzgl zzi() {
        return this.zzu.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzjh
    public zzgo zzj() {
        return this.zzu.zzj();
    }

    public zzha zzk() {
        return this.zzu.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzjh
    public zzhv zzl() {
        return this.zzu.zzl();
    }

    public zzlp zzn() {
        return this.zzu.zzq();
    }

    public zzpn zzs() {
        return this.zzu.zzv();
    }

    public void zzt() {
        this.zzu.zzl().zzt();
    }

    public void zzu() {
        this.zzu.zzaa();
    }

    public void zzv() {
        this.zzu.zzl().zzv();
    }
}
