package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class zzmw extends zzmu<zzmx, zzmx> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzmu
    public final /* synthetic */ int zza(zzmx zzmxVar) {
        return zzmxVar.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzmu
    public final /* synthetic */ int zzb(zzmx zzmxVar) {
        return zzmxVar.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzmu
    public final /* synthetic */ zzmx zzc(Object obj) {
        zzmx zzmxVar = ((zzkg) obj).zzb;
        if (zzmxVar != zzmx.zzc()) {
            return zzmxVar;
        }
        zzmx zzd = zzmx.zzd();
        zza(obj, zzd);
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzmu
    public final /* synthetic */ zzmx zzd(Object obj) {
        return ((zzkg) obj).zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzmu
    public final void zzf(Object obj) {
        ((zzkg) obj).zzb.zze();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzmu
    public final /* synthetic */ zzmx zza(zzmx zzmxVar, zzmx zzmxVar2) {
        zzmx zzmxVar3 = zzmxVar;
        zzmx zzmxVar4 = zzmxVar2;
        if (zzmx.zzc().equals(zzmxVar4)) {
            return zzmxVar3;
        }
        if (zzmx.zzc().equals(zzmxVar3)) {
            return zzmx.zza(zzmxVar3, zzmxVar4);
        }
        return zzmxVar3.zza(zzmxVar4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzmu
    public final /* synthetic */ void zzb(zzmx zzmxVar, int i5, long j5) {
        zzmxVar.zza(i5 << 3, Long.valueOf(j5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzmu
    public final /* synthetic */ void zzb(Object obj, zzmx zzmxVar) {
        zza(obj, zzmxVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzmu
    public final /* synthetic */ void zzc(Object obj, zzmx zzmxVar) {
        zza(obj, zzmxVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzmu
    public final /* synthetic */ void zzb(zzmx zzmxVar, zznl zznlVar) {
        zzmxVar.zzb(zznlVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzmu
    public final /* synthetic */ void zza(zzmx zzmxVar, int i5, zziy zziyVar) {
        zzmxVar.zza((i5 << 3) | 2, zziyVar);
    }

    private static void zza(Object obj, zzmx zzmxVar) {
        ((zzkg) obj).zzb = zzmxVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzmu
    public final /* synthetic */ void zza(zzmx zzmxVar, zznl zznlVar) {
        zzmxVar.zza(zznlVar);
    }
}
