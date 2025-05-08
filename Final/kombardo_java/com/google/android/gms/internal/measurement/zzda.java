package com.google.android.gms.internal.measurement;

import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes.dex */
public abstract class zzda {
    private static zzda zza = new zzcz();

    public static synchronized zzda zza() {
        zzda zzdaVar;
        synchronized (zzda.class) {
            zzdaVar = zza;
        }
        return zzdaVar;
    }

    public abstract URLConnection zza(URL url, String str);
}
