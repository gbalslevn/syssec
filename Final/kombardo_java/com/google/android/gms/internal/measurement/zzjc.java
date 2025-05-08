package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class zzjc extends zzjf {
    private final int zzc;
    private final int zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjc(byte[] bArr, int i5, int i6) {
        super(bArr);
        zziy.zza(i5, i5 + i6, bArr.length);
        this.zzc = i5;
        this.zzd = i6;
    }

    @Override // com.google.android.gms.internal.measurement.zzjf, com.google.android.gms.internal.measurement.zziy
    public final byte zza(int i5) {
        int zzb = zzb();
        if (((zzb - (i5 + 1)) | i5) >= 0) {
            return this.zzb[this.zzc + i5];
        }
        if (i5 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i5);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i5 + ", " + zzb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzjf, com.google.android.gms.internal.measurement.zziy
    public final byte zzb(int i5) {
        return this.zzb[this.zzc + i5];
    }

    @Override // com.google.android.gms.internal.measurement.zzjf
    protected final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzjf, com.google.android.gms.internal.measurement.zziy
    public final int zzb() {
        return this.zzd;
    }
}
