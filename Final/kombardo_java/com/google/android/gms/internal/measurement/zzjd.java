package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzjd {
    private final zzjn zza;
    private final byte[] zzb;

    public final zziy zza() {
        this.zza.zzb();
        return new zzjf(this.zzb);
    }

    public final zzjn zzb() {
        return this.zza;
    }

    private zzjd(int i5) {
        byte[] bArr = new byte[i5];
        this.zzb = bArr;
        this.zza = zzjn.zzb(bArr);
    }
}
