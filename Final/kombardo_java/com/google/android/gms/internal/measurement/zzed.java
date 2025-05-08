package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class zzed {
    private static volatile zzed zzb;
    protected final Clock zza;
    private final String zzc;
    private final ExecutorService zzd;
    private final AppMeasurementSdk zze;
    private final List<Pair<com.google.android.gms.measurement.internal.zzjt, zzd>> zzf;
    private int zzg;
    private boolean zzh;
    private String zzi;
    private volatile zzdl zzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public abstract class zzb implements Runnable {
        final long zza;
        final long zzb;
        private final boolean zzc;

        /* JADX INFO: Access modifiers changed from: package-private */
        public zzb(zzed zzedVar) {
            this(true);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (zzed.this.zzh) {
                zzb();
                return;
            }
            try {
                zza();
            } catch (Exception e5) {
                zzed.this.zza(e5, false, this.zzc);
                zzb();
            }
        }

        abstract void zza();

        protected void zzb() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public zzb(boolean z5) {
            this.zza = zzed.this.zza.currentTimeMillis();
            this.zzb = zzed.this.zza.elapsedRealtime();
            this.zzc = z5;
        }
    }

    /* loaded from: classes.dex */
    class zzc implements Application.ActivityLifecycleCallbacks {
        zzc() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            zzed.this.zza((zzb) new zzfq(this, bundle, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            zzed.this.zza((zzb) new zzfv(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            zzed.this.zza((zzb) new zzfr(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            zzed.this.zza((zzb) new zzfs(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            zzdm zzdmVar = new zzdm();
            zzed.this.zza((zzb) new zzft(this, activity, zzdmVar));
            Bundle zza = zzdmVar.zza(50L);
            if (zza != null) {
                bundle.putAll(zza);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            zzed.this.zza((zzb) new zzfp(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            zzed.this.zza((zzb) new zzfu(this, activity));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class zzd extends zzdv {
        private final com.google.android.gms.measurement.internal.zzjt zza;

        zzd(com.google.android.gms.measurement.internal.zzjt zzjtVar) {
            this.zza = zzjtVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzdw
        public final int zza() {
            return System.identityHashCode(this.zza);
        }

        @Override // com.google.android.gms.internal.measurement.zzdw
        public final void zza(String str, String str2, Bundle bundle, long j5) {
            this.zza.onEvent(str, str2, bundle, j5);
        }
    }

    private zzed(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !zzc(str2, str3)) {
            this.zzc = "FA";
        } else {
            this.zzc = str;
        }
        this.zza = DefaultClock.getInstance();
        this.zzd = zzde.zza().zza(new zzep(this), 1);
        this.zze = new AppMeasurementSdk(this);
        this.zzf = new ArrayList();
        if (zzb(context) && !zzk()) {
            this.zzi = null;
            this.zzh = true;
            Log.w(this.zzc, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (zzc(str2, str3)) {
            this.zzi = str2;
        } else {
            this.zzi = "fa";
            if (str2 == null || str3 == null) {
                if ((str2 == null) ^ (str3 == null)) {
                    Log.w(this.zzc, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.zzc, "Deferring to Google Analytics for Firebase for event data collection. https://firebase.google.com/docs/analytics");
            }
        }
        zza((zzb) new zzeg(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.zzc, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new zzc());
        }
    }

    private final boolean zzk() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics", false, getClass().getClassLoader());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void zzd(String str) {
        zza((zzb) new zzej(this, str));
    }

    public final String zzf() {
        zzdm zzdmVar = new zzdm();
        zza((zzb) new zzey(this, zzdmVar));
        return zzdmVar.zzc(50L);
    }

    public final String zzg() {
        zzdm zzdmVar = new zzdm();
        zza((zzb) new zzez(this, zzdmVar));
        return zzdmVar.zzc(500L);
    }

    public final String zzh() {
        zzdm zzdmVar = new zzdm();
        zza((zzb) new zzfa(this, zzdmVar));
        return zzdmVar.zzc(500L);
    }

    public final String zzi() {
        zzdm zzdmVar = new zzdm();
        zza((zzb) new zzev(this, zzdmVar));
        return zzdmVar.zzc(500L);
    }

    public final AppMeasurementSdk zzb() {
        return this.zze;
    }

    public final void zzc(String str) {
        zza((zzb) new zzeu(this, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzc(String str, String str2) {
        return (str2 == null || str == null || zzk()) ? false : true;
    }

    public final void zzb(String str) {
        zza((zzb) new zzer(this, str));
    }

    public final void zzb(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, null);
    }

    public final void zzb(String str, String str2) {
        zza((String) null, str, (Object) str2, false);
    }

    private static boolean zzb(Context context) {
        return new com.google.android.gms.measurement.internal.zzhw(context, com.google.android.gms.measurement.internal.zzhw.zza(context)).zza("google_app_id") != null;
    }

    public final int zza(String str) {
        zzdm zzdmVar = new zzdm();
        zza((zzb) new zzfg(this, str, zzdmVar));
        Integer num = (Integer) zzdm.zza(zzdmVar.zza(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final long zza() {
        zzdm zzdmVar = new zzdm();
        zza((zzb) new zzex(this, zzdmVar));
        Long zzb2 = zzdmVar.zzb(500L);
        if (zzb2 == null) {
            long nextLong = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
            int i5 = this.zzg + 1;
            this.zzg = i5;
            return nextLong + i5;
        }
        return zzb2.longValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzdl zza(Context context, boolean z5) {
        try {
            return zzdo.asInterface(DynamiteModule.load(context, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.LoadingException e5) {
            zza((Exception) e5, true, false);
            return null;
        }
    }

    public static zzed zza(Context context) {
        return zza(context, (String) null, (String) null, (String) null, (Bundle) null);
    }

    public static zzed zza(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (zzb == null) {
            synchronized (zzed.class) {
                try {
                    if (zzb == null) {
                        zzb = new zzed(context, str, str2, str3, bundle);
                    }
                } finally {
                }
            }
        }
        return zzb;
    }

    public final List<Bundle> zza(String str, String str2) {
        zzdm zzdmVar = new zzdm();
        zza((zzb) new zzek(this, str, str2, zzdmVar));
        List<Bundle> list = (List) zzdm.zza(zzdmVar.zza(5000L), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final Map<String, Object> zza(String str, String str2, boolean z5) {
        zzdm zzdmVar = new zzdm();
        zza((zzb) new zzfc(this, str, str2, z5, zzdmVar));
        Bundle zza = zzdmVar.zza(5000L);
        if (zza != null && zza.size() != 0) {
            HashMap hashMap = new HashMap(zza.size());
            for (String str3 : zza.keySet()) {
                Object obj = zza.get(str3);
                if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                    hashMap.put(str3, obj);
                }
            }
            return hashMap;
        }
        return Collections.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(Exception exc, boolean z5, boolean z6) {
        this.zzh |= z5;
        if (z5) {
            Log.w(this.zzc, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z6) {
            zza(5, "Error with data collection. Data lost.", exc, (Object) null, (Object) null);
        }
        Log.w(this.zzc, "Error with data collection. Data lost.", exc);
    }

    public final void zza(String str, String str2, Bundle bundle) {
        zza((zzb) new zzeh(this, str, str2, bundle));
    }

    public final void zza(String str, Bundle bundle) {
        zza(null, str, bundle, false, true, null);
    }

    private final void zza(String str, String str2, Bundle bundle, boolean z5, boolean z6, Long l5) {
        zza((zzb) new zzfn(this, l5, str, str2, bundle, z5, z6));
    }

    public final void zza(int i5, String str, Object obj, Object obj2, Object obj3) {
        zza((zzb) new zzfe(this, false, 5, str, obj, null, null));
    }

    public final void zza(com.google.android.gms.measurement.internal.zzjt zzjtVar) {
        Preconditions.checkNotNull(zzjtVar);
        synchronized (this.zzf) {
            for (int i5 = 0; i5 < this.zzf.size(); i5++) {
                try {
                    if (zzjtVar.equals(this.zzf.get(i5).first)) {
                        Log.w(this.zzc, "OnEventListener already registered.");
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            zzd zzdVar = new zzd(zzjtVar);
            this.zzf.add(new Pair<>(zzjtVar, zzdVar));
            if (this.zzj != null) {
                try {
                    this.zzj.registerOnMeasurementEventListener(zzdVar);
                    return;
                } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                    Log.w(this.zzc, "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
                }
            }
            zza((zzb) new zzfl(this, zzdVar));
        }
    }

    public final void zza(Runnable runnable) {
        zza((zzb) new zzet(this, runnable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzb zzbVar) {
        this.zzd.execute(zzbVar);
    }

    public final void zza(Bundle bundle) {
        zza((zzb) new zzei(this, bundle));
    }

    public final void zza(Activity activity, String str, String str2) {
        zza((zzb) new zzem(this, zzeb.zza(activity), str, str2));
    }

    public final void zza(String str, String str2, Object obj, boolean z5) {
        zza((zzb) new zzef(this, str, str2, obj, z5));
    }
}
