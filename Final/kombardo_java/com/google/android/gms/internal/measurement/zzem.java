package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzed;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzem extends zzed.zzb {
    private final /* synthetic */ zzeb zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ String zze;
    private final /* synthetic */ zzed zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzem(zzed zzedVar, zzeb zzebVar, String str, String str2) {
        super(zzedVar);
        this.zzc = zzebVar;
        this.zzd = str;
        this.zze = str2;
        this.zzf = zzedVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzed.zzb
    final void zza() {
        zzdl zzdlVar;
        zzdlVar = this.zzf.zzj;
        ((zzdl) Preconditions.checkNotNull(zzdlVar)).setCurrentScreenByScionActivityInfo(this.zzc, this.zzd, this.zze, this.zza);
    }
}
