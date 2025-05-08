package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import java.util.List;

/* loaded from: classes.dex */
public final class zzgr$zzc extends zzkg<zzgr$zzc, zza> implements zzlo {
    private static final zzgr$zzc zzc;
    private static volatile zzlz<zzgr$zzc> zzd;
    private int zze;
    private zzkm<zzgr$zzd> zzf = zzkg.zzcl();
    private zzgr$zza zzg;

    /* loaded from: classes.dex */
    public static final class zza extends zzkg.zza<zzgr$zzc, zza> implements zzlo {
        private zza() {
            super(zzgr$zzc.zzc);
        }
    }

    static {
        zzgr$zzc zzgr_zzc = new zzgr$zzc();
        zzc = zzgr_zzc;
        zzkg.zza((Class<zzgr$zzc>) zzgr$zzc.class, zzgr_zzc);
    }

    private zzgr$zzc() {
    }

    public final zzgr$zza zza() {
        zzgr$zza zzgr_zza = this.zzg;
        return zzgr_zza == null ? zzgr$zza.zzc() : zzgr_zza;
    }

    public final List<zzgr$zzd> zzc() {
        return this.zzf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzgq.zza[i5 - 1]) {
            case 1:
                return new zzgr$zzc();
            case 2:
                return new zza();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zze", "zzf", zzgr$zzd.class, "zzg"});
            case 4:
                return zzc;
            case 5:
                zzlz<zzgr$zzc> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzgr$zzc.class) {
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
