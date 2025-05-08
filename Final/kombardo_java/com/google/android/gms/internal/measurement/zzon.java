package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zzon implements Supplier<zzoq> {
    private static zzon zza = new zzon();
    private final Supplier<zzoq> zzb = Suppliers.ofInstance(new zzop());

    public static boolean zza() {
        return ((zzoq) zza.get()).zza();
    }

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzoq get() {
        return this.zzb.get();
    }
}
