package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes.dex */
public final class zzbg extends zzay {
    /* JADX INFO: Access modifiers changed from: protected */
    public zzbg() {
        this.zza.add(zzbv.AND);
        this.zza.add(zzbv.NOT);
        this.zza.add(zzbv.OR);
    }

    @Override // com.google.android.gms.internal.measurement.zzay
    public final zzaq zza(String str, zzh zzhVar, List<zzaq> list) {
        int i5 = zzbj.zza[zzg.zza(str).ordinal()];
        if (i5 == 1) {
            zzg.zza(zzbv.AND, 2, list);
            zzaq zza = zzhVar.zza(list.get(0));
            return !zza.zzd().booleanValue() ? zza : zzhVar.zza(list.get(1));
        }
        if (i5 == 2) {
            zzg.zza(zzbv.NOT, 1, list);
            return new zzag(Boolean.valueOf(!zzhVar.zza(list.get(0)).zzd().booleanValue()));
        }
        if (i5 != 3) {
            return super.zza(str);
        }
        zzg.zza(zzbv.OR, 2, list);
        zzaq zza2 = zzhVar.zza(list.get(0));
        return zza2.zzd().booleanValue() ? zza2 : zzhVar.zza(list.get(1));
    }
}
