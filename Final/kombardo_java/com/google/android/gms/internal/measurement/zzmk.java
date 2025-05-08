package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* loaded from: classes.dex */
final class zzmk extends zzmp {
    private final /* synthetic */ zzmj zza;

    @Override // com.google.android.gms.internal.measurement.zzmp, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzml(this.zza);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzmk(zzmj zzmjVar) {
        super(zzmjVar);
        this.zza = zzmjVar;
    }
}
