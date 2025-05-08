package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* loaded from: classes.dex */
final class zzja implements Comparator<zziy> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zziy zziyVar, zziy zziyVar2) {
        zziy zziyVar3 = zziyVar;
        zziy zziyVar4 = zziyVar2;
        zzje zzjeVar = (zzje) zziyVar3.iterator();
        zzje zzjeVar2 = (zzje) zziyVar4.iterator();
        while (zzjeVar.hasNext() && zzjeVar2.hasNext()) {
            int compare = Integer.compare(zziy.zza(zzjeVar.zza()), zziy.zza(zzjeVar2.zza()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zziyVar3.zzb(), zziyVar4.zzb());
    }
}
