package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zzoz implements Supplier<zzpc> {
    private static zzoz zza = new zzoz();
    private final Supplier<zzpc> zzb = Suppliers.ofInstance(new zzpb());

    public static boolean zza() {
        return ((zzpc) zza.get()).zza();
    }

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzpc get() {
        return this.zzb.get();
    }
}
