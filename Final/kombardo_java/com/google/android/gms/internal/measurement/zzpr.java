package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zzpr implements Supplier<zzpu> {
    private static zzpr zza = new zzpr();
    private final Supplier<zzpu> zzb = Suppliers.ofInstance(new zzpt());

    public static boolean zza() {
        return ((zzpu) zza.get()).zza();
    }

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzpu get() {
        return this.zzb.get();
    }
}
