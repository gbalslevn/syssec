package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zznv implements Supplier<zzny> {
    private static zznv zza = new zznv();
    private final Supplier<zzny> zzb = Suppliers.ofInstance(new zznx());

    public static long zza() {
        return ((zzny) zza.get()).zza();
    }

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzny get() {
        return this.zzb.get();
    }
}
