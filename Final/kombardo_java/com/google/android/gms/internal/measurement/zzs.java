package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public enum zzs {
    DEBUG(3),
    ERROR(6),
    INFO(4),
    VERBOSE(2),
    WARN(5);

    zzs(int i5) {
    }

    public static zzs zza(int i5) {
        return i5 != 2 ? i5 != 3 ? i5 != 5 ? i5 != 6 ? INFO : ERROR : WARN : DEBUG : VERBOSE;
    }
}
