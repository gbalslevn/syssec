package com.google.android.play.core.appupdate.internal;

import android.content.Context;

/* loaded from: classes.dex */
public abstract class zzz {
    public static Context zza(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }
}
