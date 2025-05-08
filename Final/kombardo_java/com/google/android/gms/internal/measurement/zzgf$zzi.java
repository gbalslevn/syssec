package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzgf$zzi extends zzkg<zzgf$zzi, zza> implements zzlo {
    private static final zzgf$zzi zzc;
    private static volatile zzlz<zzgf$zzi> zzd;
    private int zze;
    private String zzf = BuildConfig.FLAVOR;
    private String zzg = BuildConfig.FLAVOR;
    private zzgf$zzb zzh;

    /* loaded from: classes.dex */
    public static final class zza extends zzkg.zza<zzgf$zzi, zza> implements zzlo {
        private zza() {
            super(zzgf$zzi.zzc);
        }
    }

    static {
        zzgf$zzi zzgf_zzi = new zzgf$zzi();
        zzc = zzgf_zzi;
        zzkg.zza((Class<zzgf$zzi>) zzgf$zzi.class, zzgf_zzi);
    }

    private zzgf$zzi() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzgi.zza[i5 - 1]) {
            case 1:
                return new zzgf$zzi();
            case 2:
                return new zza();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzlz<zzgf$zzi> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzgf$zzi.class) {
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
