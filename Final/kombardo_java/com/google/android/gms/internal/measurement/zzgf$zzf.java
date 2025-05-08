package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgf$zzh;
import com.google.android.gms.internal.measurement.zzkg;
import java.util.Collections;
import java.util.List;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzgf$zzf extends zzkg<zzgf$zzf, zza> implements zzlo {
    private static final zzgf$zzf zzc;
    private static volatile zzlz<zzgf$zzf> zzd;
    private int zze;
    private zzkm<zzgf$zzh> zzf = zzkg.zzcl();
    private String zzg = BuildConfig.FLAVOR;
    private long zzh;
    private long zzi;
    private int zzj;

    /* loaded from: classes.dex */
    public static final class zza extends zzkg.zza<zzgf$zzf, zza> implements zzlo {
        public final int zza() {
            return ((zzgf$zzf) this.zza).zzb();
        }

        public final long zzb() {
            return ((zzgf$zzf) this.zza).zzc();
        }

        public final long zzc() {
            return ((zzgf$zzf) this.zza).zzd();
        }

        public final zza zzd() {
            zzam();
            zzgf$zzf.zza((zzgf$zzf) this.zza);
            return this;
        }

        public final String zze() {
            return ((zzgf$zzf) this.zza).zzg();
        }

        public final List<zzgf$zzh> zzf() {
            return Collections.unmodifiableList(((zzgf$zzf) this.zza).zzh());
        }

        public final boolean zzg() {
            return ((zzgf$zzf) this.zza).zzk();
        }

        private zza() {
            super(zzgf$zzf.zzc);
        }

        public final zza zza(Iterable<? extends zzgf$zzh> iterable) {
            zzam();
            zzgf$zzf.zza((zzgf$zzf) this.zza, iterable);
            return this;
        }

        public final zza zzb(long j5) {
            zzam();
            zzgf$zzf.zzb((zzgf$zzf) this.zza, j5);
            return this;
        }

        public final zza zza(zzgf$zzh.zza zzaVar) {
            zzam();
            zzgf$zzf.zza((zzgf$zzf) this.zza, (zzgf$zzh) ((zzkg) zzaVar.zzaj()));
            return this;
        }

        public final zzgf$zzh zzb(int i5) {
            return ((zzgf$zzf) this.zza).zza(i5);
        }

        public final zza zza(zzgf$zzh zzgf_zzh) {
            zzam();
            zzgf$zzf.zza((zzgf$zzf) this.zza, zzgf_zzh);
            return this;
        }

        public final zza zza(int i5) {
            zzam();
            zzgf$zzf.zza((zzgf$zzf) this.zza, i5);
            return this;
        }

        public final zza zza(String str) {
            zzam();
            zzgf$zzf.zza((zzgf$zzf) this.zza, str);
            return this;
        }

        public final zza zza(int i5, zzgf$zzh.zza zzaVar) {
            zzam();
            zzgf$zzf.zza((zzgf$zzf) this.zza, i5, (zzgf$zzh) ((zzkg) zzaVar.zzaj()));
            return this;
        }

        public final zza zza(int i5, zzgf$zzh zzgf_zzh) {
            zzam();
            zzgf$zzf.zza((zzgf$zzf) this.zza, i5, zzgf_zzh);
            return this;
        }

        public final zza zza(long j5) {
            zzam();
            zzgf$zzf.zza((zzgf$zzf) this.zza, j5);
            return this;
        }
    }

    static {
        zzgf$zzf zzgf_zzf = new zzgf$zzf();
        zzc = zzgf_zzf;
        zzkg.zza((Class<zzgf$zzf>) zzgf$zzf.class, zzgf_zzf);
    }

    private zzgf$zzf() {
    }

    public static zza zze() {
        return zzc.zzcg();
    }

    private final void zzl() {
        zzkm<zzgf$zzh> zzkmVar = this.zzf;
        if (zzkmVar.zzc()) {
            return;
        }
        this.zzf = zzkg.zza(zzkmVar);
    }

    public final int zza() {
        return this.zzj;
    }

    public final int zzb() {
        return this.zzf.size();
    }

    public final long zzc() {
        return this.zzi;
    }

    public final long zzd() {
        return this.zzh;
    }

    public final String zzg() {
        return this.zzg;
    }

    public final List<zzgf$zzh> zzh() {
        return this.zzf;
    }

    public final boolean zzi() {
        return (this.zze & 8) != 0;
    }

    public final boolean zzj() {
        return (this.zze & 4) != 0;
    }

    public final boolean zzk() {
        return (this.zze & 2) != 0;
    }

    static /* synthetic */ void zzb(zzgf$zzf zzgf_zzf, long j5) {
        zzgf_zzf.zze |= 2;
        zzgf_zzf.zzh = j5;
    }

    public final zzgf$zzh zza(int i5) {
        return this.zzf.get(i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzgi.zza[i5 - 1]) {
            case 1:
                return new zzgf$zzf();
            case 2:
                return new zza();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zze", "zzf", zzgf$zzh.class, "zzg", "zzh", "zzi", "zzj"});
            case 4:
                return zzc;
            case 5:
                zzlz<zzgf$zzf> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzgf$zzf.class) {
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

    static /* synthetic */ void zza(zzgf$zzf zzgf_zzf, Iterable iterable) {
        zzgf_zzf.zzl();
        zzio.zza(iterable, zzgf_zzf.zzf);
    }

    static /* synthetic */ void zza(zzgf$zzf zzgf_zzf, zzgf$zzh zzgf_zzh) {
        zzgf_zzh.getClass();
        zzgf_zzf.zzl();
        zzgf_zzf.zzf.add(zzgf_zzh);
    }

    static /* synthetic */ void zza(zzgf$zzf zzgf_zzf) {
        zzgf_zzf.zzf = zzkg.zzcl();
    }

    static /* synthetic */ void zza(zzgf$zzf zzgf_zzf, int i5) {
        zzgf_zzf.zzl();
        zzgf_zzf.zzf.remove(i5);
    }

    static /* synthetic */ void zza(zzgf$zzf zzgf_zzf, String str) {
        str.getClass();
        zzgf_zzf.zze |= 1;
        zzgf_zzf.zzg = str;
    }

    static /* synthetic */ void zza(zzgf$zzf zzgf_zzf, int i5, zzgf$zzh zzgf_zzh) {
        zzgf_zzh.getClass();
        zzgf_zzf.zzl();
        zzgf_zzf.zzf.set(i5, zzgf_zzh);
    }

    static /* synthetic */ void zza(zzgf$zzf zzgf_zzf, long j5) {
        zzgf_zzf.zze |= 4;
        zzgf_zzf.zzi = j5;
    }
}
