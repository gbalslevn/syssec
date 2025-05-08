package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfw$zzb;
import com.google.android.gms.internal.measurement.zzfw$zze;
import com.google.android.gms.internal.measurement.zzkg;
import java.util.List;

/* loaded from: classes.dex */
public final class zzfw$zza extends zzkg<zzfw$zza, zza> implements zzlo {
    private static final zzfw$zza zzc;
    private static volatile zzlz<zzfw$zza> zzd;
    private int zze;
    private int zzf;
    private zzkm<zzfw$zze> zzg = zzkg.zzcl();
    private zzkm<zzfw$zzb> zzh = zzkg.zzcl();
    private boolean zzi;
    private boolean zzj;

    /* loaded from: classes.dex */
    public static final class zza extends zzkg.zza<zzfw$zza, zza> implements zzlo {
        public final int zza() {
            return ((zzfw$zza) this.zza).zzb();
        }

        public final int zzb() {
            return ((zzfw$zza) this.zza).zzc();
        }

        private zza() {
            super(zzfw$zza.zzc);
        }

        public final zza zza(int i5, zzfw$zzb.zza zzaVar) {
            zzam();
            zzfw$zza.zza((zzfw$zza) this.zza, i5, (zzfw$zzb) ((zzkg) zzaVar.zzaj()));
            return this;
        }

        public final zzfw$zze zzb(int i5) {
            return ((zzfw$zza) this.zza).zzb(i5);
        }

        public final zza zza(int i5, zzfw$zze.zza zzaVar) {
            zzam();
            zzfw$zza.zza((zzfw$zza) this.zza, i5, (zzfw$zze) ((zzkg) zzaVar.zzaj()));
            return this;
        }

        public final zzfw$zzb zza(int i5) {
            return ((zzfw$zza) this.zza).zza(i5);
        }
    }

    static {
        zzfw$zza zzfw_zza = new zzfw$zza();
        zzc = zzfw_zza;
        zzkg.zza((Class<zzfw$zza>) zzfw$zza.class, zzfw_zza);
    }

    private zzfw$zza() {
    }

    public final int zza() {
        return this.zzf;
    }

    public final int zzb() {
        return this.zzh.size();
    }

    public final int zzc() {
        return this.zzg.size();
    }

    public final List<zzfw$zzb> zze() {
        return this.zzh;
    }

    public final List<zzfw$zze> zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return (this.zze & 1) != 0;
    }

    public final zzfw$zzb zza(int i5) {
        return this.zzh.get(i5);
    }

    public final zzfw$zze zzb(int i5) {
        return this.zzg.get(i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzfx.zza[i5 - 1]) {
            case 1:
                return new zzfw$zza();
            case 2:
                return new zza();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zze", "zzf", "zzg", zzfw$zze.class, "zzh", zzfw$zzb.class, "zzi", "zzj"});
            case 4:
                return zzc;
            case 5:
                zzlz<zzfw$zza> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzfw$zza.class) {
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

    static /* synthetic */ void zza(zzfw$zza zzfw_zza, int i5, zzfw$zzb zzfw_zzb) {
        zzfw_zzb.getClass();
        zzkm<zzfw$zzb> zzkmVar = zzfw_zza.zzh;
        if (!zzkmVar.zzc()) {
            zzfw_zza.zzh = zzkg.zza(zzkmVar);
        }
        zzfw_zza.zzh.set(i5, zzfw_zzb);
    }

    static /* synthetic */ void zza(zzfw$zza zzfw_zza, int i5, zzfw$zze zzfw_zze) {
        zzfw_zze.getClass();
        zzkm<zzfw$zze> zzkmVar = zzfw_zza.zzg;
        if (!zzkmVar.zzc()) {
            zzfw_zza.zzg = zzkg.zza(zzkmVar);
        }
        zzfw_zza.zzg.set(i5, zzfw_zze);
    }
}
