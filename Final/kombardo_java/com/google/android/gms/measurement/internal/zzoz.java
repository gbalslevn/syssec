package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzoz implements zzgu {
    private final /* synthetic */ String zza;
    private final /* synthetic */ List zzb;
    private final /* synthetic */ zzou zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzoz(zzou zzouVar, String str, List list) {
        this.zza = str;
        this.zzb = list;
        this.zzc = zzouVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    public final void zza(String str, int i5, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.zzc.zza(true, i5, th, bArr, this.zza, this.zzb);
    }
}
