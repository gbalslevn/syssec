package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zzpf implements Supplier<zzpi> {
    private static zzpf zza = new zzpf();
    private final Supplier<zzpi> zzb = Suppliers.ofInstance(new zzph());

    public static boolean zza() {
        return ((zzpi) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzpi) zza.get()).zzb();
    }

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzpi get() {
        return this.zzb.get();
    }
}
