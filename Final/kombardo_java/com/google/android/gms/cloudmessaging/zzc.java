package com.google.android.gms.cloudmessaging;

import android.util.Log;
import java.util.Objects;

/* loaded from: classes.dex */
public final class zzc extends ClassLoader {
    @Override // java.lang.ClassLoader
    protected final Class loadClass(String str, boolean z5) {
        if (!Objects.equals(str, "com.google.android.gms.iid.MessengerCompat")) {
            return super.loadClass(str, z5);
        }
        if (!Log.isLoggable("CloudMessengerCompat", 3)) {
            return zzd.class;
        }
        Log.d("CloudMessengerCompat", "Using renamed FirebaseIidMessengerCompat class");
        return zzd.class;
    }
}
