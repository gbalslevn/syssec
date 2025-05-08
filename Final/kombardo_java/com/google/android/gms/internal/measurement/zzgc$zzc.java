package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzgc$zzc extends zzkg<zzgc$zzc, zza> implements zzlo {
    private static final zzgc$zzc zzc;
    private static volatile zzlz<zzgc$zzc> zzd;
    private int zze;
    private String zzf = BuildConfig.FLAVOR;
    private boolean zzg;
    private boolean zzh;
    private int zzi;

    /* loaded from: classes.dex */
    public static final class zza extends zzkg.zza<zzgc$zzc, zza> implements zzlo {
        public final int zza() {
            return ((zzgc$zzc) this.zza).zza();
        }

        public final String zzb() {
            return ((zzgc$zzc) this.zza).zzc();
        }

        public final boolean zzc() {
            return ((zzgc$zzc) this.zza).zzd();
        }

        public final boolean zzd() {
            return ((zzgc$zzc) this.zza).zze();
        }

        public final boolean zze() {
            return ((zzgc$zzc) this.zza).zzf();
        }

        public final boolean zzf() {
            return ((zzgc$zzc) this.zza).zzg();
        }

        public final boolean zzg() {
            return ((zzgc$zzc) this.zza).zzh();
        }

        private zza() {
            super(zzgc$zzc.zzc);
        }

        public final zza zza(String str) {
            zzam();
            zzgc$zzc.zza((zzgc$zzc) this.zza, str);
            return this;
        }
    }

    static {
        zzgc$zzc zzgc_zzc = new zzgc$zzc();
        zzc = zzgc_zzc;
        zzkg.zza((Class<zzgc$zzc>) zzgc$zzc.class, zzgc_zzc);
    }

    private zzgc$zzc() {
    }

    public final int zza() {
        return this.zzi;
    }

    public final String zzc() {
        return this.zzf;
    }

    public final boolean zzd() {
        return this.zzg;
    }

    public final boolean zze() {
        return this.zzh;
    }

    public final boolean zzf() {
        return (this.zze & 2) != 0;
    }

    public final boolean zzg() {
        return (this.zze & 4) != 0;
    }

    public final boolean zzh() {
        return (this.zze & 8) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzgb.zza[i5 - 1]) {
            case 1:
                return new zzgc$zzc();
            case 2:
                return new zza();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzc;
            case 5:
                zzlz<zzgc$zzc> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzgc$zzc.class) {
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

    static /* synthetic */ void zza(zzgc$zzc zzgc_zzc, String str) {
        str.getClass();
        zzgc_zzc.zze |= 1;
        zzgc_zzc.zzf = str;
    }
}
