package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzla implements zzmh {
    private static final zzln zza = new zzld();
    private final zzln zzb;

    public zzla() {
        this(new zzlf(zzke.zza(), zza));
    }

    @Override // com.google.android.gms.internal.measurement.zzmh
    public final <T> zzme<T> zza(Class<T> cls) {
        zzmg.zza((Class<?>) cls);
        zzlk zza2 = this.zzb.zza(cls);
        if (zza2.zzc()) {
            return zzls.zza(zzmg.zza(), zzjx.zza(), zza2.zza());
        }
        return zzlq.zza(cls, zza2, zzlw.zza(), zzky.zza(), zzmg.zza(), zzlc.zza[zza2.zzb().ordinal()] != 1 ? zzjx.zza() : null, zzll.zza());
    }

    private zzla(zzln zzlnVar) {
        this.zzb = (zzln) zzkj.zza(zzlnVar, "messageInfoFactory");
    }
}
