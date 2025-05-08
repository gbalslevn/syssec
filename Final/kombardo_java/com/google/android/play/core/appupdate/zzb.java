package com.google.android.play.core.appupdate;

import android.content.Context;

/* loaded from: classes.dex */
public abstract class zzb {
    private static zza zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized zza zza(Context context) {
        zza zzaVar;
        synchronized (zzb.class) {
            try {
                if (zza == null) {
                    zzab zzabVar = new zzab(null);
                    zzabVar.zzb(new zzi(com.google.android.play.core.appupdate.internal.zzz.zza(context)));
                    zza = zzabVar.zza();
                }
                zzaVar = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzaVar;
    }
}
