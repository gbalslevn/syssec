package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzbb {
    private Map<String, zzay> zza = new HashMap();
    private zzbq zzb = new zzbq();

    public zzbb() {
        zza(new zzaw());
        zza(new zzba());
        zza(new zzbc());
        zza(new zzbg());
        zza(new zzbi());
        zza(new zzbo());
        zza(new zzbt());
    }

    public final zzaq zza(zzh zzhVar, zzaq zzaqVar) {
        zzay zzayVar;
        zzg.zza(zzhVar);
        if (!(zzaqVar instanceof zzat)) {
            return zzaqVar;
        }
        zzat zzatVar = (zzat) zzaqVar;
        ArrayList<zzaq> zzb = zzatVar.zzb();
        String zza = zzatVar.zza();
        if (this.zza.containsKey(zza)) {
            zzayVar = this.zza.get(zza);
        } else {
            zzayVar = this.zzb;
        }
        return zzayVar.zza(zza, zzhVar, zzb);
    }

    private final void zza(zzay zzayVar) {
        Iterator<zzbv> it = zzayVar.zza.iterator();
        while (it.hasNext()) {
            this.zza.put(it.next().toString(), zzayVar);
        }
    }
}
