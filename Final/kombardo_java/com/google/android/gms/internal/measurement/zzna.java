package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zzna {
    private static final zznb zza;

    static {
        if (zzmz.zzc()) {
            zzmz.zzd();
        }
        zza = new zzne();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int zza(byte[] bArr, int i5, int i6) {
        byte b5 = bArr[i5 - 1];
        int i7 = i6 - i5;
        if (i7 == 0) {
            if (b5 > -12) {
                return -1;
            }
            return b5;
        }
        if (i7 == 1) {
            byte b6 = bArr[i5];
            if (b5 > -12 || b6 > -65) {
                return -1;
            }
            return (b6 << 8) ^ b5;
        }
        if (i7 == 2) {
            byte b7 = bArr[i5];
            byte b8 = bArr[i5 + 1];
            if (b5 > -12 || b7 > -65 || b8 > -65) {
                return -1;
            }
            return (b8 << 16) ^ ((b7 << 8) ^ b5);
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzb(byte[] bArr, int i5, int i6) {
        return zza.zza(bArr, i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzc(byte[] bArr, int i5, int i6) {
        return zza.zza(0, bArr, i5, i6) == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(String str, byte[] bArr, int i5, int i6) {
        return zza.zza(str, bArr, i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(String str) {
        int length = str.length();
        int i5 = 0;
        int i6 = 0;
        while (i6 < length && str.charAt(i6) < 128) {
            i6++;
        }
        int i7 = length;
        while (true) {
            if (i6 >= length) {
                break;
            }
            char charAt = str.charAt(i6);
            if (charAt < 2048) {
                i7 += (127 - charAt) >>> 31;
                i6++;
            } else {
                int length2 = str.length();
                while (i6 < length2) {
                    char charAt2 = str.charAt(i6);
                    if (charAt2 < 2048) {
                        i5 += (127 - charAt2) >>> 31;
                    } else {
                        i5 += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(str, i6) < 65536) {
                                throw new zznd(i6, length2);
                            }
                            i6++;
                        }
                    }
                    i6++;
                }
                i7 += i5;
            }
        }
        if (i7 >= length) {
            return i7;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i7 + 4294967296L));
    }
}
