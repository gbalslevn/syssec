package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
enum zzam {
    UNSET('0'),
    REMOTE_DEFAULT('1'),
    REMOTE_DELEGATION('2'),
    MANIFEST('3'),
    INITIALIZATION('4'),
    API('5'),
    CHILD_ACCOUNT('6'),
    TCF('7'),
    REMOTE_ENFORCED_DEFAULT('8'),
    FAILSAFE('9');

    private final char zzl;

    zzam(char c5) {
        this.zzl = c5;
    }

    public static zzam zza(char c5) {
        for (zzam zzamVar : values()) {
            if (zzamVar.zzl == c5) {
                return zzamVar;
            }
        }
        return UNSET;
    }
}
