package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class zzce extends zzco {
    private final String zzc;
    private final boolean zzd;
    private final zzcq zze;
    private final zzcc zzf;
    private final zzcb zzg;
    private final zzcp zzh;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzco) {
            zzco zzcoVar = (zzco) obj;
            if (this.zzc.equals(zzcoVar.zze()) && this.zzd == zzcoVar.zzf() && this.zze.equals(zzcoVar.zzc())) {
                zzcoVar.zza();
                zzcoVar.zzb();
                if (this.zzh.equals(zzcoVar.zzd())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.zzc.hashCode() ^ 1000003) * 1000003) ^ (this.zzd ? 1231 : 1237)) * 1000003) ^ this.zze.hashCode()) * 583896283) ^ this.zzh.hashCode();
    }

    public final String toString() {
        return "FileComplianceOptions{fileOwner=" + this.zzc + ", hasDifferentDmaOwner=" + this.zzd + ", fileChecks=" + String.valueOf(this.zze) + ", dataForwardingNotAllowedResolver=null, multipleProductIdGroupsResolver=null, filePurpose=" + String.valueOf(this.zzh) + "}";
    }

    @Override // com.google.android.gms.internal.measurement.zzco
    public final zzcc zza() {
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.zzco
    public final zzcb zzb() {
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.zzco
    public final zzcq zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.measurement.zzco
    public final zzcp zzd() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.measurement.zzco
    public final String zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzco
    public final boolean zzf() {
        return this.zzd;
    }

    private zzce(String str, boolean z5, zzcq zzcqVar, zzcc zzccVar, zzcb zzcbVar, zzcp zzcpVar) {
        this.zzc = str;
        this.zzd = z5;
        this.zze = zzcqVar;
        this.zzh = zzcpVar;
    }
}
