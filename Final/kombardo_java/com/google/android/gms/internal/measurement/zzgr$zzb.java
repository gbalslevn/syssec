package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import java.util.List;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzgr$zzb extends zzkg<zzgr$zzb, zza> implements zzlo {
    private static final zzgr$zzb zzc;
    private static volatile zzlz<zzgr$zzb> zzd;
    private int zze;
    private String zzf = BuildConfig.FLAVOR;
    private zzkm<zzgr$zzd> zzg = zzkg.zzcl();

    /* loaded from: classes.dex */
    public static final class zza extends zzkg.zza<zzgr$zzb, zza> implements zzlo {
        private zza() {
            super(zzgr$zzb.zzc);
        }
    }

    static {
        zzgr$zzb zzgr_zzb = new zzgr$zzb();
        zzc = zzgr_zzb;
        zzkg.zza((Class<zzgr$zzb>) zzgr$zzb.class, zzgr_zzb);
    }

    private zzgr$zzb() {
    }

    public final String zzb() {
        return this.zzf;
    }

    public final List<zzgr$zzd> zzc() {
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzgq.zza[i5 - 1]) {
            case 1:
                return new zzgr$zzb();
            case 2:
                return new zza();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zze", "zzf", "zzg", zzgr$zzd.class});
            case 4:
                return zzc;
            case 5:
                zzlz<zzgr$zzb> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzgr$zzb.class) {
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
