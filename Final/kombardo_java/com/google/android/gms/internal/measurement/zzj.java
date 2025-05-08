package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class zzj {
    public static zzaq zza(zzgr$zzd zzgr_zzd) {
        if (zzgr_zzd == null) {
            return zzaq.zzc;
        }
        int i5 = zzi.zza[zzgr_zzd.zzb().ordinal()];
        if (i5 == 1) {
            if (zzgr_zzd.zzj()) {
                return new zzas(zzgr_zzd.zze());
            }
            return zzaq.zzj;
        }
        if (i5 == 2) {
            if (zzgr_zzd.zzi()) {
                return new zzai(Double.valueOf(zzgr_zzd.zza()));
            }
            return new zzai(null);
        }
        if (i5 == 3) {
            if (zzgr_zzd.zzh()) {
                return new zzag(Boolean.valueOf(zzgr_zzd.zzg()));
            }
            return new zzag(null);
        }
        if (i5 != 4) {
            if (i5 != 5) {
                throw new IllegalStateException("Invalid entity: " + String.valueOf(zzgr_zzd));
            }
            throw new IllegalArgumentException("Unknown type found. Cannot convert entity");
        }
        List<zzgr$zzd> zzf = zzgr_zzd.zzf();
        ArrayList arrayList = new ArrayList();
        Iterator<zzgr$zzd> it = zzf.iterator();
        while (it.hasNext()) {
            arrayList.add(zza(it.next()));
        }
        return new zzat(zzgr_zzd.zzd(), arrayList);
    }

    public static zzaq zza(Object obj) {
        if (obj == null) {
            return zzaq.zzd;
        }
        if (obj instanceof String) {
            return new zzas((String) obj);
        }
        if (obj instanceof Double) {
            return new zzai((Double) obj);
        }
        if (obj instanceof Long) {
            return new zzai(Double.valueOf(((Long) obj).doubleValue()));
        }
        if (obj instanceof Integer) {
            return new zzai(Double.valueOf(((Integer) obj).doubleValue()));
        }
        if (obj instanceof Boolean) {
            return new zzag((Boolean) obj);
        }
        if (obj instanceof Map) {
            zzap zzapVar = new zzap();
            Map map = (Map) obj;
            for (Object obj2 : map.keySet()) {
                zzaq zza = zza(map.get(obj2));
                if (obj2 != null) {
                    if (!(obj2 instanceof String)) {
                        obj2 = obj2.toString();
                    }
                    zzapVar.zza((String) obj2, zza);
                }
            }
            return zzapVar;
        }
        if (obj instanceof List) {
            zzaf zzafVar = new zzaf();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzafVar.zza(zza(it.next()));
            }
            return zzafVar;
        }
        throw new IllegalArgumentException("Invalid value type");
    }
}
