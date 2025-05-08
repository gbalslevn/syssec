package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgf$zzm;
import com.google.android.gms.internal.measurement.zzkg;

/* loaded from: classes.dex */
public final class zzgf$zzd extends zzkg<zzgf$zzd, zza> implements zzlo {
    private static final zzgf$zzd zzc;
    private static volatile zzlz<zzgf$zzd> zzd;
    private int zze;
    private int zzf;
    private zzgf$zzm zzg;
    private zzgf$zzm zzh;
    private boolean zzi;

    /* loaded from: classes.dex */
    public static final class zza extends zzkg.zza<zzgf$zzd, zza> implements zzlo {
        public final zza zza(int i5) {
            zzam();
            zzgf$zzd.zza((zzgf$zzd) this.zza, i5);
            return this;
        }

        private zza() {
            super(zzgf$zzd.zzc);
        }

        public final zza zza(zzgf$zzm.zza zzaVar) {
            zzam();
            zzgf$zzd.zza((zzgf$zzd) this.zza, (zzgf$zzm) ((zzkg) zzaVar.zzaj()));
            return this;
        }

        public final zza zza(boolean z5) {
            zzam();
            zzgf$zzd.zza((zzgf$zzd) this.zza, z5);
            return this;
        }

        public final zza zza(zzgf$zzm zzgf_zzm) {
            zzam();
            zzgf$zzd.zzb((zzgf$zzd) this.zza, zzgf_zzm);
            return this;
        }
    }

    static {
        zzgf$zzd zzgf_zzd = new zzgf$zzd();
        zzc = zzgf_zzd;
        zzkg.zza((Class<zzgf$zzd>) zzgf$zzd.class, zzgf_zzd);
    }

    private zzgf$zzd() {
    }

    public static zza zzb() {
        return zzc.zzcg();
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzgf$zzm zzd() {
        zzgf$zzm zzgf_zzm = this.zzg;
        return zzgf_zzm == null ? zzgf$zzm.zzg() : zzgf_zzm;
    }

    public final zzgf$zzm zze() {
        zzgf$zzm zzgf_zzm = this.zzh;
        return zzgf_zzm == null ? zzgf$zzm.zzg() : zzgf_zzm;
    }

    public final boolean zzf() {
        return this.zzi;
    }

    public final boolean zzg() {
        return (this.zze & 1) != 0;
    }

    public final boolean zzh() {
        return (this.zze & 8) != 0;
    }

    public final boolean zzi() {
        return (this.zze & 4) != 0;
    }

    static /* synthetic */ void zzb(zzgf$zzd zzgf_zzd, zzgf$zzm zzgf_zzm) {
        zzgf_zzm.getClass();
        zzgf_zzd.zzh = zzgf_zzm;
        zzgf_zzd.zze |= 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzgi.zza[i5 - 1]) {
            case 1:
                return new zzgf$zzd();
            case 2:
                return new zza();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzc;
            case 5:
                zzlz<zzgf$zzd> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzgf$zzd.class) {
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

    static /* synthetic */ void zza(zzgf$zzd zzgf_zzd, int i5) {
        zzgf_zzd.zze |= 1;
        zzgf_zzd.zzf = i5;
    }

    static /* synthetic */ void zza(zzgf$zzd zzgf_zzd, zzgf$zzm zzgf_zzm) {
        zzgf_zzm.getClass();
        zzgf_zzd.zzg = zzgf_zzm;
        zzgf_zzd.zze |= 2;
    }

    static /* synthetic */ void zza(zzgf$zzd zzgf_zzd, boolean z5) {
        zzgf_zzd.zze |= 8;
        zzgf_zzd.zzi = z5;
    }
}
