package com.google.android.gms.internal.measurement;

import android.os.Binder;

/* loaded from: classes.dex */
public abstract /* synthetic */ class zzho {
    public static <V> V zza(zzhn<V> zzhnVar) {
        try {
            return zzhnVar.zza();
        } catch (SecurityException unused) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return zzhnVar.zza();
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }
}
