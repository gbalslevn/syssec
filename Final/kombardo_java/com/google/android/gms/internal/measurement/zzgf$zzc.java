package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;

/* loaded from: classes.dex */
public final class zzgf$zzc extends zzkg<zzgf$zzc, zza> implements zzlo {
    private static final zzgf$zzc zzc;
    private static volatile zzlz<zzgf$zzc> zzd;
    private int zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;

    /* loaded from: classes.dex */
    public static final class zza extends zzkg.zza<zzgf$zzc, zza> implements zzlo {
        public final zza zza(boolean z5) {
            zzam();
            zzgf$zzc.zza((zzgf$zzc) this.zza, z5);
            return this;
        }

        public final zza zzb(boolean z5) {
            zzam();
            zzgf$zzc.zzb((zzgf$zzc) this.zza, z5);
            return this;
        }

        public final zza zzc(boolean z5) {
            zzam();
            zzgf$zzc.zzc((zzgf$zzc) this.zza, z5);
            return this;
        }

        public final zza zzd(boolean z5) {
            zzam();
            zzgf$zzc.zzd((zzgf$zzc) this.zza, z5);
            return this;
        }

        public final zza zze(boolean z5) {
            zzam();
            zzgf$zzc.zze((zzgf$zzc) this.zza, z5);
            return this;
        }

        public final zza zzf(boolean z5) {
            zzam();
            zzgf$zzc.zzf((zzgf$zzc) this.zza, z5);
            return this;
        }

        public final zza zzg(boolean z5) {
            zzam();
            zzgf$zzc.zzg((zzgf$zzc) this.zza, z5);
            return this;
        }

        private zza() {
            super(zzgf$zzc.zzc);
        }
    }

    static {
        zzgf$zzc zzgf_zzc = new zzgf$zzc();
        zzc = zzgf_zzc;
        zzkg.zza((Class<zzgf$zzc>) zzgf$zzc.class, zzgf_zzc);
    }

    private zzgf$zzc() {
    }

    public static zza zza() {
        return zzc.zzcg();
    }

    public static zzgf$zzc zzc() {
        return zzc;
    }

    static /* synthetic */ void zzd(zzgf$zzc zzgf_zzc, boolean z5) {
        zzgf_zzc.zze |= 64;
        zzgf_zzc.zzl = z5;
    }

    static /* synthetic */ void zze(zzgf$zzc zzgf_zzc, boolean z5) {
        zzgf_zzc.zze |= 2;
        zzgf_zzc.zzg = z5;
    }

    static /* synthetic */ void zzf(zzgf$zzc zzgf_zzc, boolean z5) {
        zzgf_zzc.zze |= 4;
        zzgf_zzc.zzh = z5;
    }

    static /* synthetic */ void zzg(zzgf$zzc zzgf_zzc, boolean z5) {
        zzgf_zzc.zze |= 8;
        zzgf_zzc.zzi = z5;
    }

    public final boolean zzh() {
        return this.zzg;
    }

    public final boolean zzi() {
        return this.zzh;
    }

    public final boolean zzj() {
        return this.zzi;
    }

    static /* synthetic */ void zzb(zzgf$zzc zzgf_zzc, boolean z5) {
        zzgf_zzc.zze |= 16;
        zzgf_zzc.zzj = z5;
    }

    static /* synthetic */ void zzc(zzgf$zzc zzgf_zzc, boolean z5) {
        zzgf_zzc.zze |= 1;
        zzgf_zzc.zzf = z5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzgi.zza[i5 - 1]) {
            case 1:
                return new zzgf$zzc();
            case 2:
                return new zza();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဇ\u0006", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
            case 4:
                return zzc;
            case 5:
                zzlz<zzgf$zzc> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzgf$zzc.class) {
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

    public final boolean zzd() {
        return this.zzk;
    }

    public final boolean zze() {
        return this.zzj;
    }

    public final boolean zzf() {
        return this.zzf;
    }

    public final boolean zzg() {
        return this.zzl;
    }

    static /* synthetic */ void zza(zzgf$zzc zzgf_zzc, boolean z5) {
        zzgf_zzc.zze |= 32;
        zzgf_zzc.zzk = z5;
    }
}
