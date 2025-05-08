package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzed;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzfn extends zzed.zzb {
    private final /* synthetic */ Long zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ String zze;
    private final /* synthetic */ Bundle zzf;
    private final /* synthetic */ boolean zzg;
    private final /* synthetic */ boolean zzh;
    private final /* synthetic */ zzed zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfn(zzed zzedVar, Long l5, String str, String str2, Bundle bundle, boolean z5, boolean z6) {
        super(zzedVar);
        this.zzc = l5;
        this.zzd = str;
        this.zze = str2;
        this.zzf = bundle;
        this.zzg = z5;
        this.zzh = z6;
        this.zzi = zzedVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzed.zzb
    final void zza() {
        zzdl zzdlVar;
        Long l5 = this.zzc;
        long longValue = l5 == null ? this.zza : l5.longValue();
        zzdlVar = this.zzi.zzj;
        ((zzdl) Preconditions.checkNotNull(zzdlVar)).logEvent(this.zzd, this.zze, this.zzf, this.zzg, this.zzh, longValue);
    }
}
