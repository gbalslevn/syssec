package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;

/* loaded from: classes.dex */
public final class zzgc$zzf extends zzkg<zzgc$zzf, zza> implements zzlo {
    private static final zzgc$zzf zzc;
    private static volatile zzlz<zzgc$zzf> zzd;
    private int zze;
    private int zzf = 14;
    private int zzg = 11;
    private int zzh = 60;

    /* loaded from: classes.dex */
    public static final class zza extends zzkg.zza<zzgc$zzf, zza> implements zzlo {
        private zza() {
            super(zzgc$zzf.zzc);
        }
    }

    static {
        zzgc$zzf zzgc_zzf = new zzgc$zzf();
        zzc = zzgc_zzf;
        zzkg.zza((Class<zzgc$zzf>) zzgc$zzf.class, zzgc_zzf);
    }

    private zzgc$zzf() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzgb.zza[i5 - 1]) {
            case 1:
                return new zzgc$zzf();
            case 2:
                return new zza();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzlz<zzgc$zzf> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzgc$zzf.class) {
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
