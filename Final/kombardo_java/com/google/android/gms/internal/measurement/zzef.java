package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzed;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzef extends zzed.zzb {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ Object zze;
    private final /* synthetic */ boolean zzf;
    private final /* synthetic */ zzed zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzef(zzed zzedVar, String str, String str2, Object obj, boolean z5) {
        super(zzedVar);
        this.zzc = str;
        this.zzd = str2;
        this.zze = obj;
        this.zzf = z5;
        this.zzg = zzedVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzed.zzb
    final void zza() {
        zzdl zzdlVar;
        zzdlVar = this.zzg.zzj;
        ((zzdl) Preconditions.checkNotNull(zzdlVar)).setUserProperty(this.zzc, this.zzd, ObjectWrapper.wrap(this.zze), this.zzf, this.zza);
    }
}
