package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzed;

/* loaded from: classes.dex */
final class zzfp extends zzed.zzb {
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ zzed.zzc zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfp(zzed.zzc zzcVar, Activity activity) {
        super(zzed.this);
        this.zzc = activity;
        this.zzd = zzcVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzed.zzb
    final void zza() {
        zzdl zzdlVar;
        zzdlVar = zzed.this.zzj;
        ((zzdl) Preconditions.checkNotNull(zzdlVar)).onActivityStartedByScionActivityInfo(zzeb.zza(this.zzc), this.zzb);
    }
}
