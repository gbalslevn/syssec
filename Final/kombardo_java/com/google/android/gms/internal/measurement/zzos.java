package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zzos implements Supplier<zzor> {
    private static zzos zza = new zzos();
    private final Supplier<zzor> zzb = Suppliers.ofInstance(new zzou());

    public static boolean zza() {
        return ((zzor) zza.get()).zza();
    }

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzor get() {
        return this.zzb.get();
    }
}
