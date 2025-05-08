package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzfw$zze extends zzkg<zzfw$zze, zza> implements zzlo {
    private static final zzfw$zze zzc;
    private static volatile zzlz<zzfw$zze> zzd;
    private int zze;
    private int zzf;
    private String zzg = BuildConfig.FLAVOR;
    private zzfw$zzc zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;

    /* loaded from: classes.dex */
    public static final class zza extends zzkg.zza<zzfw$zze, zza> implements zzlo {
        public final zza zza(String str) {
            zzam();
            zzfw$zze.zza((zzfw$zze) this.zza, str);
            return this;
        }

        private zza() {
            super(zzfw$zze.zzc);
        }
    }

    static {
        zzfw$zze zzfw_zze = new zzfw$zze();
        zzc = zzfw_zze;
        zzkg.zza((Class<zzfw$zze>) zzfw$zze.class, zzfw_zze);
    }

    private zzfw$zze() {
    }

    public static zza zzc() {
        return zzc.zzcg();
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzfw$zzc zzb() {
        zzfw$zzc zzfw_zzc = this.zzh;
        return zzfw_zzc == null ? zzfw$zzc.zzb() : zzfw_zzc;
    }

    public final String zze() {
        return this.zzg;
    }

    public final boolean zzf() {
        return this.zzi;
    }

    public final boolean zzg() {
        return this.zzj;
    }

    public final boolean zzh() {
        return this.zzk;
    }

    public final boolean zzi() {
        return (this.zze & 1) != 0;
    }

    public final boolean zzj() {
        return (this.zze & 32) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzfx.zza[i5 - 1]) {
            case 1:
                return new zzfw$zze();
            case 2:
                return new zza();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
            case 4:
                return zzc;
            case 5:
                zzlz<zzfw$zze> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzfw$zze.class) {
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

    static /* synthetic */ void zza(zzfw$zze zzfw_zze, String str) {
        str.getClass();
        zzfw_zze.zze |= 2;
        zzfw_zze.zzg = str;
    }
}
