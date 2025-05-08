package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzgf$zzp extends zzkg<zzgf$zzp, zza> implements zzlo {
    private static final zzgf$zzp zzc;
    private static volatile zzlz<zzgf$zzp> zzd;
    private int zze;
    private long zzf;
    private String zzg = BuildConfig.FLAVOR;
    private String zzh = BuildConfig.FLAVOR;
    private long zzi;
    private float zzj;
    private double zzk;

    /* loaded from: classes.dex */
    public static final class zza extends zzkg.zza<zzgf$zzp, zza> implements zzlo {
        public final zza zza() {
            zzam();
            zzgf$zzp.zza((zzgf$zzp) this.zza);
            return this;
        }

        public final zza zzb() {
            zzam();
            zzgf$zzp.zzb((zzgf$zzp) this.zza);
            return this;
        }

        public final zza zzc() {
            zzam();
            zzgf$zzp.zzc((zzgf$zzp) this.zza);
            return this;
        }

        private zza() {
            super(zzgf$zzp.zzc);
        }

        public final zza zza(double d5) {
            zzam();
            zzgf$zzp.zza((zzgf$zzp) this.zza, d5);
            return this;
        }

        public final zza zzb(long j5) {
            zzam();
            zzgf$zzp.zzb((zzgf$zzp) this.zza, j5);
            return this;
        }

        public final zza zza(long j5) {
            zzam();
            zzgf$zzp.zza((zzgf$zzp) this.zza, j5);
            return this;
        }

        public final zza zzb(String str) {
            zzam();
            zzgf$zzp.zzb((zzgf$zzp) this.zza, str);
            return this;
        }

        public final zza zza(String str) {
            zzam();
            zzgf$zzp.zza((zzgf$zzp) this.zza, str);
            return this;
        }
    }

    static {
        zzgf$zzp zzgf_zzp = new zzgf$zzp();
        zzc = zzgf_zzp;
        zzkg.zza((Class<zzgf$zzp>) zzgf$zzp.class, zzgf_zzp);
    }

    private zzgf$zzp() {
    }

    public static zza zze() {
        return zzc.zzcg();
    }

    public final double zza() {
        return this.zzk;
    }

    public final float zzb() {
        return this.zzj;
    }

    public final long zzc() {
        return this.zzi;
    }

    public final long zzd() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zzg;
    }

    public final String zzh() {
        return this.zzh;
    }

    public final boolean zzi() {
        return (this.zze & 32) != 0;
    }

    public final boolean zzj() {
        return (this.zze & 16) != 0;
    }

    public final boolean zzk() {
        return (this.zze & 8) != 0;
    }

    public final boolean zzl() {
        return (this.zze & 1) != 0;
    }

    public final boolean zzm() {
        return (this.zze & 4) != 0;
    }

    static /* synthetic */ void zzb(zzgf$zzp zzgf_zzp) {
        zzgf_zzp.zze &= -9;
        zzgf_zzp.zzi = 0L;
    }

    static /* synthetic */ void zzc(zzgf$zzp zzgf_zzp) {
        zzgf_zzp.zze &= -5;
        zzgf_zzp.zzh = zzc.zzh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzgi.zza[i5 - 1]) {
            case 1:
                return new zzgf$zzp();
            case 2:
                return new zza();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
            case 4:
                return zzc;
            case 5:
                zzlz<zzgf$zzp> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzgf$zzp.class) {
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

    static /* synthetic */ void zzb(zzgf$zzp zzgf_zzp, long j5) {
        zzgf_zzp.zze |= 1;
        zzgf_zzp.zzf = j5;
    }

    static /* synthetic */ void zzb(zzgf$zzp zzgf_zzp, String str) {
        str.getClass();
        zzgf_zzp.zze |= 4;
        zzgf_zzp.zzh = str;
    }

    static /* synthetic */ void zza(zzgf$zzp zzgf_zzp) {
        zzgf_zzp.zze &= -33;
        zzgf_zzp.zzk = 0.0d;
    }

    static /* synthetic */ void zza(zzgf$zzp zzgf_zzp, double d5) {
        zzgf_zzp.zze |= 32;
        zzgf_zzp.zzk = d5;
    }

    static /* synthetic */ void zza(zzgf$zzp zzgf_zzp, long j5) {
        zzgf_zzp.zze |= 8;
        zzgf_zzp.zzi = j5;
    }

    static /* synthetic */ void zza(zzgf$zzp zzgf_zzp, String str) {
        str.getClass();
        zzgf_zzp.zze |= 2;
        zzgf_zzp.zzg = str;
    }
}
