package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class zzjn extends zziv {
    private static final Logger zzb = Logger.getLogger(zzjn.class.getName());
    private static final boolean zzc = zzmz.zzc();
    zzjp zza;

    /* loaded from: classes.dex */
    public static class zza extends IOException {
        zza() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zza(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        private zza(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }

        zza(int i5, int i6, int i7, Throwable th) {
            this(i5, i6, i7, th);
        }

        private zza(long j5, long j6, int i5, Throwable th) {
            this(String.format(Locale.US, "Pos: %d, limit: %d, len: %d", Long.valueOf(j5), Long.valueOf(j6), Integer.valueOf(i5)), th);
        }
    }

    /* loaded from: classes.dex */
    private static class zzb extends zzjn {
        private final byte[] zzb;
        private final int zzc;
        private int zzd;

        zzb(byte[] bArr, int i5, int i6) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            if (((bArr.length - i6) | i6) < 0) {
                throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i6)));
            }
            this.zzb = bArr;
            this.zzd = 0;
            this.zzc = i6;
        }

        private final void zzc(byte[] bArr, int i5, int i6) {
            try {
                System.arraycopy(bArr, i5, this.zzb, this.zzd, i6);
                this.zzd += i6;
            } catch (IndexOutOfBoundsException e5) {
                throw new zza(this.zzd, this.zzc, i6, (Throwable) e5);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final int zza() {
            return this.zzc - this.zzd;
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzb(int i5, boolean z5) {
            zzj(i5, 0);
            zza(z5 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzd(int i5, zziy zziyVar) {
            zzj(1, 3);
            zzk(2, i5);
            zzc(3, zziyVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzf(int i5, long j5) {
            zzj(i5, 1);
            zzf(j5);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzg(int i5, int i6) {
            zzj(i5, 5);
            zzh(i6);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzh(int i5) {
            int i6 = this.zzd;
            try {
                byte[] bArr = this.zzb;
                bArr[i6] = (byte) i5;
                bArr[i6 + 1] = (byte) (i5 >> 8);
                bArr[i6 + 2] = (byte) (i5 >> 16);
                bArr[i6 + 3] = i5 >> 24;
                this.zzd = i6 + 4;
            } catch (IndexOutOfBoundsException e5) {
                throw new zza(i6, this.zzc, 4, (Throwable) e5);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzi(int i5) {
            if (i5 >= 0) {
                zzk(i5);
            } else {
                zzh(i5);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzj(int i5, int i6) {
            zzk((i5 << 3) | i6);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzk(int i5, int i6) {
            zzj(i5, 0);
            zzk(i6);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zza(byte b5) {
            int i5 = this.zzd;
            try {
                int i6 = i5 + 1;
                try {
                    this.zzb[i5] = b5;
                    this.zzd = i6;
                } catch (IndexOutOfBoundsException e5) {
                    e = e5;
                    i5 = i6;
                    throw new zza(i5, this.zzc, 1, (Throwable) e);
                }
            } catch (IndexOutOfBoundsException e6) {
                e = e6;
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzb(zziy zziyVar) {
            zzk(zziyVar.zzb());
            zziyVar.zza(this);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzf(long j5) {
            int i5 = this.zzd;
            try {
                byte[] bArr = this.zzb;
                bArr[i5] = (byte) j5;
                bArr[i5 + 1] = (byte) (j5 >> 8);
                bArr[i5 + 2] = (byte) (j5 >> 16);
                bArr[i5 + 3] = (byte) (j5 >> 24);
                bArr[i5 + 4] = (byte) (j5 >> 32);
                bArr[i5 + 5] = (byte) (j5 >> 40);
                bArr[i5 + 6] = (byte) (j5 >> 48);
                bArr[i5 + 7] = (byte) (j5 >> 56);
                this.zzd = i5 + 8;
            } catch (IndexOutOfBoundsException e5) {
                throw new zza(i5, this.zzc, 8, (Throwable) e5);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzk(int i5) {
            int i6;
            int i7 = this.zzd;
            while ((i5 & (-128)) != 0) {
                try {
                    i6 = i7 + 1;
                    try {
                        this.zzb[i7] = (byte) (i5 | 128);
                        i5 >>>= 7;
                        i7 = i6;
                    } catch (IndexOutOfBoundsException e5) {
                        e = e5;
                        i7 = i6;
                        throw new zza(i7, this.zzc, 1, (Throwable) e);
                    }
                } catch (IndexOutOfBoundsException e6) {
                    e = e6;
                    throw new zza(i7, this.zzc, 1, (Throwable) e);
                }
            }
            i6 = i7 + 1;
            this.zzb[i7] = (byte) i5;
            this.zzd = i6;
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzc(int i5, zziy zziyVar) {
            zzj(i5, 2);
            zzb(zziyVar);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzb(int i5, zzlm zzlmVar) {
            zzj(1, 3);
            zzk(2, i5);
            zzj(3, 2);
            zzc(zzlmVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zziv
        public final void zza(byte[] bArr, int i5, int i6) {
            zzc(bArr, i5, i6);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        final void zzc(int i5, zzlm zzlmVar, zzme zzmeVar) {
            zzj(i5, 2);
            zzk(((zzio) zzlmVar).zza(zzmeVar));
            zzmeVar.zza((zzme) zzlmVar, (zznl) this.zza);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzh(int i5, int i6) {
            zzj(i5, 0);
            zzi(i6);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzc(zzlm zzlmVar) {
            zzk(zzlmVar.zzcf());
            zzlmVar.zza(this);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzb(int i5, String str) {
            zzj(i5, 2);
            zzb(str);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzh(int i5, long j5) {
            zzj(i5, 0);
            zzh(j5);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzb(String str) {
            int i5 = this.zzd;
            try {
                int zzg = zzjn.zzg(str.length() * 3);
                int zzg2 = zzjn.zzg(str.length());
                if (zzg2 == zzg) {
                    int i6 = i5 + zzg2;
                    this.zzd = i6;
                    int zza = zzna.zza(str, this.zzb, i6, zza());
                    this.zzd = i5;
                    zzk((zza - i5) - zzg2);
                    this.zzd = zza;
                    return;
                }
                zzk(zzna.zza(str));
                this.zzd = zzna.zza(str, this.zzb, this.zzd, zza());
            } catch (zznd e5) {
                this.zzd = i5;
                zza(str, e5);
            } catch (IndexOutOfBoundsException e6) {
                throw new zza(e6);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzh(long j5) {
            int i5;
            int i6;
            int i7 = this.zzd;
            if (zzjn.zzc && zza() >= 10) {
                while ((j5 & (-128)) != 0) {
                    zzmz.zza(this.zzb, i7, (byte) (((int) j5) | 128));
                    j5 >>>= 7;
                    i7++;
                }
                i5 = i7 + 1;
                zzmz.zza(this.zzb, i7, (byte) j5);
            } else {
                while ((j5 & (-128)) != 0) {
                    try {
                        i6 = i7 + 1;
                    } catch (IndexOutOfBoundsException e5) {
                        e = e5;
                    }
                    try {
                        this.zzb[i7] = (byte) (((int) j5) | 128);
                        j5 >>>= 7;
                        i7 = i6;
                    } catch (IndexOutOfBoundsException e6) {
                        e = e6;
                        i7 = i6;
                        throw new zza(i7, this.zzc, 1, (Throwable) e);
                    }
                }
                i5 = i7 + 1;
                try {
                    this.zzb[i7] = (byte) j5;
                } catch (IndexOutOfBoundsException e7) {
                    e = e7;
                    i7 = i5;
                    throw new zza(i7, this.zzc, 1, (Throwable) e);
                }
            }
            this.zzd = i5;
        }
    }

    public static int zza(double d5) {
        return 8;
    }

    public static int zzb(int i5) {
        return 4;
    }

    public static int zzc(long j5) {
        return 8;
    }

    public static int zzd(int i5) {
        return 4;
    }

    public static int zze(int i5, int i6) {
        return zzg(i5 << 3) + zzg(zzl(i6));
    }

    public static int zzf(int i5) {
        return zzg(i5 << 3);
    }

    public static int zzg(int i5) {
        return (352 - (Integer.numberOfLeadingZeros(i5) * 9)) >>> 6;
    }

    private static long zzi(long j5) {
        return (j5 >> 63) ^ (j5 << 1);
    }

    private static int zzl(int i5) {
        return (i5 >> 31) ^ (i5 << 1);
    }

    public abstract int zza();

    public abstract void zza(byte b5);

    public abstract void zzb(int i5, zzlm zzlmVar);

    public abstract void zzb(int i5, String str);

    public abstract void zzb(int i5, boolean z5);

    public abstract void zzb(zziy zziyVar);

    public abstract void zzb(String str);

    public abstract void zzc(int i5, zziy zziyVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzc(int i5, zzlm zzlmVar, zzme zzmeVar);

    public abstract void zzc(zzlm zzlmVar);

    public abstract void zzd(int i5, zziy zziyVar);

    public abstract void zzf(int i5, long j5);

    public abstract void zzf(long j5);

    public abstract void zzg(int i5, int i6);

    public abstract void zzh(int i5);

    public abstract void zzh(int i5, int i6);

    public abstract void zzh(int i5, long j5);

    public abstract void zzh(long j5);

    public abstract void zzi(int i5);

    public final void zzj(int i5) {
        zzk(zzl(i5));
    }

    public abstract void zzj(int i5, int i6);

    public abstract void zzk(int i5);

    public abstract void zzk(int i5, int i6);

    private zzjn() {
    }

    public static int zza(float f5) {
        return 4;
    }

    public static int zzb(int i5, int i6) {
        return zzg(i5 << 3) + 4;
    }

    public static int zzd(int i5, int i6) {
        return zzg(i5 << 3) + 4;
    }

    public static int zzf(int i5, int i6) {
        return zzg(i5 << 3) + zzg(i6);
    }

    public final void zzg(int i5, long j5) {
        zzh(i5, zzi(j5));
    }

    public final void zzi(int i5, int i6) {
        zzk(i5, zzl(i6));
    }

    public static int zza(long j5) {
        return 8;
    }

    public static int zzb(int i5, long j5) {
        return zzg(i5 << 3) + zze(j5);
    }

    public static int zzc(int i5, int i6) {
        return zzg(i5 << 3) + zze(i6);
    }

    public static int zzd(int i5, long j5) {
        return zzg(i5 << 3) + zze(zzi(j5));
    }

    public static int zze(int i5) {
        return zzg(zzl(i5));
    }

    public final void zzg(long j5) {
        zzh(zzi(j5));
    }

    public static int zza(boolean z5) {
        return 1;
    }

    public static int zze(int i5, long j5) {
        return zzg(i5 << 3) + zze(j5);
    }

    public static int zza(int i5, boolean z5) {
        return zzg(i5 << 3) + 1;
    }

    public static int zzb(long j5) {
        return zze(j5);
    }

    public static int zzc(int i5) {
        return zze(i5);
    }

    public static int zzd(long j5) {
        return zze(zzi(j5));
    }

    public static int zza(byte[] bArr) {
        int length = bArr.length;
        return zzg(length) + length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i5, zzlm zzlmVar, zzme zzmeVar) {
        return zzg(i5 << 3) + zza(zzlmVar, zzmeVar);
    }

    public static int zzc(int i5, long j5) {
        return zzg(i5 << 3) + 8;
    }

    public static int zze(long j5) {
        return (640 - (Long.numberOfLeadingZeros(j5) * 9)) >>> 6;
    }

    public static int zza(int i5, zziy zziyVar) {
        int zzg = zzg(i5 << 3);
        int zzb2 = zziyVar.zzb();
        return zzg + zzg(zzb2) + zzb2;
    }

    public static int zzb(zzlm zzlmVar) {
        int zzcf = zzlmVar.zzcf();
        return zzg(zzcf) + zzcf;
    }

    public static int zzb(int i5, zziy zziyVar) {
        return (zzg(8) << 1) + zzf(2, i5) + zza(3, zziyVar);
    }

    public static int zza(zziy zziyVar) {
        int zzb2 = zziyVar.zzb();
        return zzg(zzb2) + zzb2;
    }

    public static int zza(int i5, double d5) {
        return zzg(i5 << 3) + 8;
    }

    public static zzjn zzb(byte[] bArr) {
        return new zzb(bArr, 0, bArr.length);
    }

    public static int zza(int i5, int i6) {
        return zzg(i5 << 3) + zze(i6);
    }

    public final void zzb() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public static int zza(int i5) {
        return zze(i5);
    }

    public static int zza(int i5, long j5) {
        return zzg(i5 << 3) + 8;
    }

    public final void zzb(boolean z5) {
        zza(z5 ? (byte) 1 : (byte) 0);
    }

    public static int zza(int i5, float f5) {
        return zzg(i5 << 3) + 4;
    }

    public final void zzb(int i5, double d5) {
        zzf(i5, Double.doubleToRawLongBits(d5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int zza(int i5, zzlm zzlmVar, zzme zzmeVar) {
        return (zzg(i5 << 3) << 1) + ((zzio) zzlmVar).zza(zzmeVar);
    }

    public final void zzb(double d5) {
        zzf(Double.doubleToRawLongBits(d5));
    }

    public final void zzb(int i5, float f5) {
        zzg(i5, Float.floatToRawIntBits(f5));
    }

    @Deprecated
    public static int zza(zzlm zzlmVar) {
        return zzlmVar.zzcf();
    }

    public final void zzb(float f5) {
        zzh(Float.floatToRawIntBits(f5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzlm zzlmVar, zzme zzmeVar) {
        int zza2 = ((zzio) zzlmVar).zza(zzmeVar);
        return zzg(zza2) + zza2;
    }

    public static int zza(int i5, String str) {
        return zzg(i5 << 3) + zza(str);
    }

    public static int zza(String str) {
        int length;
        try {
            length = zzna.zza(str);
        } catch (zznd unused) {
            length = str.getBytes(zzkj.zza).length;
        }
        return zzg(length) + length;
    }

    final void zza(String str, zznd zzndVar) {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzndVar);
        byte[] bytes = str.getBytes(zzkj.zza);
        try {
            zzk(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e5) {
            throw new zza(e5);
        }
    }
}
