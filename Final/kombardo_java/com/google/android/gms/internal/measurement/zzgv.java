package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public abstract class zzgv {
    private static zzgy zza;

    public static synchronized zzgy zza() {
        zzgy zzgyVar;
        synchronized (zzgv.class) {
            try {
                if (zza == null) {
                    zza(new zzgx());
                }
                zzgyVar = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzgyVar;
    }

    private static synchronized void zza(zzgy zzgyVar) {
        synchronized (zzgv.class) {
            if (zza == null) {
                zza = zzgyVar;
            } else {
                throw new IllegalStateException("init() already called");
            }
        }
    }
}
