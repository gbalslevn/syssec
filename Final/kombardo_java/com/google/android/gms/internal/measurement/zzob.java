package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zzob implements Supplier<zzoe> {
    private static zzob zza = new zzob();
    private final Supplier<zzoe> zzb = Suppliers.ofInstance(new zzod());

    public static boolean zza() {
        return ((zzoe) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzoe) zza.get()).zzb();
    }

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzoe get() {
        return this.zzb.get();
    }
}
