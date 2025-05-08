package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Looper;

/* loaded from: classes.dex */
public final class zzaf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaf(Context context) {
    }

    public static boolean zza() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
