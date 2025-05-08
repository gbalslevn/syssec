package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;

/* loaded from: classes.dex */
public final class zzgc$zze extends zzkg<zzgc$zze, zza> implements zzlo {
    private static final zzgc$zze zzc;
    private static volatile zzlz<zzgc$zze> zzd;
    private zzkm<String> zze = zzkg.zzcl();

    /* loaded from: classes.dex */
    public static final class zza extends zzkg.zza<zzgc$zze, zza> implements zzlo {
        private zza() {
            super(zzgc$zze.zzc);
        }
    }

    static {
        zzgc$zze zzgc_zze = new zzgc$zze();
        zzc = zzgc_zze;
        zzkg.zza((Class<zzgc$zze>) zzgc$zze.class, zzgc_zze);
    }

    private zzgc$zze() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzgb.zza[i5 - 1]) {
            case 1:
                return new zzgc$zze();
            case 2:
                return new zza();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzlz<zzgc$zze> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzgc$zze.class) {
                        try {
                            zzlzVar = zzd;
                            if (zzlzVar == null) {
                                zzlzVar = new zzkg.zzc<>(zzc);
                                zzd = zzlzVar;
                            }
                        } finally {
                        }
                    }
                }
                return zzlzVar;
            case 6:
                return (byte) 1;
            default:
                throw null;
        }
    }
}
