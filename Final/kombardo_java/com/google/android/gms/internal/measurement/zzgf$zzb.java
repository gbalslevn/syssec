package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzgf$zzb extends zzkg<zzgf$zzb, zza> implements zzlo {
    private static final zzgf$zzb zzc;
    private static volatile zzlz<zzgf$zzb> zzd;
    private int zze;
    private String zzf = BuildConfig.FLAVOR;
    private String zzg = BuildConfig.FLAVOR;
    private String zzh = BuildConfig.FLAVOR;
    private String zzi = BuildConfig.FLAVOR;
    private String zzj = BuildConfig.FLAVOR;
    private String zzk = BuildConfig.FLAVOR;
    private String zzl = BuildConfig.FLAVOR;

    /* loaded from: classes.dex */
    public static final class zza extends zzkg.zza<zzgf$zzb, zza> implements zzlo {
        private zza() {
            super(zzgf$zzb.zzc);
        }
    }

    static {
        zzgf$zzb zzgf_zzb = new zzgf$zzb();
        zzc = zzgf_zzb;
        zzkg.zza((Class<zzgf$zzb>) zzgf$zzb.class, zzgf_zzb);
    }

    private zzgf$zzb() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzgi.zza[i5 - 1]) {
            case 1:
                return new zzgf$zzb();
            case 2:
                return new zza();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
            case 4:
                return zzc;
            case 5:
                zzlz<zzgf$zzb> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzgf$zzb.class) {
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
