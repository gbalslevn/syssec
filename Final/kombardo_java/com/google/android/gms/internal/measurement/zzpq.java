package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zzpq implements Supplier<zzpp> {
    private static zzpq zza = new zzpq();
    private final Supplier<zzpp> zzb = Suppliers.ofInstance(new zzps());

    public static boolean zza() {
        return ((zzpp) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzpp) zza.get()).zzb();
    }

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzpp get() {
        return this.zzb.get();
    }
}
