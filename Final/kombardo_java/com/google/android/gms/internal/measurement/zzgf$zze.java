package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;

/* loaded from: classes.dex */
public final class zzgf$zze extends zzkg<zzgf$zze, zza> implements zzlo {
    private static final zzgf$zze zzc;
    private static volatile zzlz<zzgf$zze> zzd;
    private int zze;
    private int zzf;
    private long zzg;

    /* loaded from: classes.dex */
    public static final class zza extends zzkg.zza<zzgf$zze, zza> implements zzlo {
        public final zza zza(long j5) {
            zzam();
            zzgf$zze.zza((zzgf$zze) this.zza, j5);
            return this;
        }

        private zza() {
            super(zzgf$zze.zzc);
        }

        public final zza zza(int i5) {
            zzam();
            zzgf$zze.zza((zzgf$zze) this.zza, i5);
            return this;
        }
    }

    static {
        zzgf$zze zzgf_zze = new zzgf$zze();
        zzc = zzgf_zze;
        zzkg.zza((Class<zzgf$zze>) zzgf$zze.class, zzgf_zze);
    }

    private zzgf$zze() {
    }

    public static zza zzc() {
        return zzc.zzcg();
    }

    public final int zza() {
        return this.zzf;
    }

    public final long zzb() {
        return this.zzg;
    }

    public final boolean zze() {
        return (this.zze & 2) != 0;
    }

    public final boolean zzf() {
        return (this.zze & 1) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzgi.zza[i5 - 1]) {
            case 1:
                return new zzgf$zze();
            case 2:
                return new zza();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzlz<zzgf$zze> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzgf$zze.class) {
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

    static /* synthetic */ void zza(zzgf$zze zzgf_zze, long j5) {
        zzgf_zze.zze |= 2;
        zzgf_zze.zzg = j5;
    }

    static /* synthetic */ void zza(zzgf$zze zzgf_zze, int i5) {
        zzgf_zze.zze |= 1;
        zzgf_zze.zzf = i5;
    }
}
