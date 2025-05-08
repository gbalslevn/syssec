package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgf$zzk;
import com.google.android.gms.internal.measurement.zzkg;
import java.util.Collections;
import java.util.List;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzgf$zzj extends zzkg<zzgf$zzj, zzb> implements zzlo {
    private static final zzgf$zzj zzc;
    private static volatile zzlz<zzgf$zzj> zzd;
    private int zze;
    private zzkm<zzgf$zzk> zzf = zzkg.zzcl();
    private String zzg = BuildConfig.FLAVOR;
    private String zzh = BuildConfig.FLAVOR;
    private int zzi;

    /* loaded from: classes.dex */
    public enum zza implements zzki {
        SDK(0),
        SGTM(1);

        private final int zzd;

        zza(int i5) {
            this.zzd = i5;
        }

        public static zzkl zzb() {
            return zzgk.zza;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
        }

        @Override // com.google.android.gms.internal.measurement.zzki
        public final int zza() {
            return this.zzd;
        }

        public static zza zza(int i5) {
            if (i5 == 0) {
                return SDK;
            }
            if (i5 != 1) {
                return null;
            }
            return SGTM;
        }
    }

    /* loaded from: classes.dex */
    public static final class zzb extends zzkg.zza<zzgf$zzj, zzb> implements zzlo {
        public final int zza() {
            return ((zzgf$zzj) this.zza).zza();
        }

        public final zzb zzb() {
            zzam();
            zzgf$zzj.zzb((zzgf$zzj) this.zza);
            return this;
        }

        public final String zzc() {
            return ((zzgf$zzj) this.zza).zzd();
        }

        public final List<zzgf$zzk> zzd() {
            return Collections.unmodifiableList(((zzgf$zzj) this.zza).zzf());
        }

        private zzb() {
            super(zzgf$zzj.zzc);
        }

        public final zzb zza(Iterable<? extends zzgf$zzk> iterable) {
            zzam();
            zzgf$zzj.zza((zzgf$zzj) this.zza, iterable);
            return this;
        }

        public final zzb zzb(String str) {
            zzam();
            zzgf$zzj.zzb((zzgf$zzj) this.zza, str);
            return this;
        }

        public final zzb zza(zzgf$zzk.zza zzaVar) {
            zzam();
            zzgf$zzj.zza((zzgf$zzj) this.zza, (zzgf$zzk) ((zzkg) zzaVar.zzaj()));
            return this;
        }

        public final zzb zza(int i5, zzgf$zzk.zza zzaVar) {
            zzam();
            zzgf$zzj.zza((zzgf$zzj) this.zza, i5, (zzgf$zzk) ((zzkg) zzaVar.zzaj()));
            return this;
        }

        public final zzb zza(String str) {
            zzam();
            zzgf$zzj.zza((zzgf$zzj) this.zza, str);
            return this;
        }

        public final zzgf$zzk zza(int i5) {
            return ((zzgf$zzj) this.zza).zza(i5);
        }
    }

    static {
        zzgf$zzj zzgf_zzj = new zzgf$zzj();
        zzc = zzgf_zzj;
        zzkg.zza((Class<zzgf$zzj>) zzgf$zzj.class, zzgf_zzj);
    }

    private zzgf$zzj() {
    }

    public static zzb zzb() {
        return zzc.zzcg();
    }

    private final void zzi() {
        zzkm<zzgf$zzk> zzkmVar = this.zzf;
        if (zzkmVar.zzc()) {
            return;
        }
        this.zzf = zzkg.zza(zzkmVar);
    }

    public final int zza() {
        return this.zzf.size();
    }

    public final String zzd() {
        return this.zzg;
    }

    public final String zze() {
        return this.zzh;
    }

    public final List<zzgf$zzk> zzf() {
        return this.zzf;
    }

    public final boolean zzg() {
        return (this.zze & 1) != 0;
    }

    public final boolean zzh() {
        return (this.zze & 2) != 0;
    }

    public static zzb zza(zzgf$zzj zzgf_zzj) {
        return zzc.zza(zzgf_zzj);
    }

    static /* synthetic */ void zzb(zzgf$zzj zzgf_zzj) {
        zzgf_zzj.zzf = zzkg.zzcl();
    }

    static /* synthetic */ void zzb(zzgf$zzj zzgf_zzj, String str) {
        str.getClass();
        zzgf_zzj.zze |= 2;
        zzgf_zzj.zzh = str;
    }

    public final zzgf$zzk zza(int i5) {
        return this.zzf.get(i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzgi.zza[i5 - 1]) {
            case 1:
                return new zzgf$zzj();
            case 2:
                return new zzb();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0004\u0000\u0001\u0001\t\u0004\u0000\u0001\u0000\u0001\u001b\u0007ဈ\u0000\bဈ\u0001\t᠌\u0002", new Object[]{"zze", "zzf", zzgf$zzk.class, "zzg", "zzh", "zzi", zza.zzb()});
            case 4:
                return zzc;
            case 5:
                zzlz<zzgf$zzj> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzgf$zzj.class) {
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

    static /* synthetic */ void zza(zzgf$zzj zzgf_zzj, Iterable iterable) {
        zzgf_zzj.zzi();
        zzio.zza(iterable, zzgf_zzj.zzf);
    }

    static /* synthetic */ void zza(zzgf$zzj zzgf_zzj, zzgf$zzk zzgf_zzk) {
        zzgf_zzk.getClass();
        zzgf_zzj.zzi();
        zzgf_zzj.zzf.add(zzgf_zzk);
    }

    static /* synthetic */ void zza(zzgf$zzj zzgf_zzj, int i5, zzgf$zzk zzgf_zzk) {
        zzgf_zzk.getClass();
        zzgf_zzj.zzi();
        zzgf_zzj.zzf.set(i5, zzgf_zzk);
    }

    static /* synthetic */ void zza(zzgf$zzj zzgf_zzj, String str) {
        str.getClass();
        zzgf_zzj.zze |= 1;
        zzgf_zzj.zzg = str;
    }
}
