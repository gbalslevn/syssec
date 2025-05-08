package com.google.android.gms.internal.measurement;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzmx {
    private static final zzmx zza = new zzmx(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzmx() {
        this(0, new int[8], new Object[8], true);
    }

    public static zzmx zzc() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzmx zzd() {
        return new zzmx();
    }

    private final void zzf() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzmx)) {
            return false;
        }
        zzmx zzmxVar = (zzmx) obj;
        int i5 = this.zzb;
        if (i5 == zzmxVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzmxVar.zzc;
            int i6 = 0;
            while (true) {
                if (i6 >= i5) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzmxVar.zzd;
                    int i7 = this.zzb;
                    for (int i8 = 0; i8 < i7; i8++) {
                        if (objArr[i8].equals(objArr2[i8])) {
                        }
                    }
                    return true;
                }
                if (iArr[i6] != iArr2[i6]) {
                    break;
                }
                i6++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i5 = this.zzb;
        int i6 = (i5 + 527) * 31;
        int[] iArr = this.zzc;
        int i7 = 17;
        int i8 = 17;
        for (int i9 = 0; i9 < i5; i9++) {
            i8 = (i8 * 31) + iArr[i9];
        }
        int i10 = (i6 + i8) * 31;
        Object[] objArr = this.zzd;
        int i11 = this.zzb;
        for (int i12 = 0; i12 < i11; i12++) {
            i7 = (i7 * 31) + objArr[i12].hashCode();
        }
        return i10 + i7;
    }

    public final int zza() {
        int zze;
        int i5 = this.zze;
        if (i5 != -1) {
            return i5;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.zzb; i7++) {
            int i8 = this.zzc[i7];
            int i9 = i8 >>> 3;
            int i10 = i8 & 7;
            if (i10 == 0) {
                zze = zzjn.zze(i9, ((Long) this.zzd[i7]).longValue());
            } else if (i10 == 1) {
                zze = zzjn.zza(i9, ((Long) this.zzd[i7]).longValue());
            } else if (i10 == 2) {
                zze = zzjn.zza(i9, (zziy) this.zzd[i7]);
            } else if (i10 == 3) {
                zze = (zzjn.zzf(i9) << 1) + ((zzmx) this.zzd[i7]).zza();
            } else if (i10 == 5) {
                zze = zzjn.zzb(i9, ((Integer) this.zzd[i7]).intValue());
            } else {
                throw new IllegalStateException(zzkp.zza());
            }
            i6 += zze;
        }
        this.zze = i6;
        return i6;
    }

    public final int zzb() {
        int i5 = this.zze;
        if (i5 != -1) {
            return i5;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.zzb; i7++) {
            i6 += zzjn.zzb(this.zzc[i7] >>> 3, (zziy) this.zzd[i7]);
        }
        this.zze = i6;
        return i6;
    }

    public final void zze() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    private zzmx(int i5, int[] iArr, Object[] objArr, boolean z5) {
        this.zze = -1;
        this.zzb = i5;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z5;
    }

    public final void zzb(zznl zznlVar) {
        if (this.zzb == 0) {
            return;
        }
        if (zznlVar.zza() == 1) {
            for (int i5 = 0; i5 < this.zzb; i5++) {
                zza(this.zzc[i5], this.zzd[i5], zznlVar);
            }
            return;
        }
        for (int i6 = this.zzb - 1; i6 >= 0; i6--) {
            zza(this.zzc[i6], this.zzd[i6], zznlVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzmx zza(zzmx zzmxVar) {
        if (zzmxVar.equals(zza)) {
            return this;
        }
        zzf();
        int i5 = this.zzb + zzmxVar.zzb;
        zza(i5);
        System.arraycopy(zzmxVar.zzc, 0, this.zzc, this.zzb, zzmxVar.zzb);
        System.arraycopy(zzmxVar.zzd, 0, this.zzd, this.zzb, zzmxVar.zzb);
        this.zzb = i5;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzmx zza(zzmx zzmxVar, zzmx zzmxVar2) {
        int i5 = zzmxVar.zzb + zzmxVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzmxVar.zzc, i5);
        System.arraycopy(zzmxVar2.zzc, 0, copyOf, zzmxVar.zzb, zzmxVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzmxVar.zzd, i5);
        System.arraycopy(zzmxVar2.zzd, 0, copyOf2, zzmxVar.zzb, zzmxVar2.zzb);
        return new zzmx(i5, copyOf, copyOf2, true);
    }

    private final void zza(int i5) {
        int[] iArr = this.zzc;
        if (i5 > iArr.length) {
            int i6 = this.zzb;
            int i7 = i6 + (i6 / 2);
            if (i7 >= i5) {
                i5 = i7;
            }
            if (i5 < 8) {
                i5 = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i5);
            this.zzd = Arrays.copyOf(this.zzd, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i5) {
        for (int i6 = 0; i6 < this.zzb; i6++) {
            zzlr.zza(sb, i5, String.valueOf(this.zzc[i6] >>> 3), this.zzd[i6]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(int i5, Object obj) {
        zzf();
        zza(this.zzb + 1);
        int[] iArr = this.zzc;
        int i6 = this.zzb;
        iArr[i6] = i5;
        this.zzd[i6] = obj;
        this.zzb = i6 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zznl zznlVar) {
        if (zznlVar.zza() == 2) {
            for (int i5 = this.zzb - 1; i5 >= 0; i5--) {
                zznlVar.zza(this.zzc[i5] >>> 3, this.zzd[i5]);
            }
            return;
        }
        for (int i6 = 0; i6 < this.zzb; i6++) {
            zznlVar.zza(this.zzc[i6] >>> 3, this.zzd[i6]);
        }
    }

    private static void zza(int i5, Object obj, zznl zznlVar) {
        int i6 = i5 >>> 3;
        int i7 = i5 & 7;
        if (i7 == 0) {
            zznlVar.zzb(i6, ((Long) obj).longValue());
            return;
        }
        if (i7 == 1) {
            zznlVar.zza(i6, ((Long) obj).longValue());
            return;
        }
        if (i7 == 2) {
            zznlVar.zza(i6, (zziy) obj);
            return;
        }
        if (i7 != 3) {
            if (i7 == 5) {
                zznlVar.zzb(i6, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzkp.zza());
        }
        if (zznlVar.zza() == 1) {
            zznlVar.zzb(i6);
            ((zzmx) obj).zzb(zznlVar);
            zznlVar.zza(i6);
        } else {
            zznlVar.zza(i6);
            ((zzmx) obj).zzb(zznlVar);
            zznlVar.zzb(i6);
        }
    }
}
