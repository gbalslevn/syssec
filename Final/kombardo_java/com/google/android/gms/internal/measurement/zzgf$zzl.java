package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgf$zzg;
import com.google.android.gms.internal.measurement.zzkg;

/* loaded from: classes.dex */
public final class zzgf$zzl extends zzkg<zzgf$zzl, zzb> implements zzlo {
    private static final zzgf$zzl zzc;
    private static volatile zzlz<zzgf$zzl> zzd;
    private int zze;
    private int zzf = 1;
    private zzkm<zzgf$zzg> zzg = zzkg.zzcl();

    /* loaded from: classes.dex */
    public enum zza implements zzki {
        RADS(1),
        PROVISIONING(2);

        private final int zzd;

        zza(int i5) {
            this.zzd = i5;
        }

        public static zzkl zzb() {
            return zzgl.zza;
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
            if (i5 == 1) {
                return RADS;
            }
            if (i5 != 2) {
                return null;
            }
            return PROVISIONING;
        }
    }

    /* loaded from: classes.dex */
    public static final class zzb extends zzkg.zza<zzgf$zzl, zzb> implements zzlo {
        public final zzb zza(zzgf$zzg.zza zzaVar) {
            zzam();
            zzgf$zzl.zza((zzgf$zzl) this.zza, (zzgf$zzg) ((zzkg) zzaVar.zzaj()));
            return this;
        }

        private zzb() {
            super(zzgf$zzl.zzc);
        }
    }

    static {
        zzgf$zzl zzgf_zzl = new zzgf$zzl();
        zzc = zzgf_zzl;
        zzkg.zza((Class<zzgf$zzl>) zzgf$zzl.class, zzgf_zzl);
    }

    private zzgf$zzl() {
    }

    public static zzb zza() {
        return zzc.zzcg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Object zza(int i5, Object obj, Object obj2) {
        switch (zzgi.zza[i5 - 1]) {
            case 1:
                return new zzgf$zzl();
            case 2:
                return new zzb();
            case 3:
                return zzkg.zza(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b", new Object[]{"zze", "zzf", zza.zzb(), "zzg", zzgf$zzg.class});
            case 4:
                return zzc;
            case 5:
                zzlz<zzgf$zzl> zzlzVar = zzd;
                if (zzlzVar == null) {
                    synchronized (zzgf$zzl.class) {
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

    static /* synthetic */ void zza(zzgf$zzl zzgf_zzl, zzgf$zzg zzgf_zzg) {
        zzgf_zzg.getClass();
        zzkm<zzgf$zzg> zzkmVar = zzgf_zzl.zzg;
        if (!zzkmVar.zzc()) {
            zzgf_zzl.zzg = zzkg.zza(zzkmVar);
        }
        zzgf_zzl.zzg.add(zzgf_zzg);
    }
}
