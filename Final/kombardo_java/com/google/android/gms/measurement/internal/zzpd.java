package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzpd implements zzpp {
    final /* synthetic */ zzou zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpd(zzou zzouVar) {
        this.zza = zzouVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzpp
    public final void zza(String str, String str2, Bundle bundle) {
        zzic zzicVar;
        zzic zzicVar2;
        if (!TextUtils.isEmpty(str)) {
            this.zza.zzl().zzb(new zzpc(this, str, str2, bundle));
            return;
        }
        zzicVar = this.zza.zzm;
        if (zzicVar != null) {
            zzicVar2 = this.zza.zzm;
            zzicVar2.zzj().zzg().zza("AppId not known when logging event", str2);
        }
    }
}
