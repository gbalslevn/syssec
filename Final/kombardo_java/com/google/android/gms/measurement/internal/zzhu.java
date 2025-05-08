package com.google.android.gms.measurement.internal;

import java.util.Map;

/* loaded from: classes.dex */
final class zzhu implements com.google.android.gms.internal.measurement.zzo {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzhm zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhu(zzhm zzhmVar, String str) {
        this.zza = str;
        this.zzb = zzhmVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzo
    public final String zza(String str) {
        Map map;
        map = this.zzb.zzb;
        Map map2 = (Map) map.get(this.zza);
        if (map2 == null || !map2.containsKey(str)) {
            return null;
        }
        return (String) map2.get(str);
    }
}
