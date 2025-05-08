package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzix extends zziz {
    private int zza = 0;
    private final int zzb;
    private final /* synthetic */ zziy zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzix(zziy zziyVar) {
        this.zzc = zziyVar;
        this.zzb = zziyVar.zzb();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza < this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzje
    public final byte zza() {
        int i5 = this.zza;
        if (i5 >= this.zzb) {
            throw new NoSuchElementException();
        }
        this.zza = i5 + 1;
        return this.zzc.zzb(i5);
    }
}
