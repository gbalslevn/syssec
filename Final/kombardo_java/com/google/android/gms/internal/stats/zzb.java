package com.google.android.gms.internal.stats;

import java.io.Closeable;

/* loaded from: classes.dex */
public final class zzb implements Closeable {
    private static final zzb zza = new zzb(false, null);

    private zzb(boolean z5, zzd zzdVar) {
    }

    public static zzb zza(boolean z5, zzc zzcVar) {
        return zza;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
