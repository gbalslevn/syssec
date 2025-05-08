package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class zzls<T> implements zzme<T> {
    private final zzlm zza;
    private final zzmu<?, ?> zzb;
    private final boolean zzc;
    private final zzjv<?> zzd;

    private zzls(zzmu<?, ?> zzmuVar, zzjv<?> zzjvVar, zzlm zzlmVar) {
        this.zzb = zzmuVar;
        this.zzc = zzjvVar.zza(zzlmVar);
        this.zzd = zzjvVar;
        this.zza = zzlmVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final int zza(T t5) {
        zzmu<?, ?> zzmuVar = this.zzb;
        int zzb = zzmuVar.zzb(zzmuVar.zzd(t5));
        return this.zzc ? zzb + this.zzd.zza(t5).zza() : zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final int zzb(T t5) {
        int hashCode = this.zzb.zzd(t5).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zza(t5).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final void zzd(T t5) {
        this.zzb.zzf(t5);
        this.zzd.zzc(t5);
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final boolean zze(T t5) {
        return this.zzd.zza(t5).zzg();
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final boolean zzb(T t5, T t6) {
        if (!this.zzb.zzd(t5).equals(this.zzb.zzd(t6))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza(t5).equals(this.zzd.zza(t6));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> zzls<T> zza(zzmu<?, ?> zzmuVar, zzjv<?> zzjvVar, zzlm zzlmVar) {
        return new zzls<>(zzmuVar, zzjvVar, zzlmVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final T zza() {
        zzlm zzlmVar = this.zza;
        if (zzlmVar instanceof zzkg) {
            return (T) ((zzkg) zzlmVar).zzci();
        }
        return (T) zzlmVar.zzcm().zzak();
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final void zza(T t5, T t6) {
        zzmg.zza(this.zzb, t5, t6);
        if (this.zzc) {
            zzmg.zza(this.zzd, t5, t6);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzme
    public final void zza(T t5, byte[] bArr, int i5, int i6, zzit zzitVar) {
        zzkg zzkgVar = (zzkg) t5;
        if (zzkgVar.zzb == zzmx.zzc()) {
            zzkgVar.zzb = zzmx.zzd();
        }
        android.support.v4.media.session.a.a(t5);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final void zza(T t5, zznl zznlVar) {
        Iterator<Map.Entry<?, Object>> zzd = this.zzd.zza(t5).zzd();
        if (!zzd.hasNext()) {
            zzmu<?, ?> zzmuVar = this.zzb;
            zzmuVar.zza((zzmu<?, ?>) zzmuVar.zzd(t5), zznlVar);
        } else {
            android.support.v4.media.session.a.a(zzd.next().getKey());
            throw null;
        }
    }
}
