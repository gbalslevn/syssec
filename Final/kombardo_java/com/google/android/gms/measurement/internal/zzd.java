package com.google.android.gms.measurement.internal;

import android.text.TextUtils;

/* loaded from: classes.dex */
final class zzd {
    private final zzjm zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzd(zzjm zzjmVar) {
        this.zza = zzjmVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzd zza(String str) {
        zzjm zzjmVar;
        if (!TextUtils.isEmpty(str) && str.length() <= 1) {
            zzjmVar = zzjj.zza(str.charAt(0));
        } else {
            zzjmVar = zzjm.UNINITIALIZED;
        }
        return new zzd(zzjmVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzb() {
        return String.valueOf(zzjj.zza(this.zza));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzjm zza() {
        return this.zza;
    }
}
