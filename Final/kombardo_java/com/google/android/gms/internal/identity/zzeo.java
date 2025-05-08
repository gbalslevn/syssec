package com.google.android.gms.internal.identity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class zzeo {
    private static final SimpleDateFormat zza;
    private static final SimpleDateFormat zzb;
    private static final StringBuilder zzc;

    static {
        Locale locale = Locale.ROOT;
        zza = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", locale);
        zzb = new SimpleDateFormat("MM-dd HH:mm:ss", locale);
        zzc = new StringBuilder(33);
    }

    public static String zza(long j5) {
        return j5 >= 0 ? zza.format(new Date(j5)) : Long.toString(j5);
    }

    public static String zzb(long j5) {
        String sb;
        StringBuilder sb2 = zzc;
        synchronized (sb2) {
            sb2.setLength(0);
            zzc(j5, sb2);
            sb = sb2.toString();
        }
        return sb;
    }

    public static StringBuilder zzc(long j5, StringBuilder sb) {
        if (j5 == 0) {
            sb.append("0s");
            return sb;
        }
        sb.ensureCapacity(sb.length() + 27);
        boolean z5 = false;
        if (j5 < 0) {
            sb.append("-");
            if (j5 != Long.MIN_VALUE) {
                j5 = -j5;
            } else {
                j5 = Long.MAX_VALUE;
                z5 = true;
            }
        }
        if (j5 >= 86400000) {
            sb.append(j5 / 86400000);
            sb.append("d");
            j5 %= 86400000;
        }
        if (true == z5) {
            j5 = 25975808;
        }
        if (j5 >= 3600000) {
            sb.append(j5 / 3600000);
            sb.append("h");
            j5 %= 3600000;
        }
        if (j5 >= 60000) {
            sb.append(j5 / 60000);
            sb.append("m");
            j5 %= 60000;
        }
        if (j5 >= 1000) {
            sb.append(j5 / 1000);
            sb.append("s");
            j5 %= 1000;
        }
        if (j5 > 0) {
            sb.append(j5);
            sb.append("ms");
        }
        return sb;
    }
}
