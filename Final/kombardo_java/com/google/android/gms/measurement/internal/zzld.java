package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzld implements zzpp {
    private final /* synthetic */ zzju zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzld(zzju zzjuVar) {
        this.zza = zzjuVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzpp
    public final void zza(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            this.zza.zzb("auto", str2, bundle);
        } else {
            this.zza.zza("auto", str2, bundle, str);
        }
    }
}
