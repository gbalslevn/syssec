package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import java.util.List;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzgc$zza extends zzkg<zzgc$zza, zza> implements zzlo {
    private static final zzgc$zza zzc;
    private static volatile zzlz<zzgc$zza> zzd;
    private int zze;
    private boolean zzi;
    private zzkm<zzb> zzf = zzkg.zzcl();
    private zzkm<zzc> zzg = zzkg.zzcl();
    private zzkm<zzf> zzh = zzkg.zzcl();
    private zzkm<zzb> zzj = zzkg.zzcl();

    /* loaded from: classes.dex */
    public static final class zza extends zzkg.zza<zzgc$zza, zza> implements zzlo {
        private zza() {
            super(zzgc$zza.zzc);
        }
    }

    /* loaded from: classes.dex */
    public static final class zzb extends zzkg<zzb, zza> implements zzlo {
        private static final zzb zzc;
        private static volatile zzlz<zzb> zzd;
        private int zze;
        private int zzf;
        private int zzg;

        /* loaded from: classes.dex */
        public static final class zza extends zzkg.zza<zzb, zza> implements zzlo {
            private zza() {
                super(zzb.zzc);
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzc = zzbVar;
            zzkg.zza((Class<zzb>) zzb.class, zzbVar);
        }

        private zzb() {
        }

        public final zzd zzb() {
            zzd zza2 = zzd.zza(this.zzg);
            return zza2 == null ? zzd.CONSENT_STATUS_UNSPECIFIED : zza2;
        }

        public final zze zzc() {
            zze zza2 = zze.zza(this.zzf);
            return zza2 == null ? zze.CONSENT_TYPE_UNSPECIFIED : zza2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzkg
        public final Object zza(int i5, Object obj, Object obj2) {
            switch (zzgb.zza[i5 - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza();
                case 3:
                    return zzkg.zza(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zze", "zzf", zze.zzb(), "zzg", zzd.zzb()});
                case 4:
                    return zzc;
                case 5:
                    zzlz<zzb> zzlzVar = zzd;
                    if (zzlzVar == null) {
                        synchronized (zzb.class) {
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

    /* loaded from: classes.dex */
    public static final class zzc extends zzkg<zzc, zza> implements zzlo {
        private static final zzc zzc;
        private static volatile zzlz<zzc> zzd;
        private int zze;
        private int zzf;
        private int zzg;

        /* loaded from: classes.dex */
        public static final class zza extends zzkg.zza<zzc, zza> implements zzlo {
            private zza() {
                super(zzc.zzc);
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzc = zzcVar;
            zzkg.zza((Class<zzc>) zzc.class, zzcVar);
        }

        private zzc() {
        }

        public final zze zzb() {
            zze zza2 = zze.zza(this.zzg);
            return zza2 == null ? zze.CONSENT_TYPE_UNSPECIFIED : zza2;
        }

        public final zze zzc() {
            zze zza2 = zze.zza(this.zzf);
            return zza2 == null ? zze.CONSENT_TYPE_UNSPECIFIED : zza2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzkg
        public final Object zza(int i5, Object obj, Object obj2) {
            switch (zzgb.zza[i5 - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza();
                case 3:
                    return zzkg.zza(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zze", "zzf", zze.zzb(), "zzg", zze.zzb()});
                case 4:
                    return zzc;
                case 5:
                    zzlz<zzc> zzlzVar = zzd;
                    if (zzlzVar == null) {
                        synchronized (zzc.class) {
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

    /* loaded from: classes.dex */
    public enum zzd implements zzki {
        CONSENT_STATUS_UNSPECIFIED(0),
        GRANTED(1),
        DENIED(2);

        private final int zze;

        zzd(int i5) {
            this.zze = i5;
        }

        public static zzkl zzb() {
            return zzgd.zza;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + zzd.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
        }

        @Override // com.google.android.gms.internal.measurement.zzki
        public final int zza() {
            return this.zze;
        }

        public static zzd zza(int i5) {
            if (i5 == 0) {
                return CONSENT_STATUS_UNSPECIFIED;
            }
            if (i5 == 1) {
                return GRANTED;
            }
            if (i5 != 2) {
                return null;
            }
            return DENIED;
        }
    }

    /* loaded from: classes.dex */
    public enum zze implements zzki {
        CONSENT_TYPE_UNSPECIFIED(0),
        AD_STORAGE(1),
        ANALYTICS_STORAGE(2),
        AD_USER_DATA(3),
        AD_PERSONALIZATION(4);

        private final int zzg;

        zze(int i5) {
            this.zzg = i5;
        }

        public static zzkl zzb() {
            return zzge.zza;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + zze.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
        }

        @Override // com.google.android.gms.internal.measurement.zzki
        public final int zza() {
            return this.zzg;
        }

        public static zze zza(int i5) {
            if (i5 == 0) {
                return CONSENT_TYPE_UNSPECIFIED;
            }
            if (i5 == 1) {
                return AD_STORAGE;
            }
            if (i5 == 2) {
                return ANALYTICS_STORAGE;
            }
            if (i5 == 3) {
                return AD_USER_DATA;
            }
            if (i5 != 4) {
                return null;
            }
            return AD_PERSONALIZATION;
        }
    }

    /* loaded from: classes.dex */
    public static final class zzf extends zzkg<zzf, zza> implements zzlo {
        private static final zzf zzc;
        private static volatile zzlz<zzf> zzd;
        private int zze;
        private String zzf = BuildConfig.FLAVOR;
        private String zzg = BuildConfig.FLAVOR;

        /* loaded from: classes.dex */
        public static final class zza extends zzkg.zza<zzf, zza> implements zzlo {
            private zza() {
                super(zzf.zzc);
            }
        }

        static {
            zzf zzfVar = new zzf();
            zzc = zzfVar;
            zzkg.zza((Class<zzf>) zzf.class, zzfVar);
        }

        private zzf() {
        }

        public final String zzb() {
            return this.zzf;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzkg
        public final Object zza(int i5, Object obj, Object obj2) {
            switch (zzgb.zza[i5 - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza();
                case 3:
                    return zzkg.zza(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
                case 4:
                    return zzc;
                case 5:
                    zzlz<zzf> zzlzVar = zzd;
                    if (zzlzVar == null) {
                        synchronized (zzf.class) {
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

    static {
        zzgc$zza zzgc_zza = new zzgc$zza();
        zzc = zzgc_zza;
        zzkg.zza((Class<zzgc$zza>) zzgc$zza.class, zzgc_zza);
    }

    private zzgc$zza() {
    }

    public static zzgc$zza zzb() {
        return zzc;
    }

    public final List<zzf> zzc() {
        return this.zzh;
    }

    public final List<zzb> zzd() {
        return this.zzf;
    }

    public final List<zzc> zze() {
        return this.zzg;
    }

    public final List<zzb> zzf() {
        return this.zzj;
    }

    public final boolean zzg() {
        return this.zzi;
    }

    public final boolean zzh() {
        return (this.zze & 1) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzgb.zza[i5 - 1]) {
            case 1:
                return new zzgc$zza();
            case 2:
                return new zza();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0004\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004ဇ\u0000\u0005\u001b", new Object[]{"zze", "zzf", zzb.class, "zzg", zzc.class, "zzh", zzf.class, "zzi", "zzj", zzb.class});
            case 4:
                return zzc;
            case 5:
                zzlz<zzgc$zza> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzgc$zza.class) {
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
