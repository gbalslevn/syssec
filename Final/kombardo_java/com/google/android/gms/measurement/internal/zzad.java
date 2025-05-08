package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzfw$zzc;
import com.google.android.gms.internal.measurement.zzfw$zze;
import com.google.android.gms.internal.measurement.zzgf$zzp;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzad extends zzaa {
    private zzfw$zze zzg;
    private final /* synthetic */ zzx zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzad(zzx zzxVar, String str, int i5, zzfw$zze zzfw_zze) {
        super(str, i5);
        this.zzh = zzxVar;
        this.zzg = zzfw_zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzaa
    public final int zza() {
        return this.zzg.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzaa
    public final boolean zzb() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzaa
    public final boolean zzc() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean zza(Long l5, Long l6, zzgf$zzp zzgf_zzp, boolean z5) {
        Object[] objArr = com.google.android.gms.internal.measurement.zzoh.zza() && this.zzh.zze().zzf(this.zza, zzbn.zzbx);
        boolean zzf = this.zzg.zzf();
        boolean zzg = this.zzg.zzg();
        boolean zzh = this.zzg.zzh();
        Object[] objArr2 = zzf || zzg || zzh;
        Boolean bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        if (z5 && objArr2 == false) {
            this.zzh.zzj().zzq().zza("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.zzb), this.zzg.zzi() ? Integer.valueOf(this.zzg.zza()) : null);
            return true;
        }
        zzfw$zzc zzb = this.zzg.zzb();
        boolean zzf2 = zzb.zzf();
        if (zzgf_zzp.zzk()) {
            if (!zzb.zzh()) {
                this.zzh.zzj().zzr().zza("No number filter for long property. property", this.zzh.zzi().zzc(zzgf_zzp.zzg()));
            } else {
                bool = zzaa.zza(zzaa.zza(zzgf_zzp.zzc(), zzb.zzc()), zzf2);
            }
        } else if (zzgf_zzp.zzi()) {
            if (!zzb.zzh()) {
                this.zzh.zzj().zzr().zza("No number filter for double property. property", this.zzh.zzi().zzc(zzgf_zzp.zzg()));
            } else {
                bool = zzaa.zza(zzaa.zza(zzgf_zzp.zza(), zzb.zzc()), zzf2);
            }
        } else if (zzgf_zzp.zzm()) {
            if (!zzb.zzj()) {
                if (!zzb.zzh()) {
                    this.zzh.zzj().zzr().zza("No string or number filter defined. property", this.zzh.zzi().zzc(zzgf_zzp.zzg()));
                } else if (zzpj.zzb(zzgf_zzp.zzh())) {
                    bool = zzaa.zza(zzaa.zza(zzgf_zzp.zzh(), zzb.zzc()), zzf2);
                } else {
                    this.zzh.zzj().zzr().zza("Invalid user property value for Numeric number filter. property, value", this.zzh.zzi().zzc(zzgf_zzp.zzg()), zzgf_zzp.zzh());
                }
            } else {
                bool = zzaa.zza(zzaa.zza(zzgf_zzp.zzh(), zzb.zzd(), this.zzh.zzj()), zzf2);
            }
        } else {
            this.zzh.zzj().zzr().zza("User property has no value, property", this.zzh.zzi().zzc(zzgf_zzp.zzg()));
        }
        this.zzh.zzj().zzq().zza("Property filter result", bool == null ? "null" : bool);
        if (bool == null) {
            return false;
        }
        this.zzc = Boolean.TRUE;
        if (zzh && !bool.booleanValue()) {
            return true;
        }
        if (!z5 || this.zzg.zzf()) {
            this.zzd = bool;
        }
        if (bool.booleanValue() && objArr2 != false && zzgf_zzp.zzl()) {
            long zzd = zzgf_zzp.zzd();
            if (l5 != null) {
                zzd = l5.longValue();
            }
            if (objArr != false && this.zzg.zzf() && !this.zzg.zzg() && l6 != null) {
                zzd = l6.longValue();
            }
            if (this.zzg.zzg()) {
                this.zzf = Long.valueOf(zzd);
            } else {
                this.zze = Long.valueOf(zzd);
            }
        }
        return true;
    }
}
