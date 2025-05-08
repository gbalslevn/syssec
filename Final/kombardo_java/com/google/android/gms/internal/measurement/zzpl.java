package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zzpl implements Supplier<zzpo> {
    private static zzpl zza = new zzpl();
    private final Supplier<zzpo> zzb = Suppliers.ofInstance(new zzpn());

    public static boolean zza() {
        return ((zzpo) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzpo) zza.get()).zzb();
    }

    public static boolean zzc() {
        return ((zzpo) zza.get()).zzc();
    }

    public static boolean zzd() {
        return ((zzpo) zza.get()).zzd();
    }

    public static boolean zze() {
        return ((zzpo) zza.get()).zze();
    }

    public static boolean zzf() {
        return ((zzpo) zza.get()).zzf();
    }

    public static boolean zzg() {
        return ((zzpo) zza.get()).zzg();
    }

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzpo get() {
        return this.zzb.get();
    }
}
