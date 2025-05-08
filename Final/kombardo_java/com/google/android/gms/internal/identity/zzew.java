package com.google.android.gms.internal.identity;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzew extends zzex {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzex zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzew(zzex zzexVar, int i5, int i6) {
        this.zzc = zzexVar;
        this.zza = i5;
        this.zzb = i6;
    }

    @Override // java.util.List
    public final Object get(int i5) {
        zzer.zzc(i5, this.zzb, "index");
        return this.zzc.get(i5 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.identity.zzex, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i5, int i6) {
        return subList(i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.identity.zzeu
    public final Object[] zzb() {
        return this.zzc.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.identity.zzeu
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.identity.zzeu
    final int zzd() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.identity.zzeu
    public final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.identity.zzex
    /* renamed from: zzh */
    public final zzex subList(int i5, int i6) {
        zzer.zze(i5, i6, this.zzb);
        int i7 = this.zza;
        return this.zzc.subList(i5 + i7, i6 + i7);
    }
}
