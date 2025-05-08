package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import java.util.List;

/* loaded from: classes.dex */
public final class zzgf$zzn extends zzkg<zzgf$zzn, zza> implements zzlo {
    private static final zzgf$zzn zzc;
    private static volatile zzlz<zzgf$zzn> zzd;
    private int zze;
    private int zzf;
    private zzkn zzg = zzkg.zzck();

    /* loaded from: classes.dex */
    public static final class zza extends zzkg.zza<zzgf$zzn, zza> implements zzlo {
        public final zza zza(Iterable<? extends Long> iterable) {
            zzam();
            zzgf$zzn.zza((zzgf$zzn) this.zza, iterable);
            return this;
        }

        private zza() {
            super(zzgf$zzn.zzc);
        }

        public final zza zza(int i5) {
            zzam();
            zzgf$zzn.zza((zzgf$zzn) this.zza, i5);
            return this;
        }
    }

    static {
        zzgf$zzn zzgf_zzn = new zzgf$zzn();
        zzc = zzgf_zzn;
        zzkg.zza((Class<zzgf$zzn>) zzgf$zzn.class, zzgf_zzn);
    }

    private zzgf$zzn() {
    }

    public static zza zzc() {
        return zzc.zzcg();
    }

    public final int zza() {
        return this.zzg.size();
    }

    public final int zzb() {
        return this.zzf;
    }

    public final List<Long> zze() {
        return this.zzg;
    }

    public final boolean zzf() {
        return (this.zze & 1) != 0;
    }

    public final long zza(int i5) {
        return this.zzg.zzb(i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzgi.zza[i5 - 1]) {
            case 1:
                return new zzgf$zzn();
            case 2:
                return new zza();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzlz<zzgf$zzn> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzgf$zzn.class) {
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

    static /* synthetic */ void zza(zzgf$zzn zzgf_zzn, Iterable iterable) {
        zzkn zzknVar = zzgf_zzn.zzg;
        if (!zzknVar.zzc()) {
            zzgf_zzn.zzg = zzkg.zza(zzknVar);
        }
        zzio.zza(iterable, zzgf_zzn.zzg);
    }

    static /* synthetic */ void zza(zzgf$zzn zzgf_zzn, int i5) {
        zzgf_zzn.zze |= 1;
        zzgf_zzn.zzf = i5;
    }
}
