package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class zzjf extends zzjg {
    protected final byte[] zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjf(byte[] bArr) {
        super();
        bArr.getClass();
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.zziy
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zziy) || zzb() != ((zziy) obj).zzb()) {
            return false;
        }
        if (zzb() == 0) {
            return true;
        }
        if (!(obj instanceof zzjf)) {
            return obj.equals(this);
        }
        zzjf zzjfVar = (zzjf) obj;
        int zza = zza();
        int zza2 = zzjfVar.zza();
        if (zza == 0 || zza2 == 0 || zza == zza2) {
            return zza(zzjfVar, 0, zzb());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zziy
    public byte zza(int i5) {
        return this.zzb[i5];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zziy
    public byte zzb(int i5) {
        return this.zzb[i5];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zziy
    public final zziy zza(int i5, int i6) {
        int zza = zziy.zza(0, i6, zzb());
        if (zza == 0) {
            return zziy.zza;
        }
        return new zzjc(this.zzb, zzc(), zza);
    }

    @Override // com.google.android.gms.internal.measurement.zziy
    protected final int zzb(int i5, int i6, int i7) {
        return zzkj.zza(i5, this.zzb, zzc(), i7);
    }

    @Override // com.google.android.gms.internal.measurement.zziy
    public int zzb() {
        return this.zzb.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zziy
    public final void zza(zziv zzivVar) {
        zzivVar.zza(this.zzb, zzc(), zzb());
    }

    @Override // com.google.android.gms.internal.measurement.zzjg
    final boolean zza(zziy zziyVar, int i5, int i6) {
        if (i6 <= zziyVar.zzb()) {
            if (i6 <= zziyVar.zzb()) {
                if (zziyVar instanceof zzjf) {
                    zzjf zzjfVar = (zzjf) zziyVar;
                    byte[] bArr = this.zzb;
                    byte[] bArr2 = zzjfVar.zzb;
                    int zzc = zzc() + i6;
                    int zzc2 = zzc();
                    int zzc3 = zzjfVar.zzc();
                    while (zzc2 < zzc) {
                        if (bArr[zzc2] != bArr2[zzc3]) {
                            return false;
                        }
                        zzc2++;
                        zzc3++;
                    }
                    return true;
                }
                return zziyVar.zza(0, i6).equals(zza(0, i6));
            }
            throw new IllegalArgumentException("Ran off end of other: 0, " + i6 + ", " + zziyVar.zzb());
        }
        throw new IllegalArgumentException("Length too large: " + i6 + zzb());
    }
}
