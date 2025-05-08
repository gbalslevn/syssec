package com.google.android.gms.common.util;

/* loaded from: classes.dex */
public abstract class Hex {
    private static final char[] zza = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char[] zzb = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String bytesToStringLowercase(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length + length];
        int i5 = 0;
        for (byte b5 : bArr) {
            char[] cArr2 = zzb;
            cArr[i5] = cArr2[(b5 & 255) >>> 4];
            cArr[i5 + 1] = cArr2[b5 & 15];
            i5 += 2;
        }
        return new String(cArr);
    }

    public static String bytesToStringUppercase(byte[] bArr, boolean z5) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (int i5 = 0; i5 < length && (!z5 || i5 != length - 1 || (bArr[i5] & 255) != 0); i5++) {
            char[] cArr = zza;
            sb.append(cArr[(bArr[i5] & 240) >>> 4]);
            sb.append(cArr[bArr[i5] & 15]);
        }
        return sb.toString();
    }
}
