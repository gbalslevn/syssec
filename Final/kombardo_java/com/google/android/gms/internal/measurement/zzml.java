package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class zzml implements Iterator {
    private int zza;
    private Iterator zzb;
    private final /* synthetic */ zzmj zzc;

    private final Iterator zza() {
        Map map;
        if (this.zzb == null) {
            map = this.zzc.zzf;
            this.zzb = map.entrySet().iterator();
        }
        return this.zzb;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i5;
        int i6 = this.zza;
        if (i6 > 0) {
            i5 = this.zzc.zzb;
            if (i6 <= i5) {
                return true;
            }
        }
        return zza().hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Object[] objArr;
        if (zza().hasNext()) {
            return (Map.Entry) zza().next();
        }
        objArr = this.zzc.zza;
        int i5 = this.zza - 1;
        this.zza = i5;
        return (zzmn) objArr[i5];
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private zzml(zzmj zzmjVar) {
        int i5;
        this.zzc = zzmjVar;
        i5 = zzmjVar.zzb;
        this.zza = i5;
    }
}
