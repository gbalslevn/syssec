package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
abstract /* synthetic */ class zzbj {
    static final /* synthetic */ int[] zza;

    static {
        int[] iArr = new int[zzbv.values().length];
        zza = iArr;
        try {
            iArr[zzbv.AND.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zza[zzbv.NOT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            zza[zzbv.OR.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
