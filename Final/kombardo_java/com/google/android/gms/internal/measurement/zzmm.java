package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class zzmm implements Iterator {
    private int zza;
    private boolean zzb;
    private Iterator zzc;
    private final /* synthetic */ zzmj zzd;

    private final Iterator zza() {
        Map map;
        if (this.zzc == null) {
            map = this.zzd.zzc;
            this.zzc = map.entrySet().iterator();
        }
        return this.zzc;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i5;
        Map map;
        int i6 = this.zza + 1;
        i5 = this.zzd.zzb;
        if (i6 >= i5) {
            map = this.zzd.zzc;
            if (map.isEmpty() || !zza().hasNext()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        int i5;
        Object[] objArr;
        this.zzb = true;
        int i6 = this.zza + 1;
        this.zza = i6;
        i5 = this.zzd.zzb;
        if (i6 >= i5) {
            return (Map.Entry) zza().next();
        }
        objArr = this.zzd.zza;
        return (zzmn) objArr[this.zza];
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i5;
        if (!this.zzb) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzb = false;
        this.zzd.zzg();
        int i6 = this.zza;
        i5 = this.zzd.zzb;
        if (i6 >= i5) {
            zza().remove();
            return;
        }
        zzmj zzmjVar = this.zzd;
        int i7 = this.zza;
        this.zza = i7 - 1;
        zzmjVar.zzb(i7);
    }

    private zzmm(zzmj zzmjVar) {
        this.zzd = zzmjVar;
        this.zza = -1;
    }
}
