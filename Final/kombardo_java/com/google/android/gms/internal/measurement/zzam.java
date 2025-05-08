package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzam implements Iterator<zzaq> {
    private final /* synthetic */ Iterator zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzam(Iterator it) {
        this.zza = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ zzaq next() {
        return new zzas((String) this.zza.next());
    }
}
