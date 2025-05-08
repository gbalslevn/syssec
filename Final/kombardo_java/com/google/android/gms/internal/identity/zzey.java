package com.google.android.gms.internal.identity;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzey extends zzex {
    static final zzex zza = new zzey(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzey(Object[] objArr, int i5) {
        this.zzb = objArr;
        this.zzc = i5;
    }

    @Override // java.util.List
    public final Object get(int i5) {
        zzer.zzc(i5, this.zzc, "index");
        Object obj = this.zzb[i5];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.identity.zzeu
    public final Object[] zzb() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.identity.zzeu
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.identity.zzeu
    final int zzd() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.identity.zzeu
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.identity.zzex, com.google.android.gms.internal.identity.zzeu
    final int zzg(Object[] objArr, int i5) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }
}
