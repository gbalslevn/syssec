package com.google.android.gms.internal.identity;

/* loaded from: classes.dex */
public abstract class zzer {
    public static int zzc(int i5, int i6, String str) {
        String zza;
        if (i5 >= 0 && i5 < i6) {
            return i5;
        }
        if (i5 < 0) {
            zza = zzes.zza("%s (%s) must not be negative", "index", Integer.valueOf(i5));
        } else {
            if (i6 < 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(i6).length() + 15);
                sb.append("negative size: ");
                sb.append(i6);
                throw new IllegalArgumentException(sb.toString());
            }
            zza = zzes.zza("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i5), Integer.valueOf(i6));
        }
        throw new IndexOutOfBoundsException(zza);
    }

    public static int zzd(int i5, int i6, String str) {
        if (i5 < 0 || i5 > i6) {
            throw new IndexOutOfBoundsException(zzf(i5, i6, "index"));
        }
        return i5;
    }

    public static void zze(int i5, int i6, int i7) {
        if (i5 < 0 || i6 < i5 || i6 > i7) {
            throw new IndexOutOfBoundsException((i5 < 0 || i5 > i7) ? zzf(i5, i7, "start index") : (i6 < 0 || i6 > i7) ? zzf(i6, i7, "end index") : zzes.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i6), Integer.valueOf(i5)));
        }
    }

    private static String zzf(int i5, int i6, String str) {
        if (i5 < 0) {
            return zzes.zza("%s (%s) must not be negative", str, Integer.valueOf(i5));
        }
        if (i6 >= 0) {
            return zzes.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i5), Integer.valueOf(i6));
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i6).length() + 15);
        sb.append("negative size: ");
        sb.append(i6);
        throw new IllegalArgumentException(sb.toString());
    }
}
