package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfw$zzb;
import com.google.android.gms.internal.measurement.zzfw$zze;
import com.google.android.gms.internal.measurement.zzgf$zzd;
import com.google.android.gms.internal.measurement.zzgf$zze;
import com.google.android.gms.internal.measurement.zzgf$zzf;
import com.google.android.gms.internal.measurement.zzgf$zzm;
import com.google.android.gms.internal.measurement.zzgf$zzn;
import com.google.android.gms.internal.measurement.zzgf$zzp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzx extends zzot {
    private String zza;
    private Set<Integer> zzb;
    private Map<Integer, zzz> zzc;
    private Long zzd;
    private Long zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzx(zzou zzouVar) {
        super(zzouVar);
    }

    private final zzz zza(Integer num) {
        if (this.zzc.containsKey(num)) {
            return this.zzc.get(num);
        }
        zzz zzzVar = new zzz(this, this.zza);
        this.zzc.put(num, zzzVar);
        return zzzVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzot
    protected final boolean zzc() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x05dd, code lost:
    
        r7 = zzj().zzr();
        r8 = com.google.android.gms.measurement.internal.zzgo.zza(r52.zza);
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x05ef, code lost:
    
        if (r9.zzi() == false) goto L206;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x05f1, code lost:
    
        r9 = java.lang.Integer.valueOf(r9.zza());
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x05fb, code lost:
    
        r7.zza("Invalid property filter ID. appId, id", r8, java.lang.String.valueOf(r9));
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x05fa, code lost:
    
        r9 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<zzgf$zzd> zza(String str, List<zzgf$zzf> list, List<zzgf$zzp> list2, Long l5, Long l6, boolean z5) {
        boolean z6;
        zzbh zzbhVar;
        zzy zzyVar;
        ArrayMap arrayMap;
        Map<Integer, zzgf$zzm> map;
        List<zzfw$zzb> list3;
        Map<Integer, zzgf$zzm> map2;
        Iterator<zzgf$zzn> it;
        Map<Integer, List<Integer>> map3;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        this.zza = str;
        this.zzb = new HashSet();
        this.zzc = new ArrayMap();
        this.zzd = l5;
        this.zze = l6;
        Iterator<zzgf$zzf> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                z6 = false;
                break;
            }
            if ("_s".equals(it2.next().zzg())) {
                z6 = true;
                break;
            }
        }
        boolean z7 = com.google.android.gms.internal.measurement.zzoh.zza() && zze().zzf(this.zza, zzbn.zzbz);
        boolean z8 = com.google.android.gms.internal.measurement.zzoh.zza() && zze().zzf(this.zza, zzbn.zzby);
        if (z6) {
            zzar zzh = zzh();
            String str2 = this.zza;
            zzh.zzam();
            zzh.zzv();
            Preconditions.checkNotEmpty(str2);
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_session_count", (Integer) 0);
            try {
                zzh.f_().update("events", contentValues, "app_id = ?", new String[]{str2});
            } catch (SQLiteException e5) {
                zzh.zzj().zzg().zza("Error resetting session-scoped event counts. appId", zzgo.zza(str2), e5);
            }
        }
        Map<Integer, List<zzfw$zzb>> emptyMap = Collections.emptyMap();
        if (z8 && z7) {
            emptyMap = zzh().zzm(this.zza);
        }
        Map<Integer, zzgf$zzm> zzl = zzh().zzl(this.zza);
        if (!zzl.isEmpty()) {
            HashSet hashSet = new HashSet(zzl.keySet());
            if (z6) {
                String str3 = this.zza;
                Map<Integer, List<Integer>> zzn = zzh().zzn(this.zza);
                Preconditions.checkNotEmpty(str3);
                Preconditions.checkNotNull(zzl);
                ArrayMap arrayMap2 = new ArrayMap();
                if (!zzl.isEmpty()) {
                    for (Integer num : zzl.keySet()) {
                        num.intValue();
                        zzgf$zzm zzgf_zzm = zzl.get(num);
                        List<Integer> list4 = zzn.get(num);
                        if (list4 != null && !list4.isEmpty()) {
                            List<Long> zza = h_().zza(zzgf_zzm.zzi(), list4);
                            if (!zza.isEmpty()) {
                                zzgf$zzm.zza zzb = zzgf_zzm.zzch().zzb().zzb(zza);
                                zzb.zzd().zzd(h_().zza(zzgf_zzm.zzk(), list4));
                                ArrayList arrayList = new ArrayList();
                                for (zzgf$zze zzgf_zze : zzgf_zzm.zzh()) {
                                    Map<Integer, List<Integer>> map4 = zzn;
                                    if (!list4.contains(Integer.valueOf(zzgf_zze.zza()))) {
                                        arrayList.add(zzgf_zze);
                                    }
                                    zzn = map4;
                                }
                                map3 = zzn;
                                zzb.zza().zza(arrayList);
                                ArrayList arrayList2 = new ArrayList();
                                for (zzgf$zzn zzgf_zzn : zzgf_zzm.zzj()) {
                                    if (!list4.contains(Integer.valueOf(zzgf_zzn.zzb()))) {
                                        arrayList2.add(zzgf_zzn);
                                    }
                                }
                                zzb.zzc().zzc(arrayList2);
                                arrayMap2.put(num, (zzgf$zzm) ((com.google.android.gms.internal.measurement.zzkg) zzb.zzaj()));
                            }
                        } else {
                            map3 = zzn;
                            arrayMap2.put(num, zzgf_zzm);
                        }
                        zzn = map3;
                    }
                }
                map = arrayMap2;
            } else {
                map = zzl;
            }
            Iterator it3 = hashSet.iterator();
            while (it3.hasNext()) {
                Integer num2 = (Integer) it3.next();
                num2.intValue();
                zzgf$zzm zzgf_zzm2 = map.get(num2);
                BitSet bitSet = new BitSet();
                BitSet bitSet2 = new BitSet();
                ArrayMap arrayMap3 = new ArrayMap();
                if (zzgf_zzm2 != null && zzgf_zzm2.zza() != 0) {
                    for (zzgf$zze zzgf_zze2 : zzgf_zzm2.zzh()) {
                        if (zzgf_zze2.zzf()) {
                            arrayMap3.put(Integer.valueOf(zzgf_zze2.zza()), zzgf_zze2.zze() ? Long.valueOf(zzgf_zze2.zzb()) : null);
                        }
                    }
                }
                ArrayMap arrayMap4 = new ArrayMap();
                if (zzgf_zzm2 != null && zzgf_zzm2.zzc() != 0) {
                    Iterator<zzgf$zzn> it4 = zzgf_zzm2.zzj().iterator();
                    while (it4.hasNext()) {
                        zzgf$zzn next = it4.next();
                        if (!next.zzf() || next.zza() <= 0) {
                            it = it4;
                        } else {
                            it = it4;
                            arrayMap4.put(Integer.valueOf(next.zzb()), Long.valueOf(next.zza(next.zza() - 1)));
                        }
                        it4 = it;
                    }
                }
                if (zzgf_zzm2 != null) {
                    int i5 = 0;
                    while (i5 < (zzgf_zzm2.zzd() << 6)) {
                        if (zzpj.zza(zzgf_zzm2.zzk(), i5)) {
                            map2 = map;
                            zzj().zzq().zza("Filter already evaluated. audience ID, filter ID", num2, Integer.valueOf(i5));
                            bitSet2.set(i5);
                            if (zzpj.zza(zzgf_zzm2.zzi(), i5)) {
                                bitSet.set(i5);
                                i5++;
                                map = map2;
                            }
                        } else {
                            map2 = map;
                        }
                        arrayMap3.remove(Integer.valueOf(i5));
                        i5++;
                        map = map2;
                    }
                }
                Map<Integer, zzgf$zzm> map5 = map;
                zzgf$zzm zzgf_zzm3 = zzl.get(num2);
                if (z8 && z7 && (list3 = emptyMap.get(num2)) != null && this.zze != null && this.zzd != null) {
                    for (zzfw$zzb zzfw_zzb : list3) {
                        int zzb2 = zzfw_zzb.zzb();
                        long longValue = this.zze.longValue() / 1000;
                        if (zzfw_zzb.zzi()) {
                            longValue = this.zzd.longValue() / 1000;
                        }
                        if (arrayMap3.containsKey(Integer.valueOf(zzb2))) {
                            arrayMap3.put(Integer.valueOf(zzb2), Long.valueOf(longValue));
                        }
                        if (arrayMap4.containsKey(Integer.valueOf(zzb2))) {
                            arrayMap4.put(Integer.valueOf(zzb2), Long.valueOf(longValue));
                        }
                    }
                }
                this.zzc.put(num2, new zzz(this, this.zza, zzgf_zzm3, bitSet, bitSet2, arrayMap3, arrayMap4));
                it3 = it3;
                map = map5;
            }
        }
        if (!list.isEmpty()) {
            zzy zzyVar2 = new zzy(this);
            ArrayMap arrayMap5 = new ArrayMap();
            for (zzgf$zzf zzgf_zzf : list) {
                zzgf$zzf zza2 = zzyVar2.zza(this.zza, zzgf_zzf);
                if (zza2 != null) {
                    zzar zzh2 = zzh();
                    String str4 = this.zza;
                    String zzg = zza2.zzg();
                    zzbh zzd = zzh2.zzd(str4, zzgf_zzf.zzg());
                    if (zzd == null) {
                        zzh2.zzj().zzr().zza("Event aggregate wasn't created during raw event logging. appId, event", zzgo.zza(str4), zzh2.zzi().zza(zzg));
                        zzbhVar = new zzbh(str4, zzgf_zzf.zzg(), 1L, 1L, 1L, zzgf_zzf.zzd(), 0L, null, null, null, null);
                    } else {
                        zzbhVar = new zzbh(zzd.zza, zzd.zzb, zzd.zzc + 1, zzd.zzd + 1, zzd.zze + 1, zzd.zzf, zzd.zzg, zzd.zzh, zzd.zzi, zzd.zzj, zzd.zzk);
                    }
                    zzh().zza(zzbhVar);
                    if (!z5) {
                        long j5 = zzbhVar.zzc;
                        String zzg2 = zza2.zzg();
                        Map<Integer, List<zzfw$zzb>> map6 = (Map) arrayMap5.get(zzg2);
                        if (map6 == null) {
                            map6 = zzh().zzf(this.zza, zzg2);
                            arrayMap5.put(zzg2, map6);
                        }
                        for (Integer num3 : map6.keySet()) {
                            int intValue = num3.intValue();
                            if (this.zzb.contains(num3)) {
                                zzj().zzq().zza("Skipping failed audience ID", num3);
                            } else {
                                Iterator<zzfw$zzb> it5 = map6.get(num3).iterator();
                                boolean z9 = true;
                                while (true) {
                                    if (!it5.hasNext()) {
                                        zzyVar = zzyVar2;
                                        arrayMap = arrayMap5;
                                        break;
                                    }
                                    zzfw$zzb next2 = it5.next();
                                    zzyVar = zzyVar2;
                                    zzab zzabVar = new zzab(this, this.zza, intValue, next2);
                                    arrayMap = arrayMap5;
                                    z9 = zzabVar.zza(this.zzd, this.zze, zza2, j5, zzbhVar, zza(intValue, next2.zzb()));
                                    if (z9) {
                                        zza(num3).zza(zzabVar);
                                        zzyVar2 = zzyVar;
                                        arrayMap5 = arrayMap;
                                    } else {
                                        this.zzb.add(num3);
                                        break;
                                    }
                                }
                                if (!z9) {
                                    this.zzb.add(num3);
                                }
                                zzyVar2 = zzyVar;
                                arrayMap5 = arrayMap;
                            }
                        }
                    }
                }
            }
        }
        if (z5) {
            return new ArrayList();
        }
        if (!list2.isEmpty()) {
            ArrayMap arrayMap6 = new ArrayMap();
            for (zzgf$zzp zzgf_zzp : list2) {
                String zzg3 = zzgf_zzp.zzg();
                Map<Integer, List<zzfw$zze>> map7 = (Map) arrayMap6.get(zzg3);
                if (map7 == null) {
                    map7 = zzh().zzg(this.zza, zzg3);
                    arrayMap6.put(zzg3, map7);
                }
                Iterator<Integer> it6 = map7.keySet().iterator();
                while (true) {
                    if (it6.hasNext()) {
                        Integer next3 = it6.next();
                        int intValue2 = next3.intValue();
                        if (this.zzb.contains(next3)) {
                            zzj().zzq().zza("Skipping failed audience ID", next3);
                            break;
                        }
                        Iterator<zzfw$zze> it7 = map7.get(next3).iterator();
                        boolean z10 = true;
                        while (true) {
                            if (!it7.hasNext()) {
                                break;
                            }
                            zzfw$zze next4 = it7.next();
                            if (zzj().zza(2)) {
                                zzj().zzq().zza("Evaluating filter. audience, filter, property", next3, next4.zzi() ? Integer.valueOf(next4.zza()) : null, zzi().zzc(next4.zze()));
                                zzj().zzq().zza("Filter definition", h_().zza(next4));
                            }
                            if (!next4.zzi() || next4.zza() > 256) {
                                break;
                            }
                            zzad zzadVar = new zzad(this, this.zza, intValue2, next4);
                            z10 = zzadVar.zza(this.zzd, this.zze, zzgf_zzp, zza(intValue2, next4.zza()));
                            if (z10) {
                                zza(next3).zza(zzadVar);
                            } else {
                                this.zzb.add(next3);
                                break;
                            }
                        }
                        if (!z10) {
                            this.zzb.add(next3);
                        }
                    }
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Set<Integer> keySet = this.zzc.keySet();
        keySet.removeAll(this.zzb);
        for (Integer num4 : keySet) {
            int intValue3 = num4.intValue();
            zzz zzzVar = this.zzc.get(num4);
            Preconditions.checkNotNull(zzzVar);
            zzgf$zzd zza3 = zzzVar.zza(intValue3);
            arrayList3.add(zza3);
            zzar zzh3 = zzh();
            String str5 = this.zza;
            zzgf$zzm zzd2 = zza3.zzd();
            zzh3.zzam();
            zzh3.zzv();
            Preconditions.checkNotEmpty(str5);
            Preconditions.checkNotNull(zzd2);
            byte[] zzce = zzd2.zzce();
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("app_id", str5);
            contentValues2.put("audience_id", num4);
            contentValues2.put("current_results", zzce);
            try {
            } catch (SQLiteException e6) {
                e = e6;
            }
            try {
                if (zzh3.f_().insertWithOnConflict("audience_filter_values", null, contentValues2, 5) == -1) {
                    zzh3.zzj().zzg().zza("Failed to insert filter results (got -1). appId", zzgo.zza(str5));
                }
            } catch (SQLiteException e7) {
                e = e7;
                zzh3.zzj().zzg().zza("Error storing filter results. appId", zzgo.zza(str5), e);
            }
        }
        return arrayList3;
    }

    private final boolean zza(int i5, int i6) {
        zzz zzzVar = this.zzc.get(Integer.valueOf(i5));
        if (zzzVar == null) {
            return false;
        }
        return zzz.zza(zzzVar).get(i6);
    }
}
