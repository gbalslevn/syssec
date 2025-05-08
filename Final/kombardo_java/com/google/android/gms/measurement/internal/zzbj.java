package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbj implements Iterator<String> {
    private Iterator<String> zza;
    private final /* synthetic */ zzbg zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbj(zzbg zzbgVar) {
        Bundle bundle;
        this.zzb = zzbgVar;
        bundle = zzbgVar.zza;
        this.zza = bundle.keySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
