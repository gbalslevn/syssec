package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import java.util.List;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzfw$zzf extends zzkg<zzfw$zzf, zzb> implements zzlo {
    private static final zzfw$zzf zzc;
    private static volatile zzlz<zzfw$zzf> zzd;
    private int zze;
    private int zzf;
    private boolean zzh;
    private String zzg = BuildConfig.FLAVOR;
    private zzkm<String> zzi = zzkg.zzcl();

    /* loaded from: classes.dex */
    public enum zza implements zzki {
        UNKNOWN_MATCH_TYPE(0),
        REGEXP(1),
        BEGINS_WITH(2),
        ENDS_WITH(3),
        PARTIAL(4),
        EXACT(5),
        IN_LIST(6);

        private final int zzi;

        zza(int i5) {
            this.zzi = i5;
        }

        public static zzkl zzb() {
            return zzga.zza;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + '>';
        }

        @Override // com.google.android.gms.internal.measurement.zzki
        public final int zza() {
            return this.zzi;
        }

        public static zza zza(int i5) {
            switch (i5) {
                case 0:
                    return UNKNOWN_MATCH_TYPE;
                case 1:
                    return REGEXP;
                case 2:
                    return BEGINS_WITH;
                case 3:
                    return ENDS_WITH;
                case 4:
                    return PARTIAL;
                case 5:
                    return EXACT;
                case 6:
                    return IN_LIST;
                default:
                    return null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class zzb extends zzkg.zza<zzfw$zzf, zzb> implements zzlo {
        private zzb() {
            super(zzfw$zzf.zzc);
        }
    }

    static {
        zzfw$zzf zzfw_zzf = new zzfw$zzf();
        zzc = zzfw_zzf;
        zzkg.zza((Class<zzfw$zzf>) zzfw$zzf.class, zzfw_zzf);
    }

    private zzfw$zzf() {
    }

    public static zzfw$zzf zzd() {
        return zzc;
    }

    public final int zza() {
        return this.zzi.size();
    }

    public final zza zzb() {
        zza zza2 = zza.zza(this.zzf);
        return zza2 == null ? zza.UNKNOWN_MATCH_TYPE : zza2;
    }

    public final String zze() {
        return this.zzg;
    }

    public final List<String> zzf() {
        return this.zzi;
    }

    public final boolean zzg() {
        return this.zzh;
    }

    public final boolean zzh() {
        return (this.zze & 4) != 0;
    }

    public final boolean zzi() {
        return (this.zze & 2) != 0;
    }

    public final boolean zzj() {
        return (this.zze & 1) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzfx.zza[i5 - 1]) {
            case 1:
                return new zzfw$zzf();
            case 2:
                return new zzb();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zze", "zzf", zza.zzb(), "zzg", "zzh", "zzi"});
            case 4:
                return zzc;
            case 5:
                zzlz<zzfw$zzf> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzfw$zzf.class) {
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
