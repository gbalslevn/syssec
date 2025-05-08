package com.google.android.gms.internal.measurement;

import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zziu {
    private static volatile int zza = 100;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double zza(byte[] bArr, int i5) {
        return Double.longBitsToDouble(zzd(bArr, i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float zzb(byte[] bArr, int i5) {
        return Float.intBitsToFloat(zzc(bArr, i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(byte[] bArr, int i5) {
        return ((bArr[i5 + 3] & 255) << 24) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(byte[] bArr, int i5, zzit zzitVar) {
        int i6 = i5 + 1;
        long j5 = bArr[i5];
        if (j5 >= 0) {
            zzitVar.zzb = j5;
            return i6;
        }
        int i7 = i5 + 2;
        byte b5 = bArr[i6];
        long j6 = (j5 & 127) | ((b5 & Byte.MAX_VALUE) << 7);
        int i8 = 7;
        while (b5 < 0) {
            int i9 = i7 + 1;
            i8 += 7;
            j6 |= (r10 & Byte.MAX_VALUE) << i8;
            b5 = bArr[i7];
            i7 = i9;
        }
        zzitVar.zzb = j6;
        return i7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i5, zzit zzitVar) {
        int zzc = zzc(bArr, i5, zzitVar);
        int i6 = zzitVar.zza;
        if (i6 >= 0) {
            if (i6 > bArr.length - zzc) {
                throw zzkp.zzi();
            }
            if (i6 == 0) {
                zzitVar.zzc = zziy.zza;
                return zzc;
            }
            zzitVar.zzc = zziy.zza(bArr, zzc, i6);
            return zzc + i6;
        }
        throw zzkp.zzf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(zzme<?> zzmeVar, int i5, byte[] bArr, int i6, int i7, zzkm<?> zzkmVar, zzit zzitVar) {
        int zza2 = zza(zzmeVar, bArr, i6, i7, zzitVar);
        zzkmVar.add(zzitVar.zzc);
        while (zza2 < i7) {
            int zzc = zzc(bArr, zza2, zzitVar);
            if (i5 != zzitVar.zza) {
                break;
            }
            zza2 = zza(zzmeVar, bArr, zzc, i7, zzitVar);
            zzkmVar.add(zzitVar.zzc);
        }
        return zza2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(byte[] bArr, int i5, zzit zzitVar) {
        int i6 = i5 + 1;
        byte b5 = bArr[i5];
        if (b5 >= 0) {
            zzitVar.zza = b5;
            return i6;
        }
        return zza(b5, bArr, i6, zzitVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzd(byte[] bArr, int i5) {
        return ((bArr[i5 + 7] & 255) << 56) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16) | ((bArr[i5 + 3] & 255) << 24) | ((bArr[i5 + 4] & 255) << 32) | ((bArr[i5 + 5] & 255) << 40) | ((bArr[i5 + 6] & 255) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i5, zzit zzitVar) {
        int zzc = zzc(bArr, i5, zzitVar);
        int i6 = zzitVar.zza;
        if (i6 < 0) {
            throw zzkp.zzf();
        }
        if (i6 == 0) {
            zzitVar.zzc = BuildConfig.FLAVOR;
            return zzc;
        }
        zzitVar.zzc = zzna.zzb(bArr, zzc, i6);
        return zzc + i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i5, byte[] bArr, int i6, int i7, Object obj, zzlm zzlmVar, zzmu<zzmx, zzmx> zzmuVar, zzit zzitVar) {
        zzitVar.zzd.zza(zzlmVar, i5 >>> 3);
        return zza(i5, bArr, i6, i7, zzlq.zzc(obj), zzitVar);
    }

    private static <T> int zza(zzme<T> zzmeVar, byte[] bArr, int i5, int i6, int i7, zzit zzitVar) {
        T zza2 = zzmeVar.zza();
        int zza3 = zza(zza2, zzmeVar, bArr, i5, i6, i7, zzitVar);
        zzmeVar.zzd(zza2);
        zzitVar.zzc = zza2;
        return zza3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzme<?> zzmeVar, int i5, byte[] bArr, int i6, int i7, zzkm<Object> zzkmVar, zzit zzitVar) {
        int i8 = (i5 & (-8)) | 4;
        int zza2 = zza(zzmeVar, bArr, i6, i7, i8, zzitVar);
        zzkmVar.add(zzitVar.zzc);
        while (zza2 < i7) {
            int zzc = zzc(bArr, zza2, zzitVar);
            if (i5 != zzitVar.zza) {
                break;
            }
            zza2 = zza(zzmeVar, bArr, zzc, i7, i8, zzitVar);
            zzkmVar.add(zzitVar.zzc);
        }
        return zza2;
    }

    static <T> int zza(zzme<T> zzmeVar, byte[] bArr, int i5, int i6, zzit zzitVar) {
        T zza2 = zzmeVar.zza();
        int zza3 = zza(zza2, zzmeVar, bArr, i5, i6, zzitVar);
        zzmeVar.zzd(zza2);
        zzitVar.zzc = zza2;
        return zza3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i5, zzkm<?> zzkmVar, zzit zzitVar) {
        zzkh zzkhVar = (zzkh) zzkmVar;
        int zzc = zzc(bArr, i5, zzitVar);
        int i6 = zzitVar.zza + zzc;
        while (zzc < i6) {
            zzc = zzc(bArr, zzc, zzitVar);
            zzkhVar.zzd(zzitVar.zza);
        }
        if (zzc == i6) {
            return zzc;
        }
        throw zzkp.zzi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i5, byte[] bArr, int i6, int i7, zzmx zzmxVar, zzit zzitVar) {
        if ((i5 >>> 3) == 0) {
            throw zzkp.zzc();
        }
        int i8 = i5 & 7;
        if (i8 == 0) {
            int zzd = zzd(bArr, i6, zzitVar);
            zzmxVar.zza(i5, Long.valueOf(zzitVar.zzb));
            return zzd;
        }
        if (i8 == 1) {
            zzmxVar.zza(i5, Long.valueOf(zzd(bArr, i6)));
            return i6 + 8;
        }
        if (i8 == 2) {
            int zzc = zzc(bArr, i6, zzitVar);
            int i9 = zzitVar.zza;
            if (i9 >= 0) {
                if (i9 > bArr.length - zzc) {
                    throw zzkp.zzi();
                }
                if (i9 == 0) {
                    zzmxVar.zza(i5, zziy.zza);
                } else {
                    zzmxVar.zza(i5, zziy.zza(bArr, zzc, i9));
                }
                return zzc + i9;
            }
            throw zzkp.zzf();
        }
        if (i8 != 3) {
            if (i8 == 5) {
                zzmxVar.zza(i5, Integer.valueOf(zzc(bArr, i6)));
                return i6 + 4;
            }
            throw zzkp.zzc();
        }
        zzmx zzd2 = zzmx.zzd();
        int i10 = (i5 & (-8)) | 4;
        int i11 = zzitVar.zze + 1;
        zzitVar.zze = i11;
        zza(i11);
        int i12 = 0;
        while (true) {
            if (i6 >= i7) {
                break;
            }
            int zzc2 = zzc(bArr, i6, zzitVar);
            int i13 = zzitVar.zza;
            i12 = i13;
            if (i13 == i10) {
                i6 = zzc2;
                break;
            }
            int zza2 = zza(i12, bArr, zzc2, i7, zzd2, zzitVar);
            i12 = i13;
            i6 = zza2;
        }
        zzitVar.zze--;
        if (i6 <= i7 && i12 == i10) {
            zzmxVar.zza(i5, zzd2);
            return i6;
        }
        throw zzkp.zzg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i5, byte[] bArr, int i6, zzit zzitVar) {
        int i7 = i5 & 127;
        int i8 = i6 + 1;
        byte b5 = bArr[i6];
        if (b5 >= 0) {
            zzitVar.zza = i7 | (b5 << 7);
            return i8;
        }
        int i9 = i7 | ((b5 & Byte.MAX_VALUE) << 7);
        int i10 = i6 + 2;
        byte b6 = bArr[i8];
        if (b6 >= 0) {
            zzitVar.zza = i9 | (b6 << 14);
            return i10;
        }
        int i11 = i9 | ((b6 & Byte.MAX_VALUE) << 14);
        int i12 = i6 + 3;
        byte b7 = bArr[i10];
        if (b7 >= 0) {
            zzitVar.zza = i11 | (b7 << 21);
            return i12;
        }
        int i13 = i11 | ((b7 & Byte.MAX_VALUE) << 21);
        int i14 = i6 + 4;
        byte b8 = bArr[i12];
        if (b8 >= 0) {
            zzitVar.zza = i13 | (b8 << 28);
            return i14;
        }
        int i15 = i13 | ((b8 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i16 = i14 + 1;
            if (bArr[i14] >= 0) {
                zzitVar.zza = i15;
                return i16;
            }
            i14 = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i5, byte[] bArr, int i6, int i7, zzkm<?> zzkmVar, zzit zzitVar) {
        zzkh zzkhVar = (zzkh) zzkmVar;
        int zzc = zzc(bArr, i6, zzitVar);
        zzkhVar.zzd(zzitVar.zza);
        while (zzc < i7) {
            int zzc2 = zzc(bArr, zzc, zzitVar);
            if (i5 != zzitVar.zza) {
                break;
            }
            zzc = zzc(bArr, zzc2, zzitVar);
            zzkhVar.zzd(zzitVar.zza);
        }
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> int zza(Object obj, zzme<T> zzmeVar, byte[] bArr, int i5, int i6, int i7, zzit zzitVar) {
        zzlq zzlqVar = (zzlq) zzmeVar;
        int i8 = zzitVar.zze + 1;
        zzitVar.zze = i8;
        zza(i8);
        int zza2 = zzlqVar.zza(obj, bArr, i5, i6, i7, zzitVar);
        zzitVar.zze--;
        zzitVar.zzc = obj;
        return zza2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> int zza(Object obj, zzme<T> zzmeVar, byte[] bArr, int i5, int i6, zzit zzitVar) {
        int i7 = i5 + 1;
        int i8 = bArr[i5];
        if (i8 < 0) {
            i7 = zza(i8, bArr, i7, zzitVar);
            i8 = zzitVar.zza;
        }
        int i9 = i7;
        if (i8 >= 0 && i8 <= i6 - i9) {
            int i10 = zzitVar.zze + 1;
            zzitVar.zze = i10;
            zza(i10);
            int i11 = i8 + i9;
            zzmeVar.zza(obj, bArr, i9, i11, zzitVar);
            zzitVar.zze--;
            zzitVar.zzc = obj;
            return i11;
        }
        throw zzkp.zzi();
    }

    private static void zza(int i5) {
        if (i5 >= zza) {
            throw zzkp.zzh();
        }
    }
}
