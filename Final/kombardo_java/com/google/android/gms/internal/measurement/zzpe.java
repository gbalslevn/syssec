package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zzpe implements Supplier<zzpd> {
    private static zzpe zza = new zzpe();
    private final Supplier<zzpd> zzb = Suppliers.ofInstance(new zzpg());

    public static boolean zza() {
        return ((zzpd) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzpd) zza.get()).zzb();
    }

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzpd get() {
        return this.zzb.get();
    }
}
