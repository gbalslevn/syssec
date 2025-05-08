package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zzpk implements Supplier<zzpj> {
    private static zzpk zza = new zzpk();
    private final Supplier<zzpj> zzb = Suppliers.ofInstance(new zzpm());

    public static boolean zza() {
        return ((zzpj) zza.get()).zza();
    }

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzpj get() {
        return this.zzb.get();
    }
}
