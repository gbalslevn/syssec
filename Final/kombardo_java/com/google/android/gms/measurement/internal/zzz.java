package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzgf$zzd;
import com.google.android.gms.internal.measurement.zzgf$zze;
import com.google.android.gms.internal.measurement.zzgf$zzm;
import com.google.android.gms.internal.measurement.zzgf$zzn;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzz {
    private String zza;
    private boolean zzb;
    private zzgf$zzm zzc;
    private BitSet zzd;
    private BitSet zze;
    private Map<Integer, Long> zzf;
    private Map<Integer, List<Long>> zzg;
    private final /* synthetic */ zzx zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ BitSet zza(zzz zzzVar) {
        return zzzVar.zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.measurement.zzgf$zzd$zza, com.google.android.gms.internal.measurement.zzkg$zza] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r8v5, types: [com.google.android.gms.internal.measurement.zzgf$zzm$zza] */
    public final zzgf$zzd zza(int i5) {
        ArrayList arrayList;
        ?? arrayList2;
        ?? zzb = zzgf$zzd.zzb();
        zzb.zza(i5);
        zzb.zza(this.zzb);
        zzgf$zzm zzgf_zzm = this.zzc;
        if (zzgf_zzm != null) {
            zzb.zza(zzgf_zzm);
        }
        ?? zzd = zzgf$zzm.zze().zzb(zzpj.zza(this.zzd)).zzd(zzpj.zza(this.zze));
        if (this.zzf == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(this.zzf.size());
            for (Integer num : this.zzf.keySet()) {
                int intValue = num.intValue();
                Long l5 = this.zzf.get(num);
                if (l5 != null) {
                    arrayList.add((zzgf$zze) ((com.google.android.gms.internal.measurement.zzkg) zzgf$zze.zzc().zza(intValue).zza(l5.longValue()).zzaj()));
                }
            }
        }
        if (arrayList != null) {
            zzd.zza(arrayList);
        }
        if (this.zzg == null) {
            arrayList2 = Collections.emptyList();
        } else {
            arrayList2 = new ArrayList(this.zzg.size());
            for (Integer num2 : this.zzg.keySet()) {
                zzgf$zzn.zza zza = zzgf$zzn.zzc().zza(num2.intValue());
                List<Long> list = this.zzg.get(num2);
                if (list != null) {
                    Collections.sort(list);
                    zza.zza(list);
                }
                arrayList2.add((zzgf$zzn) ((com.google.android.gms.internal.measurement.zzkg) zza.zzaj()));
            }
        }
        zzd.zzc(arrayList2);
        zzb.zza(zzd);
        return (zzgf$zzd) ((com.google.android.gms.internal.measurement.zzkg) zzb.zzaj());
    }

    private zzz(zzx zzxVar, String str) {
        this.zzh = zzxVar;
        this.zza = str;
        this.zzb = true;
        this.zzd = new BitSet();
        this.zze = new BitSet();
        this.zzf = new ArrayMap();
        this.zzg = new ArrayMap();
    }

    private zzz(zzx zzxVar, String str, zzgf$zzm zzgf_zzm, BitSet bitSet, BitSet bitSet2, Map<Integer, Long> map, Map<Integer, Long> map2) {
        this.zzh = zzxVar;
        this.zza = str;
        this.zzd = bitSet;
        this.zze = bitSet2;
        this.zzf = map;
        this.zzg = new ArrayMap();
        if (map2 != null) {
            for (Integer num : map2.keySet()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(map2.get(num));
                this.zzg.put(num, arrayList);
            }
        }
        this.zzb = false;
        this.zzc = zzgf_zzm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzaa zzaaVar) {
        int zza = zzaaVar.zza();
        Boolean bool = zzaaVar.zzc;
        if (bool != null) {
            this.zze.set(zza, bool.booleanValue());
        }
        Boolean bool2 = zzaaVar.zzd;
        if (bool2 != null) {
            this.zzd.set(zza, bool2.booleanValue());
        }
        if (zzaaVar.zze != null) {
            Long l5 = this.zzf.get(Integer.valueOf(zza));
            long longValue = zzaaVar.zze.longValue() / 1000;
            if (l5 == null || longValue > l5.longValue()) {
                this.zzf.put(Integer.valueOf(zza), Long.valueOf(longValue));
            }
        }
        if (zzaaVar.zzf != null) {
            List<Long> list = this.zzg.get(Integer.valueOf(zza));
            if (list == null) {
                list = new ArrayList<>();
                this.zzg.put(Integer.valueOf(zza), list);
            }
            if (zzaaVar.zzc()) {
                list.clear();
            }
            if (com.google.android.gms.internal.measurement.zzoh.zza() && this.zzh.zze().zzf(this.zza, zzbn.zzbz) && zzaaVar.zzb()) {
                list.clear();
            }
            if (com.google.android.gms.internal.measurement.zzoh.zza() && this.zzh.zze().zzf(this.zza, zzbn.zzbz)) {
                long longValue2 = zzaaVar.zzf.longValue() / 1000;
                if (list.contains(Long.valueOf(longValue2))) {
                    return;
                }
                list.add(Long.valueOf(longValue2));
                return;
            }
            list.add(Long.valueOf(zzaaVar.zzf.longValue() / 1000));
        }
    }
}
