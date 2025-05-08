package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgc$zzc;
import com.google.android.gms.internal.measurement.zzkg;
import java.util.Collections;
import java.util.List;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzgc$zzd extends zzkg<zzgc$zzd, zza> implements zzlo {
    private static final zzgc$zzd zzc;
    private static volatile zzlz<zzgc$zzd> zzd;
    private int zze;
    private long zzf;
    private int zzh;
    private boolean zzm;
    private zzgc$zza zzr;
    private zzgc$zzf zzs;
    private zzgc$zzi zzt;
    private zzgc$zzg zzu;
    private zzgc$zze zzv;
    private String zzg = BuildConfig.FLAVOR;
    private zzkm<zzgc$zzh> zzi = zzkg.zzcl();
    private zzkm<zzgc$zzc> zzj = zzkg.zzcl();
    private zzkm<zzfw$zza> zzk = zzkg.zzcl();
    private String zzl = BuildConfig.FLAVOR;
    private zzkm<zzgr$zzc> zzn = zzkg.zzcl();
    private zzkm<zzgc$zzb> zzo = zzkg.zzcl();
    private String zzp = BuildConfig.FLAVOR;
    private String zzq = BuildConfig.FLAVOR;

    /* loaded from: classes.dex */
    public static final class zza extends zzkg.zza<zzgc$zzd, zza> implements zzlo {
        public final int zza() {
            return ((zzgc$zzd) this.zza).zzb();
        }

        public final zza zzb() {
            zzam();
            zzgc$zzd.zza((zzgc$zzd) this.zza);
            return this;
        }

        public final String zzc() {
            return ((zzgc$zzd) this.zza).zzj();
        }

        public final List<zzfw$zza> zzd() {
            return Collections.unmodifiableList(((zzgc$zzd) this.zza).zzk());
        }

        public final List<zzgc$zzb> zze() {
            return Collections.unmodifiableList(((zzgc$zzd) this.zza).zzl());
        }

        private zza() {
            super(zzgc$zzd.zzc);
        }

        public final zzgc$zzc zza(int i5) {
            return ((zzgc$zzd) this.zza).zza(i5);
        }

        public final zza zza(int i5, zzgc$zzc.zza zzaVar) {
            zzam();
            zzgc$zzd.zza((zzgc$zzd) this.zza, i5, (zzgc$zzc) ((zzkg) zzaVar.zzaj()));
            return this;
        }
    }

    static {
        zzgc$zzd zzgc_zzd = new zzgc$zzd();
        zzc = zzgc_zzd;
        zzkg.zza((Class<zzgc$zzd>) zzgc$zzd.class, zzgc_zzd);
    }

    private zzgc$zzd() {
    }

    public static zza zze() {
        return zzc.zzcg();
    }

    public static zzgc$zzd zzg() {
        return zzc;
    }

    public final int zza() {
        return this.zzn.size();
    }

    public final int zzb() {
        return this.zzj.size();
    }

    public final long zzc() {
        return this.zzf;
    }

    public final zzgc$zza zzd() {
        zzgc$zza zzgc_zza = this.zzr;
        return zzgc_zza == null ? zzgc$zza.zzb() : zzgc_zza;
    }

    public final zzgc$zzi zzh() {
        zzgc$zzi zzgc_zzi = this.zzt;
        return zzgc_zzi == null ? zzgc$zzi.zzc() : zzgc_zzi;
    }

    public final String zzi() {
        return this.zzg;
    }

    public final String zzj() {
        return this.zzp;
    }

    public final List<zzfw$zza> zzk() {
        return this.zzk;
    }

    public final List<zzgc$zzb> zzl() {
        return this.zzo;
    }

    public final List<zzgr$zzc> zzm() {
        return this.zzn;
    }

    public final List<zzgc$zzh> zzn() {
        return this.zzi;
    }

    public final boolean zzo() {
        return (this.zze & 128) != 0;
    }

    public final boolean zzp() {
        return (this.zze & 2) != 0;
    }

    public final boolean zzq() {
        return (this.zze & 512) != 0;
    }

    public final boolean zzr() {
        return (this.zze & 1) != 0;
    }

    public final zzgc$zzc zza(int i5) {
        return this.zzj.get(i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzgb.zza[i5 - 1]) {
            case 1:
                return new zzgc$zzd();
            case 2:
                return new zza();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0011\u0000\u0001\u0001\u0013\u0011\u0000\u0005\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b\n\u001b\u000bဈ\u0005\u000eဈ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011ဉ\t\u0012ဉ\n\u0013ဉ\u000b", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", zzgc$zzh.class, "zzj", zzgc$zzc.class, "zzk", zzfw$zza.class, "zzl", "zzm", "zzn", zzgr$zzc.class, "zzo", zzgc$zzb.class, "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv"});
            case 4:
                return zzc;
            case 5:
                zzlz<zzgc$zzd> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzgc$zzd.class) {
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

    static /* synthetic */ void zza(zzgc$zzd zzgc_zzd) {
        zzgc_zzd.zzk = zzkg.zzcl();
    }

    static /* synthetic */ void zza(zzgc$zzd zzgc_zzd, int i5, zzgc$zzc zzgc_zzc) {
        zzgc_zzc.getClass();
        zzkm<zzgc$zzc> zzkmVar = zzgc_zzd.zzj;
        if (!zzkmVar.zzc()) {
            zzgc_zzd.zzj = zzkg.zza(zzkmVar);
        }
        zzgc_zzd.zzj.set(i5, zzgc_zzc);
    }
}
