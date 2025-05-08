package com.google.android.gms.measurement.internal;

import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzhs extends LruCache<String, com.google.android.gms.internal.measurement.zzb> {
    private final /* synthetic */ zzhm zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzhs(zzhm zzhmVar, int i5) {
        super(20);
        this.zza = zzhmVar;
    }

    @Override // androidx.collection.LruCache
    protected final /* synthetic */ com.google.android.gms.internal.measurement.zzb create(String str) {
        String str2 = str;
        Preconditions.checkNotEmpty(str2);
        return zzhm.zza(this.zza, str2);
    }
}
