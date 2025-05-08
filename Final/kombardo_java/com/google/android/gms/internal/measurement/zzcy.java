package com.google.android.gms.internal.measurement;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* loaded from: classes.dex */
public abstract class zzcy {
    public static final int zza;

    static {
        zza = Build.VERSION.SDK_INT >= 31 ? 33554432 : 0;
    }

    public static PendingIntent zza(Context context, int i5, Intent intent, int i6) {
        return PendingIntent.getBroadcast(context, 0, intent, i6);
    }
}
