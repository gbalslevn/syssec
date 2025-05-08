package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzjj extends zzjk {
    private final byte[] zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    private final void zzab() {
        int i5 = this.zze + this.zzf;
        this.zze = i5;
        int i6 = i5 - this.zzh;
        int i7 = this.zzj;
        if (i6 <= i7) {
            this.zzf = 0;
            return;
        }
        int i8 = i6 - i7;
        this.zzf = i8;
        this.zze = i5 - i8;
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final int zza(int i5) {
        if (i5 < 0) {
            throw zzkp.zzf();
        }
        int zzc = i5 + zzc();
        if (zzc < 0) {
            throw zzkp.zzg();
        }
        int i6 = this.zzj;
        if (zzc > i6) {
            throw zzkp.zzi();
        }
        this.zzj = zzc;
        zzab();
        return i6;
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final int zzc() {
        return this.zzg - this.zzh;
    }

    private zzjj(byte[] bArr, int i5, int i6, boolean z5) {
        super();
        this.zzj = Integer.MAX_VALUE;
        this.zzd = bArr;
        this.zze = i6 + i5;
        this.zzg = i5;
        this.zzh = i5;
    }
}
