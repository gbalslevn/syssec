package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zzoh implements Supplier<zzok> {
    private static zzoh zza = new zzoh();
    private final Supplier<zzok> zzb = Suppliers.ofInstance(new zzoj());

    public static boolean zza() {
        return ((zzok) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzok) zza.get()).zzb();
    }

    public static boolean zzc() {
        return ((zzok) zza.get()).zzc();
    }

    public static boolean zzd() {
        return ((zzok) zza.get()).zzd();
    }

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzok get() {
        return this.zzb.get();
    }
}
