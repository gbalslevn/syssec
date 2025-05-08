package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zzom implements Supplier<zzol> {
    private static zzom zza = new zzom();
    private final Supplier<zzol> zzb = Suppliers.ofInstance(new zzoo());

    public static boolean zza() {
        return ((zzol) zza.get()).zza();
    }

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzol get() {
        return this.zzb.get();
    }
}
