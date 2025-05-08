package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
final class zzpo {
    final String zza;
    final String zzb;
    final String zzc;
    final long zzd;
    final Object zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpo(String str, String str2, String str3, long j5, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(obj);
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = j5;
        this.zze = obj;
    }
}
