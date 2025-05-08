package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzed;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzfg extends zzed.zzb {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzdm zzd;
    private final /* synthetic */ zzed zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfg(zzed zzedVar, String str, zzdm zzdmVar) {
        super(zzedVar);
        this.zzc = str;
        this.zzd = zzdmVar;
        this.zze = zzedVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzed.zzb
    final void zza() {
        zzdl zzdlVar;
        zzdlVar = this.zze.zzj;
        ((zzdl) Preconditions.checkNotNull(zzdlVar)).getMaxUserProperties(this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.measurement.zzed.zzb
    protected final void zzb() {
        this.zzd.zza((Bundle) null);
    }
}
