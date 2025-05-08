package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import java.util.List;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzfw$zzb extends zzkg<zzfw$zzb, zza> implements zzlo {
    private static final zzfw$zzb zzc;
    private static volatile zzlz<zzfw$zzb> zzd;
    private int zze;
    private int zzf;
    private String zzg = BuildConfig.FLAVOR;
    private zzkm<zzfw$zzc> zzh = zzkg.zzcl();
    private boolean zzi;
    private zzfw$zzd zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;

    /* loaded from: classes.dex */
    public static final class zza extends zzkg.zza<zzfw$zzb, zza> implements zzlo {
        public final int zza() {
            return ((zzfw$zzb) this.zza).zza();
        }

        public final String zzb() {
            return ((zzfw$zzb) this.zza).zzf();
        }

        private zza() {
            super(zzfw$zzb.zzc);
        }

        public final zza zza(String str) {
            zzam();
            zzfw$zzb.zza((zzfw$zzb) this.zza, str);
            return this;
        }

        public final zza zza(int i5, zzfw$zzc zzfw_zzc) {
            zzam();
            zzfw$zzb.zza((zzfw$zzb) this.zza, i5, zzfw_zzc);
            return this;
        }

        public final zzfw$zzc zza(int i5) {
            return ((zzfw$zzb) this.zza).zza(i5);
        }
    }

    static {
        zzfw$zzb zzfw_zzb = new zzfw$zzb();
        zzc = zzfw_zzb;
        zzkg.zza((Class<zzfw$zzb>) zzfw$zzb.class, zzfw_zzb);
    }

    private zzfw$zzb() {
    }

    public static zza zzc() {
        return zzc.zzcg();
    }

    public final int zza() {
        return this.zzh.size();
    }

    public final int zzb() {
        return this.zzf;
    }

    public final zzfw$zzd zze() {
        zzfw$zzd zzfw_zzd = this.zzj;
        return zzfw_zzd == null ? zzfw$zzd.zzc() : zzfw_zzd;
    }

    public final String zzf() {
        return this.zzg;
    }

    public final List<zzfw$zzc> zzg() {
        return this.zzh;
    }

    public final boolean zzh() {
        return this.zzk;
    }

    public final boolean zzi() {
        return this.zzl;
    }

    public final boolean zzj() {
        return this.zzm;
    }

    public final boolean zzk() {
        return (this.zze & 8) != 0;
    }

    public final boolean zzl() {
        return (this.zze & 1) != 0;
    }

    public final boolean zzm() {
        return (this.zze & 64) != 0;
    }

    public final zzfw$zzc zza(int i5) {
        return this.zzh.get(i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzfx.zza[i5 - 1]) {
            case 1:
                return new zzfw$zzb();
            case 2:
                return new zza();
            case 3:
                return zzkg.zza(zzc, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zze", "zzf", "zzg", "zzh", zzfw$zzc.class, "zzi", "zzj", "zzk", "zzl", "zzm"});
            case 4:
                return zzc;
            case 5:
                zzlz<zzfw$zzb> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzfw$zzb.class) {
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

    static /* synthetic */ void zza(zzfw$zzb zzfw_zzb, String str) {
        str.getClass();
        zzfw_zzb.zze |= 2;
        zzfw_zzb.zzg = str;
    }

    static /* synthetic */ void zza(zzfw$zzb zzfw_zzb, int i5, zzfw$zzc zzfw_zzc) {
        zzfw_zzc.getClass();
        zzkm<zzfw$zzc> zzkmVar = zzfw_zzb.zzh;
        if (!zzkmVar.zzc()) {
            zzfw_zzb.zzh = zzkg.zza(zzkmVar);
        }
        zzfw_zzb.zzh.set(i5, zzfw_zzc);
    }
}
