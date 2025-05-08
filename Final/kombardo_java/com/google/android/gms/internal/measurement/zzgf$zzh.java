package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import java.util.List;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzgf$zzh extends zzkg<zzgf$zzh, zza> implements zzlo {
    private static final zzgf$zzh zzc;
    private static volatile zzlz<zzgf$zzh> zzd;
    private int zze;
    private long zzh;
    private float zzi;
    private double zzj;
    private String zzf = BuildConfig.FLAVOR;
    private String zzg = BuildConfig.FLAVOR;
    private zzkm<zzgf$zzh> zzk = zzkg.zzcl();

    /* loaded from: classes.dex */
    public static final class zza extends zzkg.zza<zzgf$zzh, zza> implements zzlo {
        public final int zza() {
            return ((zzgf$zzh) this.zza).zzc();
        }

        public final zza zzb() {
            zzam();
            zzgf$zzh.zza((zzgf$zzh) this.zza);
            return this;
        }

        public final zza zzc() {
            zzam();
            zzgf$zzh.zzb((zzgf$zzh) this.zza);
            return this;
        }

        public final zza zzd() {
            zzam();
            zzgf$zzh.zzc((zzgf$zzh) this.zza);
            return this;
        }

        public final zza zze() {
            zzam();
            zzgf$zzh.zzd((zzgf$zzh) this.zza);
            return this;
        }

        public final String zzf() {
            return ((zzgf$zzh) this.zza).zzg();
        }

        public final String zzg() {
            return ((zzgf$zzh) this.zza).zzh();
        }

        private zza() {
            super(zzgf$zzh.zzc);
        }

        public final zza zza(Iterable<? extends zzgf$zzh> iterable) {
            zzam();
            zzgf$zzh.zza((zzgf$zzh) this.zza, iterable);
            return this;
        }

        public final zza zzb(String str) {
            zzam();
            zzgf$zzh.zzb((zzgf$zzh) this.zza, str);
            return this;
        }

        public final zza zza(zza zzaVar) {
            zzam();
            zzgf$zzh.zza((zzgf$zzh) this.zza, (zzgf$zzh) ((zzkg) zzaVar.zzaj()));
            return this;
        }

        public final zza zza(double d5) {
            zzam();
            zzgf$zzh.zza((zzgf$zzh) this.zza, d5);
            return this;
        }

        public final zza zza(long j5) {
            zzam();
            zzgf$zzh.zza((zzgf$zzh) this.zza, j5);
            return this;
        }

        public final zza zza(String str) {
            zzam();
            zzgf$zzh.zza((zzgf$zzh) this.zza, str);
            return this;
        }
    }

    static {
        zzgf$zzh zzgf_zzh = new zzgf$zzh();
        zzc = zzgf_zzh;
        zzkg.zza((Class<zzgf$zzh>) zzgf$zzh.class, zzgf_zzh);
    }

    private zzgf$zzh() {
    }

    public static zza zze() {
        return zzc.zzcg();
    }

    private final void zzo() {
        zzkm<zzgf$zzh> zzkmVar = this.zzk;
        if (zzkmVar.zzc()) {
            return;
        }
        this.zzk = zzkg.zza(zzkmVar);
    }

    public final double zza() {
        return this.zzj;
    }

    public final float zzb() {
        return this.zzi;
    }

    public final int zzc() {
        return this.zzk.size();
    }

    public final long zzd() {
        return this.zzh;
    }

    public final String zzg() {
        return this.zzf;
    }

    public final String zzh() {
        return this.zzg;
    }

    public final List<zzgf$zzh> zzi() {
        return this.zzk;
    }

    public final boolean zzj() {
        return (this.zze & 16) != 0;
    }

    public final boolean zzk() {
        return (this.zze & 8) != 0;
    }

    public final boolean zzl() {
        return (this.zze & 4) != 0;
    }

    public final boolean zzm() {
        return (this.zze & 1) != 0;
    }

    public final boolean zzn() {
        return (this.zze & 2) != 0;
    }

    static /* synthetic */ void zzb(zzgf$zzh zzgf_zzh) {
        zzgf_zzh.zze &= -5;
        zzgf_zzh.zzh = 0L;
    }

    static /* synthetic */ void zzc(zzgf$zzh zzgf_zzh) {
        zzgf_zzh.zzk = zzkg.zzcl();
    }

    static /* synthetic */ void zzd(zzgf$zzh zzgf_zzh) {
        zzgf_zzh.zze &= -3;
        zzgf_zzh.zzg = zzc.zzg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzgi.zza[i5 - 1]) {
            case 1:
                return new zzgf$zzh();
            case 2:
                return new zza();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzgf$zzh.class});
            case 4:
                return zzc;
            case 5:
                zzlz<zzgf$zzh> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzgf$zzh.class) {
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

    static /* synthetic */ void zzb(zzgf$zzh zzgf_zzh, String str) {
        str.getClass();
        zzgf_zzh.zze |= 2;
        zzgf_zzh.zzg = str;
    }

    static /* synthetic */ void zza(zzgf$zzh zzgf_zzh, Iterable iterable) {
        zzgf_zzh.zzo();
        zzio.zza(iterable, zzgf_zzh.zzk);
    }

    static /* synthetic */ void zza(zzgf$zzh zzgf_zzh, zzgf$zzh zzgf_zzh2) {
        zzgf_zzh2.getClass();
        zzgf_zzh.zzo();
        zzgf_zzh.zzk.add(zzgf_zzh2);
    }

    static /* synthetic */ void zza(zzgf$zzh zzgf_zzh) {
        zzgf_zzh.zze &= -17;
        zzgf_zzh.zzj = 0.0d;
    }

    static /* synthetic */ void zza(zzgf$zzh zzgf_zzh, double d5) {
        zzgf_zzh.zze |= 16;
        zzgf_zzh.zzj = d5;
    }

    static /* synthetic */ void zza(zzgf$zzh zzgf_zzh, long j5) {
        zzgf_zzh.zze |= 4;
        zzgf_zzh.zzh = j5;
    }

    static /* synthetic */ void zza(zzgf$zzh zzgf_zzh, String str) {
        str.getClass();
        zzgf_zzh.zze |= 1;
        zzgf_zzh.zzf = str;
    }
}
