package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzed;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzei extends zzed.zzb {
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ zzed zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzei(zzed zzedVar, Bundle bundle) {
        super(zzedVar);
        this.zzc = bundle;
        this.zzd = zzedVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzed.zzb
    final void zza() {
        zzdl zzdlVar;
        zzdlVar = this.zzd.zzj;
        ((zzdl) Preconditions.checkNotNull(zzdlVar)).setConditionalUserProperty(this.zzc, this.zza);
    }
}
