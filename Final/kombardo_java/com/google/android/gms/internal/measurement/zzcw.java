package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.common.base.Preconditions;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public abstract class zzcw {
    private static final ThreadLocal<Boolean> zza = new zzcv();

    public static SharedPreferences zza(Context context, String str, int i5, zzco zzcoVar) {
        zzcr zzcrVar = zzcf.zza().zzb(str, zzcoVar, zzcl.SHARED_PREFS_TYPE).equals(BuildConfig.FLAVOR) ? new zzcr() : null;
        if (zzcrVar != null) {
            return zzcrVar;
        }
        ThreadLocal<Boolean> threadLocal = zza;
        Preconditions.checkArgument(threadLocal.get().booleanValue());
        threadLocal.set(Boolean.FALSE);
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            threadLocal.set(Boolean.TRUE);
            return sharedPreferences;
        } catch (Throwable th) {
            zza.set(Boolean.TRUE);
            throw th;
        }
    }
}
