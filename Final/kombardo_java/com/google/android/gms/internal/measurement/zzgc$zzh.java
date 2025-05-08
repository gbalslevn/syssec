package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzgc$zzh extends zzkg<zzgc$zzh, zza> implements zzlo {
    private static final zzgc$zzh zzc;
    private static volatile zzlz<zzgc$zzh> zzd;
    private int zze;
    private String zzf = BuildConfig.FLAVOR;
    private String zzg = BuildConfig.FLAVOR;

    /* loaded from: classes.dex */
    public static final class zza extends zzkg.zza<zzgc$zzh, zza> implements zzlo {
        private zza() {
            super(zzgc$zzh.zzc);
        }
    }

    static {
        zzgc$zzh zzgc_zzh = new zzgc$zzh();
        zzc = zzgc_zzh;
        zzkg.zza((Class<zzgc$zzh>) zzgc$zzh.class, zzgc_zzh);
    }

    private zzgc$zzh() {
    }

    public final String zzb() {
        return this.zzf;
    }

    public final String zzc() {
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzgb.zza[i5 - 1]) {
            case 1:
                return new zzgc$zzh();
            case 2:
                return new zza();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzlz<zzgc$zzh> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzgc$zzh.class) {
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
