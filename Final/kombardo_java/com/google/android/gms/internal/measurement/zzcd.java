package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class zzcd extends zzcn {
    private String zza;
    private zzcq zzb;
    private zzcp zzc;
    private byte zzd;

    @Override // com.google.android.gms.internal.measurement.zzcn
    final zzcn zza(zzcq zzcqVar) {
        if (zzcqVar != null) {
            this.zzb = zzcqVar;
            return this;
        }
        throw new NullPointerException("Null fileChecks");
    }

    public final zzcn zza(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzcn
    public final zzcn zza(zzcp zzcpVar) {
        if (zzcpVar != null) {
            this.zzc = zzcpVar;
            return this;
        }
        throw new NullPointerException("Null filePurpose");
    }

    @Override // com.google.android.gms.internal.measurement.zzcn
    public final zzcn zza(boolean z5) {
        this.zzd = (byte) (this.zzd | 1);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzcn
    public final zzco zza() {
        if (this.zzd == 1 && this.zza != null && this.zzb != null && this.zzc != null) {
            return new zzce(this.zza, this.zzb, this.zzc);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" fileOwner");
        }
        if ((1 & this.zzd) == 0) {
            sb.append(" hasDifferentDmaOwner");
        }
        if (this.zzb == null) {
            sb.append(" fileChecks");
        }
        if (this.zzc == null) {
            sb.append(" filePurpose");
        }
        throw new IllegalStateException("Missing required properties:" + String.valueOf(sb));
    }
}
