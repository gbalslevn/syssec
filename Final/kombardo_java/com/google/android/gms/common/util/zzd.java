package com.google.android.gms.common.util;

import android.os.Looper;

/* loaded from: classes.dex */
public abstract class zzd {
    public static boolean zza() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
