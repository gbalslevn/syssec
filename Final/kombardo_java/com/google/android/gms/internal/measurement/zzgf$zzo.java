package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;

/* loaded from: classes.dex */
public final class zzgf$zzo extends zzkg<zzgf$zzo, zzb> implements zzlo {
    private static final zzgf$zzo zzc;
    private static volatile zzlz<zzgf$zzo> zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;

    /* loaded from: classes.dex */
    public enum zza implements zzki {
        CLIENT_UPLOAD_ELIGIBILITY_UNKNOWN(0),
        CLIENT_UPLOAD_ELIGIBLE(1),
        MEASUREMENT_SERVICE_NOT_ENABLED(2),
        ANDROID_TOO_OLD(3),
        NON_PLAY_MODE(4),
        SDK_TOO_OLD(5),
        MISSING_JOB_SCHEDULER(6),
        NOT_ENABLED_IN_MANIFEST(7),
        CLIENT_FLAG_OFF(8),
        SERVICE_FLAG_OFF(20),
        PINNED_TO_SERVICE_UPLOAD(21),
        MISSING_SGTM_SERVER_URL(22);

        private final int zzn;

        zza(int i5) {
            this.zzn = i5;
        }

        public static zzkl zzb() {
            return zzgm.zza;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzn + " name=" + name() + '>';
        }

        @Override // com.google.android.gms.internal.measurement.zzki
        public final int zza() {
            return this.zzn;
        }

        public static zza zza(int i5) {
            switch (i5) {
                case 0:
                    return CLIENT_UPLOAD_ELIGIBILITY_UNKNOWN;
                case 1:
                    return CLIENT_UPLOAD_ELIGIBLE;
                case 2:
                    return MEASUREMENT_SERVICE_NOT_ENABLED;
                case 3:
                    return ANDROID_TOO_OLD;
                case 4:
                    return NON_PLAY_MODE;
                case 5:
                    return SDK_TOO_OLD;
                case 6:
                    return MISSING_JOB_SCHEDULER;
                case 7:
                    return NOT_ENABLED_IN_MANIFEST;
                case 8:
                    return CLIENT_FLAG_OFF;
                default:
                    switch (i5) {
                        case 20:
                            return SERVICE_FLAG_OFF;
                        case 21:
                            return PINNED_TO_SERVICE_UPLOAD;
                        case 22:
                            return MISSING_SGTM_SERVER_URL;
                        default:
                            return null;
                    }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class zzb extends zzkg.zza<zzgf$zzo, zzb> implements zzlo {
        public final zzb zza(zza zzaVar) {
            zzam();
            zzgf$zzo.zza((zzgf$zzo) this.zza, zzaVar);
            return this;
        }

        private zzb() {
            super(zzgf$zzo.zzc);
        }

        public final zzb zza(zzc zzcVar) {
            zzam();
            zzgf$zzo.zza((zzgf$zzo) this.zza, zzcVar);
            return this;
        }

        public final zzb zza(zzd zzdVar) {
            zzam();
            zzgf$zzo.zza((zzgf$zzo) this.zza, zzdVar);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public enum zzc implements zzki {
        SERVICE_UPLOAD_ELIGIBILITY_UNKNOWN(0),
        SERVICE_UPLOAD_ELIGIBLE(1),
        NOT_IN_ROLLOUT(2),
        MISSING_SGTM_SETTINGS(3),
        MISSING_SGTM_PROXY_INFO(4),
        NON_PLAY_MISSING_SGTM_SERVER_URL(5);

        private final int zzh;

        zzc(int i5) {
            this.zzh = i5;
        }

        public static zzkl zzb() {
            return zzgn.zza;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + '>';
        }

        @Override // com.google.android.gms.internal.measurement.zzki
        public final int zza() {
            return this.zzh;
        }

        public static zzc zza(int i5) {
            if (i5 == 0) {
                return SERVICE_UPLOAD_ELIGIBILITY_UNKNOWN;
            }
            if (i5 == 1) {
                return SERVICE_UPLOAD_ELIGIBLE;
            }
            if (i5 == 2) {
                return NOT_IN_ROLLOUT;
            }
            if (i5 == 3) {
                return MISSING_SGTM_SETTINGS;
            }
            if (i5 == 4) {
                return MISSING_SGTM_PROXY_INFO;
            }
            if (i5 != 5) {
                return null;
            }
            return NON_PLAY_MISSING_SGTM_SERVER_URL;
        }
    }

    /* loaded from: classes.dex */
    public enum zzd implements zzki {
        UPLOAD_TYPE_UNKNOWN(0),
        GA_UPLOAD(1),
        SDK_CLIENT_UPLOAD(2),
        PACKAGE_SERVICE_UPLOAD(3),
        SDK_SERVICE_UPLOAD(4);

        private final int zzg;

        zzd(int i5) {
            this.zzg = i5;
        }

        public static zzkl zzb() {
            return zzgo.zza;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + zzd.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
        }

        @Override // com.google.android.gms.internal.measurement.zzki
        public final int zza() {
            return this.zzg;
        }

        public static zzd zza(int i5) {
            if (i5 == 0) {
                return UPLOAD_TYPE_UNKNOWN;
            }
            if (i5 == 1) {
                return GA_UPLOAD;
            }
            if (i5 == 2) {
                return SDK_CLIENT_UPLOAD;
            }
            if (i5 == 3) {
                return PACKAGE_SERVICE_UPLOAD;
            }
            if (i5 != 4) {
                return null;
            }
            return SDK_SERVICE_UPLOAD;
        }
    }

    static {
        zzgf$zzo zzgf_zzo = new zzgf$zzo();
        zzc = zzgf_zzo;
        zzkg.zza((Class<zzgf$zzo>) zzgf$zzo.class, zzgf_zzo);
    }

    private zzgf$zzo() {
    }

    public static zzb zza() {
        return zzc.zzcg();
    }

    public static zzgf$zzo zzf() {
        return zzc;
    }

    public final zza zzb() {
        zza zza2 = zza.zza(this.zzg);
        return zza2 == null ? zza.CLIENT_UPLOAD_ELIGIBILITY_UNKNOWN : zza2;
    }

    public final zzc zzc() {
        zzc zza2 = zzc.zza(this.zzh);
        return zza2 == null ? zzc.SERVICE_UPLOAD_ELIGIBILITY_UNKNOWN : zza2;
    }

    public final zzd zzd() {
        zzd zza2 = zzd.zza(this.zzf);
        return zza2 == null ? zzd.UPLOAD_TYPE_UNKNOWN : zza2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzgi.zza[i5 - 1]) {
            case 1:
                return new zzgf$zzo();
            case 2:
                return new zzb();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zze", "zzf", zzd.zzb(), "zzg", zza.zzb(), "zzh", zzc.zzb()});
            case 4:
                return zzc;
            case 5:
                zzlz<zzgf$zzo> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzgf$zzo.class) {
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

    static /* synthetic */ void zza(zzgf$zzo zzgf_zzo, zza zzaVar) {
        zzgf_zzo.zzg = zzaVar.zza();
        zzgf_zzo.zze |= 2;
    }

    static /* synthetic */ void zza(zzgf$zzo zzgf_zzo, zzc zzcVar) {
        zzgf_zzo.zzh = zzcVar.zza();
        zzgf_zzo.zze |= 4;
    }

    static /* synthetic */ void zza(zzgf$zzo zzgf_zzo, zzd zzdVar) {
        zzgf_zzo.zzf = zzdVar.zza();
        zzgf_zzo.zze |= 1;
    }
}
