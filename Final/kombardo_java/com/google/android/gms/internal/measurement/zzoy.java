package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zzoy implements Supplier<zzox> {
    private static zzoy zza = new zzoy();
    private final Supplier<zzox> zzb = Suppliers.ofInstance(new zzpa());

    public static boolean zza() {
        return ((zzox) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzox) zza.get()).zzb();
    }

    public static boolean zzc() {
        return ((zzox) zza.get()).zzc();
    }

    public static boolean zzd() {
        return ((zzox) zza.get()).zzd();
    }

    public static boolean zze() {
        return ((zzox) zza.get()).zze();
    }

    public static boolean zzf() {
        return ((zzox) zza.get()).zzf();
    }

    public static boolean zzg() {
        return ((zzox) zza.get()).zzg();
    }

    public static boolean zzh() {
        return ((zzox) zza.get()).zzh();
    }

    public static boolean zzi() {
        return ((zzox) zza.get()).zzi();
    }

    public static boolean zzj() {
        return ((zzox) zza.get()).zzj();
    }

    public static boolean zzk() {
        return ((zzox) zza.get()).zzk();
    }

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzox get() {
        return this.zzb.get();
    }
}
