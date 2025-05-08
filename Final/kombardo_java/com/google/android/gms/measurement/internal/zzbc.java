package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
abstract /* synthetic */ class zzbc {
    static final /* synthetic */ int[] zza;

    static {
        int[] iArr = new int[zzjm.values().length];
        zza = iArr;
        try {
            iArr[zzjm.UNINITIALIZED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zza[zzjm.POLICY.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            zza[zzjm.DENIED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            zza[zzjm.GRANTED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
