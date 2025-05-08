package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;

/* loaded from: classes.dex */
final class zzke implements zzln {
    private static final zzke zza = new zzke();

    private zzke() {
    }

    public static zzke zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzln
    public final boolean zzb(Class<?> cls) {
        return zzkg.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.measurement.zzln
    public final zzlk zza(Class<?> cls) {
        if (zzkg.class.isAssignableFrom(cls)) {
            try {
                return (zzlk) zzkg.zza(cls.asSubclass(zzkg.class)).zza(zzkg.zzf.zzc, (Object) null, (Object) null);
            } catch (Exception e5) {
                throw new RuntimeException("Unable to get message info for " + cls.getName(), e5);
            }
        }
        throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
    }
}
