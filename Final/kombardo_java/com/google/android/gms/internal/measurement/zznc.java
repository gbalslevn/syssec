package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
abstract class zznc {
    private static boolean zza(byte b5) {
        return b5 > -65;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(byte b5, byte b6, byte b7, byte b8, char[] cArr, int i5) {
        if (!zza(b6) && (((b5 << 28) + (b6 + 112)) >> 30) == 0 && !zza(b7) && !zza(b8)) {
            int i6 = ((b5 & 7) << 18) | ((b6 & 63) << 12) | ((b7 & 63) << 6) | (b8 & 63);
            cArr[i5] = (char) ((i6 >>> 10) + 55232);
            cArr[i5 + 1] = (char) ((i6 & 1023) + 56320);
            return;
        }
        throw zzkp.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(byte b5, char[] cArr, int i5) {
        cArr[i5] = (char) b5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(byte b5, byte b6, byte b7, char[] cArr, int i5) {
        if (!zza(b6) && ((b5 != -32 || b6 >= -96) && ((b5 != -19 || b6 < -96) && !zza(b7)))) {
            cArr[i5] = (char) (((b5 & 15) << 12) | ((b6 & 63) << 6) | (b7 & 63));
            return;
        }
        throw zzkp.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(byte b5, byte b6, char[] cArr, int i5) {
        if (b5 >= -62 && !zza(b6)) {
            cArr[i5] = (char) (((b5 & 31) << 6) | (b6 & 63));
            return;
        }
        throw zzkp.zzd();
    }
}
