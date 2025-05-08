package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzig implements zzhl {
    private static final Map<String, zzig> zza = new ArrayMap();
    private final SharedPreferences zzb;
    private final Runnable zzc;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzd;
    private final Object zze;
    private volatile Map<String, ?> zzf;
    private final List<Object> zzg;

    private zzig(SharedPreferences sharedPreferences, Runnable runnable) {
        SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.internal.measurement.zzij
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String str) {
                zzig.zza(zzig.this, sharedPreferences2, str);
            }
        };
        this.zzd = onSharedPreferenceChangeListener;
        this.zze = new Object();
        this.zzg = new ArrayList();
        this.zzb = sharedPreferences;
        this.zzc = runnable;
        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    private static SharedPreferences zza(Context context, String str) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (str.startsWith("direct_boot:")) {
                if (zzhg.zza()) {
                    context = context.createDeviceProtectedStorageContext();
                }
                SharedPreferences zza2 = zzcw.zza(context, str.substring(12), 0, zzcs.zza);
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return zza2;
            }
            SharedPreferences zza3 = zzcw.zza(context, str, 0, zzcs.zza);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return zza3;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzig zza(Context context, String str, Runnable runnable) {
        zzig zzigVar;
        if (!((!zzhg.zza() || str.startsWith("direct_boot:")) ? true : zzhg.zzb(context))) {
            return null;
        }
        synchronized (zzig.class) {
            try {
                Map<String, zzig> map = zza;
                zzigVar = map.get(str);
                if (zzigVar == null) {
                    zzigVar = new zzig(zza(context, str), runnable);
                    map.put(str, zzigVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzigVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzhl
    public final Object zza(String str) {
        Map<String, ?> map = this.zzf;
        if (map == null) {
            synchronized (this.zze) {
                try {
                    map = this.zzf;
                    if (map == null) {
                        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        try {
                            Map<String, ?> all = this.zzb.getAll();
                            this.zzf = all;
                            StrictMode.setThreadPolicy(allowThreadDiskReads);
                            map = all;
                        } catch (Throwable th) {
                            StrictMode.setThreadPolicy(allowThreadDiskReads);
                            throw th;
                        }
                    }
                } finally {
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public static /* synthetic */ void zza(zzig zzigVar, SharedPreferences sharedPreferences, String str) {
        synchronized (zzigVar.zze) {
            zzigVar.zzf = null;
            zzigVar.zzc.run();
        }
        synchronized (zzigVar) {
            try {
                Iterator<Object> it = zzigVar.zzg.iterator();
                if (it.hasNext()) {
                    android.support.v4.media.session.a.a(it.next());
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void zza() {
        synchronized (zzig.class) {
            try {
                for (zzig zzigVar : zza.values()) {
                    zzigVar.zzb.unregisterOnSharedPreferenceChangeListener(zzigVar.zzd);
                }
                zza.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
