package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class zzdm extends zzdp {
    private final AtomicReference<Bundle> zza = new AtomicReference<>();
    private boolean zzb;

    public final Bundle zza(long j5) {
        Bundle bundle;
        synchronized (this.zza) {
            if (!this.zzb) {
                try {
                    this.zza.wait(j5);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = this.zza.get();
        }
        return bundle;
    }

    public final Long zzb(long j5) {
        return (Long) zza(zza(j5), Long.class);
    }

    public final String zzc(long j5) {
        return (String) zza(zza(j5), String.class);
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0003, code lost:
    
        r3 = r3.get("r");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> T zza(Bundle bundle, Class<T> cls) {
        Object obj;
        if (bundle == null || obj == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException e5) {
            Log.w("AM", String.format("Unexpected object type. Expected, Received: %s, %s", cls.getCanonicalName(), obj.getClass().getCanonicalName()), e5);
            throw e5;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdq
    public final void zza(Bundle bundle) {
        synchronized (this.zza) {
            try {
                try {
                    this.zza.set(bundle);
                    this.zzb = true;
                } finally {
                    this.zza.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
