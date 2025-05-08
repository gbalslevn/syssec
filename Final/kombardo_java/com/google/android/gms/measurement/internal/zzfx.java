package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
public final class zzfx<V> {
    private static final Object zza = new Object();
    private final String zzb;
    private final zzfv<V> zzc;
    private final V zzd;
    private final Object zze;
    private volatile V zzf;
    private volatile V zzg;

    public final V zza(V v5) {
        synchronized (this.zze) {
        }
        if (v5 != null) {
            return v5;
        }
        if (zzfu.zza == null) {
            return this.zzd;
        }
        synchronized (zza) {
            try {
                if (zzaf.zza()) {
                    return this.zzg == null ? this.zzd : this.zzg;
                }
                try {
                    for (zzfx zzfxVar : zzbn.zzdc()) {
                        if (!zzaf.zza()) {
                            V v6 = null;
                            try {
                                zzfv<V> zzfvVar = zzfxVar.zzc;
                                if (zzfvVar != null) {
                                    v6 = zzfvVar.zza();
                                }
                            } catch (IllegalStateException unused) {
                            }
                            synchronized (zza) {
                                zzfxVar.zzg = v6;
                            }
                        } else {
                            throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                        }
                    }
                } catch (SecurityException unused2) {
                }
                zzfv<V> zzfvVar2 = this.zzc;
                if (zzfvVar2 == null) {
                    return this.zzd;
                }
                try {
                    return zzfvVar2.zza();
                } catch (IllegalStateException unused3) {
                    return this.zzd;
                } catch (SecurityException unused4) {
                    return this.zzd;
                }
            } finally {
            }
        }
    }

    private zzfx(String str, V v5, V v6, zzfv<V> zzfvVar) {
        this.zze = new Object();
        this.zzf = null;
        this.zzg = null;
        this.zzb = str;
        this.zzd = v5;
        this.zzc = zzfvVar;
    }

    public final String zza() {
        return this.zzb;
    }
}
