package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class zzkz implements zzkw {
    private static <E> zzkm<E> zzc(Object obj, long j5) {
        return (zzkm) zzmz.zze(obj, j5);
    }

    @Override // com.google.android.gms.internal.measurement.zzkw
    public final <E> void zza(Object obj, Object obj2, long j5) {
        zzkm zzc = zzc(obj, j5);
        zzkm zzc2 = zzc(obj2, j5);
        int size = zzc.size();
        int size2 = zzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzc.zzc()) {
                zzc = zzc.zza(size2 + size);
            }
            zzc.addAll(zzc2);
        }
        if (size > 0) {
            zzc2 = zzc;
        }
        zzmz.zza(obj, j5, zzc2);
    }

    @Override // com.google.android.gms.internal.measurement.zzkw
    public final void zzb(Object obj, long j5) {
        zzc(obj, j5).zzb();
    }
}
