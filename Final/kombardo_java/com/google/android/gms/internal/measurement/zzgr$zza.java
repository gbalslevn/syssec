package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import java.util.List;

/* loaded from: classes.dex */
public final class zzgr$zza extends zzkg<zzgr$zza, zza> implements zzlo {
    private static final zzgr$zza zzc;
    private static volatile zzlz<zzgr$zza> zzd;
    private zzkm<zzgr$zzb> zze = zzkg.zzcl();

    /* loaded from: classes.dex */
    public static final class zza extends zzkg.zza<zzgr$zza, zza> implements zzlo {
        private zza() {
            super(zzgr$zza.zzc);
        }
    }

    static {
        zzgr$zza zzgr_zza = new zzgr$zza();
        zzc = zzgr_zza;
        zzkg.zza((Class<zzgr$zza>) zzgr$zza.class, zzgr_zza);
    }

    private zzgr$zza() {
    }

    public static zzgr$zza zzc() {
        return zzc;
    }

    public final int zza() {
        return this.zze.size();
    }

    public final List<zzgr$zzb> zzd() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzgq.zza[i5 - 1]) {
            case 1:
                return new zzgr$zza();
            case 2:
                return new zza();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zze", zzgr$zzb.class});
            case 4:
                return zzc;
            case 5:
                zzlz<zzgr$zza> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzgr$zza.class) {
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
