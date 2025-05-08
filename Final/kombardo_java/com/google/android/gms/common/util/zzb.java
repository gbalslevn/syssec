package com.google.android.gms.common.util;

import android.os.StrictMode;

/* loaded from: classes.dex */
abstract class zzb {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static StrictMode.VmPolicy.Builder zza(StrictMode.VmPolicy.Builder builder) {
        StrictMode.VmPolicy.Builder permitUnsafeIntentLaunch;
        permitUnsafeIntentLaunch = builder.permitUnsafeIntentLaunch();
        return permitUnsafeIntentLaunch;
    }
}
