package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzgf$zza extends zzkg<zzgf$zza, zza> implements zzlo {
    private static final zzgf$zza zzc;
    private static volatile zzlz<zzgf$zza> zzd;
    private int zze;
    private long zzi;
    private long zzm;
    private String zzf = BuildConfig.FLAVOR;
    private String zzg = BuildConfig.FLAVOR;
    private String zzh = BuildConfig.FLAVOR;
    private String zzj = BuildConfig.FLAVOR;
    private String zzk = BuildConfig.FLAVOR;
    private String zzl = BuildConfig.FLAVOR;

    /* loaded from: classes.dex */
    public static final class zza extends zzkg.zza<zzgf$zza, zza> implements zzlo {
        public final long zza() {
            return ((zzgf$zza) this.zza).zza();
        }

        public final long zzb() {
            return ((zzgf$zza) this.zza).zzb();
        }

        public final zza zzc() {
            zzam();
            zzgf$zza.zza((zzgf$zza) this.zza);
            return this;
        }

        public final zza zzd() {
            zzam();
            zzgf$zza.zzb((zzgf$zza) this.zza);
            return this;
        }

        public final zza zze() {
            zzam();
            zzgf$zza.zzc((zzgf$zza) this.zza);
            return this;
        }

        public final zza zzf() {
            zzam();
            zzgf$zza.zzd((zzgf$zza) this.zza);
            return this;
        }

        public final zza zzg() {
            zzam();
            zzgf$zza.zze((zzgf$zza) this.zza);
            return this;
        }

        public final zza zzh() {
            zzam();
            zzgf$zza.zzf((zzgf$zza) this.zza);
            return this;
        }

        private zza() {
            super(zzgf$zza.zzc);
        }

        public final zza zza(String str) {
            zzam();
            zzgf$zza.zza((zzgf$zza) this.zza, str);
            return this;
        }

        public final zza zzb(String str) {
            zzam();
            zzgf$zza.zzb((zzgf$zza) this.zza, str);
            return this;
        }

        public final zza zzc(String str) {
            zzam();
            zzgf$zza.zzc((zzgf$zza) this.zza, str);
            return this;
        }

        public final zza zzd(String str) {
            zzam();
            zzgf$zza.zzd((zzgf$zza) this.zza, str);
            return this;
        }

        public final zza zze(String str) {
            zzam();
            zzgf$zza.zze((zzgf$zza) this.zza, str);
            return this;
        }

        public final zza zzf(String str) {
            zzam();
            zzgf$zza.zzf((zzgf$zza) this.zza, str);
            return this;
        }

        public final zza zza(long j5) {
            zzam();
            zzgf$zza.zza((zzgf$zza) this.zza, j5);
            return this;
        }

        public final zza zzb(long j5) {
            zzam();
            zzgf$zza.zzb((zzgf$zza) this.zza, j5);
            return this;
        }
    }

    static {
        zzgf$zza zzgf_zza = new zzgf$zza();
        zzc = zzgf_zza;
        zzkg.zza((Class<zzgf$zza>) zzgf$zza.class, zzgf_zza);
    }

    private zzgf$zza() {
    }

    public static zza zzc() {
        return zzc.zzcg();
    }

    public static zzgf$zza zze() {
        return zzc;
    }

    public final long zza() {
        return this.zzi;
    }

    public final long zzb() {
        return this.zzm;
    }

    public final String zzf() {
        return this.zzh;
    }

    public final String zzg() {
        return this.zzg;
    }

    public final String zzh() {
        return this.zzf;
    }

    public final String zzi() {
        return this.zzl;
    }

    public final String zzj() {
        return this.zzk;
    }

    public final String zzk() {
        return this.zzj;
    }

    public final boolean zzl() {
        return (this.zze & 4) != 0;
    }

    public final boolean zzm() {
        return (this.zze & 2) != 0;
    }

    public final boolean zzn() {
        return (this.zze & 1) != 0;
    }

    public final boolean zzo() {
        return (this.zze & 8) != 0;
    }

    public final boolean zzp() {
        return (this.zze & 128) != 0;
    }

    public final boolean zzq() {
        return (this.zze & 64) != 0;
    }

    public final boolean zzr() {
        return (this.zze & 32) != 0;
    }

    public final boolean zzs() {
        return (this.zze & 16) != 0;
    }

    static /* synthetic */ void zzb(zzgf$zza zzgf_zza) {
        zzgf_zza.zze &= -3;
        zzgf_zza.zzg = zzc.zzg;
    }

    static /* synthetic */ void zzc(zzgf$zza zzgf_zza) {
        zzgf_zza.zze &= -2;
        zzgf_zza.zzf = zzc.zzf;
    }

    static /* synthetic */ void zzd(zzgf$zza zzgf_zza) {
        zzgf_zza.zze &= -65;
        zzgf_zza.zzl = zzc.zzl;
    }

    static /* synthetic */ void zze(zzgf$zza zzgf_zza) {
        zzgf_zza.zze &= -33;
        zzgf_zza.zzk = zzc.zzk;
    }

    static /* synthetic */ void zzf(zzgf$zza zzgf_zza) {
        zzgf_zza.zze &= -17;
        zzgf_zza.zzj = zzc.zzj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzgi.zza[i5 - 1]) {
            case 1:
                return new zzgf$zza();
            case 2:
                return new zza();
            case 3:
                return zzkg.zza(zzc, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\bဂ\u0007", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
            case 4:
                return zzc;
            case 5:
                zzlz<zzgf$zza> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzgf$zza.class) {
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

    static /* synthetic */ void zzb(zzgf$zza zzgf_zza, String str) {
        str.getClass();
        zzgf_zza.zze |= 2;
        zzgf_zza.zzg = str;
    }

    static /* synthetic */ void zzc(zzgf$zza zzgf_zza, String str) {
        str.getClass();
        zzgf_zza.zze |= 1;
        zzgf_zza.zzf = str;
    }

    static /* synthetic */ void zzd(zzgf$zza zzgf_zza, String str) {
        str.getClass();
        zzgf_zza.zze |= 64;
        zzgf_zza.zzl = str;
    }

    static /* synthetic */ void zze(zzgf$zza zzgf_zza, String str) {
        str.getClass();
        zzgf_zza.zze |= 32;
        zzgf_zza.zzk = str;
    }

    static /* synthetic */ void zzf(zzgf$zza zzgf_zza, String str) {
        str.getClass();
        zzgf_zza.zze |= 16;
        zzgf_zza.zzj = str;
    }

    static /* synthetic */ void zzb(zzgf$zza zzgf_zza, long j5) {
        zzgf_zza.zze |= 128;
        zzgf_zza.zzm = j5;
    }

    static /* synthetic */ void zza(zzgf$zza zzgf_zza) {
        zzgf_zza.zze &= -5;
        zzgf_zza.zzh = zzc.zzh;
    }

    static /* synthetic */ void zza(zzgf$zza zzgf_zza, String str) {
        str.getClass();
        zzgf_zza.zze |= 4;
        zzgf_zza.zzh = str;
    }

    static /* synthetic */ void zza(zzgf$zza zzgf_zza, long j5) {
        zzgf_zza.zze |= 8;
        zzgf_zza.zzi = j5;
    }
}
