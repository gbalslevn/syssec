package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zzot implements Supplier<zzow> {
    private static zzot zza = new zzot();
    private final Supplier<zzow> zzb = Suppliers.ofInstance(new zzov());

    public static double zza() {
        return ((zzow) zza.get()).zza();
    }

    public static long zzb() {
        return ((zzow) zza.get()).zzb();
    }

    public static long zzc() {
        return ((zzow) zza.get()).zzc();
    }

    public static long zzd() {
        return ((zzow) zza.get()).zzd();
    }

    public static String zze() {
        return ((zzow) zza.get()).zze();
    }

    public static boolean zzf() {
        return ((zzow) zza.get()).zzf();
    }

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzow get() {
        return this.zzb.get();
    }
}
