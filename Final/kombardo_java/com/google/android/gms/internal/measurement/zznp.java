package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zznp implements Supplier<zzns> {
    private static zznp zza = new zznp();
    private final Supplier<zzns> zzb = Suppliers.ofInstance(new zznr());

    public static boolean zza() {
        return ((zzns) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzns) zza.get()).zzb();
    }

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzns get() {
        return this.zzb.get();
    }
}
