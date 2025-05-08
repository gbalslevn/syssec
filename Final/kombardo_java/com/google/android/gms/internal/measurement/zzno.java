package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zzno implements Supplier<zznn> {
    private static zzno zza = new zzno();
    private final Supplier<zznn> zzb = Suppliers.ofInstance(new zznq());

    public static boolean zza() {
        return ((zznn) zza.get()).zza();
    }

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zznn get() {
        return this.zzb.get();
    }
}
