package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import java.util.List;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzgr$zzd extends zzkg<zzgr$zzd, zza> implements zzlo {
    private static final zzgr$zzd zzc;
    private static volatile zzlz<zzgr$zzd> zzd;
    private int zze;
    private int zzf;
    private zzkm<zzgr$zzd> zzg = zzkg.zzcl();
    private String zzh = BuildConfig.FLAVOR;
    private String zzi = BuildConfig.FLAVOR;
    private boolean zzj;
    private double zzk;

    /* loaded from: classes.dex */
    public static final class zza extends zzkg.zza<zzgr$zzd, zza> implements zzlo {
        private zza() {
            super(zzgr$zzd.zzc);
        }
    }

    /* loaded from: classes.dex */
    public enum zzb implements zzki {
        UNKNOWN(0),
        STRING(1),
        NUMBER(2),
        BOOLEAN(3),
        STATEMENT(4);

        private final int zzg;

        zzb(int i5) {
            this.zzg = i5;
        }

        public static zzkl zzb() {
            return zzgs.zza;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
        }

        @Override // com.google.android.gms.internal.measurement.zzki
        public final int zza() {
            return this.zzg;
        }

        public static zzb zza(int i5) {
            if (i5 == 0) {
                return UNKNOWN;
            }
            if (i5 == 1) {
                return STRING;
            }
            if (i5 == 2) {
                return NUMBER;
            }
            if (i5 == 3) {
                return BOOLEAN;
            }
            if (i5 != 4) {
                return null;
            }
            return STATEMENT;
        }
    }

    static {
        zzgr$zzd zzgr_zzd = new zzgr$zzd();
        zzc = zzgr_zzd;
        zzkg.zza((Class<zzgr$zzd>) zzgr$zzd.class, zzgr_zzd);
    }

    private zzgr$zzd() {
    }

    public final double zza() {
        return this.zzk;
    }

    public final zzb zzb() {
        zzb zza2 = zzb.zza(this.zzf);
        return zza2 == null ? zzb.UNKNOWN : zza2;
    }

    public final String zzd() {
        return this.zzh;
    }

    public final String zze() {
        return this.zzi;
    }

    public final List<zzgr$zzd> zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return this.zzj;
    }

    public final boolean zzh() {
        return (this.zze & 8) != 0;
    }

    public final boolean zzi() {
        return (this.zze & 16) != 0;
    }

    public final boolean zzj() {
        return (this.zze & 4) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzgq.zza[i5 - 1]) {
            case 1:
                return new zzgr$zzd();
            case 2:
                return new zza();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006က\u0004", new Object[]{"zze", "zzf", zzb.zzb(), "zzg", zzgr$zzd.class, "zzh", "zzi", "zzj", "zzk"});
            case 4:
                return zzc;
            case 5:
                zzlz<zzgr$zzd> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzgr$zzd.class) {
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
