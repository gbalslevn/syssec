package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zzog implements Supplier<zzof> {
    private static zzog zza = new zzog();
    private final Supplier<zzof> zzb = Suppliers.ofInstance(new zzoi());

    public static boolean zza() {
        return ((zzof) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzof) zza.get()).zzb();
    }

    public static boolean zzc() {
        return ((zzof) zza.get()).zzc();
    }

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzof get() {
        return this.zzb.get();
    }
}
