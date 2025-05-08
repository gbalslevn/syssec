package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class zzlf implements zzln {
    private zzln[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlf(zzln... zzlnVarArr) {
        this.zza = zzlnVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzln
    public final zzlk zza(Class<?> cls) {
        for (zzln zzlnVar : this.zza) {
            if (zzlnVar.zzb(cls)) {
                return zzlnVar.zza(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
    }

    @Override // com.google.android.gms.internal.measurement.zzln
    public final boolean zzb(Class<?> cls) {
        for (zzln zzlnVar : this.zza) {
            if (zzlnVar.zzb(cls)) {
                return true;
            }
        }
        return false;
    }
}
