package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzgf$zzo;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzov {
    private final String zza;
    private final Map<String, String> zzb;
    private final zzlu zzc;
    private final zzgf$zzo zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzov(String str, zzlu zzluVar) {
        this(str, Collections.emptyMap(), zzluVar, null);
    }

    public final zzlu zza() {
        return this.zzc;
    }

    public final zzgf$zzo zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zza;
    }

    public final Map<String, String> zzd() {
        Map<String, String> map = this.zzb;
        return map == null ? Collections.emptyMap() : map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzov(String str, Map<String, String> map, zzlu zzluVar) {
        this(str, map, zzluVar, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzov(String str, Map<String, String> map, zzlu zzluVar, zzgf$zzo zzgf_zzo) {
        this.zza = str;
        this.zzb = map;
        this.zzc = zzluVar;
        this.zzd = zzgf_zzo;
    }
}
