package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzed;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzeh extends zzed.zzb {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ Bundle zze;
    private final /* synthetic */ zzed zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzeh(zzed zzedVar, String str, String str2, Bundle bundle) {
        super(zzedVar);
        this.zzc = str;
        this.zzd = str2;
        this.zze = bundle;
        this.zzf = zzedVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzed.zzb
    final void zza() {
        zzdl zzdlVar;
        zzdlVar = this.zzf.zzj;
        ((zzdl) Preconditions.checkNotNull(zzdlVar)).clearConditionalUserProperty(this.zzc, this.zzd, this.zze);
    }
}
