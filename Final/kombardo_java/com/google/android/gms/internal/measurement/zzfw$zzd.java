package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzfw$zzd extends zzkg<zzfw$zzd, zzb> implements zzlo {
    private static final zzfw$zzd zzc;
    private static volatile zzlz<zzfw$zzd> zzd;
    private int zze;
    private int zzf;
    private boolean zzg;
    private String zzh = BuildConfig.FLAVOR;
    private String zzi = BuildConfig.FLAVOR;
    private String zzj = BuildConfig.FLAVOR;

    /* loaded from: classes.dex */
    public enum zza implements zzki {
        UNKNOWN_COMPARISON_TYPE(0),
        LESS_THAN(1),
        GREATER_THAN(2),
        EQUAL(3),
        BETWEEN(4);

        private final int zzg;

        zza(int i5) {
            this.zzg = i5;
        }

        public static zzkl zzb() {
            return zzfy.zza;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
        }

        @Override // com.google.android.gms.internal.measurement.zzki
        public final int zza() {
            return this.zzg;
        }

        public static zza zza(int i5) {
            if (i5 == 0) {
                return UNKNOWN_COMPARISON_TYPE;
            }
            if (i5 == 1) {
                return LESS_THAN;
            }
            if (i5 == 2) {
                return GREATER_THAN;
            }
            if (i5 == 3) {
                return EQUAL;
            }
            if (i5 != 4) {
                return null;
            }
            return BETWEEN;
        }
    }

    /* loaded from: classes.dex */
    public static final class zzb extends zzkg.zza<zzfw$zzd, zzb> implements zzlo {
        private zzb() {
            super(zzfw$zzd.zzc);
        }
    }

    static {
        zzfw$zzd zzfw_zzd = new zzfw$zzd();
        zzc = zzfw_zzd;
        zzkg.zza((Class<zzfw$zzd>) zzfw$zzd.class, zzfw_zzd);
    }

    private zzfw$zzd() {
    }

    public static zzfw$zzd zzc() {
        return zzc;
    }

    public final zza zza() {
        zza zza2 = zza.zza(this.zzf);
        return zza2 == null ? zza.UNKNOWN_COMPARISON_TYPE : zza2;
    }

    public final String zzd() {
        return this.zzh;
    }

    public final String zze() {
        return this.zzj;
    }

    public final String zzf() {
        return this.zzi;
    }

    public final boolean zzg() {
        return this.zzg;
    }

    public final boolean zzh() {
        return (this.zze & 1) != 0;
    }

    public final boolean zzi() {
        return (this.zze & 4) != 0;
    }

    public final boolean zzj() {
        return (this.zze & 2) != 0;
    }

    public final boolean zzk() {
        return (this.zze & 16) != 0;
    }

    public final boolean zzl() {
        return (this.zze & 8) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzfx.zza[i5 - 1]) {
            case 1:
                return new zzfw$zzd();
            case 2:
                return new zzb();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zze", "zzf", zza.zzb(), "zzg", "zzh", "zzi", "zzj"});
            case 4:
                return zzc;
            case 5:
                zzlz<zzfw$zzd> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzfw$zzd.class) {
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
