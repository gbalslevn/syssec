package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zzoa implements Supplier<zznz> {
    private static zzoa zza = new zzoa();
    private final Supplier<zznz> zzb = Suppliers.ofInstance(new zzoc());

    public static boolean zza() {
        return ((zznz) zza.get()).zza();
    }

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zznz get() {
        return this.zzb.get();
    }
}
