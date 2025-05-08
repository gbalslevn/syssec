package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
final class zzau implements Iterator<zzaq> {
    private int zza = 0;
    private final /* synthetic */ zzas zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzau(zzas zzasVar) {
        this.zzb = zzasVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        String str;
        int i5 = this.zza;
        str = this.zzb.zza;
        return i5 < str.length();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ zzaq next() {
        String str;
        String str2;
        int i5 = this.zza;
        str = this.zzb.zza;
        if (i5 >= str.length()) {
            throw new NoSuchElementException();
        }
        str2 = this.zzb.zza;
        int i6 = this.zza;
        this.zza = i6 + 1;
        return new zzas(String.valueOf(str2.charAt(i6)));
    }
}
