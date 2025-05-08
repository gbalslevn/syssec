package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzgc$zzb extends zzkg<zzgc$zzb, zza> implements zzlo {
    private static final zzgc$zzb zzc;
    private static volatile zzlz<zzgc$zzb> zzd;
    private int zze;
    private String zzf = BuildConfig.FLAVOR;
    private zzkm<zzgc$zzg> zzg = zzkg.zzcl();
    private boolean zzh;

    /* loaded from: classes.dex */
    public static final class zza extends zzkg.zza<zzgc$zzb, zza> implements zzlo {
        private zza() {
            super(zzgc$zzb.zzc);
        }
    }

    static {
        zzgc$zzb zzgc_zzb = new zzgc$zzb();
        zzc = zzgc_zzb;
        zzkg.zza((Class<zzgc$zzb>) zzgc$zzb.class, zzgc_zzb);
    }

    private zzgc$zzb() {
    }

    public final String zzb() {
        return this.zzf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzgb.zza[i5 - 1]) {
            case 1:
                return new zzgc$zzb();
            case 2:
                return new zza();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zze", "zzf", "zzg", zzgc$zzg.class, "zzh"});
            case 4:
                return zzc;
            case 5:
                zzlz<zzgc$zzb> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzgc$zzb.class) {
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
