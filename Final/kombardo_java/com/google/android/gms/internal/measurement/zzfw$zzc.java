package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzfw$zzc extends zzkg<zzfw$zzc, zza> implements zzlo {
    private static final zzfw$zzc zzc;
    private static volatile zzlz<zzfw$zzc> zzd;
    private int zze;
    private zzfw$zzf zzf;
    private zzfw$zzd zzg;
    private boolean zzh;
    private String zzi = BuildConfig.FLAVOR;

    /* loaded from: classes.dex */
    public static final class zza extends zzkg.zza<zzfw$zzc, zza> implements zzlo {
        public final zza zza(String str) {
            zzam();
            zzfw$zzc.zza((zzfw$zzc) this.zza, str);
            return this;
        }

        private zza() {
            super(zzfw$zzc.zzc);
        }
    }

    static {
        zzfw$zzc zzfw_zzc = new zzfw$zzc();
        zzc = zzfw_zzc;
        zzkg.zza((Class<zzfw$zzc>) zzfw$zzc.class, zzfw_zzc);
    }

    private zzfw$zzc() {
    }

    public static zzfw$zzc zzb() {
        return zzc;
    }

    public final zzfw$zzd zzc() {
        zzfw$zzd zzfw_zzd = this.zzg;
        return zzfw_zzd == null ? zzfw$zzd.zzc() : zzfw_zzd;
    }

    public final zzfw$zzf zzd() {
        zzfw$zzf zzfw_zzf = this.zzf;
        return zzfw_zzf == null ? zzfw$zzf.zzd() : zzfw_zzf;
    }

    public final String zze() {
        return this.zzi;
    }

    public final boolean zzf() {
        return this.zzh;
    }

    public final boolean zzg() {
        return (this.zze & 4) != 0;
    }

    public final boolean zzh() {
        return (this.zze & 2) != 0;
    }

    public final boolean zzi() {
        return (this.zze & 8) != 0;
    }

    public final boolean zzj() {
        return (this.zze & 1) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzfx.zza[i5 - 1]) {
            case 1:
                return new zzfw$zzc();
            case 2:
                return new zza();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzc;
            case 5:
                zzlz<zzfw$zzc> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzfw$zzc.class) {
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

    static /* synthetic */ void zza(zzfw$zzc zzfw_zzc, String str) {
        str.getClass();
        zzfw_zzc.zze |= 8;
        zzfw_zzc.zzi = str;
    }
}
