package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import java.util.List;

/* loaded from: classes.dex */
public final class zzgf$zzm extends zzkg<zzgf$zzm, zza> implements zzlo {
    private static final zzgf$zzm zzc;
    private static volatile zzlz<zzgf$zzm> zzd;
    private zzkn zze = zzkg.zzck();
    private zzkn zzf = zzkg.zzck();
    private zzkm<zzgf$zze> zzg = zzkg.zzcl();
    private zzkm<zzgf$zzn> zzh = zzkg.zzcl();

    /* loaded from: classes.dex */
    public static final class zza extends zzkg.zza<zzgf$zzm, zza> implements zzlo {
        public final zza zza(Iterable<? extends zzgf$zze> iterable) {
            zzam();
            zzgf$zzm.zza((zzgf$zzm) this.zza, iterable);
            return this;
        }

        public final zza zzb(Iterable<? extends Long> iterable) {
            zzam();
            zzgf$zzm.zzb((zzgf$zzm) this.zza, iterable);
            return this;
        }

        public final zza zzc(Iterable<? extends zzgf$zzn> iterable) {
            zzam();
            zzgf$zzm.zzc((zzgf$zzm) this.zza, iterable);
            return this;
        }

        public final zza zzd(Iterable<? extends Long> iterable) {
            zzam();
            zzgf$zzm.zzd((zzgf$zzm) this.zza, iterable);
            return this;
        }

        private zza() {
            super(zzgf$zzm.zzc);
        }

        public final zza zza() {
            zzam();
            zzgf$zzm.zza((zzgf$zzm) this.zza);
            return this;
        }

        public final zza zzb() {
            zzam();
            zzgf$zzm.zzb((zzgf$zzm) this.zza);
            return this;
        }

        public final zza zzc() {
            zzam();
            zzgf$zzm.zzc((zzgf$zzm) this.zza);
            return this;
        }

        public final zza zzd() {
            zzam();
            zzgf$zzm.zzd((zzgf$zzm) this.zza);
            return this;
        }
    }

    static {
        zzgf$zzm zzgf_zzm = new zzgf$zzm();
        zzc = zzgf_zzm;
        zzkg.zza((Class<zzgf$zzm>) zzgf$zzm.class, zzgf_zzm);
    }

    private zzgf$zzm() {
    }

    public static zza zze() {
        return zzc.zzcg();
    }

    public static zzgf$zzm zzg() {
        return zzc;
    }

    public final int zza() {
        return this.zzg.size();
    }

    public final int zzb() {
        return this.zzf.size();
    }

    public final int zzc() {
        return this.zzh.size();
    }

    public final int zzd() {
        return this.zze.size();
    }

    public final List<zzgf$zze> zzh() {
        return this.zzg;
    }

    public final List<Long> zzi() {
        return this.zzf;
    }

    public final List<zzgf$zzn> zzj() {
        return this.zzh;
    }

    public final List<Long> zzk() {
        return this.zze;
    }

    static /* synthetic */ void zzb(zzgf$zzm zzgf_zzm, Iterable iterable) {
        zzkn zzknVar = zzgf_zzm.zzf;
        if (!zzknVar.zzc()) {
            zzgf_zzm.zzf = zzkg.zza(zzknVar);
        }
        zzio.zza(iterable, zzgf_zzm.zzf);
    }

    static /* synthetic */ void zzc(zzgf$zzm zzgf_zzm, Iterable iterable) {
        zzkm<zzgf$zzn> zzkmVar = zzgf_zzm.zzh;
        if (!zzkmVar.zzc()) {
            zzgf_zzm.zzh = zzkg.zza(zzkmVar);
        }
        zzio.zza(iterable, zzgf_zzm.zzh);
    }

    static /* synthetic */ void zzd(zzgf$zzm zzgf_zzm, Iterable iterable) {
        zzkn zzknVar = zzgf_zzm.zze;
        if (!zzknVar.zzc()) {
            zzgf_zzm.zze = zzkg.zza(zzknVar);
        }
        zzio.zza(iterable, zzgf_zzm.zze);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzgi.zza[i5 - 1]) {
            case 1:
                return new zzgf$zzm();
            case 2:
                return new zza();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zze", "zzf", "zzg", zzgf$zze.class, "zzh", zzgf$zzn.class});
            case 4:
                return zzc;
            case 5:
                zzlz<zzgf$zzm> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzgf$zzm.class) {
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

    static /* synthetic */ void zzb(zzgf$zzm zzgf_zzm) {
        zzgf_zzm.zzf = zzkg.zzck();
    }

    static /* synthetic */ void zzc(zzgf$zzm zzgf_zzm) {
        zzgf_zzm.zzh = zzkg.zzcl();
    }

    static /* synthetic */ void zzd(zzgf$zzm zzgf_zzm) {
        zzgf_zzm.zze = zzkg.zzck();
    }

    static /* synthetic */ void zza(zzgf$zzm zzgf_zzm, Iterable iterable) {
        zzkm<zzgf$zze> zzkmVar = zzgf_zzm.zzg;
        if (!zzkmVar.zzc()) {
            zzgf_zzm.zzg = zzkg.zza(zzkmVar);
        }
        zzio.zza(iterable, zzgf_zzm.zzg);
    }

    static /* synthetic */ void zza(zzgf$zzm zzgf_zzm) {
        zzgf_zzm.zzg = zzkg.zzcl();
    }
}
