package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzgc$zzi extends zzkg<zzgc$zzi, zza> implements zzlo {
    private static final zzgc$zzi zzc;
    private static volatile zzlz<zzgc$zzi> zzd;
    private int zze;
    private int zzi;
    private String zzf = BuildConfig.FLAVOR;
    private String zzg = BuildConfig.FLAVOR;
    private String zzh = BuildConfig.FLAVOR;
    private String zzj = BuildConfig.FLAVOR;

    /* loaded from: classes.dex */
    public static final class zza extends zzkg.zza<zzgc$zzi, zza> implements zzlo {
        private zza() {
            super(zzgc$zzi.zzc);
        }
    }

    static {
        zzgc$zzi zzgc_zzi = new zzgc$zzi();
        zzc = zzgc_zzi;
        zzkg.zza((Class<zzgc$zzi>) zzgc$zzi.class, zzgc_zzi);
    }

    private zzgc$zzi() {
    }

    public static zzgc$zzi zzc() {
        return zzc;
    }

    public final int zza() {
        return this.zzi;
    }

    public final String zzd() {
        return this.zzg;
    }

    public final String zze() {
        return this.zzj;
    }

    public final String zzf() {
        return this.zzf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzgb.zza[i5 - 1]) {
            case 1:
                return new zzgc$zzi();
            case 2:
                return new zza();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003\u0005ဈ\u0004", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
            case 4:
                return zzc;
            case 5:
                zzlz<zzgc$zzi> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzgc$zzi.class) {
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
