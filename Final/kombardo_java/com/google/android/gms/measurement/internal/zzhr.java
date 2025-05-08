package com.google.android.gms.measurement.internal;

import java.util.List;

/* loaded from: classes.dex */
final class zzhr implements com.google.android.gms.internal.measurement.zzv {
    private final /* synthetic */ zzhm zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhr(zzhm zzhmVar) {
        this.zza = zzhmVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void zza(com.google.android.gms.internal.measurement.zzs zzsVar, String str, List<String> list, boolean z5, boolean z6) {
        int i5 = zzht.zza[zzsVar.ordinal()];
        zzgq zzp = i5 != 1 ? i5 != 2 ? i5 != 3 ? i5 != 4 ? this.zza.zzj().zzp() : this.zza.zzj().zzq() : z5 ? this.zza.zzj().zzx() : !z6 ? this.zza.zzj().zzw() : this.zza.zzj().zzr() : z5 ? this.zza.zzj().zzo() : !z6 ? this.zza.zzj().zzm() : this.zza.zzj().zzg() : this.zza.zzj().zzc();
        int size = list.size();
        if (size == 1) {
            zzp.zza(str, list.get(0));
            return;
        }
        if (size == 2) {
            zzp.zza(str, list.get(0), list.get(1));
        } else if (size != 3) {
            zzp.zza(str);
        } else {
            zzp.zza(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
