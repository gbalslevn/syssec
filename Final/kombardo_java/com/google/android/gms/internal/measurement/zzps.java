package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzps implements zzpp {
    private static final zzhx<Boolean> zza = new zzif(zzhu.zza("com.google.android.gms.measurement")).zzb().zza().zza("measurement.integration.disable_firebase_instance_id", false);

    @Override // com.google.android.gms.internal.measurement.zzpp
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzpp
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }
}
