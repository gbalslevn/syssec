package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzgf$zzg extends zzkg<zzgf$zzg, zza> implements zzlo {
    private static final zzgf$zzg zzc;
    private static volatile zzlz<zzgf$zzg> zzd;
    private int zze;
    private String zzf = BuildConfig.FLAVOR;
    private long zzg;

    /* loaded from: classes.dex */
    public static final class zza extends zzkg.zza<zzgf$zzg, zza> implements zzlo {
        public final zza zza(long j5) {
            zzam();
            zzgf$zzg.zza((zzgf$zzg) this.zza, j5);
            return this;
        }

        private zza() {
            super(zzgf$zzg.zzc);
        }

        public final zza zza(String str) {
            zzam();
            zzgf$zzg.zza((zzgf$zzg) this.zza, str);
            return this;
        }
    }

    static {
        zzgf$zzg zzgf_zzg = new zzgf$zzg();
        zzc = zzgf_zzg;
        zzkg.zza((Class<zzgf$zzg>) zzgf$zzg.class, zzgf_zzg);
    }

    private zzgf$zzg() {
    }

    public static zza zza() {
        return zzc.zzcg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzgi.zza[i5 - 1]) {
            case 1:
                return new zzgf$zzg();
            case 2:
                return new zza();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzlz<zzgf$zzg> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzgf$zzg.class) {
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

    static /* synthetic */ void zza(zzgf$zzg zzgf_zzg, long j5) {
        zzgf_zzg.zze |= 2;
        zzgf_zzg.zzg = j5;
    }

    static /* synthetic */ void zza(zzgf$zzg zzgf_zzg, String str) {
        str.getClass();
        zzgf_zzg.zze |= 1;
        zzgf_zzg.zzf = str;
    }
}
